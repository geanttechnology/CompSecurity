// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import android.text.format.DateFormat;
import java.util.Calendar;
import org.json.JSONObject;

// Referenced classes of package com.apprupt.sdk:
//            CvValueExchange, SimpleJSON

private class fig
{

    private fig config;
    final CvValueExchange this$0;
    private String ts;
    private int views;

    private boolean canShowAd()
    {
        return viewsLeft() > 0;
    }

    private void incrementViews()
    {
        update(false);
        views = views + 1;
        saveCappings();
    }

    private JSONObject toJSON()
    {
        SimpleJSON simplejson = new SimpleJSON();
        simplejson.put("ts", ts);
        simplejson.put("views", Integer.valueOf(views));
        return simplejson.json;
    }

    private void update(fig fig)
    {
        config = fig;
        update(false);
    }

    private void update(boolean flag)
    {
        String s = DateFormat.format("yy/MM/dd", Calendar.getInstance().getTime()).toString();
        if (!ts.equals(s))
        {
            ts = s;
            views = 0;
            if (flag)
            {
                saveCappings();
            }
        }
    }

    private int viewsLeft()
    {
        update(true);
        return Math.max(0, config.capping - views);
    }






    private fig(fig fig, SimpleJSON simplejson)
    {
        this$0 = CvValueExchange.this;
        super();
        views = 0;
        ts = "-----";
        if (simplejson != null)
        {
            views = simplejson.getInt("views", Integer.valueOf(0));
            ts = simplejson.getString("ts", "-----");
        }
        update(fig);
    }

    fig(fig fig, SimpleJSON simplejson, fig fig1)
    {
        this(fig, simplejson);
    }
}
