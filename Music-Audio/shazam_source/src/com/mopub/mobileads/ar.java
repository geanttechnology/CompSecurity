// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import android.content.Intent;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.mopub.common.b;
import com.mopub.common.c.a;

// Referenced classes of package com.mopub.mobileads:
//            a, b

public final class ar extends GestureDetector
{
    public static interface a
    {

        public abstract void a();
    }


    public a a;
    private final View b;
    private com.mopub.mobileads.a c;

    public ar(Context context, View view, b b1)
    {
        this(context, view, new com.mopub.mobileads.a(view, b1));
    }

    private ar(Context context, View view, com.mopub.mobileads.a a1)
    {
        super(context, a1);
        c = a1;
        b = view;
        setIsLongpressEnabled(false);
    }

    public final void a(MotionEvent motionevent)
    {
        boolean flag1 = false;
        View view;
        boolean flag;
        switch (motionevent.getAction())
        {
        default:
            return;

        case 1: // '\001'
            if (a != null)
            {
                a.a();
            } else
            {
                com.mopub.common.c.a.b("View's onUserClick() is not registered.");
            }
            motionevent = c;
            if (((com.mopub.mobileads.a) (motionevent)).c == a.a.d)
            {
                motionevent.b = new com.mopub.mobileads.b(((com.mopub.mobileads.a) (motionevent)).d.getContext(), ((com.mopub.mobileads.a) (motionevent)).d, ((com.mopub.mobileads.a) (motionevent)).a);
                com.mopub.mobileads.b b1 = ((com.mopub.mobileads.a) (motionevent)).b;
                b1.b.putParcelableArrayListExtra("android.intent.extra.STREAM", b1.c);
                Intent intent = Intent.createChooser(b1.b, "Send Email...");
                intent.addFlags(0x10000000);
                b1.a.startActivity(intent);
            }
            motionevent.a();
            return;

        case 0: // '\0'
            onTouchEvent(motionevent);
            return;

        case 2: // '\002'
            view = b;
            flag = flag1;
            break;
        }
        if (motionevent != null)
        {
            if (view == null)
            {
                flag = flag1;
            } else
            {
                float f = motionevent.getX();
                float f1 = motionevent.getY();
                flag = flag1;
                if (f >= 0.0F)
                {
                    flag = flag1;
                    if (f <= (float)view.getWidth())
                    {
                        flag = flag1;
                        if (f1 >= 0.0F)
                        {
                            flag = flag1;
                            if (f1 <= (float)view.getHeight())
                            {
                                flag = true;
                            }
                        }
                    }
                }
            }
        }
        if (flag)
        {
            onTouchEvent(motionevent);
            return;
        } else
        {
            c.a();
            return;
        }
    }
}
