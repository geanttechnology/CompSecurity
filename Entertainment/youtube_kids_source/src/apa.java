// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class apa extends Exception
{

    public final int a;

    public apa(int i)
    {
        super((new StringBuilder(36)).append("AudioTrack write failed: ").append(i).toString());
        a = i;
    }
}
