// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.ui;


// Referenced classes of package com.amazon.gallery.framework.kindle.ui:
//            NetworkIndicator

class atus
    implements Runnable
{

    final NetworkIndicator this$0;
    final atus val$status;

    public void run()
    {
        updateText(val$status);
    }

    atus()
    {
        this$0 = final_networkindicator;
        val$status = atus.this;
        super();
    }
}
