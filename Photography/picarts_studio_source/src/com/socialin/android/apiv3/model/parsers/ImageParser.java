// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.model.parsers;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.InputStream;

// Referenced classes of package com.socialin.android.apiv3.model.parsers:
//            IStreamParser

public class ImageParser
    implements IStreamParser
{

    private static ImageParser instance;

    private ImageParser()
    {
    }

    public static ImageParser instance()
    {
        com/socialin/android/apiv3/model/parsers/ImageParser;
        JVM INSTR monitorenter ;
        ImageParser imageparser;
        if (instance == null)
        {
            instance = new ImageParser();
        }
        imageparser = instance;
        com/socialin/android/apiv3/model/parsers/ImageParser;
        JVM INSTR monitorexit ;
        return imageparser;
        Exception exception;
        exception;
        throw exception;
    }

    public Bitmap parse(InputStream inputstream)
    {
        return BitmapFactory.decodeStream(inputstream);
    }

    public volatile Object parse(InputStream inputstream)
    {
        return parse(inputstream);
    }
}
