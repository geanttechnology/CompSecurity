// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.singular.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

// Referenced classes of package net.singular.sdk:
//            SingularLog

class ManifestHelper
{

    private final Context context;
    private final SingularLog log;

    public ManifestHelper(Context context1, SingularLog singularlog)
    {
        context = context1;
        log = singularlog;
    }

    private Bundle getApplicationMetadata()
        throws Exception
    {
        Object obj;
        try
        {
            obj = context.getPackageName();
            obj = context.getPackageManager().getApplicationInfo(((String) (obj)), 128).metaData;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            log.trackError("singular_sdk", "ApplicationInfo not found");
            throw namenotfoundexception;
        }
        catch (Exception exception)
        {
            log.trackError("singular_sdk", "Failed to get ApplicationBundle (%s)", exception);
            throw exception;
        }
        return ((Bundle) (obj));
    }

    public String getManifestAttribute(String s, String s1, String s2, boolean flag)
    {
        Object obj = getApplicationMetadata().get(s);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        obj = obj.toString();
        return ((String) (obj));
        Exception exception;
        exception;
        log.trackError("singular_sdk", String.format("%s: getManifestAttribute: something went wrong", new Object[] {
            s2
        }), exception);
        if (flag)
        {
            Log.e("singular_sdk", String.format("Couldn't read %s, you must set a metadata tag named \"%s\" in your AndroidManifest.xml file", new Object[] {
                s1, s
            }));
        }
        return null;
    }

    public boolean tryToGetManifestAttributeBool(String s, boolean flag)
    {
        String s1 = getManifestAttribute(s, s, "tryToGetManifestAttributeBool", false);
        boolean flag1 = flag;
        if (s1 != null)
        {
            try
            {
                flag1 = Boolean.valueOf(Boolean.parseBoolean(s1)).booleanValue();
            }
            catch (RuntimeException runtimeexception)
            {
                log.trackError("singular_sdk", String.format("Couldn't parse \"%s\" value \"%s\" in your AndroidManifest.xml file", new Object[] {
                    s, s1
                }));
                return flag;
            }
        }
        return flag1;
    }

    public long tryToGetManifestAttributeLong(String s, long l)
    {
        s = tryToGetManifestAttributeLong(s);
        if (s != null)
        {
            l = s.longValue();
        }
        return l;
    }

    public Long tryToGetManifestAttributeLong(String s)
    {
        String s1;
        s1 = getManifestAttribute(s, s, "tryToGetManifestAttributeLong", false);
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        Long long1 = Long.decode(s1);
        return long1;
        RuntimeException runtimeexception;
        runtimeexception;
        Log.e("singular_sdk", String.format("Couldn't parse \"%s\" value \"%s\" in your AndroidManifest.xml file", new Object[] {
            s, s1
        }));
        return null;
    }
}
