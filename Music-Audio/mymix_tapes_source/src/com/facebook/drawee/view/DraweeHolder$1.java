// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.drawee.view;

import android.app.Activity;
import com.facebook.common.activitylistener.BaseActivityListener;

// Referenced classes of package com.facebook.drawee.view:
//            DraweeHolder

class eActivityListener extends BaseActivityListener
{

    final DraweeHolder this$0;

    public void onStart(Activity activity)
    {
        DraweeHolder.access$000(DraweeHolder.this, true);
    }

    public void onStop(Activity activity)
    {
        DraweeHolder.access$000(DraweeHolder.this, false);
    }

    eActivityListener()
    {
        this$0 = DraweeHolder.this;
        super();
    }
}
