// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.Toolbar;
import android.util.Pair;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.foundation.utils.featuremanager.FeatureManager;
import com.amazon.gallery.foundation.utils.featuremanager.Features;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.foundation.utils.messaging.RefreshHeaderOptionsEvent;
import com.amazon.gallery.foundation.utils.messaging.RotationChangeEvent;
import com.amazon.gallery.foundation.utils.messaging.WhisperplayConnectionEvent;
import com.amazon.gallery.framework.data.dao.MediaItemSortType;
import com.amazon.gallery.framework.gallery.actions.AlbumInfoAction;
import com.amazon.gallery.framework.gallery.actions.DeleteAction;
import com.amazon.gallery.framework.gallery.actions.DownloadAction;
import com.amazon.gallery.framework.gallery.actions.GenericShareAction;
import com.amazon.gallery.framework.gallery.actions.HideAction;
import com.amazon.gallery.framework.gallery.actions.ImageRewindAction;
import com.amazon.gallery.framework.gallery.actions.RemoveAction;
import com.amazon.gallery.framework.gallery.actions.ShareAlbumAction;
import com.amazon.gallery.framework.gallery.actions.SwapIconAction;
import com.amazon.gallery.framework.gallery.actions.UnHideAction;
import com.amazon.gallery.framework.gallery.actions.ViewDescriptorAction;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.gallery.view.ViewNotificationManager;
import com.amazon.gallery.framework.kindle.action.EditMediaItemAction;
import com.amazon.gallery.framework.kindle.action.InfoAction;
import com.amazon.gallery.framework.kindle.action.LockscreenAction;
import com.amazon.gallery.framework.kindle.action.ManualUploadAction;
import com.amazon.gallery.framework.kindle.action.MultiselectModeAction;
import com.amazon.gallery.framework.kindle.action.PrintAction;
import com.amazon.gallery.framework.kindle.activity.OnSortingChangedListener;
import com.amazon.gallery.framework.kindle.activity.SingleViewActivity;
import com.amazon.gallery.framework.kindle.ui.NavigationBar;
import com.amazon.gallery.framework.model.media.CommonMediaProperty;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagType;
import com.amazon.gallery.thor.albums.AddToAlbumAction;
import com.amazon.gallery.thor.albums.CreateAlbumAction;
import com.amazon.gallery.thor.albums.SetCoverPhotoAction;
import com.amazon.gallery.thor.app.actions.LaunchCameraAction;
import com.amazon.gallery.thor.app.actions.SortAction;
import com.amazon.gallery.thor.app.actions.StartSlideshowAction;
import com.amazon.gallery.thor.app.actions.ThorActionFactory;
import com.amazon.gallery.thor.app.actions.WhisperplayToggleAction;
import com.amazon.gallery.thor.app.ui.MenuItemTinter;
import com.amazon.gallery.thor.view.PhotosNavigationPane;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            AndroidToolbar, GalleryToolbar, GalleryNavigationSetting

public class ThorActionBar extends NavigationBar
{

    private static final Pair HEADER_ACTIONS[] = {
        new Pair(com/amazon/gallery/framework/kindle/action/MultiselectModeAction, Integer.valueOf(0x7f0c024b)), new Pair(com/amazon/gallery/thor/app/actions/LaunchCameraAction, Integer.valueOf(0x7f0c024e)), new Pair(com/amazon/gallery/thor/app/actions/StartSlideshowAction, Integer.valueOf(0x7f0c0275)), new Pair(com/amazon/gallery/framework/gallery/actions/GenericShareAction, Integer.valueOf(0x7f0c027b)), new Pair(com/amazon/gallery/framework/gallery/actions/RemoveAction, Integer.valueOf(0x7f0c027d)), new Pair(com/amazon/gallery/framework/gallery/actions/DeleteAction, Integer.valueOf(0x7f0c0274)), new Pair(com/amazon/gallery/framework/kindle/action/EditMediaItemAction, Integer.valueOf(0x7f0c027c)), new Pair(com/amazon/gallery/framework/kindle/action/ManualUploadAction, Integer.valueOf(0x7f0c027f)), new Pair(com/amazon/gallery/framework/kindle/action/PrintAction, Integer.valueOf(0x7f0c0283)), new Pair(com/amazon/gallery/framework/kindle/action/InfoAction, Integer.valueOf(0x7f0c0284)), 
        new Pair(com/amazon/gallery/framework/gallery/actions/DownloadAction, Integer.valueOf(0x7f0c027e)), new Pair(com/amazon/gallery/thor/app/actions/WhisperplayToggleAction, Integer.valueOf(0x7f0c024d)), new Pair(com/amazon/gallery/thor/app/actions/SortAction, Integer.valueOf(0x7f0c023a)), new Pair(com/amazon/gallery/framework/kindle/action/LockscreenAction, Integer.valueOf(0x7f0c0285)), new Pair(com/amazon/gallery/thor/albums/AddToAlbumAction, Integer.valueOf(0x7f0c0277)), new Pair(com/amazon/gallery/thor/albums/CreateAlbumAction, Integer.valueOf(0x7f0c024c)), new Pair(com/amazon/gallery/framework/gallery/actions/ImageRewindAction, Integer.valueOf(0x7f0c0280)), new Pair(com/amazon/gallery/framework/gallery/actions/AlbumInfoAction, Integer.valueOf(0x7f0c027a)), new Pair(com/amazon/gallery/thor/albums/SetCoverPhotoAction, Integer.valueOf(0x7f0c0286))
    };
    private static final String TAG = com/amazon/gallery/thor/app/activity/ThorActionBar.getName();
    private final int ACTIVE_COLOR;
    private final int ICON_COLOR;
    private BeanAwareActivity activity;
    private Drawable background;
    private int currentMenu;
    private boolean currentMenuInflated;
    private int lastBackgroundAlphaTarget;
    private MediaItem lastMediaItem;
    private ViewDescriptor lastViewDescriptor;
    private PhotosNavigationPane photosNavigationPane;
    private boolean sortEnabled;
    protected GalleryToolbar toolbar;

    public ThorActionBar(PhotosNavigationPane photosnavigationpane, BeanAwareActivity beanawareactivity, boolean flag, Toolbar toolbar1)
    {
        super(beanawareactivity);
        currentMenu = -1;
        currentMenuInflated = false;
        photosNavigationPane = photosnavigationpane;
        ICON_COLOR = beanawareactivity.getResources().getColor(0x7f090091);
        ACTIVE_COLOR = beanawareactivity.getResources().getColor(0x7f090004);
        if (photosnavigationpane != null)
        {
            photosnavigationpane.setEnabledChangedListener(new com.amazon.gallery.thor.view.PhotosNavigationPane.EnabledChangedListener() {

                final ThorActionBar this$0;

                public void OnEnabledChanged(boolean flag1)
                {
                    viewStateRefresh();
                }

            
            {
                this$0 = ThorActionBar.this;
                super();
            }
            });
        }
        decorOverlayEnabled = flag;
        activity = beanawareactivity;
        toolbar = new AndroidToolbar(beanawareactivity, toolbar1, photosnavigationpane);
        background = toolbar.getBackground();
        lastBackgroundAlphaTarget = 255;
        photosnavigationpane = getHeaderActions();
        int j = photosnavigationpane.length;
        for (int i = 0; i < j; i++)
        {
            Object obj = photosnavigationpane[i];
            actions.put(((Integer)((Pair) (obj)).second).intValue(), ThorActionFactory.createViewDescriptorAction(beanawareactivity, (Class)((Pair) (obj)).first));
        }

        if (FeatureManager.isFeatureEnabled(Features.HIDE))
        {
            actions.put(0x7f0c0281, ThorActionFactory.createViewDescriptorAction(beanawareactivity, com/amazon/gallery/framework/gallery/actions/HideAction));
            actions.put(0x7f0c0282, ThorActionFactory.createViewDescriptorAction(beanawareactivity, com/amazon/gallery/framework/gallery/actions/UnHideAction));
            if (beanawareactivity.getIntent().getBooleanExtra("view_hidden_content_button", false))
            {
                actions.remove(0x7f0c0275);
            }
        }
        actions.put(0x7f0c0279, ThorActionFactory.createThorAction(beanawareactivity, com/amazon/gallery/framework/gallery/actions/ShareAlbumAction));
        actions.put(0x7f0c027a, ThorActionFactory.createViewDescriptorAction(beanawareactivity, com/amazon/gallery/framework/gallery/actions/AlbumInfoAction));
        setNavBarLayout(toolbar1);
        adjustMargin();
        GlobalMessagingBus.register(this);
    }

    private void onAction(MenuItem menuitem)
    {
        menuitem = (ViewDescriptorAction)actions.get(menuitem.getItemId());
        if (menuitem != null)
        {
            menuitem.executeViewDescriptor(lastViewDescriptor, lastMediaItem);
        }
    }

    private void refreshHeaderOptions()
    {
        activity.runOnUiThread(new Runnable() {

            final ThorActionBar this$0;

            public void run()
            {
                updateHeaderOptions(lastViewDescriptor, lastMediaItem);
            }

            
            {
                this$0 = ThorActionBar.this;
                super();
            }
        });
    }

    private void removeSortMenu()
    {
        toolbar.removeRefineMenus();
        toolbar.invalidateActionsMenu();
    }

    protected void executeOnRotation()
    {
        super.executeOnRotation();
        GlobalMessagingBus.post(new RotationChangeEvent(activity.getResources().getConfiguration().orientation));
    }

    protected Pair[] getHeaderActions()
    {
        return HEADER_ACTIONS;
    }

    public void initGallerySortOptions(ViewDescriptor viewdescriptor)
    {
        MediaItemSortType mediaitemsorttype = viewdescriptor.getMediaItemSortType();
        boolean flag;
        if (viewdescriptor.getCollectionType() == com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.EVERYTHING || viewdescriptor.getCollectionType() == com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.MEDIA_TYPE)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (mediaitemsorttype == null)
        {
            if (flag)
            {
                toolbar.setupSort(0x7f100014, 0x7f0c0290);
                return;
            } else
            {
                toolbar.setupSort(0x7f100013, 0x7f0c028e);
                return;
            }
        }
        static class _cls5
        {

            static final int $SwitchMap$com$amazon$gallery$framework$data$dao$MediaItemSortType[];

            static 
            {
                $SwitchMap$com$amazon$gallery$framework$data$dao$MediaItemSortType = new int[MediaItemSortType.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$data$dao$MediaItemSortType[MediaItemSortType.DATE_TAKEN_DESC.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$data$dao$MediaItemSortType[MediaItemSortType.TIME_STAMP_DESC.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$data$dao$MediaItemSortType[MediaItemSortType.DATE_TAKEN_ASC.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$data$dao$MediaItemSortType[MediaItemSortType.TIME_STAMP_ASC.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$data$dao$MediaItemSortType[MediaItemSortType.DATE_ADDED_DESC.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$data$dao$MediaItemSortType[MediaItemSortType.DATE_ADDED_ASC.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls5..SwitchMap.com.amazon.gallery.framework.data.dao.MediaItemSortType[mediaitemsorttype.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
        case 2: // '\002'
            if (flag)
            {
                toolbar.setupSort(0x7f100014, 0x7f0c0290);
                return;
            } else
            {
                toolbar.setupSort(0x7f100013, 0x7f0c028e);
                return;
            }

        case 3: // '\003'
        case 4: // '\004'
            if (flag)
            {
                toolbar.setupSort(0x7f100014, 0x7f0c0290);
                return;
            } else
            {
                toolbar.setupSort(0x7f100013, 0x7f0c028f);
                return;
            }

        case 5: // '\005'
            toolbar.setupSort(0x7f100014, 0x7f0c0291);
            return;

        case 6: // '\006'
            toolbar.setupSort(0x7f100014, 0x7f0c0291);
            return;
        }
    }

    public boolean isDestroyed()
    {
        return activity == null;
    }

    protected boolean isTintEnabled()
    {
        return true;
    }

    protected boolean isTranslucent()
    {
        return decorOverlayEnabled || activity.getResources().getDimension(0x7f0a0052) > 0.0F;
    }

    protected boolean isTransparent()
    {
        return false;
    }

    public void onDestroy()
    {
        if (viewNotificationManager != null)
        {
            viewNotificationManager.removeListener(viewStateListener);
        }
        activity = null;
        GlobalMessagingBus.unregister(this);
    }

    public void onRefreshHeaderOptionsEvent(RefreshHeaderOptionsEvent refreshheaderoptionsevent)
    {
        refreshHeaderOptions();
    }

    public void onWhisperplayConnectionEvent(WhisperplayConnectionEvent whisperplayconnectionevent)
    {
        refreshHeaderOptions();
    }

    protected void removeCounter()
    {
        toolbar.setSubtitle("");
        toolbar.invalidateActionsMenu();
    }

    public void resetBackground()
    {
        resetBackground(false);
    }

    public void resetBackground(boolean flag)
    {
        if (isTransparent())
        {
            background.setAlpha(0);
        } else
        {
            int i = 255;
            if (isTranslucent())
            {
                i = 196;
            }
            if (flag || i != lastBackgroundAlphaTarget)
            {
                ObjectAnimator objectanimator = ObjectAnimator.ofInt(background, "alpha", new int[] {
                    lastBackgroundAlphaTarget, i
                });
                objectanimator.setDuration(450L);
                objectanimator.start();
                lastBackgroundAlphaTarget = i;
                return;
            }
        }
    }

    public void setNavigationSetting(GalleryNavigationSetting gallerynavigationsetting)
    {
        toolbar.setNavigationSetting(gallerynavigationsetting);
    }

    public void setTitle(CharSequence charsequence)
    {
        toolbar.setTitle(charsequence);
    }

    public void setup(int i, int j, int k, OnSortingChangedListener onsortingchangedlistener)
    {
        toolbar.setOnSortChangedListener(onsortingchangedlistener);
        toolbar.setupSort(j, k);
        if (i != -1)
        {
            currentMenu = i;
            currentMenuInflated = false;
        }
        toolbar.setOnMenuItemClickListener(new android.support.v7.widget.Toolbar.OnMenuItemClickListener() {

            final ThorActionBar this$0;

            public boolean onMenuItemClick(MenuItem menuitem)
            {
                onAction(menuitem);
                return true;
            }

            
            {
                this$0 = ThorActionBar.this;
                super();
            }
        });
        toolbar.setNavigationOnClickListener(new android.view.View.OnClickListener() {

            final ThorActionBar this$0;

            private void defaultOnNavigationClickListener()
            {
                if (toolbar.getNavigationSetting() == GalleryNavigationSetting.BACK)
                {
                    activity.onBackPressed();
                } else
                if (photosNavigationPane != null)
                {
                    photosNavigationPane.open();
                    return;
                }
            }

            public void onClick(View view)
            {
                defaultOnNavigationClickListener();
            }

            
            {
                this$0 = ThorActionBar.this;
                super();
            }
        });
    }

    protected void updateCounter(String s)
    {
        toolbar.removeRefineMenus();
        toolbar.setSubtitle(s);
    }

    public void updateHeaderOptions(ViewDescriptor viewdescriptor, MediaItem mediaitem)
    {
        lastViewDescriptor = viewdescriptor;
        lastMediaItem = mediaitem;
        if (currentMenu != -1)
        {
            if (!currentMenuInflated)
            {
                toolbar.inflateMenu(currentMenu);
                currentMenuInflated = true;
            }
            Menu menu = toolbar.getMenu();
            int j = ICON_COLOR;
            boolean flag = isTintEnabled();
            if (menu != null)
            {
                int i = 0;
                while (i < menu.size()) 
                {
                    MenuItem menuitem = menu.getItem(i);
                    Object obj = (ViewDescriptorAction)actions.get(menuitem.getItemId());
                    int k;
                    if (obj == null || !((ViewDescriptorAction) (obj)).canExecute(viewdescriptor, mediaitem))
                    {
                        menuitem.setEnabled(false);
                        menuitem.setVisible(false);
                        k = j;
                    } else
                    {
                        menuitem.setEnabled(true);
                        menuitem.setVisible(true);
                        k = j;
                        if (obj instanceof SwapIconAction)
                        {
                            obj = (SwapIconAction)obj;
                            menuitem.setIcon(((SwapIconAction) (obj)).getIcon());
                            menuitem.setTitle(((SwapIconAction) (obj)).getText());
                            k = j;
                            if (((SwapIconAction) (obj)).isActive())
                            {
                                k = ACTIVE_COLOR;
                            }
                        }
                    }
                    if (flag)
                    {
                        MenuItemTinter.applyTint(menuitem.getIcon(), k);
                    }
                    i++;
                    j = k;
                }
                toolbar.invalidateActionsMenu();
                adjustMargin();
                return;
            }
        }
    }

    public void updateMenuItemsForTagType(TagType tagtype)
    {
        boolean flag;
        if (tagtype == TagType.ALBUM)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        tagtype = toolbar.getMenu();
        if (tagtype != null)
        {
            for (int i = 0; i < tagtype.size(); i++)
            {
                MenuItem menuitem = tagtype.getItem(i);
                if (menuitem.getItemId() == 0x7f0c024c)
                {
                    menuitem.setVisible(flag);
                    menuitem.setEnabled(flag);
                    int j = activity.getResources().getColor(0x7f090091);
                    MenuItemTinter.applyTint(menuitem.getIcon(), j);
                }
            }

        }
    }

    protected void updateRefineSubtitleState(ViewDescriptor viewdescriptor)
    {
        if (viewdescriptor.getMediaItem() == null && sortEnabled)
        {
            return;
        } else
        {
            removeSortMenu();
            super.updateRefineSubtitleState(viewdescriptor);
            return;
        }
    }

    protected void updateTitle(String s)
    {
        toolbar.setTitle(s);
    }

    protected void updateTitleWidth(int i)
    {
        resetBackground();
    }

    public void viewStateChanged(ViewDescriptor viewdescriptor)
    {
        boolean flag2 = true;
        super.viewStateChanged(viewdescriptor);
        boolean flag;
        boolean flag1;
        if (viewdescriptor.getMediaItem() != null || (activity instanceof SingleViewActivity))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (viewdescriptor.getCollectionSize() > 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag || !flag1)
        {
            flag2 = false;
        }
        sortEnabled = flag2;
        initGallerySortOptions(viewdescriptor);
        updateRefineSubtitleState(viewdescriptor);
        resetBackground();
        if (photosNavigationPane != null && !photosNavigationPane.getSideBarEnabled())
        {
            toolbar.setNavigationSetting(GalleryNavigationSetting.ICON);
        } else
        {
            if (flag)
            {
                toolbar.setNavigationSetting(GalleryNavigationSetting.BACK);
                return;
            }
            if (viewdescriptor.getCollectionType() == com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.TAG || viewdescriptor.getCollectionType() == com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.DYNAMIC_ALBUM || viewdescriptor.getMediaProperty() == CommonMediaProperty.THISDAY)
            {
                toolbar.setNavigationSetting(GalleryNavigationSetting.BACK);
            } else
            {
                toolbar.setNavigationSetting(GalleryNavigationSetting.LEFT);
            }
            if (viewdescriptor.getTag() != null && viewdescriptor.getTag().getType() == TagType.SOURCE)
            {
                toolbar.setNavigationSetting(GalleryNavigationSetting.LEFT);
                return;
            }
        }
    }

    public void viewStateRefresh()
    {
        if (photosNavigationPane != null && !photosNavigationPane.getSideBarEnabled())
        {
            toolbar.setNavigationSetting(GalleryNavigationSetting.ICON);
        }
    }






}
