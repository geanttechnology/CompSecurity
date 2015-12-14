// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effectnew;

import android.view.View;

// Referenced classes of package com.picsart.effectnew:
//            k, l

public final class a
    implements android.view..OnClickListener
{

    private k a;

    public final void onClick(View view)
    {
        if (a.a == null)
        {
            return;
        } else
        {
            a.a.f();
            return;
        }
    }

    public istener(k k1)
    {
        a = k1;
        super();
    }
}
