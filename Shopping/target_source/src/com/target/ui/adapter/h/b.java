// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.a.a.e;
import com.target.mothership.model.dvm.interfaces.DvmDataResponse;
import com.target.mothership.model.page_item.interfaces.DigitalVendorMarketing;
import com.target.mothership.model.page_item.interfaces.PageItem;
import com.target.ui.model.shop.a;
import com.target.ui.util.ac;
import com.target.ui.util.q;
import com.target.ui.view.shop.PageItemView;
import com.target.ui.view.shop.ShopDvmView;
import com.target.ui.view.shop.WeeklyAdCardView;
import com.target.ui.view.shop.WeeklyAdView;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class com.target.ui.adapter.h.b extends android.support.v7.widget.RecyclerView.a
{
    private class a
        implements android.view.View.OnClickListener
    {

        final com.target.ui.adapter.h.b this$0;

        public void onClick(View view)
        {
            if (view == null || com.target.ui.adapter.h.b.a(com.target.ui.adapter.h.b.this) == null)
            {
                return;
            } else
            {
                com.target.ui.adapter.h.b.a(com.target.ui.adapter.h.b.this).a((ShopDvmView)view);
                return;
            }
        }

        private a()
        {
            this$0 = com.target.ui.adapter.h.b.this;
            super();
        }

    }

    public static interface b
    {

        public abstract void a(ShopDvmView shopdvmview);
    }

    public static interface c
    {

        public abstract void a(PageItem pageitem, PageItemView pageitemview);
    }

    public static interface d
    {

        public abstract void a(PageItem pageitem, WeeklyAdView weeklyadview, WeeklyAdCardView weeklyadcardview);
    }

    public static class e
    {

        private static final String INVALID_COLUMNS = "The number of columns must be greater than or equal to 1.";
        private static final String INVALID_ITEM_WIDTH = "No item can have a width greater thanthe given number of columns.";
        private static final String TAG = com/target/ui/adapter/h/b$e.getSimpleName();
        private int mColumn;
        private HashSet mFilledLocations;
        private List mFinalItems;
        private List mListReference;
        private int mNumColumns;
        private List mOriginalItems;
        private int mRow;

        private int a(int i, int j)
        {
            return mNumColumns * i + j;
        }

        private List a(List list, int i, int j)
        {
            ArrayList arraylist = new ArrayList();
            list = list.listIterator(i);
            i = 0;
            do
            {
                if (i >= j || !list.hasNext())
                {
                    break;
                }
                com.target.ui.model.shop.a a1 = (com.target.ui.model.shop.a)list.next();
                if (a1.f())
                {
                    arraylist.add(a1);
                    i++;
                }
            } while (true);
            if (arraylist.size() != j)
            {
                q.a(TAG, "There will be gaps in the layout.");
            }
            return arraylist;
        }

        private void a(int i)
        {
            Object obj = a(mOriginalItems, i, 1);
            ArrayList arraylist = new ArrayList();
            if (((List) (obj)).size() == 0)
            {
                mColumn = mColumn + 1;
                if (mColumn >= mNumColumns)
                {
                    mColumn = 0;
                    mRow = mRow + 1;
                }
            } else
            {
                obj = (com.target.ui.model.shop.a)((List) (obj)).get(0);
                if (d(((com.target.ui.model.shop.a) (obj))))
                {
                    ((com.target.ui.model.shop.a) (obj)).c(mColumn);
                    ((com.target.ui.model.shop.a) (obj)).b(mRow);
                    e(((com.target.ui.model.shop.a) (obj)));
                    arraylist.add(obj);
                    i = mColumn;
                    mColumn = ((com.target.ui.model.shop.a) (obj)).e() + i;
                    if (mColumn > mNumColumns)
                    {
                        q.a(TAG, "Overshot the boundary");
                    }
                } else
                {
                    mColumn = mColumn + 1;
                }
                mFinalItems.addAll(arraylist);
                mOriginalItems.removeAll(arraylist);
                if (mColumn >= mNumColumns)
                {
                    mColumn = 0;
                    mRow = mRow + 1;
                    return;
                }
            }
        }

        private void a(com.target.ui.model.shop.a a1)
        {
label0:
            {
                a1.c(mColumn);
                a1.b(mRow);
                e(a1);
                mFinalItems.add(a1);
                mColumn = mColumn + a1.e();
                if (mColumn >= mNumColumns)
                {
                    mColumn = 0;
                    if (a1.e() != mNumColumns)
                    {
                        break label0;
                    }
                    mRow = mRow + a1.b();
                }
                return;
            }
            mRow = mRow + 1;
        }

        private boolean a(com.target.ui.model.shop.a a1, int i)
        {
            if (mColumn != 0)
            {
                b(i);
                return false;
            } else
            {
                return b(a1, i);
            }
        }

        private void b(int i)
        {
            int j = mNumColumns;
            int k = mColumn;
            Object obj = a(mOriginalItems, i, j - k);
            ArrayList arraylist = new ArrayList();
            obj = ((List) (obj)).iterator();
            do
            {
label0:
                {
                    if (((Iterator) (obj)).hasNext())
                    {
                        com.target.ui.model.shop.a a1 = (com.target.ui.model.shop.a)((Iterator) (obj)).next();
                        if (!d(a1))
                        {
                            break label0;
                        }
                        a1.c(mColumn);
                        a1.b(mRow);
                        e(a1);
                        arraylist.add(a1);
                        i = mColumn;
                        mColumn = a1.e() + i;
                        if (mColumn != mNumColumns)
                        {
                            if (mColumn <= mNumColumns)
                            {
                                continue;
                            }
                            q.a(TAG, "Overshot the boundary");
                        }
                    }
                    mFinalItems.addAll(arraylist);
                    mOriginalItems.removeAll(arraylist);
                    mColumn = 0;
                    mRow = mRow + 1;
                    return;
                }
                mColumn = mColumn + 1;
            } while (true);
        }

        private boolean b(com.target.ui.model.shop.a a1)
        {
            boolean flag = false;
            if (d(a1))
            {
                a(a1);
                flag = true;
            } else
            {
                mColumn = mColumn + 1;
                if (mColumn >= mNumColumns)
                {
                    mColumn = 0;
                    mRow = mRow + 1;
                    return false;
                }
            }
            return flag;
        }

        private boolean b(com.target.ui.model.shop.a a1, int i)
        {
            if (d(a1))
            {
                a(a1);
                return true;
            } else
            {
                a(i);
                return false;
            }
        }

        private List c(com.target.ui.model.shop.a a1)
        {
            ArrayList arraylist = new ArrayList();
            for (int i = 0; i < a1.e(); i++)
            {
                for (int j = 0; j < a1.b(); j++)
                {
                    arraylist.add(Integer.valueOf(a(mRow + j, mColumn + i)));
                }

            }

            return arraylist;
        }

        private boolean c(int i)
        {
            return mFilledLocations.contains(Integer.valueOf(i));
        }

        private void d(int i)
        {
            if (i < 1)
            {
                throw new IllegalArgumentException("The number of columns must be greater than or equal to 1.");
            } else
            {
                mNumColumns = i;
                return;
            }
        }

        private boolean d(com.target.ui.model.shop.a a1)
        {
            if (mColumn + a1.e() > mNumColumns)
            {
                return false;
            }
            a1 = c(a1).iterator();
_L4:
            if (!a1.hasNext()) goto _L2; else goto _L1
_L1:
            if (!c(((Integer)a1.next()).intValue())) goto _L4; else goto _L3
_L3:
            boolean flag = false;
_L6:
            return flag;
_L2:
            flag = true;
            if (true) goto _L6; else goto _L5
_L5:
        }

        private void e(com.target.ui.model.shop.a a1)
        {
            Integer integer;
            for (a1 = c(a1).iterator(); a1.hasNext(); mFilledLocations.add(integer))
            {
                integer = (Integer)a1.next();
            }

        }

        public void a()
        {
            int j = 0;
            mRow = 0;
            mColumn = 0;
            mFilledLocations.clear();
            mFinalItems.clear();
            mOriginalItems.clear();
            com.target.ui.model.shop.a a2;
            for (Iterator iterator = mListReference.iterator(); iterator.hasNext(); mOriginalItems.add(a2))
            {
                a2 = (com.target.ui.model.shop.a)iterator.next();
            }

            if (mOriginalItems.isEmpty())
            {
                return;
            }
            for (Iterator iterator1 = mOriginalItems.iterator(); iterator1.hasNext();)
            {
                if (((com.target.ui.model.shop.a)iterator1.next()).e() > mNumColumns)
                {
                    throw new IllegalArgumentException("No item can have a width greater thanthe given number of columns.");
                }
            }

            a((com.target.ui.model.shop.a)mOriginalItems.get(0));
            int k = mOriginalItems.size();
            int i = 1;
            while (mFinalItems.size() < k && j < 10000) 
            {
                com.target.ui.model.shop.a a1 = (com.target.ui.model.shop.a)mOriginalItems.get(i);
                boolean flag;
                if (a1.e() == mNumColumns)
                {
                    flag = a(a1, i);
                } else
                if (a1.g())
                {
                    flag = b(a1, i);
                } else
                {
                    flag = b(a1);
                }
                if (flag)
                {
                    i++;
                }
                j++;
            }
            if (j >= 10000)
            {
                q.a(TAG, "Iterations exceeded. There is a likely a problem with the initial setup of the data.");
            }
            mListReference.clear();
            com.target.ui.model.shop.a a3;
            for (Iterator iterator2 = mFinalItems.iterator(); iterator2.hasNext(); mListReference.add(a3))
            {
                a3 = (com.target.ui.model.shop.a)iterator2.next();
            }

            mFilledLocations.clear();
            mFinalItems.clear();
            mOriginalItems.clear();
        }


        public e(List list, int i)
        {
            mColumn = 0;
            mRow = 0;
            mFilledLocations = new HashSet();
            mFinalItems = new ArrayList();
            mOriginalItems = new ArrayList();
            mListReference = list;
            mNumColumns = i;
            d(i);
        }
    }

    public static class f extends android.support.v7.widget.RecyclerView.t
    {

        public f(View view)
        {
            super(view);
        }
    }


    private static final int BASE_DVM_ITEM_TYPE = 3;
    private static final String INVALID_COLUMNS = "The number of columns must be greater than or equal to 1.";
    private static final int PAGE_ITEM_TYPE = 1;
    private static final int WEEKLY_AD_ITEM_TYPE = 2;
    private int mColumns;
    private b mDvmClickListener;
    private DvmDataResponse mDvmDataResponse;
    private Integer mFooterHeight;
    private c mListener;
    private List mPageItemElements;
    private boolean mShouldUseCustomWeeklyAdTile;
    private d mWeeklyAdCardViewListener;
    private List mWeeklyAdData;

    public com.target.ui.adapter.h.b(List list, int i)
    {
        mShouldUseCustomWeeklyAdTile = false;
        mPageItemElements = list;
        f(i);
    }

    static b a(com.target.ui.adapter.h.b b1)
    {
        return b1.mDvmClickListener;
    }

    static c b(com.target.ui.adapter.h.b b1)
    {
        return b1.mListener;
    }

    static d c(com.target.ui.adapter.h.b b1)
    {
        return b1.mWeeklyAdCardViewListener;
    }

    private void f(int i)
    {
        if (i < 1)
        {
            throw new IllegalArgumentException("The number of columns must be greater than or equal to 1.");
        } else
        {
            mColumns = i;
            return;
        }
    }

    public int a()
    {
        return mPageItemElements.size();
    }

    public int a(int i)
    {
        PageItem pageitem = ((com.target.ui.model.shop.a)mPageItemElements.get(i)).a();
        if (pageitem.e().b())
        {
            return i + 3;
        }
        return !pageitem.k().b() || !mShouldUseCustomWeeklyAdTile ? 1 : 2;
    }

    public android.support.v7.widget.RecyclerView.t a(ViewGroup viewgroup, int i)
    {
        return c(viewgroup, i);
    }

    public volatile void a(android.support.v7.widget.RecyclerView.t t, int i)
    {
        a((f)t, i);
    }

    public void a(b b1)
    {
        mDvmClickListener = b1;
    }

    public void a(c c1)
    {
        mListener = c1;
    }

    public void a(d d1)
    {
        mWeeklyAdCardViewListener = d1;
    }

    public void a(final f pageItemView, int i)
    {
        final com.target.ui.model.shop.a element = (com.target.ui.model.shop.a)mPageItemElements.get(i);
        i = a(i);
        if (i == 1)
        {
            pageItemView = (PageItemView)pageItemView.itemView;
            pageItemView.setPageItemElement(element);
            pageItemView.setOnClickListener(new android.view.View.OnClickListener() {

                final com.target.ui.adapter.h.b this$0;
                final com.target.ui.model.shop.a val$element;
                final PageItemView val$pageItemView;

                public void onClick(View view)
                {
                    if (com.target.ui.adapter.h.b.b(com.target.ui.adapter.h.b.this) == null)
                    {
                        return;
                    } else
                    {
                        com.target.ui.adapter.h.b.b(com.target.ui.adapter.h.b.this).a(element.a(), pageItemView);
                        return;
                    }
                }

            
            {
                this$0 = com.target.ui.adapter.h.b.this;
                element = a1;
                pageItemView = pageitemview;
                super();
            }
            });
        } else
        {
            if (i == 2)
            {
                pageItemView = (WeeklyAdView)pageItemView.itemView;
                pageItemView.setWeeklyAdData(mWeeklyAdData);
                pageItemView.setPageItemElement(element);
                pageItemView.setOnWeeklyAdCardViewClickListener(new com.target.ui.view.shop.WeeklyAdView.b() {

                    final com.target.ui.adapter.h.b this$0;
                    final com.target.ui.model.shop.a val$element;
                    final WeeklyAdView val$weeklyAdView;

                    public void a(WeeklyAdCardView weeklyadcardview)
                    {
                        if (com.target.ui.adapter.h.b.c(com.target.ui.adapter.h.b.this) == null)
                        {
                            return;
                        } else
                        {
                            com.target.ui.adapter.h.b.c(com.target.ui.adapter.h.b.this).a(element.a(), weeklyAdView, weeklyadcardview);
                            return;
                        }
                    }

            
            {
                this$0 = com.target.ui.adapter.h.b.this;
                element = a1;
                weeklyAdView = weeklyadview;
                super();
            }
                });
                return;
            }
            if (i >= 3)
            {
                pageItemView = (ShopDvmView)pageItemView.itemView;
                pageItemView.setDvmContent(mDvmDataResponse);
                pageItemView.setOnClickListener(new a());
                if (!pageItemView.b())
                {
                    pageItemView.setPageItemElement(element);
                    return;
                }
            }
        }
    }

    public void a(URL url, DvmDataResponse dvmdataresponse)
    {
        mDvmDataResponse = dvmdataresponse;
        dvmdataresponse = mPageItemElements.iterator();
        do
        {
            if (!dvmdataresponse.hasNext())
            {
                break;
            }
            com.target.ui.model.shop.a a1 = (com.target.ui.model.shop.a)dvmdataresponse.next();
            if (a1.a().e().b() && ((DigitalVendorMarketing)a1.a().e().c()).a().equals(url.toString()))
            {
                c(mPageItemElements.indexOf(a1));
            }
        } while (true);
    }

    public void a(List list)
    {
        if (mShouldUseCustomWeeklyAdTile) goto _L2; else goto _L1
_L1:
        return;
_L2:
        com.target.ui.model.shop.a a1;
        mWeeklyAdData = list;
        list = mPageItemElements.iterator();
        do
        {
            if (!list.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            a1 = (com.target.ui.model.shop.a)list.next();
        } while (!a1.a().k().b());
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
        c(mPageItemElements.indexOf(a1));
        return;
    }

    public void b(boolean flag)
    {
        mShouldUseCustomWeeklyAdTile = flag;
    }

    public f c(ViewGroup viewgroup, int i)
    {
        View view;
        Object obj;
        if (mFooterHeight == null)
        {
            mFooterHeight = Integer.valueOf(ac.d(viewgroup.getContext()));
        }
        obj = LayoutInflater.from(viewgroup.getContext());
        view = null;
        if (i != 1) goto _L2; else goto _L1
_L1:
        view = ((LayoutInflater) (obj)).inflate(0x7f03017c, viewgroup, false);
        ((PageItemView)view).setFooterHeight(mFooterHeight.intValue());
_L4:
        return new f(view);
_L2:
        if (i == 2)
        {
            view = ((LayoutInflater) (obj)).inflate(0x7f03017f, viewgroup, false);
            obj = (WeeklyAdView)view;
            ((WeeklyAdView) (obj)).setFooterHeight(mFooterHeight.intValue());
            ((WeeklyAdView) (obj)).a(viewgroup.getParent());
        } else
        if (i >= 3)
        {
            view = ((LayoutInflater) (obj)).inflate(0x7f03015a, viewgroup, false);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void e()
    {
        (new e(mPageItemElements, mColumns)).a();
        d();
    }
}
