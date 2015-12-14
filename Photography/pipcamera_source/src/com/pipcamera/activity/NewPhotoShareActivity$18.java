// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.crashlytics.android.Crashlytics;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import uz;
import yl;

// Referenced classes of package com.pipcamera.activity:
//            NewPhotoShareActivity

class a
    implements Runnable
{

    final NewPhotoShareActivity a;

    public void run()
    {
        try
        {
            Thread.sleep(300L);
        }
        catch (InterruptedException interruptedexception) { }
        a.runOnUiThread(new Runnable() {

            final NewPhotoShareActivity._cls18 a;

            public void run()
            {
                Object obj;
                NewPhotoShareActivity.b(a.a);
                obj = a.a.getIntent();
                if (a.a.getIntent() != null)
                {
                    String s = a.a.getIntent().getStringExtra("share_tag");
                    if (s != null && s.length() > 0)
                    {
                        NewPhotoShareActivity.a(a.a, s);
                    }
                }
                if (((Intent) (obj)).getStringExtra("PhotoShareActivity_ToShareImageUri") == null)
                {
                    break MISSING_BLOCK_LABEL_345;
                }
                obj = ((Intent) (obj)).getStringExtra("PhotoShareActivity_ToShareImageUri");
                Object obj1 = new File(new URI(((String) (obj)).replace(" ", "%20")));
                uz.a().b(((File) (obj1)).getPath());
                uz.a().a(false);
                NewPhotoShareActivity.a(a.a, Uri.parse(((String) (obj))));
                NewPhotoShareActivity.b(a.a, ((File) (obj1)).getPath());
                NewPhotoShareActivity.c(a.a, uz.a().d());
                NewPhotoShareActivity.a(a.a, android.provider.MediaStore.Images.Media.getBitmap(a.a.getContentResolver(), NewPhotoShareActivity.c(a.a)));
                NewPhotoShareActivity.d(a.a).setText(0x7f060197);
                obj1 = new AlphaAnimation(1.0F, 0.0F);
                ((Animation) (obj1)).setInterpolator(new DecelerateInterpolator());
                ((Animation) (obj1)).setDuration(2000L);
                ((Animation) (obj1)).setFillAfter(true);
                NewPhotoShareActivity.e(a.a).startAnimation(((Animation) (obj1)));
                obj1 = a.a.getSharedPreferences("savephotoImageString", 0).edit();
                ((android.content.SharedPreferences.Editor) (obj1)).putString("imageString", ((String) (obj)));
                ((android.content.SharedPreferences.Editor) (obj1)).commit();
_L1:
                return;
                obj;
                Crashlytics.logException(((Throwable) (obj)));
                a.a.finish();
                return;
                obj;
                ((FileNotFoundException) (obj)).printStackTrace();
                Crashlytics.logException(((Throwable) (obj)));
                return;
                obj;
                ((IOException) (obj)).printStackTrace();
                Crashlytics.logException(((Throwable) (obj)));
                return;
                obj = ((Intent) (obj)).getStringExtra("imageUrlString");
                NewPhotoShareActivity.a(a.a, yl.a().b(((String) (obj))));
                NewPhotoShareActivity.c(a.a, yl.a().a(((String) (obj))));
                if (NewPhotoShareActivity.f(a.a) != null)
                {
                    NewPhotoShareActivity.g(a.a);
                    return;
                }
                  goto _L1
            }

            
            {
                a = NewPhotoShareActivity._cls18.this;
                super();
            }
        });
    }

    _cls1.a(NewPhotoShareActivity newphotoshareactivity)
    {
        a = newphotoshareactivity;
        super();
    }
}
