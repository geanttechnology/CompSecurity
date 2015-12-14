// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photocollage.view.compose2;

import android.widget.CompoundButton;
import mf;

// Referenced classes of package com.fotoable.photocollage.view.compose2:
//            Compose2ModuleCornorView

class a
    implements android.widget.ngeListener
{

    final Compose2ModuleCornorView a;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        if (a.listener != null)
        {
            a.listener.d(flag);
        }
    }

    (Compose2ModuleCornorView compose2modulecornorview)
    {
        a = compose2modulecornorview;
        super();
    }
}
