// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.a;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.ListView;

// Referenced classes of package android.support.v7.a:
//            d

public final class c extends CursorAdapter
{

    final ListView a;
    final d b;
    final b c;
    private final int d;
    private final int e;

    public final void bindView(View view, Context context, Cursor cursor)
    {
        ((CheckedTextView)view.findViewById(0x1020014)).setText(cursor.getString(d));
        view = a;
        int i = cursor.getPosition();
        boolean flag;
        if (cursor.getInt(e) == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view.setItemChecked(i, flag);
    }

    public final View newView(Context context, Cursor cursor, ViewGroup viewgroup)
    {
        return c.c.inflate(b.I, viewgroup, false);
    }

    public ( , Context context, Cursor cursor, ListView listview, d d1)
    {
        c = ;
        a = listview;
        b = d1;
        super(context, cursor, false);
         = getCursor();
        d = .getColumnIndexOrThrow(c.c);
        e = .getColumnIndexOrThrow(c.c);
    }
}
