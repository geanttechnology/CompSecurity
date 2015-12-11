// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Set;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

public class ObscuredSharedPreferences
    implements SharedPreferences
{
    public class Editor
        implements android.content.SharedPreferences.Editor
    {

        private android.content.SharedPreferences.Editor _flddelegate;
        final ObscuredSharedPreferences this$0;

        public void apply()
        {
            _flddelegate.apply();
        }

        public volatile android.content.SharedPreferences.Editor clear()
        {
            return clear();
        }

        public Editor clear()
        {
            _flddelegate.clear();
            return this;
        }

        public boolean commit()
        {
            _flddelegate.apply();
            return true;
        }

        public volatile android.content.SharedPreferences.Editor putBoolean(String s, boolean flag)
        {
            return putBoolean(s, flag);
        }

        public Editor putBoolean(String s, boolean flag)
        {
            _flddelegate.putString(s, encrypt(Boolean.toString(flag)));
            return this;
        }

        public volatile android.content.SharedPreferences.Editor putFloat(String s, float f)
        {
            return putFloat(s, f);
        }

        public Editor putFloat(String s, float f)
        {
            _flddelegate.putString(s, encrypt(Float.toString(f)));
            return this;
        }

        public volatile android.content.SharedPreferences.Editor putInt(String s, int i)
        {
            return putInt(s, i);
        }

        public Editor putInt(String s, int i)
        {
            _flddelegate.putString(s, encrypt(Integer.toString(i)));
            return this;
        }

        public volatile android.content.SharedPreferences.Editor putLong(String s, long l)
        {
            return putLong(s, l);
        }

        public Editor putLong(String s, long l)
        {
            _flddelegate.putString(s, encrypt(Long.toString(l)));
            return this;
        }

        public volatile android.content.SharedPreferences.Editor putString(String s, String s1)
        {
            return putString(s, s1);
        }

        public Editor putString(String s, String s1)
        {
            _flddelegate.putString(s, encrypt(s1));
            return this;
        }

        public android.content.SharedPreferences.Editor putStringSet(String s, Set set)
        {
            _flddelegate.putStringSet(s, set);
            return this;
        }

        public volatile android.content.SharedPreferences.Editor remove(String s)
        {
            return remove(s);
        }

        public Editor remove(String s)
        {
            _flddelegate.remove(s);
            return this;
        }

        public Editor()
        {
            this$0 = ObscuredSharedPreferences.this;
            super();
            _flddelegate = ObscuredSharedPreferences.this._flddelegate.edit();
        }
    }


    private static final char SEKRIT[] = Double.toString(Math.pow(76D, 2D) + 2D).toCharArray();
    private static final String UTF8 = "utf-8";
    private String androidId;
    private SharedPreferences _flddelegate;
    private byte salt[];

    public ObscuredSharedPreferences(Application application, SharedPreferences sharedpreferences)
    {
        _flddelegate = sharedpreferences;
        try
        {
            androidId = android.provider.Settings.Secure.getString(application.getContentResolver(), "android_id");
            if (androidId == null)
            {
                androidId = "9774d56d682e549c";
            }
            salt = androidId.getBytes("utf-8");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Application application)
        {
            throw new RuntimeException(application);
        }
    }

    public static String decrypt(byte abyte0[], String s)
        throws Exception
    {
        javax.crypto.SecretKey secretkey;
        Cipher cipher;
        if (s != null)
        {
            s = Base64.decode(s, 0);
        } else
        {
            s = new byte[0];
        }
        secretkey = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(new PBEKeySpec(SEKRIT));
        cipher = Cipher.getInstance("PBEWithMD5AndDES");
        cipher.init(2, secretkey, new PBEParameterSpec(abyte0, 20));
        return new String(cipher.doFinal(s), "utf-8");
    }

    protected static String encrypt(byte abyte0[], String s)
        throws Exception
    {
        javax.crypto.SecretKey secretkey;
        Cipher cipher;
        if (s != null)
        {
            s = s.getBytes("utf-8");
        } else
        {
            s = new byte[0];
        }
        secretkey = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(new PBEKeySpec(SEKRIT));
        cipher = Cipher.getInstance("PBEWithMD5AndDES");
        cipher.init(1, secretkey, new PBEParameterSpec(abyte0, 20));
        return Base64.encodeToString(cipher.doFinal(s), 0);
    }

    public boolean contains(String s)
    {
        return _flddelegate.contains(s);
    }

    public String decrypt(String s)
    {
        String s1;
        try
        {
            s1 = decrypt(salt, s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            _flddelegate.edit().clear().apply();
            return null;
        }
        catch (Exception exception)
        {
            throw new RuntimeException(String.format("Error decrypting string for android id %s: %s", new Object[] {
                androidId, s
            }), exception);
        }
        return s1;
    }

    public volatile android.content.SharedPreferences.Editor edit()
    {
        return edit();
    }

    public Editor edit()
    {
        return new Editor();
    }

    protected String encrypt(String s)
    {
        String s1;
        try
        {
            s1 = encrypt(salt, s);
        }
        catch (Exception exception)
        {
            throw new RuntimeException(String.format("Error encrypting string for android id %s: %s", new Object[] {
                androidId, s
            }), exception);
        }
        return s1;
    }

    public Map getAll()
    {
        throw new UnsupportedOperationException();
    }

    public boolean getBoolean(String s, boolean flag)
    {
        for (s = _flddelegate.getString(s, null); s == null || decrypt(s) == null;)
        {
            return flag;
        }

        return Boolean.parseBoolean(decrypt(s));
    }

    public float getFloat(String s, float f)
    {
        for (s = _flddelegate.getString(s, null); s == null || decrypt(s) == null;)
        {
            return f;
        }

        return Float.parseFloat(decrypt(s));
    }

    public int getInt(String s, int i)
    {
        for (s = _flddelegate.getString(s, null); s == null || decrypt(s) == null;)
        {
            return i;
        }

        return Integer.parseInt(decrypt(s));
    }

    public long getLong(String s, long l)
    {
        for (s = _flddelegate.getString(s, null); s == null || decrypt(s) == null;)
        {
            return l;
        }

        return Long.parseLong(decrypt(s));
    }

    public String getString(String s, String s1)
    {
        for (s = _flddelegate.getString(s, null); s == null || decrypt(s) == null;)
        {
            return s1;
        }

        return decrypt(s);
    }

    public Set getStringSet(String s, Set set)
    {
        return _flddelegate.getStringSet(s, set);
    }

    public void registerOnSharedPreferenceChangeListener(android.content.SharedPreferences.OnSharedPreferenceChangeListener onsharedpreferencechangelistener)
    {
        _flddelegate.registerOnSharedPreferenceChangeListener(onsharedpreferencechangelistener);
    }

    public void unregisterOnSharedPreferenceChangeListener(android.content.SharedPreferences.OnSharedPreferenceChangeListener onsharedpreferencechangelistener)
    {
        _flddelegate.unregisterOnSharedPreferenceChangeListener(onsharedpreferencechangelistener);
    }


}
