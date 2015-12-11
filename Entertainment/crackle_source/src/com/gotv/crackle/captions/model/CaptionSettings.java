// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.captions.model;

import android.content.SharedPreferences;
import android.graphics.Color;
import com.gotv.crackle.Application;
import com.gotv.crackle.model.MediaDetailsItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.gotv.crackle.captions.model:
//            CaptionColor, CaptionFont

public class CaptionSettings
{
    public static final class CaptionEffects extends Enum
    {

        private static final CaptionEffects $VALUES[];
        public static final CaptionEffects Depressed;
        public static final CaptionEffects DropShadow;
        public static final CaptionEffects None;
        public static final CaptionEffects Raised;
        public static final CaptionEffects Uniform;

        public static CaptionEffects valueOf(String s)
        {
            return (CaptionEffects)Enum.valueOf(com/gotv/crackle/captions/model/CaptionSettings$CaptionEffects, s);
        }

        public static CaptionEffects[] values()
        {
            return (CaptionEffects[])$VALUES.clone();
        }

        static 
        {
            None = new CaptionEffects("None", 0);
            Raised = new CaptionEffects("Raised", 1);
            Depressed = new CaptionEffects("Depressed", 2);
            Uniform = new CaptionEffects("Uniform", 3);
            DropShadow = new CaptionEffects("DropShadow", 4);
            $VALUES = (new CaptionEffects[] {
                None, Raised, Depressed, Uniform, DropShadow
            });
        }

        private CaptionEffects(String s, int i)
        {
            super(s, i);
        }
    }


    public static final float MAX_FONT_SIZE = 30F;
    public static final int MAX_TRANSPARENCY = 255;
    public static final float MIN_FONT_SIZE = 10F;
    public static final int MIN_TRANSPARENCY = 0;
    private static List _sCaptionEffects;
    private static List _sCaptionFonts;
    private static List _sTextColors;
    private boolean _audioOverDubEnabled;
    private CaptionEffects _captionEffects;
    private CaptionFont _captionFont;
    private CaptionColor _characterBackgroundColor;
    private int _characterBackgroundTransparency;
    private float _fontSize;
    private MediaDetailsItem _mediaDetails;
    private String _selectedLanguage;
    private boolean _subtitlesEnabled;
    private CaptionColor _textColor;
    private int _textTransparency;
    private CaptionColor _windowColor;
    private int _windowTransparency;

    private CaptionSettings(MediaDetailsItem mediadetailsitem)
    {
        _subtitlesEnabled = false;
        _audioOverDubEnabled = false;
        _selectedLanguage = null;
        _mediaDetails = mediadetailsitem;
        loadPrefs();
    }

    private CaptionColor getCaptionColorFromColor(int i)
    {
        List list = getTextColors();
        for (Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            CaptionColor captioncolor = (CaptionColor)iterator.next();
            if (captioncolor.getColor() == i)
            {
                return captioncolor;
            }
        }

        return (CaptionColor)list.get(0);
    }

    private static CaptionEffects getCaptionEffectForInt(int i)
    {
        if (i == 0)
        {
            return CaptionEffects.None;
        }
        if (i == 1)
        {
            return CaptionEffects.Depressed;
        }
        if (i == 2)
        {
            return CaptionEffects.Uniform;
        }
        if (i == 3)
        {
            return CaptionEffects.DropShadow;
        }
        if (i == 4)
        {
            return CaptionEffects.Raised;
        } else
        {
            return CaptionEffects.Uniform;
        }
    }

    public static CaptionEffects getCaptionEffectForString(String s)
    {
        if (s == null)
        {
            return CaptionEffects.None;
        }
        if (s.equals(getStringForCaptionEffect(CaptionEffects.Raised)))
        {
            return CaptionEffects.Raised;
        }
        if (s.equals(getStringForCaptionEffect(CaptionEffects.Depressed)))
        {
            return CaptionEffects.Depressed;
        }
        if (s.equals(getStringForCaptionEffect(CaptionEffects.Uniform)))
        {
            return CaptionEffects.Uniform;
        }
        if (s.equals(getStringForCaptionEffect(CaptionEffects.DropShadow)))
        {
            return CaptionEffects.DropShadow;
        }
        if (s.equals(getStringForCaptionEffect(CaptionEffects.None)))
        {
            return CaptionEffects.None;
        } else
        {
            return CaptionEffects.None;
        }
    }

    public static List getCaptionEffectList()
    {
        if (_sCaptionEffects == null)
        {
            _sCaptionEffects = new ArrayList();
            _sCaptionEffects.add(CaptionEffects.None);
            _sCaptionEffects.add(CaptionEffects.Raised);
            _sCaptionEffects.add(CaptionEffects.Depressed);
            _sCaptionEffects.add(CaptionEffects.Uniform);
            _sCaptionEffects.add(CaptionEffects.DropShadow);
        }
        return _sCaptionEffects;
    }

    private CaptionFont getCaptionFontFromName(String s)
    {
        List list = getCaptionFontList();
        for (Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            CaptionFont captionfont = (CaptionFont)iterator.next();
            if (captionfont.getDisplayName().equals(s))
            {
                return captionfont;
            }
        }

        return (CaptionFont)list.get(0);
    }

    public static List getCaptionFontList()
    {
        if (_sCaptionFonts == null)
        {
            android.content.Context context = Application.getAppContext();
            _sCaptionFonts = new ArrayList();
            _sCaptionFonts.add(new CaptionFont("Roboto", "Fonts/Roboto-Light.ttf", context));
            _sCaptionFonts.add(new CaptionFont("Cutive Mono", "Fonts/CutiveMono-Regular.ttf", context));
            _sCaptionFonts.add(new CaptionFont("Crimson Text", "Fonts/CrimsonText-Roman.ttf", context));
            _sCaptionFonts.add(new CaptionFont("Ubuntu Mono", "Fonts/UbuntuMono-Regular.ttf", context));
            _sCaptionFonts.add(new CaptionFont("Quicksand", "Fonts/Quicksand-Regular.ttf", context));
            _sCaptionFonts.add(new CaptionFont("Sofadi One", "Fonts/SofadiOne-Regular.ttf", context));
            _sCaptionFonts.add(new CaptionFont("Great Vibes Script", "Fonts/GreatVibes-Regular.ttf", context));
            _sCaptionFonts.add(new CaptionFont("Mate SC Regular", "Fonts/MateSC-Regular.ttf", context));
        }
        return _sCaptionFonts;
    }

    public static CaptionSettings getCaptionSettingsForMediaDetails(MediaDetailsItem mediadetailsitem)
    {
        return new CaptionSettings(mediadetailsitem);
    }

    private static int getIntForCaptionEffect(CaptionEffects captioneffects)
    {
        if (captioneffects == CaptionEffects.None)
        {
            return 0;
        }
        if (captioneffects == CaptionEffects.Depressed)
        {
            return 1;
        }
        if (captioneffects == CaptionEffects.Uniform)
        {
            return 2;
        }
        if (captioneffects == CaptionEffects.DropShadow)
        {
            return 3;
        }
        return captioneffects != CaptionEffects.Raised ? -1 : 4;
    }

    public static String getStringForCaptionEffect(CaptionEffects captioneffects)
    {
        if (captioneffects == CaptionEffects.None)
        {
            return Application.getInstance().getString(0x7f0b015a);
        }
        if (captioneffects == CaptionEffects.Depressed)
        {
            return Application.getInstance().getString(0x7f0b015b);
        }
        if (captioneffects == CaptionEffects.Uniform)
        {
            return Application.getInstance().getString(0x7f0b015c);
        }
        if (captioneffects == CaptionEffects.DropShadow)
        {
            return Application.getInstance().getString(0x7f0b015d);
        }
        if (captioneffects == CaptionEffects.Raised)
        {
            return Application.getInstance().getString(0x7f0b015e);
        } else
        {
            return null;
        }
    }

    public static List getTextColors()
    {
        if (_sTextColors == null)
        {
            _sTextColors = new ArrayList();
            _sTextColors.add(new CaptionColor(Color.argb(255, 255, 255, 255), 0x7f020076));
            _sTextColors.add(new CaptionColor(Color.argb(255, 255, 0, 0), 0x7f020073));
            _sTextColors.add(new CaptionColor(Color.argb(255, 255, 0, 186), 0x7f020071));
            _sTextColors.add(new CaptionColor(Color.argb(255, 156, 0, 255), 0x7f020072));
            _sTextColors.add(new CaptionColor(Color.argb(255, 0, 24, 255), 0x7f02006f));
            _sTextColors.add(new CaptionColor(Color.argb(255, 0, 255, 30), 0x7f020070));
            _sTextColors.add(new CaptionColor(Color.argb(255, 255, 192, 0), 0x7f020077));
            _sTextColors.add(new CaptionColor(Color.argb(255, 0, 0, 0), 0x7f02006e));
        }
        return _sTextColors;
    }

    private void loadPrefs()
    {
        SharedPreferences sharedpreferences = Application.getInstance().getSharedPreferences("CC_PREFS", 0);
        _subtitlesEnabled = sharedpreferences.getBoolean("_subtitlesEnabled", false);
        _audioOverDubEnabled = sharedpreferences.getBoolean("_audioOverDubEnabled", false);
        _selectedLanguage = sharedpreferences.getString("_selectedLanguage", null);
        _windowColor = getCaptionColorFromColor(sharedpreferences.getInt("_windowColor", 0xff000000));
        _characterBackgroundColor = getCaptionColorFromColor(sharedpreferences.getInt("_characterBackgroundColor", 0xff000000));
        _textColor = getCaptionColorFromColor(sharedpreferences.getInt("_textColor", -1));
        _characterBackgroundTransparency = sharedpreferences.getInt("_characterBackgroundTransparency", 0);
        _windowTransparency = sharedpreferences.getInt("_windowTransparency", 0);
        _textTransparency = sharedpreferences.getInt("_textTransparency", 255);
        _fontSize = sharedpreferences.getFloat("_fontSize", 14F);
        _captionFont = getCaptionFontFromName(sharedpreferences.getString("_captionFont", ""));
        _captionEffects = getCaptionEffectForInt(sharedpreferences.getInt("_captionEffects", getIntForCaptionEffect(CaptionEffects.DropShadow)));
    }

    public void clearPrefs()
    {
        android.content.SharedPreferences.Editor editor = Application.getInstance().getSharedPreferences("CC_PREFS", 0).edit();
        editor.clear();
        editor.apply();
    }

    public boolean getAudioOverDubEnabled()
    {
        return _audioOverDubEnabled;
    }

    public CaptionEffects getCaptionEffects()
    {
        return _captionEffects;
    }

    public CaptionFont getCaptionFont()
    {
        return _captionFont;
    }

    public CaptionColor getCharacterBackgroundColor()
    {
        return _characterBackgroundColor;
    }

    public int getCharacterBackgroundTransparency()
    {
        return _characterBackgroundTransparency;
    }

    public float getFontSize()
    {
        return _fontSize;
    }

    public String getSelectedLanguage()
    {
        return _selectedLanguage;
    }

    public boolean getSubtitlesEnabled()
    {
        return _subtitlesEnabled;
    }

    public String[] getSupportedLanguages()
    {
        if (_mediaDetails == null)
        {
            return null;
        } else
        {
            return (String[])(String[])_mediaDetails.getClosedCaptionFiles().keySet().toArray();
        }
    }

    public CaptionColor getTextColor()
    {
        return _textColor;
    }

    public int getTextTransparency()
    {
        return _textTransparency;
    }

    public CaptionColor getWindowColor()
    {
        return _windowColor;
    }

    public int getWindowTransparency()
    {
        return _windowTransparency;
    }

    public void savePrefs()
    {
        android.content.SharedPreferences.Editor editor = Application.getInstance().getSharedPreferences("CC_PREFS", 0).edit();
        editor.putBoolean("_subtitlesEnabled", _subtitlesEnabled);
        editor.putBoolean("_audioOverDubEnabled", _audioOverDubEnabled);
        if (_selectedLanguage != null)
        {
            editor.putString("_selectedLanguage", _selectedLanguage);
        }
        editor.putInt("_windowColor", _windowColor.getColor());
        editor.putInt("_characterBackgroundColor", _characterBackgroundColor.getColor());
        editor.putInt("_textColor", _textColor.getColor());
        editor.putInt("_characterBackgroundTransparency", _characterBackgroundTransparency);
        editor.putInt("_windowTransparency", _windowTransparency);
        editor.putInt("_textTransparency", _textTransparency);
        editor.putFloat("_fontSize", _fontSize);
        if (_captionFont != null)
        {
            editor.putString("_captionFont", _captionFont.getDisplayName());
        }
        editor.putInt("_captionEffects", getIntForCaptionEffect(_captionEffects));
        editor.apply();
    }

    public void setAudioOverDubEnabled(boolean flag)
    {
        _audioOverDubEnabled = flag;
    }

    public void setCaptionEffects(CaptionEffects captioneffects)
    {
        _captionEffects = captioneffects;
    }

    public void setCaptionFont(CaptionFont captionfont)
    {
        _captionFont = captionfont;
    }

    public void setCharacterBackgroundColor(CaptionColor captioncolor)
    {
        _characterBackgroundColor = captioncolor;
    }

    public void setCharacterBackgroundTransparency(int i)
    {
        _characterBackgroundTransparency = i;
    }

    public void setFontSize(float f)
    {
        _fontSize = f;
    }

    public void setSelectedLanguage(String s)
    {
        _selectedLanguage = s;
    }

    public void setSubtitlesenabled(boolean flag)
    {
        _subtitlesEnabled = flag;
    }

    public void setTextColor(CaptionColor captioncolor)
    {
        _textColor = captioncolor;
    }

    public void setTextTransparency(int i)
    {
        _textTransparency = i;
    }

    public void setWindowColor(CaptionColor captioncolor)
    {
        _windowColor = captioncolor;
    }

    public void setWindowTransparency(int i)
    {
        _windowTransparency = i;
    }
}
