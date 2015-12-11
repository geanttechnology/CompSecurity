// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.iovation.mobile.android.details;

import android.content.Context;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;

public class k
{

    static String a(InputStream inputstream)
    {
        StringBuilder stringbuilder;
        stringbuilder = new StringBuilder();
        inputstream = new BufferedReader(new InputStreamReader(inputstream));
_L1:
        String s = inputstream.readLine();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        stringbuilder.append(s);
        stringbuilder.append("\n");
          goto _L1
        IOException ioexception;
        ioexception;
        Log.e("DetailUtil", (new StringBuilder()).append("------ getStringFromInputStream ").append(ioexception.getMessage()).toString());
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream)
            {
                Log.e("DetailUtil", (new StringBuilder()).append("------ getStringFromInputStream ").append(inputstream.getMessage()).toString());
            }
        }
        return stringbuilder.toString();
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream)
            {
                Log.e("DetailUtil", (new StringBuilder()).append("------ getStringFromInputStream ").append(inputstream.getMessage()).toString());
            }
        }
        if (true)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        Exception exception;
        exception;
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream)
            {
                Log.e("DetailUtil", (new StringBuilder()).append("------ getStringFromInputStream ").append(inputstream.getMessage()).toString());
            }
        }
        throw exception;
    }

    static String a(String s)
    {
        try
        {
            s = a(Runtime.getRuntime().exec(s).getInputStream());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("DetailUtil", (new StringBuilder()).append("------ getCpuInfo ").append(s.getMessage()).toString());
            return null;
        }
        return s;
    }

    static String a(byte abyte0[])
    {
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.update(abyte0);
            abyte0 = b(messagedigest.digest());
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            return null;
        }
        return abyte0;
    }

    public static boolean a(String s, Context context)
    {
        return context.checkCallingOrSelfPermission(s) == 0;
    }

    static String b(String s)
    {
        if (s != null)
        {
            if ((s = s.split("\n")) != null && s.length >= 1)
            {
                return s[0];
            }
        }
        return null;
    }

    static String b(byte abyte0[])
    {
        StringBuffer stringbuffer = new StringBuffer();
        for (int i = 0; i < abyte0.length; i++)
        {
            stringbuffer.append(Integer.toHexString(abyte0[i] & 0xff));
        }

        return stringbuffer.toString();
    }
}
