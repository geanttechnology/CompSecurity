// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.navigation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;
import com.target.ui.util.al;

// Referenced classes of package com.target.ui.view.navigation:
//            NavigationStoreView

public class NavigationStoreSelectionView extends FrameLayout
{
    static class Views extends com.target.ui.view.a
    {

        NavigationStoreView currentStore;
        View editStore;

        Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void a(RelevantStoreSummary relevantstoresummary);

        public abstract void e();
    }


    public static final String TAG = com/target/ui/view/navigation/NavigationStoreSelectionView.getSimpleName();
    private RelevantStoreSummary mCurrentStore;
    private a mListener;
    private Views mViews;

    public NavigationStoreSelectionView(Context context)
    {
        super(context);
        a();
    }

    public NavigationStoreSelectionView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public NavigationStoreSelectionView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a();
    }

    static a a(NavigationStoreSelectionView navigationstoreselectionview)
    {
        return navigationstoreselectionview.mListener;
    }

    private void a()
    {
        inflate(getContext(), 0x7f030175, this);
        mViews = new Views(this);
        b();
        c();
    }

    static RelevantStoreSummary b(NavigationStoreSelectionView navigationstoreselectionview)
    {
        return navigationstoreselectionview.mCurrentStore;
    }

    private void b()
    {
        mViews.currentStore.setOnClickListener(new android.view.View.OnClickListener() {

            final NavigationStoreSelectionView this$0;

            public void onClick(View view)
            {
                if (NavigationStoreSelectionView.a(NavigationStoreSelectionView.this) == null)
                {
                    return;
                }
                if (NavigationStoreSelectionView.b(NavigationStoreSelectionView.this) != null)
                {
                    NavigationStoreSelectionView.a(NavigationStoreSelectionView.this).a(NavigationStoreSelectionView.b(NavigationStoreSelectionView.this));
                    return;
                } else
                {
                    NavigationStoreSelectionView.a(NavigationStoreSelectionView.this).e();
                    return;
                }
            }

            
            {
                this$0 = NavigationStoreSelectionView.this;
                super();
            }
        });
        setCurrentStore(null);
    }

    private void c()
    {
        mViews.editStore.setOnClickListener(new android.view.View.OnClickListener() {

            final NavigationStoreSelectionView this$0;

            public void onClick(View view)
            {
                if (NavigationStoreSelectionView.a(NavigationStoreSelectionView.this) == null)
                {
                    return;
                } else
                {
                    NavigationStoreSelectionView.a(NavigationStoreSelectionView.this).e();
                    return;
                }
            }

            
            {
                this$0 = NavigationStoreSelectionView.this;
                super();
            }
        });
    }

    public void setCurrentStore(RelevantStoreSummary relevantstoresummary)
    {
        mCurrentStore = relevantstoresummary;
        mViews.currentStore.setStore(relevantstoresummary);
        relevantstoresummary = mViews.editStore;
        boolean flag;
        if (mCurrentStore != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        al.a(relevantstoresummary, flag);
    }

    public void setListener(a a1)
    {
        mListener = a1;
    }

}
