// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.os.Bundle;
import android.os.Parcel;
import android.util.Base64;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            MAPLog

public final class ParcelUtils
{

    private static final String TAG = com/amazon/identity/auth/device/utils/ParcelUtils.getName();

    private ParcelUtils()
    {
    }

    public static String bundleToString(Bundle bundle)
    {
        Parcel parcel;
        if (bundle == null)
        {
            return null;
        }
        parcel = Parcel.obtain();
        parcel.writeBundle(bundle);
        bundle = parcelToString(parcel);
        parcel.recycle();
        return bundle;
        bundle;
        parcel.recycle();
        throw bundle;
    }

    public static Serializable deserialize(String s)
    {
        if (s == null)
        {
            return null;
        }
        s = seralizedParcelStringToParcel(s);
        Serializable serializable = s.readSerializable();
        s.recycle();
        return serializable;
        Exception exception;
        exception;
        s.recycle();
        throw exception;
    }

    public static String listOfMapOfStringsToString(Collection collection)
    {
        Parcel parcel;
        if (collection == null)
        {
            return null;
        }
        parcel = Parcel.obtain();
        ArrayList arraylist;
        arraylist = new ArrayList();
        for (collection = collection.iterator(); collection.hasNext(); arraylist.add(new HashMap((Map)collection.next()))) { }
        break MISSING_BLOCK_LABEL_65;
        collection;
        parcel.recycle();
        throw collection;
        parcel.writeSerializable(arraylist);
        collection = parcelToString(parcel);
        parcel.recycle();
        return collection;
    }

    private static String parcelToString(Parcel parcel)
    {
        return Base64.encodeToString(parcel.marshall(), 0);
    }

    private static Parcel seralizedParcelStringToParcel(String s)
    {
        s = Base64.decode(s, 0);
        if (s == null)
        {
            return null;
        } else
        {
            Parcel parcel = Parcel.obtain();
            parcel.unmarshall(s, 0, s.length);
            parcel.setDataPosition(0);
            return parcel;
        }
    }

    public static String serialize(Serializable serializable)
    {
        Parcel parcel;
        if (serializable == null)
        {
            return null;
        }
        parcel = Parcel.obtain();
        parcel.writeSerializable(serializable);
        serializable = parcelToString(parcel);
        parcel.recycle();
        return serializable;
        serializable;
        parcel.recycle();
        throw serializable;
    }

    public static Bundle stringToBundle(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        if ((s = seralizedParcelStringToParcel(s)) == null) goto _L1; else goto _L3
_L3:
        Bundle bundle = s.readBundle();
        s.recycle();
        return bundle;
        Exception exception;
        exception;
        try
        {
            s.recycle();
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MAPLog.w(TAG, "Failed to deserialize parcel", s);
        }
        return null;
    }

    public static Collection stringToListOfMapOfStrings(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        if ((s = seralizedParcelStringToParcel(s)) == null) goto _L1; else goto _L3
_L3:
        Collection collection = (Collection)s.readSerializable();
        s.recycle();
        return collection;
        Exception exception;
        exception;
        s.recycle();
        throw exception;
    }

    public static String toSerializedBundleString(Set set)
    {
        Bundle bundle = new Bundle();
        bundle.putStringArray("string_array", (String[])set.toArray(new String[set.size()]));
        return bundleToString(bundle);
    }

    public static Set toStringSet(String s)
    {
        s = stringToBundle(s);
        if (s == null)
        {
            return new HashSet();
        }
        try
        {
            s = s.getStringArray("string_array");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MAPLog.w(TAG, "Failed to deserialize parcel", s);
            s = null;
        }
        if (s == null)
        {
            return new HashSet();
        } else
        {
            return new HashSet(Arrays.asList(s));
        }
    }

}
