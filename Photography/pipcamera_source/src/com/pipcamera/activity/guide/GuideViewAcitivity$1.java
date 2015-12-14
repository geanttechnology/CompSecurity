// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.guide;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import kf;

// Referenced classes of package com.pipcamera.activity.guide:
//            GuideViewAcitivity

class a
    implements android.content.ckListener
{

    final GuideViewAcitivity a;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = a.getSharedPreferences((new StringBuilder()).append("isNeedGotoGuideView_").append(kf.a).toString(), 0).edit();
        dialoginterface.putBoolean("isGotoGuideView", true);
        dialoginterface.commit();
        a.finish();
    }

    (GuideViewAcitivity guideviewacitivity)
    {
        a = guideviewacitivity;
        super();
    }
}
