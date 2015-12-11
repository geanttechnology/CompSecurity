// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.igexin.sdk.bean;

import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.igexin.sdk.bean:
//            BaseBean

public class PushMessageBean
{

    private List actionChains;
    private String actionId;
    private String masterMessageId;
    private String masterTaskId;
    private String messageId;
    private byte payload[];
    private String taskId;

    public PushMessageBean()
    {
    }

    public List getActionChains()
    {
        return actionChains;
    }

    public String getActionId()
    {
        return actionId;
    }

    public BaseBean getBean(String s)
    {
        for (Iterator iterator = getActionChains().iterator(); iterator.hasNext();)
        {
            BaseBean basebean = (BaseBean)iterator.next();
            if (basebean.getActionId().equals(s))
            {
                return basebean;
            }
        }

        return null;
    }

    public String getMasterMessageId()
    {
        return masterMessageId;
    }

    public String getMasterTaskId()
    {
        return masterTaskId;
    }

    public String getMessageId()
    {
        return messageId;
    }

    public byte[] getPayload()
    {
        return payload;
    }

    public String getTaskId()
    {
        return taskId;
    }

    public void setActionChains(List list)
    {
        actionChains = list;
    }

    public void setActionId(String s)
    {
        actionId = s;
    }

    public void setMasterMessageId(String s)
    {
        masterMessageId = s;
    }

    public void setMasterTaskId(String s)
    {
        masterTaskId = s;
    }

    public void setMessageId(String s)
    {
        messageId = s;
    }

    public void setPayload(byte abyte0[])
    {
        payload = abyte0;
    }

    public void setTaskId(String s)
    {
        taskId = s;
    }
}
