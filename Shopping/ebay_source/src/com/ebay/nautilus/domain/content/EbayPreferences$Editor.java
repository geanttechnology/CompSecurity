// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content;

import java.util.Set;

// Referenced classes of package com.ebay.nautilus.domain.content:
//            EbayPreferences

public static interface 
{

    public abstract void apply();

    public abstract  clear();

    public abstract boolean commit();

    public abstract  putBoolean(boolean flag, String s, boolean flag1);

    public abstract  putFloat(boolean flag, String s, float f);

    public abstract  putInt(boolean flag, String s, int i);

    public abstract  putLong(boolean flag, String s, long l);

    public abstract  putString(boolean flag, String s, String s1);

    public abstract  putStringSet(boolean flag, String s, Set set);

    public abstract  remove(boolean flag, String s);
}
