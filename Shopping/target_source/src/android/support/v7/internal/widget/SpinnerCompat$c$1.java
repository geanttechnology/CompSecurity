// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;

// Referenced classes of package android.support.v7.internal.widget:
//            SpinnerCompat

class a
    implements android.widget.ClickListener
{

    final SpinnerCompat a;
    final b b;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        b.b.setSelection(i);
        if (b.b.s != null)
        {
            b.b.a(view, i, b(b).getItemId(i));
        }
        b.b();
    }

    ( , SpinnerCompat spinnercompat)
    {
        b = ;
        a = spinnercompat;
        super();
    }
}
