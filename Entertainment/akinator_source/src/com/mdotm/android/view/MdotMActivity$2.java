// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mdotm.android.view;

import java.util.TimerTask;

// Referenced classes of package com.mdotm.android.view:
//            MdotMActivity

class this._cls0 extends TimerTask
{

    final MdotMActivity this$0;

    public void run()
    {
    /* block-local class not found */
    class _cls1 {}

        runOnUiThread(new _cls1());
    }


    _cls1()
    {
        this$0 = MdotMActivity.this;
        super();
    }
}
