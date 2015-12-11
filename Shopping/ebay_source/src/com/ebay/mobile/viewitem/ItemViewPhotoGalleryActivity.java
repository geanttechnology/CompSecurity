// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.common.PhotoGalleryWidget;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.image.ZoomUrlRewriter;
import com.ebay.nautilus.shell.content.FwLoader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ItemViewBaseActivity

public class ItemViewPhotoGalleryActivity extends ItemViewBaseActivity
{

    private static final int DEFAULT_AUTO_SCROLL_DELAY = 4000;
    public static final String EXTRA_PHOTO_TITLE = "photo.gallery.title";
    public static final String EXTRA_PHOTO_URLS = "photo.gallery.urls";
    public static final String EXTRA_PHOTO_URLS_AUTO_SCROLL = "photo.gallery.autoscroll";
    public static final String EXTRA_PHOTO_URLS_POSITION = "photo.gallery.position";
    public static final String EXTRA_SHOW_SMALL_GALLERY = "photo.gallery.show.small.gallery";
    private static final int LOADER_ID_GET_PHOTO = 1000;
    private boolean autoScroll;
    private PhotoGalleryWidget largeGallery;
    private int position;
    private boolean showSmallGallery;
    private PhotoGalleryWidget smallGallery;
    private String title;
    private ArrayList urls;

    public ItemViewPhotoGalleryActivity()
    {
        title = null;
        showSmallGallery = true;
        autoScroll = false;
    }

    public static void StartActivity(Activity activity, Integer integer, List list)
    {
        Intent intent = new Intent(activity, com/ebay/mobile/viewitem/ItemViewPhotoGalleryActivity);
        intent.putStringArrayListExtra("photo.gallery.urls", new ArrayList(list));
        intent.putExtra("photo.gallery.position", integer);
        activity.startActivity(intent);
    }

    private ArrayList resizeImageUrls(ArrayList arraylist)
    {
        Object obj = DeviceConfiguration.getAsync();
        if (((DeviceConfiguration) (obj)).get(DcsBoolean.viewItemLargerImages) && arraylist != null && arraylist.size() > 0)
        {
            ArrayList arraylist1 = new ArrayList();
            Object obj1 = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(((DisplayMetrics) (obj1)));
            obj = new ZoomUrlRewriter(((DeviceConfiguration) (obj)), 2);
            if (((DisplayMetrics) (obj1)).widthPixels > ((DisplayMetrics) (obj1)).heightPixels)
            {
                ((ZoomUrlRewriter) (obj)).constrainHeight(((DisplayMetrics) (obj1)).heightPixels);
            } else
            {
                ((ZoomUrlRewriter) (obj)).constrainWidth(((DisplayMetrics) (obj1)).widthPixels);
            }
            obj1 = arraylist.iterator();
            do
            {
                arraylist = arraylist1;
                if (!((Iterator) (obj1)).hasNext())
                {
                    break;
                }
                arraylist = ((ZoomUrlRewriter) (obj)).rewriteUrl((String)((Iterator) (obj1)).next());
                if (!TextUtils.isEmpty(arraylist))
                {
                    arraylist1.add(arraylist);
                }
            } while (true);
        }
        return arraylist;
    }

    public String getTrackingEventName()
    {
        return "ViewItemPhoto";
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030141);
        Object obj = getSupportActionBar();
        if (obj != null)
        {
            ((ActionBar) (obj)).hide();
        }
        obj = getIntent();
        urls = ((Intent) (obj)).getStringArrayListExtra("photo.gallery.urls");
        position = ((Intent) (obj)).getIntExtra("photo.gallery.position", 0);
        title = ((Intent) (obj)).getStringExtra("photo.gallery.title");
        showSmallGallery = ((Intent) (obj)).getBooleanExtra("photo.gallery.show.small.gallery", true);
        autoScroll = ((Intent) (obj)).getBooleanExtra("photo.gallery.autoscroll", false);
        if (bundle != null)
        {
            position = bundle.getInt("photo.gallery.position");
        }
        if (title == null)
        {
            title = getResources().getString(0x7f070496);
        }
        if (1 >= urls.size())
        {
            showSmallGallery = false;
        }
        largeGallery = (PhotoGalleryWidget)((ViewGroup)findViewById(0x7f100329)).findViewById(0x7f1004af);
        largeGallery.setFwLoaderManager(getFwLoaderManager(), 1000);
        largeGallery.setSnapTo(Boolean.valueOf(true));
        largeGallery.setAllowPinchZoom(Boolean.valueOf(true));
        largeGallery.setPictureFrame(null);
        largeGallery.setBetweenPicturePadding(0);
        largeGallery.setPictureBackgroundColor(Integer.valueOf(getResources().getColor(0x106000c)));
        if (showSmallGallery)
        {
            smallGallery = (PhotoGalleryWidget)((ViewGroup)findViewById(0x7f10032a)).findViewById(0x7f1004af);
            smallGallery.setFwLoaderManager(getFwLoaderManager(), urls.size() + 1000);
            smallGallery.setAllowFixInPlace(true);
            smallGallery.setSquarePictures(Boolean.valueOf(true));
            smallGallery.setPictureFrame(null);
            largeGallery.setOnPhotoSelectedEvent(new com.ebay.mobile.common.PhotoGalleryWidget.OnPhotoSelectedEvent() {

                final ItemViewPhotoGalleryActivity this$0;

                public void OnPhotoSelected(int i)
                {
                    smallGallery.setSelectedIndex(i);
                }

            
            {
                this$0 = ItemViewPhotoGalleryActivity.this;
                super();
            }
            });
            smallGallery.setOnPhotoSelectedEvent(new com.ebay.mobile.common.PhotoGalleryWidget.OnPhotoSelectedEvent() {

                final ItemViewPhotoGalleryActivity this$0;

                public void OnPhotoSelected(int i)
                {
                    largeGallery.setSelectedIndex(i);
                    largeGallery.reloadPhotoIfNeeded(i);
                }

            
            {
                this$0 = ItemViewPhotoGalleryActivity.this;
                super();
            }
            });
        }
        largeGallery.setOnPhotoLoadedEvent(new com.ebay.mobile.common.PhotoGalleryWidget.OnPhotoLoadedEvent() {

            final ItemViewPhotoGalleryActivity this$0;

            public void OnPhotoLoaded(String s)
            {
                Util.setAppStatus(ItemViewPhotoGalleryActivity.this, title);
            }

            
            {
                this$0 = ItemViewPhotoGalleryActivity.this;
                super();
            }
        });
        largeGallery.updateUrls(resizeImageUrls(urls), 60);
        largeGallery.setSelectedIndex(position);
        if (autoScroll)
        {
            largeGallery.turnAutoScrollOn(4000L);
        }
        if (showSmallGallery)
        {
            smallGallery.updateUrls(urls, 10);
            smallGallery.setSelectedIndex(position);
        } else
        {
            findViewById(0x7f10032a).setVisibility(8);
        }
        (new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION)).send(this);
    }

    protected void onDestroy()
    {
        if (isFinishing())
        {
            largeGallery.recycle();
            if (smallGallery != null)
            {
                smallGallery.recycle();
            }
        }
        super.onDestroy();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putInt("photo.gallery.position", largeGallery.getCenterPhoto());
    }

    protected void onTaskComplete(int i, FwLoader fwloader)
    {
        if (!isFinishing())
        {
            if (i < urls.size() + 1000)
            {
                largeGallery.onTaskComplete(fwloader);
            } else
            if (smallGallery != null)
            {
                smallGallery.onTaskComplete(fwloader);
                return;
            }
        }
    }



}
