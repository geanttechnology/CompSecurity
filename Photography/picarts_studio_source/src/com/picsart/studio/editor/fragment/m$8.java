// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.view.View;
import com.picsart.studio.EditingData;
import com.picsart.studio.utils.TimeCalculator;
import com.socialin.android.apiv3.util.AnalyticUtils;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            m

final class a
    implements android.view..OnClickListener
{

    private m a;

    public final void onClick(View view)
    {
        AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.tsFactory.ToolFreeCropCloseEvent(m.d(a).a, "cancel", (int)m.e(a).d()));
        m.f(a);
    }

    (m m1)
    {
        a = m1;
        super();
    }
}
