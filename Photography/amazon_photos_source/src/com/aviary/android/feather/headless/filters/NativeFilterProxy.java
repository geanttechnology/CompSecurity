// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.headless.filters;

import android.content.Context;
import android.graphics.Bitmap;
import com.aviary.android.feather.headless.AviaryInitializationException;
import com.aviary.android.feather.headless.moa.JSONWriter;
import com.aviary.android.feather.headless.moa.Moa;
import com.aviary.android.feather.headless.moa.MoaActionFactory;
import com.aviary.android.feather.headless.moa.MoaActionList;
import com.aviary.android.feather.headless.moa.MoaMetadata;
import com.aviary.android.feather.headless.moa.MoaResult;
import org.json.JSONException;

public final class NativeFilterProxy
{

    private static final String LOG_TAG = "NativeFilterProxy";
    private static boolean mInitialized = false;

    private NativeFilterProxy()
    {
    }

    public static String encodeActions(MoaActionList moaactionlist)
        throws JSONException
    {
        MoaMetadata moametadata = MoaActionFactory.metadata();
        moametadata.setImageSize(1, 1);
        return JSONWriter.encode(moaactionlist, moametadata);
    }

    public static void init(Context context)
        throws AviaryInitializationException
    {
        com/aviary/android/feather/headless/filters/NativeFilterProxy;
        JVM INSTR monitorenter ;
        if (!mInitialized)
        {
            Moa.init(context, context.getPackageName(), android.os.Build.VERSION.SDK_INT);
            mInitialized = true;
        }
        com/aviary/android/feather/headless/filters/NativeFilterProxy;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    public static boolean initialized()
    {
        return mInitialized;
    }

    public static MoaResult prepareActions(MoaActionList moaactionlist, Bitmap bitmap)
        throws JSONException
    {
        Object obj = MoaActionFactory.metadata();
        ((MoaMetadata) (obj)).setImageSize(1, 1);
        ((MoaMetadata) (obj)).setTransformInputBitmap(true);
        try
        {
            moaactionlist = JSONWriter.encode(moaactionlist, ((MoaMetadata) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (MoaActionList moaactionlist)
        {
            moaactionlist.printStackTrace();
            throw moaactionlist;
        }
        obj = new MoaResult();
        obj.outputBitmap = null;
        obj.inputString = moaactionlist;
        obj.outputString = "";
        obj.inputBitmap = bitmap;
        return ((MoaResult) (obj));
    }

    public static MoaResult prepareActions(MoaActionList moaactionlist, Bitmap bitmap, Bitmap bitmap1, int i, int j)
        throws JSONException
    {
        Object obj = MoaActionFactory.metadata();
        ((MoaMetadata) (obj)).setImageSize(i, j);
        try
        {
            moaactionlist = JSONWriter.encode(moaactionlist, ((MoaMetadata) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (MoaActionList moaactionlist)
        {
            moaactionlist.printStackTrace();
            throw moaactionlist;
        }
        obj = new MoaResult();
        if (bitmap1 != null)
        {
            obj.outputBitmap = bitmap1;
        }
        obj.inputString = moaactionlist;
        obj.outputString = "";
        obj.inputBitmap = bitmap;
        return ((MoaResult) (obj));
    }

}
