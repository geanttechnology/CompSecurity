// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class emz
{

    private static final char a[];
    private static final char b[];
    private static final char c[];

    public static String a(byte abyte0[])
    {
        StringBuilder stringbuilder;
label0:
        {
label1:
            {
label2:
                {
label3:
                    {
label4:
                        {
                            if (abyte0 == null)
                            {
                                return null;
                            }
                            stringbuilder = new StringBuilder(abyte0.length * 3);
                            int k = abyte0.length;
                            int i = 0;
label5:
                            do
                            {
                                {
                                    if (i >= k)
                                    {
                                        break label0;
                                    }
                                    byte byte0 = abyte0[i];
                                    switch (byte0)
                                    {
                                    default:
                                        if (byte0 >= 32 && byte0 < 127 && byte0 != 39)
                                        {
                                            stringbuilder.append((char)byte0);
                                        } else
                                        {
                                            int j = byte0;
                                            if (byte0 < 0)
                                            {
                                                j = byte0 + 256;
                                            }
                                            stringbuilder.append('\\');
                                            stringbuilder.append(a[j]);
                                            stringbuilder.append(b[j]);
                                            stringbuilder.append(c[j]);
                                        }
                                        break;

                                    case 9: // '\t'
                                        break label3;

                                    case 10: // '\n'
                                        break label5;

                                    case 13: // '\r'
                                        break label4;

                                    case 34: // '"'
                                        break label2;

                                    case 92: // '\\'
                                        break label1;
                                    }
                                }
                                i++;
                            } while (true);
                            stringbuilder.append('\\');
                            stringbuilder.append('n');
                            break MISSING_BLOCK_LABEL_117;
                        }
                        stringbuilder.append('\\');
                        stringbuilder.append('r');
                        break MISSING_BLOCK_LABEL_117;
                    }
                    stringbuilder.append('\\');
                    stringbuilder.append('t');
                    break MISSING_BLOCK_LABEL_117;
                }
                stringbuilder.append('\\');
                stringbuilder.append('"');
                break MISSING_BLOCK_LABEL_117;
            }
            stringbuilder.append('\\');
            stringbuilder.append('\\');
            break MISSING_BLOCK_LABEL_117;
        }
        return stringbuilder.toString();
    }

    static 
    {
        int i;
        a = new char[256];
        b = new char[256];
        c = new char[256];
        i = 0;
_L3:
        String s;
        char ac[] = a;
        if (i >= 256)
        {
            break; /* Loop/switch isn't completed */
        }
        String s1 = Integer.toOctalString(i);
        s = s1;
        switch (s1.length())
        {
        default:
            s = String.valueOf(s1);
            if (s.length() != 0)
            {
                s = "Bad integer value: ".concat(s);
            } else
            {
                s = new String("Bad integer value: ");
            }
            throw new RuntimeException(s);

        case 1: // '\001'
            break MISSING_BLOCK_LABEL_172;

        case 3: // '\003'
            break;

        case 2: // '\002'
            s = String.valueOf(s1);
            if (s.length() != 0)
            {
                s = "0".concat(s);
            } else
            {
                s = new String("0");
            }
            break;
        }
_L1:
        if (s.length() != 3)
        {
            s = String.valueOf(s);
            if (s.length() != 0)
            {
                s = "Bad padding: ".concat(s);
            } else
            {
                s = new String("Bad padding: ");
            }
            throw new RuntimeException(s);
        }
        break MISSING_BLOCK_LABEL_233;
        s = String.valueOf(s1);
        if (s.length() != 0)
        {
            s = "00".concat(s);
        } else
        {
            s = new String("00");
        }
          goto _L1
        s = (new StringBuilder(String.valueOf(s).length() + 1)).append("\\").append(s).toString();
        a[i] = s.charAt(1);
        b[i] = s.charAt(2);
        c[i] = s.charAt(3);
        i++;
        if (true) goto _L3; else goto _L2
_L2:
    }
}
