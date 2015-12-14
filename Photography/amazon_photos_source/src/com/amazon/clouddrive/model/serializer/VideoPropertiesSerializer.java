// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.serializer;

import com.amazon.clouddrive.model.VideoProperties;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;

// Referenced classes of package com.amazon.clouddrive.model.serializer:
//            JsonSerializer, SimpleSerializers

public class VideoPropertiesSerializer
    implements JsonSerializer
{
    static class VideoPropertiesFieldSerializer
    {

        public void serializeFields(VideoProperties videoproperties, JsonGenerator jsongenerator)
            throws IOException
        {
            jsongenerator.writeFieldName("title");
            SimpleSerializers.serializeString(videoproperties.getTitle(), jsongenerator);
            jsongenerator.writeFieldName("bitrate");
            SimpleSerializers.serializeDouble(videoproperties.getBitrate(), jsongenerator);
            jsongenerator.writeFieldName("videoFrameRate");
            SimpleSerializers.serializeDouble(videoproperties.getVideoFrameRate(), jsongenerator);
            jsongenerator.writeFieldName("creationDate");
            SimpleSerializers.serializeString(videoproperties.getCreationDate(), jsongenerator);
            jsongenerator.writeFieldName("model");
            SimpleSerializers.serializeString(videoproperties.getModel(), jsongenerator);
            jsongenerator.writeFieldName("videoBitrate");
            SimpleSerializers.serializeDouble(videoproperties.getVideoBitrate(), jsongenerator);
            jsongenerator.writeFieldName("audioCodec");
            SimpleSerializers.serializeString(videoproperties.getAudioCodec(), jsongenerator);
            jsongenerator.writeFieldName("rotate");
            SimpleSerializers.serializeInteger(videoproperties.getRotate(), jsongenerator);
            jsongenerator.writeFieldName("duration");
            SimpleSerializers.serializeDouble(videoproperties.getDuration(), jsongenerator);
            jsongenerator.writeFieldName("encoder");
            SimpleSerializers.serializeString(videoproperties.getEncoder(), jsongenerator);
            jsongenerator.writeFieldName("location");
            SimpleSerializers.serializeString(videoproperties.getLocation(), jsongenerator);
            jsongenerator.writeFieldName("audioBitrate");
            SimpleSerializers.serializeDouble(videoproperties.getAudioBitrate(), jsongenerator);
            jsongenerator.writeFieldName("audioSampleRate");
            SimpleSerializers.serializeDouble(videoproperties.getAudioSampleRate(), jsongenerator);
            jsongenerator.writeFieldName("make");
            SimpleSerializers.serializeString(videoproperties.getMake(), jsongenerator);
            jsongenerator.writeFieldName("videoCodec");
            SimpleSerializers.serializeString(videoproperties.getVideoCodec(), jsongenerator);
            jsongenerator.writeFieldName("height");
            SimpleSerializers.serializeInteger(videoproperties.getHeight(), jsongenerator);
            jsongenerator.writeFieldName("audioChannels");
            SimpleSerializers.serializeInteger(videoproperties.getAudioChannels(), jsongenerator);
            jsongenerator.writeFieldName("width");
            SimpleSerializers.serializeInteger(videoproperties.getWidth(), jsongenerator);
            jsongenerator.writeFieldName("audioChannelLayout");
            SimpleSerializers.serializeString(videoproperties.getAudioChannelLayout(), jsongenerator);
        }

        VideoPropertiesFieldSerializer()
        {
        }
    }


    public static final JsonSerializer INSTANCE = new VideoPropertiesSerializer();
    private final VideoPropertiesFieldSerializer mFieldSerializer = new VideoPropertiesFieldSerializer();

    private VideoPropertiesSerializer()
    {
    }

    public final void serialize(VideoProperties videoproperties, JsonGenerator jsongenerator)
        throws IOException
    {
        if (videoproperties == null)
        {
            jsongenerator.writeNull();
            return;
        } else
        {
            jsongenerator.writeStartObject();
            mFieldSerializer.serializeFields(videoproperties, jsongenerator);
            jsongenerator.writeEndObject();
            return;
        }
    }

    public volatile void serialize(Object obj, JsonGenerator jsongenerator)
        throws IOException
    {
        serialize((VideoProperties)obj, jsongenerator);
    }

}
