// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device;

import android.widget.ProgressBar;

// Referenced classes of package com.amazon.identity.auth.device:
//            AuthPortalUIActivity

class val.progressBar
    implements Runnable
{

    final AuthPortalUIActivity this$0;
    final ProgressBar val$progressBar;

    public void run()
    {
        if (AuthPortalUIActivity.access$2700(AuthPortalUIActivity.this))
        {
            AuthPortalUIActivity.access$2800(AuthPortalUIActivity.this);
        }
        if (AuthPortalUIActivity.access$2900(AuthPortalUIActivity.this))
        {
            val$progressBar.setVisibility(4);
        }
    }

    ()
    {
        this$0 = final_authportaluiactivity;
        val$progressBar = ProgressBar.this;
        super();
    }
}
