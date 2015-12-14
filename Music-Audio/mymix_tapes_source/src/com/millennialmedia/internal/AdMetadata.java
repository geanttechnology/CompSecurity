// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import java.util.HashMap;

public class AdMetadata extends HashMap
{

    public static final String TRANSPARENT = "x-mm-transparent";

    public AdMetadata()
    {
    }

    public boolean isTransparent()
    {
        String s = (String)get("x-mm-transparent");
        return s != null && Boolean.parseBoolean(s);
    }
}
