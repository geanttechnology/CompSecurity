// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.lib;

import com.flurry.android.FlurryAgent;
import com.fotoable.global.SimpleDialogFragment;
import java.util.HashMap;
import java.util.Map;
import ke;
import pb;

// Referenced classes of package com.instamag.activity.lib:
//            MagLibActivity

class a
    implements ke
{

    final MagLibActivity a;

    public void a()
    {
        if (a.e != null)
        {
            a.e.dismiss();
            a.e = null;
        }
        HashMap hashmap = new HashMap();
        if (pb.b())
        {
            hashmap.put("chinese", (new StringBuilder()).append("").append(a.c).toString());
        } else
        {
            hashmap.put("english", (new StringBuilder()).append("").append(a.c).toString());
        }
        FlurryAgent.logEvent("MagADResToWantuDownload", hashmap);
        a.d();
    }

    public void b()
    {
        if (a.e != null)
        {
            a.e.dismiss();
            a.e = null;
        }
    }

    (MagLibActivity maglibactivity)
    {
        a = maglibactivity;
        super();
    }
}
