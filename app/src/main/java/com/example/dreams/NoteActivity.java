package com.example.dreams;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dreams.models.Note;

public class NoteActivity extends AppCompatActivity implements View.OnTouchListener, GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    private static final String TAG = "NoteActivity";

    private TextView txtNoteTitle;
    private TextView txtNoteTimestamp;
    private EditText txtNoteContent;


    private boolean mIsNewNote;
    private Note mInitialNote;
    private  GestureDetector  gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

         txtNoteTitle = findViewById(R.id.txtNoteTitle);
         txtNoteTimestamp = findViewById(R.id.textNoteTimestamp);
         txtNoteContent = findViewById(R.id.textNoteContent);

         if (getIncomingIntent()){
            setNewNoteProperties();
         }else{
             setNoteProperties();
         }

    }
    public boolean getIncomingIntent(){
        if (getIntent().hasExtra("selected_note")){
            mInitialNote = getIntent().getParcelableExtra("selected_note");
            mIsNewNote =false;
            return  false;
        }
        mIsNewNote = true;
        return true;
    }

    public void setListener(){
        txtNoteContent.setOnTouchListener(this);
        gestureDetector = new GestureDetector(this, this);

    }

    private void setNoteProperties(){
        txtNoteTitle.setText(mInitialNote.getTitle());
        txtNoteTimestamp.setText(mInitialNote.getTimestamp());
        txtNoteContent.setText(mInitialNote.getContent());
    }

    private void setNewNoteProperties(){
        txtNoteTitle.setText("Note title");
        txtNoteTimestamp.setText("Note timestamp");
        txtNoteContent.setText("Note content");
    }



    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }
}