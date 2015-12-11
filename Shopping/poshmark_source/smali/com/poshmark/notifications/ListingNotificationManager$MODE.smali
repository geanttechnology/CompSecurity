.class public final enum Lcom/poshmark/notifications/ListingNotificationManager$MODE;
.super Ljava/lang/Enum;
.source "ListingNotificationManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/notifications/ListingNotificationManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "MODE"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/poshmark/notifications/ListingNotificationManager$MODE;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/poshmark/notifications/ListingNotificationManager$MODE;

.field public static final enum LISTING_COMMENT_ADDED:Lcom/poshmark/notifications/ListingNotificationManager$MODE;

.field public static final enum LISTING_EDITED:Lcom/poshmark/notifications/ListingNotificationManager$MODE;

.field public static final enum LISTING_LIKED:Lcom/poshmark/notifications/ListingNotificationManager$MODE;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 39
    new-instance v0, Lcom/poshmark/notifications/ListingNotificationManager$MODE;

    const-string v1, "LISTING_EDITED"

    invoke-direct {v0, v1, v2}, Lcom/poshmark/notifications/ListingNotificationManager$MODE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/notifications/ListingNotificationManager$MODE;->LISTING_EDITED:Lcom/poshmark/notifications/ListingNotificationManager$MODE;

    new-instance v0, Lcom/poshmark/notifications/ListingNotificationManager$MODE;

    const-string v1, "LISTING_LIKED"

    invoke-direct {v0, v1, v3}, Lcom/poshmark/notifications/ListingNotificationManager$MODE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/notifications/ListingNotificationManager$MODE;->LISTING_LIKED:Lcom/poshmark/notifications/ListingNotificationManager$MODE;

    new-instance v0, Lcom/poshmark/notifications/ListingNotificationManager$MODE;

    const-string v1, "LISTING_COMMENT_ADDED"

    invoke-direct {v0, v1, v4}, Lcom/poshmark/notifications/ListingNotificationManager$MODE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/notifications/ListingNotificationManager$MODE;->LISTING_COMMENT_ADDED:Lcom/poshmark/notifications/ListingNotificationManager$MODE;

    const/4 v0, 0x3

    new-array v0, v0, [Lcom/poshmark/notifications/ListingNotificationManager$MODE;

    sget-object v1, Lcom/poshmark/notifications/ListingNotificationManager$MODE;->LISTING_EDITED:Lcom/poshmark/notifications/ListingNotificationManager$MODE;

    aput-object v1, v0, v2

    sget-object v1, Lcom/poshmark/notifications/ListingNotificationManager$MODE;->LISTING_LIKED:Lcom/poshmark/notifications/ListingNotificationManager$MODE;

    aput-object v1, v0, v3

    sget-object v1, Lcom/poshmark/notifications/ListingNotificationManager$MODE;->LISTING_COMMENT_ADDED:Lcom/poshmark/notifications/ListingNotificationManager$MODE;

    aput-object v1, v0, v4

    sput-object v0, Lcom/poshmark/notifications/ListingNotificationManager$MODE;->$VALUES:[Lcom/poshmark/notifications/ListingNotificationManager$MODE;

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
    .line 39
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/poshmark/notifications/ListingNotificationManager$MODE;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 39
    const-class v0, Lcom/poshmark/notifications/ListingNotificationManager$MODE;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/poshmark/notifications/ListingNotificationManager$MODE;

    return-object v0
.end method

.method public static values()[Lcom/poshmark/notifications/ListingNotificationManager$MODE;
    .locals 1

    .prologue
    .line 39
    sget-object v0, Lcom/poshmark/notifications/ListingNotificationManager$MODE;->$VALUES:[Lcom/poshmark/notifications/ListingNotificationManager$MODE;

    invoke-virtual {v0}, [Lcom/poshmark/notifications/ListingNotificationManager$MODE;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/poshmark/notifications/ListingNotificationManager$MODE;

    return-object v0
.end method
