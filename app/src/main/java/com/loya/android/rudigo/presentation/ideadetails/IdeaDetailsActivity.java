package com.loya.android.rudigo.presentation.ideadetails;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.loya.android.rudigo.R;
import com.loya.android.rudigo.data.model.Comment;
import com.loya.android.rudigo.data.model.Idea;
import com.loya.android.rudigo.data.model.Rating;
import com.loya.android.rudigo.presentation.ideadetails.adapter.CommentAdapter;
import com.loya.android.rudigo.presentation.ideadetails.adapter.CommentDelegateAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class IdeaDetailsActivity extends AppCompatActivity implements View.OnClickListener, CommentDelegateAdapter.onViewSelectedListener {
    private FloatingActionButton send;
    private EditText comment;
    private TextView userText, userIdea, effect, rationale;
    private RecyclerView recyclerView;
    private Idea idea;
    private CommentAdapter commentAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        findViewsById();

        idea = getIntent().getParcelableExtra("idea");
        updateTextFields();

        initialiseRecyclerView();
        send.setOnClickListener(this);


    }

    private void findViewsById() {
        send = (FloatingActionButton) findViewById(R.id.fab_comment);
        comment = (EditText) findViewById(R.id.commentText);
        recyclerView = (RecyclerView) findViewById(R.id.listView);
        userText = (TextView) findViewById(R.id.userTextView);
        userIdea = (TextView) findViewById(R.id.ideaTextView);
        effect = (TextView) findViewById(R.id.effectTextView);
        rationale = (TextView) findViewById(R.id.rationaleTextView);
    }

    private void initialiseRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        commentAdapter = new CommentAdapter(this);
        recyclerView.setAdapter(commentAdapter);
    }

    private void updateTextFields() {
        userText.setText(idea.getUsername());
        userIdea.setText(idea.getIdea());
        effect.setText(idea.getEffect());
        rationale.setText(idea.getRationale());
    }

    //gets the current time
    private String getCurrentTime() {
        // TODO: 29/07/2017 change time to Long
        Date now = new Date(); // Instance of the Date class
        long curTime = now.getTime(); // Convert a Date to a long value
        //convert the time in milliseconds into a Date object by calling the Date constructor.
        Date dateObject = new Date(curTime);
        //Then we can initialize a SimpleDateFormat instance
        // and configure it to provide a more readable representation according to the given format.
        SimpleDateFormat dateFormatter = new SimpleDateFormat("HH:mm a");
        String currentTime = dateFormatter.format(dateObject);
        return currentTime;
    }

    @Override
    public void onClick(View v) {
        String commentText = comment.getText().toString();
        if (!validateText(commentText)) return;
        String currentTime = getCurrentTime();
        Rating rating = new Rating();
        Comment comment = new Comment(0, commentText, currentTime, rating);
        commentAdapter.addComment(comment);
    }


    private boolean validateText(String comment) {
        boolean state = true;
        if (TextUtils.isEmpty(comment)) {
            Toast.makeText(this, "Input field is empty", Toast.LENGTH_SHORT).show();
            state = false;
        }
        return state;
    }

    private void clearTextField() {
        comment.setText("");
    }

    @Override
    public void onDownVoteClicked(long commentId, boolean action) {
        if (action) {
            //downvote
        }
    }

    @Override
    public void onUpVoteClicked(long commentId, boolean action) {
        if (action) {
            //upvote
        }
    }

    @Override
    public void onFavoriteClicked(long commentId, boolean action) {
        if (action) {
            //favorite
        }
    }
}
