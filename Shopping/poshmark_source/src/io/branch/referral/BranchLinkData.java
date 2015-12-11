// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import java.util.Collection;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class BranchLinkData extends JSONObject
{

    private String alias;
    private String channel;
    private int duration;
    private String feature;
    private String params;
    private String stage;
    private Collection tags;
    private int type;

    public BranchLinkData()
    {
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        obj = (BranchLinkData)obj;
        if (alias == null)
        {
            if (((BranchLinkData) (obj)).alias != null)
            {
                return false;
            }
        } else
        if (!alias.equals(((BranchLinkData) (obj)).alias))
        {
            return false;
        }
        if (channel == null)
        {
            if (((BranchLinkData) (obj)).channel != null)
            {
                return false;
            }
        } else
        if (!channel.equals(((BranchLinkData) (obj)).channel))
        {
            return false;
        }
        if (feature == null)
        {
            if (((BranchLinkData) (obj)).feature != null)
            {
                return false;
            }
        } else
        if (!feature.equals(((BranchLinkData) (obj)).feature))
        {
            return false;
        }
        if (params == null)
        {
            if (((BranchLinkData) (obj)).params != null)
            {
                return false;
            }
        } else
        if (!params.equals(((BranchLinkData) (obj)).params))
        {
            return false;
        }
        if (stage == null)
        {
            if (((BranchLinkData) (obj)).stage != null)
            {
                return false;
            }
        } else
        if (!stage.equals(((BranchLinkData) (obj)).stage))
        {
            return false;
        }
        if (type != ((BranchLinkData) (obj)).type)
        {
            return false;
        }
        if (duration != ((BranchLinkData) (obj)).duration)
        {
            return false;
        }
        if (tags != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((BranchLinkData) (obj)).tags == null) goto _L1; else goto _L3
_L3:
        return false;
        if (tags.toString().equals(((BranchLinkData) (obj)).tags.toString())) goto _L1; else goto _L4
_L4:
        return false;
    }

    public String getAlias()
    {
        return alias;
    }

    public String getChannel()
    {
        return channel;
    }

    public int getDuration()
    {
        return duration;
    }

    public String getFeature()
    {
        return feature;
    }

    public String getParams()
    {
        return params;
    }

    public String getStage()
    {
        return stage;
    }

    public Collection getTags()
    {
        return tags;
    }

    public int getType()
    {
        return type;
    }

    public int hashCode()
    {
        int i1 = 0;
        int j1 = type;
        int i;
        int j;
        int k;
        int l;
        if (alias == null)
        {
            i = 0;
        } else
        {
            i = alias.toLowerCase().hashCode();
        }
        if (channel == null)
        {
            j = 0;
        } else
        {
            j = channel.toLowerCase().hashCode();
        }
        if (feature == null)
        {
            k = 0;
        } else
        {
            k = feature.toLowerCase().hashCode();
        }
        if (stage == null)
        {
            l = 0;
        } else
        {
            l = stage.toLowerCase().hashCode();
        }
        if (params != null)
        {
            i1 = params.toLowerCase().hashCode();
        }
        i = 19 * (19 * (19 * (19 * (19 * (19 * (j1 + 19) + i) + j) + k) + l) + i1) + duration;
        j = i;
        if (tags != null)
        {
            Iterator iterator = tags.iterator();
            do
            {
                j = i;
                if (!iterator.hasNext())
                {
                    break;
                }
                i = 19 * i + ((String)iterator.next()).toLowerCase().hashCode();
            } while (true);
        }
        return j;
    }

    public void putAlias(String s)
        throws JSONException
    {
        if (s != null)
        {
            alias = s;
            put(Defines.LinkParam.Alias.getKey(), s);
        }
    }

    public void putChannel(String s)
        throws JSONException
    {
        if (s != null)
        {
            channel = s;
            put(Defines.LinkParam.Channel.getKey(), s);
        }
    }

    public void putDuration(int i)
        throws JSONException
    {
        if (i > 0)
        {
            duration = i;
            put(Defines.LinkParam.Duration.getKey(), i);
        }
    }

    public void putFeature(String s)
        throws JSONException
    {
        if (s != null)
        {
            feature = s;
            put(Defines.LinkParam.Feature.getKey(), s);
        }
    }

    public void putParams(String s)
        throws JSONException
    {
        params = s;
        put(Defines.LinkParam.Data.getKey(), s);
    }

    public void putStage(String s)
        throws JSONException
    {
        if (s != null)
        {
            stage = s;
            put(Defines.LinkParam.Stage.getKey(), s);
        }
    }

    public void putTags(Collection collection)
        throws JSONException
    {
        if (collection != null)
        {
            tags = collection;
            JSONArray jsonarray = new JSONArray();
            for (collection = collection.iterator(); collection.hasNext(); jsonarray.put((String)collection.next())) { }
            put(Defines.LinkParam.Tags.getKey(), jsonarray);
        }
    }

    public void putType(int i)
        throws JSONException
    {
        if (i != 0)
        {
            type = i;
            put(Defines.LinkParam.Type.getKey(), i);
        }
    }
}
