// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.widget;


// Referenced classes of package it.sephiroth.android.library.widget:
//            AbsHListView

class val.duration
    implements Runnable
{

    final val.duration this$1;
    final int val$duration;
    final int val$position;
    final int val$postOffset;

    public void run()
    {
        artWithOffset(val$position, val$postOffset, val$duration);
    }

    I()
    {
        this$1 = final_i;
        val$position = j;
        val$postOffset = k;
        val$duration = I.this;
        super();
    }
}
