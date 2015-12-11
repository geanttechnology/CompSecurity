// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import java.util.UUID;

public class VisitedScreen
{

    UUID fragmentID;
    String screenName;

    public VisitedScreen(UUID uuid, String s)
    {
        fragmentID = uuid;
        screenName = s;
    }
}
