// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.tencent.mm.sdk.openapi.WXImageObject;
import com.tencent.mm.sdk.openapi.WXMediaMessage;
import com.tencent.mm.sdk.openapi.WXTextObject;
import com.tencent.mm.sdk.openapi.WXWebpageObject;
import com.wantu.model.res.WXDLShareInfo;
import java.io.ByteArrayOutputStream;

public class atz
{

    Context a;
    private IWXAPI b;

    public atz(Context context)
    {
        b = WXAPIFactory.createWXAPI(context, "wx283019eeca171807");
        a = context;
    }

    public static byte[] b(Bitmap bitmap, boolean flag)
    {
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
            bitmap = new com.tencent.mm.sdk.openapi.SendMessageToWX.Req();
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
        s = new com.tencent.mm.sdk.openapi.SendMessageToWX.Req();
        s.transaction = c("text");
        s.message = wxmediamessage;
        s.scene = 0;
        b.sendReq(s);
    }

    public boolean a()
    {
        return b.getWXAppSupportAPI() >= 0x21020001;
    }

    public boolean a(WXDLShareInfo wxdlshareinfo, Bitmap bitmap, boolean flag)
    {
        int i = 0;
        Object obj = new WXWebpageObject();
        obj.webpageUrl = wxdlshareinfo.webpageUrl;
        obj = new WXMediaMessage(((com.tencent.mm.sdk.openapi.WXMediaMessage.IMediaObject) (obj)));
        obj.title = wxdlshareinfo.title;
        obj.description = wxdlshareinfo.description;
        obj.thumbData = b(bitmap, false);
        wxdlshareinfo = new com.tencent.mm.sdk.openapi.SendMessageToWX.Req();
        wxdlshareinfo.transaction = c("webpage");
        wxdlshareinfo.message = ((WXMediaMessage) (obj));
        if (flag)
        {
            i = 1;
        }
        wxdlshareinfo.scene = i;
        return b.sendReq(wxdlshareinfo);
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
        s = new com.tencent.mm.sdk.openapi.SendMessageToWX.Req();
        s.transaction = c("text");
        s.message = wxmediamessage;
        s.scene = 1;
        return b.sendReq(s);
    }
}
