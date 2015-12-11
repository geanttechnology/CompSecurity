// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import android.content.res.Resources;
import android.widget.TextView;
import com.groupon.http.synchronous.SyncHttp;
import com.groupon.service.LoginService;
import com.groupon.util.AbstractRetryAsyncTask;
import com.groupon.view.SpinnerButton;
import java.io.InputStream;
import java.util.ArrayList;

// Referenced classes of package com.groupon.activity:
//            BusinessDetailPage

class it> extends AbstractRetryAsyncTask
{

    final BusinessDetailPage this$0;
    final int val$messageLength;

    public InputStream call()
        throws Exception
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add("request_deal");
        arraylist.add(Boolean.valueOf(true));
        arraylist.add("business_id");
        arraylist.add(businessId);
        String s = String.format("https:/users/%s/followed_businesses", new Object[] {
            BusinessDetailPage.access$700(BusinessDetailPage.this).getConsumerId()
        });
        return (InputStream)(new SyncHttp(getApplicationContext(), java/io/InputStream, s)).nvps(arraylist.toArray()).method("POST").call();
    }

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    protected void onPreExecute()
        throws Exception
    {
        super.onPreExecute();
    }

    protected void onSuccess(InputStream inputstream)
        throws Exception
    {
        requestDealButton.stopSpinning();
        if (val$messageLength > 0)
        {
            xPeopleSignedUpCompletedTextView.setText(String.format(getResources().getQuantityString(0x7f0c0021, val$messageLength), new Object[] {
                BusinessDetailPage.access$600(BusinessDetailPage.this, val$messageLength)
            }));
            xPeopleSignedUpCompletedTextView.setVisibility(0);
        } else
        {
            xPeopleSignedUpCompletedTextView.setVisibility(8);
        }
        BusinessDetailPage.access$1100(BusinessDetailPage.this);
        BusinessDetailPage.access$1202(BusinessDetailPage.this, true);
        super.onSuccess(inputstream);
    }

    protected volatile void onSuccess(Object obj)
        throws Exception
    {
        onSuccess((InputStream)obj);
    }

    public void onUserCancelRetry()
    {
        requestDealButton.stopSpinning();
    }

    (int i)
    {
        this$0 = final_businessdetailpage;
        val$messageLength = i;
        super(Context.this);
    }
}
