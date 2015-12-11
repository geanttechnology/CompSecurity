// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonStreamContext;

// Referenced classes of package com.fasterxml.jackson.core.json:
//            DupDetector

public class JsonWriteContext extends JsonStreamContext
{

    public static final int STATUS_EXPECT_NAME = 5;
    public static final int STATUS_EXPECT_VALUE = 4;
    public static final int STATUS_OK_AFTER_COLON = 2;
    public static final int STATUS_OK_AFTER_COMMA = 1;
    public static final int STATUS_OK_AFTER_SPACE = 3;
    public static final int STATUS_OK_AS_IS = 0;
    protected JsonWriteContext _child;
    protected String _currentName;
    protected final DupDetector _dups;
    protected boolean _gotName;
    protected final JsonWriteContext _parent;

    protected JsonWriteContext(int i, JsonWriteContext jsonwritecontext, DupDetector dupdetector)
    {
        _child = null;
        _type = i;
        _parent = jsonwritecontext;
        _dups = dupdetector;
        _index = -1;
    }

    private void _checkDup(DupDetector dupdetector, String s)
        throws JsonProcessingException
    {
        if (dupdetector.isDup(s))
        {
            throw new JsonGenerationException((new StringBuilder()).append("Duplicate field '").append(s).append("'").toString());
        } else
        {
            return;
        }
    }

    public static JsonWriteContext createRootContext()
    {
        return createRootContext(null);
    }

    public static JsonWriteContext createRootContext(DupDetector dupdetector)
    {
        return new JsonWriteContext(0, null, dupdetector);
    }

    protected final void appendDesc(StringBuilder stringbuilder)
    {
        if (_type == 2)
        {
            stringbuilder.append('{');
            if (_currentName != null)
            {
                stringbuilder.append('"');
                stringbuilder.append(_currentName);
                stringbuilder.append('"');
            } else
            {
                stringbuilder.append('?');
            }
            stringbuilder.append('}');
            return;
        }
        if (_type == 1)
        {
            stringbuilder.append('[');
            stringbuilder.append(getCurrentIndex());
            stringbuilder.append(']');
            return;
        } else
        {
            stringbuilder.append("/");
            return;
        }
    }

    public JsonWriteContext createChildArrayContext()
    {
        Object obj = _child;
        if (obj == null)
        {
            if (_dups == null)
            {
                obj = null;
            } else
            {
                obj = _dups.child();
            }
            obj = new JsonWriteContext(1, this, ((DupDetector) (obj)));
            _child = ((JsonWriteContext) (obj));
            return ((JsonWriteContext) (obj));
        } else
        {
            return ((JsonWriteContext) (obj)).reset(1);
        }
    }

    public JsonWriteContext createChildObjectContext()
    {
        Object obj = _child;
        if (obj == null)
        {
            if (_dups == null)
            {
                obj = null;
            } else
            {
                obj = _dups.child();
            }
            obj = new JsonWriteContext(2, this, ((DupDetector) (obj)));
            _child = ((JsonWriteContext) (obj));
            return ((JsonWriteContext) (obj));
        } else
        {
            return ((JsonWriteContext) (obj)).reset(2);
        }
    }

    public final String getCurrentName()
    {
        return _currentName;
    }

    public volatile JsonStreamContext getParent()
    {
        return getParent();
    }

    public final JsonWriteContext getParent()
    {
        return _parent;
    }

    protected JsonWriteContext reset(int i)
    {
        _type = i;
        _index = -1;
        _currentName = null;
        _gotName = false;
        if (_dups != null)
        {
            _dups.reset();
        }
        return this;
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(64);
        appendDesc(stringbuilder);
        return stringbuilder.toString();
    }

    public final int writeFieldName(String s)
        throws JsonProcessingException
    {
        int i = 1;
        _gotName = true;
        _currentName = s;
        if (_dups != null)
        {
            _checkDup(_dups, s);
        }
        if (_index < 0)
        {
            i = 0;
        }
        return i;
    }

    public final int writeValue()
    {
        byte byte0 = 0;
        if (_type != 2) goto _L2; else goto _L1
_L1:
        _gotName = false;
        _index = _index + 1;
        byte0 = 2;
_L4:
        return byte0;
_L2:
        if (_type != 1)
        {
            break; /* Loop/switch isn't completed */
        }
        int i = _index;
        _index = _index + 1;
        if (i >= 0)
        {
            return 1;
        }
        if (true) goto _L4; else goto _L3
_L3:
        _index = _index + 1;
        if (_index != 0)
        {
            return 3;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }
}
