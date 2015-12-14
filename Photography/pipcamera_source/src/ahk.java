// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Environment;
import android.webkit.DownloadListener;
import android.widget.Toast;
import nativead.WebBrowerActivity;

public class ahk
    implements DownloadListener
{

    final WebBrowerActivity a;

    private ahk(WebBrowerActivity webbroweractivity)
    {
        a = webbroweractivity;
        super();
    }

    public ahk(WebBrowerActivity webbroweractivity, nativead.WebBrowerActivity._cls1 _pcls1)
    {
        this(webbroweractivity);
    }

    public void onDownloadStart(String s, String s1, String s2, String s3, long l)
    {
        if (!Environment.getExternalStorageState().equals("mounted"))
        {
            s = Toast.makeText(a, "\u9700\u8981SD\u5361\u3002", 1);
            s.setGravity(17, 0, 0);
            s.show();
            return;
        } else
        {
            (new ahj(a)).execute(new String[] {
                s
            });
            return;
        }
    }
}
