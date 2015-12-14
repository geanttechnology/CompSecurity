// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.view.View;
import android.widget.SeekBar;
import com.picsart.studio.editor.item.LensFlareItem;
import com.picsart.studio.editor.view.ItemEditorView;
import com.socialin.android.util.Utils;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            q

final class a
    implements android.view.reeObserver.OnGlobalLayoutListener
{

    private View a;
    private q b;

    public final void onGlobalLayout()
    {
        Utils.a(a, this);
        if (b.getArguments() != null && q.w(b) != null)
        {
            q.a(b, q.w(b), b.getArguments());
        }
        if (q.a(b).h() instanceof LensFlareItem)
        {
            q.i(b).getLayoutParams().width = q.j(b).getWidth();
        }
    }

    Item(q q1, View view)
    {
        b = q1;
        a = view;
        super();
    }
}
