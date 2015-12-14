// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.adbuttonlib;

import android.os.Environment;
import android.webkit.DownloadListener;
import android.widget.Toast;

// Referenced classes of package com.fotoable.adbuttonlib:
//            TWebBrowActivity

class <init>
    implements DownloadListener
{

    final TWebBrowActivity this$0;

    public void onDownloadStart(String s, String s1, String s2, String s3, long l)
    {
        if (!Environment.getExternalStorageState().equals("mounted"))
        {
            s = Toast.makeText(TWebBrowActivity.this, "\u9700\u8981SD\u5361\u3002", 1);
            s.setGravity(17, 0, 0);
            s.show();
            return;
        } else
        {
            (new this._cls0(TWebBrowActivity.this))._mth0(new String[] {
                s
            });
            return;
        }
    }

    private I()
    {
        this$0 = TWebBrowActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
