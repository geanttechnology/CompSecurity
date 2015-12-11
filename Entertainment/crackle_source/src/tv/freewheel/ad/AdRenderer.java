// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.ad;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.w3c.dom.Element;
import tv.freewheel.renderers.html.HTMLRenderer;
import tv.freewheel.renderers.interfaces.IRenderer;
import tv.freewheel.renderers.nullnull.NullAdRenderer;
import tv.freewheel.renderers.temporal.VideoRenderer;
import tv.freewheel.renderers.test.TestRenderer;
import tv.freewheel.renderers.vast.VastTranslator;
import tv.freewheel.utils.Logger;

// Referenced classes of package tv.freewheel.ad:
//            ParametersHolder, AdContext

public class AdRenderer extends ParametersHolder
{

    private static Map RENDERERS;
    private static Logger logger = Logger.getLogger("AdRenderer");
    protected HashSet adUnit;
    protected HashSet contentType;
    protected HashSet creativeApi;
    public String name;
    private Class rendererClass;
    protected HashSet slotType;
    protected HashSet soAdUnit;
    public String url;

    public AdRenderer(AdContext adcontext)
    {
        super(adcontext);
        rendererClass = null;
    }

    public AdRenderer(AdContext adcontext, String s, String s1, String s2, String s3, String s4, String s5, 
            String s6, HashMap hashmap)
    {
        this(adcontext);
        contentType = parseFromCommaString(s3);
        slotType = parseFromCommaString(s4);
        adUnit = parseFromCommaString(s1);
        creativeApi = parseFromCommaString(s5);
        soAdUnit = parseFromCommaString(s2);
        name = s6;
        url = s;
        if (hashmap != null)
        {
            parameters = hashmap;
        }
    }

    public static IRenderer getRenderer(AdRenderer adrenderer)
        throws InstantiationException, IllegalAccessException
    {
        String s;
        String s1;
        Object obj;
        String s2;
        logger.debug((new StringBuilder()).append("getRenderer for url ").append(adrenderer.url).toString());
        if (adrenderer.rendererClass != null)
        {
            return (IRenderer)adrenderer.rendererClass.newInstance();
        }
        s2 = adrenderer.name;
        obj = null;
        s1 = obj;
        s = s2;
        if (adrenderer.url == null) goto _L2; else goto _L1
_L1:
        if (!adrenderer.url.startsWith("http") && !adrenderer.url.startsWith("https")) goto _L4; else goto _L3
_L3:
        int i = adrenderer.url.lastIndexOf('/');
        s1 = obj;
        s = s2;
        if (i >= 0)
        {
            s2 = adrenderer.url.substring(i + 1);
            i = s2.indexOf(".fpk");
            s1 = obj;
            s = s2;
            if (i >= 0)
            {
                s = s2.substring(0, i);
                s1 = obj;
            }
        }
_L2:
        if (s == null)
        {
            logger.error((new StringBuilder()).append("Unknown renderer URL ").append(adrenderer.url).append(", should be the format class://com.example.myClassName").toString());
            return null;
        }
        break; /* Loop/switch isn't completed */
_L4:
        s1 = obj;
        s = s2;
        if (adrenderer.url.startsWith("class://"))
        {
            s1 = adrenderer.url.substring(8);
            int j = s1.lastIndexOf('.');
            if (j >= 0)
            {
                s = s1.substring(j + 1);
            } else
            {
                s = s1;
            }
        }
        if (true) goto _L2; else goto _L5
_L5:
        Class class2 = (Class)RENDERERS.get(s);
        Class class1 = class2;
        if (class2 == null)
        {
            if (s1 == null)
            {
                logger.error((new StringBuilder()).append("Can not find registered renderer class for name ").append(s).toString());
                return null;
            }
            try
            {
                class1 = Class.forName(s1);
            }
            // Misplaced declaration of an exception variable
            catch (AdRenderer adrenderer)
            {
                logger.error((new StringBuilder()).append("Failed to load class ").append(s1).toString());
                return null;
            }
        }
        adrenderer.rendererClass = class1;
        return (IRenderer)class1.newInstance();
    }

    private HashSet parseFromCommaString(String s)
    {
        HashSet hashset = new HashSet();
        if (s != null && s.length() > 0)
        {
            Collections.addAll(hashset, s.toLowerCase().split(","));
        }
        return hashset;
    }

    public static void registerRenderer(String s, Class class1)
    {
        RENDERERS.put(s, class1);
    }

    public boolean isTranslator()
    {
        return url != null && url.toLowerCase().contains("translator");
    }

    public boolean match(String s, String s1, String s2, String s3, String s4, String s5)
    {
        boolean flag;
        if (s5 == null || s5.equals(""))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            s2 = s5;
        }
        if (adUnit.size() == 0 || adUnit.contains(s.toLowerCase()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag && (soAdUnit.size() == 0 || soAdUnit.contains(s1.toLowerCase())))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag && (contentType.size() == 0 || contentType.contains(s2.toLowerCase())))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag && (slotType.size() == 0 || slotType.contains(s3.toLowerCase())))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag && (creativeApi.size() == 0 || creativeApi.contains(s4.toLowerCase()));
    }

    public void parse(Element element)
    {
        contentType = parseFromCommaString(element.getAttribute("contentType"));
        slotType = parseFromCommaString(element.getAttribute("slotType"));
        adUnit = parseFromCommaString(element.getAttribute("adUnit"));
        creativeApi = parseFromCommaString(element.getAttribute("creativeApi"));
        soAdUnit = parseFromCommaString(element.getAttribute("soAdUnit"));
        url = element.getAttribute("url");
        name = element.getAttribute("name");
        parseRendererParameters(element);
    }

    static 
    {
        RENDERERS = Collections.synchronizedMap(new HashMap());
        RENDERERS.put("null/null", tv/freewheel/renderers/nullnull/NullAdRenderer);
        RENDERERS.put("test/ad", tv/freewheel/renderers/test/TestRenderer);
        RENDERERS.put("VideoRenderer", tv/freewheel/renderers/temporal/VideoRenderer);
        RENDERERS.put("HTMLRenderer", tv/freewheel/renderers/html/HTMLRenderer);
        RENDERERS.put("VastTranslator", tv/freewheel/renderers/vast/VastTranslator);
    }
}
