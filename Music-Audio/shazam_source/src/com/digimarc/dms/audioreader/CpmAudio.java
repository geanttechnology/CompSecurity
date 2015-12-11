// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.audioreader;

import com.digimarc.dms.DMSCpmBase;

public class CpmAudio extends DMSCpmBase
{

    private int mPayload;

    public CpmAudio(String s)
    {
        super(s);
    }

    public void nativeSetCpm(String s, String s1)
    {
        super.mCpmPath = s;
        super.mReaderInfo = s1;
    }
}
