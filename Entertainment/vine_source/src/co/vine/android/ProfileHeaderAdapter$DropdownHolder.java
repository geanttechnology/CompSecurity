// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

// Referenced classes of package co.vine.android:
//            ProfileHeaderAdapter

public static class revineIcon
{

    public final ImageView revineIcon;
    public final TextView revineLabel;
    public final View revineParent;

    public _cls9(View view)
    {
        revineParent = view.findViewById(0x7f0a0197);
        revineLabel = (TextView)view.findViewById(0x7f0a0198);
        revineIcon = (ImageView)view.findViewById(0x7f0a0199);
    }
}
