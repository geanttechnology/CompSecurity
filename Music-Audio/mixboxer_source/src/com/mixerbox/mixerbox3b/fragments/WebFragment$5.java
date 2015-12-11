// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.fragments;

import android.content.Intent;
import android.view.View;
import com.flurry.android.FlurryAgent;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.mixerbox.mixerbox3b.fragments:
//            WebFragment

class this._cls0
    implements android.view.stener
{

    final WebFragment this$0;

    public void onClick(View view)
    {
        view = new HashMap();
        view.put("url", url);
        FlurryAgent.logEvent("action:share_web", view);
        view = new Intent("android.intent.action.SEND");
        view.setType("text/plain");
        view.putExtra("android.intent.extra.TEXT", url);
        startActivity(Intent.createChooser(view, null));
    }

    ()
    {
        this$0 = WebFragment.this;
        super();
    }
}
