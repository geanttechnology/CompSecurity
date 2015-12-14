// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.Bitmap;
import com.crashlytics.android.Crashlytics;
import com.tencent.mm.sdk.modelmsg.WXImageObject;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXTextObject;
import com.tencent.mm.sdk.modelmsg.WXWebpageObject;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import java.io.ByteArrayOutputStream;

public class of
{

    Context a;
    private IWXAPI b;

    public of(Context context)
    {
        b = WXAPIFactory.createWXAPI(context, "wx236dd568f82c78c2", true);
        b.registerApp("wx236dd568f82c78c2");
        a = context;
    }

    public static byte[] b(Bitmap bitmap, boolean flag)
    {
        if (bitmap == null)
        {
            return null;
        }
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, bytearrayoutputstream);
        if (flag)
        {
            bitmap.recycle();
        }
        bitmap = bytearrayoutputstream.toByteArray();
        try
        {
            bytearrayoutputstream.close();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            Crashlytics.logException(exception);
            return bitmap;
        }
        return bitmap;
    }

    private String c(String s)
    {
        if (s == null)
        {
            return String.valueOf(System.currentTimeMillis());
        } else
        {
            return (new StringBuilder()).append(s).append(System.currentTimeMillis()).toString();
        }
    }

    public void a(Bitmap bitmap)
    {
        a(bitmap, false);
    }

    public void a(Bitmap bitmap, boolean flag)
    {
        int i = 1;
        WXImageObject wximageobject = new WXImageObject(bitmap);
        WXMediaMessage wxmediamessage = new WXMediaMessage();
        wxmediamessage.mediaObject = wximageobject;
        if (bitmap != null)
        {
            wxmediamessage.thumbData = b(Bitmap.createScaledBitmap(bitmap, 100, 100, true), true);
            bitmap = new com.tencent.mm.sdk.modelmsg.SendMessageToWX.Req();
            bitmap.transaction = c("img");
            bitmap.message = wxmediamessage;
            if (!flag)
            {
                i = 0;
            }
            bitmap.scene = i;
            if (b.sendReq(bitmap))
            {
                return;
            }
        }
    }

    public void a(String s)
    {
        WXTextObject wxtextobject = new WXTextObject();
        wxtextobject.text = s;
        WXMediaMessage wxmediamessage = new WXMediaMessage();
        wxmediamessage.mediaObject = wxtextobject;
        wxmediamessage.description = s;
        s = new com.tencent.mm.sdk.modelmsg.SendMessageToWX.Req();
        s.transaction = c("text");
        s.message = wxmediamessage;
        s.scene = 0;
        b.sendReq(s);
    }

    public boolean a()
    {
        return b.getWXAppSupportAPI() >= 0x21020001;
    }

    public boolean a(uu uu1, Bitmap bitmap, boolean flag)
    {
        int i = 0;
        Object obj = new WXWebpageObject();
        obj.webpageUrl = uu1.d;
        obj = new WXMediaMessage(((com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject) (obj)));
        obj.title = uu1.a;
        obj.description = uu1.b;
        obj.thumbData = b(bitmap, false);
        uu1 = new com.tencent.mm.sdk.modelmsg.SendMessageToWX.Req();
        uu1.transaction = c("webpage");
        uu1.message = ((WXMediaMessage) (obj));
        if (flag)
        {
            i = 1;
        }
        uu1.scene = i;
        return b.sendReq(uu1);
    }

    public void b(Bitmap bitmap)
    {
        a(bitmap, true);
    }

    public boolean b()
    {
        return b.isWXAppInstalled();
    }

    public boolean b(String s)
    {
        WXTextObject wxtextobject = new WXTextObject();
        wxtextobject.text = s;
        WXMediaMessage wxmediamessage = new WXMediaMessage();
        wxmediamessage.mediaObject = wxtextobject;
        wxmediamessage.description = s;
        s = new com.tencent.mm.sdk.modelmsg.SendMessageToWX.Req();
        s.transaction = c("text");
        s.message = wxmediamessage;
        s.scene = 1;
        return b.sendReq(s);
    }
}
