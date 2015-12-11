// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.http;

import com.groupon.service.cachebust.EmergencyDialogDisplayManager;
import com.groupon.util.ArraySharedPreferences;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.restlet.engine.util.InternetUsDateFormat;
import roboguice.util.Ln;
import roboguice.util.Strings;

public class CacheBustResponseInterceptor
    implements Interceptor
{

    EmergencyDialogDisplayManager emergencyDialogDisplayManager;
    private InternetUsDateFormat internetDateFormat;
    private ArraySharedPreferences prefs;

    public CacheBustResponseInterceptor()
    {
    }

    public Response intercept(com.squareup.okhttp.Interceptor.Chain chain)
        throws IOException
    {
        Object obj;
        Date date;
        chain = chain.proceed(chain.request());
        if (Strings.isEmpty(prefs.getString("firstIntercept", null)))
        {
            String s = internetDateFormat.format(new Date());
            prefs.edit().putString("firstIntercept", s).commit();
        }
        if (!Strings.notEmpty(chain.header("X-Groupon-Cache-Token", null)))
        {
            break MISSING_BLOCK_LABEL_144;
        }
        obj = chain.header("X-Groupon-Cache-Token", null);
        String s1 = prefs.getString("X-Groupon-Cache-Token", null);
        if (Strings.isEmpty(obj) || Strings.equals(s1, obj))
        {
            break MISSING_BLOCK_LABEL_144;
        }
        int i;
        try
        {
            date = internetDateFormat.parse(((String) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Ln.e(((Throwable) (obj)));
            return chain;
        }
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_154;
        }
        i = date.compareTo(internetDateFormat.parse(s1));
        if (i >= 0)
        {
            break MISSING_BLOCK_LABEL_154;
        }
        return chain;
        Date date1 = internetDateFormat.parse(prefs.getString("firstIntercept", null));
        if (date.getTime() - date1.getTime() >= TimeUnit.MINUTES.toMillis(1L))
        {
            break MISSING_BLOCK_LABEL_219;
        }
        prefs.edit().putString("X-Groupon-Cache-Token", ((String) (obj))).commit();
        return chain;
        Exception exception;
        exception;
        Ln.e(exception);
        emergencyDialogDisplayManager.onCacheBustHeaderReceived(((String) (obj)));
        return chain;
    }
}
