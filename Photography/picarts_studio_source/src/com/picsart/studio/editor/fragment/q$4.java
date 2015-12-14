// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.graphics.Bitmap;
import android.widget.SeekBar;
import com.picsart.studio.editor.item.Item;
import com.picsart.studio.editor.item.LensFlareItem;
import com.picsart.studio.editor.view.ItemEditorView;
import com.socialin.android.apiv3.util.AnalyticUtils;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            q

final class a
    implements android.widget.Bar.OnSeekBarChangeListener
{

    private q a;

    public final void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        if (flag)
        {
            seekbar = q.a(a).h();
            if (seekbar != null)
            {
                seekbar.c(i);
            }
        }
    }

    public final void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public final void onStopTrackingTouch(SeekBar seekbar)
    {
        seekbar = q.a(a).h();
        if (seekbar instanceof LensFlareItem)
        {
            AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.tsFactory.ToolLensFlareTryEvent(q.c, "opacity_slide", q.r(a), a.h.getHeight(), a.h.getWidth(), ((LensFlareItem)q.a(a).h()).a(), q.j(a).getProgress(), q.i(a).getProgress(), 0));
            return;
        } else
        {
            q.a(a, seekbar, com.picsart.studio.editor.gizmo.o.Action.OPACITY_SLIDE);
            return;
        }
    }

    ction(q q1)
    {
        a = q1;
        super();
    }
}
