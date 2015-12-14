// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.opengl.GLSurfaceView;
import android.os.AsyncTask;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            u, w

class x extends AsyncTask
{

    final u a;

    private x(u u1)
    {
        a = u1;
        super();
    }

    x(u u1, u._cls1 _pcls1)
    {
        this(u1);
    }

    protected transient Void a(Void avoid[])
    {
        u.a(a, a.b);
        u.a(a, u.b(a));
        u.a(a, true);
        if (u.c(a) != null)
        {
            u.c(a).a(u.d(a));
        }
        return null;
    }

    protected void a(Void void1)
    {
        u.a(a).setVisibility(8);
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Void)obj);
    }

    protected void onPreExecute()
    {
        u.a(a).setVisibility(0);
        u.a(a, false);
    }
}
