// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2;

import android.os.AsyncTask;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.geo.mapsv2:
//            CoverageGapInitializer

private class <init> extends AsyncTask
{

    final CoverageGapInitializer this$0;

    public volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    public transient Collection doInBackground(String as[])
    {
        if (as != null && as.length >= 1) goto _L2; else goto _L1
_L1:
        as = null;
_L4:
        return as;
_L2:
        as = as[0];
        ArrayList arraylist;
        JSONArray jsonarray;
        int i;
        try
        {
            jsonarray = (new JSONObject(as)).getJSONArray("replacers");
            arraylist = new ArrayList(jsonarray.length());
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            Log.e("Maps-CoverageGapRemoteConfig", "Manifest file has an invalid format", as);
            return null;
        }
        i = 0;
        as = arraylist;
        if (i >= jsonarray.length()) goto _L4; else goto _L3
_L3:
        CoverageGapInitializer.access$100(jsonarray.getJSONObject(i), arraylist);
        i++;
        break MISSING_BLOCK_LABEL_47;
    }

    protected void onCancelled()
    {
        CoverageGapInitializer.access$502(CoverageGapInitializer.this, null);
    }

    public volatile void onPostExecute(Object obj)
    {
        onPostExecute((Collection)obj);
    }

    public void onPostExecute(Collection collection)
    {
        if (collection != null)
        {
            CoverageGapInitializer.access$202(CoverageGapInitializer.this, collection);
            CoverageGapInitializer.access$300(CoverageGapInitializer.this);
        }
        CoverageGapInitializer.access$402(CoverageGapInitializer.this, null);
    }

    private ()
    {
        this$0 = CoverageGapInitializer.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
