// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.folders;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

// Referenced classes of package com.amazon.gallery.thor.folders:
//            FoldersAdapter

public static class makeAlbumButton extends android.support.v7.widget.older
{

    public TextView countView;
    private AnimatorListenerAdapter hideAnimator;
    public ImageView iconSelectedBackground;
    public ImageView iconSelectedView;
    public ImageView iconView;
    public Button makeAlbumButton;
    public TextView pathView;
    private final String pluralString;
    private AnimatorListenerAdapter showAnimator;
    private final String singularString;
    public TextView titleView;

    public void setFolderPath(String s)
    {
        pathView.setText(s);
    }

    public void setItemCount(int i)
    {
        TextView textview = countView;
        String s;
        if (i > 1)
        {
            s = pluralString;
        } else
        {
            s = singularString;
        }
        textview.setText(String.format(s, new Object[] {
            Integer.valueOf(i)
        }));
    }

    public void setItemSelected(boolean flag)
    {
        if (flag)
        {
            iconSelectedView.setVisibility(0);
            iconView.setVisibility(8);
            return;
        } else
        {
            iconView.setVisibility(0);
            iconSelectedView.setVisibility(8);
            return;
        }
    }

    public void toggleSelectionMode(boolean flag, boolean flag1)
    {
        Button button = makeAlbumButton;
        byte byte0;
        if (flag || flag1)
        {
            byte0 = 4;
        } else
        {
            byte0 = 0;
        }
        button.setVisibility(byte0);
        if (flag && flag1)
        {
            itemView.setBackgroundColor(itemView.getResources().getColor(0x7f09007b));
        } else
        {
            itemView.setBackgroundColor(itemView.getResources().getColor(0x7f0900ab));
        }
        if (flag)
        {
            iconSelectedBackground.animate().scaleX(1.0F).scaleY(1.0F).setDuration(150L).setListener(showAnimator);
        } else
        if (iconSelectedBackground.getVisibility() == 0)
        {
            iconSelectedBackground.animate().scaleX(0.0F).scaleY(0.0F).setDuration(150L).setListener(hideAnimator);
            return;
        }
    }

    public _cls2.this._cls0(View view)
    {
        super(view);
        hideAnimator = new AnimatorListenerAdapter() {

            final FoldersAdapter.ViewHolder this$0;

            public void onAnimationEnd(Animator animator)
            {
                iconSelectedBackground.setVisibility(8);
            }

            
            {
                this$0 = FoldersAdapter.ViewHolder.this;
                super();
            }
        };
        showAnimator = new AnimatorListenerAdapter() {

            final FoldersAdapter.ViewHolder this$0;

            public void onAnimationStart(Animator animator)
            {
                iconSelectedBackground.setVisibility(0);
            }

            
            {
                this$0 = FoldersAdapter.ViewHolder.this;
                super();
            }
        };
        Context context = view.getContext();
        singularString = context.getString(0x7f0e01be);
        pluralString = context.getString(0x7f0e01bd);
        iconView = (ImageView)view.findViewById(0x7f0c0143);
        iconSelectedView = (ImageView)view.findViewById(0x7f0c0144);
        iconSelectedBackground = (ImageView)view.findViewById(0x7f0c0142);
        titleView = (TextView)view.findViewById(0x7f0c0145);
        countView = (TextView)view.findViewById(0x7f0c0147);
        pathView = (TextView)view.findViewById(0x7f0c0148);
        makeAlbumButton = (Button)view.findViewById(0x7f0c0146);
    }
}
