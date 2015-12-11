// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class asg extends asf
{

    public final String b;

    public asg(String s, arx arx)
    {
        String s1 = String.valueOf(s);
        if (s1.length() != 0)
        {
            s1 = "Invalid content type: ".concat(s1);
        } else
        {
            s1 = new String("Invalid content type: ");
        }
        super(s1, arx);
        b = s;
    }
}
