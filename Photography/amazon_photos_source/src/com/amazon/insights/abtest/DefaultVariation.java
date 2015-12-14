// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.abtest;

import com.amazon.insights.Variation;
import com.amazon.insights.core.idresolver.Id;
import com.amazon.insights.core.log.Logger;
import com.amazon.insights.core.util.JSONSerializable;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DefaultVariation
    implements Variation, JSONSerializable
{
    public static final class AllocationSource extends Enum
    {

        private static final AllocationSource $VALUES[];
        public static final AllocationSource CACHE;
        public static final AllocationSource DEFAULT;
        public static final AllocationSource SERVER;

        public static AllocationSource valueOf(String s)
        {
            return (AllocationSource)Enum.valueOf(com/amazon/insights/abtest/DefaultVariation$AllocationSource, s);
        }

        public static AllocationSource[] values()
        {
            return (AllocationSource[])$VALUES.clone();
        }

        static 
        {
            SERVER = new AllocationSource("SERVER", 0);
            CACHE = new AllocationSource("CACHE", 1);
            DEFAULT = new AllocationSource("DEFAULT", 2);
            $VALUES = (new AllocationSource[] {
                SERVER, CACHE, DEFAULT
            });
        }

        private AllocationSource(String s, int i)
        {
            super(s, i);
        }
    }

    public static class Builder
    {

        private String applicationKey;
        private Date appliedDate;
        private long experimentId;
        private Date expirationDate;
        private String projectName;
        private AllocationSource source;
        private Id uniqueId;
        private Map variables;
        private long variationId;
        private String variationName;

        public DefaultVariation build()
        {
            return new DefaultVariation(this);
        }

        public AllocationSource getAllocationSource()
        {
            return source;
        }

        public String getApplicationKey()
        {
            return applicationKey;
        }

        public long getExperimentId()
        {
            return experimentId;
        }

        public Date getExpirationDate()
        {
            return new Date(expirationDate.getTime());
        }

        public String getProjectName()
        {
            return projectName;
        }

        public Id getUniqueId()
        {
            return uniqueId;
        }

        public Map getVariables()
        {
            return variables;
        }

        public long getVariationId()
        {
            return variationId;
        }

        public String getVariationName()
        {
            return variationName;
        }

        public void setAllocationSource(AllocationSource allocationsource)
        {
            source = allocationsource;
        }

        public Builder setApplicationKey(String s)
        {
            if (s != null)
            {
                applicationKey = s;
            }
            return this;
        }

        public Builder setExperimentId(long l)
        {
            experimentId = l;
            return this;
        }

        public Builder setExpirationDate(Date date)
        {
            if (date != null)
            {
                expirationDate = new Date(date.getTime());
            }
            return this;
        }

        public Builder setProjectName(String s)
        {
            if (s != null)
            {
                projectName = s;
            }
            return this;
        }

        public Builder setUniqueId(Id id)
        {
            if (id != null)
            {
                uniqueId = id;
            }
            return this;
        }

        public Builder setVariables(Map map)
        {
            if (map != null)
            {
                variables = new ConcurrentHashMap(map);
            }
            return this;
        }

        public Builder setVariationId(long l)
        {
            variationId = l;
            return this;
        }

        public Builder setVariationName(String s)
        {
            if (s != null)
            {
                variationName = s;
            }
            return this;
        }

        public Builder()
        {
            projectName = "";
            applicationKey = "";
            experimentId = 0L;
            variationId = 0L;
            variationName = "DEFAULT";
            uniqueId = Id.getEmptyId();
            variables = new ConcurrentHashMap();
            expirationDate = new Date(0L);
            appliedDate = new Date(0L);
            source = AllocationSource.DEFAULT;
        }
    }


    public static final DefaultVariation NULL_VARIATION = new DefaultVariation();
    private static final Logger logger = Logger.getLogger(com/amazon/insights/abtest/DefaultVariation);
    private String applicationKey;
    private long experimentId;
    private Date expirationDate;
    private String projectName;
    private AllocationSource source;
    private Id uniqueId;
    private Map variables;
    private long variationId;
    private String variationName;

    DefaultVariation()
    {
        this((new Builder()).setVariationName("DEFAULT"));
    }

    DefaultVariation(Builder builder)
    {
        uniqueId = Id.getEmptyId();
        uniqueId = builder.getUniqueId();
        applicationKey = builder.getApplicationKey();
        experimentId = builder.getExperimentId();
        projectName = builder.getProjectName();
        variationId = builder.getVariationId();
        variationName = builder.getVariationName();
        expirationDate = builder.getExpirationDate();
        variables = Collections.unmodifiableMap(builder.getVariables());
        source = builder.getAllocationSource();
    }

    public AllocationSource getAllocationSource()
    {
        return source;
    }

    public String getApplicationKey()
    {
        return applicationKey;
    }

    public long getExperimentId()
    {
        return experimentId;
    }

    public String getName()
    {
        if (variationName == null)
        {
            return "DEFAULT";
        } else
        {
            return variationName.toUpperCase();
        }
    }

    public String getProjectName()
    {
        return projectName;
    }

    public Id getUniqueId()
    {
        return uniqueId;
    }

    public boolean getVariableAsBoolean(String s, boolean flag)
    {
        try
        {
            if (variables.containsKey(s))
            {
                return Boolean.parseBoolean((String)variables.get(s));
            }
            logger.devw((new StringBuilder()).append("Variable '").append(s).append("' does not exist in the variation. Returning default value").toString());
        }
        catch (Exception exception)
        {
            logger.devw((new StringBuilder()).append("Variable '").append(s).append("' can not be translated to a boolean. value is: ").append((String)variables.get(s)).toString());
            logger.i("Variable could not be translated to a boolean", exception);
            return flag;
        }
        return flag;
    }

    public String getVariableAsString(String s, String s1)
    {
        if (variables.containsKey(s))
        {
            return (String)variables.get(s);
        } else
        {
            logger.devw((new StringBuilder()).append("Variable '").append(s).append("' does not exist in the variation. Returning default value").toString());
            return s1;
        }
    }

    public long getVariationId()
    {
        return variationId;
    }

    public boolean isDefault()
    {
        return variationName.equals("DEFAULT");
    }

    public boolean isExpired()
    {
        return expirationDate.before(new Date(System.currentTimeMillis()));
    }

    public JSONObject toJSONObject()
    {
        Object obj;
        JSONArray jsonarray;
        obj = new JSONObject();
        try
        {
            ((JSONObject) (obj)).put("applicationKey", getApplicationKey());
            ((JSONObject) (obj)).put("variationId", getVariationId());
            ((JSONObject) (obj)).put("experimentId", getExperimentId());
            ((JSONObject) (obj)).put("projectName", getProjectName());
            ((JSONObject) (obj)).put("uniqueId", getUniqueId().getValue());
            ((JSONObject) (obj)).put("expirationDate", expirationDate.getTime());
            ((JSONObject) (obj)).put("variationName", getName());
            jsonarray = new JSONArray();
            JSONObject jsonobject;
            for (Iterator iterator = variables.entrySet().iterator(); iterator.hasNext(); jsonarray.put(jsonobject))
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                jsonobject = new JSONObject();
                jsonobject.put("name", entry.getKey());
                jsonobject.put("value", entry.getValue());
            }

        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            logger.e("Failed to translate the variation to json", ((Throwable) (obj)));
            return null;
        }
        ((JSONObject) (obj)).put("variables", jsonarray);
        return ((JSONObject) (obj));
    }

    public String toString()
    {
        JSONObject jsonobject = toJSONObject();
        if (jsonobject != null)
        {
            try
            {
                return jsonobject.toString(4);
            }
            catch (JSONException jsonexception)
            {
                return jsonobject.toString();
            }
        } else
        {
            return "Failed to convert Variation to String";
        }
    }

}
