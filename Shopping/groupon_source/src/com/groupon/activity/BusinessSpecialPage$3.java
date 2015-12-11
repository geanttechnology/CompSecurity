// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import com.groupon.db.models.Special;
import com.groupon.http.synchronous.SyncHttp;
import com.groupon.manager.BusinessDetailSyncManager;
import com.groupon.service.LoginService;
import com.groupon.util.AbstractRetryAsyncTask;
import com.groupon.view.SpinnerButton;
import java.io.InputStream;
import java.util.ArrayList;

// Referenced classes of package com.groupon.activity:
//            BusinessSpecialPage

class it> extends AbstractRetryAsyncTask
{

    final BusinessSpecialPage this$0;

    public InputStream call()
        throws Exception
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add("special_id");
        arraylist.add(specialId);
        String s = String.format("https:/users/%s/specials", new Object[] {
            BusinessSpecialPage.access$300(BusinessSpecialPage.this).getConsumerId()
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
        specialButton.stopSpinning();
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
        BusinessSpecialPage.access$700(BusinessSpecialPage.this);
        BusinessSpecialPage.access$800(BusinessSpecialPage.this).requestSync(BusinessSpecialPage.this, null);
        BusinessSpecialPage.access$000(BusinessSpecialPage.this).claimed = true;
        super.onSuccess(inputstream);
    }

    protected volatile void onSuccess(Object obj)
        throws Exception
    {
        onSuccess((InputStream)obj);
    }

    er(Context context)
    {
        this$0 = BusinessSpecialPage.this;
        super(context);
    }
}
