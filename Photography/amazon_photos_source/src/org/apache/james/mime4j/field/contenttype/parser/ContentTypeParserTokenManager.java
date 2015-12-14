// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.field.contenttype.parser;

import java.io.IOException;
import java.io.PrintStream;

// Referenced classes of package org.apache.james.mime4j.field.contenttype.parser:
//            ContentTypeParserConstants, SimpleCharStream, TokenMgrError, Token

public class ContentTypeParserTokenManager
    implements ContentTypeParserConstants
{

    static int commentNest;
    static final long jjbitVec0[] = {
        0L, 0L, -1L, -1L
    };
    public static final int jjnewLexState[] = {
        -1, -1, -1, -1, -1, -1, -1, 1, 0, -1, 
        2, -1, -1, -1, -1, -1, 3, -1, -1, 0, 
        -1, -1, -1, -1
    };
    static final int jjnextStates[] = new int[0];
    public static final String jjstrLiteralImages[] = {
        "", "\r", "\n", "/", ";", "=", null, null, null, null, 
        null, null, null, null, null, null, null, null, null, null, 
        null, null, null, null
    };
    static final long jjtoMore[] = {
        0x7fe80L
    };
    static final long jjtoSkip[] = {
        320L
    };
    static final long jjtoSpecial[] = {
        64L
    };
    static final long jjtoToken[] = {
        0x38003fL
    };
    public static final String lexStateNames[] = {
        "DEFAULT", "INCOMMENT", "NESTED_COMMENT", "INQUOTEDSTRING"
    };
    protected char curChar;
    int curLexState;
    public PrintStream debugStream;
    int defaultLexState;
    StringBuffer image;
    protected SimpleCharStream input_stream;
    int jjimageLen;
    int jjmatchedKind;
    int jjmatchedPos;
    int jjnewStateCnt;
    int jjround;
    private final int jjrounds[] = new int[3];
    private final int jjstateSet[] = new int[6];
    int lengthOfMatch;

    public ContentTypeParserTokenManager(SimpleCharStream simplecharstream)
    {
        debugStream = System.out;
        curLexState = 0;
        defaultLexState = 0;
        input_stream = simplecharstream;
    }

    private final void ReInitRounds()
    {
        jjround = 0x80000001;
        int i = 3;
        do
        {
            int j = i - 1;
            if (i > 0)
            {
                jjrounds[j] = 0x80000000;
                i = j;
            } else
            {
                return;
            }
        } while (true);
    }

    private final void jjCheckNAdd(int i)
    {
        if (jjrounds[i] != jjround)
        {
            int ai[] = jjstateSet;
            int j = jjnewStateCnt;
            jjnewStateCnt = j + 1;
            ai[j] = i;
            jjrounds[i] = jjround;
        }
    }

    private final int jjMoveNfa_0(int i, int j)
    {
        int i1;
        int j1;
        i1 = 0;
        jjnewStateCnt = 3;
        boolean flag = true;
        jjstateSet[0] = i;
        i = 0x7fffffff;
        j1 = j;
        j = ((flag) ? 1 : 0);
_L20:
        int k = jjround + 1;
        jjround = k;
        if (k == 0x7fffffff)
        {
            ReInitRounds();
        }
        if (curChar >= '@') goto _L2; else goto _L1
_L1:
        int l;
        long l1;
        l1 = 1L << curChar;
        l = j;
_L9:
        int ai[];
        int k1;
        ai = jjstateSet;
        k1 = l - 1;
        ai[k1];
        JVM INSTR tableswitch 0 3: default 116
    //                   0 284
    //                   1 308
    //                   2 340
    //                   3 185;
           goto _L3 _L4 _L5 _L6 _L7
_L3:
        j = i;
_L10:
        l = k1;
        i = j;
        if (k1 != i1) goto _L9; else goto _L8
_L8:
        i = j;
        if (j != 0x7fffffff)
        {
            jjmatchedKind = j;
            jjmatchedPos = j1;
            i = 0x7fffffff;
        }
        j1++;
        j = jjnewStateCnt;
        jjnewStateCnt = i1;
        i1 = 3 - i1;
        if (j == i1)
        {
            return j1;
        }
        break MISSING_BLOCK_LABEL_593;
_L7:
        if ((0x3ff6cfafffffdffL & l1) != 0L)
        {
            l = i;
            if (i > 21)
            {
                l = 21;
            }
            jjCheckNAdd(2);
        } else
        {
            l = i;
            if ((0x100000200L & l1) != 0L)
            {
                l = i;
                if (i > 6)
                {
                    l = 6;
                }
                jjCheckNAdd(0);
            }
        }
        j = l;
        if ((0x3ff000000000000L & l1) != 0L)
        {
            j = l;
            if (l > 20)
            {
                j = 20;
            }
            jjCheckNAdd(1);
        }
          goto _L10
_L4:
        j = i;
        if ((0x100000200L & l1) != 0L)
        {
            j = 6;
            jjCheckNAdd(0);
        }
          goto _L10
_L5:
        j = i;
        if ((0x3ff000000000000L & l1) != 0L)
        {
            j = i;
            if (i > 20)
            {
                j = 20;
            }
            jjCheckNAdd(1);
        }
          goto _L10
_L6:
        j = i;
        if ((0x3ff6cfafffffdffL & l1) != 0L)
        {
            j = i;
            if (i > 21)
            {
                j = 21;
            }
            jjCheckNAdd(2);
        }
          goto _L10
_L2:
        char c;
        if (curChar >= '\200')
        {
            break MISSING_BLOCK_LABEL_475;
        }
        c = curChar;
        l = j;
_L13:
        ai = jjstateSet;
        k1 = l - 1;
        ai[k1];
        JVM INSTR tableswitch 2 3: default 428
    //                   2 446
    //                   3 446;
           goto _L11 _L12 _L12
_L11:
        j = i;
_L14:
        l = k1;
        i = j;
        if (k1 != i1) goto _L13; else goto _L8
_L12:
        j = i;
        if ((0xffffffffc7fffffeL & 1L << (c & 0x3f)) != 0L)
        {
            j = 21;
            jjCheckNAdd(2);
        }
          goto _L14
        char c1;
        c = curChar;
        c1 = curChar;
        l = j;
_L17:
        ai = jjstateSet;
        k1 = l - 1;
        ai[k1];
        JVM INSTR tableswitch 2 3: default 528
    //                   2 546
    //                   3 546;
           goto _L15 _L16 _L16
_L15:
        j = i;
_L18:
        l = k1;
        i = j;
        if (k1 != i1) goto _L17; else goto _L8
_L16:
        j = i;
        if ((jjbitVec0[(c & 0xff) >> 6] & 1L << (c1 & 0x3f)) != 0L)
        {
            j = i;
            if (i > 21)
            {
                j = 21;
            }
            jjCheckNAdd(2);
        }
          goto _L18
        try
        {
            curChar = input_stream.readChar();
        }
        catch (IOException ioexception)
        {
            return j1;
        }
        if (true) goto _L20; else goto _L19
_L19:
    }

    private final int jjMoveNfa_1(int i, int j)
    {
        int i1;
        int j1;
        i1 = 0;
        jjnewStateCnt = 3;
        boolean flag = true;
        jjstateSet[0] = i;
        i = 0x7fffffff;
        j1 = j;
        j = i;
        i = ((flag) ? 1 : 0);
_L21:
        int k = jjround + 1;
        jjround = k;
        if (k == 0x7fffffff)
        {
            ReInitRounds();
        }
        if (curChar >= '@') goto _L2; else goto _L1
_L1:
        int l;
        l = curChar;
        l = i;
_L7:
        int ai[];
        int k1;
        ai = jjstateSet;
        k1 = l - 1;
        ai[k1];
        JVM INSTR tableswitch 0 1: default 108
    //                   0 177
    //                   1 191;
           goto _L3 _L4 _L5
_L3:
        i = j;
_L8:
        l = k1;
        j = i;
        if (k1 != i1) goto _L7; else goto _L6
_L6:
        j = i;
        if (i != 0x7fffffff)
        {
            jjmatchedKind = i;
            jjmatchedPos = j1;
            j = 0x7fffffff;
        }
        j1++;
        i = jjnewStateCnt;
        jjnewStateCnt = i1;
        i1 = 3 - i1;
        if (i == i1)
        {
            return j1;
        }
        break MISSING_BLOCK_LABEL_506;
_L4:
        i = j;
        if (j > 11)
        {
            i = 11;
        }
          goto _L8
_L5:
        i = j;
        if (j > 9)
        {
            i = 9;
        }
          goto _L8
_L2:
        if (curChar >= '\200')
        {
            break MISSING_BLOCK_LABEL_362;
        }
        l = curChar;
        l = i;
_L13:
        ai = jjstateSet;
        k1 = l - 1;
        ai[k1];
        JVM INSTR tableswitch 0 2: default 264
    //                   0 282
    //                   1 334
    //                   2 348;
           goto _L9 _L10 _L11 _L12
_L12:
        break MISSING_BLOCK_LABEL_348;
_L9:
        i = j;
_L14:
        l = k1;
        j = i;
        if (k1 != i1) goto _L13; else goto _L6
_L10:
        l = j;
        if (j > 11)
        {
            l = 11;
        }
        i = l;
        if (curChar == '\\')
        {
            ai = jjstateSet;
            i = jjnewStateCnt;
            jjnewStateCnt = i + 1;
            ai[i] = 1;
            i = l;
        }
          goto _L14
_L11:
        i = j;
        if (j > 9)
        {
            i = 9;
        }
          goto _L14
        i = j;
        if (j > 11)
        {
            i = 11;
        }
          goto _L14
        int l1;
        long l2;
        l1 = (curChar & 0xff) >> 6;
        l2 = 1L << (curChar & 0x3f);
        l = i;
_L18:
        ai = jjstateSet;
        k1 = l - 1;
        ai[k1];
        JVM INSTR tableswitch 0 1: default 428
    //                   0 446
    //                   1 476;
           goto _L15 _L16 _L17
_L17:
        break MISSING_BLOCK_LABEL_476;
_L15:
        i = j;
_L19:
        l = k1;
        j = i;
        if (k1 != i1) goto _L18; else goto _L6
_L16:
        i = j;
        if ((jjbitVec0[l1] & l2) != 0L)
        {
            i = j;
            if (j > 11)
            {
                i = 11;
            }
        }
          goto _L19
        i = j;
        if ((jjbitVec0[l1] & l2) != 0L)
        {
            i = j;
            if (j > 9)
            {
                i = 9;
            }
        }
          goto _L19
        try
        {
            curChar = input_stream.readChar();
        }
        catch (IOException ioexception)
        {
            return j1;
        }
        if (true) goto _L21; else goto _L20
_L20:
    }

    private final int jjMoveNfa_2(int i, int j)
    {
        int i1;
        int j1;
        i1 = 0;
        jjnewStateCnt = 3;
        boolean flag = true;
        jjstateSet[0] = i;
        i = 0x7fffffff;
        j1 = j;
        j = i;
        i = ((flag) ? 1 : 0);
_L21:
        int k = jjround + 1;
        jjround = k;
        if (k == 0x7fffffff)
        {
            ReInitRounds();
        }
        if (curChar >= '@') goto _L2; else goto _L1
_L1:
        int l;
        l = curChar;
        l = i;
_L7:
        int ai[];
        int k1;
        ai = jjstateSet;
        k1 = l - 1;
        ai[k1];
        JVM INSTR tableswitch 0 1: default 108
    //                   0 177
    //                   1 191;
           goto _L3 _L4 _L5
_L3:
        i = j;
_L8:
        l = k1;
        j = i;
        if (k1 != i1) goto _L7; else goto _L6
_L6:
        j = i;
        if (i != 0x7fffffff)
        {
            jjmatchedKind = i;
            jjmatchedPos = j1;
            j = 0x7fffffff;
        }
        j1++;
        i = jjnewStateCnt;
        jjnewStateCnt = i1;
        i1 = 3 - i1;
        if (i == i1)
        {
            return j1;
        }
        break MISSING_BLOCK_LABEL_506;
_L4:
        i = j;
        if (j > 15)
        {
            i = 15;
        }
          goto _L8
_L5:
        i = j;
        if (j > 12)
        {
            i = 12;
        }
          goto _L8
_L2:
        if (curChar >= '\200')
        {
            break MISSING_BLOCK_LABEL_362;
        }
        l = curChar;
        l = i;
_L13:
        ai = jjstateSet;
        k1 = l - 1;
        ai[k1];
        JVM INSTR tableswitch 0 2: default 264
    //                   0 282
    //                   1 334
    //                   2 348;
           goto _L9 _L10 _L11 _L12
_L12:
        break MISSING_BLOCK_LABEL_348;
_L9:
        i = j;
_L14:
        l = k1;
        j = i;
        if (k1 != i1) goto _L13; else goto _L6
_L10:
        l = j;
        if (j > 15)
        {
            l = 15;
        }
        i = l;
        if (curChar == '\\')
        {
            ai = jjstateSet;
            i = jjnewStateCnt;
            jjnewStateCnt = i + 1;
            ai[i] = 1;
            i = l;
        }
          goto _L14
_L11:
        i = j;
        if (j > 12)
        {
            i = 12;
        }
          goto _L14
        i = j;
        if (j > 15)
        {
            i = 15;
        }
          goto _L14
        int l1;
        long l2;
        l1 = (curChar & 0xff) >> 6;
        l2 = 1L << (curChar & 0x3f);
        l = i;
_L18:
        ai = jjstateSet;
        k1 = l - 1;
        ai[k1];
        JVM INSTR tableswitch 0 1: default 428
    //                   0 446
    //                   1 476;
           goto _L15 _L16 _L17
_L17:
        break MISSING_BLOCK_LABEL_476;
_L15:
        i = j;
_L19:
        l = k1;
        j = i;
        if (k1 != i1) goto _L18; else goto _L6
_L16:
        i = j;
        if ((jjbitVec0[l1] & l2) != 0L)
        {
            i = j;
            if (j > 15)
            {
                i = 15;
            }
        }
          goto _L19
        i = j;
        if ((jjbitVec0[l1] & l2) != 0L)
        {
            i = j;
            if (j > 12)
            {
                i = 12;
            }
        }
          goto _L19
        try
        {
            curChar = input_stream.readChar();
        }
        catch (IOException ioexception)
        {
            return j1;
        }
        if (true) goto _L21; else goto _L20
_L20:
    }

    private final int jjMoveNfa_3(int i, int j)
    {
        int k;
        int l;
        k = 0;
        jjnewStateCnt = 3;
        boolean flag = true;
        jjstateSet[0] = i;
        i = 0x7fffffff;
        l = j;
        j = i;
        i = ((flag) ? 1 : 0);
_L21:
        int i1 = jjround + 1;
        jjround = i1;
        if (i1 == 0x7fffffff)
        {
            ReInitRounds();
        }
        if (curChar >= '@') goto _L2; else goto _L1
_L1:
        int j1;
        int l1;
        l1 = curChar;
        j1 = i;
_L7:
        int ai[];
        int k1;
        ai = jjstateSet;
        k1 = j1 - 1;
        ai[k1];
        JVM INSTR tableswitch 0 2: default 112
    //                   0 181
    //                   1 215
    //                   2 181;
           goto _L3 _L4 _L5 _L4
_L3:
        i = j;
_L8:
        j1 = k1;
        j = i;
        if (k1 != k) goto _L7; else goto _L6
_L6:
        j = i;
        if (i != 0x7fffffff)
        {
            jjmatchedKind = i;
            jjmatchedPos = l;
            j = 0x7fffffff;
        }
        l++;
        i = jjnewStateCnt;
        jjnewStateCnt = k;
        k = 3 - k;
        if (i == k)
        {
            return l;
        }
        break MISSING_BLOCK_LABEL_579;
_L4:
        i = j;
        if ((0xfffffffbffffffffL & 1L << l1) != 0L)
        {
            i = j;
            if (j > 18)
            {
                i = 18;
            }
            jjCheckNAdd(2);
        }
          goto _L8
_L5:
        i = j;
        if (j > 17)
        {
            i = 17;
        }
          goto _L8
_L2:
        long l2;
        if (curChar >= '\200')
        {
            break MISSING_BLOCK_LABEL_427;
        }
        l2 = 1L << (curChar & 0x3f);
        j1 = i;
_L13:
        ai = jjstateSet;
        k1 = j1 - 1;
        ai[k1];
        JVM INSTR tableswitch 0 2: default 296
    //                   0 314
    //                   1 381
    //                   2 395;
           goto _L9 _L10 _L11 _L12
_L12:
        break MISSING_BLOCK_LABEL_395;
_L9:
        i = j;
_L14:
        j1 = k1;
        j = i;
        if (k1 != k) goto _L13; else goto _L6
_L10:
        if ((0xffffffffefffffffL & l2) != 0L)
        {
            i = j;
            if (j > 18)
            {
                i = 18;
            }
            jjCheckNAdd(2);
        } else
        {
            i = j;
            if (curChar == '\\')
            {
                ai = jjstateSet;
                i = jjnewStateCnt;
                jjnewStateCnt = i + 1;
                ai[i] = 1;
                i = j;
            }
        }
          goto _L14
_L11:
        i = j;
        if (j > 17)
        {
            i = 17;
        }
          goto _L14
        i = j;
        if ((0xffffffffefffffffL & l2) != 0L)
        {
            i = j;
            if (j > 18)
            {
                i = 18;
            }
            jjCheckNAdd(2);
        }
          goto _L14
        l1 = (curChar & 0xff) >> 6;
        l2 = 1L << (curChar & 0x3f);
        j1 = i;
_L18:
        ai = jjstateSet;
        k1 = j1 - 1;
        ai[k1];
        JVM INSTR tableswitch 0 2: default 496
    //                   0 514
    //                   1 549
    //                   2 514;
           goto _L15 _L16 _L17 _L16
_L17:
        break MISSING_BLOCK_LABEL_549;
_L15:
        i = j;
_L19:
        j1 = k1;
        j = i;
        if (k1 != k) goto _L18; else goto _L6
_L16:
        i = j;
        if ((jjbitVec0[l1] & l2) != 0L)
        {
            i = j;
            if (j > 18)
            {
                i = 18;
            }
            jjCheckNAdd(2);
        }
          goto _L19
        i = j;
        if ((jjbitVec0[l1] & l2) != 0L)
        {
            i = j;
            if (j > 17)
            {
                i = 17;
            }
        }
          goto _L19
        try
        {
            curChar = input_stream.readChar();
        }
        catch (IOException ioexception)
        {
            return l;
        }
        if (true) goto _L21; else goto _L20
_L20:
    }

    private final int jjMoveStringLiteralDfa0_0()
    {
        switch (curChar)
        {
        default:
            return jjMoveNfa_0(3, 0);

        case 10: // '\n'
            return jjStartNfaWithStates_0(0, 2, 2);

        case 13: // '\r'
            return jjStartNfaWithStates_0(0, 1, 2);

        case 34: // '"'
            return jjStopAtPos(0, 16);

        case 40: // '('
            return jjStopAtPos(0, 7);

        case 47: // '/'
            return jjStopAtPos(0, 3);

        case 59: // ';'
            return jjStopAtPos(0, 4);

        case 61: // '='
            return jjStopAtPos(0, 5);
        }
    }

    private final int jjMoveStringLiteralDfa0_1()
    {
        switch (curChar)
        {
        default:
            return jjMoveNfa_1(0, 0);

        case 40: // '('
            return jjStopAtPos(0, 10);

        case 41: // ')'
            return jjStopAtPos(0, 8);
        }
    }

    private final int jjMoveStringLiteralDfa0_2()
    {
        switch (curChar)
        {
        default:
            return jjMoveNfa_2(0, 0);

        case 40: // '('
            return jjStopAtPos(0, 13);

        case 41: // ')'
            return jjStopAtPos(0, 14);
        }
    }

    private final int jjMoveStringLiteralDfa0_3()
    {
        switch (curChar)
        {
        default:
            return jjMoveNfa_3(0, 0);

        case 34: // '"'
            return jjStopAtPos(0, 19);
        }
    }

    private final int jjStartNfaWithStates_0(int i, int j, int k)
    {
        jjmatchedKind = j;
        jjmatchedPos = i;
        try
        {
            curChar = input_stream.readChar();
        }
        catch (IOException ioexception)
        {
            return i + 1;
        }
        return jjMoveNfa_0(k, i + 1);
    }

    private final int jjStopAtPos(int i, int j)
    {
        jjmatchedKind = j;
        jjmatchedPos = i;
        return i + 1;
    }

    void MoreLexicalActions()
    {
        int i = jjimageLen;
        int j = jjmatchedPos + 1;
        lengthOfMatch = j;
        jjimageLen = i + j;
        jjmatchedKind;
        JVM INSTR tableswitch 9 17: default 80
    //                   9 81
    //                   10 141
    //                   11 80
    //                   12 188
    //                   13 248
    //                   14 299
    //                   15 80
    //                   16 361
    //                   17 421;
           goto _L1 _L2 _L3 _L1 _L4 _L5 _L6 _L1 _L7 _L8
_L1:
        return;
_L2:
        if (image == null)
        {
            image = new StringBuffer();
        }
        image.append(input_stream.GetSuffix(jjimageLen));
        jjimageLen = 0;
        image.deleteCharAt(image.length() - 2);
        return;
_L3:
        if (image == null)
        {
            image = new StringBuffer();
        }
        image.append(input_stream.GetSuffix(jjimageLen));
        jjimageLen = 0;
        commentNest = 1;
        return;
_L4:
        if (image == null)
        {
            image = new StringBuffer();
        }
        image.append(input_stream.GetSuffix(jjimageLen));
        jjimageLen = 0;
        image.deleteCharAt(image.length() - 2);
        return;
_L5:
        if (image == null)
        {
            image = new StringBuffer();
        }
        image.append(input_stream.GetSuffix(jjimageLen));
        jjimageLen = 0;
        commentNest++;
        return;
_L6:
        if (image == null)
        {
            image = new StringBuffer();
        }
        image.append(input_stream.GetSuffix(jjimageLen));
        jjimageLen = 0;
        commentNest--;
        if (commentNest == 0)
        {
            SwitchTo(1);
            return;
        }
          goto _L1
_L7:
        if (image == null)
        {
            image = new StringBuffer();
        }
        image.append(input_stream.GetSuffix(jjimageLen));
        jjimageLen = 0;
        image.deleteCharAt(image.length() - 1);
        return;
_L8:
        if (image == null)
        {
            image = new StringBuffer();
        }
        image.append(input_stream.GetSuffix(jjimageLen));
        jjimageLen = 0;
        image.deleteCharAt(image.length() - 2);
        return;
    }

    public void SwitchTo(int i)
    {
        if (i >= 4 || i < 0)
        {
            throw new TokenMgrError((new StringBuilder()).append("Error: Ignoring invalid lexical state : ").append(i).append(". State unchanged.").toString(), 2);
        } else
        {
            curLexState = i;
            return;
        }
    }

    void TokenLexicalActions(Token token)
    {
        switch (jjmatchedKind)
        {
        default:
            return;

        case 19: // '\023'
            break;
        }
        if (image == null)
        {
            image = new StringBuffer();
        }
        StringBuffer stringbuffer = image;
        SimpleCharStream simplecharstream = input_stream;
        int i = jjimageLen;
        int j = jjmatchedPos + 1;
        lengthOfMatch = j;
        stringbuffer.append(simplecharstream.GetSuffix(i + j));
        token.image = image.substring(0, image.length() - 1);
    }

    public Token getNextToken()
    {
        Token token3;
        int k;
        token3 = null;
        k = 0;
_L10:
        int i;
        Token token;
        try
        {
            curChar = input_stream.BeginToken();
        }
        catch (IOException ioexception)
        {
            jjmatchedKind = 0;
            Token token1 = jjFillToken();
            token1.specialToken = token3;
            return token1;
        }
        image = null;
        jjimageLen = 0;
        i = k;
_L8:
        curLexState;
        JVM INSTR tableswitch 0 3: default 64
    //                   0 186
    //                   1 205
    //                   2 224
    //                   3 243;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        k = i;
        if (jjmatchedKind == 0x7fffffff)
        {
            break; /* Loop/switch isn't completed */
        }
        if (jjmatchedPos + 1 < i)
        {
            input_stream.backup(i - jjmatchedPos - 1);
        }
        if ((jjtoToken[jjmatchedKind >> 6] & 1L << (jjmatchedKind & 0x3f)) != 0L)
        {
            token = jjFillToken();
            token.specialToken = token3;
            TokenLexicalActions(token);
            if (jjnewLexState[jjmatchedKind] != -1)
            {
                curLexState = jjnewLexState[jjmatchedKind];
            }
            return token;
        }
        break; /* Loop/switch isn't completed */
_L2:
        jjmatchedKind = 0x7fffffff;
        jjmatchedPos = 0;
        i = jjMoveStringLiteralDfa0_0();
        continue; /* Loop/switch isn't completed */
_L3:
        jjmatchedKind = 0x7fffffff;
        jjmatchedPos = 0;
        i = jjMoveStringLiteralDfa0_1();
        continue; /* Loop/switch isn't completed */
_L4:
        jjmatchedKind = 0x7fffffff;
        jjmatchedPos = 0;
        i = jjMoveStringLiteralDfa0_2();
        continue; /* Loop/switch isn't completed */
_L5:
        jjmatchedKind = 0x7fffffff;
        jjmatchedPos = 0;
        i = jjMoveStringLiteralDfa0_3();
        if (true) goto _L1; else goto _L6
_L6:
        if ((jjtoSkip[jjmatchedKind >> 6] & 1L << (jjmatchedKind & 0x3f)) != 0L)
        {
            Token token2 = token3;
            if ((jjtoSpecial[jjmatchedKind >> 6] & 1L << (jjmatchedKind & 0x3f)) != 0L)
            {
                token2 = jjFillToken();
                if (token3 != null)
                {
                    token2.specialToken = token3;
                    token3.next = token2;
                }
            }
            k = i;
            token3 = token2;
            if (jjnewLexState[jjmatchedKind] != -1)
            {
                curLexState = jjnewLexState[jjmatchedKind];
                k = i;
                token3 = token2;
            }
        } else
        {
            MoreLexicalActions();
            if (jjnewLexState[jjmatchedKind] != -1)
            {
                curLexState = jjnewLexState[jjmatchedKind];
            }
            k = 0;
            i = 0;
            jjmatchedKind = 0x7fffffff;
            try
            {
                curChar = input_stream.readChar();
                continue; /* Loop/switch isn't completed */
            }
            catch (IOException ioexception1) { }
            break; /* Loop/switch isn't completed */
        }
        continue; /* Loop/switch isn't completed */
        if (true) goto _L8; else goto _L7
_L7:
        int l = input_stream.getEndLine();
        int j = input_stream.getEndColumn();
        Object obj = null;
        boolean flag = false;
        try
        {
            input_stream.readChar();
            input_stream.backup(1);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            flag = true;
            if (k <= 1)
            {
                obj = "";
            } else
            {
                obj = input_stream.GetImage();
            }
            if (curChar == '\n' || curChar == '\r')
            {
                l++;
                j = 0;
            } else
            {
                j++;
            }
        }
        if (!flag)
        {
            input_stream.backup(1);
            if (k <= 1)
            {
                obj = "";
            } else
            {
                obj = input_stream.GetImage();
            }
        }
        throw new TokenMgrError(flag, curLexState, l, j, ((String) (obj)), curChar, 0);
        if (true) goto _L10; else goto _L9
_L9:
    }

    protected Token jjFillToken()
    {
        Token token = Token.newToken(jjmatchedKind);
        token.kind = jjmatchedKind;
        String s1 = jjstrLiteralImages[jjmatchedKind];
        String s = s1;
        if (s1 == null)
        {
            s = input_stream.GetImage();
        }
        token.image = s;
        token.beginLine = input_stream.getBeginLine();
        token.beginColumn = input_stream.getBeginColumn();
        token.endLine = input_stream.getEndLine();
        token.endColumn = input_stream.getEndColumn();
        return token;
    }

}
