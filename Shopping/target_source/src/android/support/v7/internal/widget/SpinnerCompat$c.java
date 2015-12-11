// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.content.Context;
import android.support.v7.widget.v;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;

// Referenced classes of package android.support.v7.internal.widget:
//            SpinnerCompat

private class a extends v
    implements a
{

    final SpinnerCompat a;
    private CharSequence c;
    private ListAdapter d;

    static ListAdapter a(a a1)
    {
        return a1.d;
    }

    public void a(ListAdapter listadapter)
    {
        super.a(listadapter);
        d = listadapter;
    }

    public void a(CharSequence charsequence)
    {
        c = charsequence;
    }

    public _cls1.a(SpinnerCompat spinnercompat, Context context, AttributeSet attributeset, int i)
    {
        a = spinnercompat;
        super(context, attributeset, i);
        a(spinnercompat);
        a(true);
        a(0);
        a(new android.widget.AdapterView.OnItemClickListener(spinnercompat) {

            final SpinnerCompat a;
            final SpinnerCompat.c b;

            public void onItemClick(AdapterView adapterview, View view, int j, long l)
            {
                b.a.setSelection(j);
                if (b.a.s != null)
                {
                    b.a.a(view, j, SpinnerCompat.c.a(b).getItemId(j));
                }
                b.a();
            }

            
            {
                b = SpinnerCompat.c.this;
                a = spinnercompat;
                super();
            }
        });
    }
}
