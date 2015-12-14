// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.widget.SeekBar;
import com.fotoable.fotoproedit.activity.font.FontKeyBoardBottomView;

public class aji
    implements android.widget.SeekBar.OnSeekBarChangeListener
{

    final FontKeyBoardBottomView a;

    public aji(FontKeyBoardBottomView fontkeyboardbottomview)
    {
        a = fontkeyboardbottomview;
        super();
    }

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
}
