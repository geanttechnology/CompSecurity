// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.digidust.elokence.akinator.factories.AkApplication;
import com.digidust.elokence.akinator.factories.AkFarsiFactory;
import com.digidust.elokence.akinator.factories.AkLog;
import java.util.ArrayList;

public class AkLanguageSelectionAdapter extends BaseAdapter
{

    private Bitmap flags[];
    private LayoutInflater mInflater;
    private ArrayList mLanguages;
    private Typeface tf;

    public AkLanguageSelectionAdapter(Context context, ArrayList arraylist)
    {
        tf = AkApplication.getTypeFace();
        mLanguages = null;
        mInflater = null;
        int j = arraylist.size();
        mInflater = LayoutInflater.from(context);
        flags = new Bitmap[j];
        mLanguages = arraylist;
        for (int i = 0; i < j; i++)
        {
            flags[i] = null;
    /* block-local class not found */
    class AsynchronousFlagLoader {}

            (new AsynchronousFlagLoader(this, mLanguages, i)).execute(new Void[0]);
        }

    }

    public void clear()
    {
        int i = 0;
        do
        {
            if (i >= flags.length)
            {
                break;
            }
            Bitmap bitmap = flags[i];
            if (bitmap == null || bitmap.isRecycled())
            {
                break;
            }
            bitmap.recycle();
            i++;
        } while (true);
    }

    public int getCount()
    {
        return mLanguages.size();
    }

    public Object getItem(int i)
    {
        return mLanguages.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
    /* block-local class not found */
    class ViewHolder {}

        if (view == null)
        {
            AkLog.v("Akinator", (new StringBuilder()).append("convertView null pos ").append(i).append(" for : ").append(((com.elokence.limuleapi.TraductionFactory.Language)mLanguages.get(i)).getLabel()).toString());
            viewgroup = new ViewHolder(null);
            view = mInflater.inflate(0x7f03005c, null);
            viewgroup.uiLanguageText = (TextView)view.findViewById(0x7f0d026d);
            viewgroup.uiLanguageFlag = (ImageView)view.findViewById(0x7f0d0118);
            ((ViewHolder) (viewgroup)).uiLanguageText.setTextSize(0, ((ViewHolder) (viewgroup)).uiLanguageText.getTextSize() * AkApplication.getCoeffFont());
            ((ViewHolder) (viewgroup)).uiLanguageText.setTypeface(tf);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        if (i != 0)
        {
            ((ViewHolder) (viewgroup)).uiLanguageText.setText(((com.elokence.limuleapi.TraductionFactory.Language)mLanguages.get(i)).getLabel());
        } else
        {
            ((ViewHolder) (viewgroup)).uiLanguageText.setText(AkFarsiFactory.Convert(((com.elokence.limuleapi.TraductionFactory.Language)mLanguages.get(i)).getLabel()));
        }
        if (flags[i] != null)
        {
            ((ViewHolder) (viewgroup)).uiLanguageFlag.setImageBitmap(flags[i]);
        }
        return view;
    }

}
