// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.status;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Handler;
import com.cyberlink.youcammakeup.BaseActivity;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.d;
import com.cyberlink.youcammakeup.database.g;
import com.cyberlink.youcammakeup.database.more.a.b;
import com.cyberlink.youcammakeup.flurry.RateOfFeaturePointAdjustment;
import com.cyberlink.youcammakeup.jniproxy.ax;
import com.cyberlink.youcammakeup.jniproxy.ba;
import com.cyberlink.youcammakeup.jniproxy.bn;
import com.cyberlink.youcammakeup.jniproxy.y;
import com.cyberlink.youcammakeup.kernelctrl.BeautifierTaskInfo;
import com.cyberlink.youcammakeup.kernelctrl.VenusHelper;
import com.cyberlink.youcammakeup.kernelctrl.ar;
import com.cyberlink.youcammakeup.kernelctrl.at;
import com.cyberlink.youcammakeup.kernelctrl.aw;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.DevelopSetting;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.v;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageViewer;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ae;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.i;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.MakeupMode;
import com.cyberlink.youcammakeup.utility.bb;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.cyberlink.youcammakeup.widgetpool.common.ai;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.status:
//            SessionManagerLocal, ao, s, r, 
//            d, a, c, t, 
//            ImageStateChangedEvent, aa, ad, ae, 
//            af, ag, ah, ai, 
//            aj, ak, al, am, 
//            an, ap, g, h, 
//            i, k, l, m, 
//            n, p, q, u, 
//            v, w, x, y, 
//            z, ac, j, o, 
//            ab

public class StatusManager
    implements Serializable
{

    public static final UUID a = UUID.randomUUID();
    private static final long serialVersionUID = 1L;
    private com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode PalettesMode;
    private String PatternGuid;
    private Boolean bBtnClickable;
    private com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i curMakeupState;
    private BeautyMode currentBeautyMode;
    private MakeupMode currentMakeupMode;
    private List faceList;
    private SessionManagerLocal fineTuneSessionManagerLocal;
    private boolean isIntentFromCamera;
    private boolean isIntentFromLauncher;
    private ArrayList mAdjustSettingObservers;
    private ArrayList mBeautifierSettingObservers;
    private b mBeautyFilmMetadata;
    private ArrayList mBeautyFilmMetadataObserver;
    private ArrayList mBeautyModeChangeObserver;
    private ArrayList mBirdViewStateChangeObserver;
    private DevelopSetting mCopiedDev;
    private long mCurAlbumID;
    private ArrayList mCurAlbumIDObserver;
    private long mCurCategoryId;
    private String mCurCategoryName;
    private long mCurImageID;
    private List mCurImageIDArray;
    private ba mCurMetadata;
    private ArrayList mCurPanelObservers;
    private List mCurQueryMetadata;
    private long mCurReservedImageID;
    private Object mCurView;
    private ArrayList mCurViewObservers;
    private ArrayList mDecodeImageFailObserver;
    private ArrayList mDevSettingObservers;
    private t mDisplayedFeatureSet;
    private boolean mEditViewTouchStatus;
    private ArrayList mEditViewTouchStatusObserver;
    private boolean mEffectCopied;
    private ArrayList mFPtsFadeOutObserver;
    private ArrayList mFaceChangeObserver;
    private ArrayList mFaceInfoInitObserver;
    private ArrayList mFacePointChangeObserver;
    private ArrayList mFeaturePointsObservers;
    private Handler mHandler;
    private ArrayList mHideBottomToolBarObserver;
    private ArrayList mImageBufferRenderObservers;
    private ArrayList mImageCacheObserver;
    private ArrayList mImageIDArrayObservers;
    private ArrayList mImageIDObservers;
    private ArrayList mImageInfoObserver;
    private ArrayList mImagePropertyObservers;
    private ArrayList mImageStateInfoObserver;
    private ArrayList mIntroDialogObserver;
    private ArrayList mLookImageAdapterReadyObservers;
    private ArrayList mMakeupModeChangeObserver;
    private ArrayList mMotionControlObserver;
    private ArrayList mNullImagePathObserver;
    private String mPaletteGuid;
    private ArrayList mPatternChangeObserver;
    private ArrayList mPatternsChangeObserver;
    private s mPauseHideDlg;
    private r mPauseHideDlgFragment;
    private s mPauseShowDlg;
    private r mPauseShowDlgFragment;
    private int mPosOfCurAlbum;
    private ArrayList mRetouchResourceObserver;
    private ArrayList mSelectedFWImageIDs;
    private boolean mShowUpdateRAWCodec;
    private String mStyleGuid;
    private ArrayList mWigWarpObserver;
    private List patternGuids;
    private SessionManagerLocal sessionManagerLocal;
    private ConcurrentHashMap sessionManagers;

    private StatusManager()
    {
        bBtnClickable = Boolean.valueOf(true);
        PatternGuid = "";
        patternGuids = new ArrayList();
        mPaletteGuid = null;
        mStyleGuid = null;
        curMakeupState = null;
        mCurCategoryId = -1L;
        mCurCategoryName = null;
        mCurQueryMetadata = null;
        PalettesMode = null;
        mHandler = null;
        mBeautyFilmMetadataObserver = null;
        mImageIDObservers = null;
        mImageIDArrayObservers = null;
        mImagePropertyObservers = null;
        mDevSettingObservers = null;
        mAdjustSettingObservers = null;
        mBeautifierSettingObservers = null;
        mFeaturePointsObservers = null;
        mCurViewObservers = null;
        mCurPanelObservers = null;
        mImageBufferRenderObservers = null;
        mEditViewTouchStatusObserver = null;
        mImageCacheObserver = null;
        mRetouchResourceObserver = null;
        mCurAlbumIDObserver = null;
        mImageStateInfoObserver = null;
        mFaceInfoInitObserver = null;
        mSelectedFWImageIDs = null;
        mFacePointChangeObserver = null;
        mNullImagePathObserver = null;
        mDecodeImageFailObserver = null;
        mIntroDialogObserver = null;
        mMakeupModeChangeObserver = null;
        mBeautyModeChangeObserver = null;
        mHideBottomToolBarObserver = null;
        mBirdViewStateChangeObserver = null;
        mPatternChangeObserver = null;
        mPatternsChangeObserver = null;
        mFaceChangeObserver = null;
        mFPtsFadeOutObserver = null;
        mMotionControlObserver = null;
        mWigWarpObserver = null;
        mImageInfoObserver = null;
        mLookImageAdapterReadyObservers = null;
        mCurImageID = -1L;
        mCurImageIDArray = null;
        mCurAlbumID = -1L;
        mPosOfCurAlbum = 0;
        mCurReservedImageID = -1L;
        mCurView = null;
        mEffectCopied = false;
        mShowUpdateRAWCodec = true;
        mEditViewTouchStatus = false;
        mPauseShowDlg = null;
        mPauseHideDlg = null;
        mPauseShowDlgFragment = null;
        mPauseHideDlgFragment = null;
        mCopiedDev = null;
        mBeautyFilmMetadata = null;
        isIntentFromLauncher = false;
        currentMakeupMode = MakeupMode.g;
        currentBeautyMode = BeautyMode.D;
        mDisplayedFeatureSet = null;
        sessionManagers = new ConcurrentHashMap();
        sessionManagerLocal = new SessionManagerLocal(SessionManagerLocal.LocalSessionType.a);
        fineTuneSessionManagerLocal = new SessionManagerLocal(com.cyberlink.youcammakeup.kernelctrl.status.SessionManagerLocal.LocalSessionType.b);
        isIntentFromCamera = false;
        faceList = null;
        mCurMetadata = null;
        mHandler = new Handler();
        mBeautyFilmMetadataObserver = new ArrayList();
        mImageIDObservers = new ArrayList();
        mImageIDArrayObservers = new ArrayList();
        mImagePropertyObservers = new ArrayList();
        mDevSettingObservers = new ArrayList();
        mAdjustSettingObservers = new ArrayList();
        mBeautifierSettingObservers = new ArrayList();
        mFeaturePointsObservers = new ArrayList();
        mCurViewObservers = new ArrayList();
        mCurPanelObservers = new ArrayList();
        mImageBufferRenderObservers = new ArrayList();
        mEditViewTouchStatusObserver = new ArrayList();
        mImageCacheObserver = new ArrayList();
        mRetouchResourceObserver = new ArrayList();
        mCurAlbumIDObserver = new ArrayList();
        mImageStateInfoObserver = new ArrayList();
        mFaceInfoInitObserver = new ArrayList();
        mSelectedFWImageIDs = new ArrayList();
        mFacePointChangeObserver = new ArrayList();
        mNullImagePathObserver = new ArrayList();
        mDecodeImageFailObserver = new ArrayList();
        mIntroDialogObserver = new ArrayList();
        mMakeupModeChangeObserver = new ArrayList();
        mBeautyModeChangeObserver = new ArrayList();
        mHideBottomToolBarObserver = new ArrayList();
        mBirdViewStateChangeObserver = new ArrayList();
        mPatternChangeObserver = new ArrayList();
        mPatternsChangeObserver = new ArrayList();
        mFaceChangeObserver = new ArrayList();
        mFPtsFadeOutObserver = new ArrayList();
        mImageInfoObserver = new ArrayList();
        mMotionControlObserver = new ArrayList();
        mWigWarpObserver = new ArrayList();
        mLookImageAdapterReadyObservers = new ArrayList();
    }


    static ArrayList A(StatusManager statusmanager)
    {
        return statusmanager.mFPtsFadeOutObserver;
    }

    static ArrayList B(StatusManager statusmanager)
    {
        return statusmanager.mMotionControlObserver;
    }

    static ArrayList C(StatusManager statusmanager)
    {
        return statusmanager.mWigWarpObserver;
    }

    static ArrayList a(StatusManager statusmanager)
    {
        return statusmanager.mBeautyFilmMetadataObserver;
    }

    static b b(StatusManager statusmanager)
    {
        return statusmanager.mBeautyFilmMetadata;
    }

    static ArrayList c(StatusManager statusmanager)
    {
        return statusmanager.mImageIDObservers;
    }

    static ArrayList d(StatusManager statusmanager)
    {
        return statusmanager.mImageIDArrayObservers;
    }

    static ArrayList e(StatusManager statusmanager)
    {
        return statusmanager.mCurViewObservers;
    }

    static ArrayList f(StatusManager statusmanager)
    {
        return statusmanager.mCurAlbumIDObserver;
    }

    static ArrayList g(StatusManager statusmanager)
    {
        return statusmanager.mImageCacheObserver;
    }

    static ArrayList h(StatusManager statusmanager)
    {
        return statusmanager.mImageStateInfoObserver;
    }

    static ArrayList i(StatusManager statusmanager)
    {
        return statusmanager.mBeautifierSettingObservers;
    }

    public static StatusManager j()
    {
        return ao.a();
    }

    static ArrayList j(StatusManager statusmanager)
    {
        return statusmanager.mFeaturePointsObservers;
    }

    static ArrayList k(StatusManager statusmanager)
    {
        return statusmanager.mImageBufferRenderObservers;
    }

    static ArrayList l(StatusManager statusmanager)
    {
        return statusmanager.mImageInfoObserver;
    }

    static ArrayList m(StatusManager statusmanager)
    {
        return statusmanager.mFaceInfoInitObserver;
    }

    static ArrayList n(StatusManager statusmanager)
    {
        return statusmanager.mFacePointChangeObserver;
    }

    static ArrayList o(StatusManager statusmanager)
    {
        return statusmanager.mNullImagePathObserver;
    }

    static ArrayList p(StatusManager statusmanager)
    {
        return statusmanager.mDecodeImageFailObserver;
    }

    static ArrayList q(StatusManager statusmanager)
    {
        return statusmanager.mLookImageAdapterReadyObservers;
    }

    static ArrayList r(StatusManager statusmanager)
    {
        return statusmanager.mEditViewTouchStatusObserver;
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        try
        {
            long l1 = objectinputstream.readLong();
            long l2 = objectinputstream.readLong();
            long l3 = objectinputstream.readLong();
            mCurAlbumID = l1;
            mCurImageID = l2;
            mCurReservedImageID = l3;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ObjectInputStream objectinputstream)
        {
            return;
        }
    }

    static ArrayList s(StatusManager statusmanager)
    {
        return statusmanager.mIntroDialogObserver;
    }

    static ArrayList t(StatusManager statusmanager)
    {
        return statusmanager.mMakeupModeChangeObserver;
    }

    static ArrayList u(StatusManager statusmanager)
    {
        return statusmanager.mBeautyModeChangeObserver;
    }

    static ArrayList v(StatusManager statusmanager)
    {
        return statusmanager.mHideBottomToolBarObserver;
    }

    static ArrayList w(StatusManager statusmanager)
    {
        return statusmanager.mBirdViewStateChangeObserver;
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
    {
        try
        {
            objectoutputstream.writeLong(p());
            objectoutputstream.writeLong(l());
            objectoutputstream.writeLong(n());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ObjectOutputStream objectoutputstream)
        {
            return;
        }
    }

    static ArrayList x(StatusManager statusmanager)
    {
        return statusmanager.mPatternChangeObserver;
    }

    static ArrayList y(StatusManager statusmanager)
    {
        return statusmanager.mPatternsChangeObserver;
    }

    static ArrayList z(StatusManager statusmanager)
    {
        return statusmanager.mFaceChangeObserver;
    }

    public boolean A()
    {
        EditViewActivity editviewactivity = Globals.d().t();
        if (editviewactivity != null)
        {
            return editviewactivity.B();
        } else
        {
            return false;
        }
    }

    public boolean B()
    {
        return mEditViewTouchStatus;
    }

    public void C()
    {
        if (mPauseHideDlg != null)
        {
            if (!com.cyberlink.youcammakeup.kernelctrl.status.s.a(mPauseHideDlg).isFinishing())
            {
                Globals.d().i();
                com.cyberlink.youcammakeup.utility.o.a(com.cyberlink.youcammakeup.kernelctrl.status.s.a(mPauseHideDlg));
            }
            mPauseHideDlg = null;
        }
        if (mPauseShowDlg != null)
        {
            if (!com.cyberlink.youcammakeup.kernelctrl.status.s.a(mPauseShowDlg).isFinishing())
            {
                Globals.d().i().a(mPauseShowDlg.a, com.cyberlink.youcammakeup.kernelctrl.status.s.a(mPauseShowDlg), mPauseShowDlg.b.booleanValue());
            }
            mPauseShowDlg = null;
        }
        if (mPauseHideDlgFragment != null)
        {
            com.cyberlink.youcammakeup.utility.o.b(com.cyberlink.youcammakeup.kernelctrl.status.r.a(mPauseHideDlgFragment), mPauseHideDlgFragment.a, mPauseHideDlgFragment.b);
            mPauseHideDlgFragment = null;
        }
        if (mPauseShowDlgFragment != null)
        {
            com.cyberlink.youcammakeup.utility.o.a(com.cyberlink.youcammakeup.kernelctrl.status.r.a(mPauseShowDlgFragment), mPauseShowDlgFragment.a, mPauseShowDlgFragment.b);
            mPauseShowDlgFragment = null;
        }
    }

    public void D()
    {
        if (mPauseHideDlg != null)
        {
            mPauseHideDlg = null;
        }
        if (mPauseShowDlg != null)
        {
            mPauseShowDlg = null;
        }
        if (mPauseHideDlgFragment != null)
        {
            mPauseHideDlgFragment = null;
        }
        if (mPauseShowDlgFragment != null)
        {
            mPauseShowDlgFragment = null;
        }
    }

    public Boolean E()
    {
        return bBtnClickable;
    }

    public void F()
    {
        if (sessionManagers.size() == 0)
        {
            return;
        }
        for (Iterator iterator = sessionManagers.values().iterator(); iterator.hasNext(); ((com.cyberlink.youcammakeup.kernelctrl.status.d)iterator.next()).a()) { }
        sessionManagers = new ConcurrentHashMap();
    }

    public void G()
    {
        String s1 = (new StringBuilder()).append(Globals.d().q()).append("/session").append("_local").toString();
        String s2 = (new StringBuilder()).append(Globals.d().q()).append("/session").append("_global").toString();
        String s3 = (new StringBuilder()).append(Globals.d().q()).append("/").append("_imagebuffer_saved").toString();
        bb.b(new File(s1));
        bb.b(new File(s2));
        bb.b(new File(s3));
    }

    public void H()
    {
        bb.b(new File((new StringBuilder()).append(Globals.d().q()).append("/session").append("_fine_tune").toString()));
    }

    public String I()
    {
        return (new StringBuilder()).append(Globals.d().q()).append("/session").append("_global").toString();
    }

    public String J()
    {
        return (new StringBuilder()).append(Globals.d().q()).append("/largephoto").toString();
    }

    public void K()
    {
        sessionManagerLocal.a();
    }

    public void L()
    {
        fineTuneSessionManagerLocal.a();
    }

    public void M()
    {
        mHandler.post(new Runnable() {

            final StatusManager a;

            public void run()
            {
                int i1 = 0;
                StatusManager statusmanager = a;
                statusmanager;
                JVM INSTR monitorenter ;
                aa aaa[];
                int j1;
                aaa = (aa[])com.cyberlink.youcammakeup.kernelctrl.status.StatusManager.v(a).toArray(new aa[0]);
                j1 = aaa.length;
_L2:
                if (i1 >= j1)
                {
                    break; /* Loop/switch isn't completed */
                }
                aaa[i1].a();
                i1++;
                if (true) goto _L2; else goto _L1
_L1:
                statusmanager;
                JVM INSTR monitorexit ;
                return;
                Exception exception;
                exception;
                statusmanager;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                a = StatusManager.this;
                super();
            }
        });
    }

    public void N()
    {
        mHandler.post(new Runnable() {

            final StatusManager a;

            public void run()
            {
                int i1 = 0;
                StatusManager statusmanager = a;
                statusmanager;
                JVM INSTR monitorenter ;
                com.cyberlink.youcammakeup.kernelctrl.status.v av[];
                int j1;
                av = (com.cyberlink.youcammakeup.kernelctrl.status.v[])StatusManager.z(a).toArray(new com.cyberlink.youcammakeup.kernelctrl.status.v[0]);
                j1 = av.length;
_L2:
                if (i1 >= j1)
                {
                    break; /* Loop/switch isn't completed */
                }
                av[i1].d();
                i1++;
                if (true) goto _L2; else goto _L1
_L1:
                statusmanager;
                JVM INSTR monitorexit ;
                return;
                Exception exception;
                exception;
                statusmanager;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                a = StatusManager.this;
                super();
            }
        });
    }

    public boolean O()
    {
        return isIntentFromLauncher;
    }

    public boolean P()
    {
        return isIntentFromCamera;
    }

    public List Q()
    {
        return faceList;
    }

    public void R()
    {
        mHandler.post(new Runnable() {

            final StatusManager a;

            public void run()
            {
                int i1 = 0;
                StatusManager statusmanager = a;
                statusmanager;
                JVM INSTR monitorenter ;
                z az[];
                int j1;
                az = (z[])StatusManager.A(a).toArray(new z[0]);
                j1 = az.length;
_L2:
                if (i1 >= j1)
                {
                    break; /* Loop/switch isn't completed */
                }
                az[i1].r();
                i1++;
                if (true) goto _L2; else goto _L1
_L1:
                statusmanager;
                JVM INSTR monitorexit ;
                return;
                Exception exception;
                exception;
                statusmanager;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                a = StatusManager.this;
                super();
            }
        });
    }

    public List a()
    {
        return mCurQueryMetadata;
    }

    public void a(int i1)
    {
        mPosOfCurAlbum = i1;
    }

    public void a(int i1, int j1, int k1, int l1, int i2, int j2, int k2, 
            int l2)
    {
        EditViewActivity editviewactivity = Globals.d().t();
        if (editviewactivity != null)
        {
            editviewactivity.a(i1, j1, k1, l1, i2, j2, k2, l2);
        }
    }

    public void a(long l1)
    {
        mCurCategoryId = l1;
    }

    public void a(long l1, com.cyberlink.youcammakeup.database.d d1)
    {
        mHandler.post(new Runnable(l1, d1) {

            final long a;
            final com.cyberlink.youcammakeup.database.d b;
            final StatusManager c;

            public void run()
            {
                int i1 = 0;
                StatusManager statusmanager = c;
                statusmanager;
                JVM INSTR monitorenter ;
                ab aab[];
                int j1;
                aab = (ab[])com.cyberlink.youcammakeup.kernelctrl.status.StatusManager.g(c).toArray(new ab[0]);
                j1 = aab.length;
_L2:
                if (i1 >= j1)
                {
                    break; /* Loop/switch isn't completed */
                }
                aab[i1].a(a, b);
                i1++;
                if (true) goto _L2; else goto _L1
_L1:
                statusmanager;
                JVM INSTR monitorexit ;
                return;
                Exception exception;
                exception;
                statusmanager;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                c = StatusManager.this;
                a = l1;
                b = d1;
                super();
            }
        });
    }

    public void a(long l1, UUID uuid)
    {
        if (mCurImageID == l1)
        {
            return;
        } else
        {
            RateOfFeaturePointAdjustment.c();
            mCurImageID = l1;
            l1 = mCurImageID;
            Object obj = mCurView;
            mDisplayedFeatureSet = null;
            mHandler.post(new Runnable(l1, obj, uuid) {

                final long a;
                final Object b;
                final UUID c;
                final StatusManager d;

                public void run()
                {
                    int i1 = 0;
                    StatusManager statusmanager = d;
                    statusmanager;
                    JVM INSTR monitorenter ;
                    ad aad[];
                    int j1;
                    aad = (ad[])StatusManager.c(d).toArray(new ad[0]);
                    j1 = aad.length;
_L2:
                    if (i1 >= j1)
                    {
                        break; /* Loop/switch isn't completed */
                    }
                    aad[i1].a(a, b, c);
                    i1++;
                    if (true) goto _L2; else goto _L1
_L1:
                    statusmanager;
                    JVM INSTR monitorexit ;
                    return;
                    Exception exception;
                    exception;
                    statusmanager;
                    JVM INSTR monitorexit ;
                    throw exception;
                }

            
            {
                d = StatusManager.this;
                a = l1;
                b = obj;
                c = uuid;
                super();
            }
            });
            return;
        }
    }

    public void a(Fragment fragment, Activity activity)
    {
        activity = new s(this, fragment, activity, Boolean.valueOf(false));
        if (fragment != null)
        {
            if (mPauseShowDlg != null && mPauseShowDlg.a != null && mPauseShowDlg.a.getClass() == fragment.getClass())
            {
                mPauseShowDlg = null;
                return;
            } else
            {
                activity.a = null;
                mPauseHideDlg = activity;
                return;
            }
        } else
        {
            mPauseShowDlg = null;
            return;
        }
    }

    public void a(Fragment fragment, Activity activity, boolean flag)
    {
        if (fragment != null)
        {
            mPauseShowDlg = new s(this, fragment, activity, Boolean.valueOf(flag));
        }
    }

    public void a(FragmentManager fragmentmanager, DialogFragment dialogfragment, String s1)
    {
        if (dialogfragment != null)
        {
            mPauseShowDlgFragment = new r(this, fragmentmanager, dialogfragment, s1);
        }
    }

    public void a(b b1)
    {
        mBeautyFilmMetadata = b1;
        mHandler.post(new Runnable() {

            final StatusManager a;

            public void run()
            {
                int i1 = 0;
                StatusManager statusmanager = a;
                statusmanager;
                JVM INSTR monitorenter ;
                com.cyberlink.youcammakeup.kernelctrl.status.i ai[];
                int j1;
                ai = (com.cyberlink.youcammakeup.kernelctrl.status.i[])StatusManager.a(a).toArray(new com.cyberlink.youcammakeup.kernelctrl.status.i[0]);
                j1 = ai.length;
_L2:
                if (i1 >= j1)
                {
                    break; /* Loop/switch isn't completed */
                }
                ai[i1].a(com.cyberlink.youcammakeup.kernelctrl.status.StatusManager.b(a));
                i1++;
                if (true) goto _L2; else goto _L1
_L1:
                statusmanager;
                JVM INSTR monitorexit ;
                return;
                Exception exception;
                exception;
                statusmanager;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                a = StatusManager.this;
                super();
            }
        });
    }

    public void a(ba ba)
    {
        mCurMetadata = ba;
    }

    public void a(y y1, boolean flag)
    {
        mHandler.post(new Runnable(y1, flag) {

            final y a;
            final boolean b;
            final StatusManager c;

            public void run()
            {
                int i1 = 0;
                StatusManager statusmanager = c;
                statusmanager;
                JVM INSTR monitorenter ;
                com.cyberlink.youcammakeup.kernelctrl.status.y ay[];
                int j1;
                ay = (com.cyberlink.youcammakeup.kernelctrl.status.y[])StatusManager.j(c).toArray(new com.cyberlink.youcammakeup.kernelctrl.status.y[0]);
                j1 = ay.length;
_L2:
                if (i1 >= j1)
                {
                    break; /* Loop/switch isn't completed */
                }
                ay[i1].a(a, b);
                i1++;
                if (true) goto _L2; else goto _L1
_L1:
                statusmanager;
                JVM INSTR monitorexit ;
                return;
                Exception exception;
                exception;
                statusmanager;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                c = StatusManager.this;
                a = y1;
                b = flag;
                super();
            }
        });
    }

    public void a(ar ar1)
    {
        Object obj;
        Object obj1;
        if (ar1 != null)
        {
            if ((com.cyberlink.youcammakeup.database.g.a(((Long) (obj = Long.valueOf(l()))).longValue()) || com.cyberlink.youcammakeup.kernelctrl.viewengine.i.a(((Long) (obj)).longValue())) && (obj = c(((Long) (obj)).longValue()).e()) != null && (obj1 = Globals.d().t()) != null && ((obj1 = (ImageViewer)((BaseActivity) (obj1)).findViewById(0x7f0c0720)) != null && ((ImageViewer) (obj1)).m != null))
            {
                ArrayList arraylist = new ArrayList();
                arraylist.add(ar1);
                ((ImageViewer) (obj1)).m.i = arraylist;
                ((ImageViewer) (obj1)).m.j = 0;
                ((a) (obj)).a(arraylist, 0);
                ((a) (obj)).f().a(Boolean.valueOf(((ar)arraylist.get(0)).f));
                b(true);
                return;
            }
        }
    }

    public void a(aw aw1)
    {
        Object obj = Long.valueOf(l());
        if (com.cyberlink.youcammakeup.database.g.a(((Long) (obj)).longValue()) || com.cyberlink.youcammakeup.kernelctrl.viewengine.i.a(((Long) (obj)).longValue())) goto _L2; else goto _L1
_L1:
        if (aw1 != null)
        {
            aw1.a();
        }
_L4:
        return;
_L2:
        a a1;
        a1 = c(((Long) (obj)).longValue()).e();
        if (a1 != null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (aw1 != null)
        {
            aw1.a();
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        a a2;
        Object obj1;
        a2 = f(((Long) (obj)).longValue());
        obj1 = Globals.d().t();
        if (obj1 != null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (aw1 != null)
        {
            aw1.a();
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
        obj1 = (ImageViewer)((BaseActivity) (obj1)).findViewById(0x7f0c0720);
        if (a2.e == -2)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj1 != null && ((ImageViewer) (obj1)).m != null)
        {
            ((ImageViewer) (obj1)).m.i = a2.d();
            ((ImageViewer) (obj1)).m.j = a2.e;
        }
        if (aw1 != null)
        {
            aw1.a(a2.d());
            return;
        }
        if (true) goto _L4; else goto _L6
_L6:
        obj = ViewEngine.a().a(((Long) (obj)).longValue(), 1.0D, null);
        if (obj == null)
        {
            if (aw1 != null)
            {
                aw1.a();
                return;
            }
        } else
        {
            VenusHelper.a().a(((ImageBufferWrapper) (obj)), a1.d, new aw(((ImageViewer) (obj1)), a1, a2, ((ImageBufferWrapper) (obj)), aw1) {

                final ImageViewer a;
                final a b;
                final a c;
                final ImageBufferWrapper d;
                final aw e;
                final StatusManager f;

                public void a()
                {
                    d.m();
                    f.b(false);
                    if (e != null)
                    {
                        e.a();
                    }
                }

                public void a(List list)
                {
                    Integer integer;
                    if (list.size() > 0)
                    {
                        integer = Integer.valueOf(VenusHelper.a(list));
                    } else
                    {
                        integer = Integer.valueOf(-1);
                    }
                    if (a != null && a.m != null)
                    {
                        a.m.i = list;
                        a.m.j = integer.intValue();
                    }
                    b.a(list, integer.intValue());
                    if (list != null && integer.intValue() >= 0 && list.get(integer.intValue()) != null && ((ar)list.get(integer.intValue())).d != null)
                    {
                        MotionControlHelper.e().b(((ar)list.get(integer.intValue())).d.b());
                    }
                    if (list != null && integer.intValue() >= 0 && list.get(integer.intValue()) != null && ((ar)list.get(integer.intValue())).e != null)
                    {
                        MotionControlHelper.e().c(((ar)list.get(integer.intValue())).e.b());
                    }
                    if (list != null && integer.intValue() >= 0 && list.get(integer.intValue()) != null)
                    {
                        MotionControlHelper.e().a(Boolean.valueOf(((ar)list.get(integer.intValue())).f), false);
                        MotionControlHelper.e().a(((ar)list.get(integer.intValue())).g.a(), ((ar)list.get(integer.intValue())).g.b());
                        c.f().a(MotionControlHelper.e().f());
                    }
                    d.m();
                    f.b(true);
                    if (e != null)
                    {
                        e.a(list);
                    }
                }

            
            {
                f = StatusManager.this;
                a = imageviewer;
                b = a1;
                c = a2;
                d = imagebufferwrapper;
                e = aw1;
                super();
            }
            });
            return;
        }
        if (true) goto _L4; else goto _L7
_L7:
    }

    public void a(aw aw1, List list)
    {
        Object obj = Long.valueOf(l());
        if (com.cyberlink.youcammakeup.database.g.a(((Long) (obj)).longValue()) || com.cyberlink.youcammakeup.kernelctrl.viewengine.i.a(((Long) (obj)).longValue())) goto _L2; else goto _L1
_L1:
        if (aw1 != null)
        {
            aw1.a();
        }
_L4:
        return;
_L2:
        a a1;
        a1 = c(((Long) (obj)).longValue()).e();
        if (a1 != null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (aw1 != null)
        {
            aw1.a();
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        a a2;
        a2 = f(((Long) (obj)).longValue());
        obj = Globals.d().t();
        if (obj != null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (aw1 != null)
        {
            aw1.a();
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
        ImageViewer imageviewer;
        imageviewer = (ImageViewer)((BaseActivity) (obj)).findViewById(0x7f0c0720);
        if (a2.e == -2)
        {
            break; /* Loop/switch isn't completed */
        }
        if (imageviewer != null && imageviewer.m != null)
        {
            imageviewer.m.i = a2.d();
            imageviewer.m.j = a2.e;
        }
        if (aw1 != null)
        {
            aw1.a(a2.d());
            return;
        }
        if (true) goto _L4; else goto _L6
_L6:
        Integer integer;
        if (list.size() > 0)
        {
            integer = Integer.valueOf(VenusHelper.a(list));
        } else
        {
            integer = Integer.valueOf(-1);
        }
        if (imageviewer != null && imageviewer.m != null)
        {
            imageviewer.m.i = list;
            imageviewer.m.j = integer.intValue();
        }
        a1.a(list, integer.intValue());
        if (list != null && integer.intValue() >= 0 && list.get(integer.intValue()) != null && ((ar)list.get(integer.intValue())).d != null)
        {
            MotionControlHelper.e().b(((ar)list.get(integer.intValue())).d.b());
        }
        if (list != null && integer.intValue() >= 0 && list.get(integer.intValue()) != null && ((ar)list.get(integer.intValue())).e != null)
        {
            MotionControlHelper.e().c(((ar)list.get(integer.intValue())).e.b());
        }
        if (list != null && integer.intValue() >= 0 && list.get(integer.intValue()) != null)
        {
            MotionControlHelper.e().a(Boolean.valueOf(((ar)list.get(integer.intValue())).f), false);
            MotionControlHelper.e().a(((ar)list.get(integer.intValue())).g.a(), ((ar)list.get(integer.intValue())).g.b());
            a2.f().a(MotionControlHelper.e().f());
        }
        b(true);
        if (aw1 != null)
        {
            aw1.a(list);
            return;
        }
        if (true) goto _L4; else goto _L7
_L7:
    }

    public void a(com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.d d1, BeautifierTaskInfo beautifiertaskinfo)
    {
        mHandler.post(new Runnable(d1, beautifiertaskinfo) {

            final com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.d a;
            final BeautifierTaskInfo b;
            final StatusManager c;

            public void run()
            {
                int i1 = 0;
                StatusManager statusmanager = c;
                statusmanager;
                JVM INSTR monitorenter ;
                h ah[];
                int j1;
                ah = (h[])com.cyberlink.youcammakeup.kernelctrl.status.StatusManager.i(c).toArray(new h[0]);
                j1 = ah.length;
_L2:
                if (i1 >= j1)
                {
                    break; /* Loop/switch isn't completed */
                }
                ah[i1].a(a, b);
                i1++;
                if (true) goto _L2; else goto _L1
_L1:
                statusmanager;
                JVM INSTR monitorexit ;
                return;
                Exception exception;
                exception;
                statusmanager;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                c = StatusManager.this;
                a = d1;
                b = beautifiertaskinfo;
                super();
            }
        });
    }

    public void a(com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i i1)
    {
        curMakeupState = i1;
    }

    public void a(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName buffername, Long long1)
    {
        mHandler.post(new Runnable(buffername, long1) {

            final com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName a;
            final Long b;
            final StatusManager c;

            public void run()
            {
                int i1 = 0;
                StatusManager statusmanager = c;
                statusmanager;
                JVM INSTR monitorenter ;
                m am[];
                int j1;
                am = (m[])StatusManager.k(c).toArray(new m[0]);
                j1 = am.length;
_L2:
                if (i1 >= j1)
                {
                    break; /* Loop/switch isn't completed */
                }
                am[i1].a(a, b);
                i1++;
                if (true) goto _L2; else goto _L1
_L1:
                statusmanager;
                JVM INSTR monitorexit ;
                return;
                Exception exception;
                exception;
                statusmanager;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                c = StatusManager.this;
                a = buffername;
                b = long1;
                super();
            }
        });
    }

    public void a(ae ae, int i1)
    {
        mHandler.post(new Runnable(ae, i1) {

            final ae a;
            final int b;
            final StatusManager c;

            public void run()
            {
                int j1 = 0;
                StatusManager statusmanager = c;
                statusmanager;
                JVM INSTR monitorenter ;
                x ax1[];
                int k1;
                ax1 = (x[])StatusManager.n(c).toArray(new x[0]);
                k1 = ax1.length;
_L2:
                if (j1 >= k1)
                {
                    break; /* Loop/switch isn't completed */
                }
                ax1[j1].a(a, b);
                j1++;
                if (true) goto _L2; else goto _L1
_L1:
                statusmanager;
                JVM INSTR monitorexit ;
                return;
                Exception exception;
                exception;
                statusmanager;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                c = StatusManager.this;
                a = ae;
                b = i1;
                super();
            }
        });
    }

    void a(ImageStateChangedEvent imagestatechangedevent)
    {
        mHandler.post(new Runnable(imagestatechangedevent) {

            final ImageStateChangedEvent a;
            final StatusManager b;

            public void run()
            {
                int i1 = 0;
                StatusManager statusmanager = b;
                statusmanager;
                JVM INSTR monitorenter ;
                ag aag[];
                int j1;
                aag = (ag[])StatusManager.h(b).toArray(new ag[0]);
                j1 = aag.length;
_L2:
                if (i1 >= j1)
                {
                    break; /* Loop/switch isn't completed */
                }
                aag[i1].a(a);
                i1++;
                if (true) goto _L2; else goto _L1
_L1:
                statusmanager;
                JVM INSTR monitorexit ;
                return;
                Exception exception;
                exception;
                statusmanager;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                b = StatusManager.this;
                a = imagestatechangedevent;
                super();
            }
        });
    }

    public void a(WigWarpState wigwarpstate)
    {
        mHandler.post(new Runnable(wigwarpstate) {

            final WigWarpState a;
            final StatusManager b;

            public void run()
            {
                int i1 = 0;
                StatusManager statusmanager = b;
                statusmanager;
                JVM INSTR monitorenter ;
                ap aap[];
                int j1;
                aap = (ap[])StatusManager.C(b).toArray(new ap[0]);
                j1 = aap.length;
_L2:
                if (i1 >= j1)
                {
                    break; /* Loop/switch isn't completed */
                }
                aap[i1].a(a);
                i1++;
                if (true) goto _L2; else goto _L1
_L1:
                statusmanager;
                JVM INSTR monitorexit ;
                return;
                Exception exception;
                exception;
                statusmanager;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                b = StatusManager.this;
                a = wigwarpstate;
                super();
            }
        });
    }

    public void a(a a1, ImageBufferWrapper imagebufferwrapper)
    {
        c(a1.a).a(a1, imagebufferwrapper);
    }

    public void a(a a1, ImageBufferWrapper imagebufferwrapper, d d1)
    {
        if (a1 == null)
        {
            if (d1 != null)
            {
                d1.b();
            }
            return;
        } else
        {
            long l1 = a1.a;
            com.cyberlink.youcammakeup.kernelctrl.status.d d2 = j().c(l1);
            (new c(d2, a1, imagebufferwrapper, new d(d1) {

                final d b;
                final StatusManager c;

                public void a()
                {
                    if (b != null)
                    {
                        b.a();
                    }
                }

                public void b()
                {
                    if (b != null)
                    {
                        b.b();
                    }
                }

                public void c()
                {
                    if (b != null)
                    {
                        b.c();
                    }
                }

            
            {
                c = StatusManager.this;
                b = d1;
                super();
            }
            })).executeOnExecutor(d2.c(), new Void[0]);
            return;
        }
    }

    public void a(a a1, ImageBufferWrapper imagebufferwrapper, ImageBufferWrapper imagebufferwrapper1)
    {
        sessionManagerLocal.a(a1, imagebufferwrapper, imagebufferwrapper1);
    }

    public void a(aa aa)
    {
        this;
        JVM INSTR monitorenter ;
        if (!mHideBottomToolBarObserver.contains(aa))
        {
            mHideBottomToolBarObserver.add(aa);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        aa;
        this;
        JVM INSTR monitorexit ;
        throw aa;
    }

    public void a(ad ad)
    {
        this;
        JVM INSTR monitorenter ;
        if (!mImageIDObservers.contains(ad))
        {
            mImageIDObservers.add(ad);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        ad;
        this;
        JVM INSTR monitorexit ;
        throw ad;
    }

    public void a(com.cyberlink.youcammakeup.kernelctrl.status.ae ae)
    {
        this;
        JVM INSTR monitorenter ;
        if (!mImageInfoObserver.contains(ae))
        {
            mImageInfoObserver.add(ae);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        ae;
        this;
        JVM INSTR monitorexit ;
        throw ae;
    }

    public void a(af af)
    {
        this;
        JVM INSTR monitorenter ;
        if (!mImagePropertyObservers.contains(af))
        {
            mImagePropertyObservers.add(af);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        af;
        this;
        JVM INSTR monitorexit ;
        throw af;
    }

    public void a(ag ag)
    {
        this;
        JVM INSTR monitorenter ;
        if (!mImageStateInfoObserver.contains(ag))
        {
            mImageStateInfoObserver.add(ag);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        ag;
        this;
        JVM INSTR monitorexit ;
        throw ag;
    }

    public void a(ah ah)
    {
        this;
        JVM INSTR monitorenter ;
        if (!mIntroDialogObserver.contains(ah))
        {
            mIntroDialogObserver.add(ah);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        ah;
        this;
        JVM INSTR monitorexit ;
        throw ah;
    }

    public void a(com.cyberlink.youcammakeup.kernelctrl.status.ai ai)
    {
        this;
        JVM INSTR monitorenter ;
        if (!mLookImageAdapterReadyObservers.contains(ai))
        {
            mLookImageAdapterReadyObservers.add(ai);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        ai;
        this;
        JVM INSTR monitorexit ;
        throw ai;
    }

    public void a(aj aj)
    {
        this;
        JVM INSTR monitorenter ;
        if (!mMakeupModeChangeObserver.contains(aj))
        {
            mMakeupModeChangeObserver.add(aj);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        aj;
        this;
        JVM INSTR monitorexit ;
        throw aj;
    }

    public void a(ak ak)
    {
        this;
        JVM INSTR monitorenter ;
        if (!mMotionControlObserver.contains(ak))
        {
            mMotionControlObserver.add(ak);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        ak;
        this;
        JVM INSTR monitorexit ;
        throw ak;
    }

    public void a(al al)
    {
        this;
        JVM INSTR monitorenter ;
        if (!mNullImagePathObserver.contains(al))
        {
            mNullImagePathObserver.add(al);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        al;
        this;
        JVM INSTR monitorexit ;
        throw al;
    }

    public void a(am am)
    {
        this;
        JVM INSTR monitorenter ;
        if (!mPatternChangeObserver.contains(am))
        {
            mPatternChangeObserver.add(am);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        am;
        this;
        JVM INSTR monitorexit ;
        throw am;
    }

    public void a(an an)
    {
        this;
        JVM INSTR monitorenter ;
        if (!mPatternsChangeObserver.contains(an))
        {
            mPatternsChangeObserver.add(an);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        an;
        this;
        JVM INSTR monitorexit ;
        throw an;
    }

    public void a(ap ap)
    {
        this;
        JVM INSTR monitorenter ;
        if (!mWigWarpObserver.contains(ap))
        {
            mWigWarpObserver.add(ap);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        ap;
        this;
        JVM INSTR monitorexit ;
        throw ap;
    }

    public void a(com.cyberlink.youcammakeup.kernelctrl.status.g g1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!mAdjustSettingObservers.contains(g1))
        {
            mAdjustSettingObservers.add(g1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        g1;
        this;
        JVM INSTR monitorexit ;
        throw g1;
    }

    public void a(h h1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!mBeautifierSettingObservers.contains(h1))
        {
            mBeautifierSettingObservers.add(h1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        h1;
        this;
        JVM INSTR monitorexit ;
        throw h1;
    }

    public void a(com.cyberlink.youcammakeup.kernelctrl.status.i i1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!mBeautyFilmMetadataObserver.contains(i1))
        {
            mBeautyFilmMetadataObserver.add(i1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        i1;
        this;
        JVM INSTR monitorexit ;
        throw i1;
    }

    public void a(k k1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!mBirdViewStateChangeObserver.contains(k1))
        {
            mBirdViewStateChangeObserver.add(k1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        k1;
        this;
        JVM INSTR monitorexit ;
        throw k1;
    }

    public void a(l l1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!mCurAlbumIDObserver.contains(l1))
        {
            mCurAlbumIDObserver.add(l1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        l1;
        this;
        JVM INSTR monitorexit ;
        throw l1;
    }

    public void a(m m1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!mImageBufferRenderObservers.contains(m1))
        {
            mImageBufferRenderObservers.add(m1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        m1;
        this;
        JVM INSTR monitorexit ;
        throw m1;
    }

    public void a(n n1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!mCurPanelObservers.contains(n1))
        {
            mCurPanelObservers.add(n1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        n1;
        this;
        JVM INSTR monitorexit ;
        throw n1;
    }

    public void a(p p1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!mDecodeImageFailObserver.contains(p1))
        {
            mDecodeImageFailObserver.add(p1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        p1;
        this;
        JVM INSTR monitorexit ;
        throw p1;
    }

    public void a(com.cyberlink.youcammakeup.kernelctrl.status.q q1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!mDevSettingObservers.contains(q1))
        {
            mDevSettingObservers.add(q1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        q1;
        this;
        JVM INSTR monitorexit ;
        throw q1;
    }

    public void a(u u1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!mEditViewTouchStatusObserver.contains(u1))
        {
            mEditViewTouchStatusObserver.add(u1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        u1;
        this;
        JVM INSTR monitorexit ;
        throw u1;
    }

    public void a(com.cyberlink.youcammakeup.kernelctrl.status.v v1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!mFaceChangeObserver.contains(v1))
        {
            mFaceChangeObserver.add(v1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        v1;
        this;
        JVM INSTR monitorexit ;
        throw v1;
    }

    public void a(w w1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!mFaceInfoInitObserver.contains(w1))
        {
            mFaceInfoInitObserver.add(w1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        w1;
        this;
        JVM INSTR monitorexit ;
        throw w1;
    }

    public void a(x x1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!mFacePointChangeObserver.contains(x1))
        {
            mFacePointChangeObserver.add(x1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        x1;
        this;
        JVM INSTR monitorexit ;
        throw x1;
    }

    public void a(com.cyberlink.youcammakeup.kernelctrl.status.y y1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!mFeaturePointsObservers.contains(y1))
        {
            mFeaturePointsObservers.add(y1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        y1;
        this;
        JVM INSTR monitorexit ;
        throw y1;
    }

    public void a(z z1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!mFPtsFadeOutObserver.contains(z1))
        {
            mFPtsFadeOutObserver.add(z1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        z1;
        this;
        JVM INSTR monitorexit ;
        throw z1;
    }

    public void a(BeautyMode beautymode)
    {
        currentBeautyMode = beautymode;
        b(currentBeautyMode);
    }

    public void a(BeautyMode beautymode, boolean flag)
    {
        currentBeautyMode = beautymode;
        if (flag)
        {
            b(currentBeautyMode);
        }
    }

    public void a(MakeupMode makeupmode)
    {
        currentMakeupMode = makeupmode;
        b(currentMakeupMode);
    }

    public void a(MakeupMode makeupmode, boolean flag)
    {
        currentMakeupMode = makeupmode;
        if (flag)
        {
            b(currentMakeupMode);
        }
    }

    public void a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.MotionName motionname, boolean flag)
    {
        mHandler.post(new Runnable(motionname, flag) {

            final com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.MotionName a;
            final boolean b;
            final StatusManager c;

            public void run()
            {
                int i1 = 0;
                StatusManager statusmanager = c;
                statusmanager;
                JVM INSTR monitorenter ;
                ak aak[];
                int j1;
                aak = (ak[])StatusManager.B(c).toArray(new ak[0]);
                j1 = aak.length;
_L2:
                if (i1 >= j1)
                {
                    break; /* Loop/switch isn't completed */
                }
                aak[i1].a(a, b);
                i1++;
                if (true) goto _L2; else goto _L1
_L1:
                statusmanager;
                JVM INSTR monitorexit ;
                return;
                Exception exception;
                exception;
                statusmanager;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                c = StatusManager.this;
                a = motionname;
                b = flag;
                super();
            }
        });
    }

    public void a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode switchermode)
    {
        PalettesMode = switchermode;
    }

    public void a(Boolean boolean1)
    {
        bBtnClickable = boolean1;
    }

    public void a(Boolean boolean1, Boolean boolean2, Boolean boolean3, Boolean boolean4, Boolean boolean5)
    {
        EditViewActivity editviewactivity = Globals.d().t();
        if (editviewactivity != null)
        {
            editviewactivity.a(boolean1, boolean2, boolean3, boolean4, boolean5);
        }
    }

    public void a(Object obj)
    {
        if (mCurView == obj)
        {
            return;
        } else
        {
            mCurView = obj;
            obj = mCurView;
            mHandler.post(new Runnable(obj) {

                final Object a;
                final StatusManager b;

                public void run()
                {
                    int i1 = 0;
                    StatusManager statusmanager = b;
                    statusmanager;
                    JVM INSTR monitorenter ;
                    com.cyberlink.youcammakeup.kernelctrl.status.o ao1[];
                    int j1;
                    ao1 = (com.cyberlink.youcammakeup.kernelctrl.status.o[])StatusManager.e(b).toArray(new com.cyberlink.youcammakeup.kernelctrl.status.o[0]);
                    j1 = ao1.length;
_L2:
                    if (i1 >= j1)
                    {
                        break; /* Loop/switch isn't completed */
                    }
                    ao1[i1].a(a);
                    i1++;
                    if (true) goto _L2; else goto _L1
_L1:
                    statusmanager;
                    JVM INSTR monitorexit ;
                    return;
                    Exception exception;
                    exception;
                    statusmanager;
                    JVM INSTR monitorexit ;
                    throw exception;
                }

            
            {
                b = StatusManager.this;
                a = obj;
                super();
            }
            });
            return;
        }
    }

    public void a(String s1)
    {
        mCurCategoryName = s1;
    }

    public transient void a(String s1, boolean flag, Float afloat[])
    {
        mHandler.post(new Runnable(s1, flag, afloat) {

            final String a;
            final boolean b;
            final Float c[];
            final StatusManager d;

            public void run()
            {
                int i1 = 0;
                StatusManager statusmanager = d;
                statusmanager;
                JVM INSTR monitorenter ;
                am aam[];
                int j1;
                aam = (am[])StatusManager.x(d).toArray(new am[0]);
                j1 = aam.length;
_L2:
                if (i1 >= j1)
                {
                    break; /* Loop/switch isn't completed */
                }
                aam[i1].a(a, b, c);
                i1++;
                if (true) goto _L2; else goto _L1
_L1:
                statusmanager;
                JVM INSTR monitorexit ;
                return;
                Exception exception;
                exception;
                statusmanager;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                d = StatusManager.this;
                a = s1;
                b = flag;
                c = afloat;
                super();
            }
        });
    }

    public void a(List list)
    {
        mCurQueryMetadata = list;
    }

    public void a(List list, UUID uuid)
    {
        if (mCurImageIDArray == list)
        {
            return;
        }
        mCurImageIDArray = list;
        Object obj;
        if (mCurImageIDArray == null)
        {
            list = null;
        } else
        {
            list = Collections.unmodifiableList(mCurImageIDArray);
        }
        obj = mCurView;
        mHandler.post(new Runnable(list, obj, uuid) {

            final List a;
            final Object b;
            final UUID c;
            final StatusManager d;

            public void run()
            {
                int i1 = 0;
                StatusManager statusmanager = d;
                statusmanager;
                JVM INSTR monitorenter ;
                ac aac[];
                int j1;
                aac = (ac[])com.cyberlink.youcammakeup.kernelctrl.status.StatusManager.d(d).toArray(new ac[0]);
                j1 = aac.length;
_L2:
                if (i1 >= j1)
                {
                    break; /* Loop/switch isn't completed */
                }
                aac[i1].a(a, b, c);
                i1++;
                if (true) goto _L2; else goto _L1
_L1:
                statusmanager;
                JVM INSTR monitorexit ;
                return;
                Exception exception;
                exception;
                statusmanager;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                d = StatusManager.this;
                a = list;
                b = obj;
                c = uuid;
                super();
            }
        });
    }

    public void a(List list, boolean flag)
    {
        list = Collections.unmodifiableList(list);
        mHandler.post(new Runnable(list, flag) {

            final List a;
            final boolean b;
            final StatusManager c;

            public void run()
            {
                int i1 = 0;
                StatusManager statusmanager = c;
                statusmanager;
                JVM INSTR monitorenter ;
                an aan[];
                int j1;
                aan = (an[])com.cyberlink.youcammakeup.kernelctrl.status.StatusManager.y(c).toArray(new an[0]);
                j1 = aan.length;
_L2:
                if (i1 >= j1)
                {
                    break; /* Loop/switch isn't completed */
                }
                aan[i1].a(a, b);
                i1++;
                if (true) goto _L2; else goto _L1
_L1:
                statusmanager;
                JVM INSTR monitorexit ;
                return;
                Exception exception;
                exception;
                statusmanager;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                c = StatusManager.this;
                a = list;
                b = flag;
                super();
            }
        });
    }

    public void a(boolean flag)
    {
        mHandler.post(new Runnable(flag) {

            final boolean a;
            final StatusManager b;

            public void run()
            {
                int i1 = 0;
                StatusManager statusmanager = b;
                statusmanager;
                JVM INSTR monitorenter ;
                h ah[];
                int j1;
                ah = (h[])com.cyberlink.youcammakeup.kernelctrl.status.StatusManager.i(b).toArray(new h[0]);
                j1 = ah.length;
_L2:
                if (i1 >= j1)
                {
                    break; /* Loop/switch isn't completed */
                }
                ah[i1].a(a);
                i1++;
                if (true) goto _L2; else goto _L1
_L1:
                statusmanager;
                JVM INSTR monitorexit ;
                return;
                Exception exception;
                exception;
                statusmanager;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                b = StatusManager.this;
                a = flag;
                super();
            }
        });
    }

    public void a(boolean flag, com.cyberlink.youcammakeup.utility.IntroDialogUtils.IntroDialogType introdialogtype)
    {
        mHandler.post(new Runnable(flag, introdialogtype) {

            final boolean a;
            final com.cyberlink.youcammakeup.utility.IntroDialogUtils.IntroDialogType b;
            final StatusManager c;

            public void run()
            {
                int i1 = 0;
                StatusManager statusmanager = c;
                statusmanager;
                JVM INSTR monitorenter ;
                ah aah[];
                int j1;
                aah = (ah[])StatusManager.s(c).toArray(new ah[0]);
                j1 = aah.length;
_L2:
                if (i1 >= j1)
                {
                    break; /* Loop/switch isn't completed */
                }
                aah[i1].a(a, b);
                i1++;
                if (true) goto _L2; else goto _L1
_L1:
                statusmanager;
                JVM INSTR monitorexit ;
                return;
                Exception exception;
                exception;
                statusmanager;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                c = StatusManager.this;
                a = flag;
                b = introdialogtype;
                super();
            }
        });
    }

    public long b()
    {
        return mCurCategoryId;
    }

    public void b(long l1)
    {
        if (mCurAlbumID == l1)
        {
            return;
        } else
        {
            mCurAlbumID = l1;
            mPosOfCurAlbum = 0;
            mHandler.post(new Runnable(l1) {

                final long a;
                final StatusManager b;

                public void run()
                {
                    int i1 = 0;
                    StatusManager statusmanager = b;
                    statusmanager;
                    JVM INSTR monitorenter ;
                    l al[];
                    int j1;
                    al = (l[])StatusManager.f(b).toArray(new l[0]);
                    j1 = al.length;
_L2:
                    if (i1 >= j1)
                    {
                        break; /* Loop/switch isn't completed */
                    }
                    al[i1].a(a);
                    i1++;
                    if (true) goto _L2; else goto _L1
_L1:
                    statusmanager;
                    JVM INSTR monitorexit ;
                    return;
                    Exception exception;
                    exception;
                    statusmanager;
                    JVM INSTR monitorexit ;
                    throw exception;
                }

            
            {
                b = StatusManager.this;
                a = l1;
                super();
            }
            });
            return;
        }
    }

    public void b(FragmentManager fragmentmanager, DialogFragment dialogfragment, String s1)
    {
        fragmentmanager = new r(this, fragmentmanager, dialogfragment, s1);
        if (dialogfragment != null)
        {
            if (mPauseShowDlgFragment != null && mPauseShowDlgFragment.a != null && mPauseShowDlgFragment.a.getClass() == dialogfragment.getClass())
            {
                mPauseShowDlgFragment = null;
                return;
            } else
            {
                fragmentmanager.a = null;
                mPauseHideDlgFragment = fragmentmanager;
                return;
            }
        } else
        {
            mPauseShowDlgFragment = null;
            return;
        }
    }

    public void b(a a1, ImageBufferWrapper imagebufferwrapper)
    {
        sessionManagerLocal.a(a1, imagebufferwrapper);
    }

    public void b(a a1, ImageBufferWrapper imagebufferwrapper, d d1)
    {
        sessionManagerLocal.a(a1, imagebufferwrapper, d1);
    }

    public void b(a a1, ImageBufferWrapper imagebufferwrapper, ImageBufferWrapper imagebufferwrapper1)
    {
        fineTuneSessionManagerLocal.a(a1, imagebufferwrapper, imagebufferwrapper1);
    }

    public void b(aa aa)
    {
        this;
        JVM INSTR monitorenter ;
        if (mHideBottomToolBarObserver.contains(aa))
        {
            mHideBottomToolBarObserver.remove(aa);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        aa;
        this;
        JVM INSTR monitorexit ;
        throw aa;
    }

    public void b(ad ad)
    {
        this;
        JVM INSTR monitorenter ;
        if (mImageIDObservers.contains(ad))
        {
            mImageIDObservers.remove(ad);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        ad;
        this;
        JVM INSTR monitorexit ;
        throw ad;
    }

    public void b(com.cyberlink.youcammakeup.kernelctrl.status.ae ae)
    {
        this;
        JVM INSTR monitorenter ;
        if (!mImageInfoObserver.contains(ae))
        {
            mImageInfoObserver.remove(ae);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        ae;
        this;
        JVM INSTR monitorexit ;
        throw ae;
    }

    public void b(af af)
    {
        this;
        JVM INSTR monitorenter ;
        if (mImagePropertyObservers.contains(af))
        {
            mImagePropertyObservers.remove(af);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        af;
        this;
        JVM INSTR monitorexit ;
        throw af;
    }

    public void b(ag ag)
    {
        this;
        JVM INSTR monitorenter ;
        if (mImageStateInfoObserver.contains(ag))
        {
            mImageStateInfoObserver.remove(ag);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        ag;
        this;
        JVM INSTR monitorexit ;
        throw ag;
    }

    public void b(ah ah)
    {
        this;
        JVM INSTR monitorenter ;
        if (mIntroDialogObserver.contains(ah))
        {
            mIntroDialogObserver.remove(ah);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        ah;
        this;
        JVM INSTR monitorexit ;
        throw ah;
    }

    public void b(com.cyberlink.youcammakeup.kernelctrl.status.ai ai)
    {
        this;
        JVM INSTR monitorenter ;
        if (mLookImageAdapterReadyObservers.contains(ai))
        {
            mLookImageAdapterReadyObservers.remove(ai);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        ai;
        this;
        JVM INSTR monitorexit ;
        throw ai;
    }

    public void b(aj aj)
    {
        this;
        JVM INSTR monitorenter ;
        if (mMakeupModeChangeObserver.contains(aj))
        {
            mMakeupModeChangeObserver.remove(aj);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        aj;
        this;
        JVM INSTR monitorexit ;
        throw aj;
    }

    public void b(ak ak)
    {
        this;
        JVM INSTR monitorenter ;
        if (mMotionControlObserver.contains(ak))
        {
            mMotionControlObserver.remove(ak);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        ak;
        this;
        JVM INSTR monitorexit ;
        throw ak;
    }

    public void b(al al)
    {
        this;
        JVM INSTR monitorenter ;
        if (mNullImagePathObserver.contains(al))
        {
            mNullImagePathObserver.remove(al);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        al;
        this;
        JVM INSTR monitorexit ;
        throw al;
    }

    public void b(am am)
    {
        this;
        JVM INSTR monitorenter ;
        if (mPatternChangeObserver.contains(am))
        {
            mPatternChangeObserver.remove(am);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        am;
        this;
        JVM INSTR monitorexit ;
        throw am;
    }

    public void b(an an)
    {
        this;
        JVM INSTR monitorenter ;
        if (mPatternsChangeObserver.contains(an))
        {
            mPatternsChangeObserver.remove(an);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        an;
        this;
        JVM INSTR monitorexit ;
        throw an;
    }

    public void b(ap ap)
    {
        this;
        JVM INSTR monitorenter ;
        if (mWigWarpObserver.contains(ap))
        {
            mWigWarpObserver.remove(ap);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        ap;
        this;
        JVM INSTR monitorexit ;
        throw ap;
    }

    public void b(com.cyberlink.youcammakeup.kernelctrl.status.i i1)
    {
        this;
        JVM INSTR monitorenter ;
        if (mBeautyFilmMetadataObserver.contains(i1))
        {
            mBeautyFilmMetadataObserver.remove(i1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        i1;
        this;
        JVM INSTR monitorexit ;
        throw i1;
    }

    public void b(k k1)
    {
        this;
        JVM INSTR monitorenter ;
        if (mBirdViewStateChangeObserver.contains(k1))
        {
            mBirdViewStateChangeObserver.remove(k1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        k1;
        this;
        JVM INSTR monitorexit ;
        throw k1;
    }

    public void b(l l1)
    {
        this;
        JVM INSTR monitorenter ;
        if (mCurAlbumIDObserver.contains(l1))
        {
            mCurAlbumIDObserver.remove(l1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        l1;
        this;
        JVM INSTR monitorexit ;
        throw l1;
    }

    public void b(m m1)
    {
        this;
        JVM INSTR monitorenter ;
        if (mImageBufferRenderObservers.contains(m1))
        {
            mImageBufferRenderObservers.remove(m1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        m1;
        this;
        JVM INSTR monitorexit ;
        throw m1;
    }

    public void b(n n1)
    {
        this;
        JVM INSTR monitorenter ;
        if (mCurPanelObservers.contains(n1))
        {
            mCurPanelObservers.remove(n1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        n1;
        this;
        JVM INSTR monitorexit ;
        throw n1;
    }

    public void b(p p1)
    {
        this;
        JVM INSTR monitorenter ;
        if (mDecodeImageFailObserver.contains(p1))
        {
            mDecodeImageFailObserver.remove(p1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        p1;
        this;
        JVM INSTR monitorexit ;
        throw p1;
    }

    public void b(com.cyberlink.youcammakeup.kernelctrl.status.q q1)
    {
        this;
        JVM INSTR monitorenter ;
        if (mDevSettingObservers.contains(q1))
        {
            mDevSettingObservers.remove(q1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        q1;
        this;
        JVM INSTR monitorexit ;
        throw q1;
    }

    public void b(u u1)
    {
        this;
        JVM INSTR monitorenter ;
        if (mEditViewTouchStatusObserver.contains(u1))
        {
            mEditViewTouchStatusObserver.remove(u1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        u1;
        this;
        JVM INSTR monitorexit ;
        throw u1;
    }

    public void b(w w1)
    {
        this;
        JVM INSTR monitorenter ;
        if (mFaceInfoInitObserver.contains(w1))
        {
            mFaceInfoInitObserver.remove(w1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        w1;
        this;
        JVM INSTR monitorexit ;
        throw w1;
    }

    public void b(x x1)
    {
        this;
        JVM INSTR monitorenter ;
        if (mFacePointChangeObserver.contains(x1))
        {
            mFacePointChangeObserver.remove(x1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        x1;
        this;
        JVM INSTR monitorexit ;
        throw x1;
    }

    public void b(com.cyberlink.youcammakeup.kernelctrl.status.y y1)
    {
        this;
        JVM INSTR monitorenter ;
        if (mFeaturePointsObservers.contains(y1))
        {
            mFeaturePointsObservers.remove(y1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        y1;
        this;
        JVM INSTR monitorexit ;
        throw y1;
    }

    public void b(z z1)
    {
        this;
        JVM INSTR monitorenter ;
        if (mFPtsFadeOutObserver.contains(z1))
        {
            mFPtsFadeOutObserver.remove(z1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        z1;
        this;
        JVM INSTR monitorexit ;
        throw z1;
    }

    public void b(BeautyMode beautymode)
    {
        mHandler.post(new Runnable(beautymode) {

            final BeautyMode a;
            final StatusManager b;

            public void run()
            {
                int i1 = 0;
                StatusManager statusmanager = b;
                statusmanager;
                JVM INSTR monitorenter ;
                j aj[];
                int j1;
                aj = (j[])StatusManager.u(b).toArray(new j[0]);
                j1 = aj.length;
_L2:
                if (i1 >= j1)
                {
                    break; /* Loop/switch isn't completed */
                }
                aj[i1].a(a);
                i1++;
                if (true) goto _L2; else goto _L1
_L1:
                statusmanager;
                JVM INSTR monitorexit ;
                return;
                Exception exception;
                exception;
                statusmanager;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                b = StatusManager.this;
                a = beautymode;
                super();
            }
        });
    }

    public void b(MakeupMode makeupmode)
    {
        mHandler.post(new Runnable(makeupmode) {

            final MakeupMode a;
            final StatusManager b;

            public void run()
            {
                int i1 = 0;
                StatusManager statusmanager = b;
                statusmanager;
                JVM INSTR monitorenter ;
                aj aaj[];
                int j1;
                aaj = (aj[])StatusManager.t(b).toArray(new aj[0]);
                j1 = aaj.length;
_L2:
                if (i1 >= j1)
                {
                    break; /* Loop/switch isn't completed */
                }
                aaj[i1].b(a);
                i1++;
                if (true) goto _L2; else goto _L1
_L1:
                statusmanager;
                JVM INSTR monitorexit ;
                return;
                Exception exception;
                exception;
                statusmanager;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                b = StatusManager.this;
                a = makeupmode;
                super();
            }
        });
    }

    public void b(String s1)
    {
        PatternGuid = s1;
    }

    public void b(List list)
    {
        patternGuids.clear();
        if (list != null)
        {
            patternGuids.addAll(list);
        }
    }

    public void b(boolean flag)
    {
        mHandler.post(new Runnable(flag) {

            final boolean a;
            final StatusManager b;

            public void run()
            {
                int i1 = 0;
                StatusManager statusmanager = b;
                statusmanager;
                JVM INSTR monitorenter ;
                w aw1[];
                int j1;
                aw1 = (w[])StatusManager.m(b).toArray(new w[0]);
                j1 = aw1.length;
_L2:
                if (i1 >= j1)
                {
                    break; /* Loop/switch isn't completed */
                }
                aw1[i1].n(a);
                i1++;
                if (true) goto _L2; else goto _L1
_L1:
                statusmanager;
                JVM INSTR monitorexit ;
                return;
                Exception exception;
                exception;
                statusmanager;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                b = StatusManager.this;
                a = flag;
                super();
            }
        });
    }

    public com.cyberlink.youcammakeup.kernelctrl.status.d c(long l1)
    {
        if (!sessionManagers.containsKey(Long.valueOf(l1)))
        {
            sessionManagers.put(Long.valueOf(l1), new com.cyberlink.youcammakeup.kernelctrl.status.d(l1, "_global"));
        }
        return (com.cyberlink.youcammakeup.kernelctrl.status.d)sessionManagers.get(Long.valueOf(l1));
    }

    public String c()
    {
        return mCurCategoryName;
    }

    public void c(a a1, ImageBufferWrapper imagebufferwrapper)
    {
        fineTuneSessionManagerLocal.a(a1, imagebufferwrapper);
    }

    public void c(a a1, ImageBufferWrapper imagebufferwrapper, d d1)
    {
        fineTuneSessionManagerLocal.a(a1, imagebufferwrapper, d1);
    }

    public void c(String s1)
    {
        mPaletteGuid = s1;
    }

    public void c(List list)
    {
        faceList = list;
    }

    public void c(boolean flag)
    {
        EditViewActivity editviewactivity = Globals.d().t();
        if (editviewactivity != null)
        {
            editviewactivity.m(flag);
        }
    }

    public com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i d()
    {
        return curMakeupState;
    }

    public void d(long l1)
    {
        if (!sessionManagers.containsKey(Long.valueOf(l1)))
        {
            return;
        } else
        {
            ((com.cyberlink.youcammakeup.kernelctrl.status.d)sessionManagers.get(Long.valueOf(l1))).a();
            sessionManagers.remove(Long.valueOf(l1));
            return;
        }
    }

    public void d(String s1)
    {
        mStyleGuid = s1;
    }

    public void d(boolean flag)
    {
        mEditViewTouchStatus = flag;
        flag = mEditViewTouchStatus;
        mHandler.post(new Runnable(flag) {

            final boolean a;
            final StatusManager b;

            public void run()
            {
                int i1 = 0;
                StatusManager statusmanager = b;
                statusmanager;
                JVM INSTR monitorenter ;
                u au[];
                int j1;
                au = (u[])StatusManager.r(b).toArray(new u[0]);
                j1 = au.length;
_L2:
                if (i1 >= j1)
                {
                    break; /* Loop/switch isn't completed */
                }
                au[i1].g(a);
                i1++;
                if (true) goto _L2; else goto _L1
_L1:
                statusmanager;
                JVM INSTR monitorexit ;
                return;
                Exception exception;
                exception;
                statusmanager;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                b = StatusManager.this;
                a = flag;
                super();
            }
        });
    }

    public String e()
    {
        return PatternGuid;
    }

    public void e(boolean flag)
    {
        mHandler.post(new Runnable(flag) {

            final boolean a;
            final StatusManager b;

            public void run()
            {
                int i1 = 0;
                StatusManager statusmanager = b;
                statusmanager;
                JVM INSTR monitorenter ;
                k ak[];
                int j1;
                ak = (k[])StatusManager.w(b).toArray(new k[0]);
                j1 = ak.length;
_L2:
                if (i1 >= j1)
                {
                    break; /* Loop/switch isn't completed */
                }
                ak[i1].h(a);
                i1++;
                if (true) goto _L2; else goto _L1
_L1:
                statusmanager;
                JVM INSTR monitorexit ;
                return;
                Exception exception;
                exception;
                statusmanager;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                b = StatusManager.this;
                a = flag;
                super();
            }
        });
    }

    public boolean e(long l1)
    {
        while (!sessionManagers.containsKey(Long.valueOf(l1)) || c(l1).e() == null) 
        {
            return false;
        }
        return true;
    }

    public a f(long l1)
    {
        return c(l1).e();
    }

    public List f()
    {
        return new ArrayList(patternGuids);
    }

    public void f(boolean flag)
    {
        isIntentFromLauncher = flag;
    }

    public com.cyberlink.youcammakeup.kernelctrl.status.d g(long l1)
    {
        return sessionManagerLocal.a(l1);
    }

    public String g()
    {
        return mPaletteGuid;
    }

    public void g(boolean flag)
    {
        isIntentFromCamera = flag;
    }

    public String h()
    {
        return mStyleGuid;
    }

    public boolean h(long l1)
    {
        return sessionManagerLocal.b(l1);
    }

    public a i(long l1)
    {
        return sessionManagerLocal.c(l1);
    }

    public com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode i()
    {
        return PalettesMode;
    }

    public com.cyberlink.youcammakeup.kernelctrl.status.d j(long l1)
    {
        return fineTuneSessionManagerLocal.a(l1);
    }

    public b k()
    {
        return mBeautyFilmMetadata;
    }

    public boolean k(long l1)
    {
        return fineTuneSessionManagerLocal.b(l1);
    }

    public long l()
    {
        return mCurImageID;
    }

    public a l(long l1)
    {
        return fineTuneSessionManagerLocal.c(l1);
    }

    public List m()
    {
        if (mCurImageIDArray == null)
        {
            return null;
        } else
        {
            return Collections.unmodifiableList(mCurImageIDArray);
        }
    }

    public long n()
    {
        return mCurReservedImageID;
    }

    public Object o()
    {
        return mCurView;
    }

    public long p()
    {
        return mCurAlbumID;
    }

    public int q()
    {
        return mPosOfCurAlbum;
    }

    public MakeupMode r()
    {
        return currentMakeupMode;
    }

    public BeautyMode s()
    {
        return currentBeautyMode;
    }

    public void t()
    {
        mHandler.post(new Runnable() {

            final StatusManager a;

            public void run()
            {
                int i1 = 0;
                StatusManager statusmanager = a;
                statusmanager;
                JVM INSTR monitorenter ;
                h ah[];
                int j1;
                ah = (h[])com.cyberlink.youcammakeup.kernelctrl.status.StatusManager.i(a).toArray(new h[0]);
                j1 = ah.length;
_L2:
                if (i1 >= j1)
                {
                    break; /* Loop/switch isn't completed */
                }
                ah[i1].b();
                i1++;
                if (true) goto _L2; else goto _L1
_L1:
                statusmanager;
                JVM INSTR monitorexit ;
                return;
                Exception exception;
                exception;
                statusmanager;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                a = StatusManager.this;
                super();
            }
        });
    }

    public void u()
    {
        mHandler.post(new Runnable() {

            final StatusManager a;

            public void run()
            {
                int i1 = 0;
                StatusManager statusmanager = a;
                statusmanager;
                JVM INSTR monitorenter ;
                com.cyberlink.youcammakeup.kernelctrl.status.ae aae[];
                int j1;
                aae = (com.cyberlink.youcammakeup.kernelctrl.status.ae[])StatusManager.l(a).toArray(new com.cyberlink.youcammakeup.kernelctrl.status.ae[0]);
                j1 = aae.length;
_L2:
                if (i1 >= j1)
                {
                    break; /* Loop/switch isn't completed */
                }
                aae[i1].f();
                i1++;
                if (true) goto _L2; else goto _L1
_L1:
                statusmanager;
                JVM INSTR monitorexit ;
                return;
                Exception exception;
                exception;
                statusmanager;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                a = StatusManager.this;
                super();
            }
        });
    }

    public void v()
    {
        mHandler.post(new Runnable() {

            final StatusManager a;

            public void run()
            {
                int i1 = 0;
                StatusManager statusmanager = a;
                statusmanager;
                JVM INSTR monitorenter ;
                al aal[];
                int j1;
                aal = (al[])com.cyberlink.youcammakeup.kernelctrl.status.StatusManager.o(a).toArray(new al[0]);
                j1 = aal.length;
_L2:
                if (i1 >= j1)
                {
                    break; /* Loop/switch isn't completed */
                }
                aal[i1].P();
                i1++;
                if (true) goto _L2; else goto _L1
_L1:
                statusmanager;
                JVM INSTR monitorexit ;
                return;
                Exception exception;
                exception;
                statusmanager;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                a = StatusManager.this;
                super();
            }
        });
    }

    public void w()
    {
        mHandler.post(new Runnable() {

            final StatusManager a;

            public void run()
            {
                int i1 = 0;
                StatusManager statusmanager = a;
                statusmanager;
                JVM INSTR monitorenter ;
                p ap[];
                int j1;
                ap = (p[])StatusManager.p(a).toArray(new p[0]);
                j1 = ap.length;
_L2:
                if (i1 >= j1)
                {
                    break; /* Loop/switch isn't completed */
                }
                ap[i1].Q();
                i1++;
                if (true) goto _L2; else goto _L1
_L1:
                statusmanager;
                JVM INSTR monitorexit ;
                return;
                Exception exception;
                exception;
                statusmanager;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                a = StatusManager.this;
                super();
            }
        });
    }

    public void x()
    {
        mHandler.post(new Runnable() {

            final StatusManager a;

            public void run()
            {
                int i1 = 0;
                StatusManager statusmanager = a;
                statusmanager;
                JVM INSTR monitorenter ;
                com.cyberlink.youcammakeup.kernelctrl.status.ai aai[];
                int j1;
                aai = (com.cyberlink.youcammakeup.kernelctrl.status.ai[])com.cyberlink.youcammakeup.kernelctrl.status.StatusManager.q(a).toArray(new com.cyberlink.youcammakeup.kernelctrl.status.ai[0]);
                j1 = aai.length;
_L2:
                if (i1 >= j1)
                {
                    break; /* Loop/switch isn't completed */
                }
                aai[i1].a();
                i1++;
                if (true) goto _L2; else goto _L1
_L1:
                statusmanager;
                JVM INSTR monitorexit ;
                return;
                Exception exception;
                exception;
                statusmanager;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                a = StatusManager.this;
                super();
            }
        });
    }

    public void y()
    {
        EditViewActivity editviewactivity = Globals.d().t();
        if (editviewactivity == null)
        {
            return;
        }
        long l1 = j().l();
        com.cyberlink.youcammakeup.kernelctrl.status.d d1;
        boolean flag;
        boolean flag1;
        boolean flag2;
        if (A())
        {
            d1 = j(l1);
        } else
        if (z())
        {
            d1 = c(l1);
        } else
        {
            d1 = g(l1);
        }
        flag1 = d1.h();
        flag2 = d1.j();
        if (flag1 || flag2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        editviewactivity.runOnUiThread(new Runnable(editviewactivity, flag1, flag2, flag) {

            final EditViewActivity a;
            final boolean b;
            final boolean c;
            final boolean d;
            final StatusManager e;

            public void run()
            {
                boolean flag4 = false;
                if (e.s() == BeautyMode.x)
                {
                    Object obj = MotionControlHelper.e().T();
                    boolean flag3;
                    boolean flag5;
                    boolean flag6;
                    boolean flag7;
                    if (obj != null)
                    {
                        flag3 = ((ai) (obj)).a();
                    } else
                    {
                        flag3 = false;
                    }
                    if (a.A())
                    {
                        a.c(b, c);
                        return;
                    }
                    obj = a;
                    flag5 = b;
                    flag6 = b;
                    flag7 = c;
                    if (d || flag3)
                    {
                        flag4 = true;
                    }
                    ((EditViewActivity) (obj)).a(Boolean.valueOf(flag5), Boolean.valueOf(flag6), Boolean.valueOf(flag7), Boolean.valueOf(flag4), null);
                    return;
                }
                if (a.A())
                {
                    a.c(b, c);
                    return;
                } else
                {
                    a.a(Boolean.valueOf(b), Boolean.valueOf(b), Boolean.valueOf(c), Boolean.valueOf(d), null);
                    return;
                }
            }

            
            {
                e = StatusManager.this;
                a = editviewactivity;
                b = flag;
                c = flag1;
                d = flag2;
                super();
            }
        });
    }

    public boolean z()
    {
        return s() == BeautyMode.D || r() == MakeupMode.a;
    }

}
