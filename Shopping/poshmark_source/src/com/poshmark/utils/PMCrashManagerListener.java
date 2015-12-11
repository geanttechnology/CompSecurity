// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import com.poshmark.application.PMApplicationSession;
import net.hockeyapp.android.CrashManagerListener;

public class PMCrashManagerListener extends CrashManagerListener
{

    public PMCrashManagerListener()
    {
    }

    public String getUserID()
    {
        if (PMApplicationSession.GetPMSession().isLoggedIn())
        {
            return (new StringBuilder()).append(PMApplicationSession.GetPMSession().getUserName()).append("/").append(PMApplicationSession.GetPMSession().getUserId()).toString();
        } else
        {
            return "Not logged in";
        }
    }
}
