// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.deserializer;

import com.amazon.clouddrive.model.ImageProperties;
import java.io.IOException;
import org.codehaus.jackson.JsonParser;

// Referenced classes of package com.amazon.clouddrive.model.deserializer:
//            JsonFieldDeserializer, ImagePropertiesDeserializer, SimpleDeserializers

static class 
    implements JsonFieldDeserializer
{

    public boolean handleField(JsonParser jsonparser, String s, ImageProperties imageproperties)
        throws IOException
    {
        if ("yResolution".equals(s))
        {
            imageproperties.setYResolution(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("dateTimeDigitized".equals(s))
        {
            imageproperties.setDateTimeDigitized(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("whiteBalance".equals(s))
        {
            imageproperties.setWhiteBalance(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("width".equals(s))
        {
            imageproperties.setWidth(SimpleDeserializers.deserializeInteger(jsonparser));
            return true;
        }
        if ("focalLength".equals(s))
        {
            imageproperties.setFocalLength(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("meteringMode".equals(s))
        {
            imageproperties.setMeteringMode(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("software".equals(s))
        {
            imageproperties.setSoftware(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("isoSpeedRatings".equals(s))
        {
            imageproperties.setIsoSpeedRatings(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("orientation".equals(s))
        {
            imageproperties.setOrientation(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("colorSpace".equals(s))
        {
            imageproperties.setColorSpace(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("dateTime".equals(s))
        {
            imageproperties.setDateTime(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("sharpness".equals(s))
        {
            imageproperties.setSharpness(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("flash".equals(s))
        {
            imageproperties.setFlash(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("location".equals(s))
        {
            imageproperties.setLocation(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("exposureMode".equals(s))
        {
            imageproperties.setExposureMode(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("dateTimeOriginal".equals(s))
        {
            imageproperties.setDateTimeOriginal(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("model".equals(s))
        {
            imageproperties.setModel(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("make".equals(s))
        {
            imageproperties.setMake(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("exposureProgram".equals(s))
        {
            imageproperties.setExposureProgram(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("sensingMethod".equals(s))
        {
            imageproperties.setSensingMethod(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("xResolution".equals(s))
        {
            imageproperties.setXResolution(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("gpsTimeStamp".equals(s))
        {
            imageproperties.setGpsTimeStamp(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("apertureValue".equals(s))
        {
            imageproperties.setApertureValue(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("exposureTime".equals(s))
        {
            imageproperties.setExposureTime(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("resolutionUnit".equals(s))
        {
            imageproperties.setResolutionUnit(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("height".equals(s))
        {
            imageproperties.setHeight(SimpleDeserializers.deserializeInteger(jsonparser));
            return true;
        }
        if ("captureMode".equals(s))
        {
            imageproperties.setCaptureMode(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        } else
        {
            return false;
        }
    }

    public volatile boolean handleField(JsonParser jsonparser, String s, Object obj)
        throws IOException
    {
        return handleField(jsonparser, s, (ImageProperties)obj);
    }

    ()
    {
    }
}
