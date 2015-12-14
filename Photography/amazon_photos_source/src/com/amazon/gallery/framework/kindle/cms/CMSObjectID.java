// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.cms;

import com.amazon.gallery.framework.model.ObjectID;
import java.util.StringTokenizer;

public class CMSObjectID
{

    private final String albumId;
    private final String parentAlbumId;

    private CMSObjectID(String s, String s1)
    {
        albumId = s;
        parentAlbumId = s1;
    }

    public static CMSObjectID getCMSItemID(ObjectID objectid)
    {
        return new CMSObjectID(objectid.toString(), ObjectID.getRoot().toString());
    }

    public static CMSObjectID getCMSSimilarItemID(ObjectID objectid, ObjectID objectid1)
    {
        return new CMSObjectID(objectid.toString(), objectid1.toString());
    }

    public static CMSObjectID parse(String s)
    {
        StringTokenizer stringtokenizer = new StringTokenizer(s, "@");
        if (stringtokenizer.countTokens() > 1)
        {
            String s1 = stringtokenizer.nextToken();
            s = ObjectID.getRoot().toString();
            if (stringtokenizer.hasMoreElements())
            {
                s = stringtokenizer.nextToken();
            }
            return new CMSObjectID(s1, s);
        } else
        {
            return null;
        }
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
        obj = (CMSObjectID)obj;
        if (albumId == null)
        {
            if (((CMSObjectID) (obj)).albumId != null)
            {
                return false;
            }
        } else
        if (!albumId.equals(((CMSObjectID) (obj)).albumId))
        {
            return false;
        }
        if (parentAlbumId != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((CMSObjectID) (obj)).parentAlbumId == null) goto _L1; else goto _L3
_L3:
        return false;
        if (parentAlbumId.equals(((CMSObjectID) (obj)).parentAlbumId)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public String getAlbumId()
    {
        return albumId;
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        if (albumId == null)
        {
            i = 0;
        } else
        {
            i = albumId.hashCode();
        }
        if (parentAlbumId != null)
        {
            j = parentAlbumId.hashCode();
        }
        return (i + 31) * 31 + j;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(albumId).append("@");
        stringbuilder.append(parentAlbumId);
        return stringbuilder.toString();
    }
}
