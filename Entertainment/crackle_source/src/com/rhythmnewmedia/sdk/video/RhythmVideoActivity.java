// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk.video;

import android.os.Bundle;
import com.rhythmnewmedia.sdk.RhythmActivity;

public class RhythmVideoActivity extends RhythmActivity
{

    public RhythmVideoActivity()
    {
    }

    public void onCreate(Bundle bundle)
    {
        entryTransition = com.rhythmnewmedia.sdk.f.a.a;
        exitTransition = com.rhythmnewmedia.sdk.f.a.a;
        super.onCreate(bundle);
    }
}
