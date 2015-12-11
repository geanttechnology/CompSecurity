.class public final enum Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;
.super Ljava/lang/Enum;
.source "UserListFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/UserListFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "USER_LIST_MODE"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

.field public static final enum CLOSETS_SHARED_FIRST:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

.field public static final enum FB_FRIENDS_MODE:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

.field public static final enum LIKES_MODE:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

.field public static final enum NEWLY_JOINED_CLOSETS:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

.field public static final enum NEWLY_OPENED_CLOSETS:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

.field public static final enum PM_FOLLOWERS_MODE:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

.field public static final enum PM_FOLLOWING_MODE:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

.field public static final enum SEARCH_PEOPLE_MODE:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

.field public static final enum SECONDARY_SUGGESTED_USERS_MODE:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

.field public static final enum SUGGESTED_USERS_MODE:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

.field public static final enum TWITTER_FRIENDS_MODE:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 33
    new-instance v0, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    const-string v1, "SUGGESTED_USERS_MODE"

    invoke-direct {v0, v1, v3}, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->SUGGESTED_USERS_MODE:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    .line 34
    new-instance v0, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    const-string v1, "SECONDARY_SUGGESTED_USERS_MODE"

    invoke-direct {v0, v1, v4}, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->SECONDARY_SUGGESTED_USERS_MODE:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    .line 35
    new-instance v0, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    const-string v1, "FB_FRIENDS_MODE"

    invoke-direct {v0, v1, v5}, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->FB_FRIENDS_MODE:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    .line 36
    new-instance v0, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    const-string v1, "TWITTER_FRIENDS_MODE"

    invoke-direct {v0, v1, v6}, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->TWITTER_FRIENDS_MODE:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    .line 37
    new-instance v0, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    const-string v1, "PM_FOLLOWERS_MODE"

    invoke-direct {v0, v1, v7}, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->PM_FOLLOWERS_MODE:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    .line 38
    new-instance v0, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    const-string v1, "PM_FOLLOWING_MODE"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->PM_FOLLOWING_MODE:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    .line 39
    new-instance v0, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    const-string v1, "SEARCH_PEOPLE_MODE"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->SEARCH_PEOPLE_MODE:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    .line 40
    new-instance v0, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    const-string v1, "CLOSETS_SHARED_FIRST"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->CLOSETS_SHARED_FIRST:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    .line 41
    new-instance v0, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    const-string v1, "NEWLY_OPENED_CLOSETS"

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2}, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->NEWLY_OPENED_CLOSETS:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    .line 42
    new-instance v0, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    const-string v1, "NEWLY_JOINED_CLOSETS"

    const/16 v2, 0x9

    invoke-direct {v0, v1, v2}, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->NEWLY_JOINED_CLOSETS:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    .line 43
    new-instance v0, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    const-string v1, "LIKES_MODE"

    const/16 v2, 0xa

    invoke-direct {v0, v1, v2}, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->LIKES_MODE:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    .line 32
    const/16 v0, 0xb

    new-array v0, v0, [Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    sget-object v1, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->SUGGESTED_USERS_MODE:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    aput-object v1, v0, v3

    sget-object v1, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->SECONDARY_SUGGESTED_USERS_MODE:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    aput-object v1, v0, v4

    sget-object v1, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->FB_FRIENDS_MODE:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    aput-object v1, v0, v5

    sget-object v1, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->TWITTER_FRIENDS_MODE:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    aput-object v1, v0, v6

    sget-object v1, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->PM_FOLLOWERS_MODE:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->PM_FOLLOWING_MODE:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->SEARCH_PEOPLE_MODE:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->CLOSETS_SHARED_FIRST:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->NEWLY_OPENED_CLOSETS:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->NEWLY_JOINED_CLOSETS:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->LIKES_MODE:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    aput-object v2, v0, v1

    sput-object v0, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->$VALUES:[Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 32
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 32
    const-class v0, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    return-object v0
.end method

.method public static values()[Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;
    .locals 1

    .prologue
    .line 32
    sget-object v0, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->$VALUES:[Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    invoke-virtual {v0}, [Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    return-object v0
.end method
