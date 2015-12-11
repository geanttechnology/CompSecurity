// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.util;

import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.Window;

// Referenced classes of package com.google.util:
//            SystemUiHider

public class SystemUiHiderBase extends SystemUiHider
{

    private boolean mVisible;

    protected SystemUiHiderBase(ActionBarActivity actionbaractivity, View view, int i)
    {
        super(actionbaractivity, view, i);
        mVisible = true;
    }

    public void hide()
    {
        mOnVisibilityChangeListener.onVisibilityChange(false);
        mVisible = false;
    }

    public boolean isVisible()
    {
        return mVisible;
    }

    public void setup()
    {
        if ((mFlags & 1) == 0)
        {
            mActivity.getWindow().setFlags(768, 768);
        }
    }

    public void show()
    {
        mOnVisibilityChangeListener.onVisibilityChange(true);
        mVisible = true;
    }
}
