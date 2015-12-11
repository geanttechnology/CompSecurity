// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.view.View;
import android.widget.TextView;

public class TagViewHolder
{

    public String tagName;
    public TextView tagTitle;

    public TagViewHolder(View view)
    {
        tagTitle = (TextView)view.findViewById(0x7f0a0226);
    }
}
