// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.android708compatlib.view.preference;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

// Referenced classes of package com.comcast.cim.cmasl.android708compatlib.view.preference:
//            CCPreviewTextView

public class CCPreviewPreference extends Preference
{
    public static interface CCPreferenceStore
    {

        public abstract int getCCBackgroundColor();

        public abstract int getCCBackgroundOpacity();

        public abstract int getCCEdgeColor();

        public abstract int getCCEdgeType();

        public abstract int getCCFontFamily();

        public abstract int getCCTextColor();

        public abstract int getCCTextSize();

        public abstract void setCCBackgroundColor(int i);

        public abstract void setCCBackgroundOpacity(int i);

        public abstract void setCCEdgeColor(int i);

        public abstract void setCCEdgeType(int i);

        public abstract void setCCFontFamily(int i);

        public abstract void setCCTextColor(int i);

        public abstract void setCCTextSize(int i);
    }


    private CCPreferenceStore ccPrefStore;
    private CCPreviewTextView previewText;

    public CCPreviewPreference(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public CCPreviewPreference(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public static int convertColor(com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color color, String s)
    {
        s = new StringBuilder((new StringBuilder()).append("#").append(s).toString());
        static class _cls1
        {

            static final int $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Color[];
            static final int $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Font[];
            static final int $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Size[];

            static 
            {
                $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Font = new int[com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Font.values().length];
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Font[com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Font.PROPORTIONAL_WITH_SERIFS.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror27) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Font[com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Font.PROPORTIONAL_WITHOUT_SERIFS.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror26) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Font[com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Font.MONOSPACED_WITH_SERIFS.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror25) { }
                $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Color = new int[com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color.values().length];
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Color[com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color.BLACK.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror24) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Color[com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color.GRAY.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror23) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Color[com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color.WHITE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror22) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Color[com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color.BRIGHT_WHITE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror21) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Color[com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color.DARK_RED.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror20) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Color[com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color.RED.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror19) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Color[com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color.BRIGHT_RED.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror18) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Color[com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color.DARK_GREEN.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror17) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Color[com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color.GREEN.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Color[com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color.BRIGHT_GREEN.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Color[com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color.DARK_BLUE.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Color[com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color.BLUE.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Color[com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color.BRIGHT_BLUE.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Color[com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color.DARK_YELLOW.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Color[com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color.YELLOW.ordinal()] = 15;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Color[com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color.BRIGHT_YELLOW.ordinal()] = 16;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Color[com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color.DARK_MAGENTA.ordinal()] = 17;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Color[com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color.MAGENTA.ordinal()] = 18;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Color[com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color.BRIGHT_MAGENTA.ordinal()] = 19;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Color[com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color.DARK_CYAN.ordinal()] = 20;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Color[com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color.CYAN.ordinal()] = 21;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Color[com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color.BRIGHT_CYAN.ordinal()] = 22;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Size = new int[com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Size.values().length];
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Size[com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Size.SMALL.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Size[com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Size.LARGE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Size[com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Size.MEDIUM.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color[color.ordinal()];
        JVM INSTR tableswitch 1 22: default 136
    //                   1 151
    //                   2 161
    //                   3 171
    //                   4 181
    //                   5 191
    //                   6 201
    //                   7 211
    //                   8 221
    //                   9 231
    //                   10 241
    //                   11 251
    //                   12 261
    //                   13 271
    //                   14 281
    //                   15 291
    //                   16 301
    //                   17 311
    //                   18 321
    //                   19 331
    //                   20 341
    //                   21 351
    //                   22 361;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23
_L1:
        s.append("000000");
_L25:
        return Color.parseColor(s.toString());
_L2:
        s.append("000000");
        continue; /* Loop/switch isn't completed */
_L3:
        s.append("808080");
        continue; /* Loop/switch isn't completed */
_L4:
        s.append("c0c0c0");
        continue; /* Loop/switch isn't completed */
_L5:
        s.append("ffffff");
        continue; /* Loop/switch isn't completed */
_L6:
        s.append("400000");
        continue; /* Loop/switch isn't completed */
_L7:
        s.append("c00000");
        continue; /* Loop/switch isn't completed */
_L8:
        s.append("ff0000");
        continue; /* Loop/switch isn't completed */
_L9:
        s.append("004000");
        continue; /* Loop/switch isn't completed */
_L10:
        s.append("00c000");
        continue; /* Loop/switch isn't completed */
_L11:
        s.append("00ff00");
        continue; /* Loop/switch isn't completed */
_L12:
        s.append("000040");
        continue; /* Loop/switch isn't completed */
_L13:
        s.append("0000c0");
        continue; /* Loop/switch isn't completed */
_L14:
        s.append("0000ff");
        continue; /* Loop/switch isn't completed */
_L15:
        s.append("404000");
        continue; /* Loop/switch isn't completed */
_L16:
        s.append("c0c000");
        continue; /* Loop/switch isn't completed */
_L17:
        s.append("ffff00");
        continue; /* Loop/switch isn't completed */
_L18:
        s.append("400040");
        continue; /* Loop/switch isn't completed */
_L19:
        s.append("c000c0");
        continue; /* Loop/switch isn't completed */
_L20:
        s.append("ff00ff");
        continue; /* Loop/switch isn't completed */
_L21:
        s.append("004040");
        continue; /* Loop/switch isn't completed */
_L22:
        s.append("00c0c0");
        continue; /* Loop/switch isn't completed */
_L23:
        s.append("00ffff");
        if (true) goto _L25; else goto _L24
_L24:
    }

    int convertBackgroundColor(com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color color, String s)
    {
        if (color == com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color.DEFAULT)
        {
            return convertColor(com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color.BLACK, s);
        } else
        {
            return convertColor(color, s);
        }
    }

    int convertEdgeColor(com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color color, String s)
    {
        if (color == com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color.DEFAULT)
        {
            return convertColor(com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color.GRAY, s);
        } else
        {
            return convertColor(color, s);
        }
    }

    Typeface convertFont(com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Font font)
    {
        switch (_cls1..SwitchMap.com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Font[font.ordinal()])
        {
        default:
            return Typeface.DEFAULT;

        case 1: // '\001'
            return Typeface.SERIF;

        case 2: // '\002'
            return Typeface.SANS_SERIF;

        case 3: // '\003'
            return Typeface.MONOSPACE;
        }
    }

    int convertTextColor(com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color color, String s)
    {
        if (color == com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color.DEFAULT)
        {
            return convertColor(com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color.WHITE, s);
        } else
        {
            return convertColor(color, s);
        }
    }

    float getTextSize(com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Size size)
    {
        switch (_cls1..SwitchMap.com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Size[size.ordinal()])
        {
        default:
            return 24F;

        case 1: // '\001'
            return 12F;

        case 2: // '\002'
            return 36F;
        }
    }

    protected View onCreateView(ViewGroup viewgroup)
    {
        viewgroup = (LinearLayout)((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(com.comcast.cim.cmasl.android708compatlib.R.layout.cc_preview, viewgroup, false);
        previewText = (CCPreviewTextView)viewgroup.findViewById(com.comcast.cim.cmasl.android708compatlib.R.id.preview_text);
        updatePreviewText();
        return viewgroup;
    }

    public void setCcPrefStore(CCPreferenceStore ccpreferencestore)
    {
        ccPrefStore = ccpreferencestore;
    }

    public void updatePreviewText()
    {
        com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.FontEdge fontedge = com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.FontEdge.valueOfOrdinal(ccPrefStore.getCCEdgeType());
        com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Size size = com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Size.valueOfOrdinal(ccPrefStore.getCCTextSize());
        com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color color = com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color.valueOfOrdinal(ccPrefStore.getCCTextColor());
        com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color color1 = com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color.valueOfOrdinal(ccPrefStore.getCCEdgeColor());
        com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color color2 = com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Color.valueOfOrdinal(ccPrefStore.getCCBackgroundColor());
        com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Font font = com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Font.valueOfOrdinal(ccPrefStore.getCCFontFamily());
        String s = Integer.toHexString((int)(((float)ccPrefStore.getCCBackgroundOpacity() / 100F) * 255F));
        previewText.setTextSize(getTextSize(size));
        previewText.setTextColor(convertTextColor(color, "ff"));
        previewText.setEdge(fontedge, convertEdgeColor(color1, "ff"));
        previewText.setTypeface(convertFont(font));
        previewText.setBackgroundColor(convertBackgroundColor(color2, s));
    }
}
