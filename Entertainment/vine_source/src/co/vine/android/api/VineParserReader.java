// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.api;

import android.os.Bundle;
import android.util.Log;
import co.vine.android.network.HttpOperationReader;
import co.vine.android.network.HttpResult;
import com.edisonwang.android.slog.SLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package co.vine.android.api:
//            VineParsers

public class VineParserReader
    implements HttpOperationReader
{

    public static final String EXTRA_LAST_FRIEND_INDEX = "friend_index";
    public static final boolean LOGGABLE = Log.isLoggable("VineParserReader", 3);
    public static final String TAG = "VineParserReader";
    public static final int TYPE_ACTIVITY = 9;
    public static final int TYPE_ACTIVITY_COUNTS = 26;
    public static final int TYPE_BLOCKED_USERS = 17;
    public static final int TYPE_CHANNELS = 18;
    public static final int TYPE_CLIENT_FLAGS = 29;
    public static final int TYPE_CLIENT_PROFILE = 13;
    public static final int TYPE_COMMENT = 7;
    public static final int TYPE_COMMENTS = 6;
    public static final int TYPE_CONVERSATION = 22;
    public static final int TYPE_EDITIONS = 20;
    public static final int TYPE_GENERAL = 1;
    public static final int TYPE_GROUPED_ACTIVITY = 28;
    public static final int TYPE_INBOX = 25;
    public static final int TYPE_LIKE = 10;
    public static final int TYPE_LIKES = 11;
    public static final int TYPE_LOGIN = 4;
    public static final int TYPE_LOOPS_SUBMISSION = 27;
    public static final int TYPE_MESSAGE = 23;
    public static final int TYPE_NOTIFICATION_SETTINGS = 30;
    public static final int TYPE_PENDING_NOTIF_COUNT = 21;
    public static final int TYPE_POSTS = 8;
    public static final int TYPE_POST_RESPONSE = 12;
    public static final int TYPE_PRIVATE_MESSAGE_RESPONSE = 24;
    public static final int TYPE_REVINE = 19;
    public static final int TYPE_SERVER_STATUS = 15;
    public static final int TYPE_SIGN_UP = 5;
    public static final int TYPE_TAGS = 14;
    public static final int TYPE_UPLOAD = 16;
    public static final int TYPE_USER = 2;
    public static final int TYPE_USERS = 3;
    private final Bundle mBundle = new Bundle();
    private Object mParsedObject;
    private final int mType;

    private VineParserReader(int i)
    {
        mType = i;
    }

    public static VineParserReader createLoginReader()
    {
        return new VineParserReader(4);
    }

    public static VineParserReader createParserReader(int i)
    {
        return new VineParserReader(i);
    }

    public Bundle getExtraBundle()
    {
        return mBundle;
    }

    public Object getParsedObject()
    {
        return mParsedObject;
    }

    public void onHandleError(HttpResult httpresult)
    {
    }

    public void readInput(int i, int j, InputStream inputstream)
        throws IOException
    {
        Object obj;
        obj = inputstream;
        if (LOGGABLE)
        {
            obj = inputstream;
            if (SLog.sLogsOn)
            {
                obj = new ByteArrayOutputStream();
                byte abyte0[] = new byte[1024];
                do
                {
                    j = inputstream.read(abyte0);
                    if (j <= -1)
                    {
                        break;
                    }
                    ((ByteArrayOutputStream) (obj)).write(abyte0, 0, j);
                    Log.d("VineParserReader", (new StringBuilder()).append("Response: '").append(new String(abyte0, 0, j)).append("'").toString());
                } while (true);
                ((ByteArrayOutputStream) (obj)).flush();
                inputstream.close();
                obj = new ByteArrayInputStream(((ByteArrayOutputStream) (obj)).toByteArray());
            }
        }
        if (i != 200) goto _L2; else goto _L1
_L1:
        mType;
        JVM INSTR tableswitch 4 4: default 152
    //                   4 173;
           goto _L3 _L4
_L3:
        mParsedObject = VineParsers.parseVineResponse(VineParsers.createParser(((InputStream) (obj))), mType, mBundle);
_L6:
        return;
_L4:
        mParsedObject = VineParsers.parseLogin(VineParsers.createParser(((InputStream) (obj))));
        return;
_L2:
        mParsedObject = VineParsers.parseError(VineParsers.createParser(((InputStream) (obj))));
        if (LOGGABLE)
        {
            Log.d("VineParserReader", (new StringBuilder()).append("ERROR: Response with ").append(i).toString());
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

}
