// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.shazam.android.a:
//            d

public abstract class e extends d
{
    private static final class a
    {

        public final List a;
        public final List b;
        public final List c;

        private a()
        {
            a = new ArrayList();
            b = new ArrayList();
            c = new ArrayList();
        }

        a(byte byte0)
        {
            this();
        }
    }


    private int e[];

    public e(Context context, int i, List list, int ai[])
    {
        super(context, i, list);
        e = ai;
    }

    public final void a(View view, Object obj, int i)
    {
        i = 0;
        Object obj1 = view.getTag();
        if (obj1 == null)
        {
            obj1 = new a((byte)0);
            int ai[] = e;
            int j = ai.length;
            while (i < j) 
            {
                View view1 = view.findViewById(ai[i]);
                if (view1 != null)
                {
                    if (view1 instanceof TextView)
                    {
                        ((a) (obj1)).b.add((TextView)view1);
                    } else
                    if (view1 instanceof ImageView)
                    {
                        ((a) (obj1)).a.add((ImageView)view1);
                    } else
                    {
                        ((a) (obj1)).c.add(view1);
                    }
                }
                i++;
            }
            view.setTag(obj1);
            view = ((View) (obj1));
        } else
        {
            view = (a)obj1;
        }
        for (obj1 = ((a) (view)).b.iterator(); ((Iterator) (obj1)).hasNext(); a((TextView)((Iterator) (obj1)).next(), obj)) { }
        for (view = ((a) (view)).a.iterator(); view.hasNext(); a((ImageView)view.next(), obj)) { }
    }

    public void a(ImageView imageview, Object obj)
    {
    }

    public void a(TextView textview, Object obj)
    {
    }
}
