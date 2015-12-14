// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.util.Utils;
import java.io.File;

// Referenced classes of package com.socialin.android.activity:
//            SaveToSdCardDialogActivity

final class b
    implements android.content.
{

    public final void onClick(DialogInterface dialoginterface, int i)
    {
    }

    b()
    {
    }

    // Unreferenced inner class com/socialin/android/activity/SaveToSdCardDialogActivity$3

/* anonymous class */
    final class SaveToSdCardDialogActivity._cls3
        implements android.view.View.OnClickListener
    {

        final SaveToSdCardDialogActivity a;

        public final void onClick(View view)
        {
            view = SaveToSdCardDialogActivity.access$100(a).getText().toString();
            String s = (String)SaveToSdCardDialogActivity.access$200(a).getSelectedItem();
            Object obj = (String)SaveToSdCardDialogActivity.access$300(a).getSelectedItem();
            if (!TextUtils.isEmpty(view))
            {
                if (((String) (obj)).equals("PNG"))
                {
                    SaveToSdCardDialogActivity.access$402(a, android.graphics.Bitmap.CompressFormat.PNG);
                    SaveToSdCardDialogActivity.access$502(a, ".png");
                } else
                if (((String) (obj)).equals("JPEG"))
                {
                    SaveToSdCardDialogActivity.access$402(a, android.graphics.Bitmap.CompressFormat.JPEG);
                    SaveToSdCardDialogActivity.access$502(a, ".jpg");
                } else
                if (((String) (obj)).equals("GIF"))
                {
                    SaveToSdCardDialogActivity.access$402(a, null);
                    SaveToSdCardDialogActivity.access$502(a, ".gif");
                } else
                if (((String) (obj)).equals("WEBM"))
                {
                    SaveToSdCardDialogActivity.access$402(a, null);
                    SaveToSdCardDialogActivity.access$502(a, ".webm");
                } else
                if (((String) (obj)).equals("MP4"))
                {
                    SaveToSdCardDialogActivity.access$402(a, null);
                    SaveToSdCardDialogActivity.access$502(a, ".mp4");
                }
                obj = new File((new StringBuilder()).append(s).append("/").append(view).append(SaveToSdCardDialogActivity.access$500(a)).toString());
                AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.EventsFactory.ExportImageEvent("sdcard", "bin"));
                (new StringBuilder("SAVED FILE ****************** ")).append(obj);
                if (((File) (obj)).exists())
                {
                    obj = (new android.app.AlertDialog.Builder(a)).create();
                    ((AlertDialog) (obj)).setMessage(a.getText(0x7f080475));
                    ((AlertDialog) (obj)).setButton(-1, a.getString(0x7f080311), new SaveToSdCardDialogActivity._cls3._cls1(s, view));
                    ((AlertDialog) (obj)).setButton(-2, a.getString(0x7f080295), new SaveToSdCardDialogActivity._cls3._cls2());
                    ((AlertDialog) (obj)).show();
                    return;
                } else
                {
                    SaveToSdCardDialogActivity.access$600(a, s, view);
                    return;
                }
            } else
            {
                Utils.c(a, a.getString(0x7f080571));
                return;
            }
        }

            
            {
                a = savetosdcarddialogactivity;
                super();
            }

        // Unreferenced inner class com/socialin/android/activity/SaveToSdCardDialogActivity$3$1

/* anonymous class */
        final class SaveToSdCardDialogActivity._cls3._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            private String a;
            private String b;
            private SaveToSdCardDialogActivity._cls3 c;

            public final void onClick(DialogInterface dialoginterface, int i)
            {
                SaveToSdCardDialogActivity.access$600(c.a, a, b);
            }

                    
                    {
                        c = SaveToSdCardDialogActivity._cls3.this;
                        a = s;
                        b = s1;
                        super();
                    }
        }

    }

}
