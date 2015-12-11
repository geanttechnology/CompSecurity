// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

// Referenced classes of package co.vine.android:
//            ContactsPickerAdapter

public static class divider
{

    public long contactId;
    public View divider;
    public ImageView emailIndicator;
    public ImageView phoneIndicator;
    public int position;
    public TextView separator;
    public TextView username;

    public (View view)
    {
        emailIndicator = (ImageView)view.findViewById(0x7f0a0123);
        phoneIndicator = (ImageView)view.findViewById(0x7f0a0122);
        separator = (TextView)view.findViewById(0x7f0a01a8);
        username = (TextView)view.findViewById(0x7f0a0124);
        divider = view.findViewById(0x7f0a0060);
    }
}
