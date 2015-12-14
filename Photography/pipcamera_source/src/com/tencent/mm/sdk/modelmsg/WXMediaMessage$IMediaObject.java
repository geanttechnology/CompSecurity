// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;

public interface 
{

    public static final int TYPE_APPDATA = 7;
    public static final int TYPE_EMOJI = 8;
    public static final int TYPE_FILE = 6;
    public static final int TYPE_IMAGE = 2;
    public static final int TYPE_MUSIC = 3;
    public static final int TYPE_PRODUCT = 10;
    public static final int TYPE_TEXT = 1;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_URL = 5;
    public static final int TYPE_VIDEO = 4;

    public abstract boolean checkArgs();

    public abstract void serialize(Bundle bundle);

    public abstract int type();

    public abstract void unserialize(Bundle bundle);
}
