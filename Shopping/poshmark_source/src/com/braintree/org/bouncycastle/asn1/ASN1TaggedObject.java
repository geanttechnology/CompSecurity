// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintree.org.bouncycastle.asn1;

import java.io.IOException;

// Referenced classes of package com.braintree.org.bouncycastle.asn1:
//            ASN1Object, ASN1TaggedObjectParser, ASN1Choice, DEREncodable, 
//            DERObject, ASN1Set, ASN1Sequence, ASN1OctetString, 
//            DEROutputStream

public abstract class ASN1TaggedObject extends ASN1Object
    implements ASN1TaggedObjectParser
{

    boolean empty;
    boolean explicit;
    DEREncodable obj;
    int tagNo;

    public ASN1TaggedObject(int i, DEREncodable derencodable)
    {
        empty = false;
        explicit = true;
        obj = null;
        explicit = true;
        tagNo = i;
        obj = derencodable;
    }

    public ASN1TaggedObject(boolean flag, int i, DEREncodable derencodable)
    {
        empty = false;
        explicit = true;
        obj = null;
        if (derencodable instanceof ASN1Choice)
        {
            explicit = true;
        } else
        {
            explicit = flag;
        }
        tagNo = i;
        obj = derencodable;
    }

    public static ASN1TaggedObject getInstance(ASN1TaggedObject asn1taggedobject, boolean flag)
    {
        if (flag)
        {
            return (ASN1TaggedObject)asn1taggedobject.getObject();
        } else
        {
            throw new IllegalArgumentException("implicitly tagged tagged object");
        }
    }

    public static ASN1TaggedObject getInstance(Object obj1)
    {
        if (obj1 == null || (obj1 instanceof ASN1TaggedObject))
        {
            return (ASN1TaggedObject)obj1;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("unknown object in getInstance: ").append(obj1.getClass().getName()).toString());
        }
    }

    boolean asn1Equals(DERObject derobject)
    {
        if (derobject instanceof ASN1TaggedObject) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if (tagNo != ((ASN1TaggedObject) (derobject = (ASN1TaggedObject)derobject)).tagNo || empty != ((ASN1TaggedObject) (derobject)).empty || explicit != ((ASN1TaggedObject) (derobject)).explicit) goto _L1; else goto _L3
_L3:
        if (obj != null) goto _L5; else goto _L4
_L4:
        if (((ASN1TaggedObject) (derobject)).obj != null) goto _L1; else goto _L6
_L6:
        return true;
_L5:
        if (!obj.getDERObject().equals(((ASN1TaggedObject) (derobject)).obj.getDERObject()))
        {
            return false;
        }
        if (true) goto _L6; else goto _L7
_L7:
    }

    abstract void encode(DEROutputStream deroutputstream)
        throws IOException;

    public DERObject getLoadedObject()
    {
        return getDERObject();
    }

    public DERObject getObject()
    {
        if (obj != null)
        {
            return obj.getDERObject();
        } else
        {
            return null;
        }
    }

    public DEREncodable getObjectParser(int i, boolean flag)
    {
        switch (i)
        {
        default:
            if (flag)
            {
                return getObject();
            } else
            {
                throw new RuntimeException((new StringBuilder()).append("implicit tagging not implemented for tag: ").append(i).toString());
            }

        case 17: // '\021'
            return ASN1Set.getInstance(this, flag).parser();

        case 16: // '\020'
            return ASN1Sequence.getInstance(this, flag).parser();

        case 4: // '\004'
            return ASN1OctetString.getInstance(this, flag).parser();
        }
    }

    public int getTagNo()
    {
        return tagNo;
    }

    public int hashCode()
    {
        int j = tagNo;
        int i = j;
        if (obj != null)
        {
            i = j ^ obj.hashCode();
        }
        return i;
    }

    public boolean isEmpty()
    {
        return empty;
    }

    public boolean isExplicit()
    {
        return explicit;
    }

    public String toString()
    {
        return (new StringBuilder()).append("[").append(tagNo).append("]").append(obj).toString();
    }
}
