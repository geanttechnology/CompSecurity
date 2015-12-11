// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.iovation.mobile.android.details;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

// Referenced classes of package com.iovation.mobile.android.details:
//            i, j

public class t
    implements i
{

    private static final SecretKey a = new SecretKeySpec(new byte[] {
        -41, -33, -54, 50, -48, 86, 104, 117, -21, 6, 
        -96, -70, 10, -94, 7, 79, -63, -117, -49, -113, 
        50, 38, 116, -64, -110, -60, -91, 11, 62, -76, 
        -25, -68
    }, "AES");
    private String b;

    public t()
    {
        b = a();
    }

    private String a()
    {
        String s;
        try
        {
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(1, a);
            byte abyte2[] = UUID.randomUUID().toString().replace("-", "").toUpperCase(Locale.getDefault()).getBytes();
            byte abyte0[] = cipher.getIV();
            byte abyte1[] = cipher.doFinal(abyte2);
            abyte2 = new byte[abyte0.length + abyte1.length];
            System.arraycopy(abyte0, 0, abyte2, 0, abyte0.length);
            System.arraycopy(abyte1, 0, abyte2, abyte0.length, abyte1.length);
            s = Base64.encodeToString(abyte2, 2);
        }
        catch (Exception exception)
        {
            return "";
        }
        return s;
    }

    private String a(Context context)
    {
        StringBuilder stringbuilder = new StringBuilder();
        context = new BufferedReader(new InputStreamReader(context.openFileInput("ioadft"), "UTF-8"));
_L1:
        String s = context.readLine();
label0:
        {
            if (s == null)
            {
                break label0;
            }
            try
            {
                stringbuilder.append(s);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return "";
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return "";
            }
        }
          goto _L1
        context = stringbuilder.toString();
        return context;
    }

    private String b(Context context)
    {
        try
        {
            context = context.openFileOutput("ioadft", 0);
            context.write(b.getBytes());
            context.close();
            context = b;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return "";
        }
        return context;
    }

    private String c(Context context)
    {
        context = context.getSharedPreferences("IOSPT", 0);
        if (context.contains("IOSPT"))
        {
            return context.getString("IOSPT", "");
        } else
        {
            return "";
        }
    }

    private String d(Context context)
    {
        context = context.getSharedPreferences("IOSPT", 0).edit();
        context.putString("IOSPT", b);
        context.commit();
        return b;
    }

    public void a(Context context, j j1)
    {
        String s2;
        String s3;
        s2 = a(context);
        s3 = c(context);
        if (s2 != null && s2 != "" || s3 == null || s3 == "") goto _L2; else goto _L1
_L1:
        String s;
        String s1;
        b = s3;
        s1 = b(context);
        s = s3;
_L4:
        j1.a("ADFTOKEN", s1);
        j1.a("SPATOKEN", s);
        return;
_L2:
        if (s2 != null && s2 != "" && (s3 == null || s3 == ""))
        {
            b = s2;
            s = d(context);
            s1 = s2;
            continue; /* Loop/switch isn't completed */
        }
        if (s2 != null)
        {
            s = s3;
            s1 = s2;
            if (s2 != "")
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        if (s3 != null)
        {
            s = s3;
            s1 = s2;
            if (s3 != "")
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        b = a();
        s1 = b(context);
        s = d(context);
        if (true) goto _L4; else goto _L3
_L3:
    }

}
