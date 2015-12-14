// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;

public class ih
{

    private static boolean a = false;

    public static void a(Bitmap bitmap, float f)
    {
        if (a)
        {
            adf.a(bitmap, f);
        }
    }

    static 
    {
        try
        {
            System.loadLibrary("fotobeautyengine");
            a = true;
        }
        catch (Exception exception)
        {
            a = false;
        }
    }
}
