// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import android.view.ViewTreeObserver;
import com.pointinside.internal.utils.AndroidUtils;

// Referenced classes of package com.pointinside.maps:
//            MapView

class this._cls0
    implements android.view.server.OnGlobalLayoutListener
{

    final MapView this$0;

    public void onGlobalLayout()
    {
        if (AndroidUtils.isJellyBean())
        {
            getViewTreeObserver().removeOnGlobalLayoutListener(this);
        } else
        {
            getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
        MapView.access$000(MapView.this, getWidth(), getHeight());
    }

    AndroidUtils()
    {
        this$0 = MapView.this;
        super();
    }
}
