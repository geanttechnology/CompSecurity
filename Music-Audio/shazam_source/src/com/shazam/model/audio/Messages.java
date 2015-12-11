// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.audio;


public class Messages
{

    public String id;
    public String type;

    public Messages()
    {
    }

    private Messages(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        id = Builder.a(builder);
        type = Builder.b(builder);
    }

    Messages(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        obj = (Messages)obj;
        if (id == null ? ((Messages) (obj)).id != null : !id.equals(((Messages) (obj)).id))
        {
            return false;
        }
        if (type == null) goto _L4; else goto _L3
_L3:
        if (type.equals(((Messages) (obj)).type)) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (((Messages) (obj)).type == null)
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        if (id != null)
        {
            i = id.hashCode();
        } else
        {
            i = 0;
        }
        if (type != null)
        {
            j = type.hashCode();
        }
        return i * 31 + j;
    }
}
