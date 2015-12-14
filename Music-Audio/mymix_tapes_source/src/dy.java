// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public class dy extends dt
    implements ek
{

    private static final bm a = d.a(dy);

    public dy(byte abyte0[])
    {
        super((short)29186, abyte0);
    }

    public final int g()
    {
        a.b("PDXQueryError.getError()");
        return d("error");
    }

    public final String h()
    {
        a.b("PDXQueryError.getDescription()");
        String s = f("description");
        if (s != null)
        {
            return s;
        } else
        {
            return "";
        }
    }

}
