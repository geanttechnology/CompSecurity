// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.tags;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

// Referenced classes of package com.xfinity.playerlib.model.tags:
//            Tag, OrderedTag, FeaturedShow

public final class Network
    implements Parcelable, Tag, Comparable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Network createFromParcel(Parcel parcel)
        {
            return new Network(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public Network[] newArray(int i)
        {
            return new Network[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private final List categories;
    private Map categoryMap;
    private final long companyId;
    private final FeaturedShow featuredShow;
    private final boolean hasAllMoviesCategory;
    private final boolean hasAllTvCategory;
    private final String id;
    private final boolean isPremium;
    private final List movieGenres;
    private final String name;

    public Network(long l, FeaturedShow featuredshow, String s, List list, String s1, boolean flag, 
            List list1)
    {
        categoryMap = new TreeMap();
        Object obj = list;
        if (list == null)
        {
            obj = new ArrayList();
        }
        list = list1;
        if (list1 == null)
        {
            list = new ArrayList();
        }
        Collections.sort(((List) (obj)));
        Collections.sort(list);
        boolean flag1 = false;
        boolean flag2 = false;
        list1 = list.iterator();
        while (list1.hasNext()) 
        {
            OrderedTag orderedtag = (OrderedTag)list1.next();
            boolean flag3;
            if (orderedtag.getId().equals(OrderedTag.ALL_MOVIES.getId()))
            {
                flag3 = true;
            } else
            {
                flag3 = flag1;
                if (orderedtag.getId().equals(OrderedTag.ALL_TV.getId()))
                {
                    flag2 = true;
                    flag3 = flag1;
                }
            }
            categoryMap.put(orderedtag.getId(), orderedtag);
            flag1 = flag3;
        }
        featuredShow = featuredshow;
        id = s;
        movieGenres = Collections.unmodifiableList(((List) (obj)));
        name = s1;
        isPremium = flag;
        categories = Collections.unmodifiableList(list);
        hasAllMoviesCategory = flag1;
        hasAllTvCategory = flag2;
        companyId = l;
    }

    private Network(Parcel parcel)
    {
        categoryMap = new TreeMap();
        featuredShow = (FeaturedShow)parcel.readParcelable(com/xfinity/playerlib/model/tags/FeaturedShow.getClassLoader());
        id = parcel.readString();
        companyId = parcel.readLong();
        movieGenres = readList(parcel, com/xfinity/playerlib/model/tags/OrderedTag.getClassLoader());
        name = parcel.readString();
        boolean flag;
        boolean flag1;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isPremium = flag;
        categories = readList(parcel, com/xfinity/playerlib/model/tags/OrderedTag.getClassLoader());
        flag = false;
        flag1 = false;
        parcel = categories.iterator();
        while (parcel.hasNext()) 
        {
            OrderedTag orderedtag = (OrderedTag)parcel.next();
            boolean flag2;
            if (orderedtag.getId().equals(OrderedTag.ALL_MOVIES.getId()))
            {
                flag2 = true;
            } else
            {
                flag2 = flag;
                if (orderedtag.getId().equals(OrderedTag.ALL_TV.getId()))
                {
                    flag1 = true;
                    flag2 = flag;
                }
            }
            categoryMap.put(orderedtag.getId(), orderedtag);
            flag = flag2;
        }
        hasAllMoviesCategory = flag;
        hasAllTvCategory = flag1;
    }


    private List readList(Parcel parcel, ClassLoader classloader)
    {
        ArrayList arraylist = new ArrayList();
        parcel.readList(arraylist, classloader);
        return arraylist;
    }

    public int compareTo(Network network)
    {
        boolean flag1 = true;
        CompareToBuilder comparetobuilder = new CompareToBuilder();
        boolean flag;
        if (!isPremium())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (network.isPremium())
        {
            flag1 = false;
        }
        return comparetobuilder.append(flag, flag1).append(getName().toLowerCase(), network.getName().toLowerCase()).toComparison();
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((Network)obj);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (Network)obj;
            if (companyId != ((Network) (obj)).companyId)
            {
                return false;
            }
            if (hasAllMoviesCategory != ((Network) (obj)).hasAllMoviesCategory)
            {
                return false;
            }
            if (hasAllTvCategory != ((Network) (obj)).hasAllTvCategory)
            {
                return false;
            }
            if (isPremium != ((Network) (obj)).isPremium)
            {
                return false;
            }
            if (categories == null ? ((Network) (obj)).categories != null : !categories.equals(((Network) (obj)).categories))
            {
                return false;
            }
            if (!categoryMap.equals(((Network) (obj)).categoryMap))
            {
                return false;
            }
            if (featuredShow == null ? ((Network) (obj)).featuredShow != null : !featuredShow.equals(((Network) (obj)).featuredShow))
            {
                return false;
            }
            if (id == null ? ((Network) (obj)).id != null : !id.equals(((Network) (obj)).id))
            {
                return false;
            }
            if (movieGenres == null ? ((Network) (obj)).movieGenres != null : !movieGenres.equals(((Network) (obj)).movieGenres))
            {
                return false;
            }
            if (!name.equals(((Network) (obj)).name))
            {
                return false;
            }
        }
        return true;
    }

    public List getCategories()
    {
        return categories;
    }

    public OrderedTag getCategoryById(String s)
    {
        if (OrderedTag.ALL_MOVIES.getId().equals(s))
        {
            return OrderedTag.ALL_MOVIES;
        }
        if (OrderedTag.ALL_TV.getId().equals(s))
        {
            return OrderedTag.ALL_TV;
        } else
        {
            return (OrderedTag)categoryMap.get(s);
        }
    }

    public long getCompanyId()
    {
        return companyId;
    }

    public FeaturedShow getFeaturedShow()
    {
        return featuredShow;
    }

    public String getId()
    {
        return id;
    }

    public List getMovieGenres()
    {
        return movieGenres;
    }

    public String getName()
    {
        return name;
    }

    public boolean hasAllMoviesCategory()
    {
        return hasAllMoviesCategory;
    }

    public boolean hasAllTvCategory()
    {
        return hasAllTvCategory;
    }

    public int hashCode()
    {
        int k1 = 1;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int l1;
        if (featuredShow != null)
        {
            i = featuredShow.hashCode();
        } else
        {
            i = 0;
        }
        if (id != null)
        {
            j = id.hashCode();
        } else
        {
            j = 0;
        }
        if (movieGenres != null)
        {
            k = movieGenres.hashCode();
        } else
        {
            k = 0;
        }
        l1 = name.hashCode();
        if (isPremium)
        {
            l = 1;
        } else
        {
            l = 0;
        }
        if (categories != null)
        {
            i1 = categories.hashCode();
        } else
        {
            i1 = 0;
        }
        if (hasAllMoviesCategory)
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        if (!hasAllTvCategory)
        {
            k1 = 0;
        }
        return ((((((((i * 31 + j) * 31 + k) * 31 + l1) * 31 + l) * 31 + i1) * 31 + j1) * 31 + k1) * 31 + categoryMap.hashCode()) * 31 + (int)(companyId ^ companyId >>> 32);
    }

    public boolean isPremium()
    {
        return isPremium;
    }

    public String toString()
    {
        return (new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)).append("id", id).append("name", name).append("companyId", companyId).append("isPremium", isPremium).append("categories", categories).append("featuredShow", featuredShow).append("moviesGenres", movieGenres).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        i = 0;
        parcel.writeParcelable(featuredShow, 0);
        parcel.writeString(id);
        parcel.writeLong(companyId);
        parcel.writeList(movieGenres);
        parcel.writeString(name);
        if (isPremium)
        {
            i = 1;
        }
        parcel.writeByte((byte)i);
        parcel.writeList(categories);
    }

}
