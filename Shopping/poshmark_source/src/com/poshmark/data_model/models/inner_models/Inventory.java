// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models.inner_models;


public class Inventory
{
    public static final class ListingStatus extends Enum
    {

        private static final ListingStatus $VALUES[];
        public static final ListingStatus AVAILABLE;
        public static final ListingStatus NOT_FOR_SALE;
        public static final ListingStatus RESERVED;
        public static final ListingStatus SOLD;

        public static ListingStatus valueOf(String s)
        {
            return (ListingStatus)Enum.valueOf(com/poshmark/data_model/models/inner_models/Inventory$ListingStatus, s);
        }

        public static ListingStatus[] values()
        {
            return (ListingStatus[])$VALUES.clone();
        }

        static 
        {
            AVAILABLE = new ListingStatus("AVAILABLE", 0);
            SOLD = new ListingStatus("SOLD", 1);
            RESERVED = new ListingStatus("RESERVED", 2);
            NOT_FOR_SALE = new ListingStatus("NOT_FOR_SALE", 3);
            $VALUES = (new ListingStatus[] {
                AVAILABLE, SOLD, RESERVED, NOT_FOR_SALE
            });
        }

        private ListingStatus(String s, int i)
        {
            super(s, i);
        }
    }


    public Boolean caller_has_reserved;
    public String count;
    public String last_unit_reserved_at;
    public String status;
    public String status_changed_at;

    public Inventory()
    {
        caller_has_reserved = Boolean.valueOf(false);
    }

    public void copy(Inventory inventory)
    {
        count = inventory.count;
        status = inventory.status;
        status_changed_at = inventory.status_changed_at;
        last_unit_reserved_at = inventory.last_unit_reserved_at;
        caller_has_reserved = inventory.caller_has_reserved;
    }

    public ListingStatus getInventoryStatus()
    {
        ListingStatus listingstatus = ListingStatus.AVAILABLE;
        if (status.toLowerCase().equals("available"))
        {
            listingstatus = ListingStatus.AVAILABLE;
        } else
        {
            if (status.toLowerCase().equals("not_available"))
            {
                return ListingStatus.RESERVED;
            }
            if (status.toLowerCase().equals("sold_out"))
            {
                return ListingStatus.SOLD;
            }
            if (status.toLowerCase().equals("not_for_sale"))
            {
                return ListingStatus.NOT_FOR_SALE;
            }
        }
        return listingstatus;
    }
}
