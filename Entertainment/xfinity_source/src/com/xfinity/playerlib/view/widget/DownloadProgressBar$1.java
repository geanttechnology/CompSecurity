// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.widget;

import android.view.ViewTreeObserver;
import android.widget.ProgressBar;
import android.widget.TextView;

// Referenced classes of package com.xfinity.playerlib.view.widget:
//            DownloadProgressBar

class this._cls0
    implements android.view.balLayoutListener
{

    final DownloadProgressBar this$0;

    public void onGlobalLayout()
    {
label0:
        {
            int i = DownloadProgressBar.access$000(DownloadProgressBar.this).getWidth();
            int j = DownloadProgressBar.access$100(DownloadProgressBar.this).getWidth();
            int k = DownloadProgressBar.access$200(DownloadProgressBar.this).getWidth();
            if (i != 0 && j != 0 && k != 0)
            {
                if (i - j >= k)
                {
                    DownloadProgressBar.access$200(DownloadProgressBar.this).setVisibility(0);
                } else
                {
                    DownloadProgressBar.access$200(DownloadProgressBar.this).setVisibility(8);
                }
                if (android.os.lity < 16)
                {
                    break label0;
                }
                DownloadProgressBar.access$000(DownloadProgressBar.this).getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
            return;
        }
        DownloadProgressBar.access$000(DownloadProgressBar.this).getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }

    ()
    {
        this$0 = DownloadProgressBar.this;
        super();
    }
}
