// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browsenetworks;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import com.comcast.cim.android.accessibility.AlternateInterfaceListener;
import com.comcast.cim.android.accessibility.TalkDelegate;
import com.comcast.cim.android.view.common.AbstractMultiAdapterViewFragment;
import com.comcast.cim.cmasl.android.util.view.widget.DefaultLoadingViewDelegate;
import com.comcast.cim.cmasl.android.util.view.widget.TextDrawable;
import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.cmasl.taskexecutor.listener.DefaultTaskExecutionListener;
import com.comcast.cim.cmasl.taskexecutor.listener.TaskExecutionListener;
import com.comcast.cim.cmasl.utils.CommonUtils;
import com.comcast.cim.cmasl.utils.container.Tuple;
import com.comcast.cim.container.PlayerContainer;
import com.xfinity.playerlib.image.NetworkLogoImageLoader;
import com.xfinity.playerlib.model.dibic.DibicResource;
import com.xfinity.playerlib.model.tags.Network;
import com.xfinity.playerlib.model.tags.parser.TagsRoot;
import com.xfinity.playerlib.tracking.PlayNowTab;
import com.xfinity.playerlib.tracking.PlayNowTrackingService;
import com.xfinity.playerlib.view.browseprograms.NetworkProgramsActivity;
import com.xfinity.playerlib.view.browseprograms.NetworkProgramsFragment;
import com.xfinity.playerlib.view.networkcollections.NetworkCollectionsActivity;
import com.xfinity.playerlib.view.networkcollections.NetworkCollectionsBundleCodec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NetworksFragment extends AbstractMultiAdapterViewFragment
{
    private abstract class AbstractNetworksAdapter extends com.comcast.cim.cmasl.android.util.view.widget.EntityGridView.EntityGridViewAdapter
    {

        final NetworksFragment this$0;

        protected abstract void bindImageViewItem(NetworkViewHolder networkviewholder, Network network);

        protected void bindItem(NetworkViewHolder networkviewholder, Network network)
        {
            if (networkviewholder.textViewItem != null)
            {
                networkviewholder.textViewItem.setText(network.getName());
                networkviewholder = networkviewholder.textViewItem;
            } else
            if (networkviewholder.imageViewItem != null)
            {
                bindImageViewItem(networkviewholder, network);
                networkviewholder = networkviewholder.imageViewItem;
            } else
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Unexpected view type for network: ").append(network).toString());
            }
            networkviewholder.setContentDescription(network.getName());
        }

        protected volatile void bindItem(Object obj, Object obj1)
        {
            bindItem((NetworkViewHolder)obj, (Network)obj1);
        }

        protected NetworkViewHolder createViewHolder()
        {
            return new NetworkViewHolder();
        }

        protected volatile Object createViewHolder()
        {
            return createViewHolder();
        }

        protected void initializeViewHolder(View view, ViewGroup viewgroup, NetworkViewHolder networkviewholder)
        {
            networkviewholder.textViewItem = (TextView)view.findViewById(com.xfinity.playerlib.R.id.network_textview_item);
            networkviewholder.imageViewItem = (ImageView)view.findViewById(com.xfinity.playerlib.R.id.network_imageview_item);
        }

        protected volatile void initializeViewHolder(View view, ViewGroup viewgroup, Object obj)
        {
            initializeViewHolder(view, viewgroup, (NetworkViewHolder)obj);
        }

        public AbstractNetworksAdapter(LayoutInflater layoutinflater)
        {
            this$0 = NetworksFragment.this;
            super(layoutinflater);
        }
    }

    private class AllNetworksAdapter extends AbstractNetworksAdapter
    {

        final NetworksFragment this$0;

        protected void bindImageViewItem(NetworkViewHolder networkviewholder, Network network)
        {
            Drawable drawable = getNetworkNameDrawable(network);
            networkLogoLoader.loadNetworkLogoSmall(network.getCompanyId(), networkviewholder.imageViewItem, drawable, drawable, false);
        }

        protected int getViewLayoutId()
        {
            return com.xfinity.playerlib.R.layout.network_item_std;
        }

        public AllNetworksAdapter(LayoutInflater layoutinflater)
        {
            this$0 = NetworksFragment.this;
            super(layoutinflater);
        }
    }

    public static class NetworkNameComparator
        implements Comparator
    {

        public int compare(Network network, Network network1)
        {
            return network.getName().compareToIgnoreCase(network1.getName());
        }

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((Network)obj, (Network)obj1);
        }

        public NetworkNameComparator()
        {
        }
    }

    private static class NetworkViewHolder
    {

        ImageView imageViewItem;
        TextView textViewItem;

        private NetworkViewHolder()
        {
        }

    }

    private class PremiumNetworksAdapter extends AbstractNetworksAdapter
    {

        final NetworksFragment this$0;

        protected void bindImageViewItem(NetworkViewHolder networkviewholder, Network network)
        {
            Drawable drawable = getNetworkNameDrawable(network);
            networkLogoLoader.loadNetworkLogoLarge(network.getCompanyId(), networkviewholder.imageViewItem, drawable, drawable);
        }

        protected int getViewLayoutId()
        {
            return com.xfinity.playerlib.R.layout.network_item_premium;
        }

        public PremiumNetworksAdapter(LayoutInflater layoutinflater)
        {
            this$0 = NetworksFragment.this;
            super(layoutinflater);
        }
    }


    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/view/browsenetworks/NetworksFragment);
    private static int MISSING_LOGO_TEXT_COLOR;
    private static float MISSING_LOGO_TEXT_SIZE = -1F;
    private static final NetworkNameComparator NETWORK_NAME_COMPARATOR = new NetworkNameComparator();
    private List allNetworks;
    private AbsListView allNetworksAbsList;
    private AlternateInterfaceListener alternateInterfaceListener;
    private DibicResource dibicResource;
    private Map infoMap;
    private NetworkCollectionsBundleCodec networkCollectionsBundleCodec;
    private final NetworkLogoImageLoader networkLogoLoader = PlayerContainer.getInstance().createNetworkLogoImageLoader();
    private View noDataSpacer;
    private List premiumNetworks;
    private AbsListView premiumNetworksAbsList;
    private View premiumNetworksHeader;
    android.widget.AbsListView.OnScrollListener setOnScrollListener;
    private TaskExecutor tagsAndProgramsProvider;
    private TaskExecutionListener tagsAndProviderListener;
    private PlayNowTrackingService trackingService;

    public NetworksFragment()
    {
        tagsAndProgramsProvider = PlayerContainer.getInstance().getTagsAndProgramsTaskExecutor();
        networkCollectionsBundleCodec = new NetworkCollectionsBundleCodec();
        trackingService = PlayerContainer.getInstance().getTrackingService();
        setOnScrollListener = new android.widget.AbsListView.OnScrollListener() {

            final NetworksFragment this$0;

            public void onScroll(AbsListView abslistview, int i, int j, int k)
            {
                if (abslistview.getTag() != null)
                {
                    abslistview.setContentDescription(getResources().getString(com.xfinity.playerlib.R.string.content_description_networks_single_grid, new Object[] {
                        abslistview.getTag().toString(), Integer.valueOf(i + 1), Integer.valueOf(i + j), Integer.valueOf(k)
                    }));
                }
            }

            public void onScrollStateChanged(AbsListView abslistview, int i)
            {
            }

            
            {
                this$0 = NetworksFragment.this;
                super();
            }
        };
    }

    private void executeOnItemClick(AdapterView adapterview, int i)
    {
        adapterview = (Network)CommonUtils.uncheckedCast(adapterview.getItemAtPosition(i));
        trackingService.trackTapNetworkLogo(adapterview.getName());
        showApplicableBrowse(adapterview);
    }

    private void fixScrollYPosition()
    {
        if (premiumNetworksHeader != null)
        {
            bodyContainer.post(new Runnable() );
        }
    }

    private Drawable getNetworkNameDrawable(Network network)
    {
        Object obj = null;
        Activity activity = getActivity();
        if (activity != null)
        {
            if (MISSING_LOGO_TEXT_SIZE == -1F)
            {
                obj = (TextView)((ViewGroup)activity.getLayoutInflater().inflate(com.xfinity.playerlib.R.layout.network_item_missing_logo_text_style_template, null, false)).findViewById(com.xfinity.playerlib.R.id.network_gallery_missing_logo_text_style_template);
                MISSING_LOGO_TEXT_COLOR = ((TextView) (obj)).getCurrentTextColor();
                MISSING_LOGO_TEXT_SIZE = TypedValue.applyDimension(0, ((TextView) (obj)).getTextSize(), activity.getResources().getDisplayMetrics());
            }
            obj = new TextDrawable(activity, network.getName(), MISSING_LOGO_TEXT_COLOR, MISSING_LOGO_TEXT_SIZE, -2, 4, true, 4, true, android.text.TextUtils.TruncateAt.END);
        }
        return ((Drawable) (obj));
    }

    private void showApplicableBrowse(Network network)
    {
        Object obj = dibicResource.getGenreMapForNetwork(network);
        if (((Map) (obj)).size() > 1)
        {
            obj = new Intent(getActivity(), com/xfinity/playerlib/view/networkcollections/NetworkCollectionsActivity);
            ((Intent) (obj)).putExtras(networkCollectionsBundleCodec.createBundle(network));
            network = ((Network) (obj));
        } else
        {
            String s = (String)((Map) (obj)).keySet().iterator().next();
            obj = new Intent(getActivity(), com/xfinity/playerlib/view/browseprograms/NetworkProgramsActivity);
            ((Intent) (obj)).putExtras(NetworkProgramsFragment.createBundle(network, s));
            network = ((Network) (obj));
        }
        startActivity(network);
    }

    protected Map getInfoMap(LayoutInflater layoutinflater)
    {
        if (infoMap == null)
        {
            infoMap = new LinkedHashMap(2, 1.0F);
            infoMap.put(Integer.valueOf(com.xfinity.playerlib.R.id.premium_networks), new AdapterViewInfo(this, new PremiumNetworksAdapter(layoutinflater)));
            infoMap.put(Integer.valueOf(com.xfinity.playerlib.R.id.all_networks), new AdapterViewInfo(this, new AllNetworksAdapter(layoutinflater)));
        }
        return infoMap;
    }

    protected int getLayoutId()
    {
        return com.xfinity.playerlib.R.layout.networks_gallery;
    }

    protected android.widget.AdapterView.OnItemClickListener getOnItemClickListener()
    {
        return new android.widget.AdapterView.OnItemClickListener() {

            final NetworksFragment this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                NetworksFragment.LOG.debug("onItemClick()");
                executeOnItemClick(adapterview, i);
            }

            
            {
                this$0 = NetworksFragment.this;
                super();
            }
        };
    }

    protected android.widget.AdapterView.OnItemLongClickListener getOnItemLongClickListener()
    {
        return new android.widget.AdapterView.OnItemLongClickListener() {

            final NetworksFragment this$0;

            public boolean onItemLongClick(AdapterView adapterview, View view, int i, long l)
            {
                executeOnItemClick(adapterview, i);
                return true;
            }

            
            {
                this$0 = NetworksFragment.this;
                super();
            }
        };
    }

    protected int getShadowImageId()
    {
        return 0;
    }

    protected void loadResources()
    {
        tagsAndProviderListener = tagsAndProgramsProvider.execute(new DefaultTaskExecutionListener() {

            final NetworksFragment this$0;

            public void onError(TaskExecutionException taskexecutionexception)
            {
                getLoadingViewDelegate().onLoadingFailed();
            }

            public void onPostExecute(Tuple tuple)
            {
                initInfoViews();
                TagsRoot tagsroot = (TagsRoot)tuple.e1;
                dibicResource = (DibicResource)tuple.e2;
                allNetworks = new ArrayList();
                tuple = tagsroot.getNetworks().iterator();
                do
                {
                    if (!tuple.hasNext())
                    {
                        break;
                    }
                    Network network = (Network)tuple.next();
                    Map map = dibicResource.getGenreMapForNetwork(network);
                    if (map != null && map.size() > 0)
                    {
                        allNetworks.add(network);
                    }
                } while (true);
                Collections.sort(allNetworks, NetworksFragment.NETWORK_NAME_COMPARATOR);
                premiumNetworks = new ArrayList();
                tuple = allNetworks.iterator();
                do
                {
                    if (!tuple.hasNext())
                    {
                        break;
                    }
                    Network network1 = (Network)tuple.next();
                    if (network1.isPremium())
                    {
                        premiumNetworks.add(network1);
                    }
                } while (true);
                if (noDataSpacer != null)
                {
                    tuple = noDataSpacer;
                    byte byte0;
                    if (premiumNetworks.size() > 0)
                    {
                        byte0 = 8;
                    } else
                    {
                        byte0 = 0;
                    }
                    tuple.setVisibility(byte0);
                }
                updateAdapterFromList(Integer.valueOf(com.xfinity.playerlib.R.id.premium_networks), premiumNetworks);
                updateAdapterFromList(Integer.valueOf(com.xfinity.playerlib.R.id.all_networks), allNetworks);
                getLoadingViewDelegate().onLoadingFinished();
                alternateInterfaceListener.getTalkDelegate().speakManagedMessage(com.xfinity.playerlib.R.id.ACCESSIBILITY_ANNOUNCE_LOADED);
                fixScrollYPosition();
            }

            public volatile void onPostExecute(Object obj)
            {
                onPostExecute((Tuple)obj);
            }

            public void onPreAsynchronousExecute()
            {
                alternateInterfaceListener.getTalkDelegate().speakManagedMessage(com.xfinity.playerlib.R.string.loading);
            }

            
            {
                this$0 = NetworksFragment.this;
                super();
            }
        });
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        alternateInterfaceListener = (AlternateInterfaceListener)activity;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = super.onCreateView(layoutinflater, viewgroup, bundle);
        noDataSpacer = layoutinflater.findViewById(com.xfinity.playerlib.R.id.spacer_if_no_data);
        premiumNetworksHeader = layoutinflater.findViewById(com.xfinity.playerlib.R.id.premium_networks_header);
        trackingService.trackTabRendered(PlayNowTab.NETWORKS);
        premiumNetworksAbsList = (AbsListView)layoutinflater.findViewById(com.xfinity.playerlib.R.id.premium_networks);
        premiumNetworksAbsList.setTag(getString(com.xfinity.playerlib.R.string.content_description_premium_networks));
        premiumNetworksAbsList.setOnScrollListener(setOnScrollListener);
        allNetworksAbsList = (AbsListView)layoutinflater.findViewById(com.xfinity.playerlib.R.id.all_networks);
        allNetworksAbsList.setTag(getString(com.xfinity.playerlib.R.string.content_description_all_networks));
        allNetworksAbsList.setOnScrollListener(setOnScrollListener);
        return layoutinflater;
    }

    public void onPause()
    {
        super.onPause();
        tagsAndProgramsProvider.cancelNotificationsFor(tagsAndProviderListener);
        networkLogoLoader.purgeJobs();
    }

    public void onStop()
    {
        super.onStop();
        tagsAndProgramsProvider.cancelNotificationsFor(tagsAndProviderListener);
    }














/*
    static DibicResource access$202(NetworksFragment networksfragment, DibicResource dibicresource)
    {
        networksfragment.dibicResource = dibicresource;
        return dibicresource;
    }

*/



/*
    static List access$302(NetworksFragment networksfragment, List list)
    {
        networksfragment.allNetworks = list;
        return list;
    }

*/




/*
    static List access$502(NetworksFragment networksfragment, List list)
    {
        networksfragment.premiumNetworks = list;
        return list;
    }

*/




}
