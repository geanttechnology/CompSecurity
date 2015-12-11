// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model;

import com.comcast.cim.cmasl.hal.model.MicrodataPropertyResolver;
import com.comcast.cim.microdata.model.MicrodataLinkValue;
import com.comcast.cim.microdata.model.MicrodataProperty;

public class HalUtils
{

    public HalUtils()
    {
    }

    public static String resolveOptionalLink(String s, MicrodataPropertyResolver microdatapropertyresolver)
    {
        microdatapropertyresolver = microdatapropertyresolver.getProperty(s);
        s = null;
        if (!microdatapropertyresolver.isMissing())
        {
            s = resolveUrl(microdatapropertyresolver);
        }
        return s;
    }

    private static String resolveUrl(MicrodataProperty microdataproperty)
    {
        Object obj = microdataproperty.asLink();
        microdataproperty = ((MicrodataLinkValue) (obj)).getHref();
        if (microdataproperty.startsWith("../"))
        {
            obj = ((MicrodataLinkValue) (obj)).getBaseUrl().substring(0, ((MicrodataLinkValue) (obj)).getBaseUrl().length() - 1);
            return ((String) (obj)).substring(0, ((String) (obj)).lastIndexOf("/") + 1).concat(microdataproperty.substring(3));
        } else
        {
            return microdataproperty;
        }
    }
}
