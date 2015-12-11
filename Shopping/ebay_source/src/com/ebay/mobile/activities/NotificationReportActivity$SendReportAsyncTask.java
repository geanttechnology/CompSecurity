// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;
import com.ebay.nautilus.domain.net.DataRequest;
import com.ebay.nautilus.domain.net.DataResponse;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.net.URL;

// Referenced classes of package com.ebay.mobile.activities:
//            NotificationReportActivity

public final class context extends AsyncTask
{

    private final EbayContext context;
    final NotificationReportActivity this$0;
    private StringBuffer url;

    protected transient Long doInBackground(Void avoid[])
    {
        long l1 = 0L;
        avoid = ((DataResponse)com.ebay.nautilus.kernel.net.ntext(context, new DataRequest(new URL(url.toString())))).getText();
        long l;
        l = l1;
        if (avoid == null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        boolean flag = avoid.contains("200 OK");
        l = l1;
        if (flag)
        {
            l = 0L + 1L;
        }
_L2:
        return Long.valueOf(l);
        avoid;
        Log.e("NotificationReport", "removeFromList request failed", avoid);
        l = l1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected void onPostExecute(Long long1)
    {
        if (long1.longValue() != 0L)
        {
            Toast.makeText(NotificationReportActivity.this, "Report sent to notification monitor", 1).show();
            finish();
            return;
        } else
        {
            Toast.makeText(NotificationReportActivity.this, "Error sending to notification monitor", 1).show();
            NotificationReportActivity.access$000(NotificationReportActivity.this).setEnabled(true);
            return;
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Long)obj);
    }

    public (StringBuffer stringbuffer)
    {
        this$0 = NotificationReportActivity.this;
        super();
        url = stringbuffer;
        context = getEbayContext();
    }
}
