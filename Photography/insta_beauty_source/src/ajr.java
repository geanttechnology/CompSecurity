// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.widget.SeekBar;
import com.fotoable.fotoproedit.activity.font.FontShadowOutlineEditView;

public class ajr
    implements android.widget.SeekBar.OnSeekBarChangeListener
{

    final FontShadowOutlineEditView a;

    public ajr(FontShadowOutlineEditView fontshadowoutlineeditview)
    {
        a = fontshadowoutlineeditview;
        super();
    }

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        if (FontShadowOutlineEditView.access$000(a) != null && FontShadowOutlineEditView.access$100(a))
        {
            i /= 5;
            FontShadowOutlineEditView.access$000(a).b(i);
            return;
        } else
        {
            FontShadowOutlineEditView.access$102(a, true);
            return;
        }
    }

    public void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public void onStopTrackingTouch(SeekBar seekbar)
    {
        if (FontShadowOutlineEditView.access$000(a) != null)
        {
            FontShadowOutlineEditView.access$000(a).b();
        }
    }
}
