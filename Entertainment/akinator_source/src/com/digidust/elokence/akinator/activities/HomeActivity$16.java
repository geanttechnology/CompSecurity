// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.content.DialogInterface;
import com.digidust.elokence.akinator.factories.AkConfigFactory;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            HomeActivity

class this._cls0
    implements android.content.OnClickListener
{

    final HomeActivity this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (i == 0)
        {
            AkConfigFactory.sharedInstance().setPlayWithCelebrities(true);
            AkConfigFactory.sharedInstance().setPlayWithMyworld(true);
        } else
        {
            if (i == 1)
            {
                AkConfigFactory.sharedInstance().setPlayWithCelebrities(true);
                AkConfigFactory.sharedInstance().setPlayWithMyworld(false);
                return;
            }
            if (i == 2)
            {
                AkConfigFactory.sharedInstance().setPlayWithCelebrities(false);
                AkConfigFactory.sharedInstance().setPlayWithMyworld(true);
                return;
            }
        }
    }

    ()
    {
        this$0 = HomeActivity.this;
        super();
    }
}
