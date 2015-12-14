// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotobeauty;

import abx;
import aby;
import aca;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import atq;
import bjd;
import bje;
import com.fotoable.shareinstagram.InstagramPhotoShareActivity;
import com.instabeauty.application.InstaBeautyApplication;
import java.util.ArrayList;

public class PhotoShareToInstagramActivity extends InstagramPhotoShareActivity
{

    bjd a;
    bje b;

    public PhotoShareToInstagramActivity()
    {
        b = new aca(this);
    }

    private void a(ArrayList arraylist)
    {
        char c = '\u03C0';
        a = new bjd();
        a.a(b);
        a.a(arraylist);
        if (getSharedPreferences("SP", 0).getInt("setting_func_img_quality", 0) != 0) goto _L2; else goto _L1
_L1:
        if (!InstaBeautyApplication.b)
        {
            c = '\u0500';
        }
        a.b(c);
_L4:
        a.d(new ArrayList[] {
            arraylist
        });
        return;
_L2:
        if (InstaBeautyApplication.b)
        {
            c = '\u0280';
        }
        a.b(c);
        if (true) goto _L4; else goto _L3
_L3:
        arraylist;
        arraylist.printStackTrace();
        return;
    }

    public void a()
    {
        finish();
    }

    public void b()
    {
        android.graphics.Bitmap bitmap;
        bitmap = c();
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        if (c)
        {
            atq.c(this, bitmap, "sync_instagram", null, new abx(this));
            return;
        }
        try
        {
            (new Thread(new aby(this, bitmap))).start();
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (getIntent() != null)
        {
            Intent intent = getIntent();
            bundle = intent.getStringExtra("kimageuri");
            c = intent.getBooleanExtra("KSHARETOINSTAGRAM", false);
            if (bundle != null)
            {
                ArrayList arraylist = new ArrayList();
                arraylist.add(Uri.parse(bundle));
                a(arraylist);
            }
        }
    }
}
