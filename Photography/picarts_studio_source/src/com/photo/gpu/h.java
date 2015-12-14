// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.gpu;


public final class h
{

    public static String a = "float correctBrightness(float value,float brightness)\n {\n   value = 1.0 - value;\n\tvalue = pow(value,brightness);\n   value = 1.0 - value;\n\treturn value;\n }\n";
    public static String b = "float contrastGimp(float value,float contrast)\n {\n   float pi_4 = 0.7854;\n   float slant = tan (((contrast + 1.0) * pi_4));\n   value = (value - 0.5) * slant + 0.5;\n\treturn value;\n }\n";

}
