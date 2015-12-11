// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.nav;

import com.amazon.mobile.mash.api.MASHNavigationPlugin;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.mobile.mash.nav:
//            MASHNavHandler, MASHNavBackHandler, MASHNavForwardHandler, MASHNavModalCloseHandler, 
//            MASHNavModalOpenHandler, MASHNavReplaceHandler

public abstract class MASHNavHandlerFactory
{
    public static class BackHandlerFactory extends MASHNavHandlerFactory
    {

        public MASHNavHandler createOperationHandler(MASHNavigationPlugin mashnavigationplugin, List list, int i)
        {
            return new MASHNavBackHandler(mashnavigationplugin, list, i);
        }

        public BackHandlerFactory()
        {
        }
    }

    public static class ForwardHandlerFactory extends MASHNavHandlerFactory
    {

        public MASHNavHandler createOperationHandler(MASHNavigationPlugin mashnavigationplugin, List list, int i)
        {
            return new MASHNavForwardHandler(mashnavigationplugin, list, i);
        }

        public ForwardHandlerFactory()
        {
        }
    }

    public static class ModalCloseHandlerFactory extends MASHNavHandlerFactory
    {

        public MASHNavHandler createOperationHandler(MASHNavigationPlugin mashnavigationplugin, List list, int i)
        {
            return new MASHNavModalCloseHandler(mashnavigationplugin, list, i);
        }

        public ModalCloseHandlerFactory()
        {
        }
    }

    public static class ModalOpenHandlerFactory extends MASHNavHandlerFactory
    {

        public MASHNavHandler createOperationHandler(MASHNavigationPlugin mashnavigationplugin, List list, int i)
        {
            return new MASHNavModalOpenHandler(mashnavigationplugin, list, i);
        }

        public ModalOpenHandlerFactory()
        {
        }
    }

    public static class ReplaceHandlerFactory extends MASHNavHandlerFactory
    {

        public MASHNavHandler createOperationHandler(MASHNavigationPlugin mashnavigationplugin, List list, int i)
        {
            return new MASHNavReplaceHandler(mashnavigationplugin, list, i);
        }

        public ReplaceHandlerFactory()
        {
        }
    }


    private static Map sNavHandlerFactoryMap = new HashMap();

    public MASHNavHandlerFactory()
    {
    }

    public static MASHNavHandlerFactory getMASHNavHandlerFactoryImpl(String s)
    {
        String s1 = s;
        if (s.startsWith("back"))
        {
            s1 = "back";
        }
        return (MASHNavHandlerFactory)sNavHandlerFactoryMap.get(s1);
    }

    public static void registerMap(String s, MASHNavHandlerFactory mashnavhandlerfactory)
    {
        sNavHandlerFactoryMap.put(s, mashnavhandlerfactory);
    }

    public abstract MASHNavHandler createOperationHandler(MASHNavigationPlugin mashnavigationplugin, List list, int i);

    static 
    {
        registerMap("back", new BackHandlerFactory());
        registerMap("forward", new ForwardHandlerFactory());
        registerMap("replace", new ReplaceHandlerFactory());
        registerMap("modalOpen", new ModalOpenHandlerFactory());
        registerMap("modalClose", new ModalCloseHandlerFactory());
    }
}
