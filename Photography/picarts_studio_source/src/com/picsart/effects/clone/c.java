// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.clone;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.socialin.android.photo.imgop.ImageOpCommon;
import com.socialin.android.util.w;
import java.nio.ByteBuffer;

// Referenced classes of package com.picsart.effects.clone:
//            d

public final class c
    implements android.os.Handler.Callback
{

    Handler a;
    private d b;

    public c(d d1)
    {
        b = d1;
    }

    public final boolean handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 0 0: default 24
    //                   0 26;
           goto _L1 _L2
_L1:
        return false;
_L2:
        if (b == null) goto _L1; else goto _L3
_L3:
        Object obj;
        int i;
        int j;
        i = b.d();
        message = b.c();
        j = b.a();
        obj = b.b();
        if (message == null) goto _L5; else goto _L4
_L4:
        message = w.a(message, i, j);
        obj = null;
_L15:
        if (obj == null || obj == message) goto _L7; else goto _L6
_L6:
        ((Bitmap) (obj)).recycle();
_L7:
        if (message == null) goto _L9; else goto _L8
_L8:
        if (message.isRecycled()) goto _L9; else goto _L10
_L10:
        Log.e("ex1", (new StringBuilder("ClonActivity origBitmap size w = ")).append(message.getWidth()).append(" h = ").append(message.getHeight()).toString());
        obj = ImageOpCommon.allocNativeBuffer(message.getWidth() * message.getHeight() * 4);
        ((ByteBuffer) (obj)).position(0);
        message.copyPixelsToBuffer(((java.nio.Buffer) (obj)));
        ((ByteBuffer) (obj)).position(0);
        ImageOpCommon.changeBufferAlphaChannelWithAlpha(((java.nio.Buffer) (obj)), message.getWidth() * message.getHeight(), 255);
        ((ByteBuffer) (obj)).position(0);
        message.copyPixelsFromBuffer(((java.nio.Buffer) (obj)));
        ImageOpCommon.freeNativeBuffer(((ByteBuffer) (obj)));
        if (message.getWidth() <= 640 && message.getHeight() <= 640) goto _L12; else goto _L11
_L11:
        obj = w.a(message, 640, 640);
        boolean flag = true;
_L17:
        System.gc();
_L18:
        b.a(message, ((Bitmap) (obj)), flag);
        return false;
_L5:
        message = w.b(((String) (obj)), i, j);
        System.gc();
_L16:
        if (message.isMutable()) goto _L14; else goto _L13
_L13:
        Bitmap bitmap = com.socialin.android.util.c.b(message, android.graphics.Bitmap.Config.ARGB_8888);
        obj = message;
        message = bitmap;
          goto _L15
_L20:
        ((Exception) (obj)).printStackTrace();
          goto _L16
_L14:
        Message message1 = message;
        obj = message;
        message = message1;
          goto _L15
_L12:
        Object obj1 = null;
        flag = false;
        obj = message;
        message = obj1;
          goto _L17
        Exception exception;
        exception;
        message = null;
        obj = null;
        flag = false;
_L19:
        exception.printStackTrace();
          goto _L18
        exception;
        obj = null;
        flag = false;
          goto _L19
        exception;
          goto _L19
        obj;
          goto _L20
_L9:
        obj = null;
        flag = false;
          goto _L17
        obj;
        message = null;
          goto _L20
    }
}
