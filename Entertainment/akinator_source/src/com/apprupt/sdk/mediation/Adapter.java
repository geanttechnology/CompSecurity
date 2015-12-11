// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk.mediation;

import android.app.Activity;
import org.json.JSONObject;

// Referenced classes of package com.apprupt.sdk.mediation:
//            Mediator

public interface Adapter
{
    public static final class Info extends Enum
    {

        private static final Info $VALUES[];
        public static final Info ADCOLONY;
        public static final Info ADMOB;
        public static final Info APPRUPT;
        public static final Info CLIPKIT;
        public static final Info DOUBLECLICK;
        public static final Info MOPUB;

        public static String[] defaultOrder()
        {
            String as[] = new String[values().length];
            as[0] = ADCOLONY.toString();
            as[1] = APPRUPT.toString();
            as[2] = ADMOB.toString();
            as[3] = DOUBLECLICK.toString();
            as[4] = MOPUB.toString();
            as[5] = CLIPKIT.toString();
            return as;
        }

        public static String[] names()
        {
            Info ainfo[] = values();
            String as[] = new String[ainfo.length];
            int j = 0;
            int k = ainfo.length;
            for (int i = 0; i < k; i++)
            {
                as[j] = ainfo[i].toString();
                j++;
            }

            return as;
        }

        public static Info valueOf(String s)
        {
            return (Info)Enum.valueOf(com/apprupt/sdk/mediation/Adapter$Info, s);
        }

        public static Info[] values()
        {
            return (Info[])$VALUES.clone();
        }

        public Info fromString(String s)
        {
            Info ainfo[] = values();
            int j = ainfo.length;
            for (int i = 0; i < j; i++)
            {
                Info info = ainfo[i];
                if (info.toString().equals(s))
                {
                    return info;
                }
            }

            return null;
        }

        public String toClassName()
        {
            static class _cls1
            {

                static final int $SwitchMap$com$apprupt$sdk$mediation$Adapter$Info[];

                static 
                {
                    $SwitchMap$com$apprupt$sdk$mediation$Adapter$Info = new int[Info.values().length];
                    try
                    {
                        $SwitchMap$com$apprupt$sdk$mediation$Adapter$Info[Info.APPRUPT.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror5) { }
                    try
                    {
                        $SwitchMap$com$apprupt$sdk$mediation$Adapter$Info[Info.ADCOLONY.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror4) { }
                    try
                    {
                        $SwitchMap$com$apprupt$sdk$mediation$Adapter$Info[Info.MOPUB.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        $SwitchMap$com$apprupt$sdk$mediation$Adapter$Info[Info.ADMOB.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$apprupt$sdk$mediation$Adapter$Info[Info.DOUBLECLICK.ordinal()] = 5;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$apprupt$sdk$mediation$Adapter$Info[Info.CLIPKIT.ordinal()] = 6;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls1..SwitchMap.com.apprupt.sdk.mediation.Adapter.Info[ordinal()])
            {
            default:
                return null;

            case 1: // '\001'
                return "com.apprupt.sdk.CvAdapter";

            case 2: // '\002'
                return "com.apprupt.sdk.AdColonyAdapter";

            case 3: // '\003'
                return "com.apprupt.mediation.mopub.Adapter";

            case 4: // '\004'
                return "com.apprupt.mediation.google.AdMobAdapter";

            case 5: // '\005'
                return "com.apprupt.mediation.google.DoubleclickAdapter";

            case 6: // '\006'
                return "com.apprupt.mediation.clipkit.Adapter";
            }
        }

        public String toString()
        {
            return super.toString().toLowerCase();
        }

        static 
        {
            APPRUPT = new Info("APPRUPT", 0);
            ADCOLONY = new Info("ADCOLONY", 1);
            MOPUB = new Info("MOPUB", 2);
            ADMOB = new Info("ADMOB", 3);
            DOUBLECLICK = new Info("DOUBLECLICK", 4);
            CLIPKIT = new Info("CLIPKIT", 5);
            $VALUES = (new Info[] {
                APPRUPT, ADCOLONY, MOPUB, ADMOB, DOUBLECLICK, CLIPKIT
            });
        }

        private Info(String s, int i)
        {
            super(s, i);
        }
    }


    public abstract boolean canMediate(Mediator mediator);

    public abstract void configure(JSONObject jsonobject);

    public abstract void init(Activity activity);

    public abstract boolean isActive();

    public abstract boolean isReadyToServe(Mediator mediator);

    public abstract void loadInlineAd(Mediator mediator);

    public abstract void loadInterstitialAd(Mediator mediator);

    public abstract String name();
}
