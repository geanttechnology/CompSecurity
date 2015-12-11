// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.notifications;

import java.util.HashSet;

public class PMDisplayedAlerts
{

    public static HashSet displayedPartyAlerts = new HashSet();

    public PMDisplayedAlerts()
    {
    }

    public static void addEventToDisplayedList(String s)
    {
        displayedPartyAlerts.add(s);
    }

    public static boolean isEventAlertDisplayed(String s)
    {
        return displayedPartyAlerts.contains(s);
    }

    public static void removeDisplayedAlertFromList(String s)
    {
        displayedPartyAlerts.remove(s);
    }

}
