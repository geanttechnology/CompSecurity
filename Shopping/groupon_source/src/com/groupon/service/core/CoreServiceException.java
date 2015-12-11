// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.core;


// Referenced classes of package com.groupon.service.core:
//            CoreService

public class CoreServiceException extends Exception
{

    private Class coreServiceClass;

    public CoreServiceException(CoreService coreservice, Exception exception)
    {
        super((new StringBuilder()).append("A core service failed to start :").append(coreservice.getClass().getName()).toString(), exception);
        coreServiceClass = coreservice.getClass();
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (CoreServiceException)obj;
            if (coreServiceClass != ((CoreServiceException) (obj)).coreServiceClass)
            {
                return false;
            }
        }
        return true;
    }

    public Class getCoreServiceClass()
    {
        return coreServiceClass;
    }

    public int hashCode()
    {
        return coreServiceClass.hashCode();
    }
}
