// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.view.View;
import android.widget.ArrayAdapter;
import com.picsart.studio.editor.item.TextItem;
import com.picsart.studio.editor.view.ItemEditorView;
import com.picsart.studio.view.WrappingListPopupWindow;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            q

final class a
    implements android.view.OnClickListener
{

    private q a;

    public final void onClick(View view)
    {
        view = q.a(a).h();
        if (view != null && (view instanceof TextItem))
        {
            if (((TextItem)view).g())
            {
                q.o(a).clear();
                q.o(a).add(a.getString(0x7f080135));
                q.o(a).add(a.getString(0x7f08013c));
            } else
            {
                q.o(a).clear();
                q.o(a).add(a.getString(0x7f080135));
                q.o(a).add(a.getString(0x7f08013c));
                q.o(a).add(a.getString(0x7f080136));
            }
        }
        q.n(a).show();
    }

    pWindow(q q1)
    {
        a = q1;
        super();
    }
}
