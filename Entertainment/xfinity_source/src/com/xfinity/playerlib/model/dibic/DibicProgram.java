// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.dibic;

import com.google.common.collect.Sets;
import com.xfinity.playerlib.model.MerlinId;
import com.xfinity.playerlib.model.Program;
import com.xfinity.playerlib.model.tags.parser.TagsRoot;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.input.SwappedDataInputStream;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.model.dibic:
//            DibicDictionary

public abstract class DibicProgram
    implements Program
{
    public static final class Flags extends Enum
    {

        private static final Flags $VALUES[];
        public static final Flags ADULT;
        public static final Flags DOWNLOADABLE;
        public static final Flags HD;
        public static final Flags IN_STORE;
        public static final Flags IN_THEATER;
        public static final Flags IN_TVLISTING;
        public static final Flags KIDS;
        public static final Flags NEW;
        public static final Flags ON_DVD;
        public static final Flags ON_VOD;
        public static final Flags PROTECTED;
        public static final Flags THUMBNAIL;
        public int bitMask;

        public static Flags valueOf(String s)
        {
            return (Flags)Enum.valueOf(com/xfinity/playerlib/model/dibic/DibicProgram$Flags, s);
        }

        public static Flags[] values()
        {
            return (Flags[])$VALUES.clone();
        }

        static 
        {
            THUMBNAIL = new Flags("THUMBNAIL", 0, 0x80000000);
            PROTECTED = new Flags("PROTECTED", 1, 0x40000000);
            ADULT = new Flags("ADULT", 2, 0x20000000);
            IN_TVLISTING = new Flags("IN_TVLISTING", 3, 0x10000000);
            ON_DVD = new Flags("ON_DVD", 4, 0x8000000);
            IN_THEATER = new Flags("IN_THEATER", 5, 0x4000000);
            ON_VOD = new Flags("ON_VOD", 6, 0x2000000);
            IN_STORE = new Flags("IN_STORE", 7, 0x1000000);
            HD = new Flags("HD", 8, 0x800000);
            NEW = new Flags("NEW", 9, 0x400000);
            DOWNLOADABLE = new Flags("DOWNLOADABLE", 10, 0x200000);
            KIDS = new Flags("KIDS", 11, 0x100000);
            $VALUES = (new Flags[] {
                THUMBNAIL, PROTECTED, ADULT, IN_TVLISTING, ON_DVD, IN_THEATER, ON_VOD, IN_STORE, HD, NEW, 
                DOWNLOADABLE, KIDS
            });
        }

        private Flags(String s, int i, int j)
        {
            super(s, i);
            bitMask = j;
        }
    }


    private static final String FORBIDDEN_WORDS[] = {
        "A ", "An ", "The ", "'"
    };
    private final Logger LOG = LoggerFactory.getLogger(getClass());
    private int bitFields;
    private List companyIdKeys;
    private int daysOfWeekKey;
    private DibicDictionary dictionary;
    private long firstVideoExpirationDate;
    private List genreKeys;
    private long lastVideoExpirationDate;
    private int longFormCount;
    private long merlinId;
    private List networkKeys;
    private Set networks;
    private int popularity;
    private List providerCodesKeys;
    private int releaseYear;
    private String sortTitle;
    private TagsRoot tagsRoot;
    private String title;
    private int titleKey;
    private int trailerCount;

    public DibicProgram()
    {
        networks = null;
        providerCodesKeys = new ArrayList();
        networkKeys = new ArrayList();
        genreKeys = new ArrayList();
        companyIdKeys = new ArrayList();
    }

    private boolean bitFieldsContain(Flags flags)
    {
        int i = flags.bitMask;
        return (bitFields & i) == i;
    }

    int getBitFieldsForTestingOnly()
    {
        return bitFields;
    }

    public List getDaysOfWeek()
    {
        return dictionary.getStringsByKey(daysOfWeekKey);
    }

    public long getFirstVideoExpirationDate()
    {
        return firstVideoExpirationDate;
    }

    public Set getFlags()
    {
        java.util.HashSet hashset = Sets.newHashSet();
        Flags aflags[] = Flags.values();
        int j = aflags.length;
        for (int i = 0; i < j; i++)
        {
            Flags flags = aflags[i];
            if (bitFieldsContain(flags))
            {
                hashset.add(flags);
            }
        }

        return hashset;
    }

    public Set getGenreIds()
    {
        java.util.HashSet hashset = Sets.newHashSet();
        Integer integer;
        for (Iterator iterator = genreKeys.iterator(); iterator.hasNext(); hashset.addAll(dictionary.getStringsByKey(integer.intValue())))
        {
            integer = (Integer)iterator.next();
        }

        return hashset;
    }

    public List getGenres()
    {
        ArrayList arraylist = new ArrayList();
        String s;
        for (Iterator iterator = getGenreIds().iterator(); iterator.hasNext(); arraylist.add(tagsRoot.getGenreById(s)))
        {
            s = (String)iterator.next();
        }

        return arraylist;
    }

    public long getLastVideoExpirationDate()
    {
        return lastVideoExpirationDate;
    }

    public int getLongFormCount()
    {
        return longFormCount;
    }

    public MerlinId getMerlinId()
    {
        return new MerlinId(getMerlinIdNamespace(), Long.valueOf(merlinId));
    }

    public List getNetworkCompanyIds()
    {
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = companyIdKeys.iterator(); iterator.hasNext();)
        {
            Integer integer = (Integer)iterator.next();
            Iterator iterator1 = dictionary.getStringsByKey(integer.intValue()).iterator();
            while (iterator1.hasNext()) 
            {
                String s = (String)iterator1.next();
                try
                {
                    arraylist.add(Long.valueOf(Long.valueOf(s).longValue()));
                }
                catch (NumberFormatException numberformatexception)
                {
                    LOG.warn((new StringBuilder()).append("No company id found for key: ").append(integer).toString());
                }
            }
        }

        return arraylist;
    }

    public Set getNetworks()
    {
        if (networks == null)
        {
            networks = tagsRoot.getNetworksByCompanyIds(getNetworkCompanyIds());
        }
        return networks;
    }

    public MerlinId getParentMerlinIdIfApplicable()
    {
        return getMerlinId();
    }

    public int getPopularity()
    {
        return popularity;
    }

    public List getProviderCodes()
    {
        ArrayList arraylist = new ArrayList();
        Integer integer;
        for (Iterator iterator = providerCodesKeys.iterator(); iterator.hasNext(); arraylist.addAll(dictionary.getStringsByKey(integer.intValue())))
        {
            integer = (Integer)iterator.next();
        }

        return arraylist;
    }

    public int getReleaseYear()
    {
        return releaseYear;
    }

    public String getSortTitle()
    {
        return sortTitle;
    }

    public String getTitle()
    {
        return title;
    }

    List getTitleWords()
    {
        return dictionary.getStringsByKey(titleKey);
    }

    public int getTrailerCount()
    {
        return trailerCount;
    }

    public boolean isAdult()
    {
        return bitFieldsContain(Flags.ADULT);
    }

    public boolean isDownloadable()
    {
        return bitFieldsContain(Flags.DOWNLOADABLE);
    }

    public boolean isKids()
    {
        return bitFieldsContain(Flags.KIDS);
    }

    public abstract boolean isMovie();

    public boolean isNew()
    {
        return bitFieldsContain(Flags.NEW);
    }

    public void merge(DibicProgram dibicprogram)
    {
        networkKeys.addAll(dibicprogram.networkKeys);
        companyIdKeys.addAll(dibicprogram.companyIdKeys);
        genreKeys.addAll(dibicprogram.genreKeys);
        providerCodesKeys.addAll(dibicprogram.providerCodesKeys);
        if (networks == null)
        {
            networks = dibicprogram.getNetworks();
        } else
        {
            networks.addAll(dibicprogram.getNetworks());
        }
        firstVideoExpirationDate = Math.min(firstVideoExpirationDate, dibicprogram.firstVideoExpirationDate);
        lastVideoExpirationDate = Math.max(lastVideoExpirationDate, dibicprogram.lastVideoExpirationDate);
        if (dibicprogram.isDownloadable())
        {
            bitFields = bitFields | Flags.DOWNLOADABLE.bitMask;
        }
    }

    public void parse(SwappedDataInputStream swappeddatainputstream)
        throws IOException
    {
        merlinId = swappeddatainputstream.readLong();
        titleKey = swappeddatainputstream.readInt();
        releaseYear = swappeddatainputstream.readInt();
        providerCodesKeys.add(Integer.valueOf(swappeddatainputstream.readInt()));
        networkKeys.add(Integer.valueOf(swappeddatainputstream.readInt()));
        genreKeys.add(Integer.valueOf(swappeddatainputstream.readInt()));
        daysOfWeekKey = swappeddatainputstream.readInt();
        bitFields = swappeddatainputstream.readInt();
        longFormCount = swappeddatainputstream.readInt();
        trailerCount = swappeddatainputstream.readInt();
        firstVideoExpirationDate = swappeddatainputstream.readLong();
        lastVideoExpirationDate = swappeddatainputstream.readLong();
        popularity = swappeddatainputstream.readInt();
        companyIdKeys.add(Integer.valueOf(swappeddatainputstream.readInt()));
    }

    public void populateStrings()
    {
        title = dictionary.getStringByKey(titleKey);
        sortTitle = title;
        String as[] = FORBIDDEN_WORDS;
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            String s = as[i];
            if (title.startsWith(s))
            {
                sortTitle = title.substring(s.length());
                sortTitle = sortTitle.trim();
            }
        }

    }

    void setBitFieldsForTestingOnly(int i)
    {
        bitFields = i;
    }

    public void setDictionary(DibicDictionary dibicdictionary)
    {
        dictionary = dibicdictionary;
    }

    void setDownloadable(boolean flag)
    {
        if (flag)
        {
            bitFields = bitFields | Flags.DOWNLOADABLE.bitMask;
            return;
        } else
        {
            bitFields = bitFields & ~Flags.DOWNLOADABLE.bitMask;
            return;
        }
    }

    public void setTagsRoot(TagsRoot tagsroot)
    {
        tagsRoot = tagsroot;
    }

    public String toString()
    {
        return (new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)).append("merlinId", getMerlinId()).append("title", getTitle()).append("programArtId", getParentMerlinIdIfApplicable()).toString();
    }

}
