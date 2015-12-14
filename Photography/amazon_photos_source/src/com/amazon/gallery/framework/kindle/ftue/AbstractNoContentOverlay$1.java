// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.ftue;


// Referenced classes of package com.amazon.gallery.framework.kindle.ftue:
//            AbstractNoContentOverlay

class this._cls0
    implements Runnable
{

    final AbstractNoContentOverlay this$0;

    public void run()
    {
label0:
        {
            synchronized (AbstractNoContentOverlay.this)
            {
                if (attached)
                {
                    break label0;
                }
            }
            return;
        }
        show();
        AbstractNoContentOverlay.access$000(AbstractNoContentOverlay.this);
        abstractnocontentoverlay;
        JVM INSTR monitorexit ;
        return;
        exception;
        abstractnocontentoverlay;
        JVM INSTR monitorexit ;
        throw exception;
    }

    I()
    {
        this$0 = AbstractNoContentOverlay.this;
        super();
    }
}
