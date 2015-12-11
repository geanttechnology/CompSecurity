// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.content.DialogInterface;
import com.gotv.crackle.smarttv.SmartTV;

// Referenced classes of package com.gotv.crackle:
//            VideoPlayerActivity

class val.dataSent
    implements android.content.Listener
{

    final VideoPlayerActivity this$0;
    final String val$dataSent;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (VideoPlayerActivity.access$7600(VideoPlayerActivity.this))
        {
            VideoPlayerActivity.access$7602(VideoPlayerActivity.this, false);
            SmartTV.getInstance().sendData(val$dataSent);
        }
    }

    istener()
    {
        this$0 = final_videoplayeractivity;
        val$dataSent = String.this;
        super();
    }
}
