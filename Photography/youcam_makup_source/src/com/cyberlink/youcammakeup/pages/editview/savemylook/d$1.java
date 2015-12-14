// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.editview.savemylook;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.cyberlink.youcammakeup.activity.WebViewerExActivity;
import com.perfectcorp.utility.u;

// Referenced classes of package com.cyberlink.youcammakeup.pages.editview.savemylook:
//            d

class a
    implements android.view..OnClickListener
{

    final d a;

    public void onClick(View view)
    {
        Object obj = new u(d.a(a).toString());
        ((u) (obj)).a("SourceType", "feature_room");
        String s;
        try
        {
            obj = Uri.parse(((u) (obj)).c());
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view.printStackTrace();
            return;
        }
        s = ((Uri) (obj)).getScheme();
        if (s != null && s.equalsIgnoreCase(a.getContext().getString(0x7f070742)))
        {
            obj = new Intent("android.intent.action.VIEW", ((Uri) (obj)));
            view.getContext().startActivity(((Intent) (obj)));
            return;
        } else
        {
            Intent intent = new Intent(a.getContext(), com/cyberlink/youcammakeup/activity/WebViewerExActivity);
            intent.putExtra("RedirectUrl", d.a(a).toString());
            view.getContext().startActivity(intent);
            return;
        }
    }

    (d d1)
    {
        a = d1;
        super();
    }
}
