// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

public abstract class cvb extends ViewGroup
    implements cuz
{

    private boolean a;
    private int b;

    public cvb(Context context)
    {
        super(context);
        a = true;
        b = 0;
    }

    public View getView()
    {
        return this;
    }

    public void setOverlayVisibility(boolean flag)
    {
        a = flag;
        int i;
        if (flag)
        {
            i = b;
        } else
        {
            i = 8;
        }
        super.setVisibility(i);
    }

    public void setVisibility(int i)
    {
        b = i;
        if (a)
        {
            i = b;
        } else
        {
            i = 8;
        }
        super.setVisibility(i);
    }
}
