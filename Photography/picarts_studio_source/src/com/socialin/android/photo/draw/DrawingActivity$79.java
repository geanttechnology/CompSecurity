// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import android.graphics.Bitmap;
import com.socialin.android.brushlib.view.DrawingView;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class a
    implements Runnable
{

    private Bitmap a;
    private DrawingActivity b;

    public final void run()
    {
        DrawingActivity.b(b).setEditingMode(com.socialin.android.brushlib.view.Mode.PHOTO);
        DrawingActivity.b(b).setImageForAddPhotoMode(a, null);
    }

    ingMode(DrawingActivity drawingactivity, Bitmap bitmap)
    {
        b = drawingactivity;
        a = bitmap;
        super();
    }
}
