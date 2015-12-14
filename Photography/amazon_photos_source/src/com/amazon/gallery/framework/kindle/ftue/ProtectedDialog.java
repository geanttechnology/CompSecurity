// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.ftue;

import android.app.Dialog;
import android.content.Context;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ProgressBar;

public class ProtectedDialog extends Dialog
{

    private final String contentDescription;

    public ProtectedDialog(Context context)
    {
        super(context, 0x7f0f0131);
        setContentView(new ProgressBar(context));
        contentDescription = context.getString(0x7f0e0055);
    }

    public void dismiss()
    {
        try
        {
            super.dismiss();
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityevent)
    {
        boolean flag = super.dispatchPopulateAccessibilityEvent(accessibilityevent);
        accessibilityevent.setContentDescription(contentDescription);
        return flag;
    }

    public void hide()
    {
        try
        {
            super.hide();
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void show()
    {
        try
        {
            super.show();
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }
}
