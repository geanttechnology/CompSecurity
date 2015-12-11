// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.widget.ImageView;
import java.util.Iterator;
import java.util.List;

public final class byc
{

    final ImageView a;
    private final blu b;
    private final blr c;
    private final byd d;
    private btu e;
    private btt f;

    public byc(blu blu1, ImageView imageview)
    {
        this(blu1, ((blr) (new bls(imageview.getContext()))), imageview, false);
    }

    private byc(blu blu1, blr blr1, ImageView imageview, boolean flag)
    {
        b = (blu)b.a(blu1);
        c = (blr)b.a(blr1);
        a = (ImageView)b.a(imageview);
        d = new byd(this, true);
    }

    public final void a(int i)
    {
        byd.a(d);
        e = null;
        f = null;
        a.setImageResource(i);
    }

    void a(blt blt)
    {
        Object obj;
        btt btt1;
        int k;
        int l;
        boolean flag1 = true;
        if (e == null)
        {
            return;
        }
        k = a.getWidth();
        l = a.getHeight();
        if (k == 0 || l == 0)
        {
            byd.a(d, blt);
            return;
        }
        obj = e;
        boolean flag;
        if (k >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.a(flag);
        if (l >= 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        b.a(flag);
        if (((btu) (obj)).a()) goto _L2; else goto _L1
_L1:
        btt1 = null;
_L4:
        if (btt1 == null || !btt1.equals(f))
        {
            f = btt1;
            Iterator iterator;
            int i;
            int j;
            int i1;
            if (f != null)
            {
                obj = f.a;
                bln.a(b, c, ((android.net.Uri) (obj)), a, blt);
            } else
            {
                a.setImageDrawable(null);
            }
        }
        byd.a(d);
        return;
_L2:
        iterator = ((btu) (obj)).a.iterator();
        i = 0;
        obj = null;
_L5:
        btt1 = ((btt) (obj));
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        btt1 = (btt)iterator.next();
        j = k - btt1.b;
        i1 = l - btt1.c;
        j = j * j + i1 * i1;
        if (obj == null || j < i)
        {
            obj = btt1;
            i = j;
        }
          goto _L5
    }

    public final void a(btu btu1, blt blt)
    {
        if (btu1 != e)
        {
            e = btu1;
            f = null;
            a.setImageDrawable(null);
            byd.a(d);
        }
        if (btu1 == null || !btu1.a())
        {
            return;
        }
        if (a.isLayoutRequested())
        {
            byd.a(d, blt);
            return;
        } else
        {
            a(blt);
            return;
        }
    }
}
