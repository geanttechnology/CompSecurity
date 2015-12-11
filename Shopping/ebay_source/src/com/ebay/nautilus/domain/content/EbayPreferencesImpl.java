// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.dm.UserContext;
import java.util.Set;

// Referenced classes of package com.ebay.nautilus.domain.content:
//            EbayPreferences

public class EbayPreferencesImpl
    implements EbayPreferences
{
    private static class EditorImpl
        implements EbayPreferences.Editor
    {

        private final String currentUser;
        private final android.content.SharedPreferences.Editor editor;
        private final EbayPreferencesImpl preferences;

        private String getKey(boolean flag, String s)
        {
            EbayPreferencesImpl ebaypreferencesimpl = preferences;
            String s1;
            if (flag)
            {
                s1 = currentUser;
            } else
            {
                s1 = "";
            }
            return ebaypreferencesimpl.getKey(s1, s);
        }

        public void apply()
        {
            editor.apply();
        }

        public EbayPreferences.Editor clear()
        {
            editor.clear();
            return this;
        }

        public boolean commit()
        {
            return editor.commit();
        }

        public EbayPreferences.Editor putBoolean(boolean flag, String s, boolean flag1)
        {
            editor.putBoolean(getKey(flag, s), flag1);
            return this;
        }

        public EbayPreferences.Editor putFloat(boolean flag, String s, float f)
        {
            editor.putFloat(getKey(flag, s), f);
            return this;
        }

        public EbayPreferences.Editor putInt(boolean flag, String s, int i)
        {
            editor.putInt(getKey(flag, s), i);
            return this;
        }

        public EbayPreferences.Editor putLong(boolean flag, String s, long l)
        {
            editor.putLong(getKey(flag, s), l);
            return this;
        }

        public EbayPreferences.Editor putString(boolean flag, String s, String s1)
        {
            editor.putString(getKey(flag, s), s1);
            return this;
        }

        public EbayPreferences.Editor putStringSet(boolean flag, String s, Set set)
        {
            editor.putStringSet(getKey(flag, s), set);
            return this;
        }

        public EbayPreferences.Editor remove(boolean flag, String s)
        {
            editor.remove(getKey(flag, s));
            return this;
        }

        public EditorImpl(EbayPreferencesImpl ebaypreferencesimpl, android.content.SharedPreferences.Editor editor1)
        {
            preferences = ebaypreferencesimpl;
            editor = editor1;
            currentUser = ebaypreferencesimpl.getCurrentUser();
        }
    }


    private final String prefix;
    private final SharedPreferences prefs;
    private final UserContext userContext;

    public EbayPreferencesImpl(UserContext usercontext, String s, SharedPreferences sharedpreferences)
    {
        if (usercontext == null)
        {
            throw new IllegalArgumentException("userContext is null");
        }
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("prefix is null or empty");
        }
        if (sharedpreferences == null)
        {
            throw new IllegalArgumentException("prefs is null");
        } else
        {
            userContext = usercontext;
            prefix = (new StringBuilder()).append(s).append('.').toString();
            prefs = sharedpreferences;
            return;
        }
    }

    private String getKey(boolean flag, String s)
    {
        String s1;
        if (flag)
        {
            s1 = getCurrentUser();
        } else
        {
            s1 = "";
        }
        return getKey(s1, s);
    }

    public boolean contains(boolean flag, String s)
    {
        return prefs.contains(getKey(flag, s));
    }

    public EbayPreferences.Editor edit()
    {
        return new EditorImpl(this, prefs.edit());
    }

    public Authentication getAuthentication()
    {
        return userContext.getCurrentUser();
    }

    public boolean getBoolean(boolean flag, String s, boolean flag1)
    {
        return prefs.getBoolean(getKey(flag, s), flag1);
    }

    public EbayCountry getCurrentCountry()
    {
        return userContext.ensureCountry();
    }

    public String getCurrentUser()
    {
        return userContext.getCurrentUserId();
    }

    public float getFloat(boolean flag, String s, float f)
    {
        return prefs.getFloat(getKey(flag, s), f);
    }

    public int getInt(boolean flag, String s, int i)
    {
        return prefs.getInt(getKey(flag, s), i);
    }

    final String getKey(String s, String s1)
    {
        if (TextUtils.isEmpty(s1))
        {
            throw new IllegalArgumentException("key is null or empty");
        }
        if (s.length() != 0)
        {
            return (new StringBuilder()).append(prefix).append(s).append('.').append(s1).toString();
        } else
        {
            return (new StringBuilder()).append(prefix).append(s1).toString();
        }
    }

    public long getLong(boolean flag, String s, long l)
    {
        return prefs.getLong(getKey(flag, s), l);
    }

    public String getString(boolean flag, String s, String s1)
    {
        return prefs.getString(getKey(flag, s), s1);
    }

    public Set getStringSet(boolean flag, String s, Set set)
    {
        return prefs.getStringSet(getKey(flag, s), set);
    }
}
