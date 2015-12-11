// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.IOException;

public class arv extends IOException
{

    private static final long serialVersionUID = 0x9f95917c52ce6e25L;

    public arv()
    {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.");
    }

    public arv(int i, int j)
    {
        super((new StringBuilder(60)).append("Priority too low [priority=").append(i).append(", highest=").append(j).append("]").toString());
    }

    public arv(anc anc1)
    {
        anc1 = String.valueOf(anc1.a);
        if (anc1.length() != 0)
        {
            anc1 = "Blocked by rule: ".concat(anc1);
        } else
        {
            anc1 = new String("Blocked by rule: ");
        }
        super(anc1);
    }

    public arv(IOException ioexception)
    {
        super(ioexception);
    }

    public arv(Exception exception)
    {
        String s = String.valueOf(exception.getClass().getSimpleName());
        String s1 = String.valueOf(exception.getMessage());
        super((new StringBuilder(String.valueOf(s).length() + 13 + String.valueOf(s1).length())).append("Unexpected ").append(s).append(": ").append(s1).toString(), exception);
    }
}
