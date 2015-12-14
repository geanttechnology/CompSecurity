// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.widget.SeekBar;
import com.fotoable.beautyui.newui.MNewSofterFragment;

public class ve
    implements android.widget.SeekBar.OnSeekBarChangeListener
{

    final MNewSofterFragment a;

    public ve(MNewSofterFragment mnewsofterfragment)
    {
        a = mnewsofterfragment;
        super();
    }

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
    }

    public void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public void onStopTrackingTouch(SeekBar seekbar)
    {
        float f = (float)seekbar.getProgress() / 100F;
        if (MNewSofterFragment.e(a) != com.fotoable.beautyui.newui.MNewSofterFragment.SoftenState.Soften) goto _L2; else goto _L1
_L1:
        MNewSofterFragment.a(a, f);
_L4:
        MNewSofterFragment.f(a);
        return;
_L2:
        if (MNewSofterFragment.e(a) == com.fotoable.beautyui.newui.MNewSofterFragment.SoftenState.White)
        {
            MNewSofterFragment.b(a, f);
        } else
        if (MNewSofterFragment.e(a) == com.fotoable.beautyui.newui.MNewSofterFragment.SoftenState.Skin)
        {
            MNewSofterFragment.c(a, f);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
