// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.collages;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.socialin.android.apiv3.util.AnalyticUtils;

// Referenced classes of package com.picsart.collages:
//            e, SelectCollageActivity, CollageCreatorView

final class a
    implements android.view.OnClickListener
{

    private e a;

    public final void onClick(View view)
    {
        AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.sFactory.CollageCreateSecreenActionEvent(e.a(a), "grid"));
        view = a.getActivity();
        if (view != null && !view.isFinishing())
        {
            view = new Intent(view, com/picsart/collages/SelectCollageActivity);
            view.putExtra("degrees", e.b(a).c());
            view.putExtra("from", "collage");
            view.putExtra("session_id", e.a(a));
            a.startActivityForResult(view, 1006);
        }
    }

    geCreatorView(e e1)
    {
        a = e1;
        super();
    }
}
