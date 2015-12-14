// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.masteraccess;

import com.cyberlink.youcammakeup.jniproxy.UIImageCodecErrorCode;

public class de.a
{

    private final JavaError a;
    private final UIImageCodecErrorCode b;

    public JavaError a()
    {
        return a;
    }

    public UIImageCodecErrorCode b()
    {
        return b;
    }

    JavaError(UIImageCodecErrorCode uiimagecodecerrorcode)
    {
        class JavaError extends Enum
        {

            public static final JavaError a;
            public static final JavaError b;
            public static final JavaError c;
            public static final JavaError d;
            public static final JavaError e;
            public static final JavaError f;
            public static final JavaError g;
            public static final JavaError h;
            public static final JavaError i;
            public static final JavaError j;
            public static final JavaError k;
            private static final JavaError l[];

            public static JavaError valueOf(String s)
            {
                return (JavaError)Enum.valueOf(com/cyberlink/youcammakeup/masteraccess/Exporter$Error$JavaError, s);
            }

            public static JavaError[] values()
            {
                return (JavaError[])l.clone();
            }

            static 
            {
                a = new JavaError("NoError", 0);
                b = new JavaError("InvalidBuffer", 1);
                c = new JavaError("MakeDirs", 2);
                d = new JavaError("PathNotFolder", 3);
                e = new JavaError("FailedToGetFileId", 4);
                f = new JavaError("FailedToGetImageId", 5);
                g = new JavaError("FailedToGetAlbumId", 6);
                h = new JavaError("ViewEngine", 7);
                i = new JavaError("UnsupportExportFormat", 8);
                j = new JavaError("FileNotFound", 9);
                k = new JavaError("OutOfMemory", 10);
                l = (new JavaError[] {
                    a, b, c, d, e, f, g, h, i, j, 
                    k
                });
            }

            private JavaError(String s, int i1)
            {
                super(s, i1);
            }
        }

        a = JavaError.a;
        b = uiimagecodecerrorcode;
    }

    JavaError(JavaError javaerror)
    {
        a = javaerror;
        b = UIImageCodecErrorCode.a;
    }
}
