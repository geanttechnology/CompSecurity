// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import com.crashlytics.android.Crashlytics;
import com.fotoable.photocollage.activity.compose2.CollageModuleFragment2;
import com.fotoable.photocollage.activity.compose2.ComposePhotoesActivity2;
import java.io.File;

class ng.Object
    implements Runnable
{

    final File a;
    final .File b;

    public void run()
    {
        ComposePhotoesActivity2.a(b.b.a, a);
    }

    .File(.File file, File file1)
    {
        b = file;
        a = file1;
        super();
    }

    // Unreferenced inner class lj$1

/* anonymous class */
    class lj._cls1
        implements Runnable
    {

        final lj a;

        public void run()
        {
            boolean flag = true;
            if (a.a.t != null)
            {
                a.a.F = true;
                Object obj = a.a;
                if (a.a.I != com.fotoable.photocollage.service.collage.FixComposeResourceManager.FixComposeType.COMPOSE_43)
                {
                    flag = false;
                }
                obj.G = flag;
                a.a.E = a.a.t.a();
            }
            try
            {
                obj = rd.a(a.a.E);
                a.a.runOnUiThread(new lj._cls1._cls1(this, ((File) (obj))));
                return;
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
                Crashlytics.logException(exception);
                a.a.runOnUiThread(new lj._cls1._cls2());
                return;
            }
        }

            
            {
                a = lj1;
                super();
            }

        // Unreferenced inner class lj$1$2

/* anonymous class */
        class lj._cls1._cls2
            implements Runnable
        {

            final lj._cls1 a;

            public void run()
            {
                a.a.a.b(false);
                if (a.a.a.E != null && !a.a.a.E.isRecycled())
                {
                    a.a.a.E.recycle();
                    a.a.a.E = null;
                }
            }

                    
                    {
                        a = lj._cls1.this;
                        super();
                    }
        }

    }

}
