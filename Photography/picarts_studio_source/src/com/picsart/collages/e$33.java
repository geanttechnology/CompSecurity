// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.collages;

import android.view.View;
import com.socialin.android.apiv3.util.AnalyticUtils;
import java.util.ArrayList;
import java.util.Random;

// Referenced classes of package com.picsart.collages:
//            e, CollageCreatorView

final class a
    implements android.view.OnClickListener
{

    private e a;

    public final void onClick(View view)
    {
        AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.sFactory.CollageCreateSecreenActionEvent(e.a(a), "shuffle"));
        view = e.b(a);
        int j = ((CollageCreatorView) (view)).b.size();
        Random random = new Random();
        for (int i = 0; i < j / 2 + j % 1; i++)
        {
            view.a(i, random.nextInt(j));
        }

        view.invalidate();
    }

    geCreatorView(e e1)
    {
        a = e1;
        super();
    }
}
