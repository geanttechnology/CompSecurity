// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.interception;

import java.util.ArrayList;

// Referenced classes of package com.amazon.mobile.mash.interception:
//            ParameterModel

public class UrlIntercepterConfigEntry
    implements Comparable
{

    private MASHUrlIntercepter.UrlDestination mDestination;
    private ArrayList mParameters;
    private String mPattern;

    public UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination urldestination, String s)
    {
        mPattern = s;
        mDestination = urldestination;
    }

    public UrlIntercepterConfigEntry addUrlPathIndexToParseParameter(String s, int i)
    {
        if (mParameters == null)
        {
            mParameters = new ArrayList();
        }
        mParameters.add(new ParameterModel(s, i));
        return this;
    }

    public int compareTo(UrlIntercepterConfigEntry urlintercepterconfigentry)
    {
        String as[];
        as = getPattern().split("/");
        urlintercepterconfigentry = urlintercepterconfigentry.getPattern().split("/");
        if (as.length <= urlintercepterconfigentry.length) goto _L2; else goto _L1
_L1:
        return -1;
_L2:
        if (as.length < urlintercepterconfigentry.length)
        {
            return 1;
        }
        int i = 0;
label0:
        do
        {
label1:
            {
                if (i >= as.length)
                {
                    break label1;
                }
                if ("*".equals(as[i]) && !"*".equals(urlintercepterconfigentry[i]))
                {
                    return 1;
                }
                if (!"*".equals(as[i]) && "*".equals(urlintercepterconfigentry[i]))
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        return 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((UrlIntercepterConfigEntry)obj);
    }

    public boolean equals(Object obj)
    {
        while (!(obj instanceof UrlIntercepterConfigEntry) || compareTo((UrlIntercepterConfigEntry)obj) != 0) 
        {
            return false;
        }
        return true;
    }

    public MASHUrlIntercepter.UrlDestination getDestination()
    {
        return mDestination;
    }

    public ArrayList getParamList()
    {
        return mParameters;
    }

    public String getPattern()
    {
        return mPattern;
    }

    public int hashCode()
    {
        return mPattern.hashCode();
    }

    public boolean matches(String s)
    {
        String as[];
        s = s.split("/");
        as = mPattern.split("/");
        if (as.length == s.length) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int i = 1;
label0:
        do
        {
label1:
            {
                if (i >= s.length)
                {
                    break label1;
                }
                if (!as[i].equals("*") && !s[i].equals(as[i]))
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        return true;
    }
}
