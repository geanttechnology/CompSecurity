// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SeekBar;
import com.picsart.studio.editor.item.Item;
import com.picsart.studio.editor.item.LensFlareItem;
import com.picsart.studio.editor.view.ItemEditorView;
import com.socialin.android.apiv3.util.AnalyticUtils;
import java.util.List;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            q

final class a
    implements android.widget.terView.OnItemSelectedListener
{

    private q a;

    public final void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = q.a(a).h();
        if (adapterview != null)
        {
            adapterview.p = q.s(a);
            if (q.t(a) && (adapterview instanceof LensFlareItem))
            {
                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.tsFactory.ToolLensFlareTryEvent(q.c, "blending_select", q.r(a), a.h.getHeight(), a.h.getWidth(), ((LensFlareItem)q.a(a).h()).a(), q.j(a).getProgress(), q.i(a).getProgress(), 0));
            }
            q.a(a, adapterview, com.picsart.studio.editor.gizmo.o.Action.BLENDING_SELECT);
            adapterview.d(((Integer)q.u(a).get(i)).intValue());
            q.k(a);
        }
        q.v(a);
    }

    public final void onNothingSelected(AdapterView adapterview)
    {
    }

    ction(q q1)
    {
        a = q1;
        super();
    }
}
