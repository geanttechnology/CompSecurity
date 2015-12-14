// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.m;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package myobfuscated.m:
//            f

public class e
    implements android.view.View.OnTouchListener
{

    private final GestureDetector a;

    public e(Context context)
    {
        a = new GestureDetector(context, new f(this, (byte)0));
    }

    public void a()
    {
    }

    public void b()
    {
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        return a.onTouchEvent(motionevent);
    }
}
