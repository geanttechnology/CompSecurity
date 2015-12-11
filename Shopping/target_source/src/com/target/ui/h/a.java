// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.h;

import com.parse.ParseInstallation;
import com.target.mothership.model.guest.interfaces.Guest;

public class a
    implements com.target.ui.l.a, com.target.ui.service.b
{

    private static a sInstance;
    private com.target.ui.l.a mUserPreferenceService;

    private a()
    {
        mUserPreferenceService = com.target.ui.l.a.a();
        mUserPreferenceService.a(this);
        com.target.ui.service.a.a().a(this);
    }

    public static void a()
    {
        if (sInstance != null)
        {
            return;
        } else
        {
            sInstance = new a();
            return;
        }
    }

    public void a(Guest guest)
    {
        ParseInstallation parseinstallation = ParseInstallation.getCurrentInstallation();
        if (parseinstallation != null)
        {
            parseinstallation.put("appGuestId", guest.getGuestId());
            parseinstallation.put("appGuestIsAnonymous", Boolean.valueOf(guest.isAnonymous()));
            parseinstallation.put("optIn", Boolean.valueOf(mUserPreferenceService.b()));
            parseinstallation.saveEventually();
        }
    }

    public void a(boolean flag)
    {
        ParseInstallation parseinstallation = ParseInstallation.getCurrentInstallation();
        if (parseinstallation != null)
        {
            parseinstallation.put("optIn", Boolean.valueOf(mUserPreferenceService.b()));
            parseinstallation.saveEventually();
        }
    }

    public void b()
    {
    }
}
