// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.videogenerator;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.socialin.android.apiv3.util.AnalyticUtils;

// Referenced classes of package com.socialin.android.videogenerator:
//            SaveAndShareDialogHandler

final class b
    implements android.view.ndShareDialogHandler._cls4
{

    private Context a;
    private Intent b;
    private SaveAndShareDialogHandler c;

    public final void onClick(View view)
    {
        a.startActivity(b);
        AnalyticUtils analyticutils = AnalyticUtils.getInstance(a);
        com.socialin.android.apiv3.events.oEvent oevent = (new com.socialin.android.apiv3.events.oEvent(c.r, c.t)).setDest("more");
        if (c.l)
        {
            view = diaType.GIF;
        } else
        {
            view = diaType.MPG;
        }
        analyticutils.track(oevent.setType(diaType.getType(view)));
    }

    diaType(SaveAndShareDialogHandler saveandsharedialoghandler, Context context, Intent intent)
    {
        c = saveandsharedialoghandler;
        a = context;
        b = intent;
        super();
    }
}
