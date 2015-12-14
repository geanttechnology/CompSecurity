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
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import aoq;
import aou;
import apa;
import ayu;
import bfc;
import bfd;
import bfe;
import bff;
import bfg;
import bfh;
import bfi;
import bfj;
import bfk;
import bfl;
import bfm;
import bfn;
import bfo;
import com.wantu.ResourceOnlineLibrary.compose.FlipViewType;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TDecorateInfosLayerView extends View
{

    private static final String TAG = "TDecorateInfoView";
    private ImageView contentImageView;
    private TextView contentTextView;
    private bfi curSelectedDecorate;
    private bfg decorateInfo;
    private List decorateInfos;
    private List decorateRenders;
    private FlipViewType flipViewType;
    private GestureDetector gestureDetector;
    private boolean isInEditorMode;
    private bff textClickListener;

    public TDecorateInfosLayerView(Context context)
    {
        super(context);
        decorateRenders = new ArrayList();
        isInEditorMode = false;
        flipViewType = FlipViewType.FLIP_NORMAL;
        initGesture(context);
    }

    public TDecorateInfosLayerView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        decorateRenders = new ArrayList();
        isInEditorMode = false;
        flipViewType = FlipViewType.FLIP_NORMAL;
        initGesture(context);
    }

    public TDecorateInfosLayerView(Context context, List list)
    {
        super(context);
        decorateRenders = new ArrayList();
        isInEditorMode = false;
        flipViewType = FlipViewType.FLIP_NORMAL;
        initGesture(context);
        configByInfos(list);
    }

    private bfi hitTest(float f, float f1)
    {
        for (Iterator iterator = decorateRenders.iterator(); iterator.hasNext();)
        {
            bfi bfi1 = (bfi)iterator.next();
            if ((bfi1.a().A || bfi1.a().z) && bfi1.a(f, f1))
            {
                return bfi1;
            }
        }

        return null;
    }

    private void initGesture(Context context)
    {
        gestureDetector = new GestureDetector(context, new bfe(this));
    }

    private bfi nextRender(bfi bfi1, boolean flag)
    {
        bfi bfi2;
        int i;
        int j;
        if (bfi1 != null)
        {
            i = decorateRenders.indexOf(bfi1);
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
        bfi1 = (bfi)decorateRenders.get(j);
        if (!bfi1.a().r || !bfi1.a().A) goto _L6; else goto _L5
_L5:
        return bfi1;
_L6:
        j++;
        continue; /* Loop/switch isn't completed */
_L4:
        j = 0;
_L10:
        if (j >= i) goto _L8; else goto _L7
_L7:
        bfi2 = (bfi)decorateRenders.get(j);
        if (!bfi2.a().r)
        {
            break; /* Loop/switch isn't completed */
        }
        bfi1 = bfi2;
        if (bfi2.a().A) goto _L5; else goto _L9
_L9:
        j++;
          goto _L10
_L2:
        j = i;
_L14:
        if (j < 0) goto _L12; else goto _L11
_L11:
        bfi2 = (bfi)decorateRenders.get(j);
        if (!bfi2.a().r)
        {
            continue; /* Loop/switch isn't completed */
        }
        bfi1 = bfi2;
        if (bfi2.a().A) goto _L5; else goto _L13
_L13:
        j--;
          goto _L14
_L12:
        j = decorateRenders.size() - 1;
_L17:
        if (j <= i) goto _L8; else goto _L15
_L15:
        bfi2 = (bfi)decorateRenders.get(j);
        if (!bfi2.a().r)
        {
            continue; /* Loop/switch isn't completed */
        }
        bfi1 = bfi2;
        if (bfi2.a().A) goto _L5; else goto _L16
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
            bfi bfi1 = (bfi)iterator.next();
            float f2 = TPhotoComposeInfo.scale;
            f2 = bfi1.a().h.left * f2;
            float f3 = TPhotoComposeInfo.scale;
            f3 = bfi1.a().h.top * f3;
            float f4 = bfi1.i;
            float f6 = bfi1.j;
            String s = "";
            if (bfi1 instanceof bfc)
            {
                s = ((bfj)bfi1).g();
            }
            if (flipviewtype != FlipViewType.FLIP_NORMAL && f1 > 0.0F && f > 0.0F)
            {
                float f7 = bfi1.c().width();
                float f8 = bfi1.c().height();
                if (flipviewtype == FlipViewType.FLIP_HORIZONTAL)
                {
                    f4 = f - f4 - f7;
                    bfi1.b().setTranslate(0.0F, 0.0F);
                    if (bfi1.a().n != null)
                    {
                        bfi1.b().postConcat(bfi1.a().n);
                    }
                    bfi1.b().postTranslate(f4 - f2, bfi1.j - f3);
                    Log.d("TDecorateInfoView", (new StringBuilder()).append("TDecorateInfoViewtext:").append(s).append("FLIP_HORIZONTAL translate x:").append(f4 - f2).toString());
                    bfi1.i = f4;
                } else
                if (flipviewtype == FlipViewType.FLIP_VERTICAL)
                {
                    float f5 = f1 - f6 - f8;
                    bfi1.b().setTranslate(0.0F, 0.0F);
                    if (bfi1.a().n != null)
                    {
                        bfi1.b().postConcat(bfi1.a().n);
                    }
                    bfi1.b().postTranslate(bfi1.i - f2, f5 - f3);
                    Log.d("TDecorateInfoView", (new StringBuilder()).append("TDecorateInfoViewtext:").append(s).append("FLIP_VERTICAL translate y:").append(f5 - f3).toString());
                    bfi1.j = f5;
                }
            }
        } while (true);
    }

    public void configByInfos(List list)
    {
        decorateInfos = list;
        list = list.iterator();
        int j = 0;
        while (list.hasNext()) 
        {
            Object obj = (bfg)list.next();
            int i = j;
            if (((bfg) (obj)).a != null)
            {
                bfd bfd1 = new bfd(((bfg) (obj)));
                bfd1.a(j);
                decorateRenders.add(bfd1);
                i = j + 1;
            }
            j = i;
            if (((bfg) (obj)).r)
            {
                bfc bfc1 = new bfc(((bfg) (obj)));
                bfc1.a(i);
                decorateRenders.add(bfc1);
                j = i + 1;
            }
            i = j;
            if (((bfg) (obj)).c())
            {
                if (((bfg) (obj)).q == 7)
                {
                    bfl bfl1 = new bfl(((bfg) (obj)));
                    bfl1.a(j);
                    decorateRenders.add(bfl1);
                    i = j + 1;
                } else
                if (((bfg) (obj)).q == 15)
                {
                    bfm bfm1 = new bfm(((bfg) (obj)));
                    bfm1.a(j);
                    decorateRenders.add(bfm1);
                    i = j + 1;
                } else
                if (((bfg) (obj)).q == 16)
                {
                    bfn bfn1 = new bfn(((bfg) (obj)));
                    bfn1.a(j);
                    decorateRenders.add(bfn1);
                    i = j + 1;
                } else
                {
                    i = j;
                    if (((bfg) (obj)).q == 17)
                    {
                        bfo bfo1 = new bfo(((bfg) (obj)));
                        bfo1.a(j);
                        decorateRenders.add(bfo1);
                        i = j + 1;
                    }
                }
            }
            if (((bfg) (obj)).a() && ((bfg) (obj)).q == 14)
            {
                obj = new bfh(((bfg) (obj)));
                j = i + 1;
                ((bfh) (obj)).a(i);
                decorateRenders.add(obj);
                i = j;
            }
            j = i;
        }
        invalidate();
    }

    public void drawLayer(Canvas canvas)
    {
        bfi bfi1;
        for (Iterator iterator = decorateRenders.iterator(); iterator.hasNext(); bfi1.a(canvas))
        {
            bfi1 = (bfi)iterator.next();
            bfi1.f = FlipViewType.FLIP_NORMAL;
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
            bfi bfi1 = (bfi)iterator.next();
            if (bfi1.a().q == 5)
            {
                return ((bfj)bfi1).g();
            }
        }

        return "";
    }

    public String getPlaceCity()
    {
        for (Iterator iterator = decorateRenders.iterator(); iterator.hasNext();)
        {
            bfi bfi1 = (bfi)iterator.next();
            if (bfi1.a().q == 9)
            {
                return ((bfj)bfi1).g();
            }
        }

        return "";
    }

    public String getPlaceCountry()
    {
        for (Iterator iterator = decorateRenders.iterator(); iterator.hasNext();)
        {
            bfi bfi1 = (bfi)iterator.next();
            if (bfi1.a().q == 10)
            {
                return ((bfj)bfi1).g();
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
        for (Iterator iterator = decorateRenders.iterator(); iterator.hasNext(); ((bfi)iterator.next()).a(canvas)) { }
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
        }
        if (gestureDetector != null)
        {
            gestureDetector.onTouchEvent(motionevent);
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
        if (curSelectedDecorate != null && (curSelectedDecorate instanceof bfj) && curSelectedDecorate.a().A)
        {
            ((bfj)curSelectedDecorate).a(s);
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
                bfi bfi1 = (bfi)iterator.next();
                if (bfi1.a().b())
                {
                    ((bfc)bfi1).a(date);
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

    public void setLocationText(aoq aoq1)
    {
        Iterator iterator = decorateRenders.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            bfi bfi1 = (bfi)iterator.next();
            switch (bfi1.a().q)
            {
            case 5: // '\005'
                Log.v("TDecorateInfoView", (new StringBuilder()).append("TDecorateInfoViewDECORATE_TYPE_PLACE:").append(aoq1.a()).toString());
                ((bfj)bfi1).a((new StringBuilder()).append(aoq1.d()).append(",").append(aoq1.e()).toString());
                break;

            case 9: // '\t'
                Log.v("TDecorateInfoView", (new StringBuilder()).append("TDecorateInfoViewDECORATE_TYPE_PLACE_CITY:").append(aoq1.d()).toString());
                ((bfj)bfi1).a(aoq1.d());
                break;

            case 10: // '\n'
                Log.v("TDecorateInfoView", (new StringBuilder()).append("TDecorateInfoViewDECORATE_TYPE_PLACE_COUNTRY:").append(aoq1.e()).toString());
                ((bfj)bfi1).a(aoq1.e());
                break;

            case 14: // '\016'
                String s = (new StringBuilder()).append(aoq1.c().b()).append(",").append(aoq1.c().a()).toString();
                Log.v("TDecorateInfoView", (new StringBuilder()).append("TDecorateInfoViewDECORATE_TYPE_LATITUDE:").append(s).toString());
                if (bfi1 instanceof bfh)
                {
                    ((bfh)bfi1).a(aoq1);
                }
                break;
            }
        } while (true);
        invalidate();
    }

    public void setLocationTextByTTCLPlacemark(aou aou1)
    {
        if (aou1 == null)
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
            bfi bfi1 = (bfi)iterator.next();
            switch (bfi1.a().q)
            {
            case 5: // '\005'
                if (aou1.a != null && aou1.a.length() > 0)
                {
                    ((bfj)bfi1).a(aou1.a);
                }
                break;

            case 9: // '\t'
                if (aou1.b != null && aou1.b.length() > 0)
                {
                    ((bfj)bfi1).a(aou1.b);
                }
                break;

            case 10: // '\n'
                if (aou1.c != null && aou1.c.length() > 0)
                {
                    ((bfj)bfi1).a(aou1.c);
                }
                break;
            }
        } while (true);
        invalidate();
    }

    public void setTextClickListener(bff bff)
    {
        textClickListener = bff;
    }

    public void setWeather(ayu ayu)
    {
        if (ayu != null)
        {
            Iterator iterator = decorateRenders.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                bfi bfi1 = (bfi)iterator.next();
                Log.v("TDecorateInfoView", (new StringBuilder()).append("TDecorateInfoView type :").append(bfi1.a().q).toString());
                if (bfi1.a().c() && (bfi1 instanceof bfk))
                {
                    ((bfk)bfi1).a(ayu);
                }
            } while (true);
            invalidate();
        }
    }



}
