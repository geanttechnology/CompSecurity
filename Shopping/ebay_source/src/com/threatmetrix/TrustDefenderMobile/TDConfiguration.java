// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.threatmetrix.TrustDefenderMobile;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

class TDConfiguration
{

    private static final String TAG = com/threatmetrix/TrustDefenderMobile/TDConfiguration.getName();
    public final ArrayList ex_paths = new ArrayList();
    public final ArrayList jb_paths = new ArrayList();
    public int options;
    public String w;

    TDConfiguration()
    {
        options = 0;
        w = "";
    }

    private boolean parseEX(XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        Object obj;
        int i;
        i = xmlpullparser.next();
        obj = "";
_L7:
        if (i == 1)
        {
            break MISSING_BLOCK_LABEL_224;
        }
        i;
        JVM INSTR tableswitch 0 4: default 52
    //                   0 94
    //                   1 52
    //                   2 108
    //                   3 118
    //                   4 136;
           goto _L1 _L2 _L1 _L3 _L4 _L5
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        Object obj1;
        Log.d(TAG, (new StringBuilder()).append("Found unexpected event type: ").append(i).toString());
        obj1 = obj;
_L8:
        i = xmlpullparser.next();
        obj = obj1;
        if (true) goto _L7; else goto _L6
_L6:
        Log.d(TAG, "Found start document tag unexpectedly");
        obj1 = obj;
          goto _L8
_L3:
        obj1 = xmlpullparser.getName();
          goto _L8
_L4:
        obj1 = obj;
        if (!xmlpullparser.getName().equals("EX")) goto _L8; else goto _L9
_L9:
        return true;
_L5:
        obj1 = obj;
        if (obj == null) goto _L8; else goto _L10
_L10:
        if (!((String) (obj)).equals("E"))
        {
            break MISSING_BLOCK_LABEL_193;
        }
        ex_paths.add(new URI(xmlpullparser.getText()));
        obj1 = obj;
          goto _L8
        obj1;
        Log.e(TAG, "Failed to parse E into URI", ((Throwable) (obj1)));
        obj1 = obj;
          goto _L8
        Log.d(TAG, (new StringBuilder()).append("Found tag content unexpectedly: ").append(((String) (obj))).toString());
        obj1 = obj;
          goto _L8
        return false;
    }

    private boolean parsePS(XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        String s;
        int i;
        i = xmlpullparser.next();
        s = "";
_L7:
        if (i == 1)
        {
            break MISSING_BLOCK_LABEL_201;
        }
        i;
        JVM INSTR tableswitch 0 4: default 52
    //                   0 94
    //                   1 52
    //                   2 108
    //                   3 118
    //                   4 136;
           goto _L1 _L2 _L1 _L3 _L4 _L5
_L5:
        break MISSING_BLOCK_LABEL_136;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        String s1;
        Log.d(TAG, (new StringBuilder()).append("Found unexpected event type: ").append(i).toString());
        s1 = s;
_L8:
        i = xmlpullparser.next();
        s = s1;
        if (true) goto _L7; else goto _L6
_L6:
        Log.d(TAG, "Found start document tag unexpectedly");
        s1 = s;
          goto _L8
_L3:
        s1 = xmlpullparser.getName();
          goto _L8
_L4:
        s1 = s;
        if (!xmlpullparser.getName().equals("PS")) goto _L8; else goto _L9
_L9:
        return true;
        s1 = s;
        if (s != null)
        {
            if (s.equals("P"))
            {
                jb_paths.add(xmlpullparser.getText());
                s1 = s;
            } else
            {
                Log.d(TAG, (new StringBuilder()).append("Found tag content unexpectedly: ").append(s).toString());
                s1 = s;
            }
        }
          goto _L8
        return false;
    }

    public boolean isUsable()
    {
        return w != null && !w.isEmpty();
    }

    public boolean parseConfigFromStream(InputStream inputstream)
    {
        InputStream inputstream1;
        boolean flag1;
        flag1 = false;
        inputstream1 = null;
        XmlPullParser xmlpullparser;
        int i;
        xmlpullparser = XmlPullParserFactory.newInstance().newPullParser();
        xmlpullparser.setInput(new InputStreamReader(inputstream));
        i = xmlpullparser.getEventType();
          goto _L1
_L11:
        i = xmlpullparser.next();
        boolean flag;
        inputstream1 = inputstream;
        flag1 = flag;
          goto _L1
_L9:
        if (!xmlpullparser.getName().equals("PS"))
        {
            break MISSING_BLOCK_LABEL_90;
        }
        inputstream = inputstream1;
        flag = flag1;
        if (!parsePS(xmlpullparser))
        {
            flag = true;
            inputstream = inputstream1;
        }
        break; /* Loop/switch isn't completed */
        if (!xmlpullparser.getName().equals("EX"))
        {
            break MISSING_BLOCK_LABEL_126;
        }
        inputstream = inputstream1;
        flag = flag1;
        if (!parseEX(xmlpullparser))
        {
            flag = true;
            inputstream = inputstream1;
        }
        break; /* Loop/switch isn't completed */
        inputstream = xmlpullparser.getName();
        flag = flag1;
        break; /* Loop/switch isn't completed */
_L7:
        inputstream = inputstream1;
        flag = flag1;
        if (inputstream1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!inputstream1.equals("w")) goto _L3; else goto _L2
_L2:
        w = xmlpullparser.getText();
        inputstream = inputstream1;
        flag = flag1;
        break; /* Loop/switch isn't completed */
        inputstream;
        Log.e(TAG, "IO Error", inputstream);
        flag = false;
_L4:
        return !flag;
_L3:
        if (!inputstream1.equals("O"))
        {
            break MISSING_BLOCK_LABEL_250;
        }
        options = Integer.valueOf(xmlpullparser.getText()).intValue();
        inputstream = inputstream1;
        flag = flag1;
        break; /* Loop/switch isn't completed */
        inputstream;
        Log.e(TAG, "XML Parse Error", inputstream);
        flag = false;
          goto _L4
        flag = true;
        inputstream = inputstream1;
        break; /* Loop/switch isn't completed */
_L1:
        flag = flag1;
        if (i == 1) goto _L4; else goto _L5
_L5:
        inputstream = inputstream1;
        flag = flag1;
        switch (i)
        {
        default:
            inputstream = inputstream1;
            flag = flag1;
            break; /* Loop/switch isn't completed */

        case 0: // '\0'
        case 1: // '\001'
            break; /* Loop/switch isn't completed */

        case 2: // '\002'
            break;

        case 4: // '\004'
            continue; /* Loop/switch isn't completed */

        case 3: // '\003'
            inputstream = null;
            flag = flag1;
            break; /* Loop/switch isn't completed */
        }
        break; /* Loop/switch isn't completed */
        if (true) goto _L7; else goto _L6
_L6:
        if (true) goto _L9; else goto _L8
_L8:
        if (true) goto _L11; else goto _L10
_L10:
    }

}
