// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import android.app.Activity;
import com.amazon.gallery.foundation.metrics.Profiler;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            SelectionAction

public abstract class TagAction
    implements SelectionAction
{

    protected final Activity context;
    protected final Profiler profiler;

    public TagAction(Activity activity, int i, Profiler profiler1)
    {
        context = activity;
        profiler = profiler1;
    }

    public boolean canExecute(List list)
    {
        return false;
    }

    public void execute(List list)
    {
        throw new IllegalArgumentException("Tag action does not support media item executions");
    }
}
