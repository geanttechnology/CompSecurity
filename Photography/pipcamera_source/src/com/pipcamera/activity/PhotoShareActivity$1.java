// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.widget.ImageView;
import com.crashlytics.android.Crashlytics;
import java.io.File;
import java.net.URI;
import uz;
import yl;

// Referenced classes of package com.pipcamera.activity:
//            PhotoShareActivity

public class a
    implements Runnable
{

    final ProgressDialog a;
    final PhotoShareActivity b;

    public void run()
    {
        Object obj;
        Object obj1;
        a.dismiss();
        obj = (ImageView)b.findViewById(0x7f0c01e5);
        obj1 = b.getIntent();
        ((Intent) (obj1)).getStringExtra("PhotoShareActivity_ToShareImageUri");
        if (((Intent) (obj1)).getStringExtra("PhotoShareActivity_ToShareImageUri") == null)
        {
            break MISSING_BLOCK_LABEL_178;
        }
        obj1 = ((Intent) (obj1)).getStringExtra("PhotoShareActivity_ToShareImageUri");
        File file = new File(new URI(((String) (obj1)).replace(" ", "%20")));
        uz.a().b(file.getPath());
        uz.a().a(false);
        PhotoShareActivity.a(b, Uri.parse(((String) (obj1))));
        ((ImageView) (obj)).setImageURI(PhotoShareActivity.a(b));
        PhotoShareActivity.a(b, android.provider.ia.getBitmap(b.getContentResolver(), PhotoShareActivity.a(b)));
        if (PhotoShareActivity.b(b) != null)
        {
            ((ImageView) (obj)).setImageBitmap(PhotoShareActivity.b(b));
        }
_L1:
        return;
        obj;
        ((Exception) (obj)).printStackTrace();
        Crashlytics.logException(((Throwable) (obj)));
        b.finish();
        return;
        obj1 = ((Intent) (obj1)).getStringExtra("imageUrlString");
        PhotoShareActivity.a(b, yl.a().b(((String) (obj1))));
        ((ImageView) (obj)).setImageBitmap(PhotoShareActivity.b(b));
        if (PhotoShareActivity.b(b) != null)
        {
            PhotoShareActivity.c(b);
            return;
        }
          goto _L1
    }

    (PhotoShareActivity photoshareactivity, ProgressDialog progressdialog)
    {
        b = photoshareactivity;
        a = progressdialog;
        super();
    }
}
