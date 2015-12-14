// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.custommasks;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;
import myobfuscated.bw.d;

// Referenced classes of package com.picsart.studio.editor.custommasks:
//            d, Mask, o

final class f extends android.support.v7.widget.RecyclerView.ViewHolder
    implements android.view.View.OnClickListener, android.view.View.OnHoverListener
{

    private TextView a;
    private ImageView b;
    private com.picsart.studio.editor.custommasks.d c;

    public f(com.picsart.studio.editor.custommasks.d d1, View view)
    {
        c = d1;
        super(view);
        a = (TextView)view.findViewById(0x7f100234);
        b = (ImageView)view.findViewById(0x7f100233);
        view.setOnClickListener(this);
        view.setOnHoverListener(this);
    }

    static TextView a(f f1)
    {
        return f1.a;
    }

    static ImageView b(f f1)
    {
        return f1.b;
    }

    public final void onClick(View view)
    {
        if (!d.a(c))
        {
            Toast.makeText(d.b(c), "Image is not loaded yet. Please wait.", 0).show();
        } else
        {
            int i = getAdapterPosition();
            if (i >= 0 && i < d.c(c).size())
            {
                c.a((Mask)d.c(c).get(i));
                return;
            }
        }
    }

    public final boolean onHover(View view, MotionEvent motionevent)
    {
        return com.picsart.studio.editor.custommasks.d.d(c).b.a(view, motionevent);
    }
}
