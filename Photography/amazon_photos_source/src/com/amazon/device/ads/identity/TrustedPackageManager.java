// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads.identity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;

public class TrustedPackageManager
{

    private final PackageManager packageManager;
    private final String packageName;
    private volatile Set trustedCerts;

    public TrustedPackageManager(String s, PackageManager packagemanager, Set set)
    {
        packageName = s;
        packageManager = packagemanager;
        trustedCerts = set;
    }

    private int checkSignature(String s)
    {
_L2:
        return 0;
        if (packageName.equals(s) || packageManager.checkSignatures(packageName, s) == 0) goto _L2; else goto _L1
_L1:
        if (trustedCerts == null)
        {
            return -3;
        }
        Object obj;
        int i;
        int j;
        boolean flag;
        try
        {
            s = packageManager.getPackageInfo(s, 64).signatures;
            j = s.length;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return -4;
        }
        i = 0;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        obj = s[i];
        flag = trustedCerts.contains(obj);
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        i = 1;
_L4:
        if (i == 0)
        {
            return -3;
        }
        if (true) goto _L2; else goto _L3
_L3:
        i++;
        break MISSING_BLOCK_LABEL_58;
        i = 0;
          goto _L4
    }

    public Set getTrustedInstalledPackages()
    {
        Object obj = packageManager.getInstalledPackages(0);
        HashSet hashset = new HashSet();
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            PackageInfo packageinfo = (PackageInfo)((Iterator) (obj)).next();
            String s = packageinfo.packageName;
            boolean flag;
            if (s.startsWith("android") || s.startsWith("com.android") || s.startsWith("com.google"))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                if (checkSignature(packageinfo.packageName) == 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    hashset.add(packageinfo.packageName);
                }
            }
        } while (true);
        return hashset;
    }

    public JSONArray getTrustedInstalledPackagesJSONArray()
    {
        JSONArray jsonarray = new JSONArray();
        for (Iterator iterator = getTrustedInstalledPackages().iterator(); iterator.hasNext(); jsonarray.put((String)iterator.next())) { }
        return jsonarray;
    }
}
