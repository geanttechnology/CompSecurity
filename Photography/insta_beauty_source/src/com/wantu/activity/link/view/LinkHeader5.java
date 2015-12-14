// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.activity.link.view;

import android.content.Context;
import android.view.View;
import bis;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;

// Referenced classes of package com.wantu.activity.link.view:
//            LinkBaseView, CaptionLabel, UILabel

public class LinkHeader5 extends LinkBaseView
{

    private String TAG;
    private CaptionLabel captionLabel;
    private UILabel dateLabel;

    public LinkHeader5(Context context)
    {
        super(context);
        TAG = "LinkHeader4";
        View.inflate(getContext(), 0x7f030097, this);
        captionLabel = (CaptionLabel)findViewById(0x7f0d0034);
        dateLabel = (UILabel)findViewById(0x7f0d028e);
        captionLabel.setOnClickListener(new bis(this, this));
        dateLabel.setOnClickListener(new bis(this, this));
        resizeChildRecursive(this, TPhotoComposeInfo.scale, TPhotoComposeInfo.scale);
    }

    public int getOriHeight()
    {
        return 74;
    }

    public int getOriWith()
    {
        return 320;
    }

    public CaptionLabel subCaptionLabel()
    {
        return captionLabel;
    }

    public UILabel subDateLabel()
    {
        return dateLabel;
    }
}
