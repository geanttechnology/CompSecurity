// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.networkcollections;

import android.app.Activity;
import android.app.Application;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.comcast.cim.android.accessibility.AlternateInterfaceListener;
import com.comcast.cim.android.accessibility.TalkDelegate;
import com.comcast.cim.android.view.common.AbstractMultiHorizontalAdapterViewFragment;
import com.comcast.cim.cmasl.android.util.view.widget.DefaultLoadingViewDelegate;
import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.cmasl.taskexecutor.listener.DefaultTaskExecutionListener;
import com.comcast.cim.cmasl.taskexecutor.listener.TaskExecutionListener;
import com.comcast.cim.cmasl.utils.CommonUtils;
import com.comcast.cim.cmasl.utils.container.Tuple;
import com.comcast.cim.container.PlayerContainer;
import com.xfinity.playerlib.PlayerApplication;
import com.xfinity.playerlib.image.CoverArtImageLoader;
import com.xfinity.playerlib.image.NetworkLogoImageLoader;
import com.xfinity.playerlib.model.VideoFavorite;
import com.xfinity.playerlib.model.dibic.DibicProgram;
import com.xfinity.playerlib.model.dibic.DibicResource;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import com.xfinity.playerlib.model.tags.Network;
import com.xfinity.playerlib.model.tags.OrderedTag;
import com.xfinity.playerlib.model.tags.parser.TagsRoot;
import com.xfinity.playerlib.view.ScrollStateTracker;
import com.xfinity.playerlib.view.browseprograms.NetworkProgramsActivity;
import com.xfinity.playerlib.view.browseprograms.NetworkProgramsFragment;
import com.xfinity.playerlib.view.favorite.BookmarkUtils;
import com.xfinity.playerlib.view.programdetails.DetailIntentHelper;
import it.sephiroth.android.library.widget.AbsHListView;
import it.sephiroth.android.library.widget.AdapterView;
import it.sephiroth.android.library.widget.HListView;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.view.networkcollections:
//            NetworkCollectionsBundleCodec, NetworkActionBarController

public class NetworkCollectionsFragment extends AbstractMultiHorizontalAdapterViewFragment
    implements ScrollStateTracker
{
    private class ProgramAdapter extends com.comcast.cim.cmasl.android.util.view.widget.EntityGridView.EntityGridViewAdapter
    {

        final NetworkCollectionsFragment this$0;

        protected void bindItem(ProgramViewHolder programviewholder, DibicProgram dibicprogram)
        {
label0:
            {
                NetworkCollectionsFragment.LOG.debug((new StringBuilder()).append("Binding for: ").append(dibicprogram.getMerlinId()).toString());
                String s = dibicprogram.getTitle();
                if (programviewholder.title != null)
                {
                    programviewholder.title.setText(s);
                }
                final boolean placeHolderTitleIsPresent;
                boolean flag;
                if (dibicprogram.isDownloadable())
                {
                    programviewholder.downloadIndicator.setVisibility(0);
                } else
                {
                    programviewholder.downloadIndicator.setVisibility(4);
                }
                if (programviewholder.placeholderTitle != null)
                {
                    placeHolderTitleIsPresent = true;
                } else
                {
                    placeHolderTitleIsPresent = false;
                }
                if (placeHolderTitleIsPresent)
                {
                    programviewholder.placeholderTitle.setText(s);
                }
                flag = coverArtImageLoader.loadImageFromMemory(dibicprogram, programviewholder.coverArt);
                if (!flag)
                {
                    if (isFlinging())
                    {
                        programviewholder.coverArt.setTag(null);
                        if (!flag)
                        {
                            programviewholder.coverArt.setImageDrawable(null);
                        }
                    } else
                    {
                        programviewholder.coverArt.setImageDrawable(null);
                        coverArtImageLoader.loadImage(dibicprogram, programviewholder.coverArt, programviewholder. new com.comcast.cim.android.image.CimImageLoader.OnLoadListener() {

                            final ProgramAdapter this$1;
                            final ProgramViewHolder val$holder;
                            final boolean val$placeHolderTitleIsPresent;

                            public void onLoad(ImageView imageview, String s, Bitmap bitmap)
                            {
                                if (placeHolderTitleIsPresent)
                                {
                                    holder.placeholderTitle.setText(null);
                                }
                            }

                            public void onLoadError(ImageView imageview, String s)
                            {
                            }

            
            {
                this$1 = final_programadapter;
                placeHolderTitleIsPresent = flag;
                holder = ProgramViewHolder.this;
                super();
            }
                        });
                    }
                } else
                if (placeHolderTitleIsPresent)
                {
                    programviewholder.placeholderTitle.setText(null);
                }
                if (!videoEntitlement.isEntitled(dibicprogram))
                {
                    programviewholder.lockedIndicator.setVisibility(0);
                    programviewholder.networkLogo.setVisibility(8);
                } else
                {
                    programviewholder.lockedIndicator.setVisibility(8);
                    programviewholder.networkLogo.setImageDrawable(new ColorDrawable(com.xfinity.playerlib.R.color.transparent));
                }
                programviewholder.networkLogo.setImageDrawable(null);
                if (network != null && network.isPremium())
                {
                    programviewholder.networkLogo.setVisibility(0);
                    networkLogoLoader.loadNetworkLogoSmall(network.getCompanyId(), programviewholder.networkLogo);
                }
                if (programviewholder.year != null)
                {
                    if (dibicprogram.getReleaseYear() <= 0)
                    {
                        break label0;
                    }
                    programviewholder.year.setText(Integer.toString(dibicprogram.getReleaseYear()));
                    programviewholder.year.setVisibility(0);
                }
                return;
            }
            programviewholder.year.setVisibility(8);
        }

        protected volatile void bindItem(Object obj, Object obj1)
        {
            bindItem((ProgramViewHolder)obj, (DibicProgram)obj1);
        }

        protected ProgramViewHolder createViewHolder()
        {
            return new ProgramViewHolder();
        }

        protected volatile Object createViewHolder()
        {
            return createViewHolder();
        }

        protected int getViewLayoutId()
        {
            return com.xfinity.playerlib.R.layout.browse_program_item;
        }

        protected void initializeViewHolder(View view, ViewGroup viewgroup, ProgramViewHolder programviewholder)
        {
            programviewholder.coverArt = (ImageView)view.findViewById(com.xfinity.playerlib.R.id.cover_art);
            programviewholder.networkLogo = (ImageView)view.findViewById(com.xfinity.playerlib.R.id.network_logo);
            programviewholder.lockedIndicator = view.findViewById(com.xfinity.playerlib.R.id.locked_indicator);
            programviewholder.year = (TextView)view.findViewById(com.xfinity.playerlib.R.id.year);
            programviewholder.downloadIndicator = (ImageView)view.findViewById(com.xfinity.playerlib.R.id.download_indicator);
            programviewholder.title = (TextView)view.findViewById(com.xfinity.playerlib.R.id.title);
            programviewholder.placeholderTitle = (TextView)view.findViewById(com.xfinity.playerlib.R.id.placeholder_title);
            programviewholder.carousel = (HListView)viewgroup;
        }

        protected volatile void initializeViewHolder(View view, ViewGroup viewgroup, Object obj)
        {
            initializeViewHolder(view, viewgroup, (ProgramViewHolder)obj);
        }

        public ProgramAdapter(LayoutInflater layoutinflater)
        {
            this$0 = NetworkCollectionsFragment.this;
            super(layoutinflater);
        }
    }

    private static class ProgramViewHolder
    {

        public HListView carousel;
        public ImageView coverArt;
        public ImageView downloadIndicator;
        public View lockedIndicator;
        public ImageView networkLogo;
        public TextView placeholderTitle;
        public TextView title;
        public TextView year;

        private ProgramViewHolder()
        {
        }

    }


    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment);
    public static final int RESERVED_RESOURCE_IDS[] = getReservedResourceIds();
    private NetworkActionBarController actionBarController;
    protected BookmarkUtils bookmarkUtils;
    private NetworkCollectionsBundleCodec bundleCodec;
    private List categoryList;
    private Map categoryToProgramsMap;
    private long companyId;
    private final CoverArtImageLoader coverArtImageLoader = PlayerContainer.getInstance().createCoverArtImageLoader();
    private TaskExecutionListener entitlementListener;
    private TaskExecutor entitlementProvider;
    private Network network;
    private final NetworkLogoImageLoader networkLogoLoader = PlayerContainer.getInstance().createNetworkLogoImageLoader();
    private ViewGroup rowContainer;
    private ViewGroup rowViewArray[];
    private int savedSelections[];
    private int scrollState;
    private boolean showFilterButton;
    private TaskExecutionListener tagsAndProgramsFetchListener;
    private TaskExecutor tagsAndProgramsProvider;
    private VideoEntitlement videoEntitlement;
    private Map viewInfoMap;

    public NetworkCollectionsFragment()
    {
        tagsAndProgramsProvider = PlayerContainer.getInstance().getTagsAndProgramsTaskExecutor();
        entitlementProvider = PlayerContainer.getInstance().getVideoEntitlementTaskExecutor();
        bookmarkUtils = PlayerContainer.getInstance().getBookmarkUtils();
        bundleCodec = new NetworkCollectionsBundleCodec();
        viewInfoMap = new LinkedHashMap();
    }

    private void adjustScrollShadows(HListView hlistview, ImageView imageview, ImageView imageview1)
    {
        int i = hlistview.getScrollX();
        int j;
        if (i > 0)
        {
            imageview.setVisibility(0);
            imageview.getLayoutParams().width = Math.min(i, imageview.getDrawable().getIntrinsicWidth());
        } else
        {
            imageview.setVisibility(4);
        }
        j = hlistview.getMaxScrollAmount();
        if (i < j)
        {
            imageview1.setVisibility(0);
            imageview1.getLayoutParams().width = Math.min(j - i, imageview1.getDrawable().getIntrinsicWidth());
            return;
        } else
        {
            imageview1.setVisibility(4);
            return;
        }
    }

    private int createGallery(ViewGroup viewgroup, int i)
    {
        final HListView gallery = (HListView)viewgroup.findViewById(com.xfinity.playerlib.R.id.net_coll_gallery);
        i = RESERVED_RESOURCE_IDS[i];
        gallery.setId(i);
        gallery.setOnItemSelectedListener(new it.sephiroth.android.library.widget.AdapterView.OnItemSelectedListener() {

            boolean isCallingSetSelection;
            final NetworkCollectionsFragment this$0;
            final HListView val$gallery;

            public void onItemSelected(AdapterView adapterview, View view, int j, long l)
            {
                if (!isCallingSetSelection);
            }

            public void onNothingSelected(AdapterView adapterview)
            {
            }

            
            {
                this$0 = NetworkCollectionsFragment.this;
                gallery = hlistview;
                super();
            }
        });
        gallery.setOnScrollListener(new it.sephiroth.android.library.widget.AbsHListView.OnScrollListener() {

            final NetworkCollectionsFragment this$0;
            final ImageView val$collectionShadowLeft;
            final ImageView val$collectionShadowRight;
            final HListView val$gallery;

            public void onScroll(AbsHListView abshlistview, int j, int k, int l)
            {
            }

            public void onScrollStateChanged(AbsHListView abshlistview, int j)
            {
                adjustScrollShadows(gallery, collectionShadowLeft, collectionShadowRight);
                boolean flag = isFlinging();
                scrollState = j;
                if (flag && !isFlinging())
                {
                    NetworkCollectionsFragment.LOG.debug("notifyDataSetChanged because we are no longer flinging");
                    ((ProgramAdapter)gallery.getAdapter()).notifyDataSetChanged();
                }
            }

            
            {
                this$0 = NetworkCollectionsFragment.this;
                gallery = hlistview;
                collectionShadowLeft = imageview;
                collectionShadowRight = imageview1;
                super();
            }
        });
        return i;
    }

    private void displayScreenProgramsIfReady()
    {
        if (categoryToProgramsMap != null && videoEntitlement != null)
        {
            rowContainer.removeAllViews();
            viewInfoMap.clear();
            int j = categoryList.size();
            int i = j;
            if (j > RESERVED_RESOURCE_IDS.length)
            {
                categoryList = new ArrayList(categoryList);
                removeExcessElements(categoryList, RESERVED_RESOURCE_IDS.length);
                i = categoryList.size();
            }
            rowViewArray = new ViewGroup[i];
            savedSelections = new int[i];
            if (actionBarController != null)
            {
                actionBarController.loadNetworkLogo(network);
            }
            Object obj = getActivity().getLayoutInflater();
            for (int k = 0; k < i; k++)
            {
                OrderedTag orderedtag = (OrderedTag)categoryList.get(k);
                ViewGroup viewgroup = (ViewGroup)((LayoutInflater) (obj)).inflate(com.xfinity.playerlib.R.layout.network_collection_row, rowContainer, false);
                viewgroup.setLayoutParams(new android.view.ViewGroup.LayoutParams(-2, -1));
                rowContainer.addView(viewgroup);
                rowViewArray[k] = viewgroup;
                ((TextView)viewgroup.findViewById(com.xfinity.playerlib.R.id.net_coll_name)).setText(orderedtag.getName());
                int i1 = createGallery(viewgroup, k);
                viewInfoMap.put(Integer.valueOf(i1), new com.comcast.cim.android.view.common.AbstractMultiViewFragment.AdapterViewInfo(this, new ProgramAdapter(((LayoutInflater) (obj)))));
            }

            initInfoViews();
            obj = getResources().getString(com.xfinity.playerlib.R.string.network_collections_view_all_link);
            i = 0;
            while (i < rowViewArray.length) 
            {
                Object obj1 = rowViewArray[i];
                final OrderedTag category = (OrderedTag)categoryList.get(i);
                List list = (List)categoryToProgramsMap.get(category);
                if (list == null || list.size() == 0)
                {
                    ((ViewGroup) (obj1)).setVisibility(8);
                } else
                {
                    int l = list.size();
                    if (removeExcessElements(list, 24))
                    {
                        obj1 = (TextView)((ViewGroup) (obj1)).findViewById(com.xfinity.playerlib.R.id.net_coll_view_all_link);
                        ((TextView) (obj1)).setText(String.format(Locale.US, ((String) (obj)), new Object[] {
                            Integer.valueOf(l), category.getName()
                        }));
                        ((TextView) (obj1)).setVisibility(0);
                        ((TextView) (obj1)).setOnClickListener(new android.view.View.OnClickListener() {

                            final NetworkCollectionsFragment this$0;
                            final OrderedTag val$category;

                            public void onClick(View view)
                            {
                                view = new Intent(view.getContext(), com/xfinity/playerlib/view/browseprograms/NetworkProgramsActivity);
                                view.putExtras(NetworkProgramsFragment.createBundle(network, category.getId()));
                                view.putExtra("showFilterButton", showFilterButton);
                                startActivity(view);
                            }

            
            {
                this$0 = NetworkCollectionsFragment.this;
                category = orderedtag;
                super();
            }
                        });
                    }
                    updateAdapterFromList(Integer.valueOf(RESERVED_RESOURCE_IDS[i]), list);
                }
                i++;
            }
            getLoadingViewDelegate().onLoadingFinished();
            alternateInterfaceListener.getTalkDelegate().speakManagedMessage(com.xfinity.playerlib.R.id.ACCESSIBILITY_ANNOUNCE_LOADED);
        }
    }

    public static final int[] getReservedResourceIds()
    {
        PlayerApplication playerapplication = PlayerApplication.getInstance();
        Resources resources = playerapplication.getResources();
        StringBuilder stringbuilder = new StringBuilder("reserved_id_");
        int j = stringbuilder.length();
        ArrayList arraylist = new ArrayList();
        int i = 1;
        do
        {
            stringbuilder.setLength(j);
            stringbuilder.append(Integer.toString(i));
            int k = resources.getIdentifier(stringbuilder.toString(), "id", playerapplication.getPackageName());
            if (k == 0)
            {
                int ai[] = new int[arraylist.size()];
                i = ai.length;
                do
                {
                    i--;
                    if (i >= 0)
                    {
                        ai[i] = ((Integer)arraylist.get(i)).intValue();
                    } else
                    {
                        return ai;
                    }
                } while (true);
            }
            arraylist.add(Integer.valueOf(k));
            i++;
        } while (true);
    }

    private boolean removeExcessElements(List list, int i)
    {
        boolean flag = false;
        int j = list.size();
        do
        {
            j--;
            if (j >= i)
            {
                list.remove(j);
                flag = true;
            } else
            {
                return flag;
            }
        } while (true);
    }

    protected Map getInfoMap(LayoutInflater layoutinflater)
    {
        return viewInfoMap;
    }

    protected int getLayoutId()
    {
        return com.xfinity.playerlib.R.layout.network_collections_tablet;
    }

    protected it.sephiroth.android.library.widget.AdapterView.OnItemClickListener getOnItemClickListener()
    {
        return new it.sephiroth.android.library.widget.AdapterView.OnItemClickListener() {

            final NetworkCollectionsFragment this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = (new com.xfinity.playerlib.view.programdetails.DetailIntentHelper.Builder((DibicProgram)CommonUtils.uncheckedCast(adapterview.getItemAtPosition(i)))).companyId(Long.valueOf(network.getCompanyId())).build().getIntent(getActivity());
                startActivity(adapterview);
            }

            
            {
                this$0 = NetworkCollectionsFragment.this;
                super();
            }
        };
    }

    protected it.sephiroth.android.library.widget.AdapterView.OnItemLongClickListener getOnItemLongClickListener()
    {
        return new it.sephiroth.android.library.widget.AdapterView.OnItemLongClickListener() {

            final NetworkCollectionsFragment this$0;

            public boolean onItemLongClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = (DibicProgram)CommonUtils.uncheckedCast(adapterview.getItemAtPosition(i));
                bookmarkUtils.promptBookmarkDialog(NetworkCollectionsFragment.this, new VideoFavorite(adapterview.getMerlinId(), adapterview.getTitle(), adapterview.isAdult()));
                return true;
            }

            
            {
                this$0 = NetworkCollectionsFragment.this;
                super();
            }
        };
    }

    protected int getShadowImageId()
    {
        return com.xfinity.playerlib.R.id.topScrollingShadow;
    }

    public boolean isFlinging()
    {
        return scrollState == 2;
    }

    protected void loadResources()
    {
        videoEntitlement = null;
        categoryToProgramsMap = null;
        new android.content.DialogInterface.OnCancelListener() {

            final NetworkCollectionsFragment this$0;

            public void onCancel(DialogInterface dialoginterface)
            {
                getLoadingViewDelegate().onLoadingFinished();
            }

            
            {
                this$0 = NetworkCollectionsFragment.this;
                super();
            }
        };
        entitlementListener = entitlementProvider.execute(new DefaultTaskExecutionListener() {

            final NetworkCollectionsFragment this$0;

            public void onError(TaskExecutionException taskexecutionexception)
            {
                getLoadingViewDelegate().onLoadingFailed();
            }

            public void onPostExecute(VideoEntitlement videoentitlement)
            {
                videoEntitlement = videoentitlement;
                displayScreenProgramsIfReady();
            }

            public volatile void onPostExecute(Object obj)
            {
                onPostExecute((VideoEntitlement)obj);
            }

            
            {
                this$0 = NetworkCollectionsFragment.this;
                super();
            }
        });
        tagsAndProgramsFetchListener = tagsAndProgramsProvider.execute(new DefaultTaskExecutionListener() {

            final NetworkCollectionsFragment this$0;

            public void onError(TaskExecutionException taskexecutionexception)
            {
                getLoadingViewDelegate().onLoadingFailed();
            }

            public void onPostExecute(Tuple tuple)
            {
                network = ((TagsRoot)tuple.e1).getNetworkByCompanyId(companyId);
                tuple = (DibicResource)tuple.e2;
                categoryList = network.getCategories();
                categoryToProgramsMap = tuple.getProgramsMatchingGenresAndNetwork(categoryList, network);
                if (!network.isPremium() || categoryList.size() == 0)
                {
                    categoryList = new ArrayList();
                    categoryList.addAll(categoryToProgramsMap.keySet());
                }
                displayScreenProgramsIfReady();
            }

            public volatile void onPostExecute(Object obj)
            {
                onPostExecute((Tuple)obj);
            }

            
            {
                this$0 = NetworkCollectionsFragment.this;
                super();
            }
        });
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        if (activity instanceof NetworkActionBarController)
        {
            actionBarController = (NetworkActionBarController)activity;
        }
        activity = getActivity().getIntent().getExtras();
        showFilterButton = activity.getBoolean("showFilterButton", true);
        companyId = bundleCodec.getNetworkCompanyId(activity);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = (ViewGroup)super.onCreateView(layoutinflater, viewgroup, bundle);
        rowContainer = (ViewGroup)layoutinflater.findViewById(com.xfinity.playerlib.R.id.network_collections_row_container);
        setupLoadingViewDelegate(layoutinflater);
        return layoutinflater;
    }

    public void onStartInternal()
    {
        super.onStartInternal();
    }

    public void onStop()
    {
        super.onStop();
        entitlementProvider.cancelNotificationsFor(entitlementListener);
        tagsAndProgramsProvider.cancelNotificationsFor(tagsAndProgramsFetchListener);
        coverArtImageLoader.purgeJobs();
    }




/*
    static int access$102(NetworkCollectionsFragment networkcollectionsfragment, int i)
    {
        networkcollectionsfragment.scrollState = i;
        return i;
    }

*/






/*
    static VideoEntitlement access$302(NetworkCollectionsFragment networkcollectionsfragment, VideoEntitlement videoentitlement)
    {
        networkcollectionsfragment.videoEntitlement = videoentitlement;
        return videoentitlement;
    }

*/




/*
    static Network access$502(NetworkCollectionsFragment networkcollectionsfragment, Network network1)
    {
        networkcollectionsfragment.network = network1;
        return network1;
    }

*/




/*
    static List access$702(NetworkCollectionsFragment networkcollectionsfragment, List list)
    {
        networkcollectionsfragment.categoryList = list;
        return list;
    }

*/



/*
    static Map access$802(NetworkCollectionsFragment networkcollectionsfragment, Map map)
    {
        networkcollectionsfragment.categoryToProgramsMap = map;
        return map;
    }

*/

}
