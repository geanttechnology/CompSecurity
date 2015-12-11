// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.view.View;
import com.google.android.gms.ads.internal.zzg;

// Referenced classes of package android.support.v7:
//            ll, lk

public final class nu extends nw.a
{

    private final zzg a;
    private final String b;
    private final String c;

    public nu(zzg zzg1, String s, String s1)
    {
        a = zzg1;
        b = s;
        c = s1;
    }

    public String a()
    {
        return b;
    }

    public void a(lk lk)
    {
        if (lk == null)
        {
            return;
        } else
        {
            a.zzc((View)ll.a(lk));
            return;
        }
    }

    public String b()
    {
        return c;
    }

    public void c()
    {
        a.recordClick();
    }

    public void d()
    {
        a.recordImpression();
    }
}
