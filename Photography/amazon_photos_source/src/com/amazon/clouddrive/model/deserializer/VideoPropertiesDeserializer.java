// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.deserializer;

import com.amazon.clouddrive.model.VideoProperties;
import java.io.IOException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

// Referenced classes of package com.amazon.clouddrive.model.deserializer:
//            JsonDeserializer, JsonFieldDeserializer, SimpleDeserializers

public class VideoPropertiesDeserializer
    implements JsonDeserializer
{
    static class VideoPropertiesFieldDeserializer
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

        VideoPropertiesFieldDeserializer()
        {
        }
    }


    public static final JsonDeserializer INSTANCE = new VideoPropertiesDeserializer();
    private final VideoPropertiesFieldDeserializer mFieldHandler = new VideoPropertiesFieldDeserializer();

    private VideoPropertiesDeserializer()
    {
    }

    public VideoProperties deserialize(JsonParser jsonparser)
        throws IOException
    {
        JsonToken jsontoken = jsonparser.getCurrentToken();
        if (jsontoken != JsonToken.VALUE_NULL) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((VideoProperties) (obj));
_L2:
        if (jsontoken != JsonToken.START_OBJECT)
        {
            throw new JsonParseException((new StringBuilder()).append("Expected start of object, got ").append(jsontoken).toString(), jsonparser.getTokenLocation());
        }
        VideoProperties videoproperties = new VideoProperties();
        do
        {
            obj = videoproperties;
            if (jsonparser.nextToken() == JsonToken.END_OBJECT)
            {
                continue;
            }
            if (jsonparser.getCurrentToken() != JsonToken.FIELD_NAME)
            {
                throw new JsonParseException((new StringBuilder()).append("Expected field name, got ").append(jsontoken).toString(), jsonparser.getTokenLocation());
            }
            obj = jsonparser.getCurrentName();
            if (jsonparser.nextToken() == null)
            {
                throw new JsonParseException("Unexpected end of input", jsonparser.getTokenLocation());
            }
            if (!mFieldHandler.handleField(jsonparser, ((String) (obj)), videoproperties))
            {
                jsonparser.skipChildren();
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public volatile Object deserialize(JsonParser jsonparser)
        throws IOException
    {
        return deserialize(jsonparser);
    }

}
