// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.shop;

import android.app.Activity;
import android.widget.TextView;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.util.Utils;

// Referenced classes of package com.picsart.shop:
//            o

final class t>
    implements Runnable
{

    private o a;

    public final void run()
    {
        android.support.v4.app.FragmentActivity fragmentactivity = a.getActivity();
        TextView textview = o.b(a);
        float f1 = o.a(a) / 2;
        float f;
        if (SocialinV3.getInstance().isRegistered() && fragmentactivity != null && !fragmentactivity.isFinishing())
        {
            f = 0.0F;
        } else
        {
            f = Utils.a(24F, fragmentactivity);
        }
        textview.setTranslationY(f1 - f);
    }

    util.Utils(o o1)
    {
        a = o1;
        super();
    }
}
