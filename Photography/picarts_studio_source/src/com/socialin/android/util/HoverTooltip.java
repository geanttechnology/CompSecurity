// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.util;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
import java.util.HashMap;
import java.util.Map;

public abstract class HoverTooltip
{

    Map a;
    PopupWindow b;
    View c;
    Location d;
    private android.view.View.OnHoverListener e;

    public HoverTooltip(Context context)
    {
        d = Location.BOTTOM;
        e = new android.view.View.OnHoverListener() {

            private HoverTooltip a;

            public final boolean onHover(View view, MotionEvent motionevent)
            {
                int i = 0;
                motionevent.getAction();
                JVM INSTR tableswitch 7 10: default 36
            //                           7 38
            //                           8 36
            //                           9 53
            //                           10 345;
                   goto _L1 _L2 _L1 _L3 _L4
_L1:
                return false;
_L2:
                if (a.b.isShowing())
                {
                    return true;
                }
_L3:
                if (a.b.isShowing())
                {
                    a.b.dismiss();
                }
                a.b(a.c, a.a.get(view));
                a.c.measure(0, 0);
                a.b.setWidth(a.c.getMeasuredWidth());
                a.b.setHeight(a.c.getMeasuredHeight());
                final class _cls2
                {

                    static final int a[];

                    static 
                    {
                        a = new int[Location.values().length];
                        try
                        {
                            a[Location.TOP.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror2) { }
                        try
                        {
                            a[Location.LEFT.ordinal()] = 2;
                        }
                        catch (NoSuchFieldError nosuchfielderror1) { }
                        try
                        {
                            a[Location.RIGHT.ordinal()] = 3;
                        }
                        catch (NoSuchFieldError nosuchfielderror)
                        {
                            return;
                        }
                    }
                }

                _cls2.a[a.d.ordinal()];
                JVM INSTR tableswitch 1 3: default 196
            //                           1 234
            //                           2 277
            //                           3 315;
                   goto _L5 _L6 _L7 _L8
_L5:
                int j = Math.abs(a.b.getWidth() - view.getWidth()) / 2;
_L9:
                a.b.showAsDropDown(view, j, i);
                return true;
_L6:
                i = (a.b.getHeight() + view.getHeight()) * -1;
                j = Math.abs(a.b.getWidth() - view.getWidth()) / 2;
                  goto _L9
_L7:
                i = Math.abs(a.b.getHeight() - view.getHeight()) / 2;
                j = a.b.getWidth() * -1;
                  goto _L9
_L8:
                i = Math.abs(a.b.getHeight() - view.getHeight()) / 2;
                j = view.getWidth();
                  goto _L9
_L4:
                a.b.dismiss();
                return true;
            }

            
            {
                a = HoverTooltip.this;
                super();
            }
        };
        a = new HashMap();
        c = a(context);
        c.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-2, -2));
        b = new PopupWindow(c);
        b.setClippingEnabled(false);
    }

    protected abstract View a(Context context);

    public final void a(View view, Object obj)
    {
        a.put(view, obj);
        view.setOnHoverListener(e);
    }

    protected abstract void b(View view, Object obj);

    private class Location extends Enum
    {

        private static final Location $VALUES[];
        public static final Location BOTTOM;
        public static final Location LEFT;
        public static final Location RIGHT;
        public static final Location TOP;

        public static Location valueOf(String s)
        {
            return (Location)Enum.valueOf(com/socialin/android/util/HoverTooltip$Location, s);
        }

        public static Location[] values()
        {
            return (Location[])$VALUES.clone();
        }

        static 
        {
            LEFT = new Location("LEFT", 0);
            TOP = new Location("TOP", 1);
            RIGHT = new Location("RIGHT", 2);
            BOTTOM = new Location("BOTTOM", 3);
            $VALUES = (new Location[] {
                LEFT, TOP, RIGHT, BOTTOM
            });
        }

        private Location(String s, int i)
        {
            super(s, i);
        }
    }

}
