// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.widget.TabHost;

// Referenced classes of package com.poshmark.ui.fragments:
//            FeedMotherFragment

class hangeListener extends android.support.v4.view.eChangeListener
{

    final FeedMotherFragment this$0;

    public void onPageSelected(int i)
    {
        if (FeedMotherFragment.access$000(FeedMotherFragment.this).getCurrentTab() != i)
        {
            FeedMotherFragment.access$000(FeedMotherFragment.this).setCurrentTab(i);
            FeedMotherFragment.access$102(FeedMotherFragment.this, i);
        }
    }

    hangeListener()
    {
        this$0 = FeedMotherFragment.this;
        super();
    }
}
