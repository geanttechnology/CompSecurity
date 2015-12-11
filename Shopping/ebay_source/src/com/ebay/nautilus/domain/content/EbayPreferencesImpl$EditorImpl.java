// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content;

import java.util.Set;

// Referenced classes of package com.ebay.nautilus.domain.content:
//            EbayPreferencesImpl

private static class ser
    implements ser
{

    private final String currentUser;
    private final android.content.sImpl.EditorImpl.getKey editor;
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
        editor.editor();
    }

    public editor clear()
    {
        editor.editor();
        return this;
    }

    public boolean commit()
    {
        return editor.();
    }

    public editor putBoolean(boolean flag, String s, boolean flag1)
    {
        editor.lean(getKey(flag, s), flag1);
        return this;
    }

    public getKey putFloat(boolean flag, String s, float f)
    {
        editor.at(getKey(flag, s), f);
        return this;
    }

    public getKey putInt(boolean flag, String s, int i)
    {
        editor.(getKey(flag, s), i);
        return this;
    }

    public getKey putLong(boolean flag, String s, long l)
    {
        editor.g(getKey(flag, s), l);
        return this;
    }

    public getKey putString(boolean flag, String s, String s1)
    {
        editor.ing(getKey(flag, s), s1);
        return this;
    }

    public getKey putStringSet(boolean flag, String s, Set set)
    {
        editor.ingSet(getKey(flag, s), set);
        return this;
    }

    public getKey remove(boolean flag, String s)
    {
        editor.(getKey(flag, s));
        return this;
    }

    public (EbayPreferencesImpl ebaypreferencesimpl, android.content.sImpl simpl)
    {
        preferences = ebaypreferencesimpl;
        editor = simpl;
        currentUser = ebaypreferencesimpl.getCurrentUser();
    }
}
