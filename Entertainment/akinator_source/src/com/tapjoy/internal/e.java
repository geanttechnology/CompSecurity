// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;

public final class e extends Dialog
{

    private boolean a;

    public e(Context context)
    {
        super(context, 0x103000b);
        a = false;
        requestWindowFeature(1);
        getWindow().setBackgroundDrawableResource(0x106000d);
    }

    public final void a()
    {
        getWindow().setLayout(-1, -1);
    }

    public final void cancel()
    {
        a = true;
        super.cancel();
    }

    public final void show()
    {
        a = false;
        super.show();
    }
}
