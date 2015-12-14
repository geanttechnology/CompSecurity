// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.model.FileMetadata;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.ImageUtils;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.h;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.util.Locale;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            h, NetworkManager

public class NetworkFile
{

    public static com.cyberlink.beautycircle.model.network.h a(Bitmap bitmap, com.perfectcorp.utility.ImageUtils.CompressSetting compresssetting)
    {
        return a(bitmap, compresssetting, null);
    }

    public static com.cyberlink.beautycircle.model.network.h a(Bitmap bitmap, com.perfectcorp.utility.ImageUtils.CompressSetting compresssetting, String s)
    {
        FileOutputStream fileoutputstream;
        try
        {
            bitmap = ImageUtils.a(bitmap, compresssetting);
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            e.e(new Object[] {
                bitmap
            });
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            e.e(new Object[] {
                bitmap
            });
            System.gc();
            return null;
        }
        if (bitmap != null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        e.e(new Object[] {
            "bmp == null"
        });
        return null;
        s = ImageUtils.a(Globals.n(), s);
        fileoutputstream = new FileOutputStream(s);
        if (bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, compresssetting.quality, fileoutputstream))
        {
            break MISSING_BLOCK_LABEL_91;
        }
        fileoutputstream.close();
        e.e(new Object[] {
            "compress bmp fail"
        });
        return null;
        fileoutputstream.close();
        compresssetting = new ExifInterface(s);
        compresssetting.setAttribute("Orientation", String.valueOf(0));
        compresssetting.setAttribute("ImageWidth", String.valueOf(bitmap.getWidth()));
        compresssetting.setAttribute("ImageLength", String.valueOf(bitmap.getHeight()));
        compresssetting.saveAttributes();
        compresssetting = new FileMetadata();
        compresssetting.width = Integer.valueOf(bitmap.getWidth());
        compresssetting.height = Integer.valueOf(bitmap.getHeight());
        compresssetting.orientation = Integer.valueOf(0);
        compresssetting.dominantedColor = ImageUtils.a(bitmap);
        bitmap = String.format(Locale.getDefault(), "[Upload Resize] %d x %d", new Object[] {
            Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())
        });
        Globals.b(bitmap);
        e.b(new Object[] {
            bitmap
        });
        bitmap = a(s, ((FileMetadata) (compresssetting)));
        return bitmap;
    }

    public static com.cyberlink.beautycircle.model.network.h a(Uri uri, com.perfectcorp.utility.ImageUtils.CompressSetting compresssetting)
    {
        Object obj = null;
        if (uri == null || compresssetting == null)
        {
            e.e(new Object[] {
                "invalid args"
            });
            return null;
        }
        Bitmap bitmap = ImageUtils.a(Globals.n(), uri);
        if (bitmap == null)
        {
            e.e(new Object[] {
                "bmp == null"
            });
            return null;
        }
        if (com.perfectcorp.utility.ImageUtils.CompressSetting.FeedbackSnapshot.equals(compresssetting))
        {
            if (uri.getScheme().equals("content"))
            {
                String s = h.a(Globals.n(), uri, false);
                uri = ((Uri) (obj));
                if (s != null)
                {
                    int i = s.lastIndexOf('/');
                    uri = ((Uri) (obj));
                    if (i != -1)
                    {
                        uri = s.substring(i + 1);
                    }
                }
            } else
            {
                uri = uri.getLastPathSegment();
            }
            obj = uri;
            if (uri != null)
            {
                obj = uri;
                if (!uri.endsWith(".jpg"))
                {
                    obj = uri;
                    if (!uri.endsWith(".JPG"))
                    {
                        obj = (new StringBuilder()).append(uri).append(".jpg").toString();
                    }
                }
            }
            return a(bitmap, compresssetting, ((String) (obj)));
        } else
        {
            return a(bitmap, compresssetting, null);
        }
    }

    public static com.cyberlink.beautycircle.model.network.h a(String s, FileMetadata filemetadata)
    {
        int i;
        int k;
        int l;
        if (s == null)
        {
            e.e(new Object[] {
                "filepath null"
            });
            return null;
        }
        File file = new File(s);
        if (!file.exists())
        {
            e.e(new Object[] {
                "file not exist: ", s
            });
            return null;
        }
        k = (int)file.length();
        byte abyte0[] = new byte[k];
        Object obj;
        byte abyte1[];
        String s1;
        try
        {
            obj = new FileInputStream(file);
        }
        // Misplaced declaration of an exception variable
        catch (FileMetadata filemetadata)
        {
            e.e(new Object[] {
                "file: ", s, " ", filemetadata
            });
            filemetadata.printStackTrace();
            return null;
        }
        i = 0;
_L5:
        l = ((FileInputStream) (obj)).read(abyte0, i, k - i);
          goto _L1
_L4:
        ((FileInputStream) (obj)).close();
        obj = MessageDigest.getInstance("MD5");
        ((MessageDigest) (obj)).update(abyte0);
        abyte1 = ((MessageDigest) (obj)).digest();
        obj = "";
        i = 0;
_L3:
        if (i >= abyte1.length)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (new StringBuilder()).append(((String) (obj))).append(Integer.toString((abyte1[i] & 0xff) + 256, 16).substring(1)).toString();
        i++;
        if (true) goto _L3; else goto _L2
_L2:
        if (filemetadata == null)
        {
            break MISSING_BLOCK_LABEL_208;
        }
        filemetadata.fileSize = file.length();
        filemetadata.md5 = ((String) (obj));
        s1 = MimeTypeMap.getFileExtensionFromUrl(s);
        filemetadata = new com.cyberlink.beautycircle.model.network.h(file.getName(), file.length(), MimeTypeMap.getSingleton().getMimeTypeFromExtension(s1), ((String) (obj)), abyte0, filemetadata, s);
        return filemetadata;
_L1:
        boolean flag;
        if (l == -1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        i += l;
        if (i < k && !flag) goto _L5; else goto _L4
    }

    public static j a(String s, FileType filetype, byte abyte0[], String s1, String s2, String s3)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(s, filetype, abyte0, s1, s3, s2) {

            final String a;
            final FileType b;
            final byte c[];
            final String d;
            final String e;
            final String f;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.file.uploadFile == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.file.uploadFile);
                    networkmanager.a("token", a);
                    networkmanager.a("fileType", b);
                    networkmanager.a("fileBean", c, d, e);
                    networkmanager.a("metadata", f);
                    return networkmanager;
                }
            }

            protected volatile Object a(Object obj)
            {
                return a((NetworkManager)obj);
            }

            
            {
                a = s;
                b = filetype;
                c = abyte0;
                d = s1;
                e = s2;
                f = s3;
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected UploadFileResult a(String s4)
            {
                return (UploadFileResult)Model.a(com/cyberlink/beautycircle/model/network/NetworkFile$UploadFileResult, s4);
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }


            private class UploadFileResult extends Model
            {

                public Long fileId;
                public Uri originalUrl;

                public UploadFileResult()
                {
                }
            }

        });
    }
}
