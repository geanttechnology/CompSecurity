// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.graphics.Bitmap;
import android.util.Log;
import java.io.File;

class ng.Object
    implements Runnable
{

    final a a;

    public void run()
    {
        gm.b(a.a).a();
        gm.a(a.a, null);
    }

    ct(ct ct)
    {
        a = ct;
        super();
    }

    // Unreferenced inner class gm$1

/* anonymous class */
    class gm._cls1
        implements Runnable
    {

        final Bitmap a;
        final Activity b;
        final gm c;

        public void run()
        {
            c.a();
            Log.e(gm.a(c), "saveDisplayBitmap lock");
            gm.a(c, a);
            b.runOnUiThread(new gm._cls1._cls1(this));
            if (gm.c(c)) goto _L2; else goto _L1
_L1:
            gm gm1 = c;
            gm1.c = gm1.c + 1;
            gm.a(c, c.c);
            gm.a(c, (new StringBuilder()).append(gm.d(c)).append(String.valueOf(c.c)).toString(), gm.e(c));
            if (gm.f(c) - gm.g(c) < 6) goto _L2; else goto _L3
_L3:
            int i;
            int j;
            j = gm.f(c) - 6;
            i = gm.g(c);
_L9:
            if (i >= j) goto _L5; else goto _L4
_L4:
            File file = new File(gm.a((new StringBuilder()).append(gm.d(c)).append(String.valueOf(i)).toString()));
            if (file == null) goto _L7; else goto _L6
_L6:
            if (file.exists())
            {
                file.delete();
            }
              goto _L7
_L5:
            try
            {
                gm.b(c, j + 1);
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
_L2:
            c.b();
            Log.e(gm.a(c), "saveDisplayBitmap unlock");
            return;
_L7:
            i++;
            if (true) goto _L9; else goto _L8
_L8:
        }

            
            {
                c = gm1;
                a = bitmap;
                b = activity;
                super();
            }
    }

}
