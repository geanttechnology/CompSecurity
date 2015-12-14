// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.facebook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.socialin.android.adapter.RecyclerViewAdapter;
import com.socialin.android.adapter.a;

// Referenced classes of package com.socialin.android.facebook:
//            o, FacebookPageObject

public final class n extends RecyclerViewAdapter
{

    private Context a;

    public n(Context context)
    {
        super(context);
        a = context;
    }

    static a a(n n1)
    {
        return n1.clickListener;
    }

    public final void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i)
    {
        viewholder = (o)viewholder;
        super.onBindViewHolder(viewholder, i);
        FacebookPageObject facebookpageobject = (FacebookPageObject)getItem(i);
        ((o) (viewholder)).a.setText(facebookpageobject.getTitle());
        ((o) (viewholder)).itemView.setOnClickListener(new _cls1(i));
    }

    public final android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        return new o(LayoutInflater.from(a).inflate(0x7f0300fb, viewgroup, false));
    }

    public final void setOnItemClickListener(a a1)
    {
        super.setOnItemClickListener(a1);
    }

    /* member class not found */
    class _cls1 {}

}
