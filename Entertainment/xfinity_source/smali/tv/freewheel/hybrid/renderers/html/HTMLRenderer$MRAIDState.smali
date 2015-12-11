.class final enum Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;
.super Ljava/lang/Enum;
.source "HTMLRenderer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401a
    name = "MRAIDState"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;

.field public static final enum DEFAULT:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;

.field public static final enum EXPANDED:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;

.field public static final enum HIDDEN:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;

.field public static final enum LOADING:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;

.field public static final enum RESIZED:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 45
    new-instance v0, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;

    const-string v1, "LOADING"

    invoke-direct {v0, v1, v2}, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;->LOADING:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;

    new-instance v0, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;

    const-string v1, "DEFAULT"

    invoke-direct {v0, v1, v3}, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;->DEFAULT:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;

    new-instance v0, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;

    const-string v1, "EXPANDED"

    invoke-direct {v0, v1, v4}, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;->EXPANDED:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;

    new-instance v0, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;

    const-string v1, "RESIZED"

    invoke-direct {v0, v1, v5}, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;->RESIZED:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;

    new-instance v0, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;

    const-string v1, "HIDDEN"

    invoke-direct {v0, v1, v6}, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;->HIDDEN:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;

    .line 44
    const/4 v0, 0x5

    new-array v0, v0, [Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;

    sget-object v1, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;->LOADING:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;

    aput-object v1, v0, v2

    sget-object v1, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;->DEFAULT:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;

    aput-object v1, v0, v3

    sget-object v1, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;->EXPANDED:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;

    aput-object v1, v0, v4

    sget-object v1, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;->RESIZED:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;

    aput-object v1, v0, v5

    sget-object v1, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;->HIDDEN:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;

    aput-object v1, v0, v6

    sput-object v0, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;->$VALUES:[Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;

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
    .line 44
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 44
    const-class v0, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;

    return-object v0
.end method

.method public static values()[Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;
    .locals 1

    .prologue
    .line 44
    sget-object v0, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;->$VALUES:[Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;

    invoke-virtual {v0}, [Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;

    return-object v0
.end method
