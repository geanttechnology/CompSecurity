// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.livemixtapes.adapter.ViewPagerCustomDuration;
import com.livemixtapes.database.DBHelper;
import com.livemixtapes.library.JSONParser;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

// Referenced classes of package com.livemixtapes:
//            Mixtapes, JsonToMap, MixtapesActivity, PullToRefreshListView, 
//            Utils, LazyAdapterMixtapes

private class <init> extends AsyncTask
{

    ProgressDialog pd;
    final Mixtapes this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected transient JSONObject doInBackground(String as[])
    {
        as = new JSONParser();
        long l = System.currentTimeMillis() / 1000L;
        if (Mixtapes.access$1(Mixtapes.this).equals("all_mixtapes"))
        {
            Mixtapes.access$3((new StringBuilder("https://api.livemixtapes.com/api/mixtape/all?page=")).append(Mixtapes.access$2(Mixtapes.this)).toString());
        } else
        if (Mixtapes.access$1(Mixtapes.this).equals("week_mixtapes"))
        {
            Mixtapes.access$3((new StringBuilder("https://api.livemixtapes.com/api/mixtape/thisweek?page=")).append(Mixtapes.access$2(Mixtapes.this)).toString());
        } else
        if (Mixtapes.access$1(Mixtapes.this).equals("day_mixtapes"))
        {
            Mixtapes.access$3((new StringBuilder("https://api.livemixtapes.com/api/mixtape/today?page=")).append(Mixtapes.access$2(Mixtapes.this)).toString());
        } else
        if (Mixtapes.access$1(Mixtapes.this).equals("unreleased_mixtapes"))
        {
            Mixtapes.access$3((new StringBuilder("https://api.livemixtapes.com/api/mixtape/unreleased?page=")).append(Mixtapes.access$2(Mixtapes.this)).toString());
        }
        as = as.getJSONFromUrl(Mixtapes.access$4(), activity);
        if (as != null)
        {
            try
            {
                updateJSONDatatoSQlite((ArrayList)JsonToMap.convert(as).get("mixtapes"), JsonToMap.convert(as).get("screen").toString());
            }
            catch (Exception exception)
            {
                return as;
            }
        }
        return as;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((JSONObject)obj);
    }

    protected void onPostExecute(JSONObject jsonobject)
    {
        activity.hideProgressBar();
        if (listView.isRefreshing())
        {
            listView.onRefreshComplete();
        }
        Mixtapes.access$0(Mixtapes.this, Boolean.valueOf(false));
        footerView.setVisibility(8);
        if (jsonobject != null)
        {
            Object obj = JsonToMap.convert(jsonobject);
            String s = ((HashMap) (obj)).get("total_mixtape_count").toString();
            Mixtapes.access$5(Mixtapes.this, Integer.parseInt(((HashMap) (obj)).get("page").toString()));
            mixtapeCount.setText((new StringBuilder(String.valueOf(Utils.formatWithCommas(s)))).append(" Total Mixtapes").toString());
            activity.dbHelper = DBHelper.sharedInstance(activity);
            if (Mixtapes.access$2(Mixtapes.this) == 0)
            {
                mixtapelist.clear();
            }
            mixtapelist.addAll((ArrayList)JsonToMap.convert(jsonobject).get("mixtapes"));
            obj = Mixtapes.this;
            Mixtapes.access$5(((Mixtapes) (obj)), Mixtapes.access$2(((Mixtapes) (obj))) + 1);
            jsonobject = (ArrayList)JsonToMap.convert(jsonobject).get("top_mixtapes");
            if (Mixtapes.access$2(Mixtapes.this) == 1 && jsonobject.size() > 0)
            {
                viewPager.setVisibility(0);
                dotsLayout.setVisibility(0);
                Mixtapes.access$6(Mixtapes.this, jsonobject);
            }
            adapter.notifyDataSetChanged();
            jsonobject = Integer.toString(mixtapelist.size());
            if (Mixtapes.access$1(Mixtapes.this).equals("week_mixtapes"))
            {
                weekSwitch.setText((new StringBuilder(String.valueOf(jsonobject))).append(" This Week").toString());
                return;
            }
            if (Mixtapes.access$1(Mixtapes.this).equals("day_mixtapes"))
            {
                todaySwitch.setText((new StringBuilder(String.valueOf(jsonobject))).append(" Today").toString());
                return;
            }
            if (Mixtapes.access$1(Mixtapes.this).equals("unreleased_mixtapes"))
            {
                unreleasedSwitch.setText((new StringBuilder(String.valueOf(jsonobject))).append(" Unreleased").toString());
                return;
            }
        }
    }

    protected void onPreExecute()
    {
        Mixtapes.access$0(Mixtapes.this, Boolean.valueOf(true));
        super.onPreExecute();
        if (mixtapelist.size() == 0)
        {
            activity.showProgressBar("Loading...");
        }
    }

    private ()
    {
        this$0 = Mixtapes.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
