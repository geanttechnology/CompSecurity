// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            aat, ls, aaj, ado

class aci extends aat
{

    private static final String a;
    private final aaj b;

    public aci(Context context)
    {
        this(aaj.a(context));
    }

    aci(aaj aaj1)
    {
        super(a, new String[0]);
        b = aaj1;
    }

    public lv.a a(Map map)
    {
        boolean flag;
        if (!b.b())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return ado.e(Boolean.valueOf(flag));
    }

    public boolean a()
    {
        return false;
    }

    static 
    {
        a = ls.b.toString();
    }
}
