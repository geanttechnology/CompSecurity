// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.tooltip;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.View;
import java.lang.ref.WeakReference;

// Referenced classes of package it.sephiroth.android.library.tooltip:
//            TooltipManager

public static final class id
{

    int actionbarSize;
    long activateDelay;
    pClosingCallback closeCallback;
    icy closePolicy;
    int defStyleAttr;
    int defStyleRes;
    long fadeDuration;
    icy gravity;
    boolean hideArrow;
    int id;
    boolean isCustomView;
    WeakReference manager;
    int maxWidth;
    Point point;
    boolean restrictToScreenEdges;
    long showDelay;
    long showDuration;
    CharSequence text;
    int textResId;
    View view;

    public id actionBarSize(int i)
    {
        actionbarSize = i;
        return this;
    }

    public actionbarSize actionBarSize(Resources resources, int i)
    {
        return actionBarSize(resources.getDimensionPixelSize(i));
    }

    public actionBarSize activateDelay(long l)
    {
        activateDelay = l;
        return this;
    }

    public activateDelay anchor(Point point1, activateDelay activatedelay)
    {
        view = null;
        point = new Point(point1);
        gravity = activatedelay;
        return this;
    }

    public gravity anchor(View view1, gravity gravity1)
    {
        point = null;
        view = view1;
        gravity = gravity1;
        return this;
    }

    public boolean build()
    {
        boolean flag = false;
        if (closePolicy == null)
        {
            throw new IllegalStateException("ClosePolicy cannot be null");
        }
        if (point == null && view == null)
        {
            throw new IllegalStateException("Target point or target view must be specified");
        }
        if (gravity == CENTER)
        {
            hideArrow = true;
        }
        TooltipManager tooltipmanager = (TooltipManager)manager.get();
        if (tooltipmanager != null)
        {
            flag = TooltipManager.access$200(tooltipmanager, this, false);
        }
        return flag;
    }

    public icy closePolicy(icy icy, long l)
    {
        closePolicy = icy;
        showDuration = l;
        return this;
    }

    public showDuration fadeDuration(long l)
    {
        fadeDuration = l;
        return this;
    }

    public fadeDuration fitToScreen(boolean flag)
    {
        restrictToScreenEdges = flag;
        return this;
    }

    public restrictToScreenEdges maxWidth(int i)
    {
        maxWidth = i;
        return this;
    }

    public boolean show()
    {
        if (closePolicy == null)
        {
            throw new IllegalStateException("ClosePolicy cannot be null");
        }
        if (point == null && view == null)
        {
            throw new IllegalStateException("Target point or target view must be specified");
        }
        if (gravity == CENTER)
        {
            hideArrow = true;
        }
        TooltipManager tooltipmanager = (TooltipManager)manager.get();
        if (tooltipmanager != null)
        {
            return TooltipManager.access$200(tooltipmanager, this, true);
        } else
        {
            return false;
        }
    }

    public _cls00 showDelay(long l)
    {
        showDelay = l;
        return this;
    }

    public showDelay text(int i)
    {
        TooltipManager tooltipmanager = (TooltipManager)manager.get();
        showDelay showdelay = this;
        if (tooltipmanager != null)
        {
            showdelay = this;
            if (tooltipmanager.mActivity != null)
            {
                showdelay = text(((CharSequence) (tooltipmanager.mActivity.getResources().getString(i))));
            }
        }
        return showdelay;
    }

    public y text(Resources resources, int i)
    {
        return text(((CharSequence) (resources.getString(i))));
    }

    public text text(CharSequence charsequence)
    {
        text = charsequence;
        return this;
    }

    public text toggleArrow(boolean flag)
    {
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        hideArrow = flag;
        return this;
    }

    public pClosingCallback withCallback(pClosingCallback pclosingcallback)
    {
        closeCallback = pclosingcallback;
        return this;
    }

    public closeCallback withCustomView(int i)
    {
        return withCustomView(i, true);
    }

    public withCustomView withCustomView(int i, boolean flag)
    {
        textResId = i;
        isCustomView = flag;
        return this;
    }

    public isCustomView withStyleId(int i)
    {
        defStyleAttr = 0;
        defStyleRes = i;
        return this;
    }

    pClosingCallback(TooltipManager tooltipmanager, int i)
    {
        actionbarSize = 0;
        textResId = ew;
        showDelay = 0L;
        maxWidth = -1;
        defStyleRes = faultStyle;
        defStyleAttr = e;
        activateDelay = 0L;
        restrictToScreenEdges = true;
        fadeDuration = 200L;
        manager = new WeakReference(tooltipmanager);
        id = i;
    }
}
