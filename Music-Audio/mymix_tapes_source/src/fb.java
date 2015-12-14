// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public class fb
{

    private static final bm a = d.a(fb);

    private fb()
    {
    }

    public static fa a(byte abyte0[])
        throws IllegalArgumentException
    {
        if (a.b())
        {
            a.b((new StringBuilder("DictationResultImpl(buffer [size: ")).append(abyte0.length).append("] )").toString());
            if (a.a())
            {
                a.a(abyte0);
            }
        }
        if (abyte0 == null || abyte0.length < 4)
        {
            if (a.e())
            {
                a.e("Cannot parse dictation results: The buffer length is too small to be containing any results.");
            }
            throw new IllegalArgumentException("Cannot parse dictation results: The buffer length is too small to be containing any results.");
        }
        if (abyte0.length <= 20) goto _L2; else goto _L1
_L1:
        String s = fr.a(abyte0, 0, 20, "ISO-8859-1");
        if (!s.startsWith("<?xml") && (s.indexOf("<?") < 0 || s.indexOf("xml") < 0)) goto _L2; else goto _L3
_L3:
        if (a.b())
        {
            a.b("Detected xml results. Using xml parser.");
        }
        abyte0 = new fm(abyte0);
_L5:
        return abyte0.a();
_L2:
        if (a.b())
        {
            a.b("Detected binary results. Using binary parser.");
        }
        abyte0 = new fj(abyte0);
        if (true) goto _L5; else goto _L4
_L4:
        abyte0;
        throw new IllegalArgumentException("Cannot parse dictation results: illegal format buffer.");
    }

}
