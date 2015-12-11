// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.f;

import android.graphics.Bitmap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package com.facebook.ads.a.f:
//            n, j

public final class r
{

    static final int a;
    static final ExecutorService b;
    private static volatile boolean f = true;
    final Bitmap c;
    Bitmap d;
    final j e = new n();

    public r(Bitmap bitmap)
    {
        c = bitmap;
    }

    static 
    {
        int i = Runtime.getRuntime().availableProcessors();
        a = i;
        b = Executors.newFixedThreadPool(i);
    }
}
