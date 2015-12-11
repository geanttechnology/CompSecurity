// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.nav;

import com.amazon.mobile.mash.api.MASHNavigationPlugin;
import java.util.List;

// Referenced classes of package com.amazon.mobile.mash.nav:
//            MASHNavHandlerFactory, MASHNavReplaceHandler, MASHNavHandler

public static class  extends MASHNavHandlerFactory
{

    public MASHNavHandler createOperationHandler(MASHNavigationPlugin mashnavigationplugin, List list, int i)
    {
        return new MASHNavReplaceHandler(mashnavigationplugin, list, i);
    }

    public ()
    {
    }
}
