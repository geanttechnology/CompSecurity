// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.ftue;

import android.app.Dialog;
import android.os.AsyncTask;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import com.amazon.gallery.framework.network.http.rest.account.EndpointManager;
import com.amazon.gallery.framework.network.http.rest.account.SubscriptionInfoCache;
import com.amazon.gallery.thor.GalleryWebViewHelper;
import com.amazon.gallery.thor.app.activity.ManageStorageActivity;

// Referenced classes of package com.amazon.gallery.thor.ftue:
//            ThorFTUEActivity, WelcomeScreen

private class loadPromotion extends AsyncTask
{

    private boolean loadEndpoint;
    private boolean loadPromotion;
    private com.amazon.gallery.framework.network.http.rest.account.eckOccurredInThisSession promotion;
    final ThorFTUEActivity this$0;

    private void loadEndpoint()
    {
        try
        {
            ThorFTUEActivity.access$2500(ThorFTUEActivity.this).getEndpointManager().getEndpoint();
            return;
        }
        catch (TerminalException terminalexception)
        {
            GLogger.ix(ThorFTUEActivity.access$300(), "Failed to get endpoint", terminalexception);
        }
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        if (loadEndpoint)
        {
            loadEndpoint();
        }
        if (ThorFTUEActivity.access$100(ThorFTUEActivity.this) == null)
        {
            ThorFTUEActivity.access$2300(ThorFTUEActivity.this);
        }
        if (loadPromotion)
        {
            promotion = ThorFTUEActivity.access$900(ThorFTUEActivity.this).getPromotion(ThorFTUEActivity.access$2400());
        }
        return null;
    }

    protected void onCancelled()
    {
        ThorFTUEActivity.access$2000(ThorFTUEActivity.this);
        ThorFTUEActivity.access$602(ThorFTUEActivity.this, null);
    }

    protected volatile void onCancelled(Object obj)
    {
        onCancelled((Void)obj);
    }

    protected void onCancelled(Void void1)
    {
        ThorFTUEActivity.access$2000(ThorFTUEActivity.this);
        ThorFTUEActivity.access$602(ThorFTUEActivity.this, null);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        GLogger.d("LoadingEndpointAsyncRunner", "Finished", new Object[0]);
        if (promotion != null)
        {
            void1 = GalleryWebViewHelper.getPromotionIntent(ThorFTUEActivity.this, com/amazon/gallery/thor/app/activity/ManageStorageActivity, promotion);
            startActivityForResult(void1, 975);
            ThorFTUEActivity.access$900(ThorFTUEActivity.this).setPromotionCheckOccurredInThisSession(true);
            overridePendingTransition(0x7f040024, 0x7f040024);
        } else
        {
            ThorFTUEActivity.access$2000(ThorFTUEActivity.this);
            ThorFTUEActivity.access$2100(ThorFTUEActivity.this);
        }
        if (ThorFTUEActivity.access$2200(ThorFTUEActivity.this) != null)
        {
            ThorFTUEActivity.access$2200(ThorFTUEActivity.this).setHideWelcomeContent(false);
        }
        ThorFTUEActivity.access$602(ThorFTUEActivity.this, null);
    }

    protected void onPreExecute()
    {
        if (loadEndpoint || loadPromotion)
        {
            synchronized (ThorFTUEActivity.this)
            {
                if (ThorFTUEActivity.access$1900(ThorFTUEActivity.this) != null)
                {
                    ThorFTUEActivity.access$1900(ThorFTUEActivity.this).show();
                }
            }
            return;
        } else
        {
            return;
        }
        exception;
        thorftueactivity;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public (boolean flag, boolean flag1)
    {
        this$0 = ThorFTUEActivity.this;
        super();
        promotion = null;
        loadEndpoint = flag;
        loadPromotion = flag1;
    }
}
