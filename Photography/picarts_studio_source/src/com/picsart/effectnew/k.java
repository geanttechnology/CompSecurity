// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effectnew;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;

// Referenced classes of package com.picsart.effectnew:
//            l

public final class k
{

    public l a;

    public k()
    {
    }

    static TextView a(k k1)
    {
        if (k1.a != null)
        {
            k1 = k1.a.e();
            if (k1 != null)
            {
                return (TextView)k1.findViewById(0x7f100192);
            }
        }
        return null;
    }

    public final void a(View view)
    {
        if (a != null)
        {
            Object obj = view;
            if (view == null)
            {
                obj = a.e();
            }
            if (obj != null)
            {
                view = (CompoundButton)((View) (obj)).findViewById(0x7f100195);
                obj = (CompoundButton)((View) (obj)).findViewById(0x7f100196);
                if (a.c() == EffectShapeDrawerNew.ShapeType.Focal)
                {
                    view.setChecked(true);
                    ((CompoundButton) (obj)).setChecked(false);
                    return;
                } else
                {
                    view.setChecked(false);
                    ((CompoundButton) (obj)).setChecked(true);
                    return;
                }
            }
        }
    }

    public final void b(View view)
    {
        if (a != null)
        {
            View view1 = view;
            if (view == null)
            {
                view1 = a.e();
            }
            if (view1 != null)
            {
                boolean flag = a.b();
                ((CheckBox)view1.findViewById(0x7f100194)).setChecked(flag);
                return;
            }
        }
    }

    // Unreferenced inner class com/picsart/effectnew/k$1

/* anonymous class */
    public final class _cls1
        implements android.widget.SeekBar.OnSeekBarChangeListener
    {

        private k a;

        public final void onProgressChanged(SeekBar seekbar, int i, boolean flag)
        {
            Context context;
            if (a.a != null)
            {
                if ((context = a.a.d()) != null)
                {
                    TextView textview = k.a(a);
                    if (textview != null)
                    {
                        textview.setText((new StringBuilder()).append(context.getString(0x7f080068)).append("  ").append((int)(((float)seekbar.getProgress() / 30F) * 50F)).toString());
                    }
                    if (flag)
                    {
                        a.a.a(30 - seekbar.getProgress());
                        return;
                    }
                }
            }
        }

        public final void onStartTrackingTouch(SeekBar seekbar)
        {
        }

        public final void onStopTrackingTouch(SeekBar seekbar)
        {
            Context context;
            if (a.a != null)
            {
                if ((context = a.a.d()) != null)
                {
                    TextView textview = k.a(a);
                    if (textview != null)
                    {
                        textview.setText((new StringBuilder()).append(context.getString(0x7f080068)).append(" ").append((int)(((float)seekbar.getProgress() / 30F) * 50F)).toString());
                    }
                    a.a.g();
                    return;
                }
            }
        }

            public 
            {
                a = k.this;
                super();
            }
    }


    // Unreferenced inner class com/picsart/effectnew/k$2

/* anonymous class */
    public final class _cls2
        implements android.view.View.OnClickListener
    {

        private k a;

        public final void onClick(View view)
        {
            if (a.a == null)
            {
                return;
            } else
            {
                a.a.f();
                return;
            }
        }

            public 
            {
                a = k.this;
                super();
            }
    }


    // Unreferenced inner class com/picsart/effectnew/k$3

/* anonymous class */
    public final class _cls3
        implements android.view.View.OnClickListener
    {

        private k a;

        public final void onClick(View view)
        {
            if (a.a == null)
            {
                return;
            }
            EffectShapeDrawerNew.ShapeType shapetype = EffectShapeDrawerNew.ShapeType.Focal;
            if (view.getId() == 0x7f100196)
            {
                shapetype = EffectShapeDrawerNew.ShapeType.Rect;
            }
            a.a.a(shapetype);
            a.a(null);
        }

            public 
            {
                a = k.this;
                super();
            }
    }

}
