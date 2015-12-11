// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ax;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.shazam.model.availability.AppInstallationVerifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e
    implements AppInstallationVerifier
{

    private final PackageManager a;

    public e(PackageManager packagemanager)
    {
        a = packagemanager;
    }

    public final List a()
    {
        Object obj = a.getInstalledApplications(128);
        ArrayList arraylist = new ArrayList(((List) (obj)).size());
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); arraylist.add(((ApplicationInfo)((Iterator) (obj)).next()).packageName)) { }
        return arraylist;
    }

    public final boolean a(String s)
    {
        try
        {
            a.getApplicationInfo(s, 0);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        return true;
    }
}
