// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.message;

import com.comcast.cim.httpcomponentsandroid.NameValuePair;
import com.comcast.cim.httpcomponentsandroid.util.CharArrayBuffer;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.message:
//            HeaderValueFormatter

public class BasicHeaderValueFormatter
    implements HeaderValueFormatter
{

    public static final BasicHeaderValueFormatter DEFAULT = new BasicHeaderValueFormatter();

    public BasicHeaderValueFormatter()
    {
    }

    protected void doFormatValue(CharArrayBuffer chararraybuffer, String s, boolean flag)
    {
        boolean flag1 = flag;
        if (!flag)
        {
            int i = 0;
            do
            {
                flag1 = flag;
                if (i >= s.length())
                {
                    break;
                }
                flag1 = flag;
                if (flag)
                {
                    break;
                }
                flag = isSeparator(s.charAt(i));
                i++;
            } while (true);
        }
        if (flag1)
        {
            chararraybuffer.append('"');
        }
        for (int j = 0; j < s.length(); j++)
        {
            char c = s.charAt(j);
            if (isUnsafe(c))
            {
                chararraybuffer.append('\\');
            }
            chararraybuffer.append(c);
        }

        if (flag1)
        {
            chararraybuffer.append('"');
        }
    }

    protected int estimateNameValuePairLen(NameValuePair namevaluepair)
    {
        int i;
        if (namevaluepair == null)
        {
            i = 0;
        } else
        {
            int j = namevaluepair.getName().length();
            namevaluepair = namevaluepair.getValue();
            i = j;
            if (namevaluepair != null)
            {
                return j + (namevaluepair.length() + 3);
            }
        }
        return i;
    }

    public CharArrayBuffer formatNameValuePair(CharArrayBuffer chararraybuffer, NameValuePair namevaluepair, boolean flag)
    {
        if (namevaluepair == null)
        {
            throw new IllegalArgumentException("NameValuePair must not be null.");
        }
        int i = estimateNameValuePairLen(namevaluepair);
        if (chararraybuffer == null)
        {
            chararraybuffer = new CharArrayBuffer(i);
        } else
        {
            chararraybuffer.ensureCapacity(i);
        }
        chararraybuffer.append(namevaluepair.getName());
        namevaluepair = namevaluepair.getValue();
        if (namevaluepair != null)
        {
            chararraybuffer.append('=');
            doFormatValue(chararraybuffer, namevaluepair, flag);
        }
        return chararraybuffer;
    }

    protected boolean isSeparator(char c)
    {
        return " ;,:@()<>\\\"/[]?={}\t".indexOf(c) >= 0;
    }

    protected boolean isUnsafe(char c)
    {
        return "\"\\".indexOf(c) >= 0;
    }

}
