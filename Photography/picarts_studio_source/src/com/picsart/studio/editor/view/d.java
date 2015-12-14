// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.view.MotionEvent;

// Referenced classes of package com.picsart.studio.editor.view:
//            CropEditorView

abstract class d
{

    protected final CropEditorView a;

    private d(CropEditorView cropeditorview)
    {
        a = cropeditorview;
    }

    d(CropEditorView cropeditorview, byte byte0)
    {
        this(cropeditorview);
    }

    public abstract CropEditorView.Response a(MotionEvent motionevent);

    protected final boolean a()
    {
        return CropEditorView.t(a) == this;
    }
}
