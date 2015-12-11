// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.uplynk.media;

import android.util.Log;
import java.util.Iterator;
import java.util.Vector;

// Referenced classes of package com.uplynk.media:
//            CaptionManager, CaptionEvent

private class acter
{

    private static final int ROW_LENGTH = 32;
    private int _row;
    private short characterPosition;
    private Vector characters;
    int color;
    private short endPos;
    boolean isItalic;
    boolean isUnderlined;
    private short startPos;
    final CaptionManager this$0;

    private void incrementPosition(int i)
    {
        if (characterPosition + i < characters.size())
        {
            characterPosition = (short)(characterPosition + i);
            return;
        } else
        {
            characterPosition = (short)(characters.size() - 1);
            return;
        }
    }

    void backspace()
    {
        if (characterPosition > 0)
        {
            ((acter)characters.get(characterPosition)).reset();
            characterPosition = (short)(characterPosition - 1);
        }
    }

    void clearToEnd()
    {
        int i = characterPosition;
        do
        {
            if (i >= characters.size())
            {
                return;
            }
            ((acter)characters.get(i)).reset();
            i++;
        } while (true);
    }

    short[] getData()
    {
        short word1 = (short)((endPos - startPos) + 1);
        short word0 = word1;
        if (word1 + 4 < 0)
        {
            Log.w("upLynkCaptionManager", String.format("Invalid CC Row Data Size: %d vs %d", new Object[] {
                Short.valueOf(startPos), Short.valueOf(endPos)
            }));
            word0 = 0;
            reset();
        }
        short aword0[] = new short[word0 + 4];
        aword0[0] = (short)_row;
        int i = (short)1;
        aword0[1] = characterPosition;
        i++;
        aword0[2] = startPos;
        i++;
        aword0[3] = word0;
        short word2 = (short)(i + 1);
        i = startPos;
        do
        {
            if (i > endPos)
            {
                return aword0;
            }
            aword0[word2] = ((acter)characters.get(i)).character();
            word2++;
            i++;
        } while (true);
    }

    String getMarkup()
    {
        StringBuffer stringbuffer = new StringBuffer();
        if ((short)((endPos - startPos) + 1) + 4 < 0)
        {
            Log.w("upLynkCaptionManager", String.format("Invalid CC Row Data Size: %d vs %d", new Object[] {
                Short.valueOf(startPos), Short.valueOf(endPos)
            }));
            reset();
        }
        int j = 0xffffff;
        boolean flag4 = false;
        boolean flag1 = false;
        boolean flag = false;
        int i = startPos;
        do
        {
            if (i > endPos)
            {
                if (flag1)
                {
                    stringbuffer.append("</u>");
                }
                if (flag4)
                {
                    stringbuffer.append("</em>");
                }
                return stringbuffer.toString();
            }
            acter acter = (acter)characters.get(i);
            boolean flag2 = flag4;
            String s;
            if (acter.isItalic() != flag4)
            {
                int k;
                boolean flag3;
                if (acter.isItalic())
                {
                    s = "<em>";
                } else
                {
                    s = "</em>";
                }
                stringbuffer.append(s);
                flag2 = acter.isItalic();
            }
            flag3 = flag1;
            if (acter.isUnderlined() != flag1)
            {
                if (acter.isUnderlined())
                {
                    s = "<u>";
                } else
                {
                    s = "</u>";
                }
                stringbuffer.append(s);
                flag3 = acter.isUnderlined();
            }
            flag1 = flag;
            if (acter.isTransparent() != flag)
            {
                flag1 = acter.isTransparent();
            }
            k = j;
            if (acter.color() != j)
            {
                k = acter.color();
            }
            stringbuffer.append((char)acter.character());
            i++;
            j = k;
            flag4 = flag2;
            flag = flag1;
            flag1 = flag3;
        } while (true);
    }

    String getText()
    {
        StringBuffer stringbuffer = new StringBuffer();
        Log.i("upLynkCaptionManager", String.format("Get Row Characters 0-%d {%d,%d}", new Object[] {
            Short.valueOf(characterPosition), Short.valueOf(startPos), Short.valueOf(endPos)
        }));
        int i = startPos;
        do
        {
            if (i > endPos)
            {
                return stringbuffer.toString();
            }
            char c = (char)((acter)characters.get(i)).character();
            Log.d("upLynkCaptionManager", String.format("CC [%d] %c", new Object[] {
                Integer.valueOf(i), Character.valueOf(c)
            }));
            stringbuffer.append(c);
            i++;
        } while (true);
    }

    void reset()
    {
        isItalic = false;
        isUnderlined = false;
        color = 0xffffff;
        Iterator iterator = characters.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                characterPosition = 0;
                startPos = 32;
                endPos = -1;
                return;
            }
            ((acter)iterator.next()).reset();
        } while (true);
    }

    void setColumnIndex(short word0)
    {
        characterPosition = word0;
    }

    void tabIndex(int i)
    {
        incrementPosition(i);
    }

    incrementPosition toCaptionRow(CaptionEvent captionevent)
    {
        StringBuffer stringbuffer = new StringBuffer();
        Vector vector = new Vector();
        int i = startPos;
        do
        {
            if (i > endPos)
            {
                captionevent.getClass();
                return new it>(captionevent, _row, characterPosition, startPos, stringbuffer.toString(), vector);
            }
            acter acter = (acter)characters.get(i);
            stringbuffer.append((char)acter.character());
            vector.add(acter.toCaptionCharacter(captionevent));
            i++;
        } while (true);
    }

    void writeChar(char c)
    {
        acter acter = (acter)characters.get(characterPosition);
        if (acter == null)
        {
            Log.w("upLynkCaptionManager", String.format("Invalid CC Character Position: %d", new Object[] {
                Short.valueOf(characterPosition)
            }));
            return;
        }
        acter.setValue((short)c, color, isItalic, isUnderlined);
        if (characterPosition < startPos)
        {
            startPos = characterPosition;
        }
        if (characterPosition > endPos)
        {
            endPos = characterPosition;
        }
        incrementPosition(1);
    }

    protected acter(int i)
    {
        this$0 = CaptionManager.this;
        super();
        _row = 0;
        isItalic = false;
        isUnderlined = false;
        color = 0xffffff;
        _row = i;
        isItalic = false;
        isUnderlined = false;
        color = 0xfffffff;
        startPos = 32;
        endPos = -1;
        characterPosition = 0;
        characters = new Vector(32);
        i = 0;
        do
        {
            if (i >= 32)
            {
                return;
            }
            characters.add(i, new acter(CaptionManager.this));
            i++;
        } while (true);
    }
}
