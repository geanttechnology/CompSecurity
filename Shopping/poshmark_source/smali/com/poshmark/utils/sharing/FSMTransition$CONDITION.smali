.class public final enum Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;
.super Ljava/lang/Enum;
.source "FSMTransition.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/utils/sharing/FSMTransition;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "CONDITION"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;

.field public static final enum FAIL:Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;

.field public static final enum OK:Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 14
    new-instance v0, Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;

    const-string v1, "OK"

    invoke-direct {v0, v1, v2}, Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;->OK:Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;

    new-instance v0, Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;

    const-string v1, "FAIL"

    invoke-direct {v0, v1, v3}, Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;->FAIL:Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;

    const/4 v0, 0x2

    new-array v0, v0, [Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;

    sget-object v1, Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;->OK:Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;

    aput-object v1, v0, v2

    sget-object v1, Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;->FAIL:Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;

    aput-object v1, v0, v3

    sput-object v0, Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;->$VALUES:[Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;

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
    .line 14
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 14
    const-class v0, Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;

    return-object v0
.end method

.method public static values()[Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;
    .locals 1

    .prologue
    .line 14
    sget-object v0, Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;->$VALUES:[Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;

    invoke-virtual {v0}, [Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;

    return-object v0
.end method
