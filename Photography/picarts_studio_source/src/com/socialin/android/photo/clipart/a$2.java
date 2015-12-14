// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.clipart;

import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import com.picsart.studio.editor.item.BrushEditableItem;

// Referenced classes of package com.socialin.android.photo.clipart:
//            a

final class a
    implements android.widget.Bar.OnSeekBarChangeListener
{

    private View a;
    private a b;

    public final void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        i = seekbar.getProgress();
        com.socialin.android.photo.clipart.a.a(b).f = i;
        ((TextView)a.findViewById(0x7f1001e3)).setText((new StringBuilder()).append(b.getString(0x7f080068)).append(" ").append(i).toString());
        com.socialin.android.photo.clipart.a.a(b, a, i);
    }

    public final void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public final void onStopTrackingTouch(SeekBar seekbar)
    {
        com.socialin.android.photo.clipart.a.a(b).f = seekbar.getProgress();
    }

    tableItem(a a1, View view)
    {
        b = a1;
        a = view;
        super();
    }
}
