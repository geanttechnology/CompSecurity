// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import com.cyberlink.youcammakeup.c;
import com.cyberlink.youcammakeup.database.o;
import com.cyberlink.youcammakeup.database.p;
import com.cyberlink.youcammakeup.database.r;
import com.cyberlink.youcammakeup.jniproxy.UIImageCodecErrorCode;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.DevelopSetting;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.e;
import com.cyberlink.youcammakeup.masteraccess.Exporter;
import com.cyberlink.youcammakeup.masteraccess.b;
import java.io.File;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl:
//            aa

public class Share
{

    private Handler a;
    private Exporter b;
    private ArrayList c;
    private aa d;
    private long e[];
    private boolean f;

    public Share(Context context, aa aa1)
    {
        a = new Handler();
        b = new Exporter();
        d = aa1;
        c = new ArrayList();
    }

    static ArrayList a(Share share)
    {
        return share.c;
    }

    private void a(int i)
    {
        d.a(i);
    }

    static void a(Share share, Exception exception)
    {
        share.a(exception);
    }

    private void a(Exception exception)
    {
        d.a(exception);
    }

    private void b()
    {
        d.a(c);
    }

    static boolean b(Share share)
    {
        return share.f;
    }

    private void c()
    {
        d.a();
    }

    static void c(Share share)
    {
        share.c();
    }

    static long[] d(Share share)
    {
        return share.e;
    }

    static void e(Share share)
    {
        share.b();
    }

    static Handler f(Share share)
    {
        return share.a;
    }

    public void a()
    {
        f = true;
    }

    public void a(int i, boolean flag)
    {
        boolean flag1 = false;
        DevelopSetting developsetting = com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.e.a().a(Long.valueOf(e[i]), Boolean.valueOf(false));
        Object obj = com.cyberlink.youcammakeup.c.f();
        obj = ((p) (obj)).e(((p) (obj)).a(e[i]).longValue());
        if (((r) (obj)).s() != ((r) (obj)).d())
        {
            flag1 = true;
        }
        a((int)(((float)(i + 1) * 100F) / (float)e.length));
        if (developsetting.g() && !flag && !flag1)
        {
            c.add(Uri.parse((new StringBuilder()).append("file://").append(com.cyberlink.youcammakeup.c.f().b(e[i]).b()).toString()));
            i++;
            if (f)
            {
                c();
                return;
            }
            if (i < e.length)
            {
                a(i, flag);
                return;
            } else
            {
                b();
                return;
            }
        } else
        {
            b.a(e[i], true, new com.cyberlink.youcammakeup.masteraccess.c(i, flag) {

                final int a;
                final boolean b;
                final Share c;

                public void a()
                {
                }

                public void a(com.cyberlink.youcammakeup.masteraccess.Exporter.Error error)
                {
                    Exception exception;
                    com.cyberlink.youcammakeup.masteraccess.Exporter.Error.JavaError javaerror;
                    UIImageCodecErrorCode uiimagecodecerrorcode;
                    exception = new Exception(ErrorMessage.a.name());
                    javaerror = error.a();
                    uiimagecodecerrorcode = error.b();
                    if (javaerror == com.cyberlink.youcammakeup.masteraccess.Exporter.Error.JavaError.a) goto _L2; else goto _L1
_L1:
                    error = exception;
_L4:
                    Share.a(c, error);
                    return;
_L2:
                    error = exception;
                    if (uiimagecodecerrorcode != UIImageCodecErrorCode.a)
                    {
                        if (uiimagecodecerrorcode == UIImageCodecErrorCode.j)
                        {
                            error = new Exception(com.cyberlink.youcammakeup.kernelctrl.ErrorMessage.b.name());
                        } else
                        {
                            error = exception;
                            if (uiimagecodecerrorcode == UIImageCodecErrorCode.i)
                            {
                                error = new Exception(com.cyberlink.youcammakeup.kernelctrl.ErrorMessage.c.name());
                            }
                        }
                    }
                    if (true) goto _L4; else goto _L3
_L3:
                }

                public void a(b b1)
                {
                    Share.f(c).post(new Runnable(this, b1) {

                        final b a;
                        final _cls1 b;

                        public void run()
                        {
                            if (a == null)
                            {
                                Exception exception = new Exception(ErrorMessage.a.name());
                                Share.a(b.c, exception);
                                return;
                            }
                            Uri uri = Uri.parse((new StringBuilder()).append("file://").append(a.b().getPath()).toString());
                            Share.a(b.c).add(uri);
                            int i = b.a + 1;
                            if (com.cyberlink.youcammakeup.kernelctrl.Share.b(b.c))
                            {
                                com.cyberlink.youcammakeup.kernelctrl.Share.c(b.c);
                                return;
                            }
                            if (i < Share.d(b.c).length)
                            {
                                b.c.a(i, b.b);
                                return;
                            } else
                            {
                                com.cyberlink.youcammakeup.kernelctrl.Share.e(b.c);
                                return;
                            }
                        }

            
            {
                b = _pcls1;
                a = b1;
                super();
            }
                    });
                }

            
            {
                c = Share.this;
                a = i;
                b = flag;
                super();
            }

                private class ErrorMessage extends Enum
                {

                    public static final ErrorMessage a;
                    public static final ErrorMessage b;
                    public static final ErrorMessage c;
                    private static final ErrorMessage d[];

                    public static ErrorMessage valueOf(String s)
                    {
                        return (ErrorMessage)Enum.valueOf(com/cyberlink/youcammakeup/kernelctrl/Share$ErrorMessage, s);
                    }

                    public static ErrorMessage[] values()
                    {
                        return (ErrorMessage[])d.clone();
                    }

                    static 
                    {
                        a = new ErrorMessage("GENERAL_ERROR", 0);
                        b = new ErrorMessage("DISK_FULL_ERROR", 1);
                        c = new ErrorMessage("OUT_OF_MEMORY_ERROR", 2);
                        d = (new ErrorMessage[] {
                            a, b, c
                        });
                    }

                    private ErrorMessage(String s, int i)
                    {
                        super(s, i);
                    }
                }

            });
            return;
        }
    }

    public void a(long al[], boolean flag)
    {
        e = al;
        a(0, flag);
    }
}
