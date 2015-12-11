// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class daq extends dap
{

    private static final long serialVersionUID = 0x4f36c35d7cd6620aL;
    private final int a;

    public daq(int i)
    {
        a = i;
    }

    public final String toString()
    {
        return (new StringBuilder()).append(super.toString()).append(" ErrorCode:").append(a).toString();
    }
}
