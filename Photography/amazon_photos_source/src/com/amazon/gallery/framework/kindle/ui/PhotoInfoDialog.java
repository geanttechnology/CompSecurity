// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.ContentFetcher;
import com.amazon.gallery.framework.data.dao.MediaItemSortType;
import com.amazon.gallery.framework.gallery.dialog.DialogManager;
import com.amazon.gallery.framework.gallery.dialog.ShowDialogSyncTask;
import com.amazon.gallery.framework.gallery.messaging.ConfigurationContentFetcher;
import com.amazon.gallery.framework.gallery.messaging.ContentConfigurationEvent;
import com.amazon.gallery.framework.gallery.view.ContentConfiguration;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.gallery.view.overlay.VideoOverlayHelper;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.Video;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.commons.io.FileUtils;

public class PhotoInfoDialog
{

    private static final String TAG = com/amazon/gallery/framework/kindle/ui/PhotoInfoDialog.getName();
    private Context context;
    private Dialog popupDialog;

    public PhotoInfoDialog(Activity activity, MediaItem mediaitem)
    {
        context = activity;
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(activity);
        View view = activity.getLayoutInflater().inflate(0x7f0300c4, null);
        ContentConfiguration contentconfiguration = ((ContentConfigurationEvent)(new ConfigurationContentFetcher()).getContentFromProducer()).getContentConfiguration();
        MediaItemSortType mediaitemsorttype = MediaItemSortType.TIME_STAMP_DESC;
        if (contentconfiguration != null)
        {
            mediaitemsorttype = contentconfiguration.toViewDescriptor().getMediaItemSortType();
        }
        setupDateLabel(activity, view, mediaitemsorttype);
        setupDateField(view, mediaitem, mediaitemsorttype);
        setupNameField(view, mediaitem);
        setupDimensionField(view, mediaitem);
        setupDurationField(view, mediaitem);
        setupFilesizeField(view, mediaitem);
        view.findViewById(0x7f0c01be).setOnClickListener(new android.view.View.OnClickListener() {

            final PhotoInfoDialog this$0;

            public void onClick(View view1)
            {
                destroy();
            }

            
            {
                this$0 = PhotoInfoDialog.this;
                super();
            }
        });
        builder.setView(view);
        activity = activity.getString(0x7f0e0121);
        if (BuildFlavors.isDebug())
        {
            activity = mediaitem.getObjectId().toString();
        }
        builder.setTitle(activity);
        popupDialog = builder.create();
        popupDialog.setCancelable(true);
    }

    private void setupDateField(View view, MediaItem mediaitem, MediaItemSortType mediaitemsorttype)
    {
        Object obj;
        long l;
        if (Locale.getDefault().equals(new Locale("pt", "BR")))
        {
            obj = new SimpleDateFormat("EEEE, d 'de' MMMM 'de' y HH:mm:ss", Locale.getDefault());
        } else
        {
            obj = DateFormat.getDateTimeInstance(0, 2, Locale.getDefault());
        }
        if (mediaitemsorttype != MediaItemSortType.DATE_ADDED_ASC && mediaitemsorttype != MediaItemSortType.DATE_ADDED_DESC)
        {
            ((DateFormat) (obj)).setTimeZone(TimeZone.getTimeZone("UTC"));
        }
        if (mediaitemsorttype == null)
        {
            l = mediaitem.getTimestampMs();
        } else
        {
            l = mediaitemsorttype.getSortingDate(mediaitem);
        }
        ((TextView)view.findViewById(0x7f0c01b4)).setText(((DateFormat) (obj)).format(new Date(l)));
    }

    private static void setupDateLabel(Context context1, View view, MediaItemSortType mediaitemsorttype)
    {
        view = (TextView)view.findViewById(0x7f0c01b3);
        if (mediaitemsorttype == MediaItemSortType.DATE_ADDED_ASC || mediaitemsorttype == MediaItemSortType.DATE_ADDED_DESC)
        {
            view.setText(context1.getResources().getString(0x7f0e0160));
            return;
        } else
        {
            view.setText(context1.getResources().getString(0x7f0e015f));
            return;
        }
    }

    private void setupDimensionField(View view, MediaItem mediaitem)
    {
        ((TextView)view.findViewById(0x7f0c01b7)).setText((new StringBuilder()).append(mediaitem.getWidth()).append(" x ").append(mediaitem.getHeight()).toString());
    }

    private void setupDurationField(View view, MediaItem mediaitem)
    {
        if (mediaitem instanceof Video)
        {
            ((LinearLayout)view.findViewById(0x7f0c01b8)).setVisibility(0);
            mediaitem = VideoOverlayHelper.formatVideoDurationString(mediaitem);
            ((TextView)view.findViewById(0x7f0c01ba)).setText(mediaitem);
        }
    }

    private void setupFilesizeField(View view, MediaItem mediaitem)
    {
        TextView textview;
        boolean flag;
        boolean flag1;
        textview = (TextView)view.findViewById(0x7f0c01bd);
        flag1 = false;
        flag = flag1;
        if (mediaitem.getLocalPath() == null)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        textview.setText(FileUtils.byteCountToDisplaySize(FileUtils.sizeOfAsBigInteger(new File(mediaitem.getLocalPath()))));
        flag = true;
_L2:
        if (!flag)
        {
            view.findViewById(0x7f0c01bb).setVisibility(8);
        }
        return;
        mediaitem;
        GLogger.wx(TAG, "error getting file size", mediaitem);
        flag = flag1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void setupNameField(View view, MediaItem mediaitem)
    {
        ((TextView)view.findViewById(0x7f0c01b1)).setText(mediaitem.getName());
    }

    public void destroy()
    {
        popupDialog.dismiss();
        ((DialogManager)ThorGalleryApplication.getBean(Keys.DIALOG_MANAGER)).dismissActiveDialog();
    }

    public void show()
    {
        (new ShowDialogSyncTask((Activity)context) {

            final PhotoInfoDialog this$0;

            protected Dialog createDialog()
            {
                return popupDialog;
            }

            
            {
                this$0 = PhotoInfoDialog.this;
                super(activity);
            }
        }).queue();
    }


}
