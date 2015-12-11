// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintree.org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

// Referenced classes of package com.braintree.org.bouncycastle.asn1:
//            ASN1Object, ASN1OutputStream, ASN1TaggedObject, DERSet, 
//            ASN1EncodableVector, ASN1Sequence, DEREncodable, DERNull, 
//            DERObject, ASN1Encodable, DEROutputStream, ASN1SetParser

public abstract class ASN1Set extends ASN1Object
{

    protected Vector set;

    public ASN1Set()
    {
        set = new Vector();
    }

    private byte[] getEncoded(DEREncodable derencodable)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        ASN1OutputStream asn1outputstream = new ASN1OutputStream(bytearrayoutputstream);
        try
        {
            asn1outputstream.writeObject(derencodable);
        }
        // Misplaced declaration of an exception variable
        catch (DEREncodable derencodable)
        {
            throw new IllegalArgumentException("cannot encode object added to SET");
        }
        return bytearrayoutputstream.toByteArray();
    }

    public static ASN1Set getInstance(ASN1TaggedObject asn1taggedobject, boolean flag)
    {
        if (flag)
        {
            if (!asn1taggedobject.isExplicit())
            {
                throw new IllegalArgumentException("object implicit - explicit expected.");
            } else
            {
                return (ASN1Set)asn1taggedobject.getObject();
            }
        }
        if (asn1taggedobject.isExplicit())
        {
            return new DERSet(asn1taggedobject.getObject());
        }
        if (asn1taggedobject.getObject() instanceof ASN1Set)
        {
            return (ASN1Set)asn1taggedobject.getObject();
        }
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        if (asn1taggedobject.getObject() instanceof ASN1Sequence)
        {
            for (asn1taggedobject = ((ASN1Sequence)asn1taggedobject.getObject()).getObjects(); asn1taggedobject.hasMoreElements(); asn1encodablevector.add((DEREncodable)asn1taggedobject.nextElement())) { }
            return new DERSet(asn1encodablevector, false);
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("unknown object in getInstance: ").append(asn1taggedobject.getClass().getName()).toString());
        }
    }

    public static ASN1Set getInstance(Object obj)
    {
        if (obj == null || (obj instanceof ASN1Set))
        {
            return (ASN1Set)obj;
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

    private boolean lessThanOrEqual(byte abyte0[], byte abyte1[])
    {
        int i;
        int j;
        j = Math.min(abyte0.length, abyte1.length);
        i = 0;
_L9:
        if (i == j) goto _L2; else goto _L1
_L1:
        if (abyte0[i] == abyte1[i]) goto _L4; else goto _L3
_L3:
        if ((abyte0[i] & 0xff) >= (abyte1[i] & 0xff)) goto _L6; else goto _L5
_L5:
        return true;
_L6:
        return false;
_L4:
        i++;
        continue; /* Loop/switch isn't completed */
_L2:
        if (j == abyte0.length) goto _L5; else goto _L7
_L7:
        return false;
        if (true) goto _L9; else goto _L8
_L8:
    }

    protected void addObject(DEREncodable derencodable)
    {
        set.addElement(derencodable);
    }

    boolean asn1Equals(DERObject derobject)
    {
        if (derobject instanceof ASN1Set) goto _L2; else goto _L1
_L1:
        Object obj;
        return false;
_L2:
        if (size() != ((ASN1Set) (obj = (ASN1Set)derobject)).size()) goto _L1; else goto _L3
_L3:
        derobject = getObjects();
        obj = ((ASN1Set) (obj)).getObjects();
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
        return (DEREncodable)set.elementAt(i);
    }

    public Enumeration getObjects()
    {
        return set.elements();
    }

    public int hashCode()
    {
        Enumeration enumeration = getObjects();
        int i;
        for (i = size(); enumeration.hasMoreElements(); i = i * 17 ^ getNext(enumeration).hashCode()) { }
        return i;
    }

    public ASN1SetParser parser()
    {
        return new ASN1SetParser() {

            private int index;
            private final int max;
            final ASN1Set this$0;
            final ASN1Set val$outer;

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
                    obj = ASN1Set.this;
                    int i = index;
                    index = i + 1;
                    DEREncodable derencodable = ((ASN1Set) (obj)).getObjectAt(i);
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
                this$0 = ASN1Set.this;
                outer = asn1set1;
                super();
                max = size();
            }
        };
    }

    public int size()
    {
        return set.size();
    }

    protected void sort()
    {
        if (set.size() > 1)
        {
            boolean flag = true;
            int j;
            for (int k = set.size() - 1; flag; k = j)
            {
                int i = 0;
                j = 0;
                byte abyte0[] = getEncoded((DEREncodable)set.elementAt(0));
                flag = false;
                while (i != k) 
                {
                    byte abyte1[] = getEncoded((DEREncodable)set.elementAt(i + 1));
                    if (lessThanOrEqual(abyte0, abyte1))
                    {
                        abyte0 = abyte1;
                    } else
                    {
                        Object obj = set.elementAt(i);
                        set.setElementAt(set.elementAt(i + 1), i);
                        set.setElementAt(obj, i + 1);
                        flag = true;
                        j = i;
                    }
                    i++;
                }
            }

        }
    }

    public ASN1Encodable[] toArray()
    {
        ASN1Encodable aasn1encodable[] = new ASN1Encodable[size()];
        for (int i = 0; i != size(); i++)
        {
            aasn1encodable[i] = (ASN1Encodable)getObjectAt(i);
        }

        return aasn1encodable;
    }

    public String toString()
    {
        return set.toString();
    }
}
