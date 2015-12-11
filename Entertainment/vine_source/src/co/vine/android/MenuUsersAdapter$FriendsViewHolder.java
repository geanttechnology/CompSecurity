// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import co.vine.android.api.VineRecipient;
import co.vine.android.util.Util;
import co.vine.android.util.image.ImageKey;

// Referenced classes of package co.vine.android:
//            MenuUsersAdapter

public static class sectionSort
{

    public ImageKey avatarKey;
    public View divider;
    public TextView friendName;
    public ImageView image;
    public int position;
    public VineRecipient recipient;
    public View sectionIndicator;
    public TextView sectionSort;
    public TextView sectionTitle;

    public (Context context, View view)
    {
        friendName = (TextView)view.findViewById(0x7f0a0125);
        image = (ImageView)view.findViewById(0x7f0a0063);
        sectionIndicator = view.findViewById(0x7f0a0120);
        sectionTitle = (TextView)view.findViewById(0x7f0a01ab);
        sectionSort = (TextView)view.findViewById(0x7f0a01aa);
        divider = view.findViewById(0x7f0a0060);
        Util.styleSectionHeader(context, sectionTitle, sectionSort);
    }
}
