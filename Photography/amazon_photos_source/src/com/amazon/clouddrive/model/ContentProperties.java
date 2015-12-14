// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model;


// Referenced classes of package com.amazon.clouddrive.model:
//            DocumentProperties, VideoProperties, ImageProperties

public class ContentProperties
    implements Comparable
{

    private String contentDate;
    private String contentType;
    private DocumentProperties document;
    private String extension;
    private ImageProperties image;
    private String md5;
    private Long size;
    private Long version;
    private VideoProperties video;

    public ContentProperties()
    {
    }

    public int compareTo(ContentProperties contentproperties)
    {
        if (contentproperties != null) goto _L2; else goto _L1
_L1:
        int i = -1;
_L6:
        return i;
_L2:
        Object obj;
        Object obj1;
        if (contentproperties == this)
        {
            return 0;
        }
        obj = getContentType();
        obj1 = contentproperties.getContentType();
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
        obj = getExtension();
        obj1 = contentproperties.getExtension();
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
        obj = getMd5();
        obj1 = contentproperties.getMd5();
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
        obj = getDocument();
        obj1 = contentproperties.getDocument();
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
        obj = getVideo();
        obj1 = contentproperties.getVideo();
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
        obj = getContentDate();
        obj1 = contentproperties.getContentDate();
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
        obj = getSize();
        obj1 = contentproperties.getSize();
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
        obj = getVersion();
        obj1 = contentproperties.getVersion();
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
        obj = getImage();
        contentproperties = contentproperties.getImage();
        if (obj == contentproperties)
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
        if (contentproperties == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L37; else goto _L36
_L36:
        k = ((Comparable)obj).compareTo(contentproperties);
        i = k;
        if (k != 0) goto _L6; else goto _L38
_L38:
        return 0;
_L37:
        if (!obj.equals(contentproperties))
        {
            int j = obj.hashCode();
            int l = contentproperties.hashCode();
            if (j < l)
            {
                return -1;
            }
            if (j > l)
            {
                return 1;
            }
        }
        if (true) goto _L38; else goto _L39
_L39:
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((ContentProperties)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof ContentProperties)
            {
                if (compareTo((ContentProperties)obj) != 0)
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

    public String getContentDate()
    {
        return contentDate;
    }

    public String getContentType()
    {
        return contentType;
    }

    public DocumentProperties getDocument()
    {
        return document;
    }

    public String getExtension()
    {
        return extension;
    }

    public ImageProperties getImage()
    {
        return image;
    }

    public String getMd5()
    {
        return md5;
    }

    public Long getSize()
    {
        return size;
    }

    public Long getVersion()
    {
        return version;
    }

    public VideoProperties getVideo()
    {
        return video;
    }

    public int hashCode()
    {
        int i2 = 0;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        if (getContentType() == null)
        {
            i = 0;
        } else
        {
            i = getContentType().hashCode();
        }
        if (getExtension() == null)
        {
            j = 0;
        } else
        {
            j = getExtension().hashCode();
        }
        if (getMd5() == null)
        {
            k = 0;
        } else
        {
            k = getMd5().hashCode();
        }
        if (getDocument() == null)
        {
            l = 0;
        } else
        {
            l = getDocument().hashCode();
        }
        if (getVideo() == null)
        {
            i1 = 0;
        } else
        {
            i1 = getVideo().hashCode();
        }
        if (getContentDate() == null)
        {
            j1 = 0;
        } else
        {
            j1 = getContentDate().hashCode();
        }
        if (getSize() == null)
        {
            k1 = 0;
        } else
        {
            k1 = getSize().hashCode();
        }
        if (getVersion() == null)
        {
            l1 = 0;
        } else
        {
            l1 = getVersion().hashCode();
        }
        if (getImage() != null)
        {
            i2 = getImage().hashCode();
        }
        return 1 + i + j + k + l + i1 + j1 + k1 + l1 + i2;
    }

    public void setContentDate(String s)
    {
        contentDate = s;
    }

    public void setContentType(String s)
    {
        contentType = s;
    }

    public void setDocument(DocumentProperties documentproperties)
    {
        document = documentproperties;
    }

    public void setExtension(String s)
    {
        extension = s;
    }

    public void setImage(ImageProperties imageproperties)
    {
        image = imageproperties;
    }

    public void setMd5(String s)
    {
        md5 = s;
    }

    public void setSize(Long long1)
    {
        size = long1;
    }

    public void setVersion(Long long1)
    {
        version = long1;
    }

    public void setVideo(VideoProperties videoproperties)
    {
        video = videoproperties;
    }
}
