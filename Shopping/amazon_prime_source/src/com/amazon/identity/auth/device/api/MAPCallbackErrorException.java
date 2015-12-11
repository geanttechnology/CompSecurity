// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.os.Bundle;
import android.os.Parcel;

public class MAPCallbackErrorException extends Exception
{

    private static final long serialVersionUID = 1L;
    private final byte mErrorBundleBytes[];

    public MAPCallbackErrorException(Bundle bundle)
    {
        Object obj;
        if (bundle == null)
        {
            obj = null;
        } else
        {
            String s = bundle.getString("com.amazon.dcp.sso.ErrorMessage");
            if (s == null)
            {
                obj = null;
            } else
            {
                obj = s;
                if (bundle.containsKey("com.amazon.dcp.sso.ErrorCode"))
                {
                    obj = (new StringBuilder()).append(s).append(" (").append(bundle.getInt("com.amazon.dcp.sso.ErrorCode")).append(")").toString();
                }
            }
        }
        super(((String) (obj)));
        if (bundle == null)
        {
            bundle = new Bundle();
        }
        obj = Parcel.obtain();
        ((Parcel) (obj)).writeBundle(bundle);
        mErrorBundleBytes = ((Parcel) (obj)).marshall();
        ((Parcel) (obj)).recycle();
        return;
        bundle;
        ((Parcel) (obj)).recycle();
        throw bundle;
    }

    public Bundle getErrorBundle()
    {
        Parcel parcel = Parcel.obtain();
        Bundle bundle;
        parcel.unmarshall(mErrorBundleBytes, 0, mErrorBundleBytes.length);
        parcel.setDataPosition(0);
        bundle = parcel.readBundle();
        parcel.recycle();
        return bundle;
        Exception exception;
        exception;
        parcel.recycle();
        throw exception;
    }
}
