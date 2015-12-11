// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.media;

import android.content.Context;
import android.text.TextUtils;
import com.disney.datg.videoplatforms.sdk.common.AsyncHandler;
import com.disney.datg.videoplatforms.sdk.common.ThreadPoolAccessor;
import com.disney.datg.videoplatforms.sdk.error.AndroidSDKException;
import com.disney.datg.videoplatforms.sdk.error.ErrorCode;
import com.disney.datg.videoplatforms.sdk.models.VPCatalog;
import com.disney.datg.videoplatforms.sdk.models.api.Abcdvas;
import com.disney.datg.videoplatforms.sdk.models.api.AdTarget;
import com.disney.datg.videoplatforms.sdk.models.api.Affiliate;
import com.disney.datg.videoplatforms.sdk.models.api.Affiliates;
import com.disney.datg.videoplatforms.sdk.models.api.AirDate;
import com.disney.datg.videoplatforms.sdk.models.api.Airdates;
import com.disney.datg.videoplatforms.sdk.models.api.Asset;
import com.disney.datg.videoplatforms.sdk.models.api.Assets;
import com.disney.datg.videoplatforms.sdk.models.api.Channel;
import com.disney.datg.videoplatforms.sdk.models.api.Channels;
import com.disney.datg.videoplatforms.sdk.models.api.Config;
import com.disney.datg.videoplatforms.sdk.models.api.Duration;
import com.disney.datg.videoplatforms.sdk.models.api.Generic;
import com.disney.datg.videoplatforms.sdk.models.api.GeoLocation;
import com.disney.datg.videoplatforms.sdk.models.api.Season;
import com.disney.datg.videoplatforms.sdk.models.api.Show;
import com.disney.datg.videoplatforms.sdk.models.api.Thumbnail;
import com.disney.datg.videoplatforms.sdk.models.api.Thumbnails;
import com.disney.datg.videoplatforms.sdk.models.api.TrackCode;
import com.disney.datg.videoplatforms.sdk.models.api.TvRating;
import com.disney.datg.videoplatforms.sdk.models.api.Video;
import com.disney.datg.videoplatforms.sdk.models.api.Videos;
import com.disney.datg.videoplatforms.sdk.service.ChannelsAccessor;
import com.disney.datg.videoplatforms.sdk.service.VideoAccessor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.springframework.http.ResponseEntity;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.media:
//            VPGeolocation, VPChannel, VPVideo, Configuration

public class VPCatalogManager
    implements VPGeolocation.VPLocationRequestListener
{
    public static interface VPLocationRequestListener
    {

        public abstract void onLocationRequest();
    }


    private static String TAG = "VPCatalogManager";
    private Configuration configuration;
    private Context context;
    private VPLocationRequestListener onLocationRequestListener;

    private VPCatalogManager(Context context1, Configuration configuration1)
    {
        configuration = configuration1;
        setContext(context1);
        VPGeolocation.getGeolocationManager().setConfiguration(configuration1);
    }

    private List collectionFromChannels(List list, String s)
        throws AndroidSDKException
    {
        ArrayList arraylist = new ArrayList();
        String as[] = null;
        if (!TextUtils.isEmpty(s))
        {
            as = s.split(",");
        }
        int i = 0;
        while (i < list.size()) 
        {
            Object obj2 = (Channel)list.get(i);
            Object obj1 = new VPChannel();
            ((VPChannel) (obj1)).setMediaId(((Channel) (obj2)).getId());
            Object obj;
            if (((Channel) (obj2)).getAssets() != null && ((Channel) (obj2)).getAssets().getAsset() != null && ((Channel) (obj2)).getAssets().getAsset() != null)
            {
                obj = ((Channel) (obj2)).getAssets().getAsset();
            } else
            {
                obj = null;
            }
            if (obj != null)
            {
                obj = ((List) (obj)).iterator();
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break;
                    }
                    Asset asset = (Asset)((Iterator) (obj)).next();
                    if (asset.getFormat().equals(VPMedia.AssetType.ULNK.toString()))
                    {
                        ((VPChannel) (obj1)).setContentUrl(asset.getValue());
                    }
                    if (!TextUtils.isEmpty(asset.getAccesslevel()))
                    {
                        try
                        {
                            ((VPChannel) (obj1)).setAccessWindow(Integer.parseInt(asset.getAccesslevel()));
                        }
                        catch (NumberFormatException numberformatexception2) { }
                    }
                } while (true);
            }
            if (as != null && as.length > i)
            {
                ((VPChannel) (obj1)).setAffiliateId(as[i]);
            }
            ((VPChannel) (obj1)).setMediaDesc(((Channel) (obj2)).getDescription());
            if (((Channel) (obj2)).getTvrating() != null && !TextUtils.isEmpty(((Channel) (obj2)).getTvrating().getRating()))
            {
                obj = ((Channel) (obj2)).getTvrating().getRating();
            } else
            {
                obj = "";
            }
            ((VPChannel) (obj1)).setMediaRating(((String) (obj)));
            ((VPChannel) (obj1)).setMediaTitle(((Channel) (obj2)).getTitle());
            ((VPChannel) (obj1)).setWorkflowId(((Channel) (obj2)).getWorkflowid());
            if (((Channel) (obj2)).getThumbnails() != null && ((Channel) (obj2)).getThumbnails().getThumbnail() != null)
            {
                obj = ((Channel) (obj2)).getThumbnails().getThumbnail();
            } else
            {
                obj = null;
            }
            ((VPChannel) (obj1)).addThumbnail(VPMedia.ThumbnailType.EPISODE, ((List) (obj)));
            Iterator iterator;
            NumberFormatException numberformatexception1;
            if (((VPChannel) (obj1)).getAccessWindow() == VPMedia.AccessWindow.UNDEFINED && !TextUtils.isEmpty(((Channel) (obj2)).getAccesslevel()))
            {
                try
                {
                    ((VPChannel) (obj1)).setAccessWindow(Integer.parseInt(((Channel) (obj2)).getAccesslevel()));
                }
                catch (NumberFormatException numberformatexception) { }
            }
            arraylist.add(obj1);
            i++;
        }
        iterator = list.iterator();
        while (iterator.hasNext()) 
        {
            obj1 = (Channel)iterator.next();
            obj = new VPChannel();
            ((VPChannel) (obj)).setMediaId(((Channel) (obj1)).getId());
            if (((Channel) (obj1)).getAssets() != null && ((Channel) (obj1)).getAssets().getAsset() != null && ((Channel) (obj1)).getAssets().getAsset() != null)
            {
                list = ((Channel) (obj1)).getAssets().getAsset();
            } else
            {
                list = null;
            }
            if (list != null)
            {
                list = list.iterator();
                do
                {
                    if (!list.hasNext())
                    {
                        break;
                    }
                    obj2 = (Asset)list.next();
                    if (((Asset) (obj2)).getFormat().equals(VPMedia.AssetType.ULNK.toString()))
                    {
                        ((VPChannel) (obj)).setContentUrl(((Asset) (obj2)).getValue());
                    }
                    if (!TextUtils.isEmpty(((Asset) (obj2)).getAccesslevel()))
                    {
                        try
                        {
                            ((VPChannel) (obj)).setAccessWindow(Integer.parseInt(((Asset) (obj2)).getAccesslevel()));
                        }
                        // Misplaced declaration of an exception variable
                        catch (NumberFormatException numberformatexception1) { }
                    }
                } while (true);
            }
            ((VPChannel) (obj)).setAffiliateId(s);
            ((VPChannel) (obj)).setMediaDesc(((Channel) (obj1)).getDescription());
            if (((Channel) (obj1)).getTvrating() != null && !TextUtils.isEmpty(((Channel) (obj1)).getTvrating().getRating()))
            {
                list = ((Channel) (obj1)).getTvrating().getRating();
            } else
            {
                list = "";
            }
            ((VPChannel) (obj)).setMediaRating(list);
            ((VPChannel) (obj)).setMediaTitle(((Channel) (obj1)).getTitle());
            ((VPChannel) (obj)).setWorkflowId(((Channel) (obj1)).getWorkflowid());
            if (((Channel) (obj1)).getThumbnails() != null && ((Channel) (obj1)).getThumbnails().getThumbnail() != null)
            {
                list = ((Channel) (obj1)).getThumbnails().getThumbnail();
            } else
            {
                list = null;
            }
            ((VPChannel) (obj)).addThumbnail(VPMedia.ThumbnailType.EPISODE, list);
            if (((VPChannel) (obj)).getAccessWindow() == VPMedia.AccessWindow.UNDEFINED && !TextUtils.isEmpty(((Channel) (obj1)).getAccesslevel()))
            {
                try
                {
                    ((VPChannel) (obj)).setAccessWindow(Integer.parseInt(((Channel) (obj1)).getAccesslevel()));
                }
                // Misplaced declaration of an exception variable
                catch (List list) { }
            }
            arraylist.add(obj);
        }
        return arraylist;
    }

    private List collectionFromVideos(List list)
        throws AndroidSDKException
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) 
        {
            Video video = (Video)iterator.next();
            VPVideo vpvideo = new VPVideo();
            vpvideo.setMediaId(video.getId());
            if (video.getAssets() != null && video.getAssets().getAsset() != null && video.getAssets().getAsset() != null)
            {
                list = video.getAssets().getAsset();
            } else
            {
                list = null;
            }
            if (list != null)
            {
                list = list.iterator();
                do
                {
                    if (!list.hasNext())
                    {
                        break;
                    }
                    Asset asset = (Asset)list.next();
                    if (asset.getFormat().equals(VPMedia.AssetType.ULNK.toString()))
                    {
                        vpvideo.setContentUrl(asset.getValue());
                    }
                    if (!TextUtils.isEmpty(asset.getStorageid()))
                    {
                        vpvideo.setStorageId(asset.getStorageid());
                    }
                    if (!TextUtils.isEmpty(asset.getAccesslevel()))
                    {
                        try
                        {
                            vpvideo.setAccessWindow(Integer.parseInt(asset.getAccesslevel()));
                        }
                        catch (NumberFormatException numberformatexception) { }
                    }
                } while (true);
            }
            vpvideo.setMediaDesc(video.getDescription());
            if (video.getTvrating() != null && !TextUtils.isEmpty(video.getTvrating().getRating()))
            {
                list = video.getTvrating().getRating();
            } else
            {
                list = "";
            }
            vpvideo.setMediaRating(list);
            vpvideo.setMediaTitle(video.getTitle());
            vpvideo.setWorkflowId(video.getWorkflowid());
            if (video.getShow() != null && video.getShow().getThumbnails() != null)
            {
                list = video.getShow().getThumbnails().getThumbnail();
            } else
            {
                list = null;
            }
            vpvideo.addThumbnail(VPMedia.ThumbnailType.SHOW, list);
            if (video.getThumbnails() != null && video.getThumbnails().getThumbnail() != null)
            {
                list = video.getThumbnails().getThumbnail();
            } else
            {
                list = null;
            }
            vpvideo.addThumbnail(VPMedia.ThumbnailType.EPISODE, list);
            if (video.getDuration() != null && !TextUtils.isEmpty(video.getDuration().getValue()))
            {
                try
                {
                    vpvideo.setDuration(Long.parseLong(video.getDuration().getValue()));
                }
                // Misplaced declaration of an exception variable
                catch (List list) { }
            }
            if (vpvideo.getAccessWindow() == VPMedia.AccessWindow.UNDEFINED && !TextUtils.isEmpty(video.getAccesslevel()))
            {
                try
                {
                    vpvideo.setAccessWindow(Integer.parseInt(video.getAccesslevel()));
                }
                // Misplaced declaration of an exception variable
                catch (List list) { }
            }
            if (video.getAirdates() != null && video.getAirdates().getAirdate() != null && video.getAirdates().getAirdate().size() > 0)
            {
                vpvideo.setAirDate(((AirDate)video.getAirdates().getAirdate().get(0)).toString());
            }
            if (!TextUtils.isEmpty(video.getExpiredate()))
            {
                vpvideo.setExpireDate(video.getExpiredate());
            }
            if (!TextUtils.isEmpty(video.getNumber()))
            {
                vpvideo.setEpisodeNumber(video.getNumber());
            }
            if (!TextUtils.isEmpty(video.getAvaildate()))
            {
                vpvideo.setAvailableDate(video.getAvaildate());
            }
            if (video.getSeason() != null && !TextUtils.isEmpty(video.getSeason().getNum()))
            {
                vpvideo.setSeasonNumber(video.getSeason().getNum());
            }
            if (video.getShow() != null && video.getShow().getTrackcode() != null && video.getShow().getTrackcode().getGeneric() != null && !TextUtils.isEmpty(video.getShow().getTrackcode().getGeneric().getCprogram()))
            {
                vpvideo.setDayPart(video.getShow().getTrackcode().getGeneric().getCprogram());
            }
            if (video.getShow() != null && video.getShow().getTrackcode() != null && video.getShow().getTrackcode().getGeneric() != null && !TextUtils.isEmpty(video.getShow().getTrackcode().getGeneric().getCgenre()))
            {
                vpvideo.setCGenre(video.getShow().getTrackcode().getGeneric().getCgenre());
            }
            if (video.getShow() != null && video.getShow().getTrackcode() != null && video.getShow().getTrackcode().getGeneric() != null && !TextUtils.isEmpty(video.getShow().getTrackcode().getGeneric().getCshow()))
            {
                vpvideo.setCShowName(video.getShow().getTrackcode().getGeneric().getCshow());
            }
            if (video.getShow() != null && video.getShow().getTrackcode() != null && video.getShow().getTrackcode().getGeneric() != null && !TextUtils.isEmpty(video.getShow().getTrackcode().getGeneric().getCshow()))
            {
                vpvideo.setCShowName(video.getShow().getTrackcode().getGeneric().getCshow());
            }
            if (video.getAdtarget() != null && video.getAdtarget().getAbcdvas() != null && !TextUtils.isEmpty(video.getAdtarget().getAbcdvas().getCvideo()))
            {
                vpvideo.setCVideo(video.getAdtarget().getAbcdvas().getCvideo());
            }
            arraylist.add(vpvideo);
        }
        return arraylist;
    }

    protected static VPCatalogManager getCatalogManager(Context context1, Configuration configuration1)
    {
        return new VPCatalogManager(context1, configuration1);
    }

    public Future getChannelCatalog(AsyncHandler asynchandler)
    {
        Object obj;
label0:
        {
            Object obj2 = null;
            Object obj1 = null;
            GeoLocation geolocation = VPGeolocation.getGeolocationManager().doLBS(context);
            if (!configuration.getCurrentNetwork().equalsIgnoreCase("001"))
            {
                obj = obj2;
                if (!configuration.getCurrentNetwork().equalsIgnoreCase("abc"))
                {
                    break label0;
                }
            }
            obj = obj2;
            if (geolocation != null)
            {
                obj = obj2;
                if (geolocation.getAffiliates() != null)
                {
                    obj = obj2;
                    if (geolocation.getAffiliates().getAffiliates() != null)
                    {
                        Iterator iterator = geolocation.getAffiliates().getAffiliates().iterator();
                        for (obj = obj1; iterator.hasNext(); obj = (new StringBuilder()).append(((Affiliate) (obj)).getId()).append(",").toString())
                        {
                            obj = (Affiliate)iterator.next();
                        }

                    }
                }
            }
        }
        try
        {
            obj = getChannelCatalog(((String) (obj)), asynchandler);
        }
        catch (RejectedExecutionException rejectedexecutionexception)
        {
            if (asynchandler != null)
            {
                asynchandler.onError(new AndroidSDKException(ErrorCode.ANDROID_SDK_CHANNELS_SERVICE_ERROR, rejectedexecutionexception));
            }
            return null;
        }
        return ((Future) (obj));
    }

    public Future getChannelCatalog(final String affiliate, final AsyncHandler asyncHandler)
    {
        return ThreadPoolAccessor.getManager().execute(new Callable() {

            final VPCatalogManager this$0;
            final String val$affiliate;
            final AsyncHandler val$asyncHandler;

            public VPCatalog call()
                throws Exception
            {
                Object obj;
                VPCatalog vpcatalog;
                obj = configuration.getCurrentConfig().getURLFromWebServiceName("channels");
                if (TextUtils.isEmpty(((CharSequence) (obj))) && asyncHandler != null)
                {
                    obj = new AndroidSDKException(ErrorCode.ANDROID_SDK_SERVICE_UNDEFINED_HOST, "partner channels url could not be resolved from Config");
                    if (asyncHandler != null)
                    {
                        asyncHandler.onError(((Exception) (obj)));
                    }
                    throw obj;
                }
                if (!TextUtils.isEmpty(affiliate))
                {
                    obj = ((String) (obj)).replace("%AFFILIATE%", affiliate);
                } else
                {
                    obj = ((String) (obj)).replace("%AFFILIATE%", "-1");
                }
                vpcatalog = new VPCatalog();
                obj = new ChannelsAccessor(((String) (obj)), null);
                obj = (ResponseEntity)((ChannelsAccessor) (obj)).getServiceAsync().get(Configuration.SERVICE_TIMEOUT, TimeUnit.SECONDS);
                if (obj != null) goto _L2; else goto _L1
_L1:
                throw new AndroidSDKException(ErrorCode.ANDROID_SDK_CHANNELS_SERVICE_ERROR);
                obj;
                if (asyncHandler != null)
                {
                    asyncHandler.onError(new AndroidSDKException(ErrorCode.ANDROID_SDK_CHANNELS_SERVICE_ERROR, ((Throwable) (obj))));
                }
_L4:
                return vpcatalog;
_L2:
                obj = (Channels)((ResponseEntity) (obj)).getBody();
                if (((Channels) (obj)).getChannel() == null || ((Channels) (obj)).getChannel().size() <= 0)
                {
                    continue; /* Loop/switch isn't completed */
                }
                vpcatalog.setCollection(collectionFromChannels(((Channels) (obj)).getChannel(), affiliate), com.disney.datg.videoplatforms.sdk.models.VPCatalog.CatalogType.CHANNEL);
                if (asyncHandler == null)
                {
                    continue; /* Loop/switch isn't completed */
                }
                asyncHandler.onSuccess(vpcatalog);
                return vpcatalog;
                Object obj1;
                obj1;
                if (asyncHandler != null)
                {
                    asyncHandler.onError(new AndroidSDKException(ErrorCode.ANDROID_SDK_CHANNELS_SERVICE_ERROR, ((Throwable) (obj1))));
                    return vpcatalog;
                }
                continue; /* Loop/switch isn't completed */
                if (asyncHandler == null) goto _L4; else goto _L3
_L3:
                asyncHandler.onError(new AndroidSDKException(ErrorCode.ANDROID_SDK_CHANNELS_SERVICE_ERROR, "Channel is invalid or does not exist for partner"));
                return vpcatalog;
                obj1;
                if (asyncHandler != null)
                {
                    asyncHandler.onError(new AndroidSDKException(ErrorCode.ANDROID_SDK_CHANNELS_SERVICE_ERROR, ((Throwable) (obj1))));
                    return vpcatalog;
                }
                continue; /* Loop/switch isn't completed */
                obj1;
                if (asyncHandler != null)
                {
                    asyncHandler.onError(new AndroidSDKException(ErrorCode.ANDROID_SDK_CHANNELS_SERVICE_TIMEOUT, ((Throwable) (obj1))));
                    return vpcatalog;
                }
                continue; /* Loop/switch isn't completed */
                obj1;
                if (asyncHandler != null)
                {
                    asyncHandler.onError(((Exception) (obj1)));
                    return vpcatalog;
                }
                continue; /* Loop/switch isn't completed */
                obj1;
                if (asyncHandler != null)
                {
                    asyncHandler.onError(new AndroidSDKException(ErrorCode.ANDROID_SDK_CHANNELS_SERVICE_ERROR, ((Throwable) (obj1))));
                    return vpcatalog;
                }
                if (true) goto _L4; else goto _L5
_L5:
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            
            {
                this$0 = VPCatalogManager.this;
                asyncHandler = asynchandler;
                affiliate = s;
                super();
            }
        });
    }

    public Future getVideoCatalog(final String videoId, final AsyncHandler asyncHandler)
    {
        return ThreadPoolAccessor.getManager().execute(new Callable() {

            final VPCatalogManager this$0;
            final AsyncHandler val$asyncHandler;
            final String val$videoId;

            public VPCatalog call()
                throws Exception
            {
                Object obj;
                VPCatalog vpcatalog;
                obj = configuration.getCurrentConfig().getURLFromWebServiceName("videos");
                if (TextUtils.isEmpty(((CharSequence) (obj))) && asyncHandler != null)
                {
                    obj = new AndroidSDKException(ErrorCode.ANDROID_SDK_SERVICE_UNDEFINED_HOST, "partner videos url could not be resolved from Config");
                    asyncHandler.onError(((Exception) (obj)));
                    throw obj;
                }
                obj = ((String) (obj)).replace("%SHOW%", "-1").replace("%SEASON%", "-1").replace("%START%", "-1").replace("%LIMIT%", "-1");
                if (!TextUtils.isEmpty(videoId))
                {
                    try
                    {
                        obj = ((String) (obj)).replace("%VIDEO%", videoId);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        obj = new AndroidSDKException(ErrorCode.ANDROID_SDK_VIDEOS_SERVICE_ERROR, "improper format for videoId param");
                        if (asyncHandler != null)
                        {
                            asyncHandler.onError(((Exception) (obj)));
                        }
                        throw obj;
                    }
                } else
                {
                    obj = ((String) (obj)).replace("%VIDEO%", "-1");
                }
                vpcatalog = new VPCatalog();
                obj = new VideoAccessor(((String) (obj)), null);
                obj = (ResponseEntity)((VideoAccessor) (obj)).getServiceAsync().get(Configuration.SERVICE_TIMEOUT, TimeUnit.SECONDS);
                if (obj != null) goto _L2; else goto _L1
_L1:
                throw new AndroidSDKException(ErrorCode.ANDROID_SDK_VIDEOS_SERVICE_ERROR);
                obj;
                if (asyncHandler != null)
                {
                    asyncHandler.onError(new AndroidSDKException(ErrorCode.ANDROID_SDK_VIDEOS_SERVICE_ERROR, ((Throwable) (obj))));
                }
_L4:
                return vpcatalog;
_L2:
                obj = (Videos)((ResponseEntity) (obj)).getBody();
                if (((Videos) (obj)).getVideo() == null || ((Videos) (obj)).getVideo().size() <= 0)
                {
                    continue; /* Loop/switch isn't completed */
                }
                vpcatalog.setCollection(collectionFromVideos(((Videos) (obj)).getVideo()), com.disney.datg.videoplatforms.sdk.models.VPCatalog.CatalogType.VIDEO);
                if (asyncHandler == null)
                {
                    continue; /* Loop/switch isn't completed */
                }
                asyncHandler.onSuccess(vpcatalog);
                return vpcatalog;
                Object obj1;
                obj1;
                if (asyncHandler != null)
                {
                    asyncHandler.onError(new AndroidSDKException(ErrorCode.ANDROID_SDK_VIDEOS_SERVICE_ERROR, ((Throwable) (obj1))));
                    return vpcatalog;
                }
                continue; /* Loop/switch isn't completed */
                if (asyncHandler == null) goto _L4; else goto _L3
_L3:
                asyncHandler.onError(new AndroidSDKException(ErrorCode.ANDROID_SDK_VIDEOS_SERVICE_ERROR, "Video is invalid or does not exist for partner"));
                return vpcatalog;
                obj1;
                if (asyncHandler != null)
                {
                    asyncHandler.onError(new AndroidSDKException(ErrorCode.ANDROID_SDK_VIDEOS_SERVICE_ERROR, ((Throwable) (obj1))));
                    return vpcatalog;
                }
                continue; /* Loop/switch isn't completed */
                obj1;
                if (asyncHandler != null)
                {
                    asyncHandler.onError(new AndroidSDKException(ErrorCode.ANDROID_SDK_VIDEOS_SERVICE_ERROR, ((Throwable) (obj1))));
                    return vpcatalog;
                }
                continue; /* Loop/switch isn't completed */
                obj1;
                if (asyncHandler != null)
                {
                    asyncHandler.onError(((Exception) (obj1)));
                    return vpcatalog;
                }
                continue; /* Loop/switch isn't completed */
                obj1;
                if (asyncHandler != null)
                {
                    asyncHandler.onError(new AndroidSDKException(ErrorCode.ANDROID_SDK_VIDEOS_SERVICE_ERROR, ((Throwable) (obj1))));
                    return vpcatalog;
                }
                if (true) goto _L4; else goto _L5
_L5:
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            
            {
                this$0 = VPCatalogManager.this;
                asyncHandler = asynchandler;
                videoId = s;
                super();
            }
        });
    }

    public void onLocationRequest()
    {
        onLocationRequestListener.onLocationRequest();
    }

    public void setContext(Context context1)
    {
        context = context1;
    }




}
