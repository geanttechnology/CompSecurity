// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.b.a;

import com.target.mothership.services.f.a.b;
import com.target.mothership.services.f.a.c;

public class a extends b
{

    private static final com.target.mothership.services.f.a.b.a BARCODE = new com.target.mothership.services.f.a.b.a("barcode");
    private static final com.target.mothership.services.f.a.b.a COLUMN = new com.target.mothership.services.f.a.b.a("COL");
    private static final String COLUMN_VALUE = "3";
    private static final com.target.mothership.services.f.a.b.a ECL = new com.target.mothership.services.f.a.b.a("ECL");
    private static final String ECL_VALUE = "0";
    private static final com.target.mothership.services.f.a.b.a FORMAT = new com.target.mothership.services.f.a.b.a("FORMAT");
    private static final String FORMAT_VALUE = "GIF";
    private static final com.target.mothership.services.f.a.b.a MODE = new com.target.mothership.services.f.a.b.a("MODE");
    private static final String MODE_VALUE = "NUMERIC";
    private static c REGISTRY_BARCODE;
    private static final com.target.mothership.services.f.a.b.a ROTATE = new com.target.mothership.services.f.a.b.a("ROTATE");
    private static final String ROTATE_VALUE = "0";
    private static final com.target.mothership.services.f.a.b.a TRN = new com.target.mothership.services.f.a.b.a("TRN");
    private static final String TRN_VALUE = "FALSE";
    private static final com.target.mothership.services.f.a.b.a XYR = new com.target.mothership.services.f.a.b.a("XYR");
    private static final String XYR_VALUE = "5";
    private static final com.target.mothership.services.f.a.b.a X_SIZE = new com.target.mothership.services.f.a.b.a("X");

    public a(com.target.mothership.services.f.b.a a1)
    {
        super(a1);
    }

    public com.target.mothership.services.f.a.b.b a(String s, Double double1)
    {
        c c1 = REGISTRY_BARCODE;
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        a1.put(BARCODE.a(), s);
        a1.put(X_SIZE.a(), double1.toString());
        a1.put(XYR.a(), "5");
        a1.put(TRN.a(), "FALSE");
        a1.put(MODE.a(), "NUMERIC");
        a1.put(COLUMN.a(), "3");
        a1.put(ECL.a(), "0");
        a1.put(FORMAT.a(), "GIF");
        a1.put(ROTATE.a(), "0");
        return a(c1, null, null, ((java.util.Map) (a1)), null);
    }

    static 
    {
        REGISTRY_BARCODE = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.Apigee, "/v1/barcode/pdf417");
    }
}
