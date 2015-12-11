// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.android.platform.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

public abstract class ContentProviderDelegateBase
{

    private final ContentProvider mProviderProxy;

    public ContentProviderDelegateBase(ContentProvider contentprovider)
    {
        mProviderProxy = contentprovider;
    }

    public abstract int delete_impl(Uri uri, String s, String as[]);

    public ContentProvider getProxy()
    {
        return mProviderProxy;
    }

    public abstract String getType_impl(Uri uri);

    public abstract Uri insert_impl(Uri uri, ContentValues contentvalues);

    public abstract Cursor query_impl(Uri uri, String as[], String s, String as1[], String s1);

    public abstract int update_impl(Uri uri, ContentValues contentvalues, String s, String as[]);
}
