// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

// Referenced classes of package android.support.v4.widget:
//            j, bn

class h
{

    private static Method a;
    private static boolean b;

    h()
    {
    }

    static void a(PopupWindow popupwindow, int i)
    {
        if (!b)
        {
            try
            {
                Method method = android/widget/PopupWindow.getDeclaredMethod("setWindowLayoutType", new Class[] {
                    Integer.TYPE
                });
                a = method;
                method.setAccessible(true);
            }
            catch (Exception exception) { }
            b = true;
        }
        if (a == null)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        a.invoke(popupwindow, new Object[] {
            Integer.valueOf(i)
        });
        return;
        popupwindow;
    }

    public Drawable a(CompoundButton compoundbutton)
    {
        return j.a(compoundbutton);
    }

    public void a(CompoundButton compoundbutton, ColorStateList colorstatelist)
    {
        if (compoundbutton instanceof bn)
        {
            ((bn)compoundbutton).setSupportButtonTintList(colorstatelist);
        }
    }

    public void a(CompoundButton compoundbutton, android.graphics.PorterDuff.Mode mode)
    {
        if (compoundbutton instanceof bn)
        {
            ((bn)compoundbutton).setSupportButtonTintMode(mode);
        }
    }
}
