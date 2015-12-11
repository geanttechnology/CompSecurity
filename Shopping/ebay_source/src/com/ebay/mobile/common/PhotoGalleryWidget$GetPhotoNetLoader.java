// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.ebay.common.util.Debug;
import com.ebay.nautilus.domain.net.ImageRequest;
import com.ebay.nautilus.domain.net.ImageResponse;
import com.ebay.nautilus.domain.net.image.ConstructDipUrl;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.util.FwLog;
import com.ebay.nautilus.kernel.util.StreamUtil;
import com.ebay.nautilus.shell.content.FwNetLoader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

// Referenced classes of package com.ebay.mobile.common:
//            PhotoGalleryWidget

public static class lruSize extends FwNetLoader
{

    private final int index;
    private final int lruSize;
    private final result resolution;
    private byte result[];
    private final long startMillis = System.currentTimeMillis();
    private final String url;
    public String urlString;

    private byte[] getBytes(Context context, URL url1)
        throws com.ebay.nautilus.kernel.net.e, com.ebay.nautilus.kernel.net.e, IOException, InterruptedException
    {
        Object obj;
        byte abyte1[];
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        File file;
        int i;
        boolean flag;
        abyte1 = null;
        obj3 = null;
        obj4 = null;
        obj5 = null;
        Object obj1 = null;
        if (Debug.logPhotoGallery.)
        {
            FwLog.println(Debug.logPhotoGallery, (new StringBuilder()).append("Requested data for: ").append(url1.toString()).toString());
        }
        flag = true;
        file = getFile(context, url1.toString());
        obj = obj1;
        i = ((flag) ? 1 : 0);
        if (lruSize <= 0)
        {
            break MISSING_BLOCK_LABEL_264;
        }
        obj = obj1;
        i = ((flag) ? 1 : 0);
        if (!file.exists())
        {
            break MISSING_BLOCK_LABEL_264;
        }
        obj = obj1;
        i = ((flag) ? 1 : 0);
        if (file.lastModified() + 0x5265c00L <= System.currentTimeMillis())
        {
            break MISSING_BLOCK_LABEL_264;
        }
        obj7 = null;
        obj = null;
        obj6 = null;
        byte abyte0[] = new RandomAccessFile(file, "r");
        obj = obj4;
        abyte1 = obj5;
        i = (int)abyte0.length();
        obj = obj4;
        abyte1 = obj5;
        obj3 = new byte[i];
        obj = obj3;
        abyte1 = ((byte []) (obj3));
        abyte0.readFully(((byte []) (obj3)));
        obj = obj3;
        abyte1 = ((byte []) (obj3));
        if (!Debug.logPhotoGallery.)
        {
            break MISSING_BLOCK_LABEL_253;
        }
        obj = obj3;
        abyte1 = ((byte []) (obj3));
        FwLog.println(Debug.logPhotoGallery, (new StringBuilder()).append("   in cache -- file length: ").append(i).append(" data size: ").append(obj3.length).append(" ").append(url1.toString()).toString());
        i = 0;
        StreamUtil.closeQuietly(abyte0);
        obj = obj3;
_L1:
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_381;
        }
        if (Debug.logPhotoGallery.)
        {
            FwLog.println(Debug.logPhotoGallery, (new StringBuilder()).append("   NOT in cache ").append(url1.toString()).toString());
        }
        abyte0 = ((ImageResponse)sendRequest(new ImageRequest(url1, true))).getByteArray();
        obj = abyte0;
        if (abyte0 == null)
        {
            break MISSING_BLOCK_LABEL_381;
        }
        pruneOldestIfNecessary(context);
        obj = abyte0;
        if (lruSize <= 0)
        {
            break MISSING_BLOCK_LABEL_381;
        }
        context = null;
        obj = null;
        url1 = new FileOutputStream(file);
        url1.write(abyte0);
        url1.close();
        StreamUtil.closeQuietly(null);
        obj = abyte0;
        return ((byte []) (obj));
        obj3;
        abyte0 = obj6;
_L9:
        obj = abyte0;
        if (!Debug.logPhotoGallery.)
        {
            break MISSING_BLOCK_LABEL_433;
        }
        obj = abyte0;
        Debug.logPhotoGallery.((new StringBuilder()).append("PhotoGallery reading file from cache failed: ").append(((IOException) (obj3)).toString()).toString());
        StreamUtil.closeQuietly(abyte0);
        obj = abyte1;
        i = ((flag) ? 1 : 0);
          goto _L1
        obj;
        Object obj2;
        obj2 = obj7;
        abyte0 = ((byte []) (obj3));
_L8:
        obj = obj2;
        if (!Debug.logPhotoGallery.)
        {
            break MISSING_BLOCK_LABEL_500;
        }
        obj = obj2;
        FwLog.println(Debug.logPhotoGallery, (new StringBuilder()).append("   OOM! ").append(url1.toString()).toString());
        StreamUtil.closeQuietly(((java.io.Closeable) (obj2)));
        obj = abyte0;
        i = ((flag) ? 1 : 0);
          goto _L1
        context;
_L7:
        StreamUtil.closeQuietly(((java.io.Closeable) (obj)));
        throw context;
        context;
        url1 = ((URL) (obj));
        obj = context;
_L5:
        context = url1;
        if (!Debug.logPhotoGallery.)
        {
            break MISSING_BLOCK_LABEL_568;
        }
        context = url1;
        Debug.logPhotoGallery.((new StringBuilder()).append("PhotoGallery writing file to cache failed: ").append(((IOException) (obj)).toString()).toString());
        StreamUtil.closeQuietly(url1);
        return abyte0;
        url1;
_L3:
        StreamUtil.closeQuietly(context);
        throw url1;
        obj;
        context = url1;
        url1 = ((URL) (obj));
        if (true) goto _L3; else goto _L2
_L2:
        obj;
        if (true) goto _L5; else goto _L4
_L4:
        context;
        obj = abyte0;
        if (true) goto _L7; else goto _L6
_L6:
        OutOfMemoryError outofmemoryerror;
        outofmemoryerror;
        outofmemoryerror = abyte0;
        abyte0 = ((byte []) (obj));
          goto _L8
        obj3;
          goto _L9
    }

    private String getCacheFolder(Context context)
    {
        return (new StringBuilder()).append(context.getCacheDir()).append(File.separator).append("ImageCache").toString();
    }

    private File getFile(Context context, String s)
    {
        int i = 255 - "PhotoGallery-".length();
        Object obj = s.replaceAll("[^A-Za-z0-9]", "");
        s = ((String) (obj));
        if (i < ((String) (obj)).length())
        {
            s = ((String) (obj)).substring(((String) (obj)).length() - i);
        }
        obj = new StringBuilder();
        ((StringBuilder) (obj)).append("PhotoGallery-").append(s);
        context = new File(getCacheFolder(context));
        context.mkdirs();
        return new File(context, ((StringBuilder) (obj)).toString());
    }

    private void pruneOldestIfNecessary(Context context)
    {
label0:
        {
            File afile[] = (new File(getCacheFolder(context))).listFiles();
            if (afile == null)
            {
                break label0;
            }
            int i1 = afile.length;
            int j1 = lruSize;
            for (int j = 0; j < i1 - j1 - 1; j++)
            {
                int k = -1;
                context = null;
                for (int i = 0; i < afile.length;)
                {
                    Object obj;
                    int l;
label1:
                    {
                        File file = afile[i];
                        l = k;
                        obj = context;
                        if (file == null)
                        {
                            break label1;
                        }
                        long l1 = file.lastModified();
                        if (context != null)
                        {
                            l = k;
                            obj = context;
                            if (l1 >= context.longValue())
                            {
                                break label1;
                            }
                        }
                        obj = Long.valueOf(l1);
                        l = i;
                    }
                    i++;
                    k = l;
                    context = ((Context) (obj));
                }

                if (-1 == k)
                {
                    continue;
                }
                afile[k].delete();
                if (Debug.logPhotoGallery.)
                {
                    FwLog.println(Debug.logPhotoGallery, (new StringBuilder()).append(" deleting oldest file: ").append(afile[k].toString()).toString());
                }
                afile[k] = null;
            }

        }
    }

    protected final void doInBackgroundInternal()
        throws com.ebay.nautilus.kernel.net.e, com.ebay.nautilus.kernel.net.e, IOException, InterruptedException
    {
        bay.mobile.common.PhotoGalleryWidget.PhotoResolution[resolution.dinal()];
        JVM INSTR tableswitch 1 3: default 1329
    //                   1 306
    //                   2 466
    //                   3 626;
           goto _L1 _L2 _L3 _L4
_L1:
        if (Debug.logPhotoGallery.ion)
        {
            FwLog.println(Debug.logPhotoGallery, (new StringBuilder()).append("urlString updated to ").append(urlString).toString());
        }
        if (urlString == null)
        {
            urlString = url;
        }
        if (urlString != null)
        {
            URL url1 = URI.create(urlString).toURL();
            Context context = getContext();
            result = getBytes(context, url1);
            if (result == null && urlString != null)
            {
                URL url2 = new URL(urlString);
                url2 = (new URI(url2.getProtocol(), url2.getUserInfo(), url2.getHost(), url2.getPort(), url2.getPath(), url2.getQuery(), url2.getRef())).toURL();
                if (!url2.equals(url2))
                {
                    result = getBytes(context, url2);
                }
            }
        }
        Object obj;
        long l = System.currentTimeMillis();
        long l5 = startMillis;
        if (Debug.logPhotoGallery.llis)
        {
            com.ebay.nautilus.kernel.util.  = Debug.logPhotoGallery;
            StringBuilder stringbuilder = (new StringBuilder()).append("  ended after ").append(l - l5).append(" (").append(index).append("): ");
            if (result != null)
            {
                obj = "success";
            } else
            {
                obj = "failure";
            }
            FwLog.println(, stringbuilder.append(((String) (obj))).append(" ").append(urlString).toString());
        }
_L5:
        return;
_L2:
        urlString = ConstructDipUrl.constructDynamicUrl(url, "_3");
          goto _L1
        obj;
        Log.e("PhotoGalleryWidget", (new StringBuilder()).append(obj.getClass().getSimpleName()).append(", ").append(urlString).toString(), ((Throwable) (obj)));
        l = System.currentTimeMillis();
        l5 = startMillis;
        if (Debug.logPhotoGallery.llis)
        {
             = Debug.logPhotoGallery;
            stringbuilder = (new StringBuilder()).append("  ended after ").append(l - l5).append(" (").append(index).append("): ");
            if (result != null)
            {
                obj = "success";
            } else
            {
                obj = "failure";
            }
            FwLog.println(, stringbuilder.append(((String) (obj))).append(" ").append(urlString).toString());
            return;
        } else
        {
            break MISSING_BLOCK_LABEL_305;
        }
_L3:
        urlString = ConstructDipUrl.constructDynamicUrl(url, "_58");
          goto _L1
        obj;
        Log.e("PhotoGalleryWidget", (new StringBuilder()).append(obj.getClass().getSimpleName()).append(", ").append(urlString).toString(), ((Throwable) (obj)));
        l = System.currentTimeMillis();
        l5 = startMillis;
        if (Debug.logPhotoGallery.llis)
        {
             = Debug.logPhotoGallery;
            stringbuilder = (new StringBuilder()).append("  ended after ").append(l - l5).append(" (").append(index).append("): ");
            if (result != null)
            {
                obj = "success";
            } else
            {
                obj = "failure";
            }
            FwLog.println(, stringbuilder.append(((String) (obj))).append(" ").append(urlString).toString());
            return;
        } else
        {
            break MISSING_BLOCK_LABEL_305;
        }
_L4:
        urlString = url;
          goto _L1
        obj;
        Log.e("PhotoGalleryWidget", (new StringBuilder()).append(obj.getClass().getSimpleName()).append(", ").append(urlString).toString(), ((Throwable) (obj)));
        l = System.currentTimeMillis();
        l5 = startMillis;
        if (Debug.logPhotoGallery.llis)
        {
             = Debug.logPhotoGallery;
            stringbuilder = (new StringBuilder()).append("  ended after ").append(l - l5).append(" (").append(index).append("): ");
            if (result != null)
            {
                obj = "success";
            } else
            {
                obj = "failure";
            }
            FwLog.println(, stringbuilder.append(((String) (obj))).append(" ").append(urlString).toString());
            return;
        }
        break MISSING_BLOCK_LABEL_305;
        Object obj1;
        obj1;
        Log.e("PhotoGalleryWidget", (new StringBuilder()).append(obj1.getClass().getSimpleName()).append(", ").append(urlString).toString(), ((Throwable) (obj1)));
        long l1 = System.currentTimeMillis();
        long l6 = startMillis;
        if (Debug.logPhotoGallery.llis)
        {
            com.ebay.nautilus.kernel.util. 1 = Debug.logPhotoGallery;
            StringBuilder stringbuilder1 = (new StringBuilder()).append("  ended after ").append(l1 - l6).append(" (").append(index).append("): ");
            String s;
            if (result != null)
            {
                s = "success";
            } else
            {
                s = "failure";
            }
            FwLog.println(1, stringbuilder1.append(s).append(" ").append(urlString).toString());
            return;
        }
          goto _L5
        s;
        long l2 = System.currentTimeMillis();
        long l7 = startMillis;
        if (Debug.logPhotoGallery.llis)
        {
            com.ebay.nautilus.kernel.util. 2 = Debug.logPhotoGallery;
            StringBuilder stringbuilder2 = (new StringBuilder()).append("  ended after ").append(l2 - l7).append(" (").append(index).append("): ");
            String s1;
            if (result != null)
            {
                s1 = "success";
            } else
            {
                s1 = "failure";
            }
            FwLog.println(2, stringbuilder2.append(s1).append(" ").append(urlString).toString());
            return;
        }
          goto _L5
        s1;
        Log.e("PhotoGalleryWidget", (new StringBuilder()).append(s1.getClass().getSimpleName()).append(", ").append(urlString).toString(), s1);
        long l3;
        long l8;
        l3 = System.currentTimeMillis();
        l8 = startMillis;
        if (!Debug.logPhotoGallery.llis) goto _L5; else goto _L6
_L6:
        com.ebay.nautilus.kernel.util. 3 = Debug.logPhotoGallery;
        StringBuilder stringbuilder3 = (new StringBuilder()).append("  ended after ").append(l3 - l8).append(" (").append(index).append("): ");
        String s2;
        if (result != null)
        {
            s2 = "success";
        } else
        {
            s2 = "failure";
        }
        FwLog.println(3, stringbuilder3.append(s2).append(" ").append(urlString).toString());
        return;
        Exception exception;
        exception;
        long l4 = System.currentTimeMillis();
        long l9 = startMillis;
        if (Debug.logPhotoGallery.llis)
        {
            com.ebay.nautilus.kernel.util. 4 = Debug.logPhotoGallery;
            StringBuilder stringbuilder4 = (new StringBuilder()).append("  ended after ").append(l4 - l9).append(" (").append(index).append("): ");
            String s3;
            if (result != null)
            {
                s3 = "success";
            } else
            {
                s3 = "failure";
            }
            FwLog.println(4, stringbuilder4.append(s3).append(" ").append(urlString).toString());
        }
        throw exception;
          goto _L1
    }

    public Bitmap getBitmap()
    {
        Object obj = null;
        if (result != null)
        {
            try
            {
                obj = new android.graphics.oader.result();
                obj.result = false;
                obj.ig = android.graphics.ig;
                obj.ig = false;
                obj = BitmapFactory.decodeByteArray(result, 0, result.length, ((android.graphics.oader.result) (obj)));
            }
            catch (OutOfMemoryError outofmemoryerror)
            {
                Log.w("PhotoGalleryWidget", (new StringBuilder()).append("Out of memory decoding bitmap: ").append(outofmemoryerror).toString());
                return null;
            }
        }
        return ((Bitmap) (obj));
    }




/*
    static byte[] access$802(ption ption, byte abyte0[])
    {
        ption.result = abyte0;
        return abyte0;
    }

*/

    public result(String s, result result1, int i, EbayContext ebaycontext, int j)
    {
        super(ebaycontext);
        result = null;
        urlString = null;
        url = s;
        resolution = result1;
        index = i;
        lruSize = j;
        if (Debug.logPhotoGallery.)
        {
            FwLog.println(Debug.logPhotoGallery, (new StringBuilder()).append("Launching new loader for (").append(i).append(" ").append(s).toString());
        }
    }
}
