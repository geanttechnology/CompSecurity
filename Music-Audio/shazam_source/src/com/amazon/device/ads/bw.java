// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.graphics.Bitmap;
import java.io.InputStream;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            dc, bs

public final class bw extends dc
{

    final bs a;

    bw(dc dc1, bs bs1)
    {
        super(dc1.d());
        a = bs1;
    }

    public final Bitmap a()
    {
        return a.a(super.d());
    }

    public final volatile void a(String s)
    {
        super.a(s);
    }

    public final volatile void a(boolean flag)
    {
        super.a(flag);
    }

    public final volatile JSONObject b()
    {
        return super.b();
    }

    public final volatile String c()
    {
        return super.c();
    }

    public final volatile InputStream d()
    {
        return super.d();
    }
}
