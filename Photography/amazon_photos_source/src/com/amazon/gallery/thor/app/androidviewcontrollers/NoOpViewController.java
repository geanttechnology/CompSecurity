// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.androidviewcontrollers;

import android.view.View;
import com.amazon.gallery.foundation.ui.controller.androidviewcontroller.AndroidViewController;

public class NoOpViewController
    implements AndroidViewController
{

    public NoOpViewController()
    {
    }

    public boolean onClick(View view, int i)
    {
        return false;
    }

    public boolean onLongClick(View view, int i)
    {
        return false;
    }
}
