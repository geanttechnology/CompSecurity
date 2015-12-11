// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.common;

import android.widget.ImageView;
import com.comcast.cim.cmasl.android.util.view.widget.ObservableScrollView;
import com.comcast.cim.cmasl.android.util.view.widget.OnObservableScrollChangedListener;

// Referenced classes of package com.comcast.cim.android.view.common:
//            AbstractMultiViewFragment

private class <init>
    implements OnObservableScrollChangedListener
{

    final AbstractMultiViewFragment this$0;

    public void onObservableScrollChanged(ObservableScrollView observablescrollview, int i, int j, int k, int l)
    {
label0:
        {
            if (shadowImage != null)
            {
                if (j != 0)
                {
                    break label0;
                }
                shadowImage.setVisibility(8);
            }
            return;
        }
        shadowImage.setVisibility(0);
    }

    private ()
    {
        this$0 = AbstractMultiViewFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
