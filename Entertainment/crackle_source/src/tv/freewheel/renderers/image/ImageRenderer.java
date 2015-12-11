// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.image;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.URLUtil;
import android.widget.ImageView;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import tv.freewheel.ad.interfaces.IAdInstance;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.ad.interfaces.ICreativeRendition;
import tv.freewheel.ad.interfaces.ICreativeRenditionAsset;
import tv.freewheel.ad.interfaces.ISlot;
import tv.freewheel.renderers.interfaces.IActivityCallbackListener;
import tv.freewheel.renderers.interfaces.IRenderer;
import tv.freewheel.renderers.interfaces.IRendererContext;
import tv.freewheel.utils.Logger;
import tv.freewheel.utils.renderer.RendererTimer;

// Referenced classes of package tv.freewheel.renderers.image:
//            Parameters, BaseLayout, InterstitialLayout

public class ImageRenderer
    implements IRenderer, tv.freewheel.utils.renderer.RendererTimer.IRendererTimerService
{
    private class downloadImageTask extends AsyncTask
    {

        private String description;
        final ImageRenderer this$0;

        protected transient Bitmap doInBackground(String as[])
        {
            Object obj;
            Bitmap bitmap2;
            Object obj1;
            Object obj2;
            int i;
            as = as[0];
            obj1 = null;
            obj2 = null;
            obj = null;
            bitmap2 = null;
            if (!URLUtil.isValidUrl(as))
            {
                break MISSING_BLOCK_LABEL_296;
            }
            i = 0;
_L6:
            String as1[] = null;
            obj = obj1;
            Bitmap bitmap1 = obj2;
            String s;
            int j;
            try
            {
                as = (HttpURLConnection)(HttpURLConnection)(new URL(as)).openConnection();
            }
            // Misplaced declaration of an exception variable
            catch (String as[])
            {
                description = as.toString();
                return ((Bitmap) (obj));
            }
            // Misplaced declaration of an exception variable
            catch (String as[])
            {
                description = (new StringBuilder()).append("Failed to get content from creative url.").append(as.toString()).toString();
                obj = bitmap1;
                if (as1 != null)
                {
                    as1.disconnect();
                    return bitmap1;
                }
                break MISSING_BLOCK_LABEL_319;
            }
            obj = obj1;
            bitmap1 = obj2;
            as1 = as;
            as.setInstanceFollowRedirects(false);
            obj = obj1;
            bitmap1 = obj2;
            as1 = as;
            as.connect();
            obj = obj1;
            bitmap1 = obj2;
            as1 = as;
            if (as.getResponseCode() == 302) goto _L2; else goto _L1
_L1:
            obj = obj1;
            bitmap1 = obj2;
            as1 = as;
            bitmap2 = BitmapFactory.decodeStream(as.getInputStream());
            as1 = as;
            as = bitmap2;
_L4:
            obj = as;
            if (i <= 3)
            {
                break MISSING_BLOCK_LABEL_319;
            }
            obj = as;
            bitmap1 = as;
            description = "redirect too many times";
            return as;
_L2:
            obj = obj1;
            bitmap1 = obj2;
            as1 = as;
            s = as.getHeaderField("Location");
            j = i + 1;
            obj = obj1;
            bitmap1 = obj2;
            as1 = as;
            logger.debug((new StringBuilder()).append("redirect to new location: ").append(s).toString());
            obj = obj1;
            bitmap1 = obj2;
            as1 = as;
            as.disconnect();
            as1 = null;
            as = s;
            i = j;
            if (j <= 3)
            {
                break; /* Loop/switch isn't completed */
            }
            as = bitmap2;
            i = j;
            if (true) goto _L4; else goto _L3
_L3:
            if (true) goto _L6; else goto _L5
_L5:
            description = (new StringBuilder()).append("Invalid url:").append(as).toString();
            return ((Bitmap) (obj));
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected void onPostExecute(Bitmap bitmap1)
        {
            bitmap = bitmap1;
            if (bitmap1 != null)
            {
                imageWidthInPixel = bitmap1.getWidth();
                imageHeightInPixel = bitmap1.getHeight();
                onImagePrepared();
                return;
            } else
            {
                failWithError(constants.ERROR_IO(), description);
                return;
            }
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Bitmap)obj);
        }

        private downloadImageTask()
        {
            this$0 = ImageRenderer.this;
            super();
        }

    }


    private static final String BASE_UNIT_INTERSTITIAL = "app-interstitial";
    private static final int OVERLAY_SLOT_HEIGHT = 50;
    private static final int OVERLAY_SLOT_WIDTH = 240;
    private Activity activity;
    private IActivityCallbackListener activityCallbackListener;
    private boolean allowsUpscaling;
    private BaseLayout baselayout;
    private Bitmap bitmap;
    private IConstants constants;
    private double duration;
    private AtomicInteger headTime;
    private int height;
    private int imageHeightInPixel;
    private Matrix imageInverse;
    private ImageView imageView;
    private int imageWidthInPixel;
    private boolean isInterstitial;
    private Logger logger;
    private Handler mainLoopHandler;
    private Parameters parameters;
    private boolean pauseNotificationSentWhenActivityPaused;
    private boolean pauseNotificationSentWhenStart;
    private IRendererContext rendererContext;
    private RendererTimer rendererTimer;
    private boolean shouldEndAfterDuration;
    private boolean shouldPauseContentWhenStart;
    private boolean shouldPauseResumeMainVideoOnActivityStateChange;
    private ISlot slot;
    private int width;

    public ImageRenderer()
    {
        rendererContext = null;
        constants = null;
        slot = null;
        parameters = null;
        mainLoopHandler = null;
        shouldEndAfterDuration = false;
        shouldPauseResumeMainVideoOnActivityStateChange = false;
        shouldPauseContentWhenStart = false;
        pauseNotificationSentWhenStart = false;
        pauseNotificationSentWhenActivityPaused = false;
        allowsUpscaling = true;
        duration = -1D;
        headTime = new AtomicInteger(-1);
        rendererTimer = null;
        bitmap = null;
        imageView = null;
        imageInverse = null;
        imageWidthInPixel = -1;
        imageHeightInPixel = -1;
        baselayout = null;
        logger = Logger.getLogger(this);
        logger.info((new StringBuilder()).append("Android SDK Version: ").append(android.os.Build.VERSION.SDK).append(", API Version: ").append(android.os.Build.VERSION.SDK_INT).toString());
    }

    private void calculateImageViewSize()
    {
        ICreativeRendition icreativerendition = rendererContext.getAdInstance().getActiveCreativeRendition();
        logger.debug((new StringBuilder()).append("calculateImageViewSize(), slot width: ").append(slot.getWidth()).append("dp, rendition width:").append(icreativerendition.getWidth()).append("dp").toString());
        DisplayMetrics displaymetrics = activity.getResources().getDisplayMetrics();
        if (icreativerendition.getWidth() > 0 && icreativerendition.getHeight() > 0)
        {
            width = (int)((float)icreativerendition.getWidth() * displaymetrics.density);
            height = (int)((float)icreativerendition.getHeight() * displaymetrics.density);
        } else
        if (slot.getTimePositionClass() == rendererContext.getConstants().TIME_POSITION_CLASS_OVERLAY())
        {
            width = (int)(240F * displaymetrics.density);
            height = (int)(50F * displaymetrics.density);
        } else
        {
            width = imageWidthInPixel;
            height = imageHeightInPixel;
        }
        logger.debug((new StringBuilder()).append("ad width = ").append(width).append("px height = ").append(height).append("px").toString());
    }

    private void failWithError(String s, String s1)
    {
        logger.error((new StringBuilder()).append("failWithError errorCode:").append(s).append(", errorMessage:").append(s1).toString());
        Bundle bundle = new Bundle();
        bundle.putString(constants.INFO_KEY_ERROR_CODE(), s);
        bundle.putString(constants.INFO_KEY_ERROR_INFO(), s1);
        s = new HashMap();
        s.put(constants.INFO_KEY_EXTRA_INFO(), bundle);
        rendererContext.dispatchEvent(constants.EVENT_ERROR(), s);
    }

    private View getAppView()
    {
        return activity.getWindow().findViewById(0x1020002);
    }

    private void onImagePrepared()
    {
        mainLoopHandler.post(new Runnable() {

            final ImageRenderer this$0;

            public void run()
            {
                activityCallbackListener = new IActivityCallbackListener() {

                    final _cls2 this$1;

                    public void onActivityCallback(int i)
                    {
                        logger.debug((new StringBuilder()).append("onActivityStateChange ").append(i).toString());
                        if (i == constants.ACTIVITY_CALLBACK_PAUSE())
                        {
                            logger.info("context activity paused");
                            if (rendererTimer != null)
                            {
                                rendererTimer.pause();
                            }
                            if (shouldPauseResumeMainVideoOnActivityStateChange && !pauseNotificationSentWhenStart && !pauseNotificationSentWhenActivityPaused)
                            {
                                logger.debug("Send EVENT_REQUEST_CONTENT_VIDEO_PAUSE when activity is paused");
                                rendererContext.dispatchEvent(constants.EVENT_REQUEST_CONTENT_VIDEO_PAUSE());
                                pauseNotificationSentWhenActivityPaused = true;
                            }
                        } else
                        if (i == constants.ACTIVITY_CALLBACK_RESUME())
                        {
                            logger.info("context activity resumed");
                            if (rendererTimer != null)
                            {
                                rendererTimer.resume();
                            }
                            if (shouldPauseResumeMainVideoOnActivityStateChange && pauseNotificationSentWhenActivityPaused)
                            {
                                logger.debug("Send EVENT_REQUEST_CONTENT_VIDEO_RESUME when activity is resumed");
                                rendererContext.dispatchEvent(constants.EVENT_REQUEST_CONTENT_VIDEO_RESUME());
                                pauseNotificationSentWhenActivityPaused = false;
                            }
                            if (imageView != null && slot.getTimePositionClass() == constants.TIME_POSITION_CLASS_OVERLAY())
                            {
                                imageView.bringToFront();
                                return;
                            }
                        }
                    }

            
            {
                this$1 = _cls2.this;
                super();
            }
                };
                if (shouldPauseContentWhenStart && !pauseNotificationSentWhenStart)
                {
                    logger.debug("Send EVENT_REQUEST_CONTENT_VIDEO_PAUSE when the ad starts");
                    rendererContext.dispatchEvent(constants.EVENT_REQUEST_CONTENT_VIDEO_PAUSE());
                    pauseNotificationSentWhenStart = true;
                }
                rendererContext.addOnActivityCallbackListener(activityCallbackListener);
                showImage();
                rendererContext.dispatchEvent(constants.EVENT_AD_STARTED());
                if (rendererTimer != null)
                {
                    rendererTimer.start();
                }
            }

            
            {
                this$0 = ImageRenderer.this;
                super();
            }
        });
    }

    private void prepareImage()
    {
        logger.debug("prepareImage()");
        Object obj = activity.getResources().getDisplayMetrics();
        logger.debug((new StringBuilder()).append("Display size: ").append(((DisplayMetrics) (obj)).widthPixels).append("x").append(((DisplayMetrics) (obj)).heightPixels).append(", app size: ").append(getAppView().getWidth()).append("x").append(getAppView().getHeight()).toString());
        isInterstitial = "app-interstitial".equalsIgnoreCase(rendererContext.getAdInstance().getActiveCreativeRendition().getBaseUnit());
        logger.debug((new StringBuilder()).append("isInterstitial:").append(isInterstitial).toString());
        int i = slot.getTimePositionClass();
        if (isInterstitial && i == constants.TIME_POSITION_CLASS_OVERLAY())
        {
            failWithError(constants.ERROR_INVALID_SLOT(), "The interstitial ad is not supported in overlay slot");
            return;
        }
        rendererContext.setRendererCapability(constants.EVENT_AD_PAUSE(), constants.CAPABILITY_STATUS_OFF());
        rendererContext.setRendererCapability(constants.EVENT_AD_RESUME(), constants.CAPABILITY_STATUS_OFF());
        parameters = new Parameters(rendererContext);
        boolean flag;
        if (parameters.allowsUpscaling != null)
        {
            allowsUpscaling = parameters.allowsUpscaling.booleanValue();
        } else
        {
            allowsUpscaling = true;
        }
        logger.debug((new StringBuilder()).append("allowsUpscaling: ").append(allowsUpscaling).toString());
        obj = parameters.shouldEndAfterDuration;
        if (constants.TIME_POSITION_CLASS_DISPLAY() != i || isInterstitial)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        shouldEndAfterDuration = flag;
        if (obj != null)
        {
            if (shouldEndAfterDuration && ((Boolean) (obj)).booleanValue())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            shouldEndAfterDuration = flag;
        }
        if (shouldEndAfterDuration)
        {
            duration = rendererContext.getAdInstance().getActiveCreativeRendition().getDuration();
            if (duration > 0.0D)
            {
                headTime = new AtomicInteger(0);
                rendererTimer = new RendererTimer((int)duration, this);
            }
        }
        if (i == constants.TIME_POSITION_CLASS_DISPLAY() || i == constants.TIME_POSITION_CLASS_OVERLAY())
        {
            shouldPauseResumeMainVideoOnActivityStateChange = true;
        }
        logger.debug((new StringBuilder()).append("shouldPauseResumeMainVideoOnActivityStateChange:").append(shouldPauseResumeMainVideoOnActivityStateChange).toString());
        if (i == constants.TIME_POSITION_CLASS_DISPLAY() && isInterstitial)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        shouldPauseContentWhenStart = flag;
        logger.debug((new StringBuilder()).append("shouldPauseContentWhenStart:").append(shouldPauseContentWhenStart).toString());
        obj = rendererContext.getAdInstance().getActiveCreativeRendition().getPrimaryCreativRenditionAsset().getURL();
        if (obj != null && ((String) (obj)).length() != 0)
        {
            (new downloadImageTask()).execute(new String[] {
                obj
            });
            return;
        } else
        {
            failWithError(constants.ERROR_NULL_ASSET(), "Asset url is empty");
            return;
        }
    }

    private void showImage()
    {
        calculateImageViewSize();
        imageView = new ImageView(activity);
        imageView.setImageBitmap(bitmap);
        imageInverse = new Matrix();
        imageView.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
        imageView.setBackgroundColor(0);
        imageView.setClickable(true);
        imageView.setOnTouchListener(new android.view.View.OnTouchListener() {

            final ImageRenderer this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (motionevent.getAction() == 1)
                {
                    imageView.getImageMatrix().invert(imageInverse);
                    view = new float[2];
                    view[0] = motionevent.getX();
                    view[1] = motionevent.getY();
                    imageInverse.mapPoints(view);
                    float f = view[0];
                    float f1 = view[1];
                    logger.debug((new StringBuilder()).append("onTouch (").append(f).append(", ").append(f1).append(")").toString());
                    if (f > 0.0F && f1 > 0.0F && f < (float)imageWidthInPixel && f1 < (float)imageHeightInPixel)
                    {
                        rendererContext.dispatchEvent(constants.EVENT_AD_CLICK());
                        return true;
                    }
                    logger.debug("touch event not in the image area.");
                }
                return false;
            }

            
            {
                this$0 = ImageRenderer.this;
                super();
            }
        });
        if (isInterstitial)
        {
            showInterstitialImage();
            return;
        } else
        {
            showInlineImage();
            return;
        }
    }

    private void showInlineImage()
    {
        DisplayMetrics displaymetrics = activity.getResources().getDisplayMetrics();
        if (slot.getType() == rendererContext.getConstants().SLOT_TYPE_TEMPORAL())
        {
            if (slot.getTimePositionClass() == rendererContext.getConstants().TIME_POSITION_CLASS_OVERLAY())
            {
                android.widget.FrameLayout.LayoutParams layoutparams2 = new android.widget.FrameLayout.LayoutParams(width, height);
                layoutparams2.gravity = 0;
                String s1 = parameters.primaryAnchor;
                Integer integer = parameters.marginWidth;
                Integer integer1 = parameters.marginHeight;
                String s = s1;
                if (s1 == null)
                {
                    s = "bc";
                }
                if (s.contains("t"))
                {
                    layoutparams2.gravity = layoutparams2.gravity | 0x30;
                    if (integer1 != null)
                    {
                        layoutparams2.topMargin = (int)(integer1.doubleValue() * (double)displaymetrics.density);
                    }
                }
                if (s.contains("l"))
                {
                    layoutparams2.gravity = layoutparams2.gravity | 3;
                    if (integer != null)
                    {
                        layoutparams2.leftMargin = (int)(integer.doubleValue() * (double)displaymetrics.density);
                    }
                }
                if (s.contains("r"))
                {
                    layoutparams2.gravity = layoutparams2.gravity | 5;
                    if (integer != null)
                    {
                        layoutparams2.rightMargin = (int)(integer.doubleValue() * (double)displaymetrics.density);
                    }
                }
                if (s.contains("b"))
                {
                    layoutparams2.gravity = layoutparams2.gravity | 0x50;
                    if (integer1 != null)
                    {
                        layoutparams2.bottomMargin = (int)(integer1.doubleValue() * (double)displaymetrics.density);
                    }
                }
                if (s.contains("c"))
                {
                    layoutparams2.gravity = layoutparams2.gravity | 1;
                }
                if (s.contains("m"))
                {
                    layoutparams2.gravity = layoutparams2.gravity | 0x10;
                }
                if (s.equals("c") || s.equals("m") || s.equals("cm") || s.equals("mc"))
                {
                    layoutparams2.gravity = 17;
                }
                logger.debug((new StringBuilder()).append("show, overlay layout width: ").append(width).append("px, height: ").append(height).append("px ar:").append(s).append(", marginWidth: ").append((float)integer.intValue() * displaymetrics.density).append("px, marginHeight: ").append((float)integer1.intValue() * displaymetrics.density).append("px").toString());
                slot.getBase().setOnHierarchyChangeListener(new android.view.ViewGroup.OnHierarchyChangeListener() {

                    final ImageRenderer this$0;

                    public void onChildViewAdded(View view, View view1)
                    {
                        logger.debug("onChildViewAdded");
                        if (imageView != null && imageView != view1)
                        {
                            imageView.bringToFront();
                        }
                    }

                    public void onChildViewRemoved(View view, View view1)
                    {
                        logger.debug("onChildViewRemoved, do nothing");
                    }

            
            {
                this$0 = ImageRenderer.this;
                super();
            }
                });
                slot.getBase().addView(imageView, layoutparams2);
            } else
            {
                android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-1, -1);
                layoutparams.gravity = 17;
                baselayout = new BaseLayout(activity);
                slot.getBase().addView(baselayout, 0, layoutparams);
                baselayout.addAdView(imageView, slot.getBase(), width, height, allowsUpscaling);
            }
        } else
        {
            android.widget.RelativeLayout.LayoutParams layoutparams1 = new android.widget.RelativeLayout.LayoutParams(width, height);
            layoutparams1.addRule(13);
            slot.getBase().addView(imageView, layoutparams1);
        }
        imageView.bringToFront();
    }

    private void showInterstitialImage()
    {
        baselayout = new InterstitialLayout(activity);
        baselayout.addAdView(imageView, null, width, height, allowsUpscaling);
    }

    public void dispose()
    {
        logger.info("dispose()");
        stop();
    }

    public double getDuration()
    {
        return duration;
    }

    public HashMap getModuleInfo()
    {
        HashMap hashmap = new HashMap();
        hashmap.put(constants.INFO_KEY_MODULE_TYPE(), constants.MODULE_TYPE_RENDERER());
        hashmap.put("requiredAPIVersion", "5.15.2-r10578-1407080530");
        return hashmap;
    }

    public double getPlayheadTime()
    {
        return (double)headTime.get();
    }

    public void load(final IRendererContext rendererContextFinalRef)
    {
        logger.info("load()");
        rendererContextFinalRef.getActivity().runOnUiThread(new Runnable() {

            final ImageRenderer this$0;
            final IRendererContext val$rendererContextFinalRef;

            public void run()
            {
                rendererContext = rendererContextFinalRef;
                constants = rendererContext.getConstants();
                slot = rendererContext.getAdInstance().getSlot();
                activity = rendererContext.getActivity();
                mainLoopHandler = new Handler(activity.getMainLooper());
                rendererContext.dispatchEvent(constants.EVENT_AD_LOADED());
            }

            
            {
                this$0 = ImageRenderer.this;
                rendererContextFinalRef = irenderercontext;
                super();
            }
        });
    }

    public void pause()
    {
        logger.info("pause()");
        if (rendererTimer != null)
        {
            rendererTimer.pause();
        }
    }

    public void playHeadTime(int i)
    {
        headTime.set(i);
    }

    public void resize()
    {
        logger.info("resize()");
        if (!isInterstitial)
        {
            if (baselayout != null)
            {
                baselayout.removeAdView(imageView);
                ((ViewGroup)baselayout.getParent()).removeView(baselayout);
                baselayout = null;
            } else
            {
                ((ViewGroup)imageView.getParent()).removeView(imageView);
            }
            showInlineImage();
        }
    }

    public void resume()
    {
        logger.info("resume()");
        if (rendererTimer != null)
        {
            rendererTimer.resume();
        }
    }

    public void start()
    {
        logger.info("start()");
        mainLoopHandler.post(new Runnable() {

            final ImageRenderer this$0;

            public void run()
            {
                prepareImage();
            }

            
            {
                this$0 = ImageRenderer.this;
                super();
            }
        });
    }

    public void stop()
    {
        logger.info("stop()");
        mainLoopHandler.post(new Runnable() {

            final ImageRenderer this$0;

            public void run()
            {
                if (rendererTimer != null)
                {
                    rendererTimer.stop();
                    rendererTimer = null;
                }
                if (baselayout != null)
                {
                    baselayout.removeAdView(imageView);
                    if (baselayout.getParent() != null)
                    {
                        ((ViewGroup)baselayout.getParent()).removeView(baselayout);
                    }
                    baselayout = null;
                } else
                {
                    slot.getBase().removeView(imageView);
                }
                imageView = null;
                bitmap = null;
                if (shouldPauseContentWhenStart && pauseNotificationSentWhenStart)
                {
                    logger.debug("Send EVENT_REQUEST_CONTENT_VIDEO_RESUME when the ad completes");
                    rendererContext.dispatchEvent(constants.EVENT_REQUEST_CONTENT_VIDEO_RESUME());
                    pauseNotificationSentWhenStart = false;
                }
                rendererContext.dispatchEvent(constants.EVENT_AD_STOPPED());
            }

            
            {
                this$0 = ImageRenderer.this;
                super();
            }
        });
    }

    public void timeOut()
    {
        stop();
    }



/*
    static Handler access$1002(ImageRenderer imagerenderer, Handler handler)
    {
        imagerenderer.mainLoopHandler = handler;
        return handler;
    }

*/


/*
    static Bitmap access$102(ImageRenderer imagerenderer, Bitmap bitmap1)
    {
        imagerenderer.bitmap = bitmap1;
        return bitmap1;
    }

*/



/*
    static IActivityCallbackListener access$1202(ImageRenderer imagerenderer, IActivityCallbackListener iactivitycallbacklistener)
    {
        imagerenderer.activityCallbackListener = iactivitycallbacklistener;
        return iactivitycallbacklistener;
    }

*/



/*
    static RendererTimer access$1302(ImageRenderer imagerenderer, RendererTimer renderertimer)
    {
        imagerenderer.rendererTimer = renderertimer;
        return renderertimer;
    }

*/




/*
    static boolean access$1502(ImageRenderer imagerenderer, boolean flag)
    {
        imagerenderer.pauseNotificationSentWhenStart = flag;
        return flag;
    }

*/



/*
    static boolean access$1602(ImageRenderer imagerenderer, boolean flag)
    {
        imagerenderer.pauseNotificationSentWhenActivityPaused = flag;
        return flag;
    }

*/



/*
    static ImageView access$1702(ImageRenderer imagerenderer, ImageView imageview)
    {
        imagerenderer.imageView = imageview;
        return imageview;
    }

*/






/*
    static int access$202(ImageRenderer imagerenderer, int i)
    {
        imagerenderer.imageWidthInPixel = i;
        return i;
    }

*/



/*
    static BaseLayout access$2102(ImageRenderer imagerenderer, BaseLayout baselayout1)
    {
        imagerenderer.baselayout = baselayout1;
        return baselayout1;
    }

*/




/*
    static int access$302(ImageRenderer imagerenderer, int i)
    {
        imagerenderer.imageHeightInPixel = i;
        return i;
    }

*/




/*
    static IConstants access$502(ImageRenderer imagerenderer, IConstants iconstants)
    {
        imagerenderer.constants = iconstants;
        return iconstants;
    }

*/




/*
    static IRendererContext access$702(ImageRenderer imagerenderer, IRendererContext irenderercontext)
    {
        imagerenderer.rendererContext = irenderercontext;
        return irenderercontext;
    }

*/



/*
    static ISlot access$802(ImageRenderer imagerenderer, ISlot islot)
    {
        imagerenderer.slot = islot;
        return islot;
    }

*/



/*
    static Activity access$902(ImageRenderer imagerenderer, Activity activity1)
    {
        imagerenderer.activity = activity1;
        return activity1;
    }

*/
}
