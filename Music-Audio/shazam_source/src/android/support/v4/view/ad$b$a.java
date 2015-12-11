// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;

// Referenced classes of package android.support.v4.view:
//            ah, ad, w

static final class a
    implements ah
{

    ad a;

    public final void a(View view)
    {
        if (ad.d(a) >= 0)
        {
            w.a(view, 2, null);
        }
        if (ad.a(a) != null)
        {
            ad.a(a).run();
        }
        Object obj = view.getTag(0x7e000000);
        if (obj instanceof ah)
        {
            obj = (ah)obj;
        } else
        {
            obj = null;
        }
        if (obj != null)
        {
            ((ah) (obj)).a(view);
        }
    }

    public final void b(View view)
    {
        if (ad.d(a) >= 0)
        {
            w.a(view, ad.d(a), null);
            ad.c(a);
        }
        if (ad.b(a) != null)
        {
            ad.b(a).run();
        }
        Object obj = view.getTag(0x7e000000);
        if (obj instanceof ah)
        {
            obj = (ah)obj;
        } else
        {
            obj = null;
        }
        if (obj != null)
        {
            ((ah) (obj)).b(view);
        }
    }

    public final void c(View view)
    {
        Object obj = view.getTag(0x7e000000);
        if (obj instanceof ah)
        {
            obj = (ah)obj;
        } else
        {
            obj = null;
        }
        if (obj != null)
        {
            ((ah) (obj)).c(view);
        }
    }

    (ad ad1)
    {
        a = ad1;
    }
}
