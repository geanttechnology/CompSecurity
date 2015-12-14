// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.deduplicate;

import android.util.Base64;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaType;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilenameIdEmbedUtils
{

    public static final Pattern ADD_ID_SUFFIX_PATTERN = Pattern.compile("(-[0-9]*)?\\.mp4$");
    public static final Pattern CUT_TMP_SUFFIX_PATTERN = Pattern.compile("(-[0-9]*)?\\.tmp$");

    public static ObjectID extractParentObjectId(String s)
    {
        int i = s.lastIndexOf(".");
        if (i != -1)
        {
            if ((s = s.substring(0, i).split("_")).length >= 2 && s[s.length - 2].equals("ID") && (s = Base64.decode(s[s.length - 1], 10)).length == 16)
            {
                s = ByteBuffer.wrap(s);
                return new ObjectID(s.getLong(), s.getLong());
            }
        }
        return null;
    }

    public static File getFinalFile(File file, MediaItem mediaitem)
    {
        file = file.getAbsolutePath();
        String s = CUT_TMP_SUFFIX_PATTERN.matcher(file).replaceAll("");
        file = s;
        if (mediaitem != null)
        {
            file = s;
            if (mediaitem.getType() == MediaType.VIDEO)
            {
                file = ByteBuffer.allocate(16).putLong(mediaitem.getObjectId().getMostSignificantBits()).putLong(mediaitem.getObjectId().getLeastSignificantBits()).array();
                file = ADD_ID_SUFFIX_PATTERN.matcher(s).replaceAll((new StringBuilder()).append("_ID_").append(Base64.encodeToString(file, 10)).append(".mp4").toString());
            }
        }
        return new File(file);
    }

}
