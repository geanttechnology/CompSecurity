// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;


// Referenced classes of package com.millennialmedia.android:
//            DTOResizeParameters, MMAdView

class b
{

    int a;
    int b;
    DTOResizeParameters c;
    final MMAdView d;

    final android.view. a(android.view. )
    {
        .width = c.a;
        .height = c.b;
        return ;
    }

    final BoundsResult a(int i, int j, int k, int l)
    {
        if (i + k + j <= l) goto _L2; else goto _L1
_L1:
        j += l - k;
        if (j >= 0) goto _L4; else goto _L3
_L3:
        int i1;
        int j1;
        i1 = 0;
        j1 = l;
_L6:
        class BoundsResult
        {

            int a;
            int b;

            private BoundsResult()
            {
            }

            BoundsResult(MMAdView.BannerBounds bannerbounds)
            {
                this();
            }
        }

        BoundsResult boundsresult = new BoundsResult(this);
        boundsresult.a = i1 - i;
        boundsresult.b = j1;
        return boundsresult;
_L4:
        i1 = j;
        j1 = k;
        if (j + k > l)
        {
            i1 = l - k;
            j1 = k;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        i1 = j;
        j1 = k;
        if (j <= 0)
        {
            i1 = i;
            j1 = k;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    BoundsResult(MMAdView mmadview, DTOResizeParameters dtoresizeparameters)
    {
        d = mmadview;
        super();
        c = dtoresizeparameters;
        a = dtoresizeparameters.d;
        b = dtoresizeparameters.e;
    }
}
