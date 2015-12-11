// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import co.vine.android.util.ViewUtil;
import co.vine.android.views.FakeKeyEventTouchListener;

// Referenced classes of package co.vine.android:
//            RecordingFragment

public class changeColor extends FakeKeyEventTouchListener
{

    private final int mDrawableId;
    private final Resources mRes;
    private final ImageView mTarget;
    final RecordingFragment this$0;

    private void changeColor(int i)
    {
        switch (i)
        {
        default:
            return;

        case 0: // '\0'
            ViewUtil.fillColor(mRes, RecordingFragment.access$900(RecordingFragment.this), mDrawableId, mTarget);
            mTarget.setAlpha(1.0F);
            return;

        case 1: // '\001'
            ViewUtil.fillColor(mRes, RecordingFragment.access$900(RecordingFragment.this), mDrawableId, mTarget);
            break;
        }
        mTarget.setAlpha(0.35F);
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        changeColor(motionevent.getAction());
        return super.onTouch(view, motionevent);
    }

    public (ImageView imageview, int i)
    {
        this$0 = RecordingFragment.this;
        FragmentActivity fragmentactivity = getActivity();
        char c;
        if (i == 0x7f020296)
        {
            c = '\251';
        } else
        {
            c = '\250';
        }
        super(fragmentactivity, c);
        mDrawableId = i;
        mRes = getActivity().getResources();
        mTarget = imageview;
        changeColor(1);
    }
}
