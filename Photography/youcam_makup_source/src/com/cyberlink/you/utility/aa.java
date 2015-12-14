// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.utility;

import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.util.Log;
import com.cyberlink.you.pages.photoimport.a.a;
import com.nostra13.universalimageloader.a.a.a.a.f;
import java.io.File;
import java.io.IOException;

public class aa extends f
{

    public aa(File file, com.nostra13.universalimageloader.a.a.b.a a1, long l)
    {
        super(file, a1, l);
    }

    public boolean a(String s, Bitmap bitmap)
    {
        ExifInterface exifinterface = null;
        File file = a(s);
        if (file.exists())
        {
            exifinterface = new ExifInterface(file.getPath());
        }
        boolean flag = super.a(s, bitmap);
        if (flag && exifinterface != null)
        {
            s = new ExifInterface(a(s).getPath());
            if (file.exists())
            {
                try
                {
                    com.cyberlink.you.pages.photoimport.a.a.a(exifinterface, s);
                    s.setAttribute("ImageWidth", String.valueOf(bitmap.getWidth()));
                    s.setAttribute("ImageLength", String.valueOf(bitmap.getHeight()));
                    s.setAttribute("Orientation", Integer.toString(0));
                    s.saveAttributes();
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    Log.e("ULruDiskCache", "save(Bitmap) === cannot copy exif attribute", s);
                    return flag;
                }
            }
        }
        return flag;
    }
}
