// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.renderers.html;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import java.util.HashMap;
import java.util.Map;
import tv.freewheel.hybrid.ad.interfaces.IAdInstance;
import tv.freewheel.hybrid.ad.interfaces.IConstants;
import tv.freewheel.hybrid.ad.interfaces.ICreativeRendition;
import tv.freewheel.hybrid.ad.interfaces.ISlot;
import tv.freewheel.hybrid.renderers.interfaces.IRendererContext;
import tv.freewheel.hybrid.utils.Logger;

// Referenced classes of package tv.freewheel.hybrid.renderers.html:
//            MRAIDBasePresentation, MRAIDWebView, HTMLRenderer, Parameters

class MRAIDPresentationInLine extends MRAIDBasePresentation
{

    private static int OVERLAY_SLOT_HEIGHT = 50;
    private static int OVERLAY_SLOT_WIDTH = 240;
    private static Map gravityMap;
    private FrameLayout alphaHolder;
    private MRAIDWebView alphaView;
    private View appView;
    private MRAIDWebView betaView;
    private ICreativeRendition creativeRendition;
    private int defaultLocation[];
    private String expandedURL;
    private MRAIDWebView expandedViewRef;
    private int height;
    private Logger logger;
    private IRendererContext rendererContext;
    private FrameLayout resizeBaseView;
    private FrameLayout resizeHelperView;
    private ISlot slot;
    private int width;

    public MRAIDPresentationInLine(Activity activity, HTMLRenderer htmlrenderer, IRendererContext irenderercontext, Boolean boolean1)
    {
        super(activity, htmlrenderer, boolean1.booleanValue());
        logger = Logger.getLogger(this);
        rendererContext = irenderercontext;
        slot = irenderercontext.getAdInstance().getSlot();
        creativeRendition = irenderercontext.getAdInstance().getActiveCreativeRendition();
        alphaView = new MRAIDWebView(activity, htmlrenderer, true, boolean1.booleanValue());
        alphaHolder = new FrameLayout(activity);
        if (htmlrenderer.parameters().shouldBackgroundTransparent != null && htmlrenderer.parameters().shouldBackgroundTransparent.booleanValue())
        {
            alphaHolder.setBackgroundColor(0);
        }
        betaView = new MRAIDWebView(activity, htmlrenderer, false, boolean1.booleanValue());
        calculateAdSize();
        defaultLocation = new int[2];
        resizeHelperView = new FrameLayout(activity) {

            final MRAIDPresentationInLine this$0;

            public boolean onTouchEvent(MotionEvent motionevent)
            {
                return false;
            }

            
            {
                this$0 = MRAIDPresentationInLine.this;
                super(context);
            }
        };
        resizeBaseView = new FrameLayout(activity);
        resizeHelperView.addView(resizeBaseView, new android.widget.FrameLayout.LayoutParams(10, 10));
        appView = activity.getWindow().findViewById(0x1020002);
    }

    private void calculateAdSize()
    {
        byte byte0;
        byte0 = -1;
        logger.debug((new StringBuilder()).append("calculateAdSize, slot width: ").append(slot.getWidth()).append(", rendition width:").append(creativeRendition.getWidth()).toString());
        if (slot.getType() != rendererContext.getConstants().SLOT_TYPE_TEMPORAL()) goto _L2; else goto _L1
_L1:
        int i;
        if (slot.getTimePositionClass() == rendererContext.getConstants().TIME_POSITION_CLASS_OVERLAY())
        {
            width = OVERLAY_SLOT_WIDTH;
            height = OVERLAY_SLOT_HEIGHT;
        } else
        {
            if (slot.getWidth() > 0)
            {
                i = slot.getWidth();
            } else
            {
                i = -1;
            }
            width = i;
            i = byte0;
            if (slot.getHeight() > 0)
            {
                i = slot.getHeight();
            }
            height = i;
        }
        if (creativeRendition.getWidth() > 0)
        {
            i = creativeRendition.getWidth();
        } else
        {
            i = width;
        }
        width = i;
        if (creativeRendition.getHeight() > 0)
        {
            i = creativeRendition.getHeight();
        } else
        {
            i = height;
        }
        height = i;
_L4:
        logger.debug((new StringBuilder()).append("ad width = ").append(width).append(" height = ").append(height).toString());
        return;
_L2:
        width = slot.getWidth();
        height = slot.getHeight();
        if (bridge.parameters().shouldUseDip.booleanValue())
        {
            DisplayMetrics displaymetrics = activity.getResources().getDisplayMetrics();
            width = (int)((float)width * displaymetrics.density);
            height = (int)((float)height * displaymetrics.density);
            if (width > displaymetrics.widthPixels)
            {
                height = (int)((float)(displaymetrics.widthPixels * height) / (float)width);
                width = displaymetrics.widthPixels;
            }
            if (height > displaymetrics.heightPixels)
            {
                width = (int)((float)(displaymetrics.heightPixels * width) / (float)height);
                height = displaymetrics.heightPixels;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void close()
    {
        logger.debug("close");
        if (expandedViewRef != null)
        {
            logger.debug("close expanded ad view");
            betaView.closeCustomView();
            removeView();
            show();
            betaView.dispose();
            betaView = new MRAIDWebView(activity, bridge, false, enableMRAID.booleanValue());
            expandedViewRef = null;
            return;
        }
        if (alphaView.getParent() == resizeBaseView)
        {
            logger.debug("close resized ad view");
            closeButton.setOnClickListener(null);
            resizeBaseView.removeView(closeButton);
            resizeBaseView.removeView(alphaView);
            ((ViewGroup)appView).removeView(resizeHelperView);
            setEnableSync(alphaView, false);
            alphaHolder.addView(alphaView, -1, -1);
            return;
        }
        logger.debug("close inline ad view");
        if (slot.getTimePositionClass() == rendererContext.getConstants().TIME_POSITION_CLASS_OVERLAY())
        {
            slot.getBase().setOnHierarchyChangeListener(null);
        }
        alphaView.closeCustomView();
        alphaHolder.removeView(alphaView);
        slot.getBase().removeView(alphaHolder);
    }

    public void collapse()
    {
        logger.debug("collapse");
        if (expandedURL == null)
        {
            alphaView.closeCustomView();
            removeView();
            alphaView.setFullScreen(false);
            show();
            expandedViewRef = null;
            return;
        } else
        {
            logger.warn("The collapse shouldn't be called.");
            return;
        }
    }

    public void dispose()
    {
        alphaView.dispose();
        betaView.dispose();
    }

    public void expand(String s, int i, int j)
    {
        logger.debug((new StringBuilder()).append("expand(url:").append(s).append(",w=").append(i).append(",h=").append(j).append(")").toString());
        expandedURL = s;
        if (s == null)
        {
            alphaView.setFullScreen(true);
            expandedViewRef = alphaView;
        } else
        {
            betaView.runJavaScript("mraid.state='expanded';");
            betaView.setFullScreen(true);
            betaView.loadUrl(s);
            expandedViewRef = betaView;
        }
        if (slot.getTimePositionClass() == rendererContext.getConstants().TIME_POSITION_CLASS_OVERLAY())
        {
            slot.getBase().setOnHierarchyChangeListener(null);
        }
        alphaView.closeCustomView();
        if (alphaView.getParent() != alphaHolder) goto _L2; else goto _L1
_L1:
        alphaHolder.removeView(alphaView);
_L4:
        slot.getBase().removeView(alphaHolder);
        setEnableSync(expandedViewRef, false);
        super.addView(expandedViewRef, i, j);
        return;
_L2:
        if (alphaView.getParent() == resizeBaseView)
        {
            closeButton.setOnClickListener(null);
            resizeBaseView.removeView(closeButton);
            resizeBaseView.removeView(alphaView);
            ((ViewGroup)appView).removeView(resizeHelperView);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public String getAbsoluteURL(String s)
    {
        if (expandedViewRef != null)
        {
            return expandedViewRef.URLWithBaseURL(s);
        } else
        {
            return alphaView.URLWithBaseURL(s);
        }
    }

    public MRAIDWebView getCurrentView()
    {
        if (expandedViewRef != null)
        {
            return expandedViewRef;
        }
        if (alphaView != null)
        {
            return alphaView;
        } else
        {
            return null;
        }
    }

    public void getDefaultPositionOnScreen(int ai[])
    {
        if (alphaHolder.getWindowVisibility() != 8)
        {
            alphaHolder.getLocationOnScreen(defaultLocation);
        }
        ai[0] = defaultLocation[0];
        ai[1] = defaultLocation[1];
        ai[2] = width;
        ai[3] = height;
    }

    public void loadContent(String s)
    {
        logger.info((new StringBuilder()).append("loadContent: ").append(s).toString());
        alphaView.loadDataWithBaseURL(null, s, null, "UTF-8", null);
    }

    public void loadURL(String s)
    {
        logger.info((new StringBuilder()).append("loadURL(").append(s).append(")").toString());
        alphaView.loadUrl(s);
    }

    public void refresh()
    {
        logger.debug("refresh");
        (new Handler(slot.getBase().getContext().getMainLooper())).post(new Runnable() {

            final MRAIDPresentationInLine this$0;

            public void run()
            {
                alphaHolder.bringToFront();
            }

            
            {
                this$0 = MRAIDPresentationInLine.this;
                super();
            }
        });
    }

    public void resize(int i, int j, int k, int l, String s, boolean flag)
    {
        Object obj;
        int i1;
        int k1;
        obj = (ViewGroup)alphaView.getParent();
        if (obj == null || alphaHolder.getWindowVisibility() == 8)
        {
            bridge.dispatchMraidError("Resize called at incorrect state", "resize");
            return;
        }
        if (appView == null || !(appView instanceof ViewGroup))
        {
            bridge.dispatchMraidError("Could not attach view to app root view", "resize");
            return;
        }
        if (!flag && (k > appView.getWidth() || l > appView.getHeight()))
        {
            bridge.dispatchMraidError("Resize parameter out of range", "resize");
            return;
        }
        int ai[] = new int[2];
        int ai1[] = new int[2];
        appView.getLocationOnScreen(ai);
        alphaHolder.getLocationOnScreen(ai1);
        i1 = (ai1[0] - ai[0]) + i;
        k1 = (ai1[1] - ai[1]) + j;
        if (flag) goto _L2; else goto _L1
_L1:
        if (i1 >= 0) goto _L4; else goto _L3
_L3:
        i = 0;
_L11:
        if (k1 >= 0) goto _L6; else goto _L5
_L5:
        int j1;
        j = 0;
        j1 = i;
_L7:
        ((ViewGroup) (obj)).removeView(alphaView);
        if (resizeHelperView.getParent() == null)
        {
            ((ViewGroup)appView).addView(resizeHelperView, new android.view.ViewGroup.LayoutParams(-1, -1));
        }
        logger.debug((new StringBuilder()).append("Resize to: (").append(j1).append(",").append(j).append("), size (").append(k).append("x").append(l).append(") pixels").toString());
        obj = new android.widget.FrameLayout.LayoutParams(k, l);
        obj.leftMargin = j1;
        obj.topMargin = j;
        resizeBaseView.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        setEnableSync(alphaView, true);
        resizeBaseView.addView(alphaView, new android.widget.FrameLayout.LayoutParams(-1, -1));
        if (closeButton.getParent() != null)
        {
            ((ViewGroup)closeButton.getParent()).removeView(closeButton);
        }
        setCloseButtonVisibility(true);
        closeButton.setOnClickListener(new android.view.View.OnClickListener() {

            final MRAIDPresentationInLine this$0;

            public void onClick(View view)
            {
                bridge.mraidClose();
            }

            
            {
                this$0 = MRAIDPresentationInLine.this;
                super();
            }
        });
        android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(50, 50);
        obj = (Integer)gravityMap.get(s);
        s = ((String) (obj));
        if (obj == null)
        {
            s = Integer.valueOf(53);
        }
        layoutparams.gravity = s.intValue();
        resizeBaseView.addView(closeButton, layoutparams);
        resizeHelperView.bringToFront();
        return;
_L4:
        i = i1;
        if (i1 + k > appView.getWidth())
        {
            i = appView.getWidth() - k;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        j1 = i;
        j = k1;
        if (k1 + l > appView.getHeight())
        {
            j = appView.getHeight() - l;
            j1 = i;
        }
        if (true) goto _L7; else goto _L2
_L2:
        i = i1 + k / 2;
        j = i1 + l / 2;
        if (s.startsWith("center") && (j < 25 || j + 25 > appView.getHeight()) || s.startsWith("top") && k1 < 0 || s.startsWith("bottom") && k1 + l > appView.getHeight() || s.endsWith("center") && (i < 25 || i + 25 > appView.getWidth()) || s.endsWith("left") && i1 < 0)
        {
            break; /* Loop/switch isn't completed */
        }
        j1 = i1;
        j = k1;
        if (!s.endsWith("right")) goto _L7; else goto _L8
_L8:
        j1 = i1;
        j = k1;
        if (i1 + k <= appView.getWidth()) goto _L7; else goto _L9
_L9:
        bridge.dispatchMraidError("Close region out of screen", "resize");
        return;
        if (true) goto _L11; else goto _L10
_L10:
    }

    public void runJavaScript(String s)
    {
        alphaView.runJavaScript(s);
    }

    public void show()
    {
        int j = -2;
        logger.debug("show");
        alphaHolder.addView(alphaView, -1, -1);
        Object obj;
        if (slot.getType() == rendererContext.getConstants().SLOT_TYPE_TEMPORAL())
        {
            if (slot.getTimePositionClass() == rendererContext.getConstants().TIME_POSITION_CLASS_OVERLAY())
            {
                android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(width, height);
                layoutparams.gravity = 0;
                String s = bridge.parameters().primaryAnchor;
                Integer integer = bridge.parameters().marginWidth;
                Integer integer1 = bridge.parameters().marginHeight;
                obj = s;
                if (s == null)
                {
                    obj = "bc";
                }
                if (((String) (obj)).contains("t"))
                {
                    layoutparams.gravity = layoutparams.gravity | 0x30;
                    if (integer1 != null)
                    {
                        layoutparams.topMargin = integer1.intValue();
                    }
                }
                if (((String) (obj)).contains("l"))
                {
                    layoutparams.gravity = layoutparams.gravity | 3;
                    if (integer != null)
                    {
                        layoutparams.leftMargin = integer.intValue();
                    }
                }
                if (((String) (obj)).contains("r"))
                {
                    layoutparams.gravity = layoutparams.gravity | 5;
                    if (integer != null)
                    {
                        layoutparams.rightMargin = integer.intValue();
                    }
                }
                if (((String) (obj)).contains("b"))
                {
                    layoutparams.gravity = layoutparams.gravity | 0x50;
                    if (integer1 != null)
                    {
                        layoutparams.bottomMargin = integer1.intValue();
                    }
                }
                if (((String) (obj)).contains("c"))
                {
                    layoutparams.gravity = layoutparams.gravity | 1;
                }
                if (((String) (obj)).contains("m"))
                {
                    layoutparams.gravity = layoutparams.gravity | 0x10;
                }
                if (((String) (obj)).equals("c") || ((String) (obj)).equals("m") || ((String) (obj)).equals("cm") || ((String) (obj)).equals("mc"))
                {
                    layoutparams.gravity = 17;
                }
                logger.debug((new StringBuilder()).append("show, overlay layout width: ").append(width).append(", height: ").append(height).append(" ar:").append(((String) (obj))).append(", marginWidth: ").append(integer).append(", marginHeight: ").append(integer1).toString());
                slot.getBase().setOnHierarchyChangeListener(new android.view.ViewGroup.OnHierarchyChangeListener() {

                    final MRAIDPresentationInLine this$0;

                    public void onChildViewAdded(View view, View view1)
                    {
                        logger.debug("onChildViewAdded");
                        if (alphaHolder != view1)
                        {
                            refresh();
                        }
                    }

                    public void onChildViewRemoved(View view, View view1)
                    {
                        logger.debug("onChildViewRemoved, do nothing");
                    }

            
            {
                this$0 = MRAIDPresentationInLine.this;
                super();
            }
                });
                obj = layoutparams;
            } else
            {
                obj = new android.widget.FrameLayout.LayoutParams(width, height);
                obj.gravity = 17;
            }
        } else
        {
            int i;
            if (width > 0)
            {
                i = width;
            } else
            {
                i = -2;
            }
            if (height > 0)
            {
                j = height;
            }
            obj = new android.widget.RelativeLayout.LayoutParams(i, j);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(13);
        }
        setEnableSync(alphaHolder, false);
        slot.getBase().addView(alphaHolder, ((android.view.ViewGroup.LayoutParams) (obj)));
        alphaHolder.bringToFront();
    }

    static 
    {
        gravityMap = new HashMap();
        gravityMap.put("top-left", Integer.valueOf(51));
        gravityMap.put("top-right", Integer.valueOf(53));
        gravityMap.put("center", Integer.valueOf(17));
        gravityMap.put("bottom-left", Integer.valueOf(83));
        gravityMap.put("bottom-right", Integer.valueOf(85));
        gravityMap.put("top-center", Integer.valueOf(49));
        gravityMap.put("bottom-center", Integer.valueOf(81));
    }


}
