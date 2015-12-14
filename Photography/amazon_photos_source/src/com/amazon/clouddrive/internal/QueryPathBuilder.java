// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.internal;

import com.amazon.clouddrive.model.PaginatedCloudDriveRequest;
import com.amazon.clouddrive.model.PostNodeRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class QueryPathBuilder
{

    private final StringBuilder mStringBuilder = new StringBuilder();

    QueryPathBuilder()
    {
    }

    void addParameter(String s, Boolean boolean1)
    {
        if (boolean1 != null)
        {
            addParameter(s, boolean1.toString());
        }
    }

    void addParameter(String s, Integer integer)
    {
        if (integer != null)
        {
            addParameter(s, integer.toString());
        }
    }

    void addParameter(String s, String s1)
    {
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        StringBuilder stringbuilder = mStringBuilder;
        char c;
        if (mStringBuilder.length() == 0)
        {
            c = '?';
        } else
        {
            c = '&';
        }
        stringbuilder.append(c);
        mStringBuilder.append(s).append('=').append(URLEncoder.encode(s1, "UTF-8"));
        return;
        s;
        throw new IllegalArgumentException((new StringBuilder()).append("Failed to encode ").append(s1).toString(), s);
    }

    String addQueryToPath(String s)
    {
        if (mStringBuilder.length() == 0)
        {
            return s;
        } else
        {
            return (new StringBuilder()).append(s).append(mStringBuilder.toString()).toString();
        }
    }

    void addRequestParameters(PaginatedCloudDriveRequest paginatedclouddriverequest)
    {
        addParameter("filters", paginatedclouddriverequest.getFilters());
        addParameter("fields", paginatedclouddriverequest.getFields());
        addParameter("startToken", paginatedclouddriverequest.getStartToken());
        addParameter("limit", paginatedclouddriverequest.getLimit());
        addParameter("sort", paginatedclouddriverequest.getSort());
        addParameter("offset", paginatedclouddriverequest.getOffset());
    }

    void addRequestParameters(PostNodeRequest postnoderequest)
    {
        addParameter("localId", postnoderequest.getLocalId());
    }

    void addUTF8Parameter(String s, String s1)
    {
        if (s1 != null)
        {
            StringBuilder stringbuilder = mStringBuilder;
            char c;
            if (mStringBuilder.length() == 0)
            {
                c = '?';
            } else
            {
                c = '&';
            }
            stringbuilder.append(c);
            mStringBuilder.append(s).append('=').append(s1);
        }
    }
}
