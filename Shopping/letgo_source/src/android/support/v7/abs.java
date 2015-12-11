// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            aat, ls, ado

class abs extends aat
{

    private static final String a;
    private final Context b;

    public abs(Context context)
    {
        super(a, new String[0]);
        b = context;
    }

    public lv.a a(Map map)
    {
        map = a(b);
        if (map == null)
        {
            return ado.f();
        } else
        {
            return ado.e(map);
        }
    }

    protected String a(Context context)
    {
        return android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    public boolean a()
    {
        return true;
    }

    static 
    {
        a = ls.L.toString();
    }
}
