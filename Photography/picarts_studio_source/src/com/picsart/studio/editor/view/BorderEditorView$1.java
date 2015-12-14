// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.graphics.Bitmap;
import myobfuscated.bq.b;

// Referenced classes of package com.picsart.studio.editor.view:
//            BorderEditorView

final class a
    implements b
{

    private BorderEditorView a;

    public final int a(int i, int j)
    {
        return BorderEditorView.a(a).getPixel(Math.min(Math.max(i / 2, 0), BorderEditorView.a(a).getWidth() - 1), Math.min(Math.max(j / 2, 0), BorderEditorView.a(a).getHeight() - 1));
    }

    (BorderEditorView bordereditorview)
    {
        a = bordereditorview;
        super();
    }
}
