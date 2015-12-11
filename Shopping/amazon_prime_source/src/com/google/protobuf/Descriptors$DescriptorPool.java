// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    static final class SearchFilter extends Enum
    {

        private static final SearchFilter $VALUES[];
        public static final SearchFilter AGGREGATES_ONLY;
        public static final SearchFilter ALL_SYMBOLS;
        public static final SearchFilter TYPES_ONLY;

        public static SearchFilter valueOf(String s)
        {
            return (SearchFilter)Enum.valueOf(com/google/protobuf/Descriptors$DescriptorPool$SearchFilter, s);
        }

        public static SearchFilter[] values()
        {
            return (SearchFilter[])$VALUES.clone();
        }

        static 
        {
            TYPES_ONLY = new SearchFilter("TYPES_ONLY", 0);
            AGGREGATES_ONLY = new SearchFilter("AGGREGATES_ONLY", 1);
            ALL_SYMBOLS = new SearchFilter("ALL_SYMBOLS", 2);
            $VALUES = (new SearchFilter[] {
                TYPES_ONLY, AGGREGATES_ONLY, ALL_SYMBOLS
            });
        }

        private SearchFilter(String s, int i)
        {
            super(s, i);
        }
    }


    static final boolean $assertionsDisabled;
    private final Set dependencies = new HashSet();
    private final Map descriptorsByName = new HashMap();
    private final Map enumValuesByNumber = new HashMap();
    private final Map fieldsByNumber = new HashMap();

    private void importPublicDependencies(SearchFilter searchfilter)
    {
        searchfilter = searchfilter.getPublicDependencies().iterator();
        do
        {
            if (!searchfilter.hasNext())
            {
                break;
            }
            SearchFilter searchfilter1 = (getPublicDependencies)searchfilter.next();
            if (dependencies.add(searchfilter1))
            {
                importPublicDependencies(searchfilter1);
            }
        } while (true);
    }

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
        return findSymbol(s, SearchFilter.ALL_SYMBOLS);
    }

    or findSymbol(String s, SearchFilter searchfilter)
    {
        or or1 = (or)descriptorsByName.get(s);
        if (or1 == null) goto _L2; else goto _L1
_L1:
        or or = or1;
        if (searchfilter == SearchFilter.ALL_SYMBOLS) goto _L4; else goto _L3
_L3:
        if (searchfilter != SearchFilter.TYPES_ONLY) goto _L6; else goto _L5
_L5:
        or = or1;
        if (isType(or1)) goto _L4; else goto _L6
_L6:
        if (searchfilter != SearchFilter.AGGREGATES_ONLY || !isAggregate(or1)) goto _L2; else goto _L7
_L7:
        or = or1;
_L4:
        return or;
_L2:
        Iterator iterator = dependencies.iterator();
_L11:
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_171;
            }
            or1 = (or)access._mth1200((access._cls1200)iterator.next()).descriptorsByName.get(s);
        } while (or1 == null);
        or = or1;
        if (searchfilter == SearchFilter.ALL_SYMBOLS) goto _L4; else goto _L8
_L8:
        if (searchfilter != SearchFilter.TYPES_ONLY)
        {
            break; /* Loop/switch isn't completed */
        }
        or = or1;
        if (isType(or1)) goto _L4; else goto _L9
_L9:
        if (searchfilter != SearchFilter.AGGREGATES_ONLY || !isAggregate(or1)) goto _L11; else goto _L10
_L10:
        return or1;
        return null;
    }

    boolean isAggregate(or or)
    {
        return (or instanceof or) || (or instanceof or) || (or instanceof PackageDescriptor) || (or instanceof or);
    }

    boolean isType(or or)
    {
        return (or instanceof or) || (or instanceof or);
    }

    or lookupSymbol(String s, or or, SearchFilter searchfilter)
        throws ationException
    {
        if (!s.startsWith(".")) goto _L2; else goto _L1
_L1:
        searchfilter = findSymbol(s.substring(1), searchfilter);
_L4:
        String s1;
        StringBuilder stringbuilder;
        int i;
        int j;
        if (searchfilter == null)
        {
            throw new ationException(or, (new StringBuilder()).append('"').append(s).append("\" is not defined.").toString(), null);
        } else
        {
            return searchfilter;
        }
_L2:
        i = s.indexOf('.');
        if (i == -1)
        {
            s1 = s;
        } else
        {
            s1 = s.substring(0, i);
        }
        stringbuilder = new StringBuilder(or.getFullName());
_L5:
        j = stringbuilder.lastIndexOf(".");
        if (j == -1)
        {
            searchfilter = findSymbol(s, searchfilter);
        } else
        {
label0:
            {
                stringbuilder.setLength(j + 1);
                stringbuilder.append(s1);
                or or1 = findSymbol(stringbuilder.toString(), SearchFilter.AGGREGATES_ONLY);
                if (or1 == null)
                {
                    break label0;
                }
                if (i != -1)
                {
                    stringbuilder.setLength(j + 1);
                    stringbuilder.append(s);
                    searchfilter = findSymbol(stringbuilder.toString(), searchfilter);
                } else
                {
                    searchfilter = or1;
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



    ationException(SearchFilter asearchfilter[])
    {
        for (int i = 0; i < asearchfilter.length; i++)
        {
            dependencies.add(asearchfilter[i]);
            importPublicDependencies(asearchfilter[i]);
        }

        for (asearchfilter = dependencies.iterator(); asearchfilter.hasNext();)
        {
            SearchFilter searchfilter = (dependencies)asearchfilter.next();
            try
            {
                addPackage(searchfilter.getPackage(), searchfilter);
            }
            catch (ationException ationexception)
            {
                if (!$assertionsDisabled)
                {
                    throw new AssertionError();
                }
            }
        }

    }
}
