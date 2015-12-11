// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.io;

import java.lang.ref.SoftReference;
import org.codehaus.jackson.util.CharTypes;
import org.codehaus.jackson.util.TextBuffer;

public final class JsonStringEncoder
{

    private static final byte HEX_BYTES[] = CharTypes.copyHexBytes();
    private static final char HEX_CHARS[] = CharTypes.copyHexChars();
    protected static final ThreadLocal _threadEncoder = new ThreadLocal();
    protected final char _quoteBuffer[] = new char[6];
    protected TextBuffer _textBuffer;

    public JsonStringEncoder()
    {
        _quoteBuffer[0] = '\\';
        _quoteBuffer[2] = '0';
        _quoteBuffer[3] = '0';
    }

    private int _appendSingleEscape(int i, char ac[])
    {
        if (i < 0)
        {
            i = -(i + 1);
            ac[1] = 'u';
            ac[4] = HEX_CHARS[i >> 4];
            ac[5] = HEX_CHARS[i & 0xf];
            return 6;
        } else
        {
            ac[1] = (char)i;
            return 2;
        }
    }

    public static JsonStringEncoder getInstance()
    {
        Object obj = (SoftReference)_threadEncoder.get();
        Object obj1;
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = (JsonStringEncoder)((SoftReference) (obj)).get();
        }
        obj1 = obj;
        if (obj == null)
        {
            obj1 = new JsonStringEncoder();
            _threadEncoder.set(new SoftReference(obj1));
        }
        return ((JsonStringEncoder) (obj1));
    }

    public char[] quoteAsString(String s)
    {
        char ac[];
        TextBuffer textbuffer1;
        int ai[];
        int i;
        int j;
        int l;
        int i1;
        TextBuffer textbuffer = _textBuffer;
        textbuffer1 = textbuffer;
        if (textbuffer == null)
        {
            textbuffer1 = new TextBuffer(null);
            _textBuffer = textbuffer1;
        }
        ac = textbuffer1.emptyAndGetCurrentSegment();
        ai = CharTypes.get7BitOutputEscapes();
        l = ai.length;
        j = 0;
        i1 = s.length();
        i = 0;
_L3:
        int k = i;
        if (j >= i1) goto _L2; else goto _L1
_L1:
label0:
        {
            char c = s.charAt(j);
            if (c >= l || ai[c] == 0)
            {
                break label0;
            }
            int j1 = _appendSingleEscape(ai[s.charAt(j)], _quoteBuffer);
            char ac1[];
            if (i + j1 > ac.length)
            {
                k = ac.length - i;
                if (k > 0)
                {
                    System.arraycopy(_quoteBuffer, 0, ac, i, k);
                }
                ac = textbuffer1.finishCurrentSegment();
                j1 -= k;
                System.arraycopy(_quoteBuffer, k, ac, i, j1);
                i += j1;
            } else
            {
                System.arraycopy(_quoteBuffer, 0, ac, i, j1);
                i += j1;
            }
            j++;
        }
        if (true) goto _L3; else goto _L2
        k = i;
        ac1 = ac;
        if (i >= ac.length)
        {
            ac1 = textbuffer1.finishCurrentSegment();
            k = 0;
        }
        i = k + 1;
        ac1[k] = c;
        j++;
        if (j < i1)
        {
            break MISSING_BLOCK_LABEL_250;
        }
        k = i;
_L2:
        textbuffer1.setCurrentLength(k);
        return textbuffer1.contentsAsArray();
        ac = ac1;
          goto _L1
    }

}
