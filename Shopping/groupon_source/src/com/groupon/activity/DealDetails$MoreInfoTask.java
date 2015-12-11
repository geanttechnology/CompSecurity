// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.support.v7.widget.RecyclerView;
import com.groupon.adapter.DealDetailsRecyclerAdapter;
import com.groupon.models.dealdetails.DealDetailsViewType;
import com.groupon.mvc.controller.recycleritem.MoreInfoController;
import com.groupon.util.GrouponSafeAsyncTask;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            DealDetails

private class pitchHtml extends GrouponSafeAsyncTask
{

    private String pitchHtml;
    final DealDetails this$0;

    private String processPitchHtml(String s)
    {
        Object obj = s;
        if (Strings.notEmpty(s))
        {
            Object obj1 = Pattern.compile("(.*)(<\\s*(embed|object).*[\"']([^\"']+youtube[^\"']+).*<\\s*/\\s*(embed|object)\\s*>)(.*)", 32);
            obj = Pattern.compile("([^\"']+youtube[^\"']+)", 2).matcher(s);
            int i;
            for (i = 0; ((Matcher) (obj)).find(); i++) { }
            if (i > 1)
            {
                obj = ((Matcher) (obj)).replaceFirst("");
            } else
            {
                obj = s;
            }
            obj1 = ((Pattern) (obj1)).matcher(((CharSequence) (obj)));
            obj = s;
            if (((Matcher) (obj1)).matches())
            {
                obj = ((Matcher) (obj1)).replaceAll((new StringBuilder()).append("$1<a href=\"$4\">").append(getString(0x7f08040a)).append("</a>$6").toString());
            }
        }
        return ((String) (obj));
    }

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public String call()
        throws Exception
    {
        return processPitchHtml(pitchHtml);
    }

    protected volatile void onSuccess(Object obj)
        throws Exception
    {
        onSuccess((String)obj);
    }

    protected void onSuccess(String s)
        throws Exception
    {
        super.onSuccess(s);
        MoreInfoController moreinfocontroller1 = (MoreInfoController)DealDetails.access$2700(DealDetails.this).get(DealDetailsViewType.MORE_INFO);
        MoreInfoController moreinfocontroller = moreinfocontroller1;
        if (moreinfocontroller1 == null)
        {
            moreinfocontroller = new MoreInfoController(DealDetails.this);
        }
        moreinfocontroller.setDeal(DealDetails.access$1400(DealDetails.this));
        moreinfocontroller.setPitchHtml(s);
        moreinfocontroller.processData();
        DealDetails.access$2800(DealDetails.this, DealDetailsViewType.MORE_INFO, moreinfocontroller);
        if (moreinfocontroller.isReady())
        {
            detailsRecyclerView.setItemViewCacheSize(DealDetails.access$2700(DealDetails.this).size());
            DealDetails.access$2900(DealDetails.this).insertItem(DealDetailsViewType.MORE_INFO, moreinfocontroller);
        }
    }

    public (String s)
    {
        this$0 = DealDetails.this;
        super();
        pitchHtml = s;
    }
}
