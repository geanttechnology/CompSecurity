// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintree.org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

// Referenced classes of package com.braintree.org.bouncycastle.asn1:
//            ASN1Object, DERObjectIdentifier, DERInteger, DERTaggedObject, 
//            ASN1EncodableVector, DERObject, DEREncodable, DEROutputStream

public class DERExternal extends ASN1Object
{

    private ASN1Object dataValueDescriptor;
    private DERObjectIdentifier directReference;
    private int encoding;
    private DERObject externalContent;
    private DERInteger indirectReference;

    public DERExternal(ASN1EncodableVector asn1encodablevector)
    {
        int j = 0;
        DERObject derobject1 = getObjFromVector(asn1encodablevector, 0);
        DERObject derobject = derobject1;
        if (derobject1 instanceof DERObjectIdentifier)
        {
            directReference = (DERObjectIdentifier)derobject1;
            j = 0 + 1;
            derobject = getObjFromVector(asn1encodablevector, j);
        }
        derobject1 = derobject;
        int i = j;
        if (derobject instanceof DERInteger)
        {
            indirectReference = (DERInteger)derobject;
            i = j + 1;
            derobject1 = getObjFromVector(asn1encodablevector, i);
        }
        derobject = derobject1;
        j = i;
        if (!(derobject1 instanceof DERTaggedObject))
        {
            dataValueDescriptor = (ASN1Object)derobject1;
            j = i + 1;
            derobject = getObjFromVector(asn1encodablevector, j);
        }
        if (asn1encodablevector.size() != j + 1)
        {
            throw new IllegalArgumentException("input vector too large");
        }
        if (!(derobject instanceof DERTaggedObject))
        {
            throw new IllegalArgumentException("No tagged object found in vector. Structure doesn't seem to be of type External");
        } else
        {
            asn1encodablevector = (DERTaggedObject)derobject;
            setEncoding(asn1encodablevector.getTagNo());
            externalContent = asn1encodablevector.getObject();
            return;
        }
    }

    public DERExternal(DERObjectIdentifier derobjectidentifier, DERInteger derinteger, ASN1Object asn1object, int i, DERObject derobject)
    {
        setDirectReference(derobjectidentifier);
        setIndirectReference(derinteger);
        setDataValueDescriptor(asn1object);
        setEncoding(i);
        setExternalContent(derobject.getDERObject());
    }

    public DERExternal(DERObjectIdentifier derobjectidentifier, DERInteger derinteger, ASN1Object asn1object, DERTaggedObject dertaggedobject)
    {
        this(derobjectidentifier, derinteger, asn1object, dertaggedobject.getTagNo(), dertaggedobject.getDERObject());
    }

    private DERObject getObjFromVector(ASN1EncodableVector asn1encodablevector, int i)
    {
        if (asn1encodablevector.size() <= i)
        {
            throw new IllegalArgumentException("too few objects in input vector");
        } else
        {
            return asn1encodablevector.get(i).getDERObject();
        }
    }

    private void setDataValueDescriptor(ASN1Object asn1object)
    {
        dataValueDescriptor = asn1object;
    }

    private void setDirectReference(DERObjectIdentifier derobjectidentifier)
    {
        directReference = derobjectidentifier;
    }

    private void setEncoding(int i)
    {
        if (i < 0 || i > 2)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("invalid encoding value: ").append(i).toString());
        } else
        {
            encoding = i;
            return;
        }
    }

    private void setExternalContent(DERObject derobject)
    {
        externalContent = derobject;
    }

    private void setIndirectReference(DERInteger derinteger)
    {
        indirectReference = derinteger;
    }

    boolean asn1Equals(DERObject derobject)
    {
        if (derobject instanceof DERExternal)
        {
            if (this == derobject)
            {
                return true;
            }
            derobject = (DERExternal)derobject;
            if ((directReference == null || ((DERExternal) (derobject)).directReference != null && ((DERExternal) (derobject)).directReference.equals(directReference)) && (indirectReference == null || ((DERExternal) (derobject)).indirectReference != null && ((DERExternal) (derobject)).indirectReference.equals(indirectReference)) && (dataValueDescriptor == null || ((DERExternal) (derobject)).dataValueDescriptor != null && ((DERExternal) (derobject)).dataValueDescriptor.equals(dataValueDescriptor)))
            {
                return externalContent.equals(((DERExternal) (derobject)).externalContent);
            }
        }
        return false;
    }

    void encode(DEROutputStream deroutputstream)
        throws IOException
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        if (directReference != null)
        {
            bytearrayoutputstream.write(directReference.getDEREncoded());
        }
        if (indirectReference != null)
        {
            bytearrayoutputstream.write(indirectReference.getDEREncoded());
        }
        if (dataValueDescriptor != null)
        {
            bytearrayoutputstream.write(dataValueDescriptor.getDEREncoded());
        }
        bytearrayoutputstream.write((new DERTaggedObject(encoding, externalContent)).getDEREncoded());
        deroutputstream.writeEncoded(32, 8, bytearrayoutputstream.toByteArray());
    }

    public ASN1Object getDataValueDescriptor()
    {
        return dataValueDescriptor;
    }

    public DERObjectIdentifier getDirectReference()
    {
        return directReference;
    }

    public int getEncoding()
    {
        return encoding;
    }

    public DERObject getExternalContent()
    {
        return externalContent;
    }

    public DERInteger getIndirectReference()
    {
        return indirectReference;
    }

    public int hashCode()
    {
        int j = 0;
        if (directReference != null)
        {
            j = directReference.hashCode();
        }
        int i = j;
        if (indirectReference != null)
        {
            i = j ^ indirectReference.hashCode();
        }
        j = i;
        if (dataValueDescriptor != null)
        {
            j = i ^ dataValueDescriptor.hashCode();
        }
        return j ^ externalContent.hashCode();
    }
}
