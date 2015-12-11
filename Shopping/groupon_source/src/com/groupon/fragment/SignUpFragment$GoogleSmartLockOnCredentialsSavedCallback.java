// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import com.groupon.models.nst.ClickMetadata;
import com.groupon.models.nst.GoogleSmartLockExtraInfo;
import com.groupon.tracking.mobile.sdk.Logger;

// Referenced classes of package com.groupon.fragment:
//            SignUpFragment

private class <init>
    implements com.groupon.service.googlesmartlock.
{

    final SignUpFragment this$0;

    public void onCredentialSaveCompleted(boolean flag)
    {
        String s;
        ClickMetadata clickmetadata;
        if (flag)
        {
            s = "google_smartlock_save_credentials_save_click";
        } else
        {
            s = "google_smartlock_save_credentials_no_click";
        }
        clickmetadata = new ClickMetadata();
        clickmetadata.pageId = getClass().getSimpleName();
        logger.logClick("", s, SignUpFragment.access$800(SignUpFragment.this), clickmetadata, new GoogleSmartLockExtraInfo(trigger));
        SignUpFragment.access$900(SignUpFragment.this);
    }

    private allback()
    {
        this$0 = SignUpFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
