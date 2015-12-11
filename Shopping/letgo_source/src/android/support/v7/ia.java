// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package android.support.v7:
//            aqo

public class ia
    implements android.support.v7.widget.RecyclerView.OnItemTouchListener
{
    public static interface a
    {

        public abstract void a(View view, int i);
    }


    private final a a;
    private GestureDetector b;

    public ia(a a1, Context context)
    {
        a = a1;
        b = new GestureDetector(context, new android.view.GestureDetector.SimpleOnGestureListener() {

            final ia a;

            public boolean onSingleTapUp(MotionEvent motionevent)
            {
                return true;
            }

            
            {
                a = ia.this;
                super();
            }
        });
    }

    public boolean onInterceptTouchEvent(RecyclerView recyclerview, MotionEvent motionevent)
    {
        boolean flag1 = false;
        View view = recyclerview.findChildViewUnder(motionevent.getX(), motionevent.getY());
        boolean flag = flag1;
        if (view != null)
        {
            flag = flag1;
            if (a != null)
            {
                flag = flag1;
                if (b.onTouchEvent(motionevent))
                {
                    try
                    {
                        int i = recyclerview.getChildAdapterPosition(view);
                        a.a(view, i);
                    }
                    // Misplaced declaration of an exception variable
                    catch (RecyclerView recyclerview)
                    {
                        aqo.b(recyclerview, "onInterceptTouchEvent", new Object[0]);
                    }
                    flag = true;
                }
            }
        }
        return flag;
    }

    public void onRequestDisallowInterceptTouchEvent(boolean flag)
    {
    }

    public void onTouchEvent(RecyclerView recyclerview, MotionEvent motionevent)
    {
    }
}
