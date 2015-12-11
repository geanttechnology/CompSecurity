// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.a;
import com.google.android.gms.analytics.internal.ag;
import com.google.android.gms.analytics.internal.r;
import com.google.android.gms.analytics.internal.w;
import com.google.android.gms.analytics.internal.z;
import com.google.android.gms.common.internal.x;
import java.util.List;
import java.util.ListIterator;

// Referenced classes of package android.support.v7:
//            we, uy, wb, lf, 
//            wh

public class le extends we
{

    private final r b;
    private boolean c;

    public le(r r1)
    {
        super(r1.h(), r1.d());
        b = r1;
    }

    protected void a(wb wb1)
    {
        wb1 = (uy)wb1.b(android/support/v7/uy);
        if (TextUtils.isEmpty(wb1.b()))
        {
            wb1.b(b.p().b());
        }
        if (c && TextUtils.isEmpty(wb1.d()))
        {
            a a1 = b.o();
            wb1.d(a1.c());
            wb1.a(a1.b());
        }
    }

    public void b(String s)
    {
        x.a(s);
        c(s);
        l().add(new lf(b, s));
    }

    public void b(boolean flag)
    {
        c = flag;
    }

    public void c(String s)
    {
        s = android.support.v7.lf.a(s);
        ListIterator listiterator = l().listIterator();
        do
        {
            if (!listiterator.hasNext())
            {
                break;
            }
            if (s.equals(((wh)listiterator.next()).a()))
            {
                listiterator.remove();
            }
        } while (true);
    }

    r i()
    {
        return b;
    }

    public wb j()
    {
        wb wb1 = k().a();
        wb1.a(b.q().c());
        wb1.a(b.r().b());
        b(wb1);
        return wb1;
    }
}
