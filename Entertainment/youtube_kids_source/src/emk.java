// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

public final class emk extends emo
{

    private final Charset a;
    private emj b;

    public emk(emj emj1, Charset charset)
    {
        b = emj1;
        super();
        a = (Charset)f.b(charset);
    }

    public final Writer a()
    {
        return new OutputStreamWriter(b.a(), a);
    }

    public final String toString()
    {
        return (new StringBuilder()).append(b.toString()).append(".asCharSink(").append(a).append(")").toString();
    }
}
