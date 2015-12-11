.class public final enum Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;
.super Ljava/lang/Enum;
.source "FeedItemHeaderLayout.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Layout"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

.field public static final enum DOUBLE_LEVEL_HEADER:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

.field public static final enum LEGACY_HEADER:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

.field public static final enum SINGLE_LEVEL_HEADER:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

.field public static final enum SINGLE_LEVEL_HEADER_POSHPOST:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

.field public static final enum invalid:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 8
    new-instance v0, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

    const-string v1, "SINGLE_LEVEL_HEADER"

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;->SINGLE_LEVEL_HEADER:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

    .line 9
    new-instance v0, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

    const-string v1, "DOUBLE_LEVEL_HEADER"

    invoke-direct {v0, v1, v3}, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;->DOUBLE_LEVEL_HEADER:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

    .line 10
    new-instance v0, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

    const-string v1, "LEGACY_HEADER"

    invoke-direct {v0, v1, v4}, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;->LEGACY_HEADER:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

    .line 11
    new-instance v0, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

    const-string v1, "SINGLE_LEVEL_HEADER_POSHPOST"

    invoke-direct {v0, v1, v5}, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;->SINGLE_LEVEL_HEADER_POSHPOST:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

    .line 12
    new-instance v0, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

    const-string v1, "invalid"

    invoke-direct {v0, v1, v6}, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;->invalid:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

    .line 7
    const/4 v0, 0x5

    new-array v0, v0, [Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

    sget-object v1, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;->SINGLE_LEVEL_HEADER:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

    aput-object v1, v0, v2

    sget-object v1, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;->DOUBLE_LEVEL_HEADER:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

    aput-object v1, v0, v3

    sget-object v1, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;->LEGACY_HEADER:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

    aput-object v1, v0, v4

    sget-object v1, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;->SINGLE_LEVEL_HEADER_POSHPOST:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

    aput-object v1, v0, v5

    sget-object v1, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;->invalid:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

    aput-object v1, v0, v6

    sput-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;->$VALUES:[Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

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

.method public static valueOf(Ljava/lang/String;)Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 7
    const-class v0, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

    return-object v0
.end method

.method public static values()[Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;
    .locals 1

    .prologue
    .line 7
    sget-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;->$VALUES:[Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

    invoke-virtual {v0}, [Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

    return-object v0
.end method
