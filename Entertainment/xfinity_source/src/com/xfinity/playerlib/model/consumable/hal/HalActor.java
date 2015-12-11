// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.consumable.hal;

import com.comcast.cim.cmasl.hal.model.HalParseable;
import com.comcast.cim.cmasl.hal.model.MicrodataPropertyResolver;

public class HalActor
    implements HalParseable
{

    private String name;

    public HalActor()
    {
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
        obj = (HalActor)obj;
        if (name == null) goto _L4; else goto _L3
_L3:
        if (name.equals(((HalActor) (obj)).name)) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (((HalActor) (obj)).name == null)
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public String getName()
    {
        return name;
    }

    public int hashCode()
    {
        if (name != null)
        {
            return name.hashCode();
        } else
        {
            return 0;
        }
    }

    public void parseHalContent(MicrodataPropertyResolver microdatapropertyresolver)
    {
        name = microdatapropertyresolver.fetchString("name");
    }
}
