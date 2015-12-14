// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.view.View;
import com.picsart.studio.EditingData;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.view.FlipRotateEditorView;
import com.socialin.android.apiv3.util.AnalyticUtils;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            aa

final class a
    implements android.view.OnClickListener
{

    private aa a;

    public final void onClick(View view)
    {
        AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.sFactory.ToolFlipRotateTryEvent(e.a().e.a, "rotate_ccw"));
        aa.b(a).a(-90F);
    }

    eEditorView(aa aa1)
    {
        a = aa1;
        super();
    }
}
