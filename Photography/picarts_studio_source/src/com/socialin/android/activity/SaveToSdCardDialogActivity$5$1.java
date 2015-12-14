// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.photo.exif.ExifTool;
import com.socialin.android.util.FileUtils;
import com.socialin.android.util.Utils;
import com.socialin.android.util.c;
import com.socialin.android.util.w;
import java.io.File;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.activity:
//            SaveToSdCardDialogActivity

final class a
    implements Runnable
{

    private ViewById a;

    public final void run()
    {
        View view = a.a.findViewById(0x7f1003fe);
        if (view != null)
        {
            view.setVisibility(8);
        }
    }

    Event(Event event)
    {
        a = event;
        super();
    }

    // Unreferenced inner class com/socialin/android/activity/SaveToSdCardDialogActivity$5

/* anonymous class */
    final class SaveToSdCardDialogActivity._cls5 extends Thread
    {

        final SaveToSdCardDialogActivity a;
        private String b;
        private String c;

        public final void run()
        {
            Object obj = null;
            String s = (new StringBuilder()).append(b).append(SaveToSdCardDialogActivity.access$500(a)).toString();
            if (SaveToSdCardDialogActivity.access$700(a))
            {
                obj = new File(SaveToSdCardDialogActivity.access$800(a));
                File file = new File((new StringBuilder()).append(c).append("/temp").append(s).toString());
                FileUtils.b(((File) (obj)), file);
                obj = new File((new StringBuilder()).append(c).append("/").append(s).toString());
                FileUtils.b(file, ((File) (obj)));
                if (android.os.Build.VERSION.SDK_INT >= 19)
                {
                    a.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse((new StringBuilder("file://")).append(obj).toString())));
                } else
                {
                    a.sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED", Uri.parse((new StringBuilder("file://")).append(c).append(obj).toString())));
                }
                file.delete();
            } else
            if (SaveToSdCardDialogActivity.access$900(a))
            {
                obj = new File(SaveToSdCardDialogActivity.access$800(a));
                File file1 = new File((new StringBuilder()).append(c).append("/temp").append(s).toString());
                FileUtils.b(((File) (obj)), file1);
                obj = new File((new StringBuilder()).append(c).append("/").append(s).toString());
                FileUtils.b(file1, ((File) (obj)));
                file1.delete();
            } else
            {
                Bitmap bitmap = com.socialin.android.util.c.a(SaveToSdCardDialogActivity.access$800(a));
                if (bitmap != null)
                {
                    File file2 = w.a(c, s, bitmap, a, SaveToSdCardDialogActivity.access$400(a), true);
                    if (android.graphics.Bitmap.CompressFormat.JPEG.equals(SaveToSdCardDialogActivity.access$400(a)))
                    {
                        String s1 = m.c(SaveToSdCardDialogActivity.access$800(a));
                        if (s1 != null && file2 != null)
                        {
                            ExifTool.a(file2.getAbsolutePath(), ExifTool.b(SaveToSdCardDialogActivity.access$800(a)));
                            ExifTool.a(file2.getAbsolutePath(), "Exif.Photo.UserComment", s1);
                            if (SocialinV3.getInstance().isRegistered())
                            {
                                obj = String.valueOf(SocialinV3.getInstance().getUser().id);
                            }
                            if (obj != null && ExifTool.a(file2.getAbsolutePath(), "Exif.Image.Artist") == null)
                            {
                                ExifTool.a(file2.getAbsolutePath(), "Exif.Image.Artist", ((String) (obj)));
                            }
                        }
                    }
                    bitmap.recycle();
                    obj = file2;
                } else
                {
                    Utils.a(a, 0x7f0804ab);
                    a.finish();
                    obj = null;
                }
            }
            if (obj != null)
            {
                Utils.a(a, c);
                SaveToSdCardDialogActivity.access$1000(a, c, s, SaveToSdCardDialogActivity.access$400(a));
                SaveToSdCardDialogActivity.access$1100(a, "local");
                AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.EventsFactory.ExportImageSdEvent("sdcard_done", "bin"));
                return;
            } else
            {
                Utils.a(a, 0x7f0804a0);
                a.runOnUiThread(new SaveToSdCardDialogActivity._cls5._cls1(this));
                return;
            }
        }

            
            {
                a = savetosdcarddialogactivity;
                b = s;
                c = s1;
                super();
            }
    }

}
