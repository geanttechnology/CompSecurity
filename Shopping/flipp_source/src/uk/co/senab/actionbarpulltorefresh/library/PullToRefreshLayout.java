// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.actionbarpulltorefresh.library;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import java.util.WeakHashMap;
import uk.co.senab.actionbarpulltorefresh.library.a.a;
import uk.co.senab.actionbarpulltorefresh.library.b.c;

// Referenced classes of package uk.co.senab.actionbarpulltorefresh.library:
//            j, h, n, g, 
//            f

public class PullToRefreshLayout extends FrameLayout
{

    private j a;

    public PullToRefreshLayout(Context context)
    {
        this(context, null);
    }

    public PullToRefreshLayout(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public PullToRefreshLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected static j a(Activity activity, h h1)
    {
        if (h1 == null)
        {
            h1 = new h();
        }
        return new j(activity, h1);
    }

    final void a()
    {
        if (a == null)
        {
            throw new IllegalStateException("You need to setup the PullToRefreshLayout before using it");
        } else
        {
            return;
        }
    }

    final void a(View view)
    {
        if (a == null) goto _L2; else goto _L1
_L1:
        j j1 = a;
        if (view == null || !(view.getLayoutParams() instanceof n)) goto _L4; else goto _L3
_L3:
        String s = ((n)view.getLayoutParams()).a;
        if (TextUtils.isEmpty(s)) goto _L4; else goto _L5
_L5:
        int i = s.indexOf('.');
        if (i != -1) goto _L7; else goto _L6
_L6:
        Object obj = (new StringBuilder()).append(getContext().getPackageName()).append(".").append(s).toString();
_L11:
        obj = (c)uk.co.senab.actionbarpulltorefresh.library.g.a(getContext(), ((String) (obj)));
_L9:
        if (!j1.d())
        {
            if (view != null)
            {
                break; /* Loop/switch isn't completed */
            }
            Log.i("PullToRefreshAttacher", "Refreshable View is null.");
        }
_L2:
        return;
_L7:
        obj = s;
        if (i == 0)
        {
            obj = (new StringBuilder()).append(getContext().getPackageName()).append(s).toString();
        }
        continue; /* Loop/switch isn't completed */
_L4:
        obj = null;
        if (true) goto _L9; else goto _L8
_L8:
        Object obj1 = obj;
        if (obj == null)
        {
            obj1 = uk.co.senab.actionbarpulltorefresh.library.g.a(view);
        }
        j1.m.put(view, obj1);
        return;
        if (true) goto _L11; else goto _L10
_L10:
    }

    public volatile android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return generateLayoutParams(attributeset);
    }

    public android.widget.FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return new n(getContext(), attributeset);
    }

    public f getHeaderTransformer()
    {
        a();
        return a.a;
    }

    public final View getHeaderView()
    {
        a();
        return a.d;
    }

    protected void onConfigurationChanged(Configuration configuration)
    {
        if (a != null)
        {
            j j1 = a;
            j1.a.a(j1.c);
        }
        super.onConfigurationChanged(configuration);
    }

    protected void onDetachedFromWindow()
    {
        if (a != null)
        {
            a.a();
        }
        super.onDetachedFromWindow();
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        if (isEnabled() && a != null && getChildCount() > 0)
        {
            return a.a(motionevent);
        } else
        {
            return false;
        }
    }

    public final boolean onTouchEvent(MotionEvent motionevent)
    {
        boolean flag1 = false;
        if (!isEnabled() || a == null) goto _L2; else goto _L1
_L1:
        j j1;
        j1 = a;
        if (motionevent.getAction() == 0)
        {
            j1.k = true;
        }
        if (!j1.k || j1.i) goto _L4; else goto _L3
_L3:
        j1.a(motionevent);
_L8:
        boolean flag = true;
_L6:
        return flag;
_L4:
        flag = flag1;
        if (j1.l == null) goto _L6; else goto _L5
_L5:
        switch (motionevent.getAction())
        {
        default:
            continue; /* Loop/switch isn't completed */

        case 1: // '\001'
        case 3: // '\003'
            motionevent = j1.l;
            if (j1.i && j1.n && motionevent != null && j1.g - j1.h >= j1.a(motionevent))
            {
                j1.a(true, true);
            }
            if (j1.i)
            {
                j1.c();
            }
            j1.b();
            continue; /* Loop/switch isn't completed */

        case 2: // '\002'
            flag = flag1;
            break;
        }
        if (j1.j) goto _L6; else goto _L7
_L7:
        float f1 = motionevent.getY();
        if (j1.i && f1 != j1.g)
        {
            float f2 = f1 - j1.g;
            if (f2 >= (float)(-j1.f))
            {
                float f3 = j1.a(j1.l);
                float f4 = f1 - j1.h;
                if (f4 < f3)
                {
                    j1.a.a(f4 / f3);
                } else
                if (j1.n)
                {
                    j1.a.c();
                } else
                {
                    j1.a(true, true);
                }
                if (f2 > 0.0F)
                {
                    j1.g = f1;
                }
            } else
            {
                j1.c();
                j1.b();
            }
        }
        if (true) goto _L8; else goto _L2
_L2:
        return super.onTouchEvent(motionevent);
    }

    public final void setHeaderViewListener(a a1)
    {
        a();
        a.e = a1;
    }

    void setPullToRefreshAttacher(j j1)
    {
        if (a != null)
        {
            a.a();
        }
        a = j1;
    }

    public final void setRefreshing(boolean flag)
    {
        a();
        a.a(flag, false);
    }
}
