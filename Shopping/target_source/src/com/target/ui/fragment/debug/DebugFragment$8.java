// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.debug;

import android.os.Process;

// Referenced classes of package com.target.ui.fragment.debug:
//            DebugFragment

class this._cls0
    implements Runnable
{

    final DebugFragment this$0;

    public void run()
    {
        Process.killProcess(Process.myPid());
    }

    ()
    {
        this$0 = DebugFragment.this;
        super();
    }
}
