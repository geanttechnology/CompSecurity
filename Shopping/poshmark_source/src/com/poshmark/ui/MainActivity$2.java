// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui;

import com.poshmark.ui.customviews.PMTabButton;

// Referenced classes of package com.poshmark.ui:
//            MainActivity

class this._cls0
    implements com.poshmark.ui.customviews.istener
{

    final MainActivity this$0;

    public void onTabSelected(PMTabButton pmtabbutton)
    {
        pmtabbutton.launchFragment(MainActivity.this);
        MainActivity.access$002(MainActivity.this, false);
        removeVisitedTabFromStack(pmtabbutton);
        currentTab = pmtabbutton;
        pmtabbutton.setSelected(true);
        currentActiveRootFragment = pmtabbutton.getFragment();
    }

    public void onTabUnselected(PMTabButton pmtabbutton)
    {
        pmtabbutton.hideFragment(MainActivity.this);
        pmtabbutton.setSelected(false);
        if (!MainActivity.access$000(MainActivity.this))
        {
            pushCurrentTabToStack();
        }
    }

    abButton()
    {
        this$0 = MainActivity.this;
        super();
    }
}
