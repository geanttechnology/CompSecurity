// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.orca.nux;

import android.view.View;

// Referenced classes of package com.facebook.orca.nux:
//            SmsNuxDetailActivity

class j
    implements android.view.View.OnClickListener
{

    final SmsNuxDetailActivity a;

    j(SmsNuxDetailActivity smsnuxdetailactivity)
    {
        a = smsnuxdetailactivity;
        super();
    }

    public void onClick(View view)
    {
        SmsNuxDetailActivity.a(a);
    }
}
