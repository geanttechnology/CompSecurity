// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wjj.utils;


// Referenced classes of package com.wjj.utils:
//            StickyLayout

class t extends Thread
{

    final StickyLayout this$0;
    private final int val$frameCount;
    private final int val$from;
    private final boolean val$modifyOriginalHeaderHeight;
    private final float val$partation;
    private final int val$to;

    public void run()
    {
        int i = 0;
        do
        {
            if (i >= val$frameCount)
            {
                if (val$modifyOriginalHeaderHeight)
                {
                    setOriginalHeaderHeight(val$to);
                }
                return;
            }
            final int height;
            if (i == val$frameCount - 1)
            {
                height = val$to;
            } else
            {
                height = (int)((float)val$from + val$partation * (float)i);
            }
            post(new Runnable() {

                final StickyLayout._cls1 this$1;
                private final int val$height;

                public void run()
                {
                    setHeaderHeight(height);
                }

            
            {
                this$1 = StickyLayout._cls1.this;
                height = i;
                super();
            }
            });
            try
            {
                sleep(10L);
            }
            catch (InterruptedException interruptedexception)
            {
                interruptedexception.printStackTrace();
            }
            i++;
        } while (true);
    }


    _cls1.val.height(boolean flag)
    {
        this$0 = final_stickylayout;
        val$frameCount = i;
        val$to = j;
        val$from = k;
        val$partation = F.this;
        val$modifyOriginalHeaderHeight = flag;
        super(final_s);
    }
}
