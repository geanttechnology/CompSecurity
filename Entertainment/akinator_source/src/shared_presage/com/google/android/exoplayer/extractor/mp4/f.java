// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.extractor.mp4;

import shared_presage.com.google.android.exoplayer.util.Assertions;

final class f
{

    public final int a;
    public final long b[];
    public final int c[];
    public final long d[];
    public final int e[];

    f(long al[], int ai[], long al1[], int ai1[])
    {
        boolean flag1 = true;
        super();
        boolean flag;
        if (ai.length == al1.length)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkArgument(flag);
        if (al.length == al1.length)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkArgument(flag);
        if (ai1.length == al1.length)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        Assertions.checkArgument(flag);
        b = al;
        c = ai;
        d = al1;
        e = ai1;
        a = al.length;
    }
}
