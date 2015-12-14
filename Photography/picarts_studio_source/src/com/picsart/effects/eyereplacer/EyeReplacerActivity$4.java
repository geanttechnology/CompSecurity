// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.eyereplacer;

import android.graphics.Bitmap;
import android.view.View;
import com.socialin.android.util.Utils;
import java.nio.ByteBuffer;
import java.util.ArrayList;

// Referenced classes of package com.picsart.effects.eyereplacer:
//            EyeReplacerActivity, a, EyeReplaceImageView

final class a
    implements android.view.ReplacerActivity._cls4
{

    private EyeReplacerActivity a;

    public final void onClick(View view)
    {
        if (a.isFinishing())
        {
            return;
        }
        if (!EyeReplacerActivity.a(a).j)
        {
            a a1 = EyeReplacerActivity.a(a);
            a1.j = true;
            a1.g.clear();
            a1.b.position(0);
            a1.d.copyPixelsFromBuffer(a1.b);
            a1.j = false;
            EyeReplacerActivity.c(a).invalidate();
            view.setEnabled(false);
            a.findViewById(0x7f1004d3).setEnabled(false);
            a.findViewById(0x7f1004d4).setEnabled(false);
            return;
        } else
        {
            Utils.b(a, 0x7f080405);
            return;
        }
    }

    (EyeReplacerActivity eyereplaceractivity)
    {
        a = eyereplaceractivity;
        super();
    }
}
