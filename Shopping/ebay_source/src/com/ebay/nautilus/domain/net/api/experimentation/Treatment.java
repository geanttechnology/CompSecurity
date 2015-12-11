// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.experimentation;

import com.ebay.nautilus.domain.data.SerializablePair;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.net.api.experimentation:
//            Factor

public class Treatment
{

    public List eTags;
    public String engine;
    public String experimentId;
    public String experimentName;
    public List factors;
    public transient boolean isDefault;
    public String treatmentDisplayId;
    public String treatmentId;
    public String treatmentName;
    public List xTags;

    public Treatment()
    {
        isDefault = false;
        factors = new ArrayList();
        eTags = new ArrayList();
        xTags = new ArrayList();
    }

    public Treatment(Treatment treatment)
    {
        this();
        engine = treatment.engine;
        treatmentName = treatment.treatmentName;
        treatmentId = treatment.treatmentId;
        treatmentDisplayId = treatment.treatmentDisplayId;
        experimentId = treatment.experimentId;
        experimentName = treatment.experimentName;
        isDefault = treatment.isDefault;
        if (treatment.factors != null)
        {
            Factor factor;
            for (Iterator iterator = treatment.factors.iterator(); iterator.hasNext(); factors.add(new Factor(factor)))
            {
                factor = (Factor)iterator.next();
            }

        }
        if (treatment.eTags != null)
        {
            SerializablePair serializablepair1;
            for (Iterator iterator1 = treatment.eTags.iterator(); iterator1.hasNext(); eTags.add(new SerializablePair(serializablepair1)))
            {
                serializablepair1 = (SerializablePair)iterator1.next();
            }

        }
        if (treatment.xTags != null)
        {
            SerializablePair serializablepair;
            for (treatment = treatment.xTags.iterator(); treatment.hasNext(); xTags.add(new SerializablePair(serializablepair)))
            {
                serializablepair = (SerializablePair)treatment.next();
            }

        }
    }

    public Treatment(String s, Factor afactor[])
    {
        this();
        treatmentDisplayId = s;
        if (afactor != null)
        {
            factors = Arrays.asList(afactor);
            return;
        } else
        {
            factors = Collections.emptyList();
            return;
        }
    }

    public static Treatment fromString(String s)
    {
        return (Treatment)DataMapperFactory.getDefaultMapper().fromJson(s, com/ebay/nautilus/domain/net/api/experimentation/Treatment);
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (!(obj instanceof Treatment))
        {
            return false;
        }
        obj = (Treatment)obj;
        if (engine == null)
        {
            if (((Treatment) (obj)).engine != null)
            {
                return false;
            }
        } else
        if (!engine.equals(((Treatment) (obj)).engine))
        {
            return false;
        }
        if (experimentId == null)
        {
            if (((Treatment) (obj)).experimentId != null)
            {
                return false;
            }
        } else
        if (!experimentId.equals(((Treatment) (obj)).experimentId))
        {
            return false;
        }
        if (experimentName == null)
        {
            if (((Treatment) (obj)).experimentName != null)
            {
                return false;
            }
        } else
        if (!experimentName.equals(((Treatment) (obj)).experimentName))
        {
            return false;
        }
        if (factors == null)
        {
            if (((Treatment) (obj)).factors != null)
            {
                return false;
            }
        } else
        if (!factors.equals(((Treatment) (obj)).factors))
        {
            return false;
        }
        if (treatmentDisplayId == null)
        {
            if (((Treatment) (obj)).treatmentDisplayId != null)
            {
                return false;
            }
        } else
        if (!treatmentDisplayId.equals(((Treatment) (obj)).treatmentDisplayId))
        {
            return false;
        }
        if (treatmentId == null)
        {
            if (((Treatment) (obj)).treatmentId != null)
            {
                return false;
            }
        } else
        if (!treatmentId.equals(((Treatment) (obj)).treatmentId))
        {
            return false;
        }
        if (treatmentName != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((Treatment) (obj)).treatmentName == null) goto _L1; else goto _L3
_L3:
        return false;
        if (treatmentName.equals(((Treatment) (obj)).treatmentName)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public String getCurrentFactor(String s)
    {
        if (factors == null)
        {
            return null;
        }
        for (Iterator iterator = factors.iterator(); iterator.hasNext();)
        {
            Factor factor = (Factor)iterator.next();
            if (((String)factor.key).equals(s))
            {
                return (String)factor.value;
            }
        }

        return null;
    }

    public int hashCode()
    {
        int i2 = 0;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        if (eTags == null)
        {
            i = 0;
        } else
        {
            i = eTags.hashCode();
        }
        if (engine == null)
        {
            j = 0;
        } else
        {
            j = engine.hashCode();
        }
        if (experimentId == null)
        {
            k = 0;
        } else
        {
            k = experimentId.hashCode();
        }
        if (experimentName == null)
        {
            l = 0;
        } else
        {
            l = experimentName.hashCode();
        }
        if (factors == null)
        {
            i1 = 0;
        } else
        {
            i1 = factors.hashCode();
        }
        if (treatmentDisplayId == null)
        {
            j1 = 0;
        } else
        {
            j1 = treatmentDisplayId.hashCode();
        }
        if (treatmentId == null)
        {
            k1 = 0;
        } else
        {
            k1 = treatmentId.hashCode();
        }
        if (treatmentName == null)
        {
            l1 = 0;
        } else
        {
            l1 = treatmentName.hashCode();
        }
        if (xTags != null)
        {
            i2 = xTags.hashCode();
        }
        return ((((((((i + 31) * 31 + j) * 31 + k) * 31 + l) * 31 + i1) * 31 + j1) * 31 + k1) * 31 + l1) * 31 + i2;
    }

    public String toString()
    {
        return DataMapperFactory.getDefaultMapper().toJson(this);
    }
}
