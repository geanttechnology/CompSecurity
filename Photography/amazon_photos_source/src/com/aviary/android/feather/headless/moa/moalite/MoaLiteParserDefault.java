// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.headless.moa.moalite;

import android.util.Log;
import com.aviary.android.feather.common.utils.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

// Referenced classes of package com.aviary.android.feather.headless.moa.moalite:
//            MoaLitePack

final class MoaLiteParserDefault extends MoaLiteParserFactory.MoaLiteParser
{

    MoaLiteParserDefault()
    {
    }

    public MoaLitePack parseStream(InputStream inputstream)
        throws IOException, JSONException
    {
        Log.i("parser", "ANDROID-10");
        Object obj = new JSONObject(new JSONTokener(IOUtils.readFully(inputstream)));
        inputstream = new MoaLitePack();
        inputstream.setIdentifier(((JSONObject) (obj)).getString("identifier"));
        inputstream.setPackVersionCode(((JSONObject) (obj)).getInt("packVersionCode"));
        inputstream.setPackType(((JSONObject) (obj)).getString("packType"));
        inputstream.setCodename(((JSONObject) (obj)).getString("codename"));
        inputstream.setDisplayName(((JSONObject) (obj)).getString("displayName"));
        inputstream.setMinVersion(((JSONObject) (obj)).getString("minVersion"));
        obj = ((JSONObject) (obj)).getJSONArray("items");
        for (int i = 0; i < ((JSONArray) (obj)).length(); i++)
        {
            JSONObject jsonobject = ((JSONArray) (obj)).getJSONObject(i);
            MoaLitePack.MoaLiteItem moaliteitem = new MoaLitePack.MoaLiteItem();
            moaliteitem.setDisplayName(jsonobject.getString("displayName"));
            moaliteitem.setRef(jsonobject.getString("ref"));
            inputstream.addItem(moaliteitem);
        }

        return inputstream;
    }
}
