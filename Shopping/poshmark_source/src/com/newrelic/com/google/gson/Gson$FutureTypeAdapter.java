// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.com.google.gson;

import com.newrelic.com.google.gson.stream.JsonReader;
import com.newrelic.com.google.gson.stream.JsonWriter;
import java.io.IOException;

// Referenced classes of package com.newrelic.com.google.gson:
//            TypeAdapter, Gson

static class _cls9 extends TypeAdapter
{

    private TypeAdapter _flddelegate;

    public Object read(JsonReader jsonreader)
        throws IOException
    {
        if (_flddelegate == null)
        {
            throw new IllegalStateException();
        } else
        {
            return _flddelegate.read(jsonreader);
        }
    }

    public void setDelegate(TypeAdapter typeadapter)
    {
        if (_flddelegate != null)
        {
            throw new AssertionError();
        } else
        {
            _flddelegate = typeadapter;
            return;
        }
    }

    public void write(JsonWriter jsonwriter, Object obj)
        throws IOException
    {
        if (_flddelegate == null)
        {
            throw new IllegalStateException();
        } else
        {
            _flddelegate.write(jsonwriter, obj);
            return;
        }
    }

    _cls9()
    {
    }
}
