// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import android.os.Bundle;
import com.flurry.android.AdCreative;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.flurry.sdk:
//            ef, eo, bi, r, 
//            ap, cr, hm, bh, 
//            bm, ec, en

public abstract class bj
    implements ef, eo
{

    public bj()
    {
    }

    protected Bundle a(Context context)
    {
        return c(context);
    }

    protected bi a()
    {
        return c();
    }

    protected abstract ec a(Context context, r r1, AdCreative adcreative, Bundle bundle);

    public en a(Context context, r r1)
    {
        if (context != null && r1 != null && a(context, d()))
        {
            Bundle bundle = a(context);
            if (bundle != null)
            {
                return a(context, r1, bundle);
            }
        }
        return null;
    }

    protected abstract en a(Context context, r r1, Bundle bundle);

    protected boolean a(Context context, bm bm1)
    {
        bi bi1;
        if (context != null && bm1 != null)
        {
            if ((bi1 = a()) != null)
            {
                return bi1.a(context, bm1);
            }
        }
        return false;
    }

    protected Bundle b(Context context)
    {
        return c(context);
    }

    protected bi b()
    {
        return c();
    }

    public ec b(Context context, r r1)
    {
        if (context != null && r1 != null && b(context, e()))
        {
            Bundle bundle = b(context);
            if (bundle != null)
            {
                AdCreative adcreative = cr.a(r1.k().a());
                if (adcreative != null)
                {
                    return a(context, r1, adcreative, bundle);
                }
            }
        }
        return null;
    }

    protected boolean b(Context context, bm bm1)
    {
        bi bi1;
        if (context != null && bm1 != null)
        {
            if ((bi1 = b()) != null)
            {
                return bi1.a(context, bm1);
            }
        }
        return false;
    }

    protected Bundle c(Context context)
    {
        return hm.d(context);
    }

    protected bi c()
    {
        return new bh();
    }

    protected bm d()
    {
        return new bm(f(), g(), h(), i(), j());
    }

    protected bm e()
    {
        return new bm(f(), k(), l(), m(), Collections.emptyList());
    }

    protected abstract String f();

    protected abstract List g();

    protected List h()
    {
        return n();
    }

    protected List i()
    {
        return o();
    }

    protected abstract List j();

    protected abstract List k();

    protected List l()
    {
        return n();
    }

    protected List m()
    {
        return o();
    }

    protected abstract List n();

    protected abstract List o();
}
