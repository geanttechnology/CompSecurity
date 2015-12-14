// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.app;

import android.content.Context;
import android.support.v7.internal.widget.ViewUtils;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatCheckedTextView;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatMultiAutoCompleteTextView;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.View;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class AppCompatViewInflater
{

    private static final Map sConstructorMap = new HashMap();
    static final Class sConstructorSignature[] = {
        android/content/Context, android/util/AttributeSet
    };
    private final Object mConstructorArgs[] = new Object[2];
    private final Context mContext;

    public AppCompatViewInflater(Context context)
    {
        mContext = context;
    }

    private View createView(String s, String s1)
        throws ClassNotFoundException, InflateException
    {
        Object obj;
        Constructor constructor;
        constructor = (Constructor)sConstructorMap.get(s);
        obj = constructor;
        if (constructor != null) goto _L2; else goto _L1
_L1:
        try
        {
            obj = mContext.getClassLoader();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_100;
        }
        s1 = (new StringBuilder()).append(s1).append(s).toString();
_L3:
        obj = ((ClassLoader) (obj)).loadClass(s1).asSubclass(android/view/View).getConstructor(sConstructorSignature);
        sConstructorMap.put(s, obj);
_L2:
        ((Constructor) (obj)).setAccessible(true);
        s = (View)((Constructor) (obj)).newInstance(mConstructorArgs);
        return s;
        s1 = s;
          goto _L3
    }

    private View createViewFromTag(Context context, String s, AttributeSet attributeset)
    {
        String s1;
        s1 = s;
        if (s.equals("view"))
        {
            s1 = attributeset.getAttributeValue(null, "class");
        }
        mConstructorArgs[0] = context;
        mConstructorArgs[1] = attributeset;
        if (-1 != s1.indexOf('.'))
        {
            break MISSING_BLOCK_LABEL_73;
        }
        context = createView(s1, "android.widget.");
        mConstructorArgs[0] = null;
        mConstructorArgs[1] = null;
        return context;
        try
        {
            context = createView(s1, null);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            mConstructorArgs[0] = null;
            mConstructorArgs[1] = null;
            return null;
        }
        finally
        {
            mConstructorArgs[0] = null;
        }
        mConstructorArgs[0] = null;
        mConstructorArgs[1] = null;
        return context;
        mConstructorArgs[1] = null;
        throw context;
    }

    public final View createView(View view, String s, Context context, AttributeSet attributeset, boolean flag, boolean flag1)
    {
        byte byte0;
        Context context1 = context;
        if (flag)
        {
            context1 = context;
            if (view != null)
            {
                context1 = view.getContext();
            }
        }
        view = context1;
        if (flag1)
        {
            view = ViewUtils.themifyContext(context1, attributeset, true, true);
        }
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 10: default 136
    //                   -1946472170: 312
    //                   -1455429095: 266
    //                   -1346021293: 296
    //                   -938935918: 344
    //                   -339785223: 221
    //                   776382189: 251
    //                   1413872058: 281
    //                   1601505219: 236
    //                   1666676343: 206
    //                   2001146706: 328;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L1:
        break; /* Loop/switch isn't completed */
_L5:
        break MISSING_BLOCK_LABEL_344;
_L12:
        switch (byte0)
        {
        default:
            if (context != view)
            {
                return createViewFromTag(view, s, attributeset);
            } else
            {
                return null;
            }

        case 0: // '\0'
            return new AppCompatEditText(view, attributeset);

        case 1: // '\001'
            return new AppCompatSpinner(view, attributeset);

        case 2: // '\002'
            return new AppCompatCheckBox(view, attributeset);

        case 3: // '\003'
            return new AppCompatRadioButton(view, attributeset);

        case 4: // '\004'
            return new AppCompatCheckedTextView(view, attributeset);

        case 5: // '\005'
            return new AppCompatAutoCompleteTextView(view, attributeset);

        case 6: // '\006'
            return new AppCompatMultiAutoCompleteTextView(view, attributeset);

        case 7: // '\007'
            return new AppCompatRatingBar(view, attributeset);

        case 8: // '\b'
            return new AppCompatButton(view, attributeset);

        case 9: // '\t'
            return new AppCompatTextView(view, attributeset);
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
