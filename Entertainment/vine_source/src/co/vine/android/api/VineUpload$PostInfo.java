// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.api;

import android.text.TextUtils;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

// Referenced classes of package co.vine.android.api:
//            VineUpload, VineEntity, VineParsers, VineUploadParsers, 
//            VineRecipient

public static class sharedPostThumbUrl
{

    public final String caption;
    public long channelId;
    public long created;
    public final ArrayList entities;
    public final int maxLoops;
    public final String message;
    public final long postId;
    public boolean postToFacebook;
    public boolean postToTwitter;
    public ArrayList recipients;
    public final String sharedPostThumbUrl;
    public final String sharedPostVideoUrl;

    public static ArrayList entitiesToMaps(ArrayList arraylist)
    {
        ArrayList arraylist1 = new ArrayList();
        for (arraylist = arraylist.iterator(); arraylist.hasNext(); arraylist1.add(((VineEntity)arraylist.next()).toMap())) { }
        return arraylist1;
    }

    public static sharedPostThumbUrl fromJsonString(String s)
    {
        try
        {
            s = VineUploadParsers.parsePostInfo(VineParsers.createParser(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException("This should never happen.", s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException("This should never happen.", s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException("This should never happen.", s);
        }
        return s;
    }

    public static ArrayList recipientsToMaps(ArrayList arraylist)
    {
        ArrayList arraylist1 = new ArrayList();
        for (arraylist = arraylist.iterator(); arraylist.hasNext(); arraylist1.add(((VineRecipient)arraylist.next()).toMap())) { }
        return arraylist1;
    }

    private JsonNode toJson()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("description", caption);
        hashmap.put("postToTwitter", Boolean.valueOf(postToTwitter));
        hashmap.put("postToFacebook", Boolean.valueOf(postToFacebook));
        hashmap.put("channelId", Long.valueOf(channelId));
        hashmap.put("maxLoops", Integer.valueOf(maxLoops));
        if (!TextUtils.isEmpty(sharedPostVideoUrl))
        {
            hashmap.put("videoUrl", sharedPostVideoUrl);
        }
        if (!TextUtils.isEmpty(sharedPostThumbUrl))
        {
            hashmap.put("thumbUrl", sharedPostThumbUrl);
        }
        if (entities != null && !entities.isEmpty())
        {
            hashmap.put("entities", entitiesToMaps(entities));
        }
        if (recipients != null && !recipients.isEmpty())
        {
            hashmap.put("recipients", recipientsToMaps(recipients));
        }
        hashmap.put("message", message);
        hashmap.put("postId", Long.valueOf(postId));
        hashmap.put("created", Long.valueOf(created));
        return (new ObjectMapper()).valueToTree(hashmap);
    }

    public String toString()
    {
        return toJson().toString();
    }

    public gException(String s)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        caption = s1;
        entities = null;
        maxLoops = 0;
        postId = 0L;
        message = null;
        sharedPostThumbUrl = null;
        sharedPostVideoUrl = null;
    }

    public sharedPostVideoUrl(String s, boolean flag, boolean flag1, long l, ArrayList arraylist, String s1, 
            long l1, String s2, String s3, long l2, ArrayList arraylist1, 
            int i)
    {
        String s4 = s;
        if (s == null)
        {
            s4 = "";
        }
        caption = s4;
        postToTwitter = flag;
        postToFacebook = flag1;
        entities = arraylist;
        channelId = l;
        created = l2;
        message = s1;
        postId = l1;
        recipients = arraylist1;
        maxLoops = i;
        sharedPostVideoUrl = s2;
        sharedPostThumbUrl = s3;
    }
}
