// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.entitlement;

import com.xfinity.playerlib.model.dibic.DibicProgram;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VideoEntitlement
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/model/entitlement/VideoEntitlement);
    private final String edata;
    private Set entitlements;
    private final String xedata;

    protected VideoEntitlement()
    {
        entitlements = new HashSet();
        edata = "";
        xedata = "";
    }

    public VideoEntitlement(String s, String s1)
    {
        entitlements = new HashSet();
        edata = s;
        xedata = s1;
        s = edata.split("&");
        int j = s.length;
        for (int i = 0; i < j; i++)
        {
            s1 = s[i].split("=");
            if ("y".equals(s1[1]))
            {
                entitlements.add(s1[0]);
            }
        }

    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof VideoEntitlement) || (!edata.equals(((VideoEntitlement) (obj = (VideoEntitlement)obj)).getEdata()) || !xedata.equals(((VideoEntitlement) (obj)).getXedata())))
            {
                return false;
            }
        }
        return true;
    }

    public String getEdata()
    {
        return edata;
    }

    public String getXedata()
    {
        return xedata;
    }

    public boolean isEntitled(DibicProgram dibicprogram)
    {
        boolean flag;
label0:
        {
            flag = false;
            boolean flag1 = false;
            if (dibicprogram == null)
            {
                break label0;
            }
            dibicprogram = dibicprogram.getProviderCodes().iterator();
            flag = flag1;
            do
            {
                if (!dibicprogram.hasNext())
                {
                    break label0;
                }
                flag1 = isEntitled((String)dibicprogram.next());
                flag = flag1;
            } while (!flag1);
            flag = flag1;
        }
        return flag;
    }

    public boolean isEntitled(String s)
    {
label0:
        {
            boolean flag = false;
            if (s != null)
            {
                if (!s.equals("free"))
                {
                    break label0;
                }
                flag = true;
            }
            return flag;
        }
        return entitlements.contains(s);
    }

    public boolean isEntitledToList(String s)
    {
        boolean flag = false;
        if (s != null)
        {
            flag = isEntitledToList(s.split(","));
        }
        return flag;
    }

    public boolean isEntitledToList(String as[])
    {
        boolean flag;
        boolean flag1;
        flag = false;
        flag1 = false;
        if (as == null) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        j = as.length;
        i = 0;
        flag = flag1;
_L6:
        if (i >= j) goto _L2; else goto _L3
_L3:
        flag = isEntitled(as[i]);
        if (!flag) goto _L4; else goto _L2
_L2:
        return flag;
_L4:
        i++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public String toString()
    {
        return (new StringBuilder()).append(getClass().getSimpleName()).append("@").append(Integer.toHexString(hashCode())).toString();
    }

}
