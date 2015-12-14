// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.view.MotionEvent;
import com.socialin.android.brushlib.input.gesture.d;

// Referenced classes of package com.picsart.studio.editor.view:
//            d, CropEditorView

final class e extends com.picsart.studio.editor.view.d
{

    public e(CropEditorView cropeditorview)
    {
        super(cropeditorview, (byte)0);
    }

    public final CropEditorView.Response a(MotionEvent motionevent)
    {
        CropEditorView.u(a).a(motionevent);
        if (motionevent.getActionMasked() == 1)
        {
            CropEditorView.a(a, false, true);
        }
        return CropEditorView.Response.ACCEPT;
    }
}
