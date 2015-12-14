// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.crashlytics.android.Crashlytics;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNew;
import com.fotoable.fotobeauty.NewPhotoShareActivity;
import java.io.File;
import java.io.PrintStream;

public class abt
    implements Runnable
{

    final NewPhotoShareActivity a;

    public abt(NewPhotoShareActivity newphotoshareactivity)
    {
        a = newphotoshareactivity;
        super();
    }

    public void run()
    {
        Object obj;
        String s1;
        NewPhotoShareActivity.b(a);
        obj = a.getIntent();
        if (a.getIntent() != null)
        {
            String s = a.getIntent().getStringExtra("share_tag");
            if (s != null && s.length() > 0)
            {
                NewPhotoShareActivity.a(a, s);
            }
        }
        NewPhotoShareActivity.a(a, ((Intent) (obj)).getBooleanExtra(ActivityCameraNew.c, false));
        if (((Intent) (obj)).getStringExtra("PhotoShareActivity_ToShareImageUri") == null)
        {
            break MISSING_BLOCK_LABEL_245;
        }
        s1 = ((Intent) (obj)).getStringExtra("PhotoShareActivity_ToShareImageUri");
        obj = s1;
        if (!s1.substring(0, 8).equals("file://"))
        {
            obj = (new StringBuilder()).append("file://").append(s1).toString();
        }
        NewPhotoShareActivity.a(a, Uri.parse(((String) (obj))));
        NewPhotoShareActivity.b(a, NewPhotoShareActivity.c(a));
        System.out.println((new StringBuilder()).append("imageuristring:").append(NewPhotoShareActivity.d(a)).toString());
        NewPhotoShareActivity.a(a, android.provider.MediaStore.Images.Media.getBitmap(a.getContentResolver(), NewPhotoShareActivity.c(a)));
        NewPhotoShareActivity.b(a, NewPhotoShareActivity.d(a).getPath());
_L1:
        return;
        obj;
        ((Exception) (obj)).printStackTrace();
        Crashlytics.logException(((Throwable) (obj)));
        a.finish();
        return;
        if (((Intent) (obj)).getStringExtra("image_file_path") != null)
        {
            try
            {
                obj = ((Intent) (obj)).getStringExtra("image_file_path");
                File file = new File(((String) (obj)));
                NewPhotoShareActivity.b(a, Uri.fromFile(file));
                NewPhotoShareActivity.a(a, NewPhotoShareActivity.d(a));
                NewPhotoShareActivity.a(a, BitmapFactory.decodeFile(((String) (obj))));
                NewPhotoShareActivity.b(a, NewPhotoShareActivity.d(a).getPath());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((Exception) (obj)).printStackTrace();
            }
            Crashlytics.logException(((Throwable) (obj)));
            a.finish();
            return;
        }
        obj = ((Intent) (obj)).getStringExtra("imageUrlString");
        NewPhotoShareActivity.a(a, boy.b().b(((String) (obj))));
        String s2 = boy.b().a(((String) (obj)));
        NewPhotoShareActivity.b(a, Uri.parse(s2));
        NewPhotoShareActivity.a(a, NewPhotoShareActivity.d(a));
        System.out.println((new StringBuilder()).append("imageuristring:").append(((String) (obj))).append(",pipmap:").append(s2).toString());
        NewPhotoShareActivity.b(a, NewPhotoShareActivity.d(a).getPath());
        if (NewPhotoShareActivity.e(a) != null)
        {
            return;
        }
          goto _L1
    }
}
