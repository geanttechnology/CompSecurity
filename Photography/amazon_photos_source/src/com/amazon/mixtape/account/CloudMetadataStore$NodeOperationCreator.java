// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.account;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.amazon.clouddrive.extended.model.NodeExtended;
import com.amazon.clouddrive.model.ContentProperties;
import com.amazon.clouddrive.model.DocumentProperties;
import com.amazon.clouddrive.model.ImageProperties;
import com.amazon.clouddrive.model.Settings;
import com.amazon.clouddrive.model.VideoProperties;
import com.amazon.mixtape.utils.DateUtils;
import java.io.Closeable;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.mixtape.account:
//            CloudMetadataStore, NodePropertiesOperationCreator

private static class <init>
    implements Closeable
{

    private final String mCloudNodesProviderAuthority;
    private final Uri mContentUri;
    private final SQLiteDatabase mDatabase;
    private final ionCreator mDocumentAuthorsOperationCreator;
    private final ionCreator mNodeCoverPhotosOperationCreator;
    private final eator mNodeLabelsOperationCreator;
    private final reator mNodeParentsOperationCreator;
    private final NodePropertiesOperationCreator mNodePropertiesOperationCreator;
    private final ator mNodeQueryOperationCreator;
    private final onCreator mNodeTransformsOperationCreator;

    private void setNodeContentValues(ContentValues contentvalues, long l, NodeExtended nodeextended, String s)
    {
        contentvalues.put("event_id", Long.valueOf(l));
        contentvalues.put("node_id", nodeextended.getId());
        contentvalues.put("change_type", s);
        contentvalues.put("created_by", nodeextended.getCreatedBy());
        contentvalues.put("created_date", nodeextended.getCreatedDate());
        contentvalues.put("description", nodeextended.getDescription());
        contentvalues.put("exclusively_trashed", nodeextended.isExclusivelyTrashed());
        contentvalues.put("is_root", nodeextended.isRoot());
        contentvalues.put("is_shared", nodeextended.isShared());
        contentvalues.put("kind", nodeextended.getKind());
        contentvalues.put("modified_date", nodeextended.getModifiedDate());
        contentvalues.put("name", nodeextended.getName());
        contentvalues.put("recursively_trashed", nodeextended.isRecursivelyTrashed());
        contentvalues.put("restricted", nodeextended.isRestricted());
        contentvalues.put("status", nodeextended.getStatus());
        contentvalues.put("version", Long.valueOf(nodeextended.getVersion()));
        contentvalues.put("metadata_version", Integer.valueOf(5));
        s = nodeextended.getContentProperties();
        boolean flag;
        if (s != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        contentvalues.put("is_content", Boolean.valueOf(flag));
        if (s != null)
        {
            contentvalues.put("content_date", s.getContentDate());
            contentvalues.put("content_type", s.getContentType());
            contentvalues.put("content_extension", s.getExtension());
            contentvalues.put("content_md5", s.getMd5());
            contentvalues.put("content_size", s.getSize());
            contentvalues.put("content_version", s.getVersion());
            contentvalues.put("content_sort_date", DateUtils.getSortDate(nodeextended));
            Object obj = s.getDocument();
            if (obj != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            contentvalues.put("is_document", Boolean.valueOf(flag));
            if (obj != null)
            {
                contentvalues.put("document_version", ((DocumentProperties) (obj)).getDocumentVersion());
                contentvalues.put("document_title", ((DocumentProperties) (obj)).getTitle());
            }
            obj = s.getImage();
            if (obj != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            contentvalues.put("is_image", Boolean.valueOf(flag));
            if (obj != null)
            {
                contentvalues.put("image_aperture_value", ((ImageProperties) (obj)).getApertureValue());
                contentvalues.put("image_capture_mode", ((ImageProperties) (obj)).getCaptureMode());
                contentvalues.put("image_color_space", ((ImageProperties) (obj)).getColorSpace());
                contentvalues.put("image_date_time", ((ImageProperties) (obj)).getDateTime());
                contentvalues.put("image_date_time_digitized", ((ImageProperties) (obj)).getDateTimeDigitized());
                contentvalues.put("image_date_time_original", ((ImageProperties) (obj)).getDateTimeOriginal());
                contentvalues.put("image_exposure_mode", ((ImageProperties) (obj)).getExposureMode());
                contentvalues.put("image_exposure_program", ((ImageProperties) (obj)).getExposureProgram());
                contentvalues.put("image_exposure_time", ((ImageProperties) (obj)).getExposureTime());
                contentvalues.put("image_flash", ((ImageProperties) (obj)).getFlash());
                contentvalues.put("image_focal_length", ((ImageProperties) (obj)).getFocalLength());
                contentvalues.put("image_gps_time_stamp", ((ImageProperties) (obj)).getGpsTimeStamp());
                contentvalues.put("image_height", ((ImageProperties) (obj)).getHeight());
                contentvalues.put("image_iso_speed_ratings", ((ImageProperties) (obj)).getIsoSpeedRatings());
                contentvalues.put("image_location", ((ImageProperties) (obj)).getLocation());
                contentvalues.put("image_make", ((ImageProperties) (obj)).getMake());
                contentvalues.put("image_metering_mode", ((ImageProperties) (obj)).getMeteringMode());
                contentvalues.put("image_model", ((ImageProperties) (obj)).getModel());
                contentvalues.put("image_orientation", ((ImageProperties) (obj)).getOrientation());
                contentvalues.put("image_resolution_unit", ((ImageProperties) (obj)).getResolutionUnit());
                contentvalues.put("image_sensing_method", ((ImageProperties) (obj)).getSensingMethod());
                contentvalues.put("image_sharpness", ((ImageProperties) (obj)).getSharpness());
                contentvalues.put("image_software", ((ImageProperties) (obj)).getSoftware());
                contentvalues.put("image_white_balance", ((ImageProperties) (obj)).getWhiteBalance());
                contentvalues.put("image_width", ((ImageProperties) (obj)).getWidth());
                contentvalues.put("image_x_resolution", ((ImageProperties) (obj)).getXResolution());
                contentvalues.put("image_y_resolution", ((ImageProperties) (obj)).getYResolution());
            }
            s = s.getVideo();
            if (s != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            contentvalues.put("is_video", Boolean.valueOf(flag));
            if (s != null)
            {
                contentvalues.put("video_audio_bitrate", s.getAudioBitrate());
                contentvalues.put("video_audio_channels", s.getAudioChannels());
                contentvalues.put("video_audio_channel_layout", s.getAudioChannelLayout());
                contentvalues.put("video_audio_codec", s.getAudioCodec());
                contentvalues.put("video_audio_sample_rate", s.getAudioSampleRate());
                contentvalues.put("video_creation_date", s.getCreationDate());
                contentvalues.put("video_duration", s.getDuration());
                contentvalues.put("video_encoder", s.getEncoder());
                contentvalues.put("video_height", s.getHeight());
                contentvalues.put("video_location", s.getLocation());
                contentvalues.put("video_make", s.getMake());
                contentvalues.put("video_model", s.getModel());
                contentvalues.put("video_rotate", s.getRotate());
                contentvalues.put("video_title", s.getTitle());
                contentvalues.put("video_bitrate", s.getVideoBitrate());
                contentvalues.put("video_overall_bitrate", s.getBitrate());
                contentvalues.put("video_codec", s.getVideoCodec());
                contentvalues.put("video_frame_rate", s.getVideoFrameRate());
                contentvalues.put("video_width", s.getWidth());
            }
        }
        s = nodeextended.getSettings();
        if (s != null)
        {
            contentvalues.put("favorite", Boolean.valueOf(Boolean.TRUE.equals(s.isFavorite())));
            contentvalues.put("hidden", Boolean.valueOf(Boolean.TRUE.equals(s.isHidden())));
        } else
        {
            contentvalues.put("favorite", Boolean.valueOf(false));
            contentvalues.put("hidden", Boolean.valueOf(false));
        }
        nodeextended = nodeextended.getParentMap();
        if (nodeextended != null && nodeextended.containsKey("SHARED_COLLECTION"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        contentvalues.put("has_share_parent", Boolean.valueOf(flag));
    }

    public void close()
    {
        mNodeParentsOperationCreator.close();
        mNodePropertiesOperationCreator.close();
        mNodeLabelsOperationCreator.close();
        mDocumentAuthorsOperationCreator.close();
        mNodeTransformsOperationCreator.close();
        mNodeCoverPhotosOperationCreator.close();
        mNodeQueryOperationCreator.close();
    }

    public void insertOrUpdate(long l, NodeExtended nodeextended, Set set)
    {
        ContentValues contentvalues = new ContentValues();
        setNodeContentValues(contentvalues, l, nodeextended, CloudMetadataStore.access$1500(nodeextended));
        if (mDatabase.insertWithOnConflict("cloud_nodes", null, contentvalues, 4) != -1L)
        {
            mNodeLabelsOperationCreator.insert(l, nodeextended, set);
            mNodeParentsOperationCreator.insert(l, nodeextended, set);
            mNodePropertiesOperationCreator.insert(l, nodeextended, set);
            mDocumentAuthorsOperationCreator.insert(l, nodeextended, set);
            mNodeTransformsOperationCreator.insert(l, nodeextended, set);
            mNodeCoverPhotosOperationCreator.insert(l, nodeextended, set);
            mNodeQueryOperationCreator.insert(l, nodeextended, set);
            set.add(mContentUri);
        } else
        {
            String as[] = com.amazon.mixtape.provider.ContentUri;
            int j = as.length;
            for (int i = 0; i < j; i++)
            {
                String s = as[i];
                if (contentvalues.get(s) == null)
                {
                    contentvalues.putNull(s);
                }
            }

            if ((long)mDatabase.updateWithOnConflict("cloud_nodes", contentvalues, "node_id = ? AND ( version < ? OR metadata_version is null OR metadata_version < ? )", new String[] {
    nodeextended.getId(), Long.toString(nodeextended.getVersion()), contentvalues.getAsString("metadata_version")
}, 4) > 0L)
            {
                mNodeLabelsOperationCreator.insert(l, nodeextended, set);
                mNodeParentsOperationCreator.insert(l, nodeextended, set);
                mNodePropertiesOperationCreator.insert(l, nodeextended, set);
                mDocumentAuthorsOperationCreator.insert(l, nodeextended, set);
                mNodeTransformsOperationCreator.insert(l, nodeextended, set);
                mNodeCoverPhotosOperationCreator.insert(l, nodeextended, set);
                mNodeQueryOperationCreator.insert(l, nodeextended, set);
                set.add(mContentUri);
                return;
            }
        }
    }

    private onCreator(SQLiteDatabase sqlitedatabase, String s, String s1)
    {
        mDatabase = sqlitedatabase;
        mCloudNodesProviderAuthority = s;
        mNodeLabelsOperationCreator = new eator(sqlitedatabase, s, s1, null);
        mNodeParentsOperationCreator = new reator(sqlitedatabase, s, s1, null);
        mNodePropertiesOperationCreator = new NodePropertiesOperationCreator(sqlitedatabase, s, s1);
        mDocumentAuthorsOperationCreator = new ionCreator(sqlitedatabase, s, s1, null);
        mNodeTransformsOperationCreator = new onCreator(sqlitedatabase, s, s1, null);
        mNodeCoverPhotosOperationCreator = new ionCreator(sqlitedatabase, s, s1, null);
        mNodeQueryOperationCreator = new ator(sqlitedatabase, s, s1, null);
        mContentUri = com.amazon.mixtape.provider.ContentUri(mCloudNodesProviderAuthority, s1);
    }

    mCloudNodesProviderAuthority(SQLiteDatabase sqlitedatabase, String s, String s1, mCloudNodesProviderAuthority mcloudnodesproviderauthority)
    {
        this(sqlitedatabase, s, s1);
    }
}
