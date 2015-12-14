// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.font;

import android.widget.SeekBar;
import hc;

// Referenced classes of package com.fotoable.fotoproedit.activity.font:
//            FontKeyBoardBottomView

class a
    implements android.widget.stener
{

    final FontKeyBoardBottomView a;

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        if (FontKeyBoardBottomView.access$000(a) != null)
        {
            FontKeyBoardBottomView.access$000(a).e(i);
        }
    }

    public void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public void onStopTrackingTouch(SeekBar seekbar)
    {
    }

    (FontKeyBoardBottomView fontkeyboardbottomview)
    {
        a = fontkeyboardbottomview;
        super();
    }
}
