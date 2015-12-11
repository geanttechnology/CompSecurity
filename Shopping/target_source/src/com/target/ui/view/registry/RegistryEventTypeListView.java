// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.registry;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.target.ui.view.product.FixedHeightListView;
import com.target.ui.view.registry.adapter.RegistryRefineEventSelectorAdapter;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.ui.view.registry:
//            BaseRegistryRefineChildView

public class RegistryEventTypeListView extends BaseRegistryRefineChildView
{
    static class Views extends com.target.ui.view.a
    {

        FixedHeightListView listView;

        Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void a(com.target.ui.model.registry.RegistryRefineModel.RegistryEventLabel registryeventlabel);

        public abstract void b(com.target.ui.model.registry.RegistryRefineModel.RegistryEventLabel registryeventlabel);
    }

    private class b
        implements com.target.ui.view.registry.adapter.RegistryRefineEventSelectorAdapter.a
    {

        final RegistryEventTypeListView this$0;

        public void a(com.target.ui.model.registry.RegistryRefineModel.RegistryEventLabel registryeventlabel)
        {
            if (RegistryEventTypeListView.a(RegistryEventTypeListView.this) == null)
            {
                return;
            } else
            {
                RegistryEventTypeListView.a(RegistryEventTypeListView.this).a(registryeventlabel);
                return;
            }
        }

        public void b(com.target.ui.model.registry.RegistryRefineModel.RegistryEventLabel registryeventlabel)
        {
            if (RegistryEventTypeListView.a(RegistryEventTypeListView.this) == null)
            {
                return;
            } else
            {
                RegistryEventTypeListView.a(RegistryEventTypeListView.this).b(registryeventlabel);
                return;
            }
        }

        private b()
        {
            this$0 = RegistryEventTypeListView.this;
            super();
        }

    }


    private static final String TAG = com/target/ui/view/registry/RegistryEventTypeListView.getSimpleName();
    private RegistryRefineEventSelectorAdapter mAdapter;
    private List mEventOptionsList;
    private a mListener;
    private com.target.ui.model.registry.RegistryRefineModel.RegistryEventLabel mSelectedEventLabel;
    private Views mViews;

    public RegistryEventTypeListView(Context context)
    {
        super(context);
        c();
    }

    public RegistryEventTypeListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        c();
    }

    public RegistryEventTypeListView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        c();
    }

    static a a(RegistryEventTypeListView registryeventtypelistview)
    {
        return registryeventtypelistview.mListener;
    }

    private void c()
    {
        setOrientation(1);
        inflate(getContext(), 0x7f0301d5, this);
        mViews = new Views(this);
        mEventOptionsList = new ArrayList();
        mAdapter = new RegistryRefineEventSelectorAdapter(getContext(), mEventOptionsList);
        mAdapter.a(new b());
        mViews.listView.setAdapter(mAdapter);
    }

    public void a()
    {
        mSelectedEventLabel = null;
        mAdapter.a();
    }

    public void a(List list, com.target.ui.model.registry.RegistryRefineModel.RegistryEventLabel registryeventlabel)
    {
        mEventOptionsList.clear();
        mEventOptionsList.addAll(list);
        mAdapter.a(registryeventlabel);
        mSelectedEventLabel = registryeventlabel;
        mAdapter.notifyDataSetChanged();
    }

    protected boolean b()
    {
        return mSelectedEventLabel != null;
    }

    public View getView()
    {
        return this;
    }

    public void setClickListener(a a1)
    {
        mListener = a1;
    }

}
