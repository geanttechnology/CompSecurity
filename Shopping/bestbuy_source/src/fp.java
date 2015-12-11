// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class fp
{

    public static final String a = (new StringBuilder()).append("create table IF NOT EXISTS ").append("user_profile").append(" ( ").append("uuid").append(" varchar , ").append("type").append(" varchar , ").append("created").append(" varchar , ").append("modified").append(" varchar , ").append("username").append(" varchar , ").append("activated").append(" varchar , ").append("locked").append(" varchar , ").append("invalidLogins").append(" varchar , ").append("transient").append(" varchar , ").append("firstName").append(" varchar , ").append("lastName").append(" varchar , ").append("lockedAt").append(" varchar , ").append("postalCode").append(" varchar , ").append("rzLinkStatus").append(" varchar , ").append("rzMemberId").append(" varchar , ").append("rzStatus").append(" varchar , ").append("rzTierStatus").append(" varchar , ").append("access_token").append(" varchar , ").append("expires_in").append(" varchar , ").append("cg_token").append(" varchar , ").append("cg_expires_in").append(" varchar , ").append("has_registry").append(" varchar , ").append("points_balance").append(" varchar , ").append("certs_value").append(" varchar , ").append("rz_tier_status").append(" varchar , ").append("rz_status").append(" varchar , ").append("rz_member_id").append(" varchar , ").append("registry_name").append(" varchar , ").append("is_attached_user").append(" varchar ").append(" )").toString();
    public static final String b = (new StringBuilder()).append("create table IF NOT EXISTS ").append("store_appointment_time").append(" ( ").append("appointment_id").append(" varchar , ").append("store_id").append(" varchar , ").append("store_name").append(" varchar , ").append("store_address").append(" varchar , ").append("store_city").append(" varchar , ").append("store_opentime").append(" varchar , ").append("appointment_time").append(" varchar , ").append("reminder_time").append(" varchar , ").append("survey_shown").append(" varchar ").append(" )").toString();

}
