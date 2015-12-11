// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;


// Referenced classes of package com.millennialmedia.android:
//            ad, u

final class b
{
    private final class a
    {

        int a;
        int b;
        final ad.a c;

        private a()
        {
            c = ad.a.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }


    int a;
    int b;
    u c;
    final ad d;

    final android.view.roup.LayoutParams a(android.view.roup.LayoutParams layoutparams)
    {
        layoutparams.width = c.a;
        layoutparams.height = c.b;
        return layoutparams;
    }

    final a a(int i, int j, int k, int l)
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
        a a1 = new a((byte)0);
        a1.a = i1 - i;
        a1.b = j1;
        return a1;
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

    a(ad ad1, u u1)
    {
        d = ad1;
        super();
        c = u1;
        a = u1.d;
        b = u1.e;
    }
}
