// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.views;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

public class FakeKeyEventTouchListener
    implements android.view.View.OnTouchListener
{

    private final Activity mActivity;
    private final int mCode;

    public FakeKeyEventTouchListener(Activity activity, int i)
    {
        mActivity = activity;
        mCode = i;
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        switch (motionevent.getAction())
        {
        default:
            return true;

        case 0: // '\0'
            mActivity.onKeyDown(mCode, new KeyEvent(0, mCode));
            return true;

        case 1: // '\001'
            mActivity.onKeyUp(mCode, new KeyEvent(1, mCode));
            break;
        }
        return true;
    }
}
