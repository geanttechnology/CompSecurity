// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.graphics.Bitmap;
import myobfuscated.bq.b;

// Referenced classes of package com.picsart.studio.editor.view:
//            ItemEditorView

final class a
    implements b
{

    private ItemEditorView a;

    public final int a(int i, int j)
    {
        return com.picsart.studio.editor.view.ItemEditorView.b(a).getPixel(Math.min(Math.max(i / 2, 0), com.picsart.studio.editor.view.ItemEditorView.b(a).getWidth() - 1), Math.min(Math.max(j / 2, 0), com.picsart.studio.editor.view.ItemEditorView.b(a).getHeight() - 1));
    }

    (ItemEditorView itemeditorview)
    {
        a = itemeditorview;
        super();
    }
}
