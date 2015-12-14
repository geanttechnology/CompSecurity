// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photoselector.activity;

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
import ew;
import java.lang.ref.WeakReference;
import nf;
import nr;

public class PhotoSelectScrollView extends HorizontalScrollView
{

    private static final String TAG = "PhotoSelectScrollView";
    private nf mCallback;
    private WeakReference mContext;
    private LinearLayout mLayout;

    public PhotoSelectScrollView(Context context)
    {
        super(context);
        mContext = new WeakReference(context);
        init();
    }

    public PhotoSelectScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mContext = new WeakReference(context);
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
            View view = LayoutInflater.from(getContext()).inflate(com.fotoable.fotophotoselector.R.layout.selector_item_view, null);
            ImageButton imagebutton = (ImageButton)view.findViewById(com.fotoable.fotophotoselector.R.id.item_icon);
            ImageButton imagebutton1 = (ImageButton)view.findViewById(com.fotoable.fotophotoselector.R.id.delete_icon);
            view.setTag(new Integer(mLayout.getChildCount()));
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
    }

    public void setCallback(nf nf)
    {
        mCallback = nf;
    }


}
