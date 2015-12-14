// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.rendering;

import com.inmobi.commons.core.utilities.Logger;

// Referenced classes of package com.inmobi.rendering:
//            RenderView, RenderingProperties

class a
    implements ity.b
{

    final RenderView a;

    public void a()
    {
        Logger.a(com.inmobi.commons.core.utilities.alLogLevel.INTERNAL, RenderView.q(), "onAdScreenDisplayed");
        if (erties.PlacementType.INLINE == RenderView.b(a).a())
        {
            if (RenderView.c(a) != null)
            {
                RenderView.c(a).setAndUpdateViewState(nderViewState.EXPANDED);
            } else
            {
                a.setAndUpdateViewState(nderViewState.EXPANDED);
            }
            RenderView.a(a, false);
        }
        if (RenderView.d(a) != null)
        {
            RenderView.d(a).e(a);
        }
    }

    public void b()
    {
        Logger.a(com.inmobi.commons.core.utilities.alLogLevel.INTERNAL, RenderView.q(), "onAdScreenDismissed");
        if (erties.PlacementType.INLINE != RenderView.b(a).a()) goto _L2; else goto _L1
_L1:
        a.setAndUpdateViewState(nderViewState.DEFAULT);
        if (RenderView.c(a) != null)
        {
            RenderView.c(a).setAndUpdateViewState(nderViewState.DEFAULT);
        }
_L4:
        if (RenderView.d(a) != null)
        {
            RenderView.d(a).f(a);
        }
        return;
_L2:
        if (nderViewState.DEFAULT == RenderView.e(a))
        {
            a.setAndUpdateViewState(nderViewState.HIDDEN);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    nderViewState(RenderView renderview)
    {
        a = renderview;
        super();
    }
}
