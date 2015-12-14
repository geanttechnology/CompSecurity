// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import com.picsart.studio.editor.item.Item;
import com.picsart.studio.editor.item.SvgItem;
import com.picsart.studio.editor.view.h;
import com.socialin.android.photo.view.ColorPickerPreview;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            q

final class a
    implements h
{

    private q a;

    public final void a(Item item)
    {
        if (a.isAdded())
        {
            if (item == null)
            {
                q.l(a);
            } else
            {
                q.a(a, item);
                if (item.c())
                {
                    q.b(a).setColor(item.k());
                    if ((item instanceof SvgItem) && ((SvgItem)item).j)
                    {
                        q.b(a).a();
                        return;
                    }
                }
            }
        }
    }

    kerPreview(q q1)
    {
        a = q1;
        super();
    }
}
