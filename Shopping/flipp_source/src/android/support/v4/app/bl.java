// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package android.support.v4.app:
//            bu, bt, ca, bz, 
//            by, bx, bw, bv, 
//            bm, bj, bp, cm, 
//            br, bo, bs, bk, 
//            cb

public final class bl
{

    private static final bs a;

    public static bs a()
    {
        return a;
    }

    static void a(bj bj1, ArrayList arraylist)
    {
        for (arraylist = arraylist.iterator(); arraylist.hasNext(); bj1.a((bm)arraylist.next())) { }
    }

    static void a(bk bk, cb cb)
    {
        if (cb != null)
        {
            if (cb instanceof bp)
            {
                cb = (bp)cb;
                cm.a(bk, ((bp) (cb)).e, ((bp) (cb)).g, ((bp) (cb)).f, ((bp) (cb)).a);
            } else
            {
                if (cb instanceof br)
                {
                    cb = (br)cb;
                    cm.a(bk, ((br) (cb)).e, ((br) (cb)).g, ((br) (cb)).f, ((br) (cb)).a);
                    return;
                }
                if (cb instanceof bo)
                {
                    cb = (bo)cb;
                    cm.a(bk, ((bo) (cb)).e, ((bo) (cb)).g, ((bo) (cb)).f, ((bo) (cb)).a, ((bo) (cb)).b, ((bo) (cb)).c);
                    return;
                }
            }
        }
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            a = new bu();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 20)
        {
            a = new bt();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            a = new ca();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            a = new bz();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            a = new by();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            a = new bx();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            a = new bw();
        } else
        {
            a = new bv();
        }
    }
}
