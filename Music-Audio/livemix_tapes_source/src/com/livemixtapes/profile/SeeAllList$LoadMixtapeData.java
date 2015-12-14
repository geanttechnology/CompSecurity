// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes.profile;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import com.livemixtapes.JsonToMap;
import com.livemixtapes.library.JSONParser;
import java.util.HashMap;
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
        return (new JSONParser()).getJSONFromUrl((new StringBuilder("https://api.livemixtapes.com/api/mixtape/")).append(as[0]).toString(), getActivity());
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
            showMixtapeFragment(mContext, (HashMap)JsonToMap.convert(jsonobject).get("mixtape"));
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        pd = new ProgressDialog(mContext);
        pd.setMessage("Loading..");
        pd.show();
    }

    _cls9()
    {
        this$0 = SeeAllList.this;
        super();
    }
}
