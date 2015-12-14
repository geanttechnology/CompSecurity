// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.blemishfix;

import android.view.View;
import com.socialin.android.util.Utils;

// Referenced classes of package com.picsart.effects.blemishfix:
//            BlemishFixActivity, BlemishFixImageView

final class a
    implements android.view.mishFixActivity._cls5
{

    private BlemishFixActivity a;

    public final void onClick(View view)
    {
label0:
        {
            if (!a.isFinishing())
            {
                if (BlemishFixActivity.a(a).i)
                {
                    break label0;
                }
                BlemishFixActivity.a(a).setSaving(true);
                BlemishFixActivity.a(a).setProcessRuning(true);
                BlemishFixActivity.b(a);
            }
            return;
        }
        Utils.b(a, 0x7f080405);
    }

    _cls9(BlemishFixActivity blemishfixactivity)
    {
        a = blemishfixactivity;
        super();
    }
}
