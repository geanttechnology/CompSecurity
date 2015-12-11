// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.dagger.application;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.amazon.android.dagger.DaggerAndroid;

public abstract class DaggerContentProvider extends ContentProvider
{

    private static final String TAG = com/amazon/android/dagger/application/DaggerContentProvider.getSimpleName();

    public DaggerContentProvider()
    {
    }

    private static void waitForDaggerGraphCreation()
    {
        try
        {
            DaggerAndroid.awaitGraphCreation();
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            Log.e(TAG, "Interrupted while awaiting completion of Dagger object graph creation", interruptedexception);
        }
    }

    public final int delete(Uri uri, String s, String as[])
    {
        waitForDaggerGraphCreation();
        return deleteOnGraphCreate(uri, s, as);
    }

    protected abstract int deleteOnGraphCreate(Uri uri, String s, String as[]);

    public final String getType(Uri uri)
    {
        waitForDaggerGraphCreation();
        return getTypeOnGraphCreate(uri);
    }

    protected abstract String getTypeOnGraphCreate(Uri uri);

    public final Uri insert(Uri uri, ContentValues contentvalues)
    {
        waitForDaggerGraphCreation();
        return insertOnGraphCreate(uri, contentvalues);
    }

    protected abstract Uri insertOnGraphCreate(Uri uri, ContentValues contentvalues);

    public final Cursor query(Uri uri, String as[], String s, String as1[], String s1)
    {
        waitForDaggerGraphCreation();
        return queryOnGraphCreate(uri, as, s, as1, s1);
    }

    protected abstract Cursor queryOnGraphCreate(Uri uri, String as[], String s, String as1[], String s1);

    public final int update(Uri uri, ContentValues contentvalues, String s, String as[])
    {
        waitForDaggerGraphCreation();
        return updateOnGraphCreate(uri, contentvalues, s, as);
    }

    protected abstract int updateOnGraphCreate(Uri uri, ContentValues contentvalues, String s, String as[]);

}
