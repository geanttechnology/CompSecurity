// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.eas;

import java.util.ArrayList;
import java.util.EventListener;

public abstract class AlertEventListener
    implements EventListener
{

    public AlertEventListener()
    {
    }

    public void emergencyAlertCompleted(String s, boolean flag)
    {
    }

    public void emergencyAlertFailed(String s, String s1, String s2, boolean flag)
    {
    }

    public void emergencyAlertStarted(String s, boolean flag)
    {
    }

    public void fipsCodeFound(String s)
    {
    }

    public void requestFailed(String s)
    {
    }

    public void updateAlertsReceived(ArrayList arraylist)
    {
    }
}
