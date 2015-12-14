// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.util;

import android.view.View;
import myobfuscated.cr.f;

public final class i
    implements android.view.View.OnClickListener
{

    private boolean a;
    private f b;

    public i(boolean flag, f f1)
    {
        a = flag;
        b = f1;
        super();
    }

    public final void onClick(View view)
    {
        if (a)
        {
            b.j();
            return;
        } else
        {
            b.a(true, true);
            return;
        }
    }
}
