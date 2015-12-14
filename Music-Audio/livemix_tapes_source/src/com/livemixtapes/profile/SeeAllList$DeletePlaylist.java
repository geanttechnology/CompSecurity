// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes.profile;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import com.livemixtapes.JsonToMap;
import com.livemixtapes.User;
import com.livemixtapes.library.JSONParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

// Referenced classes of package com.livemixtapes.profile:
//            SeeAllList

class this._cls0 extends AsyncTask
{

    ProgressDialog pd;
    final SeeAllList this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected transient JSONObject doInBackground(String as[])
    {
        JSONParser jsonparser = new JSONParser();
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("id", as[0]));
        return jsonparser.postData((new StringBuilder("https://api.livemixtapes.com/api/playlist/delete?auth=")).append(User.getAuth()).toString(), arraylist);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((JSONObject)obj);
    }

    protected void onPostExecute(JSONObject jsonobject)
    {
        super.onPostExecute(jsonobject);
        pd.dismiss();
        if (jsonobject != null)
        {
            jsonobject = (ArrayList)JsonToMap.convert(jsonobject).get("playlists");
            User.getData().pd.clear();
            User.getData().pd.addAll(jsonobject);
            playList.clear();
            playList.addAll(User.getData().t);
            adapter.notifyDataSetChanged();
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        pd = new ProgressDialog(mContext);
        pd.setMessage("Loading..");
        pd.show();
    }

    ()
    {
        this$0 = SeeAllList.this;
        super();
    }
}
