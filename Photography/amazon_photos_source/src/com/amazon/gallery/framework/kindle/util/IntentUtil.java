// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.amazon.gallery.foundation.utils.di.BeanAwareApplication;
import com.amazon.gallery.foundation.utils.di.BeanFactory;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.MediaItemSortType;
import com.amazon.gallery.framework.data.dao.ThisDayDBInfoProvider;
import com.amazon.gallery.framework.data.dao.filter.LocalVideoFilter;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.provider.FilterCollection;
import com.amazon.gallery.framework.kindle.provider.GalleryInternalContentProvider;
import com.amazon.gallery.framework.model.media.CommonMediaProperty;
import com.amazon.gallery.framework.model.media.MediaProperty;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.model.media.SyncState;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagType;
import com.amazon.gallery.thor.albums.AddToAlbumChooserActivity;
import com.amazon.gallery.thor.app.FreeTime;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.app.activity.ThorNativeGalleryActivity;
import com.amazon.gallery.thor.di.AppKeys;
import com.amazon.gallery.thor.removablestorage.RemovableStorageManager;
import com.amazon.gallery.thor.thisday.ThisDayViewDescriptor;
import java.io.File;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.amazon.gallery.framework.kindle.util:
//            CollectionUriUtil

public class IntentUtil
{

    private static final String TAG = com/amazon/gallery/framework/kindle/util/IntentUtil.getName();

    public IntentUtil()
    {
    }

    private static void addFilters(com.amazon.gallery.framework.kindle.provider.MediaContentConfiguration.Builder builder, Intent intent)
    {
        if (intent.getType() != null)
        {
            MediaType mediatype = getMediaTypeFromIntent(intent);
            if (mediatype != null)
            {
                builder.appendWhere("type", Integer.valueOf(mediatype.ordinal()));
            } else
            if (isChooser(intent))
            {
                builder.appendWhere(LocalVideoFilter.WHERE_CLAUSE);
                return;
            }
        }
    }

    public static com.amazon.gallery.framework.kindle.provider.MediaContentConfiguration.Builder createMediaContentConfigBuilderFromIntent(Context context, Intent intent)
    {
        com.amazon.gallery.framework.kindle.provider.MediaContentConfiguration.Builder builder = new com.amazon.gallery.framework.kindle.provider.MediaContentConfiguration.Builder();
        if (!isLaunchedByStorageSettings(intent)) goto _L2; else goto _L1
_L1:
        if (!isSdCardOnly(intent)) goto _L4; else goto _L3
_L3:
        builder.withUri(GalleryInternalContentProvider.createMediaPropertyUri(CommonMediaProperty.REMOVABLE));
_L12:
        context = getMediaTypeFromIntent(intent);
        if (context == null) goto _L6; else goto _L5
_L5:
        builder.appendWhere("type", Integer.valueOf(context.ordinal()));
_L8:
        return builder;
_L4:
        if (isLocalOnly(intent))
        {
            builder.withUri(GalleryInternalContentProvider.createMediaPropertyUri(CommonMediaProperty.LOCAL));
            if (((RemovableStorageManager)ThorGalleryApplication.getBean(Keys.REMOVABLE_STORAGE_MANAGER)).isRemovableStorageMounted())
            {
                builder.appendWhere(String.format("%s NOT LIKE '%s%%'", new Object[] {
                    "local_path", ((RemovableStorageManager)ThorGalleryApplication.getBean(Keys.REMOVABLE_STORAGE_MANAGER)).getRemovableStorageRootDirectory().getAbsolutePath()
                }));
            }
        }
        continue; /* Loop/switch isn't completed */
_L6:
        GLogger.e(TAG, "Inconsistent media type, or media type not provided", new Object[0]);
        return builder;
_L2:
        if (isLaunchedByCamera(intent) && !hasCameraUrisExtra(intent))
        {
            builder.withUri(FilterCollection.CAMERA_ROLL.getMediaContentUri()).withLabel(context.getString(0x7f0e0098));
            return builder;
        }
        if (!hasCameraUrisExtra(intent) && intent.getData() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        Object obj = intent.getStringArrayListExtra("com.amazon.camera.extras.URIs");
        if (obj != null)
        {
            builder.withUri(GalleryInternalContentProvider.createMetadataUri());
            builder.appendWhereIn("value", ((List) (obj)).toArray());
            return builder;
        }
        obj = intent.getData();
        builder.withUri(((Uri) (obj)));
        if (StringUtils.equals(((Uri) (obj)).getAuthority(), android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI.getAuthority()))
        {
            builder.appendWhere("value", intent.getData().toString());
            return builder;
        }
        obj = getMediaTypeFromIntent(intent);
        if (obj != null)
        {
            builder.appendWhere("type", Integer.valueOf(((MediaType) (obj)).ordinal()));
            return builder;
        }
        if (isThisDayIntent(intent))
        {
            updateMediaContentConfigurationBuilderForThisDay(context, builder, intent);
            return builder;
        }
        if (true) goto _L8; else goto _L7
_L7:
        if (!intent.hasExtra("collectionContentUri"))
        {
            break; /* Loop/switch isn't completed */
        }
        intent = Uri.parse(intent.getStringExtra("collectionContentUri"));
        if (CollectionUriUtil.isCollectionUri(context.getContentResolver(), intent))
        {
            builder.withUri(GalleryInternalContentProvider.createCollectionMediaUri(intent));
        } else
        if (CollectionUriUtil.isTagUri(context.getContentResolver(), intent))
        {
            builder.withUri(GalleryInternalContentProvider.createTagMediaUri(intent));
        }
        context = CollectionUriUtil.getLabelFromUri(context, intent);
        if (!context.isEmpty())
        {
            builder.withLabel(context);
            return builder;
        }
        if (true) goto _L8; else goto _L9
_L9:
        if (intent.hasExtra("mediaProperty"))
        {
            String s = intent.getStringExtra("mediaProperty");
            MediaProperty mediaproperty = MediaProperty.fromString(s);
            if (mediaproperty == null)
            {
                GLogger.w(TAG, "No MediaProperty found for mediaProperty extra %s", new Object[] {
                    s
                });
                builder.withUri(FilterCollection.ALL.getMediaContentUri()).withLabel(context.getString(0x7f0e0066));
            } else
            if (mediaproperty == CommonMediaProperty.CAMERA || mediaproperty == CommonMediaProperty.LOCAL)
            {
                builder.withUri(FilterCollection.CAMERA_ROLL.getMediaContentUri()).withLabel(context.getString(0x7f0e0098));
            } else
            {
                builder.withUri(GalleryInternalContentProvider.createMediaPropertyUri(mediaproperty));
            }
            addFilters(builder, intent);
            return builder;
        }
        if (intent.getBooleanExtra("mediaDynamicAlbum", false))
        {
            builder.withUri(GalleryInternalContentProvider.createDynamicAlbumContentUri(String.valueOf(((Tag)intent.getSerializableExtra("mediaTag")).getId())));
            addFilters(builder, intent);
            return builder;
        }
        if (intent.hasExtra("mediaTag"))
        {
            builder.withUri(GalleryInternalContentProvider.createTagMediaUri(GalleryInternalContentProvider.createTagUri(((Tag)intent.getSerializableExtra("mediaTag")).getId())));
            addFilters(builder, intent);
            return builder;
        }
        if (!intent.hasExtra("mediaType") && intent.getType() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        MediaType mediatype = getMediaTypeFromIntent(intent);
        if (mediatype != null)
        {
            if (mediatype == MediaType.VIDEO)
            {
                builder.withUri(FilterCollection.VIDEOS.getMediaContentUri()).withLabel(context.getString(0x7f0e0073));
            } else
            {
                builder.withUri(com.amazon.gallery.framework.kindle.provider.GalleryInternalContentProvider.MediaItem.CONTENT_URI).appendWhere("type", Integer.valueOf(mediatype.ordinal()));
            }
        } else
        {
            builder.withUri(com.amazon.gallery.framework.kindle.provider.GalleryInternalContentProvider.MediaItem.CONTENT_URI);
            if (StringUtils.equals(intent.getType(), "*/*"))
            {
                builder.appendWhere(LocalVideoFilter.WHERE_CLAUSE);
            }
        }
        if (isLocalOnly(intent))
        {
            builder.appendWhere("local_path IS NOT NULL");
            return builder;
        }
        if (true) goto _L8; else goto _L10
_L10:
        if (isThisDayIntent(intent))
        {
            updateMediaContentConfigurationBuilderForThisDay(context, builder, intent);
            return builder;
        }
        if (isInFreetime(context))
        {
            builder.withUri(FilterCollection.CAMERA_ROLL.getMediaContentUri()).withLabel(context.getString(0x7f0e0098));
            return builder;
        }
        builder.withUri(FilterCollection.ALL.getMediaContentUri()).withLabel(context.getString(0x7f0e0066));
        return builder;
        if (true) goto _L12; else goto _L11
_L11:
    }

    public static Intent getAddPhotosIntent()
    {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.addCategory("amazon.intent.category.PHOTOS_FTUE");
        intent.putExtra("START_AT_END", true);
        return intent;
    }

    public static Intent getAlbumContentsIntent(Context context, Tag tag)
    {
        context = new Intent(context, com/amazon/gallery/thor/app/activity/ThorNativeGalleryActivity);
        context.setAction("com.amazon.photos.INTERNAL");
        context.putExtra("mediaDynamicAlbum", true);
        context.putExtra("mediaTag", tag);
        return context;
    }

    public static Intent getAllViewIntent()
    {
        Intent intent = new Intent();
        intent.setAction("com.amazon.photos.LAUNCH_PHOTOS");
        return intent;
    }

    public static Intent getBaseAddToAlbumIntent(Context context)
    {
        context = new Intent(context, com/amazon/gallery/thor/albums/AddToAlbumChooserActivity);
        context.addFlags(0x40000000);
        return context;
    }

    public static Intent getCameraRollIntent()
    {
        Intent intent = getAllViewIntent();
        intent.putExtra("mediaProperty", CommonMediaProperty.CAMERA.getName());
        return intent;
    }

    public static Intent getCollectionListIntent(TagType tagtype)
    {
        if (tagtype == TagType.FOLDER)
        {
            return getFoldersIntent();
        } else
        {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("amazon.intent.category.PHOTOS_COLLECTION");
            intent.setFlags(0x4000000);
            intent.putExtra("tagType", tagtype.toString());
            return intent;
        }
    }

    private static Intent getFoldersIntent()
    {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.addCategory("amazon.intent.category.PHOTOS_FOLDERS");
        intent.setFlags(0x4000000);
        return intent;
    }

    public static MediaType getMediaTypeFromIntent(Intent intent)
    {
        Uri uri = null;
        if (intent.hasExtra("mediaType")) goto _L2; else goto _L1
_L1:
        Object obj = uri;
        if (intent.getType() == null) goto _L3; else goto _L2
_L2:
        String s;
        String s1;
        obj = intent.getStringExtra("mediaType");
        s = intent.getType();
        s1 = intent.getStringExtra("imageMediaType");
        if (s1 == null || !s1.equals("vnd.android.cursor.dir/image")) goto _L5; else goto _L4
_L4:
        obj = MediaType.PHOTO;
_L3:
        uri = intent.getData();
        intent = ((Intent) (obj));
        if (uri != null)
        {
            intent = ((Intent) (obj));
            if ("content".equals(uri.getScheme()))
            {
                intent = ((Intent) (obj));
                if ("media".equals(uri.getAuthority()))
                {
                    intent = ((Intent) (obj));
                    if (uri.getPath().contains("/video/"))
                    {
                        intent = MediaType.VIDEO;
                    }
                }
            }
        }
        return intent;
_L5:
        if (obj != null)
        {
            obj = MediaType.valueOf(((String) (obj)));
        } else
        if (s != null && s.matches("image/.*"))
        {
            obj = MediaType.PHOTO;
        } else
        {
            obj = uri;
            if (s != null)
            {
                obj = uri;
                if (s.matches("video/.*"))
                {
                    obj = MediaType.VIDEO;
                }
            }
        }
        if (true) goto _L3; else goto _L6
_L6:
    }

    public static Intent getThisDayCollectionViewIntent()
    {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.addCategory("amazon.intent.category.PHOTOS_THIS_DAY");
        intent.setFlags(0x4000000);
        return intent;
    }

    public static Intent getThisDayGalleryViewIntentForYear(int i, boolean flag)
    {
        Intent intent = getAllViewIntent();
        intent.putExtra("thisDayYear", i);
        intent.putExtra("weekData", flag);
        return intent;
    }

    public static Intent getVideoViewIntent()
    {
        Intent intent = getAllViewIntent();
        intent.putExtra("mediaType", MediaType.VIDEO.name());
        return intent;
    }

    public static boolean hasCameraUrisExtra(Intent intent)
    {
        return intent.hasExtra("com.amazon.camera.extras.URIs");
    }

    public static transient boolean hasExtras(Intent intent, String as[])
    {
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            if (!intent.hasExtra(as[i]))
            {
                return false;
            }
        }

        return true;
    }

    public static boolean isChooser(Intent intent)
    {
        return "android.intent.action.GET_CONTENT".equals(intent.getAction()) || "android.intent.action.PICK".equals(intent.getAction()) || intent.hasExtra("CHOOSER_ACTION");
    }

    private static boolean isInFreetime(Context context)
    {
        return ((FreeTime)((BeanAwareApplication)context.getApplicationContext()).getBeanFactory().getBean(AppKeys.THOR_FREE_TIME)).isFreeTime();
    }

    public static boolean isLaunchedByCamera(Intent intent)
    {
        return "com.android.camera.action.REVIEW".equals(intent.getAction());
    }

    public static boolean isLaunchedByStorageSettings(Intent intent)
    {
        return "com.amazon.gallery.LAUNCH_PHOTOS_STORAGE_MANAGER".equals(intent.getAction());
    }

    public static boolean isLocalOnly(Intent intent)
    {
        boolean flag = false;
        if (intent.getBooleanExtra("localOnly", false) || intent.getBooleanExtra("android.intent.extra.LOCAL_ONLY", false) || "LOCAL_MEDIA_ONLY".equals(intent.getStringExtra("location")))
        {
            flag = true;
        }
        return flag;
    }

    public static boolean isSdCardOnly(Intent intent)
    {
        return "SDCARD_MEDIA_ONLY".equals(intent.getStringExtra("location"));
    }

    public static boolean isThisDayIntent(Intent intent)
    {
        return intent.hasExtra("thisDayYear");
    }

    public static void setExtrasForDescriptor(ViewDescriptor viewdescriptor, Intent intent)
    {
        Tag tag = viewdescriptor.getTag();
        if (tag != null)
        {
            intent.putExtra("mediaTag", tag);
            if (viewdescriptor.getCollectionType().equals(com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.DYNAMIC_ALBUM))
            {
                intent.putExtra("mediaDynamicAlbum", true);
            }
        } else
        {
            if (viewdescriptor.getMediaProperty() == CommonMediaProperty.CAMERA)
            {
                intent.putExtra("mediaProperty", viewdescriptor.getMediaProperty().toString());
                return;
            }
            if (viewdescriptor.getMediaType() == MediaType.VIDEO)
            {
                intent.putExtra("mediaType", viewdescriptor.getMediaType().toString());
                return;
            }
            if (viewdescriptor.getMediaType() == MediaType.PHOTO)
            {
                intent.putExtra("mediaType", viewdescriptor.getMediaType().toString());
                return;
            }
            if (viewdescriptor.getThisDayViewDescriptor() != null)
            {
                viewdescriptor = viewdescriptor.getThisDayViewDescriptor();
                intent.putExtra("thisDayYear", ((ThisDayViewDescriptor) (viewdescriptor)).focusedYear);
                intent.putExtra("weekData", ((ThisDayViewDescriptor) (viewdescriptor)).isWeekData);
                intent.putExtra("shuffleData", ((ThisDayViewDescriptor) (viewdescriptor)).isShuffleData);
                intent.putExtra("thisDayItemDate", ((ThisDayViewDescriptor) (viewdescriptor)).focusedMediaItemCreationDate);
                return;
            }
        }
    }

    private static void updateMediaContentConfigurationBuilderForThisDay(Context context, com.amazon.gallery.framework.kindle.provider.MediaContentConfiguration.Builder builder, Intent intent)
    {
        Uri uri = intent.getData();
        int i = intent.getIntExtra("thisDayYear", 0);
        boolean flag = intent.getBooleanExtra("shuffleData", false);
        boolean flag1 = intent.getBooleanExtra("weekData", false);
        if (!flag)
        {
            builder.withUri(com.amazon.gallery.framework.kindle.provider.GalleryInternalContentProvider.MediaItem.CONTENT_URI);
            builder.appendWhere("sync_state", Integer.valueOf(SyncState.SYNCED.value));
            builder.appendWhere("date_created > 0");
            builder.appendWhere("strftime('%Y', time_stamp/1000, 'unixepoch')", Integer.valueOf(i));
            if (flag1)
            {
                builder.appendWhere(ThisDayDBInfoProvider.getContentProviderWeekWhere(context));
            } else
            {
                builder.appendWhere(ThisDayDBInfoProvider.getContentProviderDayWhere(context));
            }
            builder.withSortType(MediaItemSortType.TIME_STAMP_DESC);
        } else
        {
            if (uri != null)
            {
                builder.withUri(uri);
                return;
            }
            if (intent.getBooleanExtra("aviaryMediaItem", false))
            {
                builder.withUri(GalleryInternalContentProvider.createMediaItemUri(intent.getLongExtra("mediaItemId", -1L)));
                return;
            }
        }
    }

}
