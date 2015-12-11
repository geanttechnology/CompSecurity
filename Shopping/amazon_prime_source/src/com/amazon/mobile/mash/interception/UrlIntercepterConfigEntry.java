// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.interception;

import android.net.Uri;
import android.text.TextUtils;
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
        boolean flag1 = false;
        if (!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        boolean flag = TextUtils.isEmpty(mPattern);
_L4:
        return flag;
_L2:
        String as[];
        s = Uri.parse(s);
        s = (new StringBuilder()).append(s.getAuthority()).append(s.getPath()).toString().split("/");
        as = mPattern.split("/");
        flag = flag1;
        if (as.length != s.length) goto _L4; else goto _L3
_L3:
        int i = 1;
_L8:
        if (i >= s.length) goto _L6; else goto _L5
_L5:
        if (as[i].equals("*"))
        {
            continue; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (!s[i].equals(as[i])) goto _L4; else goto _L7
_L7:
        i++;
          goto _L8
_L6:
        return true;
    }
}
