// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.support.v7.internal.widget.ActionBarContainer;

public class ba extends az
{

    public ba(ActionBarContainer actionbarcontainer)
    {
        super(actionbarcontainer);
    }

    public void getOutline(Outline outline)
    {
        if (a.mIsSplit)
        {
            if (a.mSplitBackground != null)
            {
                a.mSplitBackground.getOutline(outline);
            }
        } else
        if (a.mBackground != null)
        {
            a.mBackground.getOutline(outline);
            return;
        }
    }
}
