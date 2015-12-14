// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.deserializer;

import com.amazon.clouddrive.model.VideoProperties;
import java.io.IOException;
import org.codehaus.jackson.JsonParser;

// Referenced classes of package com.amazon.clouddrive.model.deserializer:
//            JsonFieldDeserializer, VideoPropertiesDeserializer, SimpleDeserializers

static class 
    implements JsonFieldDeserializer
{

    public boolean handleField(JsonParser jsonparser, String s, VideoProperties videoproperties)
        throws IOException
    {
        if ("title".equals(s))
        {
            videoproperties.setTitle(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("bitrate".equals(s))
        {
            videoproperties.setBitrate(SimpleDeserializers.deserializeDouble(jsonparser));
            return true;
        }
        if ("videoFrameRate".equals(s))
        {
            videoproperties.setVideoFrameRate(SimpleDeserializers.deserializeDouble(jsonparser));
            return true;
        }
        if ("creationDate".equals(s))
        {
            videoproperties.setCreationDate(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("model".equals(s))
        {
            videoproperties.setModel(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("videoBitrate".equals(s))
        {
            videoproperties.setVideoBitrate(SimpleDeserializers.deserializeDouble(jsonparser));
            return true;
        }
        if ("audioCodec".equals(s))
        {
            videoproperties.setAudioCodec(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("rotate".equals(s))
        {
            videoproperties.setRotate(SimpleDeserializers.deserializeInteger(jsonparser));
            return true;
        }
        if ("duration".equals(s))
        {
            videoproperties.setDuration(SimpleDeserializers.deserializeDouble(jsonparser));
            return true;
        }
        if ("encoder".equals(s))
        {
            videoproperties.setEncoder(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("location".equals(s))
        {
            videoproperties.setLocation(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("audioBitrate".equals(s))
        {
            videoproperties.setAudioBitrate(SimpleDeserializers.deserializeDouble(jsonparser));
            return true;
        }
        if ("audioSampleRate".equals(s))
        {
            videoproperties.setAudioSampleRate(SimpleDeserializers.deserializeDouble(jsonparser));
            return true;
        }
        if ("make".equals(s))
        {
            videoproperties.setMake(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("videoCodec".equals(s))
        {
            videoproperties.setVideoCodec(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("height".equals(s))
        {
            videoproperties.setHeight(SimpleDeserializers.deserializeInteger(jsonparser));
            return true;
        }
        if ("audioChannels".equals(s))
        {
            videoproperties.setAudioChannels(SimpleDeserializers.deserializeInteger(jsonparser));
            return true;
        }
        if ("width".equals(s))
        {
            videoproperties.setWidth(SimpleDeserializers.deserializeInteger(jsonparser));
            return true;
        }
        if ("audioChannelLayout".equals(s))
        {
            videoproperties.setAudioChannelLayout(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        } else
        {
            return false;
        }
    }

    public volatile boolean handleField(JsonParser jsonparser, String s, Object obj)
        throws IOException
    {
        return handleField(jsonparser, s, (VideoProperties)obj);
    }

    ()
    {
    }
}
