// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.content.InternalDomainError;
import com.ebay.nautilus.domain.dcs.DcsNautilusBoolean;
import com.ebay.nautilus.domain.dcs.DcsNautilusInteger;
import com.ebay.nautilus.domain.dcs.DcsNautilusLong;
import com.ebay.nautilus.domain.dcs.DcsNautilusString;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.ImageRequest;
import com.ebay.nautilus.domain.net.ImageResponse;
import com.ebay.nautilus.domain.net.image.EpsUrlRewriter;
import com.ebay.nautilus.domain.net.image.ZoomUrlBuilder;
import com.ebay.nautilus.domain.net.image.ZoomUrlRewriter;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.cachemanager.BitmapCacheManager;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ImageDataManager extends DataManager
{
    private final class GetImageTask extends AsyncTask
    {

        private boolean isCacheable;
        protected ArrayList observers;
        protected final String originalUrl;
        protected final String rewrittenUrl;
        private final long startMillis = System.currentTimeMillis();
        final ImageDataManager this$0;

        private byte[] loadBitmap(String s)
            throws InterruptedException
        {
            Object obj = null;
            byte abyte1[] = null;
            byte abyte0[] = obj;
            ImageResponse imageresponse;
            try
            {
                imageresponse = (ImageResponse)sendRequest(new ImageRequest(new URL(s), true));
            }
            catch (MalformedURLException malformedurlexception)
            {
                ImageDataManager.logTag.logAsError((new StringBuilder()).append(malformedurlexception.getClass().getSimpleName()).append(", ").append(s).toString(), malformedurlexception);
                return abyte0;
            }
            abyte0 = obj;
            if (imageresponse.getResultStatus().hasError())
            {
                break MISSING_BLOCK_LABEL_70;
            }
            abyte0 = obj;
            abyte1 = imageresponse.getByteArray();
            abyte0 = abyte1;
            isCacheable = imageresponse.isCacheable;
            return abyte1;
        }

        private void notifyObservers(Content content)
        {
            Object obj = removeActiveTask(this);
            if (content != null)
            {
                ResultStatus resultstatus = content.getStatus();
                content = (ImageInfo)content.getData();
                LoadToken loadtoken;
                ImageInfo imageinfo;
                for (obj = ((ArrayList) (obj)).iterator(); ((Iterator) (obj)).hasNext(); dispatchLoadImageComplete(loadtoken.observer, new Content(imageinfo, resultstatus)))
                {
                    loadtoken = (LoadToken)((Iterator) (obj)).next();
                    imageinfo = new ImageInfo(content, loadtoken);
                }

            }
        }

        public void addObserver(LoadToken loadtoken)
        {
            observers.add(loadtoken);
        }

        protected transient Content doInBackground(Void avoid[])
        {
            Object obj2;
            Object obj3;
            Object obj4;
            Object obj6;
            boolean flag;
            boolean flag2;
            boolean flag3;
            boolean flag4;
            boolean flag5;
            boolean flag6;
            boolean flag7;
            obj3 = null;
            obj4 = null;
            obj6 = null;
            avoid = null;
            obj2 = null;
            flag5 = true;
            flag6 = true;
            flag7 = true;
            flag = true;
            flag2 = flag5;
            flag3 = flag6;
            flag4 = flag7;
            Object obj = getCachedBitmap(rewrittenUrl);
            if (obj != null) goto _L2; else goto _L1
_L1:
            flag5 = false;
            flag6 = false;
            flag7 = false;
            flag = false;
            obj2 = obj;
            flag2 = flag5;
            obj3 = obj;
            flag3 = flag6;
            obj4 = obj;
            flag4 = flag7;
            obj6 = obj;
            avoid = ((Void []) (obj));
            byte abyte0[] = loadBitmap(rewrittenUrl.replaceAll(" ", "%20"));
            byte abyte1[];
            abyte1 = abyte0;
            if (abyte0 != null)
            {
                break MISSING_BLOCK_LABEL_230;
            }
            obj2 = obj;
            flag2 = flag5;
            obj3 = obj;
            flag3 = flag6;
            obj4 = obj;
            flag4 = flag7;
            obj6 = obj;
            avoid = ((Void []) (obj));
            Object obj5 = new URL(rewrittenUrl);
            obj2 = obj;
            flag2 = flag5;
            obj3 = obj;
            flag3 = flag6;
            obj4 = obj;
            flag4 = flag7;
            obj6 = obj;
            avoid = ((Void []) (obj));
            abyte1 = loadBitmap((new URI(((URL) (obj5)).getProtocol(), ((URL) (obj5)).getUserInfo(), ((URL) (obj5)).getHost(), ((URL) (obj5)).getPort(), ((URL) (obj5)).getPath(), ((URL) (obj5)).getQuery(), ((URL) (obj5)).getRef())).toString());
            boolean flag1;
            obj5 = obj;
            flag1 = flag;
            if (abyte1 == null) goto _L4; else goto _L3
_L3:
            obj2 = obj;
            flag2 = flag5;
            obj3 = obj;
            flag3 = flag6;
            obj4 = obj;
            flag4 = flag7;
            obj6 = obj;
            avoid = ((Void []) (obj));
            if (!isCacheable) goto _L6; else goto _L5
_L5:
            obj2 = obj;
            flag2 = flag5;
            obj3 = obj;
            flag3 = flag6;
            obj4 = obj;
            flag4 = flag7;
            obj6 = obj;
            avoid = ((Void []) (obj));
            obj5 = putCachedFlatBitmap(rewrittenUrl, abyte1);
            flag1 = flag;
_L4:
            long l = System.currentTimeMillis();
            long l5 = startMillis;
            avoid = ((Void []) (obj5));
            flag = flag1;
            if (ImageDataManager.logTag.isLoggable)
            {
                obj = ImageDataManager.logTag;
                obj2 = (new StringBuilder()).append("Load for ").append(rewrittenUrl).append(" ended after ").append(l - l5).append(" ms with ");
                MalformedURLException malformedurlexception;
                if (obj5 != null)
                {
                    avoid = "success.";
                } else
                {
                    avoid = "failure.";
                }
                ((com.ebay.nautilus.kernel.util.FwLog.LogInfo) (obj)).log(((StringBuilder) (obj2)).append(avoid).toString());
                flag = flag1;
                avoid = ((Void []) (obj5));
            }
_L8:
            Object obj1;
            if (avoid == null)
            {
                return new Content(new ImageInfo(originalUrl, null, false, null), ResultStatus.create(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
                    InternalDomainError.getDataIsNull()
                }));
            } else
            {
                return new Content(new ImageInfo(originalUrl, avoid, flag, null));
            }
_L6:
            obj2 = obj;
            flag2 = flag5;
            obj3 = obj;
            flag3 = flag6;
            obj4 = obj;
            flag4 = flag7;
            obj6 = obj;
            avoid = ((Void []) (obj));
            obj5 = putTemporaryCachedFlatBitmap(rewrittenUrl, abyte1);
            flag1 = flag;
              goto _L4
_L2:
            obj5 = obj;
            flag1 = flag;
            obj2 = obj;
            flag2 = flag5;
            obj3 = obj;
            flag3 = flag6;
            obj4 = obj;
            flag4 = flag7;
            obj6 = obj;
            avoid = ((Void []) (obj));
            if (!ImageDataManager.logTag.isLoggable) goto _L4; else goto _L7
_L7:
            obj2 = obj;
            flag2 = flag5;
            obj3 = obj;
            flag3 = flag6;
            obj4 = obj;
            flag4 = flag7;
            obj6 = obj;
            avoid = ((Void []) (obj));
            ImageDataManager.logTag.log((new StringBuilder()).append("Found cached bitmap for url: ").append(rewrittenUrl).toString());
            obj5 = obj;
            flag1 = flag;
              goto _L4
            malformedurlexception;
            avoid = ((Void []) (obj2));
            ImageDataManager.logTag.logAsError((new StringBuilder()).append(malformedurlexception.getClass().getSimpleName()).append(", ").append(rewrittenUrl).toString(), malformedurlexception);
            l = System.currentTimeMillis();
            l5 = startMillis;
            avoid = ((Void []) (obj2));
            flag = flag2;
            if (ImageDataManager.logTag.isLoggable)
            {
                malformedurlexception = ImageDataManager.logTag;
                obj3 = (new StringBuilder()).append("Load for ").append(rewrittenUrl).append(" ended after ").append(l - l5).append(" ms with ");
                if (obj2 != null)
                {
                    avoid = "success.";
                } else
                {
                    avoid = "failure.";
                }
                malformedurlexception.log(((StringBuilder) (obj3)).append(avoid).toString());
                avoid = ((Void []) (obj2));
                flag = flag2;
            }
              goto _L8
            obj1;
            avoid = ((Void []) (obj3));
            ImageDataManager.logTag.logAsError((new StringBuilder()).append(obj1.getClass().getSimpleName()).append(", ").append(rewrittenUrl).toString(), ((Throwable) (obj1)));
            long l1 = System.currentTimeMillis();
            long l6 = startMillis;
            avoid = ((Void []) (obj3));
            flag = flag3;
            if (ImageDataManager.logTag.isLoggable)
            {
                com.ebay.nautilus.kernel.util.FwLog.LogInfo loginfo = ImageDataManager.logTag;
                StringBuilder stringbuilder = (new StringBuilder()).append("Load for ").append(rewrittenUrl).append(" ended after ").append(l1 - l6).append(" ms with ");
                if (obj3 != null)
                {
                    avoid = "success.";
                } else
                {
                    avoid = "failure.";
                }
                loginfo.log(stringbuilder.append(avoid).toString());
                avoid = ((Void []) (obj3));
                flag = flag3;
            }
              goto _L8
            avoid;
            avoid = ((Void []) (obj4));
            ImageDataManager.logTag.logAsWarning((new StringBuilder()).append("OutOfMemoryError in ImageDataManager.doInBackground() while fetching url: ").append(rewrittenUrl).toString());
            long l2 = System.currentTimeMillis();
            long l7 = startMillis;
            avoid = ((Void []) (obj4));
            flag = flag4;
            if (ImageDataManager.logTag.isLoggable)
            {
                com.ebay.nautilus.kernel.util.FwLog.LogInfo loginfo1 = ImageDataManager.logTag;
                StringBuilder stringbuilder1 = (new StringBuilder()).append("Load for ").append(rewrittenUrl).append(" ended after ").append(l2 - l7).append(" ms with ");
                if (obj4 != null)
                {
                    avoid = "success.";
                } else
                {
                    avoid = "failure.";
                }
                loginfo1.log(stringbuilder1.append(avoid).toString());
                avoid = ((Void []) (obj4));
                flag = flag4;
            }
              goto _L8
            avoid;
            avoid = ((Void []) (obj6));
            removeActiveTask(this);
            long l3 = System.currentTimeMillis();
            long l8 = startMillis;
            if (ImageDataManager.logTag.isLoggable)
            {
                com.ebay.nautilus.kernel.util.FwLog.LogInfo loginfo2 = ImageDataManager.logTag;
                StringBuilder stringbuilder2 = (new StringBuilder()).append("Load for ").append(rewrittenUrl).append(" ended after ").append(l3 - l8).append(" ms with ");
                if (obj6 != null)
                {
                    avoid = "success.";
                } else
                {
                    avoid = "failure.";
                }
                loginfo2.log(stringbuilder2.append(avoid).toString());
            }
            return null;
            loginfo2;
            long l4 = System.currentTimeMillis();
            long l9 = startMillis;
            if (ImageDataManager.logTag.isLoggable)
            {
                com.ebay.nautilus.kernel.util.FwLog.LogInfo loginfo3 = ImageDataManager.logTag;
                StringBuilder stringbuilder3 = (new StringBuilder()).append("Load for ").append(rewrittenUrl).append(" ended after ").append(l4 - l9).append(" ms with ");
                if (avoid != null)
                {
                    avoid = "success.";
                } else
                {
                    avoid = "failure.";
                }
                loginfo3.log(stringbuilder3.append(avoid).toString());
            }
            throw loginfo2;
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        public boolean isEmptyObservers()
        {
            return observers.isEmpty();
        }

        protected void onCancelled(Content content)
        {
            notifyObservers(content);
        }

        protected volatile void onCancelled(Object obj)
        {
            onCancelled((Content)obj);
        }

        protected void onPostExecute(Content content)
        {
            super.onPostExecute(content);
            notifyObservers(content);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        public boolean removeObserver(LoadToken loadtoken)
        {
            return observers.remove(loadtoken);
        }

        public ArrayList takeObservers()
        {
            ArrayList arraylist = observers;
            observers = new ArrayList();
            return arraylist;
        }

        public GetImageTask(String s, String s1)
        {
            this$0 = ImageDataManager.this;
            super();
            observers = new ArrayList();
            isCacheable = false;
            originalUrl = s;
            rewrittenUrl = s1;
        }
    }

    public static final class ImageInfo
    {

        public final boolean fromCache;
        public final Bitmap image;
        public final LoadToken loadToken;
        public final String url;

        public ImageInfo(ImageInfo imageinfo, LoadToken loadtoken)
        {
            this(imageinfo.url, imageinfo.image, imageinfo.fromCache, loadtoken);
        }

        public ImageInfo(String s, Bitmap bitmap, boolean flag, LoadToken loadtoken)
        {
            url = s;
            image = bitmap;
            fromCache = flag;
            loadToken = loadtoken;
        }
    }

    public static final class KeyParams extends com.ebay.nautilus.domain.content.DataManager.DataManagerKeyParams
    {

        public volatile DataManager createManager(EbayContext ebaycontext)
        {
            return createManager(ebaycontext);
        }

        public ImageDataManager createManager(EbayContext ebaycontext)
        {
            return new ImageDataManager(ebaycontext);
        }

        protected KeyParams()
        {
        }
    }

    public static class LoadToken
    {

        protected final String key;
        protected final Observer observer;

        protected LoadToken(String s, Observer observer1)
        {
            key = s;
            observer = observer1;
        }
    }

    public static interface Observer
    {

        public abstract void onLoadImageComplete(ImageDataManager imagedatamanager, Content content);
    }

    public static final class UrlRewriterType extends Enum
    {

        private static final UrlRewriterType $VALUES[];
        public static final UrlRewriterType AKAMAI;
        public static final UrlRewriterType EPS;
        public static final UrlRewriterType NONE;
        public static final UrlRewriterType ZOOM_GALLERY;
        public static final UrlRewriterType ZOOM_MERCH;
        public static final UrlRewriterType ZOOM_VIEWITEM;

        public static UrlRewriterType from(String s)
        {
            if (TextUtils.isEmpty(s))
            {
                break MISSING_BLOCK_LABEL_15;
            }
            s = valueOf(s);
            return s;
            s;
            return NONE;
        }

        public static UrlRewriterType valueOf(String s)
        {
            return (UrlRewriterType)Enum.valueOf(com/ebay/nautilus/domain/content/dm/ImageDataManager$UrlRewriterType, s);
        }

        public static UrlRewriterType[] values()
        {
            return (UrlRewriterType[])$VALUES.clone();
        }

        static 
        {
            NONE = new UrlRewriterType("NONE", 0);
            EPS = new UrlRewriterType("EPS", 1);
            ZOOM_GALLERY = new UrlRewriterType("ZOOM_GALLERY", 2);
            ZOOM_VIEWITEM = new UrlRewriterType("ZOOM_VIEWITEM", 3);
            ZOOM_MERCH = new UrlRewriterType("ZOOM_MERCH", 4);
            AKAMAI = new UrlRewriterType("AKAMAI", 5);
            $VALUES = (new UrlRewriterType[] {
                NONE, EPS, ZOOM_GALLERY, ZOOM_VIEWITEM, ZOOM_MERCH, AKAMAI
            });
        }

        private UrlRewriterType(String s, int i)
        {
            super(s, i);
        }
    }


    public static final KeyParams KEY = new KeyParams();
    public static final long MAX_TTL = 0x9a7ec800L;
    private static HashMap activeTasks = new HashMap();
    private static volatile BitmapCacheManager cacheManager;
    private static final ExecutorService imageExecutor = Executors.newFixedThreadPool(4);
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logTag = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("ImageDM", 3, "Log Image DM");
    private EpsUrlRewriter epsGalleryRewriter;
    private ZoomUrlRewriter zoomGalleryRewriter;
    private ZoomUrlRewriter zoomMerchRewriter;
    private volatile ZoomUrlBuilder zoomUrlBuilder;
    private ZoomUrlRewriter zoomViewItemRewriter;

    protected ImageDataManager(EbayContext ebaycontext)
    {
        super(ebaycontext, com/ebay/nautilus/domain/content/dm/ImageDataManager$Observer);
        zoomUrlBuilder = null;
        com/ebay/nautilus/domain/content/dm/ImageDataManager;
        JVM INSTR monitorenter ;
        ebaycontext = DeviceConfiguration.getAsync();
        if (cacheManager == null)
        {
            cacheManager = new BitmapCacheManager(getContext(), "imageDataManagerBitmap", ebaycontext.get(DcsNautilusInteger.ImageDataManagerInMemoryInflatedSize), ebaycontext.get(DcsNautilusInteger.ImageDataManagerInMemoryFlatSize), ebaycontext.get(DcsNautilusLong.ImageDataManagerDiskSize), 0x9a7ec800L, true);
        }
        zoomGalleryRewriter = new ZoomUrlRewriter(ebaycontext, 1);
        zoomViewItemRewriter = new ZoomUrlRewriter(ebaycontext, 2);
        zoomMerchRewriter = new ZoomUrlRewriter(ebaycontext, 3);
        if (!TextUtils.isEmpty(ebaycontext.get(DcsNautilusString.ThumbnailHost)))
        {
            epsGalleryRewriter = new EpsUrlRewriter(ebaycontext);
        }
        com/ebay/nautilus/domain/content/dm/ImageDataManager;
        JVM INSTR monitorexit ;
        return;
        ebaycontext;
        com/ebay/nautilus/domain/content/dm/ImageDataManager;
        JVM INSTR monitorexit ;
        throw ebaycontext;
    }

    private boolean bypassUrlRewriter(DeviceConfiguration deviceconfiguration, String s, String s1)
    {
        if (TextUtils.isEmpty(s) && TextUtils.isEmpty(s1))
        {
            return false;
        } else
        {
            return ZoomUrlBuilder.isValid(deviceconfiguration);
        }
    }

    private static transient AsyncTask executeOnImageThreadPool(AsyncTask asynctask, Object aobj[])
    {
        return asynctask.executeOnExecutor(imageExecutor, aobj);
    }

    private String rewriteUrl(String s, UrlRewriterType urlrewritertype, int i, int j)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        urlrewritertype = null;
_L10:
        return urlrewritertype;
_L2:
        Object obj;
        DeviceConfiguration deviceconfiguration;
label0:
        {
            deviceconfiguration = DeviceConfiguration.getAsync();
            obj = urlrewritertype;
            if (deviceconfiguration.get(DcsNautilusBoolean.UseZoomImageService))
            {
                break label0;
            }
            if (urlrewritertype != UrlRewriterType.ZOOM_GALLERY && urlrewritertype != UrlRewriterType.ZOOM_VIEWITEM)
            {
                obj = urlrewritertype;
                if (urlrewritertype != UrlRewriterType.ZOOM_MERCH)
                {
                    break label0;
                }
            }
            obj = UrlRewriterType.EPS;
        }
        static class _cls1
        {

            static final int $SwitchMap$com$ebay$nautilus$domain$content$dm$ImageDataManager$UrlRewriterType[];

            static 
            {
                $SwitchMap$com$ebay$nautilus$domain$content$dm$ImageDataManager$UrlRewriterType = new int[UrlRewriterType.values().length];
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$content$dm$ImageDataManager$UrlRewriterType[UrlRewriterType.NONE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$content$dm$ImageDataManager$UrlRewriterType[UrlRewriterType.ZOOM_GALLERY.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$content$dm$ImageDataManager$UrlRewriterType[UrlRewriterType.ZOOM_VIEWITEM.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$content$dm$ImageDataManager$UrlRewriterType[UrlRewriterType.ZOOM_MERCH.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$content$dm$ImageDataManager$UrlRewriterType[UrlRewriterType.AKAMAI.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.ebay.nautilus.domain.content.dm.ImageDataManager.UrlRewriterType[((UrlRewriterType) (obj)).ordinal()];
        JVM INSTR tableswitch 1 5: default 100
    //                   1 141
    //                   2 143
    //                   3 205
    //                   4 267
    //                   5 329;
           goto _L3 _L4 _L5 _L6 _L7 _L8
_L3:
        if (epsGalleryRewriter == null)
        {
            break; /* Loop/switch isn't completed */
        }
        epsGalleryRewriter.constrainSize(i, j);
        obj = epsGalleryRewriter.rewriteUrl(s);
        urlrewritertype = ((UrlRewriterType) (obj));
        if (!s.equals(obj)) goto _L10; else goto _L9
_L9:
        return s;
_L4:
        return s;
_L5:
        if (zoomGalleryRewriter != null)
        {
            if (zoomGalleryRewriter.isStale(deviceconfiguration))
            {
                zoomGalleryRewriter = new ZoomUrlRewriter(deviceconfiguration, 1);
            }
            zoomGalleryRewriter.constrainSize(i, j);
            urlrewritertype = zoomGalleryRewriter.rewriteUrl(s);
            if (!s.equals(urlrewritertype))
            {
                return urlrewritertype;
            }
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (zoomViewItemRewriter != null)
        {
            if (zoomViewItemRewriter.isStale(deviceconfiguration))
            {
                zoomViewItemRewriter = new ZoomUrlRewriter(deviceconfiguration, 2);
            }
            zoomViewItemRewriter.constrainSize(i, j);
            urlrewritertype = zoomViewItemRewriter.rewriteUrl(s);
            if (!s.equals(urlrewritertype))
            {
                return urlrewritertype;
            }
        }
        continue; /* Loop/switch isn't completed */
_L7:
        if (zoomMerchRewriter != null)
        {
            if (zoomMerchRewriter.isStale(deviceconfiguration))
            {
                zoomMerchRewriter = new ZoomUrlRewriter(deviceconfiguration, 3);
            }
            zoomMerchRewriter.constrainSize(i, j);
            urlrewritertype = zoomMerchRewriter.rewriteUrl(s);
            if (!s.equals(urlrewritertype))
            {
                return urlrewritertype;
            }
        }
        continue; /* Loop/switch isn't completed */
_L8:
        Log.e(logTag.tag, "ImageDataManager does not yet support Akamai");
        if (true) goto _L9; else goto _L11
_L11:
    }

    private String rewriteUrlAndLog(String s, String s1, String s2, UrlRewriterType urlrewritertype, int i, int j)
    {
label0:
        {
            DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
            if (bypassUrlRewriter(deviceconfiguration, s1, s2))
            {
                s1 = buildZoomUrl(deviceconfiguration, s1, s2, i, j);
            } else
            {
                s1 = rewriteUrl(s, urlrewritertype, i, j);
            }
            if (logTag.isLoggable)
            {
                logTag.log((new StringBuilder()).append("loadImage original URL: ").append(s).toString());
                if (!TextUtils.equals(s, s1))
                {
                    break label0;
                }
                logTag.log("No URL rewriting performed");
            }
            return s1;
        }
        logTag.log((new StringBuilder()).append("URL rewritten as ").append(s1).toString());
        return s1;
    }

    public BitmapCacheManager TEST_getCacheManager()
    {
        return cacheManager;
    }

    public void TEST_nullifyCacheManager()
    {
        cacheManager = null;
    }

    String buildZoomUrl(DeviceConfiguration deviceconfiguration, String s, String s1, int i, int j)
    {
        if (zoomUrlBuilder == null || zoomUrlBuilder.isStale(deviceconfiguration))
        {
            zoomUrlBuilder = new ZoomUrlBuilder(deviceconfiguration);
        }
        return zoomUrlBuilder.build(s, s1, i, j);
    }

    public void cancelLoadImage(LoadToken loadtoken)
    {
        NautilusKernel.verifyMain();
        if (loadtoken == null)
        {
            return;
        }
        HashMap hashmap = activeTasks;
        hashmap;
        JVM INSTR monitorenter ;
        GetImageTask getimagetask = (GetImageTask)activeTasks.get(loadtoken.key);
        if (getimagetask == null)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        if (logTag.isLoggable)
        {
            logTag.log((new StringBuilder()).append("Canceling load for ").append(loadtoken.key).toString());
        }
        getimagetask.removeObserver(loadtoken);
        if (getimagetask.isEmptyObservers())
        {
            removeActiveTask(getimagetask);
            getimagetask.cancel(true);
        }
        hashmap;
        JVM INSTR monitorexit ;
        return;
        loadtoken;
        hashmap;
        JVM INSTR monitorexit ;
        throw loadtoken;
    }

    protected void dispatchLoadImageComplete(Observer observer, Content content)
    {
        if (observer != null)
        {
            observer.onLoadImageComplete(this, content);
        }
    }

    public void flush()
    {
        cacheManager.clear();
    }

    protected Bitmap getCachedBitmap(String s)
    {
        return (Bitmap)cacheManager.get(s);
    }

    protected Bitmap getCachedInMemoryBitmap(String s)
    {
        return (Bitmap)cacheManager.getInMemory(s);
    }

    public KeyParams getParams()
    {
        return KEY;
    }

    public volatile Object getParams()
    {
        return getParams();
    }

    public void loadData(Observer observer)
    {
        NautilusKernel.verifyMain();
    }

    public volatile void loadData(Object obj)
    {
        loadData((Observer)obj);
    }

    public LoadToken loadImage(Observer observer, String s)
    {
        return loadImage(observer, s, null, null);
    }

    public LoadToken loadImage(Observer observer, String s, String s1, String s2)
    {
        return loadImage(observer, s, s1, s2, UrlRewriterType.NONE, 0, 0);
    }

    public LoadToken loadImage(Observer observer, String s, String s1, String s2, UrlRewriterType urlrewritertype, int i, int j)
    {
        Object obj;
        NautilusKernel.verifyMain();
        if (observer == null)
        {
            throw new IllegalArgumentException("Observer must not be null.");
        }
        s2 = rewriteUrlAndLog(s, s1, s2, urlrewritertype, i, j);
        s1 = null;
        obj = (Observer)getSafeCallback(observer);
        urlrewritertype = new LoadToken(s2, ((Observer) (obj)));
        if (s != null) goto _L2; else goto _L1
_L1:
        observer = new Content(new ImageInfo(s, null, false, urlrewritertype), ResultStatus.create(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
            InternalDomainError.getDataIsNull()
        }));
_L4:
        if (observer != null)
        {
            break; /* Loop/switch isn't completed */
        }
        i = 0;
        obj = activeTasks;
        obj;
        JVM INSTR monitorenter ;
        s1 = (GetImageTask)activeTasks.get(s2);
        observer = s1;
        if (s1 != null)
        {
            break MISSING_BLOCK_LABEL_154;
        }
        observer = new GetImageTask(s, s2);
        activeTasks.put(s2, observer);
        i = 1;
        observer.addObserver(urlrewritertype);
        obj;
        JVM INSTR monitorexit ;
        if (i != 0)
        {
            executeOnImageThreadPool(observer, new Void[0]);
        }
        return urlrewritertype;
_L2:
        Bitmap bitmap = getCachedInMemoryBitmap(s2);
        observer = s1;
        if (bitmap == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        observer = new Content(new ImageInfo(s, bitmap, true, urlrewritertype));
        try
        {
            if (logTag.isLoggable)
            {
                logTag.log((new StringBuilder()).append("Retrieved from memory cache: ").append(s2).toString());
            }
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Observer observer) { }
        break MISSING_BLOCK_LABEL_256;
        observer;
        logTag.logAsWarning((new StringBuilder()).append("OutOfMemoryError in ImageDataManager.loadImage() while fetching url: ").append(s2).toString());
        observer = new Content(new ImageInfo(s, null, false, urlrewritertype), ResultStatus.create(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
            InternalDomainError.getDataIsNull()
        }));
        if (true) goto _L4; else goto _L3
        observer;
        obj;
        JVM INSTR monitorexit ;
        throw observer;
_L3:
        dispatchLoadImageComplete(((Observer) (obj)), observer);
        return urlrewritertype;
    }

    public Bitmap loadImageImmediate(String s)
    {
        return loadImageImmediate(s, null, null);
    }

    public Bitmap loadImageImmediate(String s, String s1, String s2)
    {
        return loadImageImmediate(s, s1, s2, UrlRewriterType.NONE, 0, 0);
    }

    public Bitmap loadImageImmediate(String s, String s1, String s2, UrlRewriterType urlrewritertype, int i, int j)
    {
        s = rewriteUrlAndLog(s, s1, s2, urlrewritertype, i, j);
        try
        {
            s1 = getCachedInMemoryBitmap(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            logTag.logAsWarning((new StringBuilder()).append("OutOfMemoryError in ImageDataManager.loadImageImmediate() while fetching url: ").append(s).toString());
            return null;
        }
        return s1;
    }

    protected void onLastObserverUnregistered()
    {
        HashMap hashmap = activeTasks;
        hashmap;
        JVM INSTR monitorenter ;
        for (Iterator iterator = activeTasks.values().iterator(); iterator.hasNext(); ((GetImageTask)iterator.next()).cancel(true)) { }
        break MISSING_BLOCK_LABEL_49;
        Exception exception;
        exception;
        hashmap;
        JVM INSTR monitorexit ;
        throw exception;
        activeTasks.clear();
        hashmap;
        JVM INSTR monitorexit ;
    }

    protected Bitmap putCachedFlatBitmap(String s, byte abyte0[])
    {
        if (abyte0 != null)
        {
            return (Bitmap)cacheManager.putFlattenedBytes(s, abyte0);
        } else
        {
            return null;
        }
    }

    protected Bitmap putTemporaryCachedFlatBitmap(String s, byte abyte0[])
    {
        if (abyte0 != null)
        {
            return (Bitmap)cacheManager.putFlattenedBytes(s, abyte0, 30000L);
        } else
        {
            return null;
        }
    }

    protected ArrayList removeActiveTask(GetImageTask getimagetask)
    {
        synchronized (activeTasks)
        {
            if ((GetImageTask)activeTasks.get(getimagetask.rewrittenUrl) == getimagetask)
            {
                activeTasks.remove(getimagetask.rewrittenUrl);
            }
            getimagetask = getimagetask.takeObservers();
        }
        return getimagetask;
        getimagetask;
        hashmap;
        JVM INSTR monitorexit ;
        throw getimagetask;
    }


}
