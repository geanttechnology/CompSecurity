// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.MotionEvent;
import android.view.View;
import com.groupon.util.SearchInterfaceProvider;

// Referenced classes of package com.groupon.fragment:
//            GlobalSearchFragment

class this._cls0
    implements android.view.gment._cls4
{

    final GlobalSearchFragment this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        GlobalSearchFragment.access$300(GlobalSearchFragment.this).clearFocus();
        return false;
    }

    ()
    {
        this$0 = GlobalSearchFragment.this;
        super();
    }
}
