.class public final enum Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;
.super Ljava/lang/Enum;
.source "FeedItemStoryType.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "StoryType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

.field public static final enum BRAND_ADD_MIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

.field public static final enum BRAND_CHECKOUT_MIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

.field public static final enum BRAND_JUSTIN_MIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

.field public static final enum BRAND_LISTING_ADD_MIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

.field public static final enum BRAND_RECOMMEND_MIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

.field public static final enum CLOSET_ADD_MIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

.field public static final enum CLOSET_ADD_SIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

.field public static final enum CLOSET_ADD_SIFU_SOCIAL:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

.field public static final enum CLOSET_RECOMMEND_MIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

.field public static final enum CLOSET_UPDATE_MIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

.field public static final enum CLOSET_UPDATE_SIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

.field public static final enum CLOSET_UPDATE_SIFU_SOCIAL:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

.field public static final enum INVALID:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

.field public static final enum LISTING_SHARE_MIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

.field public static final enum LISTING_SHARE_SIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

.field public static final enum LISTING_SHARE_SIFU_SOCIAL:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

.field public static final enum POSHPOST_SIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

.field public static final enum SELF_SHARE_MIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

.field public static final enum SELF_SHARE_SIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

.field public static final enum SELF_SHARE_SIFU_SOCIAL:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 9
    new-instance v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    const-string v1, "CLOSET_ADD_SIFU"

    invoke-direct {v0, v1, v3}, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->CLOSET_ADD_SIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    .line 10
    new-instance v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    const-string v1, "CLOSET_ADD_SIFU_SOCIAL"

    invoke-direct {v0, v1, v4}, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->CLOSET_ADD_SIFU_SOCIAL:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    .line 11
    new-instance v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    const-string v1, "CLOSET_ADD_MIFU"

    invoke-direct {v0, v1, v5}, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->CLOSET_ADD_MIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    .line 12
    new-instance v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    const-string v1, "CLOSET_UPDATE_SIFU"

    invoke-direct {v0, v1, v6}, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->CLOSET_UPDATE_SIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    .line 13
    new-instance v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    const-string v1, "CLOSET_UPDATE_SIFU_SOCIAL"

    invoke-direct {v0, v1, v7}, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->CLOSET_UPDATE_SIFU_SOCIAL:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    .line 14
    new-instance v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    const-string v1, "CLOSET_UPDATE_MIFU"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->CLOSET_UPDATE_MIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    .line 15
    new-instance v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    const-string v1, "LISTING_SHARE_SIFU"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->LISTING_SHARE_SIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    .line 16
    new-instance v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    const-string v1, "LISTING_SHARE_SIFU_SOCIAL"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->LISTING_SHARE_SIFU_SOCIAL:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    .line 17
    new-instance v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    const-string v1, "LISTING_SHARE_MIFU"

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->LISTING_SHARE_MIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    .line 18
    new-instance v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    const-string v1, "SELF_SHARE_SIFU"

    const/16 v2, 0x9

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->SELF_SHARE_SIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    .line 19
    new-instance v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    const-string v1, "SELF_SHARE_SIFU_SOCIAL"

    const/16 v2, 0xa

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->SELF_SHARE_SIFU_SOCIAL:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    .line 20
    new-instance v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    const-string v1, "SELF_SHARE_MIFU"

    const/16 v2, 0xb

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->SELF_SHARE_MIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    .line 21
    new-instance v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    const-string v1, "BRAND_ADD_MIFU"

    const/16 v2, 0xc

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->BRAND_ADD_MIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    .line 22
    new-instance v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    const-string v1, "BRAND_RECOMMEND_MIFU"

    const/16 v2, 0xd

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->BRAND_RECOMMEND_MIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    .line 23
    new-instance v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    const-string v1, "BRAND_CHECKOUT_MIFU"

    const/16 v2, 0xe

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->BRAND_CHECKOUT_MIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    .line 24
    new-instance v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    const-string v1, "BRAND_LISTING_ADD_MIFU"

    const/16 v2, 0xf

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->BRAND_LISTING_ADD_MIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    .line 25
    new-instance v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    const-string v1, "BRAND_JUSTIN_MIFU"

    const/16 v2, 0x10

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->BRAND_JUSTIN_MIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    .line 26
    new-instance v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    const-string v1, "CLOSET_RECOMMEND_MIFU"

    const/16 v2, 0x11

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->CLOSET_RECOMMEND_MIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    .line 27
    new-instance v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    const-string v1, "POSHPOST_SIFU"

    const/16 v2, 0x12

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->POSHPOST_SIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    .line 28
    new-instance v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    const-string v1, "INVALID"

    const/16 v2, 0x13

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->INVALID:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    .line 8
    const/16 v0, 0x14

    new-array v0, v0, [Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    sget-object v1, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->CLOSET_ADD_SIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->CLOSET_ADD_SIFU_SOCIAL:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->CLOSET_ADD_MIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    aput-object v1, v0, v5

    sget-object v1, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->CLOSET_UPDATE_SIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    aput-object v1, v0, v6

    sget-object v1, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->CLOSET_UPDATE_SIFU_SOCIAL:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->CLOSET_UPDATE_MIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->LISTING_SHARE_SIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->LISTING_SHARE_SIFU_SOCIAL:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->LISTING_SHARE_MIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->SELF_SHARE_SIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->SELF_SHARE_SIFU_SOCIAL:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->SELF_SHARE_MIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->BRAND_ADD_MIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->BRAND_RECOMMEND_MIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    aput-object v2, v0, v1

    const/16 v1, 0xe

    sget-object v2, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->BRAND_CHECKOUT_MIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    aput-object v2, v0, v1

    const/16 v1, 0xf

    sget-object v2, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->BRAND_LISTING_ADD_MIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    aput-object v2, v0, v1

    const/16 v1, 0x10

    sget-object v2, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->BRAND_JUSTIN_MIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    aput-object v2, v0, v1

    const/16 v1, 0x11

    sget-object v2, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->CLOSET_RECOMMEND_MIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    aput-object v2, v0, v1

    const/16 v1, 0x12

    sget-object v2, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->POSHPOST_SIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    aput-object v2, v0, v1

    const/16 v1, 0x13

    sget-object v2, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->INVALID:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    aput-object v2, v0, v1

    sput-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->$VALUES:[Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

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
    .line 8
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 8
    const-class v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    return-object v0
.end method

.method public static values()[Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;
    .locals 1

    .prologue
    .line 8
    sget-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->$VALUES:[Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    invoke-virtual {v0}, [Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    return-object v0
.end method
