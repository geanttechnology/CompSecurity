// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;

// Referenced classes of package com.groupon.activity:
//            AboutGroupon, IntentFactory

protected class this._cls0
    implements android.view.istener
{

    final AboutGroupon this$0;

    public void onClick(View view)
    {
        startActivity(AboutGroupon.access$000(AboutGroupon.this).newSimpleMarkUpActivity("internal:///privacypolicy"));
    }

    protected ()
    {
        this$0 = AboutGroupon.this;
        super();
    }
}
