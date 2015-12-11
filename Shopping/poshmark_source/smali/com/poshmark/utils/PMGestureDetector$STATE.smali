.class final enum Lcom/poshmark/utils/PMGestureDetector$STATE;
.super Ljava/lang/Enum;
.source "PMGestureDetector.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/utils/PMGestureDetector;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4018
    name = "STATE"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/poshmark/utils/PMGestureDetector$STATE;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/poshmark/utils/PMGestureDetector$STATE;

.field public static final enum MULTI_FINGER_DRAG:Lcom/poshmark/utils/PMGestureDetector$STATE;

.field public static final enum MULTI_TAP_START:Lcom/poshmark/utils/PMGestureDetector$STATE;

.field public static final enum NONE:Lcom/poshmark/utils/PMGestureDetector$STATE;

.field public static final enum SINGLE_FINGER_DRAG:Lcom/poshmark/utils/PMGestureDetector$STATE;

.field public static final enum SINGLE_TAP_START:Lcom/poshmark/utils/PMGestureDetector$STATE;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 18
    new-instance v0, Lcom/poshmark/utils/PMGestureDetector$STATE;

    const-string v1, "NONE"

    invoke-direct {v0, v1, v2}, Lcom/poshmark/utils/PMGestureDetector$STATE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/PMGestureDetector$STATE;->NONE:Lcom/poshmark/utils/PMGestureDetector$STATE;

    new-instance v0, Lcom/poshmark/utils/PMGestureDetector$STATE;

    const-string v1, "SINGLE_TAP_START"

    invoke-direct {v0, v1, v3}, Lcom/poshmark/utils/PMGestureDetector$STATE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/PMGestureDetector$STATE;->SINGLE_TAP_START:Lcom/poshmark/utils/PMGestureDetector$STATE;

    new-instance v0, Lcom/poshmark/utils/PMGestureDetector$STATE;

    const-string v1, "MULTI_TAP_START"

    invoke-direct {v0, v1, v4}, Lcom/poshmark/utils/PMGestureDetector$STATE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/PMGestureDetector$STATE;->MULTI_TAP_START:Lcom/poshmark/utils/PMGestureDetector$STATE;

    new-instance v0, Lcom/poshmark/utils/PMGestureDetector$STATE;

    const-string v1, "SINGLE_FINGER_DRAG"

    invoke-direct {v0, v1, v5}, Lcom/poshmark/utils/PMGestureDetector$STATE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/PMGestureDetector$STATE;->SINGLE_FINGER_DRAG:Lcom/poshmark/utils/PMGestureDetector$STATE;

    new-instance v0, Lcom/poshmark/utils/PMGestureDetector$STATE;

    const-string v1, "MULTI_FINGER_DRAG"

    invoke-direct {v0, v1, v6}, Lcom/poshmark/utils/PMGestureDetector$STATE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/PMGestureDetector$STATE;->MULTI_FINGER_DRAG:Lcom/poshmark/utils/PMGestureDetector$STATE;

    const/4 v0, 0x5

    new-array v0, v0, [Lcom/poshmark/utils/PMGestureDetector$STATE;

    sget-object v1, Lcom/poshmark/utils/PMGestureDetector$STATE;->NONE:Lcom/poshmark/utils/PMGestureDetector$STATE;

    aput-object v1, v0, v2

    sget-object v1, Lcom/poshmark/utils/PMGestureDetector$STATE;->SINGLE_TAP_START:Lcom/poshmark/utils/PMGestureDetector$STATE;

    aput-object v1, v0, v3

    sget-object v1, Lcom/poshmark/utils/PMGestureDetector$STATE;->MULTI_TAP_START:Lcom/poshmark/utils/PMGestureDetector$STATE;

    aput-object v1, v0, v4

    sget-object v1, Lcom/poshmark/utils/PMGestureDetector$STATE;->SINGLE_FINGER_DRAG:Lcom/poshmark/utils/PMGestureDetector$STATE;

    aput-object v1, v0, v5

    sget-object v1, Lcom/poshmark/utils/PMGestureDetector$STATE;->MULTI_FINGER_DRAG:Lcom/poshmark/utils/PMGestureDetector$STATE;

    aput-object v1, v0, v6

    sput-object v0, Lcom/poshmark/utils/PMGestureDetector$STATE;->$VALUES:[Lcom/poshmark/utils/PMGestureDetector$STATE;

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
    .line 18
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/poshmark/utils/PMGestureDetector$STATE;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 18
    const-class v0, Lcom/poshmark/utils/PMGestureDetector$STATE;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/poshmark/utils/PMGestureDetector$STATE;

    return-object v0
.end method

.method public static values()[Lcom/poshmark/utils/PMGestureDetector$STATE;
    .locals 1

    .prologue
    .line 18
    sget-object v0, Lcom/poshmark/utils/PMGestureDetector$STATE;->$VALUES:[Lcom/poshmark/utils/PMGestureDetector$STATE;

    invoke-virtual {v0}, [Lcom/poshmark/utils/PMGestureDetector$STATE;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/poshmark/utils/PMGestureDetector$STATE;

    return-object v0
.end method
