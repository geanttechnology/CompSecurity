// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.protobuf:
//            Descriptors, Message

private static final class .assertionsDisabled
{
    private static final class DescriptorIntPair
    {

        private final Descriptors.GenericDescriptor descriptor;
        private final int number;

        public boolean equals(Object obj)
        {
            if (obj instanceof DescriptorIntPair)
            {
                if (descriptor == ((DescriptorIntPair) (obj = (DescriptorIntPair)obj)).descriptor && number == ((DescriptorIntPair) (obj)).number)
                {
                    return true;
                }
            }
            return false;
        }

        public int hashCode()
        {
            return descriptor.hashCode() * 65535 + number;
        }

        DescriptorIntPair(Descriptors.GenericDescriptor genericdescriptor, int i)
        {
            descriptor = genericdescriptor;
            number = i;
        }
    }

    private static final class PackageDescriptor
        implements Descriptors.GenericDescriptor
    {

        private final Descriptors.FileDescriptor file;
        private final String fullName;
        private final String name;

        public Descriptors.FileDescriptor getFile()
        {
            return file;
        }

        public String getFullName()
        {
            return fullName;
        }

        public String getName()
        {
            return name;
        }

        public Message toProto()
        {
            return file.toProto();
        }

        PackageDescriptor(String s, String s1, Descriptors.FileDescriptor filedescriptor)
        {
            file = filedescriptor;
            fullName = s1;
            name = s;
        }
    }


    static final boolean $assertionsDisabled;
    private final .assertionsDisabled dependencies[];
    private final Map descriptorsByName = new HashMap();
    private final Map enumValuesByNumber = new HashMap();
    private final Map fieldsByNumber = new HashMap();

    static void validateSymbolName(or or)
        throws ationException
    {
        String s = or.getName();
        if (s.length() == 0)
        {
            throw new ationException(or, "Missing name.", null);
        }
        boolean flag = true;
        int i = 0;
        while (i < s.length()) 
        {
            char c = s.charAt(i);
            boolean flag1 = flag;
            if (c >= '\200')
            {
                flag1 = false;
            }
            flag = flag1;
            if (Character.isLetter(c))
            {
                continue;
            }
            flag = flag1;
            if (c != '_')
            {
                if (Character.isDigit(c) && i > 0)
                {
                    flag = flag1;
                } else
                {
                    flag = false;
                }
            }
            i++;
        }
        if (!flag)
        {
            throw new ationException(or, (new StringBuilder()).append('"').append(s).append("\" is not a valid identifier.").toString(), null);
        } else
        {
            return;
        }
    }

    void addEnumValueByNumber(ptor ptor)
    {
        DescriptorIntPair descriptorintpair = new DescriptorIntPair(ptor.getType(), ptor.getNumber());
        ptor = (ptor)enumValuesByNumber.put(descriptorintpair, ptor);
        if (ptor != null)
        {
            enumValuesByNumber.put(descriptorintpair, ptor);
        }
    }

    void addFieldByNumber( )
        throws ationException
    {
        DescriptorIntPair descriptorintpair = new DescriptorIntPair(.getContainingType(), .getNumber());
         1 = ()fieldsByNumber.put(descriptorintpair, );
        if (1 != null)
        {
            fieldsByNumber.put(descriptorintpair, 1);
            throw new ationException(, (new StringBuilder()).append("Field number ").append(.getNumber()).append("has already been used in \"").append(.getContainingType().ullName()).append("\" by field \"").append(1.getName()).append("\".").toString(), null);
        } else
        {
            return;
        }
    }

    void addPackage(String s, or or)
        throws ationException
    {
        int i = s.lastIndexOf('.');
        String s1;
        or or1;
        if (i == -1)
        {
            s1 = s;
        } else
        {
            addPackage(s.substring(0, i), or);
            s1 = s.substring(i + 1);
        }
        or1 = (or)descriptorsByName.put(s, new PackageDescriptor(s1, s, or));
        if (or1 != null)
        {
            descriptorsByName.put(s, or1);
            if (!(or1 instanceof PackageDescriptor))
            {
                throw new ationException(or, (new StringBuilder()).append('"').append(s1).append("\" is already defined (as something other than a ").append("package) in file \"").append(or1.getFile().getName()).append("\".").toString(), null);
            }
        }
    }

    void addSymbol(or or)
        throws ationException
    {
        validateSymbolName(or);
        String s = or.getFullName();
        int i = s.lastIndexOf('.');
        or or1 = (or)descriptorsByName.put(s, or);
        if (or1 != null)
        {
            descriptorsByName.put(s, or1);
            if (or.getFile() == or1.getFile())
            {
                if (i == -1)
                {
                    throw new ationException(or, (new StringBuilder()).append('"').append(s).append("\" is already defined.").toString(), null);
                } else
                {
                    throw new ationException(or, (new StringBuilder()).append('"').append(s.substring(i + 1)).append("\" is already defined in \"").append(s.substring(0, i)).append("\".").toString(), null);
                }
            } else
            {
                throw new ationException(or, (new StringBuilder()).append('"').append(s).append("\" is already defined in file \"").append(or1.getFile().getName()).append("\".").toString(), null);
            }
        } else
        {
            return;
        }
    }

    or findSymbol(String s)
    {
        or or = (or)descriptorsByName.get(s);
        if (or == null) goto _L2; else goto _L1
_L1:
        return or;
_L2:
        or aor[] = dependencies;
        int j = aor.length;
        int i = 0;
label0:
        do
        {
label1:
            {
                if (i >= j)
                {
                    break label1;
                }
                or or1 = (or)aor[i].descriptorsByName.get(s);
                or = or1;
                if (or1 != null)
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        return null;
    }

    or lookupSymbol(String s, or or)
        throws ationException
    {
        if (!s.startsWith(".")) goto _L2; else goto _L1
_L1:
        Object obj = findSymbol(s.substring(1));
_L4:
        StringBuilder stringbuilder;
        int i;
        int j;
        if (obj == null)
        {
            throw new ationException(or, (new StringBuilder()).append('"').append(s).append("\" is not defined.").toString(), null);
        } else
        {
            return ((or) (obj));
        }
_L2:
        i = s.indexOf('.');
        if (i == -1)
        {
            obj = s;
        } else
        {
            obj = s.substring(0, i);
        }
        stringbuilder = new StringBuilder(or.getFullName());
_L5:
        j = stringbuilder.lastIndexOf(".");
        if (j == -1)
        {
            obj = findSymbol(s);
        } else
        {
label0:
            {
                stringbuilder.setLength(j + 1);
                stringbuilder.append(((String) (obj)));
                or or1 = findSymbol(stringbuilder.toString());
                if (or1 == null)
                {
                    break label0;
                }
                if (i != -1)
                {
                    stringbuilder.setLength(j + 1);
                    stringbuilder.append(s);
                    obj = findSymbol(stringbuilder.toString());
                } else
                {
                    obj = or1;
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        stringbuilder.setLength(j);
          goto _L5
    }

    static 
    {
        boolean flag;
        if (!com/google/protobuf/Descriptors.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }



    ationException(PackageDescriptor.name aname[])
    {
        boolean flag = false;
        super();
        dependencies = new dependencies[aname.length];
        for (int i = 0; i < aname.length; i++)
        {
            dependencies[i] = access._mth1200(aname[i]);
        }

        int k = aname.length;
        int j = ((flag) ? 1 : 0);
        do
        {
            if (j >= k)
            {
                break;
            }
            PackageDescriptor.name name = aname[j];
            try
            {
                addPackage(name.getPackage(), name);
            }
            catch (ationException ationexception)
            {
                if (!$assertionsDisabled)
                {
                    throw new AssertionError();
                }
            }
            j++;
        } while (true);
    }
}
