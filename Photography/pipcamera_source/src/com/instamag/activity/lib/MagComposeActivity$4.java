// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.lib;

import com.flurry.android.FlurryAgent;
import com.fotoable.global.SimpleDialogFragment;
import ke;

// Referenced classes of package com.instamag.activity.lib:
//            MagComposeActivity

class a
    implements ke
{

    final MagComposeActivity a;

    public void a()
    {
        if (a.k != null)
        {
            a.k.dismiss();
            a.k = null;
        }
        FlurryAgent.logEvent("MagADBtnToWantuDownload");
        a.q();
    }

    public void b()
    {
        if (a.k != null)
        {
            a.k.dismiss();
            a.k = null;
        }
    }

    (MagComposeActivity magcomposeactivity)
    {
        a = magcomposeactivity;
        super();
    }
}
