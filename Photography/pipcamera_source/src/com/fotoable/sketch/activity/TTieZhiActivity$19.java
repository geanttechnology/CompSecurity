// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.sketch.activity;

import android.widget.CompoundButton;
import com.pipcamera.application.PIPCameraApplication;
import la;

// Referenced classes of package com.fotoable.sketch.activity:
//            TTieZhiActivity

class a
    implements android.widget.eckedChangeListener
{

    final TTieZhiActivity a;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        if (flag)
        {
            la.a(PIPCameraApplication.a, "TTieZhiActivity", "TAG_BACKTIP", true);
            return;
        } else
        {
            la.a(PIPCameraApplication.a, "TTieZhiActivity", "TAG_BACKTIP", false);
            return;
        }
    }

    tener(TTieZhiActivity ttiezhiactivity)
    {
        a = ttiezhiactivity;
        super();
    }
}
