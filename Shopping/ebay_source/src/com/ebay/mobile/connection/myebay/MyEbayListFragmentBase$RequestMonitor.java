// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.connection.myebay;

import com.ebay.nautilus.kernel.content.ResultStatus;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.ebay.mobile.connection.myebay:
//            MyEbayListFragmentBase

protected static class Info.status
{
    private class Info
    {

        ResultStatus status;
        int targetPage;
        final MyEbayListFragmentBase.RequestMonitor this$0;

        public Info(int i)
        {
            this$0 = MyEbayListFragmentBase.RequestMonitor.this;
            super();
            targetPage = i;
            status = null;
        }
    }


    private final HashMap requestToStatus = new HashMap();

    public void addRequest(Object obj)
    {
        addRequest(obj, 0);
    }

    public void addRequest(Object obj, int i)
    {
        requestToStatus.put(obj, new Info(i));
    }

    public ResultStatus getFirstError()
    {
        Object obj1 = null;
        Iterator iterator = requestToStatus.keySet().iterator();
        do
        {
            Object obj = obj1;
            if (!iterator.hasNext())
            {
                break;
            }
            obj = iterator.next();
            obj = (Info)requestToStatus.get(obj);
            if (obj == null)
            {
                obj = null;
            } else
            {
                obj = ((Info) (obj)).status;
            }
        } while (obj == null || !((ResultStatus) (obj)).hasError());
        return ((ResultStatus) (obj));
    }

    public int getTargetPage(Object obj)
    {
        obj = (Info)requestToStatus.get(obj);
        if (obj != null)
        {
            return ((Info) (obj)).targetPage;
        } else
        {
            return 0;
        }
    }

    public boolean isCompleted()
    {
        boolean flag1 = true;
        Iterator iterator = requestToStatus.keySet().iterator();
        while (iterator.hasNext()) 
        {
            Object obj = iterator.next();
            boolean flag;
            if (((Info)requestToStatus.get(obj)).status != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 &= flag;
        }
        return flag1;
    }

    public void setCompleted(Object obj, ResultStatus resultstatus)
    {
        Info info1 = (Info)requestToStatus.get(obj);
        Info info = info1;
        if (info1 == null)
        {
            info = new Info(0);
            requestToStatus.put(obj, info);
        }
        info.status = resultstatus;
    }

    protected Info.status()
    {
    }
}
