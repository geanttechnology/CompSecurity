// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.digidust.elokence.akinator.factories.AkApplication;
import com.elokence.limuleapi.TraductionFactory;
import java.util.ArrayList;

public class AkCharacterAnswerAdapter extends BaseAdapter
{

    private ArrayList mCharacters;
    private LayoutInflater mInflater;
    private Typeface tf;

    public AkCharacterAnswerAdapter(Context context, ArrayList arraylist)
    {
        tf = AkApplication.getTypeFace();
        mCharacters = null;
        mInflater = null;
        mInflater = LayoutInflater.from(context);
        mCharacters = arraylist;
    }

    public int getCount()
    {
        return mCharacters.size();
    }

    public View getDropDownView(int i, View view, ViewGroup viewgroup)
    {
        return super.getDropDownView(i, view, viewgroup);
    }

    public Object getItem(int i)
    {
        return mCharacters.get(i);
    }

    public long getItemId(int i)
    {
        return (long)((com.digidust.elokence.akinator.activities.AddQuestionActivity.LimuleObjectAnswer)mCharacters.get(i)).getObject().getIdBase();
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
    /* block-local class not found */
    class ViewHolder {}

        if (view == null)
        {
            viewgroup = new ViewHolder(null);
            view = mInflater.inflate(0x7f030057, null);
            viewgroup.uiCharacter_item_background = (ImageView)view.findViewById(0x7f0d0259);
            viewgroup.uiCharacterNameText = (TextView)view.findViewById(0x7f0d0257);
            viewgroup.uiCharacterResponseLabel = (TextView)view.findViewById(0x7f0d025b);
            viewgroup.uiCharacterResponseValue = (TextView)view.findViewById(0x7f0d025c);
            ((ViewHolder) (viewgroup)).uiCharacterResponseValue.setTextSize(0, ((ViewHolder) (viewgroup)).uiCharacterResponseValue.getTextSize() * AkApplication.getCoeffFont());
            ((ViewHolder) (viewgroup)).uiCharacterResponseLabel.setTextSize(0, ((ViewHolder) (viewgroup)).uiCharacterResponseLabel.getTextSize() * AkApplication.getCoeffFont());
            ((ViewHolder) (viewgroup)).uiCharacterNameText.setTextSize(0, ((ViewHolder) (viewgroup)).uiCharacterNameText.getTextSize() * AkApplication.getCoeffFont());
            ((ViewHolder) (viewgroup)).uiCharacterNameText.setTypeface(tf);
            ((ViewHolder) (viewgroup)).uiCharacterResponseLabel.setTypeface(tf);
            ((ViewHolder) (viewgroup)).uiCharacterResponseValue.setTypeface(tf);
            ((ViewHolder) (viewgroup)).uiCharacterResponseLabel.setText((new StringBuilder()).append(TraductionFactory.sharedInstance().getTraductionFromToken("REPONSE")).append(" :").toString());
            ((ViewHolder) (viewgroup)).uiCharacterResponseValue.setText(TraductionFactory.sharedInstance().getTraductionFromToken("SELECTIONNEZ"));
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        ((ViewHolder) (viewgroup)).uiCharacterNameText.setText(((com.digidust.elokence.akinator.activities.AddQuestionActivity.LimuleObjectAnswer)mCharacters.get(i)).getObject().getName());
        switch (((com.digidust.elokence.akinator.activities.AddQuestionActivity.LimuleObjectAnswer)mCharacters.get(i)).getAnswer())
        {
        default:
            ((ViewHolder) (viewgroup)).uiCharacter_item_background.setImageResource(0x7f020276);
            ((ViewHolder) (viewgroup)).uiCharacterResponseValue.setText(TraductionFactory.sharedInstance().getTraductionFromToken("SELECTIONNER"));
            return view;

        case -1: 
            ((ViewHolder) (viewgroup)).uiCharacter_item_background.setImageResource(0x7f020276);
            ((ViewHolder) (viewgroup)).uiCharacterResponseValue.setText(TraductionFactory.sharedInstance().getTraductionFromToken("JE_NE_CONNAIS_PAS_LA_REPONSE"));
            return view;

        case 0: // '\0'
            ((ViewHolder) (viewgroup)).uiCharacter_item_background.setImageResource(0x7f02026a);
            ((ViewHolder) (viewgroup)).uiCharacterResponseValue.setText(TraductionFactory.sharedInstance().getTraductionFromToken("OUI"));
            return view;

        case 1: // '\001'
            ((ViewHolder) (viewgroup)).uiCharacter_item_background.setImageResource(0x7f02026a);
            ((ViewHolder) (viewgroup)).uiCharacterResponseValue.setText(TraductionFactory.sharedInstance().getTraductionFromToken("NON"));
            return view;

        case 2: // '\002'
            ((ViewHolder) (viewgroup)).uiCharacter_item_background.setImageResource(0x7f02026a);
            ((ViewHolder) (viewgroup)).uiCharacterResponseValue.setText(TraductionFactory.sharedInstance().getTraductionFromToken("NE_SAIS_PAS"));
            return view;

        case 3: // '\003'
            ((ViewHolder) (viewgroup)).uiCharacter_item_background.setImageResource(0x7f02026a);
            ((ViewHolder) (viewgroup)).uiCharacterResponseValue.setText(TraductionFactory.sharedInstance().getTraductionFromToken("PROBABLEMENT"));
            return view;

        case 4: // '\004'
            ((ViewHolder) (viewgroup)).uiCharacter_item_background.setImageResource(0x7f02026a);
            break;
        }
        ((ViewHolder) (viewgroup)).uiCharacterResponseValue.setText(TraductionFactory.sharedInstance().getTraductionFromToken("PROBABLEMENT_PAS"));
        return view;
    }
}
