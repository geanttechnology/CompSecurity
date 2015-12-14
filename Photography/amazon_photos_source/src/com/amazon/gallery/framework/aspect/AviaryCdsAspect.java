// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.aspect;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.foundation.utils.aviary.ContentLoader;
import com.amazon.gallery.foundation.utils.aviary.FrameContentLoader;
import com.amazon.gallery.foundation.utils.aviary.OverlayContentLoader;
import com.amazon.gallery.foundation.utils.aviary.StickerContentLoader;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.network.cloudfront.CloudFrontConfig;
import com.aviary.android.feather.cds.AviaryCdsReceiver;
import com.aviary.android.feather.cds.AviaryCdsService;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;
import org.aspectj.lang.NoAspectBoundException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.json.JSONException;
import org.json.JSONObject;

public class AviaryCdsAspect
{

    private static final CloudFrontConfig CLOUD_FRONT_CONFIG;
    private static final String TAG = com/amazon/gallery/framework/aspect/AviaryCdsAspect.getName();
    private static Throwable ajc$initFailureCause;
    public static final AviaryCdsAspect ajc$perSingletonInstance;
    private BroadcastReceiver aviaryCdsBroadcastReceiver;
    private Set packDownloadingTracker;

    public AviaryCdsAspect()
    {
        packDownloadingTracker = new HashSet();
    }

    public static CloudFrontConfig ajc$inlineAccessFieldGet$com_amazon_gallery_framework_aspect_AviaryCdsAspect$com_amazon_gallery_framework_aspect_AviaryCdsAspect$CLOUD_FRONT_CONFIG()
    {
        return CLOUD_FRONT_CONFIG;
    }

    public static String ajc$inlineAccessFieldGet$com_amazon_gallery_framework_aspect_AviaryCdsAspect$com_amazon_gallery_framework_aspect_AviaryCdsAspect$TAG()
    {
        return TAG;
    }

    public static Set ajc$inlineAccessFieldGet$com_amazon_gallery_framework_aspect_AviaryCdsAspect$com_amazon_gallery_framework_aspect_AviaryCdsAspect$packDownloadingTracker(AviaryCdsAspect aviarycdsaspect)
    {
        return aviarycdsaspect.packDownloadingTracker;
    }

    public static boolean ajc$inlineAccessMethod$com_amazon_gallery_framework_aspect_AviaryCdsAspect$com_amazon_gallery_framework_aspect_AviaryCdsAspect$isDownloadFinished(int i)
    {
        return isDownloadFinished(i);
    }

    public static void ajc$inlineAccessMethod$com_amazon_gallery_framework_aspect_AviaryCdsAspect$com_amazon_gallery_framework_aspect_AviaryCdsAspect$populateJson(JSONObject jsonobject, ContentLoader contentloader)
    {
        populateJson(jsonobject, contentloader);
    }

    public static void ajc$inlineAccessMethod$com_amazon_gallery_framework_aspect_AviaryCdsAspect$com_amazon_gallery_framework_aspect_AviaryCdsAspect$registerReceiver(Context context, AviaryCdsAspect aviarycdsaspect)
    {
        registerReceiver(context, aviarycdsaspect);
    }

    public static void ajc$inlineAccessMethod$com_amazon_gallery_framework_aspect_AviaryCdsAspect$com_amazon_gallery_framework_aspect_AviaryCdsAspect$unregisterReceiver(Context context, AviaryCdsAspect aviarycdsaspect)
    {
        unregisterReceiver(context, aviarycdsaspect);
    }

    private static void ajc$postClinit()
    {
        ajc$perSingletonInstance = new AviaryCdsAspect();
    }

    public static AviaryCdsAspect aspectOf()
    {
        if (ajc$perSingletonInstance == null)
        {
            throw new NoAspectBoundException("com.amazon.gallery.framework.aspect.AviaryCdsAspect", ajc$initFailureCause);
        } else
        {
            return ajc$perSingletonInstance;
        }
    }

    private static boolean isDownloadFinished(int i)
    {
        return i == 4 || i == 16 || i == 8;
    }

    private static void populateJson(JSONObject jsonobject, ContentLoader contentloader)
    {
        JSONObject jsonobject1;
        jsonobject1 = contentloader.getContent();
        if (jsonobject1 == null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        jsonobject.put("contentURL", jsonobject1.getString("contentURL"));
        if (jsonobject1.has("items"))
        {
            jsonobject.put("items", jsonobject1.getJSONArray("items"));
        }
        jsonobject.put("assetsBaseURL", CLOUD_FRONT_CONFIG.getCloudFrontURI(null).toString());
        jsonobject.put("identifier", contentloader.getPackIdentifier());
        jsonobject.put("displayName", contentloader.getDisplayName());
        jsonobject.put("displayDescription", contentloader.getDisplayDescription());
        jsonobject.put("author", "Amazon");
        return;
        jsonobject;
        GLogger.ex(TAG, "Could not write json", jsonobject);
        return;
    }

    private static void registerReceiver(Context context, AviaryCdsAspect aviarycdsaspect)
    {
        GLogger.i(TAG, "Register receivers for downloading packs", new Object[0]);
        if (aviarycdsaspect.aviaryCdsBroadcastReceiver == null)
        {
            aviarycdsaspect.aviaryCdsBroadcastReceiver = new AviaryCdsReceiver();
        }
        context.registerReceiver(aviarycdsaspect.aviaryCdsBroadcastReceiver, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
    }

    private static void unregisterReceiver(Context context, AviaryCdsAspect aviarycdsaspect)
    {
        GLogger.i(TAG, "Unregister receivers after all pack downloading completed", new Object[0]);
        if (aviarycdsaspect.aviaryCdsBroadcastReceiver == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        context.unregisterReceiver(aviarycdsaspect.aviaryCdsBroadcastReceiver);
        return;
        context;
    }

    public Object invokeDownloadStatusChange(ProceedingJoinPoint proceedingjoinpoint)
        throws Throwable
    {
        Object aobj[] = proceedingjoinpoint.getArgs();
        if (ajc$inlineAccessMethod$com_amazon_gallery_framework_aspect_AviaryCdsAspect$com_amazon_gallery_framework_aspect_AviaryCdsAspect$isDownloadFinished(((Integer)aobj[3]).intValue()))
        {
            Long long1 = (Long)aobj[1];
            GLogger.i(ajc$inlineAccessFieldGet$com_amazon_gallery_framework_aspect_AviaryCdsAspect$com_amazon_gallery_framework_aspect_AviaryCdsAspect$TAG(), "Remove trace for packDownloading request %d", new Object[] {
                long1
            });
            ajc$inlineAccessFieldGet$com_amazon_gallery_framework_aspect_AviaryCdsAspect$com_amazon_gallery_framework_aspect_AviaryCdsAspect$packDownloadingTracker(this).remove(long1);
            if (ajc$inlineAccessFieldGet$com_amazon_gallery_framework_aspect_AviaryCdsAspect$com_amazon_gallery_framework_aspect_AviaryCdsAspect$packDownloadingTracker(this).isEmpty())
            {
                ajc$inlineAccessMethod$com_amazon_gallery_framework_aspect_AviaryCdsAspect$com_amazon_gallery_framework_aspect_AviaryCdsAspect$unregisterReceiver((Context)aobj[0], this);
            } else
            {
                GLogger.i(ajc$inlineAccessFieldGet$com_amazon_gallery_framework_aspect_AviaryCdsAspect$com_amazon_gallery_framework_aspect_AviaryCdsAspect$TAG(), "There are still %d packs downloading", new Object[] {
                    Integer.valueOf(ajc$inlineAccessFieldGet$com_amazon_gallery_framework_aspect_AviaryCdsAspect$com_amazon_gallery_framework_aspect_AviaryCdsAspect$packDownloadingTracker(this).size())
                });
            }
        }
        return proceedingjoinpoint.proceed();
    }

    public Object invokeHandleKeys(ProceedingJoinPoint proceedingjoinpoint)
        throws Throwable
    {
        proceedingjoinpoint = (AviaryCdsService)proceedingjoinpoint.getThis();
        Field field = proceedingjoinpoint.getClass().getDeclaredField("mApiKeySecret");
        field.setAccessible(true);
        String s = (String)field.get(proceedingjoinpoint);
        if (s == null || TextUtils.isEmpty(s))
        {
            field.set(proceedingjoinpoint, "oeriumv75k11lb1h");
        }
        return null;
    }

    public Object invokeLoadPackMethod(ProceedingJoinPoint proceedingjoinpoint)
        throws Throwable
    {
        JSONObject jsonobject;
        Object obj;
        String s;
        byte byte0;
        jsonobject = (JSONObject)proceedingjoinpoint.getArgs()[1];
        obj = proceedingjoinpoint.getTarget().getClass().getDeclaredField("mContext");
        ((Field) (obj)).setAccessible(true);
        obj = (Context)((Field) (obj)).get(proceedingjoinpoint.getTarget());
        s = jsonobject.getString("packType");
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 3: default 100
    //                   -1890252483: 135
    //                   -1091287984: 169
    //                   97692013: 152;
           goto _L1 _L2 _L3 _L4
_L1:
        byte0;
        JVM INSTR tableswitch 0 2: default 128
    //                   0 186
    //                   1 204
    //                   2 222;
           goto _L5 _L6 _L7 _L8
_L5:
        return proceedingjoinpoint.proceed();
_L2:
        if (s.equals("sticker"))
        {
            byte0 = 0;
        }
          goto _L1
_L4:
        if (s.equals("frame"))
        {
            byte0 = 1;
        }
          goto _L1
_L3:
        if (s.equals("overlay"))
        {
            byte0 = 2;
        }
          goto _L1
_L6:
        ajc$inlineAccessMethod$com_amazon_gallery_framework_aspect_AviaryCdsAspect$com_amazon_gallery_framework_aspect_AviaryCdsAspect$populateJson(jsonobject, new StickerContentLoader(((Context) (obj)), ajc$inlineAccessFieldGet$com_amazon_gallery_framework_aspect_AviaryCdsAspect$com_amazon_gallery_framework_aspect_AviaryCdsAspect$CLOUD_FRONT_CONFIG()));
          goto _L5
_L7:
        ajc$inlineAccessMethod$com_amazon_gallery_framework_aspect_AviaryCdsAspect$com_amazon_gallery_framework_aspect_AviaryCdsAspect$populateJson(jsonobject, new FrameContentLoader(((Context) (obj)), ajc$inlineAccessFieldGet$com_amazon_gallery_framework_aspect_AviaryCdsAspect$com_amazon_gallery_framework_aspect_AviaryCdsAspect$CLOUD_FRONT_CONFIG()));
          goto _L5
_L8:
        ajc$inlineAccessMethod$com_amazon_gallery_framework_aspect_AviaryCdsAspect$com_amazon_gallery_framework_aspect_AviaryCdsAspect$populateJson(jsonobject, new OverlayContentLoader(((Context) (obj)), ajc$inlineAccessFieldGet$com_amazon_gallery_framework_aspect_AviaryCdsAspect$com_amazon_gallery_framework_aspect_AviaryCdsAspect$CLOUD_FRONT_CONFIG()));
          goto _L5
    }

    public Object invokeRequestDownload(ProceedingJoinPoint proceedingjoinpoint)
        throws Throwable
    {
        Object aobj[] = proceedingjoinpoint.getArgs();
        Long long1 = (Long)aobj[1];
        GLogger.i(ajc$inlineAccessFieldGet$com_amazon_gallery_framework_aspect_AviaryCdsAspect$com_amazon_gallery_framework_aspect_AviaryCdsAspect$TAG(), "Trace packDownloading request %d", new Object[] {
            long1
        });
        ajc$inlineAccessFieldGet$com_amazon_gallery_framework_aspect_AviaryCdsAspect$com_amazon_gallery_framework_aspect_AviaryCdsAspect$packDownloadingTracker(this).add(long1);
        if (ajc$inlineAccessFieldGet$com_amazon_gallery_framework_aspect_AviaryCdsAspect$com_amazon_gallery_framework_aspect_AviaryCdsAspect$packDownloadingTracker(this).size() == 1)
        {
            ajc$inlineAccessMethod$com_amazon_gallery_framework_aspect_AviaryCdsAspect$com_amazon_gallery_framework_aspect_AviaryCdsAspect$registerReceiver((Context)aobj[0], this);
        }
        return proceedingjoinpoint.proceed();
    }

    static 
    {
        CloudFrontConfig cloudfrontconfig;
        if (BuildFlavors.isDebug())
        {
            cloudfrontconfig = CloudFrontConfig.DEVELOPMENT;
        } else
        {
            cloudfrontconfig = CloudFrontConfig.PRODUCTION;
        }
        CLOUD_FRONT_CONFIG = cloudfrontconfig;
        try
        {
            ajc$postClinit();
        }
        catch (Throwable throwable)
        {
            ajc$initFailureCause = throwable;
        }
    }
}
