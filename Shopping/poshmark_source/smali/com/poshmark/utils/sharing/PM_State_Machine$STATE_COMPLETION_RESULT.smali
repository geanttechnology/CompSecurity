.class public final enum Lcom/poshmark/utils/sharing/PM_State_Machine$STATE_COMPLETION_RESULT;
.super Ljava/lang/Enum;
.source "PM_State_Machine.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/utils/sharing/PM_State_Machine;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "STATE_COMPLETION_RESULT"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/poshmark/utils/sharing/PM_State_Machine$STATE_COMPLETION_RESULT;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/poshmark/utils/sharing/PM_State_Machine$STATE_COMPLETION_RESULT;

.field public static final enum CANCEL:Lcom/poshmark/utils/sharing/PM_State_Machine$STATE_COMPLETION_RESULT;

.field public static final enum FAILED:Lcom/poshmark/utils/sharing/PM_State_Machine$STATE_COMPLETION_RESULT;

.field public static final enum OK:Lcom/poshmark/utils/sharing/PM_State_Machine$STATE_COMPLETION_RESULT;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 13
    new-instance v0, Lcom/poshmark/utils/sharing/PM_State_Machine$STATE_COMPLETION_RESULT;

    const-string v1, "OK"

    invoke-direct {v0, v1, v2}, Lcom/poshmark/utils/sharing/PM_State_Machine$STATE_COMPLETION_RESULT;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/sharing/PM_State_Machine$STATE_COMPLETION_RESULT;->OK:Lcom/poshmark/utils/sharing/PM_State_Machine$STATE_COMPLETION_RESULT;

    new-instance v0, Lcom/poshmark/utils/sharing/PM_State_Machine$STATE_COMPLETION_RESULT;

    const-string v1, "FAILED"

    invoke-direct {v0, v1, v3}, Lcom/poshmark/utils/sharing/PM_State_Machine$STATE_COMPLETION_RESULT;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/sharing/PM_State_Machine$STATE_COMPLETION_RESULT;->FAILED:Lcom/poshmark/utils/sharing/PM_State_Machine$STATE_COMPLETION_RESULT;

    new-instance v0, Lcom/poshmark/utils/sharing/PM_State_Machine$STATE_COMPLETION_RESULT;

    const-string v1, "CANCEL"

    invoke-direct {v0, v1, v4}, Lcom/poshmark/utils/sharing/PM_State_Machine$STATE_COMPLETION_RESULT;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/sharing/PM_State_Machine$STATE_COMPLETION_RESULT;->CANCEL:Lcom/poshmark/utils/sharing/PM_State_Machine$STATE_COMPLETION_RESULT;

    const/4 v0, 0x3

    new-array v0, v0, [Lcom/poshmark/utils/sharing/PM_State_Machine$STATE_COMPLETION_RESULT;

    sget-object v1, Lcom/poshmark/utils/sharing/PM_State_Machine$STATE_COMPLETION_RESULT;->OK:Lcom/poshmark/utils/sharing/PM_State_Machine$STATE_COMPLETION_RESULT;

    aput-object v1, v0, v2

    sget-object v1, Lcom/poshmark/utils/sharing/PM_State_Machine$STATE_COMPLETION_RESULT;->FAILED:Lcom/poshmark/utils/sharing/PM_State_Machine$STATE_COMPLETION_RESULT;

    aput-object v1, v0, v3

    sget-object v1, Lcom/poshmark/utils/sharing/PM_State_Machine$STATE_COMPLETION_RESULT;->CANCEL:Lcom/poshmark/utils/sharing/PM_State_Machine$STATE_COMPLETION_RESULT;

    aput-object v1, v0, v4

    sput-object v0, Lcom/poshmark/utils/sharing/PM_State_Machine$STATE_COMPLETION_RESULT;->$VALUES:[Lcom/poshmark/utils/sharing/PM_State_Machine$STATE_COMPLETION_RESULT;

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
    .line 13
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/poshmark/utils/sharing/PM_State_Machine$STATE_COMPLETION_RESULT;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 13
    const-class v0, Lcom/poshmark/utils/sharing/PM_State_Machine$STATE_COMPLETION_RESULT;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/poshmark/utils/sharing/PM_State_Machine$STATE_COMPLETION_RESULT;

    return-object v0
.end method

.method public static values()[Lcom/poshmark/utils/sharing/PM_State_Machine$STATE_COMPLETION_RESULT;
    .locals 1

    .prologue
    .line 13
    sget-object v0, Lcom/poshmark/utils/sharing/PM_State_Machine$STATE_COMPLETION_RESULT;->$VALUES:[Lcom/poshmark/utils/sharing/PM_State_Machine$STATE_COMPLETION_RESULT;

    invoke-virtual {v0}, [Lcom/poshmark/utils/sharing/PM_State_Machine$STATE_COMPLETION_RESULT;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/poshmark/utils/sharing/PM_State_Machine$STATE_COMPLETION_RESULT;

    return-object v0
.end method
