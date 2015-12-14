// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;

// Referenced classes of package com.millennialmedia.android:
//            MMAdImpl, MMLog, MMLayout, MMWebView, 
//            MMAd

class k extends MMAdImpl
{

    private MMLayout k;

    public void addView(MMWebView mmwebview, android.widget.s s)
    {
        MMLog.d("MMLayout", (new StringBuilder("MMLayout adding view (")).append(mmwebview).append(") to ").append(this).toString());
        k.addView(mmwebview, s);
    }

    final volatile MMAd d()
    {
        return k;
    }

    final int e()
    {
        return k.getId();
    }

    public void removeView(MMWebView mmwebview)
    {
        k.removeView(mmwebview);
    }

    public void setClickable(boolean flag)
    {
        k.setClickable(flag);
    }

    public (MMLayout mmlayout, Context context)
    {
        k = mmlayout;
        super(context);
    }
}
