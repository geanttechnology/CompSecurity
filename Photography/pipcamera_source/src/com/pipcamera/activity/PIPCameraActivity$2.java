// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity;

import android.content.Intent;
import com.flurry.android.FlurryAgent;
import com.fotoable.adbuttonlib.TWebBrowActivity;
import com.fotoable.global.NewAlertDialogFragment;
import eh;
import java.util.HashMap;
import kd;

// Referenced classes of package com.pipcamera.activity:
//            PIPCameraActivity

class c
    implements kd
{

    final eh a;
    final HashMap b;
    final NewAlertDialogFragment c;
    final PIPCameraActivity d;

    public void a()
    {
        Intent intent = new Intent(d, com/fotoable/adbuttonlib/TWebBrowActivity);
        intent.putExtra("webUriString", a.d());
        d.startActivity(intent);
        FlurryAgent.logEvent("AlertAdClicked_New", b);
        c.dismiss();
    }

    public void b()
    {
        FlurryAgent.logEvent("AlertAdCanceled_New", b);
        c.dismiss();
    }

    (PIPCameraActivity pipcameraactivity, eh eh1, HashMap hashmap, NewAlertDialogFragment newalertdialogfragment)
    {
        d = pipcameraactivity;
        a = eh1;
        b = hashmap;
        c = newalertdialogfragment;
        super();
    }
}
