// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.app.Activity;
import android.os.AsyncTask;

// Referenced classes of package com.bitstrips.imoji.ui:
//            ImojiBrowserActivity, IntentCreatorService

class val.activity extends AsyncTask
{

    final ImojiBrowserActivity this$0;
    final Activity val$activity;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        intentCreatorService.goToBitmojiForMessengerOnboarding(val$activity);
    }

    ()
    {
        this$0 = final_imojibrowseractivity;
        val$activity = Activity.this;
        super();
    }
}
