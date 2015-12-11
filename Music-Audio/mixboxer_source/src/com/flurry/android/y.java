// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import java.util.Map;

// Referenced classes of package com.flurry.android:
//            gt

final class y
{

    final String bi;
    final Map bj;
    final gt bk;

    y(String s, Map map, gt gt)
    {
        bi = s;
        bj = map;
        bk = gt;
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("action=");
        stringbuilder.append(bi);
        stringbuilder.append(",params=");
        stringbuilder.append(bj);
        stringbuilder.append(",");
        stringbuilder.append(bk);
        return stringbuilder.toString();
    }
}
