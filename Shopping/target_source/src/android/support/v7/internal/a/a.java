// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.internal.view.b;
import android.support.v7.widget.c;
import android.support.v7.widget.d;
import android.support.v7.widget.e;
import android.support.v7.widget.f;
import android.support.v7.widget.g;
import android.support.v7.widget.h;
import android.support.v7.widget.i;
import android.support.v7.widget.j;
import android.support.v7.widget.k;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.View;
import java.lang.reflect.Constructor;
import java.util.Map;

public class a
{

    static final Class a[] = {
        android/content/Context, android/util/AttributeSet
    };
    private static final Map b = new android.support.v4.f.a();
    private final Object c[] = new Object[2];

    public a()
    {
    }

    private static Context a(Context context, AttributeSet attributeset, boolean flag, boolean flag1)
    {
label0:
        {
            attributeset = context.obtainStyledAttributes(attributeset, android.support.v7.a.k.View, 0, 0);
            int l;
            int i1;
            if (flag)
            {
                l = attributeset.getResourceId(android.support.v7.a.k.View_android_theme, 0);
            } else
            {
                l = 0;
            }
            i1 = l;
            if (flag1)
            {
                i1 = l;
                if (l == 0)
                {
                    l = attributeset.getResourceId(android.support.v7.a.k.View_theme, 0);
                    i1 = l;
                    if (l != 0)
                    {
                        Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
                        i1 = l;
                    }
                }
            }
            attributeset.recycle();
            attributeset = context;
            if (i1 == 0)
            {
                break label0;
            }
            if (context instanceof b)
            {
                attributeset = context;
                if (((b)context).a() == i1)
                {
                    break label0;
                }
            }
            attributeset = new b(context, i1);
        }
        return attributeset;
    }

    private View a(Context context, String s, AttributeSet attributeset)
    {
        String s1;
        s1 = s;
        if (s.equals("view"))
        {
            s1 = attributeset.getAttributeValue(null, "class");
        }
        c[0] = context;
        c[1] = attributeset;
        if (-1 != s1.indexOf('.'))
        {
            break MISSING_BLOCK_LABEL_74;
        }
        context = a(context, s1, "android.widget.");
        c[0] = null;
        c[1] = null;
        return context;
        try
        {
            context = a(context, s1, ((String) (null)));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            c[0] = null;
            c[1] = null;
            return null;
        }
        finally
        {
            c[0] = null;
        }
        c[0] = null;
        c[1] = null;
        return context;
        c[1] = null;
        throw context;
    }

    private View a(Context context, String s, String s1)
        throws ClassNotFoundException, InflateException
    {
        Object obj;
        Constructor constructor;
        constructor = (Constructor)b.get(s);
        obj = constructor;
        if (constructor != null) goto _L2; else goto _L1
_L1:
        try
        {
            obj = context.getClassLoader();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return null;
        }
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_104;
        }
        context = (new StringBuilder()).append(s1).append(s).toString();
_L3:
        obj = ((ClassLoader) (obj)).loadClass(context).asSubclass(android/view/View).getConstructor(a);
        b.put(s, obj);
_L2:
        ((Constructor) (obj)).setAccessible(true);
        context = (View)((Constructor) (obj)).newInstance(c);
        return context;
        context = s;
          goto _L3
    }

    public final View a(View view, String s, Context context, AttributeSet attributeset, boolean flag, boolean flag1, boolean flag2)
    {
label0:
        {
            Object obj;
            byte byte0;
            if (flag && view != null)
            {
                view = view.getContext();
            } else
            {
                view = context;
            }
            if (!flag1)
            {
                obj = view;
                if (!flag2)
                {
                    break label0;
                }
            }
            obj = a(((Context) (view)), attributeset, flag1, flag2);
        }
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 10: default 136
    //                   -1946472170: 314
    //                   -1455429095: 268
    //                   -1346021293: 298
    //                   -938935918: 346
    //                   -339785223: 223
    //                   776382189: 253
    //                   1413872058: 283
    //                   1601505219: 238
    //                   1666676343: 208
    //                   2001146706: 330;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L1:
        break; /* Loop/switch isn't completed */
_L5:
        break MISSING_BLOCK_LABEL_346;
_L12:
        switch (byte0)
        {
        default:
            if (context != obj)
            {
                return a(((Context) (obj)), s, attributeset);
            } else
            {
                return null;
            }

        case 0: // '\0'
            return new f(((Context) (obj)), attributeset);

        case 1: // '\001'
            return new j(((Context) (obj)), attributeset);

        case 2: // '\002'
            return new d(((Context) (obj)), attributeset);

        case 3: // '\003'
            return new h(((Context) (obj)), attributeset);

        case 4: // '\004'
            return new e(((Context) (obj)), attributeset);

        case 5: // '\005'
            return new android.support.v7.widget.b(((Context) (obj)), attributeset);

        case 6: // '\006'
            return new g(((Context) (obj)), attributeset);

        case 7: // '\007'
            return new i(((Context) (obj)), attributeset);

        case 8: // '\b'
            return new c(((Context) (obj)), attributeset);

        case 9: // '\t'
            return new k(((Context) (obj)), attributeset);
        }
_L10:
        if (s.equals("EditText"))
        {
            byte0 = 0;
        }
          goto _L12
_L6:
        if (s.equals("Spinner"))
        {
            byte0 = 1;
        }
          goto _L12
_L9:
        if (s.equals("CheckBox"))
        {
            byte0 = 2;
        }
          goto _L12
_L7:
        if (s.equals("RadioButton"))
        {
            byte0 = 3;
        }
          goto _L12
_L3:
        if (s.equals("CheckedTextView"))
        {
            byte0 = 4;
        }
          goto _L12
_L8:
        if (s.equals("AutoCompleteTextView"))
        {
            byte0 = 5;
        }
          goto _L12
_L4:
        if (s.equals("MultiAutoCompleteTextView"))
        {
            byte0 = 6;
        }
          goto _L12
_L2:
        if (s.equals("RatingBar"))
        {
            byte0 = 7;
        }
          goto _L12
_L11:
        if (s.equals("Button"))
        {
            byte0 = 8;
        }
          goto _L12
        if (s.equals("TextView"))
        {
            byte0 = 9;
        }
          goto _L12
    }

}
