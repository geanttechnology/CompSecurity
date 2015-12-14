// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import android.graphics.Bitmap;
import com.millennialmedia.MMLog;
import com.millennialmedia.internal.utils.MediaUtils;
import java.io.File;

// Referenced classes of package com.millennialmedia.internal:
//            JSBridge

class val.callbackId
    implements com.millennialmedia.internal.utils.
{

    final val.callbackId this$1;
    final String val$callbackId;
    final boolean val$maintainAspectRatio;
    final int val$maxHeight;
    final int val$maxWidth;

    public void onError(String s)
    {
        MMLog.e(JSBridge.access$000(), s);
        invokeCallback(val$callbackId, new Object[] {
            null
        });
    }

    public void onPhoto(File file)
    {
        String s = null;
        String s1 = MediaUtils.getMimeTypeFromFile(file);
        Bitmap bitmap = MediaUtils.getScaledBitmapFromFile(file, val$maxWidth, val$maxHeight, val$maintainAspectRatio, true);
        if (bitmap != null)
        {
            s = MediaUtils.base64EncodeBitmap(bitmap, s1);
            bitmap.recycle();
        }
        file.delete();
        invokeCallback(val$callbackId, new Object[] {
            s
        });
    }

    stener()
    {
        this$1 = final_stener;
        val$maxWidth = i;
        val$maxHeight = j;
        val$maintainAspectRatio = flag;
        val$callbackId = String.this;
        super();
    }
}
