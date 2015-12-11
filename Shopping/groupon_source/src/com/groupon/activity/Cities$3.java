// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.groupon.models.division.Division;
import java.util.List;

// Referenced classes of package com.groupon.activity:
//            Cities

class dexerAdapter extends dexerAdapter
{

    final Cities this$0;

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        String s = ((Division)getItem(i)).name;
        if (view == null)
        {
            view = Cities.access$900(Cities.this).inflate(0x7f030063, viewgroup, false);
        }
        ((TextView)view.findViewById(0x7f100078)).setText(s);
        return view;
    }

    vision(Context context, int i, List list)
    {
        this$0 = Cities.this;
        super(Cities.this, context, i, list);
    }
}
