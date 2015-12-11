// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.extension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import tv.freewheel.hybrid.ad.AdContext;
import tv.freewheel.hybrid.extension.medialets.MedialetsExtension;
import tv.freewheel.hybrid.extension.pausead.PauseAdExtension;
import tv.freewheel.hybrid.utils.Logger;

// Referenced classes of package tv.freewheel.hybrid.extension:
//            IExtension

public class ExtensionManager
{

    public static Map EXTENSIONS;
    public static ArrayList internalExtensions;
    private static Logger logger = Logger.getLogger("ExtensionManager");

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
        EXTENSIONS.put("PauseAdExtension", tv/freewheel/hybrid/extension/pausead/PauseAdExtension);
        EXTENSIONS.put("MedialetsExtension", tv/freewheel/hybrid/extension/medialets/MedialetsExtension);
        internalExtensions = new ArrayList();
        internalExtensions.add("PauseAdExtension");
        internalExtensions.add("MedialetsExtension");
    }
}
