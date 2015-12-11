// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.d.e;
import java.util.Map;

// Referenced classes of package com.google.android.gms.e:
//            o, cj

final class bk extends o
{

    private static final String b;
    private final Context c;

    public bk(Context context)
    {
        super(b, new String[0]);
        c = context;
    }

    public final com.google.android.gms.d.h.a a(Map map)
    {
        map = new DisplayMetrics();
        ((WindowManager)c.getSystemService("window")).getDefaultDisplay().getMetrics(map);
        int i = ((DisplayMetrics) (map)).widthPixels;
        int j = ((DisplayMetrics) (map)).heightPixels;
        return cj.a((new StringBuilder()).append(i).append("x").append(j).toString());
    }

    public final boolean a()
    {
        return true;
    }

    static 
    {
        b = e.y.toString();
    }
}
