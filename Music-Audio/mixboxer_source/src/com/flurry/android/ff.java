// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;
import android.os.Bundle;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.flurry.android:
//            ba, m, gl, ai, 
//            gj, aw, AdUnit, AdFrame, 
//            ct, FlurryAds, cw, ae, 
//            AdCreative, p

abstract class ff
    implements ba, m
{

    ff()
    {
    }

    protected abstract String O();

    protected abstract List P();

    protected abstract List Q();

    protected abstract List R();

    protected abstract List S();

    protected abstract List T();

    public final ae a(Context context, FlurryAds flurryads, cw cw, AdUnit adunit)
    {
        if (context == null || flurryads == null || cw == null || adunit == null)
        {
            return null;
        }
        Object obj = new gl(O(), P(), aj(), T(), Q());
        boolean flag;
        if (context == null || obj == null)
        {
            flag = false;
        } else
        {
            ai ai1 = new ai();
            if (ai1 == null)
            {
                flag = false;
            } else
            {
                flag = ai1.a(context, ((gl) (obj)));
            }
        }
        if (!flag)
        {
            return null;
        }
        obj = aw.l(context);
        if (obj == null)
        {
            return null;
        } else
        {
            return a(context, flurryads, cw, adunit, ((Bundle) (obj)));
        }
    }

    protected abstract ae a(Context context, FlurryAds flurryads, cw cw, AdUnit adunit, Bundle bundle);

    protected abstract p a(Context context, FlurryAds flurryads, cw cw, AdCreative adcreative, Bundle bundle);

    protected List aj()
    {
        return S();
    }

    protected List ak()
    {
        return S();
    }

    public final p b(Context context, FlurryAds flurryads, cw cw, AdUnit adunit)
    {
        if (context == null || flurryads == null || cw == null || adunit == null)
        {
            return null;
        }
        Object obj = new gl(O(), R(), ak(), T(), Collections.emptyList());
        boolean flag;
        if (context == null || obj == null)
        {
            flag = false;
        } else
        {
            ai ai1 = new ai();
            if (ai1 == null)
            {
                flag = false;
            } else
            {
                flag = ai1.a(context, ((gl) (obj)));
            }
        }
        if (!flag)
        {
            return null;
        }
        obj = aw.l(context);
        if (obj == null)
        {
            return null;
        }
        if (adunit == null)
        {
            adunit = null;
        } else
        {
            adunit = adunit.getAdFrames();
            if (adunit == null || adunit.isEmpty())
            {
                adunit = null;
            } else
            {
                adunit = (AdFrame)adunit.get(0);
                if (adunit == null)
                {
                    adunit = null;
                } else
                {
                    adunit = adunit.getAdSpaceLayout();
                    if (adunit == null)
                    {
                        adunit = null;
                    } else
                    {
                        adunit = ct.b(adunit);
                    }
                }
            }
        }
        if (adunit == null)
        {
            return null;
        } else
        {
            return a(context, flurryads, cw, adunit, ((Bundle) (obj)));
        }
    }
}
