// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;

// Referenced classes of package com.gotv.crackle:
//            MainActivity

private class <init>
    implements android.support.v7.app.
{

    final MainActivity this$0;

    public void onTabReselected(android.support.v7.app. , FragmentTransaction fragmenttransaction)
    {
    }

    public void onTabSelected(android.support.v7.app. , FragmentTransaction fragmenttransaction)
    {
        switch (.())
        {
        default:
            return;

        case 0: // '\0'
            MainActivity.access$200(MainActivity.this).setCurrentItem(.());
            MainActivity.access$302(MainActivity.this, com.gotv.crackle.base.);
            return;

        case 1: // '\001'
            MainActivity.access$200(MainActivity.this).setCurrentItem(.());
            MainActivity.access$302(MainActivity.this, com.gotv.crackle.base.ES);
            return;

        case 2: // '\002'
            MainActivity.access$200(MainActivity.this).setCurrentItem(.());
            MainActivity.access$302(MainActivity.this, com.gotv.crackle.base.S);
            return;

        case 3: // '\003'
            MainActivity.access$200(MainActivity.this).setCurrentItem(.());
            break;
        }
        MainActivity.access$302(MainActivity.this, com.gotv.crackle.base.HLISTS);
    }

    public void onTabUnselected(android.support.v7.app.LISTS lists, FragmentTransaction fragmenttransaction)
    {
    }

    private ()
    {
        this$0 = MainActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
