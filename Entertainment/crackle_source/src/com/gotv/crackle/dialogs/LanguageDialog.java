// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import com.gotv.crackle.captions.CaptionsActivity;
import com.gotv.crackle.data.VideoDubSubtitleProcessor;
import com.gotv.crackle.model.MediaDetailsItem;
import com.gotv.crackle.model.RelatedItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LanguageDialog extends DialogFragment
{
    public static interface LanguageDialogListener
    {

        public abstract void updateLanguageCancelled();

        public abstract void updateLanguageSettings(Map map, String s, String s1, List list, String s2);
    }


    private Context context;
    private Spinner mAudioSpinner;
    private LanguageDialogListener mDialogListener;
    private boolean mIsChromecast;
    private Spinner mLanguageSpinner;
    private String mSelectedSubtitles;
    private VideoDubSubtitleProcessor mVideoDubSubtitleProcessor;

    public LanguageDialog()
    {
    }

    private boolean isSelectedItemDubbed()
    {
        String s = (String)mAudioSpinner.getSelectedItem();
        return mVideoDubSubtitleProcessor != null && mVideoDubSubtitleProcessor.getCurrentItem().getLocalizedLanguage() != null && !mVideoDubSubtitleProcessor.getCurrentItem().getLocalizedLanguage().equals(s);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        View view;
        ArrayList arraylist;
        view = layoutinflater.inflate(0x7f030044, viewgroup);
        layoutinflater = (Button)view.findViewById(0x7f0a00d1);
        context = getActivity();
        layoutinflater.setOnClickListener(new android.view.View.OnClickListener() {

            final LanguageDialog this$0;

            public void onClick(View view1)
            {
                Object obj;
                Object obj1;
                Object obj2;
                String s;
                String s1;
                dismiss();
                view1 = null;
                obj1 = null;
                obj = null;
                s1 = (String)mAudioSpinner.getSelectedItem();
                s = (String)mLanguageSpinner.getSelectedItem();
                obj2 = "";
                if (isSelectedItemDubbed()) goto _L2; else goto _L1
_L1:
                obj2 = mVideoDubSubtitleProcessor.getCurrentItem().getMediaUrls();
                view1 = ((View) (obj));
                if (s != null)
                {
                    view1 = (List)mVideoDubSubtitleProcessor.getCurrentItem().getClosedCaptionFiles().get(s);
                }
                obj = mVideoDubSubtitleProcessor.getCurrentItem().getCaptionLocaleFromLanguage(s);
                obj1 = view1;
_L4:
                view1 = s;
                if (s == null)
                {
                    view1 = getString(0x7f0b00d5);
                }
                if (mDialogListener != null)
                {
                    mDialogListener.updateLanguageSettings(((Map) (obj2)), s1, view1, ((List) (obj1)), ((String) (obj)));
                }
                return;
_L2:
                int i1 = 0;
                obj = obj2;
                do
                {
                    obj2 = view1;
                    if (i1 >= mVideoDubSubtitleProcessor.getCurrentItem().getRelatedItems().length)
                    {
                        continue;
                    }
                    if (mVideoDubSubtitleProcessor.getCurrentItem().getRelatedItems()[i1].getLocalizedLanguage().equalsIgnoreCase(s1))
                    {
                        view1 = mVideoDubSubtitleProcessor.getCurrentItem().getRelatedItems()[i1].getMediaUrls();
                    }
                    obj1 = (List)mVideoDubSubtitleProcessor.getCurrentItem().getRelatedItems()[i1].getClosedCaptionFiles().get(s);
                    obj = mVideoDubSubtitleProcessor.getCurrentItem().getRelatedItems()[i1].getCaptionLocaleFromLanguage(s);
                    i1++;
                } while (true);
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                this$0 = LanguageDialog.this;
                super();
            }
        });
        layoutinflater = (Button)view.findViewById(0x7f0a00dc);
        if (mIsChromecast)
        {
            layoutinflater.setVisibility(8);
        }
        layoutinflater.setOnClickListener(new android.view.View.OnClickListener() {

            final LanguageDialog this$0;

            public void onClick(View view1)
            {
                view1 = new Intent(getActivity(), com/gotv/crackle/captions/CaptionsActivity);
                startActivity(view1);
            }

            
            {
                this$0 = LanguageDialog.this;
                super();
            }
        });
        arraylist = new ArrayList();
        bundle = new ArrayList();
        layoutinflater = null;
        mLanguageSpinner = (Spinner)view.findViewById(0x7f0a00db);
        if (!mVideoDubSubtitleProcessor.getCurrentLanguage().equals(mVideoDubSubtitleProcessor.getCurrentItem().getLocalizedLanguage())) goto _L2; else goto _L1
_L1:
        viewgroup = mVideoDubSubtitleProcessor.getCurrentItem().getClosedCaptionFiles().keySet();
_L4:
        layoutinflater = bundle;
        if (viewgroup != null)
        {
            layoutinflater = new ArrayList(viewgroup);
        }
        layoutinflater.add(0, getString(0x7f0b00d5));
        viewgroup = new ArrayAdapter(getActivity(), 0x1090008, layoutinflater.toArray(new String[layoutinflater.size()]));
        viewgroup.setDropDownViewResource(0x1090009);
        mLanguageSpinner.setAdapter(viewgroup);
        int i = viewgroup.getPosition(mSelectedSubtitles);
        if (i >= 0)
        {
            mLanguageSpinner.setSelection(i);
        }
        if (mVideoDubSubtitleProcessor.getCurrentItem() != null)
        {
            viewgroup = mVideoDubSubtitleProcessor.getCurrentItem().getRelatedItems();
            arraylist.add(mVideoDubSubtitleProcessor.getCurrentItem().getLocalizedLanguage());
            if (viewgroup != null)
            {
                for (int j = 0; j < viewgroup.length; j++)
                {
                    arraylist.add(viewgroup[j].getLocalizedLanguage());
                }

            }
        }
        break MISSING_BLOCK_LABEL_401;
_L2:
        int k = 0;
        do
        {
            viewgroup = layoutinflater;
            if (k >= mVideoDubSubtitleProcessor.getCurrentItem().getRelatedItems().length)
            {
                break;
            }
            if (mVideoDubSubtitleProcessor.getCurrentItem().getRelatedItems()[k].getLocalizedLanguage().equalsIgnoreCase(mVideoDubSubtitleProcessor.getCurrentLanguage()))
            {
                layoutinflater = mVideoDubSubtitleProcessor.getCurrentItem().getRelatedItems()[k].getClosedCaptionFiles().keySet();
            }
            k++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        mAudioSpinner = (Spinner)view.findViewById(0x7f0a00d9);
        int l;
        if (arraylist.size() > 0)
        {
            viewgroup = new ArrayAdapter(getActivity(), 0x1090008, arraylist.toArray(new String[arraylist.size()]));
            viewgroup.setDropDownViewResource(0x1090009);
            mAudioSpinner.setAdapter(viewgroup);
            mAudioSpinner.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {

                final LanguageDialog this$0;

                public void onItemSelected(AdapterView adapterview, View view1, int i1, long l1)
                {
                    if (isSelectedItemDubbed())
                    {
                        adapterview = (String)mAudioSpinner.getSelectedItem();
                        for (i1 = 0; i1 < mVideoDubSubtitleProcessor.getCurrentItem().getRelatedItems().length; i1++)
                        {
                            if (mVideoDubSubtitleProcessor.getCurrentItem().getRelatedItems()[i1].getLocalizedLanguage().equalsIgnoreCase(adapterview))
                            {
                                view1 = new ArrayList(mVideoDubSubtitleProcessor.getCurrentItem().getRelatedItems()[i1].getClosedCaptionFiles().keySet());
                                view1.add(0, getString(0x7f0b00d5));
                                ArrayAdapter arrayadapter = new ArrayAdapter(context, 0x1090008, view1.toArray(new String[view1.size()]));
                                arrayadapter.setDropDownViewResource(0x1090009);
                                mLanguageSpinner.setAdapter(arrayadapter);
                                int j1 = view1.indexOf(mVideoDubSubtitleProcessor.getCurrentCaptions());
                                mLanguageSpinner.setSelection(j1);
                            }
                        }

                    } else
                    {
                        adapterview = new ArrayList(mVideoDubSubtitleProcessor.getCurrentItem().getClosedCaptionFiles().keySet());
                        adapterview.add(0, getString(0x7f0b00d5));
                        view1 = new ArrayAdapter(context, 0x1090008, adapterview.toArray(new String[adapterview.size()]));
                        view1.setDropDownViewResource(0x1090009);
                        mLanguageSpinner.setAdapter(view1);
                        i1 = adapterview.indexOf(mVideoDubSubtitleProcessor.getCurrentCaptions());
                        mLanguageSpinner.setSelection(i1);
                    }
                }

                public void onNothingSelected(AdapterView adapterview)
                {
                }

            
            {
                this$0 = LanguageDialog.this;
                super();
            }
            });
        } else
        {
            view.findViewById(0x7f0a00d8).setVisibility(8);
        }
        getDialog().setTitle(getResources().getString(0x7f0b00f9));
        mAudioSpinner.setSelection(arraylist.indexOf(mVideoDubSubtitleProcessor.getCurrentLanguage()));
        l = layoutinflater.indexOf(mVideoDubSubtitleProcessor.getCurrentCaptions());
        mLanguageSpinner.setSelection(l);
        return view;
    }

    public void setIsChromecast(boolean flag)
    {
        mIsChromecast = flag;
    }

    public void setLanguageDialogListener(LanguageDialogListener languagedialoglistener)
    {
        mDialogListener = languagedialoglistener;
    }

    public void setSelectedSubtitles(String s)
    {
        mSelectedSubtitles = s;
    }

    public void setVideoDubSubtitleProcessor(VideoDubSubtitleProcessor videodubsubtitleprocessor)
    {
        mVideoDubSubtitleProcessor = videodubsubtitleprocessor;
    }






}
