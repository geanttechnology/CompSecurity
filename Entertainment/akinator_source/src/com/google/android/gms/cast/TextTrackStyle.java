// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzmu;
import com.google.android.gms.internal.zzmx;
import org.json.JSONException;
import org.json.JSONObject;

public final class TextTrackStyle
{

    public static final int COLOR_UNSPECIFIED = 0;
    public static final float DEFAULT_FONT_SCALE = 1F;
    public static final int EDGE_TYPE_DEPRESSED = 4;
    public static final int EDGE_TYPE_DROP_SHADOW = 2;
    public static final int EDGE_TYPE_NONE = 0;
    public static final int EDGE_TYPE_OUTLINE = 1;
    public static final int EDGE_TYPE_RAISED = 3;
    public static final int EDGE_TYPE_UNSPECIFIED = -1;
    public static final int FONT_FAMILY_CASUAL = 4;
    public static final int FONT_FAMILY_CURSIVE = 5;
    public static final int FONT_FAMILY_MONOSPACED_SANS_SERIF = 1;
    public static final int FONT_FAMILY_MONOSPACED_SERIF = 3;
    public static final int FONT_FAMILY_SANS_SERIF = 0;
    public static final int FONT_FAMILY_SERIF = 2;
    public static final int FONT_FAMILY_SMALL_CAPITALS = 6;
    public static final int FONT_FAMILY_UNSPECIFIED = -1;
    public static final int FONT_STYLE_BOLD = 1;
    public static final int FONT_STYLE_BOLD_ITALIC = 3;
    public static final int FONT_STYLE_ITALIC = 2;
    public static final int FONT_STYLE_NORMAL = 0;
    public static final int FONT_STYLE_UNSPECIFIED = -1;
    public static final int WINDOW_TYPE_NONE = 0;
    public static final int WINDOW_TYPE_NORMAL = 1;
    public static final int WINDOW_TYPE_ROUNDED = 2;
    public static final int WINDOW_TYPE_UNSPECIFIED = -1;
    private JSONObject zzWc;
    private int zzXA;
    private int zzXB;
    private int zzXC;
    private String zzXD;
    private int zzXE;
    private int zzXF;
    private float zzXw;
    private int zzXx;
    private int zzXy;
    private int zzXz;
    private int zzwg;

    public TextTrackStyle()
    {
        clear();
    }

    private void clear()
    {
        zzXw = 1.0F;
        zzXx = 0;
        zzwg = 0;
        zzXy = -1;
        zzXz = 0;
        zzXA = -1;
        zzXB = 0;
        zzXC = 0;
        zzXD = null;
        zzXE = -1;
        zzXF = -1;
        zzWc = null;
    }

    public static TextTrackStyle fromSystemSettings(Context context)
    {
        TextTrackStyle texttrackstyle;
        texttrackstyle = new TextTrackStyle();
        if (!zzmx.zzqB())
        {
            return texttrackstyle;
        }
        context = (CaptioningManager)context.getSystemService("captioning");
        texttrackstyle.setFontScale(context.getFontScale());
        context = context.getUserStyle();
        texttrackstyle.setBackgroundColor(((android.view.accessibility.CaptioningManager.CaptionStyle) (context)).backgroundColor);
        texttrackstyle.setForegroundColor(((android.view.accessibility.CaptioningManager.CaptionStyle) (context)).foregroundColor);
        ((android.view.accessibility.CaptioningManager.CaptionStyle) (context)).edgeType;
        JVM INSTR tableswitch 1 2: default 80
    //                   1 142
    //                   2 150;
           goto _L1 _L2 _L3
_L3:
        break MISSING_BLOCK_LABEL_150;
_L1:
        texttrackstyle.setEdgeType(0);
_L4:
        texttrackstyle.setEdgeColor(((android.view.accessibility.CaptioningManager.CaptionStyle) (context)).edgeColor);
        context = context.getTypeface();
        if (context != null)
        {
            boolean flag;
            boolean flag1;
            if (Typeface.MONOSPACE.equals(context))
            {
                texttrackstyle.setFontGenericFamily(1);
            } else
            if (Typeface.SANS_SERIF.equals(context))
            {
                texttrackstyle.setFontGenericFamily(0);
            } else
            if (Typeface.SERIF.equals(context))
            {
                texttrackstyle.setFontGenericFamily(2);
            } else
            {
                texttrackstyle.setFontGenericFamily(0);
            }
            flag = context.isBold();
            flag1 = context.isItalic();
            if (flag && flag1)
            {
                texttrackstyle.setFontStyle(3);
            } else
            if (flag)
            {
                texttrackstyle.setFontStyle(1);
            } else
            if (flag1)
            {
                texttrackstyle.setFontStyle(2);
            } else
            {
                texttrackstyle.setFontStyle(0);
            }
        }
        return texttrackstyle;
_L2:
        texttrackstyle.setEdgeType(1);
          goto _L4
        texttrackstyle.setEdgeType(2);
          goto _L4
    }

    private String zzI(int i)
    {
        return String.format("#%02X%02X%02X%02X", new Object[] {
            Integer.valueOf(Color.red(i)), Integer.valueOf(Color.green(i)), Integer.valueOf(Color.blue(i)), Integer.valueOf(Color.alpha(i))
        });
    }

    private int zzbI(String s)
    {
        boolean flag = false;
        int i = ((flag) ? 1 : 0);
        if (s != null)
        {
            i = ((flag) ? 1 : 0);
            if (s.length() == 9)
            {
                i = ((flag) ? 1 : 0);
                if (s.charAt(0) == '#')
                {
                    try
                    {
                        i = Integer.parseInt(s.substring(1, 3), 16);
                        int j = Integer.parseInt(s.substring(3, 5), 16);
                        int k = Integer.parseInt(s.substring(5, 7), 16);
                        i = Color.argb(Integer.parseInt(s.substring(7, 9), 16), i, j, k);
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s)
                    {
                        return 0;
                    }
                }
            }
        }
        return i;
    }

    public boolean equals(Object obj)
    {
        boolean flag4;
        boolean flag5;
        flag4 = true;
        flag5 = false;
        if (this != obj) goto _L2; else goto _L1
_L1:
        boolean flag2 = true;
_L4:
        return flag2;
_L2:
        flag2 = flag5;
        if (!(obj instanceof TextTrackStyle)) goto _L4; else goto _L3
_L3:
        obj = (TextTrackStyle)obj;
        boolean flag;
        boolean flag1;
        if (zzWc == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (((TextTrackStyle) (obj)).zzWc == null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        flag2 = flag5;
        if (flag != flag1) goto _L4; else goto _L5
_L5:
        if (zzWc == null || ((TextTrackStyle) (obj)).zzWc == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag2 = flag5;
        if (!zzmu.zzd(zzWc, ((TextTrackStyle) (obj)).zzWc)) goto _L4; else goto _L6
_L6:
        boolean flag3;
        if (zzXw == ((TextTrackStyle) (obj)).zzXw && zzXx == ((TextTrackStyle) (obj)).zzXx && zzwg == ((TextTrackStyle) (obj)).zzwg && zzXy == ((TextTrackStyle) (obj)).zzXy && zzXz == ((TextTrackStyle) (obj)).zzXz && zzXA == ((TextTrackStyle) (obj)).zzXA && zzXC == ((TextTrackStyle) (obj)).zzXC && com.google.android.gms.cast.internal.zzf.zza(zzXD, ((TextTrackStyle) (obj)).zzXD) && zzXE == ((TextTrackStyle) (obj)).zzXE && zzXF == ((TextTrackStyle) (obj)).zzXF)
        {
            flag3 = flag4;
        } else
        {
            flag3 = false;
        }
        return flag3;
    }

    public int getBackgroundColor()
    {
        return zzwg;
    }

    public JSONObject getCustomData()
    {
        return zzWc;
    }

    public int getEdgeColor()
    {
        return zzXz;
    }

    public int getEdgeType()
    {
        return zzXy;
    }

    public String getFontFamily()
    {
        return zzXD;
    }

    public int getFontGenericFamily()
    {
        return zzXE;
    }

    public float getFontScale()
    {
        return zzXw;
    }

    public int getFontStyle()
    {
        return zzXF;
    }

    public int getForegroundColor()
    {
        return zzXx;
    }

    public int getWindowColor()
    {
        return zzXB;
    }

    public int getWindowCornerRadius()
    {
        return zzXC;
    }

    public int getWindowType()
    {
        return zzXA;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            Float.valueOf(zzXw), Integer.valueOf(zzXx), Integer.valueOf(zzwg), Integer.valueOf(zzXy), Integer.valueOf(zzXz), Integer.valueOf(zzXA), Integer.valueOf(zzXB), Integer.valueOf(zzXC), zzXD, Integer.valueOf(zzXE), 
            Integer.valueOf(zzXF), zzWc
        });
    }

    public void setBackgroundColor(int i)
    {
        zzwg = i;
    }

    public void setCustomData(JSONObject jsonobject)
    {
        zzWc = jsonobject;
    }

    public void setEdgeColor(int i)
    {
        zzXz = i;
    }

    public void setEdgeType(int i)
    {
        if (i < 0 || i > 4)
        {
            throw new IllegalArgumentException("invalid edgeType");
        } else
        {
            zzXy = i;
            return;
        }
    }

    public void setFontFamily(String s)
    {
        zzXD = s;
    }

    public void setFontGenericFamily(int i)
    {
        if (i < 0 || i > 6)
        {
            throw new IllegalArgumentException("invalid fontGenericFamily");
        } else
        {
            zzXE = i;
            return;
        }
    }

    public void setFontScale(float f)
    {
        zzXw = f;
    }

    public void setFontStyle(int i)
    {
        if (i < 0 || i > 3)
        {
            throw new IllegalArgumentException("invalid fontStyle");
        } else
        {
            zzXF = i;
            return;
        }
    }

    public void setForegroundColor(int i)
    {
        zzXx = i;
    }

    public void setWindowColor(int i)
    {
        zzXB = i;
    }

    public void setWindowCornerRadius(int i)
    {
        if (i < 0)
        {
            throw new IllegalArgumentException("invalid windowCornerRadius");
        } else
        {
            zzXC = i;
            return;
        }
    }

    public void setWindowType(int i)
    {
        if (i < 0 || i > 2)
        {
            throw new IllegalArgumentException("invalid windowType");
        } else
        {
            zzXA = i;
            return;
        }
    }

    public JSONObject toJson()
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("fontScale", zzXw);
        if (zzXx != 0)
        {
            jsonobject.put("foregroundColor", zzI(zzXx));
        }
        if (zzwg != 0)
        {
            jsonobject.put("backgroundColor", zzI(zzwg));
        }
        zzXy;
        JVM INSTR tableswitch 0 4: default 587
    //                   0 321
    //                   1 335
    //                   2 349
    //                   3 363
    //                   4 377;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        if (zzXz != 0)
        {
            jsonobject.put("edgeColor", zzI(zzXz));
        }
        zzXA;
        JVM INSTR tableswitch 0 2: default 590
    //                   0 391
    //                   1 405
    //                   2 419;
           goto _L7 _L8 _L9 _L10
_L7:
        if (zzXB != 0)
        {
            jsonobject.put("windowColor", zzI(zzXB));
        }
        if (zzXA == 2)
        {
            jsonobject.put("windowRoundedCornerRadius", zzXC);
        }
        if (zzXD != null)
        {
            jsonobject.put("fontFamily", zzXD);
        }
        zzXE;
        JVM INSTR tableswitch 0 6: default 593
    //                   0 433
    //                   1 447
    //                   2 461
    //                   3 475
    //                   4 489
    //                   5 503
    //                   6 517;
           goto _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18
_L11:
        zzXF;
        JVM INSTR tableswitch 0 3: default 596
    //                   0 531
    //                   1 545
    //                   2 559
    //                   3 573;
           goto _L19 _L20 _L21 _L22 _L23
_L19:
        if (zzWc == null) goto _L25; else goto _L24
_L24:
        jsonobject.put("customData", zzWc);
        return jsonobject;
_L2:
        try
        {
            jsonobject.put("edgeType", "NONE");
        }
        catch (JSONException jsonexception)
        {
            return jsonobject;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        jsonobject.put("edgeType", "OUTLINE");
        continue; /* Loop/switch isn't completed */
_L4:
        jsonobject.put("edgeType", "DROP_SHADOW");
        continue; /* Loop/switch isn't completed */
_L5:
        jsonobject.put("edgeType", "RAISED");
        continue; /* Loop/switch isn't completed */
_L6:
        jsonobject.put("edgeType", "DEPRESSED");
        continue; /* Loop/switch isn't completed */
_L8:
        jsonobject.put("windowType", "NONE");
          goto _L7
_L9:
        jsonobject.put("windowType", "NORMAL");
          goto _L7
_L10:
        jsonobject.put("windowType", "ROUNDED_CORNERS");
          goto _L7
_L12:
        jsonobject.put("fontGenericFamily", "SANS_SERIF");
          goto _L11
_L13:
        jsonobject.put("fontGenericFamily", "MONOSPACED_SANS_SERIF");
          goto _L11
_L14:
        jsonobject.put("fontGenericFamily", "SERIF");
          goto _L11
_L15:
        jsonobject.put("fontGenericFamily", "MONOSPACED_SERIF");
          goto _L11
_L16:
        jsonobject.put("fontGenericFamily", "CASUAL");
          goto _L11
_L17:
        jsonobject.put("fontGenericFamily", "CURSIVE");
          goto _L11
_L18:
        jsonobject.put("fontGenericFamily", "SMALL_CAPITALS");
          goto _L11
_L20:
        jsonobject.put("fontStyle", "NORMAL");
          goto _L19
_L21:
        jsonobject.put("fontStyle", "BOLD");
          goto _L19
_L22:
        jsonobject.put("fontStyle", "ITALIC");
          goto _L19
_L23:
        jsonobject.put("fontStyle", "BOLD_ITALIC");
          goto _L19
_L25:
        return jsonobject;
        if (true) goto _L1; else goto _L26
_L26:
    }

    public void zzf(JSONObject jsonobject)
        throws JSONException
    {
        clear();
        zzXw = (float)jsonobject.optDouble("fontScale", 1.0D);
        zzXx = zzbI(jsonobject.optString("foregroundColor"));
        zzwg = zzbI(jsonobject.optString("backgroundColor"));
        String s;
        if (jsonobject.has("edgeType"))
        {
            s = jsonobject.getString("edgeType");
            if ("NONE".equals(s))
            {
                zzXy = 0;
            } else
            if ("OUTLINE".equals(s))
            {
                zzXy = 1;
            } else
            if ("DROP_SHADOW".equals(s))
            {
                zzXy = 2;
            } else
            if ("RAISED".equals(s))
            {
                zzXy = 3;
            } else
            if ("DEPRESSED".equals(s))
            {
                zzXy = 4;
            }
        }
        zzXz = zzbI(jsonobject.optString("edgeColor"));
        if (jsonobject.has("windowType"))
        {
            s = jsonobject.getString("windowType");
            if ("NONE".equals(s))
            {
                zzXA = 0;
            } else
            if ("NORMAL".equals(s))
            {
                zzXA = 1;
            } else
            if ("ROUNDED_CORNERS".equals(s))
            {
                zzXA = 2;
            }
        }
        zzXB = zzbI(jsonobject.optString("windowColor"));
        if (zzXA == 2)
        {
            zzXC = jsonobject.optInt("windowRoundedCornerRadius", 0);
        }
        zzXD = jsonobject.optString("fontFamily", null);
        if (jsonobject.has("fontGenericFamily"))
        {
            s = jsonobject.getString("fontGenericFamily");
            if ("SANS_SERIF".equals(s))
            {
                zzXE = 0;
            } else
            if ("MONOSPACED_SANS_SERIF".equals(s))
            {
                zzXE = 1;
            } else
            if ("SERIF".equals(s))
            {
                zzXE = 2;
            } else
            if ("MONOSPACED_SERIF".equals(s))
            {
                zzXE = 3;
            } else
            if ("CASUAL".equals(s))
            {
                zzXE = 4;
            } else
            if ("CURSIVE".equals(s))
            {
                zzXE = 5;
            } else
            if ("SMALL_CAPITALS".equals(s))
            {
                zzXE = 6;
            }
        }
        if (jsonobject.has("fontStyle"))
        {
            s = jsonobject.getString("fontStyle");
            if ("NORMAL".equals(s))
            {
                zzXF = 0;
            } else
            if ("BOLD".equals(s))
            {
                zzXF = 1;
            } else
            if ("ITALIC".equals(s))
            {
                zzXF = 2;
            } else
            if ("BOLD_ITALIC".equals(s))
            {
                zzXF = 3;
            }
        }
        zzWc = jsonobject.optJSONObject("customData");
    }
}
