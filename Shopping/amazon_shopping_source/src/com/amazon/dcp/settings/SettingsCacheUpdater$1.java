// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dcp.settings;


// Referenced classes of package com.amazon.dcp.settings:
//            SettingsCacheUpdater

class 
    implements Runnable
{

    final SettingsCacheUpdater this$0;
    final  val$listener;

    public void run()
    {
        val$listener.onCacheUpdated();
    }

    ()
    {
        this$0 = final_settingscacheupdater;
        val$listener = .this;
        super();
    }
}
