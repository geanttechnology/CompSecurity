// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;


// Referenced classes of package com.picsart.studio.editor.view:
//            CropEditorView

final class a
    implements Runnable
{

    private CropEditorView a;

    public final void run()
    {
        CropEditorView.g(a);
    }

    (CropEditorView cropeditorview)
    {
        a = cropeditorview;
        super();
    }
}
