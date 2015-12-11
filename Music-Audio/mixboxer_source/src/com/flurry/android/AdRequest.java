// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import com.flurry.org.apache.avro.AvroRuntimeException;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.specific.SpecificRecord;
import com.flurry.org.apache.avro.specific.SpecificRecordBase;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.flurry.android:
//            Location, AdViewContainer, TestAds

class AdRequest extends SpecificRecordBase
    implements SpecificRecord
{

    public static final Schema SCHEMA$ = (new com.flurry.org.apache.avro.Schema.Parser()).parse("{\"type\":\"record\",\"name\":\"AdRequest\",\"namespace\":\"com.flurry.android\",\"fields\":[{\"name\":\"apiKey\",\"type\":\"string\"},{\"name\":\"agentVersion\",\"type\":\"string\",\"default\":\"null\"},{\"name\":\"adSpaceName\",\"type\":\"string\"},{\"name\":\"sessionId\",\"type\":\"long\"},{\"name\":\"adReportedIds\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"AdReportedId\",\"fields\":[{\"name\":\"type\",\"type\":\"int\"},{\"name\":\"id\",\"type\":\"bytes\"}]}}},{\"name\":\"location\",\"type\":{\"type\":\"record\",\"name\":\"Location\",\"fields\":[{\"name\":\"lat\",\"type\":\"float\",\"default\":0.0},{\"name\":\"lon\",\"type\":\"float\",\"default\":0.0}]},\"default\":\"null\"},{\"name\":\"testDevice\",\"type\":\"boolean\",\"default\":false},{\"name\":\"bindings\",\"type\":{\"type\":\"array\",\"items\":\"int\"}},{\"name\":\"adViewContainer\",\"type\":{\"type\":\"record\",\"name\":\"AdViewContainer\",\"fields\":[{\"name\":\"viewWidth\",\"type\":\"int\",\"default\":0},{\"name\":\"viewHeight\",\"type\":\"int\",\"default\":0},{\"name\":\"screenWidth\",\"type\":\"int\",\"default\":0},{\"name\":\"screenHeight\",\"type\":\"int\",\"default\":0},{\"name\":\"density\",\"type\":\"float\",\"default\":1.0}]},\"default\":\"null\"},{\"name\":\"locale\",\"type\":\"string\",\"default\":\"null\"},{\"name\":\"timezone\",\"type\":\"string\",\"default\":\"null\"},{\"name\":\"osVersion\",\"type\":\"string\",\"default\":\"null\"},{\"name\":\"devicePlatform\",\"type\":\"string\",\"default\":\"null\"},{\"name\":\"testAds\",\"type\":{\"type\":\"record\",\"name\":\"TestAds\",\"fields\":[{\"name\":\"adspacePlacement\",\"type\":\"int\",\"default\":0}]},\"default\":\"null\"},{\"name\":\"keywords\",\"type\":{\"type\":\"map\",\"values\":\"string\"},\"default\":[]},{\"name\":\"refresh\",\"type\":\"boolean\",\"default\":false},{\"name\":\"canDoSKAppStore\",\"type\":\"boolean\",\"default\":false},{\"name\":\"networkStatus\",\"type\":\"int\",\"default\":1},{\"name\":\"frequencyCapInfos\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"FrequencyCapInfo\",\"fields\":[{\"name\":\"idHash\",\"type\":\"string\",\"default\":\"null\"},{\"name\":\"serveTime\",\"type\":\"long\"},{\"name\":\"expirationTime\",\"type\":\"long\"},{\"name\":\"views\",\"type\":\"int\"},{\"name\":\"newCap\",\"type\":\"int\"},{\"name\":\"previousCap\",\"type\":\"int\"},{\"name\":\"previousCapType\",\"type\":\"int\"}]}}},{\"name\":\"adTrackingEnabled\",\"type\":\"boolean\",\"default\":false},{\"name\":\"preferredLanguage\",\"type\":\"string\",\"default\":\"null\"},{\"name\":\"bcat\",\"type\":{\"type\":\"array\",\"items\":\"string\"},\"default\":[]}]}");
    public CharSequence cA;
    public List cB;
    public long ce;
    public CharSequence ch;
    public CharSequence ci;
    public CharSequence cj;
    public List ck;
    public Location cl;
    public boolean cm;
    public List cn;
    public AdViewContainer co;
    public CharSequence cp;
    public CharSequence cq;
    public CharSequence cr;
    public CharSequence cs;
    public TestAds ct;
    public Map cu;
    public boolean cv;
    public boolean cw;
    public int cx;
    public List cy;
    public boolean cz;

    AdRequest()
    {
    }

    public static Builder bt()
    {
        return new Builder();
    }

    public final void a(TestAds testads)
    {
        ct = testads;
    }

    public final void a(Boolean boolean1)
    {
        cv = boolean1.booleanValue();
    }

    public final void c(CharSequence charsequence)
    {
        cj = charsequence;
    }

    public final void c(Map map)
    {
        cu = map;
    }

    public Object get(int i)
    {
        switch (i)
        {
        default:
            throw new AvroRuntimeException("Bad index");

        case 0: // '\0'
            return ch;

        case 1: // '\001'
            return ci;

        case 2: // '\002'
            return cj;

        case 3: // '\003'
            return Long.valueOf(ce);

        case 4: // '\004'
            return ck;

        case 5: // '\005'
            return cl;

        case 6: // '\006'
            return Boolean.valueOf(cm);

        case 7: // '\007'
            return cn;

        case 8: // '\b'
            return co;

        case 9: // '\t'
            return cp;

        case 10: // '\n'
            return cq;

        case 11: // '\013'
            return cr;

        case 12: // '\f'
            return cs;

        case 13: // '\r'
            return ct;

        case 14: // '\016'
            return cu;

        case 15: // '\017'
            return Boolean.valueOf(cv);

        case 16: // '\020'
            return Boolean.valueOf(cw);

        case 17: // '\021'
            return Integer.valueOf(cx);

        case 18: // '\022'
            return cy;

        case 19: // '\023'
            return Boolean.valueOf(cz);

        case 20: // '\024'
            return cA;

        case 21: // '\025'
            return cB;
        }
    }

    public Schema getSchema()
    {
        return SCHEMA$;
    }

    public void put(int i, Object obj)
    {
        switch (i)
        {
        default:
            throw new AvroRuntimeException("Bad index");

        case 0: // '\0'
            ch = (CharSequence)obj;
            return;

        case 1: // '\001'
            ci = (CharSequence)obj;
            return;

        case 2: // '\002'
            cj = (CharSequence)obj;
            return;

        case 3: // '\003'
            ce = ((Long)obj).longValue();
            return;

        case 4: // '\004'
            ck = (List)obj;
            return;

        case 5: // '\005'
            cl = (Location)obj;
            return;

        case 6: // '\006'
            cm = ((Boolean)obj).booleanValue();
            return;

        case 7: // '\007'
            cn = (List)obj;
            return;

        case 8: // '\b'
            co = (AdViewContainer)obj;
            return;

        case 9: // '\t'
            cp = (CharSequence)obj;
            return;

        case 10: // '\n'
            cq = (CharSequence)obj;
            return;

        case 11: // '\013'
            cr = (CharSequence)obj;
            return;

        case 12: // '\f'
            cs = (CharSequence)obj;
            return;

        case 13: // '\r'
            ct = (TestAds)obj;
            return;

        case 14: // '\016'
            cu = (Map)obj;
            return;

        case 15: // '\017'
            cv = ((Boolean)obj).booleanValue();
            return;

        case 16: // '\020'
            cw = ((Boolean)obj).booleanValue();
            return;

        case 17: // '\021'
            cx = ((Integer)obj).intValue();
            return;

        case 18: // '\022'
            cy = (List)obj;
            return;

        case 19: // '\023'
            cz = ((Boolean)obj).booleanValue();
            return;

        case 20: // '\024'
            cA = (CharSequence)obj;
            return;

        case 21: // '\025'
            cB = (List)obj;
            break;
        }
    }


    private class Builder extends SpecificRecordBuilderBase
        implements RecordBuilder
    {

        private CharSequence cA;
        private List cB;
        private long ce;
        private CharSequence ch;
        private CharSequence ci;
        private CharSequence cj;
        private List ck;
        private Location cl;
        private boolean cm;
        private List cn;
        private AdViewContainer co;
        private CharSequence cp;
        private CharSequence cq;
        private CharSequence cr;
        private CharSequence cs;
        private TestAds ct;
        private Map cu;
        private boolean cv;
        private boolean cw;
        private int cx;
        private List cy;
        private boolean cz;

        public AdRequest build()
        {
            AdRequest adrequest = new AdRequest();
            if (!fieldSetFlags()[0]) goto _L2; else goto _L1
_L1:
            Object obj = ch;
_L43:
            adrequest.ch = ((CharSequence) (obj));
            if (!fieldSetFlags()[1]) goto _L4; else goto _L3
_L3:
            obj = ci;
_L44:
            adrequest.ci = ((CharSequence) (obj));
            if (!fieldSetFlags()[2]) goto _L6; else goto _L5
_L5:
            obj = cj;
_L45:
            adrequest.cj = ((CharSequence) (obj));
            if (!fieldSetFlags()[3]) goto _L8; else goto _L7
_L7:
            long l = ce;
_L46:
            adrequest.ce = l;
            if (!fieldSetFlags()[4]) goto _L10; else goto _L9
_L9:
            obj = ck;
_L47:
            adrequest.ck = ((List) (obj));
            if (!fieldSetFlags()[5]) goto _L12; else goto _L11
_L11:
            obj = cl;
_L48:
            adrequest.cl = ((Location) (obj));
            if (!fieldSetFlags()[6]) goto _L14; else goto _L13
_L13:
            boolean flag = cm;
_L49:
            adrequest.cm = flag;
            if (!fieldSetFlags()[7]) goto _L16; else goto _L15
_L15:
            obj = cn;
_L50:
            adrequest.cn = ((List) (obj));
            if (!fieldSetFlags()[8]) goto _L18; else goto _L17
_L17:
            obj = co;
_L51:
            adrequest.co = ((AdViewContainer) (obj));
            if (!fieldSetFlags()[9]) goto _L20; else goto _L19
_L19:
            obj = cp;
_L52:
            adrequest.cp = ((CharSequence) (obj));
            if (!fieldSetFlags()[10]) goto _L22; else goto _L21
_L21:
            obj = cq;
_L53:
            adrequest.cq = ((CharSequence) (obj));
            if (!fieldSetFlags()[11]) goto _L24; else goto _L23
_L23:
            obj = cr;
_L54:
            adrequest.cr = ((CharSequence) (obj));
            if (!fieldSetFlags()[12]) goto _L26; else goto _L25
_L25:
            obj = cs;
_L55:
            adrequest.cs = ((CharSequence) (obj));
            if (!fieldSetFlags()[13]) goto _L28; else goto _L27
_L27:
            obj = ct;
_L56:
            adrequest.ct = ((TestAds) (obj));
            if (!fieldSetFlags()[14]) goto _L30; else goto _L29
_L29:
            obj = cu;
_L57:
            adrequest.cu = ((Map) (obj));
            if (!fieldSetFlags()[15]) goto _L32; else goto _L31
_L31:
            flag = cv;
_L58:
            adrequest.cv = flag;
            if (!fieldSetFlags()[16]) goto _L34; else goto _L33
_L33:
            flag = cw;
_L59:
            adrequest.cw = flag;
            if (!fieldSetFlags()[17]) goto _L36; else goto _L35
_L35:
            int i = cx;
_L60:
            adrequest.cx = i;
            if (!fieldSetFlags()[18]) goto _L38; else goto _L37
_L37:
            obj = cy;
_L61:
            adrequest.cy = ((List) (obj));
            if (!fieldSetFlags()[19]) goto _L40; else goto _L39
_L39:
            flag = cz;
_L62:
            adrequest.cz = flag;
            if (!fieldSetFlags()[20]) goto _L42; else goto _L41
_L41:
            obj = cA;
_L63:
            adrequest.cA = ((CharSequence) (obj));
            if (!fieldSetFlags()[21])
            {
                break MISSING_BLOCK_LABEL_849;
            }
            obj = cB;
_L64:
            adrequest.cB = ((List) (obj));
            return adrequest;
_L2:
            try
            {
                obj = (CharSequence)defaultValue(fields()[0]);
            }
            catch (Exception exception)
            {
                throw new AvroRuntimeException(exception);
            }
              goto _L43
_L4:
            obj = (CharSequence)defaultValue(fields()[1]);
              goto _L44
_L6:
            obj = (CharSequence)defaultValue(fields()[2]);
              goto _L45
_L8:
            l = ((Long)defaultValue(fields()[3])).longValue();
              goto _L46
_L10:
            obj = (List)defaultValue(fields()[4]);
              goto _L47
_L12:
            obj = (Location)defaultValue(fields()[5]);
              goto _L48
_L14:
            flag = ((Boolean)defaultValue(fields()[6])).booleanValue();
              goto _L49
_L16:
            obj = (List)defaultValue(fields()[7]);
              goto _L50
_L18:
            obj = (AdViewContainer)defaultValue(fields()[8]);
              goto _L51
_L20:
            obj = (CharSequence)defaultValue(fields()[9]);
              goto _L52
_L22:
            obj = (CharSequence)defaultValue(fields()[10]);
              goto _L53
_L24:
            obj = (CharSequence)defaultValue(fields()[11]);
              goto _L54
_L26:
            obj = (CharSequence)defaultValue(fields()[12]);
              goto _L55
_L28:
            obj = (TestAds)defaultValue(fields()[13]);
              goto _L56
_L30:
            obj = (Map)defaultValue(fields()[14]);
              goto _L57
_L32:
            flag = ((Boolean)defaultValue(fields()[15])).booleanValue();
              goto _L58
_L34:
            flag = ((Boolean)defaultValue(fields()[16])).booleanValue();
              goto _L59
_L36:
            i = ((Integer)defaultValue(fields()[17])).intValue();
              goto _L60
_L38:
            obj = (List)defaultValue(fields()[18]);
              goto _L61
_L40:
            flag = ((Boolean)defaultValue(fields()[19])).booleanValue();
              goto _L62
_L42:
            obj = (CharSequence)defaultValue(fields()[20]);
              goto _L63
            obj = (List)defaultValue(fields()[21]);
              goto _L64
        }

        public volatile Object build()
        {
            return build();
        }

        public Builder clearAdReportedIds()
        {
            ck = null;
            fieldSetFlags()[4] = false;
            return this;
        }

        public Builder clearAdSpaceName()
        {
            cj = null;
            fieldSetFlags()[2] = false;
            return this;
        }

        public Builder clearAdTrackingEnabled()
        {
            fieldSetFlags()[19] = false;
            return this;
        }

        public Builder clearAdViewContainer()
        {
            co = null;
            fieldSetFlags()[8] = false;
            return this;
        }

        public Builder clearAgentVersion()
        {
            ci = null;
            fieldSetFlags()[1] = false;
            return this;
        }

        public Builder clearApiKey()
        {
            ch = null;
            fieldSetFlags()[0] = false;
            return this;
        }

        public Builder clearBcat()
        {
            cB = null;
            fieldSetFlags()[21] = false;
            return this;
        }

        public Builder clearBindings()
        {
            cn = null;
            fieldSetFlags()[7] = false;
            return this;
        }

        public Builder clearCanDoSKAppStore()
        {
            fieldSetFlags()[16] = false;
            return this;
        }

        public Builder clearDevicePlatform()
        {
            cs = null;
            fieldSetFlags()[12] = false;
            return this;
        }

        public Builder clearFrequencyCapInfos()
        {
            cy = null;
            fieldSetFlags()[18] = false;
            return this;
        }

        public Builder clearKeywords()
        {
            cu = null;
            fieldSetFlags()[14] = false;
            return this;
        }

        public Builder clearLocale()
        {
            cp = null;
            fieldSetFlags()[9] = false;
            return this;
        }

        public Builder clearLocation()
        {
            cl = null;
            fieldSetFlags()[5] = false;
            return this;
        }

        public Builder clearNetworkStatus()
        {
            fieldSetFlags()[17] = false;
            return this;
        }

        public Builder clearOsVersion()
        {
            cr = null;
            fieldSetFlags()[11] = false;
            return this;
        }

        public Builder clearPreferredLanguage()
        {
            cA = null;
            fieldSetFlags()[20] = false;
            return this;
        }

        public Builder clearRefresh()
        {
            fieldSetFlags()[15] = false;
            return this;
        }

        public Builder clearSessionId()
        {
            fieldSetFlags()[3] = false;
            return this;
        }

        public Builder clearTestAds()
        {
            ct = null;
            fieldSetFlags()[13] = false;
            return this;
        }

        public Builder clearTestDevice()
        {
            fieldSetFlags()[6] = false;
            return this;
        }

        public Builder clearTimezone()
        {
            cq = null;
            fieldSetFlags()[10] = false;
            return this;
        }

        public List getAdReportedIds()
        {
            return ck;
        }

        public CharSequence getAdSpaceName()
        {
            return cj;
        }

        public Boolean getAdTrackingEnabled()
        {
            return Boolean.valueOf(cz);
        }

        public AdViewContainer getAdViewContainer()
        {
            return co;
        }

        public CharSequence getAgentVersion()
        {
            return ci;
        }

        public CharSequence getApiKey()
        {
            return ch;
        }

        public List getBcat()
        {
            return cB;
        }

        public List getBindings()
        {
            return cn;
        }

        public Boolean getCanDoSKAppStore()
        {
            return Boolean.valueOf(cw);
        }

        public CharSequence getDevicePlatform()
        {
            return cs;
        }

        public List getFrequencyCapInfos()
        {
            return cy;
        }

        public Map getKeywords()
        {
            return cu;
        }

        public CharSequence getLocale()
        {
            return cp;
        }

        public Location getLocation()
        {
            return cl;
        }

        public Integer getNetworkStatus()
        {
            return Integer.valueOf(cx);
        }

        public CharSequence getOsVersion()
        {
            return cr;
        }

        public CharSequence getPreferredLanguage()
        {
            return cA;
        }

        public Boolean getRefresh()
        {
            return Boolean.valueOf(cv);
        }

        public Long getSessionId()
        {
            return Long.valueOf(ce);
        }

        public TestAds getTestAds()
        {
            return ct;
        }

        public Boolean getTestDevice()
        {
            return Boolean.valueOf(cm);
        }

        public CharSequence getTimezone()
        {
            return cq;
        }

        public boolean hasAdReportedIds()
        {
            return fieldSetFlags()[4];
        }

        public boolean hasAdSpaceName()
        {
            return fieldSetFlags()[2];
        }

        public boolean hasAdTrackingEnabled()
        {
            return fieldSetFlags()[19];
        }

        public boolean hasAdViewContainer()
        {
            return fieldSetFlags()[8];
        }

        public boolean hasAgentVersion()
        {
            return fieldSetFlags()[1];
        }

        public boolean hasApiKey()
        {
            return fieldSetFlags()[0];
        }

        public boolean hasBcat()
        {
            return fieldSetFlags()[21];
        }

        public boolean hasBindings()
        {
            return fieldSetFlags()[7];
        }

        public boolean hasCanDoSKAppStore()
        {
            return fieldSetFlags()[16];
        }

        public boolean hasDevicePlatform()
        {
            return fieldSetFlags()[12];
        }

        public boolean hasFrequencyCapInfos()
        {
            return fieldSetFlags()[18];
        }

        public boolean hasKeywords()
        {
            return fieldSetFlags()[14];
        }

        public boolean hasLocale()
        {
            return fieldSetFlags()[9];
        }

        public boolean hasLocation()
        {
            return fieldSetFlags()[5];
        }

        public boolean hasNetworkStatus()
        {
            return fieldSetFlags()[17];
        }

        public boolean hasOsVersion()
        {
            return fieldSetFlags()[11];
        }

        public boolean hasPreferredLanguage()
        {
            return fieldSetFlags()[20];
        }

        public boolean hasRefresh()
        {
            return fieldSetFlags()[15];
        }

        public boolean hasSessionId()
        {
            return fieldSetFlags()[3];
        }

        public boolean hasTestAds()
        {
            return fieldSetFlags()[13];
        }

        public boolean hasTestDevice()
        {
            return fieldSetFlags()[6];
        }

        public boolean hasTimezone()
        {
            return fieldSetFlags()[10];
        }

        public Builder setAdReportedIds(List list)
        {
            validate(fields()[4], list);
            ck = list;
            fieldSetFlags()[4] = true;
            return this;
        }

        public Builder setAdSpaceName(CharSequence charsequence)
        {
            validate(fields()[2], charsequence);
            cj = charsequence;
            fieldSetFlags()[2] = true;
            return this;
        }

        public Builder setAdTrackingEnabled(boolean flag)
        {
            validate(fields()[19], Boolean.valueOf(flag));
            cz = flag;
            fieldSetFlags()[19] = true;
            return this;
        }

        public Builder setAdViewContainer(AdViewContainer adviewcontainer)
        {
            validate(fields()[8], adviewcontainer);
            co = adviewcontainer;
            fieldSetFlags()[8] = true;
            return this;
        }

        public Builder setAgentVersion(CharSequence charsequence)
        {
            validate(fields()[1], charsequence);
            ci = charsequence;
            fieldSetFlags()[1] = true;
            return this;
        }

        public Builder setApiKey(CharSequence charsequence)
        {
            validate(fields()[0], charsequence);
            ch = charsequence;
            fieldSetFlags()[0] = true;
            return this;
        }

        public Builder setBcat(List list)
        {
            validate(fields()[21], list);
            cB = list;
            fieldSetFlags()[21] = true;
            return this;
        }

        public Builder setBindings(List list)
        {
            validate(fields()[7], list);
            cn = list;
            fieldSetFlags()[7] = true;
            return this;
        }

        public Builder setCanDoSKAppStore(boolean flag)
        {
            validate(fields()[16], Boolean.valueOf(flag));
            cw = flag;
            fieldSetFlags()[16] = true;
            return this;
        }

        public Builder setDevicePlatform(CharSequence charsequence)
        {
            validate(fields()[12], charsequence);
            cs = charsequence;
            fieldSetFlags()[12] = true;
            return this;
        }

        public Builder setFrequencyCapInfos(List list)
        {
            validate(fields()[18], list);
            cy = list;
            fieldSetFlags()[18] = true;
            return this;
        }

        public Builder setKeywords(Map map)
        {
            validate(fields()[14], map);
            cu = map;
            fieldSetFlags()[14] = true;
            return this;
        }

        public Builder setLocale(CharSequence charsequence)
        {
            validate(fields()[9], charsequence);
            cp = charsequence;
            fieldSetFlags()[9] = true;
            return this;
        }

        public Builder setLocation(Location location)
        {
            validate(fields()[5], location);
            cl = location;
            fieldSetFlags()[5] = true;
            return this;
        }

        public Builder setNetworkStatus(int i)
        {
            validate(fields()[17], Integer.valueOf(i));
            cx = i;
            fieldSetFlags()[17] = true;
            return this;
        }

        public Builder setOsVersion(CharSequence charsequence)
        {
            validate(fields()[11], charsequence);
            cr = charsequence;
            fieldSetFlags()[11] = true;
            return this;
        }

        public Builder setPreferredLanguage(CharSequence charsequence)
        {
            validate(fields()[20], charsequence);
            cA = charsequence;
            fieldSetFlags()[20] = true;
            return this;
        }

        public Builder setRefresh(boolean flag)
        {
            validate(fields()[15], Boolean.valueOf(flag));
            cv = flag;
            fieldSetFlags()[15] = true;
            return this;
        }

        public Builder setSessionId(long l)
        {
            validate(fields()[3], Long.valueOf(l));
            ce = l;
            fieldSetFlags()[3] = true;
            return this;
        }

        public Builder setTestAds(TestAds testads)
        {
            validate(fields()[13], testads);
            ct = testads;
            fieldSetFlags()[13] = true;
            return this;
        }

        public Builder setTestDevice(boolean flag)
        {
            validate(fields()[6], Boolean.valueOf(flag));
            cm = flag;
            fieldSetFlags()[6] = true;
            return this;
        }

        public Builder setTimezone(CharSequence charsequence)
        {
            validate(fields()[10], charsequence);
            cq = charsequence;
            fieldSetFlags()[10] = true;
            return this;
        }

        Builder()
        {
            this((byte)0);
        }

        private Builder(byte byte0)
        {
            super(AdRequest.SCHEMA$);
        }
    }

}
