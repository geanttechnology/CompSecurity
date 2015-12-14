// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

// Referenced classes of package com.bumptech.glide.load.engine:
//            OriginalKey

class EngineKey
    implements Key
{

    private final ResourceDecoder cacheDecoder;
    private final ResourceDecoder decoder;
    private final ResourceEncoder encoder;
    private int hashCode;
    private final int height;
    private final String id;
    private Key originalKey;
    private final Key signature;
    private final Encoder sourceEncoder;
    private String stringKey;
    private final ResourceTranscoder transcoder;
    private final Transformation transformation;
    private final int width;

    public EngineKey(String s, Key key, int i, int j, ResourceDecoder resourcedecoder, ResourceDecoder resourcedecoder1, Transformation transformation1, 
            ResourceEncoder resourceencoder, ResourceTranscoder resourcetranscoder, Encoder encoder1)
    {
        id = s;
        signature = key;
        width = i;
        height = j;
        cacheDecoder = resourcedecoder;
        decoder = resourcedecoder1;
        transformation = transformation1;
        encoder = resourceencoder;
        transcoder = resourcetranscoder;
        sourceEncoder = encoder1;
    }

    public boolean equals(Object obj)
    {
        boolean flag3 = false;
        if (this != obj) goto _L2; else goto _L1
_L1:
        boolean flag2 = true;
_L4:
        return flag2;
_L2:
        flag2 = flag3;
        if (obj == null) goto _L4; else goto _L3
_L3:
        flag2 = flag3;
        if (getClass() != obj.getClass()) goto _L4; else goto _L5
_L5:
        obj = (EngineKey)obj;
        flag2 = flag3;
        if (!id.equals(((EngineKey) (obj)).id)) goto _L4; else goto _L6
_L6:
        flag2 = flag3;
        if (!signature.equals(((EngineKey) (obj)).signature)) goto _L4; else goto _L7
_L7:
        flag2 = flag3;
        if (height != ((EngineKey) (obj)).height) goto _L4; else goto _L8
_L8:
        flag2 = flag3;
        if (width != ((EngineKey) (obj)).width) goto _L4; else goto _L9
_L9:
        boolean flag;
        boolean flag1;
        if (transformation == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (((EngineKey) (obj)).transformation == null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        flag2 = flag3;
        if (flag ^ flag1) goto _L4; else goto _L10
_L10:
        if (transformation == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag2 = flag3;
        if (!transformation.getId().equals(((EngineKey) (obj)).transformation.getId())) goto _L4; else goto _L11
_L11:
        if (decoder == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (((EngineKey) (obj)).decoder == null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        flag2 = flag3;
        if (flag ^ flag1) goto _L4; else goto _L12
_L12:
        if (decoder == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag2 = flag3;
        if (!decoder.getId().equals(((EngineKey) (obj)).decoder.getId())) goto _L4; else goto _L13
_L13:
        if (cacheDecoder == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (((EngineKey) (obj)).cacheDecoder == null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        flag2 = flag3;
        if (flag ^ flag1) goto _L4; else goto _L14
_L14:
        if (cacheDecoder == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag2 = flag3;
        if (!cacheDecoder.getId().equals(((EngineKey) (obj)).cacheDecoder.getId())) goto _L4; else goto _L15
_L15:
        if (encoder == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (((EngineKey) (obj)).encoder == null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        flag2 = flag3;
        if (flag ^ flag1) goto _L4; else goto _L16
_L16:
        if (encoder == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag2 = flag3;
        if (!encoder.getId().equals(((EngineKey) (obj)).encoder.getId())) goto _L4; else goto _L17
_L17:
        if (transcoder == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (((EngineKey) (obj)).transcoder == null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        flag2 = flag3;
        if (flag ^ flag1) goto _L4; else goto _L18
_L18:
        if (transcoder == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag2 = flag3;
        if (!transcoder.getId().equals(((EngineKey) (obj)).transcoder.getId())) goto _L4; else goto _L19
_L19:
        if (sourceEncoder == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (((EngineKey) (obj)).sourceEncoder == null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        flag2 = flag3;
        if (flag ^ flag1) goto _L4; else goto _L20
_L20:
        if (sourceEncoder == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag2 = flag3;
        if (!sourceEncoder.getId().equals(((EngineKey) (obj)).sourceEncoder.getId())) goto _L4; else goto _L21
_L21:
        return true;
    }

    public Key getOriginalKey()
    {
        if (originalKey == null)
        {
            originalKey = new OriginalKey(id, signature);
        }
        return originalKey;
    }

    public int hashCode()
    {
        boolean flag = false;
        if (hashCode == 0)
        {
            hashCode = id.hashCode();
            hashCode = hashCode * 31 + signature.hashCode();
            hashCode = hashCode * 31 + width;
            hashCode = hashCode * 31 + height;
            int j = hashCode;
            int i;
            if (cacheDecoder != null)
            {
                i = cacheDecoder.getId().hashCode();
            } else
            {
                i = 0;
            }
            hashCode = i + j * 31;
            j = hashCode;
            if (decoder != null)
            {
                i = decoder.getId().hashCode();
            } else
            {
                i = 0;
            }
            hashCode = i + j * 31;
            j = hashCode;
            if (transformation != null)
            {
                i = transformation.getId().hashCode();
            } else
            {
                i = 0;
            }
            hashCode = i + j * 31;
            j = hashCode;
            if (encoder != null)
            {
                i = encoder.getId().hashCode();
            } else
            {
                i = 0;
            }
            hashCode = i + j * 31;
            j = hashCode;
            if (transcoder != null)
            {
                i = transcoder.getId().hashCode();
            } else
            {
                i = 0;
            }
            hashCode = i + j * 31;
            j = hashCode;
            i = ((flag) ? 1 : 0);
            if (sourceEncoder != null)
            {
                i = sourceEncoder.getId().hashCode();
            }
            hashCode = j * 31 + i;
        }
        return hashCode;
    }

    public String toString()
    {
        if (stringKey == null)
        {
            StringBuilder stringbuilder = (new StringBuilder()).append(id).append(signature).append(width).append(height);
            String s;
            if (cacheDecoder != null)
            {
                s = cacheDecoder.getId();
            } else
            {
                s = "";
            }
            stringbuilder = stringbuilder.append(s);
            if (decoder != null)
            {
                s = decoder.getId();
            } else
            {
                s = "";
            }
            stringbuilder = stringbuilder.append(s);
            if (transformation != null)
            {
                s = transformation.getId();
            } else
            {
                s = "";
            }
            stringbuilder = stringbuilder.append(s);
            if (encoder != null)
            {
                s = encoder.getId();
            } else
            {
                s = "";
            }
            stringbuilder = stringbuilder.append(s);
            if (transcoder != null)
            {
                s = transcoder.getId();
            } else
            {
                s = "";
            }
            stringbuilder = stringbuilder.append(s);
            if (sourceEncoder != null)
            {
                s = sourceEncoder.getId();
            } else
            {
                s = "";
            }
            stringKey = stringbuilder.append(s).toString();
        }
        return stringKey;
    }

    public void updateDiskCacheKey(MessageDigest messagedigest)
        throws UnsupportedEncodingException
    {
        byte abyte0[] = ByteBuffer.allocate(8).putInt(width).putInt(height).array();
        signature.updateDiskCacheKey(messagedigest);
        messagedigest.update(id.getBytes("UTF-8"));
        messagedigest.update(abyte0);
        String s;
        if (cacheDecoder != null)
        {
            s = cacheDecoder.getId();
        } else
        {
            s = "";
        }
        messagedigest.update(s.getBytes("UTF-8"));
        if (decoder != null)
        {
            s = decoder.getId();
        } else
        {
            s = "";
        }
        messagedigest.update(s.getBytes("UTF-8"));
        if (transformation != null)
        {
            s = transformation.getId();
        } else
        {
            s = "";
        }
        messagedigest.update(s.getBytes("UTF-8"));
        if (encoder != null)
        {
            s = encoder.getId();
        } else
        {
            s = "";
        }
        messagedigest.update(s.getBytes("UTF-8"));
        if (sourceEncoder != null)
        {
            s = sourceEncoder.getId();
        } else
        {
            s = "";
        }
        messagedigest.update(s.getBytes("UTF-8"));
    }
}
