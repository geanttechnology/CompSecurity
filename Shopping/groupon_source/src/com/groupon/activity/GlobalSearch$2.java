// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.util.ViewUtils;

// Referenced classes of package com.groupon.activity:
//            GlobalSearch

class val.hideKeyboard
    implements Runnable
{

    final GlobalSearch this$0;
    final boolean val$hideKeyboard;

    public void run()
    {
        ViewUtils.setSoftKeyboardState(GlobalSearch.this, val$hideKeyboard, textSearchEditText);
    }

    ()
    {
        this$0 = final_globalsearch;
        val$hideKeyboard = Z.this;
        super();
    }
}
