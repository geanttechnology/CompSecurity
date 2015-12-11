// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.search;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class EbayAspectHistogram extends ArrayList
    implements Parcelable, Cloneable
{
    public static final class Aspect extends ArrayList
        implements Cloneable
    {

        public String name;
        public String serviceName;
        public boolean suppressDisplay;

        public static Aspect createWithValue(String s, String s1, boolean flag)
        {
            return createWithValues(s, Arrays.asList(new String[] {
                s1
            }), flag);
        }

        public static Aspect createWithValues(String s, List list, boolean flag)
        {
            ArrayList arraylist = new ArrayList();
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                String s1 = (String)list.next();
                if (!TextUtils.isEmpty(s1))
                {
                    AspectValue aspectvalue = new AspectValue();
                    aspectvalue.value = s1;
                    aspectvalue.serviceValue = s1;
                    aspectvalue.checked = flag;
                    arraylist.add(aspectvalue);
                }
            } while (true);
            list = new Aspect(s, arraylist);
            list.serviceName = s;
            return list;
        }

        public Aspect clone()
        {
            Aspect aspect = (Aspect)super.clone();
            int j = size();
            for (int i = 0; i < j; i++)
            {
                aspect.set(i, ((AspectValue)aspect.get(i)).clone());
            }

            return aspect;
        }

        public volatile Object clone()
        {
            return clone();
        }

        public boolean equals(Object obj)
        {
            if (obj == null)
            {
                return false;
            }
            if (obj instanceof Aspect)
            {
                obj = (Aspect)obj;
                if (name == null)
                {
                    if (((Aspect) (obj)).name != null)
                    {
                        return false;
                    }
                } else
                if (!name.equals(((Aspect) (obj)).name))
                {
                    return false;
                }
                if (serviceName == null)
                {
                    if (((Aspect) (obj)).serviceName != null)
                    {
                        return false;
                    }
                } else
                if (!serviceName.equals(((Aspect) (obj)).serviceName))
                {
                    return false;
                }
                int j = size();
                if (j != ((Aspect) (obj)).size())
                {
                    return false;
                }
                for (int i = 0; i < j; i++)
                {
                    if (!((AspectValue)get(i)).equals(((Aspect) (obj)).get(i)))
                    {
                        return false;
                    }
                }

                return true;
            } else
            {
                return false;
            }
        }

        public final boolean hasCheck()
        {
            for (Iterator iterator = iterator(); iterator.hasNext();)
            {
                if (((AspectValue)iterator.next()).checked)
                {
                    return true;
                }
            }

            return false;
        }

        public String toString()
        {
            return name;
        }

        public Aspect()
        {
            suppressDisplay = false;
            name = null;
        }

        public Aspect(String s, int i)
        {
            super(i);
            suppressDisplay = false;
            name = s;
        }

        public Aspect(String s, Collection collection)
        {
            super(collection);
            suppressDisplay = false;
            name = s;
        }
    }

    public static final class AspectValue
        implements Cloneable
    {

        public boolean checked;
        public int count;
        public String serviceValue;
        public String value;

        public AspectValue clone()
        {
            AspectValue aspectvalue;
            try
            {
                aspectvalue = (AspectValue)super.clone();
            }
            catch (CloneNotSupportedException clonenotsupportedexception)
            {
                throw new AssertionError();
            }
            return aspectvalue;
        }

        public volatile Object clone()
            throws CloneNotSupportedException
        {
            return clone();
        }

        public boolean equals(Object obj)
        {
            if (obj != null && (obj instanceof AspectValue))
            {
                obj = (AspectValue)obj;
                if ((value != null ? value.equals(((AspectValue) (obj)).value) : ((AspectValue) (obj)).value == null) && (serviceValue != null ? serviceValue.equals(((AspectValue) (obj)).serviceValue) : ((AspectValue) (obj)).serviceValue == null) && (count == ((AspectValue) (obj)).count && checked == ((AspectValue) (obj)).checked))
                {
                    return true;
                }
            }
            return false;
        }

        public String toString()
        {
            if (count != 0)
            {
                return (new StringBuilder()).append(value).append(" (").append(count).append(')').toString();
            } else
            {
                return value;
            }
        }

        public AspectValue()
        {
            value = null;
            count = 0;
            checked = false;
            serviceValue = null;
        }
    }

    public static final class HistoMergeStrategy extends Enum
    {

        private static final HistoMergeStrategy $VALUES[];
        public static final HistoMergeStrategy MERGE_ALL;
        public static final HistoMergeStrategy MERGE_SUPPRESS;
        public static final HistoMergeStrategy RETAIN;

        public static HistoMergeStrategy valueOf(String s)
        {
            return (HistoMergeStrategy)Enum.valueOf(com/ebay/common/model/search/EbayAspectHistogram$HistoMergeStrategy, s);
        }

        public static HistoMergeStrategy[] values()
        {
            return (HistoMergeStrategy[])$VALUES.clone();
        }

        static 
        {
            RETAIN = new HistoMergeStrategy("RETAIN", 0);
            MERGE_ALL = new HistoMergeStrategy("MERGE_ALL", 1);
            MERGE_SUPPRESS = new HistoMergeStrategy("MERGE_SUPPRESS", 2);
            $VALUES = (new HistoMergeStrategy[] {
                RETAIN, MERGE_ALL, MERGE_SUPPRESS
            });
        }

        private HistoMergeStrategy(String s, int i)
        {
            super(s, i);
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public EbayAspectHistogram createFromParcel(Parcel parcel)
        {
            return new EbayAspectHistogram(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public EbayAspectHistogram[] newArray(int i)
        {
            return new EbayAspectHistogram[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public String domainDisplayName;
    public String domainName;
    public HistoMergeStrategy mergeStrategy;
    public String scopeType;
    public String scopeValue;

    public EbayAspectHistogram()
    {
        mergeStrategy = HistoMergeStrategy.RETAIN;
        domainName = null;
        domainDisplayName = null;
        scopeType = null;
        scopeValue = null;
    }

    EbayAspectHistogram(Parcel parcel)
    {
        mergeStrategy = HistoMergeStrategy.RETAIN;
        int j = parcel.readInt();
        ensureCapacity(j);
        for (int i = 0; i < j; i++)
        {
            add(readAspect(parcel));
        }

        domainName = parcel.readString();
        domainDisplayName = parcel.readString();
        mergeStrategy = HistoMergeStrategy.valueOf(parcel.readString());
        scopeType = parcel.readString();
        scopeValue = parcel.readString();
    }

    private Aspect readAspect(Parcel parcel)
    {
        boolean flag = true;
        String s = parcel.readString();
        Object obj = parcel.readString();
        int j;
        if (parcel.readInt() != 1)
        {
            flag = false;
        }
        j = parcel.readInt();
        obj = new Aspect(((String) (obj)), j);
        obj.serviceName = s;
        obj.suppressDisplay = flag;
        for (int i = 0; i < j; i++)
        {
            ((Aspect) (obj)).add(readValue(parcel));
        }

        return ((Aspect) (obj));
    }

    private AspectValue readValue(Parcel parcel)
    {
        AspectValue aspectvalue = new AspectValue();
        aspectvalue.serviceValue = parcel.readString();
        aspectvalue.value = parcel.readString();
        aspectvalue.count = parcel.readInt();
        boolean flag;
        if (parcel.readInt() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        aspectvalue.checked = flag;
        return aspectvalue;
    }

    private void writeAspect(Parcel parcel, Aspect aspect)
    {
        int j = aspect.size();
        parcel.writeString(aspect.serviceName);
        parcel.writeString(aspect.name);
        int i;
        if (aspect.suppressDisplay)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeInt(j);
        for (i = 0; i < j; i++)
        {
            writeValue(parcel, (AspectValue)aspect.get(i));
        }

    }

    private void writeValue(Parcel parcel, AspectValue aspectvalue)
    {
        parcel.writeString(aspectvalue.serviceValue);
        parcel.writeString(aspectvalue.value);
        parcel.writeInt(aspectvalue.count);
        int i;
        if (aspectvalue.checked)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
    }

    public EbayAspectHistogram clone()
    {
        EbayAspectHistogram ebayaspecthistogram = (EbayAspectHistogram)super.clone();
        int j = ebayaspecthistogram.size();
        for (int i = 0; i < j; i++)
        {
            ebayaspecthistogram.set(i, ((Aspect)ebayaspecthistogram.get(i)).clone());
        }

        return ebayaspecthistogram;
    }

    public volatile Object clone()
    {
        return clone();
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (obj instanceof EbayAspectHistogram)
        {
            obj = (EbayAspectHistogram)obj;
            if (domainName == null)
            {
                if (((EbayAspectHistogram) (obj)).domainName != null)
                {
                    return false;
                }
            } else
            if (!domainName.equals(((EbayAspectHistogram) (obj)).domainName))
            {
                return false;
            }
            if (domainDisplayName == null)
            {
                if (((EbayAspectHistogram) (obj)).domainDisplayName != null)
                {
                    return false;
                }
            } else
            if (!domainDisplayName.equals(((EbayAspectHistogram) (obj)).domainDisplayName))
            {
                return false;
            }
            if (scopeType == null)
            {
                if (((EbayAspectHistogram) (obj)).scopeType != null)
                {
                    return false;
                }
            } else
            if (!scopeType.equals(((EbayAspectHistogram) (obj)).scopeType))
            {
                return false;
            }
            if (scopeValue == null)
            {
                if (((EbayAspectHistogram) (obj)).scopeValue != null)
                {
                    return false;
                }
            } else
            if (!scopeValue.equals(((EbayAspectHistogram) (obj)).scopeValue))
            {
                return false;
            }
            int j = size();
            if (j != ((EbayAspectHistogram) (obj)).size())
            {
                return false;
            }
            for (int i = 0; i < j; i++)
            {
                if (!((Aspect)get(i)).equals(((EbayAspectHistogram) (obj)).get(i)))
                {
                    return false;
                }
            }

            return true;
        } else
        {
            return false;
        }
    }

    public final int getAppliedAspectCount()
    {
        int i = 0;
        Iterator iterator = iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (((Aspect)iterator.next()).hasCheck())
            {
                i++;
            }
        } while (true);
        return i;
    }

    public final boolean hasCheck()
    {
        for (Iterator iterator = iterator(); iterator.hasNext();)
        {
            if (((Aspect)iterator.next()).hasCheck())
            {
                return true;
            }
        }

        return false;
    }

    public String toString()
    {
        if (scopeType != null && scopeValue != null)
        {
            return (new StringBuilder()).append(scopeType).append(" (").append(scopeValue).append(") ").append(super.toString()).toString();
        } else
        {
            return (new StringBuilder()).append(domainDisplayName).append(" (").append(domainName).append(") ").append(super.toString()).toString();
        }
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        int j = size();
        parcel.writeInt(j);
        for (i = 0; i < j; i++)
        {
            writeAspect(parcel, (Aspect)get(i));
        }

        parcel.writeString(domainName);
        parcel.writeString(domainDisplayName);
        parcel.writeString(mergeStrategy.toString());
        parcel.writeString(scopeType);
        parcel.writeString(scopeValue);
    }

}
