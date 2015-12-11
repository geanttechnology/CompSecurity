// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

// Referenced classes of package com.target.ui.view:
//            a

public class ConfigurableDropShadowView extends FrameLayout
{
    static class Views extends a
    {

        View dropShadowInternal;

        Views(View view)
        {
            super(view);
        }
    }


    private int mDropShadowHeight;
    private Views mViews;

    public ConfigurableDropShadowView(Context context)
    {
        super(context);
        a();
    }

    public ConfigurableDropShadowView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public ConfigurableDropShadowView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a();
    }

    private void a()
    {
        inflate(getContext(), 0x7f030148, this);
        mViews = new Views(this);
        mDropShadowHeight = getResources().getDimensionPixelSize(0x7f0a0187);
    }

    public void setStrength(float f)
    {
        mViews.dropShadowInternal.setAlpha(f);
        mViews.dropShadowInternal.setScaleY(f);
        mViews.dropShadowInternal.setTranslationY(((f - 1.0F) * (float)mDropShadowHeight) / 2.0F);
    }
}
