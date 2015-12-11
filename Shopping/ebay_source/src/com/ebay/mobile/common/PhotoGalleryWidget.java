// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.common;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ScrollView;
import com.ebay.common.util.Debug;
import com.ebay.common.util.ImageUtil;
import com.ebay.mobile.dcs.DcsInteger;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.ImageRequest;
import com.ebay.nautilus.domain.net.ImageResponse;
import com.ebay.nautilus.domain.net.image.ConstructDipUrl;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.util.FwLog;
import com.ebay.nautilus.kernel.util.StreamUtil;
import com.ebay.nautilus.shell.app.FwActivity;
import com.ebay.nautilus.shell.app.FwLoaderManager;
import com.ebay.nautilus.shell.content.FwLoader;
import com.ebay.nautilus.shell.content.FwNetLoader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PhotoGalleryWidget extends View
    implements android.view.GestureDetector.OnGestureListener
{
    private static class AutoScroll extends Handler
        implements Runnable
    {

        private final WeakReference widget;

        public void run()
        {
            PhotoGalleryWidget photogallerywidget = (PhotoGalleryWidget)widget.get();
            if (photogallerywidget == null || !photogallerywidget.autoScrolling) goto _L2; else goto _L1
_L1:
            int i;
            int j;
            boolean flag;
            flag = false;
            j = photogallerywidget.mOutsidePicturePadding;
            i = 0;
_L8:
            int k = ((flag) ? 1 : 0);
            if (i >= photogallerywidget.mPhotos.size()) goto _L4; else goto _L3
_L3:
            int l = ((Photo)photogallerywidget.mPhotos.get(i)).getWidthPlusFramePadding();
            k = l;
            if (i < photogallerywidget.mPhotos.size() - 1)
            {
                k = l + photogallerywidget.mBetweenPicturePadding;
            }
            j += k;
            if (photogallerywidget.mStart + photogallerywidget.mWidth >= j) goto _L6; else goto _L5
_L5:
            k = 1;
_L4:
            if (!photogallerywidget.drawn || k != 0)
            {
                photogallerywidget.snapToFling(Boolean.valueOf(true));
                postDelayed(this, photogallerywidget.autoScrollDelayMs);
            }
_L2:
            return;
_L6:
            i++;
            if (true) goto _L8; else goto _L7
_L7:
        }

        public AutoScroll(PhotoGalleryWidget photogallerywidget)
        {
            widget = new WeakReference(photogallerywidget);
        }
    }

    private class FlingRunnable
        implements Runnable
    {

        private int mLastFlingX;
        final PhotoGalleryWidget this$0;

        private final void stop()
        {
            removeCallbacks(this);
            mScroller.forceFinished(true);
        }

        public final void run()
        {
            mShouldStopFling = false;
            boolean flag = mScroller.computeScrollOffset();
            int i = mScroller.getCurrX();
            int j = mLastFlingX;
            trackMotionFling(j - i);
            if (flag && !mShouldStopFling)
            {
                mLastFlingX = i;
                post(this);
                return;
            } else
            {
                stop();
                testForBounceFling();
                return;
            }
        }

        public final void startUsingVelocity(int i)
        {
            if (i != 0)
            {
                removeCallbacks(this);
                int j;
                if (i < 0)
                {
                    j = 0x7fffffff;
                } else
                {
                    j = 0;
                }
                mLastFlingX = j;
                mScroller.fling(j, i);
                post(this);
            }
        }


        private FlingRunnable()
        {
            this$0 = PhotoGalleryWidget.this;
            super();
        }

    }

    public static class GetPhotoNetLoader extends FwNetLoader
    {

        private final int index;
        private final int lruSize;
        private final PhotoResolution resolution;
        private byte result[];
        private final long startMillis = System.currentTimeMillis();
        private final String url;
        public String urlString;

        private byte[] getBytes(Context context1, URL url1)
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, IOException, InterruptedException
        {
            Object obj;
            byte abyte1[];
            Object obj3;
            Object obj4;
            Object obj5;
            Object obj6;
            Object obj7;
            File file;
            int i;
            boolean flag;
            abyte1 = null;
            obj3 = null;
            obj4 = null;
            obj5 = null;
            Object obj1 = null;
            if (Debug.logPhotoGallery.isLoggable)
            {
                FwLog.println(Debug.logPhotoGallery, (new StringBuilder()).append("Requested data for: ").append(url1.toString()).toString());
            }
            flag = true;
            file = getFile(context1, url1.toString());
            obj = obj1;
            i = ((flag) ? 1 : 0);
            if (lruSize <= 0)
            {
                break MISSING_BLOCK_LABEL_264;
            }
            obj = obj1;
            i = ((flag) ? 1 : 0);
            if (!file.exists())
            {
                break MISSING_BLOCK_LABEL_264;
            }
            obj = obj1;
            i = ((flag) ? 1 : 0);
            if (file.lastModified() + 0x5265c00L <= System.currentTimeMillis())
            {
                break MISSING_BLOCK_LABEL_264;
            }
            obj7 = null;
            obj = null;
            obj6 = null;
            byte abyte0[] = new RandomAccessFile(file, "r");
            obj = obj4;
            abyte1 = obj5;
            i = (int)abyte0.length();
            obj = obj4;
            abyte1 = obj5;
            obj3 = new byte[i];
            obj = obj3;
            abyte1 = ((byte []) (obj3));
            abyte0.readFully(((byte []) (obj3)));
            obj = obj3;
            abyte1 = ((byte []) (obj3));
            if (!Debug.logPhotoGallery.isLoggable)
            {
                break MISSING_BLOCK_LABEL_253;
            }
            obj = obj3;
            abyte1 = ((byte []) (obj3));
            FwLog.println(Debug.logPhotoGallery, (new StringBuilder()).append("   in cache -- file length: ").append(i).append(" data size: ").append(obj3.length).append(" ").append(url1.toString()).toString());
            i = 0;
            StreamUtil.closeQuietly(abyte0);
            obj = obj3;
_L1:
            if (i == 0)
            {
                break MISSING_BLOCK_LABEL_381;
            }
            if (Debug.logPhotoGallery.isLoggable)
            {
                FwLog.println(Debug.logPhotoGallery, (new StringBuilder()).append("   NOT in cache ").append(url1.toString()).toString());
            }
            abyte0 = ((ImageResponse)sendRequest(new ImageRequest(url1, true))).getByteArray();
            obj = abyte0;
            if (abyte0 == null)
            {
                break MISSING_BLOCK_LABEL_381;
            }
            pruneOldestIfNecessary(context1);
            obj = abyte0;
            if (lruSize <= 0)
            {
                break MISSING_BLOCK_LABEL_381;
            }
            context1 = null;
            obj = null;
            url1 = new FileOutputStream(file);
            url1.write(abyte0);
            url1.close();
            StreamUtil.closeQuietly(null);
            obj = abyte0;
            return ((byte []) (obj));
            obj3;
            abyte0 = obj6;
_L9:
            obj = abyte0;
            if (!Debug.logPhotoGallery.isLoggable)
            {
                break MISSING_BLOCK_LABEL_433;
            }
            obj = abyte0;
            Debug.logPhotoGallery.log((new StringBuilder()).append("PhotoGallery reading file from cache failed: ").append(((IOException) (obj3)).toString()).toString());
            StreamUtil.closeQuietly(abyte0);
            obj = abyte1;
            i = ((flag) ? 1 : 0);
              goto _L1
            obj;
            Object obj2;
            obj2 = obj7;
            abyte0 = ((byte []) (obj3));
_L8:
            obj = obj2;
            if (!Debug.logPhotoGallery.isLoggable)
            {
                break MISSING_BLOCK_LABEL_500;
            }
            obj = obj2;
            FwLog.println(Debug.logPhotoGallery, (new StringBuilder()).append("   OOM! ").append(url1.toString()).toString());
            StreamUtil.closeQuietly(((java.io.Closeable) (obj2)));
            obj = abyte0;
            i = ((flag) ? 1 : 0);
              goto _L1
            context1;
_L7:
            StreamUtil.closeQuietly(((java.io.Closeable) (obj)));
            throw context1;
            context1;
            url1 = ((URL) (obj));
            obj = context1;
_L5:
            context1 = url1;
            if (!Debug.logPhotoGallery.isLoggable)
            {
                break MISSING_BLOCK_LABEL_568;
            }
            context1 = url1;
            Debug.logPhotoGallery.log((new StringBuilder()).append("PhotoGallery writing file to cache failed: ").append(((IOException) (obj)).toString()).toString());
            StreamUtil.closeQuietly(url1);
            return abyte0;
            url1;
_L3:
            StreamUtil.closeQuietly(context1);
            throw url1;
            obj;
            context1 = url1;
            url1 = ((URL) (obj));
            if (true) goto _L3; else goto _L2
_L2:
            obj;
            if (true) goto _L5; else goto _L4
_L4:
            context1;
            obj = abyte0;
            if (true) goto _L7; else goto _L6
_L6:
            OutOfMemoryError outofmemoryerror;
            outofmemoryerror;
            outofmemoryerror = abyte0;
            abyte0 = ((byte []) (obj));
              goto _L8
            obj3;
              goto _L9
        }

        private String getCacheFolder(Context context1)
        {
            return (new StringBuilder()).append(context1.getCacheDir()).append(File.separator).append("ImageCache").toString();
        }

        private File getFile(Context context1, String s)
        {
            int i = 255 - "PhotoGallery-".length();
            Object obj = s.replaceAll("[^A-Za-z0-9]", "");
            s = ((String) (obj));
            if (i < ((String) (obj)).length())
            {
                s = ((String) (obj)).substring(((String) (obj)).length() - i);
            }
            obj = new StringBuilder();
            ((StringBuilder) (obj)).append("PhotoGallery-").append(s);
            context1 = new File(getCacheFolder(context1));
            context1.mkdirs();
            return new File(context1, ((StringBuilder) (obj)).toString());
        }

        private void pruneOldestIfNecessary(Context context1)
        {
label0:
            {
                File afile[] = (new File(getCacheFolder(context1))).listFiles();
                if (afile == null)
                {
                    break label0;
                }
                int i1 = afile.length;
                int j1 = lruSize;
                for (int j = 0; j < i1 - j1 - 1; j++)
                {
                    int k = -1;
                    context1 = null;
                    for (int i = 0; i < afile.length;)
                    {
                        Object obj;
                        int l;
label1:
                        {
                            File file = afile[i];
                            l = k;
                            obj = context1;
                            if (file == null)
                            {
                                break label1;
                            }
                            long l1 = file.lastModified();
                            if (context1 != null)
                            {
                                l = k;
                                obj = context1;
                                if (l1 >= context1.longValue())
                                {
                                    break label1;
                                }
                            }
                            obj = Long.valueOf(l1);
                            l = i;
                        }
                        i++;
                        k = l;
                        context1 = ((Context) (obj));
                    }

                    if (-1 == k)
                    {
                        continue;
                    }
                    afile[k].delete();
                    if (Debug.logPhotoGallery.isLoggable)
                    {
                        FwLog.println(Debug.logPhotoGallery, (new StringBuilder()).append(" deleting oldest file: ").append(afile[k].toString()).toString());
                    }
                    afile[k] = null;
                }

            }
        }

        protected final void doInBackgroundInternal()
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, IOException, InterruptedException
        {
            static class _cls2
            {

                static final int $SwitchMap$com$ebay$mobile$common$PhotoGalleryWidget$PhotoResolution[];

                static 
                {
                    $SwitchMap$com$ebay$mobile$common$PhotoGalleryWidget$PhotoResolution = new int[PhotoResolution.values().length];
                    try
                    {
                        $SwitchMap$com$ebay$mobile$common$PhotoGalleryWidget$PhotoResolution[PhotoResolution.High.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$common$PhotoGalleryWidget$PhotoResolution[PhotoResolution.Medium.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$common$PhotoGalleryWidget$PhotoResolution[PhotoResolution.Standard.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            _cls2..SwitchMap.com.ebay.mobile.common.PhotoGalleryWidget.PhotoResolution[resolution.ordinal()];
            JVM INSTR tableswitch 1 3: default 1329
        //                       1 306
        //                       2 466
        //                       3 626;
               goto _L1 _L2 _L3 _L4
_L1:
            if (Debug.logPhotoGallery.isLoggable)
            {
                FwLog.println(Debug.logPhotoGallery, (new StringBuilder()).append("urlString updated to ").append(urlString).toString());
            }
            if (urlString == null)
            {
                urlString = url;
            }
            if (urlString != null)
            {
                URL url1 = URI.create(urlString).toURL();
                Context context1 = getContext();
                result = getBytes(context1, url1);
                if (result == null && urlString != null)
                {
                    URL url2 = new URL(urlString);
                    url2 = (new URI(url2.getProtocol(), url2.getUserInfo(), url2.getHost(), url2.getPort(), url2.getPath(), url2.getQuery(), url2.getRef())).toURL();
                    if (!url2.equals(url2))
                    {
                        result = getBytes(context1, url2);
                    }
                }
            }
            Object obj;
            long l = System.currentTimeMillis();
            long l5 = startMillis;
            if (Debug.logPhotoGallery.isLoggable)
            {
                com.ebay.nautilus.kernel.util.FwLog.LogInfo loginfo = Debug.logPhotoGallery;
                StringBuilder stringbuilder = (new StringBuilder()).append("  ended after ").append(l - l5).append(" (").append(index).append("): ");
                if (result != null)
                {
                    obj = "success";
                } else
                {
                    obj = "failure";
                }
                FwLog.println(loginfo, stringbuilder.append(((String) (obj))).append(" ").append(urlString).toString());
            }
_L5:
            return;
_L2:
            urlString = ConstructDipUrl.constructDynamicUrl(url, "_3");
              goto _L1
            obj;
            Log.e("PhotoGalleryWidget", (new StringBuilder()).append(obj.getClass().getSimpleName()).append(", ").append(urlString).toString(), ((Throwable) (obj)));
            l = System.currentTimeMillis();
            l5 = startMillis;
            if (Debug.logPhotoGallery.isLoggable)
            {
                loginfo = Debug.logPhotoGallery;
                stringbuilder = (new StringBuilder()).append("  ended after ").append(l - l5).append(" (").append(index).append("): ");
                if (result != null)
                {
                    obj = "success";
                } else
                {
                    obj = "failure";
                }
                FwLog.println(loginfo, stringbuilder.append(((String) (obj))).append(" ").append(urlString).toString());
                return;
            } else
            {
                break MISSING_BLOCK_LABEL_305;
            }
_L3:
            urlString = ConstructDipUrl.constructDynamicUrl(url, "_58");
              goto _L1
            obj;
            Log.e("PhotoGalleryWidget", (new StringBuilder()).append(obj.getClass().getSimpleName()).append(", ").append(urlString).toString(), ((Throwable) (obj)));
            l = System.currentTimeMillis();
            l5 = startMillis;
            if (Debug.logPhotoGallery.isLoggable)
            {
                loginfo = Debug.logPhotoGallery;
                stringbuilder = (new StringBuilder()).append("  ended after ").append(l - l5).append(" (").append(index).append("): ");
                if (result != null)
                {
                    obj = "success";
                } else
                {
                    obj = "failure";
                }
                FwLog.println(loginfo, stringbuilder.append(((String) (obj))).append(" ").append(urlString).toString());
                return;
            } else
            {
                break MISSING_BLOCK_LABEL_305;
            }
_L4:
            urlString = url;
              goto _L1
            obj;
            Log.e("PhotoGalleryWidget", (new StringBuilder()).append(obj.getClass().getSimpleName()).append(", ").append(urlString).toString(), ((Throwable) (obj)));
            l = System.currentTimeMillis();
            l5 = startMillis;
            if (Debug.logPhotoGallery.isLoggable)
            {
                loginfo = Debug.logPhotoGallery;
                stringbuilder = (new StringBuilder()).append("  ended after ").append(l - l5).append(" (").append(index).append("): ");
                if (result != null)
                {
                    obj = "success";
                } else
                {
                    obj = "failure";
                }
                FwLog.println(loginfo, stringbuilder.append(((String) (obj))).append(" ").append(urlString).toString());
                return;
            }
            break MISSING_BLOCK_LABEL_305;
            Object obj1;
            obj1;
            Log.e("PhotoGalleryWidget", (new StringBuilder()).append(obj1.getClass().getSimpleName()).append(", ").append(urlString).toString(), ((Throwable) (obj1)));
            long l1 = System.currentTimeMillis();
            long l6 = startMillis;
            if (Debug.logPhotoGallery.isLoggable)
            {
                com.ebay.nautilus.kernel.util.FwLog.LogInfo loginfo1 = Debug.logPhotoGallery;
                StringBuilder stringbuilder1 = (new StringBuilder()).append("  ended after ").append(l1 - l6).append(" (").append(index).append("): ");
                String s;
                if (result != null)
                {
                    s = "success";
                } else
                {
                    s = "failure";
                }
                FwLog.println(loginfo1, stringbuilder1.append(s).append(" ").append(urlString).toString());
                return;
            }
              goto _L5
            s;
            long l2 = System.currentTimeMillis();
            long l7 = startMillis;
            if (Debug.logPhotoGallery.isLoggable)
            {
                com.ebay.nautilus.kernel.util.FwLog.LogInfo loginfo2 = Debug.logPhotoGallery;
                StringBuilder stringbuilder2 = (new StringBuilder()).append("  ended after ").append(l2 - l7).append(" (").append(index).append("): ");
                String s1;
                if (result != null)
                {
                    s1 = "success";
                } else
                {
                    s1 = "failure";
                }
                FwLog.println(loginfo2, stringbuilder2.append(s1).append(" ").append(urlString).toString());
                return;
            }
              goto _L5
            s1;
            Log.e("PhotoGalleryWidget", (new StringBuilder()).append(s1.getClass().getSimpleName()).append(", ").append(urlString).toString(), s1);
            long l3;
            long l8;
            l3 = System.currentTimeMillis();
            l8 = startMillis;
            if (!Debug.logPhotoGallery.isLoggable) goto _L5; else goto _L6
_L6:
            com.ebay.nautilus.kernel.util.FwLog.LogInfo loginfo3 = Debug.logPhotoGallery;
            StringBuilder stringbuilder3 = (new StringBuilder()).append("  ended after ").append(l3 - l8).append(" (").append(index).append("): ");
            String s2;
            if (result != null)
            {
                s2 = "success";
            } else
            {
                s2 = "failure";
            }
            FwLog.println(loginfo3, stringbuilder3.append(s2).append(" ").append(urlString).toString());
            return;
            Exception exception;
            exception;
            long l4 = System.currentTimeMillis();
            long l9 = startMillis;
            if (Debug.logPhotoGallery.isLoggable)
            {
                com.ebay.nautilus.kernel.util.FwLog.LogInfo loginfo4 = Debug.logPhotoGallery;
                StringBuilder stringbuilder4 = (new StringBuilder()).append("  ended after ").append(l4 - l9).append(" (").append(index).append("): ");
                String s3;
                if (result != null)
                {
                    s3 = "success";
                } else
                {
                    s3 = "failure";
                }
                FwLog.println(loginfo4, stringbuilder4.append(s3).append(" ").append(urlString).toString());
            }
            throw exception;
              goto _L1
        }

        public Bitmap getBitmap()
        {
            Object obj = null;
            if (result != null)
            {
                try
                {
                    obj = new android.graphics.BitmapFactory.Options();
                    obj.inDither = false;
                    obj.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
                    obj.inScaled = false;
                    obj = BitmapFactory.decodeByteArray(result, 0, result.length, ((android.graphics.BitmapFactory.Options) (obj)));
                }
                catch (OutOfMemoryError outofmemoryerror)
                {
                    Log.w("PhotoGalleryWidget", (new StringBuilder()).append("Out of memory decoding bitmap: ").append(outofmemoryerror).toString());
                    return null;
                }
            }
            return ((Bitmap) (obj));
        }




/*
        static byte[] access$802(GetPhotoNetLoader getphotonetloader, byte abyte0[])
        {
            getphotonetloader.result = abyte0;
            return abyte0;
        }

*/

        public GetPhotoNetLoader(String s, PhotoResolution photoresolution, int i, EbayContext ebaycontext, int j)
        {
            super(ebaycontext);
            result = null;
            urlString = null;
            url = s;
            resolution = photoresolution;
            index = i;
            lruSize = j;
            if (Debug.logPhotoGallery.isLoggable)
            {
                FwLog.println(Debug.logPhotoGallery, (new StringBuilder()).append("Launching new loader for (").append(i).append(" ").append(s).toString());
            }
        }
    }

    public static interface OnPhotoLoadedEvent
    {

        public abstract void OnPhotoLoaded(String s);
    }

    public static interface OnPhotoSelectedEvent
    {

        public abstract void OnPhotoSelected(int i);
    }

    public class Photo
    {

        public Bitmap bitmap;
        public final Paint bkPaint = new Paint();
        public int centerDeltaX;
        public int centerDeltaY;
        public int deltaY;
        public Boolean missingImage;
        public Boolean needsDownload;
        public View progressSpinner;
        public PhotoResolution resolutionToUse;
        public Scale scaleCurrent;
        public Scale scaleExactFit;
        public Bitmap scaledBitmap;
        public Boolean setCenterDeltas;
        final PhotoGalleryWidget this$0;
        public Point topLeft;
        public String url;

        public void downgradeResolution()
        {
            if (PhotoResolution.High == resolutionToUse)
            {
                resolutionToUse = PhotoResolution.Medium;
                if (Debug.logPhotoGallery.isLoggable)
                {
                    FwLog.println(Debug.logPhotoGallery, (new StringBuilder()).append("downgraded ").append(url).toString());
                }
            }
        }

        public float getScaledHeight()
        {
            if (bitmap != null)
            {
                return (float)bitmap.getHeight() * scaleCurrent.sy;
            } else
            {
                return 0.0F;
            }
        }

        public float getScaledWidth()
        {
            if (bitmap != null)
            {
                return (float)bitmap.getWidth() * scaleCurrent.sx;
            } else
            {
                return 0.0F;
            }
        }

        public final int getWidthPlusFramePadding()
        {
            int i = 0;
            if (!mKeepPicturesSquare) goto _L2; else goto _L1
_L1:
            i = mMaxPhotoWidth;
_L4:
            int j = i;
            if (m9PatchPadding != null)
            {
                j = i + (m9PatchPadding.left + m9PatchPadding.right);
            }
            return j;
_L2:
            if (bitmap != null)
            {
                i = (int)getScaledWidth();
            } else
            if (mMissingImageBitmap != null)
            {
                i = mMissingImageBitmap.getWidth();
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public boolean isFake()
        {
            return TextUtils.isEmpty(url);
        }

        public boolean isPhotoLoaded()
        {
            return bitmap != null && !missingImage.booleanValue();
        }

        public boolean isSeeAllRecentlyViewed()
        {
            return "SeeAllRecentlyViewed".equals(url);
        }

        public boolean isZoomed()
        {
            return Math.abs(scaleExactFit.sx - scaleCurrent.sx) > 1E-05F || Math.abs(scaleExactFit.sx - scaleCurrent.sx) > 1E-05F;
        }

        public final void recycle()
        {
            if (!missingImage.booleanValue() && bitmap != null)
            {
                bitmap.recycle();
            }
            if (scaledBitmap != null)
            {
                scaledBitmap.recycle();
            }
            scaledBitmap = null;
            bitmap = null;
            needsDownload = Boolean.valueOf(true);
            Scale scale1 = scaleCurrent;
            scaleCurrent.sy = 1.0F;
            scale1.sx = 1.0F;
            deltaY = 0;
        }

        public void reinit(boolean flag)
        {
            setCenterDeltas = Boolean.valueOf(true);
            scaleExactFit = getScale(bitmap, mMaxPhotoHeight, mMaxPhotoWidth);
            scaleCurrent = new Scale(scaleExactFit.sx, scaleExactFit.sy);
            topLeft = new Point(0, 0);
            centerDeltaX = 0;
            centerDeltaY = 0;
            deltaY = 0;
            PhotoResolution photoresolution;
            if (flag)
            {
                photoresolution = PhotoResolution.High;
            } else
            {
                photoresolution = PhotoResolution.Standard;
            }
            resolutionToUse = photoresolution;
            needsDownload = Boolean.valueOf(true);
        }

        public void setCurrentScale(float f, Point point)
        {
            float f1;
            float f2;
            Boolean boolean2;
            f2 = getScaledWidth();
            f1 = getScaledHeight();
            Scale scale1 = scaleCurrent;
            scale1.sx = scale1.sx * f;
            scale1 = scaleCurrent;
            scale1.sy = scale1.sy * f;
            boolean2 = Boolean.valueOf(true);
            if (scaleCurrent.sx > scaleExactFit.sx && scaleCurrent.sy > scaleExactFit.sy) goto _L2; else goto _L1
_L1:
            Boolean boolean1;
            scaleCurrent.sx = scaleExactFit.sx;
            scaleCurrent.sy = scaleExactFit.sy;
            deltaY = 0;
            boolean1 = Boolean.valueOf(false);
_L4:
            f = (float)(point.x - topLeft.x) / f2;
            int i = (int)(getScaledWidth() * f);
            setStart(mStart - (point.x - topLeft.x - i));
            if (boolean1.booleanValue())
            {
                f = (float)(point.y - topLeft.y) / f1;
                int j = (int)(getScaledHeight() * f);
                deltaY = deltaY + (point.y - topLeft.y - j);
            }
            return;
_L2:
            Scale scale2 = new Scale(Math.max(6F, scaleExactFit.sx), Math.max(6F, scaleExactFit.sy));
            if (scaleCurrent.sx <= scale2.sx)
            {
                boolean1 = boolean2;
                if (scaleCurrent.sy <= scale2.sy)
                {
                    continue; /* Loop/switch isn't completed */
                }
            }
            scaleCurrent.sx = scale2.sx;
            scaleCurrent.sy = scale2.sy;
            boolean1 = boolean2;
            if (true) goto _L4; else goto _L3
_L3:
        }

        public final void setPhoto(Bitmap bitmap1, Integer integer)
        {
            bitmap = bitmap1;
            if (bitmap1 == null)
            {
                return;
            }
            missingImage = Boolean.valueOf(false);
            if (integer != null)
            {
                bkPaint.setColor(integer.intValue());
                return;
            } else
            {
                int i = ImageUtil.getAverageColor(bitmap1, false);
                bkPaint.setColor(i);
                return;
            }
        }

        public final void setPhotoToMissingImage()
        {
            if (Debug.logPhotoGallery.isLoggable)
            {
                FwLog.println(Debug.logPhotoGallery, (new StringBuilder()).append("Setting photo missing: ").append(url).toString());
            }
            bitmap = mMissingImageBitmap;
            missingImage = Boolean.valueOf(true);
            setProgressSpinner(false);
        }

        public final void setPhotoToSeeAllImage()
        {
            if (Debug.logPhotoGallery.isLoggable)
            {
                FwLog.println(Debug.logPhotoGallery, (new StringBuilder()).append("Setting see all: ").append(url).toString());
            }
            bitmap = mSeeAllImageBitmap;
            missingImage = Boolean.valueOf(true);
            setProgressSpinner(false);
        }

        public void setProgressPosition(int i)
        {
            android.widget.AbsoluteLayout.LayoutParams layoutparams = (android.widget.AbsoluteLayout.LayoutParams)progressSpinner.getLayoutParams();
            layoutparams.x = (getWidthPlusFramePadding() / 2 + i) - progressSizeDp / 2;
            layoutparams.y = getHeight() / 2 - progressSizeDp / 2;
            progressSpinner.setLayoutParams(layoutparams);
        }

        public void setProgressSpinner(boolean flag)
        {
            if (progressSpinner != null)
            {
                View view = progressSpinner;
                int i;
                if (flag)
                {
                    i = 0;
                } else
                {
                    i = 8;
                }
                view.setVisibility(i);
            }
        }

        public Photo(String s, boolean flag)
        {
            this$0 = PhotoGalleryWidget.this;
            super();
            bitmap = null;
            scaledBitmap = null;
            needsDownload = Boolean.valueOf(true);
            missingImage = Boolean.valueOf(true);
            scaleExactFit = new Scale();
            scaleCurrent = new Scale();
            topLeft = new Point(0, 0);
            centerDeltaX = 0;
            centerDeltaY = 0;
            setCenterDeltas = Boolean.valueOf(true);
            deltaY = 0;
            progressSpinner = null;
            resolutionToUse = null;
            url = s;
            if (flag)
            {
                photogallerywidget = PhotoResolution.High;
            } else
            {
                photogallerywidget = PhotoResolution.Standard;
            }
            resolutionToUse = PhotoGalleryWidget.this;
            bkPaint.setColor(-1);
        }
    }

    public static final class PhotoResolution extends Enum
    {

        private static final PhotoResolution $VALUES[];
        public static final PhotoResolution High;
        public static final PhotoResolution Medium;
        public static final PhotoResolution Standard;

        public static PhotoResolution valueOf(String s)
        {
            return (PhotoResolution)Enum.valueOf(com/ebay/mobile/common/PhotoGalleryWidget$PhotoResolution, s);
        }

        public static PhotoResolution[] values()
        {
            return (PhotoResolution[])$VALUES.clone();
        }

        static 
        {
            High = new PhotoResolution("High", 0);
            Medium = new PhotoResolution("Medium", 1);
            Standard = new PhotoResolution("Standard", 2);
            $VALUES = (new PhotoResolution[] {
                High, Medium, Standard
            });
        }

        private PhotoResolution(String s, int i)
        {
            super(s, i);
        }
    }

    private class PhotoScroller
    {

        private int mCurrX;
        private final float mDeceleration;
        private int mDuration;
        private int mFinalX;
        private boolean mFinished;
        private float mSignX;
        private long mStartTime;
        private int mStartX;
        private float mVelocity;
        final PhotoGalleryWidget this$0;

        public final boolean computeScrollOffset()
        {
            if (mFinished)
            {
                return false;
            }
            int i = (int)(AnimationUtils.currentAnimationTimeMillis() - mStartTime);
            if (i < mDuration)
            {
                float f = (float)i / 1000F;
                float f1 = mVelocity;
                float f2 = (mDeceleration * f * f) / 2.0F;
                mCurrX = mStartX + Math.round(mSignX * (f1 * f - f2));
                mCurrX = Math.max(mCurrX, 0);
                if (mCurrX == mFinalX)
                {
                    mFinished = true;
                }
            } else
            {
                mCurrX = mFinalX;
                mFinished = true;
            }
            return true;
        }

        public final void fling(int i, int j)
        {
            mFinished = false;
            float f = Math.abs(j);
            mVelocity = f;
            mDuration = (int)((1000F * f) / mDeceleration);
            mStartTime = AnimationUtils.currentAnimationTimeMillis();
            mStartX = i;
            mSignX = Math.signum(j);
            mFinalX = Math.round(getSignedDistance(j)) + i;
            mFinalX = Math.max(mFinalX, 0);
        }

        public final void forceFinished(boolean flag)
        {
            mFinished = flag;
        }

        public final int getCurrX()
        {
            return mCurrX;
        }

        public int getSignedDistance(int i)
        {
            return (int)((float)(i * i) / (2.0F * mDeceleration)) * (int)Math.signum(i);
        }

        public final int getStartVelocity(int i)
        {
            int j = Math.abs(i);
            int k;
            if (j < 50)
            {
                j = 0;
            } else
            {
                j = (int)Math.sqrt((float)(j * 2) * mDeceleration);
            }
            k = j;
            if (i < 0)
            {
                k = -j;
            }
            return k;
        }

        public PhotoScroller(Context context1)
        {
            this$0 = PhotoGalleryWidget.this;
            super();
            mSignX = 0.0F;
            mFinished = true;
            mDeceleration = 385.826F * (context1.getResources().getDisplayMetrics().density * 160F) * ViewConfiguration.getScrollFriction();
        }
    }

    private class Scale
    {

        float sx;
        float sy;
        final PhotoGalleryWidget this$0;

        Scale()
        {
            this$0 = PhotoGalleryWidget.this;
            super();
            sy = 1.0F;
            sx = 1.0F;
        }

        Scale(float f, float f1)
        {
            this$0 = PhotoGalleryWidget.this;
            super();
            sx = f;
            sy = f1;
        }
    }


    public static final String CACHE_PREFIX = "PhotoGallery-";
    public static final String SEE_ALL_RECENTLY_VIEWED = "SeeAllRecentlyViewed";
    private static final String TAG = "PhotoGalleryWidget";
    private static final Rect bkRect = new Rect();
    private static int kBetweenPicturePadding = 0;
    private static final int kMinStartValue = 14;
    private static int kOutsidePicturePadding = 0;
    private static final int kOverScrollFraction = 3;
    private boolean allowFixInPlace;
    private AutoScroll autoScroll;
    private long autoScrollDelayMs;
    private boolean autoScrolling;
    private Context context;
    private boolean drawn;
    private EbayContext ebayContext;
    private boolean fakePhotosClickable;
    private boolean fixedInPlace;
    int fwLoaderBaseId;
    FwLoaderManager fwLoaderManager;
    private LayoutInflater inflater;
    private Drawable m9PatchBackground;
    private int m9PatchBackgroundId;
    private final Rect m9PatchPadding;
    private Boolean mAllowPinchZoom;
    private int mBetweenPicturePadding;
    private Boolean mEnabled;
    private final FlingRunnable mFlingRunnable;
    private GestureDetector mGestureScanner;
    private int mHeight;
    private Boolean mIsScrolling;
    private boolean mKeepPicturesSquare;
    private int mMaxPhotoHeight;
    private int mMaxPhotoWidth;
    private int mMinStartValue;
    private Bitmap mMissingImageBitmap;
    private OnPhotoLoadedEvent mOnPhotoLoadedEvent;
    private OnPhotoSelectedEvent mOnPhotoSelectedEvent;
    private int mOutsidePicturePadding;
    private int mOverScroll;
    private final Paint mPaint;
    private ArrayList mPhotos;
    private Integer mPictureBackgroundColor;
    private float mPreviousScaleDistance;
    private Photo mScaledPhoto;
    private PhotoScroller mScroller;
    private Bitmap mSeeAllImageBitmap;
    private int mSelectedIndex;
    private boolean mShouldStopFling;
    private Boolean mSnapTo;
    private int mStart;
    private int mStretchyStart;
    private int mWidth;
    private final Matrix matrix;
    private int progressSizeDp;
    private final Matrix scale;
    private final Matrix xlate;

    public PhotoGalleryWidget(Context context1)
    {
        super(context1);
        mPhotos = new ArrayList();
        mMaxPhotoHeight = 0;
        mMaxPhotoWidth = 0;
        mHeight = -1;
        mWidth = -1;
        mStart = 0;
        mStretchyStart = 0;
        m9PatchBackgroundId = 0x7f02029b;
        m9PatchPadding = new Rect(0, 0, 0, 0);
        mBetweenPicturePadding = 0;
        mOutsidePicturePadding = 0;
        mPictureBackgroundColor = null;
        mKeepPicturesSquare = false;
        mMinStartValue = 0;
        mSelectedIndex = -1;
        mFlingRunnable = new FlingRunnable();
        mShouldStopFling = false;
        mPaint = new Paint();
        mIsScrolling = Boolean.valueOf(false);
        mSnapTo = Boolean.valueOf(false);
        mOverScroll = 0;
        mEnabled = Boolean.valueOf(true);
        drawn = false;
        fakePhotosClickable = false;
        allowFixInPlace = false;
        fixedInPlace = false;
        mAllowPinchZoom = Boolean.valueOf(false);
        mPreviousScaleDistance = 0.0F;
        autoScrolling = false;
        autoScroll = null;
        progressSizeDp = 0;
        xlate = new Matrix();
        scale = new Matrix();
        matrix = new Matrix();
        Init(context1);
    }

    public PhotoGalleryWidget(Context context1, AttributeSet attributeset)
    {
        super(context1, attributeset);
        mPhotos = new ArrayList();
        mMaxPhotoHeight = 0;
        mMaxPhotoWidth = 0;
        mHeight = -1;
        mWidth = -1;
        mStart = 0;
        mStretchyStart = 0;
        m9PatchBackgroundId = 0x7f02029b;
        m9PatchPadding = new Rect(0, 0, 0, 0);
        mBetweenPicturePadding = 0;
        mOutsidePicturePadding = 0;
        mPictureBackgroundColor = null;
        mKeepPicturesSquare = false;
        mMinStartValue = 0;
        mSelectedIndex = -1;
        mFlingRunnable = new FlingRunnable();
        mShouldStopFling = false;
        mPaint = new Paint();
        mIsScrolling = Boolean.valueOf(false);
        mSnapTo = Boolean.valueOf(false);
        mOverScroll = 0;
        mEnabled = Boolean.valueOf(true);
        drawn = false;
        fakePhotosClickable = false;
        allowFixInPlace = false;
        fixedInPlace = false;
        mAllowPinchZoom = Boolean.valueOf(false);
        mPreviousScaleDistance = 0.0F;
        autoScrolling = false;
        autoScroll = null;
        progressSizeDp = 0;
        xlate = new Matrix();
        scale = new Matrix();
        matrix = new Matrix();
        getStylableAttributes(attributeset);
        Init(context1);
    }

    public PhotoGalleryWidget(Context context1, AttributeSet attributeset, int i)
    {
        super(context1, attributeset, i);
        mPhotos = new ArrayList();
        mMaxPhotoHeight = 0;
        mMaxPhotoWidth = 0;
        mHeight = -1;
        mWidth = -1;
        mStart = 0;
        mStretchyStart = 0;
        m9PatchBackgroundId = 0x7f02029b;
        m9PatchPadding = new Rect(0, 0, 0, 0);
        mBetweenPicturePadding = 0;
        mOutsidePicturePadding = 0;
        mPictureBackgroundColor = null;
        mKeepPicturesSquare = false;
        mMinStartValue = 0;
        mSelectedIndex = -1;
        mFlingRunnable = new FlingRunnable();
        mShouldStopFling = false;
        mPaint = new Paint();
        mIsScrolling = Boolean.valueOf(false);
        mSnapTo = Boolean.valueOf(false);
        mOverScroll = 0;
        mEnabled = Boolean.valueOf(true);
        drawn = false;
        fakePhotosClickable = false;
        allowFixInPlace = false;
        fixedInPlace = false;
        mAllowPinchZoom = Boolean.valueOf(false);
        mPreviousScaleDistance = 0.0F;
        autoScrolling = false;
        autoScroll = null;
        progressSizeDp = 0;
        xlate = new Matrix();
        scale = new Matrix();
        matrix = new Matrix();
        getStylableAttributes(attributeset);
        Init(context1);
    }

    private final void AdjustStartForSelected()
    {
        if (mSelectedIndex < 0 || mSelectedIndex >= mPhotos.size()) goto _L2; else goto _L1
_L1:
        int i;
        setStart(mOutsidePicturePadding);
        i = 0;
_L6:
        if (i < mPhotos.size() && i != mSelectedIndex) goto _L4; else goto _L3
_L3:
        Photo photo = (Photo)mPhotos.get(mSelectedIndex);
        setStart(Math.max(mMinStartValue, mStart - (mWidth - photo.getWidthPlusFramePadding()) / 2));
_L2:
        mSelectedIndex = -1;
        return;
_L4:
        Photo photo1 = (Photo)mPhotos.get(i);
        setStart(mStart + photo1.getWidthPlusFramePadding() + mBetweenPicturePadding);
        i++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private final void Init(Context context1)
    {
        context = context1;
        if (!isInEditMode())
        {
            mGestureScanner = new GestureDetector(this);
            Object obj;
            for (obj = context1; obj != null && !(obj instanceof FwActivity);)
            {
                if (obj instanceof ContextWrapper)
                {
                    obj = ((ContextWrapper)context1).getBaseContext();
                } else
                {
                    obj = null;
                }
            }

            obj = (FwActivity)obj;
            if (obj != null)
            {
                ebayContext = ((FwActivity) (obj)).getEbayContext();
            }
        }
        m9PatchBackground = context1.getResources().getDrawable(m9PatchBackgroundId);
        mScroller = new PhotoScroller(context1);
        inflater = (LayoutInflater)context1.getSystemService("layout_inflater");
        mBetweenPicturePadding = scaleToScreen(kBetweenPicturePadding);
        mOutsidePicturePadding = scaleToScreen(kOutsidePicturePadding);
        mMinStartValue = Math.max(mMinStartValue, kOutsidePicturePadding);
        mPaint.setAntiAlias(true);
        mPaint.setFilterBitmap(true);
        mPaint.setDither(true);
        mPaint.setTextSize(scaleToScreen(16));
    }

    private final void InitChangableItems()
    {
        mHeight = getHeight();
        mWidth = getWidth();
        if (m9PatchBackground != null)
        {
            m9PatchBackground.setBounds(0, 0, mWidth, mHeight - 1);
            m9PatchBackground.getPadding(m9PatchPadding);
        }
        setStart(-mMinStartValue);
        mOverScroll = mWidth / 3;
        mMaxPhotoHeight = mHeight - m9PatchPadding.top - m9PatchPadding.bottom;
        Iterator iterator;
        if (mKeepPicturesSquare)
        {
            mMaxPhotoWidth = mHeight - m9PatchPadding.left - m9PatchPadding.right;
        } else
        {
            mMaxPhotoWidth = (mWidth - mOutsidePicturePadding * 2 - m9PatchPadding.left - m9PatchPadding.right) + mMinStartValue;
        }
        iterator = mPhotos.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Photo photo = (Photo)iterator.next();
            if (photo.bitmap != null)
            {
                if (!mAllowPinchZoom.booleanValue())
                {
                    photo.recycle();
                } else
                {
                    photo.reinit(mAllowPinchZoom.booleanValue());
                }
            }
        } while (true);
        int i;
        if (200 < mMaxPhotoHeight)
        {
            i = 0x7f02027a;
        } else
        {
            i = 0x7f0201f5;
        }
        try
        {
            mMissingImageBitmap = BitmapFactory.decodeResource(context.getResources(), i);
            if (mMissingImageBitmap != null)
            {
                mMissingImageBitmap = scaleBitmap(mMissingImageBitmap, mMaxPhotoHeight, mMaxPhotoWidth);
            }
            mSeeAllImageBitmap = BitmapFactory.decodeResource(context.getResources(), 0x7f02025e);
            if (mSeeAllImageBitmap != null)
            {
                mSeeAllImageBitmap = scaleBitmap(mSeeAllImageBitmap, mMaxPhotoHeight, mMaxPhotoWidth);
            }
        }
        catch (OutOfMemoryError outofmemoryerror)
        {
            mMissingImageBitmap = null;
            mSeeAllImageBitmap = null;
        }
        if (Debug.logPhotoGallery.isLoggable)
        {
            FwLog.println(Debug.logPhotoGallery, (new StringBuilder()).append(" InitChangableItems width,height").append(mWidth).append(", ").append(mHeight).toString());
        }
    }

    private final void flingToDesiredLocation(int i, int j)
    {
        i = mScroller.getStartVelocity(j - i);
        if (i == 0)
        {
            setStart(j);
        } else
        {
            mFlingRunnable.startUsingVelocity(i);
        }
        invalidate();
    }

    private float getEventDistance(MotionEvent motionevent)
    {
        float f = 0.0F;
        if (1 < motionevent.getPointerCount())
        {
            f = motionevent.getX(0) - motionevent.getX(1);
            float f1 = motionevent.getY(0) - motionevent.getY(1);
            f = (float)Math.sqrt(f * f + f1 * f1);
        }
        return f;
    }

    private final int getLimitedMotionFlingDelta(int i)
    {
        int j;
        if (mStart - i < mMinStartValue - mOverScroll)
        {
            j = (mStart - mMinStartValue) + mOverScroll;
        } else
        {
            int k = getMaxStartValue();
            j = i;
            if (mStart - i > mOverScroll + k)
            {
                return mStart - k - mOverScroll;
            }
        }
        return j;
    }

    private final int getMaxStartValue()
    {
        int i = mMinStartValue;
        for (int j = 0; j < mPhotos.size(); j++)
        {
            int l = i + ((Photo)mPhotos.get(j)).getWidthPlusFramePadding();
            i = l;
            if (j < mPhotos.size() - 1)
            {
                i = l + mBetweenPicturePadding;
            }
        }

        int k = mWidth;
        return Math.max(mMinStartValue, i - k);
    }

    private final Photo getPhoto(String s)
    {
        Object obj = null;
        Photo photo = obj;
        if (s != null)
        {
            Iterator iterator = mPhotos.iterator();
            do
            {
                photo = obj;
                if (!iterator.hasNext())
                {
                    break;
                }
                photo = (Photo)iterator.next();
            } while (photo == null || !s.equals(photo.url));
        }
        return photo;
    }

    private final int getPhotoIndexUnderX(int i)
    {
        byte byte0 = -1;
        int j = i + mStart;
        i = 0;
        do
        {
            int k;
label0:
            {
                k = byte0;
                if (i < mPhotos.size())
                {
                    k = ((Photo)mPhotos.get(i)).getWidthPlusFramePadding() + mBetweenPicturePadding;
                    if (j > k)
                    {
                        break label0;
                    }
                    k = i;
                }
                return k;
            }
            j -= k;
            i++;
        } while (true);
    }

    private Scale getScale(Bitmap bitmap, int i, int j)
    {
        if (bitmap == null)
        {
            return null;
        }
        int k = i;
        int i1 = (bitmap.getWidth() * k) / bitmap.getHeight();
        int l = k;
        i = i1;
        if (i1 > j)
        {
            l = (k * j) / i1;
            i = j;
        }
        return new Scale((float)i / (float)bitmap.getWidth(), (float)l / (float)bitmap.getHeight());
    }

    private final void getStylableAttributes(AttributeSet attributeset)
    {
        attributeset = getContext().obtainStyledAttributes(attributeset, com.ebay.mobile.R.styleable.PhotoGallery);
        kBetweenPicturePadding = attributeset.getDimensionPixelSize(2, kBetweenPicturePadding);
        kOutsidePicturePadding = attributeset.getDimensionPixelSize(3, kOutsidePicturePadding);
        m9PatchBackgroundId = attributeset.getResourceId(0, m9PatchBackgroundId);
        mKeepPicturesSquare = attributeset.getBoolean(4, mKeepPicturesSquare);
        attributeset.recycle();
    }

    private final Bitmap scaleBitmap(Bitmap bitmap, int i, int j)
    {
        Scale scale1 = getScale(bitmap, i, j);
        if (scale1 == null)
        {
            return null;
        } else
        {
            return Bitmap.createScaledBitmap(bitmap, (int)(scale1.sx * (float)bitmap.getWidth()), (int)(scale1.sy * (float)bitmap.getHeight()), true);
        }
    }

    private int scaleToScreen(int i)
    {
        float f = getResources().getDisplayMetrics().density;
        return (int)((float)i * f + 0.5F);
    }

    private void setPhotoToMissingImage(Photo photo, String s)
    {
        if (photo != null)
        {
            photo.needsDownload = Boolean.valueOf(false);
            photo.setPhotoToMissingImage();
            if (Debug.logPhotoGallery.isLoggable)
            {
                FwLog.println(Debug.logPhotoGallery, (new StringBuilder()).append("  error returned data is null for: ").append(s).toString());
            }
        }
    }

    private final void setScrolling(Boolean boolean1)
    {
        mIsScrolling = boolean1;
    }

    private void setStart(int i)
    {
        if (Debug.logPhotoGallery.isLoggable)
        {
            FwLog.println(Debug.logPhotoGallery, (new StringBuilder()).append(" setting mStart old: ").append(mStart).append(" new: ").append(i).toString());
        }
        mStart = i;
    }

    private final boolean snapToFling(Boolean boolean1)
    {
        int i = mOutsidePicturePadding;
        Boolean boolean3 = Boolean.valueOf(false);
        boolean flag = false;
        Iterator iterator = mPhotos.iterator();
        do
        {
            int j;
label0:
            {
                j = ((flag) ? 1 : 0);
                Boolean boolean2 = boolean3;
                if (iterator.hasNext())
                {
                    j = ((Photo)iterator.next()).getWidthPlusFramePadding() + mBetweenPicturePadding;
                    if ((!boolean1.booleanValue() || i <= mStart) && (boolean1.booleanValue() || i + j <= mStart))
                    {
                        break label0;
                    }
                    boolean2 = Boolean.valueOf(true);
                    j = i;
                }
                if (boolean2.booleanValue())
                {
                    flingToDesiredLocation(mStart, j);
                }
                return boolean2.booleanValue();
            }
            i += j;
        } while (true);
    }

    private final void testForBounceFling()
    {
        int i = getMaxStartValue();
        if (mStart < mMinStartValue || mStart > i)
        {
            if (1 < mPhotos.size() || mSnapTo.booleanValue())
            {
                if (mStart < mMinStartValue)
                {
                    i = mMinStartValue;
                }
            } else
            {
                i = -scaleToScreen(14);
            }
            flingToDesiredLocation(mStart, i);
        }
    }

    private final void trackMotionFling(int i)
    {
        int j = getLimitedMotionFlingDelta(i);
        if (j != i)
        {
            mFlingRunnable.stop();
        }
        setStart(mStart - j);
        invalidate();
    }

    public final void captureMouse(ScrollView scrollview)
    {
        scrollview.setOnTouchListener(new android.view.View.OnTouchListener() {

            final PhotoGalleryWidget this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (mIsScrolling.booleanValue())
                {
                    return onTouchEvent(motionevent);
                } else
                {
                    return view.onTouchEvent(motionevent);
                }
            }

            
            {
                this$0 = PhotoGalleryWidget.this;
                super();
            }
        });
    }

    public int getCenterPhoto()
    {
        return getPhotoIndexUnderX(getWidth() / 2);
    }

    public final int getPhotoCount()
    {
        return mPhotos.size();
    }

    public final int getPhotoIndexInView()
    {
        boolean flag = false;
        int j = mOutsidePicturePadding;
        int i = 0;
        do
        {
            Photo photo;
label0:
            {
                int k = ((flag) ? 1 : 0);
                if (i < mPhotos.size())
                {
                    photo = (Photo)mPhotos.get(i);
                    if (j < mStart)
                    {
                        break label0;
                    }
                    k = i;
                }
                return k;
            }
            j += photo.getWidthPlusFramePadding() + mBetweenPicturePadding;
            i++;
        } while (true);
    }

    public final List getPhotoUrls()
    {
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = mPhotos.iterator(); iterator.hasNext(); arraylist.add(((Photo)iterator.next()).url)) { }
        return arraylist;
    }

    public final boolean onDown(MotionEvent motionevent)
    {
        setScrolling(Boolean.valueOf(false));
        mFlingRunnable.stop();
        if (!fixedInPlace)
        {
            testForBounceFling();
        }
        autoScrolling = false;
        mStretchyStart = mStart;
        return true;
    }

    public final void onDraw(Canvas canvas)
    {
        if (fwLoaderManager == null) goto _L2; else goto _L1
_L1:
        int j;
        int k;
label0:
        {
            int i;
            boolean flag;
            int i1;
label1:
            {
                if (getHeight() != mHeight || getWidth() != mWidth)
                {
                    InitChangableItems();
                }
                AdjustStartForSelected();
                i1 = mOutsidePicturePadding;
                k = i1;
                if (!allowFixInPlace)
                {
                    break label0;
                }
                fixedInPlace = false;
                boolean flag1 = true;
                i = 0;
                Iterator iterator = mPhotos.iterator();
                do
                {
                    flag = flag1;
                    if (!iterator.hasNext())
                    {
                        break label1;
                    }
                    Photo photo1 = (Photo)iterator.next();
                    if (photo1.bitmap == null)
                    {
                        break;
                    }
                    k = i;
                    if (i > 0)
                    {
                        k = i + mBetweenPicturePadding;
                    }
                    i = k + photo1.getWidthPlusFramePadding();
                } while (true);
                flag = false;
            }
            k = i1;
            if (flag)
            {
                k = i1;
                if (i < getWidth())
                {
                    i = -(getWidth() - i) / 2;
                    fixedInPlace = true;
                    k = 0;
                    setStart(i);
                }
            }
        }
        j = 0;
_L12:
        if (j >= mPhotos.size()) goto _L4; else goto _L3
_L3:
        Photo photo = (Photo)mPhotos.get(j);
        if (k < mStart + mWidth) goto _L5; else goto _L4
_L4:
        drawn = true;
_L2:
        return;
_L5:
        int j1 = photo.getWidthPlusFramePadding();
        if (k + j1 < mStart) goto _L7; else goto _L6
_L6:
        int l;
        if (photo.isFake())
        {
            photo.setPhotoToMissingImage();
            photo.needsDownload = Boolean.valueOf(false);
        } else
        if (photo.isSeeAllRecentlyViewed())
        {
            photo.setPhotoToSeeAllImage();
            photo.needsDownload = Boolean.valueOf(false);
        }
        if (photo.needsDownload.booleanValue() && ebayContext != null)
        {
            photo.needsDownload = Boolean.valueOf(false);
            Object obj = new GetPhotoNetLoader(photo.url, photo.resolutionToUse, j, ebayContext, DeviceConfiguration.getAsync().get(DcsInteger.PhotoGalleryLruCacheSize));
            Object obj1 = fwLoaderManager;
            int k1 = fwLoaderBaseId;
            Rect rect;
            if (mAllowPinchZoom.booleanValue())
            {
                l = 0;
            } else
            {
                l = 1;
            }
            ((FwLoaderManager) (obj1)).start(k1 + j, ((FwLoader) (obj)), true, l);
            photo.setCenterDeltas = Boolean.valueOf(true);
            photo.setProgressSpinner(true);
        }
        k1 = k - mStart;
        if (photo.progressSpinner != null && photo.progressSpinner.getVisibility() == 0)
        {
            photo.setProgressPosition(k1);
        }
        canvas.save(2);
        if (m9PatchBackground != null)
        {
            canvas.clipRect(k1, 0.0F, k1 + j1, getHeight() - 1, android.graphics.Region.Op.INTERSECT);
            m9PatchBackground.setBounds(k1, 0, k1 + j1, getHeight() - 1);
            m9PatchBackground.draw(canvas);
        }
        bkRect.set(m9PatchPadding.left + k1, m9PatchPadding.top, (k1 + j1) - m9PatchPadding.right, getHeight() - m9PatchPadding.bottom);
        canvas.drawRect(bkRect, photo.bkPaint);
        if (photo.bitmap == null) goto _L9; else goto _L8
_L8:
        if (photo.setCenterDeltas.booleanValue() || photo.missingImage.booleanValue())
        {
            if (mKeepPicturesSquare)
            {
                l = (int)(((float)mMaxPhotoWidth - photo.getScaledWidth()) / 2.0F);
            } else
            {
                l = 0;
            }
            photo.centerDeltaX = l;
            photo.centerDeltaY = (int)(((float)mMaxPhotoHeight - photo.getScaledHeight()) / 2.0F);
            if (!photo.missingImage.booleanValue())
            {
                photo.setCenterDeltas = Boolean.valueOf(false);
            }
        }
        photo.topLeft.x = photo.centerDeltaX + k1 + m9PatchPadding.left;
        photo.topLeft.y = photo.centerDeltaY + photo.deltaY;
        canvas.clipRect(k1, 0.0F, k1 + j1, getHeight(), android.graphics.Region.Op.INTERSECT);
        if (mAllowPinchZoom.booleanValue())
        {
            break MISSING_BLOCK_LABEL_1006;
        }
        if (photo.bitmap != mSeeAllImageBitmap) goto _L11; else goto _L10
_L10:
        canvas.drawBitmap(photo.bitmap, photo.topLeft.x, photo.topLeft.y + scaleToScreen(10), mPaint);
_L9:
        if ("SeeAllRecentlyViewed".equals(photo.url))
        {
            obj = context.getString(0x7f070774);
            obj1 = new Paint();
            ((Paint) (obj1)).setAntiAlias(true);
            ((Paint) (obj1)).setDither(true);
            ((Paint) (obj1)).setTextSize(scaleToScreen(16));
            ((Paint) (obj1)).setColor(0xff888888);
            rect = new Rect();
            mPaint.getTextBounds(((String) (obj)), 0, ((String) (obj)).length(), rect);
            canvas.drawText(((String) (obj)), (photo.topLeft.x + mMaxPhotoWidth / 2) - rect.width() / 2, getHeight() - scaleToScreen(10), ((Paint) (obj1)));
        }
        canvas.restore();
_L7:
        k += mBetweenPicturePadding + j1;
        j++;
          goto _L12
_L11:
        try
        {
            canvas.drawBitmap(photo.bitmap, photo.topLeft.x, photo.topLeft.y, mPaint);
        }
        catch (OutOfMemoryError outofmemoryerror)
        {
            Log.e("PhotoGalleryWidget", (new StringBuilder()).append(outofmemoryerror.getClass().getSimpleName()).append(", can't even draw using matrix ").append(photo.url).toString(), outofmemoryerror);
        }
        catch (Exception exception)
        {
            Log.e("PhotoGalleryWidget", (new StringBuilder()).append(exception.getClass().getSimpleName()).append(", can't even draw using matrix ").append(photo.url).toString(), exception);
        }
          goto _L9
        xlate.setTranslate(photo.topLeft.x, photo.topLeft.y);
        scale.setScale(photo.scaleCurrent.sx, photo.scaleCurrent.sy);
        matrix.setConcat(xlate, scale);
        canvas.drawBitmap(photo.bitmap, matrix, mPaint);
          goto _L9
    }

    public final boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
label0:
        {
            if (fixedInPlace)
            {
                break label0;
            }
            int i = getPhotoIndexUnderX((int)((double)motionevent1.getX() + 0.5D));
            boolean flag1 = mSnapTo.booleanValue();
            boolean flag = flag1;
            if (flag1)
            {
                flag = flag1;
                if (i >= 0)
                {
                    flag = flag1;
                    if (((Photo)mPhotos.get(i)).isZoomed())
                    {
                        int j = mScroller.getSignedDistance(-(int)f);
                        if (i != getPhotoIndexUnderX((int)((double)motionevent1.getX() + 0.5D) + j))
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                    }
                }
            }
            if (flag)
            {
                if (Math.signum(f) < 0.0F)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (snapToFling(Boolean.valueOf(flag)))
                {
                    break label0;
                }
            }
            mFlingRunnable.startUsingVelocity(-(int)f);
        }
        return true;
    }

    public final void onLongPress(MotionEvent motionevent)
    {
    }

    public final boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        int i;
        if (!fixedInPlace)
        {
            i = getPhotoIndexUnderX((int)((double)motionevent1.getX() + 0.5D));
            break MISSING_BLOCK_LABEL_23;
        }
        do
        {
            return true;
        } while (mAllowPinchZoom.booleanValue() && i >= 0 && ((Photo)mPhotos.get(i)).bitmap == null || mScaledPhoto != null);
        setScrolling(Boolean.valueOf(true));
        mStretchyStart = mStretchyStart + (int)f;
        int k = getMaxStartValue();
        if (mStretchyStart < mMinStartValue)
        {
            setStart(mMinStartValue - (mMinStartValue - mStretchyStart) / 3);
        } else
        if (mStretchyStart > k)
        {
            setStart((mStretchyStart - k) / 3 + k);
        } else
        {
            setStart(mStretchyStart);
        }
        if (mAllowPinchZoom.booleanValue() && i >= 0)
        {
            motionevent = (Photo)mPhotos.get(i);
            if (motionevent.isZoomed())
            {
                int j = (int)motionevent.getScaledHeight();
                k = getHeight();
                motionevent.deltaY = ((Photo) (motionevent)).deltaY - (int)f1;
                if (j < k)
                {
                    motionevent.deltaY = Math.max(((Photo) (motionevent)).deltaY, -((Photo) (motionevent)).centerDeltaY);
                    motionevent.deltaY = Math.min(((Photo) (motionevent)).deltaY, k - j - ((Photo) (motionevent)).centerDeltaY);
                } else
                {
                    motionevent.deltaY = Math.min(((Photo) (motionevent)).deltaY, -((Photo) (motionevent)).centerDeltaY);
                    motionevent.deltaY = Math.max(((Photo) (motionevent)).deltaY, k - j - ((Photo) (motionevent)).centerDeltaY);
                }
            }
        }
        invalidate();
        return true;
    }

    public final void onShowPress(MotionEvent motionevent)
    {
    }

    public final boolean onSingleTapUp(MotionEvent motionevent)
    {
        int i = getPhotoIndexUnderX((int)((double)motionevent.getX() + 0.5D));
        if (i >= 0 && mOnPhotoSelectedEvent != null && mEnabled.booleanValue() && (!((Photo)mPhotos.get(i)).isFake() || ((Photo)mPhotos.get(i)).isFake() && fakePhotosClickable))
        {
            mOnPhotoSelectedEvent.OnPhotoSelected(i);
        }
        return true;
    }

    public void onTaskComplete(FwLoader fwloader)
    {
        GetPhotoNetLoader getphotonetloader;
        Photo photo;
        boolean flag;
        getphotonetloader = (GetPhotoNetLoader)fwloader;
        if (getphotonetloader.index >= mPhotos.size())
        {
            return;
        }
        photo = (Photo)mPhotos.get(getphotonetloader.index);
        flag = false;
        if (getphotonetloader.result == null || mMaxPhotoHeight == 0 || mMaxPhotoWidth == 0) goto _L2; else goto _L1
_L1:
        Bitmap bitmap = getphotonetloader.getBitmap();
        if (bitmap == null) goto _L4; else goto _L3
_L3:
        int i;
        int j;
        int k;
        int l;
        try
        {
            getphotonetloader.result = null;
            photo.setProgressSpinner(false);
        }
        // Misplaced declaration of an exception variable
        catch (FwLoader fwloader)
        {
            i = 1;
            Log.e("PhotoGalleryWidget", (new StringBuilder()).append(fwloader.getClass().getSimpleName()).append(", ").append(getphotonetloader.urlString).toString(), fwloader);
            continue; /* Loop/switch isn't completed */
        }
        fwloader = bitmap;
        if (!mAllowPinchZoom.booleanValue())
        {
            fwloader = scaleBitmap(bitmap, mMaxPhotoHeight, mMaxPhotoWidth);
        }
        if (fwloader != null) goto _L6; else goto _L5
_L5:
        setPhotoToMissingImage(photo, getphotonetloader.urlString);
        i = ((flag) ? 1 : 0);
_L17:
        if (i != 0)
        {
            photo.needsDownload = Boolean.valueOf(true);
            if (!recycleOutOfViewBitmaps())
            {
                photo.downgradeResolution();
            }
        }
        invalidate();
        return;
_L6:
        photo.setPhoto(fwloader, mPictureBackgroundColor);
        fwloader = getScale(photo.bitmap, mMaxPhotoHeight, mMaxPhotoWidth);
        if (fwloader == null)
        {
            break MISSING_BLOCK_LABEL_230;
        }
        photo.scaleExactFit = fwloader;
        photo.scaleCurrent = new Scale(photo.scaleExactFit.sx, photo.scaleExactFit.sy);
        j = mOutsidePicturePadding;
        i = 0;
_L15:
        if (i >= mPhotos.size()) goto _L8; else goto _L7
_L7:
        fwloader = (Photo)mPhotos.get(i);
        l = fwloader.getWidthPlusFramePadding();
        k = l;
        if (i < mPhotos.size() - 1)
        {
            k = l + mBetweenPicturePadding;
        }
        j += k;
        if (j < mStart) goto _L9; else goto _L8
_L8:
        i = ((flag) ? 1 : 0);
        if (mOnPhotoLoadedEvent == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        mOnPhotoLoadedEvent.OnPhotoLoaded(getphotonetloader.urlString);
        i = ((flag) ? 1 : 0);
        continue; /* Loop/switch isn't completed */
_L9:
        if (((Photo) (fwloader)).url == null || !((Photo) (fwloader)).url.equals(photo.url)) goto _L11; else goto _L10
_L10:
        if (mMissingImageBitmap == null) goto _L13; else goto _L12
_L12:
        float f = mMissingImageBitmap.getWidth();
_L14:
        setStart(mStart + (int)(fwloader.getScaledWidth() - f));
          goto _L8
_L2:
        setPhotoToMissingImage(photo, getphotonetloader.urlString);
        i = ((flag) ? 1 : 0);
        continue; /* Loop/switch isn't completed */
_L13:
        f = 0.0F;
          goto _L14
_L11:
        i++;
        if (true) goto _L15; else goto _L4
_L4:
        i = 1;
        if (true) goto _L17; else goto _L16
_L16:
    }

    public final boolean onTouchEvent(MotionEvent motionevent)
    {
        if (mIsScrolling.booleanValue() && 1 == motionevent.getAction())
        {
            setScrolling(Boolean.valueOf(false));
            testForBounceFling();
        }
        if (!mIsScrolling.booleanValue() && mScaledPhoto != null && mScaledPhoto.isPhotoLoaded() && 2 == motionevent.getAction())
        {
            float f = getEventDistance(motionevent);
            if (10F < f)
            {
                Point point = new Point((int)(motionevent.getX(0) + motionevent.getX(1)) / 2, (int)(motionevent.getY(0) + motionevent.getY(1)) / 2);
                mScaledPhoto.setCurrentScale(f / mPreviousScaleDistance, point);
                mPreviousScaleDistance = f;
                invalidate();
            }
        }
        if (mAllowPinchZoom.booleanValue() && 1 < motionevent.getPointerCount() && 261 == motionevent.getAction())
        {
            if (mIsScrolling.booleanValue())
            {
                setScrolling(Boolean.valueOf(false));
                testForBounceFling();
            }
            int i = getPhotoIndexUnderX((int)((double)motionevent.getX() + 0.5D));
            if (i >= 0)
            {
                mScaledPhoto = (Photo)mPhotos.get(i);
                mPreviousScaleDistance = getEventDistance(motionevent);
            }
        }
        if (mScaledPhoto != null && 1 == motionevent.getAction())
        {
            mScaledPhoto = null;
        }
        return mGestureScanner.onTouchEvent(motionevent);
    }

    public final void recycle()
    {
        int i = 0;
        int j;
        for (Iterator iterator = mPhotos.iterator(); iterator.hasNext(); i += mBetweenPicturePadding + j)
        {
            Photo photo = (Photo)iterator.next();
            int k = photo.getWidthPlusFramePadding();
            j = k;
            if (photo.bitmap == null)
            {
                continue;
            }
            j = k;
            if (photo.missingImage.booleanValue())
            {
                continue;
            }
            photo.recycle();
            j = photo.getWidthPlusFramePadding();
            if (i + k < mStart)
            {
                setStart((mStart + j) - k);
            }
        }

        mPhotos.clear();
    }

    public final boolean recycleOutOfViewBitmaps()
    {
        int i = 0;
        boolean flag = false;
        for (Iterator iterator = mPhotos.iterator(); iterator.hasNext();)
        {
            int j;
            boolean flag1;
label0:
            {
                Photo photo = (Photo)iterator.next();
                int k = photo.getWidthPlusFramePadding();
                flag1 = flag;
                j = k;
                if (photo.bitmap == null)
                {
                    break label0;
                }
                flag1 = flag;
                j = k;
                if (photo.missingImage.booleanValue())
                {
                    break label0;
                }
                if (i + k >= mStart)
                {
                    flag1 = flag;
                    j = k;
                    if (i <= mStart + mWidth)
                    {
                        break label0;
                    }
                }
                photo.recycle();
                flag1 = true;
                j = photo.getWidthPlusFramePadding();
                if (i + k < mStart)
                {
                    setStart((mStart + j) - k);
                }
            }
            i += mBetweenPicturePadding + j;
            flag = flag1;
        }

        return flag;
    }

    public final void reloadPhotoIfNeeded(int i)
    {
        Photo photo = (Photo)mPhotos.get(i);
        if (!photo.isPhotoLoaded())
        {
            photo.needsDownload = Boolean.valueOf(true);
        }
    }

    public void setAllowFixInPlace(boolean flag)
    {
        allowFixInPlace = flag;
    }

    public final void setAllowPinchZoom(Boolean boolean1)
    {
        mAllowPinchZoom = boolean1;
    }

    public final void setBetweenPicturePadding(int i)
    {
        mBetweenPicturePadding = i;
    }

    public final void setEnabled(Boolean boolean1)
    {
        mEnabled = boolean1;
    }

    public void setFakePhotosClickable(boolean flag)
    {
        fakePhotosClickable = flag;
    }

    public void setFwLoaderManager(FwLoaderManager fwloadermanager, int i)
    {
        fwLoaderManager = fwloadermanager;
        fwLoaderBaseId = i;
    }

    public final void setOnPhotoLoadedEvent(OnPhotoLoadedEvent onphotoloadedevent)
    {
        mOnPhotoLoadedEvent = onphotoloadedevent;
    }

    public final void setOnPhotoSelectedEvent(OnPhotoSelectedEvent onphotoselectedevent)
    {
        mOnPhotoSelectedEvent = onphotoselectedevent;
    }

    public final void setPictureBackgroundColor(Integer integer)
    {
        mPictureBackgroundColor = integer;
    }

    public final void setPictureFrame(Drawable drawable)
    {
        m9PatchBackground = drawable;
    }

    public final void setSelectedIndex(int i)
    {
        if (mSelectedIndex != i)
        {
            mSelectedIndex = i;
            autoScrolling = false;
            invalidate();
        }
    }

    public final void setSnapTo(Boolean boolean1)
    {
        mSnapTo = boolean1;
    }

    public final void setSquarePictures(Boolean boolean1)
    {
        mKeepPicturesSquare = boolean1.booleanValue();
    }

    public void turnAutoScrollOn(long l)
    {
        autoScrollDelayMs = l;
        autoScrolling = true;
        autoScroll = new AutoScroll(this);
        autoScroll.postDelayed(autoScroll, autoScrollDelayMs);
    }

    public final int updateUrls(List list, int i)
    {
        ViewGroup viewgroup;
        ArrayList arraylist;
        int j;
        int k;
        j = 0;
        k = 0;
        viewgroup = null;
        if (i > 0)
        {
            viewgroup = (ViewGroup)((ViewGroup)getParent()).findViewById(0x7f1004b0);
            viewgroup.removeAllViews();
            DisplayMetrics displaymetrics = new DisplayMetrics();
            ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getMetrics(displaymetrics);
            progressSizeDp = scaleToScreen(i);
        }
        arraylist = new ArrayList();
        if (list.size() != 0) goto _L2; else goto _L1
_L1:
        arraylist.add(new Photo("", false));
_L4:
        mPhotos = arraylist;
        invalidate();
        return k;
_L2:
        Iterator iterator = list.iterator();
        do
        {
            k = j;
            if (!iterator.hasNext())
            {
                continue;
            }
            String s = (String)iterator.next();
            Photo photo = getPhoto(s);
            list = photo;
            k = j;
            if (photo == null)
            {
                Photo photo1 = new Photo(s, mAllowPinchZoom.booleanValue());
                j++;
                list = photo1;
                k = j;
                if (viewgroup != null)
                {
                    list = photo1;
                    k = j;
                    if (i > 0)
                    {
                        photo1.progressSpinner = inflater.inflate(0x7f03019a, viewgroup, false);
                        list = (android.widget.AbsoluteLayout.LayoutParams)photo1.progressSpinner.getLayoutParams();
                        k = progressSizeDp;
                        list.width = k;
                        list.height = k;
                        photo1.progressSpinner.setLayoutParams(list);
                        viewgroup.addView(photo1.progressSpinner);
                        photo1.progressSpinner.setVisibility(8);
                        k = j;
                        list = photo1;
                    }
                }
            }
            arraylist.add(list);
            j = k;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    static 
    {
        kBetweenPicturePadding = 6;
        kOutsidePicturePadding = 0;
    }






















/*
    static boolean access$402(PhotoGalleryWidget photogallerywidget, boolean flag)
    {
        photogallerywidget.mShouldStopFling = flag;
        return flag;
    }

*/



}
