// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.datamapping;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.datamapping.gson.DateToMillisecondsAdapter;
import com.ebay.nautilus.domain.datamapping.gson.EbaySiteAdapter;
import com.ebay.nautilus.kernel.util.StreamUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;

public class DataMapperFactory
{

    public static final String EXTRA_JSON = "com.ebay.nautilus.kernel.databinding.Json";
    private static Gson defaultMapper = (new GsonBuilder()).excludeFieldsWithModifiers(new int[] {
        8, 128, 64
    }).setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").registerTypeAdapter(com/ebay/nautilus/domain/EbaySite, new EbaySiteAdapter()).enableComplexMapKeySerialization().create();
    private static Gson exclusiveMapper = (new GsonBuilder()).excludeFieldsWithoutExposeAnnotation().registerTypeAdapter(java/util/Date, new DateToMillisecondsAdapter()).enableComplexMapKeySerialization().create();
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("DataMapperFactory", 3, "Log DataMapperFactory usage.");
    private static Gson parcellingMapper = (new GsonBuilder()).excludeFieldsWithModifiers(new int[] {
        8, 128, 64
    }).registerTypeAdapter(java/util/Date, new DateToMillisecondsAdapter()).enableComplexMapKeySerialization().create();

    public DataMapperFactory()
    {
    }

    public static Gson getDefaultMapper()
    {
        return defaultMapper;
    }

    public static Gson getExclusiveMapper()
    {
        return exclusiveMapper;
    }

    public static Object readBundleJson(Bundle bundle, Class class1)
    {
        Bundle bundle1;
        Bundle bundle2;
        Object obj;
        Object obj1;
        obj1 = null;
        obj = null;
        bundle2 = obj;
        bundle1 = obj1;
        bundle = bundle.getByteArray("com.ebay.nautilus.kernel.databinding.Json");
        if (bundle == null)
        {
            StreamUtil.closeQuietly(null);
            return null;
        }
        bundle2 = obj;
        bundle1 = obj1;
        bundle = StreamUtil.streamToReader(new ByteArrayInputStream(bundle), "UTF-8");
        bundle2 = bundle;
        bundle1 = bundle;
        class1 = ((Class) (exclusiveMapper.fromJson(bundle, class1)));
        StreamUtil.closeQuietly(bundle);
        return class1;
        bundle;
        bundle1 = bundle2;
        logger.logAsError((new StringBuilder()).append("readBundleJson: ").append(bundle.getLocalizedMessage()).toString());
        bundle1 = bundle2;
        throw new RuntimeException(bundle);
        bundle;
        StreamUtil.closeQuietly(bundle1);
        throw bundle;
    }

    public static Object readIntentJson(Intent intent, Class class1)
    {
        intent = intent.getStringExtra("com.ebay.nautilus.kernel.databinding.Json");
        if (intent == null)
        {
            return null;
        } else
        {
            return defaultMapper.fromJson(intent, class1);
        }
    }

    public static Object readParcelJson(Parcel parcel, Class class1)
    {
        return parcellingMapper.fromJson(parcel.readString(), class1);
    }

    public static void writeBundleJson(Bundle bundle, Object obj)
    {
        bundle.putByteArray("com.ebay.nautilus.kernel.databinding.Json", exclusiveMapper.toJson(obj).getBytes());
    }

    public static void writeIntentJson(Intent intent, Object obj)
    {
        intent.putExtra("com.ebay.nautilus.kernel.databinding.Json", defaultMapper.toJson(obj));
    }

    public static void writeParcelJson(Parcel parcel, Object obj)
    {
        parcel.writeString(parcellingMapper.toJson(obj));
    }

}
