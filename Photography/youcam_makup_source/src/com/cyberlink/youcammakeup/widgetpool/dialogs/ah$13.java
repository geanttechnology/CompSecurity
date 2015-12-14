// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.cyberlink.youcammakeup.activity.LauncherActivity;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            ah

class a
    implements android.view.nClickListener
{

    final ah a;

    public void onClick(View view)
    {
        view = (new Intent(a.getActivity(), com/cyberlink/youcammakeup/activity/LauncherActivity)).setFlags(0x4000000);
        a.startActivity(view);
        a.getActivity().finish();
    }

    (ah ah1)
    {
        a = ah1;
        super();
    }
}
