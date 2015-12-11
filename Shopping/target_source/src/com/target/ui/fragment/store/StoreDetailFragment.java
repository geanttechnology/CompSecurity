// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.store;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.h;
import com.target.mothership.model.store.c;
import com.target.mothership.model.store.interfaces.StoreCapability;
import com.target.mothership.model.store.interfaces.StoreDetail;
import com.target.mothership.services.x;
import com.target.ui.fragment.common.BaseNavigationFragment;
import com.target.ui.util.al;
import com.target.ui.view.store.StoreDetailView;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.store:
//            StoreHoursDialogFragment

public class StoreDetailFragment extends BaseNavigationFragment
{

    private static final String KEY_STORE_ID = "storeId";
    private View mProgress;
    private StoreDetailView mStoreDetailView;
    private StoreIdentifier mStoreId;
    private c mStoreManager;

    public StoreDetailFragment()
    {
        mStoreManager = new c();
    }

    public static StoreDetailFragment a(StoreIdentifier storeidentifier)
    {
        StoreDetailFragment storedetailfragment = new StoreDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("storeId", storeidentifier);
        storedetailfragment.setArguments(bundle);
        return storedetailfragment;
    }

    static StoreDetailView a(StoreDetailFragment storedetailfragment)
    {
        return storedetailfragment.mStoreDetailView;
    }

    private void a()
    {
        a(true);
        mStoreManager.a(mStoreId, new h() {

            final StoreDetailFragment this$0;

            public void a(StoreDetail storedetail)
            {
                if (StoreDetailFragment.a(StoreDetailFragment.this) == null)
                {
                    return;
                } else
                {
                    StoreDetailFragment.a(StoreDetailFragment.this, false);
                    StoreDetailFragment.a(StoreDetailFragment.this).a(storedetail);
                    StoreDetailFragment.a(StoreDetailFragment.this).setDetailsClickedListener(storedetail. new com.target.ui.view.store.StoreDetailHeaderView.a() {

                        final _cls1 this$1;
                        final StoreDetail val$response;

                        public void a()
                        {
                            if (Z())
                            {
                                return;
                            } else
                            {
                                StoreHoursDialogFragment.a(response).show(getFragmentManager(), StoreHoursDialogFragment.TAG);
                                return;
                            }
                        }

            
            {
                this$1 = final__pcls1;
                response = StoreDetail.this;
                super();
            }
                    });
                    StoreDetailFragment.a(StoreDetailFragment.this).setStoreCapabilityClickedListener(new com.target.ui.view.store.StoreDetailView.a() {

                        final _cls1 this$1;

                        public void a(StoreCapability storecapability)
                        {
                            while (Z() || storecapability.b().isEmpty() && storecapability.c().isEmpty()) 
                            {
                                return;
                            }
                            StoreHoursDialogFragment.a(storecapability).show(getFragmentManager(), StoreHoursDialogFragment.TAG);
                        }

            
            {
                this$1 = _cls1.this;
                super();
            }
                    });
                    return;
                }
            }

            public void a(x x1)
            {
            }

            public volatile void a(Object obj)
            {
                a((StoreDetail)obj);
            }

            public void b(Object obj)
            {
                a((x)obj);
            }

            
            {
                this$0 = StoreDetailFragment.this;
                super();
            }
        });
    }

    static void a(StoreDetailFragment storedetailfragment, boolean flag)
    {
        storedetailfragment.a(flag);
    }

    private void a(boolean flag)
    {
        if (flag)
        {
            al.a(mProgress, new View[] {
                mStoreDetailView
            });
            return;
        } else
        {
            al.a(mStoreDetailView, new View[] {
                mProgress
            });
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mStoreId = (StoreIdentifier)getArguments().getParcelable("storeId");
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        if (!isAdded())
        {
            return;
        } else
        {
            super.onCreateOptionsMenu(menu, menuinflater);
            j(getString(0x7f09050d));
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030088, viewgroup, false);
        mStoreDetailView = (StoreDetailView)layoutinflater.findViewById(0x7f10021f);
        mProgress = layoutinflater.findViewById(0x7f100171);
        a();
        return layoutinflater;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        mStoreDetailView = null;
    }
}
