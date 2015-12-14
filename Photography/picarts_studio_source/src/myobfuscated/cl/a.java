// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cl;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

// Referenced classes of package myobfuscated.cl:
//            b

public final class a extends android.support.v7.widget.RecyclerView.ViewHolder
    implements android.view.View.OnClickListener
{

    public View a;
    public ImageView b;
    public TextView c;
    public ImageView d;
    public View e;
    b f;

    public a(View view)
    {
        super(view);
        a = view;
        b = (ImageView)view.findViewById(0x7f100233);
        b.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
        c = (TextView)view.findViewById(0x7f100234);
        view.findViewById(0x7f100235);
        d = (ImageView)view.findViewById(0x7f1003ff);
        e = view.findViewById(0x7f100235);
        view.setOnClickListener(this);
    }

    public final void onClick(View view)
    {
        int i = getAdapterPosition();
        if (i != -1 && f != null)
        {
            f.a(i);
        }
    }
}
