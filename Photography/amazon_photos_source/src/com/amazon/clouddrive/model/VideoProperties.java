// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model;


public class VideoProperties
    implements Comparable
{

    private Double audioBitrate;
    private String audioChannelLayout;
    private Integer audioChannels;
    private String audioCodec;
    private Double audioSampleRate;
    private Double bitrate;
    private String creationDate;
    private Double duration;
    private String encoder;
    private Integer height;
    private String location;
    private String make;
    private String model;
    private Integer rotate;
    private String title;
    private Double videoBitrate;
    private String videoCodec;
    private Double videoFrameRate;
    private Integer width;

    public VideoProperties()
    {
    }

    public int compareTo(VideoProperties videoproperties)
    {
        if (videoproperties != null) goto _L2; else goto _L1
_L1:
        int i = -1;
_L6:
        return i;
_L2:
        Object obj;
        Object obj1;
        if (videoproperties == this)
        {
            return 0;
        }
        obj = getTitle();
        obj1 = videoproperties.getTitle();
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
        obj = getBitrate();
        obj1 = videoproperties.getBitrate();
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
        obj = getVideoFrameRate();
        obj1 = videoproperties.getVideoFrameRate();
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
        obj = getCreationDate();
        obj1 = videoproperties.getCreationDate();
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
        obj = getModel();
        obj1 = videoproperties.getModel();
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
        obj = getVideoBitrate();
        obj1 = videoproperties.getVideoBitrate();
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
        obj = getAudioCodec();
        obj1 = videoproperties.getAudioCodec();
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
        obj = getRotate();
        obj1 = videoproperties.getRotate();
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
        obj = getDuration();
        obj1 = videoproperties.getDuration();
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
        obj = getEncoder();
        obj1 = videoproperties.getEncoder();
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
        obj = getLocation();
        obj1 = videoproperties.getLocation();
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
        obj = getAudioBitrate();
        obj1 = videoproperties.getAudioBitrate();
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
        obj = getAudioSampleRate();
        obj1 = videoproperties.getAudioSampleRate();
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
        obj = getMake();
        obj1 = videoproperties.getMake();
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
        obj = getVideoCodec();
        obj1 = videoproperties.getVideoCodec();
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
        obj = getHeight();
        obj1 = videoproperties.getHeight();
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
        obj = getAudioChannels();
        obj1 = videoproperties.getAudioChannels();
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
        obj = getWidth();
        obj1 = videoproperties.getWidth();
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
        obj = getAudioChannelLayout();
        videoproperties = videoproperties.getAudioChannelLayout();
        if (obj == videoproperties)
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
        if (videoproperties == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L77; else goto _L76
_L76:
        k = ((Comparable)obj).compareTo(videoproperties);
        i = k;
        if (k != 0) goto _L6; else goto _L78
_L78:
        return 0;
_L77:
        if (!obj.equals(videoproperties))
        {
            int j = obj.hashCode();
            int l = videoproperties.hashCode();
            if (j < l)
            {
                return -1;
            }
            if (j > l)
            {
                return 1;
            }
        }
        if (true) goto _L78; else goto _L79
_L79:
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((VideoProperties)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof VideoProperties)
            {
                if (compareTo((VideoProperties)obj) != 0)
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

    public Double getAudioBitrate()
    {
        return audioBitrate;
    }

    public String getAudioChannelLayout()
    {
        return audioChannelLayout;
    }

    public Integer getAudioChannels()
    {
        return audioChannels;
    }

    public String getAudioCodec()
    {
        return audioCodec;
    }

    public Double getAudioSampleRate()
    {
        return audioSampleRate;
    }

    public Double getBitrate()
    {
        return bitrate;
    }

    public String getCreationDate()
    {
        return creationDate;
    }

    public Double getDuration()
    {
        return duration;
    }

    public String getEncoder()
    {
        return encoder;
    }

    public Integer getHeight()
    {
        return height;
    }

    public String getLocation()
    {
        return location;
    }

    public String getMake()
    {
        return make;
    }

    public String getModel()
    {
        return model;
    }

    public Integer getRotate()
    {
        return rotate;
    }

    public String getTitle()
    {
        return title;
    }

    public Double getVideoBitrate()
    {
        return videoBitrate;
    }

    public String getVideoCodec()
    {
        return videoCodec;
    }

    public Double getVideoFrameRate()
    {
        return videoFrameRate;
    }

    public Integer getWidth()
    {
        return width;
    }

    public int hashCode()
    {
        int k4 = 0;
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
        if (getTitle() == null)
        {
            i = 0;
        } else
        {
            i = getTitle().hashCode();
        }
        if (getBitrate() == null)
        {
            j = 0;
        } else
        {
            j = getBitrate().hashCode();
        }
        if (getVideoFrameRate() == null)
        {
            k = 0;
        } else
        {
            k = getVideoFrameRate().hashCode();
        }
        if (getCreationDate() == null)
        {
            l = 0;
        } else
        {
            l = getCreationDate().hashCode();
        }
        if (getModel() == null)
        {
            i1 = 0;
        } else
        {
            i1 = getModel().hashCode();
        }
        if (getVideoBitrate() == null)
        {
            j1 = 0;
        } else
        {
            j1 = getVideoBitrate().hashCode();
        }
        if (getAudioCodec() == null)
        {
            k1 = 0;
        } else
        {
            k1 = getAudioCodec().hashCode();
        }
        if (getRotate() == null)
        {
            l1 = 0;
        } else
        {
            l1 = getRotate().hashCode();
        }
        if (getDuration() == null)
        {
            i2 = 0;
        } else
        {
            i2 = getDuration().hashCode();
        }
        if (getEncoder() == null)
        {
            j2 = 0;
        } else
        {
            j2 = getEncoder().hashCode();
        }
        if (getLocation() == null)
        {
            k2 = 0;
        } else
        {
            k2 = getLocation().hashCode();
        }
        if (getAudioBitrate() == null)
        {
            l2 = 0;
        } else
        {
            l2 = getAudioBitrate().hashCode();
        }
        if (getAudioSampleRate() == null)
        {
            i3 = 0;
        } else
        {
            i3 = getAudioSampleRate().hashCode();
        }
        if (getMake() == null)
        {
            j3 = 0;
        } else
        {
            j3 = getMake().hashCode();
        }
        if (getVideoCodec() == null)
        {
            k3 = 0;
        } else
        {
            k3 = getVideoCodec().hashCode();
        }
        if (getHeight() == null)
        {
            l3 = 0;
        } else
        {
            l3 = getHeight().hashCode();
        }
        if (getAudioChannels() == null)
        {
            i4 = 0;
        } else
        {
            i4 = getAudioChannels().hashCode();
        }
        if (getWidth() == null)
        {
            j4 = 0;
        } else
        {
            j4 = getWidth().hashCode();
        }
        if (getAudioChannelLayout() != null)
        {
            k4 = getAudioChannelLayout().hashCode();
        }
        return 1 + i + j + k + l + i1 + j1 + k1 + l1 + i2 + j2 + k2 + l2 + i3 + j3 + k3 + l3 + i4 + j4 + k4;
    }

    public void setAudioBitrate(Double double1)
    {
        audioBitrate = double1;
    }

    public void setAudioChannelLayout(String s)
    {
        audioChannelLayout = s;
    }

    public void setAudioChannels(Integer integer)
    {
        audioChannels = integer;
    }

    public void setAudioCodec(String s)
    {
        audioCodec = s;
    }

    public void setAudioSampleRate(Double double1)
    {
        audioSampleRate = double1;
    }

    public void setBitrate(Double double1)
    {
        bitrate = double1;
    }

    public void setCreationDate(String s)
    {
        creationDate = s;
    }

    public void setDuration(Double double1)
    {
        duration = double1;
    }

    public void setEncoder(String s)
    {
        encoder = s;
    }

    public void setHeight(Integer integer)
    {
        height = integer;
    }

    public void setLocation(String s)
    {
        location = s;
    }

    public void setMake(String s)
    {
        make = s;
    }

    public void setModel(String s)
    {
        model = s;
    }

    public void setRotate(Integer integer)
    {
        rotate = integer;
    }

    public void setTitle(String s)
    {
        title = s;
    }

    public void setVideoBitrate(Double double1)
    {
        videoBitrate = double1;
    }

    public void setVideoCodec(String s)
    {
        videoCodec = s;
    }

    public void setVideoFrameRate(Double double1)
    {
        videoFrameRate = double1;
    }

    public void setWidth(Integer integer)
    {
        width = integer;
    }
}
