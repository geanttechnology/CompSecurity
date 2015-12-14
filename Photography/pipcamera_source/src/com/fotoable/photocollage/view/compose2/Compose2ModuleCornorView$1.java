// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photocollage.view.compose2;

import android.widget.SeekBar;
import ew;
import mf;

// Referenced classes of package com.fotoable.photocollage.view.compose2:
//            Compose2ModuleCornorView

class a
    implements android.widget.ener
{

    final Compose2ModuleCornorView a;

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        i = (int)((float)i / 3F);
        i = ew.a(a.getContext(), i);
        a.setRadius(i);
        if (a.listener != null)
        {
            a.listener.b(i);
        }
    }

    public void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public void onStopTrackingTouch(SeekBar seekbar)
    {
    }

    (Compose2ModuleCornorView compose2modulecornorview)
    {
        a = compose2modulecornorview;
        super();
    }
}
