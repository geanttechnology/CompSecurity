// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import com.poshmark.fb_tmblr_twitter.ExtServiceConnectInterface;
import com.poshmark.http.api.PMApiError;
import com.poshmark.ui.model.ActionErrorContext;

// Referenced classes of package com.poshmark.ui.fragments:
//            FindPeopleFragment

class this._cls0
    implements ExtServiceConnectInterface
{

    final FindPeopleFragment this$0;

    public void error(PMApiError pmapierror)
    {
        hideProgressDialog();
        showError(new ActionErrorContext(pmapierror, com.poshmark.ui.model.tionContext.LINK_TWITTER));
    }

    public void success(int i, Bundle bundle)
    {
        hideProgressDialog();
        FindPeopleFragment.access$100(FindPeopleFragment.this);
    }

    Context()
    {
        this$0 = FindPeopleFragment.this;
        super();
    }
}
