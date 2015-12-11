// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SavedSearchesApi

private final class <init> extends com.ebay.nautilus.kernel.util.
{

    private int field;
    final this._cls0 this$0;

    public com.ebay.nautilus.kernel.util. getCount()
    {
        field = 2;
        return this;
    }

    public com.ebay.nautilus.kernel.util. getId()
    {
        field = 0;
        return this;
    }

    public com.ebay.nautilus.kernel.util. getName()
    {
        field = 1;
        return this;
    }

    public void text(String s)
        throws SAXException
    {
        switch (field)
        {
        default:
            return;

        case 0: // '\0'
            this._cls0.this.field._fld0 = Long.parseLong(s);
            return;

        case 1: // '\001'
            _fld0._fld0 = s;
            return;

        case 2: // '\002'
            _fld0._fld0 = Integer.parseInt(s);
            break;
        }
    }

    private ()
    {
        this$0 = this._cls0.this;
        super();
        field = 0;
    }

    field(field field2)
    {
        this();
    }
}
