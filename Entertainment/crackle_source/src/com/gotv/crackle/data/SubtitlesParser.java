// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.data;

import com.gotv.crackle.model.SubtitleTimeCode;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SubtitlesParser
{
    private class DFXPHandler extends DefaultHandler
    {

        private static final String END_TIME_TYPE = "end";
        private static final String START_TIME_TYPE = "begin";
        private static final String break_TYPE = "br";
        private static final String subtitle_TYPE = "p";
        private StringBuilder buffer;
        private double endTimeCode;
        private double startTimeCode;
        public List subtitleList;
        final SubtitlesParser this$0;

        private double doubleTimeCodeFromDFXPString(String s)
        {
            String as[];
            String s3;
            String s4;
            as = s.split(":");
            s3 = as[0];
            s4 = as[1];
            s = "0";
            if (as.length != 4) goto _L2; else goto _L1
_L1:
            String s1;
            s1 = as[2];
            s = as[3];
_L4:
            return (double)(Integer.parseInt(s3) * 0x36ee80 + Integer.parseInt(s4) * 60000 + Integer.parseInt(s1) * 1000 + Integer.parseInt(s));
_L2:
            String as1[] = as[2].split("\\.");
            String s2 = as1[0];
            s1 = s2;
            if (as1.length == 2)
            {
                s = as1[1];
                s1 = s2;
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public void characters(char ac[], int i, int j)
            throws SAXException
        {
            super.characters(ac, i, j);
            buffer.append(ac, i, j);
        }

        public void endElement(String s, String s1, String s2)
            throws SAXException
        {
            super.endElement(s, s1, s2);
            if (s1.equalsIgnoreCase("p"))
            {
                s = buffer.toString().trim();
                s1 = new SubtitleTimeCode();
                s1.text = s;
                s1.timeStart = startTimeCode;
                s1.timeEnd = endTimeCode;
                subtitleList.add(s1);
                buffer.setLength(0);
            }
        }

        public void startDocument()
            throws SAXException
        {
            super.startDocument();
            buffer = new StringBuilder();
        }

        public void startElement(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            super.startElement(s, s1, s2, attributes);
            if (s1.equalsIgnoreCase("p"))
            {
                s = attributes.getValue("begin");
                s2 = attributes.getValue("end");
                startTimeCode = doubleTimeCodeFromDFXPString(s);
                endTimeCode = doubleTimeCodeFromDFXPString(s2);
            }
            if (s1.equalsIgnoreCase("br"))
            {
                buffer.append(' ');
                buffer.append(' ');
            }
        }

        private DFXPHandler()
        {
            this$0 = SubtitlesParser.this;
            super();
            subtitleList = new ArrayList();
        }

    }


    public SubtitlesParser()
    {
    }

    public List parseDFXP(String s)
        throws SAXException, IOException, ParserConfigurationException
    {
        s = new URL(s);
        SAXParser saxparser = SAXParserFactory.newInstance().newSAXParser();
        DFXPHandler dfxphandler = new DFXPHandler();
        saxparser.parse(s.openConnection().getInputStream(), dfxphandler);
        return dfxphandler.subtitleList;
    }
}
