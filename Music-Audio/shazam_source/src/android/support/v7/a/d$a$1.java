// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

// Referenced classes of package android.support.v7.a:
//            d

public final class  extends ArrayAdapter
{

    final ListView a;
    final ItemChecked b;

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        view = super.getView(i, view, viewgroup);
        if (b.b != null && b.b[i])
        {
            a.setItemChecked(i, true);
        }
        return view;
    }

    public ( , Context context, int i, CharSequence acharsequence[], ListView listview)
    {
        b = ;
        a = listview;
        super(context, i, 0x1020014, acharsequence);
    }
}
