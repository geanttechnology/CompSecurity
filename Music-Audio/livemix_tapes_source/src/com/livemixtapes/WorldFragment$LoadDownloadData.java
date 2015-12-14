// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import com.livemixtapes.library.JSONParser;
import java.util.HashMap;
import org.json.JSONObject;

// Referenced classes of package com.livemixtapes:
//            WorldFragment, JsonToMap, WorldActivity, Mixtape

class this._cls0 extends AsyncTask
{

    ProgressDialog pd;
    final WorldFragment this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected transient JSONObject doInBackground(String as[])
    {
        return (new JSONParser()).getJSONFromUrl((new StringBuilder("https://api.livemixtapes.com/api/mixtape/")).append(as[0]).toString(), activity);
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
            jsonobject = (HashMap)JsonToMap.convert(jsonobject).get("mixtape");
            FragmentTransaction fragmenttransaction = activity.getAnimatedFragmentTransaction();
            Mixtape mixtape = new Mixtape();
            Bundle bundle = new Bundle();
            bundle.putSerializable("mixtapeData", jsonobject);
            bundle.putString("backScreenTitle", "News");
            mixtape.setArguments(bundle);
            fragmenttransaction.replace(0x7f0800cc, mixtape, "MIXTAPE").addToBackStack(null);
            fragmenttransaction.commit();
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        pd = new ProgressDialog(activity);
        pd.setMessage("Loading..");
        pd.show();
    }

    ()
    {
        this$0 = WorldFragment.this;
        super();
    }
}
