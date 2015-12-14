// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.cyberlink.beautycircle.Globals;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            a

public class k extends j
{

    public k()
    {
    }

    private void a(int i, String s)
    {
        if (e.a)
        {
            Globals.b((new StringBuilder()).append("Network Fail: ").append(i).append(" ").append(s).toString());
        }
        b(i);
    }

    protected volatile Object a(Object obj)
    {
        return a((u)obj);
    }

    protected byte[] a(u u1)
    {
        Object obj = null;
        if (!c()) goto _L2; else goto _L1
_L1:
        a(com.cyberlink.beautycircle.model.network.NetworkManager.NetworkErrorCode.e.a(), com.cyberlink.beautycircle.model.network.NetworkManager.NetworkErrorCode.e.toString());
        u1 = null;
_L6:
        return u1;
_L2:
        String s = u1.a();
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        a(NetworkManager.NetworkErrorCode.b.a(), NetworkManager.NetworkErrorCode.b.toString());
        if (false)
        {
            try
            {
                throw new NullPointerException();
            }
            // Misplaced declaration of an exception variable
            catch (u u1)
            {
                u1.printStackTrace();
            }
        }
        return null;
        HttpURLConnection httpurlconnection;
        httpurlconnection = (HttpURLConnection)(new URL(s)).openConnection();
        if (!c())
        {
            break MISSING_BLOCK_LABEL_137;
        }
        a(com.cyberlink.beautycircle.model.network.NetworkManager.NetworkErrorCode.e.a(), com.cyberlink.beautycircle.model.network.NetworkManager.NetworkErrorCode.e.toString());
        if (false)
        {
            try
            {
                throw new NullPointerException();
            }
            // Misplaced declaration of an exception variable
            catch (u u1)
            {
                u1.printStackTrace();
            }
        }
        return null;
        int i;
        httpurlconnection.setRequestMethod("POST");
        httpurlconnection.setRequestProperty("User-Agent", Key.Init.a.k);
        String s1 = Long.toHexString(System.currentTimeMillis());
        httpurlconnection.setRequestProperty("Content-Type", (new StringBuilder()).append("multipart/form-data; boundary=").append(s1).toString());
        httpurlconnection.setDoOutput(true);
        DataOutputStream dataoutputstream = new DataOutputStream(httpurlconnection.getOutputStream());
        PrintWriter printwriter = new PrintWriter(dataoutputstream);
        u1.a(printwriter, dataoutputstream, s1);
        printwriter.flush();
        printwriter.close();
        i = httpurlconnection.getResponseCode();
        if (!c())
        {
            break MISSING_BLOCK_LABEL_292;
        }
        a(com.cyberlink.beautycircle.model.network.NetworkManager.NetworkErrorCode.e.a(), com.cyberlink.beautycircle.model.network.NetworkManager.NetworkErrorCode.e.toString());
        if (false)
        {
            try
            {
                throw new NullPointerException();
            }
            // Misplaced declaration of an exception variable
            catch (u u1)
            {
                u1.printStackTrace();
            }
        }
        return null;
        if (i < 400 || i >= 600)
        {
            break MISSING_BLOCK_LABEL_341;
        }
        a(i, httpurlconnection.getResponseMessage());
        if (false)
        {
            try
            {
                throw new NullPointerException();
            }
            // Misplaced declaration of an exception variable
            catch (u u1)
            {
                u1.printStackTrace();
            }
        }
        return null;
        u1 = httpurlconnection.getInputStream();
        obj = u1;
        u1 = ((u) (obj));
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        u1 = ((u) (obj));
        byte abyte0[] = new byte[1024];
_L4:
        u1 = ((u) (obj));
        i = ((InputStream) (obj)).read(abyte0, 0, abyte0.length);
        if (i == -1)
        {
            break; /* Loop/switch isn't completed */
        }
        u1 = ((u) (obj));
        bytearrayoutputstream.write(abyte0, 0, i);
        if (true) goto _L4; else goto _L3
        abyte0;
_L9:
        u1 = ((u) (obj));
        abyte0.printStackTrace();
        u1 = ((u) (obj));
        a(NetworkManager.NetworkErrorCode.b.a(), NetworkManager.NetworkErrorCode.b.toString());
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (u u1)
            {
                u1.printStackTrace();
            }
        }
        return null;
_L3:
        u1 = ((u) (obj));
        if (!c())
        {
            break MISSING_BLOCK_LABEL_480;
        }
        u1 = ((u) (obj));
        a(com.cyberlink.beautycircle.model.network.NetworkManager.NetworkErrorCode.e.a(), com.cyberlink.beautycircle.model.network.NetworkManager.NetworkErrorCode.e.toString());
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (u u1)
            {
                u1.printStackTrace();
            }
        }
        return null;
        u1 = ((u) (obj));
        abyte0 = bytearrayoutputstream.toByteArray();
        u1 = ((u) (obj));
        bytearrayoutputstream.close();
        u1 = abyte0;
        if (obj == null) goto _L6; else goto _L5
_L5:
        try
        {
            ((InputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (u u1)
        {
            u1.printStackTrace();
            return abyte0;
        }
        return abyte0;
        u1;
_L8:
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((IOException) (obj)).printStackTrace();
            }
        }
        throw u1;
        abyte0;
        obj = u1;
        u1 = abyte0;
        if (true) goto _L8; else goto _L7
_L7:
        abyte0;
        obj = null;
          goto _L9
    }
}
