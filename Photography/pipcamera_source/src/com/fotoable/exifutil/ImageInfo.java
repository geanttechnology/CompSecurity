// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.exifutil;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.location.Address;
import android.net.Uri;
import android.util.Log;
import com.aviary.android.feather.library.media.ExifInterfaceWrapper;
import com.aviary.android.feather.library.utils.CameraUtils;
import com.crashlytics.android.Crashlytics;
import dw;
import dx;
import gd;
import java.io.IOException;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class ImageInfo
    implements Serializable
{

    private static final int INDEX_BUCKET_TITLE = 12;
    private static final int INDEX_CAPTION = 1;
    private static final int INDEX_DATA = 8;
    private static final int INDEX_LATITUDE = 3;
    private static final int INDEX_LONGITUDE = 4;
    private static final int INDEX_ORIENTATION = 9;
    private static final int INDEX_SIZE_ID = 11;
    public static final float INVALID_LATLNG = 0F;
    public static final String PROJECTION[] = {
        "_id", "title", "mime_type", "latitude", "longitude", "datetaken", "date_added", "date_modified", "_data", "orientation", 
        "bucket_id", "_size", "bucket_display_name"
    };
    private static final long serialVersionUID = 1L;
    private Address address;
    private double altitude;
    private String aperture;
    private String artist;
    private String brightness;
    private String bucketDisplayName;
    private String caption;
    private String copyright;
    private String dateTime;
    private String digitalZoom;
    private String distance;
    private int distanceRange;
    private int exposureMode;
    private int exposureProgram;
    private String exposureTime;
    private String filePath;
    private long fileSize;
    private int flash;
    private String focalLength;
    private int height;
    private String iso;
    public float latitude;
    private int lightSource;
    public float longitude;
    private String maker;
    private int meteringMode;
    private String model;
    public int rotation;
    private String software;
    private int whiteBalance;
    private int width;

    public ImageInfo()
    {
        rotation = 0;
        latitude = 0.0F;
        longitude = 0.0F;
        fileSize = 0L;
    }

    public ImageInfo(Context context, Uri uri)
    {
        rotation = 0;
        latitude = 0.0F;
        longitude = 0.0F;
        fileSize = 0L;
        String s = dw.a(context, uri);
        onLoadFromUri(context, uri);
        if (s != null)
        {
            onLoadExifData(s);
            onLoadImageSize(s, rotation);
        }
    }

    private String computeDistanceRangeType(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 2: // '\002'
            return "Close";

        case 3: // '\003'
            return "Distant";

        case 1: // '\001'
            return "Macro";
        }
    }

    private String computeExposureMode(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            return "Auto Exposure";

        case 2: // '\002'
            return "Auto Bracket";

        case 1: // '\001'
            return "Manual";
        }
    }

    private String computeExposureProgram(int i)
    {
        switch (i)
        {
        default:
            return "Custom";

        case 6: // '\006'
            return "Action";

        case 3: // '\003'
            return "Priority";

        case 5: // '\005'
            return "Creative";

        case 8: // '\b'
            return "Landscape";

        case 1: // '\001'
            return "Manual";

        case 2: // '\002'
            return "Normal";

        case 7: // '\007'
            return "Portrait";

        case 4: // '\004'
            return "Shutter Priority";
        }
    }

    private String computeFlash(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            return "No flash";

        case 1: // '\001'
            return "Flash fired";

        case 5: // '\005'
            return "Strobe return light not detected";

        case 7: // '\007'
            return "Strobe return light detected";

        case 9: // '\t'
            return "Compulsory flash";

        case 13: // '\r'
            return "Compulsory flash, light not detected";

        case 15: // '\017'
            return "Compulsory flash, light detected";

        case 16: // '\020'
            return "Flash not fired, compulsory flash";

        case 24: // '\030'
            return "Flash not fired, auto";

        case 25: // '\031'
            return "Flash fired, auto";

        case 29: // '\035'
            return "Flash fired, auto, light not detected";

        case 31: // '\037'
            return "Flash fired, auto, light detected";

        case 32: // ' '
            return "No flash function";

        case 65: // 'A'
            return "Flash fired, red-eye reduction";

        case 69: // 'E'
            return "Red-eye reduction, light not detected";

        case 71: // 'G'
            return "Red-eye reduction, light detected";

        case 73: // 'I'
            return "Compulsory flash, red-eye reduction";

        case 77: // 'M'
            return "Compulsory flash, red-eye reduction, light not detected";

        case 79: // 'O'
            return "Compulsory flash, red-eye reduction, light detected";

        case 89: // 'Y'
            return "Flash fired, auto, red-eye reduction";

        case 93: // ']'
            return "Flash fired, auto, light not detected, red-eye reduction";

        case 95: // '_'
            return "Flash fired, auto, light detected, red-eye reduction";
        }
    }

    private String computeLightSource(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 1: // '\001'
            return "Day light";

        case 2: // '\002'
            return "Fluorescent";

        case 3: // '\003'
            return "Tungsten";

        case 4: // '\004'
            return "Flash";

        case 9: // '\t'
            return "Fine weather";

        case 10: // '\n'
            return "Cloudy weather";

        case 11: // '\013'
            return "Shade";

        case 12: // '\f'
            return "Day light fluorescent";

        case 13: // '\r'
            return "Day white fluorescent";

        case 14: // '\016'
            return "Cool white";

        case 15: // '\017'
            return "White fluorescent";

        case 17: // '\021'
            return "Standard light A";

        case 18: // '\022'
            return "Standard light B";

        case 19: // '\023'
            return "Standard light C";

        case 20: // '\024'
            return "D55";

        case 21: // '\025'
            return "D65";

        case 22: // '\026'
            return "D75";

        case 23: // '\027'
            return "D50";

        case 24: // '\030'
            return "Tungsten";

        case 255: 
            return "Light source";
        }
    }

    private String computeMeteringMode(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 1: // '\001'
            return "Average";

        case 2: // '\002'
            return "Center weight average";

        case 4: // '\004'
            return "Multi spot";

        case 255: 
            return "Other";

        case 6: // '\006'
            return "Partial";

        case 5: // '\005'
            return "Pattern";

        case 3: // '\003'
            return "Spot";
        }
    }

    private String computeWhiteBalance(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            return "Auto";

        case 1: // '\001'
            return "Manual";
        }
    }

    public static String readableFileSize(long l)
    {
        if (l <= 0L)
        {
            return "0";
        } else
        {
            int i = (int)(Math.log10(l) / Math.log10(1024D));
            return (new StringBuilder()).append((new DecimalFormat("#,##0.#")).format((double)l / Math.pow(1024D, i))).append(" ").append((new String[] {
                "B", "KB", "MB", "GB", "TB"
            })[i]).toString();
        }
    }

    public String getAddressRepr()
    {
        if (address != null)
        {
            ArrayList arraylist = new ArrayList();
            if (address.getThoroughfare() != null)
            {
                arraylist.add(address.getThoroughfare());
            }
            if (address.getPostalCode() != null)
            {
                arraylist.add(address.getPostalCode());
            }
            if (address.getLocality() != null)
            {
                arraylist.add(address.getLocality());
            }
            if (address.getAdminArea() != null)
            {
                arraylist.add(address.getAdminArea());
            }
            if (address.getCountryCode() != null)
            {
                arraylist.add(address.getCountryCode());
            }
            return dx.a(arraylist, ", ");
        } else
        {
            return null;
        }
    }

    public String getDateTime()
    {
        return dateTime;
    }

    public int getHeight()
    {
        return height;
    }

    public List getInfo()
    {
        boolean flag = false;
        ArrayList arraylist = new ArrayList();
        NumberFormat numberformat = DecimalFormat.getNumberInstance();
        if (caption != null)
        {
            arraylist.add(new gd("Title", caption));
        }
        if (bucketDisplayName != null)
        {
            arraylist.add(new gd("Album", bucketDisplayName));
        }
        if (dateTime != null)
        {
            arraylist.add(new gd("Date Modified", dateTime));
        }
        if (width > 0 && height > 0)
        {
            arraylist.add(new gd("Dimension", (new StringBuilder()).append(width).append("x").append(height).append(" (").append(CameraUtils.a(width, height)).append("MP)").toString()));
        }
        Object obj = new gd("Address", "");
        float af[] = new float[2];
        float[] _tmp = af;
        af[0] = 0.0F;
        af[1] = 0.0F;
        getLatLong(af);
        if (af[0] != 0.0F)
        {
            gd.a(((gd) (obj)), af);
            gd.a(((gd) (obj)), (new StringBuilder()).append(af[0]).append(", ").append(af[1]).toString());
            if (address != null)
            {
                String s5 = getAddressRepr();
                if (s5 != null)
                {
                    gd.a(((gd) (obj)), s5);
                }
            }
            flag = true;
        }
        if (flag)
        {
            arraylist.add(obj);
        }
        if (altitude != -1D)
        {
            arraylist.add(new gd("Altitude", (new StringBuilder()).append(String.valueOf(altitude)).append(" mt").toString()));
        }
        if (rotation != 0)
        {
            arraylist.add(new gd("Orientation", String.valueOf(rotation)));
        }
        if (fileSize > 0L)
        {
            arraylist.add(new gd("Size", readableFileSize(fileSize)));
        }
        if (maker != null)
        {
            arraylist.add(new gd("Camera", maker));
        }
        if (model != null)
        {
            arraylist.add(new gd("Model", model));
        }
        if (flash != 0)
        {
            obj = computeFlash(flash);
            if (obj != null)
            {
                arraylist.add(new gd("Flash", ((String) (obj))));
            }
        }
        if (whiteBalance > -1)
        {
            obj = computeWhiteBalance(whiteBalance);
            if (obj != null)
            {
                arraylist.add(new gd("White balance", ((String) (obj))));
            }
        }
        obj = new StringBuilder();
        if (aperture != null)
        {
            double d = ExifInterfaceWrapper.b(aperture);
            if (d > 0.0D)
            {
                numberformat.setMaximumFractionDigits(1);
                ((StringBuilder) (obj)).append((new StringBuilder()).append("F/").append(numberformat.format(d)).append(" ").toString());
            }
        }
        if (focalLength != null)
        {
            double d1 = ExifInterfaceWrapper.b(focalLength);
            if (d1 > 0.0D)
            {
                ((StringBuilder) (obj)).append((new StringBuilder()).append(d1).append("mm ").toString());
            }
        }
        if (exposureTime != null)
        {
            arraylist.add(new gd("Exposure speed", exposureTime));
        }
        if (iso != null)
        {
            ((StringBuilder) (obj)).append((new StringBuilder()).append("ISO-").append(iso).toString());
        }
        if (((StringBuilder) (obj)).length() > 0)
        {
            arraylist.add(new gd("EXIF", ((StringBuilder) (obj)).toString()));
        }
        if (exposureMode > -1)
        {
            String s1 = computeExposureMode(exposureMode);
            if (s1 != null)
            {
                arraylist.add(new gd("Exposure Mode", s1));
            }
        }
        if (exposureProgram > -1)
        {
            String s2 = computeExposureProgram(exposureProgram);
            if (s2 != null)
            {
                arraylist.add(new gd("Exposure Program", s2));
            }
        }
        if (lightSource > 0)
        {
            String s3 = computeLightSource(lightSource);
            if (s3 != null)
            {
                arraylist.add(new gd("LightSource", s3));
            }
        }
        if (artist != null)
        {
            arraylist.add(new gd("Artist", artist));
        }
        if (copyright != null)
        {
            arraylist.add(new gd("Copyright", copyright));
        }
        if (software != null)
        {
            arraylist.add(new gd("Software", software));
        }
        if (brightness != null)
        {
            double d2 = ExifInterfaceWrapper.b(brightness);
            if (d2 != 0.0D)
            {
                numberformat.setMaximumFractionDigits(2);
                arraylist.add(new gd("Brightness", numberformat.format(d2)));
            }
        }
        if (meteringMode != 0)
        {
            String s4 = computeMeteringMode(meteringMode);
            if (s4 != null)
            {
                arraylist.add(new gd("Metering Mode", s4));
            }
        }
        if (digitalZoom != null)
        {
            double d3 = ExifInterfaceWrapper.b(digitalZoom);
            if (d3 > 0.0D)
            {
                arraylist.add(new gd("Digital zoom", (new StringBuilder()).append((int)d3).append("X").toString()));
            }
        }
        if (distance != null)
        {
            double d4 = ExifInterfaceWrapper.b(distance);
            if (d4 > 0.0D)
            {
                arraylist.add(new gd("Subject distance", (new StringBuilder()).append(numberformat.format(d4)).append("mt").toString()));
            }
        }
        if (distanceRange > 0)
        {
            String s = computeDistanceRangeType(distanceRange);
            if (s != null)
            {
                arraylist.add(new gd("Subject distance range", s));
            }
        }
        if (filePath != null)
        {
            arraylist.add(new gd("Path", filePath));
        }
        return arraylist;
    }

    public void getLatLong(float af[])
    {
        af[0] = latitude;
        af[1] = longitude;
    }

    public int getRotation()
    {
        return rotation;
    }

    public int getWidth()
    {
        return width;
    }

    public void onLoadExifData(String s)
    {
        float af[];
        try
        {
            s = new ExifInterfaceWrapper(s);
            altitude = s.a(-1D);
            if (rotation == 0)
            {
                rotation = s.a();
            }
            aperture = s.a("FNumber");
            artist = s.a("Artist");
            brightness = s.a("BrightnessValue");
            copyright = s.a("Copyright");
            dateTime = s.a("DateTime");
            digitalZoom = s.a("DigitalZoomRatio");
            exposureTime = s.a("ExposureTime");
            exposureMode = s.a("ExposureMode", -1);
            exposureProgram = s.a("ExposureProgram", -1);
            flash = s.a("Flash", 0);
            focalLength = s.a("FocalLength");
            iso = s.a("ISOSpeedRatings");
            lightSource = s.a("LightSource", -1);
            maker = s.a("Make");
            model = s.a("Model");
            meteringMode = s.a("MeteringMode", -1);
            software = s.a("Software");
            distance = s.a("SubjectDistance");
            distanceRange = s.a("SubjectDistanceRange", -1);
            whiteBalance = s.a("WhiteBalance", -1);
            af = new float[2];
            af;
            af[0] = 0.0F;
            af[1] = 0.0F;
            s.a(af);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            Crashlytics.logException(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            Crashlytics.logException(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("Exif", "Couldn't load stlport_shared");
            Crashlytics.logException(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("Exif", "Couldn't initailize");
            Crashlytics.logException(s);
            return;
        }
        if (af[0] == 0.0F)
        {
            break MISSING_BLOCK_LABEL_303;
        }
        latitude = af[0];
        longitude = af[1];
    }

    protected void onLoadFromCursor(Cursor cursor)
    {
        caption = cursor.getString(1);
        latitude = cursor.getFloat(3);
        longitude = cursor.getFloat(4);
        filePath = cursor.getString(8);
        rotation = cursor.getInt(9);
        fileSize = cursor.getLong(11);
        bucketDisplayName = cursor.getString(12);
    }

    public void onLoadFromUri(Context context, Uri uri)
    {
        Uri uri1 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        if ("content".equals(uri.getScheme()))
        {
            context = context.getContentResolver().query(uri, PROJECTION, null, null, null);
        } else
        {
            context = context.getContentResolver().query(uri1, PROJECTION, (new StringBuilder()).append("_data LIKE '%").append(uri.toString()).append("%'").toString(), null, null);
        }
        if (context != null)
        {
            if (context.moveToFirst())
            {
                onLoadFromCursor(context);
            }
            context.close();
        }
    }

    public void onLoadImageSize(String s, int i)
    {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try
        {
            BitmapFactory.decodeFile(s, options);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Crashlytics.logException(s);
            return;
        }
        width = options.outWidth;
        height = options.outHeight;
        if (i == 90 || i == 270)
        {
            width = options.outHeight;
            height = options.outWidth;
        }
    }

    public void setAddress(Address address1)
    {
        address = address1;
    }

}
