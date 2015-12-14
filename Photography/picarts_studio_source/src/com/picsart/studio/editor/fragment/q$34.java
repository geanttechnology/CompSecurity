// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.widget.SeekBar;
import android.widget.TextView;
import com.picsart.studio.editor.item.Item;
import com.picsart.studio.editor.item.LensFlareItem;
import com.picsart.studio.editor.item.TextItem;
import com.picsart.studio.editor.view.ItemEditorView;
import com.picsart.studio.editor.view.g;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            q

final class a
    implements g
{

    private q a;

    public final void a()
    {
        if (a.isAdded())
        {
            q.k(a);
        }
    }

    public final void a(Item item)
    {
        if (a.isAdded())
        {
            q.e(a);
            if (q.a(a).h() == item)
            {
                q.f(a).setText(a.getString(0x7f0804bf, new Object[] {
                    Integer.valueOf((item.l() * 100) / 255)
                }));
                if (item instanceof TextItem)
                {
                    int i = ((TextItem)item).p();
                    TextView textview = com.picsart.studio.editor.fragment.q.g(a);
                    q q1 = a;
                    String s;
                    if (i > 0)
                    {
                        s = (new StringBuilder("+")).append(i).toString();
                    } else
                    {
                        s = String.valueOf(i);
                    }
                    textview.setText(q1.getString(0x7f08067a, new Object[] {
                        s
                    }));
                }
                if (item instanceof LensFlareItem)
                {
                    q.h(a).setText(a.getString(0x7f08038a, new Object[] {
                        Integer.valueOf(((LensFlareItem)item).h)
                    }));
                    q.i(a).getLayoutParams().width = q.j(a).getWidth();
                }
            }
        }
    }

    Item(q q1)
    {
        a = q1;
        super();
    }
}
