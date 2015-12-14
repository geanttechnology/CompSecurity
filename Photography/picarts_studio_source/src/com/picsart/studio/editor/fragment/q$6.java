// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.widget.SeekBar;
import com.picsart.studio.editor.item.TextItem;
import com.picsart.studio.editor.view.ItemEditorView;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            q

final class a
    implements android.widget.Bar.OnSeekBarChangeListener
{

    private q a;

    public final void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        if (!flag) goto _L2; else goto _L1
_L1:
        seekbar = q.a(a).h();
        if (seekbar == null || !(seekbar instanceof TextItem)) goto _L2; else goto _L3
_L3:
        seekbar = (TextItem)seekbar;
        seekbar.e = i;
        i = seekbar.p();
        seekbar.h = Math.abs(i);
        if (((TextItem) (seekbar)).h == 360)
        {
            seekbar.h = 359;
        }
        if (i > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        seekbar.g = flag;
        if (((TextItem) (seekbar)).h != 0) goto _L5; else goto _L4
_L4:
        seekbar.f = false;
        if (((TextItem) (seekbar)).c != null)
        {
            seekbar.a(((TextItem) (seekbar)).c);
            seekbar.c = null;
        }
_L7:
        seekbar.h();
        seekbar.q();
        seekbar.f();
        seekbar.o();
_L2:
        return;
_L5:
        seekbar.f = true;
        if (((TextItem) (seekbar)).b.contains("\n"))
        {
            seekbar.a(((TextItem) (seekbar)).b);
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    public final void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public final void onStopTrackingTouch(SeekBar seekbar)
    {
    }

    (q q1)
    {
        a = q1;
        super();
    }
}
