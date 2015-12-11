// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia;

import android.view.View;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia:
//            n, af

public class a
    implements Runnable
{

    int a;
    final n b;

    public void run()
    {
        b.f.a(b.n, a, b.x);
        b.f.l().setVisibility(0);
    }

    public (n n1, int i)
    {
        b = n1;
        super();
        a = -1;
        a = i;
    }
}
