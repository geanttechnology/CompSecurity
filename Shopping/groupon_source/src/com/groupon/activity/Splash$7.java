// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;

// Referenced classes of package com.groupon.activity:
//            Splash, IntentFactory

class this._cls0
    implements android.view.ickListener
{

    final Splash this$0;

    public void onClick(View view)
    {
        startActivity(Splash.access$400(Splash.this).newCountryOrDivisionSelector());
        Splash.access$500(Splash.this, false);
    }

    tory()
    {
        this$0 = Splash.this;
        super();
    }
}
