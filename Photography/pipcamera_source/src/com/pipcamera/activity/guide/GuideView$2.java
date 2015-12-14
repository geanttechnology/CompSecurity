// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.guide;

import android.view.View;
import sk;

// Referenced classes of package com.pipcamera.activity.guide:
//            GuideView

class a
    implements android.view.Listener
{

    final GuideView a;

    public void onClick(View view)
    {
        if (a.lisener != null)
        {
            a.lisener.a();
        }
    }

    (GuideView guideview)
    {
        a = guideview;
        super();
    }
}
