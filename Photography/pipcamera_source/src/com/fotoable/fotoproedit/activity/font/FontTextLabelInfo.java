// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.font;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import com.pipcamera.application.PIPCameraApplication;
import java.io.IOException;
import java.io.InputStream;

public class FontTextLabelInfo
{

    public int a;
    public float b;
    public float c;
    public float d;
    public int e;
    public boolean f;
    public float g;
    public int h;
    public String i;
    public int j;
    public int k;
    public String l;
    public String m;
    public boolean n;
    public boolean o;
    public float p;
    public boolean q;
    public int r;
    public Rect s;
    public String t;
    public TEXTBGVIEWTYPE u;

    public FontTextLabelInfo()
    {
        c = 3F;
        b = 0.0F;
        d = 0.0F;
        f = false;
        g = 2.0F;
        h = 0xff000000;
        i = "";
        j = -1;
        k = 255;
        l = "";
        m = PIPCameraApplication.a.getResources().getText(0x7f060267).toString();
        o = false;
        n = false;
        p = 12F;
        e = 0xff000000;
        q = false;
        r = 30;
        a = -1;
    }

    private Bitmap a(String s1)
    {
        Bitmap bitmap;
        try
        {
            s1 = PIPCameraApplication.a.getAssets().open(s1);
            bitmap = BitmapFactory.decodeStream(s1);
            s1.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            s1.printStackTrace();
            return null;
        }
        return bitmap;
    }

    public Bitmap a()
    {
        return a(i);
    }
}
