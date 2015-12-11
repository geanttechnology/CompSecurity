// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.igexin.sdk.bean;

import com.igexin.sdk.SdkService;
import com.igexin.sdk.data.BasicDataManager;

// Referenced classes of package com.igexin.sdk.bean:
//            BaseBean

public class StartWebBean extends BaseBean
{

    private boolean isNetType;
    private boolean isWithCid;
    private String url;

    public StartWebBean()
    {
    }

    public String getFinalUrl()
    {
        String s;
        String s2;
label0:
        {
            String s1 = url;
            s = s1;
            if (isWithCid)
            {
                if (s1.indexOf("?") > 0)
                {
                    s = (new StringBuilder()).append(s1).append("&cid=").append(BasicDataManager.vcid).toString();
                } else
                {
                    s = (new StringBuilder()).append(s1).append("?cid=").append(BasicDataManager.vcid).toString();
                }
            }
            s1 = s;
            if (isNetType)
            {
                s2 = SdkService.getInstance().getNetworkType();
                s1 = s;
                if (s2 != null)
                {
                    if (s.indexOf("?") <= 0)
                    {
                        break label0;
                    }
                    s1 = (new StringBuilder()).append(s).append("&nettype=").append(s2).toString();
                }
            }
            return s1;
        }
        return (new StringBuilder()).append(s).append("?nettype=").append(s2).toString();
    }

    public void setNetType(boolean flag)
    {
        isNetType = flag;
    }

    public void setUrl(String s)
    {
        url = s;
    }

    public void setWithCid(boolean flag)
    {
        isWithCid = flag;
    }
}
