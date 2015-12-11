.class final enum Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;
.super Ljava/lang/Enum;
.source "FeedItem.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/models/FeedItem;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401a
    name = "ViewLayoutType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

.field public static final enum VIEW_LAYOUT_TYPE_BRAND_MIFU_3_FLUID_LARGE_LEFT:Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

.field public static final enum VIEW_LAYOUT_TYPE_BRAND_MIFU_4_GRID:Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

.field public static final enum VIEW_LAYOUT_TYPE_BRAND_SIFU:Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

.field public static final enum VIEW_LAYOUT_TYPE_CLOSET_MIFU_3_FLUID_LARGE_LEFT:Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

.field public static final enum VIEW_LAYOUT_TYPE_CLOSET_MIFU_4_GRID:Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

.field public static final enum VIEW_LAYOUT_TYPE_CLOSET_SIFU:Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

.field public static final enum VIEW_LAYOUT_TYPE_COUNT:Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

.field public static final enum VIEW_LAYOUT_TYPE_MIFU_3_FLUID_LARGE_LEFT:Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

.field public static final enum VIEW_LAYOUT_TYPE_MIFU_4_GRID:Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

.field public static final enum VIEW_LAYOUT_TYPE_POSHPOST_SIFU_LEFT_TEXT_RIGHT:Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

.field public static final enum VIEW_LAYOUT_TYPE_SIFU:Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

.field public static final enum VIEW_LAYOUT_TYPE_SIFU_DOUBLE_HEADER:Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

.field public static final enum VIEW_LAYOUT_TYPE_SOCIAL:Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 262
    new-instance v0, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

    const-string v1, "VIEW_LAYOUT_TYPE_SOCIAL"

    invoke-direct {v0, v1, v3}, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;->VIEW_LAYOUT_TYPE_SOCIAL:Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

    .line 263
    new-instance v0, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

    const-string v1, "VIEW_LAYOUT_TYPE_SIFU"

    invoke-direct {v0, v1, v4}, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;->VIEW_LAYOUT_TYPE_SIFU:Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

    .line 264
    new-instance v0, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

    const-string v1, "VIEW_LAYOUT_TYPE_SIFU_DOUBLE_HEADER"

    invoke-direct {v0, v1, v5}, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;->VIEW_LAYOUT_TYPE_SIFU_DOUBLE_HEADER:Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

    .line 265
    new-instance v0, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

    const-string v1, "VIEW_LAYOUT_TYPE_MIFU_4_GRID"

    invoke-direct {v0, v1, v6}, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;->VIEW_LAYOUT_TYPE_MIFU_4_GRID:Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

    .line 266
    new-instance v0, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

    const-string v1, "VIEW_LAYOUT_TYPE_MIFU_3_FLUID_LARGE_LEFT"

    invoke-direct {v0, v1, v7}, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;->VIEW_LAYOUT_TYPE_MIFU_3_FLUID_LARGE_LEFT:Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

    .line 267
    new-instance v0, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

    const-string v1, "VIEW_LAYOUT_TYPE_BRAND_SIFU"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;->VIEW_LAYOUT_TYPE_BRAND_SIFU:Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

    .line 268
    new-instance v0, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

    const-string v1, "VIEW_LAYOUT_TYPE_BRAND_MIFU_4_GRID"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;->VIEW_LAYOUT_TYPE_BRAND_MIFU_4_GRID:Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

    .line 269
    new-instance v0, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

    const-string v1, "VIEW_LAYOUT_TYPE_BRAND_MIFU_3_FLUID_LARGE_LEFT"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;->VIEW_LAYOUT_TYPE_BRAND_MIFU_3_FLUID_LARGE_LEFT:Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

    .line 270
    new-instance v0, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

    const-string v1, "VIEW_LAYOUT_TYPE_CLOSET_SIFU"

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;->VIEW_LAYOUT_TYPE_CLOSET_SIFU:Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

    .line 271
    new-instance v0, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

    const-string v1, "VIEW_LAYOUT_TYPE_CLOSET_MIFU_4_GRID"

    const/16 v2, 0x9

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;->VIEW_LAYOUT_TYPE_CLOSET_MIFU_4_GRID:Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

    .line 272
    new-instance v0, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

    const-string v1, "VIEW_LAYOUT_TYPE_CLOSET_MIFU_3_FLUID_LARGE_LEFT"

    const/16 v2, 0xa

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;->VIEW_LAYOUT_TYPE_CLOSET_MIFU_3_FLUID_LARGE_LEFT:Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

    .line 273
    new-instance v0, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

    const-string v1, "VIEW_LAYOUT_TYPE_POSHPOST_SIFU_LEFT_TEXT_RIGHT"

    const/16 v2, 0xb

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;->VIEW_LAYOUT_TYPE_POSHPOST_SIFU_LEFT_TEXT_RIGHT:Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

    .line 274
    new-instance v0, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

    const-string v1, "VIEW_LAYOUT_TYPE_COUNT"

    const/16 v2, 0xc

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;->VIEW_LAYOUT_TYPE_COUNT:Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

    .line 261
    const/16 v0, 0xd

    new-array v0, v0, [Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

    sget-object v1, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;->VIEW_LAYOUT_TYPE_SOCIAL:Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;->VIEW_LAYOUT_TYPE_SIFU:Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;->VIEW_LAYOUT_TYPE_SIFU_DOUBLE_HEADER:Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

    aput-object v1, v0, v5

    sget-object v1, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;->VIEW_LAYOUT_TYPE_MIFU_4_GRID:Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

    aput-object v1, v0, v6

    sget-object v1, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;->VIEW_LAYOUT_TYPE_MIFU_3_FLUID_LARGE_LEFT:Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;->VIEW_LAYOUT_TYPE_BRAND_SIFU:Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;->VIEW_LAYOUT_TYPE_BRAND_MIFU_4_GRID:Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;->VIEW_LAYOUT_TYPE_BRAND_MIFU_3_FLUID_LARGE_LEFT:Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;->VIEW_LAYOUT_TYPE_CLOSET_SIFU:Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;->VIEW_LAYOUT_TYPE_CLOSET_MIFU_4_GRID:Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;->VIEW_LAYOUT_TYPE_CLOSET_MIFU_3_FLUID_LARGE_LEFT:Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;->VIEW_LAYOUT_TYPE_POSHPOST_SIFU_LEFT_TEXT_RIGHT:Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;->VIEW_LAYOUT_TYPE_COUNT:Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

    aput-object v2, v0, v1

    sput-object v0, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;->$VALUES:[Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

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
    .line 261
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 261
    const-class v0, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

    return-object v0
.end method

.method public static values()[Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;
    .locals 1

    .prologue
    .line 261
    sget-object v0, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;->$VALUES:[Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

    invoke-virtual {v0}, [Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

    return-object v0
.end method
