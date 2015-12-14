// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.photoselector;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.crashlytics.android.Crashlytics;
import ew;
import nr;
import sr;

public class PhotoSelectScrollView extends HorizontalScrollView
{

    private static final String TAG = "PhotoSelectScrollView";
    private sr mCallback;
    private LinearLayout mLayout;

    public PhotoSelectScrollView(Context context)
    {
        super(context);
        init();
    }

    public PhotoSelectScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init();
    }

    private final void init()
    {
        mLayout = new LinearLayout(getContext());
        mLayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -1));
        mLayout.setOrientation(0);
        addView(mLayout);
    }

    public void addItem(nr nr)
    {
        Log.v("PhotoSelectScrollView", "addItem");
        try
        {
            View view = LayoutInflater.from(getContext()).inflate(0x7f030081, null);
            ImageButton imagebutton = (ImageButton)view.findViewById(0x7f0c010f);
            ImageButton imagebutton1 = (ImageButton)view.findViewById(0x7f0c0235);
            view.setTag(new Integer(mLayout.getChildCount()));
            imagebutton1.setOnClickListener(new android.view.View.OnClickListener(view) {

                final View a;
                final PhotoSelectScrollView b;

                public void onClick(View view1)
                {
                    if (b.mCallback != null)
                    {
                        b.mCallback.a(a.getTag());
                        b.mLayout.removeView(a);
                        for (int i = 0; i < b.mLayout.getChildCount(); i++)
                        {
                            b.mLayout.getChildAt(i).setTag(new Integer(i));
                        }

                    }
                }

            
            {
                b = PhotoSelectScrollView.this;
                a = view;
                super();
            }
            });
            imagebutton.setOnClickListener(new android.view.View.OnClickListener(view) {

                final View a;
                final PhotoSelectScrollView b;

                public void onClick(View view1)
                {
                    if (b.mCallback != null)
                    {
                        b.mCallback.a(a.getTag());
                        b.mLayout.removeView(a);
                        for (int i = 0; i < b.mLayout.getChildCount(); i++)
                        {
                            b.mLayout.getChildAt(i).setTag(new Integer(i));
                        }

                    }
                }

            
            {
                b = PhotoSelectScrollView.this;
                a = view;
                super();
            }
            });
            (new Thread(new Runnable(nr, imagebutton, view) {

                final nr a;
                final ImageButton b;
                final View c;
                final PhotoSelectScrollView d;

                public void run()
                {
                    Bitmap bitmap = a.a(d.getContext(), ew.a(d.getContext(), 62F), ew.a(d.getContext(), 62F));
                    (new Handler(d.getContext().getMainLooper())).post(new Runnable(this, bitmap) {

                        final Bitmap a;
                        final _cls3 b;

                        public void run()
                        {
                            if (a != null)
                            {
                                b.b.setImageBitmap(a);
                            } else
                            {
                                Log.v("hedong_icon", "no bimap");
                            }
                            if (b.d.mCallback != null)
                            {
                                b.d.mCallback.a();
                            }
                            b.d.mLayout.addView(b.c);
                            (new Handler()).postDelayed(new Runnable(this) {

                                final _cls1 a;

                                public void run()
                                {
                                    a.b.d.scroolToLast();
                                }

            
            {
                a = _pcls1;
                super();
            }
                            }, 300L);
                        }

            
            {
                b = _pcls3;
                a = bitmap;
                super();
            }
                    });
                }

            
            {
                d = PhotoSelectScrollView.this;
                a = nr1;
                b = imagebutton;
                c = view;
                super();
            }
            })).start();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (nr nr)
        {
            Log.e("PhotoSelectScrollView", (new StringBuilder()).append(nr.getMessage()).append("Exception").toString());
        }
        Crashlytics.logException(nr);
    }

    public void scroolToLast()
    {
        if (mLayout.getChildCount() >= 2)
        {
            View view = mLayout.getChildAt(mLayout.getChildCount() - 1);
            Log.v("PhotoSelectScrollView", (new StringBuilder()).append("PhotoSelectScrollView itemView.lastItemView.right :").append(view.getRight()).toString());
            Log.v("PhotoSelectScrollView", (new StringBuilder()).append("PhotoSelectScrollView getScreenWidth :").append(getWidth()).toString());
            Log.v("PhotoSelectScrollView", (new StringBuilder()).append("PhotoSelectScrollView getItemWidth :").append(view.getWidth()).toString());
            int i = getScrollX();
            Log.v("PhotoSelectScrollView", (new StringBuilder()).append("PhotoSelectScrollView scrollx :").append(i).toString());
            if (view.getRight() > getWidth() && i < getWidth())
            {
                smoothScrollTo(getWidth(), 0);
            }
        }
    }

    public void setCallback(sr sr)
    {
        mCallback = sr;
    }


}
