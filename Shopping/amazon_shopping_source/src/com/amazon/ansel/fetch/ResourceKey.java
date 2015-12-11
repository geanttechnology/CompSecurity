// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.ansel.fetch;


public class ResourceKey
{

    private volatile int hash;
    private volatile boolean hashed;
    private final Object operation;
    private final Object resourceRequest;

    public ResourceKey(Object obj, Object obj1)
    {
        hash = 0;
        operation = obj;
        resourceRequest = obj1;
    }

    private int hashCodeInternal()
    {
        int j = 0;
        int i;
        if (operation == null)
        {
            i = 0;
        } else
        {
            i = operation.hashCode();
        }
        if (resourceRequest != null)
        {
            j = resourceRequest.hashCode();
        }
        return (i + 31) * 31 + j;
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        obj = (ResourceKey)obj;
        if (operation == null)
        {
            if (((ResourceKey) (obj)).operation != null)
            {
                return false;
            }
        } else
        if (!operation.equals(((ResourceKey) (obj)).operation))
        {
            return false;
        }
        if (resourceRequest != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((ResourceKey) (obj)).resourceRequest == null) goto _L1; else goto _L3
_L3:
        return false;
        if (resourceRequest.equals(((ResourceKey) (obj)).resourceRequest)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public int hashCode()
    {
        if (hashed)
        {
            return hash;
        } else
        {
            hash = hashCodeInternal();
            hashed = true;
            return hash;
        }
    }

    public String toString()
    {
        return (new StringBuilder()).append("[").append(operation).append(", ").append(resourceRequest).append("]").toString();
    }
}
