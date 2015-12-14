// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.widget.RadioGroup;
import com.picsart.studio.editor.item.TextItem;
import com.picsart.studio.editor.view.ItemEditorView;
import com.picsart.studio.view.WrappingListPopupWindow;
import com.socialin.android.photo.draw.dialog.c;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            q

final class a
    implements c
{

    private q a;

    public final void onCheckedChanged(RadioGroup radiogroup, int i)
    {
label0:
        {
            radiogroup = q.a(a).h();
            if (radiogroup instanceof TextItem)
            {
                if (i != 0x7f1005b1)
                {
                    break label0;
                }
                ((TextItem)radiogroup).a(false);
                q.n(a).setAdapter(q.m(a));
            }
            return;
        }
        ((TextItem)radiogroup).a(true);
        q.n(a).setAdapter(q.o(a));
    }

    pWindow(q q1)
    {
        a = q1;
        super();
    }
}
