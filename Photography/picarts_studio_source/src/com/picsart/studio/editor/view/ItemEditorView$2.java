// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import com.picsart.studio.editor.item.Item;

// Referenced classes of package com.picsart.studio.editor.view:
//            g, ItemEditorView

final class a
    implements g
{

    private ItemEditorView a;

    public final void a()
    {
        ItemEditorView.a(a);
        a.invalidate();
    }

    public final void a(Item item)
    {
        ItemEditorView.a(a);
        a.invalidate();
    }

    (ItemEditorView itemeditorview)
    {
        a = itemeditorview;
        super();
    }
}
