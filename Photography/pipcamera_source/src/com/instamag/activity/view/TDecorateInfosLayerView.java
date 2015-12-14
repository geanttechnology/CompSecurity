// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.wantu.ResourceOnlineLibrary.compose.FlipViewType;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import jl;
import jp;
import ju;
import pp;
import rg;
import rh;
import ri;
import rj;
import rk;
import rl;
import rm;
import rn;
import ro;
import rp;
import rq;
import rr;

public class TDecorateInfosLayerView extends View
{

    private static final String TAG = "TDecorateInfoView";
    private rl curSelectedDecorate;
    private rj decorateInfo;
    private List decorateInfos;
    private List decorateRenders;
    private FlipViewType flipViewType;
    private GestureDetector gestureDetector;
    private boolean isInEditorMode;
    private ScaleGestureDetector mScaleDetector;
    private float mScaleFactor;
    private ri textClickListener;

    public TDecorateInfosLayerView(Context context)
    {
        super(context);
        decorateRenders = new ArrayList();
        mScaleFactor = 1.0F;
        isInEditorMode = false;
        flipViewType = FlipViewType.FLIP_NORMAL;
        initGesture(context);
    }

    public TDecorateInfosLayerView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        decorateRenders = new ArrayList();
        mScaleFactor = 1.0F;
        isInEditorMode = false;
        flipViewType = FlipViewType.FLIP_NORMAL;
        initGesture(context);
    }

    public TDecorateInfosLayerView(Context context, List list)
    {
        super(context);
        decorateRenders = new ArrayList();
        mScaleFactor = 1.0F;
        isInEditorMode = false;
        flipViewType = FlipViewType.FLIP_NORMAL;
        initGesture(context);
        configByInfos(list);
    }

    private rl hitTest(float f, float f1)
    {
        if (decorateRenders.size() <= 0) goto _L2; else goto _L1
_L1:
        int i = decorateRenders.size() - 1;
_L4:
        rl rl1;
        if (i < 0)
        {
            break; /* Loop/switch isn't completed */
        }
        rl1 = (rl)decorateRenders.get(i);
          goto _L3
_L6:
        i--;
        if (true) goto _L4; else goto _L2
_L3:
        if (!rl1.a().A && !rl1.a().z || !rl1.a(f, f1)) goto _L6; else goto _L5
_L5:
        return rl1;
_L2:
        return null;
    }

    private void initGesture(Context context)
    {
        gestureDetector = new GestureDetector(context, new android.view.GestureDetector.SimpleOnGestureListener() {

            final TDecorateInfosLayerView a;

            public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
            {
                Log.v("TDecorateInfoView", (new StringBuilder()).append("onScroll:").append(f).append("y:").append(f1).toString());
                if (a.curSelectedDecorate != null && a.curSelectedDecorate.a().z)
                {
                    a.curSelectedDecorate.b().postTranslate(-f, -f1);
                    a.invalidate();
                }
                return true;
            }

            public void onShowPress(MotionEvent motionevent)
            {
                if (a.curSelectedDecorate != null && a.curSelectedDecorate.a().z)
                {
                    a.curSelectedDecorate.a().l.postConcat(a.curSelectedDecorate.a().k);
                    a.curSelectedDecorate.a().k.reset();
                }
                super.onShowPress(motionevent);
            }

            public boolean onSingleTapConfirmed(MotionEvent motionevent)
            {
                Log.v("TDecorateInfoView", (new StringBuilder()).append("onSingleTapConfirmed:").append(motionevent.toString()).toString());
                if (a.curSelectedDecorate == null || a.curSelectedDecorate.a() == null)
                {
                    return false;
                }
                if ((a.curSelectedDecorate == null || !a.curSelectedDecorate.a().r || !a.curSelectedDecorate.a().A) && !a.curSelectedDecorate.a().J) goto _L2; else goto _L1
_L1:
                if (!a.isInEditorMode) goto _L4; else goto _L3
_L3:
                a.curSelectedDecorate.a(true);
                a.invalidate();
_L2:
                return super.onSingleTapConfirmed(motionevent);
_L4:
                if (a.textClickListener != null)
                {
                    a.textClickListener.a(a.curSelectedDecorate);
                }
                if (true) goto _L2; else goto _L5
_L5:
            }

            
            {
                a = TDecorateInfosLayerView.this;
                super();
            }
        });
    }

    private rl nextRender(rl rl1, boolean flag)
    {
        rl rl2;
        int i;
        int j;
        if (rl1 != null)
        {
            i = decorateRenders.indexOf(rl1);
        } else
        {
            i = 0;
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        j = i;
_L19:
        if (j >= decorateRenders.size()) goto _L4; else goto _L3
_L3:
        rl1 = (rl)decorateRenders.get(j);
        if (!rl1.a().r || !rl1.a().A) goto _L6; else goto _L5
_L5:
        return rl1;
_L6:
        j++;
        continue; /* Loop/switch isn't completed */
_L4:
        j = 0;
_L10:
        if (j >= i) goto _L8; else goto _L7
_L7:
        rl2 = (rl)decorateRenders.get(j);
        if (!rl2.a().r)
        {
            break; /* Loop/switch isn't completed */
        }
        rl1 = rl2;
        if (rl2.a().A) goto _L5; else goto _L9
_L9:
        j++;
          goto _L10
_L2:
        j = i;
_L14:
        if (j < 0) goto _L12; else goto _L11
_L11:
        rl2 = (rl)decorateRenders.get(j);
        if (!rl2.a().r)
        {
            continue; /* Loop/switch isn't completed */
        }
        rl1 = rl2;
        if (rl2.a().A) goto _L5; else goto _L13
_L13:
        j--;
          goto _L14
_L12:
        j = decorateRenders.size() - 1;
_L17:
        if (j <= i) goto _L8; else goto _L15
_L15:
        rl2 = (rl)decorateRenders.get(j);
        if (!rl2.a().r)
        {
            continue; /* Loop/switch isn't completed */
        }
        rl1 = rl2;
        if (rl2.a().A) goto _L5; else goto _L16
_L16:
        j--;
          goto _L17
_L8:
        return null;
        if (true) goto _L19; else goto _L18
_L18:
    }

    public void changeRenderByFlipView(FlipViewType flipviewtype)
    {
        float f = getWidth();
        float f1 = getHeight();
        Iterator iterator = decorateRenders.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            rl rl1 = (rl)iterator.next();
            float f2 = TPhotoComposeInfo.scale;
            f2 = rl1.a().h.left * f2;
            float f3 = TPhotoComposeInfo.scale;
            f3 = rl1.a().h.top * f3;
            float f4 = rl1.i;
            float f6 = rl1.j;
            String s = "";
            if (rl1 instanceof rg)
            {
                s = ((rm)rl1).g();
            }
            if (flipviewtype != FlipViewType.FLIP_NORMAL && f1 > 0.0F && f > 0.0F)
            {
                float f7 = rl1.c().width();
                float f8 = rl1.c().height();
                if (flipviewtype == FlipViewType.FLIP_HORIZONTAL)
                {
                    f4 = f - f4 - f7;
                    rl1.b().setTranslate(0.0F, 0.0F);
                    if (rl1.a().n != null)
                    {
                        rl1.b().postConcat(rl1.a().n);
                    }
                    rl1.b().postTranslate(f4 - f2, rl1.j - f3);
                    Log.d("TDecorateInfoView", (new StringBuilder()).append("TDecorateInfoViewtext:").append(s).append("FLIP_HORIZONTAL translate x:").append(f4 - f2).toString());
                    rl1.i = f4;
                } else
                if (flipviewtype == FlipViewType.FLIP_VERTICAL)
                {
                    float f5 = f1 - f6 - f8;
                    rl1.b().setTranslate(0.0F, 0.0F);
                    if (rl1.a().n != null)
                    {
                        rl1.b().postConcat(rl1.a().n);
                    }
                    rl1.b().postTranslate(rl1.i - f2, f5 - f3);
                    Log.d("TDecorateInfoView", (new StringBuilder()).append("TDecorateInfoViewtext:").append(s).append("FLIP_VERTICAL translate y:").append(f5 - f3).toString());
                    rl1.j = f5;
                }
            }
        } while (true);
    }

    public void configByInfos(List list)
    {
        decorateInfos = list;
        list = list.iterator();
        int i = 0;
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            Object obj = (rj)list.next();
            Log.v("TDecorateInfoView", (new StringBuilder()).append("TDecorateInfoViewinfo type:").append(((rj) (obj)).q).toString());
            Log.v("TDecorateInfoView", (new StringBuilder()).append("TDecorateInfoViewinfo.isBubbleText:").append(((rj) (obj)).J).toString());
            if (((rj) (obj)).a != null && !((rj) (obj)).J)
            {
                obj = new rh(((rj) (obj)));
                int j = i + 1;
                ((rh) (obj)).a(i);
                decorateRenders.add(obj);
                i = j;
            } else
            if (((rj) (obj)).r)
            {
                obj = new rg(((rj) (obj)));
                int k = i + 1;
                ((rg) (obj)).a(i);
                decorateRenders.add(obj);
                i = k;
            } else
            if (((rj) (obj)).c())
            {
                if (((rj) (obj)).q == 7)
                {
                    obj = new ro(((rj) (obj)));
                    int l = i + 1;
                    ((ro) (obj)).a(i);
                    decorateRenders.add(obj);
                    i = l;
                } else
                if (((rj) (obj)).q == 15)
                {
                    obj = new rp(((rj) (obj)));
                    int i1 = i + 1;
                    ((rp) (obj)).a(i);
                    decorateRenders.add(obj);
                    i = i1;
                } else
                if (((rj) (obj)).q == 16)
                {
                    obj = new rq(((rj) (obj)));
                    int j1 = i + 1;
                    ((rq) (obj)).a(i);
                    decorateRenders.add(obj);
                    i = j1;
                } else
                if (((rj) (obj)).q == 17)
                {
                    obj = new rr(((rj) (obj)));
                    int k1 = i + 1;
                    ((rr) (obj)).a(i);
                    decorateRenders.add(obj);
                    i = k1;
                }
            } else
            if (((rj) (obj)).a() && ((rj) (obj)).q == 14)
            {
                obj = new rk(((rj) (obj)));
                int l1 = i + 1;
                ((rk) (obj)).a(i);
                decorateRenders.add(obj);
                i = l1;
            }
        } while (true);
        invalidate();
    }

    public void drawLayer(Canvas canvas)
    {
        rl rl1;
        for (Iterator iterator = decorateRenders.iterator(); iterator.hasNext(); rl1.a(canvas))
        {
            rl1 = (rl)iterator.next();
            rl1.f = FlipViewType.FLIP_NORMAL;
        }

    }

    public FlipViewType getFlipType()
    {
        return flipViewType;
    }

    public String getPlace()
    {
        for (Iterator iterator = decorateRenders.iterator(); iterator.hasNext();)
        {
            rl rl1 = (rl)iterator.next();
            if (rl1.a().q == 5)
            {
                return ((rm)rl1).g();
            }
        }

        return "";
    }

    public String getPlaceCity()
    {
        for (Iterator iterator = decorateRenders.iterator(); iterator.hasNext();)
        {
            rl rl1 = (rl)iterator.next();
            if (rl1.a().q == 9)
            {
                return ((rm)rl1).g();
            }
        }

        return "";
    }

    public String getPlaceCountry()
    {
        for (Iterator iterator = decorateRenders.iterator(); iterator.hasNext();)
        {
            rl rl1 = (rl)iterator.next();
            if (rl1.a().q == 10)
            {
                return ((rm)rl1).g();
            }
        }

        return "";
    }

    public boolean isInEditorMode()
    {
        return isInEditorMode;
    }

    public void leftLoopTextEditor()
    {
        curSelectedDecorate = nextRender(curSelectedDecorate, false);
        if (curSelectedDecorate != null)
        {
            curSelectedDecorate.a(true);
            invalidate();
        }
    }

    protected void onDraw(Canvas canvas)
    {
        Log.d("TDecorateInfoView", "TDecorateInfoView onDraw");
        for (Iterator iterator = decorateRenders.iterator(); iterator.hasNext(); ((rl)iterator.next()).a(canvas)) { }
        super.onDraw(canvas);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (MotionEventCompat.getActionMasked(motionevent) == 0)
        {
            int i = MotionEventCompat.getActionIndex(motionevent);
            curSelectedDecorate = hitTest(MotionEventCompat.getX(motionevent, i), MotionEventCompat.getY(motionevent, i));
            if (curSelectedDecorate == null || !curSelectedDecorate.a().A && !curSelectedDecorate.a().z)
            {
                return false;
            }
            mScaleFactor = 1.0F;
        }
        if (gestureDetector != null)
        {
            gestureDetector.onTouchEvent(motionevent);
        }
        if (mScaleDetector != null)
        {
            mScaleDetector.onTouchEvent(motionevent);
        }
        return true;
    }

    public void rightLoopTextEditor()
    {
        curSelectedDecorate = nextRender(curSelectedDecorate, true);
        if (curSelectedDecorate != null)
        {
            curSelectedDecorate.a(true);
            invalidate();
        }
    }

    public void setCurSelectedDecorateText(String s)
    {
        if (curSelectedDecorate != null && (curSelectedDecorate instanceof rm) && curSelectedDecorate.a().A && curSelectedDecorate.a().A && (curSelectedDecorate instanceof rm))
        {
            ((rm)curSelectedDecorate).a(s);
        }
        invalidate();
    }

    public void setDateText(Date date)
    {
        if (date != null)
        {
            Iterator iterator = decorateRenders.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                rl rl1 = (rl)iterator.next();
                if (rl1.a().b() && (rl1 instanceof rg))
                {
                    ((rg)rl1).a(date);
                }
            } while (true);
            invalidate();
        }
    }

    public void setInEditorMode(boolean flag)
    {
        isInEditorMode = flag;
        if (curSelectedDecorate == null || !curSelectedDecorate.a().r || !curSelectedDecorate.a().A) goto _L2; else goto _L1
_L1:
        curSelectedDecorate.a(flag);
_L4:
        invalidate();
        return;
_L2:
        if (flag)
        {
            curSelectedDecorate = nextRender(null, true);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setLayerFlipType(FlipViewType flipviewtype)
    {
        flipViewType = flipviewtype;
        Log.d("TDecorateInfoView", (new StringBuilder()).append("TDecorateInfoView decorateRenders").append(decorateRenders.size()).toString());
        changeRenderByFlipView(flipviewtype);
        invalidate();
    }

    public void setLocationText(jl jl1)
    {
        Iterator iterator = decorateRenders.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            rl rl1 = (rl)iterator.next();
            switch (rl1.a().q)
            {
            case 5: // '\005'
                Log.v("TDecorateInfoView", (new StringBuilder()).append("TDecorateInfoViewDECORATE_TYPE_PLACE:").append(jl1.a()).toString());
                ((rm)rl1).a((new StringBuilder()).append(jl1.d()).append(",").append(jl1.e()).toString());
                break;

            case 9: // '\t'
                Log.v("TDecorateInfoView", (new StringBuilder()).append("TDecorateInfoViewDECORATE_TYPE_PLACE_CITY:").append(jl1.d()).toString());
                ((rm)rl1).a(jl1.d());
                break;

            case 10: // '\n'
                Log.v("TDecorateInfoView", (new StringBuilder()).append("TDecorateInfoViewDECORATE_TYPE_PLACE_COUNTRY:").append(jl1.e()).toString());
                ((rm)rl1).a(jl1.e());
                break;

            case 14: // '\016'
                String s = (new StringBuilder()).append(jl1.c().b()).append(",").append(jl1.c().a()).toString();
                Log.v("TDecorateInfoView", (new StringBuilder()).append("TDecorateInfoViewDECORATE_TYPE_LATITUDE:").append(s).toString());
                if (rl1 instanceof rk)
                {
                    ((rk)rl1).a(jl1);
                }
                break;
            }
        } while (true);
        invalidate();
    }

    public void setLocationTextByTTCLPlacemark(jp jp1)
    {
        if (jp1 == null)
        {
            return;
        }
        Iterator iterator = decorateRenders.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            rl rl1 = (rl)iterator.next();
            switch (rl1.a().q)
            {
            case 5: // '\005'
                if (jp1.a != null && jp1.a.length() > 0)
                {
                    ((rm)rl1).a(jp1.a);
                }
                break;

            case 9: // '\t'
                if (jp1.b != null && jp1.b.length() > 0)
                {
                    ((rm)rl1).a(jp1.b);
                }
                break;

            case 10: // '\n'
                if (jp1.c != null && jp1.c.length() > 0)
                {
                    ((rm)rl1).a(jp1.c);
                }
                break;
            }
        } while (true);
        invalidate();
    }

    public void setTextClickListener(ri ri)
    {
        textClickListener = ri;
    }

    public void setWeather(pp pp)
    {
        if (pp != null)
        {
            Iterator iterator = decorateRenders.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                rl rl1 = (rl)iterator.next();
                Log.v("TDecorateInfoView", (new StringBuilder()).append("TDecorateInfoView type :").append(rl1.a().q).toString());
                if (rl1.a().c() && (rl1 instanceof rn))
                {
                    ((rn)rl1).a(pp);
                }
            } while (true);
            invalidate();
        }
    }



}
