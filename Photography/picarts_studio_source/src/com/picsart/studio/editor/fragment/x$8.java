// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.view.View;
import com.picsart.studio.EditingData;
import com.picsart.studio.editor.EditorProject;
import com.picsart.studio.editor.c;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.history.RasterAction;
import com.picsart.studio.editor.view.StickerEditorView;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            x

final class a
    implements android.view..OnClickListener
{

    private x a;

    public final void onClick(View view)
    {
        e.a().e.d("sticker");
        view = x.a(a).f();
        if (view != null)
        {
            a.g.a(a, view, RasterAction.create(view, e.a().d.getHistoryDataDirectory()));
        }
    }

    rAction(x x1)
    {
        a = x1;
        super();
    }
}
