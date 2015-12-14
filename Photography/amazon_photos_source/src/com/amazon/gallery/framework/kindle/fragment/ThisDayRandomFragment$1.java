// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import com.amazon.gallery.thor.app.activity.ThisDayActivity;

// Referenced classes of package com.amazon.gallery.framework.kindle.fragment:
//            ThisDayRandomFragment

class this._cls0
    implements android.support.v4.widget.reshListener
{

    final ThisDayRandomFragment this$0;

    public void onRefresh()
    {
        ((ThisDayActivity)getActivity()).loadDataForCollection(2, true);
    }

    ()
    {
        this$0 = ThisDayRandomFragment.this;
        super();
    }
}
