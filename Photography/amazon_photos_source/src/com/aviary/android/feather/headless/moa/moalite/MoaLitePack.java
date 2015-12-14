// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.headless.moa.moalite;

import android.util.Log;
import com.aviary.android.feather.common.utils.IOUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipException;
import java.util.zip.ZipInputStream;

// Referenced classes of package com.aviary.android.feather.headless.moa.moalite:
//            MoaLiteProclistVersion

public final class MoaLitePack
{
    public static class MoaLiteItem
    {

        private String displayName;
        private String ref;

        public final String getDisplayName()
        {
            return displayName;
        }

        public final String getRef()
        {
            return ref;
        }

        public boolean loadContent(File file, OutputStream outputstream)
            throws IOException
        {
            return loadContent(((InputStream) (new FileInputStream(file))), outputstream);
        }

        public boolean loadContent(InputStream inputstream, OutputStream outputstream)
            throws IOException
        {
            IOUtils.copyFile(inputstream, outputstream);
            return true;
        }

        public byte[] loadContent(File file)
            throws IOException
        {
            return loadContent(((InputStream) (new FileInputStream(file))));
        }

        public byte[] loadContent(InputStream inputstream)
            throws IOException
        {
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            IOUtils.copyFile(inputstream, bytearrayoutputstream);
            return bytearrayoutputstream.toByteArray();
        }

        public boolean loadContentFromZip(File file, OutputStream outputstream)
            throws ZipException, IOException
        {
            return loadContentFromZip(((InputStream) (new FileInputStream(file))), outputstream);
        }

        public boolean loadContentFromZip(InputStream inputstream, OutputStream outputstream)
            throws IOException
        {
            inputstream = new ZipInputStream(inputstream);
            boolean flag = IOUtils.readFileFromZip(inputstream, getRef(), outputstream);
            inputstream.close();
            return flag;
            outputstream;
            inputstream.close();
            throw outputstream;
        }

        public boolean loadContentFromZip(InputStream inputstream, ByteBuffer bytebuffer)
            throws IOException
        {
            return IOUtils.readFileFromZip(new ZipInputStream(inputstream), getRef(), bytebuffer);
        }

        public byte[] loadContentFromZip(File file)
            throws ZipException, IOException
        {
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            loadContentFromZip(file, ((OutputStream) (bytearrayoutputstream)));
            return bytearrayoutputstream.toByteArray();
        }

        public byte[] loadContentFromZip(InputStream inputstream)
            throws IOException
        {
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            loadContentFromZip(inputstream, ((OutputStream) (bytearrayoutputstream)));
            return bytearrayoutputstream.toByteArray();
        }

        void setDisplayName(String s)
        {
            displayName = s;
        }

        public void setRef(String s)
        {
            ref = s;
        }

        MoaLiteItem()
        {
        }
    }


    public static final String INDEX_FILENAME = "index.json";
    private static final String LOG_TAG = "moa-effect-pack";
    public static final String TYPE_EFFECT = "effect";
    private String codename;
    private String displayName;
    private String fileName;
    private String identifier;
    private List items;
    private String minVersion;
    private String packType;
    private int packVersionCode;

    MoaLitePack()
    {
        items = new ArrayList();
    }

    void addItem(MoaLiteItem moaliteitem)
    {
        items.add(moaliteitem);
    }

    public boolean containsIdentifier(String s)
    {
        for (Iterator iterator = items.iterator(); iterator.hasNext();)
        {
            if (((MoaLiteItem)iterator.next()).getRef().equals(s))
            {
                return true;
            }
        }

        return false;
    }

    public String getCodename()
    {
        return codename;
    }

    public int getCount()
    {
        return items.size();
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public String getFileName()
    {
        return fileName;
    }

    public String getIdentifier()
    {
        return identifier;
    }

    public MoaLiteItem getItemAt(int i)
    {
        return (MoaLiteItem)items.get(i);
    }

    public String getMinVersion()
    {
        return minVersion;
    }

    public String getPackType()
    {
        return packType;
    }

    public int getPackTypeInt()
    {
        return !"effect".equals(packType) ? 0 : 1;
    }

    public int getPackVersionCode()
    {
        return packVersionCode;
    }

    public MoaLiteProclistVersion getProclistVersion()
    {
        return MoaLiteProclistVersion.fromString(getMinVersion());
    }

    void setCodename(String s)
    {
        codename = s;
    }

    void setDisplayName(String s)
    {
        displayName = s;
    }

    public void setFileName(String s)
    {
        fileName = s;
    }

    void setIdentifier(String s)
    {
        identifier = s;
    }

    void setMinVersion(String s)
    {
        minVersion = s;
    }

    void setPackType(String s)
    {
        packType = s;
    }

    void setPackVersionCode(int i)
    {
        packVersionCode = i;
    }

    public String toString()
    {
        return (new StringBuilder()).append("EffectPack[identifier=").append(identifier).append(", codeName=").append(codename).append(", packType=").append(packType).append(", packVersionCode=").append(packVersionCode).append(", displayName=").append(displayName).append(", minVersion=").append(minVersion).append(", items=").append(items.size()).append("]").toString();
    }

    public boolean valid()
    {
        Log.i("moa-effect-pack", (new StringBuilder()).append("valid. identifier: ").append(identifier).append(", displayName: ").append(displayName).append(", minVersion: ").append(minVersion).append(", packVersionCode: ").append(packVersionCode).append(", packType: ").append(packType).toString());
        return identifier != null && displayName != null && minVersion != null && packVersionCode > 0 && packType != null;
    }
}
