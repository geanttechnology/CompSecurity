// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.views;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TipsToast extends Toast
{

    public TipsToast(Context context)
    {
        super(context);
    }

    public static volatile Toast makeText(Context context, int i, int j)
        throws android.content.res.Resources.NotFoundException
    {
        return makeText(context, i, j);
    }

    public static volatile Toast makeText(Context context, CharSequence charsequence, int i)
    {
        return makeText(context, charsequence, i);
    }

    public static TipsToast makeText(Context context, int i, int j)
        throws android.content.res.Resources.NotFoundException
    {
        return makeText(context, context.getResources().getText(i), j);
    }

    public static TipsToast makeText(Context context, CharSequence charsequence, int i)
    {
        TipsToast tipstoast = new TipsToast(context);
        context = ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(0x7f0300c0, null);
        ((TextView)context.findViewById(0x7f070408)).setText(charsequence);
        tipstoast.setView(context);
        tipstoast.setGravity(16, 0, 0);
        tipstoast.setDuration(i);
        return tipstoast;
    }

    public void setIcon(int i)
    {
        if (getView() == null)
        {
            throw new RuntimeException("This Toast was not created with Toast.makeText()");
        }
        ImageView imageview = (ImageView)getView().findViewById(0x7f070407);
        if (imageview == null)
        {
            throw new RuntimeException("This Toast was not created with Toast.makeText()");
        } else
        {
            imageview.setImageResource(i);
            return;
        }
    }

    public void setText(CharSequence charsequence)
    {
        if (getView() == null)
        {
            throw new RuntimeException("This Toast was not created with Toast.makeText()");
        }
        TextView textview = (TextView)getView().findViewById(0x7f070408);
        if (textview == null)
        {
            throw new RuntimeException("This Toast was not created with Toast.makeText()");
        } else
        {
            textview.setText(charsequence);
            return;
        }
    }
}
