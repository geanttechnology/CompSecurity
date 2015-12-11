// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.a.d;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import com.g.a.a.a.c;
import com.pointinside.PIMapsAccessor;
import com.pointinside.accessibility.AccessibilityNodeProviderBase;
import com.pointinside.internal.utils.AndroidUtils;
import com.pointinside.internal.utils.LogUtils;
import com.pointinside.model.Place;
import com.pointinside.model.Zone;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.FloatByReference;
import com.sun.jna.ptr.PointerByReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;

// Referenced classes of package com.pointinside.maps:
//            PIMGL, PIMap, PIMGLAccessibilityElementSet, PIMGLAccessibilityElement, 
//            PIMGLRect, Projection, PIMGLFeatureSet, PIMGLContext

public class MapView extends GLSurfaceView
{
    private class AccessibilityNodeProvider extends AccessibilityNodeProviderBase
    {

        final MapView this$0;

        private AccessibilityVirtualView getItemFromCoordinates(float f, float f1)
        {
            int i = (int)f;
            int j = (int)f1;
            for (Iterator iterator = mAccessibilityVirtualViews.iterator(); iterator.hasNext();)
            {
                AccessibilityVirtualView accessibilityvirtualview = (AccessibilityVirtualView)iterator.next();
                if (accessibilityvirtualview.mBounds.contains(i, j))
                {
                    return accessibilityvirtualview;
                }
            }

            return null;
        }

        protected int getIdForItem(AccessibilityVirtualView accessibilityvirtualview)
        {
            return accessibilityvirtualview.mId;
        }

        protected volatile int getIdForItem(Object obj)
        {
            return getIdForItem((AccessibilityVirtualView)obj);
        }

        protected AccessibilityVirtualView getItemAt(float f, float f1)
        {
            return getItemFromCoordinates(f, f1);
        }

        protected volatile Object getItemAt(float f, float f1)
        {
            return getItemAt(f, f1);
        }

        protected AccessibilityVirtualView getItemForId(int i)
        {
            if (i >= 0 && i < mAccessibilityVirtualViews.size())
            {
                return (AccessibilityVirtualView)mAccessibilityVirtualViews.get(i);
            } else
            {
                return null;
            }
        }

        protected volatile Object getItemForId(int i)
        {
            return getItemForId(i);
        }

        protected void getVisibleItems(List list)
        {
            list.addAll(mAccessibilityVirtualViews);
        }

        protected boolean performActionForItem(AccessibilityVirtualView accessibilityvirtualview, int i, Bundle bundle)
        {
            return false;
        }

        protected volatile boolean performActionForItem(Object obj, int i, Bundle bundle)
        {
            return performActionForItem((AccessibilityVirtualView)obj, i, bundle);
        }

        protected void populateEventForItem(AccessibilityVirtualView accessibilityvirtualview, AccessibilityEvent accessibilityevent)
        {
            accessibilityevent.setContentDescription(accessibilityvirtualview.mText);
        }

        protected volatile void populateEventForItem(Object obj, AccessibilityEvent accessibilityevent)
        {
            populateEventForItem((AccessibilityVirtualView)obj, accessibilityevent);
        }

        protected void populateNodeForItem(AccessibilityVirtualView accessibilityvirtualview, d d1)
        {
            d1.b(accessibilityvirtualview.mBounds);
            d1.c(accessibilityvirtualview.mText);
            d1.a(String.valueOf(accessibilityvirtualview.mId));
            d1.a(true);
        }

        protected volatile void populateNodeForItem(Object obj, d d1)
        {
            populateNodeForItem((AccessibilityVirtualView)obj, d1);
        }

        public AccessibilityNodeProvider(Context context)
        {
            this$0 = MapView.this;
            super(context);
        }
    }

    private class AccessibilityVirtualView
    {

        public final Rect mBounds;
        public final int mId;
        public final String mText;
        final MapView this$0;

        public AccessibilityVirtualView(int i, Rect rect, String s)
        {
            this$0 = MapView.this;
            super();
            mBounds = rect;
            mId = i;
            mText = s;
        }
    }

    private class MultisampleConfigChooser
        implements android.opengl.GLSurfaceView.EGLConfigChooser
    {

        private static final String kTag = "GDC11";
        private int mSampleSize;
        private boolean mUsesCoverageAa;
        private int mValue[];
        final MapView this$0;

        private int findConfigAttrib(EGL10 egl10, EGLDisplay egldisplay, EGLConfig eglconfig, int i, int j)
        {
            if (egl10.eglGetConfigAttrib(egldisplay, eglconfig, i, mValue))
            {
                j = mValue[0];
            }
            return j;
        }

        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay egldisplay)
        {
            EGLConfig aeglconfig[];
            int i;
            mValue = new int[1];
            int ai[] = new int[15];
            ai[0] = 12324;
            ai[1] = 5;
            ai[2] = 12323;
            ai[3] = 6;
            ai[4] = 12322;
            ai[5] = 5;
            ai[6] = 12325;
            ai[7] = 16;
            ai[8] = 12352;
            ai[9] = 4;
            ai[10] = 12338;
            ai[11] = 1;
            ai[12] = 12337;
            ai[13] = mSampleSize;
            ai[14] = 12344;
            if (!egl10.eglChooseConfig(egldisplay, ai, null, 0, mValue))
            {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int j = mValue[0];
            i = j;
            if (j <= 0)
            {
                ai = new int[15];
                ai;
                ai[0] = 12324;
                ai[1] = 5;
                ai[2] = 12323;
                ai[3] = 6;
                ai[4] = 12322;
                ai[5] = 5;
                ai[6] = 12325;
                ai[7] = 16;
                ai[8] = 12352;
                ai[9] = 4;
                ai[10] = 12512;
                ai[11] = 1;
                ai[12] = 12513;
                ai[13] = 2;
                ai[14] = 12344;
                if (!egl10.eglChooseConfig(egldisplay, ai, null, 0, mValue))
                {
                    throw new IllegalArgumentException("2nd eglChooseConfig failed");
                }
                i = mValue[0];
                if (i <= 0)
                {
                    ai = new int[11];
                    ai;
                    ai[0] = 12324;
                    ai[1] = 5;
                    ai[2] = 12323;
                    ai[3] = 6;
                    ai[4] = 12322;
                    ai[5] = 5;
                    ai[6] = 12325;
                    ai[7] = 16;
                    ai[8] = 12352;
                    ai[9] = 4;
                    ai[10] = 12344;
                    if (!egl10.eglChooseConfig(egldisplay, ai, null, 0, mValue))
                    {
                        throw new IllegalArgumentException("3rd eglChooseConfig failed");
                    }
                    int k = mValue[0];
                    i = k;
                    if (k <= 0)
                    {
                        throw new IllegalArgumentException("No configs match configSpec");
                    }
                } else
                {
                    mUsesCoverageAa = true;
                }
            }
            aeglconfig = new EGLConfig[i];
            if (!egl10.eglChooseConfig(egldisplay, ai, aeglconfig, i, mValue))
            {
                throw new IllegalArgumentException("data eglChooseConfig failed");
            }
            i = 0;
_L3:
            if (i >= aeglconfig.length)
            {
                break MISSING_BLOCK_LABEL_531;
            }
            if (findConfigAttrib(egl10, egldisplay, aeglconfig[i], 12324, 0) != 5) goto _L2; else goto _L1
_L1:
            if (i == -1)
            {
                Log.w("GDC11", "Did not find sane config, using first");
            }
            if (aeglconfig.length > 0)
            {
                egl10 = aeglconfig[i];
            } else
            {
                egl10 = null;
            }
            if (egl10 == null)
            {
                throw new IllegalArgumentException("No config chosen");
            } else
            {
                return egl10;
            }
_L2:
            i++;
              goto _L3
            i = -1;
              goto _L1
        }

        public boolean usesCoverageAa()
        {
            return mUsesCoverageAa;
        }

        public MultisampleConfigChooser(int i)
        {
            this$0 = MapView.this;
            super();
            mSampleSize = i;
        }
    }

    private static class PIMGLRenderer
        implements android.opengl.GLSurfaceView.Renderer
    {

        private final WeakReference mPimglContext;

        public void onDrawFrame(GL10 gl10)
        {
            gl10 = (PIMGLContext)mPimglContext.get();
            if (gl10 != null)
            {
                PIMGL.render(gl10);
            }
        }

        public void onSurfaceChanged(GL10 gl10, int i, int j)
        {
            gl10 = (PIMGLContext)mPimglContext.get();
            if (gl10 != null)
            {
                PIMGL.display_setViewSize(gl10, i, j);
                LogUtils.logD(PIMGL.TAG, "PIMGLRenderer", "onSurfaceChanged");
            }
        }

        public void onSurfaceCreated(GL10 gl10, EGLConfig eglconfig)
        {
            gl10 = (PIMGLContext)mPimglContext.get();
            if (gl10 != null)
            {
                PIMGL.detectGfxContext(gl10);
                LogUtils.logD(PIMGL.TAG, "PIMGLRenderer", "onSurfaceCreated");
            }
        }

        PIMGLRenderer(PIMGLContext pimglcontext)
        {
            mPimglContext = new WeakReference(pimglcontext);
        }
    }


    private static final long PIMGL_UPDATE_FREQUENCY = 33L;
    private AccessibilityManager mAccessibilityManager;
    private boolean mAccessibilityNeedsRefresh;
    private AccessibilityNodeProvider mAccessibilityNodeProvider;
    private final List mAccessibilityVirtualViews;
    private final Handler mHandler;
    private final PIMap mMap;
    private final PIMGLContext mPimglContext;
    private final Runnable mUpdateRunnable;

    public MapView(Context context)
    {
        this(context, null);
    }

    public MapView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public MapView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset);
        mAccessibilityNeedsRefresh = false;
        mHandler = new Handler(Looper.getMainLooper());
        mAccessibilityVirtualViews = new ArrayList();
        if (isInEditMode())
        {
            mUpdateRunnable = null;
            mPimglContext = null;
            mMap = null;
            return;
        }
        if (AndroidUtils.getGLESVersion(context) >= 0x20000 || AndroidUtils.isEmulator())
        {
            setEGLContextClientVersion(2);
        }
        PIMGL.appInitialize();
        mPimglContext = PIMGL.createContext(context.getApplicationContext());
        PIMGL.display_setScreenSize(mPimglContext, context);
        ViewTreeObserver viewtreeobserver = getViewTreeObserver();
        if (viewtreeobserver.isAlive())
        {
            viewtreeobserver.addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

                final MapView this$0;

                public void onGlobalLayout()
                {
                    if (AndroidUtils.isJellyBean())
                    {
                        getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    } else
                    {
                        getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    }
                    setSize(getWidth(), getHeight());
                }

            
            {
                this$0 = MapView.this;
                super();
            }
            });
        }
        mUpdateRunnable = new Runnable() {

            final MapView this$0;

            public void run()
            {
                if (mAccessibilityNeedsRefresh)
                {
                    refreshAccessibility();
                }
                PIMGL.update(mPimglContext);
                mHandler.postDelayed(mUpdateRunnable, 33L);
            }

            
            {
                this$0 = MapView.this;
                super();
            }
        };
        int j = PIMapsAccessor.getInstance().getMultiSamplingSampleSize();
        if (j != 1)
        {
            setEGLConfigChooser(new MultisampleConfigChooser(j));
        }
        setRenderer(new PIMGLRenderer(mPimglContext));
        mMap = new PIMap(context, attributeset, i, this, mPimglContext);
        if (isAccessibilitySupported())
        {
            initAccessibility(context);
        }
        onPause();
    }

    private void initAccessibility(Context context)
    {
        mAccessibilityManager = (AccessibilityManager)context.getSystemService("accessibility");
        setFocusable(true);
    }

    private boolean isAccessibilityEnabled()
    {
        return mAccessibilityManager.isEnabled();
    }

    private boolean isAccessibilitySupported()
    {
        return AndroidUtils.isIceCreamSandwich();
    }

    private void refreshAccessibilityVirtualViews()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj2;
        int j;
        mAccessibilityVirtualViews.clear();
        obj2 = new PIMGLAccessibilityElementSet();
        PIMGL.accessibility_getVisibleElements(mPimglContext, ((PIMGLAccessibilityElementSet) (obj2)));
        j = ((PIMGLAccessibilityElementSet) (obj2)).mSize.intValue();
        if (j <= 0) goto _L2; else goto _L1
_L1:
        PIMGLAccessibilityElement apimglaccessibilityelement[];
        mAccessibilityNeedsRefresh = false;
        apimglaccessibilityelement = (PIMGLAccessibilityElement[])((PIMGLAccessibilityElementSet) (obj2)).mElements.castToArray(j);
        int i = 0;
_L6:
        if (i >= j) goto _L2; else goto _L3
_L3:
        Object obj = apimglaccessibilityelement[i];
        Object obj1;
        int k;
        int l;
        k = (int)((PIMGLAccessibilityElement) (obj)).mRect.mXMin;
        int i1 = (int)((PIMGLAccessibilityElement) (obj)).mRect.mYMin;
        l = (int)(((PIMGLAccessibilityElement) (obj)).mRect.mXMax - ((PIMGLAccessibilityElement) (obj)).mRect.mXMin);
        obj1 = new Rect(k, i1, k + l, -(int)(((PIMGLAccessibilityElement) (obj)).mRect.mYMax - ((PIMGLAccessibilityElement) (obj)).mRect.mYMin) + i1);
        if (((PIMGLAccessibilityElement) (obj)).mIsAnnotation) goto _L5; else goto _L4
_L4:
        obj = ((PIMGLAccessibilityElement) (obj)).mText.getString(0L);
_L9:
        obj = new AccessibilityVirtualView(i, ((Rect) (obj1)), ((String) (obj)));
        mAccessibilityVirtualViews.add(obj);
        i++;
          goto _L6
_L5:
        int j1 = (int)((PIMGLAccessibilityElement) (obj)).mRect.mYMax;
        obj1 = new Rect(k, j1, l + k, (int)(((PIMGLAccessibilityElement) (obj)).mRect.mYMin - ((PIMGLAccessibilityElement) (obj)).mRect.mYMax) + j1);
        if (((PIMGLAccessibilityElement) (obj)).mText == null) goto _L8; else goto _L7
_L7:
        obj = ((PIMGLAccessibilityElement) (obj)).mText.getString(0L);
          goto _L9
_L2:
        PIMGL.accessibility_releaseSet(mPimglContext, ((PIMGLAccessibilityElementSet) (obj2)));
        obj = mMap.getCurrentZone().getServices();
        obj1 = mMap.getProjection();
        i = j;
        j = 0;
_L10:
        if (j >= ((List) (obj)).size())
        {
            break MISSING_BLOCK_LABEL_462;
        }
        obj2 = (Place)((List) (obj)).get(j);
        PointF pointf = ((Place) (obj2)).getMapPoint();
        pointf = ((Projection) (obj1)).pointInZoneToView(pointf.x, -pointf.y);
        k = (int)pointf.x;
        l = (int)pointf.y;
        if (k < 0)
        {
            break MISSING_BLOCK_LABEL_494;
        }
        if (k > getWidth() || l < 0)
        {
            break MISSING_BLOCK_LABEL_494;
        }
        Rect rect;
        if (l > getHeight())
        {
            break MISSING_BLOCK_LABEL_494;
        }
        rect = new Rect(k - 22, l - 22, k + 44, l + 44);
        obj2 = ((Place) (obj2)).getName();
        k = i + 1;
        obj2 = new AccessibilityVirtualView(i, rect, ((String) (obj2)));
        mAccessibilityVirtualViews.add(obj2);
        i = k;
        break MISSING_BLOCK_LABEL_494;
        if (mAccessibilityNodeProvider != null)
        {
            mAccessibilityNodeProvider.invalidateParent();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        obj;
        throw obj;
_L8:
        obj = "PIN";
          goto _L9
        j++;
          goto _L10
    }

    private void setSize(int i, int j)
    {
        PIMGL.display_setViewSize(mPimglContext, i, j);
        mMap.addOrUpdateLogoOverlay();
    }

    public HashMap getDistancesFromFeatures(String s, String as[], float f, float f1, byte byte0)
    {
        com.sun.jna.ptr.IntByReference intbyreference = mMap.getZoneRefFromUUID(s);
        s = (new PIMGLFeatureSet()).newByReference();
        HashMap hashmap = new HashMap();
        c c1 = new c(as.length);
        if (PIMGL.zone_getDistanceToFeatures(mPimglContext, intbyreference, s, as, c1, f, f1, byte0) && ((PIMGLFeatureSet) (s)).mSize.intValue() > 0)
        {
            as = ((PIMGLFeatureSet) (s)).mNames.getPointer().getPointerArray(0L);
            Pointer apointer[] = ((PIMGLFeatureSet) (s)).mDistances.getPointer().getPointerArray(0L);
            int i = 0;
            while (i < ((PIMGLFeatureSet) (s)).mSize.intValue()) 
            {
                try
                {
                    hashmap.put(as[i].getString(0L), Float.valueOf(apointer[i].getFloat(0L)));
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
                i++;
            }
        }
        return hashmap;
    }

    public final PIMap getMap()
    {
        return mMap;
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        Context context = getContext();
        if (!isInEditMode() && AndroidUtils.isIceCreamSandwich() && mAccessibilityManager.isEnabled() && mAccessibilityNodeProvider == null && context != null)
        {
            mAccessibilityNodeProvider = new AccessibilityNodeProvider(context);
            mAccessibilityNodeProvider.install(this);
        }
    }

    public final void onDestroy()
    {
        mMap.onDestroy();
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        mMap.onDetachedFromWindow();
        if (mAccessibilityNodeProvider != null)
        {
            mAccessibilityNodeProvider.uninstall();
            mAccessibilityNodeProvider = null;
        }
    }

    public void onPause()
    {
        super.onPause();
        PIMGL.pause(mPimglContext);
        setRenderMode(0);
        mHandler.removeCallbacks(mUpdateRunnable);
    }

    public void onResume()
    {
        super.onResume();
        mMap.onResume();
        PIMGL.resume(mPimglContext);
        mHandler.postDelayed(mUpdateRunnable, 33L);
        setRenderMode(1);
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        if (k != 0 || l != 0)
        {
            setSize(i, j);
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        int i;
        boolean flag;
        i = 0;
        flag = false;
        motionevent.getActionMasked();
        JVM INSTR tableswitch 0 6: default 52
    //                   0 64
    //                   1 67
    //                   2 85
    //                   3 54
    //                   4 52
    //                   5 64
    //                   6 67;
           goto _L1 _L2 _L3 _L4 _L5 _L1 _L2 _L3
_L1:
        return true;
_L5:
        PIMGL.enqueueTouchEventCancel(mPimglContext, motionevent);
        return true;
_L2:
        flag = true;
_L3:
        i = motionevent.getActionIndex();
        PIMGL.enqueueTouchEvent(mPimglContext, motionevent, i, flag);
        return true;
_L4:
        int j = motionevent.getPointerCount();
        while (i < j) 
        {
            PIMGL.enqueueTouchEvent(mPimglContext, motionevent, i, true);
            i++;
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    public void refreshAccessibility()
    {
        while (!isAccessibilitySupported() || !isAccessibilityEnabled()) 
        {
            return;
        }
        refreshAccessibilityVirtualViews();
    }

    public final void setBackgroundColor(int i)
    {
        PIMGL.setClearColor(mPimglContext, i);
    }

    public void startTryingToRefreshAccessibility()
    {
        if (!isAccessibilitySupported())
        {
            return;
        } else
        {
            mAccessibilityNeedsRefresh = true;
            return;
        }
    }






}
