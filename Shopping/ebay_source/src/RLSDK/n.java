// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;

import java.util.Hashtable;

public final class n
{

    public static final n a = new n("AZTEC");
    public static final n b = new n("CODABAR");
    public static final n c = new n("CODE_39");
    public static final n d = new n("CODE_93");
    public static final n e = new n("CODE_128");
    public static final n f = new n("DATA_MATRIX");
    public static final n g = new n("EAN_8");
    public static final n h = new n("EAN_13");
    public static final n i = new n("ITF");
    public static final n j = new n("PDF_417");
    public static final n k = new n("QR_CODE");
    public static final n l = new n("RSS_14");
    public static final n m = new n("RSS_EXPANDED");
    public static final n n = new n("UPC_A");
    public static final n o = new n("UPC_E");
    public static final n p = new n("UPC_EAN_EXTENSION");
    private static final Hashtable q = new Hashtable();
    private final String r;

    private n(String s)
    {
        r = s;
        q.put(s, this);
    }

    public final String toString()
    {
        return r;
    }

}
