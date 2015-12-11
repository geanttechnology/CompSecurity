// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.advertising;

import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebView;

// Referenced classes of package com.medialets.advertising:
//            AdManager

final class s extends WebView
{

    public s(Context context)
    {
        super(context);
    }

    public final boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (keyevent.getKeyCode() == 4)
        {
            return ((ViewGroup)getParent()).onKeyDown(i, keyevent);
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    public final boolean onTouchEvent(MotionEvent motionevent)
    {
        requestFocus();
        AdManager.getInstance().getCurrentActivity().getWindow().addFlags(1024);
        return super.onTouchEvent(motionevent);
    }
}
