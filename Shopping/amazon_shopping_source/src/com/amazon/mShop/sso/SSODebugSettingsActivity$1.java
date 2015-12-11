// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.sso;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.AppUtils;
import com.amazon.rio.j2me.client.persistence.DataStore;

// Referenced classes of package com.amazon.mShop.sso:
//            SSODebugSettingsActivity

class this._cls0
    implements android.view.ivity._cls1
{

    final SSODebugSettingsActivity this$0;

    public void onClick(View view)
    {
        view = ((RadioButton)SSODebugSettingsActivity.access$000(SSODebugSettingsActivity.this).findViewById(SSODebugSettingsActivity.access$000(SSODebugSettingsActivity.this).getCheckedRadioButtonId())).getText().toString();
        DataStore datastore = com.amazon.mShop.platform.e().getDataStore();
        datastore.putString("switchSSONonAuthForceSignIn", view);
        datastore.putString("accountPhoneNumber", ((RadioButton)SSODebugSettingsActivity.access$100(SSODebugSettingsActivity.this).findViewById(SSODebugSettingsActivity.access$100(SSODebugSettingsActivity.this).getCheckedRadioButtonId())).getText().toString());
        AppUtils.restartApp();
    }

    ()
    {
        this$0 = SSODebugSettingsActivity.this;
        super();
    }
}
