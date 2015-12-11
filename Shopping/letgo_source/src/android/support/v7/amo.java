// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;

// Referenced classes of package android.support.v7:
//            alt, amc, amq

public class amo
{

    public amo()
    {
    }

    protected String a()
    {
        return "Fabric could not be initialized, API key missing from AndroidManifest.xml. Add the following tag to your Application element \n\t<meta-data android:name=\"io.fabric.ApiKey\" android:value=\"YOUR_API_KEY\"/>";
    }

    public String a(Context context)
    {
        String s1 = b(context);
        String s = s1;
        if (TextUtils.isEmpty(s1))
        {
            s = c(context);
        }
        if (TextUtils.isEmpty(s))
        {
            d(context);
        }
        return s;
    }

    protected String b(Context context)
    {
        String s1 = null;
        Object obj = null;
        String s = s1;
        Object obj1;
        try
        {
            obj1 = context.getPackageName();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            alt.h().a("Fabric", (new StringBuilder()).append("Caught non-fatal exception while retrieving apiKey: ").append(context).toString());
            return s;
        }
        s = s1;
        obj1 = context.getPackageManager().getApplicationInfo(((String) (obj1)), 128).metaData;
        context = obj;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        s = s1;
        s1 = ((Bundle) (obj1)).getString("io.fabric.ApiKey");
        context = s1;
        if (s1 != null)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        s = s1;
        alt.h().a("Fabric", "Falling back to Crashlytics key lookup from Manifest");
        s = s1;
        context = ((Bundle) (obj1)).getString("com.crashlytics.ApiKey");
        return context;
    }

    protected String c(Context context)
    {
        String s = null;
        int j = amq.a(context, "io.fabric.ApiKey", "string");
        int i = j;
        if (j == 0)
        {
            alt.h().a("Fabric", "Falling back to Crashlytics key lookup from Strings");
            i = amq.a(context, "com.crashlytics.ApiKey", "string");
        }
        if (i != 0)
        {
            s = context.getResources().getString(i);
        }
        return s;
    }

    protected void d(Context context)
    {
        if (alt.i() || amq.i(context))
        {
            throw new IllegalArgumentException(a());
        } else
        {
            alt.h().e("Fabric", a());
            return;
        }
    }
}
