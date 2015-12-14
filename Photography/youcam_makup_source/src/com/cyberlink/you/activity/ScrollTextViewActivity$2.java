// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.os.AsyncTask;
import android.view.View;

// Referenced classes of package com.cyberlink.you.activity:
//            ScrollTextViewActivity

class a
    implements android.view.iewActivity._cls2
{

    final ScrollTextViewActivity a;

    public void onClick(View view)
    {
        (new AsyncTask() {

            final ScrollTextViewActivity._cls2 a;

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

            
            {
                a = ScrollTextViewActivity._cls2.this;
                super();
            }
        }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        ScrollTextViewActivity.b(a);
    }

    _cls1.a(ScrollTextViewActivity scrolltextviewactivity)
    {
        a = scrolltextviewactivity;
        super();
    }
}
