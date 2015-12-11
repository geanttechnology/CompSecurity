// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.amazon.geo.mapsv2.internal.IMapOptionsPrimitive;
import com.amazon.geo.mapsv2.model.CameraPosition;
import com.amazon.geo.mapsv2.model.LatLng;
import com.amazon.geo.mapsv2.model.internal.ICameraPositionPrimitive;
import com.amazon.geo.mapsv2.model.pvt.Primitives;
import com.amazon.geo.mapsv2.pvt.PrimitiveBase;
import com.amazon.geo.mapsv2.pvt.SafeParcelable;
import java.lang.reflect.Field;

// Referenced classes of package com.amazon.geo.mapsv2:
//            AmazonMapOptionsCreator

public final class AmazonMapOptions
    implements SafeParcelable
{
    private static class MapAttributeIds
    {

        public final int cameraBearing = 1;
        public final int cameraTargetLat = 2;
        public final int cameraTargetLng = 3;
        public final int cameraTilt = 4;
        public final int cameraZoom = 5;
        public final int compassEnabled = 7;
        public final int liteMode = 6;
        public final int mapAttrs[];
        public final int mapType = 0;
        public final int rotateGesturesEnabled = 8;
        public final int scrollGesturesEnabled = 9;
        public final int tiltGesturesEnabled = 10;
        public final int uiMapToolbar = 15;
        public final int useViewLifecycle = 13;
        public final int zOrderOnTop = 14;
        public final int zoomControlsEnabled = 11;
        public final int zoomGesturesEnabled = 12;

        public MapAttributeIds(int ai[])
        {
            mapAttrs = ai;
        }
    }

    private static class MapAttributeInternalIds
    {

        public final int alignCompassBottom = 2;
        public final int alignCompassLeft = 1;
        public final int alignCompassRight = 3;
        public final int alignCompassTop = 0;
        public final int alignLocatorBottom = 7;
        public final int alignLocatorLeft = 6;
        public final int alignLocatorRight = 8;
        public final int alignLocatorTop = 5;
        public final int compassDrawable = 4;
        public final int locatorDrawable = 9;
        public final int mapAttrs[];
        public final int restrictCamera = 11;
        public final int restrictCameraBounds = 12;
        public final int tileReplacer = 10;

        public MapAttributeInternalIds(int ai[])
        {
            mapAttrs = ai;
        }
    }

    class MapOptionsPrimitive extends PrimitiveBase
        implements IMapOptionsPrimitive
    {

        final AmazonMapOptions this$0;

        public Boolean getAlignCompassBottom()
        {
            return ((AmazonMapOptions)get()).getAlignCompassBottom();
        }

        public Boolean getAlignCompassLeft()
        {
            return ((AmazonMapOptions)get()).getAlignCompassLeft();
        }

        public Boolean getAlignCompassRight()
        {
            return ((AmazonMapOptions)get()).getAlignCompassRight();
        }

        public Boolean getAlignCompassTop()
        {
            return ((AmazonMapOptions)get()).getAlignCompassTop();
        }

        public Boolean getAlignLocatorBottom()
        {
            return ((AmazonMapOptions)get()).getAlignLocatorBottom();
        }

        public Boolean getAlignLocatorLeft()
        {
            return ((AmazonMapOptions)get()).getAlignLocatorLeft();
        }

        public Boolean getAlignLocatorRight()
        {
            return ((AmazonMapOptions)get()).getAlignLocatorRight();
        }

        public Boolean getAlignLocatorTop()
        {
            return ((AmazonMapOptions)get()).getAlignLocatorTop();
        }

        public ICameraPositionPrimitive getCamera()
        {
            return Primitives.create(((AmazonMapOptions)get()).getCamera());
        }

        public Integer getCompassDrawable()
        {
            return ((AmazonMapOptions)get()).getCompassDrawable();
        }

        public Boolean getCompassEnabled()
        {
            return ((AmazonMapOptions)get()).getCompassEnabled();
        }

        public Boolean getLiteMode()
        {
            return ((AmazonMapOptions)get()).getLiteMode();
        }

        public Integer getLocatorDrawable()
        {
            return ((AmazonMapOptions)get()).getLocatorDrawable();
        }

        public Boolean getMapToolbarEnabled()
        {
            return ((AmazonMapOptions)get()).getMapToolbarEnabled();
        }

        public int getMapType()
        {
            return ((AmazonMapOptions)get()).getMapType();
        }

        public Boolean getRestrictCamera()
        {
            return ((AmazonMapOptions)get()).getRestrictCamera();
        }

        public String getRestrictCameraBounds()
        {
            return ((AmazonMapOptions)get()).getRestrictCameraBounds();
        }

        public Boolean getRotateGesturesEnabled()
        {
            return ((AmazonMapOptions)get()).getRotateGesturesEnabled();
        }

        public Boolean getScrollGesturesEnabled()
        {
            return ((AmazonMapOptions)get()).getScrollGesturesEnabled();
        }

        public Boolean getTileReplacer()
        {
            return ((AmazonMapOptions)get()).getTileReplacer();
        }

        public Boolean getTiltGesturesEnabled()
        {
            return ((AmazonMapOptions)get()).getTiltGesturesEnabled();
        }

        public Boolean getUseViewLifecycleInFragment()
        {
            return ((AmazonMapOptions)get()).getUseViewLifecycleInFragment();
        }

        public Boolean getZOrderOnTop()
        {
            return ((AmazonMapOptions)get()).getZOrderOnTop();
        }

        public Boolean getZoomControlsEnabled()
        {
            return ((AmazonMapOptions)get()).getZoomControlsEnabled();
        }

        public Boolean getZoomGesturesEnabled()
        {
            return ((AmazonMapOptions)get()).getZoomGesturesEnabled();
        }

        MapOptionsPrimitive()
        {
            this$0 = AmazonMapOptions.this;
            super(AmazonMapOptions.this);
        }
    }


    public static final AmazonMapOptionsCreator CREATOR = new AmazonMapOptionsCreator();
    private static MapAttributeIds mapAttributeIds = null;
    private static MapAttributeInternalIds mapAttributeInternalIds = null;
    private Boolean mAlignCompassBottom;
    private Boolean mAlignCompassLeft;
    private Boolean mAlignCompassRight;
    private Boolean mAlignCompassTop;
    private Boolean mAlignLocatorBottom;
    private Boolean mAlignLocatorLeft;
    private Boolean mAlignLocatorRight;
    private Boolean mAlignLocatorTop;
    private CameraPosition mCamera;
    private Integer mCompassDrawable;
    private Boolean mCompassEnabled;
    private Boolean mLiteMode;
    private Integer mLocatorDrawable;
    private Boolean mMapToolbarEnabled;
    private int mMapType;
    private Boolean mRestrictCamera;
    private String mRestrictCameraBounds;
    private Boolean mRotateGesturesEnabled;
    private Boolean mScrollGesturesEnabled;
    private Boolean mTileReplacer;
    private Boolean mTiltGesturesEnabled;
    private Boolean mUseViewLifecycleInFragment;
    private Boolean mZOrderOnTop;
    private Boolean mZoomControlsEnabled;
    private Boolean mZoomGesturesEnabled;

    public AmazonMapOptions()
    {
        mMapType = -1;
        mCamera = null;
        mLiteMode = null;
        mCompassEnabled = null;
        mRotateGesturesEnabled = null;
        mScrollGesturesEnabled = null;
        mTiltGesturesEnabled = null;
        mUseViewLifecycleInFragment = null;
        mZOrderOnTop = null;
        mZoomControlsEnabled = null;
        mZoomGesturesEnabled = null;
        mMapToolbarEnabled = null;
        mAlignCompassTop = null;
        mAlignCompassBottom = null;
        mAlignCompassLeft = null;
        mAlignCompassRight = null;
        mCompassDrawable = null;
        mAlignLocatorLeft = null;
        mAlignLocatorTop = null;
        mAlignLocatorBottom = null;
        mAlignLocatorRight = null;
        mLocatorDrawable = null;
        mTileReplacer = null;
        mRestrictCamera = null;
        mRestrictCameraBounds = null;
    }

    public static AmazonMapOptions createFromAttributes(Context context, AttributeSet attributeset)
    {
        if (attributeset != null) goto _L2; else goto _L1
_L1:
        context = null;
_L7:
        return context;
_L2:
        TypedArray typedarray;
        Object obj;
        createMapAttributeIds(context);
        typedarray = null;
        if (mapAttributeIds != null)
        {
            typedarray = context.getTheme().obtainStyledAttributes(attributeset, mapAttributeIds.mapAttrs, 0, 0);
        }
        obj = null;
        if (mapAttributeInternalIds != null)
        {
            obj = context.getTheme().obtainStyledAttributes(attributeset, mapAttributeInternalIds.mapAttrs, 0, 0);
        }
        attributeset = new AmazonMapOptions();
        if (typedarray == null)
        {
            break MISSING_BLOCK_LABEL_839;
        }
        if (!typedarray.hasValue(mapAttributeIds.cameraTargetLat) && !typedarray.hasValue(mapAttributeIds.cameraTargetLng) && !typedarray.hasValue(mapAttributeIds.cameraZoom) && !typedarray.hasValue(mapAttributeIds.cameraTilt) && !typedarray.hasValue(mapAttributeIds.cameraBearing))
        {
            break MISSING_BLOCK_LABEL_839;
        }
        context = new CameraPosition(new LatLng(typedarray.getFloat(mapAttributeIds.cameraTargetLat, 0.0F), typedarray.getFloat(mapAttributeIds.cameraTargetLng, 0.0F)), typedarray.getFloat(mapAttributeIds.cameraZoom, 0.0F), typedarray.getFloat(mapAttributeIds.cameraTilt, 0.0F), typedarray.getFloat(mapAttributeIds.cameraBearing, 0.0F));
_L8:
        attributeset.camera(context);
        if (mapAttributeIds == null) goto _L4; else goto _L3
_L3:
        Object obj1;
        Boolean boolean1;
        Boolean boolean2;
        Object obj2;
        Boolean boolean3;
        Boolean boolean4;
        Boolean boolean5;
        Boolean boolean6;
        Object obj3;
        Boolean boolean7;
        context = readBooleanAttribute(typedarray, mapAttributeIds.compassEnabled);
        obj1 = readIntegerAttribute(typedarray, mapAttributeIds.mapType);
        boolean1 = readBooleanAttribute(typedarray, mapAttributeIds.liteMode);
        boolean2 = readBooleanAttribute(typedarray, mapAttributeIds.rotateGesturesEnabled);
        obj2 = readBooleanAttribute(typedarray, mapAttributeIds.scrollGesturesEnabled);
        boolean3 = readBooleanAttribute(typedarray, mapAttributeIds.tiltGesturesEnabled);
        boolean4 = readBooleanAttribute(typedarray, mapAttributeIds.useViewLifecycle);
        boolean5 = readBooleanAttribute(typedarray, mapAttributeIds.zOrderOnTop);
        boolean6 = readBooleanAttribute(typedarray, mapAttributeIds.zoomControlsEnabled);
        obj3 = readBooleanAttribute(typedarray, mapAttributeIds.zoomGesturesEnabled);
        boolean7 = readBooleanAttribute(typedarray, mapAttributeIds.uiMapToolbar);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_369;
        }
        attributeset.mapType(((Integer) (obj1)).intValue());
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_382;
        }
        attributeset.compassEnabled(context.booleanValue());
        if (boolean2 == null)
        {
            break MISSING_BLOCK_LABEL_397;
        }
        attributeset.rotateGesturesEnabled(boolean2.booleanValue());
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_412;
        }
        attributeset.scrollGesturesEnabled(((Boolean) (obj2)).booleanValue());
        if (boolean3 == null)
        {
            break MISSING_BLOCK_LABEL_427;
        }
        attributeset.tiltGesturesEnabled(boolean3.booleanValue());
        if (boolean4 == null)
        {
            break MISSING_BLOCK_LABEL_442;
        }
        attributeset.useViewLifecycleInFragment(boolean4.booleanValue());
        if (boolean5 == null)
        {
            break MISSING_BLOCK_LABEL_457;
        }
        attributeset.zOrderOnTop(boolean5.booleanValue());
        if (boolean6 == null)
        {
            break MISSING_BLOCK_LABEL_472;
        }
        attributeset.zoomControlsEnabled(boolean6.booleanValue());
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_487;
        }
        attributeset.zoomGesturesEnabled(((Boolean) (obj3)).booleanValue());
        if (boolean1 == null)
        {
            break MISSING_BLOCK_LABEL_502;
        }
        attributeset.liteMode(boolean1.booleanValue());
        if (boolean7 == null) goto _L4; else goto _L5
_L5:
        attributeset.mapToolbarEnabled(boolean7.booleanValue());
_L4:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_827;
        }
        Boolean boolean8;
        context = readBooleanAttribute(((TypedArray) (obj)), mapAttributeInternalIds.alignCompassTop);
        obj1 = readBooleanAttribute(((TypedArray) (obj)), mapAttributeInternalIds.alignCompassBottom);
        boolean1 = readBooleanAttribute(((TypedArray) (obj)), mapAttributeInternalIds.alignCompassLeft);
        boolean2 = readBooleanAttribute(((TypedArray) (obj)), mapAttributeInternalIds.alignCompassRight);
        obj2 = readDrawableAttribute(((TypedArray) (obj)), mapAttributeInternalIds.compassDrawable);
        boolean3 = readBooleanAttribute(((TypedArray) (obj)), mapAttributeInternalIds.alignLocatorTop);
        boolean4 = readBooleanAttribute(((TypedArray) (obj)), mapAttributeInternalIds.alignLocatorBottom);
        boolean5 = readBooleanAttribute(((TypedArray) (obj)), mapAttributeInternalIds.alignLocatorLeft);
        boolean6 = readBooleanAttribute(((TypedArray) (obj)), mapAttributeInternalIds.alignLocatorRight);
        obj3 = readDrawableAttribute(((TypedArray) (obj)), mapAttributeInternalIds.locatorDrawable);
        boolean7 = readBooleanAttribute(((TypedArray) (obj)), mapAttributeInternalIds.tileReplacer);
        boolean8 = readBooleanAttribute(((TypedArray) (obj)), mapAttributeInternalIds.restrictCamera);
        obj = readStringAttribute(((TypedArray) (obj)), mapAttributeInternalIds.restrictCameraBounds);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_685;
        }
        attributeset.alignCompassTop(context);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_697;
        }
        attributeset.alignCompassBottom(((Boolean) (obj1)));
        if (boolean1 == null)
        {
            break MISSING_BLOCK_LABEL_709;
        }
        attributeset.alignCompassLeft(boolean1);
        if (boolean2 == null)
        {
            break MISSING_BLOCK_LABEL_721;
        }
        attributeset.alignCompassRight(boolean2);
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_733;
        }
        attributeset.compassDrawable(((Integer) (obj2)));
        if (boolean3 == null)
        {
            break MISSING_BLOCK_LABEL_745;
        }
        attributeset.alignLocatorTop(boolean3);
        if (boolean4 == null)
        {
            break MISSING_BLOCK_LABEL_757;
        }
        attributeset.alignLocatorBottom(boolean4);
        if (boolean5 == null)
        {
            break MISSING_BLOCK_LABEL_769;
        }
        attributeset.alignLocatorLeft(boolean5);
        if (boolean6 == null)
        {
            break MISSING_BLOCK_LABEL_781;
        }
        attributeset.alignLocatorRight(boolean6);
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_793;
        }
        attributeset.locatorDrawable(((Integer) (obj3)));
        if (boolean7 == null)
        {
            break MISSING_BLOCK_LABEL_805;
        }
        attributeset.tileReplacer(boolean7);
        if (boolean8 == null)
        {
            break MISSING_BLOCK_LABEL_817;
        }
        attributeset.restrictCamera(boolean8);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_827;
        }
        attributeset.restrictCameraBounds(((String) (obj)));
        context = attributeset;
        if (typedarray == null) goto _L7; else goto _L6
_L6:
        typedarray.recycle();
        return attributeset;
        context = new CameraPosition(new LatLng(0.0D, 0.0D), 0.0F, 0.0F, 0.0F);
          goto _L8
        context;
        if (typedarray != null)
        {
            typedarray.recycle();
        }
        throw context;
    }

    private static void createMapAttributeIds(Context context)
    {
        if (mapAttributeIds == null)
        {
            boolean flag = com/amazon/geo/mapsv2/AmazonMapOptions.getSimpleName().startsWith("Amazon");
            String s;
            Object obj;
            if (flag)
            {
                s = "AmznMapAttrs";
            } else
            {
                s = "MapAttrs";
            }
            obj = null;
            try
            {
                context = Class.forName((new StringBuilder()).append(context.getPackageName()).append(".R$styleable").toString(), false, context.getClassLoader());
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                context = ((Context) (obj));
            }
            if (context != null)
            {
                try
                {
                    mapAttributeInternalIds = new MapAttributeInternalIds((int[])(int[])context.getField("AmznMapAttrsInternal").get(null));
                }
                // Misplaced declaration of an exception variable
                catch (Object obj) { }
                // Misplaced declaration of an exception variable
                catch (Object obj) { }
                // Misplaced declaration of an exception variable
                catch (Object obj) { }
                try
                {
                    mapAttributeIds = new MapAttributeIds((int[])(int[])context.getField(s).get(null));
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    throw new IllegalStateException((new StringBuilder()).append("Can't find styleable field ").append(s).toString(), context);
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    throw new IllegalStateException((new StringBuilder()).append("Can't find styleable field ").append(s).toString(), context);
                }
                catch (NoSuchFieldException nosuchfieldexception) { }
                if (flag)
                {
                    try
                    {
                        context = (int[])(int[])context.getField("MapAttrs").get(null);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Context context)
                    {
                        throw new IllegalStateException((new StringBuilder()).append("Can't find styleable field ").append("MapAttrs").toString(), context);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Context context)
                    {
                        throw new IllegalStateException((new StringBuilder()).append("Can't find styleable field ").append("MapAttrs").toString(), context);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Context context)
                    {
                        throw new IllegalStateException((new StringBuilder()).append("Can't find styleable field ").append("MapAttrs").toString(), context);
                    }
                    mapAttributeIds = new MapAttributeIds(context);
                    return;
                }
            }
        }
    }

    private static Boolean readBooleanAttribute(TypedArray typedarray, int i)
    {
        if (typedarray != null && typedarray.hasValue(i))
        {
            return Boolean.valueOf(typedarray.getBoolean(i, false));
        } else
        {
            return null;
        }
    }

    private static Integer readDrawableAttribute(TypedArray typedarray, int i)
    {
        if (typedarray != null && typedarray.hasValue(i))
        {
            return Integer.valueOf(typedarray.getResourceId(i, 0));
        } else
        {
            return null;
        }
    }

    private static Integer readIntegerAttribute(TypedArray typedarray, int i)
    {
        if (typedarray != null && typedarray.hasValue(i))
        {
            return Integer.valueOf(typedarray.getInt(i, -1));
        } else
        {
            return null;
        }
    }

    private static String readStringAttribute(TypedArray typedarray, int i)
    {
        if (typedarray != null && typedarray.hasValue(i))
        {
            return typedarray.getString(i);
        } else
        {
            return null;
        }
    }

    AmazonMapOptions alignCompassBottom(Boolean boolean1)
    {
        mAlignCompassBottom = boolean1;
        return this;
    }

    AmazonMapOptions alignCompassLeft(Boolean boolean1)
    {
        mAlignCompassLeft = boolean1;
        return this;
    }

    AmazonMapOptions alignCompassRight(Boolean boolean1)
    {
        mAlignCompassRight = boolean1;
        return this;
    }

    AmazonMapOptions alignCompassTop(Boolean boolean1)
    {
        mAlignCompassTop = boolean1;
        return this;
    }

    AmazonMapOptions alignLocatorBottom(Boolean boolean1)
    {
        mAlignLocatorBottom = boolean1;
        return this;
    }

    AmazonMapOptions alignLocatorLeft(Boolean boolean1)
    {
        mAlignLocatorLeft = boolean1;
        return this;
    }

    AmazonMapOptions alignLocatorRight(Boolean boolean1)
    {
        mAlignLocatorRight = boolean1;
        return this;
    }

    AmazonMapOptions alignLocatorTop(Boolean boolean1)
    {
        mAlignLocatorTop = boolean1;
        return this;
    }

    public AmazonMapOptions camera(CameraPosition cameraposition)
    {
        mCamera = cameraposition;
        return this;
    }

    AmazonMapOptions compassDrawable(Integer integer)
    {
        mCompassDrawable = integer;
        return this;
    }

    public AmazonMapOptions compassEnabled(boolean flag)
    {
        mCompassEnabled = Boolean.valueOf(flag);
        return this;
    }

    IMapOptionsPrimitive createMapOptionsPrimitive()
    {
        return new MapOptionsPrimitive();
    }

    public int describeContents()
    {
        return 0;
    }

    Boolean getAlignCompassBottom()
    {
        return mAlignCompassBottom;
    }

    Boolean getAlignCompassLeft()
    {
        return mAlignCompassLeft;
    }

    Boolean getAlignCompassRight()
    {
        return mAlignCompassRight;
    }

    Boolean getAlignCompassTop()
    {
        return mAlignCompassTop;
    }

    Boolean getAlignLocatorBottom()
    {
        return mAlignLocatorBottom;
    }

    Boolean getAlignLocatorLeft()
    {
        return mAlignLocatorLeft;
    }

    Boolean getAlignLocatorRight()
    {
        return mAlignLocatorRight;
    }

    Boolean getAlignLocatorTop()
    {
        return mAlignLocatorTop;
    }

    public CameraPosition getCamera()
    {
        return mCamera;
    }

    Integer getCompassDrawable()
    {
        return mCompassDrawable;
    }

    public Boolean getCompassEnabled()
    {
        return mCompassEnabled;
    }

    public Boolean getLiteMode()
    {
        return mLiteMode;
    }

    Integer getLocatorDrawable()
    {
        return mLocatorDrawable;
    }

    public Boolean getMapToolbarEnabled()
    {
        return mMapToolbarEnabled;
    }

    public int getMapType()
    {
        return mMapType;
    }

    Boolean getRestrictCamera()
    {
        return mRestrictCamera;
    }

    String getRestrictCameraBounds()
    {
        return mRestrictCameraBounds;
    }

    public Boolean getRotateGesturesEnabled()
    {
        return mRotateGesturesEnabled;
    }

    public Boolean getScrollGesturesEnabled()
    {
        return mScrollGesturesEnabled;
    }

    Boolean getTileReplacer()
    {
        return mTileReplacer;
    }

    public Boolean getTiltGesturesEnabled()
    {
        return mTiltGesturesEnabled;
    }

    public Boolean getUseViewLifecycleInFragment()
    {
        return mUseViewLifecycleInFragment;
    }

    public Boolean getZOrderOnTop()
    {
        return mZOrderOnTop;
    }

    public Boolean getZoomControlsEnabled()
    {
        return mZoomControlsEnabled;
    }

    public Boolean getZoomGesturesEnabled()
    {
        return mZoomGesturesEnabled;
    }

    public AmazonMapOptions liteMode(boolean flag)
    {
        mLiteMode = Boolean.valueOf(flag);
        return this;
    }

    AmazonMapOptions locatorDrawable(Integer integer)
    {
        mLocatorDrawable = integer;
        return this;
    }

    public AmazonMapOptions mapToolbarEnabled(boolean flag)
    {
        mMapToolbarEnabled = Boolean.valueOf(flag);
        return this;
    }

    public AmazonMapOptions mapType(int i)
    {
        mMapType = i;
        return this;
    }

    AmazonMapOptions restrictCamera(Boolean boolean1)
    {
        mRestrictCamera = boolean1;
        return this;
    }

    AmazonMapOptions restrictCameraBounds(String s)
    {
        mRestrictCameraBounds = s;
        return this;
    }

    public AmazonMapOptions rotateGesturesEnabled(boolean flag)
    {
        mRotateGesturesEnabled = Boolean.valueOf(flag);
        return this;
    }

    public AmazonMapOptions scrollGesturesEnabled(boolean flag)
    {
        mScrollGesturesEnabled = Boolean.valueOf(flag);
        return this;
    }

    AmazonMapOptions tileReplacer(Boolean boolean1)
    {
        mTileReplacer = boolean1;
        return this;
    }

    public AmazonMapOptions tiltGesturesEnabled(boolean flag)
    {
        mTiltGesturesEnabled = Boolean.valueOf(flag);
        return this;
    }

    public AmazonMapOptions useViewLifecycleInFragment(boolean flag)
    {
        mUseViewLifecycleInFragment = Boolean.valueOf(flag);
        return this;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        AmazonMapOptionsCreator.write(this, parcel, i);
    }

    public AmazonMapOptions zOrderOnTop(boolean flag)
    {
        mZOrderOnTop = Boolean.valueOf(flag);
        return this;
    }

    public AmazonMapOptions zoomControlsEnabled(boolean flag)
    {
        mZoomControlsEnabled = Boolean.valueOf(flag);
        return this;
    }

    public AmazonMapOptions zoomGesturesEnabled(boolean flag)
    {
        mZoomGesturesEnabled = Boolean.valueOf(flag);
        return this;
    }

}
