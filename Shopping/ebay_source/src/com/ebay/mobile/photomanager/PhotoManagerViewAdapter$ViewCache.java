// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.photomanager;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

// Referenced classes of package com.ebay.mobile.photomanager:
//            PhotoManagerViewAdapter

public static final class free
{

    public final TextView caption;
    public final TextView free;
    public final ImageView image;
    public final ImageView lock;
    public final TextView numberText;

    public (View view)
    {
        image = (ImageView)view.findViewById(0x7f1004b3);
        numberText = (TextView)view.findViewById(0x7f1004b4);
        lock = (ImageView)view.findViewById(0x7f1004b5);
        caption = (TextView)view.findViewById(0x7f1004b6);
        free = (TextView)view.findViewById(0x7f1004b7);
    }
}
