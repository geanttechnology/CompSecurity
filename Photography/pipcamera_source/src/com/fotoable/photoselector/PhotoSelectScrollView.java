// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photoselector;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import nb;
import nr;

public class PhotoSelectScrollView extends HorizontalScrollView
{

    private static final String TAG = "PhotoSelectScrollView";
    private nb mCallback;
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

    public void addItem(nr nr1)
    {
        Log.v("PhotoSelectScrollView", "addItem");
        View view;
        ImageButton imagebutton;
        try
        {
            view = LayoutInflater.from(getContext()).inflate(com.fotoable.fotophotoselector.R.layout.selector_item_view, null);
            imagebutton = (ImageButton)view.findViewById(com.fotoable.fotophotoselector.R.id.item_icon);
            ImageButton imagebutton1 = (ImageButton)view.findViewById(com.fotoable.fotophotoselector.R.id.delete_icon);
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
            nr1 = nr1.c(getContext());
        }
        // Misplaced declaration of an exception variable
        catch (nr nr1)
        {
            Log.e("PhotoSelectScrollView", nr1.getMessage());
            return;
        }
        if (nr1 == null)
        {
            break MISSING_BLOCK_LABEL_105;
        }
        imagebutton.setImageBitmap(nr1);
_L2:
        mLayout.addView(view);
        return;
        Log.v("hedong_icon", "no bimap");
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void setCallback(nb nb)
    {
        mCallback = nb;
    }


}
