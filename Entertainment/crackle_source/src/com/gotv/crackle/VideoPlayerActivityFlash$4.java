// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import com.gotv.crackle.data.MediaDetailsRequest;
import com.gotv.crackle.model.MediaDetailsItem;
import java.util.Map;

// Referenced classes of package com.gotv.crackle:
//            VideoPlayerActivityFlash

class this._cls0
    implements android.widget.ener
{

    final VideoPlayerActivityFlash this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        removeDialog(6);
        if (getString(0x7f0b00d5).compareTo((String)view.getTag()) == 0)
        {
            VideoPlayerActivityFlash.access$402(VideoPlayerActivityFlash.this, null);
            VideoPlayerActivityFlash.access$302(VideoPlayerActivityFlash.this, null);
            VideoPlayerActivityFlash.access$100(VideoPlayerActivityFlash.this).loadUrl("javascript:hideSubtitles()");
            return;
        } else
        {
            VideoPlayerActivityFlash.access$402(VideoPlayerActivityFlash.this, (String)VideoPlayerActivityFlash.access$200(VideoPlayerActivityFlash.this).getItem().getClosedCaptionFileUrls().get(view.getTag()));
            VideoPlayerActivityFlash.access$302(VideoPlayerActivityFlash.this, (String)view.getTag());
            VideoPlayerActivityFlash.access$100(VideoPlayerActivityFlash.this).loadUrl((new StringBuilder()).append("javascript:loadSubtitles('").append(VideoPlayerActivityFlash.access$400(VideoPlayerActivityFlash.this)).append("')").toString());
            return;
        }
    }

    er()
    {
        this$0 = VideoPlayerActivityFlash.this;
        super();
    }
}
