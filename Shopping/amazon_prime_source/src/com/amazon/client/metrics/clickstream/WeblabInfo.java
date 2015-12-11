// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.clickstream;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.client.metrics.clickstream:
//            ClickStreamInfo, ClickStreamData, ClickStreamHelper

public class WeblabInfo
    implements ClickStreamInfo
{

    private static final String WL_HIT_TYPE = "weblab-trigger";
    private static final String WL_PAGE_ASSEMBLY_TYPE = "main";
    private static final String WL_PAGE_TYPE = "Weblab";
    private static final String WL_SUB_PAGE_TYPE = "Trigger";
    private static final char WL_TREATMENT_DIVIDER = 47;
    private final String clientID;
    private final String weblab;

    public WeblabInfo(String s, String s1)
    {
        verifyString("Weblab", s);
        verifyString("Weblab Client ID", s1);
        int i = s.indexOf('/');
        if (i <= 0 || i != s.lastIndexOf('/') || i >= s.length() - 1)
        {
            throw new IllegalArgumentException("Invalid Weblab! Must be of the format WEBLAB_ID/TREATMENT");
        } else
        {
            weblab = s;
            clientID = s1;
            return;
        }
    }

    private static void verifyString(String s, String s1)
    {
        if (s1 == null || s1.isEmpty())
        {
            throw new IllegalArgumentException(String.format("%s cannot be null or empty", new Object[] {
                s
            }));
        } else
        {
            return;
        }
    }

    public List getDataPoints()
    {
        ArrayList arraylist = new ArrayList(6);
        ClickStreamHelper.addDatapoint(arraylist, ClickStreamData.PAGE_ASSEMBLY_TYPE.getName(), "main");
        ClickStreamHelper.addDatapoint(arraylist, ClickStreamData.PAGE_TYPE.getName(), "Weblab");
        ClickStreamHelper.addDatapoint(arraylist, ClickStreamData.SUB_PAGE_TYPE.getName(), "Trigger");
        ClickStreamHelper.addDatapoint(arraylist, ClickStreamData.HIT_TYPE.getName(), "weblab-trigger");
        ClickStreamHelper.addDatapoint(arraylist, ClickStreamData.WEBLAB_CLIENT_ID.getName(), clientID);
        ClickStreamHelper.addDatapoint(arraylist, ClickStreamData.WEBLAB.getName(), weblab);
        return arraylist;
    }
}
