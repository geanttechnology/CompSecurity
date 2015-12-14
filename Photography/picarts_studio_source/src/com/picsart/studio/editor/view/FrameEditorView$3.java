// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import com.picsart.studio.editor.item.Item;
import com.picsart.studio.editor.item.SvgItem;
import com.picsart.studio.editor.item.d;

// Referenced classes of package com.picsart.studio.editor.view:
//            FrameEditorView

final class a
    implements d
{

    private FrameEditorView a;

    public final void a(Item item)
    {
        int i = item.n();
        if (i == 3 || i == 4 || i == 2 || i == 1 && (item instanceof SvgItem))
        {
            a.setLayerType(1, null);
            return;
        } else
        {
            a.setLayerType(2, null);
            return;
        }
    }

    (FrameEditorView frameeditorview)
    {
        a = frameeditorview;
        super();
    }
}
