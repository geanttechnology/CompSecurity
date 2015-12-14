// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.sketch.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.flurry.android.FlurryAgent;
import com.fotoable.sketch.info.TTieZhiInfo;
import com.pipcamera.application.PIPCameraApplication;
import dt;
import du;
import ew;
import ge;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kf;
import ov;

// Referenced classes of package com.fotoable.sketch.view:
//            TTieZhiInfoView, TTieZhiHandleView

public class TTieZhiComposeView extends FrameLayout
{

    private ov lisener;
    private FrameLayout mComposeContainer;
    private DoubleTouchState mDoubleState;
    private EditState mEditState;
    private float mFaceAngle;
    private ge mFaceKeyPoint;
    private float mFaceScale;
    private GestureDetector mGestureDetector;
    private FrameLayout mHandleContainer;
    private TTieZhiHandleView mHandleView;
    private dt mRotateDetector;
    private ScaleGestureDetector mScaleDetector;
    private SingleTouchState mSingleState;
    private PointF moveStartPoint;
    TTieZhiInfoView selecTieZhiInfoView;
    private List tiezhiViews;

    public TTieZhiComposeView(Context context)
    {
        super(context);
        selecTieZhiInfoView = null;
        tiezhiViews = new ArrayList();
        moveStartPoint = new PointF();
        mSingleState = SingleTouchState.Single_default;
        mDoubleState = DoubleTouchState.Double_default;
        mEditState = EditState.Edit_None;
        mFaceScale = 1.0F;
        mFaceAngle = 0.0F;
        init();
    }

    public TTieZhiComposeView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        selecTieZhiInfoView = null;
        tiezhiViews = new ArrayList();
        moveStartPoint = new PointF();
        mSingleState = SingleTouchState.Single_default;
        mDoubleState = DoubleTouchState.Double_default;
        mEditState = EditState.Edit_None;
        mFaceScale = 1.0F;
        mFaceAngle = 0.0F;
        init();
    }

    public TTieZhiComposeView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        selecTieZhiInfoView = null;
        tiezhiViews = new ArrayList();
        moveStartPoint = new PointF();
        mSingleState = SingleTouchState.Single_default;
        mDoubleState = DoubleTouchState.Double_default;
        mEditState = EditState.Edit_None;
        mFaceScale = 1.0F;
        mFaceAngle = 0.0F;
        init();
    }

    private PointF addPointf(PointF pointf, PointF pointf1)
    {
        return new PointF(pointf.x + pointf1.x, pointf.y + pointf1.y);
    }

    private PointF averagePointf(PointF pointf, PointF pointf1)
    {
        return averagePointfWithScale(pointf, pointf1, 0.5F);
    }

    private PointF averagePointfWithScale(PointF pointf, PointF pointf1, float f)
    {
        return new PointF(pointf.x * (1.0F - f) + pointf1.x * f, pointf.y * (1.0F - f) + pointf1.y * f);
    }

    private void deleteAction()
    {
        if (selecTieZhiInfoView != null)
        {
            selecTieZhiInfoView.setSelected(false);
            tiezhiViews.remove(selecTieZhiInfoView);
            mComposeContainer.removeView(selecTieZhiInfoView);
            selecTieZhiInfoView = null;
            mHandleView.setNeedDraw(false);
            mHandleView.redrawView();
            if (lisener != null)
            {
                lisener.a(null);
            }
        }
    }

    private void flipActipn()
    {
        if (selecTieZhiInfoView != null)
        {
            selecTieZhiInfoView.flipBitmap();
        }
    }

    private TTieZhiInfoView getSelectedInfoView(MotionEvent motionevent)
    {
        TTieZhiInfoView ttiezhiinfoview;
        TTieZhiInfoView ttiezhiinfoview1;
        ttiezhiinfoview = null;
        ttiezhiinfoview1 = null;
        if (tiezhiViews.size() > 0) goto _L2; else goto _L1
_L1:
        return ttiezhiinfoview1;
_L2:
        int i = 0;
_L8:
        ttiezhiinfoview1 = ttiezhiinfoview;
        if (i >= tiezhiViews.size()) goto _L1; else goto _L3
_L3:
        TTieZhiInfoView ttiezhiinfoview2 = (TTieZhiInfoView)tiezhiViews.get(i);
        if (!ttiezhiinfoview2.isViewContains((int)motionevent.getX(), (int)motionevent.getY())) goto _L5; else goto _L4
_L4:
        if (ttiezhiinfoview != null) goto _L7; else goto _L6
_L6:
        ttiezhiinfoview1 = ttiezhiinfoview2;
_L9:
        i++;
        ttiezhiinfoview = ttiezhiinfoview1;
          goto _L8
_L7:
        ttiezhiinfoview1 = ttiezhiinfoview2;
        if (ttiezhiinfoview2.getContaintSize() < ttiezhiinfoview.getContaintSize()) goto _L9; else goto _L5
_L5:
        ttiezhiinfoview1 = ttiezhiinfoview;
          goto _L9
    }

    private void handleTapGesture(MotionEvent motionevent)
    {
        if (mEditState == EditState.Edit_Default || mEditState == EditState.Edit_None)
        {
            mEditState = EditState.Edit_Tap;
        }
    }

    private void init()
    {
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f030094, this, true);
        mComposeContainer = (FrameLayout)findViewById(0x7f0c0257);
        mHandleContainer = (FrameLayout)findViewById(0x7f0c0258);
        mHandleView = new TTieZhiHandleView(getContext());
        mHandleContainer.addView(mHandleView);
        mScaleDetector = new ScaleGestureDetector(getContext(), new android.view.ScaleGestureDetector.OnScaleGestureListener() {

            final TTieZhiComposeView a;

            public boolean onScale(ScaleGestureDetector scalegesturedetector)
            {
                if (a.selecTieZhiInfoView != null)
                {
                    a.selecTieZhiInfoView.storeTransform();
                    a.selecTieZhiInfoView.setNewScale(scalegesturedetector.getScaleFactor());
                    a.setEditBtnBy(a.selecTieZhiInfoView);
                }
                return true;
            }

            public boolean onScaleBegin(ScaleGestureDetector scalegesturedetector)
            {
                if (a.selecTieZhiInfoView != null)
                {
                    a.selecTieZhiInfoView.storeTransform();
                    a.selecTieZhiInfoView.invalidate();
                }
                return true;
            }

            public void onScaleEnd(ScaleGestureDetector scalegesturedetector)
            {
                if (a.selecTieZhiInfoView != null)
                {
                    a.selecTieZhiInfoView.storeTransform();
                    a.selecTieZhiInfoView.invalidate();
                }
            }

            
            {
                a = TTieZhiComposeView.this;
                super();
            }
        });
        mRotateDetector = new dt(getContext(), new du() {

            final TTieZhiComposeView a;

            public boolean a(dt dt1)
            {
                if (a.selecTieZhiInfoView != null)
                {
                    a.selecTieZhiInfoView.storeTransform();
                    a.selecTieZhiInfoView.setNewRotate((float)(((double)dt1.b() * 3.1415926535897931D) / 180D));
                    a.setEditBtnBy(a.selecTieZhiInfoView);
                }
                return true;
            }

            public boolean b(dt dt1)
            {
                if (a.selecTieZhiInfoView != null)
                {
                    a.selecTieZhiInfoView.storeTransform();
                    a.selecTieZhiInfoView.invalidate();
                }
                return true;
            }

            public void c(dt dt1)
            {
                if (a.selecTieZhiInfoView != null)
                {
                    a.selecTieZhiInfoView.storeTransform();
                    a.selecTieZhiInfoView.invalidate();
                }
            }

            
            {
                a = TTieZhiComposeView.this;
                super();
            }
        });
        mGestureDetector = new GestureDetector(getContext(), new android.view.GestureDetector.OnGestureListener() {

            final TTieZhiComposeView a;

            public boolean onDown(MotionEvent motionevent)
            {
                return true;
            }

            public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
            {
                return true;
            }

            public void onLongPress(MotionEvent motionevent)
            {
            }

            public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
            {
                return true;
            }

            public void onShowPress(MotionEvent motionevent)
            {
            }

            public boolean onSingleTapUp(MotionEvent motionevent)
            {
                a.handleTapGesture(motionevent);
                return false;
            }

            
            {
                a = TTieZhiComposeView.this;
                super();
            }
        });
    }

    private void makeScaleAnimation(View view, boolean flag)
    {
        if (view == null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        if (view.getVisibility() != 0)
        {
            return;
        }
        try
        {
            Animation animation = AnimationUtils.loadAnimation(PIPCameraApplication.a, 0x7f04000e);
            animation.setAnimationListener(new android.view.animation.Animation.AnimationListener(flag, view) {

                final boolean a;
                final View b;
                final TTieZhiComposeView c;

                public void onAnimationEnd(Animation animation1)
                {
                    if (a && b != null)
                    {
                        b.setVisibility(0);
                        return;
                    } else
                    {
                        b.setVisibility(4);
                        return;
                    }
                }

                public void onAnimationRepeat(Animation animation1)
                {
                }

                public void onAnimationStart(Animation animation1)
                {
                }

            
            {
                c = TTieZhiComposeView.this;
                a = flag;
                b = view;
                super();
            }
            });
            view.startAnimation(animation);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view) { }
    }

    private void onTouchBegin(MotionEvent motionevent)
    {
        mSingleState = SingleTouchState.Single_Start;
        if (selecTieZhiInfoView == null || mHandleView == null) goto _L2; else goto _L1
_L1:
        if (!mHandleView.isDeleteButtonClicked((int)motionevent.getX(), (int)motionevent.getY())) goto _L4; else goto _L3
_L3:
        deleteAction();
        mEditState = EditState.Edit_Delete;
_L6:
        return;
_L4:
        if (mHandleView.isFlipButtonClicked((int)motionevent.getX(), (int)motionevent.getY()))
        {
            flipActipn();
            mEditState = EditState.Edit_Flip;
            return;
        }
        if (mHandleView.isRotateButtonClicked((int)motionevent.getX(), (int)motionevent.getY()))
        {
            mEditState = EditState.Edit_Rotate;
            return;
        }
        mEditState = EditState.Edit_Default;
        if (getSelectedInfoView(motionevent) == null)
        {
            mEditState = EditState.Edit_None;
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        mEditState = EditState.Edit_Default;
        motionevent = getSelectedInfoView(motionevent);
        if (motionevent != null)
        {
            selecTieZhiInfoView = motionevent;
            selecTieZhiInfoView.setSelected(true);
            if (lisener != null)
            {
                lisener.a(selecTieZhiInfoView.getInfo());
                return;
            }
        } else
        {
            mEditState = EditState.Edit_None;
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void onTouchEnd(MotionEvent motionevent)
    {
label0:
        {
            if (selecTieZhiInfoView != null)
            {
                selecTieZhiInfoView.storeTransform();
                if (mEditState == EditState.Edit_None || mEditState == EditState.Edit_Tap)
                {
                    selecTieZhiInfoView.setSelected(false);
                    selecTieZhiInfoView = null;
                    mHandleView.setNeedDraw(false);
                    mHandleView.redrawView();
                }
                if (mEditState == EditState.Edit_Tap)
                {
                    motionevent = getSelectedInfoView(motionevent);
                    if (motionevent != null)
                    {
                        selecTieZhiInfoView = motionevent;
                        selecTieZhiInfoView.setSelected(true);
                        setEditBtnBy(selecTieZhiInfoView);
                    }
                }
            }
            mSingleState = SingleTouchState.Single_default;
            if (lisener != null)
            {
                if (selecTieZhiInfoView == null)
                {
                    break label0;
                }
                lisener.a(selecTieZhiInfoView.getInfo());
            }
            return;
        }
        lisener.a(null);
    }

    private void onTouchMoved(MotionEvent motionevent)
    {
        PointF pointf;
        pointf = new PointF(motionevent.getX(), motionevent.getY());
        if (mEditState == EditState.Edit_None && selecTieZhiInfoView != null)
        {
            mEditState = EditState.Edit_Default;
        }
        if (mEditState != EditState.Edit_Tap && mEditState != EditState.Edit_Flip) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (mSingleState == SingleTouchState.Single_Start || mSingleState == SingleTouchState.Single_default)
        {
            moveStartPoint.x = motionevent.getX();
            moveStartPoint.y = motionevent.getY();
            mSingleState = SingleTouchState.Single_Move;
        }
        if (mEditState != EditState.Edit_Default)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (selecTieZhiInfoView == null) goto _L1; else goto _L3
_L3:
        selecTieZhiInfoView.setNewTranslate(new PointF(pointf.x - moveStartPoint.x, pointf.y - moveStartPoint.y));
        setEditBtnBy(selecTieZhiInfoView);
        return;
        if (mEditState != EditState.Edit_Rotate || selecTieZhiInfoView == null) goto _L1; else goto _L4
_L4:
        rotateScaleView(selecTieZhiInfoView, moveStartPoint, pointf);
        return;
    }

    private float pointDistance(PointF pointf, PointF pointf1)
    {
        return (float)Math.sqrt((pointf1.x - pointf.x) * (pointf1.x - pointf.x) + (pointf1.y - pointf.y) * (pointf1.y - pointf.y));
    }

    private void rotateScaleView(TTieZhiInfoView ttiezhiinfoview, PointF pointf, PointF pointf1)
    {
        float f2 = 1.0F;
        if (ttiezhiinfoview != null)
        {
            PointF pointf2 = ttiezhiinfoview.getCenterPointF();
            float f1 = pointDistance(pointf2, pointf);
            float f3 = pointDistance(pointf2, pointf1);
            float f4 = pointDistance(pointf, pointf1);
            float f = f1;
            if (f1 == 0.0F)
            {
                f = 1.0F;
            }
            f1 = f3;
            if (f3 == 0.0F)
            {
                f1 = 1.0F;
            }
            f3 = f1 / f;
            f = ((f * f + f1 * f1) - f4 * f4) / (f1 * (f * 2.0F));
            if (f > 1.0F)
            {
                f = f2;
            } else
            if (f < -1F)
            {
                f = -1F;
            }
            f1 = (float)Math.acos(f);
            f2 = (pointf2.y - pointf.y) / (pointf2.x - pointf.x);
            f4 = pointf.y - pointf.x * f2;
            if (pointf1.y - pointf1.x * f2 - f4 > 0.0F && pointf.x > pointf2.x)
            {
                f = -f1;
            } else
            {
                f = f1;
                if (pointf1.y - f2 * pointf1.x - f4 < 0.0F)
                {
                    f = f1;
                    if (pointf.x < pointf2.x)
                    {
                        f = -f1;
                    }
                }
            }
            ttiezhiinfoview.setNewScaleAndRotate(f3, f);
            setEditBtnBy(ttiezhiinfoview);
        }
    }

    private void setEditBtnBy(TTieZhiInfoView ttiezhiinfoview)
    {
        if (ttiezhiinfoview != null)
        {
            mHandleView.setDeleteCenter(ttiezhiinfoview.getLTRealPointF());
            mHandleView.setFlipCenter(ttiezhiinfoview.getRTRealPointF());
            mHandleView.setRotateCenter(ttiezhiinfoview.getRBRealPointF());
            mHandleView.setLBCenter(ttiezhiinfoview.getLBRealPointF());
            mHandleView.setNeedDraw(true);
            mHandleView.redrawView();
        }
    }

    private PointF subPointf(PointF pointf, PointF pointf1)
    {
        return new PointF(pointf.x - pointf1.x, pointf.y - pointf1.y);
    }

    public boolean addTieZhiWithInfo(TTieZhiInfo ttiezhiinfo, boolean flag)
    {
        boolean flag2 = true;
        boolean flag1;
        if (ttiezhiinfo == null || !ttiezhiinfo.hasSrcImg())
        {
            flag1 = false;
        } else
        {
            PointF pointf = new PointF(getLeft(), getTop());
            TTieZhiInfoView ttiezhiinfoview = new TTieZhiInfoView(getContext());
            ttiezhiinfoview.setInfo(ttiezhiinfo, false);
            if (ttiezhiinfo.faceType != com.fotoable.sketch.info.TTieZhiInfo.TIEZHIFACETYPE.GENERAL && mFaceKeyPoint != null)
            {
                ttiezhiinfoview.setCenterPoint(addPointf(pointf, getFacePointByInfo(ttiezhiinfo)));
                ttiezhiinfoview.setNewScaleAndRotate(mFaceScale, -mFaceAngle);
                if (ttiezhiinfo.faceAlign == com.fotoable.sketch.info.TTieZhiInfo.TIEZHIFACEALIGN.FACEALIGN_BOTTOM)
                {
                    float f = ttiezhiinfoview.getViewHeight();
                    ttiezhiinfoview.setNewTranslate(new PointF(((float)Math.sin(mFaceAngle) * f) / 2.0F, (-f * (float)Math.cos(mFaceAngle)) / 2.0F));
                } else
                if (ttiezhiinfo.faceAlign == com.fotoable.sketch.info.TTieZhiInfo.TIEZHIFACEALIGN.FACEALIGN_TOP)
                {
                    float f1 = ttiezhiinfoview.getViewHeight();
                    ttiezhiinfoview.setNewTranslate(new PointF(((float)Math.sin(mFaceAngle) * f1) / 2.0F, (f1 * (float)Math.cos(mFaceAngle)) / 2.0F));
                }
                ttiezhiinfoview.storeTransform();
            } else
            {
                ttiezhiinfoview.setCenterPoint(getCenterPointByInfo(ttiezhiinfo, ttiezhiinfoview.getViewWidth(), ttiezhiinfoview.getViewHeight()));
            }
            mComposeContainer.addView(ttiezhiinfoview);
            tiezhiViews.add(ttiezhiinfoview);
            flag1 = flag2;
            if (flag)
            {
                if (selecTieZhiInfoView != null)
                {
                    selecTieZhiInfoView.setSelected(false);
                }
                selecTieZhiInfoView = ttiezhiinfoview;
                selecTieZhiInfoView.setSelected(true);
                setEditBtnBy(selecTieZhiInfoView);
                flag1 = flag2;
                if (lisener != null)
                {
                    lisener.a(ttiezhiinfo);
                    return true;
                }
            }
        }
        return flag1;
    }

    public void changeCurTieZhiWithInfo(TTieZhiInfo ttiezhiinfo)
    {
        if (ttiezhiinfo == null || !ttiezhiinfo.hasSrcImg())
        {
            return;
        }
        if (selecTieZhiInfoView != null)
        {
            selecTieZhiInfoView.setInfo(ttiezhiinfo, true);
            setEditBtnBy(selecTieZhiInfoView);
            return;
        } else
        {
            addTieZhiWithInfo(ttiezhiinfo, true);
            return;
        }
    }

    public void drawInCanvas(Canvas canvas, float f, Paint paint)
    {
        Object obj;
        obj = new HashMap();
        ((Map) (obj)).put("count", (new StringBuilder()).append("").append(tiezhiViews.size()).toString());
        FlurryAgent.logEvent("SketchUseCount", ((Map) (obj)));
        if (tiezhiViews.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        obj = tiezhiViews.iterator();
_L2:
        TTieZhiInfoView ttiezhiinfoview;
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break MISSING_BLOCK_LABEL_130;
            }
            ttiezhiinfoview = (TTieZhiInfoView)((Iterator) (obj)).next();
        } while (ttiezhiinfoview == null);
        kf.b(ttiezhiinfoview.getInfo().resId);
        ttiezhiinfoview.drawInCanvas(canvas, f, paint);
        if (true) goto _L2; else goto _L1
_L1:
        canvas;
    }

    public PointF getCenterPointByInfo(TTieZhiInfo ttiezhiinfo, float f, float f1)
    {
        PointF pointf = new PointF((getLeft() + getRight()) / 2, (getTop() + getBottom()) / 2);
        float f2 = (ttiezhiinfo.margin / 100F) * (float)getWidth();
        class _cls5
        {

            static final int a[];
            static final int b[];

            static 
            {
                b = new int[com.fotoable.sketch.info.TTieZhiInfo.TIEZHIPOSITION.values().length];
                try
                {
                    b[com.fotoable.sketch.info.TTieZhiInfo.TIEZHIPOSITION.CENTER.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                try
                {
                    b[com.fotoable.sketch.info.TTieZhiInfo.TIEZHIPOSITION.LEFT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    b[com.fotoable.sketch.info.TTieZhiInfo.TIEZHIPOSITION.TOP.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    b[com.fotoable.sketch.info.TTieZhiInfo.TIEZHIPOSITION.RIGHT.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    b[com.fotoable.sketch.info.TTieZhiInfo.TIEZHIPOSITION.BOTTOM.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    b[com.fotoable.sketch.info.TTieZhiInfo.TIEZHIPOSITION.LEFTTOP.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    b[com.fotoable.sketch.info.TTieZhiInfo.TIEZHIPOSITION.LEFTBOTTOM.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    b[com.fotoable.sketch.info.TTieZhiInfo.TIEZHIPOSITION.RIGHTTOP.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    b[com.fotoable.sketch.info.TTieZhiInfo.TIEZHIPOSITION.RIGHTBOTTOM.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                a = new int[com.fotoable.sketch.info.TTieZhiInfo.TIEZHIFACETYPE.values().length];
                try
                {
                    a[com.fotoable.sketch.info.TTieZhiInfo.TIEZHIFACETYPE.GENERAL.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    a[com.fotoable.sketch.info.TTieZhiInfo.TIEZHIFACETYPE.FACE_EYE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    a[com.fotoable.sketch.info.TTieZhiInfo.TIEZHIFACETYPE.FACE_ERE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[com.fotoable.sketch.info.TTieZhiInfo.TIEZHIFACETYPE.FACE_NOSE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[com.fotoable.sketch.info.TTieZhiInfo.TIEZHIFACETYPE.FACE_MOUTH.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[com.fotoable.sketch.info.TTieZhiInfo.TIEZHIFACETYPE.FACE_CHEEK.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[com.fotoable.sketch.info.TTieZhiInfo.TIEZHIFACETYPE.FACE_MOUSTACHE.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[com.fotoable.sketch.info.TTieZhiInfo.TIEZHIFACETYPE.FACE_MEIXIN.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls5.b[ttiezhiinfo.position.ordinal()])
        {
        case 1: // '\001'
        default:
            return pointf;

        case 2: // '\002'
            return new PointF(f2 + f / 2.0F, (float)getHeight() / 2.0F);

        case 3: // '\003'
            return new PointF(getWidth() / 2, f2 + f1 / 2.0F);

        case 4: // '\004'
            return new PointF((float)getWidth() - (f2 + f / 2.0F), (float)getHeight() / 2.0F);

        case 5: // '\005'
            return new PointF(f / 2.0F + f2, (float)getHeight() - (f2 + f1 / 2.0F));

        case 6: // '\006'
            return new PointF(f / 2.0F + f2, f2 + f1 / 2.0F);

        case 7: // '\007'
            return new PointF(f / 2.0F + f2, (float)getHeight() - (f2 + f1 / 2.0F));

        case 8: // '\b'
            return new PointF((float)getWidth() - (f / 2.0F + f2), f2 + f1 / 2.0F);

        case 9: // '\t'
            return new PointF((float)getWidth() - (f / 2.0F + f2), (float)getHeight() - (f2 + f1 / 2.0F));
        }
    }

    public PointF getFacePointByInfo(TTieZhiInfo ttiezhiinfo)
    {
        PointF pointf = new PointF((getLeft() + getRight()) / 2, (getTop() + getBottom()) / 2);
        switch (_cls5.a[ttiezhiinfo.faceType.ordinal()])
        {
        case 1: // '\001'
        default:
            return pointf;

        case 2: // '\002'
            return averagePointf(mFaceKeyPoint.b, mFaceKeyPoint.c);

        case 3: // '\003'
            return mFaceKeyPoint.a;

        case 4: // '\004'
            return mFaceKeyPoint.d;

        case 5: // '\005'
            return mFaceKeyPoint.e;

        case 6: // '\006'
            return averagePointfWithScale(averagePointf(mFaceKeyPoint.b, mFaceKeyPoint.c), mFaceKeyPoint.d, 0.75F);

        case 7: // '\007'
            return mFaceKeyPoint.f;

        case 8: // '\b'
            return mFaceKeyPoint.h;
        }
    }

    public boolean hasTieZhi()
    {
        return tiezhiViews.size() > 0;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (motionevent.getPointerCount() == 1)
        {
            mGestureDetector.onTouchEvent(motionevent);
            mDoubleState = DoubleTouchState.Double_default;
            switch (motionevent.getAction())
            {
            default:
                onTouchEnd(motionevent);
                return true;

            case 0: // '\0'
                onTouchBegin(motionevent);
                return true;

            case 2: // '\002'
                onTouchMoved(motionevent);
                return true;

            case 1: // '\001'
                onTouchEnd(motionevent);
                return true;
            }
        } else
        {
            mSingleState = SingleTouchState.Single_default;
            mRotateDetector.a(motionevent);
            mScaleDetector.onTouchEvent(motionevent);
            return true;
        }
    }

    public void setComposeHandleLisener(ov ov1)
    {
        lisener = ov1;
    }

    public void setFaceKeyPoint(ge ge1)
    {
        if (ge1 != null)
        {
            mFaceKeyPoint = ge1;
            ge1 = subPointf(mFaceKeyPoint.b, mFaceKeyPoint.c);
            if (((PointF) (ge1)).x == 0.0F)
            {
                mFaceAngle = 1.570796F;
            } else
            {
                mFaceAngle = (float)Math.atan(((PointF) (ge1)).y / ((PointF) (ge1)).x);
            }
            mFaceScale = pointDistance(mFaceKeyPoint.c, mFaceKeyPoint.b) / ((float)TTieZhiInfo.kDefaultTZWidth * ew.c(getContext()) * TTieZhiInfo.kDefaultTZScale);
        }
    }



    private class SingleTouchState extends Enum
    {

        private static final SingleTouchState $VALUES[];
        public static final SingleTouchState Single_End;
        public static final SingleTouchState Single_Move;
        public static final SingleTouchState Single_Start;
        public static final SingleTouchState Single_default;

        public static SingleTouchState valueOf(String s)
        {
            return (SingleTouchState)Enum.valueOf(com/fotoable/sketch/view/TTieZhiComposeView$SingleTouchState, s);
        }

        public static SingleTouchState[] values()
        {
            return (SingleTouchState[])$VALUES.clone();
        }

        static 
        {
            Single_default = new SingleTouchState("Single_default", 0);
            Single_Start = new SingleTouchState("Single_Start", 1);
            Single_Move = new SingleTouchState("Single_Move", 2);
            Single_End = new SingleTouchState("Single_End", 3);
            $VALUES = (new SingleTouchState[] {
                Single_default, Single_Start, Single_Move, Single_End
            });
        }

        private SingleTouchState(String s, int i)
        {
            super(s, i);
        }
    }


    private class DoubleTouchState extends Enum
    {

        private static final DoubleTouchState $VALUES[];
        public static final DoubleTouchState Double_End;
        public static final DoubleTouchState Double_Move;
        public static final DoubleTouchState Double_Start;
        public static final DoubleTouchState Double_default;

        public static DoubleTouchState valueOf(String s)
        {
            return (DoubleTouchState)Enum.valueOf(com/fotoable/sketch/view/TTieZhiComposeView$DoubleTouchState, s);
        }

        public static DoubleTouchState[] values()
        {
            return (DoubleTouchState[])$VALUES.clone();
        }

        static 
        {
            Double_default = new DoubleTouchState("Double_default", 0);
            Double_Start = new DoubleTouchState("Double_Start", 1);
            Double_Move = new DoubleTouchState("Double_Move", 2);
            Double_End = new DoubleTouchState("Double_End", 3);
            $VALUES = (new DoubleTouchState[] {
                Double_default, Double_Start, Double_Move, Double_End
            });
        }

        private DoubleTouchState(String s, int i)
        {
            super(s, i);
        }
    }


    private class EditState extends Enum
    {

        private static final EditState $VALUES[];
        public static final EditState Edit_Default;
        public static final EditState Edit_Delete;
        public static final EditState Edit_Flip;
        public static final EditState Edit_None;
        public static final EditState Edit_Rotate;
        public static final EditState Edit_Tap;

        public static EditState valueOf(String s)
        {
            return (EditState)Enum.valueOf(com/fotoable/sketch/view/TTieZhiComposeView$EditState, s);
        }

        public static EditState[] values()
        {
            return (EditState[])$VALUES.clone();
        }

        static 
        {
            Edit_None = new EditState("Edit_None", 0);
            Edit_Default = new EditState("Edit_Default", 1);
            Edit_Delete = new EditState("Edit_Delete", 2);
            Edit_Flip = new EditState("Edit_Flip", 3);
            Edit_Rotate = new EditState("Edit_Rotate", 4);
            Edit_Tap = new EditState("Edit_Tap", 5);
            $VALUES = (new EditState[] {
                Edit_None, Edit_Default, Edit_Delete, Edit_Flip, Edit_Rotate, Edit_Tap
            });
        }

        private EditState(String s, int i)
        {
            super(s, i);
        }
    }

}
