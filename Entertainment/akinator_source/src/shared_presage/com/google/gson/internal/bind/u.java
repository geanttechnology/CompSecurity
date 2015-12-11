// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson.internal.bind;

import java.util.BitSet;
import shared_presage.com.google.gson.JsonSyntaxException;
import shared_presage.com.google.gson.TypeAdapter;
import shared_presage.com.google.gson.stream.JsonReader;
import shared_presage.com.google.gson.stream.JsonToken;
import shared_presage.com.google.gson.stream.JsonWriter;

final class u extends TypeAdapter
{

    u()
    {
    }

    private static BitSet a(JsonReader jsonreader)
    {
        JsonToken jsontoken;
        BitSet bitset;
        int i;
        if (jsonreader.peek() == JsonToken.NULL)
        {
            jsonreader.nextNull();
            return null;
        }
        bitset = new BitSet();
        jsonreader.beginArray();
        jsontoken = jsonreader.peek();
        i = 0;
_L2:
        boolean flag;
        if (jsontoken == JsonToken.END_ARRAY)
        {
            break MISSING_BLOCK_LABEL_200;
        }
        switch (TypeAdapters._cls1.a[jsontoken.ordinal()])
        {
        default:
            throw new JsonSyntaxException((new StringBuilder("Invalid bitset value type: ")).append(jsontoken).toString());

        case 2: // '\002'
            break; /* Loop/switch isn't completed */

        case 3: // '\003'
            break MISSING_BLOCK_LABEL_147;

        case 1: // '\001'
            if (jsonreader.nextInt() != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            break;
        }
_L3:
        if (flag)
        {
            bitset.set(i);
        }
        i++;
        jsontoken = jsonreader.peek();
        if (true) goto _L2; else goto _L1
_L1:
        flag = jsonreader.nextBoolean();
          goto _L3
        String s = jsonreader.nextString();
        int j;
        try
        {
            j = Integer.parseInt(s);
        }
        // Misplaced declaration of an exception variable
        catch (JsonReader jsonreader)
        {
            throw new JsonSyntaxException((new StringBuilder("Error: Expecting: bitset number value (1, 0), Found: ")).append(s).toString());
        }
        if (j != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
          goto _L3
        jsonreader.endArray();
        return bitset;
    }

    public final Object read(JsonReader jsonreader)
    {
        return a(jsonreader);
    }

    public final void write(JsonWriter jsonwriter, Object obj)
    {
        obj = (BitSet)obj;
        if (obj == null)
        {
            jsonwriter.nullValue();
            return;
        }
        jsonwriter.beginArray();
        int i = 0;
        while (i < ((BitSet) (obj)).length()) 
        {
            int j;
            if (((BitSet) (obj)).get(i))
            {
                j = 1;
            } else
            {
                j = 0;
            }
            jsonwriter.value(j);
            i++;
        }
        jsonwriter.endArray();
    }
}
