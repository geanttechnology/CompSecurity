// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.accessibility;

import android.app.Activity;
import android.view.View;

// Referenced classes of package com.comcast.cim.android.accessibility:
//            DefaultTalkDelegate, AccessibilityUtil, AccessibleTalkDelegate, DummyTalkDelegate, 
//            TalkDelegate

public class TalkDelegateFactory
{

    protected final AccessibilityUtil accessibilityUtil;

    public TalkDelegateFactory(AccessibilityUtil accessibilityutil)
    {
        accessibilityUtil = accessibilityutil;
    }

    public TalkDelegate getDefaultTalkDelegate(Activity activity)
    {
        return new DefaultTalkDelegate(activity);
    }

    public TalkDelegate getTalkDelegate(Activity activity, View view)
    {
        if (accessibilityUtil.isAccessibilityEnabled())
        {
            if (android.os.Build.VERSION.SDK_INT >= 16)
            {
                return new AccessibleTalkDelegate(activity, view, accessibilityUtil);
            } else
            {
                return new DefaultTalkDelegate(activity);
            }
        } else
        {
            return new DummyTalkDelegate(activity);
        }
    }
}
