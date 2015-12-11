// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.share;

import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;

public class SharableAppInfo
    implements Comparable
{

    private Drawable mIcon;
    private CharSequence mLabel;
    private String mPackageName;
    private int mPriority;
    private String mRefTag;
    private ResolveInfo mResolveInfo;

    public SharableAppInfo(CharSequence charsequence, Drawable drawable, String s, String s1, int i, ResolveInfo resolveinfo)
    {
        mLabel = charsequence;
        mIcon = drawable;
        mPackageName = s;
        mRefTag = s1;
        mPriority = i;
        mResolveInfo = resolveinfo;
    }

    public int compareTo(SharableAppInfo sharableappinfo)
    {
        return mPriority - sharableappinfo.mPriority;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((SharableAppInfo)obj);
    }

    public Drawable getIcon()
    {
        return mIcon;
    }

    public CharSequence getLabel()
    {
        return mLabel;
    }

    public String getPackageName()
    {
        return mPackageName;
    }

    public String getRefTag()
    {
        return mRefTag;
    }

    public ResolveInfo getResolveInfo()
    {
        return mResolveInfo;
    }

    public String toString()
    {
        return mLabel.toString();
    }
}
