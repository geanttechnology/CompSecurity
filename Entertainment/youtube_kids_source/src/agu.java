// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.speech.network.request.BaseRequestBuilderTask;

final class agu extends BaseRequestBuilderTask
{

    private agt a;

    agu(agt agt, String s)
    {
        a = agt;
        super(s);
    }

    protected final Object build()
    {
        agt agt = a;
        return new eww();
    }
}
