// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.headless.moa.moalite;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import org.json.JSONException;

// Referenced classes of package com.aviary.android.feather.headless.moa.moalite:
//            MoaLitePack

final class MoaLiteParserNew extends MoaLiteParserFactory.MoaLiteParser
{

    MoaLiteParserNew()
    {
    }

    private void initializePack(MoaLitePack moalitepack, String s, String s1)
    {
        if ("packType".equals(s))
        {
            moalitepack.setPackType(s1);
        } else
        {
            if ("identifier".equals(s))
            {
                moalitepack.setIdentifier(s1);
                return;
            }
            if ("codename".equals(s))
            {
                moalitepack.setCodename(s1);
                return;
            }
            if ("displayName".equals(s))
            {
                moalitepack.setDisplayName(s1);
                return;
            }
            if ("minVersion".equals(s))
            {
                moalitepack.setMinVersion(s1);
                return;
            }
        }
    }

    public MoaLitePack parseStream(InputStream inputstream)
        throws IOException, JSONException
    {
        MoaLitePack moalitepack = new MoaLitePack();
        inputstream = new JsonReader(new InputStreamReader(inputstream, Charset.forName("UTF-8")));
        inputstream.beginObject();
        while (inputstream.hasNext()) 
        {
            String s = inputstream.nextName();
            JsonToken jsontoken = inputstream.peek();
            if (jsontoken.equals(JsonToken.STRING))
            {
                initializePack(moalitepack, s, inputstream.nextString());
            } else
            if (jsontoken.equals(JsonToken.NUMBER))
            {
                if ("packVersionCode".equals(s))
                {
                    moalitepack.setPackVersionCode(inputstream.nextInt());
                } else
                {
                    inputstream.skipValue();
                }
            } else
            if (jsontoken.equals(JsonToken.BEGIN_ARRAY))
            {
                inputstream.beginArray();
                if ("items".equals(s))
                {
                    for (; inputstream.hasNext(); inputstream.endObject())
                    {
                        inputstream.beginObject();
                        MoaLitePack.MoaLiteItem moaliteitem = new MoaLitePack.MoaLiteItem();
                        while (inputstream.hasNext()) 
                        {
                            String s1 = inputstream.nextName();
                            if (inputstream.peek().equals(JsonToken.STRING))
                            {
                                if ("displayName".equals(s1))
                                {
                                    moaliteitem.setDisplayName(inputstream.nextString());
                                } else
                                if ("ref".equals(s1))
                                {
                                    moaliteitem.setRef(inputstream.nextString());
                                } else
                                {
                                    inputstream.skipValue();
                                }
                            } else
                            {
                                inputstream.skipValue();
                            }
                        }
                        moalitepack.addItem(moaliteitem);
                    }

                } else
                {
                    inputstream.skipValue();
                }
                inputstream.endArray();
            } else
            {
                inputstream.skipValue();
            }
        }
        inputstream.close();
        return moalitepack;
    }
}
