// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import android.graphics.Paint;
import com.socialin.android.brushlib.textart.DrawTextStyle;
import com.socialin.android.brushlib.view.DrawingView;
import com.socialin.android.photo.textart.TextArtStyle;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class e
    implements Runnable
{

    private String a;
    private Paint b;
    private Paint c;
    private DrawTextStyle d;
    private TextArtStyle e;
    private DrawingActivity f;

    public final void run()
    {
        DrawingActivity.b(f).setEditingMode(com.socialin.android.brushlib.view.Mode.TEXT);
        DrawingActivity.b(f).setTextParams(a, b, c, d, e);
        DrawingActivity.b(f).setCurrentColor(e.getFillColor());
        DrawingActivity.a(f, false, true);
    }

    (DrawingActivity drawingactivity, String s, Paint paint, Paint paint1, DrawTextStyle drawtextstyle, TextArtStyle textartstyle)
    {
        f = drawingactivity;
        a = s;
        b = paint;
        c = paint1;
        d = drawtextstyle;
        e = textartstyle;
        super();
    }
}
