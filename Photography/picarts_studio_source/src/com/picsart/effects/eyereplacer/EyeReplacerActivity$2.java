// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.eyereplacer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.view.View;
import com.socialin.android.util.Utils;
import java.nio.ByteBuffer;
import java.util.ArrayList;

// Referenced classes of package com.picsart.effects.eyereplacer:
//            EyeReplacerActivity, a, EyeReplaceImageView

final class a
    implements android.view.ReplacerActivity._cls2
{

    private EyeReplacerActivity a;

    public final void onClick(View view)
    {
        if (!EyeReplacerActivity.a(a).j) goto _L2; else goto _L1
_L1:
        Utils.b(a, 0x7f080405);
_L4:
        return;
_L2:
        Object obj = EyeReplacerActivity.c(a).b;
        if (obj == null || ((Bitmap) (obj)).isRecycled()) goto _L4; else goto _L3
_L3:
        obj = EyeReplacerActivity.a(a);
        if (((a) (obj)).g.size() <= 0) goto _L6; else goto _L5
_L5:
        ((a) (obj)).g.remove(((a) (obj)).g.size() - 1);
        ((a) (obj)).b.position(0);
        ((a) (obj)).d.copyPixelsFromBuffer(((a) (obj)).b);
        if (((a) (obj)).g.size() == 0) goto _L6; else goto _L7
_L7:
        boolean flag;
        PorterDuffXfermode porterduffxfermode = new PorterDuffXfermode(android.graphics.it>);
        ((a) (obj)).e.setXfermode(porterduffxfermode);
        ((a) (obj)).a(((a) (obj)).f, ((a) (obj)).e);
        porterduffxfermode = new PorterDuffXfermode(android.graphics.ER);
        ((a) (obj)).e.setXfermode(porterduffxfermode);
        ((a) (obj)).f.drawBitmap(((a) (obj)).c, 0.0F, 0.0F, ((a) (obj)).e);
        flag = true;
_L9:
        if (!flag)
        {
            view.setEnabled(false);
            a.findViewById(0x7f1004d4).setEnabled(false);
            a.findViewById(0x7f1004d2).setEnabled(false);
        }
        EyeReplacerActivity.c(a).invalidate();
        return;
_L6:
        flag = false;
        if (true) goto _L9; else goto _L8
_L8:
    }

    (EyeReplacerActivity eyereplaceractivity)
    {
        a = eyereplaceractivity;
        super();
    }
}
