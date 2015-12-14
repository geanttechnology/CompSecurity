// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.pipcamera.activity.NewPhotoShareActivity;
import gm;
import go;
import java.io.File;
import kf;
import rd;

// Referenced classes of package com.fotoable.fotoproedit.activity:
//            ProEditFilterActivity

class a extends Handler
{

    final ProEditFilterActivity a;

    public void handleMessage(Message message)
    {
        message = (Bitmap)message.obj;
        if (message != null)
        {
            try
            {
                kf.b("filter");
                gm.c().a(new go() {

                    final ProEditFilterActivity._cls6 a;

                    public void a()
                    {
                        Object obj;
                        if (!a.a.f)
                        {
                            break MISSING_BLOCK_LABEL_139;
                        }
                        obj = gm.c().k();
                        if (obj == null)
                        {
                            break MISSING_BLOCK_LABEL_104;
                        }
                        obj = rd.a(((Bitmap) (obj)));
                        rd.a(((File) (obj)).getAbsolutePath(), a.a);
                        obj = Uri.fromFile(((File) (obj)));
                        if (obj == null)
                        {
                            break MISSING_BLOCK_LABEL_104;
                        }
                        Intent intent = new Intent(a.a, com/pipcamera/activity/NewPhotoShareActivity);
                        intent.putExtra("PhotoShareActivity_ToShareImageUri", ((Uri) (obj)).toString());
                        a.a.startActivity(intent);
                        a.a.overridePendingTransition(0x7f040007, 0);
_L1:
                        Exception exception;
                        try
                        {
                            a.a.c();
                            return;
                        }
                        catch (Exception exception1)
                        {
                            a.a.c();
                            exception1.printStackTrace();
                            return;
                        }
                        exception;
                        exception.printStackTrace();
                          goto _L1
                        a.a.c();
                        a.a.setResult(-1);
                        a.a.finish();
                        a.a.overridePendingTransition(0, 0x7f040027);
                        return;
                    }

            
            {
                a = ProEditFilterActivity._cls6.this;
                super();
            }
                }, message, a);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Message message)
            {
                Log.e("ProEditFilterActivity", message.getMessage());
            }
            break MISSING_BLOCK_LABEL_64;
        }
        a.runOnUiThread(new Runnable() {

            final ProEditFilterActivity._cls6 a;

            public void run()
            {
                a.a.c();
            }

            
            {
                a = ProEditFilterActivity._cls6.this;
                super();
            }
        });
        return;
        a.c();
        return;
    }

    _cls2.a(ProEditFilterActivity proeditfilteractivity)
    {
        a = proeditfilteractivity;
        super();
    }
}
