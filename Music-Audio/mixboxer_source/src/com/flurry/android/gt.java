// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;
import java.util.Map;

// Referenced classes of package com.flurry.android:
//            AdUnit, cw

final class gt
{

    final Context Q;
    final cw S;
    final AdUnit T;
    final Map bj;
    final String jf;
    final int jg;

    gt(String s, Map map, Context context, AdUnit adunit, cw cw, int i)
    {
        jf = s;
        bj = map;
        Q = context;
        T = adunit;
        S = cw;
        jg = i;
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("event=").append(jf);
        stringbuilder.append(",params=").append(bj);
        stringbuilder.append(",adspace=").append(T.getAdSpace());
        return stringbuilder.toString();
    }
}
