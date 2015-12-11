// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api;

import android.os.AsyncTask;

// Referenced classes of package com.google.userfeedback.android.api:
//            UserFeedback

class this._cls0 extends AsyncTask
{

    final UserFeedback this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        if (!isReportReady())
        {
            blockOnReportConstruction();
        }
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        startSendUserFeedbackIntent();
    }

    ()
    {
        this$0 = UserFeedback.this;
        super();
    }
}
