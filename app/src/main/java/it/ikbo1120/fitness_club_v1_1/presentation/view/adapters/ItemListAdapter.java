package it.ikbo1120.fitness_club_v1_1.presentation.view.adapters;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import it.ikbo1120.fitness_club_v1_1.MainActivity;
import it.ikbo1120.fitness_club_v1_1.R;
import it.ikbo1120.fitness_club_v1_1.ServiceLocator;
import it.ikbo1120.fitness_club_v1_1.databinding.ServicesItemBinding;
import it.ikbo1120.fitness_club_v1_1.domain.model.Services;
import it.ikbo1120.fitness_club_v1_1.domain.repository.mock.MockBase;

import java.util.List;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ItemViewHolder> {

    private List<Services> data;
    private MainActivity mainActivity;

    final int DIALOG_EXIT = 1;
    public ItemListAdapter(List<Services> data, MainActivity mActivity) {
        this.data = data;
        this.mainActivity = mActivity;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ServicesItemBinding binding = ServicesItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Picasso.with(mainActivity)
                .load(data.get(position).getUrl())
                .into(holder.binding.cardImageView);
        holder.binding.itemCard.setOnClickListener(v -> {
            System.out.println(position);

        });
        if(data.get(position).getName_services() != null){
            holder.binding.itemName.setText(data.get(position).getName_services());
        }
        if(data.get(position).getPrice_services() != null){
            holder.binding.itemPrice.setText(data.get(position).getPrice_services().toString());
        }
        holder.binding.itemCard.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ServiceLocator.getInstance().getRepository(mainActivity.getApplication()).deleteService(data.get(position));
                return true;
            }
        });
    }

    public void onCreateDialog(int id) {

    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public List<Services> getData() {
        return data;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{
        ServicesItemBinding binding;
        public ItemViewHolder(ServicesItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }
}
