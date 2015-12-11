.class public final enum Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;
.super Ljava/lang/Enum;
.source "SideRibbonDelegate.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "State"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;

.field public static final enum CLOSED:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;

.field public static final enum IN_PROGRESS:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;

.field public static final enum OPEN:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 438
    new-instance v0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;

    const-string v1, "CLOSED"

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;->CLOSED:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;

    new-instance v0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;

    const-string v1, "OPEN"

    invoke-direct {v0, v1, v3}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;->OPEN:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;

    new-instance v0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;

    const-string v1, "IN_PROGRESS"

    invoke-direct {v0, v1, v4}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;->IN_PROGRESS:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;

    const/4 v0, 0x3

    new-array v0, v0, [Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;

    sget-object v1, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;->CLOSED:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;

    aput-object v1, v0, v2

    sget-object v1, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;->OPEN:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;

    aput-object v1, v0, v3

    sget-object v1, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;->IN_PROGRESS:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;

    aput-object v1, v0, v4

    sput-object v0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;->$VALUES:[Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;

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
    .line 438
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 438
    const-class v0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;

    return-object v0
.end method

.method public static values()[Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;
    .locals 1

    .prologue
    .line 438
    sget-object v0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;->$VALUES:[Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;

    invoke-virtual {v0}, [Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;

    return-object v0
.end method
