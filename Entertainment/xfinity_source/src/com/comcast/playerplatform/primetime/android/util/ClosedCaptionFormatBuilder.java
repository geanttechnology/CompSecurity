// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.util;

import android.graphics.Color;
import android.graphics.Typeface;
import com.adobe.mediacore.TextFormat;
import com.adobe.mediacore.TextFormatBuilder;
import com.disney.datg.videoplatforms.sdk.media.VPCaptionStyle;

// Referenced classes of package com.comcast.playerplatform.primetime.android.util:
//            ClosedCaptionsFormat

public class ClosedCaptionFormatBuilder
{

    private ClosedCaptionsFormat closedCaptionsFormat;

    public ClosedCaptionFormatBuilder()
    {
        closedCaptionsFormat = new ClosedCaptionsFormat();
    }

    private int getColorForDisney(ClosedCaptionsFormat.Color color)
    {
        Object obj;
        int i;
        if (color != null)
        {
            obj = color.name().toLowerCase();
        } else
        {
            obj = com.adobe.mediacore.TextFormat.Color.DEFAULT.name().toLowerCase();
        }
        color = ((ClosedCaptionsFormat.Color) (obj));
        if (((String) (obj)).contains("bright"))
        {
            color = ((String) (obj)).replace("bright_", "");
        }
        obj = color;
        if (color.contains("dark"))
        {
            obj = color.replace("dark_", "");
        }
        try
        {
            i = Color.parseColor(((String) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (ClosedCaptionsFormat.Color color)
        {
            return -1;
        }
        return i;
    }

    private int getDisneySize()
    {
        if (closedCaptionsFormat.getFontSize() == null) goto _L2; else goto _L1
_L1:
        static class _cls1
        {

            static final int $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Font[];
            static final int $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$FontEdge[];
            static final int $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Size[];

            static 
            {
                $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Font = new int[ClosedCaptionsFormat.Font.values().length];
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Font[ClosedCaptionsFormat.Font.MONSPACED_WITHOUT_SERIFS.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Font[ClosedCaptionsFormat.Font.MONOSPACED_WITH_SERIFS.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Font[ClosedCaptionsFormat.Font.PROPORTIONAL_WITHOUT_SERIFS.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Font[ClosedCaptionsFormat.Font.PROPORTIONAL_WITH_SERIFS.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$FontEdge = new int[ClosedCaptionsFormat.FontEdge.values().length];
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$FontEdge[ClosedCaptionsFormat.FontEdge.DROP_SHADOW_RIGHT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$FontEdge[ClosedCaptionsFormat.FontEdge.DROP_SHADOW_LEFT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Size = new int[ClosedCaptionsFormat.Size.values().length];
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Size[ClosedCaptionsFormat.Size.SMALL.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Size[ClosedCaptionsFormat.Size.LARGE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Size[closedCaptionsFormat.getFontSize().ordinal()];
        JVM INSTR tableswitch 1 2: default 48
    //                   1 51
    //                   2 54;
           goto _L2 _L3 _L4
_L2:
        return 100;
_L3:
        return 75;
_L4:
        return 150;
    }

    private com.disney.datg.videoplatforms.sdk.media.VPCaptionStyle.EdgeType getEdgeForDisney()
    {
        if (closedCaptionsFormat.getFontEdge() == null) goto _L2; else goto _L1
_L1:
        _cls1..SwitchMap.com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.FontEdge[closedCaptionsFormat.getFontEdge().ordinal()];
        JVM INSTR tableswitch 1 2: default 48
    //                   1 50
    //                   2 50;
           goto _L2 _L3 _L3
_L2:
        return null;
_L3:
        return com.disney.datg.videoplatforms.sdk.media.VPCaptionStyle.EdgeType.EDGE_TYPE_DROP_SHADOW;
    }

    private Typeface getTypefaceForDisney()
    {
        if (closedCaptionsFormat.getFont() == null) goto _L2; else goto _L1
_L1:
        _cls1..SwitchMap.com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.Font[closedCaptionsFormat.getFont().ordinal()];
        JVM INSTR tableswitch 1 4: default 56
    //                   1 58
    //                   2 58
    //                   3 62
    //                   4 66;
           goto _L2 _L3 _L3 _L4 _L5
_L2:
        return null;
_L3:
        return Typeface.MONOSPACE;
_L4:
        return Typeface.SANS_SERIF;
_L5:
        return Typeface.SERIF;
    }

    public ClosedCaptionFormatBuilder setBackgroundColor(ClosedCaptionsFormat.Color color)
    {
        closedCaptionsFormat.setBackgroundColor(color);
        return this;
    }

    public ClosedCaptionFormatBuilder setBackgroundOpacity(int i)
    {
        closedCaptionsFormat.setBackgroundOpacity(i);
        return this;
    }

    public ClosedCaptionFormatBuilder setEdgeColor(ClosedCaptionsFormat.Color color)
    {
        closedCaptionsFormat.setEdgeColor(color);
        return this;
    }

    public ClosedCaptionFormatBuilder setFont(ClosedCaptionsFormat.Font font)
    {
        closedCaptionsFormat.setFont(font);
        return this;
    }

    public ClosedCaptionFormatBuilder setFontColor(ClosedCaptionsFormat.Color color)
    {
        closedCaptionsFormat.setFontColor(color);
        return this;
    }

    public ClosedCaptionFormatBuilder setFontEdge(ClosedCaptionsFormat.FontEdge fontedge)
    {
        closedCaptionsFormat.setFontEdge(fontedge);
        return this;
    }

    public ClosedCaptionFormatBuilder setSize(ClosedCaptionsFormat.Size size)
    {
        closedCaptionsFormat.setFontSize(size);
        return this;
    }

    public TextFormat toTextFormat()
    {
        TextFormatBuilder textformatbuilder = new TextFormatBuilder();
        Object obj;
        if (closedCaptionsFormat.getFont() == null)
        {
            obj = com.adobe.mediacore.TextFormat.Font.DEFAULT;
        } else
        {
            obj = closedCaptionsFormat.getFont().textFormatValue();
        }
        textformatbuilder.setFont(((com.adobe.mediacore.TextFormat.Font) (obj)));
        if (closedCaptionsFormat.getFontSize() == null)
        {
            obj = com.adobe.mediacore.TextFormat.Size.DEFAULT;
        } else
        {
            obj = closedCaptionsFormat.getFontSize().textFormatValue();
        }
        textformatbuilder.setSize(((com.adobe.mediacore.TextFormat.Size) (obj)));
        if (closedCaptionsFormat.getFontEdge() == null)
        {
            obj = com.adobe.mediacore.TextFormat.FontEdge.DEFAULT;
        } else
        {
            obj = closedCaptionsFormat.getFontEdge().textFormatValue();
        }
        textformatbuilder.setFontEdge(((com.adobe.mediacore.TextFormat.FontEdge) (obj)));
        if (closedCaptionsFormat.getFontColor() == null)
        {
            obj = com.adobe.mediacore.TextFormat.Color.DEFAULT;
        } else
        {
            obj = closedCaptionsFormat.getFontColor().textFormatValue();
        }
        textformatbuilder.setFontColor(((com.adobe.mediacore.TextFormat.Color) (obj)));
        if (closedCaptionsFormat.getBackgroundColor() == null)
        {
            obj = com.adobe.mediacore.TextFormat.Color.DEFAULT;
        } else
        {
            obj = closedCaptionsFormat.getBackgroundColor().textFormatValue();
        }
        textformatbuilder.setBackgroundColor(((com.adobe.mediacore.TextFormat.Color) (obj)));
        if (closedCaptionsFormat.getFillColor() == null)
        {
            obj = com.adobe.mediacore.TextFormat.Color.DEFAULT;
        } else
        {
            obj = closedCaptionsFormat.getFillColor().textFormatValue();
        }
        textformatbuilder.setFillColor(((com.adobe.mediacore.TextFormat.Color) (obj)));
        if (closedCaptionsFormat.getEdgeColor() == null)
        {
            obj = null;
        } else
        {
            obj = closedCaptionsFormat.getEdgeColor().textFormatValue();
        }
        textformatbuilder.setEdgeColor(((com.adobe.mediacore.TextFormat.Color) (obj)));
        textformatbuilder.setFontOpacity(closedCaptionsFormat.getFontOpacity());
        textformatbuilder.setBackgroundOpacity(closedCaptionsFormat.getBackgroundOpacity());
        textformatbuilder.setFillOpacity(closedCaptionsFormat.getFillOpacity());
        return textformatbuilder.toTextFormat();
    }

    public VPCaptionStyle toVPCaptionStyle()
    {
        VPCaptionStyle vpcaptionstyle = new VPCaptionStyle();
        vpcaptionstyle.setTextSize(getDisneySize());
        int i = getColorForDisney(closedCaptionsFormat.getBackgroundColor());
        if (i != -1)
        {
            vpcaptionstyle.setBackgroundColor(i);
        }
        Object obj = getEdgeForDisney();
        if (obj != null)
        {
            vpcaptionstyle.setEdgeType(((com.disney.datg.videoplatforms.sdk.media.VPCaptionStyle.EdgeType) (obj)).ordinal());
        }
        i = getColorForDisney(closedCaptionsFormat.getFontColor());
        if (i != -1)
        {
            vpcaptionstyle.setTextColor(i);
        }
        obj = getTypefaceForDisney();
        if (obj != null)
        {
            vpcaptionstyle.setTypeFace(((Typeface) (obj)));
        }
        return vpcaptionstyle;
    }
}
