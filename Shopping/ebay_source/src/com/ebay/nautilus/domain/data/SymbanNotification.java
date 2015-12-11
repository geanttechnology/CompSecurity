// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.text.TextUtils;
import java.util.Date;

public interface SymbanNotification
{
    public static final class ActionEnum extends Enum
    {

        private static final ActionEnum $VALUES[];
        public static final ActionEnum BUY_NOW;
        public static final ActionEnum PAY_NOW;
        public static final ActionEnum PLACE_BID;
        public static final ActionEnum RAISE_BID;
        public static final ActionEnum REVIEW_OFFER;
        public static final ActionEnum SHIP_ITEM;
        public static final ActionEnum UPDATE_YOUR_INFO;
        public static final ActionEnum VIEW_ITEM;
        public static final ActionEnum VIEW_MESSAGE;
        public static final ActionEnum VIEW_ORDER;

        public static ActionEnum factory(String s)
        {
            ActionEnum aactionenum[] = values();
            int j = aactionenum.length;
            for (int i = 0; i < j; i++)
            {
                ActionEnum actionenum = aactionenum[i];
                if (TextUtils.equals(actionenum.name(), s))
                {
                    return actionenum;
                }
            }

            return null;
        }

        public static ActionEnum valueOf(String s)
        {
            return (ActionEnum)Enum.valueOf(com/ebay/nautilus/domain/data/SymbanNotification$ActionEnum, s);
        }

        public static ActionEnum[] values()
        {
            return (ActionEnum[])$VALUES.clone();
        }

        static 
        {
            BUY_NOW = new ActionEnum("BUY_NOW", 0);
            PAY_NOW = new ActionEnum("PAY_NOW", 1);
            PLACE_BID = new ActionEnum("PLACE_BID", 2);
            RAISE_BID = new ActionEnum("RAISE_BID", 3);
            REVIEW_OFFER = new ActionEnum("REVIEW_OFFER", 4);
            SHIP_ITEM = new ActionEnum("SHIP_ITEM", 5);
            VIEW_ITEM = new ActionEnum("VIEW_ITEM", 6);
            VIEW_ORDER = new ActionEnum("VIEW_ORDER", 7);
            VIEW_MESSAGE = new ActionEnum("VIEW_MESSAGE", 8);
            UPDATE_YOUR_INFO = new ActionEnum("UPDATE_YOUR_INFO", 9);
            $VALUES = (new ActionEnum[] {
                BUY_NOW, PAY_NOW, PLACE_BID, RAISE_BID, REVIEW_OFFER, SHIP_ITEM, VIEW_ITEM, VIEW_ORDER, VIEW_MESSAGE, UPDATE_YOUR_INFO
            });
        }

        private ActionEnum(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class MdnsNameEnum extends Enum
    {

        private static final MdnsNameEnum $VALUES[];
        public static final MdnsNameEnum BESTOFR;
        public static final MdnsNameEnum BIDITEM;
        public static final MdnsNameEnum BOACCPTD;
        public static final MdnsNameEnum BODECLND;
        public static final MdnsNameEnum CNTROFFR;
        public static final MdnsNameEnum COACCPTED;
        public static final MdnsNameEnum COCMPLT;
        public static final MdnsNameEnum CODECLND;
        public static final MdnsNameEnum ITMSHPD;
        public static final MdnsNameEnum ITMSOLD;
        public static final MdnsNameEnum ITMWON;
        public static final MdnsNameEnum MSGM2MMSGHDR;
        public static final MdnsNameEnum OFRDCLNDACPT;
        public static final MdnsNameEnum OFREXPIRED;
        public static final MdnsNameEnum OFRRETRACTED;
        public static final MdnsNameEnum OUTBID;
        public static final MdnsNameEnum SHOPCARTITM;
        public static final MdnsNameEnum UCI;
        public static final MdnsNameEnum WATCHITM;

        public static MdnsNameEnum factory(String s)
        {
            MdnsNameEnum amdnsnameenum[] = values();
            int j = amdnsnameenum.length;
            for (int i = 0; i < j; i++)
            {
                MdnsNameEnum mdnsnameenum = amdnsnameenum[i];
                if (TextUtils.equals(mdnsnameenum.name(), s))
                {
                    return mdnsnameenum;
                }
            }

            return null;
        }

        public static MdnsNameEnum valueOf(String s)
        {
            return (MdnsNameEnum)Enum.valueOf(com/ebay/nautilus/domain/data/SymbanNotification$MdnsNameEnum, s);
        }

        public static MdnsNameEnum[] values()
        {
            return (MdnsNameEnum[])$VALUES.clone();
        }

        static 
        {
            OUTBID = new MdnsNameEnum("OUTBID", 0);
            BIDITEM = new MdnsNameEnum("BIDITEM", 1);
            WATCHITM = new MdnsNameEnum("WATCHITM", 2);
            SHOPCARTITM = new MdnsNameEnum("SHOPCARTITM", 3);
            ITMWON = new MdnsNameEnum("ITMWON", 4);
            ITMSOLD = new MdnsNameEnum("ITMSOLD", 5);
            COCMPLT = new MdnsNameEnum("COCMPLT", 6);
            ITMSHPD = new MdnsNameEnum("ITMSHPD", 7);
            BESTOFR = new MdnsNameEnum("BESTOFR", 8);
            BODECLND = new MdnsNameEnum("BODECLND", 9);
            CNTROFFR = new MdnsNameEnum("CNTROFFR", 10);
            BOACCPTD = new MdnsNameEnum("BOACCPTD", 11);
            OFREXPIRED = new MdnsNameEnum("OFREXPIRED", 12);
            MSGM2MMSGHDR = new MdnsNameEnum("MSGM2MMSGHDR", 13);
            OFRRETRACTED = new MdnsNameEnum("OFRRETRACTED", 14);
            COACCPTED = new MdnsNameEnum("COACCPTED", 15);
            CODECLND = new MdnsNameEnum("CODECLND", 16);
            OFRDCLNDACPT = new MdnsNameEnum("OFRDCLNDACPT", 17);
            UCI = new MdnsNameEnum("UCI", 18);
            $VALUES = (new MdnsNameEnum[] {
                OUTBID, BIDITEM, WATCHITM, SHOPCARTITM, ITMWON, ITMSOLD, COCMPLT, ITMSHPD, BESTOFR, BODECLND, 
                CNTROFFR, BOACCPTD, OFREXPIRED, MSGM2MMSGHDR, OFRRETRACTED, COACCPTED, CODECLND, OFRDCLNDACPT, UCI
            });
        }

        private MdnsNameEnum(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class NameEnum extends Enum
    {

        private static final NameEnum $VALUES[];
        public static final NameEnum BEST_OFFER_ACCEPTED;
        public static final NameEnum BEST_OFFER_DECLINED;
        public static final NameEnum BEST_OFFER_RECEIVED;
        public static final NameEnum BID_ITEM_ENDING_SOON;
        public static final NameEnum BUYER_PAID;
        public static final NameEnum CART_ITEM_ENDING_SOON;
        public static final NameEnum COMPETING_BEST_OFFER_ACCEPTED;
        public static final NameEnum COUNTER_OFFER_ACCEPTED;
        public static final NameEnum COUNTER_OFFER_DECLINED;
        public static final NameEnum COUNTER_OFFER_RECEIVED;
        public static final NameEnum ITEM_SHIPPED;
        public static final NameEnum ITEM_SOLD;
        public static final NameEnum ITEM_WON;
        public static final NameEnum MESSAGE_RECEIVED;
        public static final NameEnum OFFER_EXPIRED;
        public static final NameEnum OFFER_RETRACTED;
        public static final NameEnum OUTBID;
        public static final NameEnum UPDATE_YOUR_INFO;
        public static final NameEnum WATCH_ITEM_ENDING_SOON;

        public static NameEnum factory(String s)
        {
            NameEnum anameenum[] = values();
            int j = anameenum.length;
            for (int i = 0; i < j; i++)
            {
                NameEnum nameenum = anameenum[i];
                if (TextUtils.equals(nameenum.name(), s))
                {
                    return nameenum;
                }
            }

            return null;
        }

        public static NameEnum valueOf(String s)
        {
            return (NameEnum)Enum.valueOf(com/ebay/nautilus/domain/data/SymbanNotification$NameEnum, s);
        }

        public static NameEnum[] values()
        {
            return (NameEnum[])$VALUES.clone();
        }

        static 
        {
            OUTBID = new NameEnum("OUTBID", 0);
            BID_ITEM_ENDING_SOON = new NameEnum("BID_ITEM_ENDING_SOON", 1);
            WATCH_ITEM_ENDING_SOON = new NameEnum("WATCH_ITEM_ENDING_SOON", 2);
            CART_ITEM_ENDING_SOON = new NameEnum("CART_ITEM_ENDING_SOON", 3);
            ITEM_WON = new NameEnum("ITEM_WON", 4);
            ITEM_SOLD = new NameEnum("ITEM_SOLD", 5);
            BUYER_PAID = new NameEnum("BUYER_PAID", 6);
            ITEM_SHIPPED = new NameEnum("ITEM_SHIPPED", 7);
            BEST_OFFER_RECEIVED = new NameEnum("BEST_OFFER_RECEIVED", 8);
            BEST_OFFER_DECLINED = new NameEnum("BEST_OFFER_DECLINED", 9);
            COUNTER_OFFER_RECEIVED = new NameEnum("COUNTER_OFFER_RECEIVED", 10);
            BEST_OFFER_ACCEPTED = new NameEnum("BEST_OFFER_ACCEPTED", 11);
            COUNTER_OFFER_ACCEPTED = new NameEnum("COUNTER_OFFER_ACCEPTED", 12);
            COUNTER_OFFER_DECLINED = new NameEnum("COUNTER_OFFER_DECLINED", 13);
            OFFER_EXPIRED = new NameEnum("OFFER_EXPIRED", 14);
            COMPETING_BEST_OFFER_ACCEPTED = new NameEnum("COMPETING_BEST_OFFER_ACCEPTED", 15);
            OFFER_RETRACTED = new NameEnum("OFFER_RETRACTED", 16);
            MESSAGE_RECEIVED = new NameEnum("MESSAGE_RECEIVED", 17);
            UPDATE_YOUR_INFO = new NameEnum("UPDATE_YOUR_INFO", 18);
            $VALUES = (new NameEnum[] {
                OUTBID, BID_ITEM_ENDING_SOON, WATCH_ITEM_ENDING_SOON, CART_ITEM_ENDING_SOON, ITEM_WON, ITEM_SOLD, BUYER_PAID, ITEM_SHIPPED, BEST_OFFER_RECEIVED, BEST_OFFER_DECLINED, 
                COUNTER_OFFER_RECEIVED, BEST_OFFER_ACCEPTED, COUNTER_OFFER_ACCEPTED, COUNTER_OFFER_DECLINED, OFFER_EXPIRED, COMPETING_BEST_OFFER_ACCEPTED, OFFER_RETRACTED, MESSAGE_RECEIVED, UPDATE_YOUR_INFO
            });
        }

        private NameEnum(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class StatusEnum extends Enum
    {

        private static final StatusEnum $VALUES[];
        public static final StatusEnum DELETED;
        public static final StatusEnum NEW;
        public static final StatusEnum READ;

        public static StatusEnum factory(String s)
        {
            StatusEnum astatusenum[] = values();
            int j = astatusenum.length;
            for (int i = 0; i < j; i++)
            {
                StatusEnum statusenum = astatusenum[i];
                if (TextUtils.equals(statusenum.name(), s))
                {
                    return statusenum;
                }
            }

            return null;
        }

        public static StatusEnum valueOf(String s)
        {
            return (StatusEnum)Enum.valueOf(com/ebay/nautilus/domain/data/SymbanNotification$StatusEnum, s);
        }

        public static StatusEnum[] values()
        {
            return (StatusEnum[])$VALUES.clone();
        }

        static 
        {
            READ = new StatusEnum("READ", 0);
            NEW = new StatusEnum("NEW", 1);
            DELETED = new StatusEnum("DELETED", 2);
            $VALUES = (new StatusEnum[] {
                READ, NEW, DELETED
            });
        }

        private StatusEnum(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class UiGroupEnum extends Enum
    {

        private static final UiGroupEnum $VALUES[];
        public static final UiGroupEnum UI_1;
        public static final UiGroupEnum UI_2;
        public static final UiGroupEnum UI_3;
        public static final UiGroupEnum UI_4;
        public static final UiGroupEnum UI_5;
        public static final UiGroupEnum UI_6;

        public static UiGroupEnum factory(String s)
        {
            UiGroupEnum auigroupenum[] = values();
            int j = auigroupenum.length;
            for (int i = 0; i < j; i++)
            {
                UiGroupEnum uigroupenum = auigroupenum[i];
                if (TextUtils.equals(uigroupenum.name(), s))
                {
                    return uigroupenum;
                }
            }

            return null;
        }

        public static UiGroupEnum valueOf(String s)
        {
            return (UiGroupEnum)Enum.valueOf(com/ebay/nautilus/domain/data/SymbanNotification$UiGroupEnum, s);
        }

        public static UiGroupEnum[] values()
        {
            return (UiGroupEnum[])$VALUES.clone();
        }

        static 
        {
            UI_1 = new UiGroupEnum("UI_1", 0);
            UI_2 = new UiGroupEnum("UI_2", 1);
            UI_3 = new UiGroupEnum("UI_3", 2);
            UI_4 = new UiGroupEnum("UI_4", 3);
            UI_5 = new UiGroupEnum("UI_5", 4);
            UI_6 = new UiGroupEnum("UI_6", 5);
            $VALUES = (new UiGroupEnum[] {
                UI_1, UI_2, UI_3, UI_4, UI_5, UI_6
            });
        }

        private UiGroupEnum(String s, int i)
        {
            super(s, i);
        }
    }


    public abstract ActionEnum getAction();

    public abstract String getContent();

    public abstract String getImageUrl();

    public abstract String getListingId();

    public abstract MdnsNameEnum getMdnsName();

    public abstract String getMessageId();

    public abstract String getNotificationId();

    public abstract Date getScheduledEndDate();

    public abstract String getTitle();

    public abstract String getTransactionId();

    public abstract UiGroupEnum getUiGroup();

    public abstract boolean isNew();
}
