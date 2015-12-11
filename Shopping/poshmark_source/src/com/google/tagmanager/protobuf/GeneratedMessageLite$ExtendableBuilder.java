// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager.protobuf;

import java.io.IOException;

// Referenced classes of package com.google.tagmanager.protobuf:
//            GeneratedMessageLite, FieldSet, CodedInputStream, CodedOutputStream, 
//            ExtensionRegistryLite

public static abstract class extensions extends extensions
    implements rBuilder
{

    private FieldSet extensions;
    private boolean extensionsIsMutable;

    private FieldSet buildExtensions()
    {
        extensions.makeImmutable();
        extensionsIsMutable = false;
        return extensions;
    }

    private void ensureExtensionsIsMutable()
    {
        if (!extensionsIsMutable)
        {
            extensions = extensions.clone();
            extensionsIsMutable = true;
        }
    }

    private void verifyExtensionContainingType( )
    {
        if (.getContainingTypeDefaultInstance() != getDefaultInstanceForType())
        {
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        } else
        {
            return;
        }
    }

    public final  addExtension( , Object obj)
    {
        verifyExtensionContainingType();
        ensureExtensionsIsMutable();
        extensions.addRepeatedField(.descriptor, .singularToFieldSetType(obj));
        return this;
    }

    public volatile .singularToFieldSetType clear()
    {
        return clear();
    }

    public clear clear()
    {
        extensions.clear();
        extensionsIsMutable = false;
        return (extensionsIsMutable)super.extensionsIsMutable();
    }

    public volatile extensionsIsMutable clear()
    {
        return clear();
    }

    public final  clearExtension( )
    {
        verifyExtensionContainingType();
        ensureExtensionsIsMutable();
        extensions.clearField(.descriptor);
        return this;
    }

    public volatile .descriptor clone()
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

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    protected boolean extensionsAreInitialized()
    {
        return extensions.isInitialized();
    }

    public final Object getExtension( )
    {
        verifyExtensionContainingType();
        Object obj = extensions.getField(.descriptor);
        if (obj == null)
        {
            return .defaultValue;
        } else
        {
            return .fromFieldSetType(obj);
        }
    }

    public final Object getExtension( , int i)
    {
        verifyExtensionContainingType();
        return .singularFromFieldSetType(extensions.getRepeatedField(.descriptor, i));
    }

    public final int getExtensionCount( )
    {
        verifyExtensionContainingType();
        return extensions.getRepeatedFieldCount(.descriptor);
    }

    public final boolean hasExtension( )
    {
        verifyExtensionContainingType();
        return extensions.hasField(.descriptor);
    }

    void internalSetExtensionSet(FieldSet fieldset)
    {
        extensions = fieldset;
    }

    protected final void mergeExtensionFields(extensions extensions1)
    {
        ensureExtensionsIsMutable();
        extensions.mergeFrom(access._mth200(extensions1));
    }

    protected boolean parseUnknownField(CodedInputStream codedinputstream, CodedOutputStream codedoutputstream, ExtensionRegistryLite extensionregistrylite, int i)
        throws IOException
    {
        ensureExtensionsIsMutable();
        return GeneratedMessageLite.access$100(extensions, getDefaultInstanceForType(), codedinputstream, codedoutputstream, extensionregistrylite, i);
    }

    public final  setExtension( , int i, Object obj)
    {
        verifyExtensionContainingType();
        ensureExtensionsIsMutable();
        extensions.setRepeatedField(.descriptor, i, .singularToFieldSetType(obj));
        return this;
    }

    public final  setExtension( , Object obj)
    {
        verifyExtensionContainingType();
        ensureExtensionsIsMutable();
        extensions.setField(.descriptor, .toFieldSetType(obj));
        return this;
    }


    protected ()
    {
        extensions = FieldSet.emptySet();
    }
}
