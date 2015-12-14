// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.widget.SeekBar;
import android.widget.TextView;
import com.picsart.studio.editor.view.BorderEditorView;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            d

final class a
    implements android.widget.Bar.OnSeekBarChangeListener
{

    private d a;

    public final void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        d.a(a).setCornerRadius(i);
        d.k(a).setText(a.getString(0x7f080101, new Object[] {
            Integer.valueOf(i)
        }));
    }

    public final void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public final void onStopTrackingTouch(SeekBar seekbar)
    {
    }

    itorView(d d1)
    {
        a = d1;
        super();
    }
}
