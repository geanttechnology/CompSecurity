// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push.iam.view;

import android.view.View;

// Referenced classes of package com.urbanairship.push.iam.view:
//            BannerContent

class this._cls0
    implements android.view.ener
{

    final BannerContent this$0;

    public void onClick(View view)
    {
        if (BannerContent.access$000(BannerContent.this) != null)
        {
            BannerContent.access$000(BannerContent.this).onDismissClick();
        }
    }

    ClickListener()
    {
        this$0 = BannerContent.this;
        super();
    }
}
