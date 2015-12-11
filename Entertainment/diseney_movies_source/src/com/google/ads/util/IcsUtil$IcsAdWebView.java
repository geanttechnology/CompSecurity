// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.util;

import com.google.ads.AdSize;
import com.google.ads.internal.ActivationOverlay;
import com.google.ads.internal.AdWebView;
import com.google.ads.n;

// Referenced classes of package com.google.ads.util:
//            IcsUtil

public static class  extends AdWebView
{

    public boolean canScrollHorizontally(int i)
    {
        if (a.e.a() != null)
        {
            return !((ActivationOverlay)a.e.a()).b();
        } else
        {
            return super.canScrollHorizontally(i);
        }
    }

    public boolean canScrollVertically(int i)
    {
        if (a.e.a() != null)
        {
            return !((ActivationOverlay)a.e.a()).b();
        } else
        {
            return super.canScrollVertically(i);
        }
    }

    public (n n1, AdSize adsize)
    {
        super(n1, adsize);
    }
}
