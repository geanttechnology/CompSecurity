// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import com.aviary.android.feather.cds.AviaryCds;
import com.aviary.android.feather.common.utils.PackageManagerUtils;
import java.io.File;
import java.util.HashMap;

public final class CdsUIUtils
{

    static HashMap sPackTypeStringMap = new HashMap();

    private CdsUIUtils()
    {
    }

    public static Cursor computePreviewAspectRatio(Context context, long l, String s, String s1, double ad[])
    {
        if (context == null)
        {
            return null;
        }
        if (ad == null || ad.length < 1)
        {
            return null;
        }
        double d1 = 1.0D;
        context = context.getContentResolver().query(PackageManagerUtils.getCDSProviderContentUri(context, (new StringBuilder()).append("pack/").append(l).append("/item/list").toString()), new String[] {
            "item_id as _id", "pack_type", "item_id", "item_identifier", "item_displayName"
        }, null, null, null);
        double d = d1;
        if (context != null)
        {
            d = d1;
            if (context.moveToFirst())
            {
                String s2 = context.getString(context.getColumnIndex("item_identifier"));
                s = (new File(s1, (new StringBuilder()).append(s2).append(AviaryCds.getPreviewItemExt(s)).toString())).getAbsolutePath();
                s1 = new android.graphics.BitmapFactory.Options();
                s1.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(s, s1);
                if (((android.graphics.BitmapFactory.Options) (s1)).outHeight == 0 || ((android.graphics.BitmapFactory.Options) (s1)).outWidth == 0)
                {
                    d = 1.0D;
                } else
                {
                    d = (double)((android.graphics.BitmapFactory.Options) (s1)).outWidth / (double)((android.graphics.BitmapFactory.Options) (s1)).outHeight;
                }
            }
        }
        ad[0] = d;
        return context;
    }

    public static String getPackTypeString(Context context, com.aviary.android.feather.cds.AviaryCds.PackType packtype)
    {
        int i;
        if (sPackTypeStringMap.containsKey(packtype))
        {
            return (String)sPackTypeStringMap.get(packtype);
        }
        i = -1;
        static class _cls1
        {

            static final int $SwitchMap$com$aviary$android$feather$cds$AviaryCds$PackType[];

            static 
            {
                $SwitchMap$com$aviary$android$feather$cds$AviaryCds$PackType = new int[com.aviary.android.feather.cds.AviaryCds.PackType.values().length];
                try
                {
                    $SwitchMap$com$aviary$android$feather$cds$AviaryCds$PackType[com.aviary.android.feather.cds.AviaryCds.PackType.FRAME.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$cds$AviaryCds$PackType[com.aviary.android.feather.cds.AviaryCds.PackType.EFFECT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$cds$AviaryCds$PackType[com.aviary.android.feather.cds.AviaryCds.PackType.STICKER.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$cds$AviaryCds$PackType[com.aviary.android.feather.cds.AviaryCds.PackType.OVERLAY.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.aviary.android.feather.cds.AviaryCds.PackType[packtype.ordinal()];
        JVM INSTR tableswitch 1 4: default 60
    //                   1 81
    //                   2 88
    //                   3 95
    //                   4 102;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        break; /* Loop/switch isn't completed */
_L5:
        break MISSING_BLOCK_LABEL_102;
_L6:
        if (i > 0)
        {
            context = context.getString(i);
            sPackTypeStringMap.put(packtype, context);
            return context;
        } else
        {
            return "";
        }
_L2:
        i = com.aviary.android.feather.sdk.R.string.feather_borders;
          goto _L6
_L3:
        i = com.aviary.android.feather.sdk.R.string.feather_effects;
          goto _L6
_L4:
        i = com.aviary.android.feather.sdk.R.string.feather_stickers;
          goto _L6
        i = com.aviary.android.feather.sdk.R.string.feather_overlays;
          goto _L6
    }

}
