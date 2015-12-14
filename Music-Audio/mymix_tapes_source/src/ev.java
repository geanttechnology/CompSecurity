// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public final class ev
{

    private static SSLSocketFactory a;
    private static SSLContext b;
    private static ew c[] = new ew[1];

    public static Socket a(String s, int i, ex ex)
        throws UnknownHostException, IOException, SecurityException
    {
        try
        {
            c[0] = new ew(ex);
            ex = SSLContext.getInstance("TLS");
            b = ex;
            ex.init(null, (javax.net.ssl.TrustManager[])c, null);
            a = b.getSocketFactory();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new SecurityException((new StringBuilder("No such algorithm exception ")).append(s).toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new SecurityException((new StringBuilder("Failed to initialize the client-side SSLContext ")).append(s).toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new SecurityException((new StringBuilder("General security exception ")).append(s).toString());
        }
        return a.createSocket(s, i);
    }

}
