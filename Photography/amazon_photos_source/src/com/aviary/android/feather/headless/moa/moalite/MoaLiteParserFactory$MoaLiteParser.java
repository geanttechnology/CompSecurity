// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.headless.moa.moalite;

import com.aviary.android.feather.common.utils.IOUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;
import org.json.JSONException;

// Referenced classes of package com.aviary.android.feather.headless.moa.moalite:
//            MoaLiteParserFactory, MoaLitePack

public static abstract class 
{

    public abstract MoaLitePack parseStream(InputStream inputstream)
        throws IOException, JSONException;

    public MoaLitePack parseZip(InputStream inputstream)
        throws IOException, JSONException
    {
        inputstream = new ZipInputStream(inputstream);
        MoaLitePack moalitepack = parseZip(((ZipInputStream) (inputstream)));
        inputstream.close();
        return moalitepack;
        Exception exception;
        exception;
        inputstream.close();
        throw exception;
    }

    public MoaLitePack parseZip(ZipInputStream zipinputstream)
        throws IOException, JSONException
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        IOUtils.readFileFromZip(zipinputstream, "index.json", bytearrayoutputstream);
        return parseStream(new ByteArrayInputStream(bytearrayoutputstream.toByteArray()));
    }

    public ()
    {
    }
}
