// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.content.Context;
import android.content.res.Resources;
import java.util.HashMap;

public class ar
{

    private static HashMap a;

    public static String a(Context context, String s)
    {
        if (a == null)
        {
            a();
        }
        int i;
        try
        {
            i = context.getResources().getIdentifier((new StringBuilder()).append("netswipe_").append(s).toString(), "string", context.getPackageName());
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return a(s);
        }
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        return a(s);
        context = context.getString(i);
        return context;
    }

    private static String a(String s)
    {
        if (a != null)
        {
            return (String)a.get(s);
        } else
        {
            return "";
        }
    }

    private static void a()
    {
        a = new HashMap();
        a.put("activity_title_scan", "Scan Card");
        a.put("activity_title_manual_entry", "Manual entry");
        a.put("activity_title_additional_info", "Additional info");
        a.put("error_view_button_scan_another_card", "Scan another card");
        a.put("error_view_button_try_again", "Try again");
        a.put("error_view_button_cancel", "Cancel");
        a.put("error_view_message_device_is_offline", "No Internet connection available");
        a.put("error_view_message_credit_card_not_supported", "Your card type is not accepted");
        a.put("error_view_message_credit_card_expired", "Your card is expired");
        a.put("error_view_message_card_not_detected", "Your card information could not be detected");
        a.put("error_view_message_auth_failed", "Authentication failed");
        a.put("error_view_message_unexpected_error", "The service is currently not available");
        a.put("error_view_message_request_failed", "We have encountered a network communication problem");
        a.put("error_view_message_startup_error", "Scanning not available at this time, please contact the app vendor");
        a.put("success_view_expiry_valid_through", "valid through");
        a.put("success_view_name", "Name:");
        a.put("success_view_sort_code", "Sort code:");
        a.put("success_view_account_number", "Account no:");
        a.put("help_view_accepted_creditcards", "Accepted cards");
        a.put("help_view_how_to", "Scan card with device camera");
        a.put("top_info_align_card", "Position front of card within the green brackets.");
        a.put("top_info_recognition", "Recognition in progress ...");
        a.put("top_info_validation", "Validation in progress ...");
        a.put("top_info_success", "Success");
        a.put("scan_area_use_front_of_card", "USE FRONT OF YOUR CARD");
        a.put("scan_area_card_holder", "Danielle Jumio");
        a.put("scan_area_valid_thru", "VALID\nTHRU");
        a.put("scan_area_expiry_date", "MM/YY");
        a.put("scan_area_creditcard_number", "1234 5678 9123 4567");
        a.put("manual_entry_card_number_invalid", "Invalid card number");
        a.put("manual_entry_card_number_not_supported", "Card type not accepted");
        a.put("manual_entry_button_finish", "Finish");
        a.put("manual_entry_cvv_cvc", "CVV/CVC");
        a.put("manual_entry_cardholder_name", "Card holder");
        a.put("manual_entry_credit_card", "Credit card number");
        a.put("manual_entry_hint_month", "MM");
        a.put("manual_entry_hint_year", "YY");
        a.put("manual_entry_valid_through", "Valid through");
    }
}
