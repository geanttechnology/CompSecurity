// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.audio;


interface 
{

    public abstract byte[] getBuffer();

    public abstract int getTotalLength();

    public abstract boolean isGood();

    public abstract boolean isOverflown();

    public abstract void join();

    public abstract void requestStop();

    public abstract void start();
}
