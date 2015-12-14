// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.os.AsyncTask;
import android.widget.EditText;
import com.livemixtapes.library.JSONParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

// Referenced classes of package com.livemixtapes:
//            CommentsActivity, User, JsonToMap

private class <init> extends AsyncTask
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

    private Adapter()
    {
        this$0 = CommentsActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
