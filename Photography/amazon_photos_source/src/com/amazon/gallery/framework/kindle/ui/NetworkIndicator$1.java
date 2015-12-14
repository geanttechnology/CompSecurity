// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.ui;

import android.view.View;
import android.view.ViewGroup;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;

// Referenced classes of package com.amazon.gallery.framework.kindle.ui:
//            NetworkIndicator

class this._cls0
    implements Runnable
{

    final NetworkIndicator this$0;

    public void run()
    {
        NetworkIndicator.access$000(NetworkIndicator.this).setClickable(true);
        NetworkIndicator.access$000(NetworkIndicator.this).setOnClickListener(new android.view.View.OnClickListener() {

            final NetworkIndicator._cls1 this$1;

            public void onClick(View view)
            {
                NetworkIndicator.access$102(this$0, NetworkIndicator.access$300(this$0).promptNoWifi(NetworkIndicator.access$200(this$0)));
            }

            
            {
                this$1 = NetworkIndicator._cls1.this;
                super();
            }
        });
        NetworkIndicator.access$000(NetworkIndicator.this).setVisibility(0);
    }

    _cls1.this._cls1()
    {
        this$0 = NetworkIndicator.this;
        super();
    }
}
