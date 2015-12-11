// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.communication.rlm;


public interface AckHandler
{

    public abstract void onAck(int i);

    public abstract void onNack(int i, int j, String s);

    public abstract void onPack(int i, int j, String s);
}
