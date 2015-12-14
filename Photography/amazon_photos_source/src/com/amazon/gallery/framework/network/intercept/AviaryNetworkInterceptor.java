// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.intercept;

import android.net.Uri;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.network.cloudfront.CloudFrontConfig;
import java.lang.reflect.Field;

public class AviaryNetworkInterceptor
{

    private static final String TAG = com/amazon/gallery/framework/network/intercept/AviaryNetworkInterceptor.getName();

    public AviaryNetworkInterceptor()
    {
    }

    private void handleException(Exception exception)
    {
        if (BuildFlavors.isDebug())
        {
            throw new RuntimeException(exception);
        } else
        {
            GLogger.ex(TAG, "Exception happens", exception);
            return;
        }
    }

    private void setStaticFieldTo(Field field, String s)
        throws IllegalAccessException
    {
        field.setAccessible(true);
        field.set(null, s);
    }

    public void initialize()
    {
        Object obj;
        Field field;
        field = Class.forName("com.aviary.android.feather.cds.AviaryCdsDefaultContentLoader").getDeclaredField("ASSET_BASE_URL");
        if (!BuildFlavors.isDebug())
        {
            break MISSING_BLOCK_LABEL_131;
        }
        obj = CloudFrontConfig.DEVELOPMENT;
_L1:
        setStaticFieldTo(field, ((CloudFrontConfig) (obj)).getCloudFrontURI(null).toString());
        obj = Class.forName("com.aviary.android.feather.cds.AviaryCdsService");
        setStaticFieldTo(((Class) (obj)).getDeclaredField("SERVER_ROOT_PRODUCTION"), "http://fakeUrl");
        setStaticFieldTo(((Class) (obj)).getDeclaredField("SERVER_ROOT_STAGING"), "http://fakeUrl");
        setStaticFieldTo(((Class) (obj)).getDeclaredField("SERVER_ROOT_TEST"), "http://fakeUrl");
        setStaticFieldTo(((Class) (obj)).getDeclaredField("mServerRoot"), "http://fakeUrl");
        obj = Class.forName("com.aviary.android.feather.receipt.ReceiptManager");
        setStaticFieldTo(((Class) (obj)).getDeclaredField("SERVER_ROOT"), "http://fakeUrl");
        setStaticFieldTo(((Class) (obj)).getDeclaredField("URI_FREE"), "http://fakeUrl");
        setStaticFieldTo(((Class) (obj)).getDeclaredField("URI_PAID"), "http://fakeUrl");
        return;
        try
        {
            obj = CloudFrontConfig.PRODUCTION;
        }
        catch (NoSuchFieldException nosuchfieldexception)
        {
            handleException(nosuchfieldexception);
            return;
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            handleException(classnotfoundexception);
            return;
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            handleException(illegalaccessexception);
            return;
        }
          goto _L1
    }

}
