// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.blemishfix;

import android.graphics.Bitmap;
import android.view.View;
import com.socialin.android.util.Utils;
import java.nio.ByteBuffer;
import java.util.ArrayList;

// Referenced classes of package com.picsart.effects.blemishfix:
//            BlemishFixActivity, BlemishFixImageView

final class a
    implements android.view.mishFixActivity._cls6
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
                view = BlemishFixActivity.a(a);
                view.i = true;
                ((BlemishFixImageView) (view)).b.position(0);
                ((BlemishFixImageView) (view)).a.copyPixelsFromBuffer(((BlemishFixImageView) (view)).b);
                ((BlemishFixImageView) (view)).b.position(0);
                ((BlemishFixImageView) (view)).c.position(0);
                ((BlemishFixImageView) (view)).a.copyPixelsToBuffer(((BlemishFixImageView) (view)).c);
                ((BlemishFixImageView) (view)).c.position(0);
                ((BlemishFixImageView) (view)).h.clear();
                view.i = false;
                view.invalidate();
                a.a(false);
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
