// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dex;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import java.lang.reflect.Constructor;

public class StubContentProvider extends ContentProvider
{

    private static final String TAG = com/amazon/dex/StubContentProvider.getSimpleName();
    private ContentProvider _flddelegate;
    private ProviderInfo providerInfo;

    public StubContentProvider()
    {
    }

    private ContentProvider getDelegate()
    {
        this;
        JVM INSTR monitorenter ;
        if (_flddelegate == null) goto _L2; else goto _L1
_L1:
        Object obj = _flddelegate;
_L4:
        this;
        JVM INSTR monitorexit ;
        return ((ContentProvider) (obj));
_L2:
        String s;
        String s1;
        s = getClass().getName();
        s1 = s.replace("Stub", "");
        if (s.equals(s1))
        {
            throw new IllegalStateException((new StringBuilder()).append("Bad stub name: ").append(s).toString());
        }
        break MISSING_BLOCK_LABEL_75;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        com.amazon.mShop.util.DebugUtil.Log.i(TAG, (new StringBuilder()).append("Creating delegate: ").append(s1).append(" for stub: ").append(s).toString());
        Exception exception;
        try
        {
            obj = (ContentProvider)Class.forName(s1).getConstructor(new Class[0]).newInstance(new Object[0]);
            ((ContentProvider) (obj)).attachInfo(getContext(), providerInfo);
            ((ContentProvider) (obj)).onCreate();
            _flddelegate = ((ContentProvider) (obj));
            com.amazon.mShop.util.DebugUtil.Log.i(TAG, (new StringBuilder()).append("Created delegate: ").append(s1).append(" for stub: ").append(s).toString());
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception) { }
        com.amazon.mShop.util.DebugUtil.Log.e(TAG, "Could not create delegate.", exception);
        exception = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void attachInfo(Context context, ProviderInfo providerinfo)
    {
        super.attachInfo(context, providerinfo);
        providerInfo = providerinfo;
    }

    public int delete(Uri uri, String s, String as[])
    {
        return getDelegate().delete(uri, s, as);
    }

    public String getType(Uri uri)
    {
        ContentProvider contentprovider = getDelegate();
        if (contentprovider == null)
        {
            return null;
        } else
        {
            return contentprovider.getType(uri);
        }
    }

    public Uri insert(Uri uri, ContentValues contentvalues)
    {
        return getDelegate().insert(uri, contentvalues);
    }

    public boolean onCreate()
    {
        com.amazon.mShop.util.DebugUtil.Log.i(TAG, (new StringBuilder()).append("Creating Content Provider: ").append(getClass()).toString());
        return true;
    }

    public Cursor query(Uri uri, String as[], String s, String as1[], String s1)
    {
        ContentProvider contentprovider = getDelegate();
        if (contentprovider == null)
        {
            return null;
        } else
        {
            return contentprovider.query(uri, as, s, as1, s1);
        }
    }

    public int update(Uri uri, ContentValues contentvalues, String s, String as[])
    {
        return getDelegate().update(uri, contentvalues, s, as);
    }

}
