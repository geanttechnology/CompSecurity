// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Binder;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.SecurityHelpers;
import com.amazon.identity.platform.metric.MetricsHelper;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            RemoteMAPException, ContentProviderClientCallback

public class SecureContentResolver
{

    private static final String TAG = com/amazon/identity/auth/device/framework/SecureContentResolver.getName();
    private final ContentResolver mContentResolver;
    private final Context mContext;

    public SecureContentResolver(Context context)
    {
        this(context, context.getContentResolver());
    }

    public SecureContentResolver(Context context, ContentResolver contentresolver)
    {
        mContext = context;
        mContentResolver = contentresolver;
    }

    public Object acquireContentProviderClient(Uri uri, ContentProviderClientCallback contentproviderclientcallback)
        throws RemoteMAPException
    {
        ContentProviderClient contentproviderclient;
        Object obj;
        ContentProviderClient contentproviderclient1;
        Object obj1;
        int i;
        long l;
        try
        {
            SecurityHelpers.checkIsAmazonOwnedContentProvider(mContext, uri);
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            throw new RemoteMAPException(uri);
        }
        i = 0;
_L6:
        obj1 = null;
        contentproviderclient = null;
        l = Binder.clearCallingIdentity();
        contentproviderclient1 = contentproviderclient;
        obj = obj1;
        if (android.os.Build.VERSION.SDK_INT < 16) goto _L2; else goto _L1
_L1:
        contentproviderclient1 = contentproviderclient;
        obj = obj1;
        contentproviderclient = mContentResolver.acquireUnstableContentProviderClient(uri);
_L4:
        contentproviderclient1 = contentproviderclient;
        obj = contentproviderclient;
        obj1 = contentproviderclientcallback.useContentProviderClient(contentproviderclient);
        if (contentproviderclient != null)
        {
            contentproviderclient.release();
        }
        Binder.restoreCallingIdentity(l);
        return obj1;
_L2:
        contentproviderclient1 = contentproviderclient;
        obj = obj1;
        contentproviderclient = mContentResolver.acquireContentProviderClient(uri);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_206;
        }
        obj = contentproviderclient1;
        MAPLog.e(TAG, (new StringBuilder("Got exception querying ")).append(uri).append(". Failing after ").append(i).append(" retries.").toString(), exception);
        obj = contentproviderclient1;
        MetricsHelper.incrementCounter("ContentProviderFailure", new String[0]);
        obj = contentproviderclient1;
        throw new RemoteMAPException(exception);
        uri;
        if (obj != null)
        {
            ((ContentProviderClient) (obj)).release();
        }
        Binder.restoreCallingIdentity(l);
        throw uri;
        obj = contentproviderclient1;
        MAPLog.w(TAG, (new StringBuilder("Got exception querying ")).append(uri).append(". Retrying.").toString(), exception);
        obj = contentproviderclient1;
        MetricsHelper.incrementCounter("ContentProviderRetry", new String[0]);
        if (contentproviderclient1 != null)
        {
            contentproviderclient1.release();
        }
        Binder.restoreCallingIdentity(l);
        if (i <= 0)
        {
            try
            {
                Thread.sleep(10L);
            }
            catch (InterruptedException interruptedexception)
            {
                MAPLog.e(TAG, (new StringBuilder("Got an InterruptedException while retrying calling ")).append(uri).toString(), interruptedexception);
            }
        }
        i++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public int delete(final Uri url, final String where, final String selectionArgs[])
        throws RemoteMAPException
    {
        return ((Integer)acquireContentProviderClient(url, new ContentProviderClientCallback() {

            final SecureContentResolver this$0;
            final String val$selectionArgs[];
            final Uri val$url;
            final String val$where;

            public volatile Object useContentProviderClient(ContentProviderClient contentproviderclient)
                throws Exception
            {
                return useContentProviderClient$2c6dc054();
            }

            public Integer useContentProviderClient$2c6dc054()
                throws Exception
            {
                return Integer.valueOf(mContentResolver.delete(url, where, selectionArgs));
            }

            
            {
                this$0 = SecureContentResolver.this;
                url = uri;
                where = s;
                selectionArgs = as;
                super();
            }
        })).intValue();
    }

    public Uri insert(final Uri url, final ContentValues values)
        throws RemoteMAPException
    {
        return (Uri)acquireContentProviderClient(url, new ContentProviderClientCallback() {

            final SecureContentResolver this$0;
            final Uri val$url;
            final ContentValues val$values;

            public volatile Object useContentProviderClient(ContentProviderClient contentproviderclient)
                throws Exception
            {
                return useContentProviderClient$4951ae5c();
            }

            public Uri useContentProviderClient$4951ae5c()
                throws Exception
            {
                return mContentResolver.insert(url, values);
            }

            
            {
                this$0 = SecureContentResolver.this;
                url = uri;
                values = contentvalues;
                super();
            }
        });
    }


}
