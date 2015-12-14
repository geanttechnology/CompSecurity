// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.contact;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.LVBuffer;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoDBItem;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class RContact extends MAutoDBItem
{

    public static final String COLUMNS[];
    public static final String COL_ALIAS = "alias";
    public static final String COL_CONREMARK = "conRemark";
    public static final String COL_CONREMARK_PYFULL = "conRemarkPYFull";
    public static final String COL_CONREMARK_PYSHORT = "conRemarkPYShort";
    public static final String COL_DOMAINLIST = "domainList";
    public static final int COL_ID_INVALID_VALUE = -1;
    public static final String COL_NICKNAME = "nickname";
    public static final String COL_PYINITIAL = "pyInitial";
    public static final String COL_QUANPIN = "quanPin";
    public static final String COL_SHOWHEAD = "showHead";
    public static final String COL_TYPE = "type";
    public static final String COL_USERNAME = "username";
    public static final String COL_VERIFY_FLAG = "verifyFlag";
    public static final String COL_WEIBOFLAG = "weiboFlag";
    public static final String COL_WEIBONICKNAME = "weiboNickname";
    public static final int DEL_CONTACT_MSG = -1;
    public static final String FAVOUR_CONTACT_SHOW_HEAD_CHAR = "$";
    public static final int FAVOUR_CONTACT_SHOW_HEAD_CODE = 32;
    private static Map M = new HashMap();
    public static final int MM_CONTACTFLAG_ALL = 127;
    public static final int MM_CONTACTFLAG_BLACKLISTCONTACT = 8;
    public static final int MM_CONTACTFLAG_CHATCONTACT = 2;
    public static final int MM_CONTACTFLAG_CHATROOMCONTACT = 4;
    public static final int MM_CONTACTFLAG_CONTACT = 1;
    public static final int MM_CONTACTFLAG_DOMAINCONTACT = 16;
    public static final int MM_CONTACTFLAG_FAVOURCONTACT = 64;
    public static final int MM_CONTACTFLAG_HIDECONTACT = 32;
    public static final int MM_CONTACTFLAG_NULL = 0;
    public static final int MM_CONTACTIMGFLAG_HAS_HEADIMG = 3;
    public static final int MM_CONTACTIMGFLAG_HAS_NO_HEADIMG = 4;
    public static final int MM_CONTACTIMGFLAG_LOCAL_EXIST = 153;
    public static final int MM_CONTACTIMGFLAG_MODIFY = 2;
    public static final int MM_CONTACTIMGFLAG_NOTMODIFY = 1;
    public static final int MM_CONTACT_BOTTLE = 5;
    public static final int MM_CONTACT_CHATROOM = 2;
    public static final int MM_CONTACT_EMAIL = 3;
    public static final int MM_CONTACT_QQ = 4;
    public static final int MM_CONTACT_QQMICROBLOG = 1;
    public static final int MM_CONTACT_WEIXIN = 0;
    public static final int MM_SEX_FEMALE = 2;
    public static final int MM_SEX_MALE = 1;
    public static final int MM_SEX_UNKNOWN = 0;
    private static Map N = new HashMap();
    public static final int NOT_IN_CHAT_LIST = 0;
    protected static Field p[];
    private String A;
    private int B;
    private int C;
    private String D;
    private String E;
    private String F;
    private String G;
    private int H;
    private int I;
    private String J;
    private String K;
    private String L;
    public long contactId;
    public String field_alias;
    public String field_conRemark;
    public String field_conRemarkPYFull;
    public String field_conRemarkPYShort;
    public String field_domainList;
    public byte field_lvbuff[];
    public String field_nickname;
    public String field_pyInitial;
    public String field_quanPin;
    public int field_showHead;
    public int field_type;
    public String field_username;
    public int field_verifyFlag;
    public int field_weiboFlag;
    public String field_weiboNickname;
    private int h;
    private int q;
    private int r;
    private String s;
    private long u;
    private String v;
    private String w;
    private int x;
    private int y;
    private String z;

    public RContact()
    {
        reset();
    }

    public RContact(String s1)
    {
        this();
        String s2 = s1;
        if (s1 == null)
        {
            s2 = "";
        }
        field_username = s2;
    }

    private byte[] a()
    {
        byte abyte0[];
        try
        {
            LVBuffer lvbuffer = new LVBuffer();
            lvbuffer.initBuild();
            lvbuffer.putInt(q);
            lvbuffer.putInt(r);
            lvbuffer.putString(s);
            lvbuffer.putLong(u);
            lvbuffer.putInt(h);
            lvbuffer.putString(v);
            lvbuffer.putString(w);
            lvbuffer.putInt(x);
            lvbuffer.putInt(y);
            lvbuffer.putString(z);
            lvbuffer.putString(A);
            lvbuffer.putInt(B);
            lvbuffer.putInt(C);
            lvbuffer.putString(D);
            lvbuffer.putString(E);
            lvbuffer.putString(F);
            lvbuffer.putString(G);
            lvbuffer.putInt(H);
            lvbuffer.putInt(I);
            lvbuffer.putString(J);
            lvbuffer.putInt(field_verifyFlag);
            lvbuffer.putString(K);
            lvbuffer.putString(L);
            abyte0 = lvbuffer.buildFinish();
        }
        catch (Exception exception)
        {
            Log.e("MicroMsg.Contact", "get value failed");
            exception.printStackTrace();
            return null;
        }
        return abyte0;
    }

    public static String formatDisplayNick(String s1)
    {
        String s2;
        if (s1 == null)
        {
            s2 = null;
        } else
        {
            if (s1.toLowerCase().endsWith("@t.qq.com"))
            {
                return (new StringBuilder("@")).append(s1.replace("@t.qq.com", "")).toString();
            }
            s2 = s1;
            if (s1.toLowerCase().endsWith("@qqim"))
            {
                return s1.replace("@qqim", "");
            }
        }
        return s2;
    }

    public static int getBlackListContactBit()
    {
        return 8;
    }

    public static int getContactBit()
    {
        return 1;
    }

    public static int getDomainContactBit()
    {
        return 16;
    }

    public static int getHiddenContactBit()
    {
        return 32;
    }

    public static boolean isContact(int i)
    {
        return (i & 1) != 0;
    }

    private static boolean isLetter(char c)
    {
        return c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z';
    }

    public static void setHardCodeAliasMaps(Map map)
    {
        N = map;
    }

    public static void setHardCodeNickMaps(Map map)
    {
        M = map;
    }

    public int calculateShowHead()
    {
        char c1 = ' ';
        if (field_conRemarkPYShort == null || field_conRemarkPYShort.equals("")) goto _L2; else goto _L1
_L1:
        char c = field_conRemarkPYShort.charAt(0);
_L8:
        if (c < 'a' || c > 'z') goto _L4; else goto _L3
_L3:
        c1 = (char)(c - 32);
_L6:
        return c1;
_L2:
        if (field_conRemarkPYFull != null && !field_conRemarkPYFull.equals(""))
        {
            c = field_conRemarkPYFull.charAt(0);
        } else
        if (field_pyInitial != null && !field_pyInitial.equals(""))
        {
            c = field_pyInitial.charAt(0);
        } else
        if (field_quanPin != null && !field_quanPin.equals(""))
        {
            c = field_quanPin.charAt(0);
        } else
        if (field_nickname != null && !field_nickname.equals("") && isLetter(field_nickname.charAt(0)))
        {
            c = field_nickname.charAt(0);
        } else
        {
            c = c1;
            if (field_username != null)
            {
                c = c1;
                if (!field_username.equals(""))
                {
                    c = c1;
                    if (isLetter(field_username.charAt(0)))
                    {
                        c = field_username.charAt(0);
                    }
                }
            }
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (c < 'A')
        {
            break; /* Loop/switch isn't completed */
        }
        c1 = c;
        if (c <= 'Z') goto _L6; else goto _L5
_L5:
        return 123;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public void convertFrom(Cursor cursor)
    {
        super.convertFrom(cursor);
        contactId = (int)cursor.getLong(cursor.getColumnCount() - 1);
        cursor = field_lvbuff;
        LVBuffer lvbuffer;
        int i;
        lvbuffer = new LVBuffer();
        i = lvbuffer.initParse(cursor);
        if (i != 0)
        {
            try
            {
                Log.e("MicroMsg.Contact", (new StringBuilder("parse LVBuffer error:")).append(i).toString());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Cursor cursor)
            {
                Log.e("MicroMsg.Contact", "get value failed");
            }
            break MISSING_BLOCK_LABEL_271;
        }
        q = lvbuffer.getInt();
        r = lvbuffer.getInt();
        s = lvbuffer.getString();
        u = lvbuffer.getLong();
        h = lvbuffer.getInt();
        v = lvbuffer.getString();
        w = lvbuffer.getString();
        x = lvbuffer.getInt();
        y = lvbuffer.getInt();
        z = lvbuffer.getString();
        A = lvbuffer.getString();
        B = lvbuffer.getInt();
        C = lvbuffer.getInt();
        D = lvbuffer.getString();
        E = lvbuffer.getString();
        F = lvbuffer.getString();
        G = lvbuffer.getString();
        H = lvbuffer.getInt();
        I = lvbuffer.getInt();
        J = lvbuffer.getString();
        field_verifyFlag = lvbuffer.getInt();
        K = lvbuffer.getString();
        if (!lvbuffer.checkGetFinish())
        {
            L = lvbuffer.getString();
            return;
        }
        break MISSING_BLOCK_LABEL_275;
        cursor.printStackTrace();
    }

    public ContentValues convertTo()
    {
        field_lvbuff = a();
        return super.convertTo();
    }

    public Field[] fields()
    {
        return p;
    }

    public String getAlias()
    {
        String s2 = (String)N.get(field_username);
        String s1 = s2;
        if (s2 == null)
        {
            s1 = field_alias;
        }
        return s1;
    }

    public int getChatroomNotify()
    {
        return B;
    }

    public String getCity()
    {
        return F;
    }

    public String getConQQMBlog()
    {
        return A;
    }

    public String getConRemark()
    {
        return field_conRemark;
    }

    public String getConRemarkPYFull()
    {
        return field_conRemarkPYFull;
    }

    public String getConRemarkPYShort()
    {
        return field_conRemarkPYShort;
    }

    public String getConSMBlog()
    {
        return z;
    }

    public int getConType()
    {
        return y;
    }

    public int getContactID()
    {
        return (int)contactId;
    }

    public String getDisplayNick()
    {
        String s1 = (String)M.get(field_username);
        if (s1 != null)
        {
            return s1;
        }
        if (field_nickname == null || field_nickname.length() <= 0)
        {
            return getDisplayUser();
        } else
        {
            return field_nickname;
        }
    }

    public String getDisplayRemark()
    {
        if (field_conRemark != null && !field_conRemark.trim().equals(""))
        {
            return field_conRemark;
        } else
        {
            return getDisplayNick();
        }
    }

    public String getDisplayUser()
    {
        String s1 = getAlias();
        if (Util.isNullOrNil(s1)) goto _L2; else goto _L1
_L1:
        return s1;
_L2:
        String s2;
        s2 = formatDisplayNick(field_username);
        if (s2 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = s2;
        if (s2.length() != 0) goto _L1; else goto _L3
_L3:
        return field_username;
    }

    public String getDistance()
    {
        return G;
    }

    public String getDomainList()
    {
        return field_domainList;
    }

    public String getEmail()
    {
        return v;
    }

    public long getFaceBookId()
    {
        return u;
    }

    public String getFaceBookUsername()
    {
        return s;
    }

    public int getFromType()
    {
        return H;
    }

    public int getImgFlag()
    {
        return q;
    }

    public String getMobile()
    {
        return w;
    }

    public String getNickname()
    {
        return field_nickname;
    }

    public int getPersonalCard()
    {
        return C;
    }

    public String getProvince()
    {
        return E;
    }

    public String getPyInitial()
    {
        if (field_pyInitial == null || field_pyInitial.length() < 0)
        {
            return getQuanPin();
        } else
        {
            return field_pyInitial;
        }
    }

    public String getQuanPin()
    {
        if (field_quanPin == null || field_quanPin.length() < 0)
        {
            return getNickname();
        } else
        {
            return field_quanPin;
        }
    }

    public String getRegionCode()
    {
        return L;
    }

    public int getSex()
    {
        return r;
    }

    public int getShowFlag()
    {
        return x;
    }

    public int getShowHead()
    {
        return field_showHead;
    }

    public String getSignature()
    {
        return D;
    }

    public int getSource()
    {
        return I;
    }

    public int getType()
    {
        return field_type;
    }

    public int getUin()
    {
        return h;
    }

    public String getUsername()
    {
        return field_username;
    }

    public int getVerifyFlag()
    {
        return field_verifyFlag;
    }

    public String getVerifyInfo()
    {
        return K;
    }

    public String getWeibo()
    {
        return J;
    }

    public int getWeiboFlag()
    {
        return field_weiboFlag;
    }

    public String getWeiboNickName()
    {
        return field_weiboNickname;
    }

    public boolean isBlackListContact()
    {
        return (field_type & 8) != 0;
    }

    public boolean isChatContact()
    {
        return (field_type & 2) != 0;
    }

    public boolean isChatRoomContact()
    {
        return (field_type & 4) != 0;
    }

    public boolean isContact()
    {
        return isContact(field_type);
    }

    public boolean isDomainContact()
    {
        return (field_type & 0x10) != 0;
    }

    public boolean isFavourContact()
    {
        return (field_type & 0x40) != 0;
    }

    public boolean isHidden()
    {
        return (field_type & 0x20) != 0;
    }

    public boolean isImgLocalExist()
    {
        return 153 == q;
    }

    public void reset()
    {
        field_username = "";
        field_nickname = "";
        field_pyInitial = "";
        field_quanPin = "";
        field_alias = "";
        field_conRemark = "";
        field_conRemarkPYShort = "";
        field_conRemarkPYFull = "";
        field_domainList = "";
        field_weiboFlag = 0;
        field_weiboNickname = "";
        field_showHead = 0;
        field_type = 0;
        field_verifyFlag = 0;
        r = 0;
        G = "";
        H = 0;
        h = 0;
        v = "";
        w = "";
        x = 0;
        y = 0;
        z = "";
        A = "";
        B = 1;
        q = 0;
        C = 0;
        D = "";
        E = "";
        F = "";
        I = 0;
        K = "";
        J = "";
        u = 0L;
        s = "";
        L = "";
    }

    public void setAlias(String s1)
    {
        field_alias = s1;
    }

    public void setBlackList()
    {
        field_type = field_type | 8;
    }

    public void setChatContact()
    {
        field_type = field_type | 2;
    }

    public void setChatroomContact()
    {
        field_type = field_type | 4;
    }

    public void setChatroomNotify(int i)
    {
        B = i;
    }

    public void setCity(String s1)
    {
        F = s1;
    }

    public void setConQQMBlog(String s1)
    {
        A = s1;
    }

    public void setConRemark(String s1)
    {
        field_conRemark = s1;
    }

    public void setConRemarkPYFull(String s1)
    {
        field_conRemarkPYFull = s1;
    }

    public void setConRemarkPYShort(String s1)
    {
        field_conRemarkPYShort = s1;
    }

    public void setConSMBlog(String s1)
    {
        z = s1;
    }

    public void setConType(int i)
    {
        y = i;
    }

    public void setContact()
    {
        field_type = field_type | 1;
    }

    public void setDistance(String s1)
    {
        G = s1;
    }

    public void setDomainList(String s1)
    {
        field_domainList = s1;
    }

    public void setEmail(String s1)
    {
        v = s1;
    }

    public void setFaceBookId(long l)
    {
        u = l;
    }

    public void setFaceBookUsername(String s1)
    {
        s = s1;
    }

    public void setFavour()
    {
        field_type = field_type | 0x40;
    }

    public void setFromType(int i)
    {
        H = i;
    }

    public void setHidden()
    {
        field_type = field_type | 0x20;
    }

    public void setImgFlag(int i)
    {
        q = i;
    }

    public void setMobile(String s1)
    {
        w = s1;
    }

    public void setNickname(String s1)
    {
        field_nickname = s1;
    }

    public void setNullContact()
    {
        field_type = 0;
    }

    public void setPersonalCard(int i)
    {
        C = i;
    }

    public void setProvince(String s1)
    {
        E = s1;
    }

    public void setPyInitial(String s1)
    {
        field_pyInitial = s1;
    }

    public void setQuanPin(String s1)
    {
        field_quanPin = s1;
    }

    public void setRegionCode(String s1)
    {
        L = s1;
    }

    public void setSex(int i)
    {
        r = i;
    }

    public void setShowFlag(int i)
    {
        x = i;
    }

    public void setShowHead(int i)
    {
        field_showHead = i;
    }

    public void setSignature(String s1)
    {
        D = s1;
    }

    public void setSource(int i)
    {
        I = i;
    }

    public void setType(int i)
    {
        field_type = i;
    }

    public void setUin(int i)
    {
        h = i;
    }

    public void setUsername(String s1)
    {
        field_username = s1;
    }

    public void setVerifyFlag(int i)
    {
        field_verifyFlag = i;
    }

    public void setVerifyInfo(String s1)
    {
        K = s1;
    }

    public void setWeibo(String s1)
    {
        J = s1;
    }

    public void setWeiboFlag(int i)
    {
        field_weiboFlag = i;
    }

    public void setWeiboNickName(String s1)
    {
        field_weiboNickname = s1;
    }

    public void unSetBlackList()
    {
        field_type = field_type & -9;
    }

    public void unSetChatContact()
    {
        field_type = field_type & -3;
    }

    public void unSetContact()
    {
        field_type = field_type & -2;
    }

    public void unSetFavour()
    {
        field_type = field_type & 0xffffffbf;
    }

    public void unSetHidden()
    {
        field_type = field_type & 0xffffffdf;
    }

    static 
    {
        Field afield[] = MAutoDBItem.getValidFields(com/tencent/mm/sdk/contact/RContact);
        p = afield;
        COLUMNS = MAutoDBItem.getFullColumns(afield);
    }
}
