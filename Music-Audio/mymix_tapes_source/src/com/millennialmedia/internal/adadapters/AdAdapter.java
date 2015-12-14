// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.adadapters;

import com.millennialmedia.InlineAd;
import com.millennialmedia.InterstitialAd;
import com.millennialmedia.MMLog;
import com.millennialmedia.NativeAd;
import com.millennialmedia.internal.AdMetadata;
import com.millennialmedia.internal.AdPlacement;
import com.millennialmedia.internal.adcontrollers.AdController;
import com.millennialmedia.internal.adcontrollers.LightboxController;
import com.millennialmedia.internal.adcontrollers.NativeController;
import com.millennialmedia.internal.adcontrollers.VASTVideoController;
import com.millennialmedia.internal.adcontrollers.WebController;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.millennialmedia.internal.adadapters:
//            MediatedAdAdapter, InlineLightboxAdapter, InterstitialVASTVideoAdapter, InlineWebAdapter, 
//            InterstitialWebAdapter, NativeNativeAdapter

public abstract class AdAdapter
{
    private static class AdapterRegistration
    {

        Class adAdapterClass;
        Class adControllerClass;
        Class adPlacementClass;

        AdapterRegistration(Class class1, Class class2, Class class3)
        {
            adPlacementClass = class1;
            adAdapterClass = class2;
            adControllerClass = class3;
        }
    }

    private static class MediatedAdapterRegistration
    {

        Class adAdapterClass;
        Class adPlacementClass;
        String mediationId;

        MediatedAdapterRegistration(String s, Class class1, Class class2)
        {
            mediationId = s;
            adPlacementClass = class1;
            adAdapterClass = class2;
        }
    }


    private static final String TAG = com/millennialmedia/internal/adadapters/AdAdapter.getSimpleName();
    private static List registeredAdapters = new ArrayList();
    private static List registeredMediatedAdapters = new ArrayList();
    protected String adContent;
    protected AdMetadata adMetadata;
    public int requestTimeout;

    public AdAdapter()
    {
        requestTimeout = 0;
    }

    public static AdAdapter getAdapterInstance(Class class1, Class class2)
    {
        Object obj;
        Object obj1 = null;
        Iterator iterator = registeredAdapters.iterator();
        do
        {
            obj = obj1;
            if (!iterator.hasNext())
            {
                break;
            }
            obj = (AdapterRegistration)iterator.next();
            boolean flag = ((AdapterRegistration) (obj)).adPlacementClass.equals(class1);
            boolean flag1 = ((AdapterRegistration) (obj)).adControllerClass.equals(class2);
            if (!flag || !flag1)
            {
                continue;
            }
            obj = ((AdapterRegistration) (obj)).adAdapterClass;
            break;
        } while (true);
        if (obj == null)
        {
            try
            {
                throw new Exception("Unable to find adapter class");
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                MMLog.e(TAG, (new StringBuilder()).append("Unable to create ad adapter instance for the placement type <").append(class1).append("> and ad controller type <").append(class2).append(">").toString(), ((Throwable) (obj)));
            }
            return null;
        }
        obj = (AdAdapter)((Class) (obj)).getConstructor(new Class[0]).newInstance(new Object[0]);
        return ((AdAdapter) (obj));
    }

    public static AdAdapter getMediatedAdapterInstance(String s, Class class1)
    {
        Object obj;
        Object obj1 = null;
        Iterator iterator = registeredMediatedAdapters.iterator();
        do
        {
            obj = obj1;
            if (!iterator.hasNext())
            {
                break;
            }
            obj = (MediatedAdapterRegistration)iterator.next();
            if (!((MediatedAdapterRegistration) (obj)).adPlacementClass.equals(class1) || !((MediatedAdapterRegistration) (obj)).mediationId.equals(s))
            {
                continue;
            }
            obj = ((MediatedAdapterRegistration) (obj)).adAdapterClass;
            break;
        } while (true);
        if (obj == null)
        {
            try
            {
                throw new Exception("Unable to find ad mediation adapter class");
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                MMLog.e(TAG, (new StringBuilder()).append("Unable to create ad mediation adapter instance for the placement type <").append(class1).append("> and mediation ID <").append(s).append(">").toString(), ((Throwable) (obj)));
            }
            return null;
        }
        obj = (AdAdapter)((Class) (obj)).getConstructor(new Class[0]).newInstance(new Object[0]);
        return ((AdAdapter) (obj));
    }

    public static void registerAdapter(Class class1, Class class2, Class class3)
    {
        if (!com/millennialmedia/internal/AdPlacement.isAssignableFrom(class1))
        {
            throw new IllegalArgumentException("Unable to register ad adapter, specified placement class is not an instance of AdPlacement");
        }
        if (!com/millennialmedia/internal/adadapters/AdAdapter.isAssignableFrom(class2))
        {
            throw new IllegalArgumentException("Unable to register ad adapter, specified adapter class is not an instance of AdAdapter");
        }
        if (!com/millennialmedia/internal/adcontrollers/AdController.isAssignableFrom(class3))
        {
            throw new IllegalArgumentException("Unable to register ad adapter, specified controller class is not an instance of AdController");
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Registering ad adapter <").append(class2).append("> for ad placement <").append(class1).append("> and ad controller <").append(class3).append(">").toString());
        }
        Iterator iterator = registeredAdapters.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            AdapterRegistration adapterregistration = (AdapterRegistration)iterator.next();
            if (adapterregistration.adPlacementClass == class1 && adapterregistration.adAdapterClass == class2 && adapterregistration.adControllerClass == class3)
            {
                iterator.remove();
            }
        } while (true);
        registeredAdapters.add(new AdapterRegistration(class1, class2, class3));
    }

    public static void registerMediatedAdapter(String s, Class class1, Class class2)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Unable to register mediation ad adapter, specified mediation ID cannot be null");
        }
        if (!com/millennialmedia/internal/AdPlacement.isAssignableFrom(class1))
        {
            throw new IllegalArgumentException("Unable to register mediation ad adapter, specified placement class is not an instance of AdPlacement");
        }
        if (!com/millennialmedia/internal/adadapters/AdAdapter.isAssignableFrom(class2))
        {
            throw new IllegalArgumentException("Unable to register mediated ad adapter, specified adapter class is not an instance of AdAdapter");
        }
        if (!com/millennialmedia/internal/adadapters/MediatedAdAdapter.isAssignableFrom(class2))
        {
            throw new IllegalArgumentException("Unable to register mediated ad adapter, specified adapter class does not implement MediatedAdAdapter");
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Registering ad adapter <").append(class2).append("> for mediation id <").append(s).append("> and ad placement <").append(class1).append(">").toString());
        }
        Iterator iterator = registeredMediatedAdapters.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            MediatedAdapterRegistration mediatedadapterregistration = (MediatedAdapterRegistration)iterator.next();
            if (mediatedadapterregistration.mediationId == s && mediatedadapterregistration.adPlacementClass == class1 && mediatedadapterregistration.adAdapterClass == class2)
            {
                iterator.remove();
            }
        } while (true);
        registeredMediatedAdapters.add(new MediatedAdapterRegistration(s, class1, class2));
    }

    public static void registerPackagedAdapters()
    {
        registerAdapter(com/millennialmedia/InlineAd, com/millennialmedia/internal/adadapters/InlineLightboxAdapter, com/millennialmedia/internal/adcontrollers/LightboxController);
        registerAdapter(com/millennialmedia/InterstitialAd, com/millennialmedia/internal/adadapters/InterstitialVASTVideoAdapter, com/millennialmedia/internal/adcontrollers/VASTVideoController);
        registerAdapter(com/millennialmedia/InlineAd, com/millennialmedia/internal/adadapters/InlineWebAdapter, com/millennialmedia/internal/adcontrollers/WebController);
        registerAdapter(com/millennialmedia/InterstitialAd, com/millennialmedia/internal/adadapters/InterstitialWebAdapter, com/millennialmedia/internal/adcontrollers/WebController);
        registerAdapter(com/millennialmedia/NativeAd, com/millennialmedia/internal/adadapters/NativeNativeAdapter, com/millennialmedia/internal/adcontrollers/NativeController);
    }

    public void setAdMetadata(AdMetadata admetadata)
    {
        adMetadata = admetadata;
    }

    public void setContent(String s)
    {
        adContent = s;
    }

}
