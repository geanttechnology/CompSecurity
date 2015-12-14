// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.exif2;

import java.text.DecimalFormat;
import java.text.NumberFormat;

// Referenced classes of package it.sephiroth.android.library.exif2:
//            Rational

public class ExifUtil
{

    static final NumberFormat formatter = DecimalFormat.getInstance();

    public ExifUtil()
    {
    }

    public static String processLensSpecifications(Rational arational[])
    {
        Rational rational = arational[0];
        Rational rational1 = arational[1];
        Rational rational2 = arational[2];
        arational = arational[3];
        formatter.setMaximumFractionDigits(1);
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(formatter.format(rational.toDouble()));
        stringbuilder.append("-");
        stringbuilder.append(formatter.format(rational1.toDouble()));
        stringbuilder.append("mm f/");
        stringbuilder.append(formatter.format(rational2.toDouble()));
        stringbuilder.append("-");
        stringbuilder.append(formatter.format(arational.toDouble()));
        return stringbuilder.toString();
    }

}
