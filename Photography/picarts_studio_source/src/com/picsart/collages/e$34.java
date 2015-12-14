// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.collages;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.photo.clipart.SelectClipArtFrameActivity;

// Referenced classes of package com.picsart.collages:
//            e, CollageCreatorView

final class a
    implements android.view.OnClickListener
{

    private e a;

    public final void onClick(View view)
    {
        AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.sFactory.CollageCreateSecreenActionEvent(e.a(a), "frame"));
        view = new Intent(a.getActivity().getApplicationContext(), com/socialin/android/photo/clipart/SelectClipArtFrameActivity);
        view.putExtra("category", "collage_frame");
        view.putExtra("readFrom", "collage_frame.json");
        view.putExtra("degrees", e.b(a).c());
        a.startActivityForResult(view, 1010);
    }

    geCreatorView(e e1)
    {
        a = e1;
        super();
    }
}
