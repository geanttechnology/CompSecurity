// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.ad;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import tv.freewheel.hybrid.utils.Logger;

// Referenced classes of package tv.freewheel.hybrid.ad:
//            AdContext, AdRequest, AdResponse

public class AdContextScoped
{

    protected AdContext context;
    protected Logger logger;

    public AdContextScoped(AdContext adcontext)
    {
        logger = Logger.getLogger(this, true);
        context = adcontext;
    }

    public static String getTextNodeValue(Node node)
    {
        node = node.getChildNodes();
        for (int i = 0; i < node.getLength(); i++)
        {
            String s = node.item(i).getNodeValue();
            if (!s.trim().equals(""))
            {
                return s;
            }
        }

        return "";
    }

    public static boolean tryParseBoolean(String s, boolean flag)
    {
        if (s == null || s == "")
        {
            return flag;
        } else
        {
            return Boolean.valueOf(s).booleanValue();
        }
    }

    public static double tryParseDouble(String s)
    {
        return tryParseDouble(s, 0.0D);
    }

    public static double tryParseDouble(String s, double d)
    {
        if (s == null || s == "")
        {
            return d;
        }
        double d1;
        try
        {
            d1 = Double.parseDouble(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return d;
        }
        return d1;
    }

    public static int tryParseInt(String s)
    {
        return tryParseInt(s, 0);
    }

    public static int tryParseInt(String s, int i)
    {
        if (s == null || s == "")
        {
            return i;
        }
        int j;
        try
        {
            j = Integer.parseInt(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return i;
        }
        return j;
    }

    public AdContext getAdContext()
    {
        return context;
    }

    public AdRequest getAdRequest()
    {
        return context.adRequest;
    }

    public AdResponse getAdResponse()
    {
        return context.adResponse;
    }
}
