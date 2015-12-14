// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.util;

import android.util.Log;
import android.view.OrientationEventListener;

public class SimpleOrientationEventListener extends OrientationEventListener
{

    private static String a = com/socialin/android/photo/util/SimpleOrientationEventListener.getSimpleName();
    private static boolean c;
    private Orientation b;

    private static Orientation a(int i)
    {
        if (i != -1) goto _L2; else goto _L1
_L1:
        Orientation orientation = Orientation.FLAT;
_L6:
        return orientation;
_L2:
        Orientation aorientation[];
        int j;
        int i1;
        if (!c && (i < 0 || i >= 360))
        {
            throw new AssertionError();
        }
        aorientation = Orientation.values();
        i1 = aorientation.length;
        j = 0;
_L4:
        if (j >= i1)
        {
            break MISSING_BLOCK_LABEL_160;
        }
        orientation = aorientation[j];
        int k = orientation.angle;
        if (!c && (i < 0 || i >= 360))
        {
            try
            {
                throw new AssertionError();
            }
            catch (AssertionError assertionerror)
            {
                return Orientation.UNDEFINED;
            }
        }
        if (c || k >= 0 && k < 360)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        throw new AssertionError();
        k = Math.abs(i - k);
        int l = k;
        if (k > 180)
        {
            l = 360 - k;
        }
        if (l < 0)
        {
            break; /* Loop/switch isn't completed */
        }
        j++;
        if (true) goto _L4; else goto _L3
_L3:
        if (true) goto _L6; else goto _L5
_L5:
        return Orientation.UNDEFINED;
    }

    public final void onOrientationChanged(int i)
    {
        Orientation orientation;
        if (i != -1)
        {
            if (!c && (i < 0 || i >= 360))
            {
                throw new AssertionError();
            }
            i = (i + 0) % 360;
        }
        orientation = a(i);
        if (orientation != b)
        {
            b = orientation;
            Log.i(a, (new StringBuilder("Orientation changed to ")).append(orientation.toString()).toString());
        }
    }

    static 
    {
        boolean flag;
        if (!com/socialin/android/photo/util/SimpleOrientationEventListener.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        c = flag;
    }

    private class Orientation extends Enum
    {

        private static final Orientation $VALUES[];
        public static final Orientation BOTTOM_DOWN;
        public static final Orientation FLAT;
        public static final Orientation LEFT_DOWN;
        public static final Orientation RIGHT_DOWN;
        public static final Orientation TOP_DOWN;
        public static final Orientation UNDEFINED;
        public final int angle;

        public static Orientation valueOf(String s)
        {
            return (Orientation)Enum.valueOf(com/socialin/android/photo/util/SimpleOrientationEventListener$Orientation, s);
        }

        public static Orientation[] values()
        {
            return (Orientation[])$VALUES.clone();
        }

        static 
        {
            BOTTOM_DOWN = new Orientation("BOTTOM_DOWN", 0, 0);
            RIGHT_DOWN = new Orientation("RIGHT_DOWN", 1, 90);
            TOP_DOWN = new Orientation("TOP_DOWN", 2, 180);
            LEFT_DOWN = new Orientation("LEFT_DOWN", 3, 270);
            FLAT = new Orientation("FLAT", 4, -1);
            UNDEFINED = new Orientation("UNDEFINED", 5, -1);
            $VALUES = (new Orientation[] {
                BOTTOM_DOWN, RIGHT_DOWN, TOP_DOWN, LEFT_DOWN, FLAT, UNDEFINED
            });
        }

        private Orientation(String s, int i, int j)
        {
            super(s, i);
            angle = j;
        }
    }

}
