// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.api;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.ArrayList;

// Referenced classes of package co.vine.android.api:
//            VineParsers, VineRecipient

public class VineUploadParsers
{

    public VineUploadParsers()
    {
    }

    public static VineUpload.PostInfo parsePostInfo(JsonParser jsonparser)
        throws IOException
    {
        String s;
        ArrayList arraylist;
        String s1;
        Object obj;
        String s2;
        String s3;
        Object obj1;
        int i;
        long l;
        long l1;
        long l2;
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = false;
        l2 = -1L;
        l1 = -1L;
        l = 0L;
        i = 0;
        s2 = "";
        s1 = "";
        s = "";
        s3 = "";
        obj = null;
        arraylist = null;
        obj1 = jsonparser.nextToken();
_L7:
        if (obj1 == null || obj1 == JsonToken.END_OBJECT)
        {
            break MISSING_BLOCK_LABEL_1222;
        }
        static class _cls1
        {

            static final int $SwitchMap$com$fasterxml$jackson$core$JsonToken[];

            static 
            {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken = new int[JsonToken.values().length];
                try
                {
                    $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_STRING.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_FALSE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_TRUE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_NUMBER_INT.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.START_ARRAY.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.fasterxml.jackson.core.JsonToken[((JsonToken) (obj1)).ordinal()];
        JVM INSTR tableswitch 1 5: default 104
    //                   1 207
    //                   2 366
    //                   3 366
    //                   4 535
    //                   5 828;
           goto _L1 _L2 _L3 _L3 _L4 _L5
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        Object obj2;
        String s4;
        String s5;
        String s6;
        ArrayList arraylist1;
        int j;
        long l3;
        long l4;
        long l5;
        boolean flag2;
        boolean flag3;
        j = i;
        arraylist1 = arraylist;
        l5 = l;
        s6 = s3;
        s5 = s;
        l4 = l1;
        s4 = s1;
        obj2 = obj;
        l3 = l2;
        flag3 = flag;
        flag2 = flag1;
        obj1 = s2;
_L8:
        JsonToken jsontoken = jsonparser.nextToken();
        s2 = ((String) (obj1));
        flag1 = flag2;
        flag = flag3;
        l2 = l3;
        obj = obj2;
        s1 = s4;
        l1 = l4;
        s = s5;
        s3 = s6;
        l = l5;
        arraylist = arraylist1;
        i = j;
        obj1 = jsontoken;
        if (true) goto _L7; else goto _L6
_L6:
        if ("description".equals(jsonparser.getCurrentName()))
        {
            s2 = jsonparser.getText();
        }
        if ("message".equals(jsonparser.getCurrentName()))
        {
            s1 = jsonparser.getText();
        }
        if ("videoUrl".equals(jsonparser.getCurrentName()))
        {
            s = jsonparser.getText();
        }
        obj1 = s2;
        flag2 = flag1;
        flag3 = flag;
        l3 = l2;
        obj2 = obj;
        s4 = s1;
        l4 = l1;
        s5 = s;
        s6 = s3;
        l5 = l;
        arraylist1 = arraylist;
        j = i;
        if ("thumbUrl".equals(jsonparser.getCurrentName()))
        {
            s6 = jsonparser.getText();
            obj1 = s2;
            flag2 = flag1;
            flag3 = flag;
            l3 = l2;
            obj2 = obj;
            s4 = s1;
            l4 = l1;
            s5 = s;
            l5 = l;
            arraylist1 = arraylist;
            j = i;
        }
          goto _L8
_L3:
        if ("postToTwitter".equals(jsonparser.getCurrentName()))
        {
            flag2 = jsonparser.getBooleanValue();
            obj1 = s2;
            flag3 = flag;
            l3 = l2;
            obj2 = obj;
            s4 = s1;
            l4 = l1;
            s5 = s;
            s6 = s3;
            l5 = l;
            arraylist1 = arraylist;
            j = i;
        } else
        {
            obj1 = s2;
            flag2 = flag1;
            flag3 = flag;
            l3 = l2;
            obj2 = obj;
            s4 = s1;
            l4 = l1;
            s5 = s;
            s6 = s3;
            l5 = l;
            arraylist1 = arraylist;
            j = i;
            if ("postToFacebook".equals(jsonparser.getCurrentName()))
            {
                flag3 = jsonparser.getBooleanValue();
                obj1 = s2;
                flag2 = flag1;
                l3 = l2;
                obj2 = obj;
                s4 = s1;
                l4 = l1;
                s5 = s;
                s6 = s3;
                l5 = l;
                arraylist1 = arraylist;
                j = i;
            }
        }
          goto _L8
_L4:
        if ("channelId".equals(jsonparser.getCurrentName()))
        {
            l3 = jsonparser.getLongValue();
            obj1 = s2;
            flag2 = flag1;
            flag3 = flag;
            obj2 = obj;
            s4 = s1;
            l4 = l1;
            s5 = s;
            s6 = s3;
            l5 = l;
            arraylist1 = arraylist;
            j = i;
        } else
        if ("created".equals(jsonparser.getCurrentName()))
        {
            l5 = jsonparser.getLongValue();
            obj1 = s2;
            flag2 = flag1;
            flag3 = flag;
            l3 = l2;
            obj2 = obj;
            s4 = s1;
            l4 = l1;
            s5 = s;
            s6 = s3;
            arraylist1 = arraylist;
            j = i;
        } else
        if ("maxLoops".equals(jsonparser.getCurrentName()))
        {
            j = jsonparser.getIntValue();
            obj1 = s2;
            flag2 = flag1;
            flag3 = flag;
            l3 = l2;
            obj2 = obj;
            s4 = s1;
            l4 = l1;
            s5 = s;
            s6 = s3;
            l5 = l;
            arraylist1 = arraylist;
        } else
        {
            obj1 = s2;
            flag2 = flag1;
            flag3 = flag;
            l3 = l2;
            obj2 = obj;
            s4 = s1;
            l4 = l1;
            s5 = s;
            s6 = s3;
            l5 = l;
            arraylist1 = arraylist;
            j = i;
            if ("postId".equals(jsonparser.getCurrentName()))
            {
                l4 = jsonparser.getLongValue();
                obj1 = s2;
                flag2 = flag1;
                flag3 = flag;
                l3 = l2;
                obj2 = obj;
                s4 = s1;
                s5 = s;
                s6 = s3;
                l5 = l;
                arraylist1 = arraylist;
                j = i;
            }
        }
          goto _L8
_L5:
        JsonToken jsontoken1;
        obj1 = jsonparser.getCurrentName();
        if (!"entities".equals(obj1))
        {
            break MISSING_BLOCK_LABEL_1003;
        }
        jsontoken1 = jsonparser.nextToken();
_L11:
        obj1 = s2;
        flag2 = flag1;
        flag3 = flag;
        l3 = l2;
        obj2 = obj;
        s4 = s1;
        l4 = l1;
        s5 = s;
        s6 = s3;
        l5 = l;
        arraylist1 = arraylist;
        j = i;
        if (jsontoken1 == null) goto _L8; else goto _L9
_L9:
        obj1 = s2;
        flag2 = flag1;
        flag3 = flag;
        l3 = l2;
        obj2 = obj;
        s4 = s1;
        l4 = l1;
        s5 = s;
        s6 = s3;
        l5 = l;
        arraylist1 = arraylist;
        j = i;
        if (jsontoken1 == JsonToken.END_ARRAY) goto _L8; else goto _L10
_L10:
        obj2 = VineParsers.parseEntity(jsonparser);
        obj1 = obj;
        if (obj == null)
        {
            obj1 = new ArrayList();
        }
        if (obj2 != null)
        {
            ((ArrayList) (obj1)).add(obj2);
        }
        jsontoken1 = jsonparser.nextToken();
        obj = obj1;
          goto _L11
        if (!"recipients".equals(obj1))
        {
            break MISSING_BLOCK_LABEL_1169;
        }
        jsontoken1 = jsonparser.nextToken();
_L14:
        obj1 = s2;
        flag2 = flag1;
        flag3 = flag;
        l3 = l2;
        obj2 = obj;
        s4 = s1;
        l4 = l1;
        s5 = s;
        s6 = s3;
        l5 = l;
        arraylist1 = arraylist;
        j = i;
        if (jsontoken1 == null) goto _L8; else goto _L12
_L12:
        obj1 = s2;
        flag2 = flag1;
        flag3 = flag;
        l3 = l2;
        obj2 = obj;
        s4 = s1;
        l4 = l1;
        s5 = s;
        s6 = s3;
        l5 = l;
        arraylist1 = arraylist;
        j = i;
        if (jsontoken1 == JsonToken.END_ARRAY) goto _L8; else goto _L13
_L13:
        obj2 = VineRecipient.fromJson(jsonparser);
        obj1 = arraylist;
        if (arraylist == null)
        {
            obj1 = new ArrayList();
        }
        if (obj2 != null)
        {
            ((ArrayList) (obj1)).add(obj2);
        }
        jsontoken1 = jsonparser.nextToken();
        arraylist = ((ArrayList) (obj1));
          goto _L14
        jsonparser.skipChildren();
        obj1 = s2;
        flag2 = flag1;
        flag3 = flag;
        l3 = l2;
        obj2 = obj;
        s4 = s1;
        l4 = l1;
        s5 = s;
        s6 = s3;
        l5 = l;
        arraylist1 = arraylist;
        j = i;
          goto _L8
        return new VineUpload.PostInfo(s2, flag1, flag, l2, ((ArrayList) (obj)), s1, l1, s, s3, l, arraylist, i);
    }
}
