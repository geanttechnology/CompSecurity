// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.ftue;

import com.amazon.gallery.framework.kindle.activity.FTUEFragmentActivity;

// Referenced classes of package com.amazon.gallery.thor.ftue:
//            FacebookScreen

class this._cls0
    implements Runnable
{

    final FacebookScreen this$0;

    public void run()
    {
        FacebookScreen.access$2100(FacebookScreen.this);
        FacebookScreen.access$4700(FacebookScreen.this).showErrorNotification(FacebookScreen.access$4600(FacebookScreen.this).getString(0x7f0e00d8));
    }

    UEFragmentActivity()
    {
        this$0 = FacebookScreen.this;
        super();
    }
}
