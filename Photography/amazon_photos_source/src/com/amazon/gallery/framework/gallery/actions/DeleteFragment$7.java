// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import android.widget.CompoundButton;
import com.amazon.gallery.framework.gallery.metrics.EngagementMetrics;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;

// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            DeleteFragment

class this._cls0
    implements android.widget.CheckedChangeListener
{

    final DeleteFragment this$0;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        if (flag)
        {
            if (DeleteFragment.access$900(DeleteFragment.this).promptIfOffline(getActivity()))
            {
                compoundbutton.setChecked(false);
                return;
            }
            DeleteFragment.access$400(DeleteFragment.this).trackEvent(com.amazon.gallery.framework.gallery.metrics..MetricsEvent.CloudAlsoCheckboxSelected);
        }
        DeleteFragment.access$1002(DeleteFragment.this, flag);
    }

    ()
    {
        this$0 = DeleteFragment.this;
        super();
    }
}
