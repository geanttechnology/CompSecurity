// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.android.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ButtonBar extends LinearLayout
{
    private static final class OnClickHandler
        implements android.view.View.OnClickListener
    {

        private Method handler;
        private final String handlerName;

        public void onClick(View view)
        {
            if (handler == null)
            {
                try
                {
                    handler = view.getContext().getClass().getMethod(handlerName, new Class[] {
                        android/view/View
                    });
                }
                catch (NoSuchMethodException nosuchmethodexception)
                {
                    String s;
                    if (view.getId() == -1)
                    {
                        s = "";
                    } else
                    {
                        s = (new StringBuilder()).append(" with id '").append(view.getContext().getResources().getResourceEntryName(view.getId())).append("'").toString();
                    }
                    throw new IllegalStateException((new StringBuilder()).append("Could not find a method ").append(handlerName).append("(View) in the activity ").append(view.getContext().getClass()).append(" for onClick handler on view ").append(view.getClass()).append(s).toString(), nosuchmethodexception);
                }
            }
            try
            {
                handler.invoke(view.getContext(), new Object[] {
                    view
                });
                return;
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                throw new IllegalStateException("Could not execute non public method of the activity", view);
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                throw new IllegalStateException("Could not execute method of the activity", view);
            }
        }

        public OnClickHandler(String s)
        {
            handler = null;
            handlerName = s;
        }
    }


    private static final int POSITIVE_SIDE_LEFT = 0;
    private static final int POSITIVE_SIDE_RIGHT = 1;
    private Drawable dividerDrawable;
    private int dividerHeight;
    private Button negativeButton;
    private Button neutralButton;
    private Button positiveButton;
    private boolean showTopDivider;

    public ButtonBar(Context context)
    {
        super(context);
    }

    public ButtonBar(Context context, AttributeSet attributeset)
    {
        OnClickHandler onclickhandler;
        Object obj;
        OnClickHandler onclickhandler1;
        Object obj3;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        int k3;
        super(context, attributeset, 0x101032e);
        setMotionEventSplittingEnabled(false);
        i2 = -1;
        k2 = -1;
        j3 = -1;
        k1 = 0;
        j2 = 0;
        i3 = 0;
        Object obj1 = null;
        obj = null;
        onclickhandler = null;
        onclickhandler1 = null;
        k = 0;
        l = 0;
        i1 = 0;
        j1 = 0;
        l1 = 1;
        obj3 = context.obtainStyledAttributes(attributeset, com.ebay.mobile.R.styleable.ButtonBar, 0x101032e, 0);
        k3 = ((TypedArray) (obj3)).getIndexCount();
        l2 = 0;
        attributeset = obj1;
_L19:
        int i;
        if (l2 >= k3)
        {
            break MISSING_BLOCK_LABEL_500;
        }
        i = ((TypedArray) (obj3)).getIndex(l2);
        i;
        JVM INSTR tableswitch 0 15: default 180
    //                   0 197
    //                   1 221
    //                   2 238
    //                   3 255
    //                   4 272
    //                   5 289
    //                   6 306
    //                   7 323
    //                   8 345
    //                   9 368
    //                   10 390
    //                   11 413
    //                   12 430
    //                   13 447
    //                   14 464
    //                   15 481;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17
_L17:
        break MISSING_BLOCK_LABEL_481;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        i = l1;
_L20:
        l2++;
        l1 = i;
        if (true) goto _L19; else goto _L18
_L18:
        if (((TypedArray) (obj3)).getInt(i, 0) == 1)
        {
            i = 1;
        } else
        {
            i = 0;
        }
          goto _L20
_L3:
        k1 = ((TypedArray) (obj3)).getResourceId(i, 0);
        i = l1;
          goto _L20
_L4:
        j2 = ((TypedArray) (obj3)).getResourceId(i, 0);
        i = l1;
          goto _L20
_L5:
        i3 = ((TypedArray) (obj3)).getResourceId(i, 0);
        i = l1;
          goto _L20
_L6:
        i2 = ((TypedArray) (obj3)).getResourceId(i, -1);
        i = l1;
          goto _L20
_L7:
        k2 = ((TypedArray) (obj3)).getResourceId(i, -1);
        i = l1;
          goto _L20
_L8:
        j3 = ((TypedArray) (obj3)).getResourceId(i, -1);
        i = l1;
          goto _L20
_L9:
        attributeset = new OnClickHandler(((TypedArray) (obj3)).getString(i));
        i = l1;
          goto _L20
_L10:
        obj = new OnClickHandler(((TypedArray) (obj3)).getString(i));
        i = l1;
          goto _L20
_L11:
        onclickhandler = new OnClickHandler(((TypedArray) (obj3)).getString(i));
        i = l1;
          goto _L20
_L12:
        onclickhandler1 = new OnClickHandler(((TypedArray) (obj3)).getString(i));
        i = l1;
          goto _L20
_L13:
        k = ((TypedArray) (obj3)).getResourceId(i, 0);
        i = l1;
          goto _L20
_L14:
        l = ((TypedArray) (obj3)).getResourceId(i, 0);
        i = l1;
          goto _L20
_L15:
        i1 = ((TypedArray) (obj3)).getResourceId(i, 0);
        i = l1;
          goto _L20
_L16:
        j1 = ((TypedArray) (obj3)).getResourceId(i, 0);
        i = l1;
          goto _L20
        showTopDivider = ((TypedArray) (obj3)).getBoolean(i, false);
        i = l1;
          goto _L20
        ((TypedArray) (obj3)).recycle();
        setGravity(16);
        Object obj5 = onclickhandler1;
        obj3 = onclickhandler;
        Object obj4 = obj;
        if (attributeset != null)
        {
            Object obj2 = obj;
            if (obj == null)
            {
                obj2 = attributeset;
            }
            obj = onclickhandler;
            if (onclickhandler == null)
            {
                obj = attributeset;
            }
            obj5 = onclickhandler1;
            obj3 = obj;
            obj4 = obj2;
            if (onclickhandler1 == null)
            {
                obj4 = obj2;
                obj3 = obj;
                obj5 = attributeset;
            }
        }
        int j = k;
        if (k <= 0)
        {
            j = 0x7f030039;
        }
        k = l;
        if (l <= 0)
        {
            k = j;
        }
        l = i1;
        if (i1 <= 0)
        {
            l = j;
        }
        i1 = j1;
        if (j1 <= 0)
        {
            i1 = j;
        }
        context = LayoutInflater.from(context);
        if (l1 != 0)
        {
            negativeButton = createButton(context, i1, j3, i3, ((android.view.View.OnClickListener) (obj5)));
            neutralButton = createButton(context, l, k2, j2, ((android.view.View.OnClickListener) (obj3)));
            positiveButton = createButton(context, k, i2, k1, ((android.view.View.OnClickListener) (obj4)));
            return;
        } else
        {
            positiveButton = createButton(context, k, i2, k1, ((android.view.View.OnClickListener) (obj4)));
            neutralButton = createButton(context, l, k2, j2, ((android.view.View.OnClickListener) (obj3)));
            negativeButton = createButton(context, i1, j3, i3, ((android.view.View.OnClickListener) (obj5)));
            return;
        }
    }

    private Button createButton(LayoutInflater layoutinflater, int i, int j, int k, android.view.View.OnClickListener onclicklistener)
    {
        if (k <= 0)
        {
            return null;
        }
        if (isInEditMode())
        {
            layoutinflater = new Button(getContext());
            layoutinflater.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -2, 1.0F));
        } else
        {
            layoutinflater = (Button)layoutinflater.inflate(i, this, false);
        }
        if (j != -1)
        {
            layoutinflater.setId(j);
        }
        if (onclicklistener != null)
        {
            if (getContext().isRestricted())
            {
                throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
            }
            layoutinflater.setOnClickListener(onclicklistener);
        }
        layoutinflater.setText(k);
        addView(layoutinflater);
        return layoutinflater;
    }

    public Button getNegativeButton()
    {
        return negativeButton;
    }

    public Button getNeutralButton()
    {
        return neutralButton;
    }

    public Button getPositiveButton()
    {
        return positiveButton;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (showTopDivider && dividerDrawable != null && dividerHeight > 0)
        {
            dividerDrawable.setBounds(0, 0, getRight(), dividerHeight);
            dividerDrawable.draw(canvas);
        }
    }

    public void setDividerDrawable(Drawable drawable)
    {
        dividerDrawable = drawable;
        if (drawable != null)
        {
            dividerHeight = drawable.getIntrinsicHeight();
        }
        super.setDividerDrawable(drawable);
    }
}
