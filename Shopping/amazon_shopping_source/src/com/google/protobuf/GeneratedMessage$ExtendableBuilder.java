// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

// Referenced classes of package com.google.protobuf:
//            GeneratedMessage, FieldSet, DynamicMessage, CodedInputStream, 
//            ExtensionRegistryLite

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

    public volatile addRepeatedField clear()
    {
        return clear();
    }

    public volatile clear clear()
    {
        return clear();
    }

    public clear clear()
    {
        extensions = FieldSet.emptySet();
        return (extensions)super.extensions();
    }

    public volatile extensions clear()
    {
        return clear();
    }

    public volatile clear clear()
    {
        return clear();
    }

    public volatile clear clearField(clear clear1)
    {
        return clearField(clear1);
    }

    public clearField clearField(clearField clearfield)
    {
        if (clearfield.sion())
        {
            verifyContainingType(clearfield);
            ensureExtensionsIsMutable();
            extensions.clearField(clearfield);
            onChanged();
            return this;
        } else
        {
            return (onChanged)super.(clearfield);
        }
    }

    public volatile  clearField( )
    {
        return clearField();
    }

    public volatile clearField clone()
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

    public volatile clone clone()
    {
        return clone();
    }

    public volatile clone clone()
    {
        return clone();
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

    public Object getRepeatedField(ultValue ultvalue, int i)
    {
        if (ultvalue.sion())
        {
            verifyContainingType(ultvalue);
            return extensions.getRepeatedField(ultvalue, i);
        } else
        {
            return super.dField(ultvalue, i);
        }
    }

    public int getRepeatedFieldCount(dField dfield)
    {
        if (dfield.sion())
        {
            verifyContainingType(dfield);
            return extensions.getRepeatedFieldCount(dfield);
        } else
        {
            return super.dFieldCount(dfield);
        }
    }

    public boolean hasField(dFieldCount dfieldcount)
    {
        if (dfieldcount.sion())
        {
            verifyContainingType(dfieldcount);
            return extensions.hasField(dfieldcount);
        } else
        {
            return super.extensions(dfieldcount);
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

    protected boolean parseUnknownField(CodedInputStream codedinputstream, onChanged onchanged, ExtensionRegistryLite extensionregistrylite, int i)
        throws IOException
    {
        return rom(codedinputstream, onchanged, extensionregistrylite, this, i);
    }

    public volatile rom setField(rom rom, Object obj)
    {
        return setField(rom, obj);
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

    public volatile setField setRepeatedField(setField setfield, int i, Object obj)
    {
        return setRepeatedField(setfield, i, obj);
    }

    public setRepeatedField setRepeatedField(setRepeatedField setrepeatedfield, int i, Object obj)
    {
        if (setrepeatedfield.sion())
        {
            verifyContainingType(setrepeatedfield);
            ensureExtensionsIsMutable();
            extensions.setRepeatedField(setrepeatedfield, i, obj);
            onChanged();
            return this;
        } else
        {
            return (onChanged)super.dField(setrepeatedfield, i, obj);
        }
    }

    public volatile dField setRepeatedField(dField dfield, int i, Object obj)
    {
        return setRepeatedField(dfield, i, obj);
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
