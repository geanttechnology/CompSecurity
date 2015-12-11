// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import co.vine.android.util.image.ImageKey;

// Referenced classes of package co.vine.android:
//            UsersAutoCompleteAdapter

private class userNameView
{

    public ImageKey avatarUrl;
    public final ImageView image;
    final UsersAutoCompleteAdapter this$0;
    public long userId;
    public final TextView userNameView;

    public (View view)
    {
        this$0 = UsersAutoCompleteAdapter.this;
        super();
        image = (ImageView)view.findViewById(0x7f0a0063);
        userNameView = (TextView)view.findViewById(0x7f0a00c4);
    }
}
