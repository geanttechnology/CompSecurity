// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import com.picsart.studio.editor.helper.b;
import com.socialin.android.util.w;

// Referenced classes of package com.picsart.studio.editor.view:
//            EditorView, q

public class CurvesEditorView extends EditorView
    implements q
{

    private b i;

    public CurvesEditorView(Context context)
    {
        this(context, null);
    }

    public CurvesEditorView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public CurvesEditorView(Context context, AttributeSet attributeset, int j)
    {
        super(context, attributeset, j);
    }

    public static Bitmap a(Bitmap bitmap, int ai[], int ai1[], int ai2[], int ai3[])
    {
        Bitmap bitmap1 = bitmap.copy(android.graphics.Bitmap.Config.ARGB_8888, true);
        bitmap = new b(bitmap, bitmap1);
        bitmap.a(ai, ai1, ai2, ai3);
        bitmap.a();
        return bitmap1;
    }

    public final void a(int ai[], int ai1[], int ai2[], int ai3[])
    {
        if (i != null)
        {
            i.a(ai, ai1, ai2, ai3);
            invalidate();
        }
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (i != null)
        {
            i.a();
        }
    }

    public void setImage(Bitmap bitmap)
    {
        if (bitmap != null)
        {
            Bitmap bitmap1 = w.f(bitmap, 2048);
            Bitmap bitmap2 = bitmap1.copy(android.graphics.Bitmap.Config.ARGB_8888, true);
            i = new b(bitmap1, bitmap2);
            if (bitmap1 != bitmap)
            {
                bitmap1.recycle();
            }
            super.setImage(bitmap2);
        }
    }
}
