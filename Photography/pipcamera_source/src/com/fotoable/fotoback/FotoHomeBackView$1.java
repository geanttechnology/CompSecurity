// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoback;

import android.view.View;
import com.flurry.android.FlurryAgent;
import gg;

// Referenced classes of package com.fotoable.fotoback:
//            FotoHomeBackView

class a
    implements android.view.r
{

    final FotoHomeBackView a;

    public void onClick(View view)
    {
        if (FotoHomeBackView.access$000(a) != null)
        {
            FotoHomeBackView.access$000(a).a();
            FlurryAgent.logEvent("event_exitApp");
        }
    }

    (FotoHomeBackView fotohomebackview)
    {
        a = fotohomebackview;
        super();
    }
}
