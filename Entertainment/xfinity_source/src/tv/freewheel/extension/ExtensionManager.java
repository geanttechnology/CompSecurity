// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.extension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
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
