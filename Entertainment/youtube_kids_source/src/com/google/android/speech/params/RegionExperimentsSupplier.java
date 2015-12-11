// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.params;

import a;
import com.google.android.speech.SpeechConfigFlags;
import egf;
import ezg;
import ezh;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// Referenced classes of package com.google.android.speech.params:
//            RegionExperiment

public class RegionExperimentsSupplier
    implements egf
{

    private static final boolean DEBUG = false;
    private static final String TAG = "RegionExperimentsSupplier";
    private final SpeechConfigFlags mSpeechConfigFlags;

    public RegionExperimentsSupplier(SpeechConfigFlags speechconfigflags)
    {
        mSpeechConfigFlags = speechconfigflags;
    }

    public volatile Object get()
    {
        return get();
    }

    public List get()
    {
        return parseRegionExperiments(mSpeechConfigFlags.getS3RegionExperiments());
    }

    List parseRegionExperiments(String as[])
    {
        if (as != null && as.length != 0) goto _L2; else goto _L1
_L1:
        Object obj = Collections.emptyList();
_L4:
        return ((List) (obj));
_L2:
        java.util.ArrayList arraylist = a.K();
        int j = as.length;
        int i = 0;
        do
        {
            obj = arraylist;
            if (i >= j)
            {
                continue;
            }
            obj = as[i];
            if (obj != null && !((String) (obj)).isEmpty())
            {
                Object obj2 = new StringTokenizer(((String) (obj)), ":", false);
                if (((StringTokenizer) (obj2)).countTokens() == 5)
                {
                    Object obj3 = ((StringTokenizer) (obj2)).nextToken();
                    String s1 = ((StringTokenizer) (obj2)).nextToken();
                    Object obj1 = ((StringTokenizer) (obj2)).nextToken();
                    String s = ((StringTokenizer) (obj2)).nextToken();
                    obj2 = ((StringTokenizer) (obj2)).nextToken();
                    if (!((String) (obj2)).isEmpty())
                    {
                        try
                        {
                            obj3 = (new ezg()).a(Integer.parseInt(((String) (obj3)))).b(Integer.parseInt(s1));
                            obj1 = (new ezg()).a(Integer.parseInt(((String) (obj1)))).b(Integer.parseInt(s));
                            arraylist.add(new RegionExperiment((new ezh()).b(((ezg) (obj3))).a(((ezg) (obj1))), ((String) (obj2))));
                        }
                        catch (NumberFormatException numberformatexception) { }
                    }
                }
            }
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }
}
