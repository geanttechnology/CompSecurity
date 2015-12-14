// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.activity.link.view;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.FrameLayout;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;

// Referenced classes of package com.wantu.activity.link.view:
//            LinkBaseView

public class LinkFooter3 extends LinkBaseView
{

    public LinkFooter3(Context context)
    {
        super(context);
        View.inflate(getContext(), 0x7f03008f, this);
        ((FrameLayout)findViewById(0x7f0d0288)).setBackgroundColor(Color.rgb(51, 51, 51));
        resizeChildRecursive(this, TPhotoComposeInfo.scale, TPhotoComposeInfo.scale);
    }

    public int getOriHeight()
    {
        return 69;
    }

    public int getOriWith()
    {
        return 320;
    }
}
