// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.adapters;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.digidust.elokence.akinator.activities.AkActivity;
import com.digidust.elokence.akinator.factories.AkApplication;
import com.elokence.limuleapi.MinibaseFactory;
import java.util.ArrayList;

public class AkMinibaseCharacterAdapter extends BaseAdapter
{

    private AkActivity mActivity;
    android.view.View.OnClickListener mBoutonsSupprClickListener;
    private ArrayList mCharacters;
    private LayoutInflater mInflater;
    private ArrayList mListBoutonsSuppr;
    private ArrayList mListImage;
    private ArrayList mListText;
    android.view.View.OnClickListener mModifyClickListener;
    private Typeface tf;

    public AkMinibaseCharacterAdapter(AkActivity akactivity, ArrayList arraylist)
    {
        tf = AkApplication.getTypeFace();
        mCharacters = null;
        mListImage = new ArrayList();
        mListText = new ArrayList();
        mListBoutonsSuppr = new ArrayList();
        mInflater = null;
        mModifyClickListener = new _cls1();
        mBoutonsSupprClickListener = new _cls2();
        mInflater = LayoutInflater.from(akactivity);
        mCharacters = arraylist;
        mActivity = akactivity;
    }

    public ArrayList getCharacters()
    {
        return mCharacters;
    }

    public int getCount()
    {
        return mCharacters.size();
    }

    public Object getItem(int i)
    {
        return mCharacters.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
    /* block-local class not found */
    class ViewHolder {}

        android.graphics.Bitmap bitmap;
        if (view == null)
        {
            viewgroup = new ViewHolder(null);
            view = mInflater.inflate(0x7f03005d, null);
            viewgroup.uiMinibaseItemPhoto = (ImageView)view.findViewById(0x7f0d026a);
            ((ViewHolder) (viewgroup)).uiMinibaseItemPhoto.setOnClickListener(mModifyClickListener);
            mListImage.add(((ViewHolder) (viewgroup)).uiMinibaseItemPhoto);
            viewgroup.uiMinibaseItemText = (TextView)view.findViewById(0x7f0d026b);
            ((ViewHolder) (viewgroup)).uiMinibaseItemText.setTextSize(0, ((ViewHolder) (viewgroup)).uiMinibaseItemText.getTextSize() * AkApplication.getCoeffFont());
            ((ViewHolder) (viewgroup)).uiMinibaseItemText.setTypeface(tf);
            ((ViewHolder) (viewgroup)).uiMinibaseItemText.setOnClickListener(mModifyClickListener);
            mListText.add(((ViewHolder) (viewgroup)).uiMinibaseItemText);
            viewgroup.uiMinibaseItemSuppBouton = (ImageView)view.findViewById(0x7f0d026e);
            ((ViewHolder) (viewgroup)).uiMinibaseItemSuppBouton.setOnClickListener(mBoutonsSupprClickListener);
            mListBoutonsSuppr.add(((ViewHolder) (viewgroup)).uiMinibaseItemSuppBouton);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        ((ViewHolder) (viewgroup)).uiMinibaseItemText.setText(((com.elokence.limuleapi.Session.ProposedLimuleObjectMinibase)mCharacters.get(i)).getName());
        bitmap = MinibaseFactory.sharedInstance().getMBCharacterPicture(mActivity, (com.elokence.limuleapi.Session.ProposedLimuleObjectMinibase)mCharacters.get(i));
        if (bitmap == null)
        {
            ((ViewHolder) (viewgroup)).uiMinibaseItemPhoto.setImageResource(0x7f0201f9);
            return view;
        } else
        {
            ((ViewHolder) (viewgroup)).uiMinibaseItemPhoto.setImageBitmap(bitmap);
            return view;
        }
    }






    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}

}
