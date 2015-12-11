// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.helpshift:
//            SearchResultActivity, o

class a
    implements android.view.
{

    final SearchResultActivity a;

    public void onClick(View view)
    {
        o.a("taf");
        view = new Intent();
        view.putExtra("action", "startConversation");
        a.setResult(-1, view);
        a.finish();
    }

    (SearchResultActivity searchresultactivity)
    {
        a = searchresultactivity;
        super();
    }
}
