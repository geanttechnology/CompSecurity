// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.api;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.DateTimeUtil;
import co.vine.android.util.Util;
import com.edisonwang.android.slog.SLog;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package co.vine.android.api:
//            VineActivityCounts, VineUser, VineChannel, VineClientFlags, 
//            VineComment, VineConversation, VineEntity, VineError, 
//            VineEverydayNotification, VineLike, VineLogin, VineLoopSubmissionResponse, 
//            VineMilestone, VineSingleNotification, VineNotificationSetting, VinePrivateMessage, 
//            VinePagedData, VinePost, VineVenue, VineRecipient, 
//            VinePrivateMessageResponse, VinePrivateMessagePostResponseWithUsers, VineRTCConversation, VineRTCParticipant, 
//            VineRepost, ServerStatus, VineTag, TwitterUser, 
//            VinePostResponse

public class VineParsers
{
    public static final class API_RESPONSE extends Enum
    {

        private static final API_RESPONSE $VALUES[];
        public static final API_RESPONSE FAILURE;
        public static final API_RESPONSE SUCCESS;

        public static API_RESPONSE valueOf(String s)
        {
            return (API_RESPONSE)Enum.valueOf(co/vine/android/api/VineParsers$API_RESPONSE, s);
        }

        public static API_RESPONSE[] values()
        {
            return (API_RESPONSE[])$VALUES.clone();
        }

        static 
        {
            SUCCESS = new API_RESPONSE("SUCCESS", 0);
            FAILURE = new API_RESPONSE("FAILURE", 1);
            $VALUES = (new API_RESPONSE[] {
                SUCCESS, FAILURE
            });
        }

        private API_RESPONSE(String s, int i)
        {
            super(s, i);
        }
    }

    public static interface PagedDataParser
    {
    }

    public static abstract class RecordListParser
        implements PagedDataParser
    {

        public abstract ArrayList parse(JsonParser jsonparser, Bundle bundle)
            throws IOException;

        public RecordListParser()
        {
        }
    }

    public static abstract class RecordParser
        implements PagedDataParser
    {

        public abstract Object parse(JsonParser jsonparser, Bundle bundle)
            throws IOException;

        public RecordParser()
        {
        }
    }

    public static class VinePagedConversation extends VinePagedData
    {

        public long lastMessage;
        public long lastMessageRead;
        public int networkType;
        public long unreadMessageCount;

        public VinePagedConversation()
        {
            unreadMessageCount = 0L;
            lastMessageRead = 0L;
            lastMessage = 0L;
        }
    }

    public static class VinePagedInbox extends VinePagedData
    {

        public ArrayList participants;

        public VinePagedInbox()
        {
            participants = new ArrayList();
        }
    }


    private static final RecordParser ACTIVITY_PARSER = new RecordParser() {

        public VineSingleNotification parse(JsonParser jsonparser, Bundle bundle)
            throws IOException
        {
            return VineParsers.parseNotification(jsonparser);
        }

        public volatile Object parse(JsonParser jsonparser, Bundle bundle)
            throws IOException
        {
            return parse(jsonparser, bundle);
        }

    };
    private static final RecordParser CHANNELS_PARSER = new RecordParser() {

        public VineChannel parse(JsonParser jsonparser, Bundle bundle)
            throws IOException
        {
            return VineParsers.parseChannel(jsonparser);
        }

        public volatile Object parse(JsonParser jsonparser, Bundle bundle)
            throws IOException
        {
            return parse(jsonparser, bundle);
        }

    };
    private static final RecordParser COMMENT_PARSER = new RecordParser() {

        public VineComment parse(JsonParser jsonparser, Bundle bundle)
            throws IOException
        {
            return VineParsers.parseComment(jsonparser);
        }

        public volatile Object parse(JsonParser jsonparser, Bundle bundle)
            throws IOException
        {
            return parse(jsonparser, bundle);
        }

    };
    private static final RecordParser CONVERSATIONS_PARSER = new RecordParser() {

        public VineConversation parse(JsonParser jsonparser, Bundle bundle)
            throws IOException
        {
            return VineParsers.parseConversation(jsonparser);
        }

        public volatile Object parse(JsonParser jsonparser, Bundle bundle)
            throws IOException
        {
            return parse(jsonparser, bundle);
        }

    };
    private static final RecordParser GROUPED_ACTIVITY_PARSER = new RecordParser() {

        public VineEverydayNotification parse(JsonParser jsonparser, Bundle bundle)
            throws IOException
        {
            return VineParsers.parseEverydayNotification(jsonparser);
        }

        public volatile Object parse(JsonParser jsonparser, Bundle bundle)
            throws IOException
        {
            return parse(jsonparser, bundle);
        }

    };
    public static final JsonFactory JSON_FACTORY = new JsonFactory();
    private static final RecordParser LIKES_PARSER = new RecordParser() {

        public VineLike parse(JsonParser jsonparser, Bundle bundle)
            throws IOException
        {
            return VineParsers.parseLike(jsonparser);
        }

        public volatile Object parse(JsonParser jsonparser, Bundle bundle)
            throws IOException
        {
            return parse(jsonparser, bundle);
        }

    };
    private static final RecordParser MESSAGES_PARSER = new RecordParser() {

        public VinePrivateMessage parse(JsonParser jsonparser, Bundle bundle)
            throws IOException
        {
            return VineParsers.parsePrivateMessage(jsonparser);
        }

        public volatile Object parse(JsonParser jsonparser, Bundle bundle)
            throws IOException
        {
            return parse(jsonparser, bundle);
        }

    };
    private static final RecordParser NOTIFICATION_SETTING_PARSER = new RecordParser() {

        public VineNotificationSetting parse(JsonParser jsonparser, Bundle bundle)
            throws IOException
        {
            return VineParsers.parseNotificationSetting(jsonparser);
        }

        public volatile Object parse(JsonParser jsonparser, Bundle bundle)
            throws IOException
        {
            return parse(jsonparser, bundle);
        }

    };
    private static final String PARAM_DATA = "data";
    private static final String PARAM_EDITION_ID = "editionId";
    private static final String PARAM_NAME = "name";
    private static final String PARAM_RECORDS = "records";
    private static final String PARAM_USERS = "users";
    private static final RecordParser POST_PARSER = new RecordParser() {

        public VinePost parse(JsonParser jsonparser, Bundle bundle)
            throws IOException
        {
            return VineParsers.parsePost(jsonparser);
        }

        public volatile Object parse(JsonParser jsonparser, Bundle bundle)
            throws IOException
        {
            return parse(jsonparser, bundle);
        }

    };
    private static final RecordParser TAG_PARSER = new RecordParser() {

        public VineTag parse(JsonParser jsonparser, Bundle bundle)
            throws IOException
        {
            return VineParsers.parseTag(jsonparser);
        }

        public volatile Object parse(JsonParser jsonparser, Bundle bundle)
            throws IOException
        {
            return parse(jsonparser, bundle);
        }

    };
    private static final String TIMESTAMP_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS";
    private static final RecordListParser USERS_PARSER = new RecordListParser() {

        public ArrayList parse(JsonParser jsonparser, Bundle bundle)
            throws IOException
        {
            return VineParsers.parseUsersArray(jsonparser, bundle);
        }

    };
    private static final RecordParser USER_PARSER = new RecordParser() {

        public VineUser parse(JsonParser jsonparser, Bundle bundle)
            throws IOException
        {
            return VineParsers.parseUser(jsonparser);
        }

        public volatile Object parse(JsonParser jsonparser, Bundle bundle)
            throws IOException
        {
            return parse(jsonparser, bundle);
        }

    };

    public VineParsers()
    {
    }

    public static JsonParser createParser(InputStream inputstream)
        throws IOException
    {
        inputstream = JSON_FACTORY.createJsonParser(inputstream);
        inputstream.nextToken();
        return inputstream;
    }

    public static JsonParser createParser(String s)
        throws IOException
    {
        s = JSON_FACTORY.createJsonParser(s);
        s.nextToken();
        return s;
    }

    private static VineActivityCounts parseActivityCounts(JsonParser jsonparser)
        throws IOException
    {
        JsonToken jsontoken;
        int i;
        int j;
        i = 0;
        j = 0;
        jsontoken = jsonparser.nextToken();
_L7:
        if (jsontoken == null || jsontoken == JsonToken.END_OBJECT) goto _L2; else goto _L1
_L1:
        static class _cls13
        {

            static final int $SwitchMap$com$fasterxml$jackson$core$JsonToken[];

            static 
            {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken = new int[JsonToken.values().length];
                try
                {
                    $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.START_OBJECT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.START_ARRAY.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_NUMBER_INT.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_STRING.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_TRUE.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_FALSE.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[jsontoken.ordinal()];
        JVM INSTR tableswitch 3 3: default 48
    //                   3 62;
           goto _L3 _L4
_L3:
        int k = i;
_L5:
        jsontoken = jsonparser.nextToken();
        i = k;
        continue; /* Loop/switch isn't completed */
_L4:
        String s = jsonparser.getCurrentName();
        if ("messages".equals(s))
        {
            k = jsonparser.getIntValue();
        } else
        {
            k = i;
            if ("notifications".equals(s))
            {
                j = jsonparser.getIntValue();
                k = i;
            }
        }
        if (true) goto _L5; else goto _L2
_L2:
        return new VineActivityCounts(i, j);
        if (true) goto _L7; else goto _L6
_L6:
    }

    private static ArrayList parseBlockedUsers(JsonParser jsonparser)
        throws IOException
    {
        JsonToken jsontoken;
        ArrayList arraylist;
        arraylist = new ArrayList();
        jsontoken = jsonparser.nextToken();
_L2:
        if (jsontoken == null || jsontoken == JsonToken.END_OBJECT)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        switch (_cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[jsontoken.ordinal()])
        {
        default:
            break;

        case 3: // '\003'
            break; /* Loop/switch isn't completed */

        case 1: // '\001'
        case 2: // '\002'
            break;
        }
        break MISSING_BLOCK_LABEL_93;
_L3:
        jsontoken = jsonparser.nextToken();
        if (true) goto _L2; else goto _L1
_L1:
        VineUser vineuser = new VineUser();
        vineuser.userId = jsonparser.getLongValue();
        arraylist.add(vineuser);
          goto _L3
        jsonparser.skipChildren();
          goto _L3
        return arraylist;
    }

    private static VineChannel parseChannel(JsonParser jsonparser)
        throws IOException
    {
        co/vine/android/api/VineParsers;
        JVM INSTR monitorenter ;
        Object obj;
        VineChannel vinechannel;
        vinechannel = new VineChannel();
        obj = jsonparser.nextToken();
_L8:
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (obj == JsonToken.END_OBJECT) goto _L2; else goto _L3
_L3:
        _cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[((JsonToken) (obj)).ordinal()];
        JVM INSTR tableswitch 1 4: default 251
    //                   1 72
    //                   2 72
    //                   3 222
    //                   4 86;
           goto _L4 _L5 _L5 _L6 _L7
_L4:
        obj = jsonparser.nextToken();
          goto _L8
_L5:
        jsonparser.skipChildren();
          goto _L4
        jsonparser;
        throw jsonparser;
_L7:
        obj = jsonparser.getCurrentName();
        if (!"channel".equals(obj)) goto _L10; else goto _L9
_L9:
        vinechannel.channel = jsonparser.getText();
          goto _L4
_L10:
        if (!"iconFullUrl".equals(obj)) goto _L12; else goto _L11
_L11:
        vinechannel.iconFullUrl = jsonparser.getText();
          goto _L4
_L12:
        if (!"retinaIconFullUrl".equals(obj)) goto _L14; else goto _L13
_L13:
        vinechannel.retinaIconFullUrl = jsonparser.getText();
          goto _L4
_L14:
        if (!"created".equals(obj)) goto _L16; else goto _L15
_L15:
        vinechannel.created = DateTimeUtil.getTimeInMsFromString(jsonparser.getText(), "yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
          goto _L4
_L16:
        if (!"backgroundColor".equals(obj)) goto _L18; else goto _L17
_L17:
        vinechannel.backgroundColor = jsonparser.getText();
          goto _L4
_L18:
        if (!"fontColor".equals(obj)) goto _L4; else goto _L19
_L19:
        vinechannel.fontColor = jsonparser.getText();
          goto _L4
_L6:
        if (!"channelId".equals(jsonparser.getCurrentName())) goto _L4; else goto _L20
_L20:
        vinechannel.channelId = jsonparser.getLongValue();
          goto _L4
_L2:
        co/vine/android/api/VineParsers;
        JVM INSTR monitorexit ;
        return vinechannel;
    }

    private static VineClientFlags parseClientFlags(JsonParser jsonparser)
        throws IOException
    {
        String s;
        String s1;
        String s2;
        String s3;
        String s4;
        String s5;
        Object obj;
        long l;
        s5 = null;
        s4 = null;
        s3 = null;
        s2 = null;
        s = null;
        s1 = null;
        l = 0L;
        obj = jsonparser.nextToken();
_L6:
        long l1;
        if (obj == null || obj == JsonToken.END_OBJECT)
        {
            break MISSING_BLOCK_LABEL_447;
        }
        l1 = l;
        _cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[((JsonToken) (obj)).ordinal()];
        JVM INSTR tableswitch 1 4: default 80
    //                   1 421
    //                   2 421
    //                   3 398
    //                   4 137;
           goto _L1 _L2 _L2 _L3 _L4
_L2:
        break MISSING_BLOCK_LABEL_421;
_L4:
        break; /* Loop/switch isn't completed */
_L1:
        String s6;
        String s7;
        String s8;
        String s9;
        l1 = l;
        s9 = s;
        s8 = s2;
        s7 = s3;
        s6 = s4;
        obj = s5;
_L7:
        JsonToken jsontoken = jsonparser.nextToken();
        s5 = ((String) (obj));
        s4 = s6;
        s3 = s7;
        s2 = s8;
        s = s9;
        l = l1;
        obj = jsontoken;
        if (true) goto _L6; else goto _L5
_L5:
        String s10 = jsonparser.getCurrentName();
        if ("messageTitle".equals(s10))
        {
            obj = jsonparser.getText();
            s6 = s4;
            s7 = s3;
            s8 = s2;
            s9 = s;
            l1 = l;
        } else
        if ("messageText".equals(s10))
        {
            s6 = jsonparser.getText();
            obj = s5;
            s7 = s3;
            s8 = s2;
            s9 = s;
            l1 = l;
        } else
        if ("apiHost".equals(s10))
        {
            s7 = jsonparser.getText();
            obj = s5;
            s6 = s4;
            s8 = s2;
            s9 = s;
            l1 = l;
        } else
        if ("rtcHost".equals(s10))
        {
            s8 = jsonparser.getText();
            obj = s5;
            s6 = s4;
            s7 = s3;
            s9 = s;
            l1 = l;
        } else
        if ("mediaHost".equals(s10))
        {
            s9 = jsonparser.getText();
            obj = s5;
            s6 = s4;
            s7 = s3;
            s8 = s2;
            l1 = l;
        } else
        {
            obj = s5;
            s6 = s4;
            s7 = s3;
            s8 = s2;
            s9 = s;
            l1 = l;
            if ("exploreHost".equals(s10))
            {
                s1 = jsonparser.getText();
                obj = s5;
                s6 = s4;
                s7 = s3;
                s8 = s2;
                s9 = s;
                l1 = l;
            }
        }
          goto _L7
_L3:
        l1 = l;
        if ("ttl_s".equals(jsonparser.getCurrentName()))
        {
            l1 = jsonparser.getLongValue();
        }
        jsonparser.skipChildren();
        obj = s5;
        s6 = s4;
        s7 = s3;
        s8 = s2;
        s9 = s;
          goto _L7
        return new VineClientFlags(s5, s4, s3, s2, s, s1, l);
    }

    public static JSONObject parseClientProfile(JsonParser jsonparser)
        throws IOException
    {
        JsonToken jsontoken;
        JSONObject jsonobject;
        SLog.d("Parse client profile.");
        jsontoken = jsonparser.nextToken();
        jsonobject = new JSONObject();
_L7:
        if (jsontoken == null || jsontoken == JsonToken.END_OBJECT)
        {
            break MISSING_BLOCK_LABEL_160;
        }
        _cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[jsontoken.ordinal()];
        JVM INSTR tableswitch 1 6: default 76
    //                   1 144
    //                   2 152
    //                   3 114
    //                   4 76
    //                   5 84
    //                   6 84;
           goto _L1 _L2 _L3 _L4 _L1 _L5 _L5
_L3:
        break MISSING_BLOCK_LABEL_152;
_L1:
        break; /* Loop/switch isn't completed */
_L5:
        break; /* Loop/switch isn't completed */
_L8:
        jsontoken = jsonparser.nextToken();
        if (true) goto _L7; else goto _L6
_L6:
        try
        {
            jsonobject.put(jsonparser.getCurrentName(), jsonparser.getBooleanValue());
        }
        catch (JSONException jsonexception)
        {
            SLog.d("Failed to parse: {}.", jsonparser.getCurrentName());
        }
          goto _L8
_L4:
        try
        {
            jsonobject.put(jsonparser.getCurrentName(), jsonparser.getIntValue());
        }
        catch (JSONException jsonexception1)
        {
            SLog.d("Failed to parse: {}.", jsonparser.getCurrentName());
        }
          goto _L8
_L2:
        jsonparser.skipChildren();
          goto _L8
        jsonparser.skipChildren();
          goto _L8
        SLog.d("Parsed client profile: ", jsonobject);
        return jsonobject;
    }

    private static VineComment parseComment(JsonParser jsonparser)
        throws IOException
    {
        ArrayList arraylist;
        String s;
        String s1;
        VineUser vineuser;
        String s2;
        String s3;
        Object obj;
        long l;
        long l1;
        long l2;
        boolean flag;
        obj = jsonparser.nextToken();
        s2 = null;
        s3 = null;
        l1 = 0L;
        l2 = 0L;
        s1 = null;
        vineuser = null;
        l = 0L;
        s = null;
        flag = false;
        arraylist = null;
_L8:
        if (obj == null || obj == JsonToken.END_OBJECT)
        {
            break MISSING_BLOCK_LABEL_1033;
        }
        _cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[((JsonToken) (obj)).ordinal()];
        JVM INSTR tableswitch 1 6: default 92
    //                   1 179
    //                   2 835
    //                   3 594
    //                   4 279
    //                   5 743
    //                   6 743;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L6
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        Object obj1;
        VineUser vineuser1;
        String s4;
        String s5;
        ArrayList arraylist1;
        long l3;
        long l4;
        long l5;
        boolean flag1;
        arraylist1 = arraylist;
        flag1 = flag;
        s5 = s;
        l5 = l;
        s4 = s1;
        l4 = l1;
        vineuser1 = vineuser;
        obj1 = s2;
        obj = s3;
        l3 = l2;
_L9:
        JsonToken jsontoken = jsonparser.nextToken();
        l2 = l3;
        s3 = ((String) (obj));
        s2 = ((String) (obj1));
        vineuser = vineuser1;
        l1 = l4;
        s1 = s4;
        l = l5;
        s = s5;
        flag = flag1;
        arraylist = arraylist1;
        obj = jsontoken;
        if (true) goto _L8; else goto _L7
_L7:
        if ("user".equals(jsonparser.getCurrentName()))
        {
            vineuser1 = parseUser(jsonparser);
            l3 = l2;
            obj = s3;
            obj1 = s2;
            l4 = l1;
            s4 = s1;
            l5 = l;
            s5 = s;
            flag1 = flag;
            arraylist1 = arraylist;
        } else
        {
            jsonparser.skipChildren();
            l3 = l2;
            obj = s3;
            obj1 = s2;
            vineuser1 = vineuser;
            l4 = l1;
            s4 = s1;
            l5 = l;
            s5 = s;
            flag1 = flag;
            arraylist1 = arraylist;
        }
          goto _L9
_L5:
        String s6 = jsonparser.getCurrentName();
        if ("avatarUrl".equals(s6))
        {
            obj1 = jsonparser.getText();
            l3 = l2;
            obj = s3;
            vineuser1 = vineuser;
            l4 = l1;
            s4 = s1;
            l5 = l;
            s5 = s;
            flag1 = flag;
            arraylist1 = arraylist;
        } else
        if ("comment".equals(s6))
        {
            obj = jsonparser.getText();
            l3 = l2;
            obj1 = s2;
            vineuser1 = vineuser;
            l4 = l1;
            s4 = s1;
            l5 = l;
            s5 = s;
            flag1 = flag;
            arraylist1 = arraylist;
        } else
        if ("created".equals(s6))
        {
            l4 = DateTimeUtil.getTimeInMsFromString(jsonparser.getText(), "yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
            l3 = l2;
            obj = s3;
            obj1 = s2;
            vineuser1 = vineuser;
            s4 = s1;
            l5 = l;
            s5 = s;
            flag1 = flag;
            arraylist1 = arraylist;
        } else
        if ("location".equals(s6))
        {
            s4 = jsonparser.getText();
            l3 = l2;
            obj = s3;
            obj1 = s2;
            vineuser1 = vineuser;
            l4 = l1;
            l5 = l;
            s5 = s;
            flag1 = flag;
            arraylist1 = arraylist;
        } else
        {
            l3 = l2;
            obj = s3;
            obj1 = s2;
            vineuser1 = vineuser;
            l4 = l1;
            s4 = s1;
            l5 = l;
            s5 = s;
            flag1 = flag;
            arraylist1 = arraylist;
            if ("username".equals(s6))
            {
                s5 = jsonparser.getText();
                l3 = l2;
                obj = s3;
                obj1 = s2;
                vineuser1 = vineuser;
                l4 = l1;
                s4 = s1;
                l5 = l;
                flag1 = flag;
                arraylist1 = arraylist;
            }
        }
          goto _L9
_L4:
        String s7 = jsonparser.getCurrentName();
        if ("commentId".equals(s7))
        {
            l3 = jsonparser.getLongValue();
            obj = s3;
            obj1 = s2;
            vineuser1 = vineuser;
            l4 = l1;
            s4 = s1;
            l5 = l;
            s5 = s;
            flag1 = flag;
            arraylist1 = arraylist;
        } else
        {
            l3 = l2;
            obj = s3;
            obj1 = s2;
            vineuser1 = vineuser;
            l4 = l1;
            s4 = s1;
            l5 = l;
            s5 = s;
            flag1 = flag;
            arraylist1 = arraylist;
            if ("userId".equals(s7))
            {
                l5 = jsonparser.getLongValue();
                l3 = l2;
                obj = s3;
                obj1 = s2;
                vineuser1 = vineuser;
                l4 = l1;
                s4 = s1;
                s5 = s;
                flag1 = flag;
                arraylist1 = arraylist;
            }
        }
          goto _L9
_L6:
        l3 = l2;
        obj = s3;
        obj1 = s2;
        vineuser1 = vineuser;
        l4 = l1;
        s4 = s1;
        l5 = l;
        s5 = s;
        flag1 = flag;
        arraylist1 = arraylist;
        if ("verified".equals(jsonparser.getCurrentName()))
        {
            flag1 = jsonparser.getBooleanValue();
            l3 = l2;
            obj = s3;
            obj1 = s2;
            vineuser1 = vineuser;
            l4 = l1;
            s4 = s1;
            l5 = l;
            s5 = s;
            arraylist1 = arraylist;
        }
          goto _L9
_L3:
        JsonToken jsontoken1;
        if (!"entities".equals(jsonparser.getCurrentName()))
        {
            break MISSING_BLOCK_LABEL_988;
        }
        jsontoken1 = jsonparser.nextToken();
_L12:
        l3 = l2;
        obj = s3;
        obj1 = s2;
        vineuser1 = vineuser;
        l4 = l1;
        s4 = s1;
        l5 = l;
        s5 = s;
        flag1 = flag;
        arraylist1 = arraylist;
        if (jsontoken1 == null) goto _L9; else goto _L10
_L10:
        l3 = l2;
        obj = s3;
        obj1 = s2;
        vineuser1 = vineuser;
        l4 = l1;
        s4 = s1;
        l5 = l;
        s5 = s;
        flag1 = flag;
        arraylist1 = arraylist;
        if (jsontoken1 == JsonToken.END_ARRAY) goto _L9; else goto _L11
_L11:
        obj1 = parseEntity(jsonparser);
        obj = arraylist;
        if (arraylist == null)
        {
            obj = new ArrayList();
        }
        if (obj1 != null)
        {
            ((ArrayList) (obj)).add(obj1);
        }
        jsontoken1 = jsonparser.nextToken();
        arraylist = ((ArrayList) (obj));
          goto _L12
        jsonparser.skipChildren();
        l3 = l2;
        obj = s3;
        obj1 = s2;
        vineuser1 = vineuser;
        l4 = l1;
        s4 = s1;
        l5 = l;
        s5 = s;
        flag1 = flag;
        arraylist1 = arraylist;
          goto _L9
        if (arraylist != null)
        {
            Util.validateAndFixEntities(arraylist);
        }
        return new VineComment(l2, s3, s2, vineuser, l1, s1, l, s, flag, 0L, arraylist, false);
    }

    private static VineConversation parseConversation(JsonParser jsonparser)
        throws IOException
    {
        ArrayList arraylist;
        Object obj;
        Object obj1;
        int i;
        long l;
        long l1;
        long l2;
        long l3;
        obj1 = jsonparser.nextToken();
        l3 = 0L;
        l1 = 0L;
        l2 = 0L;
        l = 0L;
        obj = null;
        arraylist = null;
        i = 1;
_L9:
        if (obj1 == null || obj1 == JsonToken.END_OBJECT) goto _L2; else goto _L1
_L1:
        _cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[((JsonToken) (obj1)).ordinal()];
        JVM INSTR tableswitch 1 6: default 80
    //                   1 484
    //                   2 588
    //                   3 245
    //                   4 142
    //                   5 517
    //                   6 517;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L8
_L3:
        Object obj2;
        int j;
        long l4;
        long l5;
        long l6;
        long l7;
        l7 = l;
        j = i;
        obj2 = arraylist;
        obj1 = obj;
        l6 = l1;
        l5 = l2;
        l4 = l3;
_L10:
        JsonToken jsontoken = jsonparser.nextToken();
        l3 = l4;
        l2 = l5;
        l1 = l6;
        obj = obj1;
        arraylist = ((ArrayList) (obj2));
        i = j;
        l = l7;
        obj1 = jsontoken;
          goto _L9
_L7:
        l4 = l3;
        l5 = l2;
        l6 = l1;
        obj1 = obj;
        obj2 = arraylist;
        j = i;
        l7 = l;
        if ("inbox".equals(jsonparser.getCurrentName()))
        {
            l4 = l3;
            l5 = l2;
            l6 = l1;
            obj1 = obj;
            obj2 = arraylist;
            j = i;
            l7 = l;
            if ("other".equals(jsonparser.getValueAsString()))
            {
                j = 2;
                l4 = l3;
                l5 = l2;
                l6 = l1;
                obj1 = obj;
                obj2 = arraylist;
                l7 = l;
            }
        }
          goto _L10
_L6:
        String s = jsonparser.getCurrentName();
        if ("conversationId".equals(s))
        {
            l4 = jsonparser.getLongValue();
            l5 = l2;
            l6 = l1;
            obj1 = obj;
            obj2 = arraylist;
            j = i;
            l7 = l;
        } else
        if ("lastMessage".equals(s))
        {
            l5 = jsonparser.getLongValue();
            l4 = l3;
            l6 = l1;
            obj1 = obj;
            obj2 = arraylist;
            j = i;
            l7 = l;
        } else
        if ("lastMessageRead".equals(s))
        {
            jsonparser.getLongValue();
            l4 = l3;
            l5 = l2;
            l6 = l1;
            obj1 = obj;
            obj2 = arraylist;
            j = i;
            l7 = l;
        } else
        if ("unreadMessageCount".equals(s))
        {
            l7 = jsonparser.getLongValue();
            l4 = l3;
            l5 = l2;
            l6 = l1;
            obj1 = obj;
            obj2 = arraylist;
            j = i;
        } else
        {
            l4 = l3;
            l5 = l2;
            l6 = l1;
            obj1 = obj;
            obj2 = arraylist;
            j = i;
            l7 = l;
            if ("createdBy".equals(s))
            {
                l6 = jsonparser.getLongValue();
                l4 = l3;
                l5 = l2;
                obj1 = obj;
                obj2 = arraylist;
                j = i;
                l7 = l;
            }
        }
          goto _L10
_L4:
        jsonparser.skipChildren();
        l4 = l3;
        l5 = l2;
        l6 = l1;
        obj1 = obj;
        obj2 = arraylist;
        j = i;
        l7 = l;
          goto _L10
_L8:
        l4 = l3;
        l5 = l2;
        l6 = l1;
        obj1 = obj;
        obj2 = arraylist;
        j = i;
        l7 = l;
        if ("deleted".equals(jsonparser.getCurrentName()))
        {
            jsonparser.getBooleanValue();
            l4 = l3;
            l5 = l2;
            l6 = l1;
            obj1 = obj;
            obj2 = arraylist;
            j = i;
            l7 = l;
        }
          goto _L10
_L5:
        JsonToken jsontoken1;
        obj1 = jsonparser.getCurrentName();
        if (!"messages".equals(obj1))
        {
            break MISSING_BLOCK_LABEL_713;
        }
        jsontoken1 = jsonparser.nextToken();
_L13:
        l4 = l3;
        l5 = l2;
        l6 = l1;
        obj1 = obj;
        obj2 = arraylist;
        j = i;
        l7 = l;
        if (jsontoken1 == null) goto _L10; else goto _L11
_L11:
        l4 = l3;
        l5 = l2;
        l6 = l1;
        obj1 = obj;
        obj2 = arraylist;
        j = i;
        l7 = l;
        if (jsontoken1 == JsonToken.END_ARRAY) goto _L10; else goto _L12
_L12:
        obj2 = parsePrivateMessage(jsonparser);
        obj1 = obj;
        if (obj == null)
        {
            obj1 = new ArrayList();
        }
        if (obj1 != null)
        {
            ((ArrayList) (obj1)).add(obj2);
        }
        jsontoken1 = jsonparser.nextToken();
        obj = obj1;
          goto _L13
        if (!"users".equals(obj1)) goto _L15; else goto _L14
_L14:
        jsontoken1 = jsonparser.nextToken();
_L22:
        l4 = l3;
        l5 = l2;
        l6 = l1;
        obj1 = obj;
        obj2 = arraylist;
        j = i;
        l7 = l;
        if (jsontoken1 == null) goto _L10; else goto _L16
_L16:
        l4 = l3;
        l5 = l2;
        l6 = l1;
        obj1 = obj;
        obj2 = arraylist;
        j = i;
        l7 = l;
        if (jsontoken1 == JsonToken.END_ARRAY) goto _L10; else goto _L17
_L17:
        _cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[jsontoken1.ordinal()];
        JVM INSTR tableswitch 3 3: default 820
    //                   3 829;
           goto _L18 _L19
_L18:
        jsontoken1 = jsonparser.nextToken();
          goto _L20
_L19:
        l4 = jsonparser.getLongValue();
        obj1 = arraylist;
        if (arraylist == null)
        {
            obj1 = new ArrayList();
        }
        arraylist = ((ArrayList) (obj1));
        if (obj1 != null)
        {
            ((ArrayList) (obj1)).add(Long.valueOf(l4));
            arraylist = ((ArrayList) (obj1));
        }
        if (true) goto _L18; else goto _L20
_L20:
        if (true) goto _L22; else goto _L21
_L21:
_L15:
        jsonparser.skipChildren();
        l4 = l3;
        l5 = l2;
        l6 = l1;
        obj1 = obj;
        obj2 = arraylist;
        j = i;
        l7 = l;
          goto _L10
_L2:
        return new VineConversation(l3, l2, l1, ((ArrayList) (obj)), arraylist, i, l);
    }

    private static Object parseEditions(JsonParser jsonparser)
        throws IOException
    {
        ArrayList arraylist = new ArrayList();
        JsonToken jsontoken = jsonparser.nextToken();
        String s1;
        for (String s = null; jsontoken != null && jsontoken != JsonToken.END_OBJECT; s = s1)
        {
            s1 = s;
            if (jsontoken == JsonToken.START_OBJECT)
            {
                jsontoken = jsonparser.nextToken();
                do
                {
                    s1 = s;
                    if (jsontoken == null)
                    {
                        break;
                    }
                    s1 = s;
                    if (jsontoken == JsonToken.END_OBJECT)
                    {
                        break;
                    }
                    s1 = s;
                    if (jsontoken == JsonToken.VALUE_STRING)
                    {
                        if ("editionId".equals(jsonparser.getCurrentName()))
                        {
                            s1 = jsonparser.getText();
                        } else
                        {
                            s1 = s;
                            if ("name".equals(jsonparser.getCurrentName()))
                            {
                                arraylist.add(new Pair(s, jsonparser.getText()));
                                s1 = s;
                            }
                        }
                    }
                    jsontoken = jsonparser.nextToken();
                    s = s1;
                } while (true);
            }
            jsontoken = jsonparser.nextToken();
        }

        return arraylist;
    }

    public static VineEntity parseEntity(JsonParser jsonparser)
        throws IOException
    {
        String s;
        String s1;
        String s2;
        Object obj;
        int i;
        int j;
        long l1;
        s2 = null;
        s = null;
        s1 = null;
        l1 = 0L;
        i = -1;
        j = -1;
        obj = jsonparser.nextToken();
_L7:
        if (obj == null || obj == JsonToken.END_OBJECT) goto _L2; else goto _L1
_L1:
        int k;
        int l;
        k = i;
        l = j;
        _cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[((JsonToken) (obj)).ordinal()];
        JVM INSTR tableswitch 2 4: default 76
    //                   2 272
    //                   3 394
    //                   4 131;
           goto _L3 _L4 _L5 _L6
_L5:
        break MISSING_BLOCK_LABEL_394;
_L3:
        String s3;
        String s4;
        int i1;
        int j1;
        long l2;
        l2 = l1;
        j1 = j;
        i1 = i;
        s4 = s;
        s3 = s1;
        obj = s2;
_L8:
        JsonToken jsontoken = jsonparser.nextToken();
        s2 = ((String) (obj));
        s1 = s3;
        s = s4;
        i = i1;
        j = j1;
        l1 = l2;
        obj = jsontoken;
          goto _L7
_L6:
        String s5 = jsonparser.getCurrentName();
        if ("type".equals(s5))
        {
            obj = jsonparser.getText();
            s3 = s1;
            s4 = s;
            i1 = i;
            j1 = j;
            l2 = l1;
        } else
        if ("link".equals(s5))
        {
            s4 = jsonparser.getText();
            obj = s2;
            s3 = s1;
            i1 = i;
            j1 = j;
            l2 = l1;
        } else
        {
            obj = s2;
            s3 = s1;
            s4 = s;
            i1 = i;
            j1 = j;
            l2 = l1;
            if ("title".equals(s5))
            {
                s3 = jsonparser.getText();
                obj = s2;
                s4 = s;
                i1 = i;
                j1 = j;
                l2 = l1;
            }
        }
          goto _L8
_L4:
        if (!"range".equals(jsonparser.getCurrentName())) goto _L10; else goto _L9
_L9:
        obj = jsonparser.nextToken();
_L14:
        k = i;
        l = j;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_394;
        }
        k = i;
        l = j;
        if (obj == JsonToken.END_ARRAY)
        {
            break MISSING_BLOCK_LABEL_394;
        }
        _cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[((JsonToken) (obj)).ordinal()];
        JVM INSTR tableswitch 3 3: default 348
    //                   3 357;
           goto _L11 _L12
_L11:
        obj = jsonparser.nextToken();
        continue; /* Loop/switch isn't completed */
_L12:
        if (i == -1)
        {
            i = jsonparser.getIntValue();
        } else
        {
            j = jsonparser.getIntValue();
        }
        if (true) goto _L11; else goto _L10
_L10:
        jsonparser.skipChildren();
        l = j;
        k = i;
        break MISSING_BLOCK_LABEL_394;
        if (true) goto _L14; else goto _L13
_L13:
        obj = s2;
        s3 = s1;
        s4 = s;
        i1 = k;
        j1 = l;
        l2 = l1;
        if ("id".equals(jsonparser.getCurrentName()))
        {
            l2 = jsonparser.getLongValue();
            obj = s2;
            s3 = s1;
            s4 = s;
            i1 = k;
            j1 = l;
        }
          goto _L8
_L2:
        return new VineEntity(s2, s1, s, i, j, l1);
    }

    public static VineError parseError(JsonParser jsonparser)
        throws IOException
    {
        String s;
        String s1;
        Object obj;
        int i;
        i = 0;
        s = null;
        s1 = null;
        obj = jsonparser.nextToken();
_L7:
        if (obj == null || obj == JsonToken.END_OBJECT)
        {
            break MISSING_BLOCK_LABEL_224;
        }
        _cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[((JsonToken) (obj)).ordinal()];
        JVM INSTR tableswitch 1 4: default 60
    //                   1 90
    //                   2 107
    //                   3 124
    //                   4 160;
           goto _L1 _L2 _L3 _L4 _L5
_L5:
        break MISSING_BLOCK_LABEL_160;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        String s2;
        int j;
        s2 = s;
        j = i;
        obj = s1;
_L8:
        JsonToken jsontoken = jsonparser.nextToken();
        s1 = ((String) (obj));
        i = j;
        s = s2;
        obj = jsontoken;
        if (true) goto _L7; else goto _L6
_L6:
        jsonparser.skipChildren();
        obj = s1;
        j = i;
        s2 = s;
          goto _L8
_L3:
        jsonparser.skipChildren();
        obj = s1;
        j = i;
        s2 = s;
          goto _L8
_L4:
        obj = s1;
        j = i;
        s2 = s;
        if ("code".equals(jsonparser.getCurrentName()))
        {
            j = jsonparser.getIntValue();
            obj = s1;
            s2 = s;
        }
          goto _L8
        if ("error".equals(jsonparser.getCurrentName()))
        {
            s2 = jsonparser.getText();
            obj = s1;
            j = i;
        } else
        {
            obj = s1;
            j = i;
            s2 = s;
            if ("data".equals(jsonparser.getCurrentName()))
            {
                obj = jsonparser.getText();
                j = i;
                s2 = s;
            }
        }
          goto _L8
        return new VineError(i, s, s1);
    }

    private static VineEverydayNotification parseEverydayNotification(JsonParser jsonparser)
        throws IOException
    {
        ArrayList arraylist;
        VineMilestone vinemilestone;
        VineUser vineuser;
        VinePost vinepost;
        String s;
        String s1;
        Object obj;
        long l1;
        long l2;
        long l3;
        boolean flag;
        obj = jsonparser.nextToken();
        s1 = null;
        l3 = 0L;
        l1 = 0x7fffffffffffffffL;
        s = null;
        arraylist = null;
        vineuser = null;
        vinepost = null;
        vinemilestone = null;
        flag = false;
        l2 = 0L;
_L7:
        if (obj == null || obj == JsonToken.END_OBJECT)
        {
            break MISSING_BLOCK_LABEL_1065;
        }
        _cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[((JsonToken) (obj)).ordinal()];
        JVM INSTR tableswitch 1 4: default 88
    //                   1 853
    //                   2 655
    //                   3 438
    //                   4 175;
           goto _L1 _L2 _L3 _L4 _L5
_L5:
        break; /* Loop/switch isn't completed */
_L2:
        break MISSING_BLOCK_LABEL_853;
_L1:
        Object obj1;
        VinePost vinepost1;
        VineUser vineuser1;
        ArrayList arraylist1;
        VineMilestone vinemilestone1;
        long l;
        long l4;
        long l5;
        boolean flag1;
        l = l2;
        flag1 = flag;
        l5 = l1;
        vinemilestone1 = vinemilestone;
        arraylist1 = arraylist;
        vineuser1 = vineuser;
        vinepost1 = vinepost;
        obj1 = s;
        l4 = l3;
        obj = s1;
_L8:
        JsonToken jsontoken = jsonparser.nextToken();
        s1 = ((String) (obj));
        l3 = l4;
        s = ((String) (obj1));
        vinepost = vinepost1;
        vineuser = vineuser1;
        arraylist = arraylist1;
        vinemilestone = vinemilestone1;
        l1 = l5;
        flag = flag1;
        l2 = l;
        obj = jsontoken;
        if (true) goto _L7; else goto _L6
_L6:
        String s2 = jsonparser.getCurrentName();
        if ("body".equals(s2))
        {
            obj = jsonparser.getText();
            l4 = l3;
            obj1 = s;
            vinepost1 = vinepost;
            vineuser1 = vineuser;
            arraylist1 = arraylist;
            vinemilestone1 = vinemilestone;
            l5 = l1;
            flag1 = flag;
            l = l2;
        } else
        if ("type".equals(s2))
        {
            obj1 = jsonparser.getText();
            obj = s1;
            l4 = l3;
            vinepost1 = vinepost;
            vineuser1 = vineuser;
            arraylist1 = arraylist;
            vinemilestone1 = vinemilestone;
            l5 = l1;
            flag1 = flag;
            l = l2;
        } else
        if ("lastActivityTime".equals(s2))
        {
            l5 = DateTimeUtil.getTimeInMsFromString(jsonparser.getText(), "yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
            obj = s1;
            l4 = l3;
            obj1 = s;
            vinepost1 = vinepost;
            vineuser1 = vineuser;
            arraylist1 = arraylist;
            vinemilestone1 = vinemilestone;
            flag1 = flag;
            l = l2;
        } else
        {
            obj = s1;
            l4 = l3;
            obj1 = s;
            vinepost1 = vinepost;
            vineuser1 = vineuser;
            arraylist1 = arraylist;
            vinemilestone1 = vinemilestone;
            l5 = l1;
            flag1 = flag;
            l = l2;
            if ("anchor".equals(s2))
            {
                l = Long.parseLong(jsonparser.getText());
                obj = s1;
                l4 = l3;
                obj1 = s;
                vinepost1 = vinepost;
                vineuser1 = vineuser;
                arraylist1 = arraylist;
                vinemilestone1 = vinemilestone;
                l5 = l1;
                flag1 = flag;
            }
        }
          goto _L8
_L4:
        String s3 = jsonparser.getCurrentName();
        if ("activityId".equals(s3))
        {
            l4 = jsonparser.getLongValue();
            obj = s1;
            obj1 = s;
            vinepost1 = vinepost;
            vineuser1 = vineuser;
            arraylist1 = arraylist;
            vinemilestone1 = vinemilestone;
            l5 = l1;
            flag1 = flag;
            l = l2;
        } else
        if ("isNew".equals(s3))
        {
            if (jsonparser.getIntValue() == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            obj = s1;
            l4 = l3;
            obj1 = s;
            vinepost1 = vinepost;
            vineuser1 = vineuser;
            arraylist1 = arraylist;
            vinemilestone1 = vinemilestone;
            l5 = l1;
            flag1 = flag;
            l = l2;
        } else
        {
            obj = s1;
            l4 = l3;
            obj1 = s;
            vinepost1 = vinepost;
            vineuser1 = vineuser;
            arraylist1 = arraylist;
            vinemilestone1 = vinemilestone;
            l5 = l1;
            flag1 = flag;
            l = l2;
            if ("anchor".equals(s3))
            {
                l = jsonparser.getLongValue();
                obj = s1;
                l4 = l3;
                obj1 = s;
                vinepost1 = vinepost;
                vineuser1 = vineuser;
                arraylist1 = arraylist;
                vinemilestone1 = vinemilestone;
                l5 = l1;
                flag1 = flag;
            }
        }
          goto _L8
_L3:
        JsonToken jsontoken1;
        if (!"entities".equals(jsonparser.getCurrentName()))
        {
            break MISSING_BLOCK_LABEL_808;
        }
        jsontoken1 = jsonparser.nextToken();
_L11:
        obj = s1;
        l4 = l3;
        obj1 = s;
        vinepost1 = vinepost;
        vineuser1 = vineuser;
        arraylist1 = arraylist;
        vinemilestone1 = vinemilestone;
        l5 = l1;
        flag1 = flag;
        l = l2;
        if (jsontoken1 == null) goto _L8; else goto _L9
_L9:
        obj = s1;
        l4 = l3;
        obj1 = s;
        vinepost1 = vinepost;
        vineuser1 = vineuser;
        arraylist1 = arraylist;
        vinemilestone1 = vinemilestone;
        l5 = l1;
        flag1 = flag;
        l = l2;
        if (jsontoken1 == JsonToken.END_ARRAY) goto _L8; else goto _L10
_L10:
        obj1 = parseEntity(jsonparser);
        obj = arraylist;
        if (arraylist == null)
        {
            obj = new ArrayList();
        }
        if (obj1 != null)
        {
            ((ArrayList) (obj)).add(obj1);
        }
        jsontoken1 = jsonparser.nextToken();
        arraylist = ((ArrayList) (obj));
          goto _L11
        jsonparser.skipChildren();
        obj = s1;
        l4 = l3;
        obj1 = s;
        vinepost1 = vinepost;
        vineuser1 = vineuser;
        arraylist1 = arraylist;
        vinemilestone1 = vinemilestone;
        l5 = l1;
        flag1 = flag;
        l = l2;
          goto _L8
        if ("user".equals(jsonparser.getCurrentName()))
        {
            vineuser1 = parseUser(jsonparser);
            obj = s1;
            l4 = l3;
            obj1 = s;
            vinepost1 = vinepost;
            arraylist1 = arraylist;
            vinemilestone1 = vinemilestone;
            l5 = l1;
            flag1 = flag;
            l = l2;
        } else
        if ("post".equals(jsonparser.getCurrentName()))
        {
            vinepost1 = parsePost(jsonparser);
            obj = s1;
            l4 = l3;
            obj1 = s;
            vineuser1 = vineuser;
            arraylist1 = arraylist;
            vinemilestone1 = vinemilestone;
            l5 = l1;
            flag1 = flag;
            l = l2;
        } else
        if ("milestone".equals(jsonparser.getCurrentName()))
        {
            vinemilestone1 = parseMilestone(jsonparser);
            obj = s1;
            l4 = l3;
            obj1 = s;
            vinepost1 = vinepost;
            vineuser1 = vineuser;
            arraylist1 = arraylist;
            l5 = l1;
            flag1 = flag;
            l = l2;
        } else
        {
            jsonparser.skipChildren();
            obj = s1;
            l4 = l3;
            obj1 = s;
            vinepost1 = vinepost;
            vineuser1 = vineuser;
            arraylist1 = arraylist;
            vinemilestone1 = vinemilestone;
            l5 = l1;
            flag1 = flag;
            l = l2;
        }
          goto _L8
        jsonparser = new VineEverydayNotification(s1, l3, s, vinepost, vineuser, arraylist, vinemilestone, l1, flag, l2);
        if (arraylist != null)
        {
            Util.validateAndFixEntities(arraylist);
        }
        return jsonparser;
    }

    private static Object parseGeneral(JsonParser jsonparser)
        throws IOException
    {
        JsonToken jsontoken = jsonparser.nextToken();
_L7:
        if (jsontoken == null || jsontoken == JsonToken.END_OBJECT)
        {
            break MISSING_BLOCK_LABEL_122;
        }
        _cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[jsontoken.ordinal()];
        JVM INSTR tableswitch 1 6: default 64
    //                   1 106
    //                   2 114
    //                   3 64
    //                   4 64
    //                   5 72
    //                   6 89;
           goto _L1 _L2 _L3 _L1 _L1 _L4 _L5
_L3:
        break MISSING_BLOCK_LABEL_114;
_L1:
        break; /* Loop/switch isn't completed */
_L4:
        break; /* Loop/switch isn't completed */
_L8:
        jsontoken = jsonparser.nextToken();
        if (true) goto _L7; else goto _L6
_L6:
        if ("success".equals(jsonparser.getCurrentName()))
        {
            return API_RESPONSE.SUCCESS;
        }
          goto _L8
_L5:
        if ("success".equals(jsonparser.getCurrentName()))
        {
            return API_RESPONSE.FAILURE;
        }
_L2:
        jsonparser.skipChildren();
          goto _L8
        jsonparser.skipChildren();
          goto _L8
        return null;
    }

    private static VineLike parseLike(JsonParser jsonparser)
        throws IOException
    {
        JsonToken jsontoken;
        VineLike vinelike;
        int i;
        int j;
        vinelike = new VineLike();
        jsontoken = jsonparser.nextToken();
        i = -1;
        j = 0;
_L7:
        if (jsontoken == null || jsontoken == JsonToken.END_OBJECT)
        {
            break MISSING_BLOCK_LABEL_413;
        }
        _cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[jsontoken.ordinal()];
        JVM INSTR tableswitch 1 4: default 68
    //                   1 90
    //                   2 128
    //                   3 272
    //                   4 143;
           goto _L1 _L2 _L3 _L4 _L5
_L4:
        break MISSING_BLOCK_LABEL_272;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        int k;
        int l;
        l = i;
        k = j;
_L8:
        jsontoken = jsonparser.nextToken();
        j = k;
        i = l;
        if (true) goto _L7; else goto _L6
_L6:
        k = j;
        l = i;
        if ("user".equals(jsonparser.getCurrentName()))
        {
            vinelike.user = parseUser(jsonparser);
            k = j;
            l = i;
        }
          goto _L8
_L3:
        jsonparser.skipChildren();
        k = j;
        l = i;
          goto _L8
_L5:
        String s = jsonparser.getCurrentName();
        if ("created".equals(s))
        {
            vinelike.created = DateTimeUtil.getTimeInMsFromString(jsonparser.getText(), "yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
            k = j;
            l = i;
        } else
        if ("location".equals(s))
        {
            vinelike.location = jsonparser.getText();
            k = j;
            l = i;
        } else
        if ("avatarUrl".equals(s))
        {
            vinelike.avatarUrl = jsonparser.getText();
            k = j;
            l = i;
        } else
        {
            k = j;
            l = i;
            if ("username".equals(s))
            {
                vinelike.username = jsonparser.getText();
                k = j;
                l = i;
            }
        }
          goto _L8
        String s1 = jsonparser.getCurrentName();
        if ("likeId".equals(s1))
        {
            vinelike.likeId = jsonparser.getLongValue();
            k = j;
            l = i;
        } else
        if ("userId".equals(s1))
        {
            vinelike.userId = jsonparser.getLongValue();
            k = j;
            l = i;
        } else
        if ("verified".equals(s1))
        {
            vinelike.verified = jsonparser.getIntValue();
            k = j;
            l = i;
        } else
        if ("following".equals(s1))
        {
            l = jsonparser.getIntValue();
            k = j;
        } else
        {
            k = j;
            l = i;
            if ("blocked".equals(s1))
            {
                k = jsonparser.getIntValue();
                l = i;
            }
        }
          goto _L8
        if (vinelike.user != null)
        {
            vinelike.user.following = i;
            vinelike.user.blocked = j;
        }
        return vinelike;
    }

    private static Long parseLikeId(JsonParser jsonparser)
        throws IOException
    {
        JsonToken jsontoken;
        long l;
        l = 0L;
        jsontoken = jsonparser.nextToken();
_L2:
        if (jsontoken == null || jsontoken == JsonToken.END_OBJECT)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        switch (_cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[jsontoken.ordinal()])
        {
        default:
            break;

        case 1: // '\001'
        case 2: // '\002'
            break MISSING_BLOCK_LABEL_81;

        case 3: // '\003'
            break;
        }
        break; /* Loop/switch isn't completed */
_L3:
        jsontoken = jsonparser.nextToken();
        if (true) goto _L2; else goto _L1
_L1:
        if (!"likeId".equals(jsonparser.getCurrentName()))
        {
            break MISSING_BLOCK_LABEL_81;
        }
        l = jsonparser.getLongValue();
          goto _L3
        jsonparser.skipChildren();
          goto _L3
        return Long.valueOf(l);
    }

    public static VineLogin parseLogin(JsonParser jsonparser)
        throws IOException
    {
        String s;
        String s1;
        String s2;
        JsonToken jsontoken;
        long l;
        boolean flag;
        s2 = null;
        s1 = null;
        s = null;
        l = 0L;
        flag = false;
        jsontoken = jsonparser.nextToken();
_L2:
        String s3;
        String s4;
        String s5;
        long l1;
        boolean flag1;
        if (jsontoken == null || jsontoken == JsonToken.END_OBJECT)
        {
            break MISSING_BLOCK_LABEL_501;
        }
        s3 = s2;
        s4 = s1;
        l1 = l;
        s5 = s;
        flag1 = flag;
        switch (_cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[jsontoken.ordinal()])
        {
        default:
            flag1 = flag;
            s5 = s;
            l1 = l;
            s4 = s1;
            s3 = s2;
            break;

        case 1: // '\001'
            break; /* Loop/switch isn't completed */

        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
            break;

        case 5: // '\005'
        case 6: // '\006'
            break MISSING_BLOCK_LABEL_449;
        }
_L4:
        jsontoken = jsonparser.nextToken();
        s2 = s3;
        s1 = s4;
        l = l1;
        s = s5;
        flag = flag1;
        if (true) goto _L2; else goto _L1
_L1:
        if (!"data".equals(jsonparser.getCurrentName()))
        {
            break MISSING_BLOCK_LABEL_424;
        }
        jsontoken = jsonparser.nextToken();
_L9:
        s3 = s2;
        s4 = s1;
        l1 = l;
        s5 = s;
        flag1 = flag;
        if (jsontoken == null) goto _L4; else goto _L3
_L3:
        s3 = s2;
        s4 = s1;
        l1 = l;
        s5 = s;
        flag1 = flag;
        if (jsontoken == JsonToken.END_OBJECT) goto _L4; else goto _L5
_L5:
        _cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[jsontoken.ordinal()];
        JVM INSTR tableswitch 3 4: default 236
    //                   3 380
    //                   4 271;
           goto _L6 _L7 _L8
_L7:
        break MISSING_BLOCK_LABEL_380;
_L6:
        s5 = s;
        l1 = l;
        s4 = s1;
        s3 = s2;
_L10:
        jsontoken = jsonparser.nextToken();
        s2 = s3;
        s1 = s4;
        l = l1;
        s = s5;
          goto _L9
_L8:
        String s6 = jsonparser.getCurrentName();
        if ("key".equals(s6))
        {
            s3 = jsonparser.getText();
            s4 = s1;
            l1 = l;
            s5 = s;
        } else
        if ("username".equals(s6))
        {
            s4 = jsonparser.getText();
            s3 = s2;
            l1 = l;
            s5 = s;
        } else
        {
            s3 = s2;
            s4 = s1;
            l1 = l;
            s5 = s;
            if ("edition".equals(s6))
            {
                s5 = jsonparser.getText();
                s3 = s2;
                s4 = s1;
                l1 = l;
            }
        }
          goto _L10
        s3 = s2;
        s4 = s1;
        l1 = l;
        s5 = s;
        if ("userId".equals(jsonparser.getCurrentName()))
        {
            l1 = jsonparser.getLongValue();
            s3 = s2;
            s4 = s1;
            s5 = s;
        }
          goto _L10
        jsonparser.skipChildren();
        s3 = s2;
        s4 = s1;
        l1 = l;
        s5 = s;
        flag1 = flag;
          goto _L4
        s3 = s2;
        s4 = s1;
        l1 = l;
        s5 = s;
        flag1 = flag;
        if ("success".equals(jsonparser.getCurrentName()))
        {
            flag1 = jsonparser.getBooleanValue();
            s3 = s2;
            s4 = s1;
            l1 = l;
            s5 = s;
        }
          goto _L4
        if (flag)
        {
            return new VineLogin(s2, s1, l, s);
        } else
        {
            return null;
        }
    }

    private static VineLoopSubmissionResponse parseLoopsSubmission(JsonParser jsonparser)
        throws IOException
    {
        JsonToken jsontoken;
        int i;
        i = 0;
        jsontoken = jsonparser.nextToken();
_L2:
        if (jsontoken == null || jsontoken == JsonToken.END_OBJECT)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        switch (_cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[jsontoken.ordinal()])
        {
        default:
            break;

        case 3: // '\003'
            break; /* Loop/switch isn't completed */

        case 1: // '\001'
        case 2: // '\002'
            break;
        }
        break MISSING_BLOCK_LABEL_81;
_L3:
        jsontoken = jsonparser.nextToken();
        if (true) goto _L2; else goto _L1
_L1:
        if ("nextAfter".equals(jsonparser.getCurrentName()))
        {
            i = jsonparser.getIntValue();
        }
          goto _L3
        jsonparser.skipChildren();
          goto _L3
        return new VineLoopSubmissionResponse(i);
    }

    public static VineError parseMessageError(JsonParser jsonparser)
        throws IOException
    {
        String s;
        Object obj;
        int i;
        i = 0;
        s = null;
        obj = jsonparser.nextToken();
_L7:
        if (obj == null || obj == JsonToken.END_OBJECT)
        {
            break MISSING_BLOCK_LABEL_171;
        }
        _cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[((JsonToken) (obj)).ordinal()];
        JVM INSTR tableswitch 1 4: default 60
    //                   1 82
    //                   2 96
    //                   3 110
    //                   4 140;
           goto _L1 _L2 _L3 _L4 _L5
_L5:
        break MISSING_BLOCK_LABEL_140;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        int j;
        obj = s;
        j = i;
_L8:
        JsonToken jsontoken = jsonparser.nextToken();
        i = j;
        s = ((String) (obj));
        obj = jsontoken;
        if (true) goto _L7; else goto _L6
_L6:
        jsonparser.skipChildren();
        j = i;
        obj = s;
          goto _L8
_L3:
        jsonparser.skipChildren();
        j = i;
        obj = s;
          goto _L8
_L4:
        j = i;
        obj = s;
        if ("code".equals(jsonparser.getCurrentName()))
        {
            j = jsonparser.getIntValue();
            obj = s;
        }
          goto _L8
        j = i;
        obj = s;
        if ("message".equals(jsonparser.getCurrentName()))
        {
            obj = jsonparser.getText();
            j = i;
        }
          goto _L8
        return new VineError(i, s);
    }

    public static VineMilestone parseMilestone(JsonParser jsonparser)
        throws IOException
    {
        float f;
        String s;
        String s1;
        String s2;
        String s3;
        String s4;
        String s5;
        Object obj;
        int i;
        int j;
        s5 = null;
        s4 = null;
        s3 = null;
        s2 = null;
        s1 = null;
        s = null;
        j = 0;
        i = 0;
        f = 0.0F;
        obj = jsonparser.nextToken();
_L2:
        float f1;
        String s6;
        String s7;
        String s8;
        String s9;
        String s10;
        int k;
        if (obj == null || obj == JsonToken.END_OBJECT)
        {
            break MISSING_BLOCK_LABEL_697;
        }
        switch (_cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[((JsonToken) (obj)).ordinal()])
        {
        default:
            f1 = f;
            k = j;
            s10 = s;
            s9 = s1;
            s8 = s2;
            s7 = s3;
            s6 = s4;
            obj = s5;
            break;

        case 3: // '\003'
            break MISSING_BLOCK_LABEL_617;

        case 4: // '\004'
            break; /* Loop/switch isn't completed */
        }
_L3:
        JsonToken jsontoken = jsonparser.nextToken();
        s5 = ((String) (obj));
        s4 = s6;
        s3 = s7;
        s2 = s8;
        s1 = s9;
        s = s10;
        j = k;
        f = f1;
        obj = jsontoken;
        if (true) goto _L2; else goto _L1
_L1:
        if ("backgroundImageUrl".equals(jsonparser.getCurrentName()))
        {
            obj = jsonparser.getText();
            s6 = s4;
            s7 = s3;
            s8 = s2;
            s9 = s1;
            s10 = s;
            k = j;
            f1 = f;
        } else
        if ("backgroundVideoUrl".equals(jsonparser.getCurrentName()))
        {
            s6 = jsonparser.getText();
            obj = s5;
            s7 = s3;
            s8 = s2;
            s9 = s1;
            s10 = s;
            k = j;
            f1 = f;
        } else
        if ("iconUrl".equals(jsonparser.getCurrentName()))
        {
            s7 = jsonparser.getText();
            obj = s5;
            s6 = s4;
            s8 = s2;
            s9 = s1;
            s10 = s;
            k = j;
            f1 = f;
        } else
        if ("title".equals(jsonparser.getCurrentName()))
        {
            s8 = jsonparser.getText();
            obj = s5;
            s6 = s4;
            s7 = s3;
            s9 = s1;
            s10 = s;
            k = j;
            f1 = f;
        } else
        if ("description".equals(jsonparser.getCurrentName()))
        {
            s9 = jsonparser.getText();
            obj = s5;
            s6 = s4;
            s7 = s3;
            s8 = s2;
            s10 = s;
            k = j;
            f1 = f;
        } else
        if ("milestoneUrl".equals(jsonparser.getCurrentName()))
        {
            s10 = jsonparser.getText();
            obj = s5;
            s6 = s4;
            s7 = s3;
            s8 = s2;
            s9 = s1;
            k = j;
            f1 = f;
        } else
        if ("overlayAlpha".equals(jsonparser.getCurrentName()))
        {
            f1 = Float.parseFloat(jsonparser.getText());
            obj = s5;
            s6 = s4;
            s7 = s3;
            s8 = s2;
            s9 = s1;
            s10 = s;
            k = j;
        } else
        if ("overlayColor".equals(jsonparser.getCurrentName()))
        {
            k = Integer.decode(jsonparser.getText()).intValue();
            obj = s5;
            s6 = s4;
            s7 = s3;
            s8 = s2;
            s9 = s1;
            s10 = s;
            f1 = f;
        } else
        {
            obj = s5;
            s6 = s4;
            s7 = s3;
            s8 = s2;
            s9 = s1;
            s10 = s;
            k = j;
            f1 = f;
            if ("gaussianBlurRadius".equals(jsonparser.getCurrentName()))
            {
                i = Integer.parseInt(jsonparser.getText());
                obj = s5;
                s6 = s4;
                s7 = s3;
                s8 = s2;
                s9 = s1;
                s10 = s;
                k = j;
                f1 = f;
            }
        }
          goto _L3
        obj = s5;
        s6 = s4;
        s7 = s3;
        s8 = s2;
        s9 = s1;
        s10 = s;
        k = j;
        f1 = f;
        if ("gaussianBlurRadius".equals(jsonparser.getCurrentName()))
        {
            i = jsonparser.getIntValue();
            obj = s5;
            s6 = s4;
            s7 = s3;
            s8 = s2;
            s9 = s1;
            s10 = s;
            k = j;
            f1 = f;
        }
          goto _L3
        return new VineMilestone(s5, s4, s3, s2, s1, s, j, f, i);
    }

    private static VineSingleNotification parseNotification(JsonParser jsonparser)
        throws IOException
    {
        ArrayList arraylist;
        String s;
        String s1;
        String s2;
        String s3;
        Object obj;
        boolean flag;
        int i;
        long l;
        long l1;
        long l2;
        long l3;
        long l4;
        long l5;
        long l6;
        boolean flag4;
        boolean flag5;
        boolean flag6;
        obj = jsonparser.nextToken();
        s2 = null;
        s3 = null;
        s = null;
        s1 = null;
        l6 = 0L;
        l5 = 0L;
        l4 = 0L;
        l3 = 0L;
        l2 = 0L;
        l1 = 0L;
        l = 0L;
        flag5 = false;
        i = 0;
        flag = false;
        flag6 = false;
        flag4 = false;
        arraylist = null;
_L8:
        if (obj == null || obj == JsonToken.END_OBJECT)
        {
            break MISSING_BLOCK_LABEL_2268;
        }
        _cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[((JsonToken) (obj)).ordinal()];
        JVM INSTR tableswitch 1 6: default 116
    //                   1 2195
    //                   2 1680
    //                   3 666
    //                   4 259
    //                   5 1962
    //                   6 1962;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L6
_L5:
        break; /* Loop/switch isn't completed */
_L2:
        break MISSING_BLOCK_LABEL_2195;
_L1:
        Object obj1;
        String s4;
        String s5;
        ArrayList arraylist1;
        int j;
        boolean flag1;
        long l7;
        long l8;
        long l9;
        long l10;
        long l11;
        long l12;
        long l13;
        boolean flag2;
        boolean flag3;
        boolean flag7;
        flag1 = flag;
        flag3 = flag4;
        flag2 = flag6;
        l13 = l;
        l12 = l1;
        arraylist1 = arraylist;
        l11 = l2;
        j = i;
        flag7 = flag5;
        l10 = l3;
        l9 = l4;
        l8 = l5;
        l7 = l6;
        s5 = s1;
        s4 = s;
        obj1 = s3;
        obj = s2;
_L9:
        JsonToken jsontoken = jsonparser.nextToken();
        s2 = ((String) (obj));
        s3 = ((String) (obj1));
        s = s4;
        s1 = s5;
        l6 = l7;
        l5 = l8;
        l4 = l9;
        l3 = l10;
        flag5 = flag7;
        i = j;
        l2 = l11;
        arraylist = arraylist1;
        l1 = l12;
        l = l13;
        flag6 = flag2;
        flag4 = flag3;
        flag = flag1;
        obj = jsontoken;
        if (true) goto _L8; else goto _L7
_L7:
        String s6 = jsonparser.getCurrentName();
        if ("avatarUrl".equals(s6))
        {
            obj = jsonparser.getText();
            obj1 = s3;
            s4 = s;
            s5 = s1;
            l7 = l6;
            l8 = l5;
            l9 = l4;
            l10 = l3;
            flag7 = flag5;
            j = i;
            l11 = l2;
            arraylist1 = arraylist;
            l12 = l1;
            l13 = l;
            flag2 = flag6;
            flag3 = flag4;
            flag1 = flag;
        } else
        if ("body".equals(s6))
        {
            obj1 = Util.getUsernameFromActivity(jsonparser.getText());
            s5 = jsonparser.getText();
            obj = s2;
            s4 = s;
            l7 = l6;
            l8 = l5;
            l9 = l4;
            l10 = l3;
            flag7 = flag5;
            j = i;
            l11 = l2;
            arraylist1 = arraylist;
            l12 = l1;
            l13 = l;
            flag2 = flag6;
            flag3 = flag4;
            flag1 = flag;
        } else
        if ("thumbnailUrl".equals(s6))
        {
            s4 = jsonparser.getText();
            obj = s2;
            obj1 = s3;
            s5 = s1;
            l7 = l6;
            l8 = l5;
            l9 = l4;
            l10 = l3;
            flag7 = flag5;
            j = i;
            l11 = l2;
            arraylist1 = arraylist;
            l12 = l1;
            l13 = l;
            flag2 = flag6;
            flag3 = flag4;
            flag1 = flag;
        } else
        {
            obj = s2;
            obj1 = s3;
            s4 = s;
            s5 = s1;
            l7 = l6;
            l8 = l5;
            l9 = l4;
            l10 = l3;
            flag7 = flag5;
            j = i;
            l11 = l2;
            arraylist1 = arraylist;
            l12 = l1;
            l13 = l;
            flag2 = flag6;
            flag3 = flag4;
            flag1 = flag;
            if ("created".equals(s6))
            {
                l10 = DateTimeUtil.getTimeInMsFromString(jsonparser.getText(), "yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
                obj = s2;
                obj1 = s3;
                s4 = s;
                s5 = s1;
                l7 = l6;
                l8 = l5;
                l9 = l4;
                flag7 = flag5;
                j = i;
                l11 = l2;
                arraylist1 = arraylist;
                l12 = l1;
                l13 = l;
                flag2 = flag6;
                flag3 = flag4;
                flag1 = flag;
            }
        }
          goto _L9
_L4:
        String s7 = jsonparser.getCurrentName();
        if ("notificationTypeId".equals(s7))
        {
            j = jsonparser.getIntValue();
            obj = s2;
            obj1 = s3;
            s4 = s;
            s5 = s1;
            l7 = l6;
            l8 = l5;
            l9 = l4;
            l10 = l3;
            flag7 = flag5;
            l11 = l2;
            arraylist1 = arraylist;
            l12 = l1;
            l13 = l;
            flag2 = flag6;
            flag3 = flag4;
            flag1 = flag;
        } else
        if ("notificationId".equals(s7))
        {
            l7 = jsonparser.getLongValue();
            obj = s2;
            obj1 = s3;
            s4 = s;
            s5 = s1;
            l8 = l5;
            l9 = l4;
            l10 = l3;
            flag7 = flag5;
            j = i;
            l11 = l2;
            arraylist1 = arraylist;
            l12 = l1;
            l13 = l;
            flag2 = flag6;
            flag3 = flag4;
            flag1 = flag;
        } else
        if ("userId".equals(s7))
        {
            l8 = jsonparser.getLongValue();
            obj = s2;
            obj1 = s3;
            s4 = s;
            s5 = s1;
            l7 = l6;
            l9 = l4;
            l10 = l3;
            flag7 = flag5;
            j = i;
            l11 = l2;
            arraylist1 = arraylist;
            l12 = l1;
            l13 = l;
            flag2 = flag6;
            flag3 = flag4;
            flag1 = flag;
        } else
        if ("postId".equals(s7))
        {
            l9 = jsonparser.getLongValue();
            obj = s2;
            obj1 = s3;
            s4 = s;
            s5 = s1;
            l7 = l6;
            l8 = l5;
            l10 = l3;
            flag7 = flag5;
            j = i;
            l11 = l2;
            arraylist1 = arraylist;
            l12 = l1;
            l13 = l;
            flag2 = flag6;
            flag3 = flag4;
            flag1 = flag;
        } else
        if ("verified".equals(s7))
        {
            if (jsonparser.getIntValue() == 1)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            obj = s2;
            obj1 = s3;
            s4 = s;
            s5 = s1;
            l7 = l6;
            l8 = l5;
            l9 = l4;
            l10 = l3;
            flag7 = flag2;
            j = i;
            l11 = l2;
            arraylist1 = arraylist;
            l12 = l1;
            l13 = l;
            flag2 = flag6;
            flag3 = flag4;
            flag1 = flag;
        } else
        if ("private".equals(s7))
        {
            if (jsonparser.getIntValue() == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            obj = s2;
            obj1 = s3;
            s4 = s;
            s5 = s1;
            l7 = l6;
            l8 = l5;
            l9 = l4;
            l10 = l3;
            flag7 = flag5;
            j = i;
            l11 = l2;
            arraylist1 = arraylist;
            l12 = l1;
            l13 = l;
            flag2 = flag6;
            flag3 = flag4;
            flag1 = flag;
        } else
        if ("followRequested".equals(s7))
        {
            if (jsonparser.getIntValue() == 1)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            obj = s2;
            obj1 = s3;
            s4 = s;
            s5 = s1;
            l7 = l6;
            l8 = l5;
            l9 = l4;
            l10 = l3;
            flag7 = flag5;
            j = i;
            l11 = l2;
            arraylist1 = arraylist;
            l12 = l1;
            l13 = l;
            flag3 = flag4;
            flag1 = flag;
        } else
        if ("following".equals(s7))
        {
            if (jsonparser.getIntValue() == 1)
            {
                flag3 = true;
            } else
            {
                flag3 = false;
            }
            obj = s2;
            obj1 = s3;
            s4 = s;
            s5 = s1;
            l7 = l6;
            l8 = l5;
            l9 = l4;
            l10 = l3;
            flag7 = flag5;
            j = i;
            l11 = l2;
            arraylist1 = arraylist;
            l12 = l1;
            l13 = l;
            flag2 = flag6;
            flag1 = flag;
        } else
        if ("conversationId".equals(s7))
        {
            l11 = jsonparser.getLongValue();
            obj = s2;
            obj1 = s3;
            s4 = s;
            s5 = s1;
            l7 = l6;
            l8 = l5;
            l9 = l4;
            l10 = l3;
            flag7 = flag5;
            j = i;
            arraylist1 = arraylist;
            l12 = l1;
            l13 = l;
            flag2 = flag6;
            flag3 = flag4;
            flag1 = flag;
        } else
        if ("unreadMessageCount".equals(s7))
        {
            l12 = jsonparser.getLongValue();
            obj = s2;
            obj1 = s3;
            s4 = s;
            s5 = s1;
            l7 = l6;
            l8 = l5;
            l9 = l4;
            l10 = l3;
            flag7 = flag5;
            j = i;
            l11 = l2;
            arraylist1 = arraylist;
            l13 = l;
            flag2 = flag6;
            flag3 = flag4;
            flag1 = flag;
        } else
        {
            obj = s2;
            obj1 = s3;
            s4 = s;
            s5 = s1;
            l7 = l6;
            l8 = l5;
            l9 = l4;
            l10 = l3;
            flag7 = flag5;
            j = i;
            l11 = l2;
            arraylist1 = arraylist;
            l12 = l1;
            l13 = l;
            flag2 = flag6;
            flag3 = flag4;
            flag1 = flag;
            if ("recipientUserId".equals(s7))
            {
                l13 = jsonparser.getLongValue();
                obj = s2;
                obj1 = s3;
                s4 = s;
                s5 = s1;
                l7 = l6;
                l8 = l5;
                l9 = l4;
                l10 = l3;
                flag7 = flag5;
                j = i;
                l11 = l2;
                arraylist1 = arraylist;
                l12 = l1;
                flag2 = flag6;
                flag3 = flag4;
                flag1 = flag;
            }
        }
          goto _L9
_L3:
        JsonToken jsontoken1;
        if (!"entities".equals(jsonparser.getCurrentName()))
        {
            break MISSING_BLOCK_LABEL_1889;
        }
        jsontoken1 = jsonparser.nextToken();
_L12:
        obj = s2;
        obj1 = s3;
        s4 = s;
        s5 = s1;
        l7 = l6;
        l8 = l5;
        l9 = l4;
        l10 = l3;
        flag7 = flag5;
        j = i;
        l11 = l2;
        arraylist1 = arraylist;
        l12 = l1;
        l13 = l;
        flag2 = flag6;
        flag3 = flag4;
        flag1 = flag;
        if (jsontoken1 == null) goto _L9; else goto _L10
_L10:
        obj = s2;
        obj1 = s3;
        s4 = s;
        s5 = s1;
        l7 = l6;
        l8 = l5;
        l9 = l4;
        l10 = l3;
        flag7 = flag5;
        j = i;
        l11 = l2;
        arraylist1 = arraylist;
        l12 = l1;
        l13 = l;
        flag2 = flag6;
        flag3 = flag4;
        flag1 = flag;
        if (jsontoken1 == JsonToken.END_ARRAY) goto _L9; else goto _L11
_L11:
        obj1 = parseEntity(jsonparser);
        obj = arraylist;
        if (arraylist == null)
        {
            obj = new ArrayList();
        }
        if (obj1 != null)
        {
            ((ArrayList) (obj)).add(obj1);
        }
        jsontoken1 = jsonparser.nextToken();
        arraylist = ((ArrayList) (obj));
          goto _L12
        jsonparser.skipChildren();
        obj = s2;
        obj1 = s3;
        s4 = s;
        s5 = s1;
        l7 = l6;
        l8 = l5;
        l9 = l4;
        l10 = l3;
        flag7 = flag5;
        j = i;
        l11 = l2;
        arraylist1 = arraylist;
        l12 = l1;
        l13 = l;
        flag2 = flag6;
        flag3 = flag4;
        flag1 = flag;
          goto _L9
_L6:
        String s8 = jsonparser.getCurrentName();
        if ("followRequested".equals(s8))
        {
            flag2 = jsonparser.getBooleanValue();
            obj = s2;
            obj1 = s3;
            s4 = s;
            s5 = s1;
            l7 = l6;
            l8 = l5;
            l9 = l4;
            l10 = l3;
            flag7 = flag5;
            j = i;
            l11 = l2;
            arraylist1 = arraylist;
            l12 = l1;
            l13 = l;
            flag3 = flag4;
            flag1 = flag;
        } else
        {
            obj = s2;
            obj1 = s3;
            s4 = s;
            s5 = s1;
            l7 = l6;
            l8 = l5;
            l9 = l4;
            l10 = l3;
            flag7 = flag5;
            j = i;
            l11 = l2;
            arraylist1 = arraylist;
            l12 = l1;
            l13 = l;
            flag2 = flag6;
            flag3 = flag4;
            flag1 = flag;
            if ("following".equals(s8))
            {
                flag3 = jsonparser.getBooleanValue();
                obj = s2;
                obj1 = s3;
                s4 = s;
                s5 = s1;
                l7 = l6;
                l8 = l5;
                l9 = l4;
                l10 = l3;
                flag7 = flag5;
                j = i;
                l11 = l2;
                arraylist1 = arraylist;
                l12 = l1;
                l13 = l;
                flag2 = flag6;
                flag1 = flag;
            }
        }
          goto _L9
        jsonparser.skipChildren();
        obj = s2;
        obj1 = s3;
        s4 = s;
        s5 = s1;
        l7 = l6;
        l8 = l5;
        l9 = l4;
        l10 = l3;
        flag7 = flag5;
        j = i;
        l11 = l2;
        arraylist1 = arraylist;
        l12 = l1;
        l13 = l;
        flag2 = flag6;
        flag3 = flag4;
        flag1 = flag;
          goto _L9
        jsonparser = new VineSingleNotification(s2, s3, s, s1, l6, l5, l4, l3, flag5, i, l2, arraylist, l1, l);
        if (arraylist != null)
        {
            Util.validateAndFixEntities(arraylist);
        }
        if (flag4)
        {
            jsonparser.setFollowing();
        }
        if (flag6)
        {
            jsonparser.setFollowRequested();
        }
        if (flag)
        {
            jsonparser.setPrivate();
        }
        return jsonparser;
    }

    private static VineNotificationSetting parseNotificationSetting(JsonParser jsonparser)
        throws IOException
    {
        Object obj;
        String s1;
        String s2;
        String s3;
        String s4;
        ArrayList arraylist;
        boolean flag;
        obj = jsonparser.nextToken();
        flag = false;
        s4 = null;
        s3 = null;
        s2 = null;
        s1 = null;
        arraylist = new ArrayList();
_L7:
        if (obj == null || obj == JsonToken.END_OBJECT)
        {
            break MISSING_BLOCK_LABEL_603;
        }
        _cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[((JsonToken) (obj)).ordinal()];
        JVM INSTR tableswitch 1 4: default 76
    //                   1 346
    //                   2 371
    //                   3 279
    //                   4 122;
           goto _L1 _L2 _L3 _L4 _L5
_L5:
        break; /* Loop/switch isn't completed */
_L1:
        String s;
        Object obj1;
        String s5;
        boolean flag1;
        s5 = s1;
        obj1 = s2;
        s = s3;
        obj = s4;
        flag1 = flag;
_L8:
        JsonToken jsontoken = jsonparser.nextToken();
        flag = flag1;
        s4 = ((String) (obj));
        s3 = s;
        s2 = ((String) (obj1));
        s1 = s5;
        obj = jsontoken;
        if (true) goto _L7; else goto _L6
_L6:
        if ("title".equals(jsonparser.getCurrentName()))
        {
            s = jsonparser.getText();
            flag1 = flag;
            obj = s4;
            obj1 = s2;
            s5 = s1;
        } else
        if ("section".equals(jsonparser.getCurrentName()))
        {
            obj1 = jsonparser.getText();
            flag1 = flag;
            obj = s4;
            s = s3;
            s5 = s1;
        } else
        if ("value".equals(jsonparser.getCurrentName()))
        {
            s5 = jsonparser.getText();
            flag1 = flag;
            obj = s4;
            s = s3;
            obj1 = s2;
        } else
        {
            flag1 = flag;
            obj = s4;
            s = s3;
            obj1 = s2;
            s5 = s1;
            if ("name".equals(jsonparser.getCurrentName()))
            {
                obj = jsonparser.getText();
                flag1 = flag;
                s = s3;
                obj1 = s2;
                s5 = s1;
            }
        }
          goto _L8
_L4:
        flag1 = flag;
        obj = s4;
        s = s3;
        obj1 = s2;
        s5 = s1;
        if ("boolean".equals(jsonparser.getCurrentName()))
        {
            if (jsonparser.getIntValue() == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            obj = s4;
            s = s3;
            obj1 = s2;
            s5 = s1;
        }
          goto _L8
_L2:
        jsonparser.skipChildren();
        flag1 = flag;
        obj = s4;
        s = s3;
        obj1 = s2;
        s5 = s1;
          goto _L8
_L3:
        JsonToken jsontoken1;
        if (!"choices".equals(jsonparser.getCurrentName()))
        {
            break MISSING_BLOCK_LABEL_578;
        }
        jsontoken1 = jsonparser.nextToken();
_L11:
        flag1 = flag;
        obj = s4;
        s = s3;
        obj1 = s2;
        s5 = s1;
        if (jsontoken1 == null) goto _L8; else goto _L9
_L9:
        flag1 = flag;
        obj = s4;
        s = s3;
        obj1 = s2;
        s5 = s1;
        if (jsontoken1 == JsonToken.END_ARRAY) goto _L8; else goto _L10
_L10:
        s = null;
        obj = null;
        if (jsontoken1 == JsonToken.START_OBJECT)
        {
            obj1 = jsonparser.nextToken();
            while (obj1 != null && obj1 != JsonToken.END_OBJECT) 
            {
                if ("title".equals(jsonparser.getCurrentName()))
                {
                    obj1 = jsonparser.getText();
                } else
                {
                    obj1 = s;
                    if ("value".equals(jsonparser.getCurrentName()))
                    {
                        obj = jsonparser.getText();
                        obj1 = s;
                    }
                }
                jsontoken1 = jsonparser.nextToken();
                s = ((String) (obj1));
                obj1 = jsontoken1;
            }
            obj1 = s;
            if (TextUtils.isEmpty(s))
            {
                obj1 = s;
                if (!TextUtils.isEmpty(((CharSequence) (obj))))
                {
                    obj1 = obj;
                }
            }
            arraylist.add(new Pair(obj1, obj));
        }
        jsontoken1 = jsonparser.nextToken();
          goto _L11
        jsonparser.skipChildren();
        flag1 = flag;
        obj = s4;
        s = s3;
        obj1 = s2;
        s5 = s1;
          goto _L8
        return new VineNotificationSetting(flag, s4, s3, s2, s1, arraylist);
    }

    private static VinePagedData parsePagedConversation(JsonParser jsonparser, RecordParser recordparser)
        throws IOException
    {
        Object obj;
        VinePagedConversation vinepagedconversation;
        int i;
        vinepagedconversation = new VinePagedConversation();
        vinepagedconversation.items = new ArrayList();
        i = 1;
        obj = jsonparser.nextToken();
_L7:
        int j;
        if (obj == null || obj == JsonToken.END_OBJECT)
        {
            break MISSING_BLOCK_LABEL_425;
        }
        j = i;
        _cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[((JsonToken) (obj)).ordinal()];
        JVM INSTR tableswitch 1 4: default 80
    //                   1 96
    //                   2 354
    //                   3 145
    //                   4 108;
           goto _L1 _L2 _L3 _L4 _L5
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        int k = i;
_L8:
        obj = jsonparser.nextToken();
        i = k;
        if (true) goto _L7; else goto _L6
_L6:
        jsonparser.skipChildren();
        k = i;
          goto _L8
_L5:
        j = i;
        if ("inbox".equals(jsonparser.getCurrentName()))
        {
            j = i;
            if ("other".equals(jsonparser.getValueAsString()))
            {
                j = 2;
            }
        }
_L4:
        obj = jsonparser.getCurrentName();
        if ("count".equals(obj))
        {
            vinepagedconversation.count = jsonparser.getIntValue();
            k = j;
        } else
        if ("nextPage".equals(obj))
        {
            vinepagedconversation.nextPage = jsonparser.getIntValue();
            k = j;
        } else
        if ("previousPage".equals(obj))
        {
            vinepagedconversation.previousPage = jsonparser.getIntValue();
            k = j;
        } else
        if ("size".equals(obj))
        {
            vinepagedconversation.size = jsonparser.getIntValue();
            k = j;
        } else
        if ("anchor".equals(obj))
        {
            vinepagedconversation.anchor = jsonparser.getLongValue();
            k = j;
        } else
        if ("unreadMessageCount".equals(obj))
        {
            vinepagedconversation.unreadMessageCount = jsonparser.getLongValue();
            k = j;
        } else
        if ("lastMessageRead".equals(obj))
        {
            vinepagedconversation.lastMessageRead = jsonparser.getLongValue();
            k = j;
        } else
        {
            k = j;
            if ("lastMessage".equals(obj))
            {
                vinepagedconversation.lastMessage = jsonparser.getLongValue();
                k = j;
            }
        }
          goto _L8
_L3:
        k = i;
        if (!"records".equals(jsonparser.getCurrentName())) goto _L8; else goto _L9
_L9:
        obj = jsonparser.nextToken();
_L12:
        k = i;
        if (obj == null) goto _L8; else goto _L10
_L10:
        k = i;
        if (obj == JsonToken.END_ARRAY) goto _L8; else goto _L11
_L11:
        obj = (VinePrivateMessage)recordparser.parse(jsonparser, null);
        if (obj != null)
        {
            vinepagedconversation.items.add(obj);
        }
        obj = jsonparser.nextToken();
          goto _L12
        vinepagedconversation.networkType = i;
        return vinepagedconversation;
    }

    private static VinePagedData parsePagedData(JsonParser jsonparser, PagedDataParser pageddataparser)
        throws IOException
    {
        return parsePagedData(jsonparser, pageddataparser, null);
    }

    private static VinePagedData parsePagedData(JsonParser jsonparser, PagedDataParser pageddataparser, Bundle bundle)
        throws IOException
    {
        RecordParser recordparser;
        VinePagedData vinepageddata;
        vinepageddata = new VinePagedData();
        vinepageddata.items = new ArrayList();
        recordparser = null;
        JsonToken jsontoken = null;
        if (pageddataparser instanceof RecordListParser)
        {
            pageddataparser = (RecordListParser)pageddataparser;
        } else
        {
            recordparser = (RecordParser)pageddataparser;
            pageddataparser = jsontoken;
        }
        jsontoken = jsonparser.nextToken();
        if (jsontoken == null || jsontoken == JsonToken.END_OBJECT)
        {
            break MISSING_BLOCK_LABEL_397;
        }
        switch (_cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[jsontoken.ordinal()])
        {
        default:
            break;

        case 1: // '\001'
            break; /* Loop/switch isn't completed */

        case 4: // '\004'
            if ("anchor".equals(jsonparser.getCurrentName()))
            {
                vinepageddata.stringAnchor = jsonparser.getText();
            }
            continue; /* Loop/switch isn't completed */

        case 3: // '\003'
            String s = jsonparser.getCurrentName();
            if ("count".equals(s))
            {
                vinepageddata.count = jsonparser.getIntValue();
            } else
            if ("nextPage".equals(s))
            {
                vinepageddata.nextPage = jsonparser.getIntValue();
            } else
            if ("previousPage".equals(s))
            {
                vinepageddata.previousPage = jsonparser.getIntValue();
            } else
            if ("size".equals(s))
            {
                vinepageddata.size = jsonparser.getIntValue();
            } else
            if ("anchor".equals(s))
            {
                vinepageddata.anchor = jsonparser.getLongValue();
            } else
            if ("title".equals(s))
            {
                vinepageddata.title = jsonparser.getText();
            }
            continue; /* Loop/switch isn't completed */

        case 2: // '\002'
            break;
        }
        break MISSING_BLOCK_LABEL_293;
_L4:
        jsontoken = jsonparser.nextToken();
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_44;
_L1:
        jsonparser.skipChildren();
        continue; /* Loop/switch isn't completed */
        if ("records".equals(jsonparser.getCurrentName()))
        {
            if (pageddataparser != null)
            {
                vinepageddata.items.addAll(pageddataparser.parse(jsonparser, bundle));
            } else
            {
                if (recordparser == null)
                {
                    throw new RuntimeException("Invalid parser.");
                }
                Object obj = jsonparser.nextToken();
                while (obj != null && obj != JsonToken.END_ARRAY) 
                {
                    obj = (Parcelable)recordparser.parse(jsonparser, bundle);
                    if (obj != null)
                    {
                        vinepageddata.items.add(obj);
                    }
                    obj = jsonparser.nextToken();
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        return vinepageddata;
    }

    private static VinePagedData parsePagedInbox(JsonParser jsonparser, RecordParser recordparser, RecordParser recordparser1)
        throws IOException
    {
        JsonToken jsontoken;
        VinePagedInbox vinepagedinbox;
        vinepagedinbox = new VinePagedInbox();
        vinepagedinbox.items = new ArrayList();
        jsontoken = jsonparser.nextToken();
_L6:
        if (jsontoken == null || jsontoken == JsonToken.END_OBJECT)
        {
            break MISSING_BLOCK_LABEL_323;
        }
        _cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[jsontoken.ordinal()];
        JVM INSTR tableswitch 1 3: default 72
    //                   1 80
    //                   2 203
    //                   3 88;
           goto _L1 _L2 _L3 _L4
_L3:
        break MISSING_BLOCK_LABEL_203;
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        break; /* Loop/switch isn't completed */
_L7:
        jsontoken = jsonparser.nextToken();
        if (true) goto _L6; else goto _L5
_L5:
        jsonparser.skipChildren();
          goto _L7
_L4:
        String s = jsonparser.getCurrentName();
        if ("count".equals(s))
        {
            vinepagedinbox.count = jsonparser.getIntValue();
        } else
        if ("nextPage".equals(s))
        {
            vinepagedinbox.nextPage = jsonparser.getIntValue();
        } else
        if ("previousPage".equals(s))
        {
            vinepagedinbox.previousPage = jsonparser.getIntValue();
        } else
        if ("size".equals(s))
        {
            vinepagedinbox.size = jsonparser.getIntValue();
        } else
        if ("anchor".equals(s))
        {
            vinepagedinbox.anchor = jsonparser.getLongValue();
        }
          goto _L7
        if ("records".equals(jsonparser.getCurrentName()))
        {
            for (Object obj = jsonparser.nextToken(); obj != null && obj != JsonToken.END_ARRAY; obj = jsonparser.nextToken())
            {
                obj = (VineConversation)recordparser.parse(jsonparser, null);
                if (obj != null)
                {
                    vinepagedinbox.items.add(obj);
                }
            }

        }
        if ("users".equals(jsonparser.getCurrentName()))
        {
            Object obj1 = jsonparser.nextToken();
            while (obj1 != null && obj1 != JsonToken.END_ARRAY) 
            {
                obj1 = (VineUser)recordparser1.parse(jsonparser, null);
                if (obj1 != null)
                {
                    vinepagedinbox.participants.add(obj1);
                }
                obj1 = jsonparser.nextToken();
            }
        }
          goto _L7
        return vinepagedinbox;
    }

    private static VinePost parsePost(JsonParser jsonparser)
        throws IOException
    {
        double d;
        JsonToken jsontoken;
        String s;
        String s1;
        String s2;
        String s3;
        String s4;
        String s5;
        String s6;
        String s7;
        Object obj;
        VinePost vinepost;
        long l;
        boolean flag;
        boolean flag3;
        boolean flag4;
        boolean flag5;
        boolean flag6;
        boolean flag7;
        boolean flag8;
        boolean flag9;
        vinepost = new VinePost();
        s = null;
        s7 = null;
        s5 = null;
        s6 = null;
        s4 = null;
        s3 = null;
        s2 = null;
        s1 = null;
        jsontoken = null;
        obj = jsonparser.nextToken();
        flag8 = false;
        flag3 = false;
        flag9 = false;
        flag4 = false;
        flag5 = false;
        flag7 = false;
        flag6 = false;
        l = 0L;
        d = 0.0D;
        flag = false;
_L8:
        if (obj == null || obj == JsonToken.END_OBJECT)
        {
            break MISSING_BLOCK_LABEL_5339;
        }
        _cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[((JsonToken) (obj)).ordinal()];
        JVM INSTR tableswitch 1 6: default 132
    //                   1 293
    //                   2 1488
    //                   3 3900
    //                   4 1928
    //                   5 5079
    //                   6 5079;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L6
_L6:
        break MISSING_BLOCK_LABEL_5079;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        double d1;
        Object obj1;
        String s8;
        String s9;
        String s10;
        String s11;
        String s12;
        String s13;
        Object obj2;
        long l1;
        boolean flag1;
        boolean flag2;
        boolean flag10;
        boolean flag11;
        boolean flag12;
        boolean flag13;
        boolean flag14;
        boolean flag15;
        obj2 = jsontoken;
        flag15 = flag3;
        d1 = d;
        flag2 = flag4;
        flag14 = flag5;
        flag13 = flag6;
        flag12 = flag7;
        flag11 = flag;
        l1 = l;
        flag1 = flag9;
        flag10 = flag8;
        s13 = s;
        s12 = s1;
        s11 = s2;
        s10 = s3;
        s9 = s4;
        s8 = s5;
        obj1 = s6;
        obj = s7;
_L9:
        jsontoken = jsonparser.nextToken();
        s7 = ((String) (obj));
        s6 = ((String) (obj1));
        s5 = s8;
        s4 = s9;
        s3 = s10;
        s2 = s11;
        s1 = s12;
        s = s13;
        flag8 = flag10;
        flag9 = flag1;
        l = l1;
        flag = flag11;
        flag7 = flag12;
        flag6 = flag13;
        flag5 = flag14;
        flag4 = flag2;
        obj = jsontoken;
        d = d1;
        flag3 = flag15;
        jsontoken = ((JsonToken) (obj2));
        if (true) goto _L8; else goto _L7
_L7:
        obj = jsonparser.getCurrentName();
        if ("comments".equals(obj))
        {
            vinepost.comments = parsePagedData(jsonparser, COMMENT_PARSER);
            obj = s7;
            obj1 = s6;
            s8 = s5;
            s9 = s4;
            s10 = s3;
            s11 = s2;
            s12 = s1;
            s13 = s;
            flag10 = flag8;
            flag1 = flag9;
            l1 = l;
            flag11 = flag;
            flag12 = flag7;
            flag13 = flag6;
            flag14 = flag5;
            flag2 = flag4;
            d1 = d;
            flag15 = flag3;
            obj2 = jsontoken;
        } else
        {
label0:
            {
                if (!"likes".equals(obj))
                {
                    break label0;
                }
                vinepost.likes = parsePagedData(jsonparser, LIKES_PARSER);
                obj = s7;
                obj1 = s6;
                s8 = s5;
                s9 = s4;
                s10 = s3;
                s11 = s2;
                s12 = s1;
                s13 = s;
                flag10 = flag8;
                flag1 = flag9;
                l1 = l;
                flag11 = flag;
                flag12 = flag7;
                flag13 = flag6;
                flag14 = flag5;
                flag2 = flag4;
                d1 = d;
                flag15 = flag3;
                obj2 = jsontoken;
            }
        }
          goto _L9
        JsonToken jsontoken1;
        if (!"loops".equals(obj))
        {
            break MISSING_BLOCK_LABEL_942;
        }
        jsontoken1 = jsonparser.nextToken();
_L18:
        obj = s7;
        obj1 = s6;
        s8 = s5;
        s9 = s4;
        s10 = s3;
        s11 = s2;
        s12 = s1;
        s13 = s;
        flag10 = flag8;
        flag1 = flag9;
        l1 = l;
        flag11 = flag;
        flag12 = flag7;
        flag13 = flag6;
        flag14 = flag5;
        flag2 = flag4;
        d1 = d;
        flag15 = flag3;
        obj2 = jsontoken;
        if (jsontoken1 == null) goto _L9; else goto _L10
_L10:
        obj = s7;
        obj1 = s6;
        s8 = s5;
        s9 = s4;
        s10 = s3;
        s11 = s2;
        s12 = s1;
        s13 = s;
        flag10 = flag8;
        flag1 = flag9;
        l1 = l;
        flag11 = flag;
        flag12 = flag7;
        flag13 = flag6;
        flag14 = flag5;
        flag2 = flag4;
        d1 = d;
        flag15 = flag3;
        obj2 = jsontoken;
        if (jsontoken1 == JsonToken.END_OBJECT) goto _L9; else goto _L11
_L11:
        l1 = l;
        flag1 = flag;
        d1 = d;
        _cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[jsontoken1.ordinal()];
        JVM INSTR tableswitch 1 7: default 740
    //                   1 769
    //                   2 769
    //                   3 855
    //                   4 750
    //                   5 904
    //                   6 904
    //                   7 787;
           goto _L12 _L13 _L13 _L14 _L15 _L16 _L16 _L17
_L16:
        break MISSING_BLOCK_LABEL_904;
_L15:
        break; /* Loop/switch isn't completed */
_L12:
        d1 = d;
        flag1 = flag;
        l1 = l;
_L19:
        jsontoken1 = jsonparser.nextToken();
        l = l1;
        flag = flag1;
        d = d1;
          goto _L18
_L13:
        jsonparser.skipChildren();
        l1 = l;
        flag1 = flag;
        d1 = d;
          goto _L19
_L17:
        if ("count".equals(jsonparser.getCurrentName()))
        {
            l1 = (long)jsonparser.getDoubleValue();
            flag1 = flag;
            d1 = d;
        } else
        {
            l1 = l;
            flag1 = flag;
            d1 = d;
            if ("velocity".equals(jsonparser.getCurrentName()))
            {
                d1 = jsonparser.getDoubleValue();
                l1 = l;
                flag1 = flag;
            }
        }
          goto _L19
_L14:
        l1 = l;
        flag1 = flag;
        d1 = d;
        if ("onFire".equals(jsonparser.getCurrentName()))
        {
            if (jsonparser.getIntValue() == 1)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            l1 = l;
            d1 = d;
        }
          goto _L19
        l1 = l;
        flag1 = flag;
        d1 = d;
        if ("onFire".equals(jsonparser.getCurrentName()))
        {
            flag1 = jsonparser.getBooleanValue();
            l1 = l;
            d1 = d;
        }
          goto _L19
        if ("user".equals(obj))
        {
            vinepost.user = parseUser(jsonparser);
            vinepost.userBackgroundColor = vinepost.user.profileBackground;
            obj = s7;
            obj1 = s6;
            s8 = s5;
            s9 = s4;
            s10 = s3;
            s11 = s2;
            s12 = s1;
            s13 = s;
            flag10 = flag8;
            flag1 = flag9;
            l1 = l;
            flag11 = flag;
            flag12 = flag7;
            flag13 = flag6;
            flag14 = flag5;
            flag2 = flag4;
            d1 = d;
            flag15 = flag3;
            obj2 = jsontoken;
        } else
        {
label1:
            {
                if (!"repost".equals(obj))
                {
                    break label1;
                }
                vinepost.repost = parseRepost(jsonparser);
                obj = s7;
                obj1 = s6;
                s8 = s5;
                s9 = s4;
                s10 = s3;
                s11 = s2;
                s12 = s1;
                s13 = s;
                flag10 = flag8;
                flag1 = flag9;
                l1 = l;
                flag11 = flag;
                flag12 = flag7;
                flag13 = flag6;
                flag14 = flag5;
                flag2 = flag4;
                d1 = d;
                flag15 = flag3;
                obj2 = jsontoken;
            }
        }
          goto _L9
        if (!"reposts".equals(obj))
        {
            break MISSING_BLOCK_LABEL_1406;
        }
        jsontoken1 = jsonparser.nextToken();
_L25:
        obj = s7;
        obj1 = s6;
        s8 = s5;
        s9 = s4;
        s10 = s3;
        s11 = s2;
        s12 = s1;
        s13 = s;
        flag10 = flag8;
        flag1 = flag9;
        l1 = l;
        flag11 = flag;
        flag12 = flag7;
        flag13 = flag6;
        flag14 = flag5;
        flag2 = flag4;
        d1 = d;
        flag15 = flag3;
        obj2 = jsontoken;
        if (jsontoken1 == null) goto _L9; else goto _L20
_L20:
        obj = s7;
        obj1 = s6;
        s8 = s5;
        s9 = s4;
        s10 = s3;
        s11 = s2;
        s12 = s1;
        s13 = s;
        flag10 = flag8;
        flag1 = flag9;
        l1 = l;
        flag11 = flag;
        flag12 = flag7;
        flag13 = flag6;
        flag14 = flag5;
        flag2 = flag4;
        d1 = d;
        flag15 = flag3;
        obj2 = jsontoken;
        if (jsontoken1 == JsonToken.END_OBJECT) goto _L9; else goto _L21
_L21:
        _cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[jsontoken1.ordinal()];
        JVM INSTR tableswitch 1 3: default 1364
    //                   1 1373
    //                   2 1373
    //                   3 1381;
           goto _L22 _L23 _L23 _L24
_L22:
        break; /* Loop/switch isn't completed */
_L24:
        break MISSING_BLOCK_LABEL_1381;
_L26:
        jsontoken1 = jsonparser.nextToken();
          goto _L25
_L23:
        jsonparser.skipChildren();
          goto _L26
        if ("count".equals(jsonparser.getCurrentName()))
        {
            vinepost.revinersCount = jsonparser.getIntValue();
        }
          goto _L26
        jsonparser.skipChildren();
        obj = s7;
        obj1 = s6;
        s8 = s5;
        s9 = s4;
        s10 = s3;
        s11 = s2;
        s12 = s1;
        s13 = s;
        flag10 = flag8;
        flag1 = flag9;
        l1 = l;
        flag11 = flag;
        flag12 = flag7;
        flag13 = flag6;
        flag14 = flag5;
        flag2 = flag4;
        d1 = d;
        flag15 = flag3;
        obj2 = jsontoken;
          goto _L9
_L3:
        obj = jsonparser.getCurrentName();
        if ("tags".equals(obj))
        {
            vinepost.tags = parseTags(jsonparser);
            obj = s7;
            obj1 = s6;
            s8 = s5;
            s9 = s4;
            s10 = s3;
            s11 = s2;
            s12 = s1;
            s13 = s;
            flag10 = flag8;
            flag1 = flag9;
            l1 = l;
            flag11 = flag;
            flag12 = flag7;
            flag13 = flag6;
            flag14 = flag5;
            flag2 = flag4;
            d1 = d;
            flag15 = flag3;
            obj2 = jsontoken;
        } else
        if ("entities".equals(obj))
        {
            obj = jsonparser.nextToken();
            ArrayList arraylist = null;
            for (; obj != null && obj != JsonToken.END_ARRAY; obj = obj1)
            {
                obj1 = parseEntity(jsonparser);
                obj = arraylist;
                if (arraylist == null)
                {
                    obj = new ArrayList();
                }
                if (obj1 != null)
                {
                    ((ArrayList) (obj)).add(obj1);
                }
                obj1 = jsonparser.nextToken();
                arraylist = ((ArrayList) (obj));
            }

            obj = s7;
            obj1 = s6;
            s8 = s5;
            s9 = s4;
            s10 = s3;
            s11 = s2;
            s12 = s1;
            s13 = s;
            flag10 = flag8;
            flag1 = flag9;
            l1 = l;
            flag11 = flag;
            flag12 = flag7;
            flag13 = flag6;
            flag14 = flag5;
            flag2 = flag4;
            d1 = d;
            flag15 = flag3;
            obj2 = jsontoken;
            if (arraylist != null)
            {
                Util.validateAndFixEntities(arraylist);
                vinepost.entities = arraylist;
                obj = s7;
                obj1 = s6;
                s8 = s5;
                s9 = s4;
                s10 = s3;
                s11 = s2;
                s12 = s1;
                s13 = s;
                flag10 = flag8;
                flag1 = flag9;
                l1 = l;
                flag11 = flag;
                flag12 = flag7;
                flag13 = flag6;
                flag14 = flag5;
                flag2 = flag4;
                d1 = d;
                flag15 = flag3;
                obj2 = jsontoken;
            }
        } else
        {
            jsonparser.skipChildren();
            obj = s7;
            obj1 = s6;
            s8 = s5;
            s9 = s4;
            s10 = s3;
            s11 = s2;
            s12 = s1;
            s13 = s;
            flag10 = flag8;
            flag1 = flag9;
            l1 = l;
            flag11 = flag;
            flag12 = flag7;
            flag13 = flag6;
            flag14 = flag5;
            flag2 = flag4;
            d1 = d;
            flag15 = flag3;
            obj2 = jsontoken;
        }
          goto _L9
_L5:
        String s14 = jsonparser.getCurrentName();
        if ("foursquareVenueId".equals(s14))
        {
            vinepost.foursquareVenueId = jsonparser.getText();
            obj = s7;
            obj1 = s6;
            s8 = s5;
            s9 = s4;
            s10 = s3;
            s11 = s2;
            s12 = s1;
            s13 = s;
            flag10 = flag8;
            flag1 = flag9;
            l1 = l;
            flag11 = flag;
            flag12 = flag7;
            flag13 = flag6;
            flag14 = flag5;
            flag2 = flag4;
            d1 = d;
            flag15 = flag3;
            obj2 = jsontoken;
        } else
        if ("description".equals(s14))
        {
            vinepost.description = jsonparser.getText();
            obj = s7;
            obj1 = s6;
            s8 = s5;
            s9 = s4;
            s10 = s3;
            s11 = s2;
            s12 = s1;
            s13 = s;
            flag10 = flag8;
            flag1 = flag9;
            l1 = l;
            flag11 = flag;
            flag12 = flag7;
            flag13 = flag6;
            flag14 = flag5;
            flag2 = flag4;
            d1 = d;
            flag15 = flag3;
            obj2 = jsontoken;
        } else
        if ("created".equals(s14))
        {
            vinepost.created = DateTimeUtil.getTimeInMsFromString(jsonparser.getText(), "yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
            obj = s7;
            obj1 = s6;
            s8 = s5;
            s9 = s4;
            s10 = s3;
            s11 = s2;
            s12 = s1;
            s13 = s;
            flag10 = flag8;
            flag1 = flag9;
            l1 = l;
            flag11 = flag;
            flag12 = flag7;
            flag13 = flag6;
            flag14 = flag5;
            flag2 = flag4;
            d1 = d;
            flag15 = flag3;
            obj2 = jsontoken;
        } else
        if ("location".equals(s14))
        {
            vinepost.location = jsonparser.getText();
            obj = s7;
            obj1 = s6;
            s8 = s5;
            s9 = s4;
            s10 = s3;
            s11 = s2;
            s12 = s1;
            s13 = s;
            flag10 = flag8;
            flag1 = flag9;
            l1 = l;
            flag11 = flag;
            flag12 = flag7;
            flag13 = flag6;
            flag14 = flag5;
            flag2 = flag4;
            d1 = d;
            flag15 = flag3;
            obj2 = jsontoken;
        } else
        if ("avatarUrl".equals(s14))
        {
            vinepost.avatarUrl = jsonparser.getText();
            obj = s7;
            obj1 = s6;
            s8 = s5;
            s9 = s4;
            s10 = s3;
            s11 = s2;
            s12 = s1;
            s13 = s;
            flag10 = flag8;
            flag1 = flag9;
            l1 = l;
            flag11 = flag;
            flag12 = flag7;
            flag13 = flag6;
            flag14 = flag5;
            flag2 = flag4;
            d1 = d;
            flag15 = flag3;
            obj2 = jsontoken;
        } else
        if ("videoLowURL".equals(s14))
        {
            vinepost.videoLowURL = jsonparser.getText();
            obj = s7;
            obj1 = s6;
            s8 = s5;
            s9 = s4;
            s10 = s3;
            s11 = s2;
            s12 = s1;
            s13 = s;
            flag10 = flag8;
            flag1 = flag9;
            l1 = l;
            flag11 = flag;
            flag12 = flag7;
            flag13 = flag6;
            flag14 = flag5;
            flag2 = flag4;
            d1 = d;
            flag15 = flag3;
            obj2 = jsontoken;
        } else
        if ("videoUrl".equals(s14))
        {
            vinepost.videoUrl = jsonparser.getText();
            obj = s7;
            obj1 = s6;
            s8 = s5;
            s9 = s4;
            s10 = s3;
            s11 = s2;
            s12 = s1;
            s13 = s;
            flag10 = flag8;
            flag1 = flag9;
            l1 = l;
            flag11 = flag;
            flag12 = flag7;
            flag13 = flag6;
            flag14 = flag5;
            flag2 = flag4;
            d1 = d;
            flag15 = flag3;
            obj2 = jsontoken;
        } else
        if ("videoWebmUrl".equals(s14))
        {
            obj2 = jsonparser.getText();
            obj = s7;
            obj1 = s6;
            s8 = s5;
            s9 = s4;
            s10 = s3;
            s11 = s2;
            s12 = s1;
            s13 = s;
            flag10 = flag8;
            flag1 = flag9;
            l1 = l;
            flag11 = flag;
            flag12 = flag7;
            flag13 = flag6;
            flag14 = flag5;
            flag2 = flag4;
            d1 = d;
            flag15 = flag3;
        } else
        if ("username".equals(s14))
        {
            vinepost.username = jsonparser.getText();
            obj = s7;
            obj1 = s6;
            s8 = s5;
            s9 = s4;
            s10 = s3;
            s11 = s2;
            s12 = s1;
            s13 = s;
            flag10 = flag8;
            flag1 = flag9;
            l1 = l;
            flag11 = flag;
            flag12 = flag7;
            flag13 = flag6;
            flag14 = flag5;
            flag2 = flag4;
            d1 = d;
            flag15 = flag3;
            obj2 = jsontoken;
        } else
        if ("shareUrl".equals(s14))
        {
            vinepost.shareUrl = jsonparser.getText();
            obj = s7;
            obj1 = s6;
            s8 = s5;
            s9 = s4;
            s10 = s3;
            s11 = s2;
            s12 = s1;
            s13 = s;
            flag10 = flag8;
            flag1 = flag9;
            l1 = l;
            flag11 = flag;
            flag12 = flag7;
            flag13 = flag6;
            flag14 = flag5;
            flag2 = flag4;
            d1 = d;
            flag15 = flag3;
            obj2 = jsontoken;
        } else
        if ("thumbnailUrl".equals(s14))
        {
            vinepost.thumbnailUrl = jsonparser.getText();
            obj = s7;
            obj1 = s6;
            s8 = s5;
            s9 = s4;
            s10 = s3;
            s11 = s2;
            s12 = s1;
            s13 = s;
            flag10 = flag8;
            flag1 = flag9;
            l1 = l;
            flag11 = flag;
            flag12 = flag7;
            flag13 = flag6;
            flag14 = flag5;
            flag2 = flag4;
            d1 = d;
            flag15 = flag3;
            obj2 = jsontoken;
        } else
        if ("venueAddress".equals(s14))
        {
            s13 = jsonparser.getText();
            obj = s7;
            obj1 = s6;
            s8 = s5;
            s9 = s4;
            s10 = s3;
            s11 = s2;
            s12 = s1;
            flag10 = flag8;
            flag1 = flag9;
            l1 = l;
            flag11 = flag;
            flag12 = flag7;
            flag13 = flag6;
            flag14 = flag5;
            flag2 = flag4;
            d1 = d;
            flag15 = flag3;
            obj2 = jsontoken;
        } else
        if ("venueCategoryIconUrl".equals(s14))
        {
            obj = jsonparser.getText();
            obj1 = s6;
            s8 = s5;
            s9 = s4;
            s10 = s3;
            s11 = s2;
            s12 = s1;
            s13 = s;
            flag10 = flag8;
            flag1 = flag9;
            l1 = l;
            flag11 = flag;
            flag12 = flag7;
            flag13 = flag6;
            flag14 = flag5;
            flag2 = flag4;
            d1 = d;
            flag15 = flag3;
            obj2 = jsontoken;
        } else
        if ("venueCategoryId".equals(s14))
        {
            s8 = jsonparser.getText();
            obj = s7;
            obj1 = s6;
            s9 = s4;
            s10 = s3;
            s11 = s2;
            s12 = s1;
            s13 = s;
            flag10 = flag8;
            flag1 = flag9;
            l1 = l;
            flag11 = flag;
            flag12 = flag7;
            flag13 = flag6;
            flag14 = flag5;
            flag2 = flag4;
            d1 = d;
            flag15 = flag3;
            obj2 = jsontoken;
        } else
        if ("venueCategoryShortName".equals(s14))
        {
            obj1 = jsonparser.getText();
            obj = s7;
            s8 = s5;
            s9 = s4;
            s10 = s3;
            s11 = s2;
            s12 = s1;
            s13 = s;
            flag10 = flag8;
            flag1 = flag9;
            l1 = l;
            flag11 = flag;
            flag12 = flag7;
            flag13 = flag6;
            flag14 = flag5;
            flag2 = flag4;
            d1 = d;
            flag15 = flag3;
            obj2 = jsontoken;
        } else
        if ("venueCity".equals(s14))
        {
            s9 = jsonparser.getText();
            obj = s7;
            obj1 = s6;
            s8 = s5;
            s10 = s3;
            s11 = s2;
            s12 = s1;
            s13 = s;
            flag10 = flag8;
            flag1 = flag9;
            l1 = l;
            flag11 = flag;
            flag12 = flag7;
            flag13 = flag6;
            flag14 = flag5;
            flag2 = flag4;
            d1 = d;
            flag15 = flag3;
            obj2 = jsontoken;
        } else
        if ("venueCountryCode".equals(s14))
        {
            s10 = jsonparser.getText();
            obj = s7;
            obj1 = s6;
            s8 = s5;
            s9 = s4;
            s11 = s2;
            s12 = s1;
            s13 = s;
            flag10 = flag8;
            flag1 = flag9;
            l1 = l;
            flag11 = flag;
            flag12 = flag7;
            flag13 = flag6;
            flag14 = flag5;
            flag2 = flag4;
            d1 = d;
            flag15 = flag3;
            obj2 = jsontoken;
        } else
        if ("venueName".equals(s14))
        {
            s11 = jsonparser.getText();
            obj = s7;
            obj1 = s6;
            s8 = s5;
            s9 = s4;
            s10 = s3;
            s12 = s1;
            s13 = s;
            flag10 = flag8;
            flag1 = flag9;
            l1 = l;
            flag11 = flag;
            flag12 = flag7;
            flag13 = flag6;
            flag14 = flag5;
            flag2 = flag4;
            d1 = d;
            flag15 = flag3;
            obj2 = jsontoken;
        } else
        if ("state".equals(s14))
        {
            s12 = jsonparser.getText();
            obj = s7;
            obj1 = s6;
            s8 = s5;
            s9 = s4;
            s10 = s3;
            s11 = s2;
            s13 = s;
            flag10 = flag8;
            flag1 = flag9;
            l1 = l;
            flag11 = flag;
            flag12 = flag7;
            flag13 = flag6;
            flag14 = flag5;
            flag2 = flag4;
            d1 = d;
            flag15 = flag3;
            obj2 = jsontoken;
        } else
        {
            obj = s7;
            obj1 = s6;
            s8 = s5;
            s9 = s4;
            s10 = s3;
            s11 = s2;
            s12 = s1;
            s13 = s;
            flag10 = flag8;
            flag1 = flag9;
            l1 = l;
            flag11 = flag;
            flag12 = flag7;
            flag13 = flag6;
            flag14 = flag5;
            flag2 = flag4;
            d1 = d;
            flag15 = flag3;
            obj2 = jsontoken;
            if ("profileBackground".equals(s14))
            {
                vinepost.userBackgroundColor = (int)Long.parseLong(jsonparser.getText().substring(2), 16);
                obj = s7;
                obj1 = s6;
                s8 = s5;
                s9 = s4;
                s10 = s3;
                s11 = s2;
                s12 = s1;
                s13 = s;
                flag10 = flag8;
                flag1 = flag9;
                l1 = l;
                flag11 = flag;
                flag12 = flag7;
                flag13 = flag6;
                flag14 = flag5;
                flag2 = flag4;
                d1 = d;
                flag15 = flag3;
                obj2 = jsontoken;
            }
        }
          goto _L9
_L4:
        String s15 = jsonparser.getCurrentName();
        if ("explicitContent".equals(s15))
        {
            if (jsonparser.getIntValue() == 1)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            obj = s7;
            obj1 = s6;
            s8 = s5;
            s9 = s4;
            s10 = s3;
            s11 = s2;
            s12 = s1;
            s13 = s;
            flag10 = flag1;
            flag1 = flag9;
            l1 = l;
            flag11 = flag;
            flag12 = flag7;
            flag13 = flag6;
            flag14 = flag5;
            flag2 = flag4;
            d1 = d;
            flag15 = flag3;
            obj2 = jsontoken;
        } else
        if ("postFlags".equals(s15))
        {
            vinepost.postFlags = jsonparser.getIntValue();
            obj = s7;
            obj1 = s6;
            s8 = s5;
            s9 = s4;
            s10 = s3;
            s11 = s2;
            s12 = s1;
            s13 = s;
            flag10 = flag8;
            flag1 = flag9;
            l1 = l;
            flag11 = flag;
            flag12 = flag7;
            flag13 = flag6;
            flag14 = flag5;
            flag2 = flag4;
            d1 = d;
            flag15 = flag3;
            obj2 = jsontoken;
        } else
        if ("postVerified".equals(s15))
        {
            if (jsonparser.getIntValue() == 1)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            obj = s7;
            obj1 = s6;
            s8 = s5;
            s9 = s4;
            s10 = s3;
            s11 = s2;
            s12 = s1;
            s13 = s;
            flag10 = flag8;
            flag1 = flag9;
            l1 = l;
            flag11 = flag;
            flag12 = flag2;
            flag13 = flag6;
            flag14 = flag5;
            flag2 = flag4;
            d1 = d;
            flag15 = flag3;
            obj2 = jsontoken;
        } else
        if ("promoted".equals(s15))
        {
            if (jsonparser.getIntValue() == 1)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            obj = s7;
            obj1 = s6;
            s8 = s5;
            s9 = s4;
            s10 = s3;
            s11 = s2;
            s12 = s1;
            s13 = s;
            flag10 = flag8;
            flag1 = flag9;
            l1 = l;
            flag11 = flag;
            flag12 = flag7;
            flag13 = flag6;
            flag14 = flag2;
            flag2 = flag4;
            d1 = d;
            flag15 = flag3;
            obj2 = jsontoken;
        } else
        if ("verified".equals(s15))
        {
            if (jsonparser.getIntValue() == 1)
            {
                flag3 = true;
            } else
            {
                flag3 = false;
            }
            obj = s7;
            obj1 = s6;
            s8 = s5;
            s9 = s4;
            s10 = s3;
            s11 = s2;
            s12 = s1;
            s13 = s;
            flag10 = flag8;
            flag1 = flag9;
            l1 = l;
            flag11 = flag;
            flag12 = flag7;
            flag13 = flag6;
            flag14 = flag5;
            flag2 = flag4;
            d1 = d;
            flag15 = flag3;
            obj2 = jsontoken;
        } else
        if ("postId".equals(s15))
        {
            vinepost.postId = jsonparser.getLongValue();
            obj = s7;
            obj1 = s6;
            s8 = s5;
            s9 = s4;
            s10 = s3;
            s11 = s2;
            s12 = s1;
            s13 = s;
            flag10 = flag8;
            flag1 = flag9;
            l1 = l;
            flag11 = flag;
            flag12 = flag7;
            flag13 = flag6;
            flag14 = flag5;
            flag2 = flag4;
            d1 = d;
            flag15 = flag3;
            obj2 = jsontoken;
        } else
        if ("userId".equals(s15))
        {
            vinepost.userId = jsonparser.getLongValue();
            obj = s7;
            obj1 = s6;
            s8 = s5;
            s9 = s4;
            s10 = s3;
            s11 = s2;
            s12 = s1;
            s13 = s;
            flag10 = flag8;
            flag1 = flag9;
            l1 = l;
            flag11 = flag;
            flag12 = flag7;
            flag13 = flag6;
            flag14 = flag5;
            flag2 = flag4;
            d1 = d;
            flag15 = flag3;
            obj2 = jsontoken;
        } else
        if ("myRepostId".equals(s15))
        {
            vinepost.myRepostId = jsonparser.getLongValue();
            obj = s7;
            obj1 = s6;
            s8 = s5;
            s9 = s4;
            s10 = s3;
            s11 = s2;
            s12 = s1;
            s13 = s;
            flag10 = flag8;
            flag1 = flag9;
            l1 = l;
            flag11 = flag;
            flag12 = flag7;
            flag13 = flag6;
            flag14 = flag5;
            flag2 = flag4;
            d1 = d;
            flag15 = flag3;
            obj2 = jsontoken;
            if (vinepost.myRepostId > 0L)
            {
                flag2 = true;
                obj = s7;
                obj1 = s6;
                s8 = s5;
                s9 = s4;
                s10 = s3;
                s11 = s2;
                s12 = s1;
                s13 = s;
                flag10 = flag8;
                flag1 = flag9;
                l1 = l;
                flag11 = flag;
                flag12 = flag7;
                flag13 = flag6;
                flag14 = flag5;
                d1 = d;
                flag15 = flag3;
                obj2 = jsontoken;
            }
        } else
        if ("private".equals(s15))
        {
            if (jsonparser.getLongValue() == 1L)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            obj = s7;
            obj1 = s6;
            s8 = s5;
            s9 = s4;
            s10 = s3;
            s11 = s2;
            s12 = s1;
            s13 = s;
            flag10 = flag8;
            flag1 = flag9;
            l1 = l;
            flag11 = flag;
            flag12 = flag7;
            flag13 = flag2;
            flag14 = flag5;
            flag2 = flag4;
            d1 = d;
            flag15 = flag3;
            obj2 = jsontoken;
        } else
        {
            obj = s7;
            obj1 = s6;
            s8 = s5;
            s9 = s4;
            s10 = s3;
            s11 = s2;
            s12 = s1;
            s13 = s;
            flag10 = flag8;
            flag1 = flag9;
            l1 = l;
            flag11 = flag;
            flag12 = flag7;
            flag13 = flag6;
            flag14 = flag5;
            flag2 = flag4;
            d1 = d;
            flag15 = flag3;
            obj2 = jsontoken;
            if ("liked".equals(s15))
            {
                if (jsonparser.getLongValue() == 1L)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                obj = s7;
                obj1 = s6;
                s8 = s5;
                s9 = s4;
                s10 = s3;
                s11 = s2;
                s12 = s1;
                s13 = s;
                flag10 = flag8;
                l1 = l;
                flag11 = flag;
                flag12 = flag7;
                flag13 = flag6;
                flag14 = flag5;
                flag2 = flag4;
                d1 = d;
                flag15 = flag3;
                obj2 = jsontoken;
            }
        }
          goto _L9
        String s16 = jsonparser.getCurrentName();
        if ("liked".equals(s16))
        {
            flag1 = jsonparser.getBooleanValue();
            obj = s7;
            obj1 = s6;
            s8 = s5;
            s9 = s4;
            s10 = s3;
            s11 = s2;
            s12 = s1;
            s13 = s;
            flag10 = flag8;
            l1 = l;
            flag11 = flag;
            flag12 = flag7;
            flag13 = flag6;
            flag14 = flag5;
            flag2 = flag4;
            d1 = d;
            flag15 = flag3;
            obj2 = jsontoken;
        } else
        {
            obj = s7;
            obj1 = s6;
            s8 = s5;
            s9 = s4;
            s10 = s3;
            s11 = s2;
            s12 = s1;
            s13 = s;
            flag10 = flag8;
            flag1 = flag9;
            l1 = l;
            flag11 = flag;
            flag12 = flag7;
            flag13 = flag6;
            flag14 = flag5;
            flag2 = flag4;
            d1 = d;
            flag15 = flag3;
            obj2 = jsontoken;
            if ("revined".equals(s16))
            {
                flag2 = jsonparser.getBooleanValue();
                obj = s7;
                obj1 = s6;
                s8 = s5;
                s9 = s4;
                s10 = s3;
                s11 = s2;
                s12 = s1;
                s13 = s;
                flag10 = flag8;
                flag1 = flag9;
                l1 = l;
                flag11 = flag;
                flag12 = flag7;
                flag13 = flag6;
                flag14 = flag5;
                d1 = d;
                flag15 = flag3;
                obj2 = jsontoken;
            }
        }
          goto _L9
        if (vinepost.videoUrl == null && jsontoken != null)
        {
            vinepost.videoUrl = jsontoken;
        }
        if (vinepost.foursquareVenueId != null)
        {
            vinepost.venueData = new VineVenue(s7, s6, s5, s4, s3, s2, s1, s);
        }
        vinepost.setFlagExplicit(flag8);
        vinepost.setFlagVerified(flag3);
        vinepost.setFlagRevined(flag4);
        vinepost.setFlagLiked(flag9);
        vinepost.setFlagPromoted(flag5);
        vinepost.setFlagPostVerified(flag7);
        vinepost.setFlagPrivate(flag6);
        int i;
        if (vinepost.likes != null)
        {
            i = vinepost.likes.count;
        } else
        {
            i = 0;
        }
        vinepost.likesCount = i;
        if (vinepost.comments != null)
        {
            i = vinepost.comments.count;
        } else
        {
            i = 0;
        }
        vinepost.commentsCount = i;
        vinepost.loops = l;
        vinepost.lastRefresh = System.currentTimeMillis();
        vinepost.velocity = d;
        vinepost.onFire = flag;
        return vinepost;
    }

    public static VinePrivateMessage parsePrivateMessage(JsonParser jsonparser)
        throws IOException
    {
        Object obj;
        VinePost vinepost;
        String s1;
        String s2;
        String s3;
        int i;
        int j;
        long l1;
        long l2;
        long l3;
        long l4;
        long l5;
        boolean flag;
        boolean flag1;
        obj = jsonparser.nextToken();
        l5 = 0L;
        l4 = 0L;
        l3 = 0L;
        l2 = 0L;
        s1 = null;
        s3 = null;
        s2 = null;
        flag1 = false;
        flag = false;
        vinepost = null;
        i = 0x7fffffff;
        l1 = -1L;
        j = 1;
_L8:
        if (obj == null || obj == JsonToken.END_OBJECT)
        {
            break MISSING_BLOCK_LABEL_1412;
        }
        _cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[((JsonToken) (obj)).ordinal()];
        JVM INSTR tableswitch 1 6: default 104
    //                   1 1224
    //                   2 1355
    //                   3 724
    //                   4 214
    //                   5 1039
    //                   6 1039;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L6
_L3:
        break MISSING_BLOCK_LABEL_1355;
_L5:
        break; /* Loop/switch isn't completed */
_L1:
        String s;
        String s4;
        VinePost vinepost1;
        int k;
        int l;
        long l6;
        long l7;
        long l8;
        long l9;
        long l10;
        boolean flag2;
        boolean flag3;
        vinepost1 = vinepost;
        flag3 = flag;
        l10 = l1;
        l = i;
        flag2 = flag1;
        k = j;
        s = s2;
        obj = s3;
        s4 = s1;
        l9 = l2;
        l8 = l3;
        l7 = l4;
        l6 = l5;
_L9:
        JsonToken jsontoken = jsonparser.nextToken();
        l5 = l6;
        l4 = l7;
        l3 = l8;
        l2 = l9;
        s1 = s4;
        s3 = ((String) (obj));
        s2 = s;
        j = k;
        flag1 = flag2;
        i = l;
        l1 = l10;
        flag = flag3;
        vinepost = vinepost1;
        obj = jsontoken;
        if (true) goto _L8; else goto _L7
_L7:
        obj = jsonparser.getCurrentName();
        if ("message".equals(obj))
        {
            s4 = jsonparser.getText();
            l6 = l5;
            l7 = l4;
            l8 = l3;
            l9 = l2;
            obj = s3;
            s = s2;
            k = j;
            flag2 = flag1;
            l = i;
            l10 = l1;
            flag3 = flag;
            vinepost1 = vinepost;
        } else
        if ("videoUrl".equals(obj))
        {
            obj = jsonparser.getText();
            l6 = l5;
            l7 = l4;
            l8 = l3;
            l9 = l2;
            s4 = s1;
            s = s2;
            k = j;
            flag2 = flag1;
            l = i;
            l10 = l1;
            flag3 = flag;
            vinepost1 = vinepost;
        } else
        if ("thumbnailUrl".equals(obj))
        {
            s = jsonparser.getText();
            l6 = l5;
            l7 = l4;
            l8 = l3;
            l9 = l2;
            s4 = s1;
            obj = s3;
            k = j;
            flag2 = flag1;
            l = i;
            l10 = l1;
            flag3 = flag;
            vinepost1 = vinepost;
        } else
        if ("created".equals(obj))
        {
            l9 = DateTimeUtil.getTimeInMsFromString(jsonparser.getText(), "yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
            l6 = l5;
            l7 = l4;
            l8 = l3;
            s4 = s1;
            obj = s3;
            s = s2;
            k = j;
            flag2 = flag1;
            l = i;
            l10 = l1;
            flag3 = flag;
            vinepost1 = vinepost;
        } else
        if ("vanishedDate".equals(obj))
        {
            l10 = DateTimeUtil.getTimeInMsFromString(jsonparser.getText(), "yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
            l6 = l5;
            l7 = l4;
            l8 = l3;
            l9 = l2;
            s4 = s1;
            obj = s3;
            s = s2;
            k = j;
            flag2 = flag1;
            l = i;
            flag3 = flag;
            vinepost1 = vinepost;
        } else
        {
            l6 = l5;
            l7 = l4;
            l8 = l3;
            l9 = l2;
            s4 = s1;
            obj = s3;
            s = s2;
            k = j;
            flag2 = flag1;
            l = i;
            l10 = l1;
            flag3 = flag;
            vinepost1 = vinepost;
            if ("inbox".equals(jsonparser.getCurrentName()))
            {
                l6 = l5;
                l7 = l4;
                l8 = l3;
                l9 = l2;
                s4 = s1;
                obj = s3;
                s = s2;
                k = j;
                flag2 = flag1;
                l = i;
                l10 = l1;
                flag3 = flag;
                vinepost1 = vinepost;
                if ("other".equals(jsonparser.getValueAsString()))
                {
                    k = 2;
                    l6 = l5;
                    l7 = l4;
                    l8 = l3;
                    l9 = l2;
                    s4 = s1;
                    obj = s3;
                    s = s2;
                    flag2 = flag1;
                    l = i;
                    l10 = l1;
                    flag3 = flag;
                    vinepost1 = vinepost;
                }
            }
        }
          goto _L9
_L4:
        String s5 = jsonparser.getCurrentName();
        if ("conversationId".equals(s5))
        {
            l6 = jsonparser.getLongValue();
            l7 = l4;
            l8 = l3;
            l9 = l2;
            s4 = s1;
            obj = s3;
            s = s2;
            k = j;
            flag2 = flag1;
            l = i;
            l10 = l1;
            flag3 = flag;
            vinepost1 = vinepost;
        } else
        if ("messageId".equals(s5))
        {
            l7 = jsonparser.getLongValue();
            l6 = l5;
            l8 = l3;
            l9 = l2;
            s4 = s1;
            obj = s3;
            s = s2;
            k = j;
            flag2 = flag1;
            l = i;
            l10 = l1;
            flag3 = flag;
            vinepost1 = vinepost;
        } else
        if ("userId".equals(s5))
        {
            l8 = jsonparser.getLongValue();
            l6 = l5;
            l7 = l4;
            l9 = l2;
            s4 = s1;
            obj = s3;
            s = s2;
            k = j;
            flag2 = flag1;
            l = i;
            l10 = l1;
            flag3 = flag;
            vinepost1 = vinepost;
        } else
        {
            l6 = l5;
            l7 = l4;
            l8 = l3;
            l9 = l2;
            s4 = s1;
            obj = s3;
            s = s2;
            k = j;
            flag2 = flag1;
            l = i;
            l10 = l1;
            flag3 = flag;
            vinepost1 = vinepost;
            if ("maxLoops".equals(s5))
            {
                l = jsonparser.getIntValue();
                l6 = l5;
                l7 = l4;
                l8 = l3;
                l9 = l2;
                s4 = s1;
                obj = s3;
                s = s2;
                k = j;
                flag2 = flag1;
                l10 = l1;
                flag3 = flag;
                vinepost1 = vinepost;
            }
        }
          goto _L9
_L6:
        String s6 = jsonparser.getCurrentName();
        if ("vanished".equals(s6))
        {
            flag2 = jsonparser.getBooleanValue();
            l6 = l5;
            l7 = l4;
            l8 = l3;
            l9 = l2;
            s4 = s1;
            obj = s3;
            s = s2;
            k = j;
            l = i;
            l10 = l1;
            flag3 = flag;
            vinepost1 = vinepost;
        } else
        {
            l6 = l5;
            l7 = l4;
            l8 = l3;
            l9 = l2;
            s4 = s1;
            obj = s3;
            s = s2;
            k = j;
            flag2 = flag1;
            l = i;
            l10 = l1;
            flag3 = flag;
            vinepost1 = vinepost;
            if ("ephemeral".equals(s6))
            {
                flag3 = jsonparser.getBooleanValue();
                l6 = l5;
                l7 = l4;
                l8 = l3;
                l9 = l2;
                s4 = s1;
                obj = s3;
                s = s2;
                k = j;
                flag2 = flag1;
                l = i;
                l10 = l1;
                vinepost1 = vinepost;
            }
        }
          goto _L9
_L2:
        if ("post".equals(jsonparser.getCurrentName()))
        {
            vinepost1 = parsePost(jsonparser);
            obj = vinepost1.videoUrl;
            s = vinepost1.thumbnailUrl;
            l6 = l5;
            l7 = l4;
            l8 = l3;
            l9 = l2;
            s4 = s1;
            k = j;
            flag2 = flag1;
            l = i;
            l10 = l1;
            flag3 = flag;
        } else
        {
            jsonparser.skipChildren();
            l6 = l5;
            l7 = l4;
            l8 = l3;
            l9 = l2;
            s4 = s1;
            obj = s3;
            s = s2;
            k = j;
            flag2 = flag1;
            l = i;
            l10 = l1;
            flag3 = flag;
            vinepost1 = vinepost;
        }
          goto _L9
        jsonparser.skipChildren();
        l6 = l5;
        l7 = l4;
        l8 = l3;
        l9 = l2;
        s4 = s1;
        obj = s3;
        s = s2;
        k = j;
        flag2 = flag1;
        l = i;
        l10 = l1;
        flag3 = flag;
        vinepost1 = vinepost;
          goto _L9
        return new VinePrivateMessage(-1L, l5, l4, l3, l2, s1, s3, s2, j, false, flag1, i, l1, flag, 0L, vinepost, 0, null);
    }

    private static VinePrivateMessagePostResponseWithUsers parsePrivateMessageResponse(JsonParser jsonparser)
        throws IOException
    {
        Object obj;
        Object obj6;
        Object obj7;
        ArrayList arraylist;
        ArrayList arraylist1;
        int i;
        arraylist = new ArrayList();
        arraylist1 = new ArrayList();
        obj7 = null;
        obj = null;
        i = 1;
        obj6 = jsonparser.nextToken();
_L8:
        if (obj6 == null || obj6 == JsonToken.END_OBJECT) goto _L2; else goto _L1
_L1:
        Object obj1;
        Object obj2;
        int j;
        j = i;
        obj1 = obj;
        obj2 = obj7;
        _cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[((JsonToken) (obj6)).ordinal()];
        JVM INSTR tableswitch 1 4: default 92
    //                   1 1673
    //                   2 174
    //                   3 101
    //                   4 119;
           goto _L3 _L4 _L5 _L6 _L7
_L6:
        break; /* Loop/switch isn't completed */
_L3:
        obj2 = obj7;
        obj1 = obj;
        j = i;
_L9:
        obj6 = jsonparser.nextToken();
        i = j;
        obj = obj1;
        obj7 = obj2;
          goto _L8
_L7:
        j = i;
        obj1 = obj;
        obj2 = obj7;
        if ("inbox".equals(jsonparser.getCurrentName()))
        {
            j = i;
            obj1 = obj;
            obj2 = obj7;
            if ("other".equals(jsonparser.getValueAsString()))
            {
                j = 2;
                obj1 = obj;
                obj2 = obj7;
            }
        }
          goto _L9
_L5:
        if (!"messages".equals(jsonparser.getCurrentName())) goto _L11; else goto _L10
_L10:
        j = i;
        obj1 = obj;
        obj2 = obj7;
        if (obj6 == null) goto _L9; else goto _L12
_L12:
        j = i;
        obj1 = obj;
        obj2 = obj7;
        if (obj6 == JsonToken.END_ARRAY) goto _L9; else goto _L13
_L13:
        _cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[((JsonToken) (obj6)).ordinal()];
        JVM INSTR tableswitch 1 1: default 244
    //                   1 253;
           goto _L14 _L15
_L14:
        obj6 = jsonparser.nextToken();
          goto _L10
_L15:
        Object obj3;
        Object obj4;
        Object obj5;
        VineError vineerror;
        String s;
        String s1;
        long l;
        long l1;
        long l2;
        vineerror = null;
        obj3 = null;
        s1 = null;
        s = null;
        Object obj8 = null;
        obj5 = null;
        obj4 = null;
        obj1 = null;
        l2 = 0L;
        l1 = 0L;
        l = -1L;
        obj2 = obj;
        obj = obj8;
_L23:
        if (obj6 == null || obj6 == JsonToken.END_OBJECT) goto _L17; else goto _L16
_L16:
        Object obj9;
        Object obj10;
        Object obj11;
        String s2;
        String s3;
        VineError vineerror1;
        Object obj12;
        Object obj13;
        String s4;
        String s5;
        long l3;
        long l5;
        long l6;
        s5 = jsonparser.getCurrentName();
        l3 = l;
        obj9 = obj;
        obj10 = obj5;
        obj11 = obj3;
        s2 = s1;
        s3 = s;
        vineerror1 = vineerror;
        l5 = l2;
        l6 = l1;
        obj12 = obj2;
        obj13 = obj4;
        s4 = ((String) (obj1));
        _cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[((JsonToken) (obj6)).ordinal()];
        JVM INSTR tableswitch 1 4: default 396
    //                   1 952
    //                   2 441
    //                   3 785
    //                   4 495;
           goto _L18 _L19 _L20 _L21 _L22
_L20:
        break; /* Loop/switch isn't completed */
_L18:
        s4 = ((String) (obj1));
        obj13 = obj4;
        obj12 = obj2;
        l6 = l1;
        l5 = l2;
        vineerror1 = vineerror;
        s3 = s;
        s2 = s1;
        obj11 = obj3;
        obj10 = obj5;
        obj9 = obj;
        l3 = l;
_L24:
        obj6 = jsonparser.nextToken();
        l = l3;
        obj = obj9;
        obj5 = obj10;
        obj3 = obj11;
        s1 = s2;
        s = s3;
        vineerror = vineerror1;
        l2 = l5;
        l1 = l6;
        obj2 = obj12;
        obj4 = obj13;
        obj1 = s4;
          goto _L23
_L22:
        if ("videoUrl".equals(s5))
        {
            obj11 = jsonparser.getText();
            l3 = l;
            obj9 = obj;
            obj10 = obj5;
            s2 = s1;
            s3 = s;
            vineerror1 = vineerror;
            l5 = l2;
            l6 = l1;
            obj12 = obj2;
            obj13 = obj4;
            s4 = ((String) (obj1));
        } else
        if ("thumbnailUrl".equals(s5))
        {
            s2 = jsonparser.getText();
            l3 = l;
            obj9 = obj;
            obj10 = obj5;
            obj11 = obj3;
            s3 = s;
            vineerror1 = vineerror;
            l5 = l2;
            l6 = l1;
            obj12 = obj2;
            obj13 = obj4;
            s4 = ((String) (obj1));
        } else
        if ("shareUrl".equals(s5))
        {
            s3 = jsonparser.getText();
            l3 = l;
            obj9 = obj;
            obj10 = obj5;
            obj11 = obj3;
            s2 = s1;
            vineerror1 = vineerror;
            l5 = l2;
            l6 = l1;
            obj12 = obj2;
            obj13 = obj4;
            s4 = ((String) (obj1));
        } else
        {
            l3 = l;
            obj9 = obj;
            obj10 = obj5;
            obj11 = obj3;
            s2 = s1;
            s3 = s;
            vineerror1 = vineerror;
            l5 = l2;
            l6 = l1;
            obj12 = obj2;
            obj13 = obj4;
            s4 = ((String) (obj1));
            if ("videoWebmUrl".equals(s5))
            {
                s4 = jsonparser.getText();
                l3 = l;
                obj9 = obj;
                obj10 = obj5;
                obj11 = obj3;
                s2 = s1;
                s3 = s;
                vineerror1 = vineerror;
                l5 = l2;
                l6 = l1;
                obj12 = obj2;
                obj13 = obj4;
            }
        }
          goto _L24
_L21:
        if ("conversationId".equals(s5))
        {
            l5 = jsonparser.getLongValue();
            l3 = l;
            obj9 = obj;
            obj10 = obj5;
            obj11 = obj3;
            s2 = s1;
            s3 = s;
            vineerror1 = vineerror;
            l6 = l1;
            obj12 = obj2;
            obj13 = obj4;
            s4 = ((String) (obj1));
        } else
        {
            l3 = l;
            obj9 = obj;
            obj10 = obj5;
            obj11 = obj3;
            s2 = s1;
            s3 = s;
            vineerror1 = vineerror;
            l5 = l2;
            l6 = l1;
            obj12 = obj2;
            obj13 = obj4;
            s4 = ((String) (obj1));
            if ("messageId".equals(s5))
            {
                l6 = jsonparser.getLongValue();
                l3 = l;
                obj9 = obj;
                obj10 = obj5;
                obj11 = obj3;
                s2 = s1;
                s3 = s;
                vineerror1 = vineerror;
                l5 = l2;
                obj12 = obj2;
                obj13 = obj4;
                s4 = ((String) (obj1));
            }
        }
          goto _L24
_L19:
        s5 = jsonparser.getCurrentName();
        if (!"to".equals(s5)) goto _L26; else goto _L25
_L25:
        l3 = l;
        obj9 = obj;
        obj10 = obj5;
        obj11 = obj3;
        s2 = s1;
        s3 = s;
        vineerror1 = vineerror;
        l5 = l2;
        l6 = l1;
        obj12 = obj2;
        obj13 = obj4;
        s4 = ((String) (obj1));
        if (obj6 == null) goto _L24; else goto _L27
_L27:
        l3 = l;
        obj9 = obj;
        obj10 = obj5;
        obj11 = obj3;
        s2 = s1;
        s3 = s;
        vineerror1 = vineerror;
        l5 = l2;
        l6 = l1;
        obj12 = obj2;
        obj13 = obj4;
        s4 = ((String) (obj1));
        if (obj6 == JsonToken.END_OBJECT) goto _L24; else goto _L28
_L28:
        obj11 = jsonparser.getCurrentName();
        _cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[((JsonToken) (obj6)).ordinal()];
        JVM INSTR tableswitch 3 4: default 1108
    //                   3 1260
    //                   4 1151;
           goto _L29 _L30 _L31
_L29:
        obj10 = obj4;
        obj9 = obj5;
        obj6 = obj;
        l3 = l;
_L32:
        obj11 = jsonparser.nextToken();
        l = l3;
        obj = obj6;
        obj5 = obj9;
        obj4 = obj10;
        obj6 = obj11;
          goto _L25
_L31:
        if (((String) (obj11)).equals("email"))
        {
            obj6 = jsonparser.getText();
            l3 = l;
            obj9 = obj5;
            obj10 = obj4;
        } else
        if (((String) (obj11)).equals("phoneNumber"))
        {
            obj9 = jsonparser.getText();
            l3 = l;
            obj6 = obj;
            obj10 = obj4;
        } else
        {
            l3 = l;
            obj6 = obj;
            obj9 = obj5;
            obj10 = obj4;
            if (((String) (obj11)).equals("recipientId"))
            {
                obj10 = jsonparser.getText();
                l3 = l;
                obj6 = obj;
                obj9 = obj5;
            }
        }
          goto _L32
_L30:
        l3 = l;
        obj6 = obj;
        obj9 = obj5;
        obj10 = obj4;
        if (((String) (obj11)).equals("userId"))
        {
            l3 = jsonparser.getLongValue();
            obj6 = obj;
            obj9 = obj5;
            obj10 = obj4;
        }
          goto _L32
_L26:
        if ("error".equals(s5))
        {
            vineerror1 = parseMessageError(jsonparser);
            l3 = l;
            obj9 = obj;
            obj10 = obj5;
            obj11 = obj3;
            s2 = s1;
            s3 = s;
            l5 = l2;
            l6 = l1;
            obj12 = obj2;
            obj13 = obj4;
            s4 = ((String) (obj1));
        } else
        {
            l3 = l;
            obj9 = obj;
            obj10 = obj5;
            obj11 = obj3;
            s2 = s1;
            s3 = s;
            vineerror1 = vineerror;
            l5 = l2;
            l6 = l1;
            obj12 = obj2;
            obj13 = obj4;
            s4 = ((String) (obj1));
            if ("post".equals(s5))
            {
                obj12 = parsePost(jsonparser);
                l3 = l;
                obj9 = obj;
                obj10 = obj5;
                obj11 = obj3;
                s2 = s1;
                s3 = s;
                vineerror1 = vineerror;
                l5 = l2;
                l6 = l1;
                obj13 = obj4;
                s4 = ((String) (obj1));
            }
        }
          goto _L24
_L17:
        long l4 = -1L;
        if (!TextUtils.isEmpty(((CharSequence) (obj4))))
        {
            l4 = Long.valueOf(((String) (obj4))).longValue();
        }
        obj4 = null;
        if (obj != null)
        {
            obj = VineRecipient.fromEmail(null, l, ((String) (obj)), l4);
        } else
        if (obj5 != null)
        {
            obj = VineRecipient.fromPhone(null, l, ((String) (obj5)), l4);
        } else
        if (l > 0L)
        {
            obj = VineRecipient.fromUser(null, l, 0, l4);
        } else
        {
            CrashUtil.log("No email, phone, or userId for recipient for message {}", new Object[] {
                Long.valueOf(l1)
            });
            obj = obj4;
        }
        obj4 = obj3;
        if (obj3 == null)
        {
            obj4 = obj1;
        }
        arraylist1.add(obj);
        arraylist.add(new VinePrivateMessageResponse(((VineRecipient) (obj)), l2, l1, ((String) (obj4)), s1, s, vineerror, i));
        obj = obj2;
          goto _L14
_L11:
        if ("users".equals(jsonparser.getCurrentName()))
        {
            obj2 = parseUsersArray(jsonparser, null);
            j = i;
            obj1 = obj;
        } else
        {
            jsonparser.skipChildren();
            j = i;
            obj1 = obj;
            obj2 = obj7;
        }
          goto _L9
_L4:
        jsonparser.skipChildren();
        j = i;
        obj1 = obj;
        obj2 = obj7;
          goto _L9
_L2:
        return new VinePrivateMessagePostResponseWithUsers(arraylist, arraylist1, ((ArrayList) (obj7)), ((VinePost) (obj)));
    }

    public static VineSingleNotification parsePushNotification(JsonParser jsonparser)
        throws IOException
    {
        if (jsonparser.nextToken() == JsonToken.START_OBJECT)
        {
            return parseNotification(jsonparser);
        } else
        {
            return null;
        }
    }

    public static ArrayList parseRTCConversations(JsonParser jsonparser)
        throws IOException
    {
        JsonToken jsontoken;
        ArrayList arraylist;
        arraylist = new ArrayList();
        jsontoken = jsonparser.nextToken();
_L2:
        if (jsontoken == null || jsontoken == JsonToken.END_OBJECT)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        switch (_cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[jsontoken.ordinal()])
        {
        default:
            break;

        case 1: // '\001'
            break; /* Loop/switch isn't completed */

        case 2: // '\002'
            break;
        }
        break MISSING_BLOCK_LABEL_90;
_L3:
        jsontoken = jsonparser.nextToken();
        if (true) goto _L2; else goto _L1
_L1:
        arraylist.add(new VineRTCConversation(Long.parseLong(jsonparser.getCurrentName()), parseRTCParticipants(jsonparser)));
          goto _L3
        jsonparser.skipChildren();
          goto _L3
        return arraylist;
    }

    public static ArrayList parseRTCEvent(JsonParser jsonparser)
        throws IOException
    {
        ArrayList arraylist;
        Object obj;
        arraylist = null;
        obj = jsonparser.nextToken();
_L6:
        if (obj == null || obj == JsonToken.END_OBJECT) goto _L2; else goto _L1
_L1:
        _cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[((JsonToken) (obj)).ordinal()];
        JVM INSTR tableswitch 1 2: default 48
    //                   1 62
    //                   2 153;
           goto _L3 _L4 _L5
_L3:
        obj = arraylist;
_L8:
        JsonToken jsontoken = jsonparser.nextToken();
        arraylist = ((ArrayList) (obj));
        obj = jsontoken;
          goto _L6
_L4:
        obj = arraylist;
        if (!"data".equals(jsonparser.getCurrentName())) goto _L8; else goto _L7
_L7:
        JsonToken jsontoken1 = jsonparser.nextToken();
_L15:
        obj = arraylist;
        if (jsontoken1 == null) goto _L8; else goto _L9
_L9:
        obj = arraylist;
        if (jsontoken1 == JsonToken.END_OBJECT) goto _L8; else goto _L10
_L10:
        _cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[jsontoken1.ordinal()];
        JVM INSTR tableswitch 1 1: default 124
    //                   1 132;
           goto _L11 _L12
_L11:
        jsontoken1 = jsonparser.nextToken();
          goto _L13
_L12:
        if ("conversations".equals(jsonparser.getCurrentName()))
        {
            arraylist = parseRTCConversations(jsonparser);
        }
        if (true) goto _L11; else goto _L13
_L13:
        if (true) goto _L15; else goto _L14
_L14:
_L5:
        jsonparser.skipChildren();
        obj = arraylist;
          goto _L8
_L2:
        return arraylist;
    }

    public static ArrayList parseRTCParticipants(JsonParser jsonparser)
        throws IOException
    {
        JsonToken jsontoken;
        ArrayList arraylist;
        long l;
        boolean flag;
        boolean flag1;
        arraylist = new ArrayList();
        flag1 = false;
        flag = false;
        l = -1L;
        jsontoken = jsonparser.nextToken();
_L6:
        if (jsontoken == null || jsontoken == JsonToken.END_OBJECT) goto _L2; else goto _L1
_L1:
        _cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[jsontoken.ordinal()];
        JVM INSTR tableswitch 1 2: default 64
    //                   1 72
    //                   2 309;
           goto _L3 _L4 _L5
_L3:
        jsontoken = jsonparser.nextToken();
          goto _L6
_L4:
        long l2;
        l2 = Long.parseLong(jsonparser.getCurrentName());
        jsontoken = jsonparser.nextToken();
_L13:
        if (jsontoken == null || jsontoken == JsonToken.END_OBJECT) goto _L8; else goto _L7
_L7:
        long l1;
        boolean flag2;
        boolean flag3;
        flag2 = flag1;
        flag3 = flag;
        l1 = l;
        _cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[jsontoken.ordinal()];
        JVM INSTR tableswitch 3 6: default 148
    //                   3 178
    //                   4 159
    //                   5 219
    //                   6 219;
           goto _L9 _L10 _L11 _L12 _L12
_L11:
        break; /* Loop/switch isn't completed */
_L9:
        l1 = l;
        flag3 = flag;
        flag2 = flag1;
_L14:
        jsontoken = jsonparser.nextToken();
        flag1 = flag2;
        flag = flag3;
        l = l1;
          goto _L13
_L10:
        flag2 = flag1;
        flag3 = flag;
        l1 = l;
        if ("last_message_id".equals(jsonparser.getCurrentName()))
        {
            l1 = jsonparser.getLongValue();
            flag2 = flag1;
            flag3 = flag;
        }
          goto _L14
_L12:
        String s = jsonparser.getCurrentName();
        if ("connected".equals(s))
        {
            flag2 = jsonparser.getBooleanValue();
            flag3 = flag;
            l1 = l;
        } else
        {
            flag2 = flag1;
            flag3 = flag;
            l1 = l;
            if ("typing".equals(s))
            {
                flag3 = jsonparser.getBooleanValue();
                flag2 = flag1;
                l1 = l;
            }
        }
          goto _L14
_L8:
        arraylist.add(new VineRTCParticipant(l2, flag1, flag, l));
          goto _L3
_L5:
        jsonparser.skipChildren();
          goto _L3
_L2:
        return arraylist;
    }

    private static VineRepost parseRepost(JsonParser jsonparser)
        throws IOException
    {
        String s;
        String s1;
        String s2;
        String s3;
        Object obj;
        int i;
        int j;
        int k;
        long l1;
        long l2;
        long l3;
        s3 = null;
        s2 = null;
        s1 = null;
        s = null;
        l1 = 0L;
        l3 = 0L;
        l2 = 0L;
        k = 0;
        j = 0;
        i = 0;
        obj = jsonparser.nextToken();
_L6:
        if (obj == null || obj == JsonToken.END_OBJECT)
        {
            break MISSING_BLOCK_LABEL_1088;
        }
        _cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[((JsonToken) (obj)).ordinal()];
        JVM INSTR tableswitch 1 3: default 80
    //                   1 167
    //                   2 1043
    //                   3 894;
           goto _L1 _L2 _L3 _L4
_L2:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_1043;
_L1:
        String s4;
        String s5;
        String s6;
        int l;
        int i1;
        int j1;
        long l4;
        long l5;
        long l6;
        j1 = i;
        i1 = j;
        l = k;
        l6 = l2;
        l5 = l3;
        l4 = l1;
        s6 = s;
        s5 = s1;
        s4 = s2;
        obj = s3;
_L8:
        JsonToken jsontoken = jsonparser.nextToken();
        s3 = ((String) (obj));
        s2 = s4;
        s1 = s5;
        s = s6;
        l1 = l4;
        l3 = l5;
        l2 = l6;
        k = l;
        j = i1;
        i = j1;
        obj = jsontoken;
        if (true) goto _L6; else goto _L5
_L5:
        JsonToken jsontoken1;
        if (!"user".equals(jsonparser.getCurrentName()))
        {
            break MISSING_BLOCK_LABEL_849;
        }
        jsontoken1 = jsonparser.nextToken();
_L14:
        obj = s3;
        s4 = s2;
        s5 = s1;
        s6 = s;
        l4 = l1;
        l5 = l3;
        l6 = l2;
        l = k;
        i1 = j;
        j1 = i;
        if (jsontoken1 == null) goto _L8; else goto _L7
_L7:
        obj = s3;
        s4 = s2;
        s5 = s1;
        s6 = s;
        l4 = l1;
        l5 = l3;
        l6 = l2;
        l = k;
        i1 = j;
        j1 = i;
        if (jsontoken1 == JsonToken.END_OBJECT) goto _L8; else goto _L9
_L9:
        _cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[jsontoken1.ordinal()];
        JVM INSTR tableswitch 1 4: default 312
    //                   1 812
    //                   2 812
    //                   3 597
    //                   4 379;
           goto _L10 _L11 _L11 _L12 _L13
_L11:
        break MISSING_BLOCK_LABEL_812;
_L10:
        j1 = i;
        i1 = j;
        l = k;
        l4 = l1;
        s6 = s;
        s5 = s1;
        s4 = s2;
        obj = s3;
_L15:
        jsontoken1 = jsonparser.nextToken();
        s3 = ((String) (obj));
        s2 = s4;
        s1 = s5;
        s = s6;
        l1 = l4;
        k = l;
        j = i1;
        i = j1;
          goto _L14
_L13:
        String s7 = jsonparser.getCurrentName();
        if ("description".equals(s7))
        {
            s6 = jsonparser.getText();
            obj = s3;
            s4 = s2;
            s5 = s1;
            l4 = l1;
            l = k;
            i1 = j;
            j1 = i;
        } else
        if ("avatarUrl".equals(s7))
        {
            s4 = jsonparser.getText();
            obj = s3;
            s5 = s1;
            s6 = s;
            l4 = l1;
            l = k;
            i1 = j;
            j1 = i;
        } else
        if ("location".equals(s7))
        {
            s5 = jsonparser.getText();
            obj = s3;
            s4 = s2;
            s6 = s;
            l4 = l1;
            l = k;
            i1 = j;
            j1 = i;
        } else
        {
            obj = s3;
            s4 = s2;
            s5 = s1;
            s6 = s;
            l4 = l1;
            l = k;
            i1 = j;
            j1 = i;
            if ("username".equals(s7))
            {
                obj = jsonparser.getText();
                s4 = s2;
                s5 = s1;
                s6 = s;
                l4 = l1;
                l = k;
                i1 = j;
                j1 = i;
            }
        }
          goto _L15
_L12:
        String s8 = jsonparser.getCurrentName();
        if ("verified".equals(s8))
        {
            l = jsonparser.getIntValue();
            obj = s3;
            s4 = s2;
            s5 = s1;
            s6 = s;
            l4 = l1;
            i1 = j;
            j1 = i;
        } else
        if ("private".equals(s8))
        {
            i1 = jsonparser.getIntValue();
            obj = s3;
            s4 = s2;
            s5 = s1;
            s6 = s;
            l4 = l1;
            l = k;
            j1 = i;
        } else
        if ("unflaggable".equals(s8))
        {
            j1 = jsonparser.getIntValue();
            obj = s3;
            s4 = s2;
            s5 = s1;
            s6 = s;
            l4 = l1;
            l = k;
            i1 = j;
        } else
        {
            obj = s3;
            s4 = s2;
            s5 = s1;
            s6 = s;
            l4 = l1;
            l = k;
            i1 = j;
            j1 = i;
            if ("userId".equals(s8))
            {
                l4 = jsonparser.getLongValue();
                obj = s3;
                s4 = s2;
                s5 = s1;
                s6 = s;
                l = k;
                i1 = j;
                j1 = i;
            }
        }
          goto _L15
        jsonparser.skipChildren();
        obj = s3;
        s4 = s2;
        s5 = s1;
        s6 = s;
        l4 = l1;
        l = k;
        i1 = j;
        j1 = i;
          goto _L15
        jsonparser.skipChildren();
        obj = s3;
        s4 = s2;
        s5 = s1;
        s6 = s;
        l4 = l1;
        l5 = l3;
        l6 = l2;
        l = k;
        i1 = j;
        j1 = i;
          goto _L8
_L4:
        String s9 = jsonparser.getCurrentName();
        if ("repostId".equals(s9))
        {
            l6 = jsonparser.getLongValue();
            obj = s3;
            s4 = s2;
            s5 = s1;
            s6 = s;
            l4 = l1;
            l5 = l3;
            l = k;
            i1 = j;
            j1 = i;
        } else
        {
            obj = s3;
            s4 = s2;
            s5 = s1;
            s6 = s;
            l4 = l1;
            l5 = l3;
            l6 = l2;
            l = k;
            i1 = j;
            j1 = i;
            if ("postId".equals(s9))
            {
                l5 = jsonparser.getLongValue();
                obj = s3;
                s4 = s2;
                s5 = s1;
                s6 = s;
                l4 = l1;
                l6 = l2;
                l = k;
                i1 = j;
                j1 = i;
            }
        }
          goto _L8
        jsonparser.skipChildren();
        obj = s3;
        s4 = s2;
        s5 = s1;
        s6 = s;
        l4 = l1;
        l5 = l3;
        l6 = l2;
        l = k;
        i1 = j;
        j1 = i;
          goto _L8
        return new VineRepost(s3, s2, s1, s, l1, l3, l2, k, j, i);
    }

    private static Object parseRepostResponse(JsonParser jsonparser)
        throws IOException
    {
        JsonToken jsontoken;
        long l;
        long l1;
        l = 0L;
        l1 = 0L;
        jsontoken = jsonparser.nextToken();
_L2:
        long l2;
        if (jsontoken == null || jsontoken == JsonToken.END_OBJECT)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        switch (_cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[jsontoken.ordinal()])
        {
        default:
            l2 = l;
            break;

        case 1: // '\001'
        case 2: // '\002'
            break MISSING_BLOCK_LABEL_119;

        case 3: // '\003'
            break; /* Loop/switch isn't completed */
        }
_L3:
        jsontoken = jsonparser.nextToken();
        l = l2;
        if (true) goto _L2; else goto _L1
_L1:
        String s = jsonparser.getCurrentName();
        if ("repostId".equals(s))
        {
            l2 = jsonparser.getLongValue();
        } else
        {
            l2 = l;
            if ("postId".equals(s))
            {
                l1 = jsonparser.getLongValue();
                l2 = l;
            }
        }
          goto _L3
        jsonparser.skipChildren();
        l2 = l;
          goto _L3
        jsonparser = new VineRepost();
        jsonparser.repostId = l;
        jsonparser.postId = l1;
        return jsonparser;
    }

    private static ServerStatus parseServerStatus(JsonParser jsonparser)
        throws IOException
    {
        String s;
        String s1;
        String s2;
        String s3;
        JsonToken jsontoken;
        s3 = null;
        s2 = null;
        s1 = null;
        s = null;
        jsontoken = jsonparser.nextToken();
_L2:
        String s4;
        String s6;
        String s7;
        String s8;
        if (jsontoken == null || jsontoken == JsonToken.END_OBJECT)
        {
            break MISSING_BLOCK_LABEL_274;
        }
        s4 = s3;
        s6 = s2;
        s7 = s1;
        s8 = s;
        switch (_cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[jsontoken.ordinal()])
        {
        default:
            s8 = s;
            s7 = s1;
            s6 = s2;
            s4 = s3;
            break;

        case 1: // '\001'
        case 2: // '\002'
            break; /* Loop/switch isn't completed */

        case 3: // '\003'
            break;

        case 4: // '\004'
            break MISSING_BLOCK_LABEL_136;
        }
_L3:
        jsontoken = jsonparser.nextToken();
        s3 = s4;
        s2 = s6;
        s1 = s7;
        s = s8;
        if (true) goto _L2; else goto _L1
_L1:
        jsonparser.skipChildren();
        s4 = s3;
        s6 = s2;
        s7 = s1;
        s8 = s;
          goto _L3
        String s5 = jsonparser.getCurrentName();
        if ("uploadType".equals(s5))
        {
            s4 = jsonparser.getText();
            s6 = s2;
            s7 = s1;
            s8 = s;
        } else
        if ("status".equals(s5))
        {
            s6 = jsonparser.getText();
            s4 = s3;
            s7 = s1;
            s8 = s;
        } else
        if ("message".equals(s5))
        {
            s7 = jsonparser.getText();
            s4 = s3;
            s6 = s2;
            s8 = s;
        } else
        {
            s4 = s3;
            s6 = s2;
            s7 = s1;
            s8 = s;
            if ("staticTimelineUrl".equals(s5))
            {
                s8 = jsonparser.getText();
                s4 = s3;
                s6 = s2;
                s7 = s1;
            }
        }
          goto _L3
        return new ServerStatus(s3, s2, s1, null, s);
    }

    private static VineLogin parseSignUp(JsonParser jsonparser)
        throws IOException
    {
        String s;
        String s1;
        Object obj;
        long l;
        l = 0L;
        s = null;
        obj = jsonparser.nextToken();
        s1 = null;
_L7:
        if (obj == null || obj == JsonToken.END_OBJECT)
        {
            break MISSING_BLOCK_LABEL_213;
        }
        _cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[((JsonToken) (obj)).ordinal()];
        JVM INSTR tableswitch 1 4: default 60
    //                   1 191
    //                   2 196
    //                   3 90
    //                   4 126;
           goto _L1 _L2 _L3 _L4 _L5
_L3:
        break MISSING_BLOCK_LABEL_196;
_L4:
        break; /* Loop/switch isn't completed */
_L1:
        String s2;
        long l1;
        s2 = s;
        l1 = l;
        obj = s1;
_L8:
        JsonToken jsontoken = jsonparser.nextToken();
        s1 = ((String) (obj));
        l = l1;
        s = s2;
        obj = jsontoken;
        if (true) goto _L7; else goto _L6
_L6:
        obj = s1;
        l1 = l;
        s2 = s;
        if ("userId".equals(jsonparser.getCurrentName()))
        {
            l1 = jsonparser.getLongValue();
            obj = s1;
            s2 = s;
        }
          goto _L8
_L5:
        if ("key".equals(jsonparser.getCurrentName()))
        {
            obj = jsonparser.getText();
            l1 = l;
            s2 = s;
        } else
        {
            obj = s1;
            l1 = l;
            s2 = s;
            if ("edition".equals(jsonparser.getCurrentName()))
            {
                s2 = jsonparser.getText();
                obj = s1;
                l1 = l;
            }
        }
          goto _L8
_L2:
        jsonparser.skipChildren();
        jsonparser.skipChildren();
        obj = s1;
        l1 = l;
        s2 = s;
          goto _L8
        return new VineLogin(s1, null, l, s);
    }

    private static VineTag parseTag(JsonParser jsonparser)
        throws IOException
    {
        JsonToken jsontoken;
        VineTag vinetag;
        vinetag = new VineTag();
        jsontoken = jsonparser.nextToken();
_L6:
        if (jsontoken == null || jsontoken == JsonToken.END_OBJECT)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        _cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[jsontoken.ordinal()];
        JVM INSTR tableswitch 1 4: default 64
    //                   1 94
    //                   2 94
    //                   3 83
    //                   4 72;
           goto _L1 _L2 _L2 _L3 _L4
_L2:
        break MISSING_BLOCK_LABEL_94;
_L1:
        break; /* Loop/switch isn't completed */
_L4:
        break; /* Loop/switch isn't completed */
_L7:
        jsontoken = jsonparser.nextToken();
        if (true) goto _L6; else goto _L5
_L5:
        vinetag.tagName = jsonparser.getText();
          goto _L7
_L3:
        vinetag.tagId = jsonparser.getLongValue();
          goto _L7
        jsonparser.skipChildren();
          goto _L7
        return vinetag;
    }

    private static ArrayList parseTags(JsonParser jsonparser)
        throws IOException
    {
        JsonToken jsontoken;
        String s;
        ArrayList arraylist;
        long l;
        arraylist = new ArrayList();
        jsontoken = jsonparser.nextToken();
        s = null;
        l = 0L;
_L5:
        if (jsontoken == null || jsontoken == JsonToken.END_ARRAY) goto _L2; else goto _L1
_L1:
        String s1;
        JsonToken jsontoken1;
        long l1;
        jsontoken1 = jsontoken;
        l1 = l;
        s1 = s;
        _cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[jsontoken.ordinal()];
        JVM INSTR tableswitch 1 1: default 64
    //                   1 72;
           goto _L3 _L4
_L3:
        jsontoken = jsonparser.nextToken();
          goto _L5
_L4:
        if (jsontoken1 == null || jsontoken1 == JsonToken.END_OBJECT) goto _L7; else goto _L6
_L6:
        _cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[jsontoken1.ordinal()];
        JVM INSTR tableswitch 3 4: default 116
    //                   3 133
    //                   4 125;
           goto _L8 _L9 _L10
_L8:
        jsontoken1 = jsonparser.nextToken();
          goto _L4
_L10:
        s1 = jsonparser.getText();
          goto _L8
_L9:
        l1 = jsonparser.getLongValue();
          goto _L8
_L7:
        arraylist.add(new VineTag(s1, l1));
        l = l1;
        s = s1;
          goto _L3
_L2:
        return arraylist;
    }

    public static TwitterUser parseTwitterUser(JsonParser jsonparser)
        throws IOException
    {
        String s;
        String s1;
        String s2;
        String s3;
        String s4;
        String s5;
        Object obj;
        long l;
        boolean flag;
        s5 = null;
        s4 = null;
        s3 = null;
        s2 = null;
        s1 = null;
        s = null;
        flag = false;
        l = 0L;
        obj = jsonparser.nextToken();
_L8:
        if (obj == null || obj == JsonToken.END_OBJECT)
        {
            break MISSING_BLOCK_LABEL_701;
        }
        _cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[((JsonToken) (obj)).ordinal()];
        JVM INSTR tableswitch 1 6: default 88
    //                   1 627
    //                   2 664
    //                   3 475
    //                   4 159
    //                   5 551
    //                   6 551;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L6
_L3:
        break MISSING_BLOCK_LABEL_664;
_L5:
        break; /* Loop/switch isn't completed */
_L1:
        String s6;
        String s7;
        String s8;
        String s9;
        String s10;
        long l1;
        boolean flag1;
        l1 = l;
        flag1 = flag;
        s10 = s;
        s9 = s1;
        s8 = s2;
        s7 = s3;
        s6 = s4;
        obj = s5;
_L9:
        JsonToken jsontoken = jsonparser.nextToken();
        s5 = ((String) (obj));
        s4 = s6;
        s3 = s7;
        s2 = s8;
        s1 = s9;
        s = s10;
        flag = flag1;
        l = l1;
        obj = jsontoken;
        if (true) goto _L8; else goto _L7
_L7:
        String s11 = jsonparser.getCurrentName();
        if ("name".equals(s11))
        {
            obj = jsonparser.getText();
            s6 = s4;
            s7 = s3;
            s8 = s2;
            s9 = s1;
            s10 = s;
            flag1 = flag;
            l1 = l;
        } else
        if ("screen_name".equals(s11))
        {
            s6 = jsonparser.getText();
            obj = s5;
            s7 = s3;
            s8 = s2;
            s9 = s1;
            s10 = s;
            flag1 = flag;
            l1 = l;
        } else
        if ("profile_image_url".equals(s11))
        {
            s10 = jsonparser.getText().replace("_normal", "_bigger");
            obj = s5;
            s6 = s4;
            s7 = s3;
            s8 = s2;
            s9 = s1;
            flag1 = flag;
            l1 = l;
        } else
        if ("url".equals(s11))
        {
            s9 = jsonparser.getText();
            obj = s5;
            s6 = s4;
            s7 = s3;
            s8 = s2;
            s10 = s;
            flag1 = flag;
            l1 = l;
        } else
        if ("description".equals(s11))
        {
            s8 = jsonparser.getText();
            obj = s5;
            s6 = s4;
            s7 = s3;
            s9 = s1;
            s10 = s;
            flag1 = flag;
            l1 = l;
        } else
        {
            obj = s5;
            s6 = s4;
            s7 = s3;
            s8 = s2;
            s9 = s1;
            s10 = s;
            flag1 = flag;
            l1 = l;
            if ("location".equals(s11))
            {
                s7 = jsonparser.getText();
                obj = s5;
                s6 = s4;
                s8 = s2;
                s9 = s1;
                s10 = s;
                flag1 = flag;
                l1 = l;
            }
        }
          goto _L9
_L4:
        obj = s5;
        s6 = s4;
        s7 = s3;
        s8 = s2;
        s9 = s1;
        s10 = s;
        flag1 = flag;
        l1 = l;
        if ("id".equals(jsonparser.getCurrentName()))
        {
            l1 = jsonparser.getLongValue();
            obj = s5;
            s6 = s4;
            s7 = s3;
            s8 = s2;
            s9 = s1;
            s10 = s;
            flag1 = flag;
        }
          goto _L9
_L6:
        obj = s5;
        s6 = s4;
        s7 = s3;
        s8 = s2;
        s9 = s1;
        s10 = s;
        flag1 = flag;
        l1 = l;
        if ("default_profile_image".equals(jsonparser.getCurrentName()))
        {
            flag1 = jsonparser.getBooleanValue();
            obj = s5;
            s6 = s4;
            s7 = s3;
            s8 = s2;
            s9 = s1;
            s10 = s;
            l1 = l;
        }
          goto _L9
_L2:
        jsonparser.skipChildren();
        obj = s5;
        s6 = s4;
        s7 = s3;
        s8 = s2;
        s9 = s1;
        s10 = s;
        flag1 = flag;
        l1 = l;
          goto _L9
        jsonparser.skipChildren();
        obj = s5;
        s6 = s4;
        s7 = s3;
        s8 = s2;
        s9 = s1;
        s10 = s;
        flag1 = flag;
        l1 = l;
          goto _L9
        return new TwitterUser(s5, s4, s3, s2, s1, s, flag, l);
    }

    private static VineUser parseUser(JsonParser jsonparser)
        throws IOException
    {
        return parseUser(jsonparser, -1);
    }

    private static VineUser parseUser(JsonParser jsonparser, int i)
        throws IOException
    {
        Object obj;
        String s;
        String s1;
        String s2;
        String s3;
        String s4;
        String s5;
        String s6;
        Object obj1;
        int j;
        int k;
        boolean flag;
        int l;
        boolean flag1;
        byte byte0;
        boolean flag2;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        byte byte1;
        int l2;
        int i3;
        int j3;
        int k3;
        int l3;
        long l8;
        long l9;
        long l10;
        boolean flag4;
        boolean flag5;
        boolean flag6;
        boolean flag7;
        s6 = null;
        s5 = null;
        s4 = null;
        s3 = null;
        s1 = null;
        s2 = null;
        s = null;
        obj = null;
        l10 = 0L;
        l9 = 0L;
        l3 = 0;
        k3 = 0;
        j3 = 0;
        i3 = 0;
        l2 = 0;
        byte1 = -1;
        k2 = 0;
        l = 0;
        j2 = 0;
        i2 = 0;
        l1 = 0;
        k1 = 0;
        j1 = 0;
        flag1 = false;
        flag = false;
        i1 = 1;
        flag7 = false;
        byte0 = -1;
        flag2 = false;
        k = 0;
        flag6 = false;
        flag5 = false;
        flag4 = false;
        l8 = 0L;
        obj1 = jsonparser.nextToken();
        j = i;
_L6:
        if (obj1 == null || obj1 == JsonToken.END_OBJECT)
        {
            break MISSING_BLOCK_LABEL_6347;
        }
        _cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[((JsonToken) (obj1)).ordinal()];
        JVM INSTR tableswitch 1 4: default 160
    //                   1 6202
    //                   2 6202
    //                   3 1979
    //                   4 447;
           goto _L1 _L2 _L2 _L3 _L4
_L2:
        break MISSING_BLOCK_LABEL_6202;
_L4:
        break; /* Loop/switch isn't completed */
_L1:
        String s7;
        String s8;
        String s9;
        String s10;
        String s11;
        String s12;
        String s13;
        int i4;
        int j4;
        int k4;
        int l4;
        int i5;
        int j5;
        int k5;
        int l5;
        int i6;
        int j6;
        int k6;
        int l6;
        int i7;
        int j7;
        int k7;
        int l7;
        int i8;
        int j8;
        int k8;
        long l11;
        long l12;
        long l13;
        boolean flag3;
        boolean flag8;
        boolean flag9;
        boolean flag10;
        k8 = j;
        i = k;
        j8 = ((flag) ? 1 : 0);
        i8 = ((flag1) ? 1 : 0);
        l7 = ((flag2) ? 1 : 0);
        l13 = l8;
        flag3 = flag4;
        flag10 = flag5;
        flag9 = flag6;
        s13 = ((String) (obj));
        k7 = l;
        j7 = byte0;
        flag8 = flag7;
        s12 = s;
        i7 = i1;
        l6 = j1;
        k6 = k1;
        j6 = l1;
        s11 = s1;
        s10 = s2;
        i6 = i2;
        l5 = j2;
        k5 = k2;
        j5 = byte1;
        i5 = l2;
        l4 = i3;
        k4 = j3;
        j4 = k3;
        i4 = l3;
        l12 = l9;
        l11 = l10;
        s9 = s3;
        s8 = s4;
        s7 = s5;
        obj1 = s6;
_L7:
        JsonToken jsontoken = jsonparser.nextToken();
        s6 = ((String) (obj1));
        s5 = s7;
        s4 = s8;
        s3 = s9;
        l10 = l11;
        l9 = l12;
        l3 = i4;
        k3 = j4;
        j3 = k4;
        i3 = l4;
        l2 = i5;
        byte1 = j5;
        k2 = k5;
        j2 = l5;
        i2 = i6;
        s2 = s10;
        s1 = s11;
        l1 = j6;
        k1 = k6;
        j1 = l6;
        i1 = i7;
        s = s12;
        flag7 = flag8;
        byte0 = j7;
        l = k7;
        obj = s13;
        flag6 = flag9;
        flag5 = flag10;
        flag4 = flag3;
        l8 = l13;
        flag2 = l7;
        flag1 = i8;
        flag = j8;
        k = i;
        obj1 = jsontoken;
        j = k8;
        if (true) goto _L6; else goto _L5
_L5:
        String s14 = jsonparser.getCurrentName();
        if ("avatarUrl".equals(s14))
        {
            s7 = jsonparser.getText();
            obj1 = s6;
            s8 = s4;
            s9 = s3;
            l11 = l10;
            l12 = l9;
            i4 = l3;
            j4 = k3;
            k4 = j3;
            l4 = i3;
            i5 = l2;
            j5 = byte1;
            k5 = k2;
            l5 = j2;
            i6 = i2;
            s10 = s2;
            s11 = s1;
            j6 = l1;
            k6 = k1;
            l6 = j1;
            i7 = i1;
            s12 = s;
            flag8 = flag7;
            j7 = byte0;
            k7 = l;
            s13 = ((String) (obj));
            flag9 = flag6;
            flag10 = flag5;
            flag3 = flag4;
            l13 = l8;
            l7 = ((flag2) ? 1 : 0);
            i8 = ((flag1) ? 1 : 0);
            j8 = ((flag) ? 1 : 0);
            i = k;
            k8 = j;
        } else
        if ("username".equals(s14))
        {
            obj1 = jsonparser.getText();
            s7 = s5;
            s8 = s4;
            s9 = s3;
            l11 = l10;
            l12 = l9;
            i4 = l3;
            j4 = k3;
            k4 = j3;
            l4 = i3;
            i5 = l2;
            j5 = byte1;
            k5 = k2;
            l5 = j2;
            i6 = i2;
            s10 = s2;
            s11 = s1;
            j6 = l1;
            k6 = k1;
            l6 = j1;
            i7 = i1;
            s12 = s;
            flag8 = flag7;
            j7 = byte0;
            k7 = l;
            s13 = ((String) (obj));
            flag9 = flag6;
            flag10 = flag5;
            flag3 = flag4;
            l13 = l8;
            l7 = ((flag2) ? 1 : 0);
            i8 = ((flag1) ? 1 : 0);
            j8 = ((flag) ? 1 : 0);
            i = k;
            k8 = j;
        } else
        if ("description".equals(s14))
        {
            s8 = jsonparser.getText();
            obj1 = s6;
            s7 = s5;
            s9 = s3;
            l11 = l10;
            l12 = l9;
            i4 = l3;
            j4 = k3;
            k4 = j3;
            l4 = i3;
            i5 = l2;
            j5 = byte1;
            k5 = k2;
            l5 = j2;
            i6 = i2;
            s10 = s2;
            s11 = s1;
            j6 = l1;
            k6 = k1;
            l6 = j1;
            i7 = i1;
            s12 = s;
            flag8 = flag7;
            j7 = byte0;
            k7 = l;
            s13 = ((String) (obj));
            flag9 = flag6;
            flag10 = flag5;
            flag3 = flag4;
            l13 = l8;
            l7 = ((flag2) ? 1 : 0);
            i8 = ((flag1) ? 1 : 0);
            j8 = ((flag) ? 1 : 0);
            i = k;
            k8 = j;
        } else
        if ("location".equals(s14))
        {
            s9 = jsonparser.getText();
            obj1 = s6;
            s7 = s5;
            s8 = s4;
            l11 = l10;
            l12 = l9;
            i4 = l3;
            j4 = k3;
            k4 = j3;
            l4 = i3;
            i5 = l2;
            j5 = byte1;
            k5 = k2;
            l5 = j2;
            i6 = i2;
            s10 = s2;
            s11 = s1;
            j6 = l1;
            k6 = k1;
            l6 = j1;
            i7 = i1;
            s12 = s;
            flag8 = flag7;
            j7 = byte0;
            k7 = l;
            s13 = ((String) (obj));
            flag9 = flag6;
            flag10 = flag5;
            flag3 = flag4;
            l13 = l8;
            l7 = ((flag2) ? 1 : 0);
            i8 = ((flag1) ? 1 : 0);
            j8 = ((flag) ? 1 : 0);
            i = k;
            k8 = j;
        } else
        if ("phoneNumber".equals(s14))
        {
            s11 = jsonparser.getText();
            obj1 = s6;
            s7 = s5;
            s8 = s4;
            s9 = s3;
            l11 = l10;
            l12 = l9;
            i4 = l3;
            j4 = k3;
            k4 = j3;
            l4 = i3;
            i5 = l2;
            j5 = byte1;
            k5 = k2;
            l5 = j2;
            i6 = i2;
            s10 = s2;
            j6 = l1;
            k6 = k1;
            l6 = j1;
            i7 = i1;
            s12 = s;
            flag8 = flag7;
            j7 = byte0;
            k7 = l;
            s13 = ((String) (obj));
            flag9 = flag6;
            flag10 = flag5;
            flag3 = flag4;
            l13 = l8;
            l7 = ((flag2) ? 1 : 0);
            i8 = ((flag1) ? 1 : 0);
            j8 = ((flag) ? 1 : 0);
            i = k;
            k8 = j;
        } else
        if ("email".equals(s14))
        {
            s10 = jsonparser.getText();
            obj1 = s6;
            s7 = s5;
            s8 = s4;
            s9 = s3;
            l11 = l10;
            l12 = l9;
            i4 = l3;
            j4 = k3;
            k4 = j3;
            l4 = i3;
            i5 = l2;
            j5 = byte1;
            k5 = k2;
            l5 = j2;
            i6 = i2;
            s11 = s1;
            j6 = l1;
            k6 = k1;
            l6 = j1;
            i7 = i1;
            s12 = s;
            flag8 = flag7;
            j7 = byte0;
            k7 = l;
            s13 = ((String) (obj));
            flag9 = flag6;
            flag10 = flag5;
            flag3 = flag4;
            l13 = l8;
            l7 = ((flag2) ? 1 : 0);
            i8 = ((flag1) ? 1 : 0);
            j8 = ((flag) ? 1 : 0);
            i = k;
            k8 = j;
        } else
        if ("edition".equals(s14))
        {
            s12 = jsonparser.getText();
            obj1 = s6;
            s7 = s5;
            s8 = s4;
            s9 = s3;
            l11 = l10;
            l12 = l9;
            i4 = l3;
            j4 = k3;
            k4 = j3;
            l4 = i3;
            i5 = l2;
            j5 = byte1;
            k5 = k2;
            l5 = j2;
            i6 = i2;
            s10 = s2;
            s11 = s1;
            j6 = l1;
            k6 = k1;
            l6 = j1;
            i7 = i1;
            flag8 = flag7;
            j7 = byte0;
            k7 = l;
            s13 = ((String) (obj));
            flag9 = flag6;
            flag10 = flag5;
            flag3 = flag4;
            l13 = l8;
            l7 = ((flag2) ? 1 : 0);
            i8 = ((flag1) ? 1 : 0);
            j8 = ((flag) ? 1 : 0);
            i = k;
            k8 = j;
        } else
        if ("profileBackground".equals(s14))
        {
            j7 = (int)Long.parseLong(jsonparser.getText().substring(2), 16);
            obj1 = s6;
            s7 = s5;
            s8 = s4;
            s9 = s3;
            l11 = l10;
            l12 = l9;
            i4 = l3;
            j4 = k3;
            k4 = j3;
            l4 = i3;
            i5 = l2;
            j5 = byte1;
            k5 = k2;
            l5 = j2;
            i6 = i2;
            s10 = s2;
            s11 = s1;
            j6 = l1;
            k6 = k1;
            l6 = j1;
            i7 = i1;
            s12 = s;
            flag8 = flag7;
            k7 = l;
            s13 = ((String) (obj));
            flag9 = flag6;
            flag10 = flag5;
            flag3 = flag4;
            l13 = l8;
            l7 = ((flag2) ? 1 : 0);
            i8 = ((flag1) ? 1 : 0);
            j8 = ((flag) ? 1 : 0);
            i = k;
            k8 = j;
        } else
        {
            obj1 = s6;
            s7 = s5;
            s8 = s4;
            s9 = s3;
            l11 = l10;
            l12 = l9;
            i4 = l3;
            j4 = k3;
            k4 = j3;
            l4 = i3;
            i5 = l2;
            j5 = byte1;
            k5 = k2;
            l5 = j2;
            i6 = i2;
            s10 = s2;
            s11 = s1;
            j6 = l1;
            k6 = k1;
            l6 = j1;
            i7 = i1;
            s12 = s;
            flag8 = flag7;
            j7 = byte0;
            k7 = l;
            s13 = ((String) (obj));
            flag9 = flag6;
            flag10 = flag5;
            flag3 = flag4;
            l13 = l8;
            l7 = ((flag2) ? 1 : 0);
            i8 = ((flag1) ? 1 : 0);
            j8 = ((flag) ? 1 : 0);
            i = k;
            k8 = j;
            if ("section".equals(s14))
            {
                s13 = jsonparser.getText();
                obj1 = s6;
                s7 = s5;
                s8 = s4;
                s9 = s3;
                l11 = l10;
                l12 = l9;
                i4 = l3;
                j4 = k3;
                k4 = j3;
                l4 = i3;
                i5 = l2;
                j5 = byte1;
                k5 = k2;
                l5 = j2;
                i6 = i2;
                s10 = s2;
                s11 = s1;
                j6 = l1;
                k6 = k1;
                l6 = j1;
                i7 = i1;
                s12 = s;
                flag8 = flag7;
                j7 = byte0;
                k7 = l;
                flag9 = flag6;
                flag10 = flag5;
                flag3 = flag4;
                l13 = l8;
                l7 = ((flag2) ? 1 : 0);
                i8 = ((flag1) ? 1 : 0);
                j8 = ((flag) ? 1 : 0);
                i = k;
                k8 = j;
            }
        }
          goto _L7
_L3:
        String s15 = jsonparser.getCurrentName();
        if ("userId".equals(s15))
        {
            l11 = jsonparser.getLongValue();
            obj1 = s6;
            s7 = s5;
            s8 = s4;
            s9 = s3;
            l12 = l9;
            i4 = l3;
            j4 = k3;
            k4 = j3;
            l4 = i3;
            i5 = l2;
            j5 = byte1;
            k5 = k2;
            l5 = j2;
            i6 = i2;
            s10 = s2;
            s11 = s1;
            j6 = l1;
            k6 = k1;
            l6 = j1;
            i7 = i1;
            s12 = s;
            flag8 = flag7;
            j7 = byte0;
            k7 = l;
            s13 = ((String) (obj));
            flag9 = flag6;
            flag10 = flag5;
            flag3 = flag4;
            l13 = l8;
            l7 = ((flag2) ? 1 : 0);
            i8 = ((flag1) ? 1 : 0);
            j8 = ((flag) ? 1 : 0);
            i = k;
            k8 = j;
        } else
        if ("blocked".equals(s15))
        {
            i4 = jsonparser.getIntValue();
            obj1 = s6;
            s7 = s5;
            s8 = s4;
            s9 = s3;
            l11 = l10;
            l12 = l9;
            j4 = k3;
            k4 = j3;
            l4 = i3;
            i5 = l2;
            j5 = byte1;
            k5 = k2;
            l5 = j2;
            i6 = i2;
            s10 = s2;
            s11 = s1;
            j6 = l1;
            k6 = k1;
            l6 = j1;
            i7 = i1;
            s12 = s;
            flag8 = flag7;
            j7 = byte0;
            k7 = l;
            s13 = ((String) (obj));
            flag9 = flag6;
            flag10 = flag5;
            flag3 = flag4;
            l13 = l8;
            l7 = ((flag2) ? 1 : 0);
            i8 = ((flag1) ? 1 : 0);
            j8 = ((flag) ? 1 : 0);
            i = k;
            k8 = j;
        } else
        if ("blocking".equals(s15))
        {
            j4 = jsonparser.getIntValue();
            obj1 = s6;
            s7 = s5;
            s8 = s4;
            s9 = s3;
            l11 = l10;
            l12 = l9;
            i4 = l3;
            k4 = j3;
            l4 = i3;
            i5 = l2;
            j5 = byte1;
            k5 = k2;
            l5 = j2;
            i6 = i2;
            s10 = s2;
            s11 = s1;
            j6 = l1;
            k6 = k1;
            l6 = j1;
            i7 = i1;
            s12 = s;
            flag8 = flag7;
            j7 = byte0;
            k7 = l;
            s13 = ((String) (obj));
            flag9 = flag6;
            flag10 = flag5;
            flag3 = flag4;
            l13 = l8;
            l7 = ((flag2) ? 1 : 0);
            i8 = ((flag1) ? 1 : 0);
            j8 = ((flag) ? 1 : 0);
            i = k;
            k8 = j;
        } else
        if ("explicit".equals(s15))
        {
            k4 = jsonparser.getIntValue();
            obj1 = s6;
            s7 = s5;
            s8 = s4;
            s9 = s3;
            l11 = l10;
            l12 = l9;
            i4 = l3;
            j4 = k3;
            l4 = i3;
            i5 = l2;
            j5 = byte1;
            k5 = k2;
            l5 = j2;
            i6 = i2;
            s10 = s2;
            s11 = s1;
            j6 = l1;
            k6 = k1;
            l6 = j1;
            i7 = i1;
            s12 = s;
            flag8 = flag7;
            j7 = byte0;
            k7 = l;
            s13 = ((String) (obj));
            flag9 = flag6;
            flag10 = flag5;
            flag3 = flag4;
            l13 = l8;
            l7 = ((flag2) ? 1 : 0);
            i8 = ((flag1) ? 1 : 0);
            j8 = ((flag) ? 1 : 0);
            i = k;
            k8 = j;
        } else
        if ("followerCount".equals(s15))
        {
            l4 = jsonparser.getIntValue();
            obj1 = s6;
            s7 = s5;
            s8 = s4;
            s9 = s3;
            l11 = l10;
            l12 = l9;
            i4 = l3;
            j4 = k3;
            k4 = j3;
            i5 = l2;
            j5 = byte1;
            k5 = k2;
            l5 = j2;
            i6 = i2;
            s10 = s2;
            s11 = s1;
            j6 = l1;
            k6 = k1;
            l6 = j1;
            i7 = i1;
            s12 = s;
            flag8 = flag7;
            j7 = byte0;
            k7 = l;
            s13 = ((String) (obj));
            flag9 = flag6;
            flag10 = flag5;
            flag3 = flag4;
            l13 = l8;
            l7 = ((flag2) ? 1 : 0);
            i8 = ((flag1) ? 1 : 0);
            j8 = ((flag) ? 1 : 0);
            i = k;
            k8 = j;
        } else
        if ("followingCount".equals(s15))
        {
            i5 = jsonparser.getIntValue();
            obj1 = s6;
            s7 = s5;
            s8 = s4;
            s9 = s3;
            l11 = l10;
            l12 = l9;
            i4 = l3;
            j4 = k3;
            k4 = j3;
            l4 = i3;
            j5 = byte1;
            k5 = k2;
            l5 = j2;
            i6 = i2;
            s10 = s2;
            s11 = s1;
            j6 = l1;
            k6 = k1;
            l6 = j1;
            i7 = i1;
            s12 = s;
            flag8 = flag7;
            j7 = byte0;
            k7 = l;
            s13 = ((String) (obj));
            flag9 = flag6;
            flag10 = flag5;
            flag3 = flag4;
            l13 = l8;
            l7 = ((flag2) ? 1 : 0);
            i8 = ((flag1) ? 1 : 0);
            j8 = ((flag) ? 1 : 0);
            i = k;
            k8 = j;
        } else
        if ("following".equals(s15))
        {
            j5 = jsonparser.getIntValue();
            obj1 = s6;
            s7 = s5;
            s8 = s4;
            s9 = s3;
            l11 = l10;
            l12 = l9;
            i4 = l3;
            j4 = k3;
            k4 = j3;
            l4 = i3;
            i5 = l2;
            k5 = k2;
            l5 = j2;
            i6 = i2;
            s10 = s2;
            s11 = s1;
            j6 = l1;
            k6 = k1;
            l6 = j1;
            i7 = i1;
            s12 = s;
            flag8 = flag7;
            j7 = byte0;
            k7 = l;
            s13 = ((String) (obj));
            flag9 = flag6;
            flag10 = flag5;
            flag3 = flag4;
            l13 = l8;
            l7 = ((flag2) ? 1 : 0);
            i8 = ((flag1) ? 1 : 0);
            j8 = ((flag) ? 1 : 0);
            i = k;
            k8 = j;
        } else
        if ("likeCount".equals(s15))
        {
            k5 = jsonparser.getIntValue();
            obj1 = s6;
            s7 = s5;
            s8 = s4;
            s9 = s3;
            l11 = l10;
            l12 = l9;
            i4 = l3;
            j4 = k3;
            k4 = j3;
            l4 = i3;
            i5 = l2;
            j5 = byte1;
            l5 = j2;
            i6 = i2;
            s10 = s2;
            s11 = s1;
            j6 = l1;
            k6 = k1;
            l6 = j1;
            i7 = i1;
            s12 = s;
            flag8 = flag7;
            j7 = byte0;
            k7 = l;
            s13 = ((String) (obj));
            flag9 = flag6;
            flag10 = flag5;
            flag3 = flag4;
            l13 = l8;
            l7 = ((flag2) ? 1 : 0);
            i8 = ((flag1) ? 1 : 0);
            j8 = ((flag) ? 1 : 0);
            i = k;
            k8 = j;
        } else
        if ("authoredPostCount".equals(s15))
        {
            k7 = jsonparser.getIntValue();
            obj1 = s6;
            s7 = s5;
            s8 = s4;
            s9 = s3;
            l11 = l10;
            l12 = l9;
            i4 = l3;
            j4 = k3;
            k4 = j3;
            l4 = i3;
            i5 = l2;
            j5 = byte1;
            k5 = k2;
            l5 = j2;
            i6 = i2;
            s10 = s2;
            s11 = s1;
            j6 = l1;
            k6 = k1;
            l6 = j1;
            i7 = i1;
            s12 = s;
            flag8 = flag7;
            j7 = byte0;
            s13 = ((String) (obj));
            flag9 = flag6;
            flag10 = flag5;
            flag3 = flag4;
            l13 = l8;
            l7 = ((flag2) ? 1 : 0);
            i8 = ((flag1) ? 1 : 0);
            j8 = ((flag) ? 1 : 0);
            i = k;
            k8 = j;
        } else
        if ("postCount".equals(s15))
        {
            l5 = jsonparser.getIntValue();
            obj1 = s6;
            s7 = s5;
            s8 = s4;
            s9 = s3;
            l11 = l10;
            l12 = l9;
            i4 = l3;
            j4 = k3;
            k4 = j3;
            l4 = i3;
            i5 = l2;
            j5 = byte1;
            k5 = k2;
            i6 = i2;
            s10 = s2;
            s11 = s1;
            j6 = l1;
            k6 = k1;
            l6 = j1;
            i7 = i1;
            s12 = s;
            flag8 = flag7;
            j7 = byte0;
            k7 = l;
            s13 = ((String) (obj));
            flag9 = flag6;
            flag10 = flag5;
            flag3 = flag4;
            l13 = l8;
            l7 = ((flag2) ? 1 : 0);
            i8 = ((flag1) ? 1 : 0);
            j8 = ((flag) ? 1 : 0);
            i = k;
            k8 = j;
        } else
        if ("verified".equals(s15))
        {
            i6 = jsonparser.getIntValue();
            obj1 = s6;
            s7 = s5;
            s8 = s4;
            s9 = s3;
            l11 = l10;
            l12 = l9;
            i4 = l3;
            j4 = k3;
            k4 = j3;
            l4 = i3;
            i5 = l2;
            j5 = byte1;
            k5 = k2;
            l5 = j2;
            s10 = s2;
            s11 = s1;
            j6 = l1;
            k6 = k1;
            l6 = j1;
            i7 = i1;
            s12 = s;
            flag8 = flag7;
            j7 = byte0;
            k7 = l;
            s13 = ((String) (obj));
            flag9 = flag6;
            flag10 = flag5;
            flag3 = flag4;
            l13 = l8;
            l7 = ((flag2) ? 1 : 0);
            i8 = ((flag1) ? 1 : 0);
            j8 = ((flag) ? 1 : 0);
            i = k;
            k8 = j;
        } else
        if ("followId".equals(s15))
        {
            l12 = jsonparser.getLongValue();
            obj1 = s6;
            s7 = s5;
            s8 = s4;
            s9 = s3;
            l11 = l10;
            i4 = l3;
            j4 = k3;
            k4 = j3;
            l4 = i3;
            i5 = l2;
            j5 = byte1;
            k5 = k2;
            l5 = j2;
            i6 = i2;
            s10 = s2;
            s11 = s1;
            j6 = l1;
            k6 = k1;
            l6 = j1;
            i7 = i1;
            s12 = s;
            flag8 = flag7;
            j7 = byte0;
            k7 = l;
            s13 = ((String) (obj));
            flag9 = flag6;
            flag10 = flag5;
            flag3 = flag4;
            l13 = l8;
            l7 = ((flag2) ? 1 : 0);
            i8 = ((flag1) ? 1 : 0);
            j8 = ((flag) ? 1 : 0);
            i = k;
            k8 = j;
        } else
        if ("twitterConnected".equals(s15))
        {
            j6 = jsonparser.getIntValue();
            obj1 = s6;
            s7 = s5;
            s8 = s4;
            s9 = s3;
            l11 = l10;
            l12 = l9;
            i4 = l3;
            j4 = k3;
            k4 = j3;
            l4 = i3;
            i5 = l2;
            j5 = byte1;
            k5 = k2;
            l5 = j2;
            i6 = i2;
            s10 = s2;
            s11 = s1;
            k6 = k1;
            l6 = j1;
            i7 = i1;
            s12 = s;
            flag8 = flag7;
            j7 = byte0;
            k7 = l;
            s13 = ((String) (obj));
            flag9 = flag6;
            flag10 = flag5;
            flag3 = flag4;
            l13 = l8;
            l7 = ((flag2) ? 1 : 0);
            i8 = ((flag1) ? 1 : 0);
            j8 = ((flag) ? 1 : 0);
            i = k;
            k8 = j;
        } else
        if ("includePromoted".equals(s15))
        {
            k6 = jsonparser.getIntValue();
            obj1 = s6;
            s7 = s5;
            s8 = s4;
            s9 = s3;
            l11 = l10;
            l12 = l9;
            i4 = l3;
            j4 = k3;
            k4 = j3;
            l4 = i3;
            i5 = l2;
            j5 = byte1;
            k5 = k2;
            l5 = j2;
            i6 = i2;
            s10 = s2;
            s11 = s1;
            j6 = l1;
            l6 = j1;
            i7 = i1;
            s12 = s;
            flag8 = flag7;
            j7 = byte0;
            k7 = l;
            s13 = ((String) (obj));
            flag9 = flag6;
            flag10 = flag5;
            flag3 = flag4;
            l13 = l8;
            l7 = ((flag2) ? 1 : 0);
            i8 = ((flag1) ? 1 : 0);
            j8 = ((flag) ? 1 : 0);
            i = k;
            k8 = j;
        } else
        if ("private".equals(s15))
        {
            l6 = jsonparser.getIntValue();
            obj1 = s6;
            s7 = s5;
            s8 = s4;
            s9 = s3;
            l11 = l10;
            l12 = l9;
            i4 = l3;
            j4 = k3;
            k4 = j3;
            l4 = i3;
            i5 = l2;
            j5 = byte1;
            k5 = k2;
            l5 = j2;
            i6 = i2;
            s10 = s2;
            s11 = s1;
            j6 = l1;
            k6 = k1;
            i7 = i1;
            s12 = s;
            flag8 = flag7;
            j7 = byte0;
            k7 = l;
            s13 = ((String) (obj));
            flag9 = flag6;
            flag10 = flag5;
            flag3 = flag4;
            l13 = l8;
            l7 = ((flag2) ? 1 : 0);
            i8 = ((flag1) ? 1 : 0);
            j8 = ((flag) ? 1 : 0);
            i = k;
            k8 = j;
        } else
        if ("followApprovalPending".equals(s15))
        {
            if (jsonparser.getIntValue() == 1)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            obj1 = s6;
            s7 = s5;
            s8 = s4;
            s9 = s3;
            l11 = l10;
            l12 = l9;
            i4 = l3;
            j4 = k3;
            k4 = j3;
            l4 = i3;
            i5 = l2;
            j5 = byte1;
            k5 = k2;
            l5 = j2;
            i6 = i2;
            s10 = s2;
            s11 = s1;
            j6 = l1;
            k6 = k1;
            l6 = j1;
            i7 = i1;
            s12 = s;
            flag8 = flag7;
            j7 = byte0;
            k7 = l;
            s13 = ((String) (obj));
            flag9 = flag6;
            flag10 = flag5;
            flag3 = flag4;
            l13 = l8;
            l7 = ((flag2) ? 1 : 0);
            i8 = i;
            j8 = ((flag) ? 1 : 0);
            i = k;
            k8 = j;
        } else
        if ("followRequested".equals(s15))
        {
            if (jsonparser.getIntValue() == 1)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            obj1 = s6;
            s7 = s5;
            s8 = s4;
            s9 = s3;
            l11 = l10;
            l12 = l9;
            i4 = l3;
            j4 = k3;
            k4 = j3;
            l4 = i3;
            i5 = l2;
            j5 = byte1;
            k5 = k2;
            l5 = j2;
            i6 = i2;
            s10 = s2;
            s11 = s1;
            j6 = l1;
            k6 = k1;
            l6 = j1;
            i7 = i1;
            s12 = s;
            flag8 = flag7;
            j7 = byte0;
            k7 = l;
            s13 = ((String) (obj));
            flag9 = flag6;
            flag10 = flag5;
            flag3 = flag4;
            l13 = l8;
            l7 = ((flag2) ? 1 : 0);
            i8 = ((flag1) ? 1 : 0);
            j8 = i;
            i = k;
            k8 = j;
        } else
        if ("repostsEnabled".equals(s15))
        {
            i7 = jsonparser.getIntValue();
            obj1 = s6;
            s7 = s5;
            s8 = s4;
            s9 = s3;
            l11 = l10;
            l12 = l9;
            i4 = l3;
            j4 = k3;
            k4 = j3;
            l4 = i3;
            i5 = l2;
            j5 = byte1;
            k5 = k2;
            l5 = j2;
            i6 = i2;
            s10 = s2;
            s11 = s1;
            j6 = l1;
            k6 = k1;
            l6 = j1;
            s12 = s;
            flag8 = flag7;
            j7 = byte0;
            k7 = l;
            s13 = ((String) (obj));
            flag9 = flag6;
            flag10 = flag5;
            flag3 = flag4;
            l13 = l8;
            l7 = ((flag2) ? 1 : 0);
            i8 = ((flag1) ? 1 : 0);
            j8 = ((flag) ? 1 : 0);
            i = k;
            k8 = j;
        } else
        if ("verifiedEmail".equals(s15))
        {
            if (jsonparser.getIntValue() == 1)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            obj1 = s6;
            s7 = s5;
            s8 = s4;
            s9 = s3;
            l11 = l10;
            l12 = l9;
            i4 = l3;
            j4 = k3;
            k4 = j3;
            l4 = i3;
            i5 = l2;
            j5 = byte1;
            k5 = k2;
            l5 = j2;
            i6 = i2;
            s10 = s2;
            s11 = s1;
            j6 = l1;
            k6 = k1;
            l6 = j1;
            i7 = i1;
            s12 = s;
            flag8 = flag7;
            j7 = byte0;
            k7 = l;
            s13 = ((String) (obj));
            flag9 = flag6;
            flag10 = flag5;
            flag3 = flag4;
            l13 = l8;
            l7 = i;
            i8 = ((flag1) ? 1 : 0);
            j8 = ((flag) ? 1 : 0);
            i = k;
            k8 = j;
        } else
        if ("verifiedPhoneNumber".equals(s15))
        {
            if (jsonparser.getIntValue() == 1)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            obj1 = s6;
            s7 = s5;
            s8 = s4;
            s9 = s3;
            l11 = l10;
            l12 = l9;
            i4 = l3;
            j4 = k3;
            k4 = j3;
            l4 = i3;
            i5 = l2;
            j5 = byte1;
            k5 = k2;
            l5 = j2;
            i6 = i2;
            s10 = s2;
            s11 = s1;
            j6 = l1;
            k6 = k1;
            l6 = j1;
            i7 = i1;
            s12 = s;
            flag8 = flag7;
            j7 = byte0;
            k7 = l;
            s13 = ((String) (obj));
            flag9 = flag6;
            flag10 = flag5;
            flag3 = flag4;
            l13 = l8;
            l7 = ((flag2) ? 1 : 0);
            i8 = ((flag1) ? 1 : 0);
            j8 = ((flag) ? 1 : 0);
            k8 = j;
        } else
        if ("sectionId".equals(s15))
        {
            k8 = jsonparser.getIntValue();
            obj1 = s6;
            s7 = s5;
            s8 = s4;
            s9 = s3;
            l11 = l10;
            l12 = l9;
            i4 = l3;
            j4 = k3;
            k4 = j3;
            l4 = i3;
            i5 = l2;
            j5 = byte1;
            k5 = k2;
            l5 = j2;
            i6 = i2;
            s10 = s2;
            s11 = s1;
            j6 = l1;
            k6 = k1;
            l6 = j1;
            i7 = i1;
            s12 = s;
            flag8 = flag7;
            j7 = byte0;
            k7 = l;
            s13 = ((String) (obj));
            flag9 = flag6;
            flag10 = flag5;
            flag3 = flag4;
            l13 = l8;
            l7 = ((flag2) ? 1 : 0);
            i8 = ((flag1) ? 1 : 0);
            j8 = ((flag) ? 1 : 0);
            i = k;
        } else
        if ("disableAddressBook".equals(s15))
        {
            if (jsonparser.getIntValue() == 1)
            {
                flag3 = true;
            } else
            {
                flag3 = false;
            }
            obj1 = s6;
            s7 = s5;
            s8 = s4;
            s9 = s3;
            l11 = l10;
            l12 = l9;
            i4 = l3;
            j4 = k3;
            k4 = j3;
            l4 = i3;
            i5 = l2;
            j5 = byte1;
            k5 = k2;
            l5 = j2;
            i6 = i2;
            s10 = s2;
            s11 = s1;
            j6 = l1;
            k6 = k1;
            l6 = j1;
            i7 = i1;
            s12 = s;
            flag8 = flag7;
            j7 = byte0;
            k7 = l;
            s13 = ((String) (obj));
            flag9 = flag3;
            flag10 = flag5;
            flag3 = flag4;
            l13 = l8;
            l7 = ((flag2) ? 1 : 0);
            i8 = ((flag1) ? 1 : 0);
            j8 = ((flag) ? 1 : 0);
            i = k;
            k8 = j;
        } else
        if ("acceptsOutOfNetworkConversations".equals(s15))
        {
            if (jsonparser.getIntValue() == 1)
            {
                flag3 = true;
            } else
            {
                flag3 = false;
            }
            obj1 = s6;
            s7 = s5;
            s8 = s4;
            s9 = s3;
            l11 = l10;
            l12 = l9;
            i4 = l3;
            j4 = k3;
            k4 = j3;
            l4 = i3;
            i5 = l2;
            j5 = byte1;
            k5 = k2;
            l5 = j2;
            i6 = i2;
            s10 = s2;
            s11 = s1;
            j6 = l1;
            k6 = k1;
            l6 = j1;
            i7 = i1;
            s12 = s;
            flag8 = flag3;
            j7 = byte0;
            k7 = l;
            s13 = ((String) (obj));
            flag9 = flag6;
            flag10 = flag5;
            flag3 = flag4;
            l13 = l8;
            l7 = ((flag2) ? 1 : 0);
            i8 = ((flag1) ? 1 : 0);
            j8 = ((flag) ? 1 : 0);
            i = k;
            k8 = j;
        } else
        if ("hiddenEmail".equals(s15))
        {
            if (jsonparser.getIntValue() == 1)
            {
                flag3 = true;
            } else
            {
                flag3 = false;
            }
            obj1 = s6;
            s7 = s5;
            s8 = s4;
            s9 = s3;
            l11 = l10;
            l12 = l9;
            i4 = l3;
            j4 = k3;
            k4 = j3;
            l4 = i3;
            i5 = l2;
            j5 = byte1;
            k5 = k2;
            l5 = j2;
            i6 = i2;
            s10 = s2;
            s11 = s1;
            j6 = l1;
            k6 = k1;
            l6 = j1;
            i7 = i1;
            s12 = s;
            flag8 = flag7;
            j7 = byte0;
            k7 = l;
            s13 = ((String) (obj));
            flag9 = flag6;
            flag10 = flag3;
            flag3 = flag4;
            l13 = l8;
            l7 = ((flag2) ? 1 : 0);
            i8 = ((flag1) ? 1 : 0);
            j8 = ((flag) ? 1 : 0);
            i = k;
            k8 = j;
        } else
        if ("hiddenPhoneNumber".equals(s15))
        {
            if (jsonparser.getIntValue() == 1)
            {
                flag3 = true;
            } else
            {
                flag3 = false;
            }
            obj1 = s6;
            s7 = s5;
            s8 = s4;
            s9 = s3;
            l11 = l10;
            l12 = l9;
            i4 = l3;
            j4 = k3;
            k4 = j3;
            l4 = i3;
            i5 = l2;
            j5 = byte1;
            k5 = k2;
            l5 = j2;
            i6 = i2;
            s10 = s2;
            s11 = s1;
            j6 = l1;
            k6 = k1;
            l6 = j1;
            i7 = i1;
            s12 = s;
            flag8 = flag7;
            j7 = byte0;
            k7 = l;
            s13 = ((String) (obj));
            flag9 = flag6;
            flag10 = flag5;
            l13 = l8;
            l7 = ((flag2) ? 1 : 0);
            i8 = ((flag1) ? 1 : 0);
            j8 = ((flag) ? 1 : 0);
            i = k;
            k8 = j;
        } else
        {
            obj1 = s6;
            s7 = s5;
            s8 = s4;
            s9 = s3;
            l11 = l10;
            l12 = l9;
            i4 = l3;
            j4 = k3;
            k4 = j3;
            l4 = i3;
            i5 = l2;
            j5 = byte1;
            k5 = k2;
            l5 = j2;
            i6 = i2;
            s10 = s2;
            s11 = s1;
            j6 = l1;
            k6 = k1;
            l6 = j1;
            i7 = i1;
            s12 = s;
            flag8 = flag7;
            j7 = byte0;
            k7 = l;
            s13 = ((String) (obj));
            flag9 = flag6;
            flag10 = flag5;
            flag3 = flag4;
            l13 = l8;
            l7 = ((flag2) ? 1 : 0);
            i8 = ((flag1) ? 1 : 0);
            j8 = ((flag) ? 1 : 0);
            i = k;
            k8 = j;
            if ("loopCount".equals(s15))
            {
                l13 = jsonparser.getLongValue();
                obj1 = s6;
                s7 = s5;
                s8 = s4;
                s9 = s3;
                l11 = l10;
                l12 = l9;
                i4 = l3;
                j4 = k3;
                k4 = j3;
                l4 = i3;
                i5 = l2;
                j5 = byte1;
                k5 = k2;
                l5 = j2;
                i6 = i2;
                s10 = s2;
                s11 = s1;
                j6 = l1;
                k6 = k1;
                l6 = j1;
                i7 = i1;
                s12 = s;
                flag8 = flag7;
                j7 = byte0;
                k7 = l;
                s13 = ((String) (obj));
                flag9 = flag6;
                flag10 = flag5;
                flag3 = flag4;
                l7 = ((flag2) ? 1 : 0);
                i8 = ((flag1) ? 1 : 0);
                j8 = ((flag) ? 1 : 0);
                i = k;
                k8 = j;
            }
        }
          goto _L7
        jsonparser.skipChildren();
        obj1 = s6;
        s7 = s5;
        s8 = s4;
        s9 = s3;
        l11 = l10;
        l12 = l9;
        i4 = l3;
        j4 = k3;
        k4 = j3;
        l4 = i3;
        i5 = l2;
        j5 = byte1;
        k5 = k2;
        l5 = j2;
        i6 = i2;
        s10 = s2;
        s11 = s1;
        j6 = l1;
        k6 = k1;
        l6 = j1;
        i7 = i1;
        s12 = s;
        flag8 = flag7;
        j7 = byte0;
        k7 = l;
        s13 = ((String) (obj));
        flag9 = flag6;
        flag10 = flag5;
        flag3 = flag4;
        l13 = l8;
        l7 = ((flag2) ? 1 : 0);
        i8 = ((flag1) ? 1 : 0);
        j8 = ((flag) ? 1 : 0);
        i = k;
        k8 = j;
          goto _L7
        if (l10 <= 0L)
        {
            jsonparser = null;
        } else
        {
            obj = new VineUser(s6, s5, s4, s3, l10, l9, l3, k3, j3, i3, l2, byte1, k2, j2, i2, s2, s1, l1, k1, j1, i1, s, flag7, byte0, l, ((String) (obj)), flag6, flag5, flag4, l8);
            obj.sectionId = j;
            if (flag1)
            {
                ((VineUser) (obj)).setApprovalPending();
            }
            if (flag)
            {
                ((VineUser) (obj)).setFollowRequested();
            }
            if (flag2)
            {
                ((VineUser) (obj)).setEmailVerified();
            }
            jsonparser = ((JsonParser) (obj));
            if (k != 0)
            {
                ((VineUser) (obj)).setPhoneVerified();
                return ((VineUser) (obj));
            }
        }
        return jsonparser;
    }

    private static ArrayList parseUsersArray(JsonParser jsonparser, Bundle bundle)
        throws IOException
    {
        JsonToken jsontoken1 = jsonparser.nextToken();
        ArrayList arraylist = new ArrayList();
        byte byte0 = -1;
        boolean flag = false;
        int i = byte0;
        int j = ((flag) ? 1 : 0);
        JsonToken jsontoken = jsontoken1;
        if (bundle != null)
        {
            long l1 = bundle.getLong("friend_index", -1L);
            i = byte0;
            j = ((flag) ? 1 : 0);
            jsontoken = jsontoken1;
            if (l1 >= 0L)
            {
                i = (int)(l1 >> 32);
                j = (int)((l1 - ((long)i << 32)) + 1L);
                jsontoken = jsontoken1;
            }
        }
        while (jsontoken != null && jsontoken != JsonToken.END_ARRAY) 
        {
            int i1 = i;
            int j1 = j;
            if (jsontoken == JsonToken.START_OBJECT)
            {
                bundle = parseUser(jsonparser, i);
                int l = i;
                int k = j;
                if (((VineUser) (bundle)).sectionId >= 0)
                {
                    if (i != ((VineUser) (bundle)).sectionId)
                    {
                        bundle.friendIndex = (long)((VineUser) (bundle)).sectionId << 32;
                        k = 1;
                        l = ((VineUser) (bundle)).sectionId;
                    } else
                    {
                        bundle.friendIndex = ((long)((VineUser) (bundle)).sectionId << 32) + (long)j;
                        k = j + 1;
                        l = i;
                    }
                }
                i1 = l;
                j1 = k;
                if (bundle != null)
                {
                    arraylist.add(bundle);
                    j1 = k;
                    i1 = l;
                }
            }
            jsontoken = jsonparser.nextToken();
            i = i1;
            j = j1;
        }
        return arraylist;
    }

    private static VinePostResponse parseVinePostResponse(JsonParser jsonparser)
        throws IOException
    {
        JsonToken jsontoken;
        long l;
        long l1;
        l = 0L;
        l1 = 0L;
        jsontoken = jsonparser.nextToken();
_L2:
        long l2;
        if (jsontoken == null || jsontoken == JsonToken.END_OBJECT)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        switch (_cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[jsontoken.ordinal()])
        {
        default:
            l2 = l;
            break;

        case 1: // '\001'
        case 2: // '\002'
            break MISSING_BLOCK_LABEL_119;

        case 3: // '\003'
            break; /* Loop/switch isn't completed */
        }
_L3:
        jsontoken = jsonparser.nextToken();
        l = l2;
        if (true) goto _L2; else goto _L1
_L1:
        String s = jsonparser.getCurrentName();
        if ("postId".equals(s))
        {
            l2 = jsonparser.getLongValue();
        } else
        {
            l2 = l;
            if ("createdAt".equals(s))
            {
                l1 = jsonparser.getLongValue();
                l2 = l;
            }
        }
          goto _L3
        jsonparser.skipChildren();
        l2 = l;
          goto _L3
        return new VinePostResponse(l, l1);
    }

    public static Object parseVineResponse(JsonParser jsonparser, int i, Bundle bundle)
        throws IOException
    {
        JsonToken jsontoken;
        if (i == 16)
        {
            return null;
        }
        if (i == 15)
        {
            return parseServerStatus(jsonparser);
        }
        if (i == 1)
        {
            return parseGeneral(jsonparser);
        }
        jsontoken = jsonparser.nextToken();
_L6:
        if (jsontoken == null || jsontoken == JsonToken.END_OBJECT)
        {
            break MISSING_BLOCK_LABEL_507;
        }
        _cls13..SwitchMap.com.fasterxml.jackson.core.JsonToken[jsontoken.ordinal()];
        JVM INSTR tableswitch 1 3: default 80
    //                   1 88
    //                   2 392
    //                   3 464;
           goto _L1 _L2 _L3 _L4
_L4:
        break MISSING_BLOCK_LABEL_464;
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        break; /* Loop/switch isn't completed */
_L7:
        jsontoken = jsonparser.nextToken();
        if (true) goto _L6; else goto _L5
_L5:
        if ("data".equals(jsonparser.getCurrentName()))
        {
            switch (i)
            {
            case 4: // '\004'
            case 15: // '\017'
            case 16: // '\020'
            case 17: // '\021'
            case 20: // '\024'
            case 21: // '\025'
            default:
                jsonparser.skipChildren();
                break;

            case 2: // '\002'
                return parseUser(jsonparser);

            case 3: // '\003'
                return parsePagedData(jsonparser, USERS_PARSER, bundle);

            case 13: // '\r'
                return parseClientProfile(jsonparser);

            case 5: // '\005'
                return parseSignUp(jsonparser);

            case 6: // '\006'
                return parsePagedData(jsonparser, COMMENT_PARSER);

            case 8: // '\b'
                return parsePagedData(jsonparser, POST_PARSER);

            case 7: // '\007'
                return parseComment(jsonparser);

            case 9: // '\t'
                return parsePagedData(jsonparser, ACTIVITY_PARSER);

            case 28: // '\034'
                return parsePagedData(jsonparser, GROUPED_ACTIVITY_PARSER);

            case 10: // '\n'
                return parseLikeId(jsonparser);

            case 11: // '\013'
                return parsePagedData(jsonparser, LIKES_PARSER);

            case 12: // '\f'
                return parseVinePostResponse(jsonparser);

            case 24: // '\030'
                return parsePrivateMessageResponse(jsonparser);

            case 14: // '\016'
                return parsePagedData(jsonparser, TAG_PARSER);

            case 18: // '\022'
                return parsePagedData(jsonparser, CHANNELS_PARSER);

            case 19: // '\023'
                return parseRepostResponse(jsonparser);

            case 25: // '\031'
                return parsePagedInbox(jsonparser, CONVERSATIONS_PARSER, USER_PARSER);

            case 23: // '\027'
                return parsePrivateMessage(jsonparser);

            case 22: // '\026'
                return parsePagedConversation(jsonparser, MESSAGES_PARSER);

            case 26: // '\032'
                return parseActivityCounts(jsonparser);

            case 27: // '\033'
                return parseLoopsSubmission(jsonparser);

            case 29: // '\035'
                return parseClientFlags(jsonparser);

            case 30: // '\036'
                return parsePagedData(jsonparser, NOTIFICATION_SETTING_PARSER);
            }
        }
          goto _L7
_L3:
        if ("data".equals(jsonparser.getCurrentName()))
        {
            switch (i)
            {
            default:
                jsonparser.skipChildren();
                break;

            case 3: // '\003'
                return parseUsersArray(jsonparser, bundle);

            case 17: // '\021'
                return parseBlockedUsers(jsonparser);

            case 20: // '\024'
                return parseEditions(jsonparser);
            }
        }
          goto _L7
        if ("data".equals(jsonparser.getCurrentName()))
        {
            switch (i)
            {
            case 21: // '\025'
                return Integer.valueOf(jsonparser.getIntValue());
            }
        }
          goto _L7
        throw new IllegalArgumentException((new StringBuilder()).append("Unhandled parse type ").append(i).toString());
    }












}
