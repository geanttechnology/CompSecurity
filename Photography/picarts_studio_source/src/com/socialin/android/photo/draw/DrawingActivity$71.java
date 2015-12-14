// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import android.view.View;
import com.picsart.studio.EditingData;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.brushlib.controller.a;
import com.socialin.android.brushlib.view.DrawingView;
import com.socialin.android.picsart.profile.invite.i;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class a
    implements android.view.r
{

    private DrawingActivity a;

    public final void onClick(View view)
    {
        if (a.showEnjoyDialog)
        {
            i.a(a, "close");
        }
        AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.oneEvent(DrawingActivity.Z(a).a, DrawingActivity.ac(a), DrawingActivity.b(a).g.b(), DrawingActivity.b(a).g.c(), "close", (System.nanoTime() - DrawingActivity.ad(a)) / 0x3b9aca00L));
        DrawingActivity.ae(a);
        a.executeInviteNotificaionAction();
        DrawingActivity.at(a);
        com.socialin.android.photo.draw.DrawingActivity.a(a, null, null);
    }

    wDoneEvent(DrawingActivity drawingactivity)
    {
        a = drawingactivity;
        super();
    }
}
