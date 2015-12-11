// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

// Referenced classes of package android.support.v7.internal.widget:
//            s

public class f extends PopupWindow
{

    private final boolean a;

    public f(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        context = s.a(context, attributeset, android.support.v7.a.a.k.PopupWindow, i, 0);
        a = context.a(android.support.v7.a.a.k.PopupWindow_overlapAnchor, false);
        setBackgroundDrawable(context.a(android.support.v7.a.a.k.PopupWindow_android_popupBackground));
        context.b();
        if (android.os.Build.VERSION.SDK_INT < 14)
        {
            a(this);
        }
    }

    private static void a(PopupWindow popupwindow)
    {
        try
        {
            Field field = android/widget/PopupWindow.getDeclaredField("mAnchor");
            field.setAccessible(true);
            Field field1 = android/widget/PopupWindow.getDeclaredField("mOnScrollChangedListener");
            field1.setAccessible(true);
            field1.set(popupwindow, new android.view.ViewTreeObserver.OnScrollChangedListener(field, popupwindow, (android.view.ViewTreeObserver.OnScrollChangedListener)field1.get(popupwindow)) {

                final Field a;
                final PopupWindow b;
                final android.view.ViewTreeObserver.OnScrollChangedListener c;

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

            
            {
                a = field;
                b = popupwindow;
                c = onscrollchangedlistener;
                super();
            }
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (PopupWindow popupwindow)
        {
            Log.d("AppCompatPopupWindow", "Exception while installing workaround OnScrollChangedListener", popupwindow);
        }
    }

    public void showAsDropDown(View view, int i, int j)
    {
        int k = j;
        if (android.os.Build.VERSION.SDK_INT < 21)
        {
            k = j;
            if (a)
            {
                k = j - view.getHeight();
            }
        }
        super.showAsDropDown(view, i, k);
    }

    public void showAsDropDown(View view, int i, int j, int k)
    {
        int l = j;
        if (android.os.Build.VERSION.SDK_INT < 21)
        {
            l = j;
            if (a)
            {
                l = j - view.getHeight();
            }
        }
        super.showAsDropDown(view, i, l, k);
    }

    public void update(View view, int i, int j, int k, int l)
    {
        if (android.os.Build.VERSION.SDK_INT < 21 && a)
        {
            j -= view.getHeight();
        }
        super.update(view, i, j, k, l);
    }
}
