// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.Test118;

import android.graphics.Bitmap;
import android.util.Log;
import com.crashlytics.android.Crashlytics;
import java.io.File;
import java.io.FileOutputStream;

public class NativeView
{

    private static boolean a = false;

    private static native int RenderBitmap(Bitmap bitmap, int i, int j, int k, String s);

    public static void a(Bitmap bitmap, String s, int i)
    {
        if (bitmap == null)
        {
            throw new NullPointerException();
        }
        if (bitmap.getConfig() != android.graphics.Bitmap.Config.ARGB_8888 || !a)
        {
            try
            {
                s = new FileOutputStream(new File(s));
                bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, i, s);
                s.flush();
                s.close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Bitmap bitmap)
            {
                Crashlytics.logException(bitmap);
            }
            throw bitmap;
        }
        try
        {
            RenderBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), i, s);
            return;
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
            try
            {
                s = new FileOutputStream(new File(s));
                bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, i, s);
                s.flush();
                s.close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Bitmap bitmap)
            {
                Crashlytics.logException(bitmap);
            }
            throw exception;
        }
    }

    static 
    {
        try
        {
            System.loadLibrary("Test118");
            a = true;
        }
        catch (Exception exception)
        {
            a = false;
            Crashlytics.logException(exception);
        }
        catch (UnsatisfiedLinkError unsatisfiedlinkerror)
        {
            a = false;
            Crashlytics.logException(unsatisfiedlinkerror);
            Log.e("Test118", "catch UnsatisfiedLinkError success");
        }
        catch (Error error)
        {
            a = false;
            Log.e("Test118", "catch Error success");
        }
    }
}
