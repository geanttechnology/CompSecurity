// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import co.vine.android.util.Util;

// Referenced classes of package co.vine.android.widget:
//            ContactsMenuAdapter

public static class sectionSort
{

    public long contactId;
    public View divider;
    public ImageView emailIndicator;
    public ImageView phoneIndicator;
    public int position;
    public View sectionIndicator;
    public TextView sectionSort;
    public TextView sectionTitle;
    public TextView username;

    public I(Context context, View view)
    {
        emailIndicator = (ImageView)view.findViewById(0x7f0a0123);
        phoneIndicator = (ImageView)view.findViewById(0x7f0a0122);
        sectionIndicator = view.findViewById(0x7f0a0120);
        sectionTitle = (TextView)view.findViewById(0x7f0a01ab);
        sectionSort = (TextView)view.findViewById(0x7f0a01aa);
        username = (TextView)view.findViewById(0x7f0a0124);
        divider = view.findViewById(0x7f0a0060);
        Util.styleSectionHeader(context, sectionTitle, sectionSort);
    }
}
