// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.content.Context;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextValidator
{
    public static final class MODE extends Enum
    {

        private static final MODE $VALUES[];
        public static final MODE MODE_CREDITCARD;
        public static final MODE MODE_DOB;
        public static final MODE MODE_EMAIL;
        public static final MODE MODE_PASSWORD;
        public static final MODE MODE_SIMPLE;
        public static final MODE MODE_SIMPLE_NO_SPACES;
        public static final MODE MODE_SSN;
        public static final MODE MODE_USERNAME;
        public static final MODE MODE_ZIPCODE;

        public static MODE getMode(int i)
        {
            MODE mode = MODE_SIMPLE;
            switch (i)
            {
            default:
                return mode;

            case 1: // '\001'
                return MODE_SIMPLE;

            case 2: // '\002'
                return MODE_PASSWORD;

            case 3: // '\003'
                return MODE_EMAIL;

            case 4: // '\004'
                return MODE_SSN;

            case 5: // '\005'
                return MODE_ZIPCODE;

            case 6: // '\006'
                return MODE_DOB;

            case 7: // '\007'
                return MODE_CREDITCARD;

            case 8: // '\b'
                return MODE_USERNAME;

            case 9: // '\t'
                return MODE_SIMPLE_NO_SPACES;
            }
        }

        public static MODE valueOf(String s)
        {
            return (MODE)Enum.valueOf(com/poshmark/utils/TextValidator$MODE, s);
        }

        public static MODE[] values()
        {
            return (MODE[])$VALUES.clone();
        }

        static 
        {
            MODE_SIMPLE = new MODE("MODE_SIMPLE", 0);
            MODE_PASSWORD = new MODE("MODE_PASSWORD", 1);
            MODE_EMAIL = new MODE("MODE_EMAIL", 2);
            MODE_SSN = new MODE("MODE_SSN", 3);
            MODE_ZIPCODE = new MODE("MODE_ZIPCODE", 4);
            MODE_DOB = new MODE("MODE_DOB", 5);
            MODE_CREDITCARD = new MODE("MODE_CREDITCARD", 6);
            MODE_USERNAME = new MODE("MODE_USERNAME", 7);
            MODE_SIMPLE_NO_SPACES = new MODE("MODE_SIMPLE_NO_SPACES", 8);
            $VALUES = (new MODE[] {
                MODE_SIMPLE, MODE_PASSWORD, MODE_EMAIL, MODE_SSN, MODE_ZIPCODE, MODE_DOB, MODE_CREDITCARD, MODE_USERNAME, MODE_SIMPLE_NO_SPACES
            });
        }

        private MODE(String s, int i)
        {
            super(s, i);
        }
    }


    MODE validatorMode;

    public TextValidator()
    {
        validatorMode = MODE.MODE_SIMPLE;
    }

    private boolean validateCreditCardNumber(String s)
    {
        return !s.isEmpty() && s.length() >= 12 && s.length() <= 19;
    }

    private boolean validateEmail(String s)
    {
        return s != null && !s.isEmpty() && s.contains("@");
    }

    private boolean validatePassword(String s)
    {
        return s != null && !s.isEmpty() && s.length() >= 6 && s.length() <= 24;
    }

    private boolean validateSimple(String s)
    {
        return !s.isEmpty();
    }

    private boolean validateSimpleNoSpaces(String s)
    {
        if (!s.isEmpty())
        {
            if ((s = s.trim()) != null && s.length() > 0)
            {
                return true;
            }
        }
        return false;
    }

    private boolean validateUsername(String s)
    {
        return s != null && !s.isEmpty() && s.length() >= 3;
    }

    private boolean validateZipcode(String s)
    {
        return !s.isEmpty() && s.length() >= 5;
    }

    public String getErrorMessage(Context context, String s)
    {
        String s1;
        String s2;
        s1 = new String();
        s2 = s1;
        static class _cls1
        {

            static final int $SwitchMap$com$poshmark$utils$TextValidator$MODE[];

            static 
            {
                $SwitchMap$com$poshmark$utils$TextValidator$MODE = new int[MODE.values().length];
                try
                {
                    $SwitchMap$com$poshmark$utils$TextValidator$MODE[MODE.MODE_SIMPLE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$TextValidator$MODE[MODE.MODE_SIMPLE_NO_SPACES.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$TextValidator$MODE[MODE.MODE_PASSWORD.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$TextValidator$MODE[MODE.MODE_EMAIL.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$TextValidator$MODE[MODE.MODE_USERNAME.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$TextValidator$MODE[MODE.MODE_CREDITCARD.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$TextValidator$MODE[MODE.MODE_ZIPCODE.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$TextValidator$MODE[MODE.MODE_SSN.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$TextValidator$MODE[MODE.MODE_DOB.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.poshmark.utils.TextValidator.MODE[validatorMode.ordinal()];
        JVM INSTR tableswitch 1 9: default 72
    //                   1 75
    //                   2 75
    //                   3 78
    //                   4 113
    //                   5 139
    //                   6 75
    //                   7 75
    //                   8 75
    //                   9 75;
           goto _L1 _L2 _L2 _L3 _L4 _L5 _L2 _L2 _L2 _L2
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        s2 = s1;
_L7:
        return s2;
_L3:
        if (s.length() < 6)
        {
            return context.getString(0x7f0601c8);
        }
        s2 = s1;
        if (s.length() > 24)
        {
            return context.getString(0x7f0601c7);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        s2 = s1;
        if (!Pattern.compile("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$", 2).matcher(s).matches())
        {
            return context.getString(0x7f060277);
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (s.length() < 3)
        {
            s1 = context.getString(0x7f06027a);
        } else
        if (s.length() > 15)
        {
            s1 = context.getString(0x7f06027c);
        }
        s2 = s1;
        if (!s.matches("^[a-zA-Z0-9]*$"))
        {
            return context.getString(0x7f06027b);
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    public boolean isValid(String s)
    {
        switch (_cls1..SwitchMap.com.poshmark.utils.TextValidator.MODE[validatorMode.ordinal()])
        {
        default:
            return false;

        case 1: // '\001'
            return validateSimple(s);

        case 2: // '\002'
            return validateSimpleNoSpaces(s);

        case 3: // '\003'
            return validatePassword(s);

        case 4: // '\004'
            return validateEmail(s);

        case 5: // '\005'
            return validateUsername(s);

        case 6: // '\006'
            return validateCreditCardNumber(s);

        case 7: // '\007'
            return validateZipcode(s);
        }
    }

    public void setValidatorMode(MODE mode)
    {
        validatorMode = mode;
    }
}
