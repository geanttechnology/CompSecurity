// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.media;

import android.os.Bundle;
import android.text.TextUtils;
import com.disney.datg.videoplatforms.sdk.utils.LogUtils;
import com.disney.datg.videoplatforms.sdk.utils.UplynkUtils;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.media:
//            VPMedia

public class VPMediaMetadata
{
    public static final class BoundaryEvents extends Enum
    {

        private static final BoundaryEvents $VALUES[];
        public static final BoundaryEvents AD_BREAK_END;
        public static final BoundaryEvents AD_BREAK_START;
        public static final BoundaryEvents AD_END;
        public static final BoundaryEvents AD_START;
        public static final BoundaryEvents PROGRAM_END;
        public static final BoundaryEvents PROGRAM_START;

        public static BoundaryEvents valueOf(String s)
        {
            return (BoundaryEvents)Enum.valueOf(com/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents, s);
        }

        public static BoundaryEvents[] values()
        {
            return (BoundaryEvents[])$VALUES.clone();
        }

        static 
        {
            AD_START = new BoundaryEvents("AD_START", 0);
            AD_END = new BoundaryEvents("AD_END", 1);
            AD_BREAK_START = new BoundaryEvents("AD_BREAK_START", 2);
            AD_BREAK_END = new BoundaryEvents("AD_BREAK_END", 3);
            PROGRAM_START = new BoundaryEvents("PROGRAM_START", 4);
            PROGRAM_END = new BoundaryEvents("PROGRAM_END", 5);
            $VALUES = (new BoundaryEvents[] {
                AD_START, AD_END, AD_BREAK_START, AD_BREAK_END, PROGRAM_START, PROGRAM_END
            });
        }

        private BoundaryEvents(String s, int i)
        {
            super(s, i);
        }
    }


    public static String ADINFO_AD_DURATION = "ad_duration";
    public static String ADINFO_AD_INDEX = "ad_index";
    public static String ADINFO_AD_TYPE = "ad_type";
    public static String ADINFO_TOTAL_ADS = "total_ads";
    public static String ASSET_CURRENT_AFFILIATE = "current_affiliate";
    public static String ASSET_DESCRIPTION = "asset_description";
    public static String ASSET_DURATION = "asset_duration";
    public static String ASSET_ID = "metadata_asset_id";
    public static String ASSET_RATING = "asset_rating";
    public static String ASSET_SUPPORTED_AFFILIATES = "supported_affiliates";
    public static String ASSET_TITLE = "asset_title";
    protected static String BOUNDARY_EVENT = "BOUNDARY";
    protected static String BOUNDARY_EVENT_AD_BREAK_END = "AD_BREAK_END";
    protected static String BOUNDARY_EVENT_AD_BREAK_START = "AD_BREAK_START";
    protected static String BOUNDARY_EVENT_AD_END = "AD_END";
    protected static String BOUNDARY_EVENT_AD_START = "AD_START";
    protected static String BOUNDARY_EVENT_PROGRAM_END = "PROGRAM_END";
    protected static String BOUNDARY_EVENT_PROGRAM_START = "PROGRAM_START";
    public static String METADATA_ASSET = "metadata_asset";
    protected static String METADATA_EVENT = "METADATA";
    public static String METADATA_EVENT_DESC = "metadata_event_desc";
    public static String METADATA_EVENT_NAME = "metadata_event_name";
    public static String METADATA_RATE = "metadata_rate";
    private VPMedia currentMedia;
    private com.uplynk.media.MediaPlayer.UplynkMetadata uplynkMetadata;

    public VPMediaMetadata(VPMedia vpmedia)
    {
        currentMedia = vpmedia;
    }

    protected Bundle createBoundaryEvent(String s)
    {
        Bundle bundle;
        bundle = new Bundle();
        bundle.putString(METADATA_EVENT, BOUNDARY_EVENT);
        bundle.putString(METADATA_EVENT_NAME, s);
        com.uplynk.media.MediaPlayer.UplynkAssetInfo uplynkassetinfo = uplynkMetadata.getAssetInfo();
        if (currentMedia == null || uplynkMetadata == null) goto _L2; else goto _L1
_L1:
        if (!TextUtils.isEmpty(currentMedia.getMediaId()))
        {
            bundle.putString(ASSET_ID, currentMedia.getMediaId());
        }
        if (uplynkassetinfo == null) goto _L4; else goto _L3
_L3:
        s = "N/A";
        if (uplynkassetinfo.getMovieRating() == 0) goto _L6; else goto _L5
_L5:
        s = UplynkUtils.translateMovieRating(uplynkassetinfo.getMovieRating());
_L12:
        bundle.putString(ASSET_RATING, s);
_L4:
        if (TextUtils.isEmpty(currentMedia.getMediaTitle())) goto _L8; else goto _L7
_L7:
        bundle.putString(ASSET_TITLE, currentMedia.getMediaTitle());
_L14:
        if (TextUtils.isEmpty(uplynkassetinfo.getDescription())) goto _L10; else goto _L9
_L9:
        bundle.putString(ASSET_DESCRIPTION, uplynkassetinfo.getDescription());
_L16:
        try
        {
            bundle.putString(ASSET_DURATION, Double.toString(uplynkassetinfo.getDuration()));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return bundle;
        }
_L2:
        return bundle;
_L6:
        if (uplynkassetinfo.getTvRating() == 0) goto _L12; else goto _L11
_L11:
        s = UplynkUtils.translateTVRating(uplynkassetinfo.getTvRating(), uplynkassetinfo.getRatingFlags());
          goto _L12
_L8:
        if (TextUtils.isEmpty(uplynkassetinfo.getDescription())) goto _L14; else goto _L13
_L13:
        bundle.putString(ASSET_TITLE, uplynkassetinfo.getDescription());
          goto _L14
        s;
        LogUtils.LOGE("VPMediaMetadata", "Problem with UplynkAssetInfo");
        return bundle;
_L10:
        if (TextUtils.isEmpty(currentMedia.getMediaDesc())) goto _L16; else goto _L15
_L15:
        bundle.putString(ASSET_DESCRIPTION, currentMedia.getMediaDesc());
          goto _L16
    }

    protected com.uplynk.media.MediaPlayer.UplynkMetadata getUplynkMetadata()
    {
        return uplynkMetadata;
    }

    protected void setUplynkMetadata(com.uplynk.media.MediaPlayer.UplynkMetadata uplynkmetadata)
    {
        uplynkMetadata = uplynkmetadata;
    }

}
