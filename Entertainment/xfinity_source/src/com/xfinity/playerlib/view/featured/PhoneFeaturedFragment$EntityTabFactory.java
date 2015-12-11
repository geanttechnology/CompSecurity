// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.featured;

import android.view.View;

// Referenced classes of package com.xfinity.playerlib.view.featured:
//            PhoneFeaturedFragment

private class <init>
    implements android.widget.ent.EntityTabFactory
{

    final PhoneFeaturedFragment this$0;

    public View createTabContent(String s)
    {
        s = new View(getActivity());
        s.setMinimumHeight(0);
        s.setMinimumWidth(0);
        return s;
    }

    private ()
    {
        this$0 = PhoneFeaturedFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
