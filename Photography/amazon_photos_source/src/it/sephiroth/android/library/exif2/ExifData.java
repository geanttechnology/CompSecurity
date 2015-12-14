// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.exif2;

import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package it.sephiroth.android.library.exif2:
//            IfdData, ExifTag, ExifInterface

class ExifData
{

    private static final String TAG = "ExifData";
    private static final byte USER_COMMENT_ASCII[] = {
        65, 83, 67, 73, 73, 0, 0, 0
    };
    private static final byte USER_COMMENT_JIS[] = {
        74, 73, 83, 0, 0, 0, 0, 0
    };
    private static final byte USER_COMMENT_UNICODE[] = {
        85, 78, 73, 67, 79, 68, 69, 0
    };
    private int imageLength;
    private int imageWidth;
    private short jpegProcess;
    private final ByteOrder mByteOrder;
    private final IfdData mIfdDatas[] = new IfdData[5];
    private List mSections;
    private ArrayList mStripBytes;
    private byte mThumbnail[];
    public int mUncompressedDataPosition;
    private int qualityGuess;

    ExifData(ByteOrder byteorder)
    {
        mStripBytes = new ArrayList();
        qualityGuess = 0;
        imageLength = -1;
        imageWidth = -1;
        jpegProcess = 0;
        mUncompressedDataPosition = 0;
        mByteOrder = byteorder;
    }

    protected void addIfdData(IfdData ifddata)
    {
        mIfdDatas[ifddata.getId()] = ifddata;
    }

    protected ExifTag addTag(ExifTag exiftag)
    {
        if (exiftag != null)
        {
            return addTag(exiftag, exiftag.getIfd());
        } else
        {
            return null;
        }
    }

    protected ExifTag addTag(ExifTag exiftag, int i)
    {
        if (exiftag != null && ExifTag.isValidIfd(i))
        {
            return getOrCreateIfdData(i).setTag(exiftag);
        } else
        {
            return null;
        }
    }

    protected void clearThumbnailAndStrips()
    {
        mThumbnail = null;
        mStripBytes.clear();
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (obj instanceof ExifData)
        {
            obj = (ExifData)obj;
            if (((ExifData) (obj)).mByteOrder != mByteOrder || ((ExifData) (obj)).mStripBytes.size() != mStripBytes.size() || !Arrays.equals(((ExifData) (obj)).mThumbnail, mThumbnail))
            {
                return false;
            }
            for (int i = 0; i < mStripBytes.size(); i++)
            {
                if (!Arrays.equals((byte[])((ExifData) (obj)).mStripBytes.get(i), (byte[])mStripBytes.get(i)))
                {
                    return false;
                }
            }

            for (int j = 0; j < 5; j++)
            {
                IfdData ifddata = ((ExifData) (obj)).getIfdData(j);
                IfdData ifddata1 = getIfdData(j);
                if (ifddata != ifddata1 && ifddata != null && !ifddata.equals(ifddata1))
                {
                    return false;
                }
            }

            return true;
        } else
        {
            return false;
        }
    }

    protected List getAllTags()
    {
        ArrayList arraylist1 = new ArrayList();
        IfdData aifddata[] = mIfdDatas;
        int k = aifddata.length;
        for (int i = 0; i < k; i++)
        {
            IfdData ifddata = aifddata[i];
            if (ifddata == null)
            {
                continue;
            }
            ExifTag aexiftag[] = ifddata.getAllTags();
            if (aexiftag == null)
            {
                continue;
            }
            int l = aexiftag.length;
            for (int j = 0; j < l; j++)
            {
                arraylist1.add(aexiftag[j]);
            }

        }

        ArrayList arraylist = arraylist1;
        if (arraylist1.size() == 0)
        {
            arraylist = null;
        }
        return arraylist;
    }

    protected List getAllTagsForIfd(int i)
    {
        Object obj = mIfdDatas[i];
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = ((IfdData) (obj)).getAllTags();
            if (obj == null)
            {
                return null;
            }
            ArrayList arraylist = new ArrayList(obj.length);
            int j = obj.length;
            for (i = 0; i < j; i++)
            {
                arraylist.add(obj[i]);
            }

            obj = arraylist;
            if (arraylist.size() == 0)
            {
                return null;
            }
        }
        return ((List) (obj));
    }

    protected List getAllTagsForTagId(short word0)
    {
        ArrayList arraylist1 = new ArrayList();
        IfdData aifddata[] = mIfdDatas;
        int j = aifddata.length;
        for (int i = 0; i < j; i++)
        {
            Object obj = aifddata[i];
            if (obj == null)
            {
                continue;
            }
            obj = ((IfdData) (obj)).getTag(word0);
            if (obj != null)
            {
                arraylist1.add(obj);
            }
        }

        ArrayList arraylist = arraylist1;
        if (arraylist1.size() == 0)
        {
            arraylist = null;
        }
        return arraylist;
    }

    protected ByteOrder getByteOrder()
    {
        return mByteOrder;
    }

    protected byte[] getCompressedThumbnail()
    {
        return mThumbnail;
    }

    protected IfdData getIfdData(int i)
    {
        if (ExifTag.isValidIfd(i))
        {
            return mIfdDatas[i];
        } else
        {
            return null;
        }
    }

    public int[] getImageSize()
    {
        return (new int[] {
            imageWidth, imageLength
        });
    }

    public short getJpegProcess()
    {
        return jpegProcess;
    }

    protected IfdData getOrCreateIfdData(int i)
    {
        IfdData ifddata1 = mIfdDatas[i];
        IfdData ifddata = ifddata1;
        if (ifddata1 == null)
        {
            ifddata = new IfdData(i);
            mIfdDatas[i] = ifddata;
        }
        return ifddata;
    }

    public int getQualityGuess()
    {
        return qualityGuess;
    }

    public List getSections()
    {
        return mSections;
    }

    protected byte[] getStrip(int i)
    {
        return (byte[])mStripBytes.get(i);
    }

    protected int getStripCount()
    {
        return mStripBytes.size();
    }

    protected ExifTag getTag(short word0, int i)
    {
        IfdData ifddata = mIfdDatas[i];
        if (ifddata == null)
        {
            return null;
        } else
        {
            return ifddata.getTag(word0);
        }
    }

    protected String getUserComment()
    {
        Object obj = mIfdDatas[0];
        if (obj != null) goto _L2; else goto _L1
_L1:
        ExifTag exiftag;
        return null;
_L2:
        if ((exiftag = ((IfdData) (obj)).getTag(ExifInterface.getTrueTagKey(ExifInterface.TAG_USER_COMMENT))) == null || exiftag.getComponentCount() < 8) goto _L1; else goto _L3
_L3:
        byte abyte0[];
        byte abyte1[];
        abyte0 = new byte[exiftag.getComponentCount()];
        exiftag.getBytes(abyte0);
        abyte1 = new byte[8];
        System.arraycopy(abyte0, 0, abyte1, 0, 8);
        if (Arrays.equals(abyte1, USER_COMMENT_ASCII))
        {
            return new String(abyte0, 8, abyte0.length - 8, "US-ASCII");
        }
        if (Arrays.equals(abyte1, USER_COMMENT_JIS))
        {
            return new String(abyte0, 8, abyte0.length - 8, "EUC-JP");
        }
        if (!Arrays.equals(abyte1, USER_COMMENT_UNICODE)) goto _L1; else goto _L4
_L4:
        abyte0 = new String(abyte0, 8, abyte0.length - 8, "UTF-16");
        return abyte0;
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        Log.w("ExifData", "Failed to decode the user comment");
        return null;
    }

    protected boolean hasCompressedThumbnail()
    {
        return mThumbnail != null;
    }

    protected boolean hasUncompressedStrip()
    {
        return mStripBytes.size() != 0;
    }

    protected void removeTag(short word0, int i)
    {
        IfdData ifddata = mIfdDatas[i];
        if (ifddata == null)
        {
            return;
        } else
        {
            ifddata.removeTag(word0);
            return;
        }
    }

    protected void removeThumbnailData()
    {
        clearThumbnailAndStrips();
        mIfdDatas[1] = null;
    }

    protected void setCompressedThumbnail(byte abyte0[])
    {
        mThumbnail = abyte0;
    }

    protected void setImageSize(int i, int j)
    {
        imageWidth = i;
        imageLength = j;
    }

    public void setJpegProcess(short word0)
    {
        jpegProcess = word0;
    }

    protected void setQualityGuess(int i)
    {
        qualityGuess = i;
    }

    public void setSections(List list)
    {
        mSections = list;
    }

    protected void setStripBytes(int i, byte abyte0[])
    {
        if (i < mStripBytes.size())
        {
            mStripBytes.set(i, abyte0);
            return;
        }
        for (int j = mStripBytes.size(); j < i; j++)
        {
            mStripBytes.add(null);
        }

        mStripBytes.add(abyte0);
    }

}
