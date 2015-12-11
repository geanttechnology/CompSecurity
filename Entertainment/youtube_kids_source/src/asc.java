// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.IOException;

public class asc extends IOException
{

    public asc(int i, int j)
    {
        super((new StringBuilder("CodedOutputStream was writing to a flat byte array and ran out of space (pos ")).append(i).append(" limit ").append(j).append(").").toString());
    }

    public asc(IOException ioexception)
    {
        super(ioexception);
    }
}
