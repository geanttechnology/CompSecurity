// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import opens.components.http.EOnlineDownType;

public class cex
{

    protected int a;
    private EOnlineDownType b;
    private ExecutorService c;
    private final Handler d = new Handler();

    public cex()
    {
        a = 50000;
        c = Executors.newFixedThreadPool(1);
    }

    static String a(cex cex1, String s)
    {
        return cex1.a(s);
    }

    private String a(InputStream inputstream)
    {
        StringBuilder stringbuilder;
        BufferedReader bufferedreader;
        bufferedreader = new BufferedReader(new InputStreamReader(inputstream));
        stringbuilder = new StringBuilder();
_L1:
        String s = bufferedreader.readLine();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        stringbuilder.append((new StringBuilder()).append(s).append("\n").toString());
          goto _L1
        IOException ioexception;
        ioexception;
        ioexception.printStackTrace();
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
        }
        return stringbuilder.toString();
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
        }
        if (true)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        Exception exception;
        exception;
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
        }
        throw exception;
    }

    private String a(String s)
    {
        int i;
        s = (HttpURLConnection)(new URL(s)).openConnection();
        s.setConnectTimeout(a);
        i = s.getResponseCode();
        if (i != 200) goto _L2; else goto _L1
_L1:
        s = s.getInputStream();
_L4:
        if (i != 200 || s == null)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        s = a(((InputStream) (s)));
        return s;
        s;
        s.printStackTrace();
        return null;
        s;
        try
        {
            s.printStackTrace();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        return null;
_L2:
        s = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    static EOnlineDownType a(cex cex1)
    {
        return cex1.b;
    }

    static Handler b(cex cex1)
    {
        return cex1.d;
    }

    public void a(String s, cfb cfb)
    {
        c.submit(new cey(this, s, cfb));
    }

    public void a(EOnlineDownType eonlinedowntype)
    {
        b = eonlinedowntype;
    }
}
