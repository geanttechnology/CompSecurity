// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.huewu.pla.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListAdapter;
import com.huewu.pla.a.c;
import com.huewu.pla.lib.internal.PLA_AbsListView;
import com.huewu.pla.lib.internal.PLA_ListView;
import com.huewu.pla.lib.internal.d;

// Referenced classes of package com.huewu.pla.lib:
//            ParcelableSparseIntArray, b, c, d

public class MultiColumnListView extends PLA_ListView
{

    public d a = new d() {

        final MultiColumnListView a;
        private int b;

        public void a(PLA_AbsListView pla_abslistview, int i)
        {
            int j = a.getAdapter().getCount();
            if (i == 0 && b == j - 2 && MultiColumnListView.a(a))
            {
                a.b.a();
                MultiColumnListView.a(a, false);
            }
        }

        public void a(PLA_AbsListView pla_abslistview, int i, int j, int k)
        {
            b = (i + j) - 2;
        }

            
            {
                a = MultiColumnListView.this;
                super();
                b = 0;
            }
    };
    private int ah;
    private b ai[];
    private b aj;
    private ParcelableSparseIntArray ak;
    private int al;
    private int am;
    private Rect an;
    private boolean ao;
    com.huewu.pla.lib.d b;

    public MultiColumnListView(Context context)
    {
        super(context);
        ah = 2;
        ai = null;
        aj = null;
        ak = new ParcelableSparseIntArray();
        al = 0;
        am = 0;
        an = new Rect();
        ao = true;
        b(((AttributeSet) (null)));
    }

    public MultiColumnListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ah = 2;
        ai = null;
        aj = null;
        ak = new ParcelableSparseIntArray();
        al = 0;
        am = 0;
        an = new Rect();
        ao = true;
        b(attributeset);
    }

    public MultiColumnListView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        ah = 2;
        ai = null;
        aj = null;
        ak = new ParcelableSparseIntArray();
        al = 0;
        am = 0;
        an = new Rect();
        ao = true;
        b(attributeset);
    }

    private b a(boolean flag, int i)
    {
        int j = ak.get(i, -1);
        if (j != -1)
        {
            return ai[j];
        }
        i = Math.max(0, Math.max(0, i - getHeaderViewsCount()));
        if (i < ah)
        {
            return ai[i];
        }
        if (flag)
        {
            return gettBottomColumn();
        } else
        {
            return getTopColumn();
        }
    }

    static boolean a(MultiColumnListView multicolumnlistview)
    {
        return multicolumnlistview.ao;
    }

    static boolean a(MultiColumnListView multicolumnlistview, boolean flag)
    {
        multicolumnlistview.ao = flag;
        return flag;
    }

    private void b(AttributeSet attributeset)
    {
        int i;
        i = 0;
        getWindowVisibleDisplayFrame(an);
        if (attributeset != null) goto _L2; else goto _L1
_L1:
        ah = 2;
_L4:
        ai = new b[ah];
        for (; i < ah; i++)
        {
            ai[i] = new b(this, i);
        }

        break MISSING_BLOCK_LABEL_172;
_L2:
        int k;
        attributeset = getContext().obtainStyledAttributes(attributeset, c.PLA_MultiColumnListView);
        int j = attributeset.getInteger(c.PLA_MultiColumnListView_PLA_plaLandscapeColumnNumber, -1);
        k = attributeset.getInteger(c.PLA_MultiColumnListView_PLA_plaColumnNumber, -1);
        if (an.width() <= an.height() || j == -1)
        {
            break; /* Loop/switch isn't completed */
        }
        ah = j;
_L5:
        al = attributeset.getDimensionPixelSize(c.PLA_MultiColumnListView_PLA_plaColumnPaddingLeft, 0);
        am = attributeset.getDimensionPixelSize(c.PLA_MultiColumnListView_PLA_plaColumnPaddingRight, 0);
        attributeset.recycle();
        if (true) goto _L4; else goto _L3
_L3:
        if (k != -1)
        {
            ah = k;
        } else
        {
            ah = 2;
        }
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
        aj = new com.huewu.pla.lib.c(this);
        return;
    }

    private b getTopColumn()
    {
        b b1 = ai[0];
        b ab[] = ai;
        int j = ab.length;
        for (int i = 0; i < j; i++)
        {
            b b2 = ab[i];
            if (b1.e() > b2.e())
            {
                b1 = b2;
            }
        }

        return b1;
    }

    private b gettBottomColumn()
    {
        b b1 = ai[0];
        b ab[] = ai;
        int j = ab.length;
        for (int i = 0; i < j; i++)
        {
            b b2 = ab[i];
            if (b1.d() > b2.d())
            {
                b1 = b2;
            }
        }

        return b1;
    }

    private boolean m(int i)
    {
        return e.getItemViewType(i) == -2;
    }

    private int n(int i)
    {
        i = ak.get(i, -1);
        if (i == -1)
        {
            return 0;
        } else
        {
            return ai[i].a();
        }
    }

    private int o(int i)
    {
        i = ak.get(i, -1);
        if (i == -1)
        {
            return 0;
        } else
        {
            return ai[i].b();
        }
    }

    public void a(int i)
    {
        if (i >= 1 && i != ah)
        {
            ak.clear();
            ah = i;
            ai = new b[i];
            i = 0;
            while (i < ah) 
            {
                ai[i] = new b(this, i);
                i++;
            }
        }
    }

    protected void a(int i, boolean flag)
    {
        super.a(i, flag);
        if (!m(i))
        {
            b b1 = a(flag, i);
            ak.append(i, b1.c());
        }
    }

    protected void a(View view, int i, int j, int k)
    {
        if (d(view))
        {
            view.measure(j, k);
            return;
        } else
        {
            view.measure(0x40000000 | o(i), k);
            return;
        }
    }

    protected void a(boolean flag)
    {
        int i = 0;
        int j = getFirstVisiblePosition();
        if (!flag && j == 0)
        {
            int k = ai[0].e();
            b ab[] = ai;
            for (int l = ab.length; i < l; i++)
            {
                b b1 = ab[i];
                b1.a(k - b1.e());
            }

        }
        super.a(flag);
    }

    protected void b(int i)
    {
        b ab[] = ai;
        int j = ab.length;
        for (i = 0; i < j; i++)
        {
            ab[i].f();
        }

    }

    protected void c(int i)
    {
        b ab[] = ai;
        int j = ab.length;
        for (i = 0; i < j; i++)
        {
            ab[i].g();
        }

    }

    protected int d(int i)
    {
        if (m(i))
        {
            return aj.a();
        } else
        {
            return n(i);
        }
    }

    protected int e(int i)
    {
        if (m(i))
        {
            return aj.d();
        }
        i = ak.get(i, -1);
        if (i == -1)
        {
            return getFillChildBottom();
        } else
        {
            return ai[i].d();
        }
    }

    protected int f(int i)
    {
        if (m(i))
        {
            return aj.e();
        }
        i = ak.get(i, -1);
        if (i == -1)
        {
            return getFillChildTop();
        } else
        {
            return ai[i].e();
        }
    }

    public int getColumnCount()
    {
        return ah;
    }

    protected int getFillChildBottom()
    {
        int i = 0x7fffffff;
        b ab[] = ai;
        int l = ab.length;
        for (int j = 0; j < l; j++)
        {
            int k = ab[j].d();
            if (i > k)
            {
                i = k;
            }
        }

        return i;
    }

    protected int getFillChildTop()
    {
        int j = 0x80000000;
        b ab[] = ai;
        int k = ab.length;
        for (int i = 0; i < k; i++)
        {
            j = Math.max(j, ab[i].e());
        }

        return j;
    }

    protected int getScrollChildBottom()
    {
        int i = 0x80000000;
        b ab[] = ai;
        int l = ab.length;
        for (int j = 0; j < l; j++)
        {
            int k = ab[j].d();
            if (i < k)
            {
                i = k;
            }
        }

        return i;
    }

    protected int getScrollChildTop()
    {
        int i = 0x7fffffff;
        b ab[] = ai;
        int l = ab.length;
        for (int j = 0; j < l; j++)
        {
            int k = ab[j].e();
            if (i > k)
            {
                i = k;
            }
        }

        return i;
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        j = (getMeasuredWidth() - n.left - n.right - al - am) / ah;
        for (i = 0; i < ah; i++)
        {
            com.huewu.pla.lib.b.a(ai[i], j);
            com.huewu.pla.lib.b.b(ai[i], n.left + al + j * i);
        }

        com.huewu.pla.lib.b.b(aj, n.left);
        com.huewu.pla.lib.b.a(aj, getMeasuredWidth());
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        Parcelable parcelable1 = parcelable;
        if (parcelable instanceof Bundle)
        {
            parcelable = (Bundle)parcelable;
            ak = (ParcelableSparseIntArray)parcelable.getParcelable("items");
            parcelable1 = parcelable.getParcelable("instanceState");
        }
        super.onRestoreInstanceState(parcelable1);
    }

    public Parcelable onSaveInstanceState()
    {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putParcelable("items", ak);
        return bundle;
    }

    public void setColumnPaddingLeft(int i)
    {
        al = i;
    }

    public void setColumnPaddingRight(int i)
    {
        am = i;
    }

    public void setOnLoadMoreListener(com.huewu.pla.lib.d d1)
    {
        if (d1 != null)
        {
            b = d1;
            setOnScrollListener(a);
        }
    }
}
