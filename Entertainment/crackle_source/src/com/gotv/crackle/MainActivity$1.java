// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.support.v7.app.ActionBar;

// Referenced classes of package com.gotv.crackle:
//            MainActivity

class this._cls0
    implements android.support.v4.view.eChangeListener
{

    final MainActivity this$0;

    public void onPageScrollStateChanged(int i)
    {
    }

    public void onPageScrolled(int i, float f, int j)
    {
    }

    public void onPageSelected(int i)
    {
        MainActivity.access$100(MainActivity.this).setSelectedNavigationItem(i);
    }

    ()
    {
        this$0 = MainActivity.this;
        super();
    }
}
