// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import com.fotoable.beautyui.newui.MNewFotoBeautyActivity;
import java.io.OutputStream;

public class ub
    implements Runnable
{

    final Uri a;
    final MNewFotoBeautyActivity b;

    public ub(MNewFotoBeautyActivity mnewfotobeautyactivity, Uri uri)
    {
        b = mnewfotobeautyactivity;
        a = uri;
        super();
    }

    public void run()
    {
        OutputStream outputstream = b.getContentResolver().openOutputStream(a);
        MNewFotoBeautyActivity.f(b).compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, outputstream);
        outputstream.close();
        boolean flag = true;
_L2:
        Intent intent = new Intent();
        intent.putExtra(MNewFotoBeautyActivity.h, flag);
        b.setResult(1244, intent);
        b.runOnUiThread(new uc(this));
        return;
        Exception exception;
        exception;
        exception.printStackTrace();
        flag = false;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
