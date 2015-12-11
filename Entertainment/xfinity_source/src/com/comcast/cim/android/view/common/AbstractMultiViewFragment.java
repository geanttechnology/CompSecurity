// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.common;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.comcast.cim.android.accessibility.AlternateInterfaceListener;
import com.comcast.cim.android.view.launch.AuthenticatingFragment;
import com.comcast.cim.cmasl.android.util.system.InternetConnection;
import com.comcast.cim.cmasl.android.util.view.widget.DefaultLoadingViewDelegate;
import com.comcast.cim.cmasl.android.util.view.widget.LoadingIndicator;
import com.comcast.cim.cmasl.android.util.view.widget.ObservableScrollView;
import com.comcast.cim.cmasl.android.util.view.widget.OnObservableScrollChangedListener;
import com.comcast.cim.container.CALContainer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractMultiViewFragment extends AuthenticatingFragment
{
    protected class AdapterViewInfo
    {

        public final com.comcast.cim.cmasl.android.util.view.widget.EntityGridView.EntityGridViewAdapter adapter;
        final AbstractMultiViewFragment this$0;
        public ViewGroup view;

        public AdapterViewInfo(com.comcast.cim.cmasl.android.util.view.widget.EntityGridView.EntityGridViewAdapter entitygridviewadapter)
        {
            this$0 = AbstractMultiViewFragment.this;
            super();
            adapter = entitygridviewadapter;
        }
    }

    private class ShadowImageScrollChangedListener
        implements OnObservableScrollChangedListener
    {

        final AbstractMultiViewFragment this$0;

        public void onObservableScrollChanged(ObservableScrollView observablescrollview, int i, int j, int k, int l)
        {
label0:
            {
                if (shadowImage != null)
                {
                    if (j != 0)
                    {
                        break label0;
                    }
                    shadowImage.setVisibility(8);
                }
                return;
            }
            shadowImage.setVisibility(0);
        }

        private ShadowImageScrollChangedListener()
        {
            this$0 = AbstractMultiViewFragment.this;
            super();
        }

    }


    private static final Logger LOG = LoggerFactory.getLogger(com/comcast/cim/android/view/common/AbstractMultiViewFragment);
    protected AlternateInterfaceListener alternateInterfaceListener;
    protected ViewGroup bodyContainer;
    protected Map infoMap;
    private final InternetConnection internetConnection = CALContainer.getInstance().getInternetConnection();
    private LayoutInflater layoutInflator;
    private DefaultLoadingViewDelegate loadingViewDelegate;
    protected ImageView shadowImage;

    public AbstractMultiViewFragment()
    {
        alternateInterfaceListener = null;
    }

    protected abstract Map getInfoMap(LayoutInflater layoutinflater);

    protected abstract int getLayoutId();

    public DefaultLoadingViewDelegate getLoadingViewDelegate()
    {
        return loadingViewDelegate;
    }

    protected abstract int getShadowImageId();

    protected abstract void initInfoView(int i, AdapterViewInfo adapterviewinfo);

    protected void initInfoViews()
    {
        infoMap = getInfoMap(layoutInflator);
        if (infoMap != null)
        {
            java.util.Map.Entry entry;
            AdapterViewInfo adapterviewinfo;
            for (Iterator iterator = infoMap.entrySet().iterator(); iterator.hasNext(); initInfoView(((Integer)entry.getKey()).intValue(), adapterviewinfo))
            {
                entry = (java.util.Map.Entry)iterator.next();
                adapterviewinfo = (AdapterViewInfo)entry.getValue();
            }

        }
    }

    protected abstract void loadResources();

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        alternateInterfaceListener = (AlternateInterfaceListener)activity;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        viewgroup = (ViewGroup)layoutinflater.inflate(getLayoutId(), viewgroup, false);
        bodyContainer = (ViewGroup)viewgroup.findViewById(com.comcast.cim.android.R.id.body_container);
        int i = getShadowImageId();
        if (i != 0)
        {
            shadowImage = (ImageView)viewgroup.findViewById(i);
            ((ObservableScrollView)bodyContainer).setOnObservableScrollChangedListener(new ShadowImageScrollChangedListener());
        }
        layoutInflator = layoutinflater;
        setupLoadingViewDelegate(viewgroup);
        return viewgroup;
    }

    public void onDestroyView()
    {
        if (bodyContainer instanceof ObservableScrollView)
        {
            ((ObservableScrollView)bodyContainer).setOnObservableScrollChangedListener(null);
        }
        super.onDestroyView();
    }

    public void onStartInternal()
    {
        super.onStartInternal();
        loadingViewDelegate.onStart();
    }

    public void onStop()
    {
        super.onStop();
        loadingViewDelegate.onStop();
    }

    protected void setupLoadingViewDelegate(ViewGroup viewgroup)
    {
        ViewGroup viewgroup1 = (ViewGroup)viewgroup.findViewById(com.comcast.cim.android.R.id.body_container);
        viewgroup = (LoadingIndicator)viewgroup.findViewById(com.comcast.cim.android.R.id.loading_indicator);
        loadingViewDelegate = new DefaultLoadingViewDelegate(getActivity(), viewgroup1, viewgroup, internetConnection, new com.comcast.cim.cmasl.android.util.view.widget.DefaultLoadingViewDelegate.ReadyListener() {

            final AbstractMultiViewFragment this$0;

            public void onReady()
            {
                loadResources();
            }

            
            {
                this$0 = AbstractMultiViewFragment.this;
                super();
            }
        });
    }

    protected void updateAdapterFromList(Integer integer, List list)
    {
label0:
        {
            integer = ((AdapterViewInfo)infoMap.get(integer)).adapter;
            if (integer != null)
            {
                integer.setEntities(list);
                if (integer.getCount() <= 0)
                {
                    break label0;
                }
                integer.notifyDataSetChanged();
            }
            return;
        }
        integer.notifyDataSetInvalidated();
    }

}
