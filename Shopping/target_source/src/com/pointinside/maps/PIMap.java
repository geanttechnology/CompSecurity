// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import com.g.a.a.a.c;
import com.pointinside.PIException;
import com.pointinside.analytics.MapAnalyticData;
import com.pointinside.analytics.MapMarkerAnalyticData;
import com.pointinside.internal.ParameterCheck;
import com.pointinside.internal.utils.AndroidUtils;
import com.pointinside.internal.utils.LogUtils;
import com.pointinside.internal.utils.StringUtils;
import com.pointinside.maps.model.CameraPosition;
import com.pointinside.maps.model.FeatureStyle;
import com.pointinside.maps.model.MarkerOptions;
import com.pointinside.maps.model.MinMax;
import com.pointinside.maps.model.PolylineOptions;
import com.pointinside.maps.model.RouteOverlayOptions;
import com.pointinside.maps.model.TextHeadingStyle;
import com.pointinside.model.Venue;
import com.pointinside.model.Zone;
import com.pointinside.nav.Route;
import com.pointinside.nav.RouteDirection;
import com.pointinside.nav.RouteLeg;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.pointinside.maps:
//            PIMGLUtil, UiSettings, MapFeatureSettings, Projection, 
//            MarkerController, Marker, PIMGL, MapUtil, 
//            PIMGLZonePickerEntry, EventTypeHandler, PIMapError, Location, 
//            CameraAnimation, PIMGLCameraAttrs, SetCameraEventTypeHandler, MapView, 
//            PIBitmap, Polyline, RouteOverlay, SetRouteEventTypeHandler, 
//            PIMGLFeatureSet, MapZoneViewAnalyticsRequestor, PIMGLFeatureAttrs, PIMapZoneSelectorStyle, 
//            ZoneSelectorEventTypeHandler, PIMGLContext, PIMGLEventData, MapMarkerAnalyticsRequestor

public class PIMap
{
    public static final class AddMarkerAnimation extends Enum
    {

        private static final AddMarkerAnimation $VALUES[];
        public static final AddMarkerAnimation DROP;
        public static final AddMarkerAnimation FADE;
        public static final AddMarkerAnimation NONE;

        public static AddMarkerAnimation valueOf(String s)
        {
            return (AddMarkerAnimation)Enum.valueOf(com/pointinside/maps/PIMap$AddMarkerAnimation, s);
        }

        public static AddMarkerAnimation[] values()
        {
            return (AddMarkerAnimation[])$VALUES.clone();
        }

        static 
        {
            NONE = new AddMarkerAnimation("NONE", 0);
            DROP = new AddMarkerAnimation("DROP", 1);
            FADE = new AddMarkerAnimation("FADE", 2);
            $VALUES = (new AddMarkerAnimation[] {
                NONE, DROP, FADE
            });
        }

        private AddMarkerAnimation(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class AddRouteAnimation extends Enum
    {

        private static final AddRouteAnimation $VALUES[];
        public static final AddRouteAnimation FADE;
        public static final AddRouteAnimation NONE;

        public static AddRouteAnimation valueOf(String s)
        {
            return (AddRouteAnimation)Enum.valueOf(com/pointinside/maps/PIMap$AddRouteAnimation, s);
        }

        public static AddRouteAnimation[] values()
        {
            return (AddRouteAnimation[])$VALUES.clone();
        }

        static 
        {
            NONE = new AddRouteAnimation("NONE", 0);
            FADE = new AddRouteAnimation("FADE", 1);
            $VALUES = (new AddRouteAnimation[] {
                NONE, FADE
            });
        }

        private AddRouteAnimation(String s, int i)
        {
            super(s, i);
        }
    }

    public static interface CameraCallback
    {

        public abstract void onCameraSet();
    }

    public static final class ClearRouteAnimation extends Enum
    {

        private static final ClearRouteAnimation $VALUES[];
        public static final ClearRouteAnimation FADE;
        public static final ClearRouteAnimation NONE;

        public static ClearRouteAnimation valueOf(String s)
        {
            return (ClearRouteAnimation)Enum.valueOf(com/pointinside/maps/PIMap$ClearRouteAnimation, s);
        }

        public static ClearRouteAnimation[] values()
        {
            return (ClearRouteAnimation[])$VALUES.clone();
        }

        static 
        {
            NONE = new ClearRouteAnimation("NONE", 0);
            FADE = new ClearRouteAnimation("FADE", 1);
            $VALUES = (new ClearRouteAnimation[] {
                NONE, FADE
            });
        }

        private ClearRouteAnimation(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class CompanyBrandLogoMapLocation extends Enum
    {

        private static final CompanyBrandLogoMapLocation $VALUES[];
        public static final CompanyBrandLogoMapLocation BOTTOM_LEFT;
        public static final CompanyBrandLogoMapLocation BOTTOM_RIGHT;
        public static final CompanyBrandLogoMapLocation NONE;
        public static final CompanyBrandLogoMapLocation TOP_LEFT;
        public static final CompanyBrandLogoMapLocation TOP_RIGHT;
        final int id;

        static CompanyBrandLogoMapLocation fromId(int i)
        {
            CompanyBrandLogoMapLocation acompanybrandlogomaplocation[] = values();
            int k = acompanybrandlogomaplocation.length;
            for (int j = 0; j < k; j++)
            {
                CompanyBrandLogoMapLocation companybrandlogomaplocation = acompanybrandlogomaplocation[j];
                if (companybrandlogomaplocation.id == i)
                {
                    return companybrandlogomaplocation;
                }
            }

            return BOTTOM_LEFT;
        }

        public static CompanyBrandLogoMapLocation valueOf(String s)
        {
            return (CompanyBrandLogoMapLocation)Enum.valueOf(com/pointinside/maps/PIMap$CompanyBrandLogoMapLocation, s);
        }

        public static CompanyBrandLogoMapLocation[] values()
        {
            return (CompanyBrandLogoMapLocation[])$VALUES.clone();
        }

        static 
        {
            NONE = new CompanyBrandLogoMapLocation("NONE", 0, 0);
            TOP_LEFT = new CompanyBrandLogoMapLocation("TOP_LEFT", 1, 1);
            TOP_RIGHT = new CompanyBrandLogoMapLocation("TOP_RIGHT", 2, 2);
            BOTTOM_LEFT = new CompanyBrandLogoMapLocation("BOTTOM_LEFT", 3, 3);
            BOTTOM_RIGHT = new CompanyBrandLogoMapLocation("BOTTOM_RIGHT", 4, 4);
            $VALUES = (new CompanyBrandLogoMapLocation[] {
                NONE, TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT
            });
        }

        private CompanyBrandLogoMapLocation(String s, int i, int j)
        {
            super(s, i);
            id = j;
        }
    }

    static final class EventHandlerActions extends Enum
    {

        private static final EventHandlerActions $VALUES[];
        public static final EventHandlerActions HIDE_ZONE_SELECTOR;
        public static final EventHandlerActions LOAD_SVG_LOAD_ZONE;
        public static final EventHandlerActions LOAD_SVG_SET_CAMERA;
        public static final EventHandlerActions POST_CAMERA_SET;
        public static final EventHandlerActions ROUTE_WITH_ANIMATION;
        public static final EventHandlerActions STATIC_ZONE_SELECTOR;
        public static final EventHandlerActions UNKNOWN;
        final int id;

        static EventHandlerActions fromId(int i)
        {
            EventHandlerActions aeventhandleractions[] = values();
            int k = aeventhandleractions.length;
            for (int j = 0; j < k; j++)
            {
                EventHandlerActions eventhandleractions = aeventhandleractions[j];
                if (eventhandleractions.id == i)
                {
                    return eventhandleractions;
                }
            }

            return UNKNOWN;
        }

        public static EventHandlerActions valueOf(String s)
        {
            return (EventHandlerActions)Enum.valueOf(com/pointinside/maps/PIMap$EventHandlerActions, s);
        }

        public static EventHandlerActions[] values()
        {
            return (EventHandlerActions[])$VALUES.clone();
        }

        static 
        {
            UNKNOWN = new EventHandlerActions("UNKNOWN", 0, 0);
            LOAD_SVG_SET_CAMERA = new EventHandlerActions("LOAD_SVG_SET_CAMERA", 1, 1);
            LOAD_SVG_LOAD_ZONE = new EventHandlerActions("LOAD_SVG_LOAD_ZONE", 2, 2);
            POST_CAMERA_SET = new EventHandlerActions("POST_CAMERA_SET", 3, 3);
            STATIC_ZONE_SELECTOR = new EventHandlerActions("STATIC_ZONE_SELECTOR", 4, 4);
            HIDE_ZONE_SELECTOR = new EventHandlerActions("HIDE_ZONE_SELECTOR", 5, 5);
            ROUTE_WITH_ANIMATION = new EventHandlerActions("ROUTE_WITH_ANIMATION", 6, 6);
            $VALUES = (new EventHandlerActions[] {
                UNKNOWN, LOAD_SVG_SET_CAMERA, LOAD_SVG_LOAD_ZONE, POST_CAMERA_SET, STATIC_ZONE_SELECTOR, HIDE_ZONE_SELECTOR, ROUTE_WITH_ANIMATION
            });
        }

        private EventHandlerActions(String s, int i, int j)
        {
            super(s, i);
            id = j;
        }
    }

    public static interface OnCameraChangeListener
    {

        public abstract void onCameraPositionChange(PointF pointf);

        public abstract void onCameraZoomChange(float f);
    }

    public static interface OnMarkerClickListener
    {

        public abstract void onMarkerClick(Marker marker, PointF pointf, PointF pointf1);
    }

    public static interface OnSingleTapListener
    {

        public abstract void onSingleTapEvent(PointF pointf, PointF pointf1);
    }

    public static interface OnZoneChangeListener
    {

        public abstract void onZoneChange(PIMap pimap);
    }

    public static interface OnZoneLoadCallback
    {

        public abstract void postZoneLoad(String s, int i, int j);

        public abstract void preZoneLoad(String s, int i, int j);
    }

    public static interface RouteCallBack
    {

        public abstract void onPostRouteDraw(RouteOverlay routeoverlay);
    }

    public static final class UpdateMarkerAnimation extends Enum
    {

        private static final UpdateMarkerAnimation $VALUES[];
        public static final UpdateMarkerAnimation MOVING_CROSS_FADE;
        public static final UpdateMarkerAnimation NONE;

        public static UpdateMarkerAnimation valueOf(String s)
        {
            return (UpdateMarkerAnimation)Enum.valueOf(com/pointinside/maps/PIMap$UpdateMarkerAnimation, s);
        }

        public static UpdateMarkerAnimation[] values()
        {
            return (UpdateMarkerAnimation[])$VALUES.clone();
        }

        static 
        {
            NONE = new UpdateMarkerAnimation("NONE", 0);
            MOVING_CROSS_FADE = new UpdateMarkerAnimation("MOVING_CROSS_FADE", 1);
            $VALUES = (new UpdateMarkerAnimation[] {
                NONE, MOVING_CROSS_FADE
            });
        }

        private UpdateMarkerAnimation(String s, int i)
        {
            super(s, i);
        }
    }


    private static final int ANALYTICS_SCHEDULE_DELAY = 2;
    private static final String FONT_FAMILY = "Helvetica-Bold";
    private static final String FONT_FILE = "SourceSansPro-Semibold.otf";
    static final float HEADER_TEXT_STYLE_PADDING = 6F;
    static final float HEADER_TEXT_STYLE_SPACING = 0F;
    private static final float LOD_THRESHOLD_METERS_PER_POINT = 0.28125F;
    private static final String LOG_TAG = LogUtils.makeLogTag(com/pointinside/maps/PIMap.getSimpleName());
    private static final int MAX_ZOOM = 8;
    private static final int MIN_ZOOM = 1;
    public static final float ROUTE_FADE_ANIMATION_DURATION = 1F;
    private static final float VIEW_WIDTH_TO_MAP_UNITS_FOR_DOUBLE_TAP_ZOOM_IN = 9.14286F;
    private static final float ZONE_PICKER_LABEL_OUTLINE_WIDTH = 0.039F;
    private static final int ZONE_PICKER_LABEL_TEXT_COLOR = 0xff000000;
    private static final float ZONE_PICKER_LABEL_TEXT_SIZE = 40F;
    private static final String ZONE_SELECTOR_HEADER_ID = "zoneSelector";
    final HashMap mActionRefMap;
    private IntByReference mBlueDot;
    private CameraPosition mCamera;
    private PIMGLCameraAttrs mCameraAttrs;
    private RectF mCameraBounds;
    private CameraCallback mCameraCallback;
    private Venue mCurrentVenue;
    private PIMGLInterface.PIMGLEventHandlerFunc mEventHandlerFunc;
    private EventTypeHandler mEventTypeHandler;
    private IntByReference mFontRef;
    private final Handler mHandler;
    private CountDownLatch mLatch;
    private AtomicInteger mLoadZoneProgressIndex;
    private int mLoadZoneProgressTotal;
    private PIMGLInterface.PIMGLLogFunc mLogFunc;
    private CompanyBrandLogoMapLocation mLogoMapLocation;
    private IntByReference mLogoOverlayRef;
    private MapAnalyticData mMapAnalyticData;
    private final MapFeatureSettings mMapFeatureSettings;
    private final MapView mMapView;
    private Runnable mMarkerAnalyticsRunnable;
    private ScheduledThreadPoolExecutor mMarkerAnalyticsScheduler;
    private final MarkerController mMarkerController;
    private OnCameraChangeListener mOnCameraChangeListener;
    private OnMarkerClickListener mOnMarkerClickListener;
    private OnSingleTapListener mOnSingleTapListener;
    private OnZoneChangeListener mOnZoneChangeListener;
    private OnZoneLoadCallback mOnZoneLoadCallback;
    private final List mPendingAnnnotationAnalyticsData;
    private final PIMGLContext mPimglContext;
    private final List mPolylines;
    private final Projection mProjection;
    private RouteCallBack mRouteCallBack;
    private RouteOverlay mRouteOverlay;
    private boolean mShowZoneSelector;
    private final Map mTextHeadingToStyleMap;
    private MinMax mTiltMinMax;
    private final UiSettings mUiSettings;
    private final Thread mUiThread;
    private boolean mZoneChangeRequested;
    private PIMGLZonePickerEntry.ByReference mZonePickerEntryRef;
    private AtomicBoolean mZoneSelectorInteractive;
    private AtomicBoolean mZoneSelectorVisible;
    private Map mZoneToZoneRefMap;
    final Map mZoneUUIDToZonePickerEntryMap;
    final Map mZoneUUIDToZoneRefMap;
    private MinMax mZoomPercentMinMax;

    PIMap(Context context, AttributeSet attributeset, int i, MapView mapview, PIMGLContext pimglcontext)
    {
        int j;
        mLoadZoneProgressIndex = new AtomicInteger(0);
        mZoneSelectorVisible = new AtomicBoolean(false);
        mZoneSelectorInteractive = new AtomicBoolean(false);
        mHandler = new Handler(Looper.getMainLooper());
        mTextHeadingToStyleMap = PIMGLUtil.getTextHeadingToStyleMap();
        mPendingAnnnotationAnalyticsData = Collections.synchronizedList(new ArrayList());
        mPolylines = new ArrayList();
        mShowZoneSelector = false;
        mZoneChangeRequested = false;
        mZoneUUIDToZoneRefMap = new HashMap();
        mActionRefMap = new HashMap();
        mEventHandlerFunc = new PIMGLInterface.PIMGLEventHandlerFunc() {

            final PIMap this$0;

            public void apply(PIMGLEventData pimgleventdata)
            {
                Object obj;
                obj = pimgleventdata.mUserdata;
                if (obj == null)
                {
                    obj = EventHandlerActions.UNKNOWN;
                } else
                {
                    obj = EventHandlerActions.fromId(((Pointer) (obj)).getInt(0L));
                }
                pimgleventdata.mType;
                JVM INSTR tableswitch 0 15: default 96
            //                           0 96
            //                           1 625
            //                           2 734
            //                           3 809
            //                           4 96
            //                           5 922
            //                           6 883
            //                           7 876
            //                           8 109
            //                           9 590
            //                           10 340
            //                           11 96
            //                           12 466
            //                           13 533
            //                           14 96
            //                           15 385;
                   goto _L1 _L1 _L2 _L3 _L4 _L1 _L5 _L6 _L7 _L8 _L9 _L10 _L1 _L11 _L12 _L1 _L13
_L1:
                return;
_L8:
                pimgleventdata = getZoneFromZoneRef(pimgleventdata.mZone).getUUID();
                mMarkerController.addAnyPendingMarker(pimgleventdata);
                if (mOnZoneLoadCallback != null)
                {
                    mOnZoneLoadCallback.postZoneLoad(pimgleventdata, mLoadZoneProgressIndex.addAndGet(1), mLoadZoneProgressTotal);
                }
                static class _cls5
                {

                    static final int $SwitchMap$com$pointinside$maps$PIMap$CompanyBrandLogoMapLocation[];
                    static final int $SwitchMap$com$pointinside$maps$PIMap$EventHandlerActions[];

                    static 
                    {
                        $SwitchMap$com$pointinside$maps$PIMap$CompanyBrandLogoMapLocation = new int[CompanyBrandLogoMapLocation.values().length];
                        try
                        {
                            $SwitchMap$com$pointinside$maps$PIMap$CompanyBrandLogoMapLocation[CompanyBrandLogoMapLocation.TOP_LEFT.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror8) { }
                        try
                        {
                            $SwitchMap$com$pointinside$maps$PIMap$CompanyBrandLogoMapLocation[CompanyBrandLogoMapLocation.TOP_RIGHT.ordinal()] = 2;
                        }
                        catch (NoSuchFieldError nosuchfielderror7) { }
                        try
                        {
                            $SwitchMap$com$pointinside$maps$PIMap$CompanyBrandLogoMapLocation[CompanyBrandLogoMapLocation.BOTTOM_LEFT.ordinal()] = 3;
                        }
                        catch (NoSuchFieldError nosuchfielderror6) { }
                        try
                        {
                            $SwitchMap$com$pointinside$maps$PIMap$CompanyBrandLogoMapLocation[CompanyBrandLogoMapLocation.BOTTOM_RIGHT.ordinal()] = 4;
                        }
                        catch (NoSuchFieldError nosuchfielderror5) { }
                        $SwitchMap$com$pointinside$maps$PIMap$EventHandlerActions = new int[EventHandlerActions.values().length];
                        try
                        {
                            $SwitchMap$com$pointinside$maps$PIMap$EventHandlerActions[EventHandlerActions.LOAD_SVG_SET_CAMERA.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror4) { }
                        try
                        {
                            $SwitchMap$com$pointinside$maps$PIMap$EventHandlerActions[EventHandlerActions.LOAD_SVG_LOAD_ZONE.ordinal()] = 2;
                        }
                        catch (NoSuchFieldError nosuchfielderror3) { }
                        try
                        {
                            $SwitchMap$com$pointinside$maps$PIMap$EventHandlerActions[EventHandlerActions.STATIC_ZONE_SELECTOR.ordinal()] = 3;
                        }
                        catch (NoSuchFieldError nosuchfielderror2) { }
                        try
                        {
                            $SwitchMap$com$pointinside$maps$PIMap$EventHandlerActions[EventHandlerActions.POST_CAMERA_SET.ordinal()] = 4;
                        }
                        catch (NoSuchFieldError nosuchfielderror1) { }
                        try
                        {
                            $SwitchMap$com$pointinside$maps$PIMap$EventHandlerActions[EventHandlerActions.HIDE_ZONE_SELECTOR.ordinal()] = 5;
                        }
                        catch (NoSuchFieldError nosuchfielderror)
                        {
                            return;
                        }
                    }
                }

                _cls5..SwitchMap.com.pointinside.maps.PIMap.EventHandlerActions[((EventHandlerActions) (obj)).ordinal()];
                JVM INSTR tableswitch 1 2: default 208
            //                           1 219
            //                           2 250;
                   goto _L14 _L15 _L16
_L14:
                mMapView.startTryingToRefreshAccessibility();
                return;
_L15:
                pimgleventdata = (IntByReference)mZoneUUIDToZoneRefMap.get(pimgleventdata);
                mEventTypeHandler.execute(pimgleventdata);
                continue; /* Loop/switch isn't completed */
_L16:
                if (mLatch != null)
                {
                    mLatch.countDown();
                }
                int k = getZones().size();
                if (mEventTypeHandler instanceof SetRouteEventTypeHandler)
                {
                    mEventTypeHandler.execute();
                } else
                if (mZoneUUIDToZoneRefMap.size() == k)
                {
                    mEventTypeHandler.execute();
                }
                if (true) goto _L14; else goto _L10
_L10:
                mZoneSelectorVisible.set(true);
                switch (_cls5..SwitchMap.com.pointinside.maps.PIMap.EventHandlerActions[((EventHandlerActions) (obj)).ordinal()])
                {
                default:
                    return;

                case 3: // '\003'
                    setFocusedZoneDuringAnimatedZoneChange();
                    break;
                }
                return;
_L13:
                mZoneSelectorVisible.set(false);
                mZoneSelectorInteractive.set(false);
                switch (_cls5..SwitchMap.com.pointinside.maps.PIMap.EventHandlerActions[((EventHandlerActions) (obj)).ordinal()])
                {
                default:
                    return;

                case 4: // '\004'
                    break;
                }
                if (mCameraCallback != null)
                {
                    mHandler.postDelayed(new Runnable() {

                        final _cls1 this$1;

                        public void run()
                        {
                            mCameraCallback.onCameraSet();
                            mMapView.startTryingToRefreshAccessibility();
                        }

            
            {
                this$1 = _cls1.this;
                super();
            }
                    }, 240L);
                    return;
                }
                continue; /* Loop/switch isn't completed */
_L11:
                float f;
                Object obj1;
                if (pimgleventdata.mZone != null)
                {
                    pimgleventdata = getZoneFromZoneRef(pimgleventdata.mZone);
                } else
                {
                    pimgleventdata = null;
                }
                obj = PIMap.LOG_TAG;
                obj1 = (new StringBuilder()).append("ZonePickerSelectionChanged ");
                if (pimgleventdata == null)
                {
                    pimgleventdata = "No Zone";
                } else
                {
                    pimgleventdata = pimgleventdata.getName();
                }
                Log.i(((String) (obj)), ((StringBuilder) (obj1)).append(pimgleventdata).toString());
                return;
_L12:
                Log.i(PIMap.LOG_TAG, "ZonePickerSelectionChangedProgramatically");
                if (!mZoneSelectorInteractive.get())
                {
                    pimgleventdata = getZoneFromZoneRef(pimgleventdata.mZone);
                    mCamera = CameraPosition.createWith(pimgleventdata).build();
                    setCameraAfterHighlightZone();
                    return;
                }
                if (true) goto _L1; else goto _L9
_L9:
                pimgleventdata = getZoneFromZoneRef(pimgleventdata.mZone);
                mCamera = CameraPosition.createWith(pimgleventdata).build();
                setCameraAfterHighlightZone();
                return;
_L2:
                switch (_cls5..SwitchMap.com.pointinside.maps.PIMap.EventHandlerActions[((EventHandlerActions) (obj)).ordinal()])
                {
                default:
                    return;

                case 4: // '\004'
                    if (mCameraCallback != null)
                    {
                        mCameraCallback.onCameraSet();
                    }
                    if (mZoneChangeRequested)
                    {
                        if (mOnZoneChangeListener != null)
                        {
                            mOnZoneChangeListener.onZoneChange(PIMap.this);
                        }
                        mZoneChangeRequested = false;
                        return;
                    }
                    break;

                case 5: // '\005'
                    hideZoneSelector(true);
                    return;
                }
                if (true)
                {
                    continue; /* Loop/switch isn't completed */
                }
_L3:
                if (mOnCameraChangeListener != null)
                {
                    pimgleventdata = new PIMGLCameraAttrs();
                    PIMGL.camera_getAttrs(mPimglContext, pimgleventdata);
                    f = mCamera.zone.getImageSizeInMapUnits().x / ((PIMGLCameraAttrs) (pimgleventdata)).scope;
                    mOnCameraChangeListener.onCameraZoomChange(f);
                }
                mMapView.refreshAccessibility();
                return;
_L4:
                if (mOnCameraChangeListener != null)
                {
                    pimgleventdata = new PIMGLCameraAttrs();
                    PIMGL.camera_getAttrs(mPimglContext, pimgleventdata);
                    mOnCameraChangeListener.onCameraPositionChange(new PointF(((PIMGLCameraAttrs) (pimgleventdata)).x, ((PIMGLCameraAttrs) (pimgleventdata)).y));
                }
                mMapView.refreshAccessibility();
                return;
_L7:
                if (obj == EventHandlerActions.ROUTE_WITH_ANIMATION)
                {
                    continue; /* Loop/switch isn't completed */
                }
_L6:
                if (mRouteCallBack != null)
                {
                    mRouteCallBack.onPostRouteDraw(mRouteOverlay);
                    mRouteCallBack = null;
                    return;
                }
                continue; /* Loop/switch isn't completed */
_L5:
                if (pimgleventdata.mTapCount == 1 && mCurrentVenue != null)
                {
                    obj = new PointF(pimgleventdata.mTapX, pimgleventdata.mTapY);
                    obj1 = mProjection.viewToPointInZone(pimgleventdata.mTapX, pimgleventdata.mTapY);
                    LogUtils.logD(PIMap.LOG_TAG, (new StringBuilder()).append("Event InputTap pointInZone: ").append(pimgleventdata.mTapX).append(" ,").append(pimgleventdata.mTapY).append("; pointInView: ").append(((PointF) (obj1)).toString()).toString());
                    if (mOnMarkerClickListener != null)
                    {
                        pimgleventdata = new PointerByReference();
                        if (PIMGL.annotation_pick(mPimglContext, ((PointF) (obj)).x, ((PointF) (obj)).y, pimgleventdata))
                        {
                            pimgleventdata = pimgleventdata.getValue();
                            if (pimgleventdata != null)
                            {
                                pimgleventdata = mMarkerController.getMarker(pimgleventdata);
                                if (pimgleventdata != null)
                                {
                                    mOnMarkerClickListener.onMarkerClick(pimgleventdata, ((PointF) (obj1)), ((PointF) (obj)));
                                    return;
                                }
                            }
                        }
                    }
                    if (mOnSingleTapListener != null)
                    {
                        mOnSingleTapListener.onSingleTapEvent(((PointF) (obj1)), ((PointF) (obj)));
                        return;
                    }
                }
                if (true) goto _L1; else goto _L17
_L17:
            }

            
            {
                this$0 = PIMap.this;
                super();
            }
        };
        mLogFunc = new PIMGLInterface.PIMGLLogFunc() {

            final PIMap this$0;

            public void apply(String s, Pointer pointer, Pointer pointer1)
            {
                if (Log.isLoggable(PIMGL.TAG, 3))
                {
                    pointer1 = new PointerByReference();
                    PIMGL.formatString(s, pointer, pointer1);
                    s = pointer1.getValue();
                    pointer = s.getString(0L);
                    LogUtils.logD(PIMGL.TAG, "PIMGLLog", pointer);
                    PIMGL.freeString(s);
                }
            }

            
            {
                this$0 = PIMap.this;
                super();
            }
        };
        mMarkerAnalyticsRunnable = new Runnable() {

            final PIMap this$0;

            public void run()
            {
                List list = mPendingAnnnotationAnalyticsData;
                list;
                JVM INSTR monitorenter ;
                boolean flag = false;
                if (!mPendingAnnnotationAnalyticsData.isEmpty())
                {
                    LogUtils.logDebugIO((new StringBuilder()).append("Sending marker Analytics: ").append(StringUtils.getDatetimeInString(System.currentTimeMillis())).toString());
                    flag = (new MapMarkerAnalyticsRequestor()).sendAnalyticsInfo(mPendingAnnnotationAnalyticsData);
                }
                if (!flag)
                {
                    break MISSING_BLOCK_LABEL_88;
                }
                mPendingAnnnotationAnalyticsData.clear();
                list;
                JVM INSTR monitorexit ;
                return;
                Exception exception;
                exception;
                list;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                this$0 = PIMap.this;
                super();
            }
        };
        mPimglContext = pimglcontext;
        mMapView = mapview;
        mUiThread = Thread.currentThread();
        mZoneUUIDToZonePickerEntryMap = new HashMap();
        mZoneToZoneRefMap = new HashMap();
        mUiSettings = new UiSettings(pimglcontext);
        mMapFeatureSettings = new MapFeatureSettings(this);
        mProjection = new Projection(this);
        mMarkerController = new MarkerController(this);
        j = CompanyBrandLogoMapLocation.BOTTOM_LEFT.id;
        if (attributeset == null)
        {
            break MISSING_BLOCK_LABEL_286;
        }
        context = context.obtainStyledAttributes(attributeset, com.pointinside.R.styleable.MapView, i, 0);
        j = context.getInt(com.pointinside.R.styleable.MapView_company_logo_map_location, CompanyBrandLogoMapLocation.BOTTOM_LEFT.id);
        context.recycle();
        mLogoMapLocation = CompanyBrandLogoMapLocation.fromId(j);
        mZoomPercentMinMax = new MinMax(1.0F, 8F);
        mTiltMinMax = new MinMax(0.0F, 67.5F);
        context = EventHandlerActions.values();
        j = context.length;
        for (i = 0; i < j; i++)
        {
            attributeset = context[i];
            mActionRefMap.put(attributeset, new IntByReference(((EventHandlerActions) (attributeset)).id));
        }

        break MISSING_BLOCK_LABEL_379;
        attributeset;
        context.recycle();
        throw attributeset;
    }

    private void addInMarkerAnalyticsList(Marker marker, MapMarkerAnalyticData mapmarkeranalyticdata)
    {
        marker = (MapMarkerAnalyticDataInternal.Builder)(new MapMarkerAnalyticDataInternal.Builder()).location(marker.getLocation()).datetime(System.currentTimeMillis());
        if (mapmarkeranalyticdata != null)
        {
            marker.itemId(mapmarkeranalyticdata.itemId).itemType(mapmarkeranalyticdata.itemType).referrer(mapmarkeranalyticdata.referrer).custData(mapmarkeranalyticdata.custData);
        }
        mPendingAnnnotationAnalyticsData.add(marker.build());
    }

    private void clearAll()
    {
        if (Thread.currentThread() != mUiThread)
        {
            throw new IllegalStateException("clearAll can only be called on the UI thread");
        }
        hideZoneSelector(false);
        mMarkerController.clear(this);
        java.util.Map.Entry entry;
        for (Iterator iterator = mZoneUUIDToZoneRefMap.entrySet().iterator(); iterator.hasNext(); PIMGL.zone_delete(mPimglContext, (IntByReference)entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        mZoneUUIDToZoneRefMap.clear();
        mZoneUUIDToZonePickerEntryMap.clear();
        mZoneToZoneRefMap.clear();
        mZonePickerEntryRef = null;
        mCameraCallback = null;
        mLoadZoneProgressIndex.set(0);
        mLoadZoneProgressTotal = 0;
    }

    private void deleteLogoOverlay()
    {
        if (Thread.currentThread() != mUiThread)
        {
            throw new IllegalStateException("deleteLogoOverlay can only be called on the UI thread");
        }
        if (mLogoOverlayRef != null)
        {
            PIMGL.overlay_Delete(mPimglContext, mLogoOverlayRef);
            PIMGL.ref_release(mPimglContext, mLogoOverlayRef);
            mLogoOverlayRef = null;
        }
    }

    private void destroyAnalyticScheduler()
    {
        if (mMarkerAnalyticsScheduler != null)
        {
            mMarkerAnalyticsScheduler.shutdown();
            mMarkerAnalyticsScheduler = null;
        }
    }

    private int getNumOfZonesForCurrentVenue()
    {
        return getZones().size();
    }

    private Zone getZoneFromZoneRef(IntByReference intbyreference)
    {
        if (Thread.currentThread() != mUiThread)
        {
            throw new IllegalStateException("getZoneFromZoneRef can only be called on the UI thread");
        }
        for (Iterator iterator = mZoneToZoneRefMap.entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if (((IntByReference)entry.getValue()).getPointer().equals(intbyreference.getPointer()))
            {
                return (Zone)entry.getKey();
            }
        }

        return null;
    }

    private List getZones()
    {
        return mCurrentVenue.getAllZones();
    }

    private void loadZone(Zone zone, EventHandlerActions eventhandleractions)
    {
        float f;
        float f1;
        String s;
        IntByReference intbyreference;
        if (Thread.currentThread() != mUiThread)
        {
            throw new IllegalStateException("loadZone can only be called on the UI thread");
        }
        String s1 = zone.getUUID();
        if (mOnZoneLoadCallback != null)
        {
            mOnZoneLoadCallback.preZoneLoad(s1, mLoadZoneProgressIndex.get(), mLoadZoneProgressTotal);
        }
        s = MapUtil.getZoneImagePath(zone, getAppContext());
        f = zone.getScaleX();
        f1 = zone.getScaleY();
        intbyreference = ((PIMGLZonePickerEntry)mZoneUUIDToZonePickerEntryMap.get(s1)).mZoneRef;
        PIMGL.zone_create(mPimglContext, intbyreference);
        mZoneUUIDToZoneRefMap.put(s1, intbyreference);
        float f3 = AndroidUtils.getDisplayWidth(getAppContext());
        float f4 = zone.getMetersPerMapUnit().x;
        float f2 = (0.28125F * f3) / f4;
        PIMGL.zone_setLevelOfDetail(mPimglContext, intbyreference, 1, true, true, 0.0F, f2);
        f3 = (3.402823E+38F * f3) / f4;
        PIMGL.zone_setLevelOfDetail(mPimglContext, intbyreference, 2, true, false, f2, f3);
        eventhandleractions = (IntByReference)mActionRefMap.get(eventhandleractions);
        if (!Log.isLoggable("DEBUG_MAP_LOAD", 3)) goto _L2; else goto _L1
_L1:
        try
        {
            zone = new File("/sdcard/pimapslib/Map");
        }
        // Misplaced declaration of an exception variable
        catch (Zone zone)
        {
            zone = s;
            continue; /* Loop/switch isn't completed */
        }
        if (zone == null) goto _L4; else goto _L3
_L3:
        zone = zone.listFiles();
        if (zone == null) goto _L4; else goto _L5
_L5:
        if (zone.length <= 0) goto _L4; else goto _L6
_L6:
        zone = zone[0].getAbsolutePath();
_L8:
        PIMGL.zone_loadSVG(mPimglContext, intbyreference, zone, 1, f, f1, 0.0F, 0.0F, eventhandleractions.getPointer());
        return;
_L4:
        zone = s;
        continue; /* Loop/switch isn't completed */
_L2:
        zone = s;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private void loadZones(final List zones)
    {
        int i = getNumOfZonesForCurrentVenue();
        int j = mZoneUUIDToZoneRefMap.size();
        if (i == j)
        {
            mEventTypeHandler.execute();
            return;
        } else
        {
            mLoadZoneProgressIndex.set(0);
            mLoadZoneProgressTotal = i - j;
            (new Thread(new Runnable() {

                final PIMap this$0;
                final List val$zones;

                public void run()
                {
                    Iterator iterator = zones.iterator();
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            break;
                        }
                        Zone zone = (Zone)iterator.next();
                        if ((IntByReference)mZoneUUIDToZoneRefMap.get(zone.getUUID()) == null)
                        {
                            mLatch = new CountDownLatch(1);
                            mHandler.post(zone. new Runnable() {

                                final _cls4 this$1;
                                final Zone val$zone;

                                public void run()
                                {
                                    loadZone(zone, EventHandlerActions.LOAD_SVG_LOAD_ZONE);
                                }

            
            {
                this$1 = final__pcls4;
                zone = Zone.this;
                super();
            }
                            });
                            try
                            {
                                mLatch.await();
                            }
                            catch (InterruptedException interruptedexception)
                            {
                                interruptedexception.printStackTrace();
                            }
                        }
                    } while (true);
                }

            
            {
                this$0 = PIMap.this;
                zones = list;
                super();
            }
            })).start();
            return;
        }
    }

    private void loadZonesIfRequiredByThisRoute(Route route)
        throws PIMapError
    {
        ArrayList arraylist = new ArrayList();
        for (route = route.getLegs().iterator(); route.hasNext();)
        {
            Iterator iterator = ((RouteLeg)route.next()).getDirections().iterator();
            while (iterator.hasNext()) 
            {
                Object obj = ((RouteDirection)iterator.next()).getLocation();
                if ((IntByReference)mZoneUUIDToZoneRefMap.get(((Location) (obj)).zone) == null)
                {
                    obj = mCurrentVenue.findZoneByUUID(((Location) (obj)).zone);
                    if (obj != null)
                    {
                        arraylist.add(obj);
                    }
                }
            }
        }

        if (!arraylist.isEmpty())
        {
            loadZones(arraylist);
            return;
        } else
        {
            drawRoute();
            return;
        }
    }

    private void resumeAnalyticScheduler()
    {
        if (mMarkerAnalyticsScheduler == null)
        {
            mMarkerAnalyticsScheduler = (ScheduledThreadPoolExecutor)Executors.newScheduledThreadPool(1);
            mMarkerAnalyticsScheduler.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
            mMarkerAnalyticsScheduler.scheduleWithFixedDelay(mMarkerAnalyticsRunnable, 2L, 2L, TimeUnit.SECONDS);
        }
    }

    private void setCamera(CameraPosition cameraposition, MapAnalyticData mapanalyticdata, CameraAnimation cameraanimation, boolean flag, CameraCallback cameracallback)
    {
        if (Thread.currentThread() != mUiThread)
        {
            throw new IllegalStateException("setCamera can only be called on the UI thread");
        }
        mCameraCallback = cameracallback;
        float f;
        if (cameraanimation != CameraAnimation.None)
        {
            f = 0.5F;
        } else
        {
            f = 0.0F;
        }
        setCameraAnimation(cameraposition, f, cameraanimation, flag, mapanalyticdata);
    }

    private void setCamera(CameraPosition cameraposition, MapAnalyticData mapanalyticdata, CameraAnimation cameraanimation, boolean flag, CameraCallback cameracallback, float f)
    {
        if (Thread.currentThread() != mUiThread)
        {
            throw new IllegalStateException("setCamera can only be called on the UI thread");
        } else
        {
            mCameraCallback = cameracallback;
            setCameraAnimation(cameraposition, f, cameraanimation, flag, mapanalyticdata);
            return;
        }
    }

    private void setCameraAfterHighlightZone()
    {
        IntByReference intbyreference = (IntByReference)mZoneUUIDToZoneRefMap.get(mCamera.zone.getUUID());
        PIMGL.zone_select(mPimglContext, intbyreference);
        updateAllBoundsAndZoomPercentMinMaxForZoneRef(intbyreference);
        setCameraAttrsForCamera(EventHandlerActions.HIDE_ZONE_SELECTOR);
    }

    private void setCameraAnimation(CameraPosition cameraposition, float f, CameraAnimation cameraanimation, boolean flag, MapAnalyticData mapanalyticdata)
    {
        CameraPosition cameraposition1 = getCameraPosition();
        if (cameraposition1 != null) goto _L2; else goto _L1
_L1:
        setUpPIMapGL();
_L4:
        float f1;
label0:
        {
            f1 = f;
            if (f != 0.0F)
            {
                break label0;
            }
            if (cameraanimation != CameraAnimation.None)
            {
                f1 = f;
                if (cameraposition1 != null)
                {
                    break label0;
                }
            }
            f1 = 0.0F;
        }
        mCamera = cameraposition;
        cameraposition = mCamera.zone;
        float f2;
        float f3;
        int i;
        if (cameraposition1 == null)
        {
            i = 1;
        } else
        if (!cameraposition1.zone.getUUID().equals(cameraposition.getUUID()))
        {
            i = getZones().size();
            mZoneChangeRequested = true;
            if (flag && i > 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            mShowZoneSelector = flag;
            i = 1;
        } else
        {
            i = 0;
        }
        cameraposition = cameraposition.getImageSizeInMapUnits();
        if (mCamera.pointInZone == null)
        {
            f = ((PointF) (cameraposition)).x / 2.0F;
            f2 = ((PointF) (cameraposition)).y / 2.0F;
        } else
        {
            f = mCamera.pointInZone.x;
            f2 = mCamera.pointInZone.y;
        }
        if (mCamera.visibleMapWidth > 0.0F)
        {
            f3 = mCamera.visibleMapWidth;
        } else
        {
            f3 = ((PointF) (cameraposition)).x;
        }
        mCameraAttrs = new PIMGLCameraAttrs(f, f2, mCamera.rotation, f3, mCamera.tilt, cameraanimation, f1, false);
        mMapAnalyticData = mapanalyticdata;
        if (i != 0)
        {
            cameraposition = (IntByReference)mZoneUUIDToZoneRefMap.get(mCamera.zone.getUUID());
            mEventTypeHandler = new SetCameraEventTypeHandler(this, cameraposition1, mShowZoneSelector);
            if (cameraposition == null)
            {
                mLoadZoneProgressIndex.set(0);
                mLoadZoneProgressTotal = 1;
                loadZone(mCamera.zone, EventHandlerActions.LOAD_SVG_SET_CAMERA);
                return;
            } else
            {
                mEventTypeHandler.execute(cameraposition);
                return;
            }
        } else
        {
            setCameraAttrsForCamera(EventHandlerActions.POST_CAMERA_SET);
            return;
        }
_L2:
        if (MapUtil.isItJustPointInZoneChange(cameraposition, cameraposition1) && f == 0.0F)
        {
            f = MapUtil.computeTraversalDurationForPreviousLocation(this, cameraposition1.pointInZone, cameraposition.pointInZone);
            cameraanimation = CameraAnimation.SoftSmooth;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void setCameraAttrsForCamera(EventHandlerActions eventhandleractions)
    {
        if (Thread.currentThread() != mUiThread)
        {
            throw new IllegalStateException("Non UI thread");
        } else
        {
            eventhandleractions = (IntByReference)mActionRefMap.get(eventhandleractions);
            PIMGL.camera_setAttrs(mPimglContext, mCameraAttrs, mCameraAttrs.animationDuration, mCameraAttrs.animation, mCameraAttrs.force, eventhandleractions.getPointer());
            return;
        }
    }

    private void setFocusedZoneDuringAnimatedZoneChange()
    {
        setZoneSelectorFocusedZone((IntByReference)mZoneUUIDToZoneRefMap.get(mCamera.zone.getUUID()));
    }

    private void setUpForHeaderTextStyle()
    {
        if (Thread.currentThread() != mUiThread)
        {
            throw new IllegalStateException("setUpForHeaderTextStyle can only be called on the UI thread");
        }
        for (Iterator iterator = mTextHeadingToStyleMap.entrySet().iterator(); iterator.hasNext();)
        {
            Object obj = (java.util.Map.Entry)iterator.next();
            TextHeadingStyle textheadingstyle = (TextHeadingStyle)((java.util.Map.Entry) (obj)).getValue();
            String s = textheadingstyle.getFontName();
            obj = (String)((java.util.Map.Entry) (obj)).getKey();
            int i = Integer.valueOf(((String) (obj)).substring(1)).intValue();
            if (!"SourceSansPro-Semibold.otf".equals(s))
            {
                IntByReference intbyreference = new IntByReference();
                PIMGL.ref_create(mPimglContext, new PointerByReference(intbyreference.getPointer()));
                if (PIMGL.font_createWithOutline(mPimglContext, intbyreference, s, ((String) (obj))) == 5)
                {
                    PIMGL.font_createWithOutline(mPimglContext, intbyreference, "SourceSansPro-Semibold.otf", ((String) (obj)));
                }
                PIMGL.setSVGHeaderTextStyle(mPimglContext, i, intbyreference, textheadingstyle);
                PIMGL.ref_release(mPimglContext, intbyreference);
            } else
            {
                PIMGL.font_createWithOutline(mPimglContext, mFontRef, s, ((String) (obj)));
                PIMGL.setSVGHeaderTextStyle(mPimglContext, i, mFontRef, textheadingstyle);
            }
        }

    }

    private void setUpForZonePicker(IntByReference intbyreference)
    {
        if (Thread.currentThread() != mUiThread)
        {
            throw new IllegalStateException("setUpForZonePicker can only be called on the UI thread");
        } else
        {
            PIMGL.zonePicker_showLabel(mPimglContext, true);
            PIMGL.zonePicker_setLabelTextStyle(mPimglContext, intbyreference, MapUtil.getRawTextSize(getAppContext(), 40F), 0.0F, 40F);
            PIMGL.zonePicker_setLabelTextColor(mPimglContext, 0xff000000);
            PIMGL.zonePicker_setLabelOutline(mPimglContext, 1.0F, 1.0F, 1.0F, 0.5F, 0.039F);
            return;
        }
    }

    private void setUpPIMapGL()
    {
        if (Thread.currentThread() != mUiThread)
        {
            throw new IllegalStateException("setUpPIMapGL can only be called on the UI thread");
        } else
        {
            PIMGL.setEnvironmentCacheDir(mPimglContext, getAppContext().getFilesDir().getPath());
            PIMGL.setEventListener(mPimglContext, mEventHandlerFunc);
            PIMGL.setLogFunc(mLogFunc, Pointer.NULL);
            mFontRef = new IntByReference();
            PIMGL.ref_create(mPimglContext, new PointerByReference(mFontRef.getPointer()));
            PIMGL.font_create(mPimglContext, mFontRef, "SourceSansPro-Semibold.otf");
            PIMGL.setSVGFontFamily(mPimglContext, mFontRef, "Helvetica-Bold");
            setUpForHeaderTextStyle();
            setUpForZonePicker(mFontRef);
            PIMGL.ref_release(mPimglContext, mFontRef);
            PIMGL.camera_setTiltBounds(mPimglContext, mTiltMinMax);
            PIMGL.camera_enableTruck(mPimglContext, mUiSettings.isDragToPanEnabled());
            PIMGL.camera_enableDolly(mPimglContext, mUiSettings.isPinchToZoomEnabled());
            PIMGL.camera_enableOrbit(mPimglContext, mUiSettings.isRotateGestureToRotateEnabled());
            PIMGL.camera_enableTilt(mPimglContext, mUiSettings.isVerticalDragToTiltEnabled());
            PIMGL.camera_enableTapZoom(mPimglContext, mUiSettings.isDoubleTapZoomModeEnabled());
            PIMGL.camera_setZoomMode(mPimglContext, mUiSettings.getDoubleTapZoomMode().id);
            PIMGL.camera_setLocMomentumDecay(mPimglContext, 0.89F);
            return;
        }
    }

    private void setZoneSelectorFocusedZone(IntByReference intbyreference)
    {
        if (Thread.currentThread() != mUiThread)
        {
            throw new IllegalStateException("setZoneSelectorForFocusedZone can only be called on the UI thread");
        } else
        {
            IntByReference intbyreference1 = (IntByReference)mActionRefMap.get(EventHandlerActions.STATIC_ZONE_SELECTOR);
            PIMGL.zonePicker_SetHighlightedZone(mPimglContext, intbyreference, true, intbyreference1.getPointer());
            return;
        }
    }

    private void updateAllBoundsAndZoomPercentMinMaxForZoneRef(IntByReference intbyreference)
    {
        if (Thread.currentThread() != mUiThread)
        {
            throw new IllegalStateException("Non UI thread");
        } else
        {
            mCameraBounds = PIMGL.zone_getBounds(mPimglContext, intbyreference);
            PIMGL.camera_setLocBounds(mPimglContext, mCameraBounds);
            setZoomPercentMinMax(mZoomPercentMinMax);
            return;
        }
    }

    public boolean addBlueDot(Location location)
    {
        return addBlueDot(location, 0);
    }

    public boolean addBlueDot(Location location, int i)
    {
        mBlueDot = new IntByReference();
        IntByReference intbyreference = (IntByReference)mZoneUUIDToZoneRefMap.get(mCamera.zone.getUUID());
        PIMGL.blueDotCreate(getPIMGLContext(), mBlueDot, intbyreference, i);
        mBlueDot.getValue();
        mBlueDot = mBlueDot;
        PIMGL.blueDotSetLocation(getPIMGLContext(), mBlueDot, location.x, -location.y);
        PIMGL.blueDotSetRangeRadius(getPIMGLContext(), mBlueDot, 10F);
        return true;
    }

    public final Marker addMarker(MarkerOptions markeroptions, MapMarkerAnalyticData mapmarkeranalyticdata, AddMarkerAnimation addmarkeranimation)
        throws IllegalArgumentException
    {
        if (Thread.currentThread() != mUiThread)
        {
            throw new IllegalStateException("Markers can only be added to a PIMap on the UI thread");
        }
        if (!mMarkerController.isMarkerLocationValid(this, markeroptions.getLocation()))
        {
            throw new IllegalArgumentException("Location object of marker is invalid. Make sure venue uuid of the location is same as the venue which is loaded on the map. Also make sure that zone uuid is not NULL.");
        }
        markeroptions = mMarkerController.addMarker(markeroptions, addmarkeranimation);
        if (markeroptions != null)
        {
            addInMarkerAnalyticsList(markeroptions, mapmarkeranalyticdata);
        }
        return markeroptions;
    }

    void addOrUpdateLogoOverlay()
    {
        int i;
        int j;
        if (Thread.currentThread() != mUiThread)
        {
            throw new IllegalStateException("addOrUpdateLogoOverlay can only be called on the UI thread");
        }
        i = mMapView.getWidth();
        j = mMapView.getHeight();
        if (i != 0 && j != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        deleteLogoOverlay();
        if (mLogoMapLocation == CompanyBrandLogoMapLocation.NONE) goto _L1; else goto _L3
_L3:
        IntByReference intbyreference;
        Object obj;
        Object obj1;
        intbyreference = new IntByReference();
        PIMGL.ref_create(mPimglContext, new PointerByReference(intbyreference.getPointer()));
        Drawable drawable = getAppContext().getResources().getDrawable(com.pointinside.R.drawable.pi_logo);
        obj = new PIBitmap(drawable);
        ((PIBitmap) (obj)).write();
        obj1 = ((PIBitmap) (obj)).getPointer();
        ((PIBitmap) (obj)).read();
        PIMGL.texture_createFromData(mPimglContext, intbyreference, ((Pointer) (obj1)), ((PIBitmap) (obj)).getNativeSize());
        obj = new IntByReference();
        PIMGL.ref_create(mPimglContext, new PointerByReference(((IntByReference) (obj)).getPointer()));
        PIMGL.image_create(mPimglContext, ((IntByReference) (obj)), intbyreference);
        obj1 = new PointF(i / 2, j / 2);
        i = drawable.getIntrinsicWidth();
        j = drawable.getIntrinsicHeight();
        _cls5..SwitchMap.com.pointinside.maps.PIMap.CompanyBrandLogoMapLocation[mLogoMapLocation.ordinal()];
        JVM INSTR tableswitch 1 4: default 248
    //                   1 357
    //                   2 386
    //                   3 420
    //                   4 454;
           goto _L4 _L5 _L6 _L7 _L8
_L4:
        PointF pointf = null;
_L10:
        PIMGL.image_setModelRect(mPimglContext, ((IntByReference) (obj)), -pointf.x, -pointf.y, (float)i - pointf.x, (float)j - pointf.y);
        PIMGL.image_setUVRect(mPimglContext, ((IntByReference) (obj)), 0.0F, 0.0F, 1.0F, 1.0F);
        mLogoOverlayRef = new IntByReference();
        PIMGL.ref_create(mPimglContext, new PointerByReference(mLogoOverlayRef.getPointer()));
        PIMGL.overlay_Create(mPimglContext, mLogoOverlayRef, ((IntByReference) (obj)));
        PIMGL.ref_release(mPimglContext, ((IntByReference) (obj)));
        PIMGL.ref_release(mPimglContext, intbyreference);
        return;
_L5:
        pointf = new PointF(((PointF) (obj1)).x - 5F, ((PointF) (obj1)).y - 5F);
        continue; /* Loop/switch isn't completed */
_L6:
        pointf = new PointF(-((PointF) (obj1)).x + (float)i + 5F, ((PointF) (obj1)).y - 5F);
        continue; /* Loop/switch isn't completed */
_L7:
        pointf = new PointF(((PointF) (obj1)).x - 5F, 5F + (-((PointF) (obj1)).y + (float)j));
        continue; /* Loop/switch isn't completed */
_L8:
        pointf = new PointF(-((PointF) (obj1)).x + (float)i + 5F, 5F + (-((PointF) (obj1)).y + (float)j));
        if (true) goto _L10; else goto _L9
_L9:
    }

    public Polyline addPolyline(PolylineOptions polylineoptions, float f)
        throws IllegalArgumentException
    {
        polylineoptions = new Polyline(this, f, PolylineOptions.copy(polylineoptions));
        mPolylines.add(polylineoptions);
        polylineoptions.update();
        return polylineoptions;
    }

    public void addRoute(RouteOverlayOptions routeoverlayoptions, AddRouteAnimation addrouteanimation, RouteCallBack routecallback)
        throws PIMapError
    {
        removeRoute();
        mRouteCallBack = routecallback;
        mRouteOverlay = new RouteOverlay(mPimglContext, routeoverlayoptions, addrouteanimation);
        mEventTypeHandler = new SetRouteEventTypeHandler(this);
        loadZonesIfRequiredByThisRoute(routeoverlayoptions.getRoute());
    }

    public void animateCamera(CameraPosition cameraposition, MapAnalyticData mapanalyticdata, CameraCallback cameracallback)
    {
        setCamera(cameraposition, mapanalyticdata, CameraAnimation.EaseIn, false, cameracallback);
    }

    public void animateCamera(CameraPosition cameraposition, CameraCallback cameracallback)
    {
        setCamera(cameraposition, null, CameraAnimation.EaseIn, false, cameracallback);
    }

    public void animateCamera(CameraPosition cameraposition, CameraCallback cameracallback, CameraAnimation cameraanimation)
    {
        setCamera(cameraposition, null, cameraanimation, false, cameracallback);
    }

    public void animateCamera(CameraPosition cameraposition, CameraCallback cameracallback, CameraAnimation cameraanimation, float f)
    {
        setCamera(cameraposition, null, cameraanimation, false, cameracallback, f);
    }

    public void animateCameraWithZoneSelector(CameraPosition cameraposition, MapAnalyticData mapanalyticdata, CameraCallback cameracallback)
    {
        setCamera(cameraposition, mapanalyticdata, CameraAnimation.EaseIn, true, cameracallback);
    }

    public void animateCameraWithZoneSelector(CameraPosition cameraposition, CameraCallback cameracallback)
    {
        setCamera(cameraposition, null, CameraAnimation.EaseIn, true, cameracallback);
    }

    public void clearClientProvidedUserHeading()
    {
        if (mBlueDot != null)
        {
            PIMGL.blueDotClearHeading(getPIMGLContext(), mBlueDot);
        }
    }

    void drawRoute()
    {
        mRouteOverlay.draw(this);
    }

    Context getAppContext()
    {
        return mMapView.getContext().getApplicationContext();
    }

    public RectF getCameraBounds()
    {
        return mCameraBounds;
    }

    public CameraPosition getCameraPosition()
    {
        if (Thread.currentThread() != mUiThread)
        {
            throw new IllegalStateException("getCameraPosition can only be called on the UI thread");
        }
        if (mCamera != null)
        {
            PIMGLCameraAttrs pimglcameraattrs = new PIMGLCameraAttrs();
            PIMGL.camera_getAttrs(mPimglContext, pimglcameraattrs);
            return (new com.pointinside.maps.model.CameraPosition.Builder()).zone(mCamera.zone).pointInZone(new PointF(pimglcameraattrs.x, -pimglcameraattrs.y)).rotation(pimglcameraattrs.orbit).tilt(pimglcameraattrs.tilt).visibleMapWidth(pimglcameraattrs.scope).build();
        } else
        {
            return null;
        }
    }

    public com.pointinside.feeds.ZoneImageEntity.ImageType getCurrentImageType()
    {
        return com.pointinside.feeds.ZoneImageEntity.ImageType.DEFAULT4;
    }

    public Venue getCurrentVenue()
    {
        return mCurrentVenue;
    }

    public Zone getCurrentZone()
    {
        return mCamera.zone;
    }

    public RectF getCurrentZoneBounds()
    {
        IntByReference intbyreference = (IntByReference)mZoneUUIDToZoneRefMap.get(mCamera.zone.getUUID());
        if (intbyreference != null)
        {
            return PIMGL.zone_getBounds(mPimglContext, intbyreference);
        } else
        {
            return null;
        }
    }

    public List getFeaturesNearPoint(float f, float f1, boolean flag)
    {
        return getFeaturesNearPointWithFilter(f, f1, null, flag);
    }

    public List getFeaturesNearPointWithFilter(float f, float f1, List list, boolean flag)
    {
        PIMGLFeatureSet.ByReference byreference = (new PIMGLFeatureSet()).newByReference();
        c c1 = new c(0L);
        String as[] = null;
        if (list != null)
        {
            c1 = new c(list.size());
            as = new String[list.size()];
            list.toArray(as);
        }
        if (PIMGL.zone_getFeaturesForPoint(getPIMGLContext(), getZoneRefFromUUID(getCurrentZone().getUUID()), byreference, as, c1, f, -f1, flag))
        {
            list = new ArrayList();
            if (((PIMGLFeatureSet) (byreference)).mSize.intValue() > 0)
            {
                Pointer apointer[] = ((PIMGLFeatureSet) (byreference)).mNames.getPointer().getPointerArray(0L);
                int i = 0;
                while (i < ((PIMGLFeatureSet) (byreference)).mSize.intValue()) 
                {
                    try
                    {
                        list.add(apointer[i].getString(0L));
                    }
                    catch (Exception exception)
                    {
                        exception.printStackTrace();
                    }
                    i++;
                }
            }
        } else
        {
            list = null;
        }
        PIMGL.zone_releaseFeatureSet(getPIMGLContext(), byreference);
        return list;
    }

    public CompanyBrandLogoMapLocation getLogoMapLocation()
    {
        return mLogoMapLocation;
    }

    public MapFeatureSettings getMapFeatureSettings()
    {
        return mMapFeatureSettings;
    }

    PIMGLContext getPIMGLContext()
    {
        return mPimglContext;
    }

    public Projection getProjection()
    {
        return mProjection;
    }

    public TextHeadingStyle getTextHeadingStyle(String s)
    {
        return (TextHeadingStyle)mTextHeadingToStyleMap.get(s);
    }

    public MinMax getTiltMinMax()
    {
        return mTiltMinMax;
    }

    public UiSettings getUiSettings()
    {
        return mUiSettings;
    }

    float getViewHeight()
    {
        return (float)mMapView.getHeight();
    }

    PIMGLZonePickerEntry.ByReference getZonePickerEntryRef()
    {
        return mZonePickerEntryRef;
    }

    IntByReference getZoneRefFromUUID(String s)
    {
        return (IntByReference)mZoneUUIDToZoneRefMap.get(s);
    }

    public boolean getZoneSelectorVisible()
    {
        return mZoneSelectorVisible.get();
    }

    public MinMax getZoomPercentMinMax()
    {
        return mZoomPercentMinMax;
    }

    public void hideZoneSelector(boolean flag)
    {
        if (Thread.currentThread() != mUiThread)
        {
            throw new IllegalStateException("hideZoneSelector can only be called on the UI thread");
        } else
        {
            IntByReference intbyreference = (IntByReference)mActionRefMap.get(EventHandlerActions.POST_CAMERA_SET);
            PIMGL.zonePicker_hide(mPimglContext, flag, intbyreference.getPointer());
            mZoneSelectorVisible.set(false);
            return;
        }
    }

    public void initCamera(Venue venue, CameraPosition cameraposition, MapAnalyticData mapanalyticdata, CameraCallback cameracallback)
    {
        if (Thread.currentThread() != mUiThread)
        {
            throw new IllegalStateException("initCamera can only be called on the UI thread");
        }
        if (mCurrentVenue == null || !mCurrentVenue.getUUID().equals(venue.getUUID()))
        {
            clearAll();
            mCurrentVenue = venue;
            Zone zone;
            IntByReference intbyreference;
            for (venue = getZones().iterator(); venue.hasNext(); mZoneToZoneRefMap.put(zone, intbyreference))
            {
                zone = (Zone)venue.next();
                intbyreference = new IntByReference();
                PIMGLZonePickerEntry pimglzonepickerentry = new PIMGLZonePickerEntry(intbyreference, zone.getName(), intbyreference.getPointer());
                mZoneUUIDToZonePickerEntryMap.put(zone.getUUID(), pimglzonepickerentry);
            }

        }
        moveCamera(cameraposition, mapanalyticdata, cameracallback);
    }

    public boolean moveBlueDot(Location location)
    {
        boolean flag = false;
        if (mBlueDot != null)
        {
            PIMGL.blueDotSetLocation(getPIMGLContext(), mBlueDot, location.x, -location.y);
            flag = true;
        }
        return flag;
    }

    public void moveCamera(CameraPosition cameraposition, MapAnalyticData mapanalyticdata, CameraCallback cameracallback)
    {
        setCamera(cameraposition, mapanalyticdata, CameraAnimation.None, false, cameracallback);
    }

    public void moveCamera(CameraPosition cameraposition, CameraCallback cameracallback)
    {
        setCamera(cameraposition, null, CameraAnimation.None, false, cameracallback);
    }

    void onDestroy()
    {
        clearAll();
        PIMGL.deleteContext(mPimglContext);
        mActionRefMap.clear();
        mEventHandlerFunc = null;
        mLogFunc = null;
    }

    void onDetachedFromWindow()
    {
        destroyAnalyticScheduler();
    }

    void onResume()
    {
        resumeAnalyticScheduler();
        IntByReference intbyreference = new IntByReference();
        PIMGL.countContexts(intbyreference);
        LogUtils.logD(PIMGL.TAG, (new StringBuilder()).append("Context count: ").append(intbyreference.getValue()).toString());
    }

    public void removeBlueDot()
    {
        if (mBlueDot != null)
        {
            PIMGL.blueDotDelete(getPIMGLContext(), mBlueDot);
            mBlueDot = null;
        }
    }

    void removePolyline(Polyline polyline)
    {
        mPolylines.remove(polyline);
    }

    public void removeRoute()
    {
        if (mRouteOverlay != null && !mRouteOverlay.isRemoved)
        {
            mRouteOverlay.remove();
            mRouteOverlay = null;
        }
    }

    void sendMapAnalytics()
    {
        MapAnalyticsDataInternal.Builder builder = new MapAnalyticsDataInternal.Builder();
        builder.zoneUUID(mCamera.zone.getUUID()).venueUUID(mCamera.zone.getVenueUUID()).datetime(System.currentTimeMillis());
        if (mMapAnalyticData != null)
        {
            ((MapAnalyticsDataInternal.Builder)builder.custData(mMapAnalyticData.custData)).referrer(mMapAnalyticData.referrer);
        }
        (new MapZoneViewAnalyticsRequestor()).sendAnalyticsInfo(builder.build());
        mMapAnalyticData = null;
    }

    public boolean setAttributesForFeature(String s, int i, int j, int k, float f, boolean flag)
    {
        Object obj = new FeatureStyle();
        ((FeatureStyle) (obj)).fillColor(i);
        ((FeatureStyle) (obj)).strokeColor(j);
        ((FeatureStyle) (obj)).tintColor(k);
        ((FeatureStyle) (obj)).visibilty(flag);
        obj = new PIMGLFeatureAttrs(((FeatureStyle) (obj)));
        return PIMGLUtil.validate(PIMGL.zone_setFeatureAttrs(getPIMGLContext(), getZoneRefFromUUID(getCurrentZone().getUUID()), s, ((PIMGLFeatureAttrs) (obj)), 0.0F, 0, false, null));
    }

    public boolean setAttributesForFeatureImmediate(String s, int i, int j, int k, float f, boolean flag)
    {
        Object obj = new FeatureStyle();
        ((FeatureStyle) (obj)).fillColor(i);
        ((FeatureStyle) (obj)).strokeColor(j);
        ((FeatureStyle) (obj)).tintColor(k);
        ((FeatureStyle) (obj)).visibilty(flag);
        obj = new PIMGLFeatureAttrs(((FeatureStyle) (obj)));
        return PIMGLUtil.validate(PIMGL.zone_setFeatureAttrsImmediate(getPIMGLContext(), getZoneRefFromUUID(getCurrentZone().getUUID()), s, ((PIMGLFeatureAttrs) (obj))));
    }

    public void setBlueDotRange(float f)
    {
        if (mBlueDot != null)
        {
            PIMGL.blueDotSetRangeRadius(getPIMGLContext(), mBlueDot, f);
        }
    }

    public void setCameraBounds(RectF rectf)
    {
        if (Thread.currentThread() != mUiThread)
        {
            throw new IllegalStateException("setCameraBounds can only be called on the UI thread");
        }
        mCameraBounds = rectf;
        if (mCamera != null)
        {
            PIMGL.camera_setLocBounds(mPimglContext, mCameraBounds);
        }
    }

    public void setClientProvidedUserHeading(float f)
    {
        if (mBlueDot != null)
        {
            PIMGL.blueDotSetHeading(getPIMGLContext(), mBlueDot, f);
        }
    }

    public void setCompanyLogoMapLocation(CompanyBrandLogoMapLocation companybrandlogomaplocation)
    {
        mLogoMapLocation = companybrandlogomaplocation;
        addOrUpdateLogoOverlay();
    }

    public void setImageType(com.pointinside.feeds.ZoneImageEntity.ImageType imagetype)
    {
    }

    public void setOnCameraChangeListener(OnCameraChangeListener oncamerachangelistener)
    {
        mOnCameraChangeListener = oncamerachangelistener;
    }

    public void setOnMarkerClickListener(OnMarkerClickListener onmarkerclicklistener)
    {
        mOnMarkerClickListener = onmarkerclicklistener;
    }

    public void setOnSingleTapListener(OnSingleTapListener onsingletaplistener)
    {
        mOnSingleTapListener = onsingletaplistener;
    }

    public void setOnZoneChangeListener(OnZoneChangeListener onzonechangelistener)
    {
        mOnZoneChangeListener = onzonechangelistener;
    }

    public void setOnZoneLoadCallback(OnZoneLoadCallback onzoneloadcallback)
    {
        mOnZoneLoadCallback = onzoneloadcallback;
    }

    public void setTextHeadingStyle(String s, TextHeadingStyle textheadingstyle)
    {
        if (Thread.currentThread() != mUiThread)
        {
            throw new IllegalStateException("Non UI thread");
        }
        if (s == null || textheadingstyle == null)
        {
            LogUtils.logE(LOG_TAG, "Either heading or style is null. Ignoring the request");
            return;
        } else
        {
            mTextHeadingToStyleMap.put(s, textheadingstyle);
            return;
        }
    }

    public void setTiltMinMax(MinMax minmax)
    {
        if (Thread.currentThread() != mUiThread)
        {
            throw new IllegalStateException("setTiltMinMax can only be called on the UI thread");
        }
        if (minmax.minimum < 0.0F || minmax.maximum > 360F || minmax.minimum > minmax.maximum)
        {
            LogUtils.logE(LOG_TAG, "tiltMinMax attempt to set to a value out of allowed range.");
        }
        mTiltMinMax = minmax;
        if (mCamera != null)
        {
            PIMGL.camera_setTiltBounds(mPimglContext, mTiltMinMax);
        }
    }

    void setZonePickerEntryRef(PIMGLZonePickerEntry.ByReference byreference)
    {
        mZonePickerEntryRef = byreference;
    }

    public void setZoneSelectorStyle(PIMapZoneSelectorStyle pimapzoneselectorstyle)
        throws PIException
    {
        Object obj1 = null;
        if (mMapView != null)
        {
            mMapView.getContext();
            Object obj;
            if (pimapzoneselectorstyle != null)
            {
                if (Float.isNaN(pimapzoneselectorstyle.getLabelsFontSize()) || 0.0F >= pimapzoneselectorstyle.getLabelsFontSize())
                {
                    obj1 = "Invalid Parameter: style";
                    obj = null;
                } else
                if (Float.isNaN(pimapzoneselectorstyle.getLabelsOutlineWidth()) || 0.0F >= pimapzoneselectorstyle.getLabelsOutlineWidth())
                {
                    obj1 = "Invalid Parameter: outlineWidth";
                    obj = null;
                } else
                if (!ParameterCheck.isNullOrEmpty(pimapzoneselectorstyle.getLabelsFontPath()))
                {
                    File file = new File(pimapzoneselectorstyle.getLabelsFontPath());
                    obj = file;
                    if (!file.exists())
                    {
                        obj1 = "Invalid Parameter: fontPath";
                        obj = file;
                    }
                } else
                {
                    obj = null;
                }
            } else
            {
                obj1 = "Invalid Parameter: style cannot be null";
                obj = null;
            }
            if (obj1 == null)
            {
                if (obj != null)
                {
                    obj1 = new IntByReference();
                    PIMGL.ref_create(mPimglContext, new PointerByReference(mFontRef.getPointer()));
                    PIMGL.font_create(mPimglContext, mFontRef, ((File) (obj)).getAbsolutePath());
                    obj = pimapzoneselectorstyle.getLabelsOffset();
                    PIMGL.zonePicker_setLabelTextStyle(mPimglContext, ((IntByReference) (obj1)), pimapzoneselectorstyle.getLabelsFontSize(), ((PointF) (obj)).x, ((PointF) (obj)).y);
                    return;
                }
            } else
            {
                throw new PIException(((String) (obj1)));
            }
        }
    }

    public void setZoomPercentMinMax(MinMax minmax)
    {
        if (Thread.currentThread() != mUiThread)
        {
            throw new IllegalStateException("setZoomPercentMinMax can only be called on the UI thread");
        }
        if (minmax.minimum <= 0.0F || minmax.minimum > minmax.maximum)
        {
            LogUtils.logE(LOG_TAG, "zoomPercentMinMax attempt to set to a value out of allowed range. Willset to default (0,8)");
        } else
        {
            mZoomPercentMinMax = minmax;
        }
        if (mCamera != null)
        {
            minmax = mCamera.zone;
            float f1 = minmax.getImageSizeX();
            float f = f1 / mZoomPercentMinMax.maximum;
            f1 /= mZoomPercentMinMax.minimum;
            PIMGL.camera_setScopeBounds(mPimglContext, f, f1);
            f = AndroidUtils.getDisplayWidth(getAppContext()) / (minmax.getMetersPerMapUnitX() * 9.14286F);
            PIMGL.camera_setTapZoomStops(mPimglContext, f, f1);
        }
    }

    void showZoneOnMap(IntByReference intbyreference)
    {
        PIMGL.zone_select(mPimglContext, intbyreference);
        updateAllBoundsAndZoomPercentMinMaxForZoneRef(intbyreference);
        mZoneChangeRequested = true;
        setCameraAttrsForCamera(EventHandlerActions.POST_CAMERA_SET);
    }

    public void showZoneSelector(Zone zone, boolean flag)
    {
        showZoneSelectorInternal(zone, flag, true);
    }

    void showZoneSelectorInternal(Zone zone, boolean flag, boolean flag1)
    {
        if (Thread.currentThread() != mUiThread)
        {
            throw new IllegalStateException("showZoneSelectorInternal can only be called on the UI thread");
        }
        List list = mCurrentVenue.getAllZones();
        if (list.size() < 2)
        {
            throw new IllegalArgumentException("At least two zones needed to show zone selector");
        } else
        {
            mEventTypeHandler = new ZoneSelectorEventTypeHandler(this, list, zone, flag, flag1);
            mZoneSelectorInteractive.set(flag1);
            loadZones(getZones());
            return;
        }
    }











/*
    static CameraPosition access$1502(PIMap pimap, CameraPosition cameraposition)
    {
        pimap.mCamera = cameraposition;
        return cameraposition;
    }

*/




/*
    static boolean access$1702(PIMap pimap, boolean flag)
    {
        pimap.mZoneChangeRequested = flag;
        return flag;
    }

*/







/*
    static RouteCallBack access$2102(PIMap pimap, RouteCallBack routecallback)
    {
        pimap.mRouteCallBack = routecallback;
        return routecallback;
    }

*/













/*
    static CountDownLatch access$602(PIMap pimap, CountDownLatch countdownlatch)
    {
        pimap.mLatch = countdownlatch;
        return countdownlatch;
    }

*/



}
