// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nielsen.app.sdk;

import android.content.SharedPreferences;
import java.security.NoSuchAlgorithmException;
import javax.crypto.NoSuchPaddingException;

// Referenced classes of package com.nielsen.app.sdk:
//            AppCryptoManager, AppPreferencesManager

public class b extends AppCryptoManager
{

    final AppPreferencesManager a;
    private android.content.ger.b b;

    public void apply()
    {
        b.b();
    }

    public b clear()
    {
        b.b();
        return this;
    }

    public boolean commit()
    {
        return b.b();
    }

    public volatile String decrypt(String s, int i)
        throws NoSuchAlgorithmException, NoSuchPaddingException, Exception
    {
        return super.decrypt(s, i);
    }

    public volatile String encrypt(String s, int i)
        throws NoSuchAlgorithmException, NoSuchPaddingException, Exception
    {
        return super.encrypt(s, i);
    }

    public b putBoolean(String s, boolean flag)
        throws NoSuchAlgorithmException, NoSuchPaddingException, Exception
    {
        b.b(encrypt((new StringBuilder()).append('B').append(s).toString(), 1), encrypt(Boolean.toString(flag), 0));
        return this;
    }

    public encrypt putDouble(String s, double d)
        throws NoSuchAlgorithmException, NoSuchPaddingException, Exception
    {
        b.b(encrypt((new StringBuilder()).append('D').append(s).toString(), 1), encrypt(Double.toString(d), 0));
        return this;
    }

    public encrypt putFloat(String s, float f)
        throws NoSuchAlgorithmException, NoSuchPaddingException, Exception
    {
        b.b(encrypt((new StringBuilder()).append('F').append(s).toString(), 1), encrypt(Float.toString(f), 0));
        return this;
    }

    public encrypt putInt(String s, int i)
        throws NoSuchAlgorithmException, NoSuchPaddingException, Exception
    {
        b.b(encrypt((new StringBuilder()).append('I').append(s).toString(), 1), encrypt(Integer.toString(i), 0));
        return this;
    }

    public encrypt putLong(String s, long l)
        throws NoSuchAlgorithmException, NoSuchPaddingException, Exception
    {
        b.b(encrypt((new StringBuilder()).append('L').append(s).toString(), 1), encrypt(Long.toString(l), 0));
        return this;
    }

    public encrypt putString(String s, String s1)
        throws NoSuchAlgorithmException, NoSuchPaddingException, Exception
    {
        s = encrypt((new StringBuilder()).append('S').append(s).toString(), 1);
        s1 = encrypt(s1, 0);
        b.b(s, s1);
        return this;
    }

    public b remove(String s)
        throws NoSuchAlgorithmException, NoSuchPaddingException, Exception
    {
        char c = a.a(s);
        if (c != 'U')
        {
            b.b(encrypt((new StringBuilder()).append(c).append(s).toString(), 1));
        }
        return this;
    }

    public encrypt remove(String s, char c)
        throws NoSuchAlgorithmException, NoSuchPaddingException, Exception
    {
        s = encrypt((new StringBuilder()).append(c).append(s).toString(), 1);
        if (AppPreferencesManager.a(a).contains(s))
        {
            b.b(s);
        }
        return this;
    }

    public (AppPreferencesManager apppreferencesmanager)
    {
        a = apppreferencesmanager;
        super();
        b = null;
        if (b == null)
        {
            b = AppPreferencesManager.a(apppreferencesmanager).edit();
        }
    }
}
