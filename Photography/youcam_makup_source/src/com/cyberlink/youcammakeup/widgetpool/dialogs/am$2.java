// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.WeiboSharingActivity;
import com.cyberlink.youcammakeup.database.more.makeup.MakeupItemMetadata;
import com.cyberlink.youcammakeup.utility.al;
import com.cyberlink.youcammakeup.utility.cc;
import com.cyberlink.youcammakeup.utility.o;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            am

class a
    implements android.view.OnClickListener
{

    final am a;

    public void onClick(View view)
    {
        if (al.a("com.sina.weibo"))
        {
            cc.a(a.d.u());
            view = new Intent(a.getActivity(), com/cyberlink/youcammakeup/activity/WeiboSharingActivity);
            Bundle bundle = new Bundle();
            bundle.putString("mimeType", "image/*");
            bundle.putString("url", Globals.d().B().getPath());
            bundle.putString("unlock_key_id", a.d.u());
            view.putExtras(bundle);
            a.startActivity(view);
            a.dismiss();
            return;
        } else
        {
            view = Globals.d().i();
            String s = a.getActivity().getString(0x7f070069);
            view.a(a.getActivity(), null, s, false);
            return;
        }
    }

    ivity(am am1)
    {
        a = am1;
        super();
    }
}
