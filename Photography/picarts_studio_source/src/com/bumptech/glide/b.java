// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.support.v4.app.FragmentActivity;
import com.bumptech.glide.load.e;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.load.resource.bitmap.aa;
import com.bumptech.glide.load.resource.bitmap.d;
import com.bumptech.glide.load.resource.bitmap.h;
import com.bumptech.glide.load.resource.bitmap.p;
import com.bumptech.glide.load.resource.bitmap.x;
import com.bumptech.glide.request.a;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import myobfuscated.ab.f;
import myobfuscated.ab.n;
import myobfuscated.ab.o;
import myobfuscated.ad.l;
import myobfuscated.s.j;
import myobfuscated.v.ar;
import myobfuscated.v.as;
import myobfuscated.v.at;
import myobfuscated.v.av;
import myobfuscated.v.aw;
import myobfuscated.v.ay;
import myobfuscated.v.bb;
import myobfuscated.v.bd;
import myobfuscated.v.bf;
import myobfuscated.v.c;
import myobfuscated.v.m;
import myobfuscated.v.s;
import myobfuscated.v.t;
import myobfuscated.w.g;
import myobfuscated.w.i;
import myobfuscated.w.k;

// Referenced classes of package com.bumptech.glide:
//            Registry, d, c, k

public class b
    implements ComponentCallbacks2
{

    private static volatile b f;
    public final myobfuscated.s.g a;
    final com.bumptech.glide.d b;
    public final j c = new j();
    final myobfuscated.ad.d d;
    final List e = new ArrayList();
    private final myobfuscated.t.l g;
    private final Registry h;
    private final myobfuscated.s.b i;

    private b(Context context, com.bumptech.glide.load.engine.m m1, myobfuscated.t.l l1, myobfuscated.s.g g1, myobfuscated.s.b b1, myobfuscated.ad.d d1, int i1, 
            com.bumptech.glide.request.e e1)
    {
        a = g1;
        i = b1;
        g = l1;
        d = d1;
        ((a) (e1)).q.a(p.a);
        new myobfuscated.u.a();
        l1 = context.getResources();
        d1 = new p(l1.getDisplayMetrics(), g1, c);
        b1 = new myobfuscated.ab.a(context, g1, b1);
        h = (new Registry(context)).a(java/nio/ByteBuffer, new myobfuscated.v.j()).a(java/io/InputStream, new at(c)).a(java/nio/ByteBuffer, android/graphics/Bitmap, new h(d1)).a(java/io/InputStream, android/graphics/Bitmap, new x(d1, c)).a(android/os/ParcelFileDescriptor, android/graphics/Bitmap, new aa(g1)).a(android/graphics/Bitmap, new d()).a(java/nio/ByteBuffer, android/graphics/drawable/BitmapDrawable, new com.bumptech.glide.load.resource.bitmap.a(l1, g1, new h(d1))).a(java/io/InputStream, android/graphics/drawable/BitmapDrawable, new com.bumptech.glide.load.resource.bitmap.a(l1, g1, new x(d1, c))).a(android/os/ParcelFileDescriptor, android/graphics/drawable/BitmapDrawable, new com.bumptech.glide.load.resource.bitmap.a(l1, g1, new aa(g1))).a(android/graphics/drawable/BitmapDrawable, new com.bumptech.glide.load.resource.bitmap.b(g1, new d())).b(java/io/InputStream, myobfuscated/ab/d, new o(b1, c)).b(java/nio/ByteBuffer, myobfuscated/ab/d, b1).a(myobfuscated/ab/d, new f()).a(myobfuscated/p/a, myobfuscated/p/a, new ay()).a(myobfuscated/p/a, android/graphics/Bitmap, new n(g1)).a(new myobfuscated.y.b()).a(java/io/File, java/nio/ByteBuffer, new m()).a(java/io/File, java/io/InputStream, new s()).a(java/io/File, java/io/File, new myobfuscated.aa.a()).a(java/io/File, android/os/ParcelFileDescriptor, new myobfuscated.v.p()).a(java/io/File, java/io/File, new ay()).a(new myobfuscated.q.n(c)).a(Integer.TYPE, java/io/InputStream, new as()).a(Integer.TYPE, android/os/ParcelFileDescriptor, new ar()).a(java/lang/Integer, java/io/InputStream, new as()).a(java/lang/Integer, android/os/ParcelFileDescriptor, new ar()).a(java/lang/String, java/io/InputStream, new aw()).a(java/lang/String, android/os/ParcelFileDescriptor, new av()).a(android/net/Uri, java/io/InputStream, new myobfuscated.w.e()).a(android/net/Uri, java/io/InputStream, new myobfuscated.v.d()).a(android/net/Uri, android/os/ParcelFileDescriptor, new c()).a(android/net/Uri, java/io/InputStream, new g()).a(android/net/Uri, java/io/InputStream, new i()).a(android/net/Uri, java/io/InputStream, new bd()).a(android/net/Uri, android/os/ParcelFileDescriptor, new bb()).a(android/net/Uri, java/io/InputStream, new bf()).a(java/net/URL, java/io/InputStream, new k()).a(android/net/Uri, java/io/File, new myobfuscated.v.aa()).a(myobfuscated/v/t, java/io/InputStream, new myobfuscated.w.c()).a([B, java/nio/ByteBuffer, new myobfuscated.v.f()).a([B, java/io/InputStream, new myobfuscated.v.i()).a(android/graphics/Bitmap, android/graphics/drawable/BitmapDrawable, new myobfuscated.ac.b(l1, g1)).a(android/graphics/Bitmap, [B, new myobfuscated.ac.a()).a(myobfuscated/ab/d, [B, new myobfuscated.ac.c());
        l1 = new myobfuscated.ag.d();
        b = new com.bumptech.glide.d(context, h, l1, e1, m1, this, i1);
    }

    public static b a(Context context)
    {
        if (f != null) goto _L2; else goto _L1
_L1:
        com/bumptech/glide/b;
        JVM INSTR monitorenter ;
        Object obj;
        Object obj1;
        if (f != null)
        {
            break MISSING_BLOCK_LABEL_476;
        }
        context = context.getApplicationContext();
        obj = (new myobfuscated.ae.b(context)).a();
        obj1 = new com.bumptech.glide.c(context);
        for (Iterator iterator = ((List) (obj)).iterator(); iterator.hasNext(); ((myobfuscated.ae.a)iterator.next()).applyOptions(context, ((com.bumptech.glide.c) (obj1)))) { }
        break MISSING_BLOCK_LABEL_82;
        context;
        com/bumptech/glide/b;
        JVM INSTR monitorexit ;
        throw context;
        if (((com.bumptech.glide.c) (obj1)).f == null)
        {
            obj1.f = new GlideExecutor("source");
        }
        if (((com.bumptech.glide.c) (obj1)).g == null)
        {
            obj1.g = new GlideExecutor("disk-cache", (byte)0);
        }
        if (((com.bumptech.glide.c) (obj1)).i == null)
        {
            myobfuscated.t.o o1 = new myobfuscated.t.o(((com.bumptech.glide.c) (obj1)).a);
            obj1.i = new myobfuscated.t.n(o1.a, o1.b, o1.c, o1.d, o1.e, o1.h, o1.f, o1.g);
        }
        if (((com.bumptech.glide.c) (obj1)).j == null)
        {
            obj1.j = new myobfuscated.ad.d();
        }
        if (((com.bumptech.glide.c) (obj1)).c == null)
        {
            if (android.os.Build.VERSION.SDK_INT < 11)
            {
                break MISSING_BLOCK_LABEL_462;
            }
            obj1.c = new myobfuscated.s.p(((com.bumptech.glide.c) (obj1)).i.a);
        }
_L3:
        if (((com.bumptech.glide.c) (obj1)).d == null)
        {
            obj1.d = new myobfuscated.s.b(((com.bumptech.glide.c) (obj1)).i.c);
        }
        if (((com.bumptech.glide.c) (obj1)).e == null)
        {
            obj1.e = new myobfuscated.t.k(((com.bumptech.glide.c) (obj1)).i.b);
        }
        if (((com.bumptech.glide.c) (obj1)).h == null)
        {
            obj1.h = new myobfuscated.t.j(((com.bumptech.glide.c) (obj1)).a);
        }
        if (((com.bumptech.glide.c) (obj1)).b == null)
        {
            obj1.b = new com.bumptech.glide.load.engine.m(((com.bumptech.glide.c) (obj1)).e, ((com.bumptech.glide.c) (obj1)).h, ((com.bumptech.glide.c) (obj1)).g, ((com.bumptech.glide.c) (obj1)).f);
        }
        Context context1 = ((com.bumptech.glide.c) (obj1)).a;
        com.bumptech.glide.load.engine.m m1 = ((com.bumptech.glide.c) (obj1)).b;
        myobfuscated.t.l l1 = ((com.bumptech.glide.c) (obj1)).e;
        myobfuscated.s.g g1 = ((com.bumptech.glide.c) (obj1)).c;
        myobfuscated.s.b b1 = ((com.bumptech.glide.c) (obj1)).d;
        myobfuscated.ad.d d1 = ((com.bumptech.glide.c) (obj1)).j;
        int i1 = ((com.bumptech.glide.c) (obj1)).k;
        obj1 = ((com.bumptech.glide.c) (obj1)).l;
        obj1.t = true;
        f = new b(context1, m1, l1, g1, b1, d1, i1, (com.bumptech.glide.request.e)obj1);
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); ((myobfuscated.ae.a)((Iterator) (obj)).next()).registerComponents(context, f.h)) { }
        break MISSING_BLOCK_LABEL_476;
        obj1.c = new myobfuscated.s.h();
          goto _L3
        com/bumptech/glide/b;
        JVM INSTR monitorexit ;
_L2:
        return f;
    }

    public static com.bumptech.glide.k a(Activity activity)
    {
        return l.a().a(activity);
    }

    public static com.bumptech.glide.k a(FragmentActivity fragmentactivity)
    {
        return l.a().a(fragmentactivity);
    }

    public static com.bumptech.glide.k b(Context context)
    {
        return l.a().a(context);
    }

    public final void a()
    {
        myobfuscated.aj.j.a();
        g.a();
        a.a();
        i.a();
    }

    public void onConfigurationChanged(Configuration configuration)
    {
    }

    public void onLowMemory()
    {
        a();
    }

    public void onTrimMemory(int i1)
    {
        myobfuscated.aj.j.a();
        g.a(i1);
        a.a(i1);
        i.a(i1);
    }
}
