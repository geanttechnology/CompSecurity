// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.registry;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.target.ui.view.product.FixedHeightListView;
import com.target.ui.view.registry.adapter.RegistryRefineSortSelectorAdapter;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.ui.view.registry:
//            BaseRegistryRefineChildView

public class RegistrySortListView extends BaseRegistryRefineChildView
{
    static class Views extends com.target.ui.view.a
    {

        FixedHeightListView listView;

        Views(View view)
        {
            super(view);
        }
    }

    private class a
        implements com.target.ui.view.registry.adapter.RegistryRefineSortSelectorAdapter.a
    {

        final RegistrySortListView this$0;

        public void a(com.target.ui.model.registry.RegistryRefineModel.RegistrySortLabel registrysortlabel)
        {
            if (RegistrySortListView.a(RegistrySortListView.this) == null)
            {
                return;
            } else
            {
                RegistrySortListView.a(RegistrySortListView.this).a(registrysortlabel);
                return;
            }
        }

        public void b(com.target.ui.model.registry.RegistryRefineModel.RegistrySortLabel registrysortlabel)
        {
            if (RegistrySortListView.a(RegistrySortListView.this) == null)
            {
                return;
            } else
            {
                RegistrySortListView.a(RegistrySortListView.this).b(registrysortlabel);
                return;
            }
        }

        private a()
        {
            this$0 = RegistrySortListView.this;
            super();
        }

    }

    public static interface b
    {

        public abstract void a(com.target.ui.model.registry.RegistryRefineModel.RegistrySortLabel registrysortlabel);

        public abstract void b(com.target.ui.model.registry.RegistryRefineModel.RegistrySortLabel registrysortlabel);
    }


    private static final String TAG = com/target/ui/view/registry/RegistrySortListView.getSimpleName();
    private RegistryRefineSortSelectorAdapter mAdapter;
    private b mListener;
    private com.target.ui.model.registry.RegistryRefineModel.RegistrySortLabel mSelectedSortLabel;
    private List mSortingOptionsList;
    private Views mViews;

    public RegistrySortListView(Context context)
    {
        super(context);
        c();
    }

    public RegistrySortListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        c();
    }

    public RegistrySortListView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        c();
    }

    static b a(RegistrySortListView registrysortlistview)
    {
        return registrysortlistview.mListener;
    }

    private void c()
    {
        setOrientation(1);
        inflate(getContext(), 0x7f0301dd, this);
        mViews = new Views(this);
        mSortingOptionsList = new ArrayList();
        mAdapter = new RegistryRefineSortSelectorAdapter(getContext(), mSortingOptionsList);
        mAdapter.a(new a());
        mViews.listView.setAdapter(mAdapter);
    }

    public void a()
    {
        mSelectedSortLabel = null;
        mAdapter.a();
    }

    public void a(List list, com.target.ui.model.registry.RegistryRefineModel.RegistrySortLabel registrysortlabel)
    {
        mSortingOptionsList.clear();
        mSortingOptionsList.addAll(list);
        mSelectedSortLabel = registrysortlabel;
        mAdapter.a(registrysortlabel);
        mAdapter.notifyDataSetChanged();
    }

    protected boolean b()
    {
        return mSelectedSortLabel != null;
    }

    public View getView()
    {
        return this;
    }

    public void setClickListener(b b1)
    {
        mListener = b1;
    }

}
