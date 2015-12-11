// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ScrollView;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

// Referenced classes of package com.wishabi.flipp.widget:
//            i, j, q, r, 
//            t, n, s, p

public class CollectionView extends ScrollView
{

    private static final Comparator l = new i();
    s a;
    int b;
    ActionMode c;
    q d;
    final SparseBooleanArray e;
    private n f;
    private View g;
    private ListAdapter h;
    private r i;
    private t j;
    private final j k;

    public CollectionView(Context context)
    {
        this(context, null);
    }

    public CollectionView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x1010080);
    }

    public CollectionView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        e = new SparseBooleanArray();
        k = new j(this, context);
        addView(k);
    }

    static ActionMode a(CollectionView collectionview)
    {
        collectionview.c = null;
        return null;
    }

    static SparseBooleanArray b(CollectionView collectionview)
    {
        return collectionview.e;
    }

    static Comparator b()
    {
        return l;
    }

    private void c()
    {
        if (g != null)
        {
            if (h == null || h.isEmpty())
            {
                g.setVisibility(0);
            } else
            {
                g.setVisibility(8);
            }
        }
        if (h == null || h.isEmpty())
        {
            setVisibility(8);
            return;
        } else
        {
            setVisibility(0);
            return;
        }
    }

    static void c(CollectionView collectionview)
    {
        collectionview.c();
    }

    static n d(CollectionView collectionview)
    {
        return collectionview.f;
    }

    public final void a()
    {
        if (b == 3 && c != null)
        {
            c.finish();
        }
    }

    public final void a(int i1, boolean flag)
    {
        if (b == 0)
        {
            return;
        }
        if (b == 3 && c == null)
        {
            if (d == null)
            {
                throw new IllegalStateException("CollectionView: attempted to start selection mode for CHOICE_MODE_MULTIPLE_MODAL but no choice mode callback was supplied. Call setMultiChoiceModeListener to set a callback.");
            }
            c = startActionMode(d);
        }
        if (b != 2 && b != 3) goto _L2; else goto _L1
_L1:
        if (flag)
        {
            e.put(i1, true);
        } else
        {
            e.delete(i1);
        }
        if (c != null)
        {
            d.a(c, i1, h.getItemId(i1), flag);
        }
_L4:
        if (k != null)
        {
            k.a();
        }
        requestLayout();
        return;
_L2:
        if (flag || e.get(i1))
        {
            e.clear();
        }
        if (flag)
        {
            e.put(i1, true);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void a(View view, int i1)
    {
        boolean flag2;
        if (b == 0)
        {
            break MISSING_BLOCK_LABEL_191;
        }
        if (b == 2 || b == 3 && c != null)
        {
            boolean flag;
            boolean flag1;
            boolean flag3;
            if (c != null)
            {
                flag = false;
            } else
            {
                flag = true;
            }
            if (!e.get(i1, false))
            {
                flag3 = true;
            } else
            {
                flag3 = false;
            }
            a(i1, flag3);
        } else
        {
label0:
            {
                if (b != 1)
                {
                    break label0;
                }
                if (!e.get(i1, false))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    e.clear();
                    e.put(i1, true);
                }
                flag = true;
            }
        }
        flag1 = true;
        flag2 = flag;
        if (flag1)
        {
            k.a();
            flag2 = flag;
        }
_L2:
        if (flag2 && i != null)
        {
            playSoundEffect(0);
            if (view != null)
            {
                view.sendAccessibilityEvent(1);
            }
            i.a(this, i1);
        }
        return;
        flag1 = false;
        flag = true;
        break MISSING_BLOCK_LABEL_64;
        flag2 = true;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public int getActivatedItemCount()
    {
        return e.size();
    }

    public int getActivatedItemPosition()
    {
        if (b == 1 && e.size() == 1)
        {
            return e.keyAt(0);
        } else
        {
            return -1;
        }
    }

    public SparseBooleanArray getActivatedItemPositions()
    {
        if (b != 0)
        {
            return e;
        } else
        {
            return null;
        }
    }

    public SparseArray getActiveViews()
    {
        return com.wishabi.flipp.widget.j.a(k);
    }

    public ListAdapter getAdapter()
    {
        return h;
    }

    public View getEmptyView()
    {
        return g;
    }

    public n getLayout()
    {
        return f;
    }

    public p getMultiChoiceModeListener()
    {
        return d;
    }

    public r getOnItemClickListener()
    {
        return i;
    }

    public s getOnItemLongClickListener()
    {
        return a;
    }

    public t getOnScrollListener()
    {
        return j;
    }

    protected void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        int i2 = getScrollY();
        super.onLayout(flag, i1, j1, k1, l1);
        if (i2 != getScrollY() && flag)
        {
            requestLayout();
        }
    }

    protected void onScrollChanged(int i1, int j1, int k1, int l1)
    {
        super.onScrollChanged(i1, j1, k1, l1);
        com.wishabi.flipp.widget.j.a(k, j1);
        if (j != null)
        {
            j.a();
        }
    }

    public void requestLayout()
    {
        super.requestLayout();
        if (k != null)
        {
            k.requestLayout();
        }
    }

    public void setAdapter(ListAdapter listadapter)
    {
        if (h == listadapter)
        {
            return;
        }
        h = listadapter;
        j j1 = k;
        if (j1.c != listadapter)
        {
            if (j1.c != null)
            {
                j1.c.unregisterDataSetObserver(j1.f);
            }
            j1.c = listadapter;
            j1.removeAllViews();
            j1.b.clear();
            j1.a.clear();
            if (j1.c != null)
            {
                j1.c.registerDataSetObserver(j1.f);
                int k1 = j1.c.getViewTypeCount();
                for (int i1 = 0; i1 < k1; i1++)
                {
                    j1.b.add(new Stack());
                }

            }
        }
        e.clear();
        c();
    }

    public void setChoiceMode(int i1)
    {
        b = i1;
        if (c != null)
        {
            c.finish();
            c = null;
        }
        if (b == 3)
        {
            e.clear();
            setLongClickable(true);
        }
    }

    public void setEmptyView(View view)
    {
        if (g == view)
        {
            return;
        }
        if (g != null)
        {
            g.setVisibility(8);
        }
        g = view;
        c();
    }

    public void setLayout(n n1)
    {
        if (f == n1)
        {
            return;
        }
        if (f != null)
        {
            f.a = null;
        }
        f = n1;
        f.a = this;
    }

    public void setMultiChoiceModeListener(p p)
    {
        if (d == null)
        {
            d = new q(this, (byte)0);
        }
        d.a = p;
    }

    public void setOnItemClickListener(r r1)
    {
        i = r1;
    }

    public void setOnItemLongClickListener(s s)
    {
        a = s;
    }

    public void setOnScrollListener(t t1)
    {
        j = t1;
    }

    public ActionMode startActionMode(android.view.ActionMode.Callback callback)
    {
        if (b == 3 && c == null)
        {
            c = super.startActionMode(d);
        }
        if (c != null)
        {
            c.invalidate();
        }
        return c;
    }

}
