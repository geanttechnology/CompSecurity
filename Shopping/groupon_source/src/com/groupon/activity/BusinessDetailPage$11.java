// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import android.widget.FrameLayout;
import com.groupon.db.models.Business;
import com.groupon.http.synchronous.SyncHttp;
import com.groupon.util.AbstractRetryAsyncTask;
import java.io.InputStream;
import java.util.ArrayList;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            BusinessDetailPage

class it> extends AbstractRetryAsyncTask
{

    final BusinessDetailPage this$0;
    final boolean val$isThumbUp;
    final String val$oldRecommend;

    public InputStream call()
        throws Exception
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add("recommend");
        String s;
        if (val$isThumbUp)
        {
            s = "yes";
        } else
        {
            s = "no";
        }
        arraylist.add(s);
        s = String.format("https:/businesses/%s/recommendations", new Object[] {
            businessId
        });
        return (InputStream)(new SyncHttp(getApplicationContext(), java/io/InputStream, s)).nvps(arraylist.toArray()).method("POST").call();
    }

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    protected void onException(Exception exception)
    {
        super.onException(exception);
    }

    protected void onPreExecute()
        throws Exception
    {
        super.onPreExecute();
    }

    protected void onSuccess(InputStream inputstream)
        throws Exception
    {
        super.onSuccess(inputstream);
    }

    protected volatile void onSuccess(Object obj)
        throws Exception
    {
        onSuccess((InputStream)obj);
    }

    public void onUserCancelRetry()
    {
        boolean flag = false;
        if (Strings.isEmpty(val$oldRecommend))
        {
            thumbUp.setSelected(false);
            thumbDown.setSelected(false);
            BusinessDetailPage.access$100(BusinessDetailPage.this).recommend = val$oldRecommend;
            return;
        }
        Object obj = thumbUp;
        if (!val$isThumbUp)
        {
            flag = true;
        }
        ((FrameLayout) (obj)).setSelected(flag);
        thumbDown.setSelected(val$isThumbUp);
        Business business = BusinessDetailPage.access$100(BusinessDetailPage.this);
        if (!val$isThumbUp)
        {
            obj = "yes";
        } else
        {
            obj = "no";
        }
        business.recommend = ((String) (obj));
    }

    (String s)
    {
        this$0 = final_businessdetailpage;
        val$isThumbUp = Z.this;
        val$oldRecommend = s;
        super(final_context);
    }
}
