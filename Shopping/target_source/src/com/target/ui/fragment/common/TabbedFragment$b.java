// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.common;

import android.support.v4.app.Fragment;

// Referenced classes of package com.target.ui.fragment.common:
//            TabbedFragment

public static class mUniqueId
{

    private static final long ID_UNSET = 0x8000000000000000L;
    private final Fragment mFragment;
    private final String mLabel;
    private final long mUniqueId;

    public Fragment a()
    {
        return mFragment;
    }

    public String b()
    {
        return mLabel;
    }

    public long c()
    {
        return mUniqueId;
    }

    public (Fragment fragment, String s)
    {
        this(fragment, s, 0x8000000000000000L);
    }

    public <init>(Fragment fragment, String s, long l)
    {
        mLabel = s;
        mFragment = fragment;
        mUniqueId = l;
    }
}
