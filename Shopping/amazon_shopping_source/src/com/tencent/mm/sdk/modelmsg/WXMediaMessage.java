// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.modelmsg;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayOutputStream;

public final class WXMediaMessage
{
    public static class Builder
    {

        public static WXMediaMessage fromBundle(Bundle bundle)
        {
            WXMediaMessage wxmediamessage = new WXMediaMessage();
            wxmediamessage.sdkVer = bundle.getInt("_wxobject_sdkVer");
            wxmediamessage.title = bundle.getString("_wxobject_title");
            wxmediamessage.description = bundle.getString("_wxobject_description");
            wxmediamessage.thumbData = bundle.getByteArray("_wxobject_thumbdata");
            wxmediamessage.mediaTagName = bundle.getString("_wxobject_mediatagname");
            wxmediamessage.messageAction = bundle.getString("_wxobject_message_action");
            wxmediamessage.messageExt = bundle.getString("_wxobject_message_ext");
            String s = pathOldToNew(bundle.getString("_wxobject_identifier_"));
            if (s == null || s.length() <= 0)
            {
                return wxmediamessage;
            }
            try
            {
                wxmediamessage.mediaObject = (IMediaObject)Class.forName(s).newInstance();
                wxmediamessage.mediaObject.unserialize(bundle);
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                bundle.printStackTrace();
                Log.e("MicroMsg.SDK.WXMediaMessage", (new StringBuilder()).append("get media object from bundle failed: unknown ident ").append(s).append(", ex = ").append(bundle.getMessage()).toString());
                return wxmediamessage;
            }
            return wxmediamessage;
        }

        private static String pathNewToOld(String s)
        {
            if (s == null || s.length() == 0)
            {
                Log.e("MicroMsg.SDK.WXMediaMessage", "pathNewToOld fail, newPath is null");
                return s;
            } else
            {
                return s.replace("com.tencent.mm.sdk.modelmsg", "com.tencent.mm.sdk.openapi");
            }
        }

        private static String pathOldToNew(String s)
        {
            if (s == null || s.length() == 0)
            {
                Log.e("MicroMsg.SDK.WXMediaMessage", "pathOldToNew fail, oldPath is null");
                return s;
            } else
            {
                return s.replace("com.tencent.mm.sdk.openapi", "com.tencent.mm.sdk.modelmsg");
            }
        }

        public static Bundle toBundle(WXMediaMessage wxmediamessage)
        {
            Bundle bundle = new Bundle();
            bundle.putInt("_wxobject_sdkVer", wxmediamessage.sdkVer);
            bundle.putString("_wxobject_title", wxmediamessage.title);
            bundle.putString("_wxobject_description", wxmediamessage.description);
            bundle.putByteArray("_wxobject_thumbdata", wxmediamessage.thumbData);
            if (wxmediamessage.mediaObject != null)
            {
                bundle.putString("_wxobject_identifier_", pathNewToOld(wxmediamessage.mediaObject.getClass().getName()));
                wxmediamessage.mediaObject.serialize(bundle);
            }
            bundle.putString("_wxobject_mediatagname", wxmediamessage.mediaTagName);
            bundle.putString("_wxobject_message_action", wxmediamessage.messageAction);
            bundle.putString("_wxobject_message_ext", wxmediamessage.messageExt);
            return bundle;
        }

        public Builder()
        {
        }
    }

    public static interface IMediaObject
    {

        public abstract boolean checkArgs();

        public abstract void serialize(Bundle bundle);

        public abstract int type();

        public abstract void unserialize(Bundle bundle);
    }


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

    boolean checkArgs()
    {
        if (getType() == 8 && (thumbData == null || thumbData.length == 0))
        {
            Log.e("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, thumbData should not be null when send emoji");
            return false;
        }
        if (thumbData != null && thumbData.length > 32768)
        {
            Log.e("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, thumbData is invalid");
            return false;
        }
        if (title != null && title.length() > 512)
        {
            Log.e("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, title is invalid");
            return false;
        }
        if (description != null && description.length() > 1024)
        {
            Log.e("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, description is invalid");
            return false;
        }
        if (mediaObject == null)
        {
            Log.e("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, mediaObject is null");
            return false;
        }
        if (mediaTagName != null && mediaTagName.length() > 64)
        {
            Log.e("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, mediaTagName is too long");
            return false;
        }
        if (messageAction != null && messageAction.length() > 2048)
        {
            Log.e("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, messageAction is too long");
            return false;
        }
        if (messageExt != null && messageExt.length() > 2048)
        {
            Log.e("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, messageExt is too long");
            return false;
        } else
        {
            return mediaObject.checkArgs();
        }
    }

    public int getType()
    {
        if (mediaObject == null)
        {
            return 0;
        } else
        {
            return mediaObject.type();
        }
    }

    public void setThumbImage(Bitmap bitmap)
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
        Log.e("MicroMsg.SDK.WXMediaMessage", "put thumb failed");
    }
}
