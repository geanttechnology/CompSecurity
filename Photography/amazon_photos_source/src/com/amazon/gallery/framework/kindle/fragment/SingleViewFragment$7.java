// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import android.support.v4.app.FragmentActivity;

// Referenced classes of package com.amazon.gallery.framework.kindle.fragment:
//            SingleViewFragment

class this._cls0
    implements uk.co.senab.photoview.caleChangeListener
{

    final SingleViewFragment this$0;

    public void onScaleChange(float f, float f1, float f2)
    {
        SingleViewFragment.access$1132(SingleViewFragment.this, f);
        if (SingleViewFragment.access$1100(SingleViewFragment.this) < 0.8F)
        {
            getActivity().onBackPressed();
        }
    }

    ()
    {
        this$0 = SingleViewFragment.this;
        super();
    }
}
