// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.store;

import android.content.Context;
import android.location.Location;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.a.a.e;
import com.google.android.gms.common.ConnectionResult;
import com.target.mothership.cache.j;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.c.c;
import com.target.mothership.model.d;
import com.target.mothership.model.h;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;
import com.target.mothership.model.store.interfaces.StoreSummary;
import com.target.mothership.services.g;
import com.target.mothership.services.x;
import com.target.ui.adapter.i.a;
import com.target.ui.service.k;
import com.target.ui.util.ai;
import com.target.ui.util.al;
import com.target.ui.util.p;
import com.target.ui.view.ZipCodeChooserView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StoreChooserSelectionView extends RelativeLayout
    implements com.target.mothership.cache.j.a, com.target.mothership.services.g.d, com.target.ui.adapter.i.a.a, com.target.ui.view.ZipCodeChooserView.d
{
    public static interface a
    {

        public abstract void a();

        public abstract void a(StoreIdentifier storeidentifier);

        public abstract void a(StoreSummary storesummary);

        public abstract void b();

        public abstract void c();
    }

    private static class b
    {

        TextView errorMessage;
        ListView listView;
        View locationPendingWarning;
        View storesUpdatingWarning;
        ZipCodeChooserView zipCodeChooser;

        public b(View view)
        {
            listView = (ListView)view.findViewById(0x7f100320);
            errorMessage = (TextView)view.findViewById(0x7f1005bd);
            locationPendingWarning = view.findViewById(0x7f1005bb);
            storesUpdatingWarning = view.findViewById(0x7f1005bc);
            zipCodeChooser = (ZipCodeChooserView)view.findViewById(0x7f100321);
        }
    }


    private static final int MAX_STORES = 7;
    private static final String TAG = com/target/ui/view/store/StoreChooserSelectionView.getSimpleName();
    private com.target.ui.adapter.i.a mAdapter;
    private boolean mIsZipSearch;
    private a mListener;
    private c mLocationManager;
    private StoreSummary mSelectedStore;
    private ArrayList mStores;
    private b mViews;

    public StoreChooserSelectionView(Context context)
    {
        super(context);
        mStores = new ArrayList();
        c();
    }

    public StoreChooserSelectionView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mStores = new ArrayList();
        c();
    }

    public StoreChooserSelectionView(Context context, AttributeSet attributeset, int l)
    {
        super(context, attributeset, l);
        mStores = new ArrayList();
        c();
    }

    static b a(StoreChooserSelectionView storechooserselectionview)
    {
        return storechooserselectionview.mViews;
    }

    private void a(double d1, double d2)
    {
        if (mListener != null)
        {
            mListener.b();
        }
        k.a().a(d1, d2, 7, new h() {

            final StoreChooserSelectionView this$0;

            public void a(x x1)
            {
                if (com.target.ui.view.store.StoreChooserSelectionView.a(StoreChooserSelectionView.this) == null)
                {
                    return;
                } else
                {
                    StoreChooserSelectionView.b(StoreChooserSelectionView.this);
                    return;
                }
            }

            public volatile void a(Object obj)
            {
                a((List)obj);
            }

            public void a(List list)
            {
                if (com.target.ui.view.store.StoreChooserSelectionView.a(StoreChooserSelectionView.this) == null)
                {
                    return;
                } else
                {
                    com.target.ui.view.store.StoreChooserSelectionView.a(StoreChooserSelectionView.this, list);
                    return;
                }
            }

            public void b(Object obj)
            {
                a((x)obj);
            }

            
            {
                this$0 = StoreChooserSelectionView.this;
                super();
            }
        });
    }

    private void a(int l)
    {
        al.a(mViews.errorMessage, new View[] {
            mViews.listView, mViews.locationPendingWarning
        });
        mViews.errorMessage.setText(getContext().getString(l));
    }

    static void a(StoreChooserSelectionView storechooserselectionview, double d1, double d2)
    {
        storechooserselectionview.a(d1, d2);
    }

    static void a(StoreChooserSelectionView storechooserselectionview, int l)
    {
        storechooserselectionview.a(l);
    }

    static void a(StoreChooserSelectionView storechooserselectionview, List list)
    {
        storechooserselectionview.a(list);
    }

    static void a(StoreChooserSelectionView storechooserselectionview, boolean flag)
    {
        storechooserselectionview.a(flag);
    }

    private void a(List list)
    {
        Iterator iterator;
        h();
        if (list == null)
        {
            return;
        }
        iterator = list.iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        if (!((RelevantStoreSummary)iterator.next()).c()) goto _L4; else goto _L3
_L3:
        boolean flag = true;
_L6:
        mStores.clear();
        mAdapter.a(flag);
        if (list.isEmpty())
        {
            if (mIsZipSearch)
            {
                a(0x7f090536);
            }
        } else
        {
            mStores.addAll(list);
        }
        mAdapter.notifyDataSetChanged();
        return;
_L2:
        flag = false;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void a(boolean flag)
    {
        al.a(mViews.locationPendingWarning, flag);
        ListView listview = mViews.listView;
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        al.a(listview, flag);
        al.a(mViews.errorMessage, false);
    }

    static void b(StoreChooserSelectionView storechooserselectionview)
    {
        storechooserselectionview.e();
    }

    private void b(String s)
    {
        if (mListener != null)
        {
            mListener.b();
        }
        mLocationManager.a(s, new d() {

            final StoreChooserSelectionView this$0;

            public void a(com.target.mothership.model.c.c.a.a a1)
            {
                if (com.target.ui.view.store.StoreChooserSelectionView.a(StoreChooserSelectionView.this) == null)
                {
                    return;
                }
                if (com.target.ui.view.store.StoreChooserSelectionView.c(StoreChooserSelectionView.this) != null)
                {
                    com.target.ui.view.store.StoreChooserSelectionView.c(StoreChooserSelectionView.this).c();
                }
                com.target.ui.view.store.StoreChooserSelectionView.a(StoreChooserSelectionView.this, 0x7f090518);
            }

            public void a(com.target.mothership.model.c.c.a a1)
            {
                if (com.target.ui.view.store.StoreChooserSelectionView.a(StoreChooserSelectionView.this) == null)
                {
                    return;
                }
                if (a1.d().b() && a1.e().b())
                {
                    com.target.ui.view.store.StoreChooserSelectionView.a(StoreChooserSelectionView.this, ((Double)a1.d().c()).doubleValue(), ((Double)a1.e().c()).doubleValue());
                    return;
                }
                if (com.target.ui.view.store.StoreChooserSelectionView.c(StoreChooserSelectionView.this) != null)
                {
                    com.target.ui.view.store.StoreChooserSelectionView.c(StoreChooserSelectionView.this).c();
                }
                com.target.ui.view.store.StoreChooserSelectionView.a(StoreChooserSelectionView.this, 0x7f090518);
            }

            public volatile void a(Object obj)
            {
                a((com.target.mothership.model.c.c.a)obj);
            }

            public void b(Object obj)
            {
                a((com.target.mothership.model.c.c.a.a)obj);
            }

            
            {
                this$0 = StoreChooserSelectionView.this;
                super();
            }
        });
    }

    private void b(boolean flag)
    {
        boolean flag2 = true;
        al.a(mViews.storesUpdatingWarning, flag);
        Object obj = mViews.listView;
        boolean flag1;
        if (!flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        al.a(((View) (obj)), flag1);
        obj = mViews.zipCodeChooser;
        if (!flag)
        {
            flag = flag2;
        } else
        {
            flag = false;
        }
        ((ZipCodeChooserView) (obj)).setEnabled(flag);
        al.a(mViews.errorMessage, false);
    }

    static a c(StoreChooserSelectionView storechooserselectionview)
    {
        return storechooserselectionview.mListener;
    }

    private void c()
    {
        inflate(getContext(), 0x7f0301f7, this);
        mViews = new b(this);
        mLocationManager = new c();
        f();
        g();
    }

    private void d()
    {
        k.a().a(7, new com.target.ui.service.k.d() {

            final StoreChooserSelectionView this$0;

            public void a(com.target.ui.service.k.a a1, x x)
            {
                if (com.target.ui.view.store.StoreChooserSelectionView.a(StoreChooserSelectionView.this) != null)
                {
                    if (a1 == com.target.ui.service.k.a.NO_RELEVANT_STORES)
                    {
                        if (p.a(getContext()) && com.target.mothership.services.g.a().b() == null)
                        {
                            com.target.ui.view.store.StoreChooserSelectionView.a(StoreChooserSelectionView.this, true);
                            com.target.mothership.services.g.a().a(StoreChooserSelectionView.this);
                            return;
                        }
                    } else
                    {
                        StoreChooserSelectionView.b(StoreChooserSelectionView.this);
                        return;
                    }
                }
            }

            public void a(List list)
            {
                if (com.target.ui.view.store.StoreChooserSelectionView.a(StoreChooserSelectionView.this) == null)
                {
                    return;
                } else
                {
                    com.target.ui.view.store.StoreChooserSelectionView.a(StoreChooserSelectionView.this, list);
                    return;
                }
            }

            public void onResult(Object obj)
            {
                a((List)obj);
            }

            
            {
                this$0 = StoreChooserSelectionView.this;
                super();
            }
        });
    }

    private void e()
    {
        ai.a(getContext(), 0x7f0904c7);
    }

    private void f()
    {
        mAdapter = new com.target.ui.adapter.i.a(getContext(), mStores, this);
        mViews.listView.setAdapter(mAdapter);
    }

    private void g()
    {
        mViews.zipCodeChooser.setZipCodeListener(this);
    }

    private void h()
    {
        if (mListener != null)
        {
            mListener.c();
        }
        al.a(mViews.listView, new View[] {
            mViews.locationPendingWarning, mViews.errorMessage
        });
    }

    private void i()
    {
        j.getInstance().removeListener(this);
        if (!mIsZipSearch)
        {
            b(false);
            d();
        }
    }

    public void a()
    {
        mSelectedStore = null;
        if (mListener != null)
        {
            mListener.a();
        }
    }

    public void a(Location location)
    {
        com.target.mothership.services.g.a().b(this);
        while (mViews == null || mIsZipSearch) 
        {
            return;
        }
        a(false);
        d();
    }

    public void a(ConnectionResult connectionresult)
    {
        com.target.mothership.services.g.a().b(this);
    }

    public void a(StoreIdentifier storeidentifier)
    {
        if (mListener != null)
        {
            mListener.a(storeidentifier);
        }
    }

    public void a(StoreSummary storesummary)
    {
        mSelectedStore = storesummary;
        if (mListener != null)
        {
            mListener.a(mSelectedStore);
        }
    }

    public void a(String s)
    {
        mIsZipSearch = true;
        b(s);
    }

    public void b()
    {
        if (!j.getInstance().isUpdated())
        {
            b(true);
            j.getInstance().addListener(this);
            return;
        } else
        {
            d();
            return;
        }
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        com.target.mothership.services.g.a().b(this);
        j.getInstance().removeListener(this);
        mViews = null;
    }

    public void onStoreDatabaseUpdateFailed()
    {
        if (mViews == null)
        {
            return;
        } else
        {
            i();
            return;
        }
    }

    public void onStoreDatabaseUpdated()
    {
        if (mViews == null)
        {
            return;
        } else
        {
            i();
            return;
        }
    }

    public void setListener(a a1)
    {
        mListener = a1;
    }

}
