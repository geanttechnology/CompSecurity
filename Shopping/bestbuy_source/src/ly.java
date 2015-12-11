// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Intent;
import com.google.zxing.BarcodeFormat;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;
import java.util.regex.Pattern;

public final class ly
{

    public static final Vector a;
    static final Vector b;
    static final Vector c;
    static final Vector d = new Vector(1);
    private static final Pattern e = Pattern.compile(",");

    public static Vector a(Intent intent)
    {
        java.util.List list = null;
        String s = intent.getStringExtra("SCAN_FORMATS");
        if (s != null)
        {
            list = Arrays.asList(e.split(s));
        }
        return a(((Iterable) (list)), intent.getStringExtra("SCAN_MODE"));
    }

    private static Vector a(Iterable iterable, String s)
    {
label0:
        {
label1:
            {
                Vector vector;
label2:
                {
                    if (iterable != null)
                    {
                        vector = new Vector();
                        try
                        {
                            for (iterable = iterable.iterator(); iterable.hasNext(); vector.add(BarcodeFormat.valueOf((String)iterable.next()))) { }
                            break label2;
                        }
                        // Misplaced declaration of an exception variable
                        catch (Iterable iterable)
                        {
                            iterable.printStackTrace();
                        }
                    }
                    if (s == null)
                    {
                        break label0;
                    }
                    if ("PRODUCT_MODE".equals(s))
                    {
                        return a;
                    }
                    break label1;
                }
                return vector;
            }
            if ("QR_CODE_MODE".equals(s))
            {
                return c;
            }
            if ("DATA_MATRIX_MODE".equals(s))
            {
                return d;
            }
            if ("ONE_D_MODE".equals(s))
            {
                return b;
            }
        }
        return null;
    }

    static 
    {
        a = new Vector(5);
        a.add(BarcodeFormat.UPC_A);
        a.add(BarcodeFormat.UPC_E);
        a.add(BarcodeFormat.EAN_13);
        a.add(BarcodeFormat.EAN_8);
        b = new Vector(a.size() + 4);
        b.addAll(a);
        b.add(BarcodeFormat.CODE_39);
        b.add(BarcodeFormat.CODE_128);
        b.add(BarcodeFormat.ITF);
        c = new Vector(1);
        c.add(BarcodeFormat.QR_CODE);
    }
}
