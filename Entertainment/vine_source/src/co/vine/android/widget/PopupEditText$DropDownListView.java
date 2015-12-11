// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.content.Context;
import android.util.AttributeSet;
import co.vine.android.views.SdkListView;

// Referenced classes of package co.vine.android.widget:
//            PopupEditText

private static class  extends SdkListView
{

    public boolean hasFocus()
    {
        return true;
    }

    public boolean hasWindowFocus()
    {
        return true;
    }

    public boolean isFocused()
    {
        return true;
    }

    public (Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }
}
