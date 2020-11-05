package com.example.dreams.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dreams.R;
import com.example.dreams.models.Note;

import java.util.ArrayList;

public class NotesRecyclerViewAdapter extends RecyclerView.Adapter<NotesRecyclerViewAdapter.ViewHolder>{
    private ArrayList<Note> mNotes = new ArrayList<>();
    private OnNoteListener mOnNoteListener;

    public NotesRecyclerViewAdapter(ArrayList<Note> mNotes, OnNoteListener onNoteListener){
        this.mNotes = mNotes;
        this.mOnNoteListener = onNoteListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_list_item,null);

        return new ViewHolder(view, mOnNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.timestamp.setText(mNotes.get(i).getTimestamp());
        viewHolder.title.setText(mNotes.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return mNotes.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView title;
        private TextView timestamp;
        OnNoteListener onNoteListener;

        public ViewHolder(@NonNull View itemView, OnNoteListener onNoteListener){
            super(itemView);
            title = itemView.findViewById(R.id.note_title);
            timestamp = itemView.findViewById(R.id.note_time);
            this.onNoteListener = onNoteListener;

            itemView.setOnClickListener(this);

        }

        public void onClick(View v){
            onNoteListener.onNoteClick(getAdapterPosition());
        }
    }
        public interface OnNoteListener {
            void onNoteClick(int position);
        }
}
