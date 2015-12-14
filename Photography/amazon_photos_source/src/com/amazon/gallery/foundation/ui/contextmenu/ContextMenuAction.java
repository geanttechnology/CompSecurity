// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.ui.contextmenu;

import android.app.Activity;

public abstract class ContextMenuAction
{

    protected final Activity context;
    protected final int resourceLabelId;

    public ContextMenuAction(Activity activity, int i)
    {
        context = activity;
        resourceLabelId = i;
    }
}
