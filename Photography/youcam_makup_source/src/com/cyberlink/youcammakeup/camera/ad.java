// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.os.AsyncTask;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            y, ac

class ad extends AsyncTask
{

    final y a;

    private ad(y y1)
    {
        a = y1;
        super();
    }

    ad(y y1, y._cls1 _pcls1)
    {
        this(y1);
    }

    protected transient Void a(Void avoid[])
    {
        y.b(a, true);
        if (y.g(a) != null)
        {
            y.g(a).a();
        }
        return null;
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPreExecute()
    {
        y.b(a, false);
    }
}
