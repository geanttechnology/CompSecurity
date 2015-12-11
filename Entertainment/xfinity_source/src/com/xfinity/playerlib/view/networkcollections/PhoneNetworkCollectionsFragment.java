// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.networkcollections;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.comcast.cim.android.accessibility.AlternateInterfaceListener;
import com.comcast.cim.android.view.common.CALDialogFragment;
import com.comcast.cim.android.view.common.ErrorDialogFactory;
import com.comcast.cim.android.view.launch.AuthenticatingFragment;
import com.comcast.cim.cmasl.android.util.view.widget.ViewHolderBaseAdapter;
import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.cmasl.taskexecutor.listener.DefaultTaskExecutionListener;
import com.comcast.cim.cmasl.taskexecutor.listener.TaskExecutionListener;
import com.comcast.cim.cmasl.utils.container.Tuple;
import com.comcast.cim.container.PlayerContainer;
import com.xfinity.playerlib.image.ProgramDetailArtImageLoader;
import com.xfinity.playerlib.model.VideoFavorite;
import com.xfinity.playerlib.model.dibic.DibicResource;
import com.xfinity.playerlib.model.tags.FeaturedShow;
import com.xfinity.playerlib.model.tags.Network;
import com.xfinity.playerlib.model.tags.OrderedTag;
import com.xfinity.playerlib.model.tags.parser.TagsRoot;
import com.xfinity.playerlib.view.browseprograms.NetworkProgramsActivity;
import com.xfinity.playerlib.view.browseprograms.NetworkProgramsFragment;
import com.xfinity.playerlib.view.favorite.BookmarkUtils;
import com.xfinity.playerlib.view.programdetails.DetailIntentHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.xfinity.playerlib.view.networkcollections:
//            NetworkCollectionsBundleCodec, NetworkActionBarController

public class PhoneNetworkCollectionsFragment extends AuthenticatingFragment
{
    private class CategoryAdapter extends ViewHolderBaseAdapter
    {

        private ArrayList genres;
        private Map programCounts;
        final PhoneNetworkCollectionsFragment this$0;

        protected void bindItem(CategoryViewHolder categoryviewholder, OrderedTag orderedtag)
        {
            categoryviewholder.title.setText(orderedtag.getName());
            orderedtag = Integer.toString(((Integer)programCounts.get(orderedtag)).intValue());
            categoryviewholder.count.setText(orderedtag);
        }

        protected volatile void bindItem(Object obj, Object obj1)
        {
            bindItem((CategoryViewHolder)obj, (OrderedTag)obj1);
        }

        protected CategoryViewHolder createViewHolder()
        {
            return new CategoryViewHolder();
        }

        protected volatile Object createViewHolder()
        {
            return createViewHolder();
        }

        public int getCount()
        {
            return genres.size();
        }

        public OrderedTag getItem(int i)
        {
            return (OrderedTag)genres.get(i);
        }

        public volatile Object getItem(int i)
        {
            return getItem(i);
        }

        protected int getViewLayoutId()
        {
            return com.xfinity.playerlib.R.layout.network_collections_item;
        }

        protected void initializeViewHolder(View view, ViewGroup viewgroup, CategoryViewHolder categoryviewholder)
        {
            categoryviewholder.title = (TextView)view.findViewById(com.xfinity.playerlib.R.id.title);
            categoryviewholder.count = (TextView)view.findViewById(com.xfinity.playerlib.R.id.count);
        }

        protected volatile void initializeViewHolder(View view, ViewGroup viewgroup, Object obj)
        {
            initializeViewHolder(view, viewgroup, (CategoryViewHolder)obj);
        }

        public void setData(Network network, DibicResource dibicresource)
        {
            genres.clear();
            programCounts.clear();
            for (network = dibicresource.getProgramsMatchingGenresAndNetwork(network.getCategories(), network).entrySet().iterator(); network.hasNext(); programCounts.put(dibicresource.getKey(), Integer.valueOf(((List)dibicresource.getValue()).size())))
            {
                dibicresource = (java.util.Map.Entry)network.next();
                genres.add(dibicresource.getKey());
            }

            notifyDataSetChanged();
        }

        public CategoryAdapter(LayoutInflater layoutinflater)
        {
            this$0 = PhoneNetworkCollectionsFragment.this;
            super(layoutinflater);
            genres = new ArrayList();
            programCounts = new HashMap();
        }
    }

    private static class CategoryViewHolder
    {

        public TextView count;
        public TextView title;

        private CategoryViewHolder()
        {
        }

    }

    private class TagsAndProgramsTaskExecutionListener extends DefaultTaskExecutionListener
    {

        final PhoneNetworkCollectionsFragment this$0;

        public void onError(TaskExecutionException taskexecutionexception)
        {
            errorDialogFactory.createErrorDialogForThrowable(taskexecutionexception, new com.comcast.cim.android.view.common.CALDialogFragment.TryAgainListener() {

                final TagsAndProgramsTaskExecutionListener this$1;

                public void tryAgain()
                {
                    fetchData();
                }

            
            {
                this$1 = TagsAndProgramsTaskExecutionListener.this;
                super();
            }
            }).show(getFragmentManager(), "caldialogfragment");
        }

        public void onPostExecute(Tuple tuple)
        {
            Object obj = (TagsRoot)tuple.e1;
            tuple = (DibicResource)tuple.e2;
            obj = ((TagsRoot) (obj)).getNetworkByCompanyId(companyId);
            if (actionBarController != null)
            {
                actionBarController.loadNetworkLogo(((Network) (obj)));
            }
            FeaturedShow featuredshow = ((Network) (obj)).getFeaturedShow();
            if (featuredshow != null)
            {
                detailArtImageLoader.loadNetworkFeatureDetailProgramArt(featuredshow, featureImage, new com.comcast.cim.android.image.CimImageLoader.OnLoadListener() {

                    final TagsAndProgramsTaskExecutionListener this$1;

                    public void onLoad(ImageView imageview, String s, Bitmap bitmap)
                    {
                    }

                    public void onLoadError(ImageView imageview, String s)
                    {
                        featureSection.setVisibility(8);
                    }

            
            {
                this$1 = TagsAndProgramsTaskExecutionListener.this;
                super();
            }
                });
                featureSection.setOnClickListener(getOnClickListenerForProgramDetail(featuredshow));
                featureSection.setOnLongClickListener(getOnLongClickListenerForProgramDetail(featuredshow));
                featureTitle.setText(featuredshow.getTitle());
                featureTitle.setContentDescription(getString(com.xfinity.playerlib.R.string.content_description_feature_program, new Object[] {
                    featuredshow.getTitle()
                }));
            } else
            {
                featureSection.setVisibility(8);
            }
            categoryAdapter.setData(((Network) (obj)), tuple);
            categoryList.setOnItemClickListener(((_cls2) (obj)). new android.widget.AdapterView.OnItemClickListener() {

                final TagsAndProgramsTaskExecutionListener this$1;
                final Network val$network;

                public void onItemClick(AdapterView adapterview, View view, int i, long l)
                {
                    adapterview = new Intent(view.getContext(), com/xfinity/playerlib/view/browseprograms/NetworkProgramsActivity);
                    adapterview.putExtras(NetworkProgramsFragment.createBundle(network, categoryAdapter.getItem(i).getId()));
                    adapterview.putExtra("showFilterButton", showFilterButton);
                    startActivity(adapterview);
                }

            
            {
                this$1 = final_tagsandprogramstaskexecutionlistener;
                network = Network.this;
                super();
            }
            });
            categoryList.setContentDescription(getString(com.xfinity.playerlib.R.string.content_description_network_categories_main, new Object[] {
                Long.valueOf(companyId), Integer.valueOf(((Network) (obj)).getCategories().size())
            }));
            hideLoading();
        }

        public volatile void onPostExecute(Object obj)
        {
            onPostExecute((Tuple)obj);
        }

        private TagsAndProgramsTaskExecutionListener()
        {
            this$0 = PhoneNetworkCollectionsFragment.this;
            super();
        }

    }


    private NetworkActionBarController actionBarController;
    protected AlternateInterfaceListener alternateInterfaceListener;
    private View bodyContainer;
    protected BookmarkUtils bookmarkUtils;
    private NetworkCollectionsBundleCodec bundleCodec;
    private CategoryAdapter categoryAdapter;
    private ListView categoryList;
    private long companyId;
    private final ProgramDetailArtImageLoader detailArtImageLoader = PlayerContainer.getInstance().createProgramDetailArtImageLoader();
    private final ErrorDialogFactory errorDialogFactory = PlayerContainer.getInstance().getErrorDialogFactory();
    private ImageView featureImage;
    private LinearLayout featureSection;
    private TextView featureTitle;
    private View loadingIndicator;
    private boolean showFilterButton;
    private TaskExecutor tagsAndProgramsProvider;
    private TaskExecutionListener tagsAndProgramsTaskExecutionListener;

    public PhoneNetworkCollectionsFragment()
    {
        tagsAndProgramsProvider = PlayerContainer.getInstance().getTagsAndProgramsTaskExecutor();
        bundleCodec = new NetworkCollectionsBundleCodec();
        bookmarkUtils = PlayerContainer.getInstance().getBookmarkUtils();
        tagsAndProgramsTaskExecutionListener = new TagsAndProgramsTaskExecutionListener();
    }

    private void fetchData()
    {
        tagsAndProgramsProvider.execute(tagsAndProgramsTaskExecutionListener);
    }

    private android.view.View.OnClickListener getOnClickListenerForProgramDetail(final FeaturedShow featuredShow)
    {
        return new android.view.View.OnClickListener() {

            final PhoneNetworkCollectionsFragment this$0;
            final FeaturedShow val$featuredShow;

            public void onClick(View view)
            {
                view = (new com.xfinity.playerlib.view.programdetails.DetailIntentHelper.Builder(featuredShow.getMerlinId())).build().getIntent(getActivity());
                startActivity(view);
            }

            
            {
                this$0 = PhoneNetworkCollectionsFragment.this;
                featuredShow = featuredshow;
                super();
            }
        };
    }

    private android.view.View.OnLongClickListener getOnLongClickListenerForProgramDetail(final FeaturedShow featuredShow)
    {
        return new android.view.View.OnLongClickListener() {

            final PhoneNetworkCollectionsFragment this$0;
            final FeaturedShow val$featuredShow;

            public boolean onLongClick(View view)
            {
                bookmarkUtils.promptBookmarkDialog(PhoneNetworkCollectionsFragment.this, new VideoFavorite(featuredShow.getMerlinId(), featuredShow.getTitle()));
                return true;
            }

            
            {
                this$0 = PhoneNetworkCollectionsFragment.this;
                featuredShow = featuredshow;
                super();
            }
        };
    }

    public void hideLoading()
    {
        bodyContainer.setVisibility(0);
        loadingIndicator.setVisibility(8);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        if (activity instanceof NetworkActionBarController)
        {
            actionBarController = (NetworkActionBarController)activity;
        }
        alternateInterfaceListener = (AlternateInterfaceListener)activity;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = new Bundle();
        Intent intent = getActivity().getIntent();
        if (intent != null && intent.getExtras() != null)
        {
            bundle.putAll(intent.getExtras());
        }
        if (getArguments() != null)
        {
            bundle.putAll(getArguments());
        }
        showFilterButton = bundle.getBoolean("showFilterButton", true);
        companyId = bundleCodec.getNetworkCompanyId(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        viewgroup = (ViewGroup)layoutinflater.inflate(com.xfinity.playerlib.R.layout.network_collections_phone, viewgroup, false);
        featureSection = (LinearLayout)viewgroup.findViewById(com.xfinity.playerlib.R.id.feature_section);
        featureImage = (ImageView)viewgroup.findViewById(com.xfinity.playerlib.R.id.feature_image);
        featureTitle = (TextView)viewgroup.findViewById(com.xfinity.playerlib.R.id.feature_title);
        categoryList = (ListView)viewgroup.findViewById(com.xfinity.playerlib.R.id.category_list);
        categoryAdapter = new CategoryAdapter(layoutinflater);
        categoryList.setAdapter(categoryAdapter);
        loadingIndicator = viewgroup.findViewById(com.xfinity.playerlib.R.id.loading_indicator);
        bodyContainer = viewgroup.findViewById(com.xfinity.playerlib.R.id.body_container);
        alternateInterfaceListener.setupPassiveGestureDetector(viewgroup, com.xfinity.playerlib.R.id.touchy_parent);
        return viewgroup;
    }

    public void onPause()
    {
        super.onPause();
        tagsAndProgramsProvider.cancelNotificationsFor(tagsAndProgramsTaskExecutionListener);
    }

    public void onResumeInternal()
    {
        super.onResumeInternal();
        showLoading();
        fetchData();
    }

    public void showLoading()
    {
        bodyContainer.setVisibility(8);
        loadingIndicator.setVisibility(0);
    }













}
