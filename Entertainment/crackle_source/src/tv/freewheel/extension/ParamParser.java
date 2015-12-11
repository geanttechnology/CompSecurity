// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.extension;

import android.graphics.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import tv.freewheel.ad.interfaces.IAdContext;
import tv.freewheel.utils.Logger;

public class ParamParser
{

    private IAdContext context;
    private Logger logger;
    private String paramNamespace;

    public ParamParser(IAdContext iadcontext, String s)
    {
        context = iadcontext;
        paramNamespace = s;
        logger = Logger.getLogger(this);
    }

    private Object getNamespacedParam(String s)
    {
        Object obj = context.getParameter((new StringBuilder()).append(paramNamespace).append(".").append(s).toString());
        if (obj != null)
        {
            return obj;
        } else
        {
            return context.getParameter(s);
        }
    }

    private String getNamespacedParamStr(String s)
    {
        return (String)getNamespacedParam(s);
    }

    private int parseIntNotNull(String s, int i)
        throws NumberFormatException
    {
        String s1 = s;
        if (s.startsWith("0x"))
        {
            s1 = s.substring(2);
            i = 16;
        }
        return Integer.parseInt(s1, i);
    }

    public Boolean parseBoolean(String s, Boolean boolean1)
    {
        String s1;
        s1 = getNamespacedParamStr(s);
        s = boolean1;
        if (s1 == null) goto _L2; else goto _L1
_L1:
        s1 = s1.trim().toLowerCase();
        if (!s1.equals("true") && !s1.equals("on") && !s1.equals("yes")) goto _L4; else goto _L3
_L3:
        s = Boolean.valueOf(true);
_L2:
        return s;
_L4:
        if (s1.equals("false") || s1.equals("off"))
        {
            break; /* Loop/switch isn't completed */
        }
        s = boolean1;
        if (!s1.equals("no")) goto _L2; else goto _L5
_L5:
        return Boolean.valueOf(false);
    }

    public GregorianCalendar parseCalendar(String s, GregorianCalendar gregoriancalendar, String s1)
    {
        Object obj;
        obj = getNamespacedParam(s);
        if (obj instanceof GregorianCalendar)
        {
            return (GregorianCalendar)obj;
        }
        if (!(obj instanceof String))
        {
            break MISSING_BLOCK_LABEL_112;
        }
        obj = ((String)obj).trim();
        s1 = (new SimpleDateFormat(s1)).parse(((String) (obj)));
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        GregorianCalendar gregoriancalendar1;
        gregoriancalendar1 = new GregorianCalendar();
        gregoriancalendar1.setTime(s1);
        return gregoriancalendar1;
        s1;
        logger.warn((new StringBuilder()).append("IllegalArgumentException when parsing parameter ").append(s).append(" as date whose value is ").append(((String) (obj))).toString());
_L2:
        return gregoriancalendar;
        s1;
        logger.warn((new StringBuilder()).append("ParseException when parsing parameter ").append(s).append(" as date whose value is ").append(((String) (obj))).toString());
        if (true) goto _L2; else goto _L1
_L1:
    }

    public int parseColor(String s, int i)
    {
        String s1 = getNamespacedParamStr(s);
        if (s1 != null)
        {
            int j;
            try
            {
                j = Color.parseColor(s1);
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                logger.warn((new StringBuilder()).append("IllegalArgumentException when parsing parameter ").append(s).append(" as color whose value is ").append(s1).toString());
                return i;
            }
            return j;
        } else
        {
            return i;
        }
    }

    public GregorianCalendar parseDate(String s, GregorianCalendar gregoriancalendar)
    {
        return parseCalendar(s, gregoriancalendar, "yyyy-MM-dd");
    }

    public String parseEnum(String s, String s1, String as[])
    {
        s = getNamespacedParamStr(s);
        if (s != null)
        {
            s = s.trim();
            for (int i = 0; i < as.length; i++)
            {
                String s2 = as[i];
                if (s.equalsIgnoreCase(s2))
                {
                    return s2;
                }
            }

        }
        return s1;
    }

    public int parseInt(String s, int i)
    {
        return parseInt(s, i, 10);
    }

    public int parseInt(String s, int i, int j)
    {
        String s1 = getNamespacedParamStr(s);
        int k = i;
        if (s1 != null)
        {
            try
            {
                k = parseIntNotNull(s1, j);
            }
            catch (NumberFormatException numberformatexception)
            {
                logger.warn((new StringBuilder()).append("NumberFormatException when parsing parameter ").append(s).append(" as int whose value is ").append(s1).toString());
                return i;
            }
        }
        return k;
    }

    public Integer parseInteger(String s, Integer integer)
    {
        return parseInteger(s, integer, 10);
    }

    public Integer parseInteger(String s, Integer integer, int i)
    {
        s = getNamespacedParamStr(s);
        if (s == null)
        {
            return integer;
        }
        try
        {
            i = parseIntNotNull(s, i);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return integer;
        }
        return Integer.valueOf(i);
    }

    public List parseList(String s)
    {
        return parseList(s, null, ",");
    }

    public List parseList(String s, List list, String s1)
    {
        s = getNamespacedParamStr(s);
        if (s != null)
        {
            list = Arrays.asList(s.split(s1));
            for (int i = 0; i < list.size(); i++)
            {
                list.set(i, ((String)list.get(i)).trim());
            }

        }
        return list;
    }

    public HashMap parseQueryString(String s)
    {
        HashMap hashmap = new HashMap();
        s = getNamespacedParamStr(s);
        if (s != null)
        {
            s = s.split("&");
            int j = s.length;
            for (int i = 0; i < j; i++)
            {
                String as[] = s[i].split("=");
                if (as.length == 2)
                {
                    hashmap.put(as[0], as[1]);
                }
            }

        }
        return hashmap;
    }

    public ArrayList parseQueryStringAsList(String s)
    {
        ArrayList arraylist = new ArrayList();
        s = getNamespacedParamStr(s);
        if (s != null)
        {
            s = s.split("&");
            int j = s.length;
            for (int i = 0; i < j; i++)
            {
                String as[] = s[i].split("=");
                if (as.length == 2)
                {
                    HashMap hashmap = new HashMap();
                    hashmap.put(as[0], as[1]);
                    arraylist.add(hashmap);
                }
            }

        }
        return arraylist;
    }

    public String parseString(String s, String s1)
    {
        s = getNamespacedParamStr(s);
        if (s != null)
        {
            s1 = s.trim();
        }
        return s1;
    }
}
