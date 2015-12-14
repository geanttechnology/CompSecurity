// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;
import com.picsart.studio.editor.view.SvgCropView;
import com.socialin.android.util.ScaleRotateGestureDetector;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            z

final class a
    implements android.view..OnClickListener
{

    private z a;

    public final void onClick(View view)
    {
        view = z.a(a);
        Matrix matrix = ((SvgCropView) (view)).i.f;
        ((SvgCropView) (view)).j.set(((SvgCropView) (view)).g);
        matrix.mapRect(((SvgCropView) (view)).j);
        matrix.postRotate(10F, ((SvgCropView) (view)).j.centerX(), ((SvgCropView) (view)).j.centerY());
        view.invalidate();
    }

    stureDetector(z z1)
    {
        a = z1;
        super();
    }
}
