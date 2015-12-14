// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v4.view.ActionProvider;
import android.support.v7.internal.widget.ActivityChooserView;
import android.support.v7.widget.ListPopupWindow;

public class cp
    implements android.view.ViewTreeObserver.OnGlobalLayoutListener
{

    final ActivityChooserView a;

    public cp(ActivityChooserView activitychooserview)
    {
        a = activitychooserview;
        super();
    }

    public void onGlobalLayout()
    {
        if (a.isShowingPopup())
        {
            if (!a.isShown())
            {
                ActivityChooserView.access$100(a).a();
            } else
            {
                ActivityChooserView.access$100(a).c();
                if (a.mProvider != null)
                {
                    a.mProvider.subUiVisibilityChanged(true);
                    return;
                }
            }
        }
    }
}
