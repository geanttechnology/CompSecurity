// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.dagger;

import com.amazon.gallery.framework.kindle.amazon.NoWifiDialogFactory;
import com.amazon.gallery.framework.kindle.amazon.ScreenModeManager;
import com.amazon.gallery.framework.kindle.amazon.SoftkeyBarManagerFactory;

// Referenced classes of package com.amazon.gallery.thor.dagger:
//            ThorNoWifiDialogFactory, ThorScreenModeManager, ThorSoftkeyBarManagerFactory

public class AmazonDependencyProvider
{

    public AmazonDependencyProvider()
    {
    }

    public NoWifiDialogFactory provideNoWifiDialogFactory()
    {
        return new ThorNoWifiDialogFactory();
    }

    public ScreenModeManager provideScreenModeManager()
    {
        return new ThorScreenModeManager();
    }

    public SoftkeyBarManagerFactory provideSoftkeyBarManagerFactory()
    {
        return new ThorSoftkeyBarManagerFactory();
    }
}
