// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.Dialog;
import android.view.View;

// Referenced classes of package com.groupon.fragment:
//            TermsConditionsFragment

class this._cls0
    implements android.view.gment._cls1
{

    final TermsConditionsFragment this$0;

    public void onClick(View view)
    {
        if (TermsConditionsFragment.access$000(TermsConditionsFragment.this) != null && isResumed())
        {
            TermsConditionsFragment.access$000(TermsConditionsFragment.this).onTermsConditionsAccepted();
        }
        getDialog().dismiss();
    }

    rmsConditionsListener()
    {
        this$0 = TermsConditionsFragment.this;
        super();
    }
}
