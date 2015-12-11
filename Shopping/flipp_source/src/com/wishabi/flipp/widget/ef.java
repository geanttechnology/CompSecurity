// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;


// Referenced classes of package com.wishabi.flipp.widget:
//            ed

final class ef
    implements ed
{

    int a[];
    int b[];

    private ef()
    {
    }

    ef(byte byte0)
    {
        this();
    }

    public final int a(int i)
    {
        return a[i % a.length];
    }

    public final int b(int i)
    {
        return b[i % b.length];
    }
}
