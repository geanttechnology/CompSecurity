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
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

// Referenced classes of package com.livemixtapes.profile:
//            SelectedPlayList

class isReorderOrDelete extends AsyncTask
{

    int isReorderOrDelete;
    ProgressDialog pd;
    final SelectedPlayList this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected transient JSONObject doInBackground(String as[])
    {
        JSONParser jsonparser = new JSONParser();
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("id", SelectedPlayList.map.get("playlist_id").toString()));
        if (isReorderOrDelete == 1)
        {
            arraylist.add(new BasicNameValuePair("tracks", as[0]));
            return jsonparser.postData((new StringBuilder("https://api.livemixtapes.com/api/playlist/reorder?auth=")).append(User.getAuth()).toString(), arraylist);
        }
        if (isReorderOrDelete == 2)
        {
            arraylist.add(new BasicNameValuePair("track", as[0]));
            return jsonparser.postData((new StringBuilder("https://api.livemixtapes.com/api/playlist/deletetrack?auth=")).append(User.getAuth()).toString(), arraylist);
        } else
        {
            arraylist.add(new BasicNameValuePair("name", as[0]));
            return jsonparser.postData((new StringBuilder("https://api.livemixtapes.com/api/playlist/rename?auth=")).append(User.getAuth()).toString(), arraylist);
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((JSONObject)obj);
    }

    protected void onPostExecute(JSONObject jsonobject)
    {
        super.onPostExecute(jsonobject);
        if (isReorderOrDelete != 3)
        {
            pd.dismiss();
        }
        if (jsonobject == null) goto _L2; else goto _L1
_L1:
        if (isReorderOrDelete == 3) goto _L4; else goto _L3
_L3:
        int i;
        jsonobject = JsonToMap.convert(jsonobject);
        i = 0;
_L6:
        if (i < User.getData().isReorderOrDelete.size()) goto _L5; else goto _L2
_L2:
        return;
_L5:
        if (((Map)User.getData().isReorderOrDelete.get(i)).get("playlist_id").toString().equals(jsonobject.get("playlist_id").toString()))
        {
            User.getData().isReorderOrDelete.set(i, jsonobject);
        }
        i++;
        if (true) goto _L6; else goto _L4
_L4:
        jsonobject = JsonToMap.convert(jsonobject);
        User.getData().isReorderOrDelete = (ArrayList)jsonobject.get("playlists");
        return;
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        pd = new ProgressDialog(mContext);
        pd.setMessage("Loading..");
        if (isReorderOrDelete != 3)
        {
            pd.show();
        }
    }

    public (int i)
    {
        this$0 = SelectedPlayList.this;
        super();
        isReorderOrDelete = i;
    }
}
