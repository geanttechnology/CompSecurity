// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.actionbarpulltorefresh.library.b;

import android.view.View;
import android.widget.AbsListView;

// Referenced classes of package uk.co.senab.actionbarpulltorefresh.library.b:
//            c

public class a
    implements c
{

    public static final Class a[] = {
        android/widget/AbsListView
    };

    public a()
    {
    }

    public final boolean a(View view, float f)
    {
        boolean flag2 = true;
        view = (AbsListView)view;
        int i;
        boolean flag;
        boolean flag1;
        if (view.getCount() == 0)
        {
            flag = true;
        } else
        if (view.getFirstVisiblePosition() == 0)
        {
            View view1 = view.getChildAt(0);
            if (view1 != null && view1.getTop() >= 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        } else
        {
            flag = false;
        }
        if (!flag || !view.isFastScrollEnabled()) goto _L2; else goto _L1
_L1:
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            flag1 = view.isFastScrollAlwaysVisible();
        } else
        {
            flag1 = false;
        }
        if (!flag1) goto _L2; else goto _L3
_L3:
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            i = view.getVerticalScrollbarPosition();
        } else
        {
            i = 2;
        }
        i;
        JVM INSTR tableswitch 1 2: default 88
    //                   1 160
    //                   2 139;
           goto _L2 _L4 _L5
_L2:
        return flag;
_L5:
        flag = flag2;
        if (f >= (float)(view.getRight() - view.getVerticalScrollbarWidth()))
        {
            return false;
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L4:
        flag = flag2;
        if (f <= (float)view.getVerticalScrollbarWidth())
        {
            return false;
        }
        if (true) goto _L2; else goto _L6
_L6:
    }

}
