// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication.devicetodevice;

import amazon.communication.Message;
import amazon.communication.identity.EndpointIdentity;

public class D2DMessage
{

    public int channel;
    public EndpointIdentity destination;
    public String destinationApp;
    public Message message;
    public String messageType;
    public EndpointIdentity origin;
    public String originApp;

    public D2DMessage()
    {
    }

    public boolean equals(Object obj)
    {
        if (obj != this) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null)
        {
            return false;
        }
        if (!(obj instanceof D2DMessage))
        {
            break MISSING_BLOCK_LABEL_230;
        }
        obj = (D2DMessage)obj;
        if (message == null)
        {
            if (((D2DMessage) (obj)).message != null)
            {
                return false;
            }
        } else
        if (!message.equals(((D2DMessage) (obj)).message))
        {
            return false;
        }
        if (messageType == null)
        {
            if (((D2DMessage) (obj)).messageType != null)
            {
                return false;
            }
        } else
        if (!messageType.equals(((D2DMessage) (obj)).messageType))
        {
            return false;
        }
        if (channel != ((D2DMessage) (obj)).channel)
        {
            return false;
        }
        if (origin == null)
        {
            if (((D2DMessage) (obj)).origin != null)
            {
                return false;
            }
        } else
        if (!origin.equals(((D2DMessage) (obj)).origin))
        {
            return false;
        }
        if (destination == null)
        {
            if (((D2DMessage) (obj)).destination != null)
            {
                return false;
            }
        } else
        if (!destination.equals(((D2DMessage) (obj)).destination))
        {
            return false;
        }
        if (originApp == null)
        {
            if (((D2DMessage) (obj)).originApp != null)
            {
                return false;
            }
        } else
        if (!originApp.equals(((D2DMessage) (obj)).originApp))
        {
            return false;
        }
        if (destinationApp != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((D2DMessage) (obj)).destinationApp == null) goto _L1; else goto _L3
_L3:
        return false;
        if (destinationApp.equals(((D2DMessage) (obj)).destinationApp)) goto _L1; else goto _L4
_L4:
        return false;
        return false;
    }

    public int hashCode()
    {
        int j1 = 0;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int k1;
        if (message == null)
        {
            i = 0;
        } else
        {
            i = message.hashCode();
        }
        if (messageType == null)
        {
            j = 0;
        } else
        {
            j = messageType.hashCode();
        }
        k1 = channel;
        if (origin == null)
        {
            k = 0;
        } else
        {
            k = origin.hashCode();
        }
        if (destination == null)
        {
            l = 0;
        } else
        {
            l = destination.hashCode();
        }
        if (destinationApp == null)
        {
            i1 = 0;
        } else
        {
            i1 = destinationApp.hashCode();
        }
        if (originApp != null)
        {
            j1 = originApp.hashCode();
        }
        return ((((((i + 31) * 31 + j) * 31 + k1) * 31 + k) * 31 + l) * 31 + i1) * 31 + j1;
    }
}
