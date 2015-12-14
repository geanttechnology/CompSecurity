// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.b;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Handler;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.b:
//            a, b

class d extends AsyncTask
{

    final a a;

    private d(a a1)
    {
        a = a1;
        super();
    }

    d(a a1, a._cls1 _pcls1)
    {
        this(a1);
    }

    protected transient Boolean a(Void avoid[])
    {
        avoid = com.cyberlink.youcammakeup.widgetpool.b.a.a(a);
        if (avoid != null)
        {
            com.cyberlink.youcammakeup.widgetpool.b.a.a(a, Bitmap.createBitmap((int)avoid.b(), (int)avoid.c(), android.graphics.Bitmap.Config.ARGB_8888));
            avoid.c(com.cyberlink.youcammakeup.widgetpool.b.a.b(a));
            avoid.m();
            return Boolean.valueOf(true);
        } else
        {
            com.cyberlink.youcammakeup.widgetpool.b.a.a(a, "get ImageBufferWrapper null");
            return Boolean.valueOf(false);
        }
    }

    protected void a(Boolean boolean1)
    {
        if (boolean1.booleanValue())
        {
            com.cyberlink.youcammakeup.widgetpool.b.a.c(a).b();
            com.cyberlink.youcammakeup.widgetpool.b.a.e(a).post(new Runnable() {

                final d a;

                public void run()
                {
                    android.app.Activity activity = a.a.getActivity();
                    if (activity != null && !com.cyberlink.youcammakeup.widgetpool.b.a.d(a.a))
                    {
                        ((EditViewActivity)activity).a(true, true);
                    }
                }

            
            {
                a = d.this;
                super();
            }
            });
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Boolean)obj);
    }
}
