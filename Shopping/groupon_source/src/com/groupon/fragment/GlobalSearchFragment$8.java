// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.KeyEvent;
import android.view.View;

// Referenced classes of package com.groupon.fragment:
//            GlobalSearchFragment

class this._cls0
    implements android.view.gment._cls8
{

    final GlobalSearchFragment this$0;

    public boolean onKey(View view, int i, KeyEvent keyevent)
    {
        if (i == 66)
        {
            GlobalSearchFragment.access$800(GlobalSearchFragment.this);
            return true;
        } else
        {
            return false;
        }
    }

    ()
    {
        this$0 = GlobalSearchFragment.this;
        super();
    }
}
