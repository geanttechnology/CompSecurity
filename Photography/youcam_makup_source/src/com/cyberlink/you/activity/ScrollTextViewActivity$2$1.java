// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.os.AsyncTask;
import android.view.View;

// Referenced classes of package com.cyberlink.you.activity:
//            ScrollTextViewActivity

class a extends AsyncTask
{

    final a a;

    protected transient Void a(Void avoid[])
    {
        Thread.currentThread().setName("ScrollTextViewActivity.pingUServer AsyncTask");
        ScrollTextViewActivity.a(a.a);
        return null;
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/cyberlink/you/activity/ScrollTextViewActivity$2

/* anonymous class */
    class ScrollTextViewActivity._cls2
        implements android.view.View.OnClickListener
    {

        final ScrollTextViewActivity a;

        public void onClick(View view)
        {
            (new ScrollTextViewActivity._cls2._cls1(this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            ScrollTextViewActivity.b(a);
        }

            
            {
                a = scrolltextviewactivity;
                super();
            }
    }

}
