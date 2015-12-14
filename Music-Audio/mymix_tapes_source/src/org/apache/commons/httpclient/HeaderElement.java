// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.httpclient.util.ParameterParser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// Referenced classes of package org.apache.commons.httpclient:
//            NameValuePair, HttpException

public class HeaderElement extends NameValuePair
{

    private static final Log LOG;
    static Class class$org$apache$commons$httpclient$HeaderElement;
    private NameValuePair parameters[];

    public HeaderElement()
    {
        this(((String) (null)), ((String) (null)), ((NameValuePair []) (null)));
    }

    public HeaderElement(String s, String s1)
    {
        this(s, s1, ((NameValuePair []) (null)));
    }

    public HeaderElement(String s, String s1, NameValuePair anamevaluepair[])
    {
        super(s, s1);
        parameters = null;
        parameters = anamevaluepair;
    }

    public HeaderElement(char ac[])
    {
        this(ac, 0, ac.length);
    }

    public HeaderElement(char ac[], int i, int j)
    {
        this();
        if (ac != null)
        {
            if ((ac = (new ParameterParser()).parse(ac, i, j, ';')).size() > 0)
            {
                NameValuePair namevaluepair = (NameValuePair)ac.remove(0);
                setName(namevaluepair.getName());
                setValue(namevaluepair.getValue());
                if (ac.size() > 0)
                {
                    parameters = (NameValuePair[])(NameValuePair[])ac.toArray(new NameValuePair[ac.size()]);
                    return;
                }
            }
        }
    }

    static Class _mthclass$(String s)
    {
        try
        {
            s = Class.forName(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new NoClassDefFoundError(s.getMessage());
        }
        return s;
    }

    public static final HeaderElement[] parse(String s)
        throws HttpException
    {
        LOG.trace("enter HeaderElement.parse(String)");
        if (s == null)
        {
            return new HeaderElement[0];
        } else
        {
            return parseElements(s.toCharArray());
        }
    }

    public static final HeaderElement[] parseElements(String s)
    {
        LOG.trace("enter HeaderElement.parseElements(String)");
        if (s == null)
        {
            return new HeaderElement[0];
        } else
        {
            return parseElements(s.toCharArray());
        }
    }

    public static final HeaderElement[] parseElements(char ac[])
    {
        LOG.trace("enter HeaderElement.parseElements(char[])");
        if (ac == null)
        {
            return new HeaderElement[0];
        }
        ArrayList arraylist = new ArrayList();
        int i = 0;
        int j = 0;
        int l = ac.length;
        int k = 0;
        while (i < l) 
        {
            char c = ac[i];
            boolean flag = k;
            HeaderElement headerelement;
            if (c == '"')
            {
                if (k == 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            }
            headerelement = null;
            if (!flag && c == ',')
            {
                headerelement = new HeaderElement(ac, j, i);
                k = i + 1;
            } else
            {
                k = j;
                if (i == l - 1)
                {
                    headerelement = new HeaderElement(ac, j, l);
                    k = j;
                }
            }
            if (headerelement != null && headerelement.getName() != null)
            {
                arraylist.add(headerelement);
            }
            i++;
            j = k;
            k = ((flag) ? 1 : 0);
        }
        return (HeaderElement[])(HeaderElement[])arraylist.toArray(new HeaderElement[arraylist.size()]);
    }

    public NameValuePair getParameterByName(String s)
    {
        NameValuePair namevaluepair;
        Object obj;
        NameValuePair anamevaluepair[];
        LOG.trace("enter HeaderElement.getParameterByName(String)");
        if (s == null)
        {
            throw new IllegalArgumentException("Name may not be null");
        }
        obj = null;
        anamevaluepair = getParameters();
        namevaluepair = obj;
        if (anamevaluepair == null) goto _L2; else goto _L1
_L1:
        int i = 0;
_L6:
        namevaluepair = obj;
        if (i >= anamevaluepair.length) goto _L2; else goto _L3
_L3:
        namevaluepair = anamevaluepair[i];
        if (!namevaluepair.getName().equalsIgnoreCase(s)) goto _L4; else goto _L2
_L2:
        return namevaluepair;
_L4:
        i++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public NameValuePair[] getParameters()
    {
        return parameters;
    }

    static 
    {
        Class class1;
        if (class$org$apache$commons$httpclient$HeaderElement == null)
        {
            class1 = _mthclass$("org.apache.commons.httpclient.HeaderElement");
            class$org$apache$commons$httpclient$HeaderElement = class1;
        } else
        {
            class1 = class$org$apache$commons$httpclient$HeaderElement;
        }
        LOG = LogFactory.getLog(class1);
    }
}
