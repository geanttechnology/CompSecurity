// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you;

import android.os.Environment;
import java.io.File;

public class d
{

    public static final String a;
    public static final String b;
    public static final String c;
    public static String d = "635165575013";

    static 
    {
        a = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append(File.separator).append("U").append(File.separator).toString();
        b = (new StringBuilder()).append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)).append(File.separator).append("U_PHOTO").append(File.separator).toString();
        c = (new StringBuilder()).append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)).append(File.separator).append("U_VIDEO").append(File.separator).toString();
    }
}
