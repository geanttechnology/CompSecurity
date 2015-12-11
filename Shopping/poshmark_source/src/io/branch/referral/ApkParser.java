// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;


class ApkParser
{

    public static int endDocTag = 0x100101;
    public static int endTag = 0x100103;
    public static int startTag = 0x100102;

    ApkParser()
    {
    }

    private boolean validURI(String s)
    {
        return s != null && !s.equals("http") && !s.equals("https") && !s.equals("geo") && !s.equals("*") && !s.equals("package") && !s.equals("sms") && !s.equals("smsto") && !s.equals("mms") && !s.equals("mmsto") && !s.equals("tel") && !s.equals("voicemail") && !s.equals("file") && !s.equals("content") && !s.equals("mailto");
    }

    public int LEW(byte abyte0[], int i)
    {
        return abyte0[i + 3] << 24 & 0xff000000 | abyte0[i + 2] << 16 & 0xff0000 | abyte0[i + 1] << 8 & 0xff00 | abyte0[i] & 0xff;
    }

    public String compXmlString(byte abyte0[], int i, int j, int k)
    {
        if (k < 0)
        {
            return null;
        } else
        {
            return compXmlStringAt(abyte0, j + LEW(abyte0, k * 4 + i));
        }
    }

    public String compXmlStringAt(byte abyte0[], int i)
    {
        int k = abyte0[i + 1] << 8 & 0xff00 | abyte0[i] & 0xff;
        byte abyte1[] = new byte[k];
        for (int j = 0; j < k; j++)
        {
            abyte1[j] = abyte0[i + 2 + j * 2];
        }

        return new String(abyte1);
    }

    public String decompressXML(byte abyte0[])
    {
        int i;
        int k;
        int l;
        l = 36 + LEW(abyte0, 16) * 4;
        k = LEW(abyte0, 12);
        i = k;
_L8:
        int j = k;
        if (i >= abyte0.length - 4) goto _L2; else goto _L1
_L1:
        if (LEW(abyte0, i) != startTag) goto _L4; else goto _L3
_L3:
        j = i;
_L2:
        int i1;
label0:
        {
            if (j >= abyte0.length)
            {
                break MISSING_BLOCK_LABEL_257;
            }
            i = LEW(abyte0, j);
            if (i == startTag)
            {
                i1 = LEW(abyte0, j + 28);
                i = j + 36;
                k = 0;
                break label0;
            }
        }
          goto _L5
_L4:
        i += 4;
        continue; /* Loop/switch isn't completed */
        while (true) 
        {
            j = i;
            if (k >= i1)
            {
                continue; /* Loop/switch isn't completed */
            }
            j = LEW(abyte0, i + 4);
            int j1 = LEW(abyte0, i + 8);
            int k1 = LEW(abyte0, i + 16);
            i += 20;
            if (compXmlString(abyte0, 36, l, j).equals("scheme"))
            {
                String s;
                if (j1 != -1)
                {
                    s = compXmlString(abyte0, 36, l, j1);
                } else
                {
                    s = (new StringBuilder()).append("resourceID 0x").append(Integer.toHexString(k1)).toString();
                }
                if (validURI(s))
                {
                    return s;
                }
            }
            k++;
        }
_L5:
        if (i != endTag)
        {
            break; /* Loop/switch isn't completed */
        }
        j += 24;
        if (true) goto _L2; else goto _L6
_L6:
        if (i != endDocTag);
        return "bnc_no_value";
        if (true) goto _L8; else goto _L7
_L7:
    }

}
