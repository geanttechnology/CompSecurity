// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

// Referenced classes of package android.support.v4.widget:
//            r, y

class j
    implements r
{

    private static Field a;
    private static boolean b;

    j()
    {
    }

    static Drawable a(CompoundButton compoundbutton)
    {
        if (!b)
        {
            try
            {
                Field field = android/widget/CompoundButton.getDeclaredField("mButtonDrawable");
                a = field;
                field.setAccessible(true);
            }
            catch (NoSuchFieldException nosuchfieldexception)
            {
                Log.i("CompoundButtonCompatDonut", "Failed to retrieve mButtonDrawable field", nosuchfieldexception);
            }
            b = true;
        }
        if (a == null)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        compoundbutton = (Drawable)a.get(compoundbutton);
        return compoundbutton;
        compoundbutton;
        Log.i("CompoundButtonCompatDonut", "Failed to get button drawable via reflection", compoundbutton);
        a = null;
        return null;
    }

    public int a(Object obj)
    {
        return y.a(obj);
    }

    public Drawable a(Context context)
    {
        return y.a(context);
    }

    public void a(View view)
    {
        y.a(view);
    }

    public void a(View view, Object obj, int i)
    {
        y.a(view, obj, i);
    }

    public void a(android.view.ViewGroup.MarginLayoutParams marginlayoutparams, Object obj, int i)
    {
        y.a(marginlayoutparams, obj, i);
    }
}
