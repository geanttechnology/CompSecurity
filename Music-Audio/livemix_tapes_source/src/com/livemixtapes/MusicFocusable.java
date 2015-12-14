// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;


public interface MusicFocusable
{

    public abstract void onGainedAudioFocus();

    public abstract void onLostAudioFocus(boolean flag);
}
