// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import java.util.HashMap;

// Referenced classes of package jumiomobile:
//            cl

public class mk extends cl
{

    public mk()
    {
        b = "netverify_";
        a.put("search", "Search");
        a.put("choose_country", "Choose Country");
        a.put("error_network_problems", "We have encountered a network communication problem");
        a.put("error_auth_failed", "Authentication failed");
        a.put("error_device_is_offline", "No internet connection available");
        a.put("error_startup_error", "Scanning not available at this time, please contact the app vendor");
        a.put("error_cancelled_by_user", "Cancelled by end-user");
        a.put("error_no_camera_connection", "The camera is currently not available");
        a.put("error_saving_instance_not_supported", "Saving instance is not supported");
        a.put("button_retry", "Retry");
        a.put("button_cancel", "Cancel");
        a.put("button_select_another_country", "Select another country");
        a.put("button_select_country", "Select country");
        a.put("button_submit", "Submit");
        a.put("button_change_photos", "Change photos");
        a.put("button_done", "Done");
        a.put("documenttype_passport", "Passport");
        a.put("documenttype_visa", "Visa");
        a.put("documenttype_idcard", "Identity card");
        a.put("documenttype_driverlicense", "Driver license");
        a.put("documentvariant_paper_idcard", "Paper identity card");
        a.put("documentvariant_plastic_idcard", "Plastic identity card");
        a.put("documentvariant_paper_driverlicense", "Paper driver license");
        a.put("documentvariant_plastic_driverlicense", "Plastic driver license");
        a.put("empty_list", "No data in list");
        a.put("actionbar_title_loading", "Loading");
        a.put("actionbar_title_country", "Issuing country");
        a.put("actionbar_title_documenttype", "Document type");
        a.put("actionbar_title_documentvariant", "Document style");
        a.put("actionbar_title_scan", "Scan your ID");
        a.put("actionbar_title_scan_face", "Scan your face");
        a.put("actionbar_title_upload", "Upload");
        a.put("actionbar_title_submission", "Submission");
        a.put("actionbar_title_finished", "Finished");
        a.put("actionbar_title_barcode", "Scan Barcode");
        a.put("front", "Front");
        a.put("back", "Back");
        a.put("face", "Face");
        a.put("take_photo_front", "Tap to take or use an existing photo of the document's front.");
        a.put("take_photo_back", "Tap to take or use an existing photo of the document's back.");
        a.put("take_photo_face", "Tap to take a photo of your face.");
        a.put("change_photo_front", "Tap to change the photo of the document's front.");
        a.put("change_photo_back", "Tap to change the photo of the document's back.");
        a.put("change_photo_face", "Tap to retake the photo of your face.");
        a.put("photo_not_necessary", "Not necessary to take a photo.");
        a.put("infobar_issuer_country", "Confirm or select the issuing country of the ID you want to verify");
        a.put("infobar_document_type", "Select the type of ID you wish to scan");
        a.put("infobar_document_variant", "Select the style of ID you wish to scan");
        a.put("infobar_camera_view_idcard", "Place identity card within brackets");
        a.put("infobar_camera_view_driverlicense", "Place driver license within brackets");
        a.put("infobar_camera_view_passport", "Place passport within the brackets");
        a.put("infobar_camera_view_front_idcard_templatematcher", "Place front of your identity card within the frame");
        a.put("infobar_camera_view_back_idcard_templatematcher", "Place back of your identity card within the frame");
        a.put("infobar_camera_view_front_driverlicense_templatematcher", "Place front of your driver license within the frame");
        a.put("infobar_camera_view_back_driverlicense_templatematcher", "Place back of your driver license within the frame");
        a.put("infobar_camera_view_front_passport", "Place front of your passport within the frame");
        a.put("infobar_camera_view_back_passport", "Place back of your passport within the frame");
        a.put("infobar_camera_view_passport_frame", "Place passport within the frame");
        a.put("infobar_camera_view_visa_frame", "Place the visa within the frame");
        a.put("infobar_camera_view_face", "Place your face in front of the camera and take the photo.");
        a.put("infobar_camera_view_face_liveness", "Position face close to the overlay for 5 sec to scan.");
        a.put("infobar_camera_view_barcode_driverlicense", "Scan the bar code on the back");
        a.put("infobar_camera_view_manual", "Please scan the main info page of your document");
        a.put("infobar_extraction_in_progress", "Extraction in progress ...");
        a.put("infobar_processing_image", "Processing image ...");
        a.put("infobar_help_button", "Help");
        a.put("use_front_side_of_card", "USE FRONT OF YOUR CARD");
        a.put("use_back_side_of_card", "USE BACK OF YOUR CARD");
        a.put("overlay_liveness_advice", "Move your eyes or blink");
        a.put("submission_uploading", "Your submission has been encrypted and is being securely uploaded to our servers. This may take some time.");
        a.put("submission_complete", "Thank you! Your submission was successfully received.");
        a.put("submission_error", "There was an error during the upload. You may check your internet connection and retry.");
        a.put("milestone_upload", "Upload");
        a.put("milestone_finish", "Finish");
        a.put("help_view_passport", "Your personal info is on the passport photo page. The code is at the bottom.");
        a.put("help_view_visa", "Your personal info is on the visa page. The code is at the bottom.");
        a.put("help_view_idcard", "The code of the identity card is at the bottom.");
        a.put("help_view_mrz", "Please make sure to fit the entire code within the green highlighted area.");
        a.put("help_view_driverlicense_mrz", "The code of the driver license is at the bottom.");
        a.put("help_view_driverlicense_barcode", "Scan the bar code in the highlighted green section.");
        a.put("help_view_linefind", "How to do it the right way.");
        a.put("help_view_liveness_line1", "Place your face within the frame to start the scanning process.");
        a.put("help_view_liveness_line2", "Blink twice to complete the scanning process.");
        a.put("help_view_liveness_line3", "The scanning takes 5 seconds.");
        a.put("help_view_fallback_button_mrz", "There is no code on my ID");
        a.put("help_view_fallback_button_mrv", "I'm not able to scan my VISA");
        a.put("help_view_fallback_button_barcode", "No barcode on my document");
        a.put("help_view_templatematcher_dl_line1", "Make sure not to crop the driver license while trying to get as close as possible.");
        a.put("help_view_templatematcher_dl_line2", "Bring the driver license fully into the camera frame and it will be automatically detected.");
        a.put("help_view_templatematcher_id_line1", "Make sure not to crop the ID card while trying to get as close as possible.");
        a.put("help_view_templatematcher_id_line2", "Bring the ID card fully into the camera frame and it will be automatically detected.");
        a.put("help_view_templatematcher_fallback", "Detection not working");
        a.put("confirm_linefinder_result_title", "Please make sure all data is readable. If not, please retry.");
        a.put("require_us_address_title", "Please scan the front of your driver license");
        a.put("require_us_address_message", "The barcode did not contain your address. Scan the front of your driver license where the address is shown.");
        a.put("require_us_address_button", "Scan front");
        a.put("dialog_title_error", "Error");
    }
}
