// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.view.View;
import android.widget.TextView;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.thor.app.ThorGalleryApplication;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            SignInActivity

class this._cls0
    implements android.view.er
{

    final SignInActivity this$0;

    public void onClick(View view)
    {
        if (!((NetworkConnectivity)ThorGalleryApplication.getBean(Keys.NETWORK_CONNECTIVITY)).isNetworkConnected())
        {
            SignInActivity.access$1700(SignInActivity.this).setVisibility(4);
            SignInActivity.access$1800(SignInActivity.this).setText(getString(0x7f0e0054));
            SignInActivity.access$1800(SignInActivity.this).setVisibility(0);
            return;
        } else
        {
            SignInActivity.access$1900(SignInActivity.this);
            return;
        }
    }

    rkConnectivity()
    {
        this$0 = SignInActivity.this;
        super();
    }
}
