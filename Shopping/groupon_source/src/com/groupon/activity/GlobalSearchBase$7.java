// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.util.ViewUtils;

// Referenced classes of package com.groupon.activity:
//            GlobalSearchBase

class this._cls0
    implements Runnable
{

    final GlobalSearchBase this$0;

    public void run()
    {
        ViewUtils.setSoftKeyboardState(getApplicationContext(), false, textSearchEditText);
    }

    ()
    {
        this$0 = GlobalSearchBase.this;
        super();
    }
}
