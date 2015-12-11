// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;


// Referenced classes of package co.vine.android.widget:
//            AnimatingCircle

public class this._cls0
    implements Runnable
{

    final AnimatingCircle this$0;

    public void run()
    {
        AnimatingCircle.access$002(AnimatingCircle.this, AnimatingCircle.access$000(AnimatingCircle.this) + AnimatingCircle.access$100(AnimatingCircle.this));
        invalidate();
        startDefaultAnimation();
    }

    public ()
    {
        this$0 = AnimatingCircle.this;
        super();
    }
}
