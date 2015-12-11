// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.view.View;
import android.widget.TextView;

// Referenced classes of package co.vine.android:
//            ProfileHeaderAdapter

static class userLoopCount
{

    public TextView description;
    public TextView location;
    public View parent;
    public TextView userLoopCount;

    public A(View view)
    {
        parent = view.findViewById(0x7f0a019c);
        location = (TextView)view.findViewById(0x7f0a019e);
        description = (TextView)view.findViewById(0x7f0a019d);
        userLoopCount = (TextView)view.findViewById(0x7f0a019f);
    }
}
