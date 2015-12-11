// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.gotv.crackle.Application;

public class EpisodeDetailsMoreInfoFragment extends Fragment
{

    private TextView mCastText;
    private TextView mDescriptionText;
    private TextView mDirectorsText;
    private TextView mGenresText;
    private TextView mMoreInfoLabel;
    private View mMoreInfoLine;
    private TextView mWritersText;

    public EpisodeDetailsMoreInfoFragment()
    {
    }

    public void hideMoreInfo()
    {
        mMoreInfoLabel.setVisibility(8);
        mMoreInfoLine.setVisibility(8);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030047, viewgroup, false);
        mMoreInfoLabel = (TextView)layoutinflater.findViewById(0x7f0a00e0);
        mMoreInfoLine = layoutinflater.findViewById(0x7f0a00e1);
        mGenresText = (TextView)layoutinflater.findViewById(0x7f0a00e2);
        mCastText = (TextView)layoutinflater.findViewById(0x7f0a00e3);
        mDirectorsText = (TextView)layoutinflater.findViewById(0x7f0a00e4);
        mWritersText = (TextView)layoutinflater.findViewById(0x7f0a00e5);
        mDescriptionText = (TextView)layoutinflater.findViewById(0x7f0a00e6);
        if (Application.getInstance().isTablet())
        {
            mMoreInfoLabel.setPadding(0, 0, 0, 0);
            mGenresText.setPadding(0, 0, 0, 0);
            mCastText.setPadding(0, 0, 0, 0);
            mDirectorsText.setPadding(0, 0, 0, 0);
            mWritersText.setPadding(0, 0, 0, 0);
            mDescriptionText.setPadding(0, 0, 0, 0);
        }
        return layoutinflater;
    }

    public void setEpisodeDetailsCast(String s)
    {
        if (s == null)
        {
            mCastText.setVisibility(8);
            return;
        }
        if (Application.getInstance().isTablet())
        {
            mCastText.setText((new StringBuilder()).append(getResources().getString(0x7f0b00ab)).append(" ").append(s).toString());
            return;
        } else
        {
            mCastText.setText(Application.setStringColor((new StringBuilder()).append(getResources().getString(0x7f0b00ab)).append(" ").toString(), s));
            return;
        }
    }

    public void setEpisodeDetailsDescription(String s)
    {
        if (s == null)
        {
            mDescriptionText.setVisibility(8);
            return;
        }
        if (Application.getInstance().isTablet())
        {
            mDescriptionText.setText(s);
            return;
        } else
        {
            mDescriptionText.setText(Application.setStringColor("", s));
            return;
        }
    }

    public void setEpisodeDetailsDirectors(String s)
    {
        if (s == null)
        {
            mDirectorsText.setVisibility(8);
            return;
        }
        if (Application.getInstance().isTablet())
        {
            mDirectorsText.setText((new StringBuilder()).append(getResources().getString(0x7f0b00ac)).append(" ").append(s).toString());
            return;
        } else
        {
            mDirectorsText.setText(Application.setStringColor((new StringBuilder()).append(getResources().getString(0x7f0b00ac)).append(" ").toString(), s));
            return;
        }
    }

    public void setEpisodeDetailsGenre(String s)
    {
        if (s == null)
        {
            mGenresText.setVisibility(8);
            return;
        }
        if (Application.getInstance().isTablet())
        {
            mGenresText.setText((new StringBuilder()).append(getResources().getString(0x7f0b00aa)).append(" ").append(s).toString());
            return;
        } else
        {
            mGenresText.setText(Application.setStringColor((new StringBuilder()).append(getResources().getString(0x7f0b00aa)).append(" ").toString(), s));
            return;
        }
    }

    public void setEpisodeDetailsWriters(String s)
    {
        if (s == null)
        {
            mWritersText.setVisibility(8);
            return;
        }
        if (Application.getInstance().isTablet())
        {
            mWritersText.setText((new StringBuilder()).append(getResources().getString(0x7f0b00ad)).append(" ").append(s).toString());
            return;
        } else
        {
            mWritersText.setText(Application.setStringColor((new StringBuilder()).append(getResources().getString(0x7f0b00ad)).append(" ").toString(), s));
            return;
        }
    }

    public void setInfoLabelTextColor()
    {
        if (!Application.getInstance().isTablet())
        {
            mMoreInfoLabel.setTextColor(getResources().getColor(0x7f070023));
        }
    }
}
