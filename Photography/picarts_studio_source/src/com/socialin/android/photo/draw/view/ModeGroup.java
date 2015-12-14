// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.melnykov.fab.a;

public class ModeGroup extends RadioGroup
    implements android.view.View.OnClickListener, android.view.ViewGroup.OnHierarchyChangeListener
{

    private int a;

    public ModeGroup(Context context)
    {
        this(context, null);
    }

    public ModeGroup(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        super.setOnHierarchyChangeListener(this);
    }

    public void onChildViewAdded(View view, View view1)
    {
        if (!(view1 instanceof RadioButton))
        {
            throw new IllegalStateException();
        } else
        {
            view1.setOnClickListener(this);
            return;
        }
    }

    public void onChildViewRemoved(View view, View view1)
    {
        view1.setOnClickListener(null);
    }

    public void onClick(View view)
    {
        int i = view.getId();
        if (i != a)
        {
            a = i;
        }
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        a = getCheckedRadioButtonId();
    }

    public void setOnHierarchyChangeListener(android.view.ViewGroup.OnHierarchyChangeListener onhierarchychangelistener)
    {
        throw new UnsupportedOperationException();
    }

    public void setOnModeSelectedListener$7554c8d8(a a1)
    {
    }
}
