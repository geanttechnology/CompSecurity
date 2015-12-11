// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.auditude.ads.model.smil;

import com.auditude.ads.model.Asset;
import com.auditude.ads.model.BaseElement;
import com.auditude.ads.model.LinearAsset;
import com.auditude.ads.util.StringUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

// Referenced classes of package com.auditude.ads.model.smil:
//            SmilElementType, Par, Ref

public class Sequence extends BaseElement
{
    class RefIterator
        implements Iterable, Iterator
    {

        private int index;
        private ArrayList refs;
        final Sequence this$0;

        public boolean hasNext()
        {
            return true;
        }

        public Iterator iterator()
        {
            return this;
        }

        public Ref next()
        {
            if (refs.size() > index)
            {
                ArrayList arraylist = refs;
                int i = index;
                index = i + 1;
                return (Ref)arraylist.get(i);
            } else
            {
                return null;
            }
        }

        public volatile Object next()
        {
            return next();
        }

        public void remove()
        {
        }

        public RefIterator(ArrayList arraylist)
        {
            this$0 = Sequence.this;
            super();
            refs = new ArrayList();
            index = 0;
            if (arraylist == null) goto _L2; else goto _L1
_L1:
            sequence = arraylist.iterator();
_L5:
            if (Iterator.this.hasNext()) goto _L3; else goto _L2
_L2:
            return;
_L3:
            arraylist = ((Par)Iterator.this.next()).getRefList();
            if (arraylist != null && arraylist.size() > 0)
            {
                arraylist = arraylist.iterator();
                while (arraylist.hasNext()) 
                {
                    Ref ref = (Ref)arraylist.next();
                    if (ref.getPrimaryAsset() != null)
                    {
                        refs.add(ref);
                    }
                }
            }
            if (true) goto _L5; else goto _L4
_L4:
        }
    }


    public static String PLAYABLE_AD_COUNT = "playableAdCount";
    public static String PLAYABLE_DURATION = "playableDuration";
    public static String PLAYABLE_REFS = "playableRefs";
    private int count;
    private int creativeMaxDuration;
    private int duration;
    private int enumeratorIndex;
    private boolean isWatched;
    private int maxCount;
    private int maxDuration;
    private ArrayList pars;
    private String submissionId;
    private SmilElementType type;

    public Sequence(BaseElement baseelement, SmilElementType smilelementtype)
    {
        super(baseelement);
        type = SmilElementType.values()[0];
        maxDuration = -1;
        duration = -1;
        maxCount = -1;
        count = -1;
        creativeMaxDuration = -1;
        isWatched = false;
        pars = new ArrayList();
        enumeratorIndex = -1;
        type = smilelementtype;
    }

    public final void addPar(Par par)
    {
        if (par != null)
        {
            par.setSequence(this);
            pars.add(par);
        }
    }

    public final void addState(String s, String s1)
    {
        if (StringUtil.isNotNullOrEmpty(s) && StringUtil.isNotNullOrEmpty(s1))
        {
            HashMap hashmap1 = super.getState();
            HashMap hashmap = hashmap1;
            if (hashmap1 == null)
            {
                hashmap = new HashMap();
            }
            hashmap.put(s, s1);
            super.setState(hashmap);
        }
    }

    public final int getCreativeMaxDuration()
    {
        return creativeMaxDuration;
    }

    public final int getDuration()
    {
        return duration;
    }

    public final int getMaxCount()
    {
        if (maxCount < 0)
        {
            return count;
        } else
        {
            return maxCount;
        }
    }

    public final int getMaxDuration()
    {
        if (maxDuration < 0)
        {
            return duration;
        } else
        {
            return maxDuration;
        }
    }

    public final ArrayList getPars()
    {
        return pars;
    }

    public final HashMap getPlayableMetrics()
    {
        ArrayList arraylist;
        RefIterator refiterator;
        int i;
        int j;
        i = 0;
        j = 0;
        arraylist = new ArrayList();
        refiterator = new RefIterator(pars);
_L5:
        Object obj = refiterator.next();
        if (obj != null) goto _L2; else goto _L1
_L1:
        int k;
        int l;
        l = i;
        k = j;
_L4:
        HashMap hashmap = new HashMap();
        hashmap.put(PLAYABLE_DURATION, Integer.valueOf(l));
        hashmap.put(PLAYABLE_AD_COUNT, Integer.valueOf(k));
        hashmap.put(PLAYABLE_REFS, arraylist);
        return hashmap;
_L2:
        Asset asset;
        asset = ((Ref) (obj)).getPrimaryAsset();
        if (!(asset instanceof LinearAsset))
        {
            break; /* Loop/switch isn't completed */
        }
        if (getMaxCount() < 0)
        {
            break; /* Loop/switch isn't completed */
        }
        k = j;
        l = i;
        if (j >= getMaxCount()) goto _L4; else goto _L3
_L3:
        if (getMaxDuration() >= 0 && ((LinearAsset)asset).getDurationInMillis() + i > getMaxDuration() || getCreativeMaxDuration() >= 0 && asset.getDurationInMillis() > getCreativeMaxDuration())
        {
            break; /* Loop/switch isn't completed */
        }
        k = j + 1;
        l = i + ((LinearAsset)asset).getDurationInMillis();
        arraylist.add(obj);
        obj = asset.getAuditudeParams();
        j = k;
        i = l;
        if (obj == null)
        {
            break; /* Loop/switch isn't completed */
        }
        j = k;
        i = l;
        if (!((HashMap) (obj)).containsKey("daisy_chaining"))
        {
            break; /* Loop/switch isn't completed */
        }
        j = k;
        i = l;
        if (!((String)((HashMap) (obj)).get("daisy_chaining")).equalsIgnoreCase("never")) goto _L5; else goto _L4
    }

    public final ArrayList getRefs()
    {
        return (ArrayList)getPlayableMetrics().get(PLAYABLE_REFS);
    }

    public final String getSubmissionId()
    {
        return submissionId;
    }

    public SmilElementType getType()
    {
        return type;
    }

    public final boolean isEmpty()
    {
        return pars.isEmpty();
    }

    public final boolean isLinear()
    {
        return type == SmilElementType.LINEAR;
    }

    public final void setCount(int i)
    {
        count = i;
    }

    public final void setCreativeMaxDuration(int i)
    {
        creativeMaxDuration = i;
    }

    public final void setDuration(int i)
    {
        duration = i;
    }

    public final void setMaxCount(int i)
    {
        maxCount = i;
    }

    public final void setMaxDuration(int i)
    {
        maxDuration = i;
    }

    public final void setSubmissionId(String s)
    {
        submissionId = s;
    }

    public void setType(SmilElementType smilelementtype)
    {
        type = smilelementtype;
    }

}
