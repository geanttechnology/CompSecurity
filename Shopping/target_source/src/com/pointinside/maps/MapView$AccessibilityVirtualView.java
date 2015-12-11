// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import android.graphics.Rect;

// Referenced classes of package com.pointinside.maps:
//            MapView

private class mText
{

    public final Rect mBounds;
    public final int mId;
    public final String mText;
    final MapView this$0;

    public (int i, Rect rect, String s)
    {
        this$0 = MapView.this;
        super();
        mBounds = rect;
        mId = i;
        mText = s;
    }
}
