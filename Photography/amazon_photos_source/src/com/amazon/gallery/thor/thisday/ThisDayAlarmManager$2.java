// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.thisday;


// Referenced classes of package com.amazon.gallery.thor.thisday:
//            ThisDayAlarmManager, ThisDaySharedPrefsManager

class this._cls0
    implements com.amazon.gallery.foundation.metrics.amazoninsights.aunchLoadedListener
{

    final ThisDayAlarmManager this$0;

    public void onLaunchLoaded(boolean flag)
    {
        ThisDayAlarmManager.access$200(ThisDayAlarmManager.this).setBannerEnabled(flag);
    }

    ger()
    {
        this$0 = ThisDayAlarmManager.this;
        super();
    }
}
