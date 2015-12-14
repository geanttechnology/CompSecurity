// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ab;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.bumptech.glide.b;
import com.bumptech.glide.j;
import com.bumptech.glide.k;
import com.bumptech.glide.load.engine.l;
import com.bumptech.glide.load.h;
import com.bumptech.glide.request.e;
import java.util.ArrayList;
import java.util.List;
import myobfuscated.f.m;
import myobfuscated.p.a;
import myobfuscated.p.c;
import myobfuscated.p.d;
import myobfuscated.s.g;

// Referenced classes of package myobfuscated.ab:
//            l, j, m

final class i
{

    final a a;
    final Handler b;
    final List c;
    final k d;
    boolean e;
    boolean f;
    myobfuscated.ab.j g;
    boolean h;
    myobfuscated.ab.j i;
    Bitmap j;
    private final Context k;
    private j l;

    private i(Context context, k k1, a a1, j j1, h h1, Bitmap bitmap)
    {
        c = new ArrayList();
        e = false;
        f = false;
        d = k1;
        k1 = new Handler(Looper.getMainLooper(), new myobfuscated.ab.l(this, (byte)0));
        k = context;
        b = k1;
        l = j1;
        a = a1;
        a(h1, bitmap);
    }

    public i(Context context, a a1, int i1, int j1, h h1, Bitmap bitmap)
    {
        this(context, com.bumptech.glide.b.b(context), a1, com.bumptech.glide.b.b(context).g().a(((e)com.bumptech.glide.request.e.b(l.b).a(true)).a(i1, j1)), h1, bitmap);
    }

    final Bitmap a()
    {
        if (g != null)
        {
            return g.b;
        } else
        {
            return j;
        }
    }

    final void a(h h1, Bitmap bitmap)
    {
        m.a(h1, "Argument must not be null");
        j = (Bitmap)m.a(bitmap, "Argument must not be null");
        l = l.a((new e()).a(k, h1));
    }

    final void b()
    {
        a a1;
        if (!e || f)
        {
            return;
        }
        f = true;
        a1 = a;
        if (a1.g.c > 0 && a1.f >= 0) goto _L2; else goto _L1
_L1:
        int i1 = 0;
_L4:
        long l1 = SystemClock.uptimeMillis();
        long l2 = i1;
        a.a();
        i = new myobfuscated.ab.j(b, a.f, l2 + l1);
        l.a().a(com.bumptech.glide.request.e.a(new myobfuscated.ab.m())).a(a).a(i);
        return;
_L2:
        int j1 = a1.f;
        byte byte0 = -1;
        i1 = byte0;
        if (j1 >= 0)
        {
            i1 = byte0;
            if (j1 < a1.g.c)
            {
                i1 = ((c)a1.g.e.get(j1)).i;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    final void c()
    {
        if (j != null)
        {
            com.bumptech.glide.b.a(k).a.a(j);
            j = null;
        }
    }
}
