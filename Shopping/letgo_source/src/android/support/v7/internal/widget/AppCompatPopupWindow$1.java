// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.widget.PopupWindow;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

// Referenced classes of package android.support.v7.internal.widget:
//            AppCompatPopupWindow

static final class c
    implements android.view.llChangedListener
{

    final Field a;
    final PopupWindow b;
    final android.view.llChangedListener c;

    public void onScrollChanged()
    {
        WeakReference weakreference = (WeakReference)a.get(b);
        if (weakreference == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        if (weakreference.get() == null)
        {
            return;
        }
        try
        {
            c.onScrollChanged();
            return;
        }
        catch (IllegalAccessException illegalaccessexception) { }
    }

    (Field field, PopupWindow popupwindow, android.view.llChangedListener llchangedlistener)
    {
        a = field;
        b = popupwindow;
        c = llchangedlistener;
        super();
    }
}
