// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.support;

import android.os.Parcel;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import roboguice.util.Ln;

public class ParcelableCreator
    implements android.os.Parcelable.Creator
{
    public static interface OnFailureListener
    {

        public abstract void onFailure(Exception exception);
    }


    public static final String TAG = "Parcelable unmarshaller";
    private final Class clazz;
    private final OnFailureListener listener;

    public ParcelableCreator(Class class1)
    {
        this(class1, new OnFailureListener() {

            public void onFailure(Exception exception)
            {
                Ln.d("Parcelable unmarshaller", new Object[] {
                    "Unmarshalling error:", exception
                });
            }

        });
    }

    public ParcelableCreator(Class class1, OnFailureListener onfailurelistener)
    {
        clazz = class1;
        listener = onfailurelistener;
    }

    public Object createFromParcel(Parcel parcel)
    {
        try
        {
            parcel = ((Parcel) (clazz.getConstructor(new Class[] {
                android/os/Parcel
            }).newInstance(new Object[] {
                parcel
            })));
        }
        // Misplaced declaration of an exception variable
        catch (Parcel parcel)
        {
            listener.onFailure(parcel);
            return null;
        }
        return parcel;
    }

    public Object[] newArray(int i)
    {
        return (Object[])(Object[])Array.newInstance(clazz, i);
    }
}
