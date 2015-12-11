// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.views;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.ViewTreeObserver;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.digidust.elokence.akinator.activities.AkActivity;
import com.digidust.elokence.akinator.factories.AkLog;
import com.digidust.elokence.akinator.factories.AkSessionFactory;
import com.elokence.limuleapi.Session;
import com.elokence.limuleapi.SessionFactory;
import java.util.ArrayList;
import java.util.Iterator;

public class TileFloatView extends ScrollView
{

    public static final boolean CENT_PERCENT_HIGH = true;
    public static final boolean CENT_PERCENT_MIDDLE = false;
    public static final boolean ZERO_PERCENT_DOWN = false;
    public static final boolean ZERO_PERCENT_MIDDLE = true;
    static int sizeInnerLayout[] = {
        0, 0, 0, 0
    };
    static int sizeWindowHeight[] = {
        0, 0, 0, 0
    };
    private int centOffset;
    private float currentOffset;
    private boolean destination;
    private boolean firstMeasure;
    private int imageHeight;
    private LinearLayout innerLayout;
    private int mIndex;
    private boolean origin;
    private int windowHeight;
    private int zeroOffset;

    public TileFloatView(int i, AkActivity akactivity, ArrayList arraylist, int j, boolean flag, boolean flag1, boolean flag2, 
            int k)
    {
        super(akactivity);
        origin = false;
        destination = false;
        windowHeight = 0;
        imageHeight = 0;
        zeroOffset = 0;
        centOffset = 0;
        currentOffset = 0.0F;
        firstMeasure = true;
        mIndex = i;
        origin = flag;
        destination = flag1;
        innerLayout = new LinearLayout(akactivity);
        innerLayout.setOrientation(1);
        Object obj = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        if (!flag2)
        {
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(2, 0x7f0d0198);
        }
        setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        obj = new android.widget.FrameLayout.LayoutParams(-1, -2);
        innerLayout.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        i = k;
        if (k == -1)
        {
            i = j;
        }
        getResources().getAssets();
        try
        {
            ImageView imageview;
            for (Iterator iterator = arraylist.iterator(); iterator.hasNext(); innerLayout.addView(imageview))
            {
                Bitmap bitmap = (Bitmap)iterator.next();
                imageview = new ImageView(akactivity);
                double d = (double)bitmap.getHeight() / (double)bitmap.getWidth();
                android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(i, (int)((double)i * d));
                imageview.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
                imageview.setLayoutParams(layoutparams);
                imageview.setImageBitmap(bitmap);
                imageview.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
                imageview.setAdjustViewBounds(true);
            }

        }
        // Misplaced declaration of an exception variable
        catch (AkActivity akactivity)
        {
            AkLog.e("AkinatorFV", (new StringBuilder()).append("Exception sur ").append(arraylist.get(0)).append(" ").toString(), akactivity);
            recycleAllBitmaps();
        }
        addView(innerLayout);
        setOnTouchListener(new _cls1());
        getViewTreeObserver().addOnGlobalLayoutListener(new _cls2());
    }

    private void translateFromMaxToPosition()
    {
        float f = zeroOffset;
        float f1 = centOffset;
        float f2 = zeroOffset;
        float f3 = SessionFactory.sharedInstance().getSession().getCurrentSessionProgression().getProgression();
        f3 = (float)zeroOffset + (((float)centOffset - (float)zeroOffset) * f3) / 100F;
        TranslateAnimation translateanimation = new TranslateAnimation(0.0F, 0.0F, f + (f1 - f2), f3);
        translateanimation.setDuration(1000L);
        translateanimation.setFillAfter(true);
        innerLayout.startAnimation(translateanimation);
        currentOffset = f3;
    }

    public void forcePositionToZeroWithoutAnimation()
    {
        float f = zeroOffset;
        TranslateAnimation translateanimation = new TranslateAnimation(0.0F, 0.0F, f, f);
        translateanimation.setDuration(1L);
        translateanimation.setFillAfter(true);
        innerLayout.startAnimation(translateanimation);
        currentOffset = f;
    }

    public void measureAll()
    {
        if (sizeWindowHeight[mIndex] == 0)
        {
            windowHeight = getMeasuredHeight();
            imageHeight = innerLayout.getMeasuredHeight();
            sizeWindowHeight[mIndex] = windowHeight;
            sizeInnerLayout[mIndex] = imageHeight;
        } else
        {
            windowHeight = sizeWindowHeight[mIndex];
            imageHeight = sizeInnerLayout[mIndex];
            if (!origin)
            {
                zeroOffset = windowHeight - imageHeight;
            } else
            {
                zeroOffset = windowHeight / 2 - imageHeight;
            }
            if (destination)
            {
                centOffset = 0;
            } else
            {
                centOffset = windowHeight / 2;
            }
            if (innerLayout != null && firstMeasure)
            {
                currentOffset = zeroOffset;
                if (SessionFactory.sharedInstance().getSession().getCurrentSessionProgression().getStep() == 0)
                {
                    forcePositionToZeroWithoutAnimation();
                } else
                {
                    translateFromMaxToPosition();
                }
                firstMeasure = false;
                return;
            }
        }
    }

    public void recycleAllBitmaps()
    {
        Object obj = new ArrayList();
        int i = 0;
        while (i < innerLayout.getChildCount()) 
        {
            if (innerLayout.getChildAt(i).getClass() == android/widget/ImageView)
            {
                ((ArrayList) (obj)).add((ImageView)(ImageView)innerLayout.getChildAt(i));
            }
            i++;
        }
        innerLayout.removeAllViews();
        obj = ((ArrayList) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            Object obj1 = ((ImageView)((Iterator) (obj)).next()).getDrawable();
            if (obj1 instanceof BitmapDrawable)
            {
                obj1 = ((BitmapDrawable)obj1).getBitmap();
                try
                {
                    ((Bitmap) (obj1)).recycle();
                }
                catch (Exception exception) { }
            }
        } while (true);
        System.gc();
    }

    public void updatePosition()
    {
        updatePosition(null);
    }

    public void updatePosition(android.view.animation.Animation.AnimationListener animationlistener)
    {
        float f;
        TranslateAnimation translateanimation;
        if (AkSessionFactory.sharedInstance().isAbleToFind())
        {
            f = 100F;
        } else
        {
            f = SessionFactory.sharedInstance().getSession().getCurrentSessionProgression().getProgression();
        }
        f = (float)zeroOffset + (((float)centOffset - (float)zeroOffset) * f) / 100F;
        translateanimation = new TranslateAnimation(0.0F, 0.0F, currentOffset, f);
        translateanimation.setDuration(1000L);
        translateanimation.setFillAfter(true);
        if (animationlistener != null)
        {
            translateanimation.setAnimationListener(animationlistener);
        }
        innerLayout.startAnimation(translateanimation);
        currentOffset = f;
    }


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}

}
