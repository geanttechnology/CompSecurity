// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AssetContentProvider extends ContentProvider
{

    private String WhiteListedFiles[] = {
        "mash-android.js", "cordova.android.js"
    };

    public AssetContentProvider()
    {
    }

    private boolean isFileWhiteListed(String s)
    {
        String as[] = WhiteListedFiles;
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            if (as[i].equals(s))
            {
                return true;
            }
        }

        return false;
    }

    public int delete(Uri uri, String s, String as[])
    {
        return 0;
    }

    public String getType(Uri uri)
    {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentvalues)
    {
        return null;
    }

    public boolean onCreate()
    {
        return false;
    }

    public AssetFileDescriptor openAssetFile(Uri uri, String s)
        throws FileNotFoundException
    {
        if (uri.toString().startsWith("content://amazon.mShop.android.AssetContentProvider/"))
        {
            if (!s.equalsIgnoreCase("r"))
            {
                throw new SecurityException("We only support Read mode");
            }
            uri = uri.toString().substring("content://amazon.mShop.android.AssetContentProvider/".length());
            if (!isFileWhiteListed(uri))
            {
                uri = (new StringBuilder()).append(uri).append(" is not in white list").toString();
                Log.e("AssetContentProvider", uri);
                throw new FileNotFoundException(uri);
            }
            s = getContext().getAssets();
            try
            {
                uri = s.openFd(uri);
            }
            // Misplaced declaration of an exception variable
            catch (Uri uri)
            {
                Log.e("AssetContentProvider", uri.getMessage());
                throw new FileNotFoundException(uri.getMessage());
            }
            return uri;
        } else
        {
            uri = (new StringBuilder()).append("un-supported URI: ").append(uri).toString();
            Log.e("AssetContentProvider", uri);
            throw new FileNotFoundException(uri);
        }
    }

    public Cursor query(Uri uri, String as[], String s, String as1[], String s1)
    {
        return null;
    }

    public int update(Uri uri, ContentValues contentvalues, String s, String as[])
    {
        return 0;
    }
}
