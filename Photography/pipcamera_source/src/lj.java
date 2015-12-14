// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.View;
import com.crashlytics.android.Crashlytics;
import com.fotoable.photocollage.activity.compose2.CollageModuleFragment2;
import com.fotoable.photocollage.activity.compose2.ComposePhotoesActivity2;
import java.io.File;

public class lj
    implements android.view.View.OnClickListener
{

    final ComposePhotoesActivity2 a;

    public lj(ComposePhotoesActivity2 composephotoesactivity2)
    {
        a = composephotoesactivity2;
        super();
    }

    public void onClick(View view)
    {
        a.a(a.getResources().getString(0x7f0601a4));
        a.x.setEnabled(false);
        if (a.t != null)
        {
            a.t.c();
        }
        (new Thread(new Runnable() {

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
                    a.a.runOnUiThread(new Runnable(this, ((File) (obj))) {

                        final File a;
                        final _cls1 b;

                        public void run()
                        {
                            ComposePhotoesActivity2.a(b.a.a, a);
                        }

            
            {
                b = _pcls1;
                a = file;
                super();
            }
                    });
                    return;
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                    Crashlytics.logException(exception);
                    a.a.runOnUiThread(new Runnable(this) {

                        final _cls1 a;

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
                a = _pcls1;
                super();
            }
                    });
                    return;
                }
            }

            
            {
                a = lj.this;
                super();
            }
        })).start();
    }
}
