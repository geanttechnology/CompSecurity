// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.audio;

import java.util.List;

public class Mood
{

    public List messages;
    public String sdkVersion;

    private Mood()
    {
    }

    private Mood(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        messages = Builder.a(builder);
        sdkVersion = Builder.b(builder);
    }

    Mood(Builder builder, _cls1 _pcls1)
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
        obj = (Mood)obj;
        if (sdkVersion == null ? ((Mood) (obj)).sdkVersion != null : !sdkVersion.equals(((Mood) (obj)).sdkVersion))
        {
            return false;
        }
        if (messages == null) goto _L4; else goto _L3
_L3:
        if (messages.equals(((Mood) (obj)).messages)) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (((Mood) (obj)).messages == null)
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
        if (messages != null)
        {
            i = messages.hashCode();
        } else
        {
            i = 0;
        }
        if (sdkVersion != null)
        {
            j = sdkVersion.hashCode();
        }
        return i * 37 + j;
    }

    public String toString()
    {
        return (new StringBuilder("{Mood sdk:")).append(sdkVersion).append(", messages:").append(messages).append("}").toString();
    }
}
