.class public final enum Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;
.super Ljava/lang/Enum;
.source "FeedItemImageLayout.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/models/FeedItemImageLayout;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Layout"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

.field public static final enum Invalid:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

.field public static final enum MIFU_3_FLUID_LARGE_LEFT:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

.field public static final enum MIFU_4_GRID:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

.field public static final enum SIFU_LEFT_IMAGE_RIGHT_TEXT:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

.field public static final enum SIFU_SOCIAL:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

.field public static final enum SIFU_SUMMARY:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 8
    new-instance v0, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    const-string v1, "SIFU_SUMMARY"

    invoke-direct {v0, v1, v3}, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;->SIFU_SUMMARY:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    .line 9
    new-instance v0, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    const-string v1, "SIFU_SOCIAL"

    invoke-direct {v0, v1, v4}, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;->SIFU_SOCIAL:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    .line 10
    new-instance v0, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    const-string v1, "MIFU_3_FLUID_LARGE_LEFT"

    invoke-direct {v0, v1, v5}, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;->MIFU_3_FLUID_LARGE_LEFT:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    .line 11
    new-instance v0, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    const-string v1, "MIFU_4_GRID"

    invoke-direct {v0, v1, v6}, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;->MIFU_4_GRID:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    .line 12
    new-instance v0, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    const-string v1, "SIFU_LEFT_IMAGE_RIGHT_TEXT"

    invoke-direct {v0, v1, v7}, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;->SIFU_LEFT_IMAGE_RIGHT_TEXT:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    .line 13
    new-instance v0, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    const-string v1, "Invalid"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;->Invalid:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    .line 7
    const/4 v0, 0x6

    new-array v0, v0, [Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    sget-object v1, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;->SIFU_SUMMARY:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    aput-object v1, v0, v3

    sget-object v1, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;->SIFU_SOCIAL:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    aput-object v1, v0, v4

    sget-object v1, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;->MIFU_3_FLUID_LARGE_LEFT:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    aput-object v1, v0, v5

    sget-object v1, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;->MIFU_4_GRID:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    aput-object v1, v0, v6

    sget-object v1, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;->SIFU_LEFT_IMAGE_RIGHT_TEXT:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;->Invalid:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    aput-object v2, v0, v1

    sput-object v0, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;->$VALUES:[Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

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
    .line 7
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 7
    const-class v0, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    return-object v0
.end method

.method public static values()[Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;
    .locals 1

    .prologue
    .line 7
    sget-object v0, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;->$VALUES:[Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    invoke-virtual {v0}, [Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    return-object v0
.end method
