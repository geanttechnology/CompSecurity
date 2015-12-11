// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.captions;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.gotv.crackle.captions.model.CaptionSettings;

// Referenced classes of package com.gotv.crackle.captions:
//            CaptionMainSettingsFragment, CaptionWindowSettingsFragment, CaptionBackgroundSettingsFragment, CaptionFontStyleSettingsFragment, 
//            CaptionEffectsSettingsFragment, CaptionWindow

public abstract class CaptionSettingsFragment extends Fragment
    implements android.widget.AdapterView.OnItemClickListener
{
    public static final class CaptionSettingsMode extends Enum
    {

        private static final CaptionSettingsMode $VALUES[];
        public static final CaptionSettingsMode CaptionEffects;
        public static final CaptionSettingsMode CharacterBackground;
        public static final CaptionSettingsMode FontStyle;
        public static final CaptionSettingsMode Main;
        public static final CaptionSettingsMode WindowSettings;

        public static CaptionSettingsMode valueOf(String s)
        {
            return (CaptionSettingsMode)Enum.valueOf(com/gotv/crackle/captions/CaptionSettingsFragment$CaptionSettingsMode, s);
        }

        public static CaptionSettingsMode[] values()
        {
            return (CaptionSettingsMode[])$VALUES.clone();
        }

        static 
        {
            Main = new CaptionSettingsMode("Main", 0);
            WindowSettings = new CaptionSettingsMode("WindowSettings", 1);
            CharacterBackground = new CaptionSettingsMode("CharacterBackground", 2);
            FontStyle = new CaptionSettingsMode("FontStyle", 3);
            CaptionEffects = new CaptionSettingsMode("CaptionEffects", 4);
            $VALUES = (new CaptionSettingsMode[] {
                Main, WindowSettings, CharacterBackground, FontStyle, CaptionEffects
            });
        }

        private CaptionSettingsMode(String s, int i)
        {
            super(s, i);
        }
    }


    public static final String INTENT_MODE = "CAPTION_SETTINGS_MODE";
    protected CaptionSettings _captionSettings;
    protected CaptionWindow _captionWindow;
    protected ArrayAdapter _listAdapter;

    public CaptionSettingsFragment()
    {
    }

    public static CaptionSettingsMode getCaptionSettingsModeForInt(int i)
    {
        if (i == 0)
        {
            return CaptionSettingsMode.Main;
        }
        if (i == 1)
        {
            return CaptionSettingsMode.WindowSettings;
        }
        if (i == 2)
        {
            return CaptionSettingsMode.CharacterBackground;
        }
        if (i == 3)
        {
            return CaptionSettingsMode.FontStyle;
        }
        if (i == 4)
        {
            return CaptionSettingsMode.CaptionEffects;
        } else
        {
            return CaptionSettingsMode.Main;
        }
    }

    public static CaptionSettingsFragment getFragmentForMode(CaptionSettingsMode captionsettingsmode)
    {
        if (captionsettingsmode == CaptionSettingsMode.Main)
        {
            return new CaptionMainSettingsFragment();
        }
        if (captionsettingsmode == CaptionSettingsMode.WindowSettings)
        {
            return new CaptionWindowSettingsFragment();
        }
        if (captionsettingsmode == CaptionSettingsMode.CharacterBackground)
        {
            return new CaptionBackgroundSettingsFragment();
        }
        if (captionsettingsmode == CaptionSettingsMode.FontStyle)
        {
            return new CaptionFontStyleSettingsFragment();
        }
        if (captionsettingsmode == CaptionSettingsMode.CaptionEffects)
        {
            return new CaptionEffectsSettingsFragment();
        } else
        {
            return null;
        }
    }

    public static int getIntForCaptionSettingsMode(CaptionSettingsMode captionsettingsmode)
    {
        if (captionsettingsmode != CaptionSettingsMode.Main)
        {
            if (captionsettingsmode == CaptionSettingsMode.WindowSettings)
            {
                return 1;
            }
            if (captionsettingsmode == CaptionSettingsMode.CharacterBackground)
            {
                return 2;
            }
            if (captionsettingsmode == CaptionSettingsMode.FontStyle)
            {
                return 3;
            }
            if (captionsettingsmode == CaptionSettingsMode.CaptionEffects)
            {
                return 4;
            }
        }
        return 0;
    }

    public static int getTitleIdForMode(CaptionSettingsMode captionsettingsmode)
    {
        if (captionsettingsmode == CaptionSettingsMode.Main)
        {
            return 0x7f0b014c;
        }
        if (captionsettingsmode == CaptionSettingsMode.WindowSettings)
        {
            return 0x7f0b014d;
        }
        if (captionsettingsmode == CaptionSettingsMode.CharacterBackground)
        {
            return 0x7f0b014e;
        }
        if (captionsettingsmode == CaptionSettingsMode.FontStyle)
        {
            return 0x7f0b014f;
        }
        return captionsettingsmode != CaptionSettingsMode.CaptionEffects ? 0 : 0x7f0b0150;
    }

    public abstract String getFragmentTitle();

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        _listAdapter = new ArrayAdapter(getActivity(), 0) {

            final CaptionSettingsFragment this$0;

            public View getView(int i, View view, ViewGroup viewgroup)
            {
                return (View)getItem(i);
            }

            
            {
                this$0 = CaptionSettingsFragment.this;
                super(context, i);
            }
        };
        _captionSettings = CaptionSettings.getCaptionSettingsForMediaDetails(null);
        setAdapterRows();
        bundle = (ListView)getView().findViewById(0x7f0a0087);
        bundle.setAdapter(_listAdapter);
        _captionWindow = (CaptionWindow)getView().findViewById(0x7f0a0086);
        bundle.setOnItemClickListener(this);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f030024, viewgroup, false);
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
    }

    public void onPause()
    {
        super.onPause();
        _captionSettings.savePrefs();
    }

    public void onResume()
    {
        super.onResume();
        _captionSettings = CaptionSettings.getCaptionSettingsForMediaDetails(null);
        updatePreview();
    }

    public void reset()
    {
        _captionSettings.clearPrefs();
        _captionSettings = CaptionSettings.getCaptionSettingsForMediaDetails(null);
        updatePreview();
    }

    protected abstract void setAdapterRows();

    protected void updatePreview()
    {
        _captionWindow.setCaptionSettings(_captionSettings);
    }
}
