.class public final enum Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate$UtteranceID;
.super Ljava/lang/Enum;
.source "DefaultTalkDelegate.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "UtteranceID"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate$UtteranceID;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate$UtteranceID;

.field public static final enum DO_NOTHING:Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate$UtteranceID;

.field public static final enum FOLLOWUP_WITH_LISTEN:Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate$UtteranceID;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 27
    new-instance v0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate$UtteranceID;

    const-string v1, "FOLLOWUP_WITH_LISTEN"

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate$UtteranceID;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate$UtteranceID;->FOLLOWUP_WITH_LISTEN:Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate$UtteranceID;

    .line 28
    new-instance v0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate$UtteranceID;

    const-string v1, "DO_NOTHING"

    invoke-direct {v0, v1, v3}, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate$UtteranceID;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate$UtteranceID;->DO_NOTHING:Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate$UtteranceID;

    .line 26
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate$UtteranceID;

    sget-object v1, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate$UtteranceID;->FOLLOWUP_WITH_LISTEN:Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate$UtteranceID;

    aput-object v1, v0, v2

    sget-object v1, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate$UtteranceID;->DO_NOTHING:Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate$UtteranceID;

    aput-object v1, v0, v3

    sput-object v0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate$UtteranceID;->$VALUES:[Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate$UtteranceID;

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
    .line 26
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate$UtteranceID;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 26
    const-class v0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate$UtteranceID;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate$UtteranceID;

    return-object v0
.end method

.method public static values()[Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate$UtteranceID;
    .locals 1

    .prologue
    .line 26
    sget-object v0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate$UtteranceID;->$VALUES:[Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate$UtteranceID;

    invoke-virtual {v0}, [Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate$UtteranceID;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate$UtteranceID;

    return-object v0
.end method
