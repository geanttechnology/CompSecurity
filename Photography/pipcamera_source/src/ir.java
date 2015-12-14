// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import com.pipcamera.application.PIPCameraApplication;
import java.io.File;

public class ir
{

    public static String a = "FONT_DOWNLOAD_SUCCESS";
    private static ir b;
    private Context c;
    private in d;
    private iv e;
    private hb f;
    private is g;
    private boolean h;

    public ir()
    {
        h = true;
        d = new in() {

            final ir a;

            public void a(int i)
            {
                Object obj;
                File file;
                obj = (new StringBuilder()).append(ir.a()).append("/fonts/").append(ir.a(a).f).append(".zip").toString();
                file = new File(((String) (obj)));
                i;
                JVM INSTR tableswitch -1 1: default 76
            //                           -1 163
            //                           0 77
            //                           1 90;
                   goto _L1 _L2 _L3 _L4
_L1:
                return;
_L3:
                if (file.exists())
                {
                    file.delete();
                    return;
                }
                continue; /* Loop/switch isn't completed */
_L4:
                if (file.exists())
                {
                    obj = new it(((String) (obj)), (new StringBuilder()).append(ir.a()).append("/fonts/").toString(), ir.b(a), true, ir.c(a));
                    ((it) (obj)).a(ir.d(a));
                    ((it) (obj)).execute(new Void[0]);
                    return;
                }
                if (true) goto _L1; else goto _L2
_L2:
                if (file.exists())
                {
                    file.delete();
                }
                if (ir.e(a) != null)
                {
                    ir.e(a).a();
                    return;
                }
                if (true) goto _L1; else goto _L5
_L5:
            }

            
            {
                a = ir.this;
                super();
            }
        };
        e = new iv() {

            final ir a;

            public void a()
            {
                Object obj;
                obj = new File((new StringBuilder()).append(ir.a()).append("/fonts/").append(ir.a(a).f).append(".zip").toString());
                if (((File) (obj)).exists())
                {
                    ((File) (obj)).delete();
                }
                obj = new File((new StringBuilder()).append(ir.a()).append("/fonts/").append(ir.a(a).f).toString());
                if (!((File) (obj)).exists())
                {
                    break MISSING_BLOCK_LABEL_206;
                }
                obj = Typeface.createFromFile(((File) (obj)));
                if (obj != null)
                {
                    try
                    {
                        if (ir.e(a) != null)
                        {
                            ir.e(a).a(((Typeface) (obj)));
                        }
                        obj = new Intent(ir.a);
                        PIPCameraApplication.a.sendBroadcast(((Intent) (obj)));
                        return;
                    }
                    catch (Exception exception) { }
                    break MISSING_BLOCK_LABEL_183;
                }
                if (ir.e(a) != null)
                {
                    ir.e(a).a();
                    return;
                }
                break MISSING_BLOCK_LABEL_228;
                if (ir.e(a) != null)
                {
                    ir.e(a).a();
                    return;
                }
                break MISSING_BLOCK_LABEL_228;
                if (ir.e(a) != null)
                {
                    ir.e(a).a();
                }
            }

            
            {
                a = ir.this;
                super();
            }
        };
    }

    static hb a(ir ir1)
    {
        return ir1.f;
    }

    public static ir a(Context context)
    {
        if (b == null)
        {
            b = new ir();
        }
        b.b(context);
        return b;
    }

    public static String a()
    {
        return iq.a().d();
    }

    static Context b(ir ir1)
    {
        return ir1.c;
    }

    static boolean c(ir ir1)
    {
        return ir1.h;
    }

    static iv d(ir ir1)
    {
        return ir1.e;
    }

    static is e(ir ir1)
    {
        return ir1.g;
    }

    public void a(hb hb1, boolean flag)
    {
        f = hb1;
        h = flag;
        if (hb1.b != null && hb1.b.length() > 0)
        {
            hb1 = new im(hb1.b, (new StringBuilder()).append(a()).append("/fonts/").toString(), (new StringBuilder()).append(hb1.f).append(".zip").toString(), c, flag);
            hb1.a(d);
            hb1.execute(new Void[0]);
        } else
        if (g != null)
        {
            g.a();
            return;
        }
    }

    public void a(is is1)
    {
        g = is1;
    }

    public void b(Context context)
    {
        c = context;
    }

}
