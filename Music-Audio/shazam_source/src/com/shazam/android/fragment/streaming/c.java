// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.fragment.streaming;

import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.shazam.android.activities.streaming.b;

// Referenced classes of package com.shazam.android.fragment.streaming:
//            b

public final class c
    implements com.shazam.android.fragment.streaming.b
{

    private TextView a;
    private b.a b;
    private ImageView c;
    private ImageView d;
    private b e;
    private View f;

    public c()
    {
    }

    public final void a()
    {
        a.setVisibility(0);
        a.setText(0x7f090060);
        c.setImageResource(e.e);
        f.setVisibility(8);
        d.setImageResource(e.f);
    }

    public final void a(View view, b b1)
    {
        e = b1;
        a = (TextView)view.findViewById(0x7f110114);
        ((TextView)view.findViewById(0x7f110113)).setMovementMethod(new ScrollingMovementMethod());
        c = (ImageView)view.findViewById(0x7f110110);
        d = (ImageView)view.findViewById(0x7f110116);
        f = view.findViewById(0x7f110115);
        b = b.a.a;
        a();
    }

    public final void b()
    {
        a.setVisibility(8);
        f.setVisibility(0);
        b = com.shazam.android.fragment.streaming.b.a.b;
    }

    public final b.a c()
    {
        return b;
    }
}
