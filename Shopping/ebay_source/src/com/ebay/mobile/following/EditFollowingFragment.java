// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.following;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;
import com.ebay.common.content.dm.FollowedEntityDataManager;
import com.ebay.common.model.followinterest.FollowType;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.mobile.activities.BaseFragment;
import com.ebay.mobile.activities.UserDetailActivity;
import com.ebay.mobile.collections.CollectionDetailsActivity;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.notifications.NotificationPreferenceManager;
import com.ebay.mobile.notifications.NotificationUtil;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.FollowingContentDataManager;
import com.ebay.nautilus.domain.content.dm.UserContextDataManager;
import com.ebay.nautilus.domain.content.dm.UssContentsDataManager;
import com.ebay.nautilus.domain.content.dm.UssFeedDataManager;
import com.ebay.nautilus.domain.data.FollowingContent;
import com.ebay.nautilus.domain.data.UnifiedStream.ContentSourceEnum;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.BaseActivity;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import com.ebay.nautilus.shell.app.FwActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

// Referenced classes of package com.ebay.mobile.following:
//            FollowedSearchViewModel, FollowedMemberViewModel, FollowedCollectionViewModel, BrowseFollowingSearchesFragmentAdapter, 
//            AlphabeticalInterestSort, BrowseFollowingMembersFragmentAdapter, BrowseFollowingCollectionsFragmentAdapter, VerticalDividerItemDecoration, 
//            HorizontalDividerSearchItemDecoration

public class EditFollowingFragment extends BaseFragment
    implements com.ebay.mobile.common.view.ViewModel.OnClickListener, com.ebay.nautilus.domain.content.dm.FollowingContentDataManager.Observer
{
    private class FollowedEntityDataManagerObserver extends com.ebay.common.content.dm.FollowedEntityDataManager.SimpleObserver
    {

        final EditFollowingFragment this$0;

        public void onCollectionFollowed(Content content)
        {
            EditFollowingFragment.this.onCollectionFollowed(content);
        }

        public void onFollowDeleted(FollowType followtype, String s, ResultStatus resultstatus)
        {
            EditFollowingFragment.this.onFollowDeleted(followtype, s, resultstatus);
        }

        public void onUserFollowed(Content content)
        {
            EditFollowingFragment.this.onUserFollowed(content);
        }

        private FollowedEntityDataManagerObserver()
        {
            this$0 = EditFollowingFragment.this;
            super();
        }

    }

    private static class PendingFollowUpdate
    {

        View view;
        ViewModel viewModel;

        public PendingFollowUpdate(View view1, ViewModel viewmodel)
        {
            view = view1;
            viewModel = viewmodel;
        }
    }

    private static final class SaveSavedSearchesAsyncTask extends AsyncTask
    {

        private final Context context;
        private final EbayContext ebayContext;
        private final Observer observer;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient Void doInBackground(String as[])
        {
            NotificationUtil.updateNotificationSubscriptions(context, ebayContext, Arrays.asList(as));
            return null;
        }

        protected volatile void onCancelled(Object obj)
        {
            onCancelled((Void)obj);
        }

        protected void onCancelled(Void void1)
        {
            super.onCancelled(void1);
            if (observer != null)
            {
                observer.onSearchesSaved(false);
            }
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            super.onPostExecute(void1);
            if (observer != null)
            {
                observer.onSearchesSaved(true);
            }
        }

        public SaveSavedSearchesAsyncTask(Context context1, EbayContext ebaycontext, Observer observer1)
        {
            context = context1;
            ebayContext = ebaycontext;
            observer = observer1;
        }
    }

    public static interface SaveSavedSearchesAsyncTask.Observer
    {

        public abstract void onSearchesSaved(boolean flag);
    }


    public static final String EXTRA_FOLLOW_TYPE = "followType";
    public static final int FOLLOW_TYPE_COLLECTIONS = 3;
    public static final int FOLLOW_TYPE_INTERESTS = 1;
    public static final int FOLLOW_TYPE_MEMBERS = 2;
    private String addFollowLabel;
    private BrowseFollowingCollectionsFragmentAdapter collectionsAdapter;
    private int followType;
    protected FollowedEntityDataManager followedEntityDataManager;
    private FollowingContentDataManager followingContentDataManager;
    private RecyclerView list;
    private BrowseFollowingMembersFragmentAdapter membersAdapter;
    private NotificationPreferenceManager notificationPrefs;
    private View progressContainer;
    private Drawable removeFollowDrawable;
    private String removeFollowLabel;
    protected ScrollView scrollView;
    protected BrowseFollowingSearchesFragmentAdapter searchesAdapter;
    protected HashMap updatePendingMap;
    private UserContextDataManager userContextDataManager;

    public EditFollowingFragment()
    {
        updatePendingMap = new HashMap();
    }

    private void setListShown(boolean flag)
    {
        boolean flag1 = false;
        Object obj = list;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((RecyclerView) (obj)).setVisibility(i);
        obj = progressContainer;
        if (!flag)
        {
            i = ((flag1) ? 1 : 0);
        } else
        {
            i = 8;
        }
        ((View) (obj)).setVisibility(i);
    }

    private void toggleNotificationPref(final FollowedSearchViewModel model, Authentication authentication)
    {
        final boolean setNotifyEnabled;
        if (!notificationPrefs.isNotifyEnabledForSavedSearch(authentication.user, model.id))
        {
            setNotifyEnabled = true;
        } else
        {
            setNotifyEnabled = false;
        }
        if (setNotifyEnabled)
        {
            notificationPrefs.addNotifyEnabledSavedSearchId(authentication.user, model.id);
        } else
        {
            notificationPrefs.removeNotifyEnabledSavedSearchId(authentication.user, model.id);
        }
        authentication = (String[])notificationPrefs.getNotifyEnabledSavedSearchIdList(authentication.user).toArray(new String[0]);
        model = new SaveSavedSearchesAsyncTask.Observer() {

            final EditFollowingFragment this$0;
            final FollowedSearchViewModel val$model;
            final boolean val$setNotifyEnabled;

            public void onSearchesSaved(boolean flag)
            {
                if (flag)
                {
                    model.isNotifyEnabled = Boolean.valueOf(setNotifyEnabled);
                    searchesAdapter.notifyDataSetChanged();
                }
            }

            
            {
                this$0 = EditFollowingFragment.this;
                model = followedsearchviewmodel;
                setNotifyEnabled = flag;
                super();
            }
        };
        (new SaveSavedSearchesAsyncTask(getActivity(), getFwActivity().getEbayContext(), model)).execute(authentication);
    }

    public void onClick(final View view, final ViewModel model)
    {
        final String iafToken;
        final Object followedSearchViewModel;
        Authentication authentication;
        int i;
        authentication = userContextDataManager.getCurrentUser();
        if (authentication != null)
        {
            iafToken = authentication.iafToken;
        } else
        {
            iafToken = null;
        }
        followedSearchViewModel = userContextDataManager.getCurrentCountry().getSiteGlobalId();
        if (!(model instanceof FollowedSearchViewModel)) goto _L2; else goto _L1
_L1:
        followedSearchViewModel = (FollowedSearchViewModel)model;
        if (!(view instanceof ImageButton)) goto _L4; else goto _L3
_L3:
        i = view.getId();
        if (i != 0x7f10018b) goto _L6; else goto _L5
_L5:
        view = new android.content.DialogInterface.OnClickListener() {

            final EditFollowingFragment this$0;
            final FollowedSearchViewModel val$followedSearchViewModel;
            final String val$iafToken;
            final ViewModel val$model;
            final View val$view;

            public void onClick(DialogInterface dialoginterface, int j)
            {
                followedEntityDataManager.deleteFollow(FollowType.INTEREST, followedSearchViewModel.id, iafToken);
                view.setEnabled(false);
                updatePendingMap.put(followedSearchViewModel.id, new PendingFollowUpdate(view, model));
            }

            
            {
                this$0 = EditFollowingFragment.this;
                followedSearchViewModel = followedsearchviewmodel;
                iafToken = s;
                view = view1;
                model = viewmodel;
                super();
            }
        };
        (new android.support.v7.app.AlertDialog.Builder(getActivity())).setTitle(0x7f070287).setPositiveButton(0x7f070285, view).setNegativeButton(0x7f0701cc, null).show();
_L4:
        return;
_L6:
        if (i == 0x7f10018d)
        {
            toggleNotificationPref(((FollowedSearchViewModel) (followedSearchViewModel)), authentication);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (model instanceof FollowedMemberViewModel)
        {
            FollowedMemberViewModel followedmemberviewmodel = (FollowedMemberViewModel)model;
            if (view instanceof Button)
            {
                Button button = (Button)view;
                if (addFollowLabel.equals(button.getText()))
                {
                    followedEntityDataManager.followUser(followedmemberviewmodel.username, ((String) (followedSearchViewModel)));
                    button.setEnabled(false);
                } else
                {
                    followedEntityDataManager.deleteFollow(FollowType.USER, followedmemberviewmodel.username, iafToken);
                    button.setEnabled(false);
                }
                updatePendingMap.put(followedmemberviewmodel.username, new PendingFollowUpdate(view, model));
                return;
            } else
            {
                UserDetailActivity.StartActivity(getActivity(), followedmemberviewmodel.username, null, null, false);
                return;
            }
        }
        if (model instanceof FollowedCollectionViewModel)
        {
            FollowedCollectionViewModel followedcollectionviewmodel = (FollowedCollectionViewModel)model;
            if (view instanceof Button)
            {
                Button button1 = (Button)view;
                if (addFollowLabel.equals(button1.getText()))
                {
                    followedEntityDataManager.followCollection(followedcollectionviewmodel.id, ((String) (followedSearchViewModel)));
                    button1.setEnabled(false);
                } else
                {
                    followedEntityDataManager.deleteFollow(FollowType.COLLECTION, followedcollectionviewmodel.id, iafToken);
                    button1.setEnabled(false);
                }
                updatePendingMap.put(followedcollectionviewmodel.id, new PendingFollowUpdate(view, model));
                return;
            } else
            {
                CollectionDetailsActivity.startActivity(getActivity(), followedcollectionviewmodel.id, null, null);
                return;
            }
        }
        if (true) goto _L4; else goto _L7
_L7:
    }

    void onCollectionFollowed(Content content)
    {
        ResultStatus resultstatus = content.getStatus();
        if (resultstatus.hasError())
        {
            EbayErrorHandler.handleResultStatus(this, 0, resultstatus);
            return;
        }
        content = (String)content.getData();
        content = (PendingFollowUpdate)updatePendingMap.remove(content);
        if (content != null)
        {
            content = (Button)((PendingFollowUpdate) (content)).view;
            if (content != null)
            {
                content.setText(removeFollowLabel);
                content.setCompoundDrawablesWithIntrinsicBounds(removeFollowDrawable, null, null, null);
                content.setEnabled(true);
            }
        }
        followingContentDataManager.flush();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getArguments();
        int i;
        if (bundle != null)
        {
            i = bundle.getInt("followType");
        } else
        {
            i = 0;
        }
        followType = i;
        notificationPrefs = new NotificationPreferenceManager(getActivity());
        addFollowLabel = getString(0x7f070127);
        removeFollowLabel = getString(0x7f070b8a);
        removeFollowDrawable = getResources().getDrawable(0x7f0201c9);
        initDataManagers();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f030090, viewgroup, false);
    }

    void onFollowDeleted(FollowType followtype, String s, ResultStatus resultstatus)
    {
        if (resultstatus.hasError())
        {
            EbayErrorHandler.handleResultStatus(this, 0, resultstatus);
            return;
        }
        s = (PendingFollowUpdate)updatePendingMap.remove(s);
        if (s == null) goto _L2; else goto _L1
_L1:
        if (!FollowType.INTEREST.equals(followtype)) goto _L4; else goto _L3
_L3:
        followtype = (ImageButton)((PendingFollowUpdate) (s)).view;
        if (followtype != null)
        {
            followtype.setEnabled(true);
        }
        searchesAdapter.removeItem((FollowedSearchViewModel)((PendingFollowUpdate) (s)).viewModel);
_L2:
        followingContentDataManager.flush();
        followtype = getBaseActivity().getEbayContext();
        s = (UssFeedDataManager)UssFeedDataManager.getIfExists(followtype, UssFeedDataManager.KEY);
        if (s != null)
        {
            s.invalidateData();
        }
        UssContentsDataManager.invalidateActivityChannelData(followtype, new ContentSourceEnum[] {
            ContentSourceEnum.FOLLOW
        });
        return;
_L4:
        followtype = (Button)((PendingFollowUpdate) (s)).view;
        if (followtype != null)
        {
            followtype.setText(addFollowLabel);
            followtype.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            followtype.setEnabled(true);
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public void onFollowingContentChanged(FollowingContentDataManager followingcontentdatamanager, Content content)
    {
        followingcontentdatamanager = content.getStatus();
        if (followingcontentdatamanager.hasError())
        {
            EbayErrorHandler.handleResultStatus(this, 0, followingcontentdatamanager);
            return;
        }
        content = (FollowingContent)content.getData();
        if (content != null && ((FollowingContent) (content)).followedEntities != null)
        {
            if (searchesAdapter != null)
            {
                followingcontentdatamanager = null;
                if (((FollowingContent) (content)).followedEntities.interests != null)
                {
                    followingcontentdatamanager = new ArrayList(((FollowingContent) (content)).followedEntities.interests);
                    Collections.sort(followingcontentdatamanager, new AlphabeticalInterestSort());
                }
                searchesAdapter.setContents(followingcontentdatamanager, null, notificationPrefs, userContextDataManager.getCurrentUser());
            }
            if (membersAdapter != null)
            {
                membersAdapter.setContents(((FollowingContent) (content)).followedEntities.users);
            }
            if (collectionsAdapter != null)
            {
                collectionsAdapter.setContents(((FollowingContent) (content)).followedEntities.collections);
            }
        }
        scrollView.post(new Runnable() {

            final EditFollowingFragment this$0;

            public void run()
            {
                scrollView.scrollTo(0, 0);
            }

            
            {
                this$0 = EditFollowingFragment.this;
                super();
            }
        });
        setListShown(true);
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        userContextDataManager = (UserContextDataManager)datamanagercontainer.initialize(UserContextDataManager.KEY, null);
        followingContentDataManager = (FollowingContentDataManager)datamanagercontainer.initialize(FollowingContentDataManager.KEY, this);
        followedEntityDataManager = (FollowedEntityDataManager)datamanagercontainer.initialize(FollowedEntityDataManager.KEY, new FollowedEntityDataManagerObserver());
        followedEntityDataManager.registerObserver(new com.ebay.mobile.search.SearchUtil.WatchFollowsObserver(getActivity(), null));
    }

    public void onSetFollowedEntityIsHiddenComplete(FollowingContentDataManager followingcontentdatamanager, Content content)
    {
    }

    void onUserFollowed(Content content)
    {
        ResultStatus resultstatus = content.getStatus();
        if (resultstatus.hasError())
        {
            EbayErrorHandler.handleResultStatus(this, 0, resultstatus);
            return;
        }
        content = (String)content.getData();
        content = (PendingFollowUpdate)updatePendingMap.remove(content);
        if (content != null)
        {
            content = (Button)((PendingFollowUpdate) (content)).view;
            if (content != null)
            {
                content.setText(removeFollowLabel);
                content.setCompoundDrawablesWithIntrinsicBounds(removeFollowDrawable, null, null, null);
                content.setEnabled(true);
            }
        }
        followingContentDataManager.flush();
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        scrollView = (ScrollView)view.findViewById(0x7f1000e0);
        list = (RecyclerView)view.findViewById(0x102000a);
        progressContainer = view.findViewById(0x7f1000ca);
        bundle = (TextView)view.findViewById(0x1020016);
        ((Button)view.findViewById(0x7f10018c)).setOnClickListener(new android.view.View.OnClickListener() {

            final EditFollowingFragment this$0;

            public void onClick(View view1)
            {
                getActivity().finish();
            }

            
            {
                this$0 = EditFollowingFragment.this;
                super();
            }
        });
        if (followType != 1) goto _L2; else goto _L1
_L1:
        bundle.setText(getString(0x7f07041a));
        view = getActivity();
        searchesAdapter = new BrowseFollowingSearchesFragmentAdapter(view, true);
        list.setLayoutManager(searchesAdapter.createLayoutManager());
        list.setAdapter(searchesAdapter);
        searchesAdapter.setOnClickListener(this, new int[0]);
        int i = searchesAdapter.getNumSpans();
        if (i > 1)
        {
            list.addItemDecoration(new VerticalDividerItemDecoration(view, i));
        } else
        {
            list.addItemDecoration(new HorizontalDividerSearchItemDecoration(view));
        }
_L4:
        setListShown(false);
        return;
_L2:
        if (followType == 2)
        {
            bundle.setText(getString(0x7f070419));
            view = getActivity();
            membersAdapter = new BrowseFollowingMembersFragmentAdapter(getActivity(), true);
            list.setLayoutManager(membersAdapter.createLayoutManager());
            list.setAdapter(membersAdapter);
            membersAdapter.setOnClickListener(this, new int[0]);
            int j = membersAdapter.getNumSpans();
            if (j > 1)
            {
                list.addItemDecoration(new VerticalDividerItemDecoration(view, j));
            } else
            {
                list.addItemDecoration(new HorizontalDividerSearchItemDecoration(view));
            }
        } else
        if (followType == 3)
        {
            bundle.setText(getString(0x7f070418));
            collectionsAdapter = new BrowseFollowingCollectionsFragmentAdapter(getActivity(), true);
            list.setLayoutManager(collectionsAdapter.createLayoutManager());
            list.setAdapter(collectionsAdapter);
            collectionsAdapter.setOnClickListener(this, new int[0]);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
