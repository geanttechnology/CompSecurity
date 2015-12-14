// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.app.Activity;
import android.view.View;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.database.more.makeup.MakeupItemMetadata;
import com.cyberlink.youcammakeup.kernelctrl.ShareActionProvider;
import com.cyberlink.youcammakeup.utility.al;
import com.cyberlink.youcammakeup.utility.cc;
import com.cyberlink.youcammakeup.utility.o;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            am

class a
    implements android.view.OnClickListener
{

    final am a;

    public void onClick(View view)
    {
        if (al.a("com.tencent.mm"))
        {
            cc.a(a.d.u());
            view = new ArrayList();
            view.add(Globals.d().B());
            ShareActionProvider.a(a.getActivity(), view, false);
            if (a.d.u() != null)
            {
                cc.c(a.d.u());
            }
            a.dismiss();
            return;
        } else
        {
            view = Globals.d().i();
            String s = a.getActivity().getString(0x7f070068);
            view.a(a.getActivity(), null, s, false);
            return;
        }
    }

    ovider(am am1)
    {
        a = am1;
        super();
    }
}
