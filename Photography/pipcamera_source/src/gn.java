// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.util.Log;
import com.fotoable.comlib.util.UgentAsyncTask;
import java.io.IOException;

class gn extends UgentAsyncTask
{

    String a;
    gp e;
    boolean f;
    final gm g;

    gn(gm gm1)
    {
        g = gm1;
        super();
        f = false;
    }

    protected transient String a(Bitmap abitmap[])
    {
        if (a == null)
        {
            return null;
        }
        g.a();
        Log.e("imagekeep", (new StringBuilder()).append("doInBackground:").append(g.c).toString());
        abitmap = gm.a(g, a, abitmap[0]);
        g.b();
        return abitmap;
        abitmap;
        abitmap.printStackTrace();
        return null;
        abitmap;
        throw abitmap;
    }

    public void a(gp gp1)
    {
        e = gp1;
    }

    public void a(String s)
    {
        a = s;
    }

    protected Object b(Object aobj[])
    {
        return a((Bitmap[])aobj);
    }

    protected volatile void b(Object obj)
    {
        b((String)obj);
    }

    protected void b(String s)
    {
        if (e != null)
        {
            e.a(s);
        }
        super.b(s);
    }
}
