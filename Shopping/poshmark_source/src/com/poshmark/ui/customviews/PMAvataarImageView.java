// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.fragments.ClosetFragment;

// Referenced classes of package com.poshmark.ui.customviews:
//            PMImageView, PMImageViewOnClickListener

public class PMAvataarImageView extends PMImageView
{

    boolean isImageSet;
    String userId;

    public PMAvataarImageView(Context context)
    {
        super(context);
        userId = null;
        isImageSet = false;
    }

    public PMAvataarImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        userId = null;
        isImageSet = false;
    }

    public void launchFragmentOnClick()
    {
        if (userId != null)
        {
            Bundle bundle = new Bundle();
            bundle.putString("NAME", userId);
            PMActivity pmactivity = (PMActivity)getContext();
            if (pmactivity != null && pmactivity.isActivityInForeground())
            {
                pmactivity.launchFragment(bundle, com/poshmark/ui/fragments/ClosetFragment, null);
            }
        }
    }

    public void loadImage(String s)
    {
        isImageSet = true;
        super.loadImage(s);
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
    }

    public void requestLayout()
    {
        if (!isImageSet)
        {
            super.requestLayout();
        }
    }

    public void setCustomOnClickListener(PMImageViewOnClickListener pmimageviewonclicklistener)
    {
    }

    public void setUser(String s)
    {
        userId = s;
    }
}
