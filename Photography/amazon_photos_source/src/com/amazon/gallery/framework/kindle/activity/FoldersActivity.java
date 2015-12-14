// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.utils.messaging.ActionCompleteEvent;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.foundation.utils.messaging.MultiSelectModeCommand;
import com.amazon.gallery.framework.data.dao.SortOrder;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.gallery.actions.ConvertFolderToAlbumAction;
import com.amazon.gallery.framework.gallery.actions.TagAction;
import com.amazon.gallery.framework.gallery.cab.ContextBar;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.amazon.ScreenModeManager;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.kindle.cds.SyncHandler;
import com.amazon.gallery.framework.kindle.provider.MediaContentConfiguration;
import com.amazon.gallery.framework.kindle.recyclerview.ListDividerItemDecoration;
import com.amazon.gallery.framework.kindle.util.SavedTagsFragment;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagType;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.thor.albums.AlbumsMetricsHelper;
import com.amazon.gallery.thor.app.activity.GalleryNavigationSetting;
import com.amazon.gallery.thor.app.activity.ThorActionBar;
import com.amazon.gallery.thor.app.activity.ThorNativeGalleryActivity;
import com.amazon.gallery.thor.app.ui.cab.TagContextBar;
import com.amazon.gallery.thor.camera.ThorLaunchCamera;
import com.amazon.gallery.thor.di.NativeActivityBeans;
import com.amazon.gallery.thor.folders.FolderToAlbumMapper;
import com.amazon.gallery.thor.folders.FoldersActionBar;
import com.amazon.gallery.thor.folders.FoldersAdapter;
import com.amazon.gallery.thor.folders.FoldersBottomSheet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.kindle.activity:
//            CommonActivity, OnSortingChangedListener

public class FoldersActivity extends CommonActivity
    implements android.support.v4.app.LoaderManager.LoaderCallbacks, OnSortingChangedListener
{

    private final int LOADER_ID = hashCode();
    private ComponentProfiler albumProfiler;
    private AuthenticationManager authenticationManager;
    private MediaContentConfiguration contentConfiguration;
    private ContextBar contextBar;
    private TagAction convertToAlbum;
    private FolderToAlbumMapper folderToAlbumMapper;
    private FoldersAdapter foldersAdapter;
    private FoldersBottomSheet foldersBottomSheet;
    private android.view.View.OnClickListener itemClickListener;
    private MediaItemDao mediaItemDao;
    private Profiler profiler;
    private RecyclerView recyclerView;
    private ScreenModeManager screenModeManager;
    private String sortType;
    private TagDao tagDao;
    private ThorActionBar toolbar;

    public FoldersActivity()
    {
        super(new NativeActivityBeans(), new ThorLaunchCamera());
        itemClickListener = new android.view.View.OnClickListener() {

            final FoldersActivity this$0;

            public void onClick(View view)
            {
                if (contextBar.isContextBarActive())
                {
                    onFolderSelected(view);
                    return;
                } else
                {
                    int i = recyclerView.getChildAdapterPosition(view);
                    view = new Intent(FoldersActivity.this, com/amazon/gallery/thor/app/activity/ThorNativeGalleryActivity);
                    view.setAction("com.amazon.photos.INTERNAL");
                    view.putExtra("mediaTag", foldersAdapter.getFolderForPosition(i));
                    view.putExtra("navigationFromFolders", true);
                    com.amazon.gallery.thor.albums.AlbumsMetricsHelper.MetricsEvent metricsevent = com.amazon.gallery.thor.albums.AlbumsMetricsHelper.MetricsEvent.FolderMigrationViewAll;
                    albumProfiler.trackEvent(metricsevent, AlbumsMetricsHelper.createMetricsExtra(metricsevent.name(), null, null));
                    startActivity(view);
                    return;
                }
            }

            
            {
                this$0 = FoldersActivity.this;
                super();
            }
        };
    }

    private void enterSelectionMode()
    {
        contextBar.show();
        foldersAdapter.setSelectedMode(true);
        toggleBottomSheet();
    }

    private void exitSelectionMode()
    {
        contextBar.hide();
        foldersAdapter.setSelectedMode(false);
        toggleBottomSheet();
    }

    private int getSelectedCount()
    {
        return ((TagContextBar)contextBar).getSelectables().size();
    }

    private void onActionTaken(List list)
    {
        convertToAlbum.executeTags(list);
        exitSelectionMode();
    }

    private boolean onFolderSelected(View view)
    {
        int i = recyclerView.getChildAdapterPosition(view);
        view = foldersAdapter.getFolderForPosition(i);
        if (folderToAlbumMapper.contains(view.getObjectId()))
        {
            Toast.makeText(this, 0x7f0e01bf, 0).show();
            return false;
        }
        boolean flag = false;
        if (!contextBar.isContextBarActive())
        {
            enterSelectionMode();
            flag = true;
        }
        if (contextBar.isSelected(view))
        {
            contextBar.removeSelectable(view);
        } else
        {
            contextBar.addSelectable(view);
        }
        foldersBottomSheet.updateView(getSelectedCount());
        if (flag)
        {
            foldersAdapter.notifyDataSetChanged();
        } else
        {
            foldersAdapter.notifyItemChanged(i);
        }
        return true;
    }

    private void setupBottomSheet()
    {
        foldersBottomSheet = new FoldersBottomSheet(this, new android.view.View.OnClickListener() {

            final FoldersActivity this$0;

            public void onClick(View view)
            {
                view = new ArrayList(((TagContextBar)contextBar).getSelectables());
                onActionTaken(view);
            }

            
            {
                this$0 = FoldersActivity.this;
                super();
            }
        });
    }

    private void setupConfiguration()
    {
        contentConfiguration = (new com.amazon.gallery.framework.kindle.provider.MediaContentConfiguration.Builder()).withUri(com.amazon.gallery.framework.kindle.provider.GalleryInternalContentProvider.Tag.CONTENT_URI).withProjection(com.amazon.gallery.framework.kindle.provider.GalleryInternalContentProvider.Tag.Columns.ALL_PROJECTION).appendWhere("valid", Integer.toString(1)).appendWhere("type", Integer.valueOf(TagType.FOLDER.ordinal())).build();
        sortType = com.amazon.gallery.framework.gallery.widget.TagListAdapter.SortType.NAME_ASC.getSortOrder().getOrderByString();
    }

    private void setupContextBar()
    {
        contextBar = new TagContextBar(this, 0x7f100008);
    }

    private void setupFolderToAlbumMapper()
    {
        folderToAlbumMapper.init(foldersAdapter);
    }

    private void setupRecyclerView()
    {
        recyclerView = (RecyclerView)findViewById(0x7f0c014f);
        android.support.v7.widget.RecyclerView.ItemAnimator itemanimator = recyclerView.getItemAnimator();
        if (itemanimator != null)
        {
            itemanimator.setSupportsChangeAnimations(false);
        }
        foldersAdapter = new FoldersAdapter(this, tagDao, mediaItemDao, folderToAlbumMapper, contextBar, authenticationManager.getAccountId());
        foldersAdapter.setOnClickListener(itemClickListener);
        foldersAdapter.setOnLongClickListener(new android.view.View.OnLongClickListener() {

            final FoldersActivity this$0;

            public boolean onLongClick(View view)
            {
                return !onFolderSelected(view);
            }

            
            {
                this$0 = FoldersActivity.this;
                super();
            }
        });
        foldersAdapter.setOnButtonClickListener(new android.view.View.OnClickListener() {

            final FoldersActivity this$0;

            public void onClick(View view)
            {
                view = (View)view.getParent();
                int i = recyclerView.getChildAdapterPosition(view);
                view = foldersAdapter.getFolderForPosition(i);
                onActionTaken(Collections.singletonList(view));
            }

            
            {
                this$0 = FoldersActivity.this;
                super();
            }
        });
        recyclerView.setAdapter(foldersAdapter);
        recyclerView.addItemDecoration(new ListDividerItemDecoration(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setupToolbar()
    {
        toolbar = new FoldersActionBar(null, this, false, (Toolbar)findViewById(0x7f0c0086));
        toolbar.setNavigationSetting(GalleryNavigationSetting.BACK);
        toolbar.setup(0x7f100009, 0x7f100012, 0x7f0c028c, this);
        toolbar.setTitle(getResources().getString(0x7f0e01b5));
        toolbar.updateHeaderOptions(null, null);
    }

    private void toggleBottomSheet()
    {
        foldersBottomSheet.updateView(getSelectedCount());
        foldersBottomSheet.toggle(contextBar.isContextBarActive());
    }

    protected SyncHandler createSyncHandler()
    {
        return null;
    }

    protected String getAccessibilityDescription()
    {
        return getResources().getString(0x7f0e01b5);
    }

    public SavedTagsFragment getSavedTagsFragment()
    {
        FragmentManager fragmentmanager = getSupportFragmentManager();
        SavedTagsFragment savedtagsfragment1 = (SavedTagsFragment)fragmentmanager.findFragmentByTag(SavedTagsFragment.TAG);
        SavedTagsFragment savedtagsfragment = savedtagsfragment1;
        if (savedtagsfragment1 == null)
        {
            savedtagsfragment = new SavedTagsFragment();
            fragmentmanager.beginTransaction().add(savedtagsfragment, SavedTagsFragment.TAG).commit();
        }
        return savedtagsfragment;
    }

    public void onActionComplete(ActionCompleteEvent actioncompleteevent)
    {
        foldersAdapter.setSelectedMode(false);
        foldersAdapter.notifyDataSetChanged();
        toggleBottomSheet();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030090);
        authenticationManager = (AuthenticationManager)getApplicationBean(Keys.AUTHENTICATING_MANAGER);
        screenModeManager = (ScreenModeManager)getApplicationBean(Keys.SCREEN_MODE_MANAGER);
        mediaItemDao = (MediaItemDao)getApplicationBean(Keys.MEDIA_ITEM_DAO);
        tagDao = (TagDao)getApplicationBean(Keys.TAG_DAO);
        profiler = (Profiler)getApplicationBean(Keys.PROFILER);
        albumProfiler = new ComponentProfiler(profiler, "AlbumsMetrics");
        folderToAlbumMapper = new FolderToAlbumMapper(this);
        setupToolbar();
        setupContextBar();
        setupRecyclerView();
        setupConfiguration();
        setupBottomSheet();
        setupFolderToAlbumMapper();
        convertToAlbum = new ConvertFolderToAlbumAction(this, (NetworkConnectivity)getApplicationBean(Keys.NETWORK_CONNECTIVITY), profiler);
        getSupportLoaderManager().initLoader(LOADER_ID, null, this);
    }

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        return new CursorLoader(this, contentConfiguration.getContentUri(), contentConfiguration.getProjection(), contentConfiguration.getSelection(), contentConfiguration.getSelectionArgs(), sortType);
    }

    protected void onDestroy()
    {
        super.onDestroy();
        getSupportLoaderManager().destroyLoader(LOADER_ID);
    }

    public void onLoadFinished(Loader loader, Cursor cursor)
    {
        foldersAdapter.updateCursor(cursor);
    }

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (Cursor)obj);
    }

    public void onLoaderReset(Loader loader)
    {
        foldersAdapter.updateCursor(null);
    }

    public void onMultiSelectModeCommand(MultiSelectModeCommand multiselectmodecommand)
    {
        if (multiselectmodecommand.enabled)
        {
            enterSelectionMode();
            return;
        } else
        {
            exitSelectionMode();
            return;
        }
    }

    protected void onPause()
    {
        super.onPause();
        contextBar.onPause();
        GlobalMessagingBus.unregister(this);
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        bundle = getSavedTagsFragment().getSelectedTags();
        if (contextBar != null && bundle != null)
        {
            ((TagContextBar)contextBar).restoreState(bundle);
            if (!bundle.isEmpty())
            {
                foldersAdapter.setSelectedMode(true);
                foldersAdapter.notifyDataSetChanged();
                toggleBottomSheet();
            }
        }
    }

    protected void onResume()
    {
        super.onResume();
        screenModeManager.setScreenMode(com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode.NORMAL_OPAQUE_UI, this);
        contextBar.onResume();
        GlobalMessagingBus.register(this);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        SavedTagsFragment savedtagsfragment = getSavedTagsFragment();
        if (contextBar.isContextBarActive())
        {
            savedtagsfragment.setSelectedTags(((TagContextBar)contextBar).getSelectables());
        } else
        {
            savedtagsfragment.setSelectedTags(null);
        }
        super.onSaveInstanceState(bundle);
    }

    public void onSortingChanged(int i)
    {
        i;
        JVM INSTR tableswitch 2131493517 2131493517: default 20
    //                   2131493517 48;
           goto _L1 _L2
_L1:
        sortType = com.amazon.gallery.framework.gallery.widget.TagListAdapter.SortType.NAME_ASC.getSortOrder().getOrderByString();
_L4:
        getSupportLoaderManager().restartLoader(LOADER_ID, null, this);
        return;
_L2:
        sortType = com.amazon.gallery.framework.gallery.widget.TagListAdapter.SortType.DATE_DESC.getSortOrder().getOrderByString();
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void recordOnResumeMetrics()
    {
        com.amazon.gallery.thor.albums.AlbumsMetricsHelper.MetricsEvent metricsevent = com.amazon.gallery.thor.albums.AlbumsMetricsHelper.MetricsEvent.FolderMigrationsViewAll;
        albumProfiler.trackEvent(metricsevent, AlbumsMetricsHelper.createMetricsExtra(metricsevent.name(), null, null));
    }






}
