// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl;

import android.graphics.Bitmap;
import com.cyberlink.youcammakeup.jniproxy.d;
import com.cyberlink.youcammakeup.jniproxy.p;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import java.io.File;
import java.util.UUID;

public class t
{

    public static Bitmap a(ImageBufferWrapper imagebufferwrapper, boolean flag)
    {
        Bitmap bitmap1;
        bitmap1 = Bitmap.createBitmap((int)imagebufferwrapper.b(), (int)imagebufferwrapper.c(), android.graphics.Bitmap.Config.ARGB_8888);
        imagebufferwrapper.c(bitmap1);
        Bitmap bitmap;
        bitmap = bitmap1;
        if (flag)
        {
            imagebufferwrapper.m();
            bitmap = bitmap1;
        }
_L2:
        return bitmap;
        Object obj;
        obj;
        obj = null;
        if (!flag) goto _L2; else goto _L1
_L1:
        imagebufferwrapper.m();
        return null;
        obj;
        if (flag)
        {
            imagebufferwrapper.m();
        }
        throw obj;
    }

    public static ImageBufferWrapper a(String s, Boolean boolean1)
    {
        ImageBufferWrapper imagebufferwrapper;
        ImageBufferWrapper imagebufferwrapper1 = null;
        Object obj1 = null;
        imagebufferwrapper = null;
        Object obj = imagebufferwrapper1;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        obj = imagebufferwrapper1;
        if (s == "")
        {
            break MISSING_BLOCK_LABEL_107;
        }
        imagebufferwrapper1 = obj1;
        try
        {
            obj = new p();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return imagebufferwrapper1;
        }
        imagebufferwrapper1 = obj1;
        if (!d.a(s, ((p) (obj))))
        {
            break MISSING_BLOCK_LABEL_86;
        }
        imagebufferwrapper1 = obj1;
        imagebufferwrapper = new ImageBufferWrapper();
        try
        {
            imagebufferwrapper.a(((p) (obj)).b(), ((p) (obj)).c(), ((p) (obj)).d());
            imagebufferwrapper.j().a(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return imagebufferwrapper;
        }
        obj = imagebufferwrapper;
        imagebufferwrapper1 = imagebufferwrapper;
        if (!boolean1.booleanValue())
        {
            break MISSING_BLOCK_LABEL_107;
        }
        imagebufferwrapper1 = imagebufferwrapper;
        a(s);
        obj = imagebufferwrapper;
        return ((ImageBufferWrapper) (obj));
    }

    public static String a(ImageBufferWrapper imagebufferwrapper, String s)
    {
        String s1 = "";
        String s2 = s1;
        if (imagebufferwrapper == null)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        boolean flag;
        try
        {
            s2 = UUID.randomUUID().toString();
        }
        // Misplaced declaration of an exception variable
        catch (ImageBufferWrapper imagebufferwrapper)
        {
            return s1;
        }
        s1 = s2;
        flag = Boolean.valueOf(imagebufferwrapper.j().b((new StringBuilder()).append(s).append("/").append(s2).toString())).booleanValue();
        if (flag);
        return s2;
    }

    public static void a(String s)
    {
        if (s != "")
        {
            s = new File(s);
            if (s.exists() && s.canWrite() && !s.delete())
            {
                s.deleteOnExit();
            }
        }
    }

    public static Bitmap b(String s)
    {
        return a(a(s, Boolean.valueOf(false)), true);
    }
}
