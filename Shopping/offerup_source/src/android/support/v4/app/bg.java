// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Notification;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package android.support.v4.app:
//            br, bq, bw, bv, 
//            bu, bt, bs, bp, 
//            bh, be, bk, ce, 
//            bo, bj, bf, bx

public final class bg
{

    private static final bp a;

    public static Bundle a(Notification notification)
    {
        return a.a(notification);
    }

    static bp a()
    {
        return a;
    }

    static void a(be be1, ArrayList arraylist)
    {
        for (arraylist = arraylist.iterator(); arraylist.hasNext(); be1.a((bh)arraylist.next())) { }
    }

    static void a(bf bf, bx bx)
    {
        if (bx != null)
        {
            if (bx instanceof bk)
            {
                bx = (bk)bx;
                ce.a(bf, ((bk) (bx)).c, ((bk) (bx)).e, ((bk) (bx)).d, ((bk) (bx)).a);
            } else
            {
                if (bx instanceof bo)
                {
                    bx = (bo)bx;
                    ce.a(bf, ((bo) (bx)).c, ((bo) (bx)).e, ((bo) (bx)).d, ((bo) (bx)).a);
                    return;
                }
                if (bx instanceof bj)
                {
                    bx = (bj)bx;
                    ce.a(bf, ((bj) (bx)).c, ((bj) (bx)).e, ((bj) (bx)).d, ((bj) (bx)).a, null, false);
                    return;
                }
            }
        }
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            a = new br();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 20)
        {
            a = new bq();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            a = new bw();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            a = new bv();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            a = new bu();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            a = new bt();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            a = new bs();
        } else
        {
            a = new bp();
        }
    }
}
