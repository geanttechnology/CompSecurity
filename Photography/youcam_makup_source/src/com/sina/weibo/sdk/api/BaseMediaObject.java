// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.api;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.sina.weibo.sdk.utils.LogUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public abstract class BaseMediaObject
    implements Parcelable
{

    public static final int MEDIA_TYPE_CMD = 7;
    public static final int MEDIA_TYPE_IMAGE = 2;
    public static final int MEDIA_TYPE_MUSIC = 3;
    public static final int MEDIA_TYPE_TEXT = 1;
    public static final int MEDIA_TYPE_VIDEO = 4;
    public static final int MEDIA_TYPE_VOICE = 6;
    public static final int MEDIA_TYPE_WEBPAGE = 5;
    public String actionUrl;
    public String description;
    public String identify;
    public String schema;
    public byte thumbData[];
    public String title;

    public BaseMediaObject()
    {
    }

    public BaseMediaObject(Parcel parcel)
    {
        actionUrl = parcel.readString();
        schema = parcel.readString();
        identify = parcel.readString();
        title = parcel.readString();
        description = parcel.readString();
        thumbData = parcel.createByteArray();
    }

    protected boolean checkArgs()
    {
        if (actionUrl == null || actionUrl.length() > 512)
        {
            LogUtil.e("Weibo.BaseMediaObject", "checkArgs fail, actionUrl is invalid");
            return false;
        }
        if (identify == null || identify.length() > 512)
        {
            LogUtil.e("Weibo.BaseMediaObject", "checkArgs fail, identify is invalid");
            return false;
        }
        if (thumbData == null || thumbData.length > 32768)
        {
            StringBuilder stringbuilder = new StringBuilder("checkArgs fail, thumbData is invalid,size is ");
            int i;
            if (thumbData != null)
            {
                i = thumbData.length;
            } else
            {
                i = -1;
            }
            LogUtil.e("Weibo.BaseMediaObject", stringbuilder.append(i).append("! more then 32768.").toString());
            return false;
        }
        if (title == null || title.length() > 512)
        {
            LogUtil.e("Weibo.BaseMediaObject", "checkArgs fail, title is invalid");
            return false;
        }
        if (description == null || description.length() > 1024)
        {
            LogUtil.e("Weibo.BaseMediaObject", "checkArgs fail, description is invalid");
            return false;
        } else
        {
            return true;
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public abstract int getObjType();

    public final void setThumbImage(Bitmap bitmap)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        Object obj = bytearrayoutputstream;
        bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 85, bytearrayoutputstream);
        obj = bytearrayoutputstream;
        thumbData = bytearrayoutputstream.toByteArray();
        if (bytearrayoutputstream == null)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        bytearrayoutputstream.close();
_L2:
        return;
        Exception exception;
        exception;
        bitmap = null;
_L5:
        obj = bitmap;
        exception.printStackTrace();
        obj = bitmap;
        LogUtil.e("Weibo.BaseMediaObject", "put thumb failed");
        if (bitmap == null) goto _L2; else goto _L1
_L1:
        try
        {
            bitmap.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            bitmap.printStackTrace();
        }
        return;
        bitmap;
        obj = null;
_L4:
        if (obj != null)
        {
            try
            {
                ((ByteArrayOutputStream) (obj)).close();
            }
            catch (IOException ioexception)
            {
                ioexception.printStackTrace();
            }
        }
        throw bitmap;
        bitmap;
        bitmap.printStackTrace();
        return;
        bitmap;
        if (true) goto _L4; else goto _L3
_L3:
        exception;
        bitmap = bytearrayoutputstream;
          goto _L5
    }

    protected abstract BaseMediaObject toExtraMediaObject(String s);

    protected abstract String toExtraMediaString();

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(actionUrl);
        parcel.writeString(schema);
        parcel.writeString(identify);
        parcel.writeString(title);
        parcel.writeString(description);
        parcel.writeByteArray(thumbData);
    }
}
