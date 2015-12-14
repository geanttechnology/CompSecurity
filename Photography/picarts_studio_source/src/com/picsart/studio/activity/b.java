// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.activity;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.widget.SearchView;
import android.view.View;
import com.picsart.studio.utils.d;
import java.util.List;

// Referenced classes of package com.picsart.studio.activity:
//            MapActivity

final class b extends SimpleCursorAdapter
{

    final MapActivity a;

    public b(MapActivity mapactivity, Context context, String as[], int ai[])
    {
        a = mapactivity;
        super(context, 0x1090003, null, as, ai, 0);
    }

    public final void bindView(View view, Context context, Cursor cursor)
    {
        super.bindView(view, context, cursor);
        view.setOnClickListener(new android.view.View.OnClickListener(cursor.getPosition(), Double.valueOf(cursor.getString(cursor.getColumnIndex("lat"))).doubleValue(), Double.valueOf(cursor.getString(cursor.getColumnIndex("lng"))).doubleValue()) {

            private int a;
            private double b;
            private double c;
            private b d;

            public final void onClick(View view1)
            {
                MapActivity.i(d.a).clearFocus();
                MapActivity.a(d.a, (d)MapActivity.m(d.a).get(a));
                view1 = d;
                view1.changeCursor(null);
                view1.notifyDataSetChanged();
                MapActivity.a(d.a, b, c);
            }

            
            {
                d = b.this;
                a = i;
                b = d1;
                c = d2;
                super();
            }
        });
    }
}
