// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.serializer;

import com.amazon.clouddrive.model.ImageProperties;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;

// Referenced classes of package com.amazon.clouddrive.model.serializer:
//            ImagePropertiesSerializer, SimpleSerializers

static class 
{

    public void serializeFields(ImageProperties imageproperties, JsonGenerator jsongenerator)
        throws IOException
    {
        jsongenerator.writeFieldName("yResolution");
        SimpleSerializers.serializeString(imageproperties.getYResolution(), jsongenerator);
        jsongenerator.writeFieldName("dateTimeDigitized");
        SimpleSerializers.serializeString(imageproperties.getDateTimeDigitized(), jsongenerator);
        jsongenerator.writeFieldName("whiteBalance");
        SimpleSerializers.serializeString(imageproperties.getWhiteBalance(), jsongenerator);
        jsongenerator.writeFieldName("width");
        SimpleSerializers.serializeInteger(imageproperties.getWidth(), jsongenerator);
        jsongenerator.writeFieldName("focalLength");
        SimpleSerializers.serializeString(imageproperties.getFocalLength(), jsongenerator);
        jsongenerator.writeFieldName("meteringMode");
        SimpleSerializers.serializeString(imageproperties.getMeteringMode(), jsongenerator);
        jsongenerator.writeFieldName("software");
        SimpleSerializers.serializeString(imageproperties.getSoftware(), jsongenerator);
        jsongenerator.writeFieldName("isoSpeedRatings");
        SimpleSerializers.serializeString(imageproperties.getIsoSpeedRatings(), jsongenerator);
        jsongenerator.writeFieldName("orientation");
        SimpleSerializers.serializeString(imageproperties.getOrientation(), jsongenerator);
        jsongenerator.writeFieldName("colorSpace");
        SimpleSerializers.serializeString(imageproperties.getColorSpace(), jsongenerator);
        jsongenerator.writeFieldName("dateTime");
        SimpleSerializers.serializeString(imageproperties.getDateTime(), jsongenerator);
        jsongenerator.writeFieldName("sharpness");
        SimpleSerializers.serializeString(imageproperties.getSharpness(), jsongenerator);
        jsongenerator.writeFieldName("flash");
        SimpleSerializers.serializeString(imageproperties.getFlash(), jsongenerator);
        jsongenerator.writeFieldName("location");
        SimpleSerializers.serializeString(imageproperties.getLocation(), jsongenerator);
        jsongenerator.writeFieldName("exposureMode");
        SimpleSerializers.serializeString(imageproperties.getExposureMode(), jsongenerator);
        jsongenerator.writeFieldName("dateTimeOriginal");
        SimpleSerializers.serializeString(imageproperties.getDateTimeOriginal(), jsongenerator);
        jsongenerator.writeFieldName("model");
        SimpleSerializers.serializeString(imageproperties.getModel(), jsongenerator);
        jsongenerator.writeFieldName("make");
        SimpleSerializers.serializeString(imageproperties.getMake(), jsongenerator);
        jsongenerator.writeFieldName("exposureProgram");
        SimpleSerializers.serializeString(imageproperties.getExposureProgram(), jsongenerator);
        jsongenerator.writeFieldName("sensingMethod");
        SimpleSerializers.serializeString(imageproperties.getSensingMethod(), jsongenerator);
        jsongenerator.writeFieldName("xResolution");
        SimpleSerializers.serializeString(imageproperties.getXResolution(), jsongenerator);
        jsongenerator.writeFieldName("gpsTimeStamp");
        SimpleSerializers.serializeString(imageproperties.getGpsTimeStamp(), jsongenerator);
        jsongenerator.writeFieldName("apertureValue");
        SimpleSerializers.serializeString(imageproperties.getApertureValue(), jsongenerator);
        jsongenerator.writeFieldName("exposureTime");
        SimpleSerializers.serializeString(imageproperties.getExposureTime(), jsongenerator);
        jsongenerator.writeFieldName("resolutionUnit");
        SimpleSerializers.serializeString(imageproperties.getResolutionUnit(), jsongenerator);
        jsongenerator.writeFieldName("height");
        SimpleSerializers.serializeInteger(imageproperties.getHeight(), jsongenerator);
        jsongenerator.writeFieldName("captureMode");
        SimpleSerializers.serializeString(imageproperties.getCaptureMode(), jsongenerator);
    }

    ()
    {
    }
}
