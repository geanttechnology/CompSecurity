.class final enum Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;
.super Ljava/lang/Enum;
.source "CameraFiltersFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/CameraFiltersFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4018
    name = "FilterType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

.field public static final enum FILTER_TYPE_CHIC:Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

.field public static final enum FILTER_TYPE_CLASSIC:Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

.field public static final enum FILTER_TYPE_GLAM:Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

.field public static final enum FILTER_TYPE_MODERN:Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

.field public static final enum FILTER_TYPE_RETRO:Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

.field public static final enum FILTER_TYPE_STREET:Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

.field public static final enum FILTER_TYPE_TIMELESS:Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

.field public static final enum FILTER_TYPE_VINTAGE:Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 38
    new-instance v0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

    const-string v1, "FILTER_TYPE_TIMELESS"

    invoke-direct {v0, v1, v3}, Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;->FILTER_TYPE_TIMELESS:Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

    .line 39
    new-instance v0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

    const-string v1, "FILTER_TYPE_GLAM"

    invoke-direct {v0, v1, v4}, Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;->FILTER_TYPE_GLAM:Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

    .line 40
    new-instance v0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

    const-string v1, "FILTER_TYPE_MODERN"

    invoke-direct {v0, v1, v5}, Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;->FILTER_TYPE_MODERN:Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

    .line 41
    new-instance v0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

    const-string v1, "FILTER_TYPE_VINTAGE"

    invoke-direct {v0, v1, v6}, Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;->FILTER_TYPE_VINTAGE:Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

    .line 42
    new-instance v0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

    const-string v1, "FILTER_TYPE_RETRO"

    invoke-direct {v0, v1, v7}, Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;->FILTER_TYPE_RETRO:Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

    .line 43
    new-instance v0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

    const-string v1, "FILTER_TYPE_CHIC"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;->FILTER_TYPE_CHIC:Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

    .line 44
    new-instance v0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

    const-string v1, "FILTER_TYPE_STREET"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;->FILTER_TYPE_STREET:Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

    .line 45
    new-instance v0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

    const-string v1, "FILTER_TYPE_CLASSIC"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;->FILTER_TYPE_CLASSIC:Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

    .line 37
    const/16 v0, 0x8

    new-array v0, v0, [Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

    sget-object v1, Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;->FILTER_TYPE_TIMELESS:Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;->FILTER_TYPE_GLAM:Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;->FILTER_TYPE_MODERN:Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

    aput-object v1, v0, v5

    sget-object v1, Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;->FILTER_TYPE_VINTAGE:Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

    aput-object v1, v0, v6

    sget-object v1, Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;->FILTER_TYPE_RETRO:Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;->FILTER_TYPE_CHIC:Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;->FILTER_TYPE_STREET:Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;->FILTER_TYPE_CLASSIC:Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

    aput-object v2, v0, v1

    sput-object v0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;->$VALUES:[Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

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
    .line 37
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 37
    const-class v0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

    return-object v0
.end method

.method public static values()[Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;
    .locals 1

    .prologue
    .line 37
    sget-object v0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;->$VALUES:[Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

    invoke-virtual {v0}, [Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

    return-object v0
.end method
