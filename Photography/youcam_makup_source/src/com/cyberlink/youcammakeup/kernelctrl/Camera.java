// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.cyberlink.youcammakeup.clflurry.YMKYCPCamPOUUsageEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.flurry.PercentageOfCameraUsing;
import com.cyberlink.youcammakeup.flurry.a;
import com.cyberlink.youcammakeup.masteraccess.Exporter;
import com.cyberlink.youcammakeup.utility.al;
import com.pf.common.utility.m;
import java.io.File;
import java.util.Locale;
import java.util.UUID;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl:
//            i

public class Camera
{

    public static UUID a = UUID.randomUUID();
    private Uri b;
    private String c;

    private Camera()
    {
    }


    private Intent a(PackageManager packagemanager)
    {
        Object obj = al.a(packagemanager, "com.cyberlink.youperfect", "android.media.action.IMAGE_CAPTURE", "android.intent.category.DEFAULT");
        if (obj == null)
        {
            return new Intent("android.media.action.IMAGE_CAPTURE");
        } else
        {
            packagemanager = ((ActivityInfo) (obj)).packageName;
            obj = ((ActivityInfo) (obj)).name;
            Intent intent = new Intent();
            intent.setClassName(packagemanager, ((String) (obj)));
            return intent;
        }
    }

    private Uri a(int j)
    {
        return Uri.fromFile(b(j));
    }

    public static Camera a()
    {
        return com.cyberlink.youcammakeup.kernelctrl.i.a();
    }

    private File b(int j)
    {
        Object obj = null;
        m.d("YMK150505-0029", String.format(Locale.US, "MEDIA_TYPE: %d", new Object[] {
            Integer.valueOf(j)
        }));
        String s = Exporter.b();
        File file = new File(s);
        m.d("YMK150505-0029", String.format("mediaStorageDir: %s", new Object[] {
            String.valueOf(file)
        }));
        if (!Exporter.a(null, file))
        {
            b("failed to create directory");
            m.d("YMK150505-0029", String.format("CannotCreateFolderException: %s", new Object[] {
                String.valueOf(s)
            }));
            throw new CannotCreateFolderException(s);
        }
        if (j == 1)
        {
            obj = Exporter.i();
            m.d("YMK150505-0029", String.format("photoFilePath: %s", new Object[] {
                String.valueOf(obj)
            }));
            obj = new File(((String) (obj)));
        }
        return ((File) (obj));
    }

    public void a(Activity activity)
    {
        b = a(1);
        Object obj;
        if (b != null)
        {
            obj = b.getPath();
        } else
        {
            obj = "";
        }
        c = ((String) (obj));
        m.d("YMK150505-0029", String.format("mCapturedFileUri: %s", new Object[] {
            String.valueOf(b)
        }));
        m.d("YMK150505-0029", String.format("mCapturedFilePath: %s", new Object[] {
            String.valueOf(c)
        }));
        obj = a(activity.getPackageManager());
        if (((Intent) (obj)).getAction() == "android.media.action.IMAGE_CAPTURE")
        {
            com.cyberlink.youcammakeup.flurry.a.a(new PercentageOfCameraUsing(com.cyberlink.youcammakeup.flurry.PercentageOfCameraUsing.CameraType.b));
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKYCPCamPOUUsageEvent(com.cyberlink.youcammakeup.clflurry.YMKYCPCamPOUUsageEvent.CameraType.b));
            m.d("YMK150505-0029", "System camera.");
        } else
        {
            com.cyberlink.youcammakeup.flurry.a.a(new PercentageOfCameraUsing(com.cyberlink.youcammakeup.flurry.PercentageOfCameraUsing.CameraType.a));
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKYCPCamPOUUsageEvent(com.cyberlink.youcammakeup.clflurry.YMKYCPCamPOUUsageEvent.CameraType.a));
            m.d("YMK150505-0029", "YCP camera.");
        }
        ((Intent) (obj)).putExtra("output", b);
        b("Turn on camera.");
        m.d("YMK150505-0029", "Start the camera.");
        activity.startActivityForResult(((Intent) (obj)), 100);
    }

    public void a(String s)
    {
        c = s;
    }

    public String b()
    {
        return c;
    }

    public void b(String s)
    {
        m.b("Camera", s);
    }

    public boolean c()
    {
        return c != null && !c.equals("") && (new File(c)).isFile();
    }


    private class CannotCreateFolderException extends RuntimeException
    {

        private static final long serialVersionUID = 0xdd5441c4924491d1L;
        final Camera this$0;

        public CannotCreateFolderException(String s)
        {
            this$0 = Camera.this;
            super(s);
        }
    }

}
