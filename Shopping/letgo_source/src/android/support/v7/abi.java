// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            aat, ls, aaj, ado

class abi extends aat
{

    private static final String a;
    private final aaj b;

    public abi(Context context)
    {
        this(aaj.a(context));
    }

    abi(aaj aaj1)
    {
        super(a, new String[0]);
        b = aaj1;
    }

    public lv.a a(Map map)
    {
        map = b.a();
        if (map == null)
        {
            return ado.f();
        } else
        {
            return ado.e(map);
        }
    }

    public boolean a()
    {
        return false;
    }

    static 
    {
        a = ls.a.toString();
    }
}
