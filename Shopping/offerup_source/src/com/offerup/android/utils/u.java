// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.utils;

import android.util.Log;
import com.b.a.a.g;
import com.google.gson.Gson;
import com.offerup.android.dto.ErrorResponse;
import com.offerup.android.f.a;
import com.offerup.android.gson.GsonManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.commons.lang3.StringUtils;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.mime.TypedInput;

public final class u
{

    private static String a = "ErrorHelper";

    public static String a(RetrofitError retrofiterror, String s)
    {
        Object obj = s;
        if (retrofiterror == null) goto _L2; else goto _L1
_L1:
        obj = s;
        if (retrofiterror.getResponse() == null) goto _L2; else goto _L3
_L3:
        obj = s;
        if (retrofiterror.getResponse().getBody() == null) goto _L2; else goto _L4
_L4:
        BufferedReader bufferedreader;
        obj = retrofiterror.getResponse().getBody().in();
        bufferedreader = new BufferedReader(new InputStreamReader(((InputStream) (obj))));
        retrofiterror = new StringBuilder();
_L7:
        String s1 = bufferedreader.readLine();
        if (s1 == null) goto _L6; else goto _L5
_L5:
        retrofiterror.append((new StringBuilder()).append(s1).append("\n").toString());
          goto _L7
        IOException ioexception1;
        ioexception1;
        g.a(a, ioexception1);
        ((InputStream) (obj)).close();
_L10:
        obj = GsonManager.getGson();
        retrofiterror = retrofiterror.toString();
        g.a(a, new a(retrofiterror));
        retrofiterror = (ErrorResponse)((Gson) (obj)).fromJson(retrofiterror, com/offerup/android/dto/ErrorResponse);
        obj = s;
        if (retrofiterror.getStatus().getError() == null) goto _L2; else goto _L8
_L8:
        boolean flag;
        retrofiterror = retrofiterror.getStatus().getError().getDescription();
        flag = StringUtils.isNotEmpty(retrofiterror);
        obj = s;
        if (flag)
        {
            obj = retrofiterror;
        }
_L2:
        return ((String) (obj));
_L6:
        ((InputStream) (obj)).close();
        continue; /* Loop/switch isn't completed */
        obj;
        try
        {
            g.a(a, ((Exception) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (RetrofitError retrofiterror)
        {
            g.c("ErrorHelper", Log.getStackTraceString(retrofiterror));
            return s;
        }
        continue; /* Loop/switch isn't completed */
        obj;
        g.a(a, ((Exception) (obj)));
        if (true) goto _L10; else goto _L9
_L9:
        retrofiterror;
        ((InputStream) (obj)).close();
_L11:
        throw retrofiterror;
        IOException ioexception;
        ioexception;
        g.a(a, ioexception);
          goto _L11
        retrofiterror;
        g.a(a, retrofiterror);
        return s;
    }

}
