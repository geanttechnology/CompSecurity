// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.toolbar;

import android.util.SparseArray;
import android.view.View;

public class NewIconCtrl
{

    private View a;
    private SparseArray b;

    public NewIconCtrl(View view)
    {
        a = view;
        b = new SparseArray();
        view = ButtonControl.values();
        int j = view.length;
        for (int i = 0; i < j; i++)
        {
            ButtonControl buttoncontrol = view[i];
            b.put(buttoncontrol.b(), buttoncontrol);
        }

        a();
    }

    public void a()
    {
        ButtonControl abuttoncontrol[] = ButtonControl.values();
        int j = abuttoncontrol.length;
        for (int i = 0; i < j; i++)
        {
            abuttoncontrol[i].a(a);
        }

    }

    public void a(View view)
    {
        while (view == null || (ButtonControl)b.get(view.getId()) == null) 
        {
            return;
        }
        ((ButtonControl)b.get(view.getId())).b(view);
    }

    private class ButtonControl extends Enum
    {

        public static final ButtonControl a;
        private static final ButtonControl b[];

        public static ButtonControl valueOf(String s)
        {
            return (ButtonControl)Enum.valueOf(com/cyberlink/youcammakeup/widgetpool/toolbar/NewIconCtrl$ButtonControl, s);
        }

        public static ButtonControl[] values()
        {
            return (ButtonControl[])b.clone();
        }

        protected abstract String a();

        protected void a(View view)
        {
            boolean flag = z.a(a(), true, Globals.d().getApplicationContext());
            view = view.findViewById(b());
            if (view != null)
            {
                int i;
                if (flag)
                {
                    i = 0;
                } else
                {
                    i = 4;
                }
                a(view, i);
            }
        }

        protected void a(View view, int i)
        {
            view.findViewById(0x7f0c072a).findViewById(0x7f0c072a).setVisibility(i);
        }

        protected abstract int b();

        protected void b(View view)
        {
            a(view, 4);
            z.a(a(), Boolean.valueOf(false), Globals.d().getApplicationContext());
        }

        static 
        {
            a = new ButtonControl("None", 0) {

                protected String a()
                {
                    return "none";
                }

                protected int b()
                {
                    return 0;
                }

            };
            b = (new ButtonControl[] {
                a
            });
        }

        private ButtonControl(String s, int i)
        {
            super(s, i);
        }

    }

}
