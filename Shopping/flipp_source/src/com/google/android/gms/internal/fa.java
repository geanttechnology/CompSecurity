// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            cd, ez

final class fa
    implements Runnable
{

    final cd a;
    final ez b;

    fa(ez ez, cd cd1)
    {
        b = ez;
        a = cd1;
        super();
    }

    public final void run()
    {
        a.h();
    }
}
