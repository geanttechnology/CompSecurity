// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.api;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.edisonwang.android.slog.SLog;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

// Referenced classes of package co.vine.android.api:
//            VineEntity, VineParsers, VineUploadParsers, VineRecipient

public class VineUpload
    implements Parcelable
{
    public static class PostInfo
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

        public static PostInfo fromJsonString(String s)
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

        public PostInfo(String s)
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

        public PostInfo(String s, boolean flag, boolean flag1, long l, ArrayList arraylist, String s1, 
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


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public VineUpload createFromParcel(Parcel parcel)
        {
            return new VineUpload(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public VineUpload[] newArray(int i)
        {
            return new VineUpload[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public String captchaUrl;
    public long conversationRowId;
    public String hash;
    public long id;
    public boolean isPrivate;
    public long mergedMessageId;
    public String path;
    public String postInfo;
    public String reference;
    public int status;
    public String thumbnailPath;
    public String thumbnailUrl;
    public long uploadTime;
    public String videoUrl;

    public VineUpload()
    {
        status = 0;
    }

    public VineUpload(Parcel parcel)
    {
        status = parcel.readInt();
        boolean flag;
        if (parcel.readInt() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isPrivate = flag;
        id = parcel.readLong();
        uploadTime = parcel.readLong();
        conversationRowId = parcel.readLong();
        path = parcel.readString();
        hash = parcel.readString();
        postInfo = parcel.readString();
        thumbnailPath = parcel.readString();
        thumbnailUrl = parcel.readString();
        reference = parcel.readString();
        captchaUrl = parcel.readString();
        mergedMessageId = parcel.readLong();
        videoUrl = parcel.readString();
    }

    public VineUpload(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, int i, String s8, boolean flag, long l, long l1)
    {
        path = s;
        hash = s1;
        postInfo = s2;
        videoUrl = s3;
        thumbnailPath = s4;
        thumbnailUrl = s5;
        reference = s7;
        status = i;
        isPrivate = flag;
        conversationRowId = l;
        if (!TextUtils.isEmpty(s6))
        {
            uploadTime = Long.parseLong(s6);
        } else
        {
            uploadTime = 0L;
        }
        captchaUrl = s8;
        mergedMessageId = l1;
    }

    public static VineUpload fromCursor(String s, Cursor cursor)
    {
        co/vine/android/api/VineUpload;
        JVM INSTR monitorenter ;
        String s1;
        String s2;
        String s3;
        String s4;
        String s5;
        String s6;
        String s7;
        int i;
        s1 = cursor.getString(2);
        s2 = cursor.getString(4);
        s3 = cursor.getString(5);
        s4 = cursor.getString(6);
        s5 = cursor.getString(7);
        s6 = cursor.getString(8);
        s7 = cursor.getString(11);
        i = cursor.getInt(3);
        long l;
        boolean flag;
        if (cursor.getInt(9) > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        l = cursor.getLong(10);
        s = new VineUpload(s, s1, s2, s3, s4, s5, s6, s7, i, cursor.getString(13), flag, l, cursor.getLong(15));
        co/vine/android/api/VineUpload;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    public int describeContents()
    {
        return 0;
    }

    public PostInfo getPostInfo()
    {
        SLog.d("Post info: {}.", postInfo);
        if (TextUtils.isEmpty(postInfo))
        {
            return null;
        } else
        {
            return PostInfo.fromJsonString(postInfo);
        }
    }

    public String[] getUris()
    {
        return (new String[] {
            videoUrl, thumbnailUrl
        });
    }

    public boolean isExpired()
    {
        return System.currentTimeMillis() - uploadTime > 0x5265c00L;
    }

    public void setCaptchaUrl(String s)
    {
        captchaUrl = s;
    }

    public void setUris(String as[])
    {
        videoUrl = as[0];
        thumbnailUrl = as[1];
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(status);
        if (isPrivate)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeLong(id);
        parcel.writeLong(uploadTime);
        parcel.writeLong(conversationRowId);
        parcel.writeString(path);
        parcel.writeString(hash);
        parcel.writeString(postInfo);
        parcel.writeString(thumbnailPath);
        parcel.writeString(thumbnailUrl);
        parcel.writeString(reference);
        parcel.writeString(captchaUrl);
        parcel.writeLong(mergedMessageId);
        parcel.writeString(videoUrl);
    }

}
