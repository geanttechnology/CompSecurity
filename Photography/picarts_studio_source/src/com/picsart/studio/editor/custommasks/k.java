// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.custommasks;

import android.view.View;
import android.widget.TextView;
import java.util.List;

// Referenced classes of package com.picsart.studio.editor.custommasks:
//            i, h

final class k extends android.support.v7.widget.RecyclerView.ViewHolder
    implements android.view.View.OnClickListener
{

    public TextView a;
    private i b;

    public k(i j, View view)
    {
        b = j;
        super(view);
        a = (TextView)view;
        view.setOnClickListener(this);
    }

    public final void onClick(View view)
    {
        int j = getAdapterPosition();
        view = (h)i.a(b).get(j);
        b.b(view);
    }
}
