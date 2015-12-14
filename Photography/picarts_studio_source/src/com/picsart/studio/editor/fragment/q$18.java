// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.view.View;
import com.picsart.studio.editor.item.BrushEditableItem;
import com.picsart.studio.editor.view.ItemEditorView;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            q

final class a
    implements android.view.OnClickListener
{

    private BrushEditableItem a;
    private q b;

    public final void onClick(View view)
    {
        view = a;
        view.d = ((BrushEditableItem) (view)).d - 1;
        view.g_();
        q.e(b);
        q.a(b).invalidate();
    }

    ableItem(q q1, BrushEditableItem brusheditableitem)
    {
        b = q1;
        a = brusheditableitem;
        super();
    }
}
