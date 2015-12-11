// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.KeyEvent;
import android.widget.TextView;

// Referenced classes of package com.groupon.fragment:
//            GlobalSearchFragment

class this._cls0
    implements android.widget.Listener
{

    final GlobalSearchFragment this$0;

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        if (i == 3)
        {
            GlobalSearchFragment.access$800(GlobalSearchFragment.this);
            return true;
        } else
        {
            return false;
        }
    }

    er()
    {
        this$0 = GlobalSearchFragment.this;
        super();
    }
}
