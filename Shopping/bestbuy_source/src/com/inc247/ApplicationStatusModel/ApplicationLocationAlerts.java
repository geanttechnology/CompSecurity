// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inc247.ApplicationStatusModel;


public class ApplicationLocationAlerts
{

    static boolean LocationAlertShowingOrNot;

    public ApplicationLocationAlerts()
    {
    }

    public static boolean getLocationAlertStatus()
    {
        return LocationAlertShowingOrNot;
    }

    public static void setLocationAlertShowingOrNot(boolean flag)
    {
        LocationAlertShowingOrNot = flag;
    }
}
