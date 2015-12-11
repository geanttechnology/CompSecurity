// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            aat, ls, ado

class adu extends aat
{

    private static final String a;
    private final Context b;

    public adu(Context context)
    {
        super(a, new String[0]);
        b = context;
    }

    public lv.a a(Map map)
    {
        return ado.e(b.getPackageName());
    }

    public boolean a()
    {
        return true;
    }

    static 
    {
        a = ls.c.toString();
    }
}
