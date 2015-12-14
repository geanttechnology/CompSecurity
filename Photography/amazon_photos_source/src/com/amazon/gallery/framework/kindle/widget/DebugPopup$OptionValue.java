// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.widget;

import android.content.Context;

// Referenced classes of package com.amazon.gallery.framework.kindle.widget:
//            DebugPopup

private static abstract class value
{

    Object value;

    abstract boolean CheckPreferenceEquality(Context context, String s);

    abstract void saveValue(Context context, String s);

    public (Object obj)
    {
        value = obj;
    }
}
