// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;


// Referenced classes of package com.mopub.nativeads:
//            VisibilityTracker

class this._cls0
    implements android.view.reDrawListener
{

    final VisibilityTracker this$0;

    public boolean onPreDraw()
    {
        scheduleVisibilityCheck();
        return true;
    }

    istener()
    {
        this$0 = VisibilityTracker.this;
        super();
    }
}
