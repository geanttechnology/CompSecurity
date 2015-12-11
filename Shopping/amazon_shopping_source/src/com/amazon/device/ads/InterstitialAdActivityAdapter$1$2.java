// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

// Referenced classes of package com.amazon.device.ads:
//            InterstitialAdActivityAdapter

class val.closeButton
    implements android.view.pter._cls1._cls2
{

    final l.closeNormal this$1;
    final ImageView val$closeButton;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        motionevent.getAction();
        JVM INSTR tableswitch 0 1: default 28
    //                   0 30
    //                   1 47;
           goto _L1 _L2 _L3
_L1:
        return false;
_L2:
        val$closeButton.setImageDrawable(closePressed);
        continue; /* Loop/switch isn't completed */
_L3:
        val$closeButton.setImageDrawable(closeNormal);
        if (true) goto _L1; else goto _L4
_L4:
    }

    l.tapTargetSize()
    {
        this$1 = final_taptargetsize;
        val$closeButton = ImageView.this;
        super();
    }

    // Unreferenced inner class com/amazon/device/ads/InterstitialAdActivityAdapter$1

/* anonymous class */
    class InterstitialAdActivityAdapter._cls1 extends AsyncTask
    {

        final InterstitialAdActivityAdapter this$0;
        final int val$buttonSize;
        final BitmapDrawable val$closeNormal;
        final BitmapDrawable val$closePressed;
        final FrameLayout val$parentView;
        final int val$tapTargetSize;

        protected transient RelativeLayout doInBackground(Void avoid[])
        {
            avoid = new RelativeLayout(parentView.getContext());
            ImageButton imagebutton = new ImageButton(parentView.getContext());
            imagebutton.setImageDrawable(closeNormal);
            imagebutton.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
            imagebutton.setBackgroundDrawable(null);
            Object obj = new InterstitialAdActivityAdapter._cls1._cls1();
            imagebutton.setOnClickListener(((android.view.View.OnClickListener) (obj)));
            avoid.setOnClickListener(((android.view.View.OnClickListener) (obj)));
            obj = imagebutton. new InterstitialAdActivityAdapter._cls1._cls2();
            avoid.setOnTouchListener(((android.view.View.OnTouchListener) (obj)));
            imagebutton.setOnTouchListener(((android.view.View.OnTouchListener) (obj)));
            obj = new android.widget.RelativeLayout.LayoutParams(buttonSize, buttonSize);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(13);
            avoid.addView(imagebutton, ((android.view.ViewGroup.LayoutParams) (obj)));
            return avoid;
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected void onPostExecute(RelativeLayout relativelayout)
        {
            android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(tapTargetSize, tapTargetSize, 5);
            layoutparams.topMargin = 0;
            layoutparams.rightMargin = 0;
            parentView.addView(relativelayout, layoutparams);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((RelativeLayout)obj);
        }

            
            {
                this$0 = final_interstitialadactivityadapter;
                parentView = framelayout;
                closeNormal = bitmapdrawable;
                closePressed = bitmapdrawable1;
                buttonSize = i;
                tapTargetSize = I.this;
                super();
            }

        // Unreferenced inner class com/amazon/device/ads/InterstitialAdActivityAdapter$1$1

/* anonymous class */
        class InterstitialAdActivityAdapter._cls1._cls1
            implements android.view.View.OnClickListener
        {

            final InterstitialAdActivityAdapter._cls1 this$1;

            public void onClick(View view)
            {
                InterstitialAdActivityAdapter.access$000(this$0).finish();
            }

                    
                    {
                        this$1 = InterstitialAdActivityAdapter._cls1.this;
                        super();
                    }
        }

    }

}
