// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.ui;

import android.view.View;
import android.view.ViewGroup;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;

// Referenced classes of package com.amazon.gallery.framework.kindle.ui:
//            NetworkIndicator

class this._cls1
    implements android.view.e.ui.NetworkIndicator._cls1._cls1
{

    final is._cls0 this$1;

    public void onClick(View view)
    {
        NetworkIndicator.access$102(_fld0, NetworkIndicator.access$300(_fld0).promptNoWifi(NetworkIndicator.access$200(_fld0)));
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/gallery/framework/kindle/ui/NetworkIndicator$1

/* anonymous class */
    class NetworkIndicator._cls1
        implements Runnable
    {

        final NetworkIndicator this$0;

        public void run()
        {
            NetworkIndicator.access$000(NetworkIndicator.this).setClickable(true);
            NetworkIndicator.access$000(NetworkIndicator.this).setOnClickListener(new NetworkIndicator._cls1._cls1());
            NetworkIndicator.access$000(NetworkIndicator.this).setVisibility(0);
        }

            
            {
                this$0 = NetworkIndicator.this;
                super();
            }
    }

}
