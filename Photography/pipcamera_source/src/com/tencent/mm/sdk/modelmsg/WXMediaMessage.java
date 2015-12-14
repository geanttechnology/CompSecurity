// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.modelmsg;

import android.graphics.Bitmap;
import com.tencent.mm.sdk.b.a;
import java.io.ByteArrayOutputStream;

public final class WXMediaMessage
{

    public static final String ACTION_WXAPPMESSAGE = "com.tencent.mm.sdk.openapi.Intent.ACTION_WXAPPMESSAGE";
    private static final int DESCRIPTION_LENGTH_LIMIT = 1024;
    private static final int MEDIA_TAG_NAME_LENGTH_LIMIT = 64;
    private static final int MESSAGE_ACTION_LENGTH_LIMIT = 2048;
    private static final int MESSAGE_EXT_LENGTH_LIMIT = 2048;
    private static final String TAG = "MicroMsg.SDK.WXMediaMessage";
    private static final int THUMB_LENGTH_LIMIT = 32768;
    private static final int TITLE_LENGTH_LIMIT = 512;
    public String description;
    public IMediaObject mediaObject;
    public String mediaTagName;
    public String messageAction;
    public String messageExt;
    public int sdkVer;
    public byte thumbData[];
    public String title;

    public WXMediaMessage()
    {
        this(null);
    }

    public WXMediaMessage(IMediaObject imediaobject)
    {
        mediaObject = imediaobject;
    }

    final boolean checkArgs()
    {
        if (getType() == 8 && (thumbData == null || thumbData.length == 0))
        {
            a.a("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, thumbData should not be null when send emoji");
            return false;
        }
        if (thumbData != null && thumbData.length > 32768)
        {
            a.a("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, thumbData is invalid");
            return false;
        }
        if (title != null && title.length() > 512)
        {
            a.a("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, title is invalid");
            return false;
        }
        if (description != null && description.length() > 1024)
        {
            a.a("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, description is invalid");
            return false;
        }
        if (mediaObject == null)
        {
            a.a("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, mediaObject is null");
            return false;
        }
        if (mediaTagName != null && mediaTagName.length() > 64)
        {
            a.a("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, mediaTagName is too long");
            return false;
        }
        if (messageAction != null && messageAction.length() > 2048)
        {
            a.a("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, messageAction is too long");
            return false;
        }
        if (messageExt != null && messageExt.length() > 2048)
        {
            a.a("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, messageExt is too long");
            return false;
        } else
        {
            return mediaObject.checkArgs();
        }
    }

    public final int getType()
    {
        if (mediaObject == null)
        {
            return 0;
        } else
        {
            return mediaObject.type();
        }
    }

    public final void setThumbImage(Bitmap bitmap)
    {
        try
        {
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 85, bytearrayoutputstream);
            thumbData = bytearrayoutputstream.toByteArray();
            bytearrayoutputstream.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            bitmap.printStackTrace();
        }
        a.a("MicroMsg.SDK.WXMediaMessage", "put thumb failed");
    }

    private class IMediaObject
    {

        public static final int TYPE_APPDATA = 7;
        public static final int TYPE_EMOJI = 8;
        public static final int TYPE_FILE = 6;
        public static final int TYPE_IMAGE = 2;
        public static final int TYPE_MUSIC = 3;
        public static final int TYPE_PRODUCT = 10;
        public static final int TYPE_TEXT = 1;
        public static final int TYPE_UNKNOWN = 0;
        public static final int TYPE_URL = 5;
        public static final int TYPE_VIDEO = 4;

        public abstract boolean checkArgs();

        public abstract void serialize(Bundle bundle);

        public abstract int type();

        public abstract void unserialize(Bundle bundle);
    }

}
