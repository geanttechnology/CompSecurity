// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.gms.analytics.Tracker;
import com.livemixtapes.library.JSONParser;
import com.livemixtapes.ui.BaseActivity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

// Referenced classes of package com.livemixtapes:
//            console, App, JsonToMap, User

public class CommentsActivity extends BaseActivity
{
    public class CommentsListAdapter extends BaseAdapter
    {

        private Activity activity;
        private List comments;
        private LayoutInflater inflater;
        final CommentsActivity this$0;

        public int getCount()
        {
            return comments.size();
        }

        public Object getItem(int i)
        {
            return comments.get(i);
        }

        public long getItemId(int i)
        {
            return (long)i;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            Object obj;
            Object obj1;
            if (inflater == null)
            {
                inflater = (LayoutInflater)activity.getSystemService("layout_inflater");
            }
            viewgroup = view;
            if (view == null)
            {
                viewgroup = inflater.inflate(0x7f03001d, null);
            }
            obj1 = (TextView)viewgroup.findViewById(0x7f080074);
            TextView textview = (TextView)viewgroup.findViewById(0x7f080063);
            view = (TextView)viewgroup.findViewById(0x7f080075);
            obj = (HashMap)comments.get(i);
            ((TextView) (obj1)).setText((CharSequence)((HashMap) (obj)).get("username"));
            textview.setText((CharSequence)((HashMap) (obj)).get("comment"));
            obj1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            ((SimpleDateFormat) (obj1)).setTimeZone(TimeZone.getTimeZone("UTC"));
            obj = ((SimpleDateFormat) (obj1)).parse((String)((HashMap) (obj)).get("timestamp"));
            obj1 = new SimpleDateFormat("dd MMM yyyy hh:mm:ss a");
            ((SimpleDateFormat) (obj1)).setTimeZone(TimeZone.getDefault());
            view.setText(((SimpleDateFormat) (obj1)).format(((java.util.Date) (obj))));
            return viewgroup;
            view;
_L2:
            view.printStackTrace();
            return viewgroup;
            view;
            if (true) goto _L2; else goto _L1
_L1:
        }

        public CommentsListAdapter(Activity activity1, List list)
        {
            this$0 = CommentsActivity.this;
            super();
            activity = activity1;
            comments = list;
        }
    }

    private class JSONParse extends AsyncTask
    {

        final CommentsActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient JSONObject doInBackground(String as[])
        {
            JSONParser jsonparser = new JSONParser();
            String s1 = (new StringBuilder(String.valueOf(CommentsActivity.url))).append(mixtapeId).toString();
            String s = s1;
            if (as[0].length() > 0)
            {
                s = (new StringBuilder(String.valueOf(s1))).append("&before=").append(as[0]).toString();
            }
            return jsonparser.getJSONFromUrl(s, CommentsActivity.this);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((JSONObject)obj);
        }

        protected void onPostExecute(JSONObject jsonobject)
        {
            hideProgressBar();
            flag_loading = false;
            jsonobject = (ArrayList)JsonToMap.convert(jsonobject).get("comments");
            commentsList.addAll(jsonobject);
            if (jsonobject.size() > 0)
            {
                HashMap hashmap = (HashMap)commentsList.get(commentsList.size() - 1);
                lastSavedCommentTimestamp = (String)hashmap.get("timestamp");
            }
            if (jsonobject.size() <= 2)
            {
                stop_loading = true;
            }
            adapter.notifyDataSetChanged();
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            flag_loading = true;
            showProgressBar("Loading...");
        }

        private JSONParse()
        {
            this$0 = CommentsActivity.this;
            super();
        }

        JSONParse(JSONParse jsonparse)
        {
            this();
        }
    }

    private class PostComment extends AsyncTask
    {

        final CommentsActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient JSONObject doInBackground(String as[])
        {
            JSONParser jsonparser = new JSONParser();
            ArrayList arraylist = new ArrayList();
            arraylist.add(new BasicNameValuePair("album_id", mixtapeId));
            arraylist.add(new BasicNameValuePair("comment_text", as[0]));
            arraylist.add(new BasicNameValuePair("auth", User.getAuth()));
            return jsonparser.postData("https://api.livemixtapes.com/api/comments/add", arraylist);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((JSONObject)obj);
        }

        protected void onPostExecute(JSONObject jsonobject)
        {
            hideProgressBar();
            if (jsonobject != null)
            {
                commentsEditText.setText("");
                commentsList.clear();
                jsonobject = (ArrayList)JsonToMap.convert(jsonobject).get("comments");
                commentsList.addAll(jsonobject);
                if (jsonobject.size() > 0)
                {
                    HashMap hashmap = (HashMap)commentsList.get(commentsList.size() - 1);
                    lastSavedCommentTimestamp = (String)hashmap.get("timestamp");
                }
                if (jsonobject.size() <= 2)
                {
                    stop_loading = true;
                }
                adapter.notifyDataSetChanged();
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            flag_loading = true;
            showProgressBar("Posting...");
        }

        private PostComment()
        {
            this$0 = CommentsActivity.this;
            super();
        }

        PostComment(PostComment postcomment)
        {
            this();
        }
    }


    private static String url = "https://api.livemixtapes.com/api/comments/list?id=";
    CommentsListAdapter adapter;
    EditText commentsEditText;
    ArrayList commentsList;
    boolean flag_loading;
    String lastSavedCommentTimestamp;
    LinearLayout layoutBack;
    ListView listView;
    String mixtapeId;
    Button sendButton;
    boolean stop_loading;

    public CommentsActivity()
    {
        commentsList = new ArrayList();
        flag_loading = false;
        stop_loading = false;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle, 0x7f03001c);
        mixtapeId = getIntent().getStringExtra("mixTapeId");
        listView = (ListView)findViewById(0x7f080070);
        layoutBack = (LinearLayout)findViewById(0x7f08006d);
        commentsEditText = (EditText)findViewById(0x7f080072);
        getWindow().setSoftInputMode(2);
        sendButton = (Button)findViewById(0x7f080073);
        sendButton.setVisibility(8);
        adapter = new CommentsListAdapter(this, commentsList);
        listView.setAdapter(adapter);
        lastSavedCommentTimestamp = "";
        layoutBack.setOnClickListener(new android.view.View.OnClickListener() {

            final CommentsActivity this$0;

            public void onClick(View view)
            {
                onBackPressed();
            }

            
            {
                this$0 = CommentsActivity.this;
                super();
            }
        });
        commentsEditText.addTextChangedListener(new TextWatcher() {

            final CommentsActivity this$0;

            public void afterTextChanged(Editable editable)
            {
                if (editable.length() == 0)
                {
                    sendButton.setVisibility(8);
                    return;
                } else
                {
                    sendButton.setVisibility(0);
                    return;
                }
            }

            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            
            {
                this$0 = CommentsActivity.this;
                super();
            }
        });
        sendButton.setOnClickListener(new android.view.View.OnClickListener() {

            final CommentsActivity this$0;

            public void onClick(View view)
            {
                view = commentsEditText.getText().toString();
                if (view.length() == 0)
                {
                    return;
                }
                if (User.getAuth().length() == 0)
                {
                    (new android.app.AlertDialog.Builder(CommentsActivity.this)).setTitle("Login").setMessage("Please login to post a comment").setPositiveButton("OK", new android.content.DialogInterface.OnClickListener() {

                        final _cls3 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls3.this;
                super();
            }
                    }).setIcon(0x1080027).show();
                    return;
                } else
                {
                    (new PostComment(null)).execute(new String[] {
                        view
                    });
                    return;
                }
            }

            
            {
                this$0 = CommentsActivity.this;
                super();
            }
        });
        listView.setOnScrollListener(new android.widget.AbsListView.OnScrollListener() {

            final CommentsActivity this$0;

            public void onScroll(AbsListView abslistview, int i, int j, int k)
            {
                while (stop_loading || i + j != k || k == 0 || flag_loading) 
                {
                    return;
                }
                flag_loading = true;
                (new JSONParse(null)).execute(new String[] {
                    lastSavedCommentTimestamp
                });
            }

            public void onScrollStateChanged(AbsListView abslistview, int i)
            {
            }

            
            {
                this$0 = CommentsActivity.this;
                super();
            }
        });
        (new JSONParse(null)).execute(new String[] {
            ""
        });
    }

    public volatile View onCreateView(View view, String s, Context context, AttributeSet attributeset)
    {
        return super.onCreateView(view, s, context, attributeset);
    }

    public volatile View onCreateView(String s, Context context, AttributeSet attributeset)
    {
        return super.onCreateView(s, context, attributeset);
    }

    public void onResume()
    {
        super.onResume();
        console.log(new Object[] {
            "LOGGING COMMENTS ACTIVITY"
        });
        App app = (App)getApplication();
        app.getDefaultTracker().setScreenName("Image~CommentsActivity");
        app.getDefaultTracker().send((new com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder()).build());
    }


}
