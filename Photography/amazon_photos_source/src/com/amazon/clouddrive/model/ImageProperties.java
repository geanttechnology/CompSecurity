// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model;


public class ImageProperties
    implements Comparable
{

    private String apertureValue;
    private String captureMode;
    private String colorSpace;
    private String dateTime;
    private String dateTimeDigitized;
    private String dateTimeOriginal;
    private String exposureMode;
    private String exposureProgram;
    private String exposureTime;
    private String flash;
    private String focalLength;
    private String gpsTimeStamp;
    private Integer height;
    private String isoSpeedRatings;
    private String location;
    private String make;
    private String meteringMode;
    private String model;
    private String orientation;
    private String resolutionUnit;
    private String sensingMethod;
    private String sharpness;
    private String software;
    private String whiteBalance;
    private Integer width;
    private String xResolution;
    private String yResolution;

    public ImageProperties()
    {
    }

    public int compareTo(ImageProperties imageproperties)
    {
        if (imageproperties != null) goto _L2; else goto _L1
_L1:
        int i = -1;
_L6:
        return i;
_L2:
        Object obj;
        Object obj1;
        if (imageproperties == this)
        {
            return 0;
        }
        obj = getYResolution();
        obj1 = imageproperties.getYResolution();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L4; else goto _L3
_L3:
        int k;
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L5
_L5:
        obj = getDateTimeDigitized();
        obj1 = imageproperties.getDateTimeDigitized();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L5; else goto _L7
_L7:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L9; else goto _L8
_L8:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L10
_L10:
        obj = getWhiteBalance();
        obj1 = imageproperties.getWhiteBalance();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L9:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L10; else goto _L11
_L11:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L13; else goto _L12
_L12:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L14
_L14:
        obj = getWidth();
        obj1 = imageproperties.getWidth();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L13:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L14; else goto _L15
_L15:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L17; else goto _L16
_L16:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L18
_L18:
        obj = getFocalLength();
        obj1 = imageproperties.getFocalLength();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L17:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L18; else goto _L19
_L19:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L21; else goto _L20
_L20:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L22
_L22:
        obj = getMeteringMode();
        obj1 = imageproperties.getMeteringMode();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L21:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L22; else goto _L23
_L23:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L25; else goto _L24
_L24:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L26
_L26:
        obj = getSoftware();
        obj1 = imageproperties.getSoftware();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L25:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L26; else goto _L27
_L27:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L29; else goto _L28
_L28:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L30
_L30:
        obj = getIsoSpeedRatings();
        obj1 = imageproperties.getIsoSpeedRatings();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L29:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L30; else goto _L31
_L31:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L33; else goto _L32
_L32:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L34
_L34:
        obj = getOrientation();
        obj1 = imageproperties.getOrientation();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L33:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L34; else goto _L35
_L35:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L37; else goto _L36
_L36:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L38
_L38:
        obj = getColorSpace();
        obj1 = imageproperties.getColorSpace();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L37:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L38; else goto _L39
_L39:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L41; else goto _L40
_L40:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L42
_L42:
        obj = getDateTime();
        obj1 = imageproperties.getDateTime();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L41:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L42; else goto _L43
_L43:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L45; else goto _L44
_L44:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L46
_L46:
        obj = getSharpness();
        obj1 = imageproperties.getSharpness();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L45:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L46; else goto _L47
_L47:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L49; else goto _L48
_L48:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L50
_L50:
        obj = getFlash();
        obj1 = imageproperties.getFlash();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L49:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L50; else goto _L51
_L51:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L53; else goto _L52
_L52:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L54
_L54:
        obj = getLocation();
        obj1 = imageproperties.getLocation();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L53:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L54; else goto _L55
_L55:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L57; else goto _L56
_L56:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L58
_L58:
        obj = getExposureMode();
        obj1 = imageproperties.getExposureMode();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L57:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L58; else goto _L59
_L59:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L61; else goto _L60
_L60:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L62
_L62:
        obj = getDateTimeOriginal();
        obj1 = imageproperties.getDateTimeOriginal();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L61:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L62; else goto _L63
_L63:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L65; else goto _L64
_L64:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L66
_L66:
        obj = getModel();
        obj1 = imageproperties.getModel();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L65:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L66; else goto _L67
_L67:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L69; else goto _L68
_L68:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L70
_L70:
        obj = getMake();
        obj1 = imageproperties.getMake();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L69:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L70; else goto _L71
_L71:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L73; else goto _L72
_L72:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L74
_L74:
        obj = getExposureProgram();
        obj1 = imageproperties.getExposureProgram();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L73:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L74; else goto _L75
_L75:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L77; else goto _L76
_L76:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L78
_L78:
        obj = getSensingMethod();
        obj1 = imageproperties.getSensingMethod();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L77:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L78; else goto _L79
_L79:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L81; else goto _L80
_L80:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L82
_L82:
        obj = getXResolution();
        obj1 = imageproperties.getXResolution();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L81:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L82; else goto _L83
_L83:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L85; else goto _L84
_L84:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L86
_L86:
        obj = getGpsTimeStamp();
        obj1 = imageproperties.getGpsTimeStamp();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L85:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L86; else goto _L87
_L87:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L89; else goto _L88
_L88:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L90
_L90:
        obj = getApertureValue();
        obj1 = imageproperties.getApertureValue();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L89:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L90; else goto _L91
_L91:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L93; else goto _L92
_L92:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L94
_L94:
        obj = getExposureTime();
        obj1 = imageproperties.getExposureTime();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L93:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L94; else goto _L95
_L95:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L97; else goto _L96
_L96:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L98
_L98:
        obj = getResolutionUnit();
        obj1 = imageproperties.getResolutionUnit();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L97:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L98; else goto _L99
_L99:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L101; else goto _L100
_L100:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L102
_L102:
        obj = getHeight();
        obj1 = imageproperties.getHeight();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L101:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L102; else goto _L103
_L103:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L105; else goto _L104
_L104:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L106
_L106:
        obj = getCaptureMode();
        imageproperties = imageproperties.getCaptureMode();
        if (obj == imageproperties)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L105:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L106; else goto _L107
_L107:
        if (imageproperties == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L109; else goto _L108
_L108:
        k = ((Comparable)obj).compareTo(imageproperties);
        i = k;
        if (k != 0) goto _L6; else goto _L110
_L110:
        return 0;
_L109:
        if (!obj.equals(imageproperties))
        {
            int j = obj.hashCode();
            int l = imageproperties.hashCode();
            if (j < l)
            {
                return -1;
            }
            if (j > l)
            {
                return 1;
            }
        }
        if (true) goto _L110; else goto _L111
_L111:
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((ImageProperties)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof ImageProperties)
            {
                if (compareTo((ImageProperties)obj) != 0)
                {
                    return false;
                }
            } else
            {
                return false;
            }
        }
        return true;
    }

    public String getApertureValue()
    {
        return apertureValue;
    }

    public String getCaptureMode()
    {
        return captureMode;
    }

    public String getColorSpace()
    {
        return colorSpace;
    }

    public String getDateTime()
    {
        return dateTime;
    }

    public String getDateTimeDigitized()
    {
        return dateTimeDigitized;
    }

    public String getDateTimeOriginal()
    {
        return dateTimeOriginal;
    }

    public String getExposureMode()
    {
        return exposureMode;
    }

    public String getExposureProgram()
    {
        return exposureProgram;
    }

    public String getExposureTime()
    {
        return exposureTime;
    }

    public String getFlash()
    {
        return flash;
    }

    public String getFocalLength()
    {
        return focalLength;
    }

    public String getGpsTimeStamp()
    {
        return gpsTimeStamp;
    }

    public Integer getHeight()
    {
        return height;
    }

    public String getIsoSpeedRatings()
    {
        return isoSpeedRatings;
    }

    public String getLocation()
    {
        return location;
    }

    public String getMake()
    {
        return make;
    }

    public String getMeteringMode()
    {
        return meteringMode;
    }

    public String getModel()
    {
        return model;
    }

    public String getOrientation()
    {
        return orientation;
    }

    public String getResolutionUnit()
    {
        return resolutionUnit;
    }

    public String getSensingMethod()
    {
        return sensingMethod;
    }

    public String getSharpness()
    {
        return sharpness;
    }

    public String getSoftware()
    {
        return software;
    }

    public String getWhiteBalance()
    {
        return whiteBalance;
    }

    public Integer getWidth()
    {
        return width;
    }

    public String getXResolution()
    {
        return xResolution;
    }

    public String getYResolution()
    {
        return yResolution;
    }

    public int hashCode()
    {
        int k6 = 0;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        int k3;
        int l3;
        int i4;
        int j4;
        int k4;
        int l4;
        int i5;
        int j5;
        int k5;
        int l5;
        int i6;
        int j6;
        if (getYResolution() == null)
        {
            i = 0;
        } else
        {
            i = getYResolution().hashCode();
        }
        if (getDateTimeDigitized() == null)
        {
            j = 0;
        } else
        {
            j = getDateTimeDigitized().hashCode();
        }
        if (getWhiteBalance() == null)
        {
            k = 0;
        } else
        {
            k = getWhiteBalance().hashCode();
        }
        if (getWidth() == null)
        {
            l = 0;
        } else
        {
            l = getWidth().hashCode();
        }
        if (getFocalLength() == null)
        {
            i1 = 0;
        } else
        {
            i1 = getFocalLength().hashCode();
        }
        if (getMeteringMode() == null)
        {
            j1 = 0;
        } else
        {
            j1 = getMeteringMode().hashCode();
        }
        if (getSoftware() == null)
        {
            k1 = 0;
        } else
        {
            k1 = getSoftware().hashCode();
        }
        if (getIsoSpeedRatings() == null)
        {
            l1 = 0;
        } else
        {
            l1 = getIsoSpeedRatings().hashCode();
        }
        if (getOrientation() == null)
        {
            i2 = 0;
        } else
        {
            i2 = getOrientation().hashCode();
        }
        if (getColorSpace() == null)
        {
            j2 = 0;
        } else
        {
            j2 = getColorSpace().hashCode();
        }
        if (getDateTime() == null)
        {
            k2 = 0;
        } else
        {
            k2 = getDateTime().hashCode();
        }
        if (getSharpness() == null)
        {
            l2 = 0;
        } else
        {
            l2 = getSharpness().hashCode();
        }
        if (getFlash() == null)
        {
            i3 = 0;
        } else
        {
            i3 = getFlash().hashCode();
        }
        if (getLocation() == null)
        {
            j3 = 0;
        } else
        {
            j3 = getLocation().hashCode();
        }
        if (getExposureMode() == null)
        {
            k3 = 0;
        } else
        {
            k3 = getExposureMode().hashCode();
        }
        if (getDateTimeOriginal() == null)
        {
            l3 = 0;
        } else
        {
            l3 = getDateTimeOriginal().hashCode();
        }
        if (getModel() == null)
        {
            i4 = 0;
        } else
        {
            i4 = getModel().hashCode();
        }
        if (getMake() == null)
        {
            j4 = 0;
        } else
        {
            j4 = getMake().hashCode();
        }
        if (getExposureProgram() == null)
        {
            k4 = 0;
        } else
        {
            k4 = getExposureProgram().hashCode();
        }
        if (getSensingMethod() == null)
        {
            l4 = 0;
        } else
        {
            l4 = getSensingMethod().hashCode();
        }
        if (getXResolution() == null)
        {
            i5 = 0;
        } else
        {
            i5 = getXResolution().hashCode();
        }
        if (getGpsTimeStamp() == null)
        {
            j5 = 0;
        } else
        {
            j5 = getGpsTimeStamp().hashCode();
        }
        if (getApertureValue() == null)
        {
            k5 = 0;
        } else
        {
            k5 = getApertureValue().hashCode();
        }
        if (getExposureTime() == null)
        {
            l5 = 0;
        } else
        {
            l5 = getExposureTime().hashCode();
        }
        if (getResolutionUnit() == null)
        {
            i6 = 0;
        } else
        {
            i6 = getResolutionUnit().hashCode();
        }
        if (getHeight() == null)
        {
            j6 = 0;
        } else
        {
            j6 = getHeight().hashCode();
        }
        if (getCaptureMode() != null)
        {
            k6 = getCaptureMode().hashCode();
        }
        return 1 + i + j + k + l + i1 + j1 + k1 + l1 + i2 + j2 + k2 + l2 + i3 + j3 + k3 + l3 + i4 + j4 + k4 + l4 + i5 + j5 + k5 + l5 + i6 + j6 + k6;
    }

    public void setApertureValue(String s)
    {
        apertureValue = s;
    }

    public void setCaptureMode(String s)
    {
        captureMode = s;
    }

    public void setColorSpace(String s)
    {
        colorSpace = s;
    }

    public void setDateTime(String s)
    {
        dateTime = s;
    }

    public void setDateTimeDigitized(String s)
    {
        dateTimeDigitized = s;
    }

    public void setDateTimeOriginal(String s)
    {
        dateTimeOriginal = s;
    }

    public void setExposureMode(String s)
    {
        exposureMode = s;
    }

    public void setExposureProgram(String s)
    {
        exposureProgram = s;
    }

    public void setExposureTime(String s)
    {
        exposureTime = s;
    }

    public void setFlash(String s)
    {
        flash = s;
    }

    public void setFocalLength(String s)
    {
        focalLength = s;
    }

    public void setGpsTimeStamp(String s)
    {
        gpsTimeStamp = s;
    }

    public void setHeight(Integer integer)
    {
        height = integer;
    }

    public void setIsoSpeedRatings(String s)
    {
        isoSpeedRatings = s;
    }

    public void setLocation(String s)
    {
        location = s;
    }

    public void setMake(String s)
    {
        make = s;
    }

    public void setMeteringMode(String s)
    {
        meteringMode = s;
    }

    public void setModel(String s)
    {
        model = s;
    }

    public void setOrientation(String s)
    {
        orientation = s;
    }

    public void setResolutionUnit(String s)
    {
        resolutionUnit = s;
    }

    public void setSensingMethod(String s)
    {
        sensingMethod = s;
    }

    public void setSharpness(String s)
    {
        sharpness = s;
    }

    public void setSoftware(String s)
    {
        software = s;
    }

    public void setWhiteBalance(String s)
    {
        whiteBalance = s;
    }

    public void setWidth(Integer integer)
    {
        width = integer;
    }

    public void setXResolution(String s)
    {
        xResolution = s;
    }

    public void setYResolution(String s)
    {
        yResolution = s;
    }
}
