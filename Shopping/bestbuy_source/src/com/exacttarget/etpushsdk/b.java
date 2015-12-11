// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk;

import android.view.View;

// Referenced classes of package com.exacttarget.etpushsdk:
//            ETLandingPagePresenter

class b
    implements android.view.View.OnClickListener
{

    final ETLandingPagePresenter a;

    b(ETLandingPagePresenter etlandingpagepresenter)
    {
        a = etlandingpagepresenter;
        super();
    }

    public void onClick(View view)
    {
        a.finish();
    }
}
