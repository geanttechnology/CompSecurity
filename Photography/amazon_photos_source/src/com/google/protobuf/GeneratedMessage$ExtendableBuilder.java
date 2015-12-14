// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.util.Collections;
import java.util.Map;

// Referenced classes of package com.google.protobuf:
//            GeneratedMessage, FieldSet, DynamicMessage

public static abstract class extensions extends extensions
    implements rBuilder
{

    private FieldSet extensions;

    private FieldSet buildExtensions()
    {
        extensions.makeImmutable();
        return extensions;
    }

    private void ensureExtensionsIsMutable()
    {
        if (extensions.isImmutable())
        {
            extensions = extensions.clone();
        }
    }

    private void verifyContainingType(extensions extensions1)
    {
        if (extensions1.ainingType() != getDescriptorForType())
        {
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        } else
        {
            return;
        }
    }

    public volatile getDescriptorForType addRepeatedField(getDescriptorForType getdescriptorfortype, Object obj)
    {
        return addRepeatedField(getdescriptorfortype, obj);
    }

    public addRepeatedField addRepeatedField(addRepeatedField addrepeatedfield, Object obj)
    {
        if (addrepeatedfield.sion())
        {
            verifyContainingType(addrepeatedfield);
            ensureExtensionsIsMutable();
            extensions.addRepeatedField(addrepeatedfield, obj);
            onChanged();
            return this;
        } else
        {
            return (onChanged)super.dField(addrepeatedfield, obj);
        }
    }

    public volatile dField addRepeatedField(dField dfield, Object obj)
    {
        return addRepeatedField(dfield, obj);
    }

    public volatile addRepeatedField clone()
    {
        return clone();
    }

    public volatile clone clone()
    {
        return clone();
    }

    public volatile clone clone()
    {
        return clone();
    }

    public clone clone()
    {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    protected boolean extensionsAreInitialized()
    {
        return extensions.isInitialized();
    }

    public Map getAllFields()
    {
        Map map = _mth0(this);
        map.putAll(extensions.getAllFields());
        return Collections.unmodifiableMap(map);
    }

    public Object getField(extensions extensions1)
    {
label0:
        {
label1:
            {
                if (!extensions1.sion())
                {
                    break label0;
                }
                verifyContainingType(extensions1);
                Object obj1 = extensions.getField(extensions1);
                Object obj = obj1;
                if (obj1 == null)
                {
                    if (extensions1.Type() != e.MESSAGE)
                    {
                        break label1;
                    }
                    obj = DynamicMessage.getDefaultInstance(extensions1.ageType());
                }
                return obj;
            }
            return extensions1.ultValue();
        }
        return super.ultValue(extensions1);
    }

    public boolean hasField(ultValue ultvalue)
    {
        if (ultvalue.sion())
        {
            verifyContainingType(ultvalue);
            return extensions.hasField(ultvalue);
        } else
        {
            return super.extensions(ultvalue);
        }
    }

    public boolean isInitialized()
    {
        return super.zed() && extensionsAreInitialized();
    }

    protected final void mergeExtensionFields(extensionsAreInitialized extensionsareinitialized)
    {
        ensureExtensionsIsMutable();
        extensions.mergeFrom(access._mth600(extensionsareinitialized));
        onChanged();
    }

    public volatile onChanged setField(onChanged onchanged, Object obj)
    {
        return setField(onchanged, obj);
    }

    public setField setField(setField setfield, Object obj)
    {
        if (setfield.sion())
        {
            verifyContainingType(setfield);
            ensureExtensionsIsMutable();
            extensions.setField(setfield, obj);
            onChanged();
            return this;
        } else
        {
            return (onChanged)super.onChanged(setfield, obj);
        }
    }

    public volatile onChanged setField(onChanged onchanged, Object obj)
    {
        return setField(onchanged, obj);
    }


    protected e()
    {
        extensions = FieldSet.emptySet();
    }

    protected extensions(extensions extensions1)
    {
        super(extensions1);
        extensions = FieldSet.emptySet();
    }
}
