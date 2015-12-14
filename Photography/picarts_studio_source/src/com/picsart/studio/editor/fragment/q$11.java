// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import com.picsart.studio.editor.item.Item;
import com.picsart.studio.editor.item.SvgItem;
import com.picsart.studio.editor.view.ItemEditorView;
import com.socialin.android.colorpicker.c;
import com.socialin.android.photo.view.ColorPickerPreview;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            q

final class a
    implements c
{

    private q a;

    public final void a(int i)
    {
        Item item = q.a(a).h();
        if (item != null)
        {
            item.b(item.l() << 24 | 0xffffff & i);
            if (item instanceof SvgItem)
            {
                ((SvgItem)item).q();
                q.a(a, item, com.picsart.studio.editor.gizmo..Action.COLOR_CHANGE);
            }
        }
        if (q.b(a) != null)
        {
            q.b(a).setColor(i);
        }
    }

    kerPreview(q q1)
    {
        a = q1;
        super();
    }
}
