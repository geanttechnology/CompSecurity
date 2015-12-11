// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.specific;

import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.data.ErrorBuilder;
import com.flurry.org.apache.avro.data.RecordBuilderBase;
import java.lang.reflect.Constructor;

// Referenced classes of package com.flurry.org.apache.avro.specific:
//            SpecificData, SpecificExceptionBase

public abstract class SpecificErrorBuilderBase extends RecordBuilderBase
    implements ErrorBuilder
{

    private Throwable cause;
    private Constructor errorConstructor;
    private boolean hasCause;
    private boolean hasValue;
    private Object value;

    protected SpecificErrorBuilderBase(Schema schema)
    {
        super(schema, SpecificData.get());
    }

    protected SpecificErrorBuilderBase(SpecificErrorBuilderBase specificerrorbuilderbase)
    {
        super(specificerrorbuilderbase, SpecificData.get());
        errorConstructor = specificerrorbuilderbase.errorConstructor;
        value = specificerrorbuilderbase.value;
        hasValue = specificerrorbuilderbase.hasValue;
        cause = specificerrorbuilderbase.cause;
        hasCause = specificerrorbuilderbase.hasCause;
    }

    protected SpecificErrorBuilderBase(SpecificExceptionBase specificexceptionbase)
    {
        super(specificexceptionbase.getSchema(), SpecificData.get());
        Object obj = specificexceptionbase.getValue();
        if (obj != null)
        {
            setValue(obj);
        }
        specificexceptionbase = specificexceptionbase.getCause();
        if (specificexceptionbase != null)
        {
            setCause(specificexceptionbase);
        }
    }

    public volatile ErrorBuilder clearCause()
    {
        return clearCause();
    }

    public SpecificErrorBuilderBase clearCause()
    {
        cause = null;
        hasCause = false;
        return this;
    }

    public volatile ErrorBuilder clearValue()
    {
        return clearValue();
    }

    public SpecificErrorBuilderBase clearValue()
    {
        value = null;
        hasValue = false;
        return this;
    }

    public Throwable getCause()
    {
        return cause;
    }

    public Object getValue()
    {
        return value;
    }

    public boolean hasCause()
    {
        return hasCause;
    }

    public boolean hasValue()
    {
        return hasValue;
    }

    public volatile ErrorBuilder setCause(Throwable throwable)
    {
        return setCause(throwable);
    }

    public SpecificErrorBuilderBase setCause(Throwable throwable)
    {
        cause = throwable;
        hasCause = true;
        return this;
    }

    public volatile ErrorBuilder setValue(Object obj)
    {
        return setValue(obj);
    }

    public SpecificErrorBuilderBase setValue(Object obj)
    {
        value = obj;
        hasValue = true;
        return this;
    }
}
