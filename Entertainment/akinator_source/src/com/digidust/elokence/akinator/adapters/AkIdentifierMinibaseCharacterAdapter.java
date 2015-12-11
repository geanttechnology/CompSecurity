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
import android.widget.LinearLayout;
import android.widget.TextView;
import com.digidust.elokence.akinator.activities.AkActivity;
import com.digidust.elokence.akinator.factories.AkApplication;
import com.elokence.limuleapi.MinibaseFactory;
import java.util.ArrayList;

public class AkIdentifierMinibaseCharacterAdapter extends BaseAdapter
{

    private AkActivity mActivity;
    private int mActivityMode;
    private ArrayList mCharacters;
    private LayoutInflater mInflater;
    private ArrayList mListLayouts;
    android.view.View.OnClickListener mValideClickListener;
    protected Typeface tf;

    public AkIdentifierMinibaseCharacterAdapter(AkActivity akactivity, ArrayList arraylist, int i)
    {
        tf = AkApplication.getTypeFace();
        mCharacters = null;
        mListLayouts = new ArrayList();
        mInflater = null;
        mValideClickListener = new _cls1();
        mInflater = LayoutInflater.from(akactivity);
        mCharacters = arraylist;
        mActivity = akactivity;
        mActivityMode = i;
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
            view = mInflater.inflate(0x7f03005b, null);
            viewgroup.uiLayoutIdentifier = (LinearLayout)view.findViewById(0x7f0d0269);
            ((ViewHolder) (viewgroup)).uiLayoutIdentifier.setOnClickListener(mValideClickListener);
            mListLayouts.add(((ViewHolder) (viewgroup)).uiLayoutIdentifier);
            viewgroup.uiMinibaseItemPhoto = (ImageView)view.findViewById(0x7f0d026a);
            viewgroup.uiMinibaseItemText = (TextView)view.findViewById(0x7f0d026b);
            ((ViewHolder) (viewgroup)).uiMinibaseItemText.setTextSize(0, ((ViewHolder) (viewgroup)).uiMinibaseItemText.getTextSize() * AkApplication.getCoeffFont());
            ((ViewHolder) (viewgroup)).uiMinibaseItemText.setTypeface(tf);
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

}
