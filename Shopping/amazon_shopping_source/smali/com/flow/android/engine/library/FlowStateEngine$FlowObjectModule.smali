.class public final enum Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;
.super Ljava/lang/Enum;
.source "FlowStateEngine.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/flow/android/engine/library/FlowStateEngine;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "FlowObjectModule"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;

.field public static final enum BARCODE:Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;

.field public static final enum DEEPLEARNING:Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;

.field public static final enum IMAGEMATCH:Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;

.field public static final enum LOGO:Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;

.field public static final enum QRCODE:Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;

.field public static final enum TEXT:Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 102
    new-instance v0, Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;

    const-string/jumbo v1, "IMAGEMATCH"

    invoke-direct {v0, v1, v3}, Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;->IMAGEMATCH:Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;

    new-instance v0, Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;

    const-string/jumbo v1, "BARCODE"

    invoke-direct {v0, v1, v4}, Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;->BARCODE:Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;

    new-instance v0, Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;

    const-string/jumbo v1, "QRCODE"

    invoke-direct {v0, v1, v5}, Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;->QRCODE:Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;

    new-instance v0, Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;

    const-string/jumbo v1, "TEXT"

    invoke-direct {v0, v1, v6}, Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;->TEXT:Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;

    new-instance v0, Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;

    const-string/jumbo v1, "LOGO"

    invoke-direct {v0, v1, v7}, Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;->LOGO:Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;

    new-instance v0, Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;

    const-string/jumbo v1, "DEEPLEARNING"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;->DEEPLEARNING:Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;

    .line 101
    const/4 v0, 0x6

    new-array v0, v0, [Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;

    sget-object v1, Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;->IMAGEMATCH:Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;

    aput-object v1, v0, v3

    sget-object v1, Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;->BARCODE:Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;

    aput-object v1, v0, v4

    sget-object v1, Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;->QRCODE:Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;

    aput-object v1, v0, v5

    sget-object v1, Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;->TEXT:Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;

    aput-object v1, v0, v6

    sget-object v1, Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;->LOGO:Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;->DEEPLEARNING:Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;

    aput-object v2, v0, v1

    sput-object v0, Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;->$VALUES:[Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;

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
    .line 101
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 101
    const-class v0, Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;

    return-object v0
.end method

.method public static values()[Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;
    .locals 1

    .prologue
    .line 101
    sget-object v0, Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;->$VALUES:[Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;

    invoke-virtual {v0}, [Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;

    return-object v0
.end method
