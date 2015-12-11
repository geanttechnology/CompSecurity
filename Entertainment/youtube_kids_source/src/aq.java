// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Iterator;

public final class aq
{

    private static final aw a;

    public static aw a()
    {
        return a;
    }

    static void a(ao ao1, ArrayList arraylist)
    {
        for (arraylist = arraylist.iterator(); arraylist.hasNext(); ao1.a((ar)arraylist.next())) { }
    }

    static void a(ap ap, be be)
    {
        if (be != null)
        {
            if (be instanceof at)
            {
                bj.a(ap, null, false, null, null);
            } else
            {
                if (be instanceof av)
                {
                    bj.a(ap, null, false, null, ((av)be).a);
                    return;
                }
                if (be instanceof as)
                {
                    bj.a(ap, null, false, null, null, null, false);
                    return;
                }
            }
        }
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            a = new ay();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 20)
        {
            a = new ax();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            a = new bd();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            a = new bc();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            a = new bb();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            a = new ba();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            a = new az();
        } else
        {
            a = new aw();
        }
    }
}
