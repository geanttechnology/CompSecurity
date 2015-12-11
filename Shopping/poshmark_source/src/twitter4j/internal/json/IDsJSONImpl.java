// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package twitter4j.internal.json;

import java.util.Arrays;
import twitter4j.IDs;
import twitter4j.TwitterException;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.org.json.JSONArray;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;

// Referenced classes of package twitter4j.internal.json:
//            TwitterResponseImpl, DataObjectFactoryUtil, z_T4JInternalParseUtil

final class IDsJSONImpl extends TwitterResponseImpl
    implements IDs
{

    private static final long serialVersionUID = 0xa49d493b84decd47L;
    private long ids[];
    private long nextCursor;
    private long previousCursor;

    IDsJSONImpl(String s)
        throws TwitterException
    {
        previousCursor = -1L;
        nextCursor = -1L;
        init(s);
    }

    IDsJSONImpl(HttpResponse httpresponse, Configuration configuration)
        throws TwitterException
    {
        super(httpresponse);
        previousCursor = -1L;
        nextCursor = -1L;
        httpresponse = httpresponse.asString();
        init(httpresponse);
        if (configuration.isJSONStoreEnabled())
        {
            DataObjectFactoryUtil.clearThreadLocalMap();
            DataObjectFactoryUtil.registerJSONObject(this, httpresponse);
        }
    }

    private void init(String s)
        throws TwitterException
    {
        JSONArray jsonarray;
        if (!s.startsWith("{"))
        {
            break MISSING_BLOCK_LABEL_130;
        }
        s = new JSONObject(s);
        jsonarray = s.getJSONArray("ids");
        ids = new long[jsonarray.length()];
        int i = 0;
_L1:
        NumberFormatException numberformatexception;
        int j;
        try
        {
            j = jsonarray.length();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new TwitterException(s);
        }
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_109;
        }
        ids[i] = Long.parseLong(jsonarray.getString(i));
        i++;
          goto _L1
        numberformatexception;
        throw new TwitterException((new StringBuilder()).append("Twitter API returned malformed response: ").append(s).toString(), numberformatexception);
        previousCursor = z_T4JInternalParseUtil.getLong("previous_cursor", s);
        nextCursor = z_T4JInternalParseUtil.getLong("next_cursor", s);
        return;
        s = new JSONArray(s);
        ids = new long[s.length()];
        i = 0;
_L2:
        int k = s.length();
        if (i >= k)
        {
            break MISSING_BLOCK_LABEL_213;
        }
        ids[i] = Long.parseLong(s.getString(i));
        i++;
          goto _L2
        NumberFormatException numberformatexception1;
        numberformatexception1;
        throw new TwitterException((new StringBuilder()).append("Twitter API returned malformed response: ").append(s).toString(), numberformatexception1);
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof IDs))
            {
                return false;
            }
            obj = (IDs)obj;
            if (!Arrays.equals(ids, ((IDs) (obj)).getIDs()))
            {
                return false;
            }
        }
        return true;
    }

    public long[] getIDs()
    {
        return ids;
    }

    public long getNextCursor()
    {
        return nextCursor;
    }

    public long getPreviousCursor()
    {
        return previousCursor;
    }

    public boolean hasNext()
    {
        return 0L != nextCursor;
    }

    public boolean hasPrevious()
    {
        return 0L != previousCursor;
    }

    public int hashCode()
    {
        if (ids != null)
        {
            return Arrays.hashCode(ids);
        } else
        {
            return 0;
        }
    }

    public String toString()
    {
        return (new StringBuilder()).append("IDsJSONImpl{ids=").append(Arrays.toString(ids)).append(", previousCursor=").append(previousCursor).append(", nextCursor=").append(nextCursor).append('}').toString();
    }
}
