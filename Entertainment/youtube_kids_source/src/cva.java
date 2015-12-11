// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

public abstract class cva extends FrameLayout
    implements cuz
{

    private int localVisibility;
    private boolean showOverlay;

    public cva(Context context)
    {
        super(context);
        showOverlay = true;
        localVisibility = 0;
    }

    public View getView()
    {
        return this;
    }

    public void setOverlayVisibility(boolean flag)
    {
        showOverlay = flag;
        int i;
        if (flag)
        {
            i = localVisibility;
        } else
        {
            i = 8;
        }
        super.setVisibility(i);
    }

    public void setVisibility(int i)
    {
        localVisibility = i;
        if (showOverlay)
        {
            i = localVisibility;
        } else
        {
            i = 8;
        }
        super.setVisibility(i);
    }
}
