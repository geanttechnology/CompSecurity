// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.provider;

import android.net.Uri;

public class CloudNodesContract
{
    public static final class AccountMetadataStates
    {

        public static Uri getContentUri(String s, String s1)
        {
            return CloudNodesContract.buildContentUri(s, s1, "account_metadata_states");
        }
    }

    public static final class Checkpoints
    {

        public static Uri getContentUri(String s, String s1)
        {
            return CloudNodesContract.buildContentUri(s, s1, "checkpoints");
        }
    }

    public static final class DocumentAuthors
    {

        public static Uri getContentUri(String s, String s1)
        {
            return CloudNodesContract.buildContentUri(s, s1, "document_authors");
        }
    }

    public static final class Events
    {

        public static Uri getContentUri(String s, String s1)
        {
            return CloudNodesContract.buildContentUri(s, s1, "events");
        }
    }

    public static final class MediaParents
    {

        public static Uri getContentUri(String s, String s1)
        {
            return CloudNodesContract.buildContentUri(s, s1, "cloud_media_parents");
        }
    }

    public static final class NodeChildren
    {

        public static Uri getContentUri(String s, String s1)
        {
            return CloudNodesContract.buildContentUri(s, s1, "cloud_node_children");
        }
    }

    public static final class NodeCoverPhotos
    {

        public static Uri getContentUri(String s, String s1)
        {
            return CloudNodesContract.buildContentUri(s, s1, "cloud_node_cover_photos");
        }
    }

    public static final class NodeLabels
    {

        public static Uri getContentUri(String s, String s1)
        {
            return CloudNodesContract.buildContentUri(s, s1, "cloud_node_labels");
        }
    }

    public static final class NodeParents
    {

        public static Uri getContentUri(String s, String s1)
        {
            return CloudNodesContract.buildContentUri(s, s1, "cloud_node_parents");
        }
    }

    public static final class NodeProperties
    {

        public static Uri getContentUri(String s, String s1)
        {
            return CloudNodesContract.buildContentUri(s, s1, "cloud_node_properties");
        }
    }

    public static final class NodeQueryExcludedIds
    {

        public static Uri getContentUri(String s, String s1)
        {
            return CloudNodesContract.buildContentUri(s, s1, "cloud_node_query_excluded_ids");
        }
    }

    public static final class NodeQueryInclude
    {

        public static Uri getContentUri(String s, String s1)
        {
            return CloudNodesContract.buildContentUri(s, s1, "cloud_node_query_include");
        }
    }

    public static final class NodeTransforms
    {

        public static Uri getContentUri(String s, String s1)
        {
            return CloudNodesContract.buildContentUri(s, s1, "cloud_node_transforms");
        }
    }

    public static final class Nodes
    {

        public static final String ALL_COLUMNS[] = {
            "event_id", "node_id", "change_type", "created_by", "created_date", "description", "exclusively_trashed", "is_root", "is_shared", "kind", 
            "modified_date", "name", "recursively_trashed", "restricted", "status", "version", "content_date", "content_type", "content_extension", "content_md5", 
            "content_size", "content_version", "document_version", "document_title", "image_aperture_value", "image_capture_mode", "image_color_space", "image_date_time", "image_date_time_digitized", "image_date_time_original", 
            "image_exposure_mode", "image_exposure_program", "image_exposure_time", "image_flash", "image_focal_length", "image_gps_time_stamp", "image_height", "image_iso_speed_ratings", "image_location", "image_make", 
            "image_metering_mode", "image_model", "image_orientation", "image_resolution_unit", "image_sensing_method", "image_sharpness", "image_software", "image_white_balance", "image_width", "image_x_resolution", 
            "image_y_resolution", "is_content", "is_document", "is_image", "is_video", "video_audio_bitrate", "video_audio_channels", "video_audio_channel_layout", "video_audio_codec", "video_audio_sample_rate", 
            "video_creation_date", "video_duration", "video_encoder", "video_height", "video_location", "video_make", "video_model", "video_rotate", "video_title", "video_bitrate", 
            "video_overall_bitrate", "video_codec", "video_frame_rate", "video_width", "favorite", "hidden", "metadata_version", "has_share_parent"
        };

        public static Uri getContentUri(String s, String s1)
        {
            return CloudNodesContract.buildContentUri(s, s1, "cloud_nodes");
        }

    }


    private static Uri buildContentUri(String s, String s1, String s2)
    {
        return Uri.parse((new StringBuilder()).append("content://").append(s).append("/").append(s1).append("/").append(s2).toString());
    }

}
