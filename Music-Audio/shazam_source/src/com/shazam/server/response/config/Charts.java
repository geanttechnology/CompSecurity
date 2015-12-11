// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.config;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Charts
    implements Serializable
{
    public static class Builder
    {

        private List chartList;

        public static Builder charts()
        {
            return new Builder();
        }

        public Charts build()
        {
            return new Charts(this, null);
        }

        public Builder withChartList(List list)
        {
            if (list != null)
            {
                chartList = list;
            }
            return this;
        }


        public Builder()
        {
            chartList = new ArrayList();
        }
    }


    private List chartList;

    private Charts()
    {
    }

    private Charts(Builder builder)
    {
        chartList = builder.chartList;
    }

    Charts(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public List getChartList()
    {
        if (chartList != null)
        {
            return chartList;
        } else
        {
            return Collections.emptyList();
        }
    }
}
