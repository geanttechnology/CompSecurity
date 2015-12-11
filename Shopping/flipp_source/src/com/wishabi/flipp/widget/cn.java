// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.content.Context;
import android.support.v7.widget.bi;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

// Referenced classes of package com.wishabi.flipp.widget:
//            co, cp, cq, cw

public final class cn extends bi
{

    final TextView k;
    final EditText l;
    final LinearLayout m;
    final cw n;

    public cn(Context context, View view, TextWatcher textwatcher, cw cw)
    {
        super(view);
        k = (TextView)view.findViewById(0x7f0b010a);
        l = (EditText)view.findViewById(0x7f0b010b);
        m = (LinearLayout)view.findViewById(0x7f0b008b);
        n = cw;
        l.setImeActionLabel(context.getString(0x7f0e0123), 6);
        l.setOnEditorActionListener(new co(this));
        l.addTextChangedListener(textwatcher);
        l.setOnFocusChangeListener(new cp(this));
        m.setOnClickListener(new cq(this));
    }
}
