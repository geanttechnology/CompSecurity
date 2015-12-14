// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.exif2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.util.SparseIntArray;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.commons.io.IOUtils;

// Referenced classes of package it.sephiroth.android.library.exif2:
//            ExifData, Rational, IfdData, JpegHeader, 
//            ExifOutputStream, ExifTag, ExifUtil, ExifInvalidFormatException, 
//            ExifReader

public class ExifInterface
{
    public static interface ColorSpace
    {

        public static final short SRGB = 1;
        public static final short UNCALIBRATED = -1;
    }

    public static interface ComponentsConfiguration
    {

        public static final short B = 6;
        public static final short CB = 2;
        public static final short CR = 3;
        public static final short G = 5;
        public static final short NOT_EXIST = 0;
        public static final short R = 4;
        public static final short Y = 1;
    }

    public static interface Compression
    {

        public static final short JPEG = 6;
        public static final short UNCOMPRESSION = 1;
    }

    public static interface Contrast
    {

        public static final short HARD = 2;
        public static final short NORMAL = 0;
        public static final short SOFT = 1;
    }

    public static interface ExposureMode
    {

        public static final short AUTO_BRACKET = 2;
        public static final short AUTO_EXPOSURE = 0;
        public static final short MANUAL_EXPOSURE = 1;
    }

    public static interface ExposureProgram
    {

        public static final short ACTION_PROGRAM = 6;
        public static final short APERTURE_PRIORITY = 3;
        public static final short CREATIVE_PROGRAM = 5;
        public static final short LANDSCAPE_MODE = 8;
        public static final short MANUAL = 1;
        public static final short NORMAL_PROGRAM = 2;
        public static final short NOT_DEFINED = 0;
        public static final short PROTRAIT_MODE = 7;
        public static final short SHUTTER_PRIORITY = 4;
    }

    public static interface FileSource
    {

        public static final short DSC = 3;
    }

    public static interface Flash
    {
    }

    public static final class Flash.CompulsoryMode extends Enum
    {

        private static final Flash.CompulsoryMode $VALUES[];
        public static final Flash.CompulsoryMode AUTO;
        public static final Flash.CompulsoryMode FIRING;
        public static final Flash.CompulsoryMode SUPPRESSION;
        public static final Flash.CompulsoryMode UNKNOWN;

        public static Flash.CompulsoryMode valueOf(String s)
        {
            return (Flash.CompulsoryMode)Enum.valueOf(it/sephiroth/android/library/exif2/ExifInterface$Flash$CompulsoryMode, s);
        }

        public static Flash.CompulsoryMode[] values()
        {
            return (Flash.CompulsoryMode[])$VALUES.clone();
        }

        static 
        {
            UNKNOWN = new Flash.CompulsoryMode("UNKNOWN", 0);
            FIRING = new Flash.CompulsoryMode("FIRING", 1);
            SUPPRESSION = new Flash.CompulsoryMode("SUPPRESSION", 2);
            AUTO = new Flash.CompulsoryMode("AUTO", 3);
            $VALUES = (new Flash.CompulsoryMode[] {
                UNKNOWN, FIRING, SUPPRESSION, AUTO
            });
        }

        private Flash.CompulsoryMode(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class Flash.FlashFired extends Enum
    {

        private static final Flash.FlashFired $VALUES[];
        public static final Flash.FlashFired NO;
        public static final Flash.FlashFired YES;

        public static Flash.FlashFired valueOf(String s)
        {
            return (Flash.FlashFired)Enum.valueOf(it/sephiroth/android/library/exif2/ExifInterface$Flash$FlashFired, s);
        }

        public static Flash.FlashFired[] values()
        {
            return (Flash.FlashFired[])$VALUES.clone();
        }

        static 
        {
            NO = new Flash.FlashFired("NO", 0);
            YES = new Flash.FlashFired("YES", 1);
            $VALUES = (new Flash.FlashFired[] {
                NO, YES
            });
        }

        private Flash.FlashFired(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class Flash.FlashFunction extends Enum
    {

        private static final Flash.FlashFunction $VALUES[];
        public static final Flash.FlashFunction FUNCTION_NOR_PRESENT;
        public static final Flash.FlashFunction FUNCTION_PRESENT;

        public static Flash.FlashFunction valueOf(String s)
        {
            return (Flash.FlashFunction)Enum.valueOf(it/sephiroth/android/library/exif2/ExifInterface$Flash$FlashFunction, s);
        }

        public static Flash.FlashFunction[] values()
        {
            return (Flash.FlashFunction[])$VALUES.clone();
        }

        static 
        {
            FUNCTION_PRESENT = new Flash.FlashFunction("FUNCTION_PRESENT", 0);
            FUNCTION_NOR_PRESENT = new Flash.FlashFunction("FUNCTION_NOR_PRESENT", 1);
            $VALUES = (new Flash.FlashFunction[] {
                FUNCTION_PRESENT, FUNCTION_NOR_PRESENT
            });
        }

        private Flash.FlashFunction(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class Flash.RedEyeMode extends Enum
    {

        private static final Flash.RedEyeMode $VALUES[];
        public static final Flash.RedEyeMode NONE;
        public static final Flash.RedEyeMode SUPPORTED;

        public static Flash.RedEyeMode valueOf(String s)
        {
            return (Flash.RedEyeMode)Enum.valueOf(it/sephiroth/android/library/exif2/ExifInterface$Flash$RedEyeMode, s);
        }

        public static Flash.RedEyeMode[] values()
        {
            return (Flash.RedEyeMode[])$VALUES.clone();
        }

        static 
        {
            NONE = new Flash.RedEyeMode("NONE", 0);
            SUPPORTED = new Flash.RedEyeMode("SUPPORTED", 1);
            $VALUES = (new Flash.RedEyeMode[] {
                NONE, SUPPORTED
            });
        }

        private Flash.RedEyeMode(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class Flash.StrobeLightDetection extends Enum
    {

        private static final Flash.StrobeLightDetection $VALUES[];
        public static final Flash.StrobeLightDetection LIGHT_DETECTED;
        public static final Flash.StrobeLightDetection LIGHT_NOT_DETECTED;
        public static final Flash.StrobeLightDetection NO_DETECTION;
        public static final Flash.StrobeLightDetection RESERVED;

        public static Flash.StrobeLightDetection valueOf(String s)
        {
            return (Flash.StrobeLightDetection)Enum.valueOf(it/sephiroth/android/library/exif2/ExifInterface$Flash$StrobeLightDetection, s);
        }

        public static Flash.StrobeLightDetection[] values()
        {
            return (Flash.StrobeLightDetection[])$VALUES.clone();
        }

        static 
        {
            NO_DETECTION = new Flash.StrobeLightDetection("NO_DETECTION", 0);
            RESERVED = new Flash.StrobeLightDetection("RESERVED", 1);
            LIGHT_NOT_DETECTED = new Flash.StrobeLightDetection("LIGHT_NOT_DETECTED", 2);
            LIGHT_DETECTED = new Flash.StrobeLightDetection("LIGHT_DETECTED", 3);
            $VALUES = (new Flash.StrobeLightDetection[] {
                NO_DETECTION, RESERVED, LIGHT_NOT_DETECTED, LIGHT_DETECTED
            });
        }

        private Flash.StrobeLightDetection(String s, int i)
        {
            super(s, i);
        }
    }

    public static interface GainControl
    {

        public static final short HIGH_DOWN = 4;
        public static final short HIGH_UP = 2;
        public static final short LOW_DOWN = 3;
        public static final short LOW_UP = 1;
        public static final short NONE = 0;
    }

    public static interface GpsAltitudeRef
    {

        public static final short SEA_LEVEL = 0;
        public static final short SEA_LEVEL_NEGATIVE = 1;
    }

    public static interface GpsDifferential
    {

        public static final short DIFFERENTIAL_CORRECTION_APPLIED = 1;
        public static final short WITHOUT_DIFFERENTIAL_CORRECTION = 0;
    }

    public static interface GpsLatitudeRef
    {

        public static final String NORTH = "N";
        public static final String SOUTH = "S";
    }

    public static interface GpsLongitudeRef
    {

        public static final String EAST = "E";
        public static final String WEST = "W";
    }

    public static interface GpsMeasureMode
    {

        public static final String MODE_2_DIMENSIONAL = "2";
        public static final String MODE_3_DIMENSIONAL = "3";
    }

    public static interface GpsSpeedRef
    {

        public static final String KILOMETERS = "K";
        public static final String KNOTS = "N";
        public static final String MILES = "M";
    }

    public static interface GpsStatus
    {

        public static final String INTEROPERABILITY = "V";
        public static final String IN_PROGRESS = "A";
    }

    public static interface GpsTrackRef
    {

        public static final String MAGNETIC_DIRECTION = "M";
        public static final String TRUE_DIRECTION = "T";
    }

    public static interface JpegProcess
    {

        public static final short BASELINE = -64;
        public static final short DIFFERENTIAL_LOSSLESS = -57;
        public static final short DIFFERENTIAL_LOSSLESS_ARITHMETIC_CODING = -49;
        public static final short DIFFERENTIAL_PROGRESSIVE = -58;
        public static final short DIFFERENTIAL_PROGRESSIVE_ARITHMETIC_CODING = -50;
        public static final short DIFFERENTIAL_SEQUENTIAL = -59;
        public static final short DIFFERENTIAL_SEQ_ARITHMETIC_CODING = -51;
        public static final short EXTENDED_SEQUENTIAL = -63;
        public static final short EXTENDED_SEQ_ARITHMETIC_CODING = -55;
        public static final short LOSSLESS = -61;
        public static final short LOSSLESS_AITHMETIC_CODING = -53;
        public static final short PROGRESSIVE = -62;
        public static final short PROGRESSIVE_AIRTHMETIC_CODING = -54;
    }

    public static interface LightSource
    {

        public static final short CLOUDY_WEATHER = 10;
        public static final short COOL_WHITE_FLUORESCENT = 14;
        public static final short D50 = 23;
        public static final short D55 = 20;
        public static final short D65 = 21;
        public static final short D75 = 22;
        public static final short DAYLIGHT = 1;
        public static final short DAYLIGHT_FLUORESCENT = 12;
        public static final short DAY_WHITE_FLUORESCENT = 13;
        public static final short FINE_WEATHER = 9;
        public static final short FLASH = 4;
        public static final short FLUORESCENT = 2;
        public static final short ISO_STUDIO_TUNGSTEN = 24;
        public static final short OTHER = 255;
        public static final short SHADE = 11;
        public static final short STANDARD_LIGHT_A = 17;
        public static final short STANDARD_LIGHT_B = 18;
        public static final short STANDARD_LIGHT_C = 19;
        public static final short TUNGSTEN = 3;
        public static final short UNKNOWN = 0;
        public static final short WHITE_FLUORESCENT = 15;
    }

    public static interface MeteringMode
    {

        public static final short AVERAGE = 1;
        public static final short CENTER_WEIGHTED_AVERAGE = 2;
        public static final short MULTISPOT = 4;
        public static final short OTHER = 255;
        public static final short PARTAIL = 6;
        public static final short PATTERN = 5;
        public static final short SPOT = 3;
        public static final short UNKNOWN = 0;
    }

    public static interface Options
    {

        public static final int OPTION_ALL = 63;
        public static final int OPTION_IFD_0 = 1;
        public static final int OPTION_IFD_1 = 2;
        public static final int OPTION_IFD_EXIF = 4;
        public static final int OPTION_IFD_GPS = 8;
        public static final int OPTION_IFD_INTEROPERABILITY = 16;
        public static final int OPTION_THUMBNAIL = 32;
    }

    public static interface Orientation
    {

        public static final short BOTTOM_LEFT = 3;
        public static final short BOTTOM_RIGHT = 4;
        public static final short LEFT_BOTTOM = 7;
        public static final short LEFT_TOP = 5;
        public static final short RIGHT_BOTTOM = 8;
        public static final short RIGHT_TOP = 6;
        public static final short TOP_LEFT = 1;
        public static final short TOP_RIGHT = 2;
    }

    public static interface PhotometricInterpretation
    {

        public static final short RGB = 2;
        public static final short YCBCR = 6;
    }

    public static interface PlanarConfiguration
    {

        public static final short CHUNKY = 1;
        public static final short PLANAR = 2;
    }

    public static interface ResolutionUnit
    {

        public static final short CENTIMETERS = 3;
        public static final short INCHES = 2;
        public static final short MICROMETERS = 5;
        public static final short MILLIMETERS = 4;
    }

    public static interface Saturation
    {

        public static final short HIGH = 2;
        public static final short LOW = 1;
        public static final short NORMAL = 0;
    }

    public static interface SceneCapture
    {

        public static final short LANDSCAPE = 1;
        public static final short NIGHT_SCENE = 3;
        public static final short PROTRAIT = 2;
        public static final short STANDARD = 0;
    }

    public static interface SceneType
    {

        public static final short DIRECT_PHOTOGRAPHED = 1;
    }

    public static interface SensingMethod
    {

        public static final short COLOR_SEQUENTIAL_AREA = 5;
        public static final short COLOR_SEQUENTIAL_LINEAR = 8;
        public static final short NOT_DEFINED = 1;
        public static final short ONE_CHIP_COLOR = 2;
        public static final short THREE_CHIP_COLOR = 4;
        public static final short TRILINEAR = 7;
        public static final short TWO_CHIP_COLOR = 3;
    }

    public static interface SensitivityType
    {

        public static final short ISO = 3;
        public static final short REI = 2;
        public static final short REI_ISO = 6;
        public static final short SOS = 1;
        public static final short SOS_ISO = 5;
        public static final short SOS_REI = 4;
        public static final short SOS_REI_ISO = 7;
        public static final short UNKNOWN = 0;
    }

    public static interface Sharpness
    {

        public static final short HARD = 2;
        public static final short NORMAL = 0;
        public static final short SOFT = 1;
    }

    public static interface SubjectDistance
    {

        public static final short CLOSE_VIEW = 2;
        public static final short DISTANT_VIEW = 3;
        public static final short MACRO = 1;
        public static final short UNKNOWN = 0;
    }

    public static interface WhiteBalance
    {

        public static final short AUTO = 0;
        public static final short MANUAL = 1;
    }

    public static interface YCbCrPositioning
    {

        public static final short CENTERED = 1;
        public static final short CO_SITED = 2;
    }


    private static final String DATETIME_FORMAT_STR = "yyyy:MM:dd kk:mm:ss";
    public static final ByteOrder DEFAULT_BYTE_ORDER;
    public static final int DEFINITION_NULL = 0;
    private static final String GPS_DATE_FORMAT_STR = "yyyy:MM:dd";
    public static final int IFD_NULL = -1;
    private static final String NULL_ARGUMENT_STRING = "Argument is null";
    private static final String TAG = "ExifInterface";
    public static final int TAG_APERTURE_VALUE = defineTag(2, (short)-28158);
    public static final int TAG_ARTIST = defineTag(0, (short)315);
    public static final int TAG_BITS_PER_SAMPLE = defineTag(0, (short)258);
    public static final int TAG_BRIGHTNESS_VALUE = defineTag(2, (short)-28157);
    public static final int TAG_CFA_PATTERN = defineTag(2, (short)-23806);
    public static final int TAG_COLOR_SPACE = defineTag(2, (short)-24575);
    public static final int TAG_COMPONENTS_CONFIGURATION = defineTag(2, (short)-28415);
    public static final int TAG_COMPRESSED_BITS_PER_PIXEL = defineTag(2, (short)-28414);
    public static final int TAG_COMPRESSION = defineTag(0, (short)259);
    public static final int TAG_CONTRAST = defineTag(2, (short)-23544);
    public static final int TAG_COPYRIGHT = defineTag(0, (short)-32104);
    public static final int TAG_CUSTOM_RENDERED = defineTag(2, (short)-23551);
    public static final int TAG_DATE_TIME = defineTag(0, (short)306);
    public static final int TAG_DATE_TIME_DIGITIZED = defineTag(2, (short)-28668);
    public static final int TAG_DATE_TIME_ORIGINAL = defineTag(2, (short)-28669);
    public static final int TAG_DEVICE_SETTING_DESCRIPTION = defineTag(2, (short)-23541);
    public static final int TAG_DIGITAL_ZOOM_RATIO = defineTag(2, (short)-23548);
    public static final int TAG_EXIF_IFD;
    public static final int TAG_EXIF_VERSION = defineTag(2, (short)-28672);
    public static final int TAG_EXPOSURE_BIAS_VALUE = defineTag(2, (short)-28156);
    public static final int TAG_EXPOSURE_INDEX = defineTag(2, (short)-24043);
    public static final int TAG_EXPOSURE_MODE = defineTag(2, (short)-23550);
    public static final int TAG_EXPOSURE_PROGRAM = defineTag(2, (short)-30686);
    public static final int TAG_EXPOSURE_TIME = defineTag(2, (short)-32102);
    public static final int TAG_FILE_SOURCE = defineTag(2, (short)-23808);
    public static final int TAG_FLASH = defineTag(2, (short)-28151);
    public static final int TAG_FLASHPIX_VERSION = defineTag(2, (short)-24576);
    public static final int TAG_FLASH_ENERGY = defineTag(2, (short)-24053);
    public static final int TAG_FOCAL_LENGTH = defineTag(2, (short)-28150);
    public static final int TAG_FOCAL_LENGTH_IN_35_MM_FILE = defineTag(2, (short)-23547);
    public static final int TAG_FOCAL_PLANE_RESOLUTION_UNIT = defineTag(2, (short)-24048);
    public static final int TAG_FOCAL_PLANE_X_RESOLUTION = defineTag(2, (short)-24050);
    public static final int TAG_FOCAL_PLANE_Y_RESOLUTION = defineTag(2, (short)-24049);
    public static final int TAG_F_NUMBER = defineTag(2, (short)-32099);
    public static final int TAG_GAIN_CONTROL = defineTag(2, (short)-23545);
    public static final int TAG_GPS_ALTITUDE = defineTag(4, (short)6);
    public static final int TAG_GPS_ALTITUDE_REF = defineTag(4, (short)5);
    public static final int TAG_GPS_AREA_INFORMATION = defineTag(4, (short)28);
    public static final int TAG_GPS_DATE_STAMP = defineTag(4, (short)29);
    public static final int TAG_GPS_DEST_BEARING = defineTag(4, (short)24);
    public static final int TAG_GPS_DEST_BEARING_REF = defineTag(4, (short)23);
    public static final int TAG_GPS_DEST_DISTANCE = defineTag(4, (short)26);
    public static final int TAG_GPS_DEST_DISTANCE_REF = defineTag(4, (short)25);
    public static final int TAG_GPS_DEST_LATITUDE = defineTag(4, (short)20);
    public static final int TAG_GPS_DEST_LATITUDE_REF = defineTag(4, (short)19);
    public static final int TAG_GPS_DEST_LONGITUDE = defineTag(4, (short)22);
    public static final int TAG_GPS_DEST_LONGITUDE_REF = defineTag(4, (short)21);
    public static final int TAG_GPS_DIFFERENTIAL = defineTag(4, (short)30);
    public static final int TAG_GPS_DOP = defineTag(4, (short)11);
    public static final int TAG_GPS_IFD;
    public static final int TAG_GPS_IMG_DIRECTION = defineTag(4, (short)17);
    public static final int TAG_GPS_IMG_DIRECTION_REF = defineTag(4, (short)16);
    public static final int TAG_GPS_LATITUDE = defineTag(4, (short)2);
    public static final int TAG_GPS_LATITUDE_REF = defineTag(4, (short)1);
    public static final int TAG_GPS_LONGITUDE = defineTag(4, (short)4);
    public static final int TAG_GPS_LONGITUDE_REF = defineTag(4, (short)3);
    public static final int TAG_GPS_MAP_DATUM = defineTag(4, (short)18);
    public static final int TAG_GPS_MEASURE_MODE = defineTag(4, (short)10);
    public static final int TAG_GPS_PROCESSING_METHOD = defineTag(4, (short)27);
    public static final int TAG_GPS_SATTELLITES = defineTag(4, (short)8);
    public static final int TAG_GPS_SPEED = defineTag(4, (short)13);
    public static final int TAG_GPS_SPEED_REF = defineTag(4, (short)12);
    public static final int TAG_GPS_STATUS = defineTag(4, (short)9);
    public static final int TAG_GPS_TIME_STAMP = defineTag(4, (short)7);
    public static final int TAG_GPS_TRACK = defineTag(4, (short)15);
    public static final int TAG_GPS_TRACK_REF = defineTag(4, (short)14);
    public static final int TAG_GPS_VERSION_ID = defineTag(4, (short)0);
    public static final int TAG_IMAGE_DESCRIPTION = defineTag(0, (short)270);
    public static final int TAG_IMAGE_LENGTH = defineTag(0, (short)257);
    public static final int TAG_IMAGE_UNIQUE_ID = defineTag(2, (short)-23520);
    public static final int TAG_IMAGE_WIDTH = defineTag(0, (short)256);
    public static final int TAG_INTEROPERABILITY_IFD;
    public static final int TAG_INTEROPERABILITY_INDEX = defineTag(3, (short)1);
    public static final int TAG_INTEROP_VERSION = defineTag(3, (short)2);
    public static final int TAG_ISO_SPEED_RATINGS = defineTag(2, (short)-30681);
    public static final int TAG_JPEG_INTERCHANGE_FORMAT;
    public static final int TAG_JPEG_INTERCHANGE_FORMAT_LENGTH;
    public static final int TAG_LENS_MAKE = defineTag(2, (short)-23501);
    public static final int TAG_LENS_MODEL = defineTag(2, (short)-23500);
    public static final int TAG_LENS_SPECS = defineTag(2, (short)-23502);
    public static final int TAG_LIGHT_SOURCE = defineTag(2, (short)-28152);
    public static final int TAG_MAKE = defineTag(0, (short)271);
    public static final int TAG_MAKER_NOTE = defineTag(2, (short)-28036);
    public static final int TAG_MAX_APERTURE_VALUE = defineTag(2, (short)-28155);
    public static final int TAG_METERING_MODE = defineTag(2, (short)-28153);
    public static final int TAG_MODEL = defineTag(0, (short)272);
    public static final int TAG_NULL = -1;
    public static final int TAG_OECF = defineTag(2, (short)-30680);
    public static final int TAG_ORIENTATION = defineTag(0, (short)274);
    public static final int TAG_PHOTOMETRIC_INTERPRETATION = defineTag(0, (short)262);
    public static final int TAG_PIXEL_X_DIMENSION = defineTag(2, (short)-24574);
    public static final int TAG_PIXEL_Y_DIMENSION = defineTag(2, (short)-24573);
    public static final int TAG_PLANAR_CONFIGURATION = defineTag(0, (short)284);
    public static final int TAG_PRIMARY_CHROMATICITIES = defineTag(0, (short)319);
    public static final int TAG_REFERENCE_BLACK_WHITE = defineTag(0, (short)532);
    public static final int TAG_RELATED_SOUND_FILE = defineTag(2, (short)-24572);
    public static final int TAG_RESOLUTION_UNIT = defineTag(0, (short)296);
    public static final int TAG_ROWS_PER_STRIP = defineTag(0, (short)278);
    public static final int TAG_SAMPLES_PER_PIXEL = defineTag(0, (short)277);
    public static final int TAG_SATURATION = defineTag(2, (short)-23543);
    public static final int TAG_SCENE_CAPTURE_TYPE = defineTag(2, (short)-23546);
    public static final int TAG_SCENE_TYPE = defineTag(2, (short)-23807);
    public static final int TAG_SENSING_METHOD = defineTag(2, (short)-24041);
    public static final int TAG_SENSITIVITY_TYPE = defineTag(2, (short)-30672);
    public static final int TAG_SHARPNESS = defineTag(2, (short)-23542);
    public static final int TAG_SHUTTER_SPEED_VALUE = defineTag(2, (short)-28159);
    public static final int TAG_SOFTWARE = defineTag(0, (short)305);
    public static final int TAG_SPATIAL_FREQUENCY_RESPONSE = defineTag(2, (short)-24052);
    public static final int TAG_SPECTRAL_SENSITIVITY = defineTag(2, (short)-30684);
    public static final int TAG_STRIP_BYTE_COUNTS;
    public static final int TAG_STRIP_OFFSETS;
    public static final int TAG_SUBJECT_AREA = defineTag(2, (short)-28140);
    public static final int TAG_SUBJECT_DISTANCE = defineTag(2, (short)-28154);
    public static final int TAG_SUBJECT_DISTANCE_RANGE = defineTag(2, (short)-23540);
    public static final int TAG_SUBJECT_LOCATION = defineTag(2, (short)-24044);
    public static final int TAG_SUB_SEC_TIME = defineTag(2, (short)-28016);
    public static final int TAG_SUB_SEC_TIME_DIGITIZED = defineTag(2, (short)-28014);
    public static final int TAG_SUB_SEC_TIME_ORIGINAL = defineTag(2, (short)-28015);
    public static final int TAG_TRANSFER_FUNCTION = defineTag(0, (short)301);
    public static final int TAG_USER_COMMENT = defineTag(2, (short)-28026);
    public static final int TAG_WHITE_BALANCE = defineTag(2, (short)-23549);
    public static final int TAG_WHITE_POINT = defineTag(0, (short)318);
    public static final int TAG_X_RESOLUTION = defineTag(0, (short)282);
    public static final int TAG_Y_CB_CR_COEFFICIENTS = defineTag(0, (short)529);
    public static final int TAG_Y_CB_CR_POSITIONING = defineTag(0, (short)531);
    public static final int TAG_Y_CB_CR_SUB_SAMPLING = defineTag(0, (short)530);
    public static final int TAG_Y_RESOLUTION = defineTag(0, (short)283);
    private static final DateFormat mDateTimeStampFormat = new SimpleDateFormat("yyyy:MM:dd kk:mm:ss");
    private static final DateFormat mGPSDateStampFormat = new SimpleDateFormat("yyyy:MM:dd");
    protected static HashSet sBannedDefines;
    private static HashSet sOffsetTags;
    private ExifData mData;
    private final Calendar mGPSTimeStampCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
    private SparseIntArray mTagInfo;

    public ExifInterface()
    {
        mData = new ExifData(DEFAULT_BYTE_ORDER);
        mTagInfo = null;
        mGPSDateStampFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    protected static void closeSilently(Closeable closeable)
    {
        if (closeable == null)
        {
            break MISSING_BLOCK_LABEL_10;
        }
        closeable.close();
        return;
        closeable;
    }

    public static double convertLatOrLongToDouble(Rational arational[], String s)
    {
label0:
        {
label1:
            {
                double d1;
                double d2;
                boolean flag;
                try
                {
                    double d = arational[0].toDouble();
                    d2 = arational[1].toDouble();
                    double d3 = arational[2].toDouble();
                    d2 = d2 / 60D + d + d3 / 3600D;
                    if (s.startsWith("S"))
                    {
                        break label1;
                    }
                    flag = s.startsWith("W");
                }
                // Misplaced declaration of an exception variable
                catch (Rational arational[])
                {
                    throw new IllegalArgumentException();
                }
                d1 = d2;
                if (!flag)
                {
                    break label0;
                }
            }
            d1 = -d2;
        }
        return d1;
    }

    private static String convertRationalLatLonToString(Rational arational[], String s)
    {
        arational = String.format("%1$.0f\260 %2$.0f' %3$.0f\" %4$s", new Object[] {
            Double.valueOf(arational[0].toDouble()), Double.valueOf(arational[1].toDouble()), Double.valueOf(arational[2].toDouble()), s.substring(0, 1).toUpperCase(Locale.getDefault())
        });
        return arational;
        arational;
        arational.printStackTrace();
_L2:
        return null;
        arational;
        arational.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static int defineTag(int i, short word0)
    {
        return 0xffff & word0 | i << 16;
    }

    protected static int getAllowedIfdFlagsFromInfo(int i)
    {
        return i >>> 24;
    }

    protected static int[] getAllowedIfdsFromInfo(int i)
    {
        int ai[];
        int j = getAllowedIfdFlagsFromInfo(i);
        int ai1[] = IfdData.getIfds();
        ai = new ArrayList();
        for (i = 0; i < 5; i++)
        {
            if ((j >> i & 1) == 1)
            {
                ai.add(Integer.valueOf(ai1[i]));
            }
        }

        if (ai.size() > 0) goto _L2; else goto _L1
_L1:
        ai = null;
_L4:
        return ai;
_L2:
        int ai2[] = new int[ai.size()];
        i = 0;
        Iterator iterator = ai.iterator();
        do
        {
            ai = ai2;
            if (!iterator.hasNext())
            {
                continue;
            }
            ai2[i] = ((Integer)iterator.next()).intValue();
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected static int getComponentCountFromInfo(int i)
    {
        return 0xffff & i;
    }

    public static Date getDateTime(String s, TimeZone timezone)
    {
        if (s == null)
        {
            return null;
        }
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy:MM:dd kk:mm:ss");
        simpledateformat.setTimeZone(timezone);
        try
        {
            s = simpledateformat.parse(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        return s;
    }

    protected static int getFlagsFromAllowedIfds(int ai[])
    {
        if (ai != null && ai.length != 0) goto _L2; else goto _L1
_L1:
        int k = 0;
_L4:
        return k;
_L2:
        int ai1[];
        int i;
        int j;
        i = 0;
        ai1 = IfdData.getIfds();
        j = 0;
_L5:
        k = i;
        if (j >= 5) goto _L4; else goto _L3
_L3:
        int i1;
        i1 = ai.length;
        k = 0;
_L6:
label0:
        {
            int l = i;
            if (k < i1)
            {
                l = ai[k];
                if (ai1[j] != l)
                {
                    break label0;
                }
                l = i | 1 << j;
            }
            j++;
            i = l;
        }
          goto _L5
        k++;
          goto _L6
    }

    public static short getOrientationValueForRotation(int i)
    {
        int j = i % 360;
        i = j;
        if (j < 0)
        {
            i = j + 360;
        }
        if (i < 90)
        {
            return 1;
        }
        if (i < 180)
        {
            return 6;
        }
        return i >= 270 ? 8 : 3;
    }

    public static int getRotationForOrientationValue(short word0)
    {
        switch (word0)
        {
        case 1: // '\001'
        case 2: // '\002'
        case 4: // '\004'
        case 5: // '\005'
        case 7: // '\007'
        default:
            return 0;

        case 6: // '\006'
            return 90;

        case 3: // '\003'
            return 180;

        case 8: // '\b'
            return 270;
        }
    }

    public static int getTrueIfd(int i)
    {
        return i >>> 16;
    }

    public static short getTrueTagKey(int i)
    {
        return (short)i;
    }

    protected static short getTypeFromInfo(int i)
    {
        return (short)(i >> 16 & 0xff);
    }

    private void initTagInfo()
    {
        int i = getFlagsFromAllowedIfds(new int[] {
            0, 1
        }) << 24;
        mTagInfo.put(TAG_MAKE, 0x20000 | i);
        mTagInfo.put(TAG_IMAGE_WIDTH, 0x40000 | i | 1);
        mTagInfo.put(TAG_IMAGE_LENGTH, 0x40000 | i | 1);
        mTagInfo.put(TAG_BITS_PER_SAMPLE, 0x30000 | i | 3);
        mTagInfo.put(TAG_COMPRESSION, 0x30000 | i | 1);
        mTagInfo.put(TAG_PHOTOMETRIC_INTERPRETATION, 0x30000 | i | 1);
        mTagInfo.put(TAG_ORIENTATION, 0x30000 | i | 1);
        mTagInfo.put(TAG_SAMPLES_PER_PIXEL, 0x30000 | i | 1);
        mTagInfo.put(TAG_PLANAR_CONFIGURATION, 0x30000 | i | 1);
        mTagInfo.put(TAG_Y_CB_CR_SUB_SAMPLING, 0x30000 | i | 2);
        mTagInfo.put(TAG_Y_CB_CR_POSITIONING, 0x30000 | i | 1);
        mTagInfo.put(TAG_X_RESOLUTION, 0x50000 | i | 1);
        mTagInfo.put(TAG_Y_RESOLUTION, 0x50000 | i | 1);
        mTagInfo.put(TAG_RESOLUTION_UNIT, 0x30000 | i | 1);
        mTagInfo.put(TAG_STRIP_OFFSETS, 0x40000 | i);
        mTagInfo.put(TAG_ROWS_PER_STRIP, 0x40000 | i | 1);
        mTagInfo.put(TAG_STRIP_BYTE_COUNTS, 0x40000 | i);
        mTagInfo.put(TAG_TRANSFER_FUNCTION, 0x30000 | i | 0x300);
        mTagInfo.put(TAG_WHITE_POINT, 0x50000 | i | 2);
        mTagInfo.put(TAG_PRIMARY_CHROMATICITIES, 0x50000 | i | 6);
        mTagInfo.put(TAG_Y_CB_CR_COEFFICIENTS, 0x50000 | i | 3);
        mTagInfo.put(TAG_REFERENCE_BLACK_WHITE, 0x50000 | i | 6);
        mTagInfo.put(TAG_DATE_TIME, 0x20000 | i | 0x14);
        mTagInfo.put(TAG_IMAGE_DESCRIPTION, 0x20000 | i);
        mTagInfo.put(TAG_MODEL, 0x20000 | i);
        mTagInfo.put(TAG_SOFTWARE, 0x20000 | i);
        mTagInfo.put(TAG_ARTIST, 0x20000 | i);
        mTagInfo.put(TAG_COPYRIGHT, 0x20000 | i);
        mTagInfo.put(TAG_EXIF_IFD, 0x40000 | i | 1);
        mTagInfo.put(TAG_GPS_IFD, 0x40000 | i | 1);
        i = getFlagsFromAllowedIfds(new int[] {
            1
        }) << 24;
        mTagInfo.put(TAG_JPEG_INTERCHANGE_FORMAT, 0x40000 | i | 1);
        mTagInfo.put(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 0x40000 | i | 1);
        i = getFlagsFromAllowedIfds(new int[] {
            2
        }) << 24;
        mTagInfo.put(TAG_EXIF_VERSION, 0x70000 | i | 4);
        mTagInfo.put(TAG_FLASHPIX_VERSION, 0x70000 | i | 4);
        mTagInfo.put(TAG_COLOR_SPACE, 0x30000 | i | 1);
        mTagInfo.put(TAG_COMPONENTS_CONFIGURATION, 0x70000 | i | 4);
        mTagInfo.put(TAG_COMPRESSED_BITS_PER_PIXEL, 0x50000 | i | 1);
        mTagInfo.put(TAG_PIXEL_X_DIMENSION, 0x40000 | i | 1);
        mTagInfo.put(TAG_PIXEL_Y_DIMENSION, 0x40000 | i | 1);
        mTagInfo.put(TAG_MAKER_NOTE, 0x70000 | i);
        mTagInfo.put(TAG_USER_COMMENT, 0x70000 | i);
        mTagInfo.put(TAG_RELATED_SOUND_FILE, 0x20000 | i | 0xd);
        mTagInfo.put(TAG_DATE_TIME_ORIGINAL, 0x20000 | i | 0x14);
        mTagInfo.put(TAG_DATE_TIME_DIGITIZED, 0x20000 | i | 0x14);
        mTagInfo.put(TAG_SUB_SEC_TIME, 0x20000 | i);
        mTagInfo.put(TAG_SUB_SEC_TIME_ORIGINAL, 0x20000 | i);
        mTagInfo.put(TAG_SUB_SEC_TIME_DIGITIZED, 0x20000 | i);
        mTagInfo.put(TAG_IMAGE_UNIQUE_ID, 0x20000 | i | 0x21);
        mTagInfo.put(TAG_LENS_SPECS, 0xa0000 | i | 3);
        mTagInfo.put(TAG_LENS_MAKE, 0x20000 | i);
        mTagInfo.put(TAG_LENS_MODEL, 0x20000 | i);
        mTagInfo.put(TAG_SENSITIVITY_TYPE, 0x30000 | i | 1);
        mTagInfo.put(TAG_EXPOSURE_TIME, 0x50000 | i | 1);
        mTagInfo.put(TAG_F_NUMBER, 0x50000 | i | 1);
        mTagInfo.put(TAG_EXPOSURE_PROGRAM, 0x30000 | i | 1);
        mTagInfo.put(TAG_SPECTRAL_SENSITIVITY, 0x20000 | i);
        mTagInfo.put(TAG_ISO_SPEED_RATINGS, 0x30000 | i);
        mTagInfo.put(TAG_OECF, 0x70000 | i);
        mTagInfo.put(TAG_SHUTTER_SPEED_VALUE, 0xa0000 | i | 1);
        mTagInfo.put(TAG_APERTURE_VALUE, 0x50000 | i | 1);
        mTagInfo.put(TAG_BRIGHTNESS_VALUE, 0xa0000 | i | 1);
        mTagInfo.put(TAG_EXPOSURE_BIAS_VALUE, 0xa0000 | i | 1);
        mTagInfo.put(TAG_MAX_APERTURE_VALUE, 0x50000 | i | 1);
        mTagInfo.put(TAG_SUBJECT_DISTANCE, 0x50000 | i | 1);
        mTagInfo.put(TAG_METERING_MODE, 0x30000 | i | 1);
        mTagInfo.put(TAG_LIGHT_SOURCE, 0x30000 | i | 1);
        mTagInfo.put(TAG_FLASH, 0x30000 | i | 1);
        mTagInfo.put(TAG_FOCAL_LENGTH, 0x50000 | i | 1);
        mTagInfo.put(TAG_SUBJECT_AREA, 0x30000 | i);
        mTagInfo.put(TAG_FLASH_ENERGY, 0x50000 | i | 1);
        mTagInfo.put(TAG_SPATIAL_FREQUENCY_RESPONSE, 0x70000 | i);
        mTagInfo.put(TAG_FOCAL_PLANE_X_RESOLUTION, 0x50000 | i | 1);
        mTagInfo.put(TAG_FOCAL_PLANE_Y_RESOLUTION, 0x50000 | i | 1);
        mTagInfo.put(TAG_FOCAL_PLANE_RESOLUTION_UNIT, 0x30000 | i | 1);
        mTagInfo.put(TAG_SUBJECT_LOCATION, 0x30000 | i | 2);
        mTagInfo.put(TAG_EXPOSURE_INDEX, 0x50000 | i | 1);
        mTagInfo.put(TAG_SENSING_METHOD, 0x30000 | i | 1);
        mTagInfo.put(TAG_FILE_SOURCE, 0x70000 | i | 1);
        mTagInfo.put(TAG_SCENE_TYPE, 0x70000 | i | 1);
        mTagInfo.put(TAG_CFA_PATTERN, 0x70000 | i);
        mTagInfo.put(TAG_CUSTOM_RENDERED, 0x30000 | i | 1);
        mTagInfo.put(TAG_EXPOSURE_MODE, 0x30000 | i | 1);
        mTagInfo.put(TAG_WHITE_BALANCE, 0x30000 | i | 1);
        mTagInfo.put(TAG_DIGITAL_ZOOM_RATIO, 0x50000 | i | 1);
        mTagInfo.put(TAG_FOCAL_LENGTH_IN_35_MM_FILE, 0x30000 | i | 1);
        mTagInfo.put(TAG_SCENE_CAPTURE_TYPE, 0x30000 | i | 1);
        mTagInfo.put(TAG_GAIN_CONTROL, 0x50000 | i | 1);
        mTagInfo.put(TAG_CONTRAST, 0x30000 | i | 1);
        mTagInfo.put(TAG_SATURATION, 0x30000 | i | 1);
        mTagInfo.put(TAG_SHARPNESS, 0x30000 | i | 1);
        mTagInfo.put(TAG_DEVICE_SETTING_DESCRIPTION, 0x70000 | i);
        mTagInfo.put(TAG_SUBJECT_DISTANCE_RANGE, 0x30000 | i | 1);
        mTagInfo.put(TAG_INTEROPERABILITY_IFD, 0x40000 | i | 1);
        i = getFlagsFromAllowedIfds(new int[] {
            4
        }) << 24;
        mTagInfo.put(TAG_GPS_VERSION_ID, 0x10000 | i | 4);
        mTagInfo.put(TAG_GPS_LATITUDE_REF, 0x20000 | i | 2);
        mTagInfo.put(TAG_GPS_LONGITUDE_REF, 0x20000 | i | 2);
        mTagInfo.put(TAG_GPS_LATITUDE, 0xa0000 | i | 3);
        mTagInfo.put(TAG_GPS_LONGITUDE, 0xa0000 | i | 3);
        mTagInfo.put(TAG_GPS_ALTITUDE_REF, 0x10000 | i | 1);
        mTagInfo.put(TAG_GPS_ALTITUDE, 0x50000 | i | 1);
        mTagInfo.put(TAG_GPS_TIME_STAMP, 0x50000 | i | 3);
        mTagInfo.put(TAG_GPS_SATTELLITES, 0x20000 | i);
        mTagInfo.put(TAG_GPS_STATUS, 0x20000 | i | 2);
        mTagInfo.put(TAG_GPS_MEASURE_MODE, 0x20000 | i | 2);
        mTagInfo.put(TAG_GPS_DOP, 0x50000 | i | 1);
        mTagInfo.put(TAG_GPS_SPEED_REF, 0x20000 | i | 2);
        mTagInfo.put(TAG_GPS_SPEED, 0x50000 | i | 1);
        mTagInfo.put(TAG_GPS_TRACK_REF, 0x20000 | i | 2);
        mTagInfo.put(TAG_GPS_TRACK, 0x50000 | i | 1);
        mTagInfo.put(TAG_GPS_IMG_DIRECTION_REF, 0x20000 | i | 2);
        mTagInfo.put(TAG_GPS_IMG_DIRECTION, 0x50000 | i | 1);
        mTagInfo.put(TAG_GPS_MAP_DATUM, 0x20000 | i);
        mTagInfo.put(TAG_GPS_DEST_LATITUDE_REF, 0x20000 | i | 2);
        mTagInfo.put(TAG_GPS_DEST_LATITUDE, 0x50000 | i | 1);
        mTagInfo.put(TAG_GPS_DEST_BEARING_REF, 0x20000 | i | 2);
        mTagInfo.put(TAG_GPS_DEST_BEARING, 0x50000 | i | 1);
        mTagInfo.put(TAG_GPS_DEST_DISTANCE_REF, 0x20000 | i | 2);
        mTagInfo.put(TAG_GPS_DEST_DISTANCE, 0x50000 | i | 1);
        mTagInfo.put(TAG_GPS_PROCESSING_METHOD, 0x70000 | i);
        mTagInfo.put(TAG_GPS_AREA_INFORMATION, 0x70000 | i);
        mTagInfo.put(TAG_GPS_DATE_STAMP, 0x20000 | i | 0xb);
        mTagInfo.put(TAG_GPS_DIFFERENTIAL, 0x30000 | i | 0xb);
        i = getFlagsFromAllowedIfds(new int[] {
            3
        }) << 24;
        mTagInfo.put(TAG_INTEROPERABILITY_INDEX, 0x20000 | i);
        mTagInfo.put(TAG_INTEROP_VERSION, 0x70000 | i | 4);
    }

    protected static boolean isIfdAllowed(int i, int j)
    {
        int ai[] = IfdData.getIfds();
        int k = getAllowedIfdFlagsFromInfo(i);
        for (i = 0; i < ai.length; i++)
        {
            if (j == ai[i] && (k >> i & 1) == 1)
            {
                return true;
            }
        }

        return false;
    }

    protected static boolean isOffsetTag(short word0)
    {
        return sOffsetTags.contains(Short.valueOf(word0));
    }

    public static byte[] toBitArray(short word0)
    {
        byte abyte0[] = new byte[16];
        for (int i = 0; i < 16; i++)
        {
            abyte0[15 - i] = (byte)(word0 >> i & 1);
        }

        return abyte0;
    }

    private static Rational[] toExifLatLong(double d)
    {
        d = Math.abs(d);
        int i = (int)d;
        d = (d - (double)i) * 60D;
        int j = (int)d;
        int k = (int)((d - (double)j) * 6000D);
        return (new Rational[] {
            new Rational(i, 1L), new Rational(j, 1L), new Rational(k, 100L)
        });
    }

    private static int writeExif_internal(InputStream inputstream, OutputStream outputstream, ExifData exifdata)
        throws IOException
    {
        ExifInterface exifinterface = new ExifInterface();
        exifinterface.readExif(inputstream, 0);
        outputstream.write(255);
        outputstream.write(216);
        inputstream = exifinterface.mData.getSections();
        if (((ExifParser.Section)inputstream.get(0)).type != 224)
        {
            Log.w("ExifInterface", "first section is not a JFIF or EXIF tag");
            outputstream.write(JpegHeader.JFIF_HEADER);
        }
        ExifOutputStream exifoutputstream = new ExifOutputStream(exifinterface);
        exifoutputstream.setExifData(exifdata);
        exifoutputstream.writeExifData(outputstream);
        for (int i = 0; i < inputstream.size() - 1; i++)
        {
            exifdata = (ExifParser.Section)inputstream.get(i);
            outputstream.write(255);
            outputstream.write(((ExifParser.Section) (exifdata)).type);
            outputstream.write(((ExifParser.Section) (exifdata)).data);
        }

        inputstream = (ExifParser.Section)inputstream.get(inputstream.size() - 1);
        outputstream.write(255);
        outputstream.write(((ExifParser.Section) (inputstream)).type);
        outputstream.write(((ExifParser.Section) (inputstream)).data);
        return exifinterface.mData.mUncompressedDataPosition;
    }

    public boolean addDateTimeStampTag(int i, long l, TimeZone timezone)
    {
label0:
        {
            if (i == TAG_DATE_TIME || i == TAG_DATE_TIME_DIGITIZED || i == TAG_DATE_TIME_ORIGINAL)
            {
                mDateTimeStampFormat.setTimeZone(timezone);
                timezone = buildTag(i, mDateTimeStampFormat.format(Long.valueOf(l)));
                if (timezone != null)
                {
                    break label0;
                }
            }
            return false;
        }
        setTag(timezone);
        return true;
    }

    public boolean addGpsDateTimeStampTag(long l)
    {
        ExifTag exiftag = buildTag(TAG_GPS_DATE_STAMP, mGPSDateStampFormat.format(Long.valueOf(l)));
        if (exiftag != null)
        {
            setTag(exiftag);
            mGPSTimeStampCalendar.setTimeInMillis(l);
            exiftag = buildTag(TAG_GPS_TIME_STAMP, new Rational[] {
                new Rational(mGPSTimeStampCalendar.get(11), 1L), new Rational(mGPSTimeStampCalendar.get(12), 1L), new Rational(mGPSTimeStampCalendar.get(13), 1L)
            });
            if (exiftag != null)
            {
                setTag(exiftag);
                return true;
            }
        }
        return false;
    }

    public boolean addGpsTags(double d, double d1)
    {
        ExifTag exiftag = buildTag(TAG_GPS_LATITUDE, toExifLatLong(d));
        ExifTag exiftag1 = buildTag(TAG_GPS_LONGITUDE, toExifLatLong(d1));
        int i = TAG_GPS_LATITUDE_REF;
        Object obj;
        ExifTag exiftag2;
        if (d >= 0.0D)
        {
            obj = "N";
        } else
        {
            obj = "S";
        }
        exiftag2 = buildTag(i, obj);
        i = TAG_GPS_LONGITUDE_REF;
        if (d1 >= 0.0D)
        {
            obj = "E";
        } else
        {
            obj = "W";
        }
        obj = buildTag(i, obj);
        if (exiftag == null || exiftag1 == null || exiftag2 == null || obj == null)
        {
            return false;
        } else
        {
            setTag(exiftag);
            setTag(exiftag1);
            setTag(exiftag2);
            setTag(((ExifTag) (obj)));
            return true;
        }
    }

    public ExifTag buildTag(int i, int j, Object obj)
    {
        int k = getTagInfo().get(i);
        ExifTag exiftag;
        if (k == 0 || obj == null)
        {
            exiftag = null;
        } else
        {
            short word0 = getTypeFromInfo(k);
            int l = getComponentCountFromInfo(k);
            boolean flag;
            if (l != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!isIfdAllowed(k, j))
            {
                return null;
            }
            ExifTag exiftag1 = new ExifTag(getTrueTagKey(i), word0, l, j, flag);
            exiftag = exiftag1;
            if (!exiftag1.setValue(obj))
            {
                return null;
            }
        }
        return exiftag;
    }

    public ExifTag buildTag(int i, Object obj)
    {
        return buildTag(i, getTrueIfd(i), obj);
    }

    protected ExifTag buildUninitializedTag(int i)
    {
        int j = getTagInfo().get(i);
        if (j == 0)
        {
            return null;
        }
        short word0 = getTypeFromInfo(j);
        j = getComponentCountFromInfo(j);
        int k;
        boolean flag;
        if (j != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        k = getTrueIfd(i);
        return new ExifTag(getTrueTagKey(i), word0, j, k, flag);
    }

    public void clearExif()
    {
        mData = new ExifData(DEFAULT_BYTE_ORDER);
    }

    public void deleteTag(int i)
    {
        deleteTag(i, getDefinedTagDefaultIfd(i));
    }

    public void deleteTag(int i, int j)
    {
        mData.removeTag(getTrueTagKey(i), j);
    }

    public int getActualTagCount(int i, int j)
    {
        ExifTag exiftag = getTag(i, j);
        if (exiftag == null)
        {
            return 0;
        } else
        {
            return exiftag.getComponentCount();
        }
    }

    public List getAllTags()
    {
        return mData.getAllTags();
    }

    public double getAltitude(double d)
    {
        Byte byte1 = getTagByteValue(TAG_GPS_ALTITUDE_REF);
        Rational rational = getTagRationalValue(TAG_GPS_ALTITUDE);
        int i = 1;
        if (byte1 != null)
        {
            if (byte1.intValue() == 1)
            {
                i = -1;
            } else
            {
                i = 1;
            }
        }
        if (rational != null)
        {
            d = rational.toDouble() * (double)i;
        }
        return d;
    }

    public double getApertureSize()
    {
        double d1 = 0.0D;
        Rational rational = getTagRationalValue(TAG_F_NUMBER);
        double d;
        if (rational != null && rational.toDouble() > 0.0D)
        {
            d = rational.toDouble();
        } else
        {
            Rational rational1 = getTagRationalValue(TAG_APERTURE_VALUE);
            d = d1;
            if (rational1 != null)
            {
                d = d1;
                if (rational1.toDouble() > 0.0D)
                {
                    return Math.exp(rational1.toDouble() * Math.log(2D) * 0.5D);
                }
            }
        }
        return d;
    }

    public int getDefinedTagCount(int i)
    {
        i = getTagInfo().get(i);
        if (i == 0)
        {
            return 0;
        } else
        {
            return getComponentCountFromInfo(i);
        }
    }

    public int getDefinedTagDefaultIfd(int i)
    {
        if (getTagInfo().get(i) == 0)
        {
            return -1;
        } else
        {
            return getTrueIfd(i);
        }
    }

    public short getDefinedTagType(int i)
    {
        i = getTagInfo().get(i);
        if (i == 0)
        {
            return -1;
        } else
        {
            return getTypeFromInfo(i);
        }
    }

    public int[] getImageSize()
    {
        return mData.getImageSize();
    }

    public short getJpegProcess()
    {
        return mData.getJpegProcess();
    }

    public double[] getLatLongAsDoubles()
    {
        Rational arational[] = getTagRationalValues(TAG_GPS_LATITUDE);
        String s = getTagStringValue(TAG_GPS_LATITUDE_REF);
        Rational arational1[] = getTagRationalValues(TAG_GPS_LONGITUDE);
        String s1 = getTagStringValue(TAG_GPS_LONGITUDE_REF);
        if (arational == null || arational1 == null || s == null || s1 == null || arational.length < 3 || arational1.length < 3)
        {
            return null;
        } else
        {
            return (new double[] {
                convertLatOrLongToDouble(arational, s), convertLatOrLongToDouble(arational1, s1)
            });
        }
    }

    public String getLatitude()
    {
        Rational arational[] = getTagRationalValues(TAG_GPS_LATITUDE);
        String s = getTagStringValue(TAG_GPS_LATITUDE_REF);
        if (arational == null || s == null)
        {
            return null;
        } else
        {
            return convertRationalLatLonToString(arational, s);
        }
    }

    public String getLensModelDescription()
    {
        String s = getTagStringValue(TAG_LENS_MODEL);
        if (s != null)
        {
            return s;
        }
        Rational arational[] = getTagRationalValues(TAG_LENS_SPECS);
        if (arational != null)
        {
            return ExifUtil.processLensSpecifications(arational);
        } else
        {
            return null;
        }
    }

    public String getLongitude()
    {
        Rational arational[] = getTagRationalValues(TAG_GPS_LONGITUDE);
        String s = getTagStringValue(TAG_GPS_LONGITUDE_REF);
        if (arational == null || s == null)
        {
            return null;
        } else
        {
            return convertRationalLatLonToString(arational, s);
        }
    }

    public int getQualityGuess()
    {
        return mData.getQualityGuess();
    }

    public double getResolutionUnit(int i)
    {
        switch (i)
        {
        case 1: // '\001'
        case 2: // '\002'
        default:
            return 25.399999999999999D;

        case 3: // '\003'
            return 10D;

        case 4: // '\004'
            return 1.0D;

        case 5: // '\005'
            return 0.001D;
        }
    }

    public ExifTag getTag(int i)
    {
        return getTag(i, getDefinedTagDefaultIfd(i));
    }

    public ExifTag getTag(int i, int j)
    {
        if (!ExifTag.isValidIfd(j))
        {
            return null;
        } else
        {
            return mData.getTag(getTrueTagKey(i), j);
        }
    }

    public Byte getTagByteValue(int i)
    {
        return getTagByteValue(i, getDefinedTagDefaultIfd(i));
    }

    public Byte getTagByteValue(int i, int j)
    {
        byte abyte0[] = getTagByteValues(i, j);
        if (abyte0 == null || abyte0.length <= 0)
        {
            return null;
        } else
        {
            return new Byte(abyte0[0]);
        }
    }

    public byte[] getTagByteValues(int i)
    {
        return getTagByteValues(i, getDefinedTagDefaultIfd(i));
    }

    public byte[] getTagByteValues(int i, int j)
    {
        ExifTag exiftag = getTag(i, j);
        if (exiftag == null)
        {
            return null;
        } else
        {
            return exiftag.getValueAsBytes();
        }
    }

    protected int getTagDefinition(short word0, int i)
    {
        return getTagInfo().get(defineTag(i, word0));
    }

    protected int getTagDefinitionForTag(ExifTag exiftag)
    {
        short word0 = exiftag.getDataType();
        int i = exiftag.getComponentCount();
        int j = exiftag.getIfd();
        return getTagDefinitionForTag(exiftag.getTagId(), word0, i, j);
    }

    protected int getTagDefinitionForTag(short word0, short word1, int i, int j)
    {
        int ai[] = getTagDefinitionsForTagId(word0);
        if (ai != null)
        {
            SparseIntArray sparseintarray = getTagInfo();
            int i1 = ai.length;
            int k = 0;
            while (k < i1) 
            {
                int j1 = ai[k];
                int l = sparseintarray.get(j1);
                short word2 = getTypeFromInfo(l);
                int k1 = getComponentCountFromInfo(l);
                int ai1[] = getAllowedIfdsFromInfo(l);
                boolean flag1 = false;
                int l1 = ai1.length;
                l = 0;
label0:
                do
                {
label1:
                    {
                        boolean flag = flag1;
                        if (l < l1)
                        {
                            if (ai1[l] != j)
                            {
                                break label1;
                            }
                            flag = true;
                        }
                        if (flag && word1 == word2 && (i == k1 || k1 == 0))
                        {
                            return j1;
                        }
                        break label0;
                    }
                    l++;
                } while (true);
                k++;
            }
        }
_L2:
        return -1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected int[] getTagDefinitionsForTagId(short word0)
    {
        int ai[] = IfdData.getIfds();
        int ai1[] = new int[ai.length];
        SparseIntArray sparseintarray = getTagInfo();
        int l = ai.length;
        int j = 0;
        int i = 0;
        for (; j < l; j++)
        {
            int i1 = defineTag(ai[j], word0);
            if (sparseintarray.get(i1) != 0)
            {
                int k = i + 1;
                ai1[i] = i1;
                i = k;
            }
        }

        if (i == 0)
        {
            return null;
        } else
        {
            return Arrays.copyOfRange(ai1, 0, i);
        }
    }

    protected SparseIntArray getTagInfo()
    {
        if (mTagInfo == null)
        {
            mTagInfo = new SparseIntArray();
            initTagInfo();
        }
        return mTagInfo;
    }

    public Integer getTagIntValue(int i)
    {
        return getTagIntValue(i, getDefinedTagDefaultIfd(i));
    }

    public Integer getTagIntValue(int i, int j)
    {
        int ai[] = getTagIntValues(i, j);
        if (ai == null || ai.length <= 0)
        {
            return null;
        } else
        {
            return new Integer(ai[0]);
        }
    }

    public int[] getTagIntValues(int i)
    {
        return getTagIntValues(i, getDefinedTagDefaultIfd(i));
    }

    public int[] getTagIntValues(int i, int j)
    {
        ExifTag exiftag = getTag(i, j);
        if (exiftag == null)
        {
            return null;
        } else
        {
            return exiftag.getValueAsInts();
        }
    }

    public Long getTagLongValue(int i)
    {
        return getTagLongValue(i, getDefinedTagDefaultIfd(i));
    }

    public Long getTagLongValue(int i, int j)
    {
        long al[] = getTagLongValues(i, j);
        if (al == null || al.length <= 0)
        {
            return null;
        } else
        {
            return new Long(al[0]);
        }
    }

    public long[] getTagLongValues(int i)
    {
        return getTagLongValues(i, getDefinedTagDefaultIfd(i));
    }

    public long[] getTagLongValues(int i, int j)
    {
        ExifTag exiftag = getTag(i, j);
        if (exiftag == null)
        {
            return null;
        } else
        {
            return exiftag.getValueAsLongs();
        }
    }

    public Rational getTagRationalValue(int i)
    {
        return getTagRationalValue(i, getDefinedTagDefaultIfd(i));
    }

    public Rational getTagRationalValue(int i, int j)
    {
        Rational arational[] = getTagRationalValues(i, j);
        if (arational == null || arational.length == 0)
        {
            return null;
        } else
        {
            return new Rational(arational[0]);
        }
    }

    public Rational[] getTagRationalValues(int i)
    {
        return getTagRationalValues(i, getDefinedTagDefaultIfd(i));
    }

    public Rational[] getTagRationalValues(int i, int j)
    {
        ExifTag exiftag = getTag(i, j);
        if (exiftag == null)
        {
            return null;
        } else
        {
            return exiftag.getValueAsRationals();
        }
    }

    public String getTagStringValue(int i)
    {
        return getTagStringValue(i, getDefinedTagDefaultIfd(i));
    }

    public String getTagStringValue(int i, int j)
    {
        ExifTag exiftag = getTag(i, j);
        if (exiftag == null)
        {
            return null;
        } else
        {
            return exiftag.getValueAsString();
        }
    }

    public Object getTagValue(int i)
    {
        return getTagValue(i, getDefinedTagDefaultIfd(i));
    }

    public Object getTagValue(int i, int j)
    {
        ExifTag exiftag = getTag(i, j);
        if (exiftag == null)
        {
            return null;
        } else
        {
            return exiftag.getValue();
        }
    }

    public List getTagsForIfdId(int i)
    {
        return mData.getAllTagsForIfd(i);
    }

    public List getTagsForTagId(short word0)
    {
        return mData.getAllTagsForTagId(word0);
    }

    public byte[] getThumbnail()
    {
        return mData.getCompressedThumbnail();
    }

    public Bitmap getThumbnailBitmap()
    {
        if (mData.hasCompressedThumbnail())
        {
            byte abyte0[] = mData.getCompressedThumbnail();
            return BitmapFactory.decodeByteArray(abyte0, 0, abyte0.length);
        } else
        {
            if (!mData.hasUncompressedStrip());
            return null;
        }
    }

    public byte[] getThumbnailBytes()
    {
        if (mData.hasCompressedThumbnail())
        {
            return mData.getCompressedThumbnail();
        } else
        {
            if (!mData.hasUncompressedStrip());
            return null;
        }
    }

    public String getUserComment()
    {
        return mData.getUserComment();
    }

    public boolean hasThumbnail()
    {
        return mData.hasCompressedThumbnail();
    }

    public boolean isTagCountDefined(int i)
    {
        i = getTagInfo().get(i);
        return i != 0 && getComponentCountFromInfo(i) != 0;
    }

    public boolean isThumbnailCompressed()
    {
        return mData.hasCompressedThumbnail();
    }

    public void readExif(InputStream inputstream, int i)
        throws IOException
    {
        if (inputstream == null)
        {
            throw new IllegalArgumentException("Argument is null");
        }
        try
        {
            inputstream = (new ExifReader(this)).read(inputstream, i);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new IOException((new StringBuilder()).append("Invalid exif format : ").append(inputstream).toString());
        }
        mData = inputstream;
    }

    public void readExif(String s, int i)
        throws IOException
    {
        Object obj;
        if (s == null)
        {
            throw new IllegalArgumentException("Argument is null");
        }
        obj = null;
        s = new BufferedInputStream(new FileInputStream(s));
        readExif(((InputStream) (s)), i);
        s.close();
        return;
        s;
_L2:
        closeSilently(((Closeable) (obj)));
        throw s;
        IOException ioexception;
        ioexception;
        obj = s;
        s = ioexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void readExif(byte abyte0[], int i)
        throws IOException
    {
        readExif(((InputStream) (new ByteArrayInputStream(abyte0))), i);
    }

    public void removeCompressedThumbnail()
    {
        mData.setCompressedThumbnail(null);
    }

    public void removeTagDefinition(int i)
    {
        getTagInfo().delete(i);
    }

    public void resetTagDefinitions()
    {
        mTagInfo = null;
    }

    public boolean setCompressedThumbnail(Bitmap bitmap)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        if (!bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 90, bytearrayoutputstream))
        {
            return false;
        } else
        {
            return setCompressedThumbnail(bytearrayoutputstream.toByteArray());
        }
    }

    public boolean setCompressedThumbnail(byte abyte0[])
    {
        mData.clearThumbnailAndStrips();
        mData.setCompressedThumbnail(abyte0);
        return true;
    }

    public void setExif(Collection collection)
    {
        clearExif();
        setTags(collection);
    }

    public ExifTag setTag(ExifTag exiftag)
    {
        return mData.addTag(exiftag);
    }

    public int setTagDefinition(short word0, int i, short word1, short word2, int ai[])
    {
        if (sBannedDefines.contains(Short.valueOf(word0)))
        {
            return -1;
        }
        if (ExifTag.isValidType(word1) && ExifTag.isValidIfd(i))
        {
            int i1 = defineTag(i, word0);
            if (i1 == -1)
            {
                return -1;
            }
            int ai1[] = getTagDefinitionsForTagId(word0);
            SparseIntArray sparseintarray = getTagInfo();
            boolean flag = false;
            int j1 = ai.length;
            for (int j = 0; j < j1; j++)
            {
                int k1 = ai[j];
                if (i == k1)
                {
                    flag = true;
                }
                if (!ExifTag.isValidIfd(k1))
                {
                    return -1;
                }
            }

            if (!flag)
            {
                return -1;
            }
            int k = getFlagsFromAllowedIfds(ai);
            if (ai1 != null)
            {
                int l = ai1.length;
                for (i = 0; i < l; i++)
                {
                    if ((k & getAllowedIfdFlagsFromInfo(sparseintarray.get(ai1[i]))) != 0)
                    {
                        return -1;
                    }
                }

            }
            getTagInfo().put(i1, k << 24 | word1 << 16 | word2);
            return i1;
        } else
        {
            return -1;
        }
    }

    public boolean setTagValue(int i, int j, Object obj)
    {
        ExifTag exiftag = getTag(i, j);
        return exiftag != null && exiftag.setValue(obj);
    }

    public boolean setTagValue(int i, Object obj)
    {
        return setTagValue(i, getDefinedTagDefaultIfd(i), obj);
    }

    public void setTags(Collection collection)
    {
        if (collection != null)
        {
            collection = collection.iterator();
            while (collection.hasNext()) 
            {
                setTag((ExifTag)collection.next());
            }
        }
    }

    public void writeExif(Bitmap bitmap, String s, int i)
        throws IOException
    {
        Log.i("ExifInterface", (new StringBuilder()).append("writeExif: ").append(s).toString());
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, i, bytearrayoutputstream);
        bitmap = new ByteArrayInputStream(bytearrayoutputstream.toByteArray());
        bytearrayoutputstream.close();
        writeExif(((InputStream) (bitmap)), s);
    }

    public void writeExif(InputStream inputstream, String s)
        throws IOException
    {
        Log.i("ExifInterface", (new StringBuilder()).append("writeExif: ").append(s).toString());
        s = new FileOutputStream(s);
        writeExif_internal(inputstream, s, mData);
        IOUtils.copy(inputstream, s);
        s.flush();
        s.close();
    }

    public void writeExif(String s)
        throws IOException
    {
        File file;
        Log.i("ExifInterface", (new StringBuilder()).append("writeExif: ").append(s).toString());
        file = new File(s);
        s = new File((new StringBuilder()).append(s).append(".t").toString());
        s.delete();
        writeExif(file.getAbsolutePath(), s.getAbsolutePath());
        s.renameTo(file);
        s.delete();
        return;
        Object obj;
        obj;
        throw obj;
        obj;
        s.delete();
        throw obj;
    }

    public void writeExif(String s, String s1)
        throws IOException
    {
        Log.i("ExifInterface", (new StringBuilder()).append("writeExif: ").append(s1).toString());
        if (s.equals(s1))
        {
            return;
        } else
        {
            s = new FileInputStream(s);
            s1 = new FileOutputStream(s1);
            int i = writeExif_internal(s, s1, mData);
            FileChannel filechannel = s.getChannel();
            FileChannel filechannel1 = s1.getChannel();
            filechannel.transferTo(i, filechannel.size() - (long)i, filechannel1);
            s1.flush();
            IOUtils.closeQuietly(s);
            IOUtils.closeQuietly(s1);
            return;
        }
    }

    static 
    {
        TAG_STRIP_OFFSETS = defineTag(0, (short)273);
        TAG_STRIP_BYTE_COUNTS = defineTag(0, (short)279);
        TAG_EXIF_IFD = defineTag(0, (short)-30871);
        TAG_GPS_IFD = defineTag(0, (short)-30683);
        TAG_JPEG_INTERCHANGE_FORMAT = defineTag(1, (short)513);
        TAG_JPEG_INTERCHANGE_FORMAT_LENGTH = defineTag(1, (short)514);
        TAG_INTEROPERABILITY_IFD = defineTag(2, (short)-24571);
        DEFAULT_BYTE_ORDER = ByteOrder.BIG_ENDIAN;
        sOffsetTags = new HashSet();
        sOffsetTags.add(Short.valueOf(getTrueTagKey(TAG_GPS_IFD)));
        sOffsetTags.add(Short.valueOf(getTrueTagKey(TAG_EXIF_IFD)));
        sOffsetTags.add(Short.valueOf(getTrueTagKey(TAG_JPEG_INTERCHANGE_FORMAT)));
        sOffsetTags.add(Short.valueOf(getTrueTagKey(TAG_INTEROPERABILITY_IFD)));
        sOffsetTags.add(Short.valueOf(getTrueTagKey(TAG_STRIP_OFFSETS)));
        sBannedDefines = new HashSet(sOffsetTags);
        sBannedDefines.add(Short.valueOf(getTrueTagKey(-1)));
        sBannedDefines.add(Short.valueOf(getTrueTagKey(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH)));
        sBannedDefines.add(Short.valueOf(getTrueTagKey(TAG_STRIP_BYTE_COUNTS)));
    }
}
