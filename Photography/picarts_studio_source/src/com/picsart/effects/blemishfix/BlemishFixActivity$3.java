// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.blemishfix;

import android.widget.RadioGroup;

// Referenced classes of package com.picsart.effects.blemishfix:
//            BlemishFixActivity, BlemishFixImageView

final class a
    implements android.widget.hangeListener
{

    private BlemishFixActivity a;

    public final void onCheckedChanged(RadioGroup radiogroup, int i)
    {
        a.b = true;
        if (i == 0x7f1001b1)
        {
            BlemishFixActivity.a(a).setBlemishfixMethod(1);
            return;
        } else
        {
            BlemishFixActivity.a(a).setBlemishfixMethod(2);
            return;
        }
    }

    _cls9(BlemishFixActivity blemishfixactivity)
    {
        a = blemishfixactivity;
        super();
    }
}
