// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.Externalizable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.millennialmedia.android:
//            CachedAd, VideoImage, VideoLogEvent, AdCache, 
//            HandShake, MMAdImpl, HttpGetRequest, DTOCachedVideo

class VideoAd extends CachedAd
    implements Parcelable, Externalizable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public VideoAd createFromParcel(Parcel parcel)
        {
            return new VideoAd(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public VideoAd[] newArray(int i)
        {
            return new VideoAd[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    static final String VIDEO_FILE_ID = "video.dat";
    static final long serialVersionUID = 0x252e2adaa757e358L;
    ArrayList activities;
    ArrayList buttons;
    String cacheComplete[];
    String cacheFailed[];
    String cacheMissURL;
    DTOCachedVideo cachedVideoDto;
    long closeDelayMillis;
    long contentLength;
    long duration;
    String endActivity[];
    String endOverlayURL;
    String onCompletionUrl;
    boolean reloadNonEndOverlayOnRestart;
    boolean showControls;
    boolean showCountdown;
    String startActivity[];
    boolean stayInPlayer;
    boolean usingInternalStorage;
    String videoError[];
    private String videoFileId;
    String webOverlayURL;

    public VideoAd()
    {
        buttons = new ArrayList();
        activities = new ArrayList();
    }

    VideoAd(Parcel parcel)
    {
        super(parcel);
        buttons = new ArrayList();
        activities = new ArrayList();
        try
        {
            startActivity = new String[parcel.readInt()];
            parcel.readStringArray(startActivity);
            endActivity = new String[parcel.readInt()];
            parcel.readStringArray(endActivity);
            boolean aflag[] = new boolean[5];
            parcel.readBooleanArray(aflag);
            showControls = aflag[0];
            stayInPlayer = aflag[1];
            showCountdown = aflag[2];
            reloadNonEndOverlayOnRestart = aflag[3];
            usingInternalStorage = aflag[4];
            onCompletionUrl = parcel.readString();
            webOverlayURL = parcel.readString();
            endOverlayURL = parcel.readString();
            cacheMissURL = parcel.readString();
            videoFileId = parcel.readString();
            duration = parcel.readLong();
            contentLength = parcel.readLong();
            closeDelayMillis = parcel.readLong();
            buttons = parcel.readArrayList(com/millennialmedia/android/VideoImage.getClassLoader());
            activities = parcel.readArrayList(com/millennialmedia/android/VideoLogEvent.getClassLoader());
            cacheComplete = new String[parcel.readInt()];
            parcel.readStringArray(cacheComplete);
            cacheFailed = new String[parcel.readInt()];
            parcel.readStringArray(cacheFailed);
            videoError = new String[parcel.readInt()];
            parcel.readStringArray(videoError);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Parcel parcel)
        {
            parcel.printStackTrace();
        }
    }

    VideoAd(String s)
    {
        buttons = new ArrayList();
        activities = new ArrayList();
        if (s != null)
        {
            Object obj = null;
            try
            {
                s = new JSONObject(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                s = obj;
            }
            if (s != null)
            {
                s = s.optJSONObject("video");
                if (s != null)
                {
                    deserializeFromObj(s);
                }
            }
        }
    }

    private void deleteVideoFile(Context context)
    {
        if (AdCache.deleteFile(context, (new StringBuilder()).append(videoFileId).append("video.dat").toString()))
        {
            MMSDK.Log.v("VideoAd video file %s was deleted.", new Object[] {
                videoFileId
            });
        }
    }

    static boolean downloadVideoFile(Context context, String s, String s1)
    {
        File file = AdCache.getCacheDirectory(context);
        if (file == null || !file.isDirectory())
        {
            return false;
        } else
        {
            MMSDK.Log.v((new StringBuilder()).append("Downloading (").append(s1).append("video.dat").append(") content to %s").toString(), new Object[] {
                file
            });
            boolean flag = AdCache.downloadComponent(s, (new StringBuilder()).append(s1).append("video.dat").toString(), file, context);
            MMSDK.Log.v((new StringBuilder()).append("Caching completed successfully (").append(s1).append("video.dat").append(")? %b").toString(), new Object[] {
                Boolean.valueOf(flag)
            });
            return flag;
        }
    }

    static Uri getVideoUri(Context context, String s)
    {
        return Uri.fromFile(AdCache.getDownloadFile(context, (new StringBuilder()).append(s).append("video.dat").toString()));
    }

    private void handleSharedVideoFile(final Context context)
    {
        AdCache.iterateCachedAds(context, 2, new AdCache.Iterator() {

            boolean hasSharedVideoFile;
            final VideoAd this$0;
            final Context val$context;

            boolean callback(CachedAd cachedad)
            {
                if (cachedad != null && (cachedad instanceof VideoAd) && ((VideoAd)cachedad).videoFileId.equals(videoFileId))
                {
                    hasSharedVideoFile = true;
                }
                return super.callback(cachedad);
            }

            void done()
            {
                if (!hasSharedVideoFile)
                {
                    deleteVideoFile(context);
                }
                super.done();
            }

            
            {
                this$0 = VideoAd.this;
                context = context1;
                super();
                hasSharedVideoFile = false;
            }
        });
    }

    static boolean hasVideoFile(Context context, String s)
    {
        return AdCache.hasDownloadFile(context, (new StringBuilder()).append(s).append("video.dat").toString());
    }

    static void playAd(Context context, String s, HttpRedirection.RedirectionListenerImpl redirectionlistenerimpl)
    {
label0:
        {
            if (s != null)
            {
                VideoAd videoad = (VideoAd)AdCache.load(context, s);
                if (videoad == null || !videoad.canShow(context, null, false))
                {
                    break label0;
                }
                redirectionlistenerimpl.updateLastVideoViewedTime();
                MMSDK.Log.v("mmvideo: attempting to play video %s", new Object[] {
                    s
                });
                videoad.show(context, redirectionlistenerimpl.creatorAdImplInternalId);
                redirectionlistenerimpl.startingVideo();
            }
            return;
        }
        MMSDK.Log.v("mmvideo: Ad %s cannot be shown at this time.", new Object[] {
            s
        });
    }

    boolean canShow(Context context, MMAdImpl mmadimpl, boolean flag)
    {
        if (!flag) goto _L2; else goto _L1
_L1:
        if (isExpired() || !isOnDisk(context) || !HandShake.sharedHandShake(context).canDisplayCachedAd(mmadimpl.adType, deferredViewStart)) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        if (isExpired() || !isOnDisk(context))
        {
            return false;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    void delete(Context context)
    {
        super.delete(context);
        handleSharedVideoFile(context);
        AdCache.cachedVideoWasRemoved(context, acid);
        MMSDK.Log.v("Ad %s was deleted.", new Object[] {
            getId()
        });
    }

    public int describeContents()
    {
        return 0;
    }

    protected void deserializeFromObj(JSONObject jsonobject)
    {
        super.deserializeFromObj(jsonobject);
        Object obj = jsonobject.optJSONArray("startActivity");
        webOverlayURL = jsonobject.optString("overlayURL", null);
        endOverlayURL = jsonobject.optString("endURL", null);
        cacheMissURL = jsonobject.optString("cacheMissURL", null);
        videoFileId = jsonobject.optString("videoFileId", null);
        if (obj != null)
        {
            startActivity = new String[((JSONArray) (obj)).length()];
            for (int i = 0; i < ((JSONArray) (obj)).length(); i++)
            {
                startActivity[i] = ((JSONArray) (obj)).optString(i);
            }

        } else
        {
            startActivity = new String[0];
        }
        obj = jsonobject.optJSONArray("endActivity");
        if (obj != null)
        {
            endActivity = new String[((JSONArray) (obj)).length()];
            for (int j = 0; j < ((JSONArray) (obj)).length(); j++)
            {
                endActivity[j] = ((JSONArray) (obj)).optString(j);
            }

        } else
        {
            endActivity = new String[0];
        }
        obj = jsonobject.optJSONArray("cacheComplete");
        if (obj != null)
        {
            cacheComplete = new String[((JSONArray) (obj)).length()];
            for (int k = 0; k < ((JSONArray) (obj)).length(); k++)
            {
                cacheComplete[k] = ((JSONArray) (obj)).optString(k);
            }

        } else
        {
            cacheComplete = new String[0];
        }
        obj = jsonobject.optJSONArray("cacheFailed");
        if (obj != null)
        {
            cacheFailed = new String[((JSONArray) (obj)).length()];
            for (int l = 0; l < ((JSONArray) (obj)).length(); l++)
            {
                cacheFailed[l] = ((JSONArray) (obj)).optString(l);
            }

        } else
        {
            cacheFailed = new String[0];
        }
        obj = jsonobject.optJSONArray("videoError");
        if (obj != null)
        {
            videoError = new String[((JSONArray) (obj)).length()];
            for (int i1 = 0; i1 < ((JSONArray) (obj)).length(); i1++)
            {
                videoError[i1] = ((JSONArray) (obj)).optString(i1);
            }

        } else
        {
            videoError = new String[0];
        }
        showControls = jsonobject.optBoolean("showVideoPlayerControls");
        showCountdown = jsonobject.optBoolean("showCountdownHUD");
        reloadNonEndOverlayOnRestart = jsonobject.optBoolean("reloadOverlayOnRestart");
        obj = jsonobject.optJSONObject("onCompletion");
        if (obj != null)
        {
            onCompletionUrl = ((JSONObject) (obj)).optString("url", null);
            stayInPlayer = ((JSONObject) (obj)).optBoolean("stayInPlayer");
        }
        duration = (long)(jsonobject.optDouble("duration", 0.0D) * 1000D);
        contentLength = jsonobject.optLong("contentLength");
        closeDelayMillis = jsonobject.optLong("closeAfterDelay");
        obj = jsonobject.optJSONArray("buttons");
        if (obj != null)
        {
            for (int j1 = 0; j1 < ((JSONArray) (obj)).length(); j1++)
            {
                Object obj2 = ((JSONArray) (obj)).optJSONObject(j1);
                if (obj2 != null)
                {
                    obj2 = new VideoImage(((JSONObject) (obj2)));
                    buttons.add(obj2);
                }
            }

        }
        jsonobject = jsonobject.optJSONArray("log");
        if (jsonobject != null)
        {
            for (int k1 = 0; k1 < jsonobject.length(); k1++)
            {
                Object obj1 = jsonobject.optJSONObject(k1);
                if (obj1 != null)
                {
                    obj1 = new VideoLogEvent(((JSONObject) (obj1)));
                    activities.add(obj1);
                }
            }

        }
    }

    boolean download(Context context)
    {
        File file;
        boolean flag;
        boolean flag1;
        file = AdCache.getCacheDirectory(context);
        if (file == null || !file.isDirectory())
        {
            return false;
        }
        usingInternalStorage = AdCache.isInternalDir(context, file);
        MMSDK.Log.v("Downloading content to %s", new Object[] {
            file
        });
        flag1 = AdCache.downloadComponent(contentUrl, (new StringBuilder()).append(videoFileId).append("video.dat").toString(), file, context);
        flag = flag1;
        if (!flag1) goto _L2; else goto _L1
_L1:
        int i;
        i = 0;
        flag = flag1;
_L6:
        if (i >= buttons.size()) goto _L2; else goto _L3
_L3:
        VideoImage videoimage = (VideoImage)buttons.get(i);
        flag = AdCache.downloadComponent(videoimage.imageUrl, (new StringBuilder()).append(getId()).append(videoimage.getImageName()).toString(), file, context);
        if (flag) goto _L4; else goto _L2
_L2:
        if (!flag)
        {
            if (downloadAllOrNothing)
            {
                delete(context);
            }
            HttpGetRequest.log(cacheFailed);
        } else
        if (flag)
        {
            if (acid != null && acid.length() > 0)
            {
                AdCache.cachedVideoWasAdded(context, acid);
            }
            HttpGetRequest.log(cacheComplete);
        }
        MMSDK.Log.v("Caching completed successfully? %b", new Object[] {
            Boolean.valueOf(flag)
        });
        return flag;
_L4:
        i++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    int getType()
    {
        return 1;
    }

    String getTypeString()
    {
        return "Video";
    }

    Intent getVideoExtrasIntent(Context context, long l)
    {
        Intent intent = new Intent();
        intent.putExtra("videoId", getId());
        if (l != -4L)
        {
            intent.putExtra("internalId", l);
        }
        intent.setData(Uri.parse((new StringBuilder()).append(AdCache.getCacheDirectory(context).getAbsolutePath()).append(File.separator).append(videoFileId).append("video.dat").toString()));
        return intent;
    }

    boolean hasEndCard()
    {
        for (Iterator iterator = buttons.iterator(); iterator.hasNext();)
        {
            if (((VideoImage)iterator.next()).isLeaveBehind)
            {
                return true;
            }
        }

        return false;
    }

    boolean isOnDisk(Context context)
    {
        boolean flag;
        boolean flag1;
        boolean flag2;
        flag1 = false;
        flag2 = false;
        context = AdCache.getCacheDirectory(context);
        flag = flag1;
        if (context == null) goto _L2; else goto _L1
_L1:
        flag = flag1;
        if (!context.exists()) goto _L2; else goto _L3
_L3:
        String as[] = context.list(new FilenameFilter() {

            final VideoAd this$0;

            public boolean accept(File file, String s)
            {
                if (getId() == null)
                {
                    return false;
                } else
                {
                    return s.startsWith(getId());
                }
            }

            
            {
                this$0 = VideoAd.this;
                super();
            }
        });
        flag1 = flag2;
        if (as != null)
        {
            flag1 = flag2;
            if (as.length >= buttons.size() + 1)
            {
                flag1 = true;
            }
        }
        flag = flag1;
        if (!flag1) goto _L2; else goto _L4
_L4:
        if ((new File(context, (new StringBuilder()).append(videoFileId).append("video.dat").toString())).exists()) goto _L6; else goto _L5
_L5:
        flag = false;
_L2:
        return flag;
_L6:
        Iterator iterator = buttons.iterator();
        do
        {
            flag = flag1;
            if (!iterator.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            VideoImage videoimage = (VideoImage)iterator.next();
            if (!(new File(context, (new StringBuilder()).append(getId()).append(videoimage.getImageName()).toString())).exists())
            {
                return false;
            }
        } while (true);
        if (true) goto _L2; else goto _L7
_L7:
    }

    void logBeginEvent()
    {
        if (startActivity != null)
        {
            MMSDK.Log.d("Cached video begin event logged");
            for (int i = 0; i < startActivity.length; i++)
            {
                MMSDK.Event.logEvent(startActivity[i]);
            }

        }
    }

    void logEndEvent()
    {
        if (endActivity != null)
        {
            MMSDK.Log.d("Cached video end event logged");
            for (int i = 0; i < endActivity.length; i++)
            {
                MMSDK.Event.logEvent(endActivity[i]);
            }

        }
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        super.readExternal(objectinput);
        showControls = objectinput.readBoolean();
        onCompletionUrl = (String)objectinput.readObject();
        webOverlayURL = (String)objectinput.readObject();
        endOverlayURL = (String)objectinput.readObject();
        cacheMissURL = (String)objectinput.readObject();
        videoFileId = (String)objectinput.readObject();
        stayInPlayer = objectinput.readBoolean();
        showCountdown = objectinput.readBoolean();
        reloadNonEndOverlayOnRestart = objectinput.readBoolean();
        int l1 = objectinput.readInt();
        startActivity = new String[l1];
        for (int i = 0; i < l1; i++)
        {
            startActivity[i] = (String)objectinput.readObject();
        }

        l1 = objectinput.readInt();
        endActivity = new String[l1];
        for (int j = 0; j < l1; j++)
        {
            endActivity[j] = (String)objectinput.readObject();
        }

        duration = objectinput.readLong();
        usingInternalStorage = objectinput.readBoolean();
        contentLength = objectinput.readLong();
        closeDelayMillis = objectinput.readLong();
        l1 = objectinput.readInt();
        cacheComplete = new String[l1];
        for (int k = 0; k < l1; k++)
        {
            cacheComplete[k] = (String)objectinput.readObject();
        }

        l1 = objectinput.readInt();
        cacheFailed = new String[l1];
        for (int l = 0; l < l1; l++)
        {
            cacheFailed[l] = (String)objectinput.readObject();
        }

        l1 = objectinput.readInt();
        videoError = new String[l1];
        for (int i1 = 0; i1 < l1; i1++)
        {
            videoError[i1] = (String)objectinput.readObject();
        }

        buttons.clear();
        l1 = objectinput.readInt();
        for (int j1 = 0; j1 < l1; j1++)
        {
            VideoImage videoimage = (VideoImage)objectinput.readObject();
            buttons.add(videoimage);
        }

        activities.clear();
        l1 = objectinput.readInt();
        for (int k1 = 0; k1 < l1; k1++)
        {
            VideoLogEvent videologevent = (VideoLogEvent)objectinput.readObject();
            activities.add(videologevent);
        }

    }

    boolean saveAssets(Context context)
    {
        return true;
    }

    void setDtoCachedVideo(DTOCachedVideo dtocachedvideo)
    {
        cachedVideoDto = dtocachedvideo;
    }

    void show(Context context, long l)
    {
        Utils.IntentUtils.startCachedVideoPlayerActivity(context, getVideoExtrasIntent(context, l));
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        super.writeExternal(objectoutput);
        objectoutput.writeBoolean(showControls);
        objectoutput.writeObject(onCompletionUrl);
        objectoutput.writeObject(webOverlayURL);
        objectoutput.writeObject(endOverlayURL);
        objectoutput.writeObject(cacheMissURL);
        objectoutput.writeObject(videoFileId);
        objectoutput.writeBoolean(stayInPlayer);
        objectoutput.writeBoolean(showCountdown);
        objectoutput.writeBoolean(reloadNonEndOverlayOnRestart);
        objectoutput.writeInt(startActivity.length);
        String as[] = startActivity;
        int j1 = as.length;
        for (int i = 0; i < j1; i++)
        {
            objectoutput.writeObject(as[i]);
        }

        objectoutput.writeInt(endActivity.length);
        as = endActivity;
        j1 = as.length;
        for (int j = 0; j < j1; j++)
        {
            objectoutput.writeObject(as[j]);
        }

        objectoutput.writeLong(duration);
        objectoutput.writeBoolean(usingInternalStorage);
        objectoutput.writeLong(contentLength);
        objectoutput.writeLong(closeDelayMillis);
        objectoutput.writeInt(cacheComplete.length);
        as = cacheComplete;
        j1 = as.length;
        for (int k = 0; k < j1; k++)
        {
            objectoutput.writeObject(as[k]);
        }

        objectoutput.writeInt(cacheFailed.length);
        as = cacheFailed;
        j1 = as.length;
        for (int l = 0; l < j1; l++)
        {
            objectoutput.writeObject(as[l]);
        }

        objectoutput.writeInt(videoError.length);
        as = videoError;
        j1 = as.length;
        for (int i1 = 0; i1 < j1; i1++)
        {
            objectoutput.writeObject(as[i1]);
        }

        objectoutput.writeInt(buttons.size());
        for (Iterator iterator = buttons.iterator(); iterator.hasNext(); objectoutput.writeObject((VideoImage)iterator.next())) { }
        objectoutput.writeInt(activities.size());
        for (Iterator iterator1 = activities.iterator(); iterator1.hasNext(); objectoutput.writeObject((VideoLogEvent)iterator1.next())) { }
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        parcel.writeInt(startActivity.length);
        parcel.writeStringArray(startActivity);
        parcel.writeInt(endActivity.length);
        parcel.writeStringArray(endActivity);
        parcel.writeBooleanArray(new boolean[] {
            showControls, stayInPlayer, showCountdown, reloadNonEndOverlayOnRestart, usingInternalStorage
        });
        parcel.writeString(onCompletionUrl);
        parcel.writeString(endOverlayURL);
        parcel.writeString(webOverlayURL);
        parcel.writeString(cacheMissURL);
        parcel.writeString(videoFileId);
        parcel.writeLong(duration);
        parcel.writeLong(contentLength);
        parcel.writeLong(closeDelayMillis);
        parcel.writeList(buttons);
        parcel.writeList(activities);
        parcel.writeInt(cacheComplete.length);
        parcel.writeStringArray(cacheComplete);
        parcel.writeInt(cacheFailed.length);
        parcel.writeStringArray(cacheFailed);
        parcel.writeInt(videoError.length);
        parcel.writeStringArray(videoError);
    }



}
