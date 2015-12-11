// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now;


// Referenced classes of package com.amazon.now:
//            R

public static final class 
{

    public static final int action_bar = 0x7f030000;
    public static final int action_bar_header = 0x7f030001;
    public static final int apwebviewlayout = 0x7f030002;
    public static final int browse_list_header = 0x7f030003;
    public static final int browse_list_item = 0x7f030004;
    public static final int cookie_add_layout = 0x7f030005;
    public static final int cookie_edit_view = 0x7f030006;
    public static final int cookie_list_item = 0x7f030007;
    public static final int debug_detail_page_settings = 0x7f030008;
    public static final int debug_settings = 0x7f030009;
    public static final int embedded_browser_container = 0x7f03000a;
    public static final int feature_list_item = 0x7f03000b;
    public static final int fullscreen_gallery = 0x7f03000c;
    public static final int gallery_product_items = 0x7f03000d;
    public static final int grid_product_items = 0x7f03000e;
    public static final int item_message = 0x7f03000f;
    public static final int left_nav = 0x7f030010;
    public static final int left_nav_menu_divider = 0x7f030011;
    public static final int left_nav_menu_location = 0x7f030012;
    public static final int left_nav_menu_logo = 0x7f030013;
    public static final int left_nav_menu_normal = 0x7f030014;
    public static final int left_nav_menu_spacer = 0x7f030015;
    public static final int left_nav_menu_stores = 0x7f030016;
    public static final int list_product_items = 0x7f030017;
    public static final int list_product_items_consumables = 0x7f030018;
    public static final int loading_spinner = 0x7f030019;
    public static final int map_activity = 0x7f03001a;
    public static final int now_error_box = 0x7f03001b;
    public static final int refinements_child_dds = 0x7f03001c;
    public static final int refinements_child_regular = 0x7f03001d;
    public static final int refinements_filter_item = 0x7f03001e;
    public static final int refinements_group = 0x7f03001f;
    public static final int refinements_menu = 0x7f030020;
    public static final int result_header = 0x7f030021;
    public static final int retail_search_layout = 0x7f030022;
    public static final int rs_action_bar_query_entry = 0x7f030023;
    public static final int rs_brand_cell = 0x7f030024;
    public static final int rs_brand_strip = 0x7f030025;
    public static final int rs_corrections_fkmr_header = 0x7f030026;
    public static final int rs_corrections_mixed = 0x7f030027;
    public static final int rs_corrections_no_results = 0x7f030028;
    public static final int rs_corrections_spell_corrected = 0x7f030029;
    public static final int rs_corrections_spell_corrected_footer = 0x7f03002a;
    public static final int rs_debug_settings = 0x7f03002b;
    public static final int rs_debug_spinner_item = 0x7f03002c;
    public static final int rs_detail_page_webview = 0x7f03002d;
    public static final int rs_entry_action_divider = 0x7f03002e;
    public static final int rs_entry_btn = 0x7f03002f;
    public static final int rs_external_widget_slot_nav_bar_above_rib = 0x7f030030;
    public static final int rs_fast_browse_menu = 0x7f030031;
    public static final int rs_fast_browse_menu_item = 0x7f030032;
    public static final int rs_horizontal_stack_view = 0x7f030033;
    public static final int rs_immersive_product_items = 0x7f030034;
    public static final int rs_inline_actions = 0x7f030035;
    public static final int rs_inline_actions_immersive = 0x7f030036;
    public static final int rs_iss_row_action = 0x7f030037;
    public static final int rs_iss_row_suggestion = 0x7f030038;
    public static final int rs_multi_store_item = 0x7f030039;
    public static final int rs_multi_store_layout = 0x7f03003a;
    public static final int rs_multi_store_see_more = 0x7f03003b;
    public static final int rs_past_purchases = 0x7f03003c;
    public static final int rs_quantity_changer = 0x7f03003d;
    public static final int rs_quantity_changer_list_item = 0x7f03003e;
    public static final int rs_related_searches = 0x7f03003f;
    public static final int rs_request_error = 0x7f030040;
    public static final int rs_results_availability_gallery = 0x7f030041;
    public static final int rs_results_availability_grid = 0x7f030042;
    public static final int rs_results_availability_list = 0x7f030043;
    public static final int rs_results_consumable_messaging = 0x7f030044;
    public static final int rs_results_consumable_price_list = 0x7f030045;
    public static final int rs_results_count_text = 0x7f030046;
    public static final int rs_results_display_fragment = 0x7f030047;
    public static final int rs_results_display_fragment_compat = 0x7f030048;
    public static final int rs_results_image_wrapper_consumable_list = 0x7f030049;
    public static final int rs_results_image_wrapper_gallery = 0x7f03004a;
    public static final int rs_results_image_wrapper_grid = 0x7f03004b;
    public static final int rs_results_image_wrapper_list = 0x7f03004c;
    public static final int rs_results_image_wrapper_sim = 0x7f03004d;
    public static final int rs_results_image_wrapper_split = 0x7f03004e;
    public static final int rs_results_price_gallery = 0x7f03004f;
    public static final int rs_results_price_grid = 0x7f030050;
    public static final int rs_results_price_list = 0x7f030051;
    public static final int rs_results_price_split = 0x7f030052;
    public static final int rs_results_prime_options_container = 0x7f030053;
    public static final int rs_results_prime_options_item = 0x7f030054;
    public static final int rs_search_dropdown_item_scan_snap = 0x7f030055;
    public static final int rs_search_entry_bar = 0x7f030056;
    public static final int rs_search_entry_view = 0x7f030057;
    public static final int rs_search_spinner = 0x7f030058;
    public static final int rs_sims_layout = 0x7f030059;
    public static final int rs_stack_view_container = 0x7f03005a;
    public static final int rs_twister_list_item = 0x7f03005b;
    public static final int rs_twister_menu = 0x7f03005c;
    public static final int rs_vertical_stack_view = 0x7f03005d;
    public static final int rs_widget_image_sparkle = 0x7f03005e;
    public static final int rs_widget_sparkle = 0x7f03005f;
    public static final int rs_widget_text_sparkle = 0x7f030060;
    public static final int search_page_root = 0x7f030061;
    public static final int split_product_items = 0x7f030062;
    public static final int vs_dialog = 0x7f030063;
    public static final int vs_dialog_head = 0x7f030064;
    public static final int vs_dialog_title = 0x7f030065;
    public static final int vs_disambig = 0x7f030066;
    public static final int vs_interp = 0x7f030067;
    public static final int vs_low_confidence = 0x7f030068;
    public static final int vs_nav_voice_btn = 0x7f030069;
    public static final int vs_nav_voice_btn_stub = 0x7f03006a;
    public static final int vs_negative_result = 0x7f03006b;
    public static final int vs_network_error = 0x7f03006c;
    public static final int vs_no_speech = 0x7f03006d;
    public static final int vs_rescue_buttons = 0x7f03006e;
    public static final int vs_speak = 0x7f03006f;
    public static final int vs_tab_nav_voice_btn = 0x7f030070;
    public static final int vs_tab_nav_voice_btn_stub = 0x7f030071;
    public static final int vs_time_error = 0x7f030072;
    public static final int vs_voice_search_btn = 0x7f030073;
    public static final int web_fragment = 0x7f030074;
    public static final int weblab_settings = 0x7f030075;
    public static final int welcome_screen = 0x7f030076;
    public static final int zip_text_input = 0x7f030077;

    public ()
    {
    }
}
