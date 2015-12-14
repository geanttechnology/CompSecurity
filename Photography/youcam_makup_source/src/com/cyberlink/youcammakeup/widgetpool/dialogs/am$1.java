// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.content.Intent;
import android.view.View;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.FacebookSharingActivity;
import com.cyberlink.youcammakeup.database.more.makeup.MakeupItemMetadata;
import com.cyberlink.youcammakeup.utility.cc;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            am

class a
    implements android.view.OnClickListener
{

    final am a;

    public void onClick(View view)
    {
        cc.a(a.d.u());
        view = new ArrayList();
        view.add(Globals.d().B());
        Globals.d().a(view);
        view = new Intent(a.getActivity(), com/cyberlink/youcammakeup/activity/FacebookSharingActivity);
        view.putExtra("unlock_key_id", a.d.u());
        a.startActivity(view);
        a.dismiss();
    }

    Activity(am am1)
    {
        a = am1;
        super();
    }
}
