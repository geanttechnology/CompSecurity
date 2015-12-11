// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.android.platform.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.amazon.mShop.android.platform.dex.ExceptionUtil;
import com.amazon.mShop.android.platform.dex.SecondDexEntry;

// Referenced classes of package com.amazon.mShop.android.platform.content:
//            ContentProviderDelegateBase

public class ProxyContentProvider extends ContentProvider
{

    private ContentProviderDelegateBase mDelegate;

    public ProxyContentProvider()
    {
    }

    private ContentProviderDelegateBase getDelegate()
    {
        this;
        JVM INSTR monitorenter ;
        ContentProviderDelegateBase contentproviderdelegatebase = mDelegate;
        if (contentproviderdelegatebase != null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        mDelegate = (ContentProviderDelegateBase)SecondDexEntry.getInstance().createContentProviderDelegate(this);
_L1:
        contentproviderdelegatebase = mDelegate;
        this;
        JVM INSTR monitorexit ;
        return contentproviderdelegatebase;
        Object obj;
        obj;
        ExceptionUtil.reportExceptions(getClass().getSimpleName(), ((Exception) (obj)));
          goto _L1
        obj;
        throw obj;
    }

    public int delete(Uri uri, String s, String as[])
    {
        return getDelegate().delete_impl(uri, s, as);
    }

    public String getType(Uri uri)
    {
        if (getDelegate() == null)
        {
            return null;
        } else
        {
            return getDelegate().getType_impl(uri);
        }
    }

    public Uri insert(Uri uri, ContentValues contentvalues)
    {
        return getDelegate().insert_impl(uri, contentvalues);
    }

    public boolean onCreate()
    {
        return true;
    }

    public Cursor query(Uri uri, String as[], String s, String as1[], String s1)
    {
        if (getDelegate() == null)
        {
            return null;
        } else
        {
            return getDelegate().query_impl(uri, as, s, as1, s1);
        }
    }

    public int update(Uri uri, ContentValues contentvalues, String s, String as[])
    {
        return getDelegate().update_impl(uri, contentvalues, s, as);
    }
}
