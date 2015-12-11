// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintree.org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

// Referenced classes of package com.braintree.org.bouncycastle.asn1:
//            ASN1Object, ASN1TaggedObject, BERTaggedObject, BERSequence, 
//            DERSequence, DEREncodable, DERNull, DERObject, 
//            DEROutputStream, ASN1SequenceParser, ASN1Set

public abstract class ASN1Sequence extends ASN1Object
{

    private Vector seq;

    public ASN1Sequence()
    {
        seq = new Vector();
    }

    public static ASN1Sequence getInstance(ASN1TaggedObject asn1taggedobject, boolean flag)
    {
        if (flag)
        {
            if (!asn1taggedobject.isExplicit())
            {
                throw new IllegalArgumentException("object implicit - explicit expected.");
            } else
            {
                return (ASN1Sequence)asn1taggedobject.getObject();
            }
        }
        if (asn1taggedobject.isExplicit())
        {
            if (asn1taggedobject instanceof BERTaggedObject)
            {
                return new BERSequence(asn1taggedobject.getObject());
            } else
            {
                return new DERSequence(asn1taggedobject.getObject());
            }
        }
        if (asn1taggedobject.getObject() instanceof ASN1Sequence)
        {
            return (ASN1Sequence)asn1taggedobject.getObject();
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("unknown object in getInstance: ").append(asn1taggedobject.getClass().getName()).toString());
        }
    }

    public static ASN1Sequence getInstance(Object obj)
    {
        if (obj == null || (obj instanceof ASN1Sequence))
        {
            return (ASN1Sequence)obj;
        }
        if (obj instanceof byte[])
        {
            try
            {
                obj = getInstance(ASN1Object.fromByteArray((byte[])(byte[])obj));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("failed to construct sequence from byte[]: ").append(((IOException) (obj)).getMessage()).toString());
            }
            return ((ASN1Sequence) (obj));
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("unknown object in getInstance: ").append(obj.getClass().getName()).toString());
        }
    }

    private DEREncodable getNext(Enumeration enumeration)
    {
        DEREncodable derencodable = (DEREncodable)enumeration.nextElement();
        enumeration = derencodable;
        if (derencodable == null)
        {
            enumeration = DERNull.INSTANCE;
        }
        return enumeration;
    }

    protected void addObject(DEREncodable derencodable)
    {
        seq.addElement(derencodable);
    }

    boolean asn1Equals(DERObject derobject)
    {
        if (derobject instanceof ASN1Sequence) goto _L2; else goto _L1
_L1:
        Object obj;
        return false;
_L2:
        if (size() != ((ASN1Sequence) (obj = (ASN1Sequence)derobject)).size()) goto _L1; else goto _L3
_L3:
        derobject = getObjects();
        obj = ((ASN1Sequence) (obj)).getObjects();
_L6:
        if (!derobject.hasMoreElements()) goto _L5; else goto _L4
_L4:
        Object obj1;
        Object obj2;
        obj2 = getNext(derobject);
        obj1 = getNext(((Enumeration) (obj)));
        obj2 = ((DEREncodable) (obj2)).getDERObject();
        obj1 = ((DEREncodable) (obj1)).getDERObject();
        if (obj2 != obj1 && !((DERObject) (obj2)).equals(obj1)) goto _L1; else goto _L6
_L5:
        return true;
    }

    abstract void encode(DEROutputStream deroutputstream)
        throws IOException;

    public DEREncodable getObjectAt(int i)
    {
        return (DEREncodable)seq.elementAt(i);
    }

    public Enumeration getObjects()
    {
        return seq.elements();
    }

    public int hashCode()
    {
        Enumeration enumeration = getObjects();
        int i;
        for (i = size(); enumeration.hasMoreElements(); i = i * 17 ^ getNext(enumeration).hashCode()) { }
        return i;
    }

    public ASN1SequenceParser parser()
    {
        return new ASN1SequenceParser() {

            private int index;
            private final int max;
            final ASN1Sequence this$0;
            final ASN1Sequence val$outer;

            public DERObject getDERObject()
            {
                return outer;
            }

            public DERObject getLoadedObject()
            {
                return outer;
            }

            public DEREncodable readObject()
                throws IOException
            {
                Object obj;
                if (index == max)
                {
                    obj = null;
                } else
                {
                    obj = ASN1Sequence.this;
                    int i = index;
                    index = i + 1;
                    DEREncodable derencodable = ((ASN1Sequence) (obj)).getObjectAt(i);
                    if (derencodable instanceof ASN1Sequence)
                    {
                        return ((ASN1Sequence)derencodable).parser();
                    }
                    obj = derencodable;
                    if (derencodable instanceof ASN1Set)
                    {
                        return ((ASN1Set)derencodable).parser();
                    }
                }
                return ((DEREncodable) (obj));
            }

            
            {
                this$0 = ASN1Sequence.this;
                outer = asn1sequence1;
                super();
                max = size();
            }
        };
    }

    public int size()
    {
        return seq.size();
    }

    public String toString()
    {
        return seq.toString();
    }
}
