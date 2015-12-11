// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.util.TextBuffer;
import java.lang.ref.SoftReference;

// Referenced classes of package com.fasterxml.jackson.core.io:
//            CharTypes

public final class JsonStringEncoder
{

    private static final byte HB[] = CharTypes.copyHexBytes();
    private static final char HC[] = CharTypes.copyHexChars();
    protected static final ThreadLocal _threadEncoder = new ThreadLocal();
    protected final char _qbuf[] = new char[6];
    protected TextBuffer _text;

    public JsonStringEncoder()
    {
        _qbuf[0] = '\\';
        _qbuf[2] = '0';
        _qbuf[3] = '0';
    }

    private int _appendNamed(int i, char ac[])
    {
        ac[1] = (char)i;
        return 2;
    }

    private int _appendNumeric(int i, char ac[])
    {
        ac[1] = 'u';
        ac[4] = HC[i >> 4];
        ac[5] = HC[i & 0xf];
        return 6;
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
        TextBuffer textbuffer = _text;
        TextBuffer textbuffer1 = textbuffer;
        if (textbuffer == null)
        {
            textbuffer1 = new TextBuffer(null);
            _text = textbuffer1;
        }
        char ac[] = textbuffer1.emptyAndGetCurrentSegment();
        int ai[] = CharTypes.get7BitOutputEscapes();
        int i1 = ai.length;
        int j1 = s.length();
        int i = 0;
        int j = 0;
label0:
        do
        {
            int k = i;
            if (j < j1)
            {
                do
                {
                    char c = s.charAt(j);
                    if (c < i1 && ai[c] != 0)
                    {
                        k = s.charAt(j);
                        int l = ai[k];
                        if (l < 0)
                        {
                            k = _appendNumeric(k, _qbuf);
                        } else
                        {
                            k = _appendNamed(l, _qbuf);
                        }
                        if (i + k > ac.length)
                        {
                            l = ac.length - i;
                            if (l > 0)
                            {
                                System.arraycopy(_qbuf, 0, ac, i, l);
                            }
                            ac = textbuffer1.finishCurrentSegment();
                            i = k - l;
                            System.arraycopy(_qbuf, l, ac, 0, i);
                        } else
                        {
                            System.arraycopy(_qbuf, 0, ac, i, k);
                            i += k;
                        }
                        j++;
                        continue label0;
                    }
                    if (i >= ac.length)
                    {
                        ac = textbuffer1.finishCurrentSegment();
                        i = 0;
                    }
                    k = i + 1;
                    ac[i] = c;
                    l = j + 1;
                    i = k;
                    j = l;
                } while (l < j1);
            }
            textbuffer1.setCurrentLength(k);
            return textbuffer1.contentsAsArray();
        } while (true);
    }

}
