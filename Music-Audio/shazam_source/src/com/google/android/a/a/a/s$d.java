// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.a.a.a;

import android.os.Handler;
import android.os.IBinder;

// Referenced classes of package com.google.android.a.a.a:
//            s

protected final class <init> extends <init>
{

    final s a;

    public final void a(String s1, IBinder ibinder)
    {
        a.a.sendMessage(a.a.obtainMessage(1, new <init>(a, s1, ibinder)));
    }

    protected (s s1)
    {
        a = s1;
        super();
    }
}
