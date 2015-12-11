// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.parser;


// Referenced classes of package org.jsoup.parser:
//            Token

static class e.Doctype extends Token
{

    boolean forceQuirks;
    final StringBuilder name = new StringBuilder();
    final StringBuilder publicIdentifier = new StringBuilder();
    final StringBuilder systemIdentifier = new StringBuilder();

    String getName()
    {
        return name.toString();
    }

    String getPublicIdentifier()
    {
        return publicIdentifier.toString();
    }

    public String getSystemIdentifier()
    {
        return systemIdentifier.toString();
    }

    public boolean isForceQuirks()
    {
        return forceQuirks;
    }

    e()
    {
        super(null);
        forceQuirks = false;
        type = e.Doctype;
    }
}
