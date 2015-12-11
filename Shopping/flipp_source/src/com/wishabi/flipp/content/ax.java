// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;

import android.support.v7.widget.bi;
import android.view.View;
import android.widget.TextView;
import com.wishabi.flipp.widget.db;

public final class ax extends bi
{

    public db k;
    public TextView l;

    public ax(View view)
    {
        super(view);
        db db1;
        if (view instanceof db)
        {
            db1 = (db)view;
        } else
        {
            db1 = null;
        }
        k = db1;
        l = (TextView)view.findViewById(0x7f0b0132);
    }
}
