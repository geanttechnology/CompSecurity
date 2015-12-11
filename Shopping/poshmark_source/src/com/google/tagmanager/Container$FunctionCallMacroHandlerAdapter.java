// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import java.util.Map;

// Referenced classes of package com.google.tagmanager:
//            Container

private class <init>
    implements <init>
{

    final Container this$0;

    public Object evaluate(String s, Map map)
    {
        <init> <init>1 = getFunctionCallMacroHandler(s);
        if (<init>1 == null)
        {
            return null;
        } else
        {
            return <init>1.e(s, map);
        }
    }

    private ()
    {
        this$0 = Container.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
