// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib;

import java.io.File;

// Referenced classes of package com.xfinity.playerlib:
//            PlayerAppUpgradeHelper, PlayerApplication

class this._cls0
    implements Runnable
{

    final PlayerAppUpgradeHelper this$0;

    public void run()
    {
        PlayerAppUpgradeHelper.access$000(PlayerAppUpgradeHelper.this).getFilesDir();
        (new File((new StringBuilder()).append(PlayerAppUpgradeHelper.access$000(PlayerAppUpgradeHelper.this).getFilesDir()).append("analyticsqueue").toString())).delete();
    }

    ()
    {
        this$0 = PlayerAppUpgradeHelper.this;
        super();
    }
}
