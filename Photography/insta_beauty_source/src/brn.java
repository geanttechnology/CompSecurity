// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.wantu.weibo.other.sina.WeiboException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class brn extends brk
{

    public brn()
    {
    }

    public bru a(bru bru1)
    {
        if (bru1 == null || bru1.a() == 0)
        {
            return null;
        } else
        {
            bru bru2 = new bru();
            bru2.a("oauth_callback", bru1.b("oauth_callback"));
            bru2.a("oauth_consumer_key", bru1.b("oauth_consumer_key"));
            bru2.a("oauth_nonce", bru1.b("oauth_nonce"));
            bru2.a("oauth_signature_method", bru1.b("oauth_signature_method"));
            bru2.a("oauth_timestamp", bru1.b("oauth_timestamp"));
            bru2.a("oauth_version", bru1.b("oauth_version"));
            bru2.a("source", bru1.b("source"));
            return bru2;
        }
    }

    public String a(String s, brp brp)
    {
        try
        {
            brp = Mac.getInstance("HmacSHA1");
            brp.init(new SecretKeySpec((new StringBuilder()).append(b(brt.c())).append("&").toString().getBytes(), "HmacSHA1"));
            s = brp.doFinal(s.getBytes());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new WeiboException(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new WeiboException(s);
        }
        return String.valueOf(brq.a(s));
    }

    public void a(bru bru1, bru bru2)
    {
    }
}
