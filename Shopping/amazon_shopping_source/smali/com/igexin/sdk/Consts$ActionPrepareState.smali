.class public final enum Lcom/igexin/sdk/Consts$ActionPrepareState;
.super Ljava/lang/Enum;
.source "Consts.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/igexin/sdk/Consts;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "ActionPrepareState"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/igexin/sdk/Consts$ActionPrepareState;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/igexin/sdk/Consts$ActionPrepareState;

.field public static final enum stop:Lcom/igexin/sdk/Consts$ActionPrepareState;

.field public static final enum success:Lcom/igexin/sdk/Consts$ActionPrepareState;

.field public static final enum wait:Lcom/igexin/sdk/Consts$ActionPrepareState;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 79
    new-instance v0, Lcom/igexin/sdk/Consts$ActionPrepareState;

    const-string/jumbo v1, "success"

    invoke-direct {v0, v1, v2}, Lcom/igexin/sdk/Consts$ActionPrepareState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/igexin/sdk/Consts$ActionPrepareState;->success:Lcom/igexin/sdk/Consts$ActionPrepareState;

    new-instance v0, Lcom/igexin/sdk/Consts$ActionPrepareState;

    const-string/jumbo v1, "wait"

    invoke-direct {v0, v1, v3}, Lcom/igexin/sdk/Consts$ActionPrepareState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/igexin/sdk/Consts$ActionPrepareState;->wait:Lcom/igexin/sdk/Consts$ActionPrepareState;

    new-instance v0, Lcom/igexin/sdk/Consts$ActionPrepareState;

    const-string/jumbo v1, "stop"

    invoke-direct {v0, v1, v4}, Lcom/igexin/sdk/Consts$ActionPrepareState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/igexin/sdk/Consts$ActionPrepareState;->stop:Lcom/igexin/sdk/Consts$ActionPrepareState;

    .line 78
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/igexin/sdk/Consts$ActionPrepareState;

    sget-object v1, Lcom/igexin/sdk/Consts$ActionPrepareState;->success:Lcom/igexin/sdk/Consts$ActionPrepareState;

    aput-object v1, v0, v2

    sget-object v1, Lcom/igexin/sdk/Consts$ActionPrepareState;->wait:Lcom/igexin/sdk/Consts$ActionPrepareState;

    aput-object v1, v0, v3

    sget-object v1, Lcom/igexin/sdk/Consts$ActionPrepareState;->stop:Lcom/igexin/sdk/Consts$ActionPrepareState;

    aput-object v1, v0, v4

    sput-object v0, Lcom/igexin/sdk/Consts$ActionPrepareState;->$VALUES:[Lcom/igexin/sdk/Consts$ActionPrepareState;

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
    .line 78
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/igexin/sdk/Consts$ActionPrepareState;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 78
    const-class v0, Lcom/igexin/sdk/Consts$ActionPrepareState;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/igexin/sdk/Consts$ActionPrepareState;

    return-object v0
.end method

.method public static values()[Lcom/igexin/sdk/Consts$ActionPrepareState;
    .locals 1

    .prologue
    .line 78
    sget-object v0, Lcom/igexin/sdk/Consts$ActionPrepareState;->$VALUES:[Lcom/igexin/sdk/Consts$ActionPrepareState;

    invoke-virtual {v0}, [Lcom/igexin/sdk/Consts$ActionPrepareState;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/igexin/sdk/Consts$ActionPrepareState;

    return-object v0
.end method
