// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.api;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class VineRepost
    implements Externalizable
{

    private static final long serialVersionUID = 0xa8cb4c033d727527L;
    public String avatarUrl;
    public String description;
    public String location;
    public long postId;
    public int priv;
    public long repostId;
    public int unflaggable;
    public long userId;
    public String username;
    public int verified;

    public VineRepost()
    {
    }

    public VineRepost(String s, String s1, String s2, String s3, long l, long l1, long l2, int i, int j, int k)
    {
        username = s;
        avatarUrl = s1;
        location = s2;
        description = s3;
        userId = l;
        postId = l1;
        repostId = l2;
        verified = i;
        priv = j;
        unflaggable = k;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (VineRepost)obj;
            if (postId != ((VineRepost) (obj)).postId)
            {
                return false;
            }
            if (priv != ((VineRepost) (obj)).priv)
            {
                return false;
            }
            if (repostId != ((VineRepost) (obj)).repostId)
            {
                return false;
            }
            if (unflaggable != ((VineRepost) (obj)).unflaggable)
            {
                return false;
            }
            if (userId != ((VineRepost) (obj)).userId)
            {
                return false;
            }
            if (verified != ((VineRepost) (obj)).verified)
            {
                return false;
            }
            if (avatarUrl == null ? ((VineRepost) (obj)).avatarUrl != null : !avatarUrl.equals(((VineRepost) (obj)).avatarUrl))
            {
                return false;
            }
            if (description == null ? ((VineRepost) (obj)).description != null : !description.equals(((VineRepost) (obj)).description))
            {
                return false;
            }
            if (location == null ? ((VineRepost) (obj)).location != null : !location.equals(((VineRepost) (obj)).location))
            {
                return false;
            }
            if (username == null ? ((VineRepost) (obj)).username != null : !username.equals(((VineRepost) (obj)).username))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        int l = 0;
        int i;
        int j;
        int k;
        if (username != null)
        {
            i = username.hashCode();
        } else
        {
            i = 0;
        }
        if (avatarUrl != null)
        {
            j = avatarUrl.hashCode();
        } else
        {
            j = 0;
        }
        if (location != null)
        {
            k = location.hashCode();
        } else
        {
            k = 0;
        }
        if (description != null)
        {
            l = description.hashCode();
        }
        return ((((((((i * 31 + j) * 31 + k) * 31 + l) * 31 + (int)(userId ^ userId >>> 32)) * 31 + (int)(postId ^ postId >>> 32)) * 31 + (int)(repostId ^ repostId >>> 32)) * 31 + verified) * 31 + priv) * 31 + unflaggable;
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        username = (String)objectinput.readObject();
        avatarUrl = (String)objectinput.readObject();
        location = (String)objectinput.readObject();
        description = (String)objectinput.readObject();
        userId = objectinput.readLong();
        postId = objectinput.readLong();
        repostId = objectinput.readLong();
        verified = objectinput.readInt();
        priv = objectinput.readInt();
        unflaggable = objectinput.readInt();
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        objectoutput.writeObject(username);
        objectoutput.writeObject(avatarUrl);
        objectoutput.writeObject(location);
        objectoutput.writeObject(description);
        objectoutput.writeLong(userId);
        objectoutput.writeLong(postId);
        objectoutput.writeLong(repostId);
        objectoutput.writeInt(verified);
        objectoutput.writeInt(priv);
        objectoutput.writeInt(unflaggable);
    }
}
