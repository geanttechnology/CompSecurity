// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.experimentation;

import android.content.Context;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.dcs.DcsState;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.net.api.experimentation:
//            ExperimentationContextBase, Experiment, Treatment, ExperimentationDataManager

public abstract class ExperimentBase extends ExperimentationContextBase
    implements Experiment
{

    private static final List EMPTY_CONTEXT = Collections.emptyList();
    private final String dcsKey;
    protected Treatment defaultTreatment;
    protected final String displayId;
    protected final String id;
    protected final String name;

    public ExperimentBase(String s, String s1, String s2)
    {
        name = s;
        id = s1;
        displayId = s2;
        dcsKey = (new StringBuilder()).append("mep.default.exp.").append(s.replaceAll("\\W", "_")).toString();
    }

    public Object defaultValue(DcsState dcsstate)
    {
        return null;
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (!(obj instanceof ExperimentBase))
        {
            return false;
        }
        obj = (ExperimentBase)obj;
        if (defaultTreatment == null)
        {
            if (((ExperimentBase) (obj)).defaultTreatment != null)
            {
                return false;
            }
        } else
        if (!defaultTreatment.equals(((ExperimentBase) (obj)).defaultTreatment))
        {
            return false;
        }
        if (displayId == null)
        {
            if (((ExperimentBase) (obj)).displayId != null)
            {
                return false;
            }
        } else
        if (!displayId.equals(((ExperimentBase) (obj)).displayId))
        {
            return false;
        }
        if (id == null)
        {
            if (((ExperimentBase) (obj)).id != null)
            {
                return false;
            }
        } else
        if (!id.equals(((ExperimentBase) (obj)).id))
        {
            return false;
        }
        if (name != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((ExperimentBase) (obj)).name == null) goto _L1; else goto _L3
_L3:
        return false;
        if (name.equals(((ExperimentBase) (obj)).name)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public List getContextDictionary(Context context)
    {
        return EMPTY_CONTEXT;
    }

    public Treatment getCurrentTreatment(EbayContext ebaycontext)
    {
        ebaycontext = (ExperimentationDataManager)DataManager.get(ebaycontext, new ExperimentationDataManager.KeyParams(ebaycontext));
        ebaycontext.addExperiment(this);
        return ebaycontext.getExperimentState(this);
    }

    public Treatment getDefaultTreatment()
    {
        return defaultTreatment;
    }

    public String getDisplayId()
    {
        return displayId;
    }

    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public int hashCode()
    {
        int l = 0;
        int i;
        int j;
        int k;
        if (defaultTreatment == null)
        {
            i = 0;
        } else
        {
            i = defaultTreatment.hashCode();
        }
        if (displayId == null)
        {
            j = 0;
        } else
        {
            j = displayId.hashCode();
        }
        if (id == null)
        {
            k = 0;
        } else
        {
            k = id.hashCode();
        }
        if (name != null)
        {
            l = name.hashCode();
        }
        return (((i + 31) * 31 + j) * 31 + k) * 31 + l;
    }

    public String key()
    {
        return dcsKey;
    }

}
