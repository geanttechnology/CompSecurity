// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.playhaven.android.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.playhaven.android.Placement;
import com.playhaven.android.PlacementListener;
import com.playhaven.android.PlayHaven;
import com.playhaven.android.PlayHavenException;
import com.playhaven.android.compat.VendorCompat;
import com.playhaven.android.util.MemoryReporter;

// Referenced classes of package com.playhaven.android.view:
//            FrameManager, PlayHavenListener, ChildView, HTMLView

public class PlayHavenView extends FrameLayout
    implements PlacementListener, FrameManager
{
    public static final class DismissType extends Enum
    {

        private static final DismissType $VALUES[];
        public static final DismissType AppClose;
        public static final DismissType BackButton;
        public static final DismissType Emergency;
        public static final DismissType Launch;
        public static final DismissType NoThanks;
        public static final DismissType OptIn;
        public static final DismissType Purchase;
        public static final DismissType Reward;
        public static final DismissType SelfClose;

        public static DismissType valueOf(String s)
        {
            return (DismissType)Enum.valueOf(com/playhaven/android/view/PlayHavenView$DismissType, s);
        }

        public static DismissType[] values()
        {
            return (DismissType[])$VALUES.clone();
        }

        static 
        {
            Emergency = new DismissType("Emergency", 0);
            NoThanks = new DismissType("NoThanks", 1);
            Launch = new DismissType("Launch", 2);
            SelfClose = new DismissType("SelfClose", 3);
            AppClose = new DismissType("AppClose", 4);
            BackButton = new DismissType("BackButton", 5);
            Reward = new DismissType("Reward", 6);
            Purchase = new DismissType("Purchase", 7);
            OptIn = new DismissType("OptIn", 8);
            $VALUES = (new DismissType[] {
                Emergency, NoThanks, Launch, SelfClose, AppClose, BackButton, Reward, Purchase, OptIn
            });
        }

        private DismissType(String s, int i)
        {
            super(s, i);
        }
    }


    public static final int AUTO_DISPLAY_OPTIONS = 1;
    public static final String BUNDLE_DATA = "data";
    public static final String BUNDLE_DATA_OPTIN = "data.optin";
    public static final String BUNDLE_DATA_PURCHASE = "data.purchase";
    public static final String BUNDLE_DATA_REWARD = "data.reward";
    public static final String BUNDLE_DISMISS_TYPE = "dismissType";
    public static final String BUNDLE_DISPLAY_OPTIONS = "displayOptions";
    public static final String BUNDLE_EXCEPTION = "exception";
    public static final String BUNDLE_PLACEMENT = "placement";
    public static final String BUNDLE_PLACEMENT_TAG = "placementTag";
    public static final int DISPLAY_ANIMATION = 4;
    public static final int DISPLAY_OVERLAY = 2;
    public static final int NO_DISPLAY_OPTIONS = 0;
    private ChildView childView;
    private VendorCompat compat;
    private int displayOptions;
    private FrameManager frameMgr;
    private PlayHavenListener phListener;
    private Placement placement;

    public PlayHavenView(Context context)
    {
        super(context);
        frameMgr = this;
        compat = PlayHaven.getVendorCompat(context);
        createLayers();
    }

    public PlayHavenView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        frameMgr = this;
        compat = PlayHaven.getVendorCompat(context);
        createLayers();
        attributeset = compat.obtainStyledAttributes(context, attributeset, com.playhaven.android.compat.VendorCompat.STYLEABLE.com_playhaven_android_view_PlayHavenView);
        int i = compat.getAttrId(context, com.playhaven.android.compat.VendorCompat.ATTR.com_playhaven_android_view_PlayHavenView_placementTag);
        int j = compat.getAttrId(context, com.playhaven.android.compat.VendorCompat.ATTR.com_playhaven_android_view_PlayHavenView_cuDisplayOptions);
        setPlacementTag(attributeset.getString(i));
        setDisplayOptions(attributeset.getInteger(j, 1));
        attributeset.recycle();
        return;
        context;
        attributeset.recycle();
        throw context;
    }

    private void updateLoading()
    {
        if (placement != null && placement.isLoading())
        {
            setOverlayVisible(isOverlaySet());
            setAnimationVisible(isAnimationSet());
            setExitVisible(true);
        }
    }

    public void contentDismissed(Placement placement1, DismissType dismisstype, Bundle bundle)
    {
        if (phListener != null)
        {
            phListener.viewDismissed(this, dismisstype, bundle);
        }
    }

    public void contentFailed(Placement placement1, PlayHavenException playhavenexception)
    {
        failView(playhavenexception);
    }

    public void contentLoaded(Placement placement1)
    {
        setAnimationVisible(false);
        setOverlayVisible(false);
        post(new _cls5(placement1));
    }

    protected android.view.View.OnClickListener createExitListener()
    {
        return new _cls1();
    }

    protected void createLayers()
    {
        MemoryReporter.report();
        int i = compat.getLayoutId(getContext(), com.playhaven.android.compat.VendorCompat.LAYOUT.playhaven_overlay);
        int j = compat.getLayoutId(getContext(), com.playhaven.android.compat.VendorCompat.LAYOUT.playhaven_loadinganim);
        int k = compat.getLayoutId(getContext(), com.playhaven.android.compat.VendorCompat.LAYOUT.playhaven_exit);
        int l = compat.getId(getContext(), com.playhaven.android.compat.VendorCompat.ID.com_playhaven_android_view_Exit_button);
        if (i <= 0 || j <= 0 || k <= 0 || l <= 0)
        {
            failView(new PlayHavenException("createLayers was unable to locate a resource: %d / %d / %d / %d", new Object[] {
                Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(l)
            }));
            return;
        } else
        {
            setMeasureAllChildren(true);
            Object obj = (LayoutInflater)getContext().getSystemService("layout_inflater");
            Object obj1 = (LinearLayout)((LayoutInflater) (obj)).inflate(i, null);
            ((LinearLayout) (obj1)).setVisibility(8);
            addView(((View) (obj1)));
            obj1 = (RelativeLayout)((LayoutInflater) (obj)).inflate(j, null);
            ((RelativeLayout) (obj1)).setVisibility(8);
            addView(((View) (obj1)));
            addView(new View(getContext()));
            obj = (LinearLayout)((LayoutInflater) (obj)).inflate(k, null);
            ((LinearLayout) (obj)).setVisibility(0);
            ((ImageView)((LinearLayout) (obj)).findViewById(l)).setOnClickListener(createExitListener());
            addView(((View) (obj)));
            return;
        }
    }

    protected void dismissView(DismissType dismisstype)
    {
        if (phListener == null)
        {
            return;
        }
        Bundle bundle = null;
        if (childView != null)
        {
            bundle = childView.generateResponseBundle();
        }
        phListener.viewDismissed(this, dismisstype, bundle);
    }

    protected void failView(PlayHavenException playhavenexception)
    {
        PlayHaven.e(playhavenexception);
        if (phListener != null)
        {
            phListener.viewFailed(this, playhavenexception);
        }
    }

    public int getDisplayOptions()
    {
        return displayOptions;
    }

    public Placement getPlacement()
    {
        return placement;
    }

    public String getPlacementTag()
    {
        if (placement == null)
        {
            return null;
        } else
        {
            return placement.getPlacementTag();
        }
    }

    public PlayHavenListener getPlayHavenListener()
    {
        return phListener;
    }

    public boolean isAnimationSet()
    {
        return (displayOptions | 4) == displayOptions;
    }

    protected boolean isAutoDisplayOptionSet()
    {
        return (displayOptions | 1) == displayOptions;
    }

    public boolean isOverlaySet()
    {
        return (displayOptions | 2) == displayOptions;
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        updateLoading();
    }

    protected void onDetachedFromWindow()
    {
        MemoryReporter.report();
        super.onDetachedFromWindow();
    }

    public void onPause()
    {
        if (android.os.Build.VERSION.SDK_INT > 10 && childView != null)
        {
            ((HTMLView)childView).onPause();
        }
    }

    public void reload()
    {
        setPlacementTag(getPlacementTag());
    }

    protected void setAnimationVisible(boolean flag)
    {
        post(new _cls3(findViewById(compat.getId(getContext(), com.playhaven.android.compat.VendorCompat.ID.com_playhaven_android_view_LoadingAnimation)), flag));
    }

    public void setDisplayOptions(int i)
    {
        displayOptions = i;
        String s;
        String s1;
        if (isAnimationSet())
        {
            s = "animation";
        } else
        {
            s = "";
        }
        if (isOverlaySet())
        {
            s1 = "overlay";
        } else
        {
            s1 = "";
        }
        PlayHaven.v("displayOptions = %d (%s %s)", new Object[] {
            Integer.valueOf(i), s, s1
        });
        updateLoading();
    }

    protected void setExitVisible(boolean flag)
    {
        post(new _cls4(findViewById(compat.getId(getContext(), com.playhaven.android.compat.VendorCompat.ID.com_playhaven_android_view_Exit)), flag));
    }

    protected void setFrameManager(FrameManager framemanager)
    {
        frameMgr = framemanager;
    }

    protected void setOverlayVisible(boolean flag)
    {
        post(new _cls2(findViewById(compat.getId(getContext(), com.playhaven.android.compat.VendorCompat.ID.com_playhaven_android_view_Overlay)), flag));
    }

    public void setPlacement(Placement placement1)
    {
        placement = placement1;
        if (placement1.isLoaded() && placement1.isEmpty())
        {
            placement1.reset();
        }
        placement1.setListener(this);
        if (placement1.isDisplayable())
        {
            if (isAutoDisplayOptionSet())
            {
                setDisplayOptions(0);
            }
            contentLoaded(placement1);
        } else
        {
            if (placement1.isLoading())
            {
                if (isAutoDisplayOptionSet())
                {
                    setDisplayOptions(6);
                }
                updateLoading();
                return;
            }
            if (!placement1.isLoaded())
            {
                if (isAutoDisplayOptionSet())
                {
                    setDisplayOptions(6);
                }
                placement1.preload(getContext());
                return;
            }
        }
    }

    public void setPlacementTag(String s)
    {
        if (s == null)
        {
            return;
        } else
        {
            setPlacement(new Placement(s));
            PlayHaven.d("placementTag = %s", new Object[] {
                s
            });
            return;
        }
    }

    public void setPlayHavenListener(PlayHavenListener playhavenlistener)
    {
        phListener = playhavenlistener;
    }

    public void updateFrame()
    {
    }




/*
    static ChildView access$102(PlayHavenView playhavenview, ChildView childview)
    {
        playhavenview.childView = childview;
        return childview;
    }

*/

    /* member class not found */
    class _cls5 {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls2 {}

}
