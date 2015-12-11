.class public final enum Lcom/poshmark/triggers/PMTrigger$TriggerState;
.super Ljava/lang/Enum;
.source "PMTrigger.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/triggers/PMTrigger;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "TriggerState"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/poshmark/triggers/PMTrigger$TriggerState;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/poshmark/triggers/PMTrigger$TriggerState;

.field public static final enum DISMISSED:Lcom/poshmark/triggers/PMTrigger$TriggerState;

.field public static final enum IGNORED:Lcom/poshmark/triggers/PMTrigger$TriggerState;

.field public static final enum INITIAL:Lcom/poshmark/triggers/PMTrigger$TriggerState;

.field public static final enum INTERACTED:Lcom/poshmark/triggers/PMTrigger$TriggerState;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 15
    new-instance v0, Lcom/poshmark/triggers/PMTrigger$TriggerState;

    const-string v1, "INITIAL"

    invoke-direct {v0, v1, v2}, Lcom/poshmark/triggers/PMTrigger$TriggerState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/triggers/PMTrigger$TriggerState;->INITIAL:Lcom/poshmark/triggers/PMTrigger$TriggerState;

    new-instance v0, Lcom/poshmark/triggers/PMTrigger$TriggerState;

    const-string v1, "IGNORED"

    invoke-direct {v0, v1, v3}, Lcom/poshmark/triggers/PMTrigger$TriggerState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/triggers/PMTrigger$TriggerState;->IGNORED:Lcom/poshmark/triggers/PMTrigger$TriggerState;

    new-instance v0, Lcom/poshmark/triggers/PMTrigger$TriggerState;

    const-string v1, "DISMISSED"

    invoke-direct {v0, v1, v4}, Lcom/poshmark/triggers/PMTrigger$TriggerState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/triggers/PMTrigger$TriggerState;->DISMISSED:Lcom/poshmark/triggers/PMTrigger$TriggerState;

    new-instance v0, Lcom/poshmark/triggers/PMTrigger$TriggerState;

    const-string v1, "INTERACTED"

    invoke-direct {v0, v1, v5}, Lcom/poshmark/triggers/PMTrigger$TriggerState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/triggers/PMTrigger$TriggerState;->INTERACTED:Lcom/poshmark/triggers/PMTrigger$TriggerState;

    const/4 v0, 0x4

    new-array v0, v0, [Lcom/poshmark/triggers/PMTrigger$TriggerState;

    sget-object v1, Lcom/poshmark/triggers/PMTrigger$TriggerState;->INITIAL:Lcom/poshmark/triggers/PMTrigger$TriggerState;

    aput-object v1, v0, v2

    sget-object v1, Lcom/poshmark/triggers/PMTrigger$TriggerState;->IGNORED:Lcom/poshmark/triggers/PMTrigger$TriggerState;

    aput-object v1, v0, v3

    sget-object v1, Lcom/poshmark/triggers/PMTrigger$TriggerState;->DISMISSED:Lcom/poshmark/triggers/PMTrigger$TriggerState;

    aput-object v1, v0, v4

    sget-object v1, Lcom/poshmark/triggers/PMTrigger$TriggerState;->INTERACTED:Lcom/poshmark/triggers/PMTrigger$TriggerState;

    aput-object v1, v0, v5

    sput-object v0, Lcom/poshmark/triggers/PMTrigger$TriggerState;->$VALUES:[Lcom/poshmark/triggers/PMTrigger$TriggerState;

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
    .line 15
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/poshmark/triggers/PMTrigger$TriggerState;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 15
    const-class v0, Lcom/poshmark/triggers/PMTrigger$TriggerState;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/poshmark/triggers/PMTrigger$TriggerState;

    return-object v0
.end method

.method public static values()[Lcom/poshmark/triggers/PMTrigger$TriggerState;
    .locals 1

    .prologue
    .line 15
    sget-object v0, Lcom/poshmark/triggers/PMTrigger$TriggerState;->$VALUES:[Lcom/poshmark/triggers/PMTrigger$TriggerState;

    invoke-virtual {v0}, [Lcom/poshmark/triggers/PMTrigger$TriggerState;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/poshmark/triggers/PMTrigger$TriggerState;

    return-object v0
.end method
