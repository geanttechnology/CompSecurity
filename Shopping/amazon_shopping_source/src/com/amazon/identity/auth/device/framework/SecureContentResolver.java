// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.SecurityHelpers;
import com.amazon.identity.platform.metric.MetricsHelper;
import java.util.concurrent.ExecutionException;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            ContentProviderClientCallback

public class SecureContentResolver
{

    public static final int NUM_RETRY = 1;
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

    private void logExceptionError(String s, String s1)
    {
        MAPLog.e(TAG, (new StringBuilder()).append(s).append(": Remote ContentResolver threw exception: ").append(s1).toString());
    }

    private void logSecurityException(SecurityException securityexception)
    {
        MAPLog.e(TAG, "SecurityException while accessing content provider. This error usually means that there are multiple MAP enabled apps signed with different certificates on the device. Please uninstall all MAP enabled apps, and reinstall only apps which share the same certificate.", securityexception);
    }

    public Object acquireContentProviderClient(Uri uri, ContentProviderClientCallback contentproviderclientcallback)
        throws ExecutionException
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
            throw new ExecutionException(uri);
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
            break MISSING_BLOCK_LABEL_197;
        }
        obj = contentproviderclient1;
        MAPLog.e(TAG, (new StringBuilder("Got exception querying content provider. Failing after ")).append(i).append(" retries.").toString(), exception);
        obj = contentproviderclient1;
        MetricsHelper.increasePeriodicCounter("ContentProviderFailure", new String[0]);
        obj = contentproviderclient1;
        throw new ExecutionException(exception);
        uri;
        if (obj != null)
        {
            ((ContentProviderClient) (obj)).release();
        }
        Binder.restoreCallingIdentity(l);
        throw uri;
        obj = contentproviderclient1;
        MAPLog.w(TAG, "Got exception querying content provider. Retrying.", exception);
        obj = contentproviderclient1;
        MetricsHelper.increasePeriodicCounter("ContentProviderRetry", new String[0]);
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
                MAPLog.e(TAG, "Got an InterruptedException while retrying calling Generic IPC central store.", interruptedexception);
            }
        }
        i++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public int delete(Uri uri, String s, String as[])
    {
        SecurityHelpers.checkIsAmazonOwnedContentProvider(mContext, uri);
        int i;
        try
        {
            i = mContentResolver.delete(uri, s, as);
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            logExceptionError("delete()", uri.toString());
            return 0;
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            logSecurityException(uri);
            throw uri;
        }
        return i;
    }

    public Uri insert(Uri uri, ContentValues contentvalues)
    {
        SecurityHelpers.checkIsAmazonOwnedContentProvider(mContext, uri);
        try
        {
            uri = mContentResolver.insert(uri, contentvalues);
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            logExceptionError("insert()", uri.toString());
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            logSecurityException(uri);
            throw uri;
        }
        return uri;
    }

    public Cursor query(Uri uri, String as[], String s, String as1[], String s1)
    {
        SecurityHelpers.checkIsAmazonOwnedContentProvider(mContext, uri);
        try
        {
            uri = mContentResolver.query(uri, as, s, as1, s1);
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            logExceptionError("query()", uri.toString());
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            logSecurityException(uri);
            throw uri;
        }
        return uri;
    }

    public int update(Uri uri, ContentValues contentvalues, String s, String as[])
    {
        SecurityHelpers.checkIsAmazonOwnedContentProvider(mContext, uri);
        int i;
        try
        {
            i = mContentResolver.update(uri, contentvalues, s, as);
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            logExceptionError("update()", uri.toString());
            return 0;
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            logSecurityException(uri);
            throw uri;
        }
        return i;
    }

}
