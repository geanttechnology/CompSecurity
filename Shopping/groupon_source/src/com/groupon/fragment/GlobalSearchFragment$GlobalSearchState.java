// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;


// Referenced classes of package com.groupon.fragment:
//            GlobalSearchFragment

protected class showTextOrLocationSearchResult
{

    private int currentMode;
    private boolean showTextOrLocationSearchResult;
    final GlobalSearchFragment this$0;

    public int getCurrentMode()
    {
        return currentMode;
    }

    public boolean isSearchModeLocationSearch()
    {
        return currentMode == 1;
    }

    public boolean isSearchModeTextSearch()
    {
        return currentMode == 0;
    }

    public void setCurrentMode(int i)
    {
        currentMode = i;
    }

    public void setShowTextOrLocationSearchResult(boolean flag)
    {
        if (showTextOrLocationSearchResult == flag)
        {
            return;
        }
        showTextOrLocationSearchResult = flag;
        if (GlobalSearchFragment.access$3400(GlobalSearchFragment.this))
        {
            GlobalSearchFragment.access$3402(GlobalSearchFragment.this, false);
            GlobalSearchFragment.access$3000(GlobalSearchFragment.this);
        }
        GlobalSearchFragment.access$3300(GlobalSearchFragment.this);
    }

    public void switchToSearchModeLocationSearch()
    {
        currentMode = 1;
        GlobalSearchFragment.access$3300(GlobalSearchFragment.this);
    }

    public void switchToSearchModeTextSearch()
    {
        currentMode = 0;
        GlobalSearchFragment.access$3300(GlobalSearchFragment.this);
    }


    public A()
    {
        this$0 = GlobalSearchFragment.this;
        super();
        currentMode = 0;
        showTextOrLocationSearchResult = false;
    }
}
