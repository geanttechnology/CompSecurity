// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.cds;

import android.content.ContentProviderClient;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.mixtape.utils.ISO8601;
import com.amazon.mixtape.utils.IdUtils;
import java.text.ParseException;
import java.util.UUID;

public class CDSUtil
{
    public static class TwoPartProgress
    {

        private int currentProgress;
        private final double ratio;

        public int getProgress()
        {
            return currentProgress;
        }

        public void setCurrentProgress(int i)
        {
            currentProgress = i;
        }

        public void update(double d, Part part)
        {
            int i = 0;
            static class _cls1
            {

                static final int $SwitchMap$com$amazon$gallery$thor$cds$CDSUtil$TwoPartProgress$Part[];

                static 
                {
                    $SwitchMap$com$amazon$gallery$thor$cds$CDSUtil$TwoPartProgress$Part = new int[TwoPartProgress.Part.values().length];
                    try
                    {
                        $SwitchMap$com$amazon$gallery$thor$cds$CDSUtil$TwoPartProgress$Part[TwoPartProgress.Part.ONE.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$amazon$gallery$thor$cds$CDSUtil$TwoPartProgress$Part[TwoPartProgress.Part.TWO.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            _cls1..SwitchMap.com.amazon.gallery.thor.cds.CDSUtil.TwoPartProgress.Part[part.ordinal()];
            JVM INSTR tableswitch 1 2: default 32
        //                       1 58
        //                       2 70;
               goto _L1 _L2 _L3
_L1:
            i -= currentProgress;
            if (i > 0)
            {
                currentProgress = currentProgress + i;
            }
            return;
_L2:
            i = (int)(ratio * d);
            continue; /* Loop/switch isn't completed */
_L3:
            i = (int)((double)(int)((1.0D - ratio) * d) + 100D * ratio);
            if (true) goto _L1; else goto _L4
_L4:
        }

        public TwoPartProgress(double d)
        {
            currentProgress = 0;
            ratio = d;
        }
    }

    public static final class TwoPartProgress.Part extends Enum
    {

        private static final TwoPartProgress.Part $VALUES[];
        public static final TwoPartProgress.Part ONE;
        public static final TwoPartProgress.Part TWO;

        public static TwoPartProgress.Part valueOf(String s)
        {
            return (TwoPartProgress.Part)Enum.valueOf(com/amazon/gallery/thor/cds/CDSUtil$TwoPartProgress$Part, s);
        }

        public static TwoPartProgress.Part[] values()
        {
            return (TwoPartProgress.Part[])$VALUES.clone();
        }

        static 
        {
            ONE = new TwoPartProgress.Part("ONE", 0);
            TWO = new TwoPartProgress.Part("TWO", 1);
            $VALUES = (new TwoPartProgress.Part[] {
                ONE, TWO
            });
        }

        private TwoPartProgress.Part(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String TAG = com/amazon/gallery/thor/cds/CDSUtil.getName();

    public CDSUtil()
    {
    }

    public static void closeCursorQuietly(Cursor cursor)
    {
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_10;
        }
        cursor.close();
        return;
        cursor;
    }

    public static String getAccountState(ContentProviderClient contentproviderclient, Uri uri)
    {
        ContentProviderClient contentproviderclient1;
        ContentProviderClient contentproviderclient2;
        contentproviderclient2 = null;
        contentproviderclient1 = null;
        contentproviderclient = contentproviderclient.query(uri, null, null, null, "_id DESC");
        contentproviderclient1 = contentproviderclient;
        contentproviderclient2 = contentproviderclient;
        if (!contentproviderclient.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_53;
        }
        contentproviderclient1 = contentproviderclient;
        contentproviderclient2 = contentproviderclient;
        uri = contentproviderclient.getString(contentproviderclient.getColumnIndex("state"));
        closeCursorQuietly(contentproviderclient);
        return uri;
        closeCursorQuietly(contentproviderclient);
_L2:
        return null;
        contentproviderclient;
        contentproviderclient2 = contentproviderclient1;
        GLogger.ex(TAG, "Could get not account state", contentproviderclient);
        closeCursorQuietly(contentproviderclient1);
        if (true) goto _L2; else goto _L1
_L1:
        contentproviderclient;
        closeCursorQuietly(contentproviderclient2);
        throw contentproviderclient;
    }

    public static ObjectID getObjectId(String s)
    {
        s = IdUtils.nodeIdToUUID(s);
        return new ObjectID(s.getMostSignificantBits(), s.getLeastSignificantBits());
    }

    public static long getUnixTimestamp(String s)
    {
        long l = 0L;
        if (s != null)
        {
            try
            {
                l = ISO8601.getUnixTimestampFromString(s);
            }
            catch (ParseException parseexception)
            {
                GLogger.ex(TAG, (new StringBuilder()).append("Encountered an exception parsing the date ").append(s).toString(), parseexception);
                return 0L;
            }
        }
        return l;
    }

}
