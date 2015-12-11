// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            aat, ls, ado

class acp extends aat
{

    private static final String a;
    private final Context b;

    public acp(Context context)
    {
        super(a, new String[0]);
        b = context;
    }

    public lv.a a(Map map)
    {
        map = new DisplayMetrics();
        ((WindowManager)b.getSystemService("window")).getDefaultDisplay().getMetrics(map);
        int i = ((DisplayMetrics) (map)).widthPixels;
        int j = ((DisplayMetrics) (map)).heightPixels;
        return ado.e((new StringBuilder()).append(i).append("x").append(j).toString());
    }

    public boolean a()
    {
        return true;
    }

    static 
    {
        a = ls.y.toString();
    }
}
