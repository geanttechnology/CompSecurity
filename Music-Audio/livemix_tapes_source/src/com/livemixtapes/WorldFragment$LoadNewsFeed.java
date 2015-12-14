// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.os.AsyncTask;
import com.livemixtapes.library.JSONParser;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONObject;

// Referenced classes of package com.livemixtapes:
//            WorldFragment, WorldActivity, JsonToMap

private class <init> extends AsyncTask
{

    final WorldFragment this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected transient JSONObject doInBackground(String as[])
    {
        return (new JSONParser()).getJSONFromUrl(WorldFragment.url, activity);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((JSONObject)obj);
    }

    protected void onPostExecute(JSONObject jsonobject)
    {
        activity.hideProgressBar();
        if (jsonobject == null)
        {
            return;
        } else
        {
            newsList.addAll((ArrayList)JsonToMap.convert(jsonobject).get("news"));
            Collections.sort(newsList, new Comparator() {

                final WorldFragment.LoadNewsFeed this$1;

                public volatile int compare(Object obj, Object obj1)
                {
                    return compare((HashMap)obj, (HashMap)obj1);
                }

                public int compare(HashMap hashmap, HashMap hashmap1)
                {
                    hashmap = convertUtcToDate((String)hashmap.get("timestamp"));
                    hashmap1 = convertUtcToDate((String)hashmap1.get("timestamp"));
                    if (hashmap == null || hashmap1 == null)
                    {
                        return 0;
                    } else
                    {
                        return hashmap1.compareTo(hashmap);
                    }
                }

            
            {
                this$1 = WorldFragment.LoadNewsFeed.this;
                super();
            }
            });
            adapter.notifyDataSetChanged();
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        activity.showProgressBar("Loading...");
    }


    private _cls1.this._cls1()
    {
        this$0 = WorldFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
