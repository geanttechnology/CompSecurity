// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.widget.SeekBar;
import android.widget.TextView;
import com.picsart.studio.editor.view.FrameEditorView;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            l

final class a
    implements android.widget.Bar.OnSeekBarChangeListener
{

    private l a;

    public final void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        l.a(a).setOverlayOpacity(i);
        l.e(a).setText(a.getString(0x7f0804be, new Object[] {
            Integer.valueOf(i)
        }));
    }

    public final void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public final void onStopTrackingTouch(SeekBar seekbar)
    {
    }

    torView(l l1)
    {
        a = l1;
        super();
    }
}
