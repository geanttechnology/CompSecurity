// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.adcontrollers;

import com.millennialmedia.MMLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.millennialmedia.internal.adcontrollers:
//            LightboxController, VASTVideoController, NativeController, WebController

public abstract class AdController
{

    private static final String TAG = com/millennialmedia/internal/adcontrollers/AdController.getSimpleName();
    private static List registeredControllers = new ArrayList();

    public AdController()
    {
    }

    public static Class getControllerClassForContent(String s)
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Attempting to get controller class for ad content.\n").append(s).toString());
        }
        Class class1 = null;
        Iterator iterator = registeredControllers.iterator();
        Object obj;
        do
        {
            obj = class1;
            if (!iterator.hasNext())
            {
                break;
            }
            obj = (AdController)iterator.next();
            if (!((AdController) (obj)).canHandleContent(s))
            {
                continue;
            }
            class1 = obj.getClass();
            obj = class1;
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(TAG, (new StringBuilder()).append("Found controller class <").append(class1.getName()).append("> for ad content").toString());
                obj = class1;
            }
            break;
        } while (true);
        if (obj == null)
        {
            MMLog.e(TAG, (new StringBuilder()).append("Unable to find AdController for content <").append(s).append(">").toString());
        }
        return ((Class) (obj));
    }

    public static void registerController(AdController adcontroller)
    {
        if (adcontroller == null)
        {
            throw new IllegalArgumentException("Unable to register ad controller, specified controller cannot be null");
        }
        if (registeredControllers.contains(adcontroller))
        {
            MMLog.w(TAG, (new StringBuilder()).append("Ad controller <").append(adcontroller.getClass()).append("> already registered").toString());
            return;
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Registering ad controller <").append(adcontroller.getClass()).append(">").toString());
        }
        registeredControllers.add(adcontroller);
    }

    public static void registerPackagedControllers()
    {
        registerController(new LightboxController());
        registerController(new VASTVideoController());
        registerController(new NativeController());
        registerController(new WebController());
    }

    public abstract boolean canHandleContent(String s);

}
