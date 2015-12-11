// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.media;

import android.util.SparseArray;
import com.uplynk.media.CaptionEvent;
import java.util.Vector;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.media:
//            CaptionData, CaptionCue

public class CaptionUtils
{

    public static CaptionData parseEvent(CaptionEvent captionevent, String s, String s1)
    {
        CaptionData captiondata;
        captiondata = new CaptionData();
        captiondata.setEventType(captionevent.eventType);
        captiondata.setMode(captionevent.mode);
        if (captionevent.mode != com.uplynk.media.CaptionEvent.CaptionMode.POP_ON) goto _L2; else goto _L1
_L1:
        captionevent = captionevent.rows;
        for (int i = 0; i < captionevent.size(); i++)
        {
            com.uplynk.media.CaptionEvent.CaptionRow captionrow = (com.uplynk.media.CaptionEvent.CaptionRow)captionevent.valueAt(i);
            CaptionCue captioncue1 = new CaptionCue(parsePopOnEventString(captionrow.getCharacters()), s, s1, captionrow.getRow(), captionrow.getColumn(), captionrow.getIndent());
            captioncue1.setRawText(captionrow.getText());
            captiondata.addCue(captioncue1);
        }

          goto _L3
_L2:
        if (captionevent.mode != com.uplynk.media.CaptionEvent.CaptionMode.ROLL_UP && captionevent.mode != com.uplynk.media.CaptionEvent.CaptionMode.PAINT_ON) goto _L3; else goto _L4
_L4:
        CaptionCue captioncue = null;
        if (captionevent.eventType != com.uplynk.media.CaptionEvent.CaptionEventType.TEXT) goto _L6; else goto _L5
_L5:
        captionevent = captionevent.character;
        captioncue = new CaptionCue(String.valueOf(captionevent.character()), s, s1, -1, -1, -1);
        captioncue.setRawText(String.valueOf(captionevent.character()));
_L8:
        captiondata.addCue(captioncue);
_L3:
        return captiondata;
_L6:
        if (captionevent.eventType == com.uplynk.media.CaptionEvent.CaptionEventType.LINEBREAK)
        {
            captioncue = new CaptionCue("\n", s, s1, -1, -1, -1);
            captioncue.setRawText("\n");
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    private static String parsePopOnEventString(Vector vector)
    {
        StringBuffer stringbuffer = new StringBuffer();
        boolean flag2 = false;
        boolean flag1 = false;
        for (int i = 0; i < vector.size(); i++)
        {
            com.uplynk.media.CaptionEvent.CaptionCharacter captioncharacter;
            boolean flag;
label0:
            {
                captioncharacter = (com.uplynk.media.CaptionEvent.CaptionCharacter)vector.get(i);
                flag = flag2;
                if (captioncharacter.isItalic())
                {
                    flag = flag2;
                    if (!Character.isISOControl(captioncharacter.character()))
                    {
                        flag = flag2;
                        if (!Character.isSpaceChar(captioncharacter.character()))
                        {
                            flag = flag2;
                            if (!flag2)
                            {
                                stringbuffer.append("<i>");
                                flag = true;
                            }
                        }
                    }
                }
                flag2 = flag1;
                if (captioncharacter.isUnderlined())
                {
                    flag2 = flag1;
                    if (!Character.isISOControl(captioncharacter.character()))
                    {
                        flag2 = flag1;
                        if (!Character.isSpaceChar(captioncharacter.character()))
                        {
                            flag2 = flag1;
                            if (!flag1)
                            {
                                stringbuffer.append("<u>");
                                flag2 = true;
                            }
                        }
                    }
                }
                stringbuffer.append(captioncharacter.character());
                if (captioncharacter.isUnderlined())
                {
                    flag1 = flag2;
                    if (i != vector.size() - 1)
                    {
                        break label0;
                    }
                }
                flag1 = flag2;
                if (flag2)
                {
                    stringbuffer.append("</u>");
                    flag1 = false;
                }
            }
            if (captioncharacter.isItalic())
            {
                flag2 = flag;
                if (i != vector.size() - 1)
                {
                    continue;
                }
            }
            flag2 = flag;
            if (flag)
            {
                stringbuffer.append("</i>");
                flag2 = false;
            }
        }

        return stringbuffer.toString();
    }
}
