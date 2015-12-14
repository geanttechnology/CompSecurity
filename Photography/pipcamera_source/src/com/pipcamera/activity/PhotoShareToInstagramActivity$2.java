// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.Toast;
import java.io.File;
import rd;

// Referenced classes of package com.pipcamera.activity:
//            PhotoShareToInstagramActivity, NewPhotoShareActivity

class a
    implements Runnable
{

    final Bitmap a;
    final PhotoShareToInstagramActivity b;

    public void run()
    {
        File file = rd.a(a);
        b.runOnUiThread(new Runnable(file) {

            final File a;
            final PhotoShareToInstagramActivity._cls2 b;

            public void run()
            {
                if (a == null)
                {
                    Toast.makeText(b.b, b.b.getResources().getString(0x7f060196), 0).show();
                } else
                {
                    rd.a(a.getAbsolutePath(), b.b);
                    Uri uri = Uri.fromFile(a);
                    if (uri != null)
                    {
                        Intent intent = new Intent(b.b, com/pipcamera/activity/NewPhotoShareActivity);
                        intent.putExtra("PhotoShareActivity_ToShareImageUri", uri.toString());
                        b.b.startActivity(intent);
                        b.b.overridePendingTransition(0x7f040007, 0);
                        return;
                    }
                }
            }

            
            {
                b = PhotoShareToInstagramActivity._cls2.this;
                a = file;
                super();
            }
        });
    }

    _cls1.a(PhotoShareToInstagramActivity photosharetoinstagramactivity, Bitmap bitmap)
    {
        b = photosharetoinstagramactivity;
        a = bitmap;
        super();
    }
}
