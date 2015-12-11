// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.extension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import tv.freewheel.ad.AdContext;
import tv.freewheel.extension.blueKai.BlueKaiDataExtension;
import tv.freewheel.extension.medialets.MedialetsExtension;
import tv.freewheel.extension.pausead.PauseAdExtension;
import tv.freewheel.utils.Logger;

// Referenced classes of package tv.freewheel.extension:
//            IExtension

public class ExtensionManager
{

    public static Map EXTENSIONS;
    public static ArrayList internalExtensions;
    private static Logger logger = Logger.getLogger("ExtensionManager");

    public ExtensionManager()
    {
    }

    public static boolean hasExtensionLoaded(String s)
    {
        return true;
    }

    public static IExtension loadExtension(String s, AdContext adcontext)
        throws IllegalAccessException, InstantiationException
    {
        Object obj = (Class)EXTENSIONS.get(s);
        if (obj == null)
        {
            logger.error((new StringBuilder()).append("can not get extension class for name:").append(s).toString());
            return null;
        } else
        {
            obj = (IExtension)((Class) (obj)).newInstance();
            ((IExtension) (obj)).init(adcontext);
            adcontext.loadedExtensions.put(s, obj);
            return ((IExtension) (obj));
        }
    }

    public static void registerExtension(String s, Class class1)
    {
        EXTENSIONS.put(s, class1);
    }

    public static void unregisterAdContext(AdContext adcontext)
    {
        for (Iterator iterator = adcontext.loadedExtensions.keySet().iterator(); iterator.hasNext();)
        {
            String s = (String)iterator.next();
            IExtension iextension = (IExtension)adcontext.loadedExtensions.get(s);
            try
            {
                iextension.stop();
            }
            catch (Exception exception)
            {
                logger.warn((new StringBuilder()).append("Exception happened when stop ").append(s).toString());
            }
        }

        adcontext.loadedExtensions.clear();
    }

    static 
    {
        EXTENSIONS = Collections.synchronizedMap(new HashMap());
        EXTENSIONS.put("PauseAdExtension", tv/freewheel/extension/pausead/PauseAdExtension);
        EXTENSIONS.put("MedialetsExtension", tv/freewheel/extension/medialets/MedialetsExtension);
        EXTENSIONS.put("BlueKaiDataExtension", tv/freewheel/extension/blueKai/BlueKaiDataExtension);
        internalExtensions = new ArrayList();
        internalExtensions.add("PauseAdExtension");
        internalExtensions.add("MedialetsExtension");
        internalExtensions.add("BlueKaiDataExtension");
    }
}
