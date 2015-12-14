// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes.profile;

import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import com.livemixtapes.JsonToMap;
import com.livemixtapes.Mixtape;
import com.livemixtapes.User;
import com.livemixtapes.library.JSONParser;
import com.livemixtapes.ui.BaseActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

// Referenced classes of package com.livemixtapes.profile:
//            SeeAllList

class isNewOrOld extends AsyncTask
{

    int isNewOrOld;
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
        arraylist.add(new BasicNameValuePair("id", as[1]));
        arraylist.add(new BasicNameValuePair("tracks", as[2]));
        return jsonparser.postData((new StringBuilder("https://api.livemixtapes.com/api/")).append(as[0]).append("?auth=").append(User.getAuth()).toString(), arraylist);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((JSONObject)obj);
    }

    protected void onPostExecute(JSONObject jsonobject)
    {
        super.onPostExecute(jsonobject);
        pd.dismiss();
        if (jsonobject == null) goto _L2; else goto _L1
_L1:
        int i;
        boolean flag;
        Mixtape.shouldClearPlayListMode = true;
        jsonobject = JsonToMap.convert(jsonobject);
        flag = false;
        i = 0;
_L8:
        if (i < User.getData().stMode.size()) goto _L4; else goto _L3
_L3:
        i = ((flag) ? 1 : 0);
_L6:
        if (i == 0)
        {
            User.getData().stMode.add(jsonobject);
        }
        ((BaseActivity)getActivity()).getAnimatedFragmentTransaction().remove(SeeAllList.this).commit();
_L2:
        return;
_L4:
        if (!((Map)User.getData()._fld0.get(i)).get("playlist_id").toString().equals(jsonobject.get("playlist_id").toString()))
        {
            break; /* Loop/switch isn't completed */
        }
        User.getData()._fld0.set(i, jsonobject);
        i = 1;
        if (true) goto _L6; else goto _L5
_L5:
        i++;
        if (true) goto _L8; else goto _L7
_L7:
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        pd = new ProgressDialog(mContext);
        pd.setMessage("Loading..");
        pd.show();
    }

    public (int i)
    {
        this$0 = SeeAllList.this;
        super();
        isNewOrOld = i;
    }
}
