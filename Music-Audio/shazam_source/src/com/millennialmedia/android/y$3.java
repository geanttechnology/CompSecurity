// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.android:
//            y, ak, al

final class a
    implements android.view..OnTouchListener
{

    final y a;

    public final boolean onTouch(View view, MotionEvent motionevent)
    {
        if (motionevent.getAction() == 1)
        {
            view = (ak)y.f(a).get();
            if (view == null)
            {
                al.a("InlineVideoView", "Unable to handle touch event, MMLayout weak reference broken");
                return false;
            }
            if (!TextUtils.isEmpty(y.a(a).j))
            {
                view.a(String.format((new StringBuilder("javascript:")).append(y.a(a).j).append("(%f,%f)").toString(), new Object[] {
                    Float.valueOf(motionevent.getX()), Float.valueOf(motionevent.getY())
                }));
            }
            if (y.j(a) != null && !y.j(a).isShowing())
            {
                y.j(a).show();
                return true;
            }
        }
        return true;
    }

    r(y y1)
    {
        a = y1;
        super();
    }
}
