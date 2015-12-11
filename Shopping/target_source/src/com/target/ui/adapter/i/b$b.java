// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.target.ui.view.DepartmentBadgeView;

// Referenced classes of package com.target.ui.adapter.i:
//            b

public static class Id
{

    public ImageView action;
    public DepartmentBadgeView icon;
    public TextView name;
    public TextView subText;

    public tBadgeView(View view)
    {
        name = (TextView)view.findViewById(0x7f1005c3);
        subText = (TextView)view.findViewById(0x7f1005c4);
        icon = (DepartmentBadgeView)view.findViewById(0x7f1005c2);
        action = (ImageView)view.findViewById(0x7f1005c5);
    }
}
