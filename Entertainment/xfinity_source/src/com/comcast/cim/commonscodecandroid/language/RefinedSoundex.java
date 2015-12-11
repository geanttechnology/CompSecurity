// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.commonscodecandroid.language;

import com.comcast.cim.commonscodecandroid.EncoderException;
import com.comcast.cim.commonscodecandroid.StringEncoder;

// Referenced classes of package com.comcast.cim.commonscodecandroid.language:
//            SoundexUtils

public class RefinedSoundex
    implements StringEncoder
{

    public static final RefinedSoundex US_ENGLISH = new RefinedSoundex();
    public static final char US_ENGLISH_MAPPING[] = "01360240043788015936020505".toCharArray();
    private final char soundexMapping[];

    public RefinedSoundex()
    {
        soundexMapping = US_ENGLISH_MAPPING;
    }

    public Object encode(Object obj)
        throws EncoderException
    {
        if (!(obj instanceof String))
        {
            throw new EncoderException("Parameter supplied to RefinedSoundex encode is not of type java.lang.String");
        } else
        {
            return soundex((String)obj);
        }
    }

    char getMappingCode(char c)
    {
        if (!Character.isLetter(c))
        {
            return '\0';
        } else
        {
            return soundexMapping[Character.toUpperCase(c) - 65];
        }
    }

    public String soundex(String s)
    {
        if (s == null)
        {
            return null;
        }
        s = SoundexUtils.clean(s);
        if (s.length() == 0)
        {
            return s;
        }
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append(s.charAt(0));
        char c1 = '*';
        int i = 0;
        while (i < s.length()) 
        {
            char c = getMappingCode(s.charAt(i));
            if (c != c1)
            {
                if (c != 0)
                {
                    stringbuffer.append(c);
                }
                c1 = c;
            }
            i++;
        }
        return stringbuffer.toString();
    }

}
