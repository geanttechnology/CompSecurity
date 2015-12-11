// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;

public class nm
{

    public static Dialog a = null;
    public static kq b = null;
    public static ld c = null;
    public static boolean d = false;
    private static final String e = nm.getSimpleName();

    public nm()
    {
    }

    public static void a(Context context, nn nn)
    {
        b(context, new nn(nn) {

            final nn a;

            public void a()
            {
                nm.d = false;
                a.a();
            }

            
            {
                a = nn1;
                super();
            }
        });
    }

    public static void a(Context context, no no)
    {
        a = new kz(context, no);
        a.show();
    }

    private static void a(Context context, no no, nn nn)
    {
        if (context == null || ((Activity)context).isFinishing())
        {
            return;
        } else
        {
            b = new kq(context, no, nn);
            b.a();
            return;
        }
    }

    public static void a(Context context, no no, nn nn, boolean flag, int i)
    {
        if (!flag)
        {
            if (i == 0)
            {
                a(context, no, nn);
                return;
            } else
            {
                a(context, nn);
                return;
            }
        } else
        {
            a(context, no);
            return;
        }
    }

    private static void b(Context context, nn nn)
    {
        if (context == null || ((Activity)context).isFinishing())
        {
            return;
        } else
        {
            c = new ld(context, nn);
            c.a();
            return;
        }
    }

}
