// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.player;

import android.content.Context;
import android.util.AttributeSet;

// Referenced classes of package co.vine.android.player:
//            SdkVideoView

public class StaticSizeVideoView extends SdkVideoView
{

    private int mHeight;
    private int mWidth;

    public StaticSizeVideoView(Context context)
    {
        super(context);
        mWidth = 0;
        mHeight = 0;
    }

    public StaticSizeVideoView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mWidth = 0;
        mHeight = 0;
    }

    public StaticSizeVideoView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mWidth = 0;
        mHeight = 0;
    }

    protected void onMeasure(int i, int j)
    {
        setMeasuredDimension(mWidth, mHeight);
    }

    public void setSize(int i, int j)
    {
        mWidth = i;
        mHeight = j;
    }
}
