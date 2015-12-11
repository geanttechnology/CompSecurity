// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            ci, f, h, aj, 
//            do

private static final class b extends b
{

    private final ci b;

    public final JSONObject a()
    {
        Object obj = b.g.a;
        Object obj1 = new DisplayMetrics();
        ((WindowManager)((h) (obj)).b.getSystemService("window")).getDefaultDisplay().getMetrics(((DisplayMetrics) (obj1)));
        int j = ((DisplayMetrics) (obj1)).widthPixels;
        int i = ((DisplayMetrics) (obj1)).heightPixels;
        obj1 = ((h) (obj)).e;
        j = aj.a(j);
        obj = ((h) (obj)).e;
        return (new do(j, aj.a(i))).a();
    }

    public (ci ci1)
    {
        super("GetScreenSize");
        b = ci1;
    }
}
