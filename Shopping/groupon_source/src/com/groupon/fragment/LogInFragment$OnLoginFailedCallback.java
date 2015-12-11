// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.Activity;
import android.widget.Toast;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.CountryUtil;
import com.groupon.util.Function1;
import com.groupon.view.SpinnerButton;

// Referenced classes of package com.groupon.fragment:
//            LogInFragment

private class <init>
    implements Function1
{

    final LogInFragment this$0;

    public void execute(Exception exception)
    {
        submit.stopSpinning();
        Toast.makeText(getActivity().getApplicationContext(), getString(0x7f08017d, new Object[] {
            countryUtil.getDisplayNameByIsoName(currentCountryManager.getCurrentCountry())
        }), 1).show();
    }

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((Exception)obj);
    }

    private ger()
    {
        this$0 = LogInFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
