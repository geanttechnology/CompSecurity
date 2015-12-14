// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import android.app.Activity;
import android.content.Context;
import com.amazon.gallery.framework.network.exceptions.InvalidParameterException;
import com.amazon.gallery.framework.network.http.rest.RestClient;

public interface FacebookHelper
{
    public static interface LinkDetectCallback
    {

        public abstract void onResult(boolean flag);
    }


    public abstract void hasPhotosPermissions(RestClient restclient, Runnable runnable, Runnable runnable1)
        throws InvalidParameterException;

    public abstract void isLinkedToFacebook(Context context, LinkDetectCallback linkdetectcallback);

    public abstract void launchFacebookPermissionsPage(Activity activity);

    public abstract void launchFacebookSettingsPage(Activity activity);

    public abstract void unlinkFacebookFlagFromDevice(Context context);
}
