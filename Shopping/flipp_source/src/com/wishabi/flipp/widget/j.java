// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.wishabi.flipp.c.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

// Referenced classes of package com.wishabi.flipp.widget:
//            CollectionView, k, l, m, 
//            o, n

final class j extends ViewGroup
{

    static final boolean g;
    final SparseArray a;
    final List b;
    ListAdapter c;
    final android.view.View.OnClickListener d;
    final android.view.View.OnLongClickListener e;
    final DataSetObserver f;
    final CollectionView h;

    public j(CollectionView collectionview, Context context)
    {
        this(collectionview, context, (byte)0);
    }

    private j(CollectionView collectionview, Context context, byte byte0)
    {
        this(collectionview, context, '\0');
    }

    private j(CollectionView collectionview, Context context, char c1)
    {
        h = collectionview;
        super(context, null, 0);
        a = new SparseArray();
        b = new ArrayList();
        d = new k(this);
        e = new l(this);
        f = new m(this);
    }

    static SparseArray a(j j1)
    {
        return j1.a;
    }

    private void a(int i)
    {
        ListAdapter listadapter;
        SparseArray sparsearray;
        List list;
        android.view.View.OnClickListener onclicklistener;
        android.view.View.OnLongClickListener onlongclicklistener;
        Iterator iterator;
        com.wishabi.flipp.c.a.a("layoutChildren");
        listadapter = c;
        if (listadapter == null)
        {
            return;
        }
        int k1 = getWidth();
        int l1 = i + h.getHeight();
        sparsearray = a;
        list = b;
        Object obj = CollectionView.d(h);
        onclicklistener = d;
        onlongclicklistener = e;
        int i1 = 0;
label0:
        do
        {
            View view;
label1:
            {
                if (i1 >= getChildCount())
                {
                    break label0;
                }
                view = getChildAt(i1);
                if (!g && view == null)
                {
                    throw new AssertionError();
                }
                o o1 = (o)view.getLayoutParams();
                if (!g && o1 == null)
                {
                    throw new AssertionError();
                }
                int i2 = o1.d;
                if (!((n) (obj)).a(i2).a.intersects(0, i, k1, l1))
                {
                    sparsearray.delete(i2);
                    i2 = listadapter.getItemViewType(i2);
                    if (i2 == -1)
                    {
                        break label1;
                    }
                    ((Stack)list.get(i2)).push(view);
                }
                i1++;
                continue;
            }
            removeViewInLayout(view);
        } while (true);
        detachAllViewsFromParent();
        obj = ((n) (obj)).a(i, k1, l1);
        Collections.sort(((List) (obj)), CollectionView.b());
        iterator = ((List) (obj)).iterator();
_L2:
        Object obj1;
        o o2;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_485;
        }
        o2 = (o)iterator.next();
        i = o2.d;
        obj1 = (View)sparsearray.get(i);
        if (obj1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        attachViewToParent(((View) (obj1)), -1, o2);
_L4:
        Rect rect = o2.a;
        ((View) (obj1)).measure(android.view.View.MeasureSpec.makeMeasureSpec(rect.width(), 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(rect.height(), 0x40000000));
        ((View) (obj1)).layout(rect.left, rect.top, rect.right, rect.bottom);
        ((View) (obj1)).setActivated(CollectionView.b(h).get(i));
        if (true) goto _L2; else goto _L1
_L1:
        View view1;
        int j1 = listadapter.getItemViewType(i);
        obj1 = null;
        if (j1 != -1)
        {
            obj1 = (Stack)list.get(j1);
            if (((Stack) (obj1)).empty())
            {
                obj1 = null;
            } else
            {
                obj1 = (View)((Stack) (obj1)).pop();
            }
        }
        view1 = listadapter.getView(i, ((View) (obj1)), this);
        if (view1 == null) goto _L2; else goto _L3
_L3:
        if (view1 != obj1)
        {
            addViewInLayout(view1, -1, o2);
            if (o2.f)
            {
                view1.setOnClickListener(onclicklistener);
                view1.setOnLongClickListener(onlongclicklistener);
            }
        } else
        {
            attachViewToParent(view1, -1, o2);
        }
        sparsearray.put(i, view1);
        obj1 = view1;
          goto _L4
        com.wishabi.flipp.c.a.a();
        return;
    }

    static void a(j j1, int i)
    {
        j1.a(i);
    }

    static ListAdapter b(j j1)
    {
        return j1.c;
    }

    static List c(j j1)
    {
        return j1.b;
    }

    public final void a()
    {
        int i1 = getChildCount();
        for (int i = 0; i < i1; i++)
        {
            View view = getChildAt(i);
            if (!g && view == null)
            {
                throw new AssertionError();
            }
            o o1 = (o)view.getLayoutParams();
            if (!g && o1 == null)
            {
                throw new AssertionError();
            }
            int j1 = o1.d;
            view.setActivated(CollectionView.b(h).get(j1));
        }

        invalidate();
    }

    protected final void onLayout(boolean flag, int i, int i1, int j1, int k1)
    {
        a(h.getScrollY());
    }

    protected final void onMeasure(int i, int i1)
    {
        if (CollectionView.d(h) != null)
        {
            CollectionView.d(h).c();
            setMeasuredDimension(CollectionView.d(h).a(), CollectionView.d(h).b());
            return;
        } else
        {
            setMeasuredDimension(android.view.View.MeasureSpec.getSize(i), android.view.View.MeasureSpec.getSize(i1));
            return;
        }
    }

    static 
    {
        boolean flag;
        if (!com/wishabi/flipp/widget/CollectionView.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        g = flag;
    }
}
