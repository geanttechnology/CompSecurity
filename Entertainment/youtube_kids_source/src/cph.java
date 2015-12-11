// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

public final class cph extends me
{

    private static final byte j[] = {
        83, 0, 0, 0, 0, 0, 0, 0, 0
    };
    private final Cipher k = Cipher.getInstance("AES/CTR/NoPadding");
    private final byte l[];
    private final Key m;
    private final Key n;
    private final int o = 4;
    private final mk p;

    public cph(Uri uri, mj mj, byte abyte0[], int i)
    {
        super(1, uri.toString(), mj);
        p = (mk)b.a(mj);
        b.a(true);
        boolean flag;
        if (abyte0.length > 16)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.a(flag, "projectKey must contain 16-byte key");
        i = abyte0.length - 16;
        uri = new byte[16];
        mj = new byte[i];
        System.arraycopy(abyte0, 0, uri, 0, 16);
        System.arraycopy(abyte0, 16, mj, 0, i);
        m = new SecretKeySpec(uri, "AES");
        n = new SecretKeySpec(mj, "HmacSHA1");
        abyte0 = ByteBuffer.allocate(abyte0.length + 16);
        abyte0.putLong(16L);
        abyte0.put(uri);
        abyte0.putLong(i);
        abyte0.put(mj);
        l = a.b(bnh.a(abyte0.array()), 4);
    }

    private byte[] c(String s)
    {
        byte abyte0[];
        byte abyte1[];
        int i;
        s = Base64.decode(s, 0);
        boolean flag;
        if (s.length > 17)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.b(flag, "Encrypted string is invalid.");
        if (s[0] != 0)
        {
            throw new JSONException("Bad 'type' in encoded string.");
        }
        if (!Arrays.equals(a.a(s, 1, 4), l))
        {
            throw new JSONException("Project key signature does not match.");
        }
        i = s.length - o;
        abyte0 = a.a(s, 0, i);
        if (!Arrays.equals(a.a(s, i, o), a.b(cpe.a(n, a.a(new byte[][] {
    j, abyte0
})), o)))
        {
            throw new JSONException("HMAC signature does not match.");
        }
        abyte0 = a.a(a.a(s, 5, 8), 16);
        i = s.length - 13 - o;
        abyte1 = a.a(a.a(s, 13, i), 16);
        synchronized (k)
        {
            k.init(2, m, new IvParameterSpec(abyte0));
            abyte0 = a.b(k.doFinal(abyte1), i);
        }
        return abyte0;
        exception;
        s;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException("Fatal error: project encryption key invalid.", s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException("Fatal error: initialization vector is the wrong size.", s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException("Unexpected IllegalBlockSizeException.", s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new JSONException("Bad input padding.");
        }
    }

    protected final mi a(mb mb1)
    {
        try
        {
            JSONObject jsonobject = new JSONObject(new String(mb1.b, "UTF-8"));
            mb1 = mi.a(new cpe(jsonobject.getString("id"), c(jsonobject.getString("key"))), a.a(mb1));
        }
        // Misplaced declaration of an exception variable
        catch (mb mb1)
        {
            return mi.a(new md(mb1));
        }
        // Misplaced declaration of an exception variable
        catch (mb mb1)
        {
            throw new RuntimeException("Could not find UTF-8 character set!");
        }
        return mb1;
    }

    protected final void a(Object obj)
    {
        obj = (cpe)obj;
        p.a(obj);
    }

}
