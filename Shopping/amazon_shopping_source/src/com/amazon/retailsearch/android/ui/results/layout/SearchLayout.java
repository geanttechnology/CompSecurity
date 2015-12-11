// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout;


// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout:
//            UserState

public interface SearchLayout
{

    public abstract void changeOrientation(int i, UserState userstate);

    public abstract UserState disable();

    public abstract void enable(UserState userstate);

    public abstract UserState getUserState();

    public abstract void pause();

    public abstract void resume();

    public abstract void setEntryGroupAsin(String s);
}
