// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.acf.module;

import com.amazon.client.framework.androidresparser.AndroidManifest;

public final class PrivateApk
{

    public final String apkpath;
    public final String datapath;
    public final String dexoptpath;
    public final AndroidManifest manifest;
    public final String nativelibpath;

    PrivateApk(AndroidManifest androidmanifest, String s, String s1, String s2, String s3)
    {
        datapath = s;
        manifest = androidmanifest;
        apkpath = s1;
        dexoptpath = s2;
        nativelibpath = s3;
    }
}
