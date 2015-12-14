// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.methods;

import java.util.Iterator;
import java.util.Vector;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.util.EncodingUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// Referenced classes of package org.apache.commons.httpclient.methods:
//            EntityEnclosingMethod, ByteArrayRequestEntity, RequestEntity

public class PostMethod extends EntityEnclosingMethod
{

    public static final String FORM_URL_ENCODED_CONTENT_TYPE = "application/x-www-form-urlencoded";
    private static final Log LOG;
    static Class class$org$apache$commons$httpclient$methods$PostMethod;
    private Vector params;

    public PostMethod()
    {
        params = new Vector();
    }

    public PostMethod(String s)
    {
        super(s);
        params = new Vector();
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

    public void addParameter(String s, String s1)
        throws IllegalArgumentException
    {
        LOG.trace("enter PostMethod.addParameter(String, String)");
        if (s == null || s1 == null)
        {
            throw new IllegalArgumentException("Arguments to addParameter(String, String) cannot be null");
        } else
        {
            super.clearRequestBody();
            params.add(new NameValuePair(s, s1));
            return;
        }
    }

    public void addParameter(NameValuePair namevaluepair)
        throws IllegalArgumentException
    {
        LOG.trace("enter PostMethod.addParameter(NameValuePair)");
        if (namevaluepair == null)
        {
            throw new IllegalArgumentException("NameValuePair may not be null");
        } else
        {
            addParameter(namevaluepair.getName(), namevaluepair.getValue());
            return;
        }
    }

    public void addParameters(NameValuePair anamevaluepair[])
    {
        LOG.trace("enter PostMethod.addParameters(NameValuePair[])");
        if (anamevaluepair == null)
        {
            LOG.warn("Attempt to addParameters(null) ignored");
        } else
        {
            super.clearRequestBody();
            int i = 0;
            while (i < anamevaluepair.length) 
            {
                params.add(anamevaluepair[i]);
                i++;
            }
        }
    }

    protected void clearRequestBody()
    {
        LOG.trace("enter PostMethod.clearRequestBody()");
        params.clear();
        super.clearRequestBody();
    }

    protected RequestEntity generateRequestEntity()
    {
        if (!params.isEmpty())
        {
            return new ByteArrayRequestEntity(EncodingUtil.getAsciiBytes(EncodingUtil.formUrlEncode(getParameters(), getRequestCharSet())), "application/x-www-form-urlencoded");
        } else
        {
            return super.generateRequestEntity();
        }
    }

    public String getName()
    {
        return "POST";
    }

    public NameValuePair getParameter(String s)
    {
        LOG.trace("enter PostMethod.getParameter(String)");
        if (s == null)
        {
            return null;
        }
        for (Iterator iterator = params.iterator(); iterator.hasNext();)
        {
            NameValuePair namevaluepair = (NameValuePair)iterator.next();
            if (s.equals(namevaluepair.getName()))
            {
                return namevaluepair;
            }
        }

        return null;
    }

    public NameValuePair[] getParameters()
    {
        LOG.trace("enter PostMethod.getParameters()");
        int j = params.size();
        Object aobj[] = params.toArray();
        NameValuePair anamevaluepair[] = new NameValuePair[j];
        for (int i = 0; i < j; i++)
        {
            anamevaluepair[i] = (NameValuePair)aobj[i];
        }

        return anamevaluepair;
    }

    protected boolean hasRequestContent()
    {
        LOG.trace("enter PostMethod.hasRequestContent()");
        if (!params.isEmpty())
        {
            return true;
        } else
        {
            return super.hasRequestContent();
        }
    }

    public boolean removeParameter(String s)
        throws IllegalArgumentException
    {
        LOG.trace("enter PostMethod.removeParameter(String)");
        if (s == null)
        {
            throw new IllegalArgumentException("Argument passed to removeParameter(String) cannot be null");
        }
        boolean flag = false;
        Iterator iterator = params.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (s.equals(((NameValuePair)iterator.next()).getName()))
            {
                iterator.remove();
                flag = true;
            }
        } while (true);
        return flag;
    }

    public boolean removeParameter(String s, String s1)
        throws IllegalArgumentException
    {
        LOG.trace("enter PostMethod.removeParameter(String, String)");
        if (s == null)
        {
            throw new IllegalArgumentException("Parameter name may not be null");
        }
        if (s1 == null)
        {
            throw new IllegalArgumentException("Parameter value may not be null");
        }
        for (Iterator iterator = params.iterator(); iterator.hasNext();)
        {
            NameValuePair namevaluepair = (NameValuePair)iterator.next();
            if (s.equals(namevaluepair.getName()) && s1.equals(namevaluepair.getValue()))
            {
                iterator.remove();
                return true;
            }
        }

        return false;
    }

    public void setParameter(String s, String s1)
    {
        LOG.trace("enter PostMethod.setParameter(String, String)");
        removeParameter(s);
        addParameter(s, s1);
    }

    public void setRequestBody(NameValuePair anamevaluepair[])
        throws IllegalArgumentException
    {
        LOG.trace("enter PostMethod.setRequestBody(NameValuePair[])");
        if (anamevaluepair == null)
        {
            throw new IllegalArgumentException("Array of parameters may not be null");
        } else
        {
            clearRequestBody();
            addParameters(anamevaluepair);
            return;
        }
    }

    static 
    {
        Class class1;
        if (class$org$apache$commons$httpclient$methods$PostMethod == null)
        {
            class1 = _mthclass$("org.apache.commons.httpclient.methods.PostMethod");
            class$org$apache$commons$httpclient$methods$PostMethod = class1;
        } else
        {
            class1 = class$org$apache$commons$httpclient$methods$PostMethod;
        }
        LOG = LogFactory.getLog(class1);
    }
}
