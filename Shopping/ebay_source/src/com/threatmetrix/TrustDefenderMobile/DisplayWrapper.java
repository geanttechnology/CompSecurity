// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.threatmetrix.TrustDefenderMobile;

import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import java.lang.reflect.Method;

// Referenced classes of package com.threatmetrix.TrustDefenderMobile:
//            WrapperHelper

class DisplayWrapper extends WrapperHelper
{

    private static final String TAG = com/threatmetrix/TrustDefenderMobile/DisplayWrapper.getName();
    private static final Method m_getHeight = getMethod(android/view/Display, "getHeight", new Class[0]);
    private static final Method m_getSize = getMethod(android/view/Display, "getSize", new Class[] {
        android/graphics/Point
    });
    private static final Method m_getWidth = getMethod(android/view/Display, "getWidth", new Class[0]);
    private final Display m_display;

    public DisplayWrapper(Display display)
    {
        m_display = display;
    }

    public int getHeight()
    {
        if (m_getSize != null)
        {
            Point point = new Point();
            invoke(m_display, m_getSize, new Object[] {
                point
            });
            return point.y;
        }
        if (m_getHeight != null)
        {
            Integer integer = (Integer)invoke(m_display, m_getHeight, new Object[0]);
            if (integer != null)
            {
                return integer.intValue();
            }
        }
        Log.w(TAG, "unable to get display height");
        return 0;
    }

    public int getWidth()
    {
        if (m_getSize != null)
        {
            Point point = new Point();
            invoke(m_display, m_getSize, new Object[] {
                point
            });
            return point.x;
        }
        if (m_getWidth != null)
        {
            Integer integer = (Integer)invoke(m_display, m_getWidth, new Object[0]);
            if (integer != null)
            {
                return integer.intValue();
            }
        }
        Log.w(TAG, "unable to get display width");
        return 0;
    }

}
