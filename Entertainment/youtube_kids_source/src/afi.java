// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.util.SparseIntArray;
import android.widget.Button;
import com.google.android.apps.youtube.kids.application.KidsApplication;

public final class afi extends Button
{

    private static final SparseIntArray a;
    private static final SparseIntArray b;
    private final int c;
    private final int d;

    public afi(Context context, bql bql1)
    {
        super(context);
        int i = bql1.a.b.a;
        c = a.get(i);
        d = b.get(i);
        setTag(0x7f100018, bql1.a.a);
        setBackgroundResource(d);
    }

    public final void setSelected(boolean flag)
    {
        if (isSelected() != flag)
        {
            super.setSelected(flag);
            if (flag)
            {
                Object obj = (AnimationDrawable)getResources().getDrawable(c);
                setBackground(((android.graphics.drawable.Drawable) (obj)));
                ((AnimationDrawable) (obj)).start();
                obj = ((KidsApplication)getContext().getApplicationContext()).h().R();
                if (c == a.get(26))
                {
                    ((acd) (obj)).b(0x7f080013);
                    return;
                }
                if (c == a.get(27))
                {
                    ((acd) (obj)).b(0x7f080011);
                    return;
                }
                if (c == a.get(21))
                {
                    ((acd) (obj)).b(0x7f080012);
                    return;
                }
                if (c == a.get(14))
                {
                    ((acd) (obj)).b(0x7f080010);
                    return;
                }
                if (c == a.get(33))
                {
                    ((acd) (obj)).b(0x7f08000f);
                    return;
                }
            } else
            {
                setBackgroundResource(d);
                return;
            }
        }
    }

    static 
    {
        SparseIntArray sparseintarray = new SparseIntArray();
        a = sparseintarray;
        sparseintarray.put(26, 0x7f020192);
        a.put(27, 0x7f020119);
        a.put(21, 0x7f020148);
        a.put(14, 0x7f0200f5);
        a.put(33, 0x7f0200d2);
        sparseintarray = new SparseIntArray();
        b = sparseintarray;
        sparseintarray.put(26, 0x7f020172);
        b.put(27, 0x7f0200f9);
        b.put(21, 0x7f02012c);
        b.put(14, 0x7f0200db);
        b.put(33, 0x7f0200b2);
    }
}
