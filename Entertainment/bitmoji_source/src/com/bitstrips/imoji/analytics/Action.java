// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.analytics;


public final class Action extends Enum
{

    private static final Action $VALUES[];
    public static final Action ATTACH;
    public static final Action AVATAR_DISPLAY_FAILED;
    public static final Action AVATAR_NOT_FOUND;
    public static final Action AVATAR_SAVE_FAILED;
    public static final Action BEARDTONE_SAVED;
    public static final Action BEARDTONE_SELECTED;
    public static final Action BEARDTYPE_SAVED;
    public static final Action BEARDTYPE_SELECTED;
    public static final Action BITSHOP_OPENED;
    public static final Action BLUSHTONE_SAVED;
    public static final Action BLUSHTONE_SELECTED;
    public static final Action BODYHEIGHT_SAVED;
    public static final Action BODYHEIGHT_SELECTED;
    public static final Action BODYTYPE_SAVED;
    public static final Action BODYTYPE_SELECTED;
    public static final Action BREASTTYPE_SAVED;
    public static final Action BREASTTYPE_SELECTED;
    public static final Action BROWTONE_SAVED;
    public static final Action BROWTONE_SELECTED;
    public static final Action BUILDER_LOAD_FAILED;
    public static final Action BUTTON_NAVIGATION;
    public static final Action CHEEKDETAILS_SAVED;
    public static final Action CHEEKDETAILS_SELECTED;
    public static final Action CLICK;
    public static final Action CREATED;
    public static final Action DISABLE;
    public static final Action EARRINGTYPE_SAVED;
    public static final Action EARRINGTYPE_SELECTED;
    public static final Action EARTYPE_SAVED;
    public static final Action EARTYPE_SELECTED;
    public static final Action EYEBROWTYPE_SAVED;
    public static final Action EYEBROWTYPE_SELECTED;
    public static final Action EYEDETAILS_SAVED;
    public static final Action EYEDETAILS_SELECTED;
    public static final Action EYELASHTYPE_SAVED;
    public static final Action EYELASHTYPE_SELECTED;
    public static final Action EYESHADOWTONE_SAVED;
    public static final Action EYESHADOWTONE_SELECTED;
    public static final Action EYETYPE_SAVED;
    public static final Action EYETYPE_SELECTED;
    public static final Action FACELINES_SAVED;
    public static final Action FACELINES_SELECTED;
    public static final Action FACEPROPORTIONS_SAVED;
    public static final Action FACEPROPORTIONS_SELECTED;
    public static final Action GENDER_SAVED;
    public static final Action GENDER_SELECTED;
    public static final Action GLASSES_SAVED;
    public static final Action GLASSES_SELECTED;
    public static final Action HAIRACCESSORIES_SAVED;
    public static final Action HAIRACCESSORIES_SELECTED;
    public static final Action HAIRLENGTH_SAVED;
    public static final Action HAIRLENGTH_SELECTED;
    public static final Action HAIRSTYLE_SAVED;
    public static final Action HAIRSTYLE_SELECTED;
    public static final Action HAIRTONE_SAVED;
    public static final Action HAIRTONE_SELECTED;
    public static final Action HAIRTYPE_SAVED;
    public static final Action HAIRTYPE_SELECTED;
    public static final Action HAT_SAVED;
    public static final Action HAT_SELECTED;
    public static final Action INITIALIZE;
    public static final Action INVIEW;
    public static final Action JAWTYPE_SAVED;
    public static final Action JAWTYPE_SELECTED;
    public static final Action LAUNCH;
    public static final Action LINECOMBOS_SAVED;
    public static final Action LINECOMBOS_SELECTED;
    public static final Action LIPSTICKTONE_SAVED;
    public static final Action LIPSTICKTONE_SELECTED;
    public static final Action LOGIN;
    public static final Action LOGOUT;
    public static final Action MOUTHTYPE_SAVED;
    public static final Action MOUTHTYPE_SELECTED;
    public static final Action NEWUSER_SKIPS;
    public static final Action NOSETYPE_SAVED;
    public static final Action NOSETYPE_SELECTED;
    public static final Action NO_MESSENGER;
    public static final Action NO_THANKS;
    public static final Action OUTFIT_SAVED;
    public static final Action OUTFIT_SELECTED;
    public static final Action PREVIEW;
    public static final Action PUPILTONE_SAVED;
    public static final Action PUPILTONE_SELECTED;
    public static final Action PUPILTYPE_SAVED;
    public static final Action PUPILTYPE_SELECTED;
    public static final Action PURCHASE_CANCELLED;
    public static final Action PURCHASE_COMPLETED;
    public static final Action PURCHASE_FAILED;
    public static final Action PURCHASE_STARTED;
    public static final Action RATE_NOW;
    public static final Action REMIND_ME;
    public static final Action REPLY_SHARE;
    public static final Action ROTATEAVATAR_LEFT;
    public static final Action ROTATEAVATAR_RIGHT;
    public static final Action SAVE;
    public static final Action SELECTBOX_SELECTION;
    public static final Action SHARE;
    public static final Action SHARE_TO;
    public static final Action SIGN_UP;
    public static final Action SKINTONE_SAVED;
    public static final Action SKINTONE_SELECTED;
    public static final Action SKIP;
    public static final Action SWIPE_NAVIGATION;
    public static final Action YES_MESSENGER;
    private final String name;

    private Action(String s, int i, String s1)
    {
        super(s, i);
        name = s1;
    }

    public static boolean isUXAction(Action action)
    {
        return action == BUTTON_NAVIGATION || action == SWIPE_NAVIGATION || action == SELECTBOX_SELECTION || action == ROTATEAVATAR_LEFT || action == ROTATEAVATAR_RIGHT || action == NEWUSER_SKIPS;
    }

    public static Action valueOf(String s)
    {
        return (Action)Enum.valueOf(com/bitstrips/imoji/analytics/Action, s);
    }

    public static Action[] values()
    {
        return (Action[])$VALUES.clone();
    }

    public String toString()
    {
        return name;
    }

    static 
    {
        INITIALIZE = new Action("INITIALIZE", 0, "Initialize");
        SHARE = new Action("SHARE", 1, "Share");
        REPLY_SHARE = new Action("REPLY_SHARE", 2, "ReplyShare");
        PREVIEW = new Action("PREVIEW", 3, "Preview");
        INVIEW = new Action("INVIEW", 4, "Inview");
        SHARE_TO = new Action("SHARE_TO", 5, "Share to");
        ATTACH = new Action("ATTACH", 6, "Attach");
        CLICK = new Action("CLICK", 7, "Click");
        DISABLE = new Action("DISABLE", 8, "Disable");
        SAVE = new Action("SAVE", 9, "Save");
        CREATED = new Action("CREATED", 10, "Avatar Created");
        RATE_NOW = new Action("RATE_NOW", 11, "Rate Now");
        REMIND_ME = new Action("REMIND_ME", 12, "Remind Me");
        NO_THANKS = new Action("NO_THANKS", 13, "No Thanks");
        YES_MESSENGER = new Action("YES_MESSENGER", 14, "Yes FB Messenger Download");
        NO_MESSENGER = new Action("NO_MESSENGER", 15, "No FB Messenger Download");
        LOGIN = new Action("LOGIN", 16, "Login");
        LOGOUT = new Action("LOGOUT", 17, "Logout");
        SIGN_UP = new Action("SIGN_UP", 18, "Sign Up");
        LAUNCH = new Action("LAUNCH", 19, "Launch");
        AVATAR_NOT_FOUND = new Action("AVATAR_NOT_FOUND", 20, "Avatar Not Found");
        GENDER_SELECTED = new Action("GENDER_SELECTED", 21, "Gender_Selected");
        FACEPROPORTIONS_SELECTED = new Action("FACEPROPORTIONS_SELECTED", 22, "Faceproportions_Selected");
        SKINTONE_SELECTED = new Action("SKINTONE_SELECTED", 23, "Skintone_Selected");
        HAIRTONE_SELECTED = new Action("HAIRTONE_SELECTED", 24, "Hairtone_Selected");
        HAIRLENGTH_SELECTED = new Action("HAIRLENGTH_SELECTED", 25, "Hairlength_Selected");
        HAIRTYPE_SELECTED = new Action("HAIRTYPE_SELECTED", 26, "Hairtype_Selected");
        HAIRSTYLE_SELECTED = new Action("HAIRSTYLE_SELECTED", 27, "Hairstyle_Selected");
        JAWTYPE_SELECTED = new Action("JAWTYPE_SELECTED", 28, "Jawtype_Selected");
        EYEBROWTYPE_SELECTED = new Action("EYEBROWTYPE_SELECTED", 29, "Eyebrowtype_Selected");
        BROWTONE_SELECTED = new Action("BROWTONE_SELECTED", 30, "Browtone_Selected");
        EYETYPE_SELECTED = new Action("EYETYPE_SELECTED", 31, "Eyetype_Selected");
        EYELASHTYPE_SELECTED = new Action("EYELASHTYPE_SELECTED", 32, "Eyelashtype_Selected");
        PUPILTYPE_SELECTED = new Action("PUPILTYPE_SELECTED", 33, "Pupiltype_Selected");
        PUPILTONE_SELECTED = new Action("PUPILTONE_SELECTED", 34, "Pupiltone_Selected");
        NOSETYPE_SELECTED = new Action("NOSETYPE_SELECTED", 35, "Nosetype_Selected");
        MOUTHTYPE_SELECTED = new Action("MOUTHTYPE_SELECTED", 36, "Mouthtype_Selected");
        EARTYPE_SELECTED = new Action("EARTYPE_SELECTED", 37, "Eartype_Selected");
        EARRINGTYPE_SELECTED = new Action("EARRINGTYPE_SELECTED", 38, "Earringtype_Selected");
        LINECOMBOS_SELECTED = new Action("LINECOMBOS_SELECTED", 39, "Linecombos_Selected");
        BEARDTYPE_SELECTED = new Action("BEARDTYPE_SELECTED", 40, "Beardtype_Selected");
        BEARDTONE_SELECTED = new Action("BEARDTONE_SELECTED", 41, "Beardtone_Selected");
        EYEDETAILS_SELECTED = new Action("EYEDETAILS_SELECTED", 42, "Eyedetails_Selected");
        CHEEKDETAILS_SELECTED = new Action("CHEEKDETAILS_SELECTED", 43, "Cheekdetails_Selected");
        FACELINES_SELECTED = new Action("FACELINES_SELECTED", 44, "Facelines_Selected");
        BLUSHTONE_SELECTED = new Action("BLUSHTONE_SELECTED", 45, "Blushtone_Selected");
        EYESHADOWTONE_SELECTED = new Action("EYESHADOWTONE_SELECTED", 46, "Eyeshadowtone_Selected");
        LIPSTICKTONE_SELECTED = new Action("LIPSTICKTONE_SELECTED", 47, "Lipsticktone_Selected");
        GLASSES_SELECTED = new Action("GLASSES_SELECTED", 48, "Glasses_Selected");
        HAT_SELECTED = new Action("HAT_SELECTED", 49, "Hat_Selected");
        HAIRACCESSORIES_SELECTED = new Action("HAIRACCESSORIES_SELECTED", 50, "Hairaccessories_Selected");
        BODYHEIGHT_SELECTED = new Action("BODYHEIGHT_SELECTED", 51, "Bodyheight_Selected");
        BODYTYPE_SELECTED = new Action("BODYTYPE_SELECTED", 52, "Bodytype_Selected");
        BREASTTYPE_SELECTED = new Action("BREASTTYPE_SELECTED", 53, "Breasttype_Selected");
        OUTFIT_SELECTED = new Action("OUTFIT_SELECTED", 54, "Outfit_Selected");
        GENDER_SAVED = new Action("GENDER_SAVED", 55, "Gender_Saved");
        FACEPROPORTIONS_SAVED = new Action("FACEPROPORTIONS_SAVED", 56, "Faceproportions_Saved");
        SKINTONE_SAVED = new Action("SKINTONE_SAVED", 57, "Skintone_Saved");
        HAIRTONE_SAVED = new Action("HAIRTONE_SAVED", 58, "Hairtone_Saved");
        HAIRLENGTH_SAVED = new Action("HAIRLENGTH_SAVED", 59, "Hairlength_Saved");
        HAIRTYPE_SAVED = new Action("HAIRTYPE_SAVED", 60, "Hairtype_Saved");
        HAIRSTYLE_SAVED = new Action("HAIRSTYLE_SAVED", 61, "Hairstyle_Saved");
        JAWTYPE_SAVED = new Action("JAWTYPE_SAVED", 62, "Jawtype_Saved");
        EYEBROWTYPE_SAVED = new Action("EYEBROWTYPE_SAVED", 63, "Eyebrowtype_Saved");
        BROWTONE_SAVED = new Action("BROWTONE_SAVED", 64, "Browtone_Saved");
        EYETYPE_SAVED = new Action("EYETYPE_SAVED", 65, "Eyetype_Saved");
        EYELASHTYPE_SAVED = new Action("EYELASHTYPE_SAVED", 66, "Eyelashtype_Saved");
        PUPILTYPE_SAVED = new Action("PUPILTYPE_SAVED", 67, "Pupiltype_Saved");
        PUPILTONE_SAVED = new Action("PUPILTONE_SAVED", 68, "Pupiltone_Saved");
        NOSETYPE_SAVED = new Action("NOSETYPE_SAVED", 69, "Nosetype_Saved");
        MOUTHTYPE_SAVED = new Action("MOUTHTYPE_SAVED", 70, "Mouthtype_Saved");
        EARTYPE_SAVED = new Action("EARTYPE_SAVED", 71, "Eartype_Saved");
        EARRINGTYPE_SAVED = new Action("EARRINGTYPE_SAVED", 72, "Earringtype_Saved");
        LINECOMBOS_SAVED = new Action("LINECOMBOS_SAVED", 73, "Linecombos_Saved");
        BEARDTYPE_SAVED = new Action("BEARDTYPE_SAVED", 74, "Beardtype_Saved");
        BEARDTONE_SAVED = new Action("BEARDTONE_SAVED", 75, "Beardtone_Saved");
        EYEDETAILS_SAVED = new Action("EYEDETAILS_SAVED", 76, "Eyedetails_Saved");
        CHEEKDETAILS_SAVED = new Action("CHEEKDETAILS_SAVED", 77, "Cheekdetails_Saved");
        FACELINES_SAVED = new Action("FACELINES_SAVED", 78, "Facelines_Saved");
        BLUSHTONE_SAVED = new Action("BLUSHTONE_SAVED", 79, "Blushtone_Saved");
        EYESHADOWTONE_SAVED = new Action("EYESHADOWTONE_SAVED", 80, "Eyeshadowtone_Saved");
        LIPSTICKTONE_SAVED = new Action("LIPSTICKTONE_SAVED", 81, "Lipsticktone_Saved");
        GLASSES_SAVED = new Action("GLASSES_SAVED", 82, "Glasses_Saved");
        HAT_SAVED = new Action("HAT_SAVED", 83, "Hat_Saved");
        HAIRACCESSORIES_SAVED = new Action("HAIRACCESSORIES_SAVED", 84, "Hairaccessories_Saved");
        BODYHEIGHT_SAVED = new Action("BODYHEIGHT_SAVED", 85, "Bodyheight_Saved");
        BODYTYPE_SAVED = new Action("BODYTYPE_SAVED", 86, "Bodytype_Saved");
        BREASTTYPE_SAVED = new Action("BREASTTYPE_SAVED", 87, "Breasttype_Saved");
        OUTFIT_SAVED = new Action("OUTFIT_SAVED", 88, "Outfit_Saved");
        AVATAR_DISPLAY_FAILED = new Action("AVATAR_DISPLAY_FAILED", 89, "Avatar_Display_Failed");
        AVATAR_SAVE_FAILED = new Action("AVATAR_SAVE_FAILED", 90, "Avatar_Save_Failed");
        BUILDER_LOAD_FAILED = new Action("BUILDER_LOAD_FAILED", 91, "Builder_Load_Failed");
        BUTTON_NAVIGATION = new Action("BUTTON_NAVIGATION", 92, "Button_Navigation");
        SWIPE_NAVIGATION = new Action("SWIPE_NAVIGATION", 93, "Swipe_Navigation");
        SELECTBOX_SELECTION = new Action("SELECTBOX_SELECTION", 94, "SelectBox_Selection");
        ROTATEAVATAR_LEFT = new Action("ROTATEAVATAR_LEFT", 95, "RotateAvatar_Left");
        ROTATEAVATAR_RIGHT = new Action("ROTATEAVATAR_RIGHT", 96, "RotateAvatar_Right");
        NEWUSER_SKIPS = new Action("NEWUSER_SKIPS", 97, "NewUser_Skips");
        BITSHOP_OPENED = new Action("BITSHOP_OPENED", 98, "Opened");
        PURCHASE_STARTED = new Action("PURCHASE_STARTED", 99, "Purchase_Started");
        PURCHASE_CANCELLED = new Action("PURCHASE_CANCELLED", 100, "Purchase_Cancelled");
        PURCHASE_FAILED = new Action("PURCHASE_FAILED", 101, "Purchase_Failed");
        PURCHASE_COMPLETED = new Action("PURCHASE_COMPLETED", 102, "Purchase_Completed");
        SKIP = new Action("SKIP", 103, "Skip");
        $VALUES = (new Action[] {
            INITIALIZE, SHARE, REPLY_SHARE, PREVIEW, INVIEW, SHARE_TO, ATTACH, CLICK, DISABLE, SAVE, 
            CREATED, RATE_NOW, REMIND_ME, NO_THANKS, YES_MESSENGER, NO_MESSENGER, LOGIN, LOGOUT, SIGN_UP, LAUNCH, 
            AVATAR_NOT_FOUND, GENDER_SELECTED, FACEPROPORTIONS_SELECTED, SKINTONE_SELECTED, HAIRTONE_SELECTED, HAIRLENGTH_SELECTED, HAIRTYPE_SELECTED, HAIRSTYLE_SELECTED, JAWTYPE_SELECTED, EYEBROWTYPE_SELECTED, 
            BROWTONE_SELECTED, EYETYPE_SELECTED, EYELASHTYPE_SELECTED, PUPILTYPE_SELECTED, PUPILTONE_SELECTED, NOSETYPE_SELECTED, MOUTHTYPE_SELECTED, EARTYPE_SELECTED, EARRINGTYPE_SELECTED, LINECOMBOS_SELECTED, 
            BEARDTYPE_SELECTED, BEARDTONE_SELECTED, EYEDETAILS_SELECTED, CHEEKDETAILS_SELECTED, FACELINES_SELECTED, BLUSHTONE_SELECTED, EYESHADOWTONE_SELECTED, LIPSTICKTONE_SELECTED, GLASSES_SELECTED, HAT_SELECTED, 
            HAIRACCESSORIES_SELECTED, BODYHEIGHT_SELECTED, BODYTYPE_SELECTED, BREASTTYPE_SELECTED, OUTFIT_SELECTED, GENDER_SAVED, FACEPROPORTIONS_SAVED, SKINTONE_SAVED, HAIRTONE_SAVED, HAIRLENGTH_SAVED, 
            HAIRTYPE_SAVED, HAIRSTYLE_SAVED, JAWTYPE_SAVED, EYEBROWTYPE_SAVED, BROWTONE_SAVED, EYETYPE_SAVED, EYELASHTYPE_SAVED, PUPILTYPE_SAVED, PUPILTONE_SAVED, NOSETYPE_SAVED, 
            MOUTHTYPE_SAVED, EARTYPE_SAVED, EARRINGTYPE_SAVED, LINECOMBOS_SAVED, BEARDTYPE_SAVED, BEARDTONE_SAVED, EYEDETAILS_SAVED, CHEEKDETAILS_SAVED, FACELINES_SAVED, BLUSHTONE_SAVED, 
            EYESHADOWTONE_SAVED, LIPSTICKTONE_SAVED, GLASSES_SAVED, HAT_SAVED, HAIRACCESSORIES_SAVED, BODYHEIGHT_SAVED, BODYTYPE_SAVED, BREASTTYPE_SAVED, OUTFIT_SAVED, AVATAR_DISPLAY_FAILED, 
            AVATAR_SAVE_FAILED, BUILDER_LOAD_FAILED, BUTTON_NAVIGATION, SWIPE_NAVIGATION, SELECTBOX_SELECTION, ROTATEAVATAR_LEFT, ROTATEAVATAR_RIGHT, NEWUSER_SKIPS, BITSHOP_OPENED, PURCHASE_STARTED, 
            PURCHASE_CANCELLED, PURCHASE_FAILED, PURCHASE_COMPLETED, SKIP
        });
    }
}
