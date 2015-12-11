// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.sideribbon;

import android.app.Activity;
import android.content.Intent;

// Referenced classes of package com.comcast.cim.android.sideribbon:
//            SlideClosedListener

public class ActivityStarter
    implements SlideClosedListener
{

    protected final Activity activity;
    protected final Intent intent;

    public ActivityStarter(Intent intent1, Activity activity1)
    {
        intent = intent1;
        activity = activity1;
    }

    public ActivityStarter(Class class1, Activity activity1)
    {
        this(new Intent(activity1, class1), activity1);
    }

    public void onCloseFinished()
    {
        activity.startActivity(intent);
    }
}
