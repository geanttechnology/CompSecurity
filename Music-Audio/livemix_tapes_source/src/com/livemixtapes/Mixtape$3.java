// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.content.Intent;
import android.view.View;
import java.util.Map;

// Referenced classes of package com.livemixtapes:
//            Mixtape

class this._cls0
    implements android.view.ckListener
{

    final Mixtape this$0;

    public void onClick(View view)
    {
        view = new Intent("android.intent.action.SEND");
        view.setType("text/plain");
        view.putExtra("android.intent.extra.SUBJECT", (String)mixtape.get("title"));
        view.putExtra("android.intent.extra.TEXT", (String)mixtape.get("sharetext"));
        startActivity(Intent.createChooser(view, "Share using"));
    }

    stener()
    {
        this$0 = Mixtape.this;
        super();
    }
}
