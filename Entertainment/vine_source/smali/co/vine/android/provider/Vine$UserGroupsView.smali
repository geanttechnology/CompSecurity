.class public final Lco/vine/android/provider/Vine$UserGroupsView;
.super Ljava/lang/Object;
.source "Vine.java"

# interfaces
.implements Landroid/provider/BaseColumns;
.implements Lco/vine/android/provider/Vine$UserColumns;
.implements Lco/vine/android/provider/Vine$UserGroupColumns;
.implements Lco/vine/android/provider/Vine$UserSections;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/provider/Vine;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "UserGroupsView"
.end annotation


# static fields
.field public static final CONTENT_URI:Landroid/net/Uri;

.field public static final CONTENT_URI_ALL_FOLLOW:Landroid/net/Uri;

.field public static final CONTENT_URI_FIND_FRIENDS_ADDRESS:Landroid/net/Uri;

.field public static final CONTENT_URI_FIND_FRIENDS_TWITTER:Landroid/net/Uri;

.field public static final CONTENT_URI_FOLLOWERS:Landroid/net/Uri;

.field public static final CONTENT_URI_FOLLOWING:Landroid/net/Uri;

.field public static final CONTENT_URI_FRIENDS:Landroid/net/Uri;

.field public static final CONTENT_URI_FRIENDS_FILTER:Landroid/net/Uri;

.field public static final CONTENT_URI_LIKERS:Landroid/net/Uri;

.field public static final CONTENT_URI_REVINERS:Landroid/net/Uri;

.field public static final CONTENT_URI_USER_SEARCH_RESULTS:Landroid/net/Uri;

.field public static final SORT_ORDER_DEFAULT:Ljava/lang/String; = "_id ASC"

.field public static final SORT_ORDER_DEFAULT_IS_LAST:Ljava/lang/String; = "_id DESC"

.field public static final SORT_ORDER_DEFINED_ASCENDING:Ljava/lang/String; = "order_id ASC"

.field public static final SORT_ORDER_DEFINED_DESCENDING:Ljava/lang/String; = "order_id DESC"

.field public static final SORT_ORDER_DEFINED_DESCENDING_IS_LAST:Ljava/lang/String; = "order_id ASC"

.field public static final SORT_ORDER_DEFINED_LAST:Ljava/lang/String; = "order_id ASC"

.field public static final SORT_ORDER_FRIEND_REFRESH_FIRST:Ljava/lang/String; = "last_section_refresh DESC"

.field public static final SORT_ORDER_FRIEND_REFRESH_FIRST_THEN_FRIEND_INDEX:Ljava/lang/String; = "last_section_refresh DESC, section_index ASC"

.field static final TABLE_NAME:Ljava/lang/String; = "user_groups_view"

.field public static final USER_ID:Ljava/lang/String; = "user_id"


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 1195
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lco/vine/android/provider/Vine;->CONTENT_AUTHORITY:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "user_groups_view"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lco/vine/android/provider/Vine$UserGroupsView;->CONTENT_URI:Landroid/net/Uri;

    .line 1200
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lco/vine/android/provider/Vine;->CONTENT_AUTHORITY:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "user_groups_view"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/followers"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lco/vine/android/provider/Vine$UserGroupsView;->CONTENT_URI_FOLLOWERS:Landroid/net/Uri;

    .line 1203
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lco/vine/android/provider/Vine;->CONTENT_AUTHORITY:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "user_groups_view"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/following"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lco/vine/android/provider/Vine$UserGroupsView;->CONTENT_URI_FOLLOWING:Landroid/net/Uri;

    .line 1206
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lco/vine/android/provider/Vine;->CONTENT_AUTHORITY:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "user_groups_view"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/all_follow"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lco/vine/android/provider/Vine$UserGroupsView;->CONTENT_URI_ALL_FOLLOW:Landroid/net/Uri;

    .line 1209
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lco/vine/android/provider/Vine;->CONTENT_AUTHORITY:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "user_groups_view"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/friends"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lco/vine/android/provider/Vine$UserGroupsView;->CONTENT_URI_FRIENDS:Landroid/net/Uri;

    .line 1212
    sget-object v0, Lco/vine/android/provider/Vine$UserGroupsView;->CONTENT_URI_FRIENDS:Landroid/net/Uri;

    const-string v1, "filter"

    invoke-static {v0, v1}, Landroid/net/Uri;->withAppendedPath(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lco/vine/android/provider/Vine$UserGroupsView;->CONTENT_URI_FRIENDS_FILTER:Landroid/net/Uri;

    .line 1215
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lco/vine/android/provider/Vine;->CONTENT_AUTHORITY:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "user_groups_view"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/find_friends_twitter"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lco/vine/android/provider/Vine$UserGroupsView;->CONTENT_URI_FIND_FRIENDS_TWITTER:Landroid/net/Uri;

    .line 1218
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lco/vine/android/provider/Vine;->CONTENT_AUTHORITY:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "user_groups_view"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/find_friends_address"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lco/vine/android/provider/Vine$UserGroupsView;->CONTENT_URI_FIND_FRIENDS_ADDRESS:Landroid/net/Uri;

    .line 1221
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lco/vine/android/provider/Vine;->CONTENT_AUTHORITY:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "user_groups_view"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/likers"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lco/vine/android/provider/Vine$UserGroupsView;->CONTENT_URI_LIKERS:Landroid/net/Uri;

    .line 1224
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lco/vine/android/provider/Vine;->CONTENT_AUTHORITY:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "user_groups_view"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/reviners"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lco/vine/android/provider/Vine$UserGroupsView;->CONTENT_URI_REVINERS:Landroid/net/Uri;

    .line 1227
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lco/vine/android/provider/Vine;->CONTENT_AUTHORITY:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "user_groups_view"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/user_search_results"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lco/vine/android/provider/Vine$UserGroupsView;->CONTENT_URI_USER_SEARCH_RESULTS:Landroid/net/Uri;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 1188
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
