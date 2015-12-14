// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.support.v7.internal.widget.SpinnerCompat;
import android.support.v7.widget.ListPopupWindow;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;

public class cd extends ListPopupWindow
    implements ce
{

    final SpinnerCompat a;
    private CharSequence c;
    private ListAdapter d;

    public cd(SpinnerCompat spinnercompat, Context context, AttributeSet attributeset, int i)
    {
        a = spinnercompat;
        super(context, attributeset, i);
        a(spinnercompat);
        a(true);
        a(0);
        a(new android.widget.AdapterView.OnItemClickListener(spinnercompat) {

            final SpinnerCompat a;
            final cd b;

            public void onItemClick(AdapterView adapterview, View view, int j, long l)
            {
                b.a.setSelection(j);
                if (b.a.mOnItemClickListener != null)
                {
                    b.a.performItemClick(view, j, cd.a(b).getItemId(j));
                }
                b.a();
            }

            
            {
                b = cd.this;
                a = spinnercompat;
                super();
            }
        });
    }

    static ListAdapter a(cd cd1)
    {
        return cd1.d;
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
}
